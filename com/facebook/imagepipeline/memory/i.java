package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class i {
    final a jJa;
    private final com.facebook.common.references.c<byte[]> jzO;

    public i(com.facebook.common.memory.c cVar, r rVar) {
        com.facebook.common.internal.g.checkArgument(rVar.jJw > 0);
        this.jJa = new a(cVar, rVar, n.cyZ());
        this.jzO = new com.facebook.common.references.c<byte[]>() { // from class: com.facebook.imagepipeline.memory.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            /* renamed from: aa */
            public void release(byte[] bArr) {
                i.this.aa(bArr);
            }
        };
    }

    public com.facebook.common.references.a<byte[]> CB(int i) {
        return com.facebook.common.references.a.a(this.jJa.get(i), this.jzO);
    }

    public void aa(byte[] bArr) {
        this.jJa.release(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends j {
        public a(com.facebook.common.memory.c cVar, r rVar, s sVar) {
            super(cVar, rVar, sVar);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        d<byte[]> Cw(int i) {
            return new o(Cu(i), this.jIK.jJw, 0);
        }
    }
}
