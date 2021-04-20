package com.google.vr.dynamite.client;
/* loaded from: classes6.dex */
public final class c extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public final int f31308a = 1;

    public c(int i) {
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        int i = this.f31308a;
        String str = i != 1 ? i != 2 ? "Unknown error" : "Package obsolete" : "Package not available";
        StringBuilder sb = new StringBuilder(str.length() + 17);
        sb.append("LoaderException{");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}
