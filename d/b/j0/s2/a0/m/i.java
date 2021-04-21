package d.b.j0.s2.a0.m;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    public int f62004c;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, List<String>> f62007f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f62008g;

    /* renamed from: h  reason: collision with root package name */
    public int f62009h;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f62002a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f62003b = -1;

    /* renamed from: d  reason: collision with root package name */
    public String f62005d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f62006e = "";

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        if (httpURLConnection != null) {
            this.f62003b = httpURLConnection.getResponseCode();
            this.f62005d = httpURLConnection.getContentEncoding();
            httpURLConnection.getContentType();
            this.f62006e = httpURLConnection.getContentLength() + "";
            this.f62007f = httpURLConnection.getHeaderFields();
        }
    }
}
