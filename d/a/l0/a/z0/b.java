package d.a.l0.a.z0;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f45983c;

    /* renamed from: a  reason: collision with root package name */
    public TextWatcher f45984a;

    /* renamed from: b  reason: collision with root package name */
    public SwanEditText f45985b;

    static {
        boolean z = k.f43199a;
    }

    public static b d() {
        if (f45983c == null) {
            synchronized (b.class) {
                if (f45983c == null) {
                    f45983c = new b();
                }
            }
        }
        return f45983c;
    }

    public SwanEditText a(Context context) {
        SwanEditText swanEditText = new SwanEditText(context);
        this.f45985b = swanEditText;
        return swanEditText;
    }

    public void b() {
        this.f45985b = null;
    }

    public SwanEditText c() {
        return this.f45985b;
    }

    public TextWatcher e() {
        return this.f45984a;
    }

    public void f(TextWatcher textWatcher) {
        this.f45984a = textWatcher;
    }
}
