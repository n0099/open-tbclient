package com.facebook.c;

import com.baidu.android.util.devices.RomUtils;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c {
    public static final c muf = new c(RomUtils.UNKNOWN, null);
    private final String mName;
    private final String mug;

    /* loaded from: classes13.dex */
    public interface a {
        int getHeaderSize();

        @Nullable
        c o(byte[] bArr, int i);
    }

    public c(String str, @Nullable String str2) {
        this.mName = str;
        this.mug = str2;
    }

    public String toString() {
        return getName();
    }

    public String getName() {
        return this.mName;
    }
}
