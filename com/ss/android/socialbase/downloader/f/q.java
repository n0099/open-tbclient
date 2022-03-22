package com.ss.android.socialbase.downloader.f;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public class q {
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final String f43326b;

    /* renamed from: c  reason: collision with root package name */
    public final String f43327c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f43328d;

    /* renamed from: e  reason: collision with root package name */
    public final List<m> f43329e;

    /* renamed from: f  reason: collision with root package name */
    public int f43330f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f43331g;

    /* renamed from: h  reason: collision with root package name */
    public int f43332h;
    public String i;
    public final AtomicLong j;

    public q(String str, boolean z) {
        this.f43329e = new ArrayList();
        this.j = new AtomicLong();
        this.a = str;
        this.f43328d = z;
        this.f43326b = null;
        this.f43327c = null;
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int lastIndexOf = str.lastIndexOf(".");
            if (lastIndexOf <= 0 || lastIndexOf >= str.length()) {
                return null;
            }
            return str.substring(0, lastIndexOf);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private String e() {
        if (this.i == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append("_");
            String str = this.f43326b;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append("_");
            sb.append(this.f43328d);
            this.i = sb.toString();
        }
        return this.i;
    }

    public synchronized void b(m mVar) {
        try {
            this.f43329e.remove(mVar);
        } catch (Throwable unused) {
        }
    }

    public synchronized void c() {
        this.f43331g = false;
    }

    public synchronized boolean d() {
        return this.f43331g;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            return e().equals(((q) obj).e());
        }
        return false;
    }

    public int hashCode() {
        if (this.f43332h == 0) {
            this.f43332h = e().hashCode();
        }
        return this.f43332h;
    }

    public String toString() {
        return "UrlRecord{url='" + this.a + "', ip='" + this.f43326b + "', ipFamily='" + this.f43327c + "', isMainUrl=" + this.f43328d + ", failedTimes=" + this.f43330f + ", isCurrentFailed=" + this.f43331g + '}';
    }

    public synchronized void b() {
        this.f43330f++;
        this.f43331g = true;
    }

    public synchronized void a(m mVar) {
        this.f43329e.add(mVar);
    }

    public q(String str, String str2) {
        this.f43329e = new ArrayList();
        this.j = new AtomicLong();
        this.a = str;
        this.f43328d = false;
        this.f43326b = str2;
        this.f43327c = a(str2);
    }

    public synchronized int a() {
        return this.f43329e.size();
    }

    public void a(long j) {
        this.j.addAndGet(j);
    }
}
