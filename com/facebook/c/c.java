package com.facebook.c;

import com.baidu.android.util.devices.RomUtils;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class c {
    public static final c lOR = new c(RomUtils.UNKNOWN, null);
    private final String lOS;
    private final String mName;

    /* loaded from: classes12.dex */
    public interface a {
        int getHeaderSize();

        @Nullable
        c p(byte[] bArr, int i);
    }

    public c(String str, @Nullable String str2) {
        this.mName = str;
        this.lOS = str2;
    }

    public String toString() {
        return getName();
    }

    public String getName() {
        return this.mName;
    }
}
