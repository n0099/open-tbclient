package com.qq.e.comm.plugin.t;

import android.annotation.TargetApi;
import android.util.Pair;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import org.json.JSONObject;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes3.dex */
public class e {

    /* loaded from: classes3.dex */
    private static class a extends Exception {
        public a(String str) {
            super(str);
        }

        public a(String str, Throwable th) {
            super(str, th);
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends Exception {
        public b(String str, Throwable th) {
            super(str, th);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      assets/yaqgdtadv0.sec
     */
    /* loaded from: classes3.dex */
    private static class c {
        static byte a() {
            return gdtadv.getBresult(GDiffPatcher.COPY_INT_USHORT, 1, new Object[0]);
        }

        static Pair<Long, byte[]> a(byte[] bArr) throws a {
            return (Pair) gdtadv.getobjresult(GDiffPatcher.COPY_INT_INT, 1, bArr);
        }

        static byte[] a(String str, long j, byte[] bArr) throws a {
            return (byte[]) gdtadv.getobjresult(255, 1, str, Long.valueOf(j), bArr);
        }

        static byte b() {
            return gdtadv.getBresult(256, 1, new Object[0]);
        }

        static byte c() {
            return gdtadv.getBresult(257, 1, new Object[0]);
        }

        static byte d() {
            return gdtadv.getBresult(258, 1, new Object[0]);
        }

        static int e() {
            return gdtadv.getIresult(259, 1, new Object[0]);
        }

        static int f() {
            return gdtadv.getIresult(260, 1, new Object[0]);
        }

        static int g() {
            return gdtadv.getIresult(261, 1, new Object[0]);
        }

        static int h() {
            return gdtadv.getIresult(262, 1, new Object[0]);
        }
    }

    private static String a() {
        return (String) gdtadv.getobjresult(GDiffPatcher.DATA_INT, 1, new Object[0]);
    }

    public static JSONObject a(int i) {
        return (JSONObject) gdtadv.getobjresult(249, 1, Integer.valueOf(i));
    }

    public static byte[] a(byte[] bArr) throws b {
        return (byte[]) gdtadv.getobjresult(250, 1, bArr);
    }

    public static native byte[] a(byte[] bArr, long j);

    private static long b() {
        return gdtadv.getJresult(GDiffPatcher.COPY_USHORT_INT, 1, new Object[0]);
    }

    @TargetApi(9)
    public static byte[] b(byte[] bArr) throws b {
        return (byte[]) gdtadv.getobjresult(GDiffPatcher.COPY_INT_UBYTE, 1, bArr);
    }

    public static native byte[] c(byte[] bArr);
}
