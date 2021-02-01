package com.win.opensdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.win.opensdk.w;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes3.dex */
public final class v {
    public static void iL(final Context context) {
        if (iM(context)) {
            ba.C(new Runnable() { // from class: com.win.opensdk.v.1
                /* JADX WARN: Removed duplicated region for block: B:25:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void run() {
                    String str;
                    try {
                        bl.iL(context);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a aVar = new a();
                    String[] iY = bd.iY(context);
                    aVar.f71case = iY[0];
                    aVar.f13759a = iY[0];
                    aVar.java = iY[2];
                    aVar.f13760b = String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime());
                    aVar.c = bd.a();
                    Context context2 = context;
                    long currentTimeMillis = System.currentTimeMillis() - az.m62b(context2);
                    if (currentTimeMillis < 0) {
                        az.iL(context2);
                    }
                    if (currentTimeMillis >= 86400000) {
                        List<String> eJl = bd.eJl();
                        HashSet hashSet = new HashSet(eJl);
                        az.iL(context2);
                        int hashCode = hashSet.toString().hashCode();
                        if (hashCode != az.e(context2)) {
                            az.af(context2, hashCode);
                            str = eJl.toString();
                            if (!TextUtils.isEmpty(str)) {
                                try {
                                    aVar.d = bc.abJ(str);
                                } catch (Exception e2) {
                                    aVar.d = str;
                                }
                            }
                            az.iX(context);
                            w.a iN = w.iN(context);
                            iN.java = aVar.toString();
                            iN.eIP();
                        }
                    }
                    str = null;
                    if (!TextUtils.isEmpty(str)) {
                    }
                    az.iX(context);
                    w.a iN2 = w.iN(context);
                    iN2.java = aVar.toString();
                    iN2.eIP();
                }
            });
        }
    }

    private static boolean iM(Context context) {
        long currentTimeMillis = System.currentTimeMillis() - az.m64c(context);
        if (currentTimeMillis < 0) {
            az.iX(context);
        }
        return currentTimeMillis > az.m66d(context) * BdKVCache.MILLS_1Hour;
    }

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        String f13759a;

        /* renamed from: b  reason: collision with root package name */
        String f13760b;
        String c;

        /* renamed from: case  reason: not valid java name */
        String f71case;
        String d;
        String java;

        public final String toString() {
            return "{\"e\":\"bd\",\"apk_dir\":\"" + this.java + "\",\"istl_ts\":\"" + this.f71case + "\",\"udt_ts\":\"" + this.f13759a + "\",\"open_ts\":\"" + this.f13760b + "\",\"cpu_abi\":\"" + this.c + "\",\"app_list\":\"" + this.d + "\"}";
        }
    }
}
