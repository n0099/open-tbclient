package d.o.a.e.b.i;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public final String f68064a;

    /* renamed from: b  reason: collision with root package name */
    public final String f68065b;

    /* renamed from: c  reason: collision with root package name */
    public final String f68066c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f68067d;

    /* renamed from: e  reason: collision with root package name */
    public final List<l> f68068e;

    /* renamed from: f  reason: collision with root package name */
    public int f68069f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68070g;

    /* renamed from: h  reason: collision with root package name */
    public int f68071h;
    public String i;
    public final AtomicLong j;

    public o(String str, boolean z) {
        this.f68068e = new ArrayList();
        this.j = new AtomicLong();
        this.f68064a = str;
        this.f68067d = z;
        this.f68065b = null;
        this.f68066c = null;
    }

    public synchronized int a() {
        return this.f68068e.size();
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
        this.f68068e.add(lVar);
    }

    public synchronized void e() {
        this.f68069f++;
        this.f68070g = true;
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
            this.f68068e.remove(lVar);
        } catch (Throwable unused) {
        }
    }

    public synchronized void g() {
        this.f68070g = false;
    }

    public synchronized boolean h() {
        return this.f68070g;
    }

    public int hashCode() {
        if (this.f68071h == 0) {
            this.f68071h = i().hashCode();
        }
        return this.f68071h;
    }

    public final String i() {
        if (this.i == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f68064a);
            sb.append("_");
            String str = this.f68065b;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append("_");
            sb.append(this.f68067d);
            this.i = sb.toString();
        }
        return this.i;
    }

    public String toString() {
        return "UrlRecord{url='" + this.f68064a + "', ip='" + this.f68065b + "', ipFamily='" + this.f68066c + "', isMainUrl=" + this.f68067d + ", failedTimes=" + this.f68069f + ", isCurrentFailed=" + this.f68070g + '}';
    }

    public o(String str, String str2) {
        this.f68068e = new ArrayList();
        this.j = new AtomicLong();
        this.f68064a = str;
        this.f68067d = false;
        this.f68065b = str2;
        this.f68066c = b(str2);
    }
}
