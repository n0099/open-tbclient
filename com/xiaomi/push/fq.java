package com.xiaomi.push;

import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public final class fq extends fk {
    public fq() {
        a("PING", (String) null);
        a("0");
        a(0);
    }

    @Override // com.xiaomi.push.fk
    /* renamed from: a */
    public ByteBuffer mo402a(ByteBuffer byteBuffer) {
        return m405a().length == 0 ? byteBuffer : super.mo402a(byteBuffer);
    }

    @Override // com.xiaomi.push.fk
    public int c() {
        if (m405a().length == 0) {
            return 0;
        }
        return super.c();
    }
}
