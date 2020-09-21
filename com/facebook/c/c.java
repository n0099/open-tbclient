package com.facebook.c;

import com.baidu.android.util.devices.RomUtils;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class c {
    public static final c nCw = new c(RomUtils.UNKNOWN, null);
    private final String mName;
    private final String nCx;

    /* loaded from: classes12.dex */
    public interface a {
        int getHeaderSize();

        @Nullable
        c n(byte[] bArr, int i);
    }

    public c(String str, @Nullable String str2) {
        this.mName = str;
        this.nCx = str2;
    }

    public String toString() {
        return getName();
    }

    public String getName() {
        return this.mName;
    }
}
