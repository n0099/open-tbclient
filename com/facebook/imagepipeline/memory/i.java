package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes18.dex */
public class i {
    private final com.facebook.common.references.c<byte[]> nKD;
    final a nWJ;

    public i(com.facebook.common.memory.c cVar, r rVar) {
        com.facebook.common.internal.g.checkArgument(rVar.nXg > 0);
        this.nWJ = new a(cVar, rVar, n.ecK());
        this.nKD = new com.facebook.common.references.c<byte[]>() { // from class: com.facebook.imagepipeline.memory.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            /* renamed from: an */
            public void release(byte[] bArr) {
                i.this.an(bArr);
            }
        };
    }

    public com.facebook.common.references.a<byte[]> MN(int i) {
        return com.facebook.common.references.a.a(this.nWJ.get(i), this.nKD);
    }

    public void an(byte[] bArr) {
        this.nWJ.release(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public static class a extends j {
        public a(com.facebook.common.memory.c cVar, r rVar, s sVar) {
            super(cVar, rVar, sVar);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        d<byte[]> Nh(int i) {
            return new o(Ne(i), this.nWr.nXg, 0);
        }
    }
}
