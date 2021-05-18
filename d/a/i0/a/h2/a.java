package d.a.i0.a.h2;

import android.annotation.SuppressLint;
/* loaded from: classes3.dex */
public final class a implements b {
    public static a a() {
        return new a();
    }

    @Override // d.a.i0.a.h2.b
    @SuppressLint({"BDSoLoader", "UnsafeDynamicallyLoadedCode"})
    public void load(String str) {
        System.load(str);
    }

    @Override // d.a.i0.a.h2.b
    @SuppressLint({"BDSoLoader"})
    public void loadLibrary(String str) {
        System.loadLibrary(str);
    }
}
