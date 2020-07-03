package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public class i {
    private final com.facebook.common.references.c<byte[]> mIQ;
    final a mVh;

    public i(com.facebook.common.memory.c cVar, r rVar) {
        com.facebook.common.internal.g.checkArgument(rVar.mVE > 0);
        this.mVh = new a(cVar, rVar, n.dFC());
        this.mIQ = new com.facebook.common.references.c<byte[]>() { // from class: com.facebook.imagepipeline.memory.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            /* renamed from: am */
            public void release(byte[] bArr) {
                i.this.am(bArr);
            }
        };
    }

    public com.facebook.common.references.a<byte[]> ID(int i) {
        return com.facebook.common.references.a.a(this.mVh.get(i), this.mIQ);
    }

    public void am(byte[] bArr) {
        this.mVh.release(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class a extends j {
        public a(com.facebook.common.memory.c cVar, r rVar, s sVar) {
            super(cVar, rVar, sVar);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        d<byte[]> IX(int i) {
            return new o(IU(i), this.mUP.mVE, 0);
        }
    }
}
