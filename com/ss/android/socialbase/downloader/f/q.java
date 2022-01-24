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
    public final String f60097b;

    /* renamed from: c  reason: collision with root package name */
    public final String f60098c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f60099d;

    /* renamed from: e  reason: collision with root package name */
    public final List<m> f60100e;

    /* renamed from: f  reason: collision with root package name */
    public int f60101f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60102g;

    /* renamed from: h  reason: collision with root package name */
    public int f60103h;

    /* renamed from: i  reason: collision with root package name */
    public String f60104i;

    /* renamed from: j  reason: collision with root package name */
    public final AtomicLong f60105j;

    public q(String str, boolean z) {
        this.f60100e = new ArrayList();
        this.f60105j = new AtomicLong();
        this.a = str;
        this.f60099d = z;
        this.f60097b = null;
        this.f60098c = null;
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
        if (this.f60104i == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append("_");
            String str = this.f60097b;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append("_");
            sb.append(this.f60099d);
            this.f60104i = sb.toString();
        }
        return this.f60104i;
    }

    public synchronized void b(m mVar) {
        try {
            this.f60100e.remove(mVar);
        } catch (Throwable unused) {
        }
    }

    public synchronized void c() {
        this.f60102g = false;
    }

    public synchronized boolean d() {
        return this.f60102g;
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
        if (this.f60103h == 0) {
            this.f60103h = e().hashCode();
        }
        return this.f60103h;
    }

    public String toString() {
        return "UrlRecord{url='" + this.a + ExtendedMessageFormat.QUOTE + ", ip='" + this.f60097b + ExtendedMessageFormat.QUOTE + ", ipFamily='" + this.f60098c + ExtendedMessageFormat.QUOTE + ", isMainUrl=" + this.f60099d + ", failedTimes=" + this.f60101f + ", isCurrentFailed=" + this.f60102g + ExtendedMessageFormat.END_FE;
    }

    public synchronized void b() {
        this.f60101f++;
        this.f60102g = true;
    }

    public synchronized void a(m mVar) {
        this.f60100e.add(mVar);
    }

    public q(String str, String str2) {
        this.f60100e = new ArrayList();
        this.f60105j = new AtomicLong();
        this.a = str;
        this.f60099d = false;
        this.f60097b = str2;
        this.f60098c = a(str2);
    }

    public synchronized int a() {
        return this.f60100e.size();
    }

    public void a(long j2) {
        this.f60105j.addAndGet(j2);
    }
}
