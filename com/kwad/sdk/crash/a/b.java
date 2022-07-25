package com.kwad.sdk.crash.a;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public final class b {
    public Set<String> ahi = new HashSet();
    public Set<String> ahj = new HashSet();

    public final synchronized void a(String[] strArr, String[] strArr2) {
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str)) {
                            this.ahi.add(str);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (strArr2 != null && strArr2.length > 0) {
            for (String str2 : strArr2) {
                if (!TextUtils.isEmpty(str2)) {
                    this.ahj.add(str2);
                }
            }
        }
    }

    public final synchronized String[] wB() {
        return (String[]) this.ahj.toArray(new String[this.ahj.size()]);
    }

    public final synchronized String[] wM() {
        return (String[]) this.ahi.toArray(new String[this.ahi.size()]);
    }
}
