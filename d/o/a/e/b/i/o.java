package d.o.a.e.b.i;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public final String f66577a;

    /* renamed from: b  reason: collision with root package name */
    public final String f66578b;

    /* renamed from: c  reason: collision with root package name */
    public final String f66579c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f66580d;

    /* renamed from: e  reason: collision with root package name */
    public final List<l> f66581e;

    /* renamed from: f  reason: collision with root package name */
    public int f66582f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f66583g;

    /* renamed from: h  reason: collision with root package name */
    public int f66584h;

    /* renamed from: i  reason: collision with root package name */
    public String f66585i;
    public final AtomicLong j;

    public o(String str, boolean z) {
        this.f66581e = new ArrayList();
        this.j = new AtomicLong();
        this.f66577a = str;
        this.f66580d = z;
        this.f66578b = null;
        this.f66579c = null;
    }

    public synchronized int a() {
        return this.f66581e.size();
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
        this.f66581e.add(lVar);
    }

    public synchronized void e() {
        this.f66582f++;
        this.f66583g = true;
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
            this.f66581e.remove(lVar);
        } catch (Throwable unused) {
        }
    }

    public synchronized void g() {
        this.f66583g = false;
    }

    public synchronized boolean h() {
        return this.f66583g;
    }

    public int hashCode() {
        if (this.f66584h == 0) {
            this.f66584h = i().hashCode();
        }
        return this.f66584h;
    }

    public final String i() {
        if (this.f66585i == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f66577a);
            sb.append("_");
            String str = this.f66578b;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append("_");
            sb.append(this.f66580d);
            this.f66585i = sb.toString();
        }
        return this.f66585i;
    }

    public String toString() {
        return "UrlRecord{url='" + this.f66577a + "', ip='" + this.f66578b + "', ipFamily='" + this.f66579c + "', isMainUrl=" + this.f66580d + ", failedTimes=" + this.f66582f + ", isCurrentFailed=" + this.f66583g + '}';
    }

    public o(String str, String str2) {
        this.f66581e = new ArrayList();
        this.j = new AtomicLong();
        this.f66577a = str;
        this.f66580d = false;
        this.f66578b = str2;
        this.f66579c = b(str2);
    }
}
