package com.google.vr.dynamite.client;
/* loaded from: classes6.dex */
public final class c extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public final int f32270a = 1;

    public c(int i2) {
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        int i2 = this.f32270a;
        String str = i2 != 1 ? i2 != 2 ? "Unknown error" : "Package obsolete" : "Package not available";
        StringBuilder sb = new StringBuilder(str.length() + 17);
        sb.append("LoaderException{");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}
