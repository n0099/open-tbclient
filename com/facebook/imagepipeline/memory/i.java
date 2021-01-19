package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes3.dex */
public class i {
    final a pAy;
    private final com.facebook.common.references.c<byte[]> poO;

    public i(com.facebook.common.memory.c cVar, r rVar) {
        com.facebook.common.internal.g.checkArgument(rVar.pAV > 0);
        this.pAy = new a(cVar, rVar, n.ewt());
        this.poO = new com.facebook.common.references.c<byte[]>() { // from class: com.facebook.imagepipeline.memory.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            public void release(byte[] bArr) {
                i.this.release(bArr);
            }
        };
    }

    public com.facebook.common.references.a<byte[]> Pf(int i) {
        return com.facebook.common.references.a.a(this.pAy.get(i), this.poO);
    }

    public void release(byte[] bArr) {
        this.pAy.release(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a extends j {
        public a(com.facebook.common.memory.c cVar, r rVar, s sVar) {
            super(cVar, rVar, sVar);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        d<byte[]> Pz(int i) {
            return new o(Pw(i), this.pAg.pAV, 0);
        }
    }
}
