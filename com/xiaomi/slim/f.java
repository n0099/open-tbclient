package com.xiaomi.slim;

import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public final class f extends b {
    public f() {
        a("PING", (String) null);
        a("0");
        a(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaomi.slim.b
    public ByteBuffer a(ByteBuffer byteBuffer) {
        return k().length == 0 ? byteBuffer : super.a(byteBuffer);
    }

    @Override // com.xiaomi.slim.b
    public int l() {
        if (k().length == 0) {
            return 0;
        }
        return super.l();
    }
}
