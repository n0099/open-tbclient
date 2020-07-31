package com.google.vr.dynamite.client;
/* loaded from: classes5.dex */
public final class c extends Exception {
    private final int a = 1;

    public c(int i) {
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        String str;
        switch (this.a) {
            case 1:
                str = "Package not available";
                break;
            case 2:
                str = "Package obsolete";
                break;
            default:
                str = "Unknown error";
                break;
        }
        return new StringBuilder(String.valueOf(str).length() + 17).append("LoaderException{").append(str).append("}").toString();
    }
}
