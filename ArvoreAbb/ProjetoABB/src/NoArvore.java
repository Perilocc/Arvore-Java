public class NoArvore {
    Aluno aluno;
    NoArvore esquerda;
    NoArvore direita;

    public NoArvore(Aluno aluno) {
        this.aluno = aluno;
        this.esquerda = null;
        this.direita = null;
    }

    public static NoArvore insere(NoArvore no, Aluno novoAluno) {
        if (no == null) {
            return new NoArvore(novoAluno);
        } else if (novoAluno.rgm < no.aluno.rgm) {
            no.esquerda = insere(no.esquerda, novoAluno);
        } else if (novoAluno.rgm > no.aluno.rgm) {
            no.direita = insere(no.direita, novoAluno);
        }
        return no;
    }

    public static void imprimeInOrdem(NoArvore raiz) {
        if (raiz != null) {
            imprimeInOrdem(raiz.esquerda);
            System.out.println("Aluno: " + raiz.aluno.nome + ", RGM: " + raiz.aluno.rgm);
            imprimeInOrdem(raiz.direita);
        }
    }
    
    public static void imprimePreOrdem(NoArvore raiz) {
        if (raiz != null) {
        	System.out.println("Aluno: " + raiz.aluno.nome + ", RGM: " + raiz.aluno.rgm);
            imprimePreOrdem(raiz.esquerda);
            imprimePreOrdem(raiz.direita);
        }
    }
    
    public static void imprimePosOrdem(NoArvore raiz) {
        if (raiz != null) {
            imprimePosOrdem(raiz.esquerda);
            imprimePosOrdem(raiz.direita);
            System.out.println("Aluno: " + raiz.aluno.nome + ", RGM: " + raiz.aluno.rgm);
        }
    }

    public static NoArvore busca(NoArvore no, int rgmProcurado) {
        if (no == null)
            return null;

        if (no.aluno.rgm > rgmProcurado)
            return busca(no.esquerda, rgmProcurado);
        else if (no.aluno.rgm < rgmProcurado)
            return busca(no.direita, rgmProcurado);
        else
            return no;
    }

    public static NoArvore remove(NoArvore r, int rgm) {
        if (r == null)
            return null;
        else if (r.aluno.rgm > rgm)
            r.esquerda = remove(r.esquerda, rgm);
        else if (r.aluno.rgm < rgm)
            r.direita = remove(r.direita, rgm);
        else {
            if (r.esquerda == null && r.direita == null) {
                r = null;
            } else if (r.esquerda == null) {
                NoArvore temp = r;
                r = r.direita;
            } else if (r.direita == null) {
                NoArvore temp = r;
                r = r.esquerda;
            } else {
                NoArvore subesquerda = r.esquerda;
                while (subesquerda.direita != null) {
                    subesquerda = subesquerda.direita;
                }
                r.aluno = subesquerda.aluno;
                subesquerda.aluno = null;
                r.esquerda = remove(r.esquerda, rgm);
            }
        }
        return r;
    }
}
