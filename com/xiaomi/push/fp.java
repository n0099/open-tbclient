package com.xiaomi.push;

import java.nio.ByteBuffer;
/* loaded from: classes12.dex */
public final class fp extends fl {
    public fp() {
        a("PING", (String) null);
        a("0");
        a(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaomi.push.fl
    /* renamed from: a */
    public ByteBuffer mo282a(ByteBuffer byteBuffer) {
        return a().length == 0 ? byteBuffer : super.mo282a(byteBuffer);
    }

    @Override // com.xiaomi.push.fl
    public int c() {
        if (a().length == 0) {
            return 0;
        }
        return super.c();
    }
}
