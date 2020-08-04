package com.facebook.c;

import com.baidu.android.util.devices.RomUtils;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class c {
    public static final c mYr = new c(RomUtils.UNKNOWN, null);
    private final String mName;
    private final String mYs;

    /* loaded from: classes3.dex */
    public interface a {
        int getHeaderSize();

        @Nullable
        c o(byte[] bArr, int i);
    }

    public c(String str, @Nullable String str2) {
        this.mName = str;
        this.mYs = str2;
    }

    public String toString() {
        return getName();
    }

    public String getName() {
        return this.mName;
    }
}
