function test_nn(str,Theta1,Theta2)

I=invertIntensity(imread(str));

m=size(I,1);n=size(I,2);
nI=zeros(20,20);
bh=floor(m/20);bw=floor(n/20);
for i=1:20
	x=1+(i-1)*bh;
	for j=1:20
		y=1+(j-1)*bw;
		nI(i,j)=round(mean(mean(I(x:min(x+bh,m),y:min(y+bw,n)),'a'),'a'));
	end
end
ex=[reshape(nI,1,400)];	
fprintf('\nDisplaying Example Image\n');
figure;
%displayData(ex);
colormap(gray);	imagesc(nI);
pred = predict(Theta1, Theta2, ex);
fprintf('\nNeural Network Prediction:digit %d\n',mod(pred, 10));
sleep(1.5);
%close;
end