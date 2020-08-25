package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes8.dex */
public class i {
    private final com.facebook.common.references.c<byte[]> nkS;
    final a nxd;

    public i(com.facebook.common.memory.c cVar, r rVar) {
        com.facebook.common.internal.g.checkArgument(rVar.nxA > 0);
        this.nxd = new a(cVar, rVar, n.dUS());
        this.nkS = new com.facebook.common.references.c<byte[]>() { // from class: com.facebook.imagepipeline.memory.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            /* renamed from: an */
            public void release(byte[] bArr) {
                i.this.an(bArr);
            }
        };
    }

    public com.facebook.common.references.a<byte[]> LC(int i) {
        return com.facebook.common.references.a.a(this.nxd.get(i), this.nkS);
    }

    public void an(byte[] bArr) {
        this.nxd.release(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class a extends j {
        public a(com.facebook.common.memory.c cVar, r rVar, s sVar) {
            super(cVar, rVar, sVar);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        d<byte[]> LW(int i) {
            return new o(LT(i), this.nwL.nxA, 0);
        }
    }
}
