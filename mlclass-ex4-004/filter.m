function [nI]=filter(I)

nI=zeros(size(I));
for i=1:size(I,1)
	for j=1:size(I,2)
		if I(i,j)==255 
			nI(i,j)=double(0.0);
		else 
			nI(i,j)=double(1.0); 
		end
	end
end

end