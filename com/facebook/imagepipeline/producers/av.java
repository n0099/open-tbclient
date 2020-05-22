package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public class av implements aj<com.facebook.imagepipeline.g.e> {
    private final aw<com.facebook.imagepipeline.g.e>[] mAv;

    public av(aw<com.facebook.imagepipeline.g.e>... awVarArr) {
        this.mAv = (aw[]) com.facebook.common.internal.g.checkNotNull(awVarArr);
        com.facebook.common.internal.g.dj(0, this.mAv.length);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.dBi().dCc() == null) {
            kVar.h(null, 1);
        } else if (!a(0, kVar, akVar)) {
            kVar.h(null, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final int mAw;
        private final com.facebook.imagepipeline.common.d mtZ;
        private final ak myL;

        public a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, int i) {
            super(kVar);
            this.myL = akVar;
            this.mAw = i;
            this.mtZ = this.myL.dBi().dCc();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (eVar != null && (Ie(i) || ax.a(eVar, this.mtZ))) {
                dBu().h(eVar, i);
            } else if (Id(i)) {
                com.facebook.imagepipeline.g.e.e(eVar);
                if (!av.this.a(this.mAw + 1, dBu(), this.myL)) {
                    dBu().h(null, 1);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void F(Throwable th) {
            if (!av.this.a(this.mAw + 1, dBu(), this.myL)) {
                dBu().G(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        int a2 = a(i, akVar.dBi().dCc());
        if (a2 == -1) {
            return false;
        }
        this.mAv[a2].c(new a(kVar, akVar, a2), akVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.d dVar) {
        while (i < this.mAv.length) {
            if (!this.mAv[i].a(dVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
