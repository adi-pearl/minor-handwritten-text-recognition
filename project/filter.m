function [nI]=filter(I)

nI=zeros(size(I));
for i=1:size(I,1)
	for j=1:size(I,2)
		if I(i,j)>=40
			nI(i,j)=1;
		else 
			nI(i,j)=0; 
		end
	end
end

end