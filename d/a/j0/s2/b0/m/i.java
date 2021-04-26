package d.a.j0.s2.b0.m;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    public int f60189c;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, List<String>> f60192f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f60193g;

    /* renamed from: h  reason: collision with root package name */
    public int f60194h;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f60187a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f60188b = -1;

    /* renamed from: d  reason: collision with root package name */
    public String f60190d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f60191e = "";

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        if (httpURLConnection != null) {
            this.f60188b = httpURLConnection.getResponseCode();
            this.f60190d = httpURLConnection.getContentEncoding();
            httpURLConnection.getContentType();
            this.f60191e = httpURLConnection.getContentLength() + "";
            this.f60192f = httpURLConnection.getHeaderFields();
        }
    }
}
