function [I]= invert(I,x)

for i=1:size(I,1)/2
	for j=1:size(I,2)
		tmp=I(i,j);
		I(i,j)=I(size(I,1)-i+1,j);
		I(size(I,1)-i+1,j)=tmp;
	end
end

end