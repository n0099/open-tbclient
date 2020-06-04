package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public class i {
    private final com.facebook.common.references.c<byte[]> mmQ;
    final a mza;

    public i(com.facebook.common.memory.c cVar, r rVar) {
        com.facebook.common.internal.g.checkArgument(rVar.mzx > 0);
        this.mza = new a(cVar, rVar, n.dBa());
        this.mmQ = new com.facebook.common.references.c<byte[]>() { // from class: com.facebook.imagepipeline.memory.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            /* renamed from: ak */
            public void release(byte[] bArr) {
                i.this.ak(bArr);
            }
        };
    }

    public com.facebook.common.references.a<byte[]> Hw(int i) {
        return com.facebook.common.references.a.a(this.mza.get(i), this.mmQ);
    }

    public void ak(byte[] bArr) {
        this.mza.release(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class a extends j {
        public a(com.facebook.common.memory.c cVar, r rVar, s sVar) {
            super(cVar, rVar, sVar);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        d<byte[]> HQ(int i) {
            return new o(HN(i), this.myI.mzx, 0);
        }
    }
}
