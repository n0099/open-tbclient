package com.qq.e.comm.plugin.t;

import com.qq.e.comm.plugin.t.e;
import java.io.IOException;
import java.net.HttpURLConnection;
/* loaded from: classes3.dex */
class g extends com.qq.e.comm.plugin.t.b.b {
    public g(HttpURLConnection httpURLConnection) {
        super(httpURLConnection);
    }

    @Override // com.qq.e.comm.plugin.t.b.b
    public byte[] a() throws IllegalStateException, IOException {
        try {
            return e.b(super.a());
        } catch (e.b e) {
            e.printStackTrace();
            return null;
        }
    }
}
