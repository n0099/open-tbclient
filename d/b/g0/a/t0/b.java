package d.b.g0.a.t0;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import d.b.g0.a.k;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f46222c;

    /* renamed from: a  reason: collision with root package name */
    public TextWatcher f46223a;

    /* renamed from: b  reason: collision with root package name */
    public SwanEditText f46224b;

    static {
        boolean z = k.f45051a;
    }

    public static b d() {
        if (f46222c == null) {
            synchronized (b.class) {
                if (f46222c == null) {
                    f46222c = new b();
                }
            }
        }
        return f46222c;
    }

    public SwanEditText a(Context context) {
        SwanEditText swanEditText = new SwanEditText(context);
        this.f46224b = swanEditText;
        return swanEditText;
    }

    public void b() {
        this.f46224b = null;
    }

    public SwanEditText c() {
        return this.f46224b;
    }

    public TextWatcher e() {
        return this.f46223a;
    }

    public void f(TextWatcher textWatcher) {
        this.f46223a = textWatcher;
    }
}
