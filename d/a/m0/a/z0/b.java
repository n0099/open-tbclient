package d.a.m0.a.z0;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import d.a.m0.a.k;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f49765c;

    /* renamed from: a  reason: collision with root package name */
    public TextWatcher f49766a;

    /* renamed from: b  reason: collision with root package name */
    public SwanEditText f49767b;

    static {
        boolean z = k.f46983a;
    }

    public static b d() {
        if (f49765c == null) {
            synchronized (b.class) {
                if (f49765c == null) {
                    f49765c = new b();
                }
            }
        }
        return f49765c;
    }

    public SwanEditText a(Context context) {
        SwanEditText swanEditText = new SwanEditText(context);
        this.f49767b = swanEditText;
        return swanEditText;
    }

    public void b() {
        this.f49767b = null;
    }

    public SwanEditText c() {
        return this.f49767b;
    }

    public TextWatcher e() {
        return this.f49766a;
    }

    public void f(TextWatcher textWatcher) {
        this.f49766a = textWatcher;
    }
}
