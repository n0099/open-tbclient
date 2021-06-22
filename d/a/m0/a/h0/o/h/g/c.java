package d.a.m0.a.h0.o.h.g;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.baidu.webkit.sdk.WebResourceResponse;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public final class c implements g {

    /* renamed from: a  reason: collision with root package name */
    public CopyOnWriteArrayList<a> f46270a;

    /* renamed from: b  reason: collision with root package name */
    public String f46271b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f46272c;

    /* renamed from: d  reason: collision with root package name */
    public int f46273d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f46274e;

    /* renamed from: f  reason: collision with root package name */
    public String f46275f;

    public c(CopyOnWriteArrayList<a> copyOnWriteArrayList, String str, Map<String, String> map, int i2, boolean z) {
        this.f46270a = copyOnWriteArrayList;
        this.f46271b = str;
        this.f46272c = map;
        this.f46273d = i2;
        this.f46274e = z;
    }

    @Override // d.a.m0.a.h0.o.h.g.g
    public void a(String str) {
        this.f46275f = str;
    }

    @Override // d.a.m0.a.h0.o.h.g.g
    public WebResourceResponse b(String str, Map<String, String> map, boolean z) {
        if (this.f46273d >= this.f46270a.size()) {
            return null;
        }
        return this.f46270a.get(this.f46273d).h(new c(this.f46270a, this.f46271b, this.f46272c, this.f46273d + 1, z));
    }

    @Override // d.a.m0.a.h0.o.h.g.g
    public boolean c() {
        return this.f46274e;
    }

    @Override // d.a.m0.a.h0.o.h.g.g
    public String d() {
        return this.f46271b;
    }

    @Override // d.a.m0.a.h0.o.h.g.g
    public String getMimeType() {
        if (TextUtils.isEmpty(this.f46275f)) {
            this.f46275f = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(this.f46271b));
        }
        return this.f46275f;
    }

    @Override // d.a.m0.a.h0.o.h.g.g
    public Map<String, String> getRequestHeaders() {
        return this.f46272c;
    }
}
