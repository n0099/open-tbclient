package com.kwad.sdk.crash.b;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Set<String> f9627a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private Set<String> f9628b = new HashSet();

    public synchronized void a(String[] strArr, String[] strArr2) {
        synchronized (this) {
            if (strArr != null) {
                if (strArr.length > 0) {
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str)) {
                            this.f9627a.add(str);
                        }
                    }
                }
            }
            if (strArr2 != null && strArr2.length > 0) {
                for (String str2 : strArr2) {
                    if (!TextUtils.isEmpty(str2)) {
                        this.f9628b.add(str2);
                    }
                }
            }
        }
    }

    public synchronized String[] a() {
        return (String[]) this.f9627a.toArray(new String[this.f9627a.size()]);
    }

    public synchronized String[] b() {
        return (String[]) this.f9628b.toArray(new String[this.f9628b.size()]);
    }
}
