package d.a.i0.a.h0.o.h.g;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.baidu.webkit.sdk.WebResourceResponse;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public final class c implements g {

    /* renamed from: a  reason: collision with root package name */
    public CopyOnWriteArrayList<a> f42312a;

    /* renamed from: b  reason: collision with root package name */
    public String f42313b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f42314c;

    /* renamed from: d  reason: collision with root package name */
    public int f42315d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42316e;

    /* renamed from: f  reason: collision with root package name */
    public String f42317f;

    public c(CopyOnWriteArrayList<a> copyOnWriteArrayList, String str, Map<String, String> map, int i2, boolean z) {
        this.f42312a = copyOnWriteArrayList;
        this.f42313b = str;
        this.f42314c = map;
        this.f42315d = i2;
        this.f42316e = z;
    }

    @Override // d.a.i0.a.h0.o.h.g.g
    public void a(String str) {
        this.f42317f = str;
    }

    @Override // d.a.i0.a.h0.o.h.g.g
    public WebResourceResponse b(String str, Map<String, String> map, boolean z) {
        if (this.f42315d >= this.f42312a.size()) {
            return null;
        }
        return this.f42312a.get(this.f42315d).h(new c(this.f42312a, this.f42313b, this.f42314c, this.f42315d + 1, z));
    }

    @Override // d.a.i0.a.h0.o.h.g.g
    public boolean c() {
        return this.f42316e;
    }

    @Override // d.a.i0.a.h0.o.h.g.g
    public String d() {
        return this.f42313b;
    }

    @Override // d.a.i0.a.h0.o.h.g.g
    public String getMimeType() {
        if (TextUtils.isEmpty(this.f42317f)) {
            this.f42317f = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(this.f42313b));
        }
        return this.f42317f;
    }

    @Override // d.a.i0.a.h0.o.h.g.g
    public Map<String, String> getRequestHeaders() {
        return this.f42314c;
    }
}
