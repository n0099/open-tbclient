package com.kwad.sdk.crash.b;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes10.dex */
public final class b {
    public Set<String> aEN = new HashSet();
    public Set<String> aEO = new HashSet();

    public final synchronized String[] Gn() {
        return (String[]) this.aEO.toArray(new String[this.aEO.size()]);
    }

    public final synchronized String[] Gz() {
        return (String[]) this.aEN.toArray(new String[this.aEN.size()]);
    }

    public final synchronized void a(String[] strArr, String[] strArr2) {
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str)) {
                            this.aEN.add(str);
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
                    this.aEO.add(str2);
                }
            }
        }
    }
}
