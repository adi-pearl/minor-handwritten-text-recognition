function test(imageFile)

load('neuralParameters.mat');
I=imresize(imread(imageFile),[20 20]);
%imshow(I);
I=imcomplement(I);
%I=rgb2gray(I)
%I=filter(I);
if binary==false, 
	I=im2double(I);
else 
	I=filter(I);
end
figure;imshow(I);I

[prob,p]=predict(Theta1,Theta2,reshape(I,1,400));
fprintf("Neural Network Prediction: %d with probability: %.2f\n",mod(p,10),prob);
sleep(1);
close;

end