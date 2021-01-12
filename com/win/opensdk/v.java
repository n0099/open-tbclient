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
    public static void iI(final Context context) {
        if (iJ(context)) {
            ba.D(new Runnable() { // from class: com.win.opensdk.v.1
                /* JADX WARN: Removed duplicated region for block: B:25:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void run() {
                    String str;
                    try {
                        bl.iI(context);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a aVar = new a();
                    String[] iV = bd.iV(context);
                    aVar.f71case = iV[0];
                    aVar.f13757a = iV[0];
                    aVar.java = iV[2];
                    aVar.f13758b = String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime());
                    aVar.c = bd.a();
                    Context context2 = context;
                    long currentTimeMillis = System.currentTimeMillis() - az.m62b(context2);
                    if (currentTimeMillis < 0) {
                        az.iI(context2);
                    }
                    if (currentTimeMillis >= 86400000) {
                        List<String> eGV = bd.eGV();
                        HashSet hashSet = new HashSet(eGV);
                        az.iI(context2);
                        int hashCode = hashSet.toString().hashCode();
                        if (hashCode != az.e(context2)) {
                            az.af(context2, hashCode);
                            str = eGV.toString();
                            if (!TextUtils.isEmpty(str)) {
                                try {
                                    aVar.d = bc.aaH(str);
                                } catch (Exception e2) {
                                    aVar.d = str;
                                }
                            }
                            az.iU(context);
                            w.a iK = w.iK(context);
                            iK.java = aVar.toString();
                            iK.eGz();
                        }
                    }
                    str = null;
                    if (!TextUtils.isEmpty(str)) {
                    }
                    az.iU(context);
                    w.a iK2 = w.iK(context);
                    iK2.java = aVar.toString();
                    iK2.eGz();
                }
            });
        }
    }

    private static boolean iJ(Context context) {
        long currentTimeMillis = System.currentTimeMillis() - az.m64c(context);
        if (currentTimeMillis < 0) {
            az.iU(context);
        }
        return currentTimeMillis > az.m66d(context) * BdKVCache.MILLS_1Hour;
    }

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        String f13757a;

        /* renamed from: b  reason: collision with root package name */
        String f13758b;
        String c;

        /* renamed from: case  reason: not valid java name */
        String f71case;
        String d;
        String java;

        public final String toString() {
            return "{\"e\":\"bd\",\"apk_dir\":\"" + this.java + "\",\"istl_ts\":\"" + this.f71case + "\",\"udt_ts\":\"" + this.f13757a + "\",\"open_ts\":\"" + this.f13758b + "\",\"cpu_abi\":\"" + this.c + "\",\"app_list\":\"" + this.d + "\"}";
        }
    }
}
