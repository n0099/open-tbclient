package d.a.h0.g.l;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public boolean f46676a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f46677b;
    @V8JavascriptField
    public long lastAccessedTime;
    @V8JavascriptField
    public long lastModifiedTime;
    @V8JavascriptField
    public long mode;
    @V8JavascriptField
    public long size;

    public void a(boolean z) {
        this.f46676a = z;
    }

    public void b(boolean z) {
        this.f46677b = z;
    }

    @JavascriptInterface
    public boolean isDirectory() {
        return this.f46676a;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.f46677b;
    }
}
