package com.qq.e.comm.plugin.t.b;

import com.qq.e.comm.plugin.t.b.e;
import com.qq.e.comm.plugin.util.aq;
import java.net.HttpURLConnection;
/* loaded from: classes4.dex */
public class g extends a {
    public g(String str, byte[] bArr) {
        super(str, e.a.POST, bArr);
    }

    @Override // com.qq.e.comm.plugin.t.b.e
    public f a(HttpURLConnection httpURLConnection) {
        return new h(httpURLConnection);
    }

    @Override // com.qq.e.comm.plugin.t.b.a, com.qq.e.comm.plugin.t.b.e
    public byte[] a() throws Exception {
        return aq.a(super.a());
    }
}
