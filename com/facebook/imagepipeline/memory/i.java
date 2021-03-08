package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes5.dex */
public class i {
    private final com.facebook.common.references.c<byte[]> pBE;
    final a pNl;

    public i(com.facebook.common.memory.c cVar, r rVar) {
        com.facebook.common.internal.g.checkArgument(rVar.pNI > 0);
        this.pNl = new a(cVar, rVar, n.ezc());
        this.pBE = new com.facebook.common.references.c<byte[]>() { // from class: com.facebook.imagepipeline.memory.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            public void release(byte[] bArr) {
                i.this.release(bArr);
            }
        };
    }

    public com.facebook.common.references.a<byte[]> PF(int i) {
        return com.facebook.common.references.a.a(this.pNl.get(i), this.pBE);
    }

    public void release(byte[] bArr) {
        this.pNl.release(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a extends j {
        public a(com.facebook.common.memory.c cVar, r rVar, s sVar) {
            super(cVar, rVar, sVar);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        d<byte[]> PZ(int i) {
            return new o(PW(i), this.pMT.pNI, 0);
        }
    }
}
