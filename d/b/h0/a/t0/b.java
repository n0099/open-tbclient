package d.b.h0.a.t0;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import d.b.h0.a.k;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f46943c;

    /* renamed from: a  reason: collision with root package name */
    public TextWatcher f46944a;

    /* renamed from: b  reason: collision with root package name */
    public SwanEditText f46945b;

    static {
        boolean z = k.f45772a;
    }

    public static b d() {
        if (f46943c == null) {
            synchronized (b.class) {
                if (f46943c == null) {
                    f46943c = new b();
                }
            }
        }
        return f46943c;
    }

    public SwanEditText a(Context context) {
        SwanEditText swanEditText = new SwanEditText(context);
        this.f46945b = swanEditText;
        return swanEditText;
    }

    public void b() {
        this.f46945b = null;
    }

    public SwanEditText c() {
        return this.f46945b;
    }

    public TextWatcher e() {
        return this.f46944a;
    }

    public void f(TextWatcher textWatcher) {
        this.f46944a = textWatcher;
    }
}
