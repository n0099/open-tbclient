package com.xiaomi.push;

import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public final class fj extends ff {
    public fj() {
        a("PING", (String) null);
        a("0");
        a(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaomi.push.ff
    /* renamed from: a */
    public ByteBuffer mo273a(ByteBuffer byteBuffer) {
        return a().length == 0 ? byteBuffer : super.mo273a(byteBuffer);
    }

    @Override // com.xiaomi.push.ff
    public int c() {
        if (a().length == 0) {
            return 0;
        }
        return super.c();
    }
}
