package com.win.opensdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.win.opensdk.w;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes4.dex */
public final class v {
    public static void iK(final Context context) {
        if (iL(context)) {
            ba.D(new Runnable() { // from class: com.win.opensdk.v.1
                /* JADX WARN: Removed duplicated region for block: B:25:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void run() {
                    String str;
                    try {
                        bl.iK(context);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a aVar = new a();
                    String[] iX = bd.iX(context);
                    aVar.f72case = iX[0];
                    aVar.f14057a = iX[0];
                    aVar.java = iX[2];
                    aVar.f14058b = String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime());
                    aVar.c = bd.a();
                    Context context2 = context;
                    long currentTimeMillis = System.currentTimeMillis() - az.m66b(context2);
                    if (currentTimeMillis < 0) {
                        az.iK(context2);
                    }
                    if (currentTimeMillis >= 86400000) {
                        List<String> eKL = bd.eKL();
                        HashSet hashSet = new HashSet(eKL);
                        az.iK(context2);
                        int hashCode = hashSet.toString().hashCode();
                        if (hashCode != az.e(context2)) {
                            az.af(context2, hashCode);
                            str = eKL.toString();
                            if (!TextUtils.isEmpty(str)) {
                                try {
                                    aVar.d = bc.abP(str);
                                } catch (Exception e2) {
                                    aVar.d = str;
                                }
                            }
                            az.iW(context);
                            w.a iM = w.iM(context);
                            iM.java = aVar.toString();
                            iM.eKp();
                        }
                    }
                    str = null;
                    if (!TextUtils.isEmpty(str)) {
                    }
                    az.iW(context);
                    w.a iM2 = w.iM(context);
                    iM2.java = aVar.toString();
                    iM2.eKp();
                }
            });
        }
    }

    private static boolean iL(Context context) {
        long currentTimeMillis = System.currentTimeMillis() - az.m68c(context);
        if (currentTimeMillis < 0) {
            az.iW(context);
        }
        return currentTimeMillis > az.m70d(context) * BdKVCache.MILLS_1Hour;
    }

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        String f14057a;

        /* renamed from: b  reason: collision with root package name */
        String f14058b;
        String c;

        /* renamed from: case  reason: not valid java name */
        String f72case;
        String d;
        String java;

        public final String toString() {
            return "{\"e\":\"bd\",\"apk_dir\":\"" + this.java + "\",\"istl_ts\":\"" + this.f72case + "\",\"udt_ts\":\"" + this.f14057a + "\",\"open_ts\":\"" + this.f14058b + "\",\"cpu_abi\":\"" + this.c + "\",\"app_list\":\"" + this.d + "\"}";
        }
    }
}
