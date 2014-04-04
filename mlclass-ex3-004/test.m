function test(str,all_theta)

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
%nI=invert(nI,'y');

figure;
colormap(gray);imagesc(nI);
ex=[1 reshape(nI,1,400)];	
disp(sigmoid(ex * all_theta'));
[prob,p]=max(sigmoid(ex * all_theta'));
fprintf('image <example.jpg> is predicted to be digit %d with probability %f\n',mod(p,10),prob);
hold off;
sleep(3);
close;
end