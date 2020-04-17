package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public class i {
    private final com.facebook.common.references.c<byte[]> lRK;
    final a mdV;

    public i(com.facebook.common.memory.c cVar, r rVar) {
        com.facebook.common.internal.g.checkArgument(rVar.mes > 0);
        this.mdV = new a(cVar, rVar, n.dtx());
        this.lRK = new com.facebook.common.references.c<byte[]>() { // from class: com.facebook.imagepipeline.memory.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            /* renamed from: ad */
            public void release(byte[] bArr) {
                i.this.ad(bArr);
            }
        };
    }

    public com.facebook.common.references.a<byte[]> GI(int i) {
        return com.facebook.common.references.a.a(this.mdV.get(i), this.lRK);
    }

    public void ad(byte[] bArr) {
        this.mdV.release(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class a extends j {
        public a(com.facebook.common.memory.c cVar, r rVar, s sVar) {
            super(cVar, rVar, sVar);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        d<byte[]> Hc(int i) {
            return new o(GZ(i), this.mdD.mes, 0);
        }
    }
}
