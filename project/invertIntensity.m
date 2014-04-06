function [I] = invertIntensity(I)

mx=max(max(I));
for i=1:size(I,1)
	for j=1:size(I,2)
		I(i,j)=mx-I(i,j);
	end
end

end