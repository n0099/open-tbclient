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
    public ByteBuffer mo485a(ByteBuffer byteBuffer) {
        return m488a().length == 0 ? byteBuffer : super.mo485a(byteBuffer);
    }

    @Override // com.xiaomi.push.fk
    public int c() {
        if (m488a().length == 0) {
            return 0;
        }
        return super.c();
    }
}
