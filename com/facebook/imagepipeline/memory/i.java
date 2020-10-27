package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes18.dex */
public class i {
    private final com.facebook.common.references.c<byte[]> oBW;
    final a oOb;

    public i(com.facebook.common.memory.c cVar, r rVar) {
        com.facebook.common.internal.g.checkArgument(rVar.oOy > 0);
        this.oOb = new a(cVar, rVar, n.emI());
        this.oBW = new com.facebook.common.references.c<byte[]>() { // from class: com.facebook.imagepipeline.memory.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            /* renamed from: an */
            public void release(byte[] bArr) {
                i.this.an(bArr);
            }
        };
    }

    public com.facebook.common.references.a<byte[]> OE(int i) {
        return com.facebook.common.references.a.a(this.oOb.get(i), this.oBW);
    }

    public void an(byte[] bArr) {
        this.oOb.release(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public static class a extends j {
        public a(com.facebook.common.memory.c cVar, r rVar, s sVar) {
            super(cVar, rVar, sVar);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        d<byte[]> OY(int i) {
            return new o(OV(i), this.oNJ.oOy, 0);
        }
    }
}
