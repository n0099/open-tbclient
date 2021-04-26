package d.a.h0.a.t0;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import d.a.h0.a.k;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f44331c;

    /* renamed from: a  reason: collision with root package name */
    public TextWatcher f44332a;

    /* renamed from: b  reason: collision with root package name */
    public SwanEditText f44333b;

    static {
        boolean z = k.f43101a;
    }

    public static b d() {
        if (f44331c == null) {
            synchronized (b.class) {
                if (f44331c == null) {
                    f44331c = new b();
                }
            }
        }
        return f44331c;
    }

    public SwanEditText a(Context context) {
        SwanEditText swanEditText = new SwanEditText(context);
        this.f44333b = swanEditText;
        return swanEditText;
    }

    public void b() {
        this.f44333b = null;
    }

    public SwanEditText c() {
        return this.f44333b;
    }

    public TextWatcher e() {
        return this.f44332a;
    }

    public void f(TextWatcher textWatcher) {
        this.f44332a = textWatcher;
    }
}
