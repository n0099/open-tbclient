package com.facebook.c;

import com.baidu.android.util.devices.RomUtils;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c {
    public static final c lYW = new c(RomUtils.UNKNOWN, null);
    private final String lYX;
    private final String mName;

    /* loaded from: classes13.dex */
    public interface a {
        int getHeaderSize();

        @Nullable
        c n(byte[] bArr, int i);
    }

    public c(String str, @Nullable String str2) {
        this.mName = str;
        this.lYX = str2;
    }

    public String toString() {
        return getName();
    }

    public String getName() {
        return this.mName;
    }
}
