package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.ViewCompat;
import com.qq.e.comm.managers.GDTADManager;
/* loaded from: classes3.dex */
public class ay {

    /* renamed from: a  reason: collision with root package name */
    private static Toast f12571a = null;

    /* renamed from: b  reason: collision with root package name */
    private static TextView f12572b = null;

    private static void a(Context context) {
        f12572b = new TextView(context);
        f12572b.setPadding(ak.a(context, 20), ak.a(context, 12), ak.a(context, 20), ak.a(context, 12));
        f12572b.setTextColor(-1);
        f12572b.setTextSize(2, 16.0f);
        f12572b.setBackgroundDrawable(ap.a(60.0f, ViewCompat.MEASURED_STATE_MASK, 100));
        f12571a = new Toast(context);
        f12571a.setGravity(17, 0, 0);
        f12571a.setView(f12572b);
    }

    private static void a(Context context, String str) {
        if (f12572b == null || f12571a == null) {
            a(context);
        }
        f12572b.setText(str);
    }

    public static void a(final String str) {
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.util.ay.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ay.b(str);
                } catch (Throwable th) {
                }
            }
        });
    }

    public static void b(String str) {
        a(GDTADManager.getInstance().getAppContext(), str);
        f12571a.setDuration(0);
        f12571a.show();
    }
}
