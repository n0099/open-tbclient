package d.a.l0.a.r0;

import android.annotation.SuppressLint;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes2.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public boolean f44405a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f44406b;
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
        this.f44405a = z;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void b(boolean z) {
        this.f44406b = z;
    }

    @JavascriptInterface
    public boolean isDirectory() {
        return this.f44405a;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.f44406b;
    }
}
