package com.qq.e.comm.plugin.w.a;

import android.content.Context;
import android.util.Pair;
import com.qq.e.comm.plugin.w.a.d;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes4.dex */
public class h {
    static int a(Context context, d.a aVar, String str, String str2, boolean z) {
        return gdtadv.getIresult(5, 1, context, aVar, str, str2, Boolean.valueOf(z));
    }

    public static String a(String str) {
        return (String) gdtadv.getobjresult(6, 1, str);
    }

    static String a(String str, d.a aVar, d.e eVar, d.b bVar) {
        return (String) gdtadv.getobjresult(7, 1, str, aVar, eVar, bVar);
    }

    static <T> void a(T t, Context context, d.a aVar, d.b bVar, d.e eVar, boolean z) {
        gdtadv.getVresult(8, 1, t, context, aVar, bVar, eVar, Boolean.valueOf(z));
    }

    static <T> void a(T t, Context context, d.a aVar, d.b bVar, d.e eVar, boolean z, boolean z2) {
        gdtadv.getVresult(9, 1, t, context, aVar, bVar, eVar, Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    private static boolean a(d.a aVar, d.b bVar, d.e eVar, String str) {
        return gdtadv.getZresult(10, 1, aVar, bVar, eVar, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> boolean a(T t, Context context, d.a aVar, d.b bVar, d.e eVar) {
        return gdtadv.getZresult(11, 1, t, context, aVar, bVar, eVar);
    }

    private static Pair<String, String> b(String str, d.a aVar, d.e eVar, d.b bVar) {
        return (Pair) gdtadv.getobjresult(12, 1, str, aVar, eVar, bVar);
    }

    private static String b(String str) {
        return (String) gdtadv.getobjresult(13, 1, str);
    }
}
