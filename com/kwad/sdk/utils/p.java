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
/* loaded from: classes4.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f10828a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f10829b = false;

    public static void a(Context context) {
        a(context, q.c(context));
    }

    public static void a(Context context, String str) {
        a(context, str, R.layout.ksad_content_alliance_toast_2);
    }

    private static void a(Context context, String str, int i) {
        a(context, str, i, 800L);
    }

    private static void a(Context context, String str, int i, long j) {
        if (f10829b) {
            return;
        }
        f10829b = true;
        View inflate = LayoutInflater.from(context).inflate(i, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.ksad_message_toast_txt)).setText(str);
        Toast toast = new Toast(context.getApplicationContext());
        toast.setGravity(17, 0, 0);
        toast.setDuration(0);
        toast.setView(inflate);
        toast.show();
        f10828a.postDelayed(new Runnable() { // from class: com.kwad.sdk.utils.p.1
            @Override // java.lang.Runnable
            public void run() {
                boolean unused = p.f10829b = false;
            }
        }, j);
    }

    public static void a(Context context, String str, long j) {
        a(context, str, R.layout.ksad_content_alliance_toast_2, j);
    }

    public static void b(Context context) {
        a(context, q.f(context));
    }

    public static void c(Context context) {
        a(context, q.b(context));
    }
}
