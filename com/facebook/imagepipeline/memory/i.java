package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class i {
    private final com.facebook.common.references.c<byte[]> ikl;
    final a itq;

    public i(com.facebook.common.memory.c cVar, r rVar) {
        com.facebook.common.internal.g.checkArgument(rVar.itN > 0);
        this.itq = new a(cVar, rVar, n.bZU());
        this.ikl = new com.facebook.common.references.c<byte[]>() { // from class: com.facebook.imagepipeline.memory.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            /* renamed from: U */
            public void release(byte[] bArr) {
                i.this.U(bArr);
            }
        };
    }

    public com.facebook.common.references.a<byte[]> yP(int i) {
        return com.facebook.common.references.a.a(this.itq.get(i), this.ikl);
    }

    public void U(byte[] bArr) {
        this.itq.release(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends j {
        public a(com.facebook.common.memory.c cVar, r rVar, s sVar) {
            super(cVar, rVar, sVar);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        d<byte[]> yK(int i) {
            return new o(yI(i), this.ita.itN, 0);
        }
    }
}
