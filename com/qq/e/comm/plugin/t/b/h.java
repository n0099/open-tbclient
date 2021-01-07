package com.qq.e.comm.plugin.t.b;

import com.qq.e.comm.plugin.util.aq;
import java.io.IOException;
import java.net.HttpURLConnection;
/* loaded from: classes4.dex */
public class h extends b {
    public h(HttpURLConnection httpURLConnection) {
        super(httpURLConnection);
    }

    @Override // com.qq.e.comm.plugin.t.b.b
    public byte[] a() throws IllegalStateException, IOException {
        try {
            return aq.b(super.a());
        } catch (aq.b e) {
            e.printStackTrace();
            return null;
        }
    }
}
