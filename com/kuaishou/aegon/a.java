package com.kuaishou.aegon;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final /* synthetic */ class a implements Runnable {
    private final String pNF;
    private final String pNG;

    private a(String str, String str2) {
        this.pNF = str;
        this.pNG = str2;
    }

    public static Runnable hq(String str, String str2) {
        return new a(str, str2);
    }

    @Override // java.lang.Runnable
    public void run() {
        Aegon.nativeUpdateConfig(this.pNF, this.pNG);
    }
}
