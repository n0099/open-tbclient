package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes9.dex */
public class i {
    private final com.facebook.common.references.c<byte[]> lEn;
    final a lPT;

    public i(com.facebook.common.memory.c cVar, r rVar) {
        com.facebook.common.internal.g.checkArgument(rVar.lQq > 0);
        this.lPT = new a(cVar, rVar, n.doC());
        this.lEn = new com.facebook.common.references.c<byte[]>() { // from class: com.facebook.imagepipeline.memory.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            public void release(byte[] bArr) {
                i.this.release(bArr);
            }
        };
    }

    public com.facebook.common.references.a<byte[]> HN(int i) {
        return com.facebook.common.references.a.a(this.lPT.get(i), this.lEn);
    }

    public void release(byte[] bArr) {
        this.lPT.release(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class a extends j {
        public a(com.facebook.common.memory.c cVar, r rVar, s sVar) {
            super(cVar, rVar, sVar);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        d<byte[]> Ig(int i) {
            return new o(Id(i), this.lPB.lQq, 0);
        }
    }
}
