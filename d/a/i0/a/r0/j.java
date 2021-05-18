package d.a.i0.a.r0;

import android.annotation.SuppressLint;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes2.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public boolean f44229a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f44230b;
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
        this.f44229a = z;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void b(boolean z) {
        this.f44230b = z;
    }

    @JavascriptInterface
    public boolean isDirectory() {
        return this.f44229a;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.f44230b;
    }
}
