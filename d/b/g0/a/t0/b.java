package d.b.g0.a.t0;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import d.b.g0.a.k;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f46221c;

    /* renamed from: a  reason: collision with root package name */
    public TextWatcher f46222a;

    /* renamed from: b  reason: collision with root package name */
    public SwanEditText f46223b;

    static {
        boolean z = k.f45050a;
    }

    public static b d() {
        if (f46221c == null) {
            synchronized (b.class) {
                if (f46221c == null) {
                    f46221c = new b();
                }
            }
        }
        return f46221c;
    }

    public SwanEditText a(Context context) {
        SwanEditText swanEditText = new SwanEditText(context);
        this.f46223b = swanEditText;
        return swanEditText;
    }

    public void b() {
        this.f46223b = null;
    }

    public SwanEditText c() {
        return this.f46223b;
    }

    public TextWatcher e() {
        return this.f46222a;
    }

    public void f(TextWatcher textWatcher) {
        this.f46222a = textWatcher;
    }
}
