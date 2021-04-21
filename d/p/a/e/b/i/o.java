package d.p.a.e.b.i;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public final String f68211a;

    /* renamed from: b  reason: collision with root package name */
    public final String f68212b;

    /* renamed from: c  reason: collision with root package name */
    public final String f68213c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f68214d;

    /* renamed from: e  reason: collision with root package name */
    public final List<l> f68215e;

    /* renamed from: f  reason: collision with root package name */
    public int f68216f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68217g;

    /* renamed from: h  reason: collision with root package name */
    public int f68218h;
    public String i;
    public final AtomicLong j;

    public o(String str, boolean z) {
        this.f68215e = new ArrayList();
        this.j = new AtomicLong();
        this.f68211a = str;
        this.f68214d = z;
        this.f68212b = null;
        this.f68213c = null;
    }

    public synchronized int a() {
        return this.f68215e.size();
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
        this.f68215e.add(lVar);
    }

    public synchronized void e() {
        this.f68216f++;
        this.f68217g = true;
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
            this.f68215e.remove(lVar);
        } catch (Throwable unused) {
        }
    }

    public synchronized void g() {
        this.f68217g = false;
    }

    public synchronized boolean h() {
        return this.f68217g;
    }

    public int hashCode() {
        if (this.f68218h == 0) {
            this.f68218h = i().hashCode();
        }
        return this.f68218h;
    }

    public final String i() {
        if (this.i == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f68211a);
            sb.append("_");
            String str = this.f68212b;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append("_");
            sb.append(this.f68214d);
            this.i = sb.toString();
        }
        return this.i;
    }

    public String toString() {
        return "UrlRecord{url='" + this.f68211a + "', ip='" + this.f68212b + "', ipFamily='" + this.f68213c + "', isMainUrl=" + this.f68214d + ", failedTimes=" + this.f68216f + ", isCurrentFailed=" + this.f68217g + '}';
    }

    public o(String str, String str2) {
        this.f68215e = new ArrayList();
        this.j = new AtomicLong();
        this.f68211a = str;
        this.f68214d = false;
        this.f68212b = str2;
        this.f68213c = b(str2);
    }
}
