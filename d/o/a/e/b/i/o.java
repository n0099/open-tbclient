package d.o.a.e.b.i;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public final String f67066a;

    /* renamed from: b  reason: collision with root package name */
    public final String f67067b;

    /* renamed from: c  reason: collision with root package name */
    public final String f67068c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f67069d;

    /* renamed from: e  reason: collision with root package name */
    public final List<l> f67070e;

    /* renamed from: f  reason: collision with root package name */
    public int f67071f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67072g;

    /* renamed from: h  reason: collision with root package name */
    public int f67073h;
    public String i;
    public final AtomicLong j;

    public o(String str, boolean z) {
        this.f67070e = new ArrayList();
        this.j = new AtomicLong();
        this.f67066a = str;
        this.f67069d = z;
        this.f67067b = null;
        this.f67068c = null;
    }

    public synchronized int a() {
        return this.f67070e.size();
    }

    public final String b(String str) {
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

    public void c(long j) {
        this.j.addAndGet(j);
    }

    public synchronized void d(l lVar) {
        this.f67070e.add(lVar);
    }

    public synchronized void e() {
        this.f67071f++;
        this.f67072g = true;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o) {
            return i().equals(((o) obj).i());
        }
        return false;
    }

    public synchronized void f(l lVar) {
        try {
            this.f67070e.remove(lVar);
        } catch (Throwable unused) {
        }
    }

    public synchronized void g() {
        this.f67072g = false;
    }

    public synchronized boolean h() {
        return this.f67072g;
    }

    public int hashCode() {
        if (this.f67073h == 0) {
            this.f67073h = i().hashCode();
        }
        return this.f67073h;
    }

    public final String i() {
        if (this.i == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f67066a);
            sb.append("_");
            String str = this.f67067b;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append("_");
            sb.append(this.f67069d);
            this.i = sb.toString();
        }
        return this.i;
    }

    public String toString() {
        return "UrlRecord{url='" + this.f67066a + "', ip='" + this.f67067b + "', ipFamily='" + this.f67068c + "', isMainUrl=" + this.f67069d + ", failedTimes=" + this.f67071f + ", isCurrentFailed=" + this.f67072g + '}';
    }

    public o(String str, String str2) {
        this.f67070e = new ArrayList();
        this.j = new AtomicLong();
        this.f67066a = str;
        this.f67069d = false;
        this.f67067b = str2;
        this.f67068c = b(str2);
    }
}
