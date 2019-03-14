package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class i {
    final a jJl;
    private final com.facebook.common.references.c<byte[]> jzZ;

    public i(com.facebook.common.memory.c cVar, r rVar) {
        com.facebook.common.internal.g.checkArgument(rVar.jJH > 0);
        this.jJl = new a(cVar, rVar, n.czm());
        this.jzZ = new com.facebook.common.references.c<byte[]>() { // from class: com.facebook.imagepipeline.memory.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            /* renamed from: aa */
            public void release(byte[] bArr) {
                i.this.aa(bArr);
            }
        };
    }

    public com.facebook.common.references.a<byte[]> CC(int i) {
        return com.facebook.common.references.a.a(this.jJl.get(i), this.jzZ);
    }

    public void aa(byte[] bArr) {
        this.jJl.release(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends j {
        public a(com.facebook.common.memory.c cVar, r rVar, s sVar) {
            super(cVar, rVar, sVar);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        d<byte[]> Cx(int i) {
            return new o(Cv(i), this.jIV.jJH, 0);
        }
    }
}
