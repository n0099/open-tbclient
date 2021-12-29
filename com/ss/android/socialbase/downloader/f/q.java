package com.ss.android.socialbase.downloader.f;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes3.dex */
public class q {
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final String f62406b;

    /* renamed from: c  reason: collision with root package name */
    public final String f62407c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f62408d;

    /* renamed from: e  reason: collision with root package name */
    public final List<m> f62409e;

    /* renamed from: f  reason: collision with root package name */
    public int f62410f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f62411g;

    /* renamed from: h  reason: collision with root package name */
    public int f62412h;

    /* renamed from: i  reason: collision with root package name */
    public String f62413i;

    /* renamed from: j  reason: collision with root package name */
    public final AtomicLong f62414j;

    public q(String str, boolean z) {
        this.f62409e = new ArrayList();
        this.f62414j = new AtomicLong();
        this.a = str;
        this.f62408d = z;
        this.f62406b = null;
        this.f62407c = null;
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
        if (this.f62413i == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append("_");
            String str = this.f62406b;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append("_");
            sb.append(this.f62408d);
            this.f62413i = sb.toString();
        }
        return this.f62413i;
    }

    public synchronized void b(m mVar) {
        try {
            this.f62409e.remove(mVar);
        } catch (Throwable unused) {
        }
    }

    public synchronized void c() {
        this.f62411g = false;
    }

    public synchronized boolean d() {
        return this.f62411g;
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
        if (this.f62412h == 0) {
            this.f62412h = e().hashCode();
        }
        return this.f62412h;
    }

    public String toString() {
        return "UrlRecord{url='" + this.a + ExtendedMessageFormat.QUOTE + ", ip='" + this.f62406b + ExtendedMessageFormat.QUOTE + ", ipFamily='" + this.f62407c + ExtendedMessageFormat.QUOTE + ", isMainUrl=" + this.f62408d + ", failedTimes=" + this.f62410f + ", isCurrentFailed=" + this.f62411g + ExtendedMessageFormat.END_FE;
    }

    public synchronized void b() {
        this.f62410f++;
        this.f62411g = true;
    }

    public synchronized void a(m mVar) {
        this.f62409e.add(mVar);
    }

    public q(String str, String str2) {
        this.f62409e = new ArrayList();
        this.f62414j = new AtomicLong();
        this.a = str;
        this.f62408d = false;
        this.f62406b = str2;
        this.f62407c = a(str2);
    }

    public synchronized int a() {
        return this.f62409e.size();
    }

    public void a(long j2) {
        this.f62414j.addAndGet(j2);
    }
}
