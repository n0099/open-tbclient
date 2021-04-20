package com.kwad.sdk.crash.b;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Set<String> f34720a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f34721b = new HashSet();

    public synchronized void a(String[] strArr, String[] strArr2) {
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str)) {
                            this.f34720a.add(str);
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
                    this.f34721b.add(str2);
                }
            }
        }
    }

    public synchronized String[] a() {
        return (String[]) this.f34720a.toArray(new String[this.f34720a.size()]);
    }

    public synchronized String[] b() {
        return (String[]) this.f34721b.toArray(new String[this.f34721b.size()]);
    }
}
