package d.a.l0.a.r0;

import android.annotation.SuppressLint;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public boolean f48079a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f48080b;
    @V8JavascriptField
    public long lastAccessedTime;
    @V8JavascriptField
    public long lastModifiedTime;
    @V8JavascriptField
    public long mode;
    @V8JavascriptField
    public long size;

    @SuppressLint({"KotlinPropertyAccess"})
    public void a(boolean z) {
        this.f48079a = z;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void b(boolean z) {
        this.f48080b = z;
    }

    @JavascriptInterface
    public boolean isDirectory() {
        return this.f48079a;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.f48080b;
    }
}
