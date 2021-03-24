package com.xiaomi.push;

import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public final class fg extends fa {
    public fg() {
        a("PING", (String) null);
        a("0");
        a(0);
    }

    @Override // com.xiaomi.push.fa
    /* renamed from: a */
    public ByteBuffer mo284a(ByteBuffer byteBuffer) {
        return m287a().length == 0 ? byteBuffer : super.mo284a(byteBuffer);
    }

    @Override // com.xiaomi.push.fa
    public int c() {
        if (m287a().length == 0) {
            return 0;
        }
        return super.c();
    }
}
