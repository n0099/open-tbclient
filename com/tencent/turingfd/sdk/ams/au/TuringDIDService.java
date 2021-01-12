package com.tencent.turingfd.sdk.ams.au;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.SparseArray;
import java.util.Map;
/* loaded from: classes3.dex */
public class TuringDIDService {

    /* loaded from: classes3.dex */
    public static final class a implements r {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ x f13456a;

        public a(x xVar) {
            this.f13456a = xVar;
        }

        @Override // com.tencent.turingfd.sdk.ams.au.r
        public int a() {
            return ((ap) this.f13456a).d;
        }

        @Override // com.tencent.turingfd.sdk.ams.au.r
        public String b() {
            return ((ap) this.f13456a).f;
        }

        @Override // com.tencent.turingfd.sdk.ams.au.r
        public String c() {
            return ((ap) this.f13456a).g;
        }
    }

    /* loaded from: classes3.dex */
    public static class aa {

        /* loaded from: classes3.dex */
        public static class bb implements ServiceConnection {
            @Override // android.content.ServiceConnection
            public native void onServiceConnected(ComponentName componentName, IBinder iBinder);

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
            }
        }

        public static native SparseArray<Object> a(SparseArray<Object> sparseArray, Context context, Map<String, String> map, int i);

        public static native SparseArray<Object> b(SparseArray<Object> sparseArray, byte[] bArr, int i);

        public static native SparseArray<Object> c(SparseArray<Object> sparseArray, Context context);

        public static native SparseArray<Object> d(SparseArray<Object> sparseArray);

        public static native SparseArray<Object> e(SparseArray<Object> sparseArray, Context context, Map<String, String> map, int i);

        public static native SparseArray<Object> f(SparseArray<Object> sparseArray, byte[] bArr, int i);
    }

    public static r a(Context context) {
        int a2 = bg.a();
        return a(a2 != 0 ? ap.a(a2) : an.f13475a.a(context, true));
    }

    public static r a(x xVar) {
        return new a(xVar);
    }

    public static void a(t tVar) {
        bg.a(tVar);
    }

    public static r b(Context context) {
        ap a2;
        int a3 = bg.a();
        if (a3 != 0) {
            a2 = ap.a(a3);
        } else {
            an anVar = an.f13475a;
            a2 = anVar.a(context);
            int a4 = anVar.a(a2);
            if (a4 != 1) {
                if (a4 == 2) {
                    anVar.a();
                    a2 = ap.a(-10009);
                } else if (a4 == 3) {
                    anVar.a();
                }
            }
        }
        return a(a2);
    }
}
