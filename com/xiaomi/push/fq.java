package com.xiaomi.push;

import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public final class fq extends fk {
    public fq() {
        a("PING", (String) null);
        a("0");
        a(0);
    }

    @Override // com.xiaomi.push.fk
    /* renamed from: a */
    public ByteBuffer mo484a(ByteBuffer byteBuffer) {
        return m487a().length == 0 ? byteBuffer : super.mo484a(byteBuffer);
    }

    @Override // com.xiaomi.push.fk
    public int c() {
        if (m487a().length == 0) {
            return 0;
        }
        return super.c();
    }
}
