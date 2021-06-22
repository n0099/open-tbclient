package d.a.m0.a.h0.o.h;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.baidu.webkit.sdk.WebResourceRequest;
import com.baidu.webkit.sdk.WebResourceResponse;
import d.a.m0.a.h0.o.h.g.c;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public CopyOnWriteArrayList<d.a.m0.a.h0.o.h.g.a> f46234a;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f46235a = new a();
    }

    public static a b() {
        return b.f46235a;
    }

    public void a(d.a.m0.a.h0.o.h.g.a aVar) {
        if (aVar == null || this.f46234a.contains(aVar)) {
            return;
        }
        this.f46234a.add(aVar);
    }

    @RequiresApi(api = 21)
    public WebResourceResponse c(WebResourceRequest webResourceRequest, boolean z) {
        Uri url;
        if (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) {
            return null;
        }
        return d(url.toString(), webResourceRequest.getRequestHeaders(), z);
    }

    public final WebResourceResponse d(String str, Map<String, String> map, boolean z) {
        if (this.f46234a.isEmpty() || TextUtils.isEmpty(str) || str.startsWith("file://")) {
            return null;
        }
        return new c(this.f46234a, str, map, 0, z).b(str, map, z);
    }

    public a() {
        this.f46234a = new CopyOnWriteArrayList<>();
    }
}
