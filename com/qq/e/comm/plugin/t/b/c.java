package com.qq.e.comm.plugin.t.b;

import com.qq.e.comm.plugin.t.b.e;
import java.net.HttpURLConnection;
import java.util.Map;
/* loaded from: classes4.dex */
public class c extends a {
    public c(String str, e.a aVar, byte[] bArr) {
        super(str, aVar, bArr);
    }

    public c(String str, Map<String, String> map, e.a aVar) {
        super(str, map, aVar);
    }

    @Override // com.qq.e.comm.plugin.t.b.e
    public f a(HttpURLConnection httpURLConnection) {
        return new d(httpURLConnection);
    }
}
