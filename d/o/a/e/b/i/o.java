package d.o.a.e.b.i;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public final String f67306a;

    /* renamed from: b  reason: collision with root package name */
    public final String f67307b;

    /* renamed from: c  reason: collision with root package name */
    public final String f67308c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f67309d;

    /* renamed from: e  reason: collision with root package name */
    public final List<l> f67310e;

    /* renamed from: f  reason: collision with root package name */
    public int f67311f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67312g;

    /* renamed from: h  reason: collision with root package name */
    public int f67313h;

    /* renamed from: i  reason: collision with root package name */
    public String f67314i;
    public final AtomicLong j;

    public o(String str, boolean z) {
        this.f67310e = new ArrayList();
        this.j = new AtomicLong();
        this.f67306a = str;
        this.f67309d = z;
        this.f67307b = null;
        this.f67308c = null;
    }

    public synchronized int a() {
        return this.f67310e.size();
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
        this.f67310e.add(lVar);
    }

    public synchronized void e() {
        this.f67311f++;
        this.f67312g = true;
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
            this.f67310e.remove(lVar);
        } catch (Throwable unused) {
        }
    }

    public synchronized void g() {
        this.f67312g = false;
    }

    public synchronized boolean h() {
        return this.f67312g;
    }

    public int hashCode() {
        if (this.f67313h == 0) {
            this.f67313h = i().hashCode();
        }
        return this.f67313h;
    }

    public final String i() {
        if (this.f67314i == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f67306a);
            sb.append("_");
            String str = this.f67307b;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append("_");
            sb.append(this.f67309d);
            this.f67314i = sb.toString();
        }
        return this.f67314i;
    }

    public String toString() {
        return "UrlRecord{url='" + this.f67306a + "', ip='" + this.f67307b + "', ipFamily='" + this.f67308c + "', isMainUrl=" + this.f67309d + ", failedTimes=" + this.f67311f + ", isCurrentFailed=" + this.f67312g + '}';
    }

    public o(String str, String str2) {
        this.f67310e = new ArrayList();
        this.j = new AtomicLong();
        this.f67306a = str;
        this.f67309d = false;
        this.f67307b = str2;
        this.f67308c = b(str2);
    }
}
