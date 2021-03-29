package d.b.g0.g.l;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public boolean f48462a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f48463b;
    @V8JavascriptField
    public long lastAccessedTime;
    @V8JavascriptField
    public long lastModifiedTime;
    @V8JavascriptField
    public long mode;
    @V8JavascriptField
    public long size;

    public void a(boolean z) {
        this.f48462a = z;
    }

    public void b(boolean z) {
        this.f48463b = z;
    }

    @JavascriptInterface
    public boolean isDirectory() {
        return this.f48462a;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.f48463b;
    }
}
