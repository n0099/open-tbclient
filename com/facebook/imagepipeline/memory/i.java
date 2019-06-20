package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class i {
    private final com.facebook.common.references.c<byte[]> jSo;
    final a kbx;

    public i(com.facebook.common.memory.c cVar, r rVar) {
        com.facebook.common.internal.g.checkArgument(rVar.kbT > 0);
        this.kbx = new a(cVar, rVar, n.cHc());
        this.jSo = new com.facebook.common.references.c<byte[]>() { // from class: com.facebook.imagepipeline.memory.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            /* renamed from: Y */
            public void release(byte[] bArr) {
                i.this.Y(bArr);
            }
        };
    }

    public com.facebook.common.references.a<byte[]> Dw(int i) {
        return com.facebook.common.references.a.a(this.kbx.get(i), this.jSo);
    }

    public void Y(byte[] bArr) {
        this.kbx.release(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends j {
        public a(com.facebook.common.memory.c cVar, r rVar, s sVar) {
            super(cVar, rVar, sVar);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        d<byte[]> Dr(int i) {
            return new o(Dp(i), this.kbh.kbT, 0);
        }
    }
}
