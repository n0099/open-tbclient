package com.qq.e.comm.plugin.t.b;

import java.net.HttpURLConnection;
import java.util.Map;
/* loaded from: classes3.dex */
public interface e {

    /* loaded from: classes3.dex */
    public enum a {
        GET,
        POST
    }

    f a(HttpURLConnection httpURLConnection);

    void a(String str, String str2);

    void a(boolean z);

    byte[] a() throws Exception;

    a b();

    void b(String str, String str2);

    void b(boolean z);

    Map<String, String> d();

    Map<String, String> e();

    String f();

    int g();

    int h();

    boolean i();

    boolean j();
}
