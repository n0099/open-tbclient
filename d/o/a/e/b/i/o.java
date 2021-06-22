package d.o.a.e.b.i;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public final String f71196a;

    /* renamed from: b  reason: collision with root package name */
    public final String f71197b;

    /* renamed from: c  reason: collision with root package name */
    public final String f71198c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f71199d;

    /* renamed from: e  reason: collision with root package name */
    public final List<l> f71200e;

    /* renamed from: f  reason: collision with root package name */
    public int f71201f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f71202g;

    /* renamed from: h  reason: collision with root package name */
    public int f71203h;

    /* renamed from: i  reason: collision with root package name */
    public String f71204i;
    public final AtomicLong j;

    public o(String str, boolean z) {
        this.f71200e = new ArrayList();
        this.j = new AtomicLong();
        this.f71196a = str;
        this.f71199d = z;
        this.f71197b = null;
        this.f71198c = null;
    }

    public synchronized int a() {
        return this.f71200e.size();
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
        this.f71200e.add(lVar);
    }

    public synchronized void e() {
        this.f71201f++;
        this.f71202g = true;
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
            this.f71200e.remove(lVar);
        } catch (Throwable unused) {
        }
    }

    public synchronized void g() {
        this.f71202g = false;
    }

    public synchronized boolean h() {
        return this.f71202g;
    }

    public int hashCode() {
        if (this.f71203h == 0) {
            this.f71203h = i().hashCode();
        }
        return this.f71203h;
    }

    public final String i() {
        if (this.f71204i == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f71196a);
            sb.append("_");
            String str = this.f71197b;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append("_");
            sb.append(this.f71199d);
            this.f71204i = sb.toString();
        }
        return this.f71204i;
    }

    public String toString() {
        return "UrlRecord{url='" + this.f71196a + "', ip='" + this.f71197b + "', ipFamily='" + this.f71198c + "', isMainUrl=" + this.f71199d + ", failedTimes=" + this.f71201f + ", isCurrentFailed=" + this.f71202g + '}';
    }

    public o(String str, String str2) {
        this.f71200e = new ArrayList();
        this.j = new AtomicLong();
        this.f71196a = str;
        this.f71199d = false;
        this.f71197b = str2;
        this.f71198c = b(str2);
    }
}
