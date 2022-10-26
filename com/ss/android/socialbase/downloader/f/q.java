package com.ss.android.socialbase.downloader.f;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes8.dex */
public class q {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final List e;
    public int f;
    public boolean g;
    public int h;
    public String i;
    public final AtomicLong j;

    public q(String str, String str2) {
        this.e = new ArrayList();
        this.j = new AtomicLong();
        this.a = str;
        this.d = false;
        this.b = str2;
        this.c = a(str2);
    }

    public q(String str, boolean z) {
        this.e = new ArrayList();
        this.j = new AtomicLong();
        this.a = str;
        this.d = z;
        this.b = null;
        this.c = null;
    }

    private String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                int lastIndexOf = str.lastIndexOf(".");
                if (lastIndexOf > 0 && lastIndexOf < str.length()) {
                    return str.substring(0, lastIndexOf);
                }
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public synchronized void b(m mVar) {
        try {
            this.e.remove(mVar);
        } catch (Throwable unused) {
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        return e().equals(((q) obj).e());
    }

    private String e() {
        if (this.i == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append("_");
            String str = this.b;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append("_");
            sb.append(this.d);
            this.i = sb.toString();
        }
        return this.i;
    }

    public synchronized int a() {
        return this.e.size();
    }

    public synchronized void b() {
        this.f++;
        this.g = true;
    }

    public synchronized void c() {
        this.g = false;
    }

    public synchronized boolean d() {
        return this.g;
    }

    public int hashCode() {
        if (this.h == 0) {
            this.h = e().hashCode();
        }
        return this.h;
    }

    public void a(long j) {
        this.j.addAndGet(j);
    }

    public synchronized void a(m mVar) {
        this.e.add(mVar);
    }

    public String toString() {
        return "UrlRecord{url='" + this.a + "', ip='" + this.b + "', ipFamily='" + this.c + "', isMainUrl=" + this.d + ", failedTimes=" + this.f + ", isCurrentFailed=" + this.g + '}';
    }
}
