package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public class i {
    private final com.facebook.common.references.c<byte[]> mlG;
    final a mxQ;

    public i(com.facebook.common.memory.c cVar, r rVar) {
        com.facebook.common.internal.g.checkArgument(rVar.myn > 0);
        this.mxQ = new a(cVar, rVar, n.dAM());
        this.mlG = new com.facebook.common.references.c<byte[]>() { // from class: com.facebook.imagepipeline.memory.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            /* renamed from: ak */
            public void release(byte[] bArr) {
                i.this.ak(bArr);
            }
        };
    }

    public com.facebook.common.references.a<byte[]> Hu(int i) {
        return com.facebook.common.references.a.a(this.mxQ.get(i), this.mlG);
    }

    public void ak(byte[] bArr) {
        this.mxQ.release(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class a extends j {
        public a(com.facebook.common.memory.c cVar, r rVar, s sVar) {
            super(cVar, rVar, sVar);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        d<byte[]> HO(int i) {
            return new o(HL(i), this.mxy.myn, 0);
        }
    }
}
