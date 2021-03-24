package com.kuaishou.aegon;
/* loaded from: classes6.dex */
public final /* synthetic */ class Aegon$$Lambda$15 implements Runnable {
    public final String arg$1;
    public final String arg$2;

    public Aegon$$Lambda$15(String str, String str2) {
        this.arg$1 = str;
        this.arg$2 = str2;
    }

    public static Runnable lambdaFactory$(String str, String str2) {
        return new Aegon$$Lambda$15(str, str2);
    }

    @Override // java.lang.Runnable
    public void run() {
        Aegon.nativeAddExtraRequestHeader(this.arg$1, this.arg$2);
    }
}
