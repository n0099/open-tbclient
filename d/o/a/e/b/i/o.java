package d.o.a.e.b.i;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public final String f67071a;

    /* renamed from: b  reason: collision with root package name */
    public final String f67072b;

    /* renamed from: c  reason: collision with root package name */
    public final String f67073c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f67074d;

    /* renamed from: e  reason: collision with root package name */
    public final List<l> f67075e;

    /* renamed from: f  reason: collision with root package name */
    public int f67076f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67077g;

    /* renamed from: h  reason: collision with root package name */
    public int f67078h;
    public String i;
    public final AtomicLong j;

    public o(String str, boolean z) {
        this.f67075e = new ArrayList();
        this.j = new AtomicLong();
        this.f67071a = str;
        this.f67074d = z;
        this.f67072b = null;
        this.f67073c = null;
    }

    public synchronized int a() {
        return this.f67075e.size();
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
        this.f67075e.add(lVar);
    }

    public synchronized void e() {
        this.f67076f++;
        this.f67077g = true;
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
            this.f67075e.remove(lVar);
        } catch (Throwable unused) {
        }
    }

    public synchronized void g() {
        this.f67077g = false;
    }

    public synchronized boolean h() {
        return this.f67077g;
    }

    public int hashCode() {
        if (this.f67078h == 0) {
            this.f67078h = i().hashCode();
        }
        return this.f67078h;
    }

    public final String i() {
        if (this.i == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f67071a);
            sb.append("_");
            String str = this.f67072b;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append("_");
            sb.append(this.f67074d);
            this.i = sb.toString();
        }
        return this.i;
    }

    public String toString() {
        return "UrlRecord{url='" + this.f67071a + "', ip='" + this.f67072b + "', ipFamily='" + this.f67073c + "', isMainUrl=" + this.f67074d + ", failedTimes=" + this.f67076f + ", isCurrentFailed=" + this.f67077g + '}';
    }

    public o(String str, String str2) {
        this.f67075e = new ArrayList();
        this.j = new AtomicLong();
        this.f67071a = str;
        this.f67074d = false;
        this.f67072b = str2;
        this.f67073c = b(str2);
    }
}
