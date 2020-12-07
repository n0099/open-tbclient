package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes15.dex */
public class i {
    private final com.facebook.common.references.c<byte[]> pcb;
    final a pnM;

    public i(com.facebook.common.memory.c cVar, r rVar) {
        com.facebook.common.internal.g.checkArgument(rVar.pok > 0);
        this.pnM = new a(cVar, rVar, n.evZ());
        this.pcb = new com.facebook.common.references.c<byte[]>() { // from class: com.facebook.imagepipeline.memory.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            /* renamed from: ap */
            public void release(byte[] bArr) {
                i.this.ap(bArr);
            }
        };
    }

    public com.facebook.common.references.a<byte[]> Qy(int i) {
        return com.facebook.common.references.a.a(this.pnM.get(i), this.pcb);
    }

    public void ap(byte[] bArr) {
        this.pnM.release(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class a extends j {
        public a(com.facebook.common.memory.c cVar, r rVar, s sVar) {
            super(cVar, rVar, sVar);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        d<byte[]> QS(int i) {
            return new o(QP(i), this.pnu.pok, 0);
        }
    }
}
