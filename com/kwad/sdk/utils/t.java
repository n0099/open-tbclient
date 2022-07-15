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
import com.kwad.sdk.api.loader.Wrapper;
/* loaded from: classes5.dex */
public final class t {
    public static Handler a = new Handler(Looper.getMainLooper());
    public static volatile boolean b = false;

    public static void a(Context context, String str) {
        b(context, str, (int) R.layout.obfuscated_res_0x7f0d040b);
    }

    public static void a(Context context, String str, int i) {
        if (com.kwad.b.kwai.a.d.booleanValue()) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d040a, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091093)).setText(str);
            Toast toast = new Toast(context);
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.setView(inflate);
            toast.show();
        }
    }

    public static void a(Context context, String str, int i, long j) {
        if (com.kwad.b.kwai.a.d.booleanValue() && !b) {
            b = true;
            View inflate = Wrapper.wrapInflaterIfNeed(LayoutInflater.from(context)).inflate(i, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091093)).setText(str);
            Toast toast = new Toast(context.getApplicationContext());
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.setView(inflate);
            toast.show();
            a.postDelayed(new Runnable() { // from class: com.kwad.sdk.utils.t.1
                @Override // java.lang.Runnable
                public final void run() {
                    boolean unused = t.b = false;
                }
            }, j);
        }
    }

    public static void a(Context context, String str, long j) {
        a(context, str, R.layout.obfuscated_res_0x7f0d040b, 0L);
    }

    public static void b(Context context, String str, int i) {
        a(context, str, i, 800L);
    }

    public static void b(Context context, String str, long j) {
        a(context, str, R.layout.obfuscated_res_0x7f0d046e, 0L);
    }
}
