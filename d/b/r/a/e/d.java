package d.b.r.a.e;

import android.content.Context;
import com.baidu.android.imsdk.internal.IMHttpDnsUrlRequest;
import com.baidu.webkit.internal.daemon.HttpDnsCacheForHost;
import d.b.r.a.c.a;
import d.b.r.a.c.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends a {

    /* renamed from: b  reason: collision with root package name */
    public a.d f65352b = null;

    public d(Context context) {
        this.f65348a = context;
    }

    public void a(a.d dVar) {
        this.f65352b = dVar;
    }

    @Override // d.b.r.a.e.c.b
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put("Host", IMHttpDnsUrlRequest.HTTP_DNS_HOST);
        return hashMap;
    }

    @Override // d.b.r.a.e.c.b
    public String getHost() {
        return IMHttpDnsUrlRequest.HTTP_DNS_URL;
    }

    @Override // d.b.r.a.e.c.b
    public String getMediaType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // d.b.r.a.e.a, d.b.r.a.e.c.b
    public String getMethod() {
        return "GET";
    }

    @Override // d.b.r.a.e.c.b
    public byte[] getRequestParameter() {
        return ("type=ipv4,ipv6&dn=" + f.T(this.f65348a).x).getBytes();
    }

    @Override // d.b.r.a.e.c.d
    public void onFailure(int i, String str) {
        d.b.r.a.g.d.b("LCPHttpDnsUrlRequest", "HttpDns failure errorcode:" + i + ",errormsg:" + str);
        d.b.r.a.c.a.g(true);
        d.b.r.a.c.a.d(this.f65348a).b(f.T(this.f65348a).x, this.f65352b);
    }

    @Override // d.b.r.a.e.c.d
    public void onSuccess(byte[] bArr) {
        String str = new String(bArr);
        d.b.r.a.g.d.a("LCPHttpDnsUrlRequest", "onSuccess----ip of " + f.T(this.f65348a).x + " is " + str);
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("data").getJSONObject(f.T(this.f65348a).x);
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
                d.b.r.a.c.a.k(arrayList);
                if (this.f65352b == null || d.b.r.a.c.a.f65283c.size() <= 0) {
                    return;
                }
                this.f65352b.a(0, "ok", d.b.r.a.c.a.f65283c.get(0));
                if (d.b.r.a.c.a.f65283c.size() > 1) {
                    d.b.r.a.c.a.f65284d++;
                    return;
                }
                return;
            }
            d.b.r.a.g.d.b("LCPHttpDnsUrlRequest", "HttpDnsResponse ips is null ");
            d.b.r.a.c.a.g(true);
            d.b.r.a.c.a.d(this.f65348a).b(f.T(this.f65348a).x, this.f65352b);
        } catch (Exception e2) {
            d.b.r.a.g.d.b("LCPHttpDnsUrlRequest", "HttpDnsRequester ip parse exception " + e2.getMessage());
            d.b.r.a.c.a.g(true);
            d.b.r.a.c.a.d(this.f65348a).b(f.T(this.f65348a).x, this.f65352b);
        }
    }
}
