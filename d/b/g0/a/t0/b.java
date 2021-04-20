package d.b.g0.a.t0;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import d.b.g0.a.k;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f46614c;

    /* renamed from: a  reason: collision with root package name */
    public TextWatcher f46615a;

    /* renamed from: b  reason: collision with root package name */
    public SwanEditText f46616b;

    static {
        boolean z = k.f45443a;
    }

    public static b d() {
        if (f46614c == null) {
            synchronized (b.class) {
                if (f46614c == null) {
                    f46614c = new b();
                }
            }
        }
        return f46614c;
    }

    public SwanEditText a(Context context) {
        SwanEditText swanEditText = new SwanEditText(context);
        this.f46616b = swanEditText;
        return swanEditText;
    }

    public void b() {
        this.f46616b = null;
    }

    public SwanEditText c() {
        return this.f46616b;
    }

    public TextWatcher e() {
        return this.f46615a;
    }

    public void f(TextWatcher textWatcher) {
        this.f46615a = textWatcher;
    }
}
