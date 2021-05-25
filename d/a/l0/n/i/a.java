package d.a.l0.n.i;

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
    public static final boolean f48015a = d.a.l0.n.c.f47984a;

    /* renamed from: b  reason: collision with root package name */
    public static CookieManager f48016b = d.a.l0.n.c.b().g();

    /* renamed from: c  reason: collision with root package name */
    public static String f48017c;

    /* renamed from: d.a.l0.n.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1076a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Map f48018a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f48019b;

        public C1076a(Map map, e eVar) {
            this.f48018a = map;
            this.f48019b = eVar;
        }

        @Override // d.a.l0.n.i.a.c
        public void a(Map<String, String> map, byte[] bArr, String str) {
            PostByteRequest.PostByteRequestBuilder postByteRequest = d.a.l0.m.e.a.g().postByteRequest();
            d.a.l0.n.d.a(postByteRequest, this.f48018a);
            postByteRequest.url(f.i(str, this.f48018a)).content(bArr).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6).requestSubFrom(10);
            if (map != null) {
                postByteRequest.addHeaders(map);
            }
            if (!TextUtils.isEmpty(a.f48017c)) {
                postByteRequest.userAgent(a.f48017c);
            }
            postByteRequest.cookieManager(a.f48016b).enableStat(true).build().executeStat(this.f48019b);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Map f48020a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f48021b;

        public b(Map map, e eVar) {
            this.f48020a = map;
            this.f48021b = eVar;
        }

        @Override // d.a.l0.n.i.a.c
        public void a(Map<String, String> map, byte[] bArr, String str) {
            GetRequest.GetRequestBuilder requestSubFrom = d.a.l0.m.e.a.g().getRequest().url(f.i(str, this.f48020a)).requestSubFrom(10);
            if (!TextUtils.isEmpty(a.f48017c)) {
                requestSubFrom.userAgent(a.f48017c);
            }
            if (map != null) {
                requestSubFrom.addHeaders(map);
            }
            requestSubFrom.cookieManager(a.f48016b).enableStat(true).build().executeStat(this.f48021b);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(Map<String, String> map, byte[] bArr, String str);
    }

    static {
        d.a.l0.m.a b2 = d.a.l0.m.b.b();
        if (b2 == null || !d.a.l0.m.e.a.g().c()) {
            return;
        }
        f48017c = b2.a();
    }

    @Deprecated
    public static void a(String str, Map<String, String> map, Map<String, String> map2, e<String> eVar) {
        if (TextUtils.isEmpty(str)) {
            if (f48015a) {
                throw new InvalidParameterException("PMS request URL is empty");
            }
            return;
        }
        if (eVar != null) {
            eVar.onStart();
        }
        d.a.l0.n.a b2 = d.a.l0.n.c.b();
        if (PMSConstants.a(b2)) {
            b2.m(f.i(str, map), null, new b(map, eVar));
            return;
        }
        GetRequest.GetRequestBuilder requestSubFrom = d.a.l0.m.e.a.g().getRequest().url(f.i(str, map)).requestSubFrom(10);
        if (!TextUtils.isEmpty(f48017c)) {
            requestSubFrom.userAgent(f48017c);
        }
        if (map2 != null) {
            requestSubFrom.addHeaders(map2);
        }
        requestSubFrom.cookieManager(f48016b).enableStat(true).build().executeStat(eVar);
    }

    @Deprecated
    public static void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, e<String> eVar) {
        if (TextUtils.isEmpty(str)) {
            if (f48015a) {
                throw new InvalidParameterException("PMS request URL is empty");
            }
            return;
        }
        if (eVar != null) {
            eVar.onStart();
        }
        d.a.l0.n.a b2 = d.a.l0.n.c.b();
        if (PMSConstants.a(b2)) {
            b2.m(f.i(str, map), jSONObject.toString(), new C1076a(map, eVar));
            return;
        }
        d.a.l0.m.c.h postStringRequest = d.a.l0.m.e.a.g().postStringRequest();
        d.a.l0.n.d.a(postStringRequest, map);
        postStringRequest.url(f.i(str, map)).content(jSONObject.toString()).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6).requestSubFrom(10);
        if (map2 != null) {
            postStringRequest.addHeaders(map2);
        }
        if (!TextUtils.isEmpty(f48017c)) {
            postStringRequest.userAgent(f48017c);
        }
        postStringRequest.cookieManager(f48016b).enableStat(true).build().executeStat(eVar);
    }
}
