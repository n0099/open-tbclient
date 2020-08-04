package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes4.dex */
public class i {
    private final com.facebook.common.references.c<byte[]> mQX;
    final a ndn;

    public i(com.facebook.common.memory.c cVar, r rVar) {
        com.facebook.common.internal.g.checkArgument(rVar.ndK > 0);
        this.ndn = new a(cVar, rVar, n.dIT());
        this.mQX = new com.facebook.common.references.c<byte[]>() { // from class: com.facebook.imagepipeline.memory.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            /* renamed from: am */
            public void release(byte[] bArr) {
                i.this.am(bArr);
            }
        };
    }

    public com.facebook.common.references.a<byte[]> IY(int i) {
        return com.facebook.common.references.a.a(this.ndn.get(i), this.mQX);
    }

    public void am(byte[] bArr) {
        this.ndn.release(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a extends j {
        public a(com.facebook.common.memory.c cVar, r rVar, s sVar) {
            super(cVar, rVar, sVar);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        d<byte[]> Js(int i) {
            return new o(Jp(i), this.ncV.ndK, 0);
        }
    }
}
