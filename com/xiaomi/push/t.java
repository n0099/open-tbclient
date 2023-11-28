package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import java.util.Collection;
/* loaded from: classes2.dex */
public class t {

    /* loaded from: classes2.dex */
    public static class a {
        public final String a;

        /* renamed from: a  reason: collision with other field name */
        public final StringBuilder f1009a;
        public final String b;

        public a() {
            this(":", ",");
        }

        public a(String str, String str2) {
            this.f1009a = new StringBuilder();
            this.a = str;
            this.b = str2;
        }

        public a a(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                if (this.f1009a.length() > 0) {
                    this.f1009a.append(this.b);
                }
                StringBuilder sb = this.f1009a;
                sb.append(str);
                sb.append(this.a);
                sb.append(obj);
            }
            return this;
        }

        public String toString() {
            return this.f1009a.toString();
        }
    }

    public static int a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i;
        }
    }

    public static boolean a() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static boolean a(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return Build.VERSION.SDK_INT >= 20 ? powerManager != null && powerManager.isInteractive() : powerManager != null && powerManager.isScreenOn();
    }

    public static boolean a(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static int b(String str, int i) {
        return !TextUtils.isEmpty(str) ? ((str.hashCode() / 10) * 10) + i : i;
    }
}
