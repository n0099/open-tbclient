package d.o.a.e.b.i;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public final String f71092a;

    /* renamed from: b  reason: collision with root package name */
    public final String f71093b;

    /* renamed from: c  reason: collision with root package name */
    public final String f71094c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f71095d;

    /* renamed from: e  reason: collision with root package name */
    public final List<l> f71096e;

    /* renamed from: f  reason: collision with root package name */
    public int f71097f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f71098g;

    /* renamed from: h  reason: collision with root package name */
    public int f71099h;

    /* renamed from: i  reason: collision with root package name */
    public String f71100i;
    public final AtomicLong j;

    public o(String str, boolean z) {
        this.f71096e = new ArrayList();
        this.j = new AtomicLong();
        this.f71092a = str;
        this.f71095d = z;
        this.f71093b = null;
        this.f71094c = null;
    }

    public synchronized int a() {
        return this.f71096e.size();
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
        this.f71096e.add(lVar);
    }

    public synchronized void e() {
        this.f71097f++;
        this.f71098g = true;
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
            this.f71096e.remove(lVar);
        } catch (Throwable unused) {
        }
    }

    public synchronized void g() {
        this.f71098g = false;
    }

    public synchronized boolean h() {
        return this.f71098g;
    }

    public int hashCode() {
        if (this.f71099h == 0) {
            this.f71099h = i().hashCode();
        }
        return this.f71099h;
    }

    public final String i() {
        if (this.f71100i == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f71092a);
            sb.append("_");
            String str = this.f71093b;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append("_");
            sb.append(this.f71095d);
            this.f71100i = sb.toString();
        }
        return this.f71100i;
    }

    public String toString() {
        return "UrlRecord{url='" + this.f71092a + "', ip='" + this.f71093b + "', ipFamily='" + this.f71094c + "', isMainUrl=" + this.f71095d + ", failedTimes=" + this.f71097f + ", isCurrentFailed=" + this.f71098g + '}';
    }

    public o(String str, String str2) {
        this.f71096e = new ArrayList();
        this.j = new AtomicLong();
        this.f71092a = str;
        this.f71095d = false;
        this.f71093b = str2;
        this.f71094c = b(str2);
    }
}
