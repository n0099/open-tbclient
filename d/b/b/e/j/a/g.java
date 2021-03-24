package d.b.b.e.j.a;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f41796a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f41797b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f41798c = -1;

    /* renamed from: d  reason: collision with root package name */
    public String f41799d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f41800e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f41801f = "";

    /* renamed from: g  reason: collision with root package name */
    public Map<String, List<String>> f41802g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f41803h;
    public int i;

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        if (httpURLConnection != null) {
            this.f41797b = httpURLConnection.getResponseCode();
            this.f41799d = httpURLConnection.getContentEncoding();
            this.f41800e = httpURLConnection.getContentType();
            this.f41801f = httpURLConnection.getContentLength() + "";
            this.f41802g = httpURLConnection.getHeaderFields();
        }
    }

    public boolean b() {
        return this.f41797b == 200;
    }
}
