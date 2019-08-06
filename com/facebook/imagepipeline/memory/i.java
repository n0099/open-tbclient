package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class i {
    private final com.facebook.common.references.c<byte[]> kay;
    final a kjK;

    public i(com.facebook.common.memory.c cVar, r rVar) {
        com.facebook.common.internal.g.checkArgument(rVar.kkg > 0);
        this.kjK = new a(cVar, rVar, n.cKB());
        this.kay = new com.facebook.common.references.c<byte[]>() { // from class: com.facebook.imagepipeline.memory.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            /* renamed from: Z */
            public void release(byte[] bArr) {
                i.this.Z(bArr);
            }
        };
    }

    public com.facebook.common.references.a<byte[]> Ef(int i) {
        return com.facebook.common.references.a.a(this.kjK.get(i), this.kay);
    }

    public void Z(byte[] bArr) {
        this.kjK.release(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends j {
        public a(com.facebook.common.memory.c cVar, r rVar, s sVar) {
            super(cVar, rVar, sVar);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        d<byte[]> Ea(int i) {
            return new o(DY(i), this.kju.kkg, 0);
        }
    }
}
