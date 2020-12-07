package com.google.vr.dynamite.client;
/* loaded from: classes17.dex */
public final class c extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private final int f4054a = 1;

    public c(int i) {
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        String str;
        switch (this.f4054a) {
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
