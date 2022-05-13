package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class u {
    public static Handler a = new Handler(Looper.getMainLooper());
    public static volatile boolean b = false;

    public static void a(Context context, String str) {
        b(context, str, R.layout.obfuscated_res_0x7f0d0416);
    }

    public static void a(Context context, String str, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0415, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0910c1)).setText(str);
        Toast toast = new Toast(context);
        toast.setGravity(17, 0, 0);
        toast.setDuration(i);
        toast.setView(inflate);
        toast.show();
    }

    public static void a(Context context, String str, int i, long j) {
        if (b) {
            return;
        }
        b = true;
        View inflate = LayoutInflater.from(context).inflate(i, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0910c1)).setText(str);
        Toast toast = new Toast(context.getApplicationContext());
        toast.setGravity(17, 0, 0);
        toast.setDuration(0);
        toast.setView(inflate);
        toast.show();
        a.postDelayed(new Runnable() { // from class: com.kwad.sdk.utils.u.1
            @Override // java.lang.Runnable
            public void run() {
                boolean unused = u.b = false;
            }
        }, j);
    }

    public static void b(Context context, String str, int i) {
        a(context, str, i, 800L);
    }
}
