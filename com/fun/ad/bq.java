package com.fun.ad;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes15.dex */
public final class bq {

    /* renamed from: a  reason: collision with root package name */
    public static ExecutorService f8074a = Executors.newSingleThreadExecutor();

    /* renamed from: b  reason: collision with root package name */
    public static ExecutorService f8075b = Executors.newSingleThreadExecutor();
    public static a pKo;

    /* loaded from: classes15.dex */
    public interface a {
    }

    public static String a(Context context, String str) {
        if (d.f) {
            try {
                String string = context.getSharedPreferences("fun_ad_sdk", 0).getString("key_ad_online_config", null);
                if (!TextUtils.isEmpty(string)) {
                    return m.a(string, str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            InputStream open = context.getAssets().open(str + ".json");
            String a2 = m.a(open);
            open.close();
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            return m.a(a2, str);
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static void a(Context context, bf bfVar) {
        f8074a.execute(new bi(context, bfVar));
        f8075b.execute(new bn(context));
    }

    public static void a(Context context, String str, String str2, String str3) {
        bf bfVar = new bf();
        bfVar.f8067b = "ac";
        bfVar.c = str;
        bfVar.d = str2;
        bfVar.e = str3;
        a(context, bfVar);
    }

    public static void j(Context context, String str, String str2, String str3) {
        bf bfVar = new bf();
        bfVar.f8067b = "as";
        bfVar.c = str;
        bfVar.d = str2;
        bfVar.e = str3;
        a(context, bfVar);
    }

    public static void k(Context context, String str, String str2, String str3) {
        bf bfVar = new bf();
        bfVar.f8067b = "ao";
        bfVar.c = str;
        bfVar.d = str2;
        bfVar.e = str3;
        a(context, bfVar);
    }
}
