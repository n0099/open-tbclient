package com.kuaishou.aegon;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final /* synthetic */ class a implements Runnable {
    private final String pSe;
    private final String pSf;

    private a(String str, String str2) {
        this.pSe = str;
        this.pSf = str2;
    }

    public static Runnable hr(String str, String str2) {
        return new a(str, str2);
    }

    @Override // java.lang.Runnable
    public void run() {
        Aegon.nativeUpdateConfig(this.pSe, this.pSf);
    }
}
