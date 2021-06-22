package d.a.m0.a.v2;

import android.content.Context;
import android.os.IBinder;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes3.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49287a = d.a.m0.a.k.f46983a;

    public static void a(Context context, IBinder iBinder) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager != null) {
            try {
                inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
            } catch (Exception e2) {
                if (f49287a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void b(Context context, boolean z) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(z ? 2 : 0, 2);
        }
    }
}
