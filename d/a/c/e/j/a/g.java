package d.a.c.e.j.a;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f38641a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f38642b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f38643c = -1;

    /* renamed from: d  reason: collision with root package name */
    public String f38644d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f38645e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f38646f = "";

    /* renamed from: g  reason: collision with root package name */
    public Map<String, List<String>> f38647g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f38648h;

    /* renamed from: i  reason: collision with root package name */
    public int f38649i;

    public void a(HttpURLConnection httpURLConnection) throws Exception {
        if (httpURLConnection != null) {
            this.f38642b = httpURLConnection.getResponseCode();
            this.f38644d = httpURLConnection.getContentEncoding();
            this.f38645e = httpURLConnection.getContentType();
            this.f38646f = httpURLConnection.getContentLength() + "";
            this.f38647g = httpURLConnection.getHeaderFields();
        }
    }

    public boolean b() {
        return this.f38642b == 200;
    }
}
