function [bX]= convertCorpusIntoBinary(X)

bX=zeros(size(X));
for i=1:size(X,1)
	for j=1:size(X,2)
		if X(i,j) >= 0.5
			bX(i,j)=1;
		end
	end
end

end