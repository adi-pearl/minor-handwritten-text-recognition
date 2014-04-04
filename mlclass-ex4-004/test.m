function test(Theta1,Theta2,imageFile)

I=imresize(imread(imageFile),[20 20]);
I=filter(I)
[prob,p]=predict(Theta1,Theta2,reshape(I,1,400));
fprintf("Neural Network Prediction: %d with probability: %.2f\n",mod(p,10),prob);
end