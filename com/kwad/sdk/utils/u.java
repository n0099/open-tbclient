package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.kwad.sdk.R;
/* loaded from: classes3.dex */
public class u {
    public static Handler a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f57959b = false;

    public static void a(Context context, String str) {
        b(context, str, R.layout.ksad_content_alliance_toast_2);
    }

    public static void a(Context context, String str, int i2) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.ksad_content_alliance_toast, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.ksad_message_toast_txt)).setText(str);
        Toast toast = new Toast(context);
        toast.setGravity(17, 0, 0);
        toast.setDuration(i2);
        toast.setView(inflate);
        toast.show();
    }

    public static void a(Context context, String str, int i2, long j2) {
        if (f57959b) {
            return;
        }
        f57959b = true;
        View inflate = LayoutInflater.from(context).inflate(i2, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.ksad_message_toast_txt)).setText(str);
        Toast toast = new Toast(context.getApplicationContext());
        toast.setGravity(17, 0, 0);
        toast.setDuration(0);
        toast.setView(inflate);
        toast.show();
        a.postDelayed(new Runnable() { // from class: com.kwad.sdk.utils.u.1
            @Override // java.lang.Runnable
            public void run() {
                boolean unused = u.f57959b = false;
            }
        }, j2);
    }

    public static void b(Context context, String str, int i2) {
        a(context, str, i2, 800L);
    }
}
