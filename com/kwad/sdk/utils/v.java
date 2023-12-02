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
/* loaded from: classes10.dex */
public final class v {
    public static Handler fS = new Handler(Looper.getMainLooper());
    public static volatile boolean HD = false;

    public static void O(Context context, String str) {
        b(context, str, R.layout.obfuscated_res_0x7f0d04b9);
    }

    public static void a(Context context, String str, int i, long j) {
        if (!com.kwad.framework.a.a.adt.booleanValue() || HD) {
            return;
        }
        HD = true;
        View inflate = com.kwad.sdk.m.l.inflate(context, i, null);
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0913d7)).setText(str);
        Toast toast = new Toast(context.getApplicationContext());
        toast.setGravity(17, 0, 0);
        toast.setDuration(0);
        toast.setView(inflate);
        toast.show();
        fS.postDelayed(new Runnable() { // from class: com.kwad.sdk.utils.v.1
            @Override // java.lang.Runnable
            public final void run() {
                v.access$002(false);
            }
        }, j);
    }

    public static /* synthetic */ boolean access$002(boolean z) {
        HD = false;
        return false;
    }

    public static void b(Context context, String str, int i) {
        a(context, str, i, 800L);
    }

    public static void c(Context context, String str, long j) {
        a(context, str, R.layout.obfuscated_res_0x7f0d04b9, 0L);
    }

    public static void d(Context context, String str, long j) {
        a(context, str, R.layout.obfuscated_res_0x7f0d051e, 0L);
    }

    public static void c(Context context, String str, int i) {
        if (!com.kwad.framework.a.a.adt.booleanValue()) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d04b8, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0913d7)).setText(str);
        Toast toast = new Toast(context);
        toast.setGravity(17, 0, 0);
        toast.setDuration(0);
        toast.setView(inflate);
        toast.show();
    }
}
