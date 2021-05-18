package d.a.i0.a.z0;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import d.a.i0.a.k;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f45807c;

    /* renamed from: a  reason: collision with root package name */
    public TextWatcher f45808a;

    /* renamed from: b  reason: collision with root package name */
    public SwanEditText f45809b;

    static {
        boolean z = k.f43025a;
    }

    public static b d() {
        if (f45807c == null) {
            synchronized (b.class) {
                if (f45807c == null) {
                    f45807c = new b();
                }
            }
        }
        return f45807c;
    }

    public SwanEditText a(Context context) {
        SwanEditText swanEditText = new SwanEditText(context);
        this.f45809b = swanEditText;
        return swanEditText;
    }

    public void b() {
        this.f45809b = null;
    }

    public SwanEditText c() {
        return this.f45809b;
    }

    public TextWatcher e() {
        return this.f45808a;
    }

    public void f(TextWatcher textWatcher) {
        this.f45808a = textWatcher;
    }
}
