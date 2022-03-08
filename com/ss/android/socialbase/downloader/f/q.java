package com.ss.android.socialbase.downloader.f;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes8.dex */
public class q {
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final String f58614b;

    /* renamed from: c  reason: collision with root package name */
    public final String f58615c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f58616d;

    /* renamed from: e  reason: collision with root package name */
    public final List<m> f58617e;

    /* renamed from: f  reason: collision with root package name */
    public int f58618f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58619g;

    /* renamed from: h  reason: collision with root package name */
    public int f58620h;

    /* renamed from: i  reason: collision with root package name */
    public String f58621i;

    /* renamed from: j  reason: collision with root package name */
    public final AtomicLong f58622j;

    public q(String str, boolean z) {
        this.f58617e = new ArrayList();
        this.f58622j = new AtomicLong();
        this.a = str;
        this.f58616d = z;
        this.f58614b = null;
        this.f58615c = null;
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
        if (this.f58621i == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append("_");
            String str = this.f58614b;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append("_");
            sb.append(this.f58616d);
            this.f58621i = sb.toString();
        }
        return this.f58621i;
    }

    public synchronized void b(m mVar) {
        try {
            this.f58617e.remove(mVar);
        } catch (Throwable unused) {
        }
    }

    public synchronized void c() {
        this.f58619g = false;
    }

    public synchronized boolean d() {
        return this.f58619g;
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
        if (this.f58620h == 0) {
            this.f58620h = e().hashCode();
        }
        return this.f58620h;
    }

    public String toString() {
        return "UrlRecord{url='" + this.a + ExtendedMessageFormat.QUOTE + ", ip='" + this.f58614b + ExtendedMessageFormat.QUOTE + ", ipFamily='" + this.f58615c + ExtendedMessageFormat.QUOTE + ", isMainUrl=" + this.f58616d + ", failedTimes=" + this.f58618f + ", isCurrentFailed=" + this.f58619g + ExtendedMessageFormat.END_FE;
    }

    public synchronized void b() {
        this.f58618f++;
        this.f58619g = true;
    }

    public synchronized void a(m mVar) {
        this.f58617e.add(mVar);
    }

    public q(String str, String str2) {
        this.f58617e = new ArrayList();
        this.f58622j = new AtomicLong();
        this.a = str;
        this.f58616d = false;
        this.f58614b = str2;
        this.f58615c = a(str2);
    }

    public synchronized int a() {
        return this.f58617e.size();
    }

    public void a(long j2) {
        this.f58622j.addAndGet(j2);
    }
}
