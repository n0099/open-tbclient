package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes25.dex */
public class i {
    final a nHs;
    private final com.facebook.common.references.c<byte[]> nvk;

    public i(com.facebook.common.memory.c cVar, r rVar) {
        com.facebook.common.internal.g.checkArgument(rVar.nHP > 0);
        this.nHs = new a(cVar, rVar, n.dYZ());
        this.nvk = new com.facebook.common.references.c<byte[]>() { // from class: com.facebook.imagepipeline.memory.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            /* renamed from: an */
            public void release(byte[] bArr) {
                i.this.an(bArr);
            }
        };
    }

    public com.facebook.common.references.a<byte[]> Mh(int i) {
        return com.facebook.common.references.a.a(this.nHs.get(i), this.nvk);
    }

    public void an(byte[] bArr) {
        this.nHs.release(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public static class a extends j {
        public a(com.facebook.common.memory.c cVar, r rVar, s sVar) {
            super(cVar, rVar, sVar);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        d<byte[]> MB(int i) {
            return new o(My(i), this.nHa.nHP, 0);
        }
    }
}
