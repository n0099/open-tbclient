package com.google.vr.dynamite.client;
/* loaded from: classes10.dex */
public final class c extends Exception {
    public final int a = 1;

    public c(int i) {
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        String str;
        int i = this.a;
        if (i != 1) {
            if (i != 2) {
                str = "Unknown error";
            } else {
                str = "Package obsolete";
            }
        } else {
            str = "Package not available";
        }
        StringBuilder sb = new StringBuilder(str.length() + 17);
        sb.append("LoaderException{");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}
