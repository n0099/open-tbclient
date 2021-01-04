package com.qq.e.comm.plugin.t;

import com.qq.e.comm.plugin.t.b.e;
import java.net.HttpURLConnection;
/* loaded from: classes3.dex */
public class f extends com.qq.e.comm.plugin.t.b.a {
    public f(String str, byte[] bArr) {
        super(str, e.a.POST, bArr);
    }

    @Override // com.qq.e.comm.plugin.t.b.e
    public com.qq.e.comm.plugin.t.b.f a(HttpURLConnection httpURLConnection) {
        return new g(httpURLConnection);
    }

    @Override // com.qq.e.comm.plugin.t.b.a, com.qq.e.comm.plugin.t.b.e
    public byte[] a() throws Exception {
        return e.a(super.a());
    }
}
