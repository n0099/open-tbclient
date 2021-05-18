package d.o.a.e.b.i;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public final String f67263a;

    /* renamed from: b  reason: collision with root package name */
    public final String f67264b;

    /* renamed from: c  reason: collision with root package name */
    public final String f67265c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f67266d;

    /* renamed from: e  reason: collision with root package name */
    public final List<l> f67267e;

    /* renamed from: f  reason: collision with root package name */
    public int f67268f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67269g;

    /* renamed from: h  reason: collision with root package name */
    public int f67270h;

    /* renamed from: i  reason: collision with root package name */
    public String f67271i;
    public final AtomicLong j;

    public o(String str, boolean z) {
        this.f67267e = new ArrayList();
        this.j = new AtomicLong();
        this.f67263a = str;
        this.f67266d = z;
        this.f67264b = null;
        this.f67265c = null;
    }

    public synchronized int a() {
        return this.f67267e.size();
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
        this.f67267e.add(lVar);
    }

    public synchronized void e() {
        this.f67268f++;
        this.f67269g = true;
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
            this.f67267e.remove(lVar);
        } catch (Throwable unused) {
        }
    }

    public synchronized void g() {
        this.f67269g = false;
    }

    public synchronized boolean h() {
        return this.f67269g;
    }

    public int hashCode() {
        if (this.f67270h == 0) {
            this.f67270h = i().hashCode();
        }
        return this.f67270h;
    }

    public final String i() {
        if (this.f67271i == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f67263a);
            sb.append("_");
            String str = this.f67264b;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append("_");
            sb.append(this.f67266d);
            this.f67271i = sb.toString();
        }
        return this.f67271i;
    }

    public String toString() {
        return "UrlRecord{url='" + this.f67263a + "', ip='" + this.f67264b + "', ipFamily='" + this.f67265c + "', isMainUrl=" + this.f67266d + ", failedTimes=" + this.f67268f + ", isCurrentFailed=" + this.f67269g + '}';
    }

    public o(String str, String str2) {
        this.f67267e = new ArrayList();
        this.j = new AtomicLong();
        this.f67263a = str;
        this.f67266d = false;
        this.f67264b = str2;
        this.f67265c = b(str2);
    }
}
