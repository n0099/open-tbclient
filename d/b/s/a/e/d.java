package d.b.s.a.e;

import android.content.Context;
import com.baidu.android.imsdk.internal.IMHttpDnsUrlRequest;
import com.baidu.webkit.internal.daemon.HttpDnsCacheForHost;
import d.b.s.a.c.a;
import d.b.s.a.c.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends a {

    /* renamed from: b  reason: collision with root package name */
    public a.d f64658b = null;

    public d(Context context) {
        this.f64654a = context;
    }

    public void a(a.d dVar) {
        this.f64658b = dVar;
    }

    @Override // d.b.s.a.e.c.b
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put("Host", IMHttpDnsUrlRequest.HTTP_DNS_HOST);
        return hashMap;
    }

    @Override // d.b.s.a.e.c.b
    public String getHost() {
        return IMHttpDnsUrlRequest.HTTP_DNS_URL;
    }

    @Override // d.b.s.a.e.c.b
    public String getMediaType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // d.b.s.a.e.a, d.b.s.a.e.c.b
    public String getMethod() {
        return "GET";
    }

    @Override // d.b.s.a.e.c.b
    public byte[] getRequestParameter() {
        return ("type=ipv4,ipv6&dn=" + f.T(this.f64654a).x).getBytes();
    }

    @Override // d.b.s.a.e.c.d
    public void onFailure(int i, String str) {
        d.b.s.a.g.d.b("LCPHttpDnsUrlRequest", "HttpDns failure errorcode:" + i + ",errormsg:" + str);
        d.b.s.a.c.a.g(true);
        d.b.s.a.c.a.d(this.f64654a).b(f.T(this.f64654a).x, this.f64658b);
    }

    @Override // d.b.s.a.e.c.d
    public void onSuccess(byte[] bArr) {
        String str = new String(bArr);
        d.b.s.a.g.d.a("LCPHttpDnsUrlRequest", "onSuccess----ip of " + f.T(this.f64654a).x + " is " + str);
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("data").getJSONObject(f.T(this.f64654a).x);
            JSONArray optJSONArray = jSONObject.optJSONArray("ip");
            JSONArray optJSONArray2 = jSONObject.optJSONArray(HttpDnsCacheForHost.JSON_KEY_IPV6);
            int length = optJSONArray2 == null ? 0 : optJSONArray2.length();
            int length2 = optJSONArray == null ? 0 : optJSONArray.length();
            if (length2 + length > 0) {
                ArrayList arrayList = new ArrayList();
                if (optJSONArray != null && length2 > 0) {
                    arrayList.add(optJSONArray.getString(0));
                }
                if (optJSONArray2 != null && length > 0) {
                    arrayList.add(optJSONArray2.getString(0));
                }
                d.b.s.a.c.a.k(arrayList);
                if (this.f64658b == null || d.b.s.a.c.a.f64589c.size() <= 0) {
                    return;
                }
                this.f64658b.a(0, "ok", d.b.s.a.c.a.f64589c.get(0));
                if (d.b.s.a.c.a.f64589c.size() > 1) {
                    d.b.s.a.c.a.f64590d++;
                    return;
                }
                return;
            }
            d.b.s.a.g.d.b("LCPHttpDnsUrlRequest", "HttpDnsResponse ips is null ");
            d.b.s.a.c.a.g(true);
            d.b.s.a.c.a.d(this.f64654a).b(f.T(this.f64654a).x, this.f64658b);
        } catch (Exception e2) {
            d.b.s.a.g.d.b("LCPHttpDnsUrlRequest", "HttpDnsRequester ip parse exception " + e2.getMessage());
            d.b.s.a.c.a.g(true);
            d.b.s.a.c.a.d(this.f64654a).b(f.T(this.f64654a).x, this.f64658b);
        }
    }
}
