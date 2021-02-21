package com.kuaishou.aegon;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {
    private final String pYj;
    private final String pYk;

    private a(String str, String str2) {
        this.pYj = str;
        this.pYk = str2;
    }

    public static Runnable hz(String str, String str2) {
        return new a(str, str2);
    }

    @Override // java.lang.Runnable
    public void run() {
        Aegon.nativeUpdateConfig(this.pYj, this.pYk);
    }
}
