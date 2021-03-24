package com.kuaishou.aegon;
/* loaded from: classes6.dex */
public final /* synthetic */ class Aegon$$Lambda$5 implements Runnable {
    public final String arg$1;
    public final String[] arg$2;

    public Aegon$$Lambda$5(String str, String[] strArr) {
        this.arg$1 = str;
        this.arg$2 = strArr;
    }

    public static Runnable lambdaFactory$(String str, String[] strArr) {
        return new Aegon$$Lambda$5(str, strArr);
    }

    @Override // java.lang.Runnable
    public void run() {
        Aegon.nativeSetPreconnectUrls(this.arg$1, this.arg$2);
    }
}
