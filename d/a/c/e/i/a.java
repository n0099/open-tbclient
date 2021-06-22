package d.a.c.e.i;

import android.location.Address;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    public static a m;

    /* renamed from: a  reason: collision with root package name */
    public long f42347a = 10000;

    /* renamed from: b  reason: collision with root package name */
    public long f42348b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f42349c = 300000;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42350d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42351e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42352f = false;

    /* renamed from: g  reason: collision with root package name */
    public int f42353g = 4;

    /* renamed from: h  reason: collision with root package name */
    public Address f42354h = null;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<SoftReference<c>> f42355i = null;
    public ArrayList<d.a.c.e.i.b> j = new ArrayList<>();
    public Handler k = null;
    public d l = new C0543a();

    /* renamed from: d.a.c.e.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0543a implements d {
        public C0543a() {
        }

        @Override // d.a.c.e.i.a.d
        public void a(int i2, String str, Address address, long j, boolean z) {
            a aVar = a.this;
            aVar.f42348b = j;
            aVar.f42354h = address;
            a.this.f42350d = z;
            a.this.f42353g = i2;
            a.this.r();
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4 && StringUtils.isNull(str)) {
                            str = BdBaseApplication.getInst().getResources().getString(R.string.location_out_time);
                        }
                    } else if (StringUtils.isNull(str)) {
                        str = BdBaseApplication.getInst().getResources().getString(R.string.location_all_offline);
                    }
                } else if (StringUtils.isNull(str)) {
                    str = BdBaseApplication.getInst().getResources().getString(R.string.location_net_offline);
                }
            } else if (StringUtils.isNull(str)) {
                str = BdBaseApplication.getInst().getResources().getString(R.string.location_gps_offline);
            }
            a.this.f(i2, str, address);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Handler.Callback {
        public b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            String string;
            if (message.what != 0) {
                return false;
            }
            a.this.r();
            int i2 = a.this.f42353g;
            if (i2 == 1) {
                string = BdBaseApplication.getInst().getResources().getString(R.string.location_gps_offline);
            } else if (i2 == 2) {
                string = BdBaseApplication.getInst().getResources().getString(R.string.location_net_offline);
            } else if (i2 == 3) {
                string = BdBaseApplication.getInst().getResources().getString(R.string.location_all_offline);
            } else if (i2 != 4) {
                string = i2 != 6 ? "" : BdBaseApplication.getInst().getResources().getString(R.string.location_out_time);
            } else {
                string = BdBaseApplication.getInst().getResources().getString(R.string.location_out_time);
            }
            a aVar = a.this;
            aVar.f(aVar.f42353g, string, null);
            return false;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void onLocationGeted(int i2, String str, Address address);
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(int i2, String str, Address address, long j, boolean z);
    }

    public static a k() {
        if (m == null) {
            synchronized (a.class) {
                if (m == null) {
                    m = new a();
                }
            }
        }
        return m;
    }

    public final void f(int i2, String str, Address address) {
        c cVar;
        if (this.k.hasMessages(0)) {
            this.k.removeMessages(0);
        }
        ArrayList<SoftReference<c>> arrayList = this.f42355i;
        if (arrayList != null) {
            synchronized (arrayList) {
                for (int i3 = 0; i3 < this.f42355i.size(); i3++) {
                    SoftReference<c> softReference = this.f42355i.get(i3);
                    if (softReference != null && (cVar = softReference.get()) != null) {
                        cVar.onLocationGeted(i2, str, address);
                    }
                }
                this.f42355i.clear();
            }
        }
    }

    public Address g(boolean z) {
        return i(z, false);
    }

    public Address h(boolean z, c cVar) {
        return j(z, false, cVar);
    }

    public Address i(boolean z, boolean z2) {
        if (System.currentTimeMillis() - this.f42348b > this.f42349c) {
            this.f42354h = null;
        }
        if (this.f42354h != null && !z && ((z2 && this.f42350d) || !z2)) {
            return this.f42354h;
        }
        this.f42354h = null;
        boolean z3 = this.f42352f;
        if (!z3) {
            q(z2);
            return null;
        }
        if (z3 && z2 && !this.f42351e) {
            r();
            q(z2);
        }
        return null;
    }

    public Address j(boolean z, boolean z2, c cVar) {
        boolean z3;
        c cVar2;
        if (System.currentTimeMillis() - this.f42348b > this.f42349c) {
            this.f42354h = null;
        }
        if (this.f42354h != null && !z && ((z2 && this.f42350d) || !z2)) {
            if (cVar != null) {
                cVar.onLocationGeted(0, "", this.f42354h);
            }
            return this.f42354h;
        }
        if (cVar != null) {
            synchronized (this.f42355i) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.f42355i.size()) {
                        z3 = false;
                        break;
                    }
                    SoftReference<c> softReference = this.f42355i.get(i2);
                    if (softReference != null && (cVar2 = softReference.get()) != null && cVar2.equals(cVar)) {
                        z3 = true;
                        break;
                    }
                    i2++;
                }
                if (!z3) {
                    if (this.f42355i.size() >= 100) {
                        this.f42355i.remove(0);
                    }
                    this.f42355i.add(new SoftReference<>(cVar));
                }
            }
            boolean z4 = this.f42352f;
            if (!z4) {
                q(z2);
                return null;
            } else if (z4 && z2 && !this.f42351e) {
                r();
                q(z2);
                return null;
            }
        }
        return null;
    }

    public long l() {
        return this.f42347a;
    }

    public final void m() {
        this.k = new Handler(Looper.getMainLooper(), new b());
    }

    public void n() {
        this.f42355i = new ArrayList<>();
        m();
    }

    public void o(d.a.c.e.i.b bVar) {
        if (bVar != null) {
            synchronized (this.j) {
                if (!this.j.contains(bVar)) {
                    bVar.b(this.l);
                    this.j.add(bVar);
                }
            }
        }
    }

    public void p(c cVar) {
        c cVar2;
        synchronized (this.f42355i) {
            int i2 = 0;
            while (true) {
                if (i2 < this.f42355i.size()) {
                    SoftReference<c> softReference = this.f42355i.get(i2);
                    if (softReference != null && (cVar2 = softReference.get()) != null && cVar2.equals(cVar)) {
                        this.f42355i.remove(softReference);
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
        }
    }

    public final void q(boolean z) {
        if (this.k.hasMessages(0)) {
            this.k.removeMessages(0);
        }
        this.f42353g = 4;
        this.f42351e = z;
        this.f42352f = true;
        ArrayList<d.a.c.e.i.b> arrayList = this.j;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<d.a.c.e.i.b> it = this.j.iterator();
            while (it.hasNext()) {
                d.a.c.e.i.b next = it.next();
                if (next != null) {
                    try {
                        next.a(z);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
            Handler handler = this.k;
            handler.sendMessageDelayed(handler.obtainMessage(0), this.f42347a);
            return;
        }
        this.f42353g = 6;
        Handler handler2 = this.k;
        handler2.sendMessage(handler2.obtainMessage(0));
    }

    public void r() {
        if (this.k.hasMessages(0)) {
            this.k.removeMessages(0);
        }
        this.f42352f = false;
        Iterator<d.a.c.e.i.b> it = this.j.iterator();
        while (it.hasNext()) {
            d.a.c.e.i.b next = it.next();
            if (next != null) {
                try {
                    next.c();
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    public void s(d.a.c.e.i.b bVar) {
        if (bVar != null) {
            synchronized (this.j) {
                bVar.destroy();
                this.j.remove(bVar);
            }
        }
    }
}
