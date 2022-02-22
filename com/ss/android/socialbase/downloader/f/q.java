package com.ss.android.socialbase.downloader.f;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes4.dex */
public class q {
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final String f60264b;

    /* renamed from: c  reason: collision with root package name */
    public final String f60265c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f60266d;

    /* renamed from: e  reason: collision with root package name */
    public final List<m> f60267e;

    /* renamed from: f  reason: collision with root package name */
    public int f60268f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60269g;

    /* renamed from: h  reason: collision with root package name */
    public int f60270h;

    /* renamed from: i  reason: collision with root package name */
    public String f60271i;

    /* renamed from: j  reason: collision with root package name */
    public final AtomicLong f60272j;

    public q(String str, boolean z) {
        this.f60267e = new ArrayList();
        this.f60272j = new AtomicLong();
        this.a = str;
        this.f60266d = z;
        this.f60264b = null;
        this.f60265c = null;
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
        if (this.f60271i == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append("_");
            String str = this.f60264b;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append("_");
            sb.append(this.f60266d);
            this.f60271i = sb.toString();
        }
        return this.f60271i;
    }

    public synchronized void b(m mVar) {
        try {
            this.f60267e.remove(mVar);
        } catch (Throwable unused) {
        }
    }

    public synchronized void c() {
        this.f60269g = false;
    }

    public synchronized boolean d() {
        return this.f60269g;
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
        if (this.f60270h == 0) {
            this.f60270h = e().hashCode();
        }
        return this.f60270h;
    }

    public String toString() {
        return "UrlRecord{url='" + this.a + ExtendedMessageFormat.QUOTE + ", ip='" + this.f60264b + ExtendedMessageFormat.QUOTE + ", ipFamily='" + this.f60265c + ExtendedMessageFormat.QUOTE + ", isMainUrl=" + this.f60266d + ", failedTimes=" + this.f60268f + ", isCurrentFailed=" + this.f60269g + ExtendedMessageFormat.END_FE;
    }

    public synchronized void b() {
        this.f60268f++;
        this.f60269g = true;
    }

    public synchronized void a(m mVar) {
        this.f60267e.add(mVar);
    }

    public q(String str, String str2) {
        this.f60267e = new ArrayList();
        this.f60272j = new AtomicLong();
        this.a = str;
        this.f60266d = false;
        this.f60264b = str2;
        this.f60265c = a(str2);
    }

    public synchronized int a() {
        return this.f60267e.size();
    }

    public void a(long j2) {
        this.f60272j.addAndGet(j2);
    }
}
