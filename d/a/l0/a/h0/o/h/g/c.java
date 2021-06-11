package d.a.l0.a.h0.o.h.g;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.baidu.webkit.sdk.WebResourceResponse;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public final class c implements g {

    /* renamed from: a  reason: collision with root package name */
    public CopyOnWriteArrayList<a> f46162a;

    /* renamed from: b  reason: collision with root package name */
    public String f46163b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f46164c;

    /* renamed from: d  reason: collision with root package name */
    public int f46165d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f46166e;

    /* renamed from: f  reason: collision with root package name */
    public String f46167f;

    public c(CopyOnWriteArrayList<a> copyOnWriteArrayList, String str, Map<String, String> map, int i2, boolean z) {
        this.f46162a = copyOnWriteArrayList;
        this.f46163b = str;
        this.f46164c = map;
        this.f46165d = i2;
        this.f46166e = z;
    }

    @Override // d.a.l0.a.h0.o.h.g.g
    public void a(String str) {
        this.f46167f = str;
    }

    @Override // d.a.l0.a.h0.o.h.g.g
    public WebResourceResponse b(String str, Map<String, String> map, boolean z) {
        if (this.f46165d >= this.f46162a.size()) {
            return null;
        }
        return this.f46162a.get(this.f46165d).h(new c(this.f46162a, this.f46163b, this.f46164c, this.f46165d + 1, z));
    }

    @Override // d.a.l0.a.h0.o.h.g.g
    public boolean c() {
        return this.f46166e;
    }

    @Override // d.a.l0.a.h0.o.h.g.g
    public String d() {
        return this.f46163b;
    }

    @Override // d.a.l0.a.h0.o.h.g.g
    public String getMimeType() {
        if (TextUtils.isEmpty(this.f46167f)) {
            this.f46167f = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(this.f46163b));
        }
        return this.f46167f;
    }

    @Override // d.a.l0.a.h0.o.h.g.g
    public Map<String, String> getRequestHeaders() {
        return this.f46164c;
    }
}
