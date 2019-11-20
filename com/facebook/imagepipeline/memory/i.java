package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class i {
    private final com.facebook.common.references.c<byte[]> kan;
    final a kjC;

    public i(com.facebook.common.memory.c cVar, r rVar) {
        com.facebook.common.internal.g.checkArgument(rVar.kjY > 0);
        this.kjC = new a(cVar, rVar, n.cIk());
        this.kan = new com.facebook.common.references.c<byte[]>() { // from class: com.facebook.imagepipeline.memory.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            /* renamed from: N */
            public void release(byte[] bArr) {
                i.this.N(bArr);
            }
        };
    }

    public com.facebook.common.references.a<byte[]> CE(int i) {
        return com.facebook.common.references.a.a(this.kjC.get(i), this.kan);
    }

    public void N(byte[] bArr) {
        this.kjC.release(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends j {
        public a(com.facebook.common.memory.c cVar, r rVar, s sVar) {
            super(cVar, rVar, sVar);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        d<byte[]> Cz(int i) {
            return new o(Cx(i), this.kjm.kjY, 0);
        }
    }
}
