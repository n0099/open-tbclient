package com.kuaishou.aegon;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {
    private final String pXJ;
    private final String pXK;

    private a(String str, String str2) {
        this.pXJ = str;
        this.pXK = str2;
    }

    public static Runnable hx(String str, String str2) {
        return new a(str, str2);
    }

    @Override // java.lang.Runnable
    public void run() {
        Aegon.nativeUpdateConfig(this.pXJ, this.pXK);
    }
}
