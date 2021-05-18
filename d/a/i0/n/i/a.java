package d.a.i0.n.i;

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
    public static final boolean f47839a = d.a.i0.n.c.f47808a;

    /* renamed from: b  reason: collision with root package name */
    public static CookieManager f47840b = d.a.i0.n.c.b().g();

    /* renamed from: c  reason: collision with root package name */
    public static String f47841c;

    /* renamed from: d.a.i0.n.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1065a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Map f47842a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f47843b;

        public C1065a(Map map, e eVar) {
            this.f47842a = map;
            this.f47843b = eVar;
        }

        @Override // d.a.i0.n.i.a.c
        public void a(Map<String, String> map, byte[] bArr, String str) {
            PostByteRequest.PostByteRequestBuilder postByteRequest = d.a.i0.m.e.a.g().postByteRequest();
            d.a.i0.n.d.a(postByteRequest, this.f47842a);
            postByteRequest.url(f.i(str, this.f47842a)).content(bArr).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6).requestSubFrom(10);
            if (map != null) {
                postByteRequest.addHeaders(map);
            }
            if (!TextUtils.isEmpty(a.f47841c)) {
                postByteRequest.userAgent(a.f47841c);
            }
            postByteRequest.cookieManager(a.f47840b).enableStat(true).build().executeStat(this.f47843b);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Map f47844a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f47845b;

        public b(Map map, e eVar) {
            this.f47844a = map;
            this.f47845b = eVar;
        }

        @Override // d.a.i0.n.i.a.c
        public void a(Map<String, String> map, byte[] bArr, String str) {
            GetRequest.GetRequestBuilder requestSubFrom = d.a.i0.m.e.a.g().getRequest().url(f.i(str, this.f47844a)).requestSubFrom(10);
            if (!TextUtils.isEmpty(a.f47841c)) {
                requestSubFrom.userAgent(a.f47841c);
            }
            if (map != null) {
                requestSubFrom.addHeaders(map);
            }
            requestSubFrom.cookieManager(a.f47840b).enableStat(true).build().executeStat(this.f47845b);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(Map<String, String> map, byte[] bArr, String str);
    }

    static {
        d.a.i0.m.a b2 = d.a.i0.m.b.b();
        if (b2 == null || !d.a.i0.m.e.a.g().c()) {
            return;
        }
        f47841c = b2.a();
    }

    @Deprecated
    public static void a(String str, Map<String, String> map, Map<String, String> map2, e<String> eVar) {
        if (TextUtils.isEmpty(str)) {
            if (f47839a) {
                throw new InvalidParameterException("PMS request URL is empty");
            }
            return;
        }
        if (eVar != null) {
            eVar.onStart();
        }
        d.a.i0.n.a b2 = d.a.i0.n.c.b();
        if (PMSConstants.a(b2)) {
            b2.m(f.i(str, map), null, new b(map, eVar));
            return;
        }
        GetRequest.GetRequestBuilder requestSubFrom = d.a.i0.m.e.a.g().getRequest().url(f.i(str, map)).requestSubFrom(10);
        if (!TextUtils.isEmpty(f47841c)) {
            requestSubFrom.userAgent(f47841c);
        }
        if (map2 != null) {
            requestSubFrom.addHeaders(map2);
        }
        requestSubFrom.cookieManager(f47840b).enableStat(true).build().executeStat(eVar);
    }

    @Deprecated
    public static void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, e<String> eVar) {
        if (TextUtils.isEmpty(str)) {
            if (f47839a) {
                throw new InvalidParameterException("PMS request URL is empty");
            }
            return;
        }
        if (eVar != null) {
            eVar.onStart();
        }
        d.a.i0.n.a b2 = d.a.i0.n.c.b();
        if (PMSConstants.a(b2)) {
            b2.m(f.i(str, map), jSONObject.toString(), new C1065a(map, eVar));
            return;
        }
        d.a.i0.m.c.h postStringRequest = d.a.i0.m.e.a.g().postStringRequest();
        d.a.i0.n.d.a(postStringRequest, map);
        postStringRequest.url(f.i(str, map)).content(jSONObject.toString()).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6).requestSubFrom(10);
        if (map2 != null) {
            postStringRequest.addHeaders(map2);
        }
        if (!TextUtils.isEmpty(f47841c)) {
            postStringRequest.userAgent(f47841c);
        }
        postStringRequest.cookieManager(f47840b).enableStat(true).build().executeStat(eVar);
    }
}
