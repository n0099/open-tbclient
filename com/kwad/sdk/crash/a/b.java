package com.kwad.sdk.crash.a;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class b {
    public Set<String> a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f56714b = new HashSet();

    public synchronized void a(String[] strArr, String[] strArr2) {
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str)) {
                            this.a.add(str);
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
                    this.f56714b.add(str2);
                }
            }
        }
    }

    public synchronized String[] a() {
        return (String[]) this.a.toArray(new String[this.a.size()]);
    }

    public synchronized String[] b() {
        return (String[]) this.f56714b.toArray(new String[this.f56714b.size()]);
    }
}
