package com.kwad.sdk.crash.b;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Set<String> f35079a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f35080b = new HashSet();

    public synchronized void a(String[] strArr, String[] strArr2) {
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str)) {
                            this.f35079a.add(str);
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
                    this.f35080b.add(str2);
                }
            }
        }
    }

    public synchronized String[] a() {
        return (String[]) this.f35079a.toArray(new String[this.f35079a.size()]);
    }

    public synchronized String[] b() {
        return (String[]) this.f35080b.toArray(new String[this.f35080b.size()]);
    }
}
