package d.a.i0.a.h0.o.h;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import d.a.i0.a.h0.o.h.g.g;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class b extends d.a.i0.a.h0.o.h.g.a implements d.a.i0.a.h0.o.h.e.a {

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.a.h0.o.h.d.b.a f42278e;

    public b(@NonNull Context context, d.a.i0.a.h0.o.h.c.a aVar) {
        super(context, aVar);
        this.f42278e = d.a.i0.a.h0.o.h.d.a.a().f();
    }

    @Override // d.a.i0.a.h0.o.h.g.a
    public String d() {
        return "image";
    }

    @Override // d.a.i0.a.h0.o.h.g.a
    public Map<String, String> f(@NonNull g gVar) {
        Map<String, String> requestHeaders = gVar.getRequestHeaders();
        if (requestHeaders == null) {
            requestHeaders = new HashMap<>();
        }
        String f2 = d.a.i0.a.l2.b.l().f(e(gVar.d()), requestHeaders.get("Cookie"));
        if (!TextUtils.isEmpty(f2)) {
            requestHeaders.put("Cookie", f2);
            if (d.a.i0.a.h0.o.h.e.a.f42292a) {
                Log.d("HybridIntercept", "addCookiesToHeader cookie: " + f2);
            }
        }
        return requestHeaders;
    }

    @Override // d.a.i0.a.h0.o.h.g.a
    public boolean i(@NonNull g gVar) {
        Map<String, String> requestHeaders;
        String str;
        if (gVar.c()) {
            return this.f42278e.a(gVar) && (requestHeaders = gVar.getRequestHeaders()) != null && requestHeaders.containsKey("Accept") && (str = requestHeaders.get("Accept")) != null && str.startsWith("image");
        }
        return true;
    }
}
