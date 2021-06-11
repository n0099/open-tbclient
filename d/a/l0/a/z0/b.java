package d.a.l0.a.z0;

import android.content.Context;
import android.text.TextWatcher;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f49657c;

    /* renamed from: a  reason: collision with root package name */
    public TextWatcher f49658a;

    /* renamed from: b  reason: collision with root package name */
    public SwanEditText f49659b;

    static {
        boolean z = k.f46875a;
    }

    public static b d() {
        if (f49657c == null) {
            synchronized (b.class) {
                if (f49657c == null) {
                    f49657c = new b();
                }
            }
        }
        return f49657c;
    }

    public SwanEditText a(Context context) {
        SwanEditText swanEditText = new SwanEditText(context);
        this.f49659b = swanEditText;
        return swanEditText;
    }

    public void b() {
        this.f49659b = null;
    }

    public SwanEditText c() {
        return this.f49659b;
    }

    public TextWatcher e() {
        return this.f49658a;
    }

    public void f(TextWatcher textWatcher) {
        this.f49658a = textWatcher;
    }
}
