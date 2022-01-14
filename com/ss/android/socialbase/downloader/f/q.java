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
    public final String f60052b;

    /* renamed from: c  reason: collision with root package name */
    public final String f60053c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f60054d;

    /* renamed from: e  reason: collision with root package name */
    public final List<m> f60055e;

    /* renamed from: f  reason: collision with root package name */
    public int f60056f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60057g;

    /* renamed from: h  reason: collision with root package name */
    public int f60058h;

    /* renamed from: i  reason: collision with root package name */
    public String f60059i;

    /* renamed from: j  reason: collision with root package name */
    public final AtomicLong f60060j;

    public q(String str, boolean z) {
        this.f60055e = new ArrayList();
        this.f60060j = new AtomicLong();
        this.a = str;
        this.f60054d = z;
        this.f60052b = null;
        this.f60053c = null;
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
        if (this.f60059i == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append("_");
            String str = this.f60052b;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append("_");
            sb.append(this.f60054d);
            this.f60059i = sb.toString();
        }
        return this.f60059i;
    }

    public synchronized void b(m mVar) {
        try {
            this.f60055e.remove(mVar);
        } catch (Throwable unused) {
        }
    }

    public synchronized void c() {
        this.f60057g = false;
    }

    public synchronized boolean d() {
        return this.f60057g;
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
        if (this.f60058h == 0) {
            this.f60058h = e().hashCode();
        }
        return this.f60058h;
    }

    public String toString() {
        return "UrlRecord{url='" + this.a + ExtendedMessageFormat.QUOTE + ", ip='" + this.f60052b + ExtendedMessageFormat.QUOTE + ", ipFamily='" + this.f60053c + ExtendedMessageFormat.QUOTE + ", isMainUrl=" + this.f60054d + ", failedTimes=" + this.f60056f + ", isCurrentFailed=" + this.f60057g + ExtendedMessageFormat.END_FE;
    }

    public synchronized void b() {
        this.f60056f++;
        this.f60057g = true;
    }

    public synchronized void a(m mVar) {
        this.f60055e.add(mVar);
    }

    public q(String str, String str2) {
        this.f60055e = new ArrayList();
        this.f60060j = new AtomicLong();
        this.a = str;
        this.f60054d = false;
        this.f60052b = str2;
        this.f60053c = a(str2);
    }

    public synchronized int a() {
        return this.f60055e.size();
    }

    public void a(long j2) {
        this.f60060j.addAndGet(j2);
    }
}
