package d.a.l0.a.h0.o.h.g;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.baidu.webkit.sdk.WebResourceResponse;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public final class c implements g {

    /* renamed from: a  reason: collision with root package name */
    public CopyOnWriteArrayList<a> f42486a;

    /* renamed from: b  reason: collision with root package name */
    public String f42487b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f42488c;

    /* renamed from: d  reason: collision with root package name */
    public int f42489d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42490e;

    /* renamed from: f  reason: collision with root package name */
    public String f42491f;

    public c(CopyOnWriteArrayList<a> copyOnWriteArrayList, String str, Map<String, String> map, int i2, boolean z) {
        this.f42486a = copyOnWriteArrayList;
        this.f42487b = str;
        this.f42488c = map;
        this.f42489d = i2;
        this.f42490e = z;
    }

    @Override // d.a.l0.a.h0.o.h.g.g
    public void a(String str) {
        this.f42491f = str;
    }

    @Override // d.a.l0.a.h0.o.h.g.g
    public WebResourceResponse b(String str, Map<String, String> map, boolean z) {
        if (this.f42489d >= this.f42486a.size()) {
            return null;
        }
        return this.f42486a.get(this.f42489d).h(new c(this.f42486a, this.f42487b, this.f42488c, this.f42489d + 1, z));
    }

    @Override // d.a.l0.a.h0.o.h.g.g
    public boolean c() {
        return this.f42490e;
    }

    @Override // d.a.l0.a.h0.o.h.g.g
    public String d() {
        return this.f42487b;
    }

    @Override // d.a.l0.a.h0.o.h.g.g
    public String getMimeType() {
        if (TextUtils.isEmpty(this.f42491f)) {
            this.f42491f = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(this.f42487b));
        }
        return this.f42491f;
    }

    @Override // d.a.l0.a.h0.o.h.g.g
    public Map<String, String> getRequestHeaders() {
        return this.f42488c;
    }
}
