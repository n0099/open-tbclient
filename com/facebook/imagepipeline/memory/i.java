package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes10.dex */
public class i {
    private final com.facebook.common.references.c<byte[]> lHL;
    final a lTF;

    public i(com.facebook.common.memory.c cVar, r rVar) {
        com.facebook.common.internal.g.checkArgument(rVar.lUc > 0);
        this.lTF = new a(cVar, rVar, n.dpL());
        this.lHL = new com.facebook.common.references.c<byte[]>() { // from class: com.facebook.imagepipeline.memory.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            public void release(byte[] bArr) {
                i.this.release(bArr);
            }
        };
    }

    public com.facebook.common.references.a<byte[]> HW(int i) {
        return com.facebook.common.references.a.a(this.lTF.get(i), this.lHL);
    }

    public void release(byte[] bArr) {
        this.lTF.release(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public static class a extends j {
        public a(com.facebook.common.memory.c cVar, r rVar, s sVar) {
            super(cVar, rVar, sVar);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        d<byte[]> Ip(int i) {
            return new o(Im(i), this.lTn.lUc, 0);
        }
    }
}
