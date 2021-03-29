package d.b.b.e.j.a;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f41797a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f41798b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f41799c = -1;

    /* renamed from: d  reason: collision with root package name */
    public String f41800d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f41801e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f41802f = "";

    /* renamed from: g  reason: collision with root package name */
    public Map<String, List<String>> f41803g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f41804h;
    public int i;

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        if (httpURLConnection != null) {
            this.f41798b = httpURLConnection.getResponseCode();
            this.f41800d = httpURLConnection.getContentEncoding();
            this.f41801e = httpURLConnection.getContentType();
            this.f41802f = httpURLConnection.getContentLength() + "";
            this.f41803g = httpURLConnection.getHeaderFields();
        }
    }

    public boolean b() {
        return this.f41798b == 200;
    }
}
