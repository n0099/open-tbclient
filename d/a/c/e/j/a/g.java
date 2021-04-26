package d.a.c.e.j.a;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f39732a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f39733b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f39734c = -1;

    /* renamed from: d  reason: collision with root package name */
    public String f39735d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f39736e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f39737f = "";

    /* renamed from: g  reason: collision with root package name */
    public Map<String, List<String>> f39738g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f39739h;

    /* renamed from: i  reason: collision with root package name */
    public int f39740i;

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        if (httpURLConnection != null) {
            this.f39733b = httpURLConnection.getResponseCode();
            this.f39735d = httpURLConnection.getContentEncoding();
            this.f39736e = httpURLConnection.getContentType();
            this.f39737f = httpURLConnection.getContentLength() + "";
            this.f39738g = httpURLConnection.getHeaderFields();
        }
    }

    public boolean b() {
        return this.f39733b == 200;
    }
}
