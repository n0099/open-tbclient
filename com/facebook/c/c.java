package com.facebook.c;

import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class c {
    public static final c kfs = new c("UNKNOWN", null);
    private final String kft;
    private final String mName;

    /* loaded from: classes2.dex */
    public interface a {
        int getHeaderSize();

        @Nullable
        c l(byte[] bArr, int i);
    }

    public c(String str, @Nullable String str2) {
        this.mName = str;
        this.kft = str2;
    }

    public String toString() {
        return getName();
    }

    public String getName() {
        return this.mName;
    }
}
