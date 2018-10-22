package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class i {
    private final com.facebook.common.references.c<byte[]> hWX;
    final a igd;

    public i(com.facebook.common.memory.c cVar, r rVar) {
        com.facebook.common.internal.g.checkArgument(rVar.igA > 0);
        this.igd = new a(cVar, rVar, n.bWV());
        this.hWX = new com.facebook.common.references.c<byte[]>() { // from class: com.facebook.imagepipeline.memory.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            /* renamed from: V */
            public void release(byte[] bArr) {
                i.this.V(bArr);
            }
        };
    }

    public com.facebook.common.references.a<byte[]> xK(int i) {
        return com.facebook.common.references.a.a(this.igd.get(i), this.hWX);
    }

    public void V(byte[] bArr) {
        this.igd.release(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends j {
        public a(com.facebook.common.memory.c cVar, r rVar, s sVar) {
            super(cVar, rVar, sVar);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        d<byte[]> xF(int i) {
            return new o(xD(i), this.ifN.igA, 0);
        }
    }
}
