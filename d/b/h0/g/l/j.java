package d.b.h0.g.l;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public boolean f49183a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f49184b;
    @V8JavascriptField
    public long lastAccessedTime;
    @V8JavascriptField
    public long lastModifiedTime;
    @V8JavascriptField
    public long mode;
    @V8JavascriptField
    public long size;

    public void a(boolean z) {
        this.f49183a = z;
    }

    public void b(boolean z) {
        this.f49184b = z;
    }

    @JavascriptInterface
    public boolean isDirectory() {
        return this.f49183a;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.f49184b;
    }
}
