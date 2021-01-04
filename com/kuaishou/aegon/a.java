package com.kuaishou.aegon;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final /* synthetic */ class a implements Runnable {
    private final String pQw;
    private final String pQx;

    private a(String str, String str2) {
        this.pQw = str;
        this.pQx = str2;
    }

    public static Runnable hq(String str, String str2) {
        return new a(str, str2);
    }

    @Override // java.lang.Runnable
    public void run() {
        Aegon.nativeUpdateConfig(this.pQw, this.pQx);
    }
}
