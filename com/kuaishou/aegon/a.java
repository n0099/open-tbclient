package com.kuaishou.aegon;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {
    private final String pYX;
    private final String pYY;

    private a(String str, String str2) {
        this.pYX = str;
        this.pYY = str2;
    }

    public static Runnable hz(String str, String str2) {
        return new a(str, str2);
    }

    @Override // java.lang.Runnable
    public void run() {
        Aegon.nativeUpdateConfig(this.pYX, this.pYY);
    }
}
