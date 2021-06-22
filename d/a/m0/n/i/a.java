package d.a.m0.n.i;

import android.text.TextUtils;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.GetRequest;
import com.baidu.searchbox.http.request.PostByteRequest;
import com.baidu.swan.pms.PMSConstants;
import com.baidubce.AbstractBceClient;
import java.security.InvalidParameterException;
import java.util.Map;
import okhttp3.MediaType;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f51797a = d.a.m0.n.c.f51766a;

    /* renamed from: b  reason: collision with root package name */
    public static CookieManager f51798b = d.a.m0.n.c.b().g();

    /* renamed from: c  reason: collision with root package name */
    public static String f51799c;

    /* renamed from: d.a.m0.n.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1135a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Map f51800a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f51801b;

        public C1135a(Map map, e eVar) {
            this.f51800a = map;
            this.f51801b = eVar;
        }

        @Override // d.a.m0.n.i.a.c
        public void a(Map<String, String> map, byte[] bArr, String str) {
            PostByteRequest.PostByteRequestBuilder postByteRequest = d.a.m0.m.e.a.g().postByteRequest();
            d.a.m0.n.d.a(postByteRequest, this.f51800a);
            postByteRequest.url(f.i(str, this.f51800a)).content(bArr).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6).requestSubFrom(10);
            if (map != null) {
                postByteRequest.addHeaders(map);
            }
            if (!TextUtils.isEmpty(a.f51799c)) {
                postByteRequest.userAgent(a.f51799c);
            }
            postByteRequest.cookieManager(a.f51798b).enableStat(true).build().executeStat(this.f51801b);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Map f51802a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f51803b;

        public b(Map map, e eVar) {
            this.f51802a = map;
            this.f51803b = eVar;
        }

        @Override // d.a.m0.n.i.a.c
        public void a(Map<String, String> map, byte[] bArr, String str) {
            GetRequest.GetRequestBuilder requestSubFrom = d.a.m0.m.e.a.g().getRequest().url(f.i(str, this.f51802a)).requestSubFrom(10);
            if (!TextUtils.isEmpty(a.f51799c)) {
                requestSubFrom.userAgent(a.f51799c);
            }
            if (map != null) {
                requestSubFrom.addHeaders(map);
            }
            requestSubFrom.cookieManager(a.f51798b).enableStat(true).build().executeStat(this.f51803b);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(Map<String, String> map, byte[] bArr, String str);
    }

    static {
        d.a.m0.m.a b2 = d.a.m0.m.b.b();
        if (b2 == null || !d.a.m0.m.e.a.g().c()) {
            return;
        }
        f51799c = b2.a();
    }

    @Deprecated
    public static void a(String str, Map<String, String> map, Map<String, String> map2, e<String> eVar) {
        if (TextUtils.isEmpty(str)) {
            if (f51797a) {
                throw new InvalidParameterException("PMS request URL is empty");
            }
            return;
        }
        if (eVar != null) {
            eVar.onStart();
        }
        d.a.m0.n.a b2 = d.a.m0.n.c.b();
        if (PMSConstants.a(b2)) {
            b2.m(f.i(str, map), null, new b(map, eVar));
            return;
        }
        GetRequest.GetRequestBuilder requestSubFrom = d.a.m0.m.e.a.g().getRequest().url(f.i(str, map)).requestSubFrom(10);
        if (!TextUtils.isEmpty(f51799c)) {
            requestSubFrom.userAgent(f51799c);
        }
        if (map2 != null) {
            requestSubFrom.addHeaders(map2);
        }
        requestSubFrom.cookieManager(f51798b).enableStat(true).build().executeStat(eVar);
    }

    @Deprecated
    public static void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, e<String> eVar) {
        if (TextUtils.isEmpty(str)) {
            if (f51797a) {
                throw new InvalidParameterException("PMS request URL is empty");
            }
            return;
        }
        if (eVar != null) {
            eVar.onStart();
        }
        d.a.m0.n.a b2 = d.a.m0.n.c.b();
        if (PMSConstants.a(b2)) {
            b2.m(f.i(str, map), jSONObject.toString(), new C1135a(map, eVar));
            return;
        }
        d.a.m0.m.c.h postStringRequest = d.a.m0.m.e.a.g().postStringRequest();
        d.a.m0.n.d.a(postStringRequest, map);
        postStringRequest.url(f.i(str, map)).content(jSONObject.toString()).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6).requestSubFrom(10);
        if (map2 != null) {
            postStringRequest.addHeaders(map2);
        }
        if (!TextUtils.isEmpty(f51799c)) {
            postStringRequest.userAgent(f51799c);
        }
        postStringRequest.cookieManager(f51798b).enableStat(true).build().executeStat(eVar);
    }
}
