package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.ViewCompat;
import com.qq.e.comm.managers.GDTADManager;
/* loaded from: classes3.dex */
public class ay {

    /* renamed from: a  reason: collision with root package name */
    private static Toast f12870a = null;

    /* renamed from: b  reason: collision with root package name */
    private static TextView f12871b = null;

    private static void a(Context context) {
        f12871b = new TextView(context);
        f12871b.setPadding(ak.a(context, 20), ak.a(context, 12), ak.a(context, 20), ak.a(context, 12));
        f12871b.setTextColor(-1);
        f12871b.setTextSize(2, 16.0f);
        f12871b.setBackgroundDrawable(ap.a(60.0f, ViewCompat.MEASURED_STATE_MASK, 100));
        f12870a = new Toast(context);
        f12870a.setGravity(17, 0, 0);
        f12870a.setView(f12871b);
    }

    private static void a(Context context, String str) {
        if (f12871b == null || f12870a == null) {
            a(context);
        }
        f12871b.setText(str);
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
        f12870a.setDuration(0);
        f12870a.show();
    }
}
