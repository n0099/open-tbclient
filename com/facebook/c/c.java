package com.facebook.c;

import com.baidu.searchbox.ng.ai.apps.util.AiAppRomUtils;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class c {
    public static final c idJ = new c(AiAppRomUtils.UNKNOWN, null);
    private final String idK;
    private final String mName;

    /* loaded from: classes2.dex */
    public interface a {
        int getHeaderSize();

        @Nullable
        c j(byte[] bArr, int i);
    }

    public c(String str, @Nullable String str2) {
        this.mName = str;
        this.idK = str2;
    }

    public String toString() {
        return getName();
    }

    public String getName() {
        return this.mName;
    }
}
