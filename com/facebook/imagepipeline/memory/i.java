package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public class i {
    private final com.facebook.common.references.c<byte[]> lIK;
    final a lUE;

    public i(com.facebook.common.memory.c cVar, r rVar) {
        com.facebook.common.internal.g.checkArgument(rVar.lVb > 0);
        this.lUE = new a(cVar, rVar, n.drc());
        this.lIK = new com.facebook.common.references.c<byte[]>() { // from class: com.facebook.imagepipeline.memory.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            public void release(byte[] bArr) {
                i.this.release(bArr);
            }
        };
    }

    public com.facebook.common.references.a<byte[]> Ib(int i) {
        return com.facebook.common.references.a.a(this.lUE.get(i), this.lIK);
    }

    public void release(byte[] bArr) {
        this.lUE.release(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class a extends j {
        public a(com.facebook.common.memory.c cVar, r rVar, s sVar) {
            super(cVar, rVar, sVar);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        d<byte[]> Iu(int i) {
            return new o(Ir(i), this.lUm.lVb, 0);
        }
    }
}
