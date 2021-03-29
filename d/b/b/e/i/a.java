package d.b.b.e.i;

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
    public long f41750a = 10000;

    /* renamed from: b  reason: collision with root package name */
    public long f41751b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f41752c = 300000;

    /* renamed from: d  reason: collision with root package name */
    public boolean f41753d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f41754e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f41755f = false;

    /* renamed from: g  reason: collision with root package name */
    public int f41756g = 4;

    /* renamed from: h  reason: collision with root package name */
    public Address f41757h = null;
    public ArrayList<SoftReference<c>> i = null;
    public ArrayList<d.b.b.e.i.b> j = new ArrayList<>();
    public Handler k = null;
    public d l = new C0537a();

    /* renamed from: d.b.b.e.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0537a implements d {
        public C0537a() {
        }

        @Override // d.b.b.e.i.a.d
        public void a(int i, String str, Address address, long j, boolean z) {
            a aVar = a.this;
            aVar.f41751b = j;
            aVar.f41757h = address;
            a.this.f41753d = z;
            a.this.f41756g = i;
            a.this.s();
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4 && StringUtils.isNull(str)) {
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
            a.this.g(i, str, address);
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
            a.this.s();
            int i = a.this.f41756g;
            if (i == 1) {
                string = BdBaseApplication.getInst().getResources().getString(R.string.location_gps_offline);
            } else if (i == 2) {
                string = BdBaseApplication.getInst().getResources().getString(R.string.location_net_offline);
            } else if (i == 3) {
                string = BdBaseApplication.getInst().getResources().getString(R.string.location_all_offline);
            } else if (i != 4) {
                string = i != 6 ? "" : BdBaseApplication.getInst().getResources().getString(R.string.location_out_time);
            } else {
                string = BdBaseApplication.getInst().getResources().getString(R.string.location_out_time);
            }
            a aVar = a.this;
            aVar.g(aVar.f41756g, string, null);
            return false;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void onLocationGeted(int i, String str, Address address);
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(int i, String str, Address address, long j, boolean z);
    }

    public static a l() {
        if (m == null) {
            synchronized (a.class) {
                if (m == null) {
                    m = new a();
                }
            }
        }
        return m;
    }

    public final void g(int i, String str, Address address) {
        c cVar;
        if (this.k.hasMessages(0)) {
            this.k.removeMessages(0);
        }
        ArrayList<SoftReference<c>> arrayList = this.i;
        if (arrayList != null) {
            synchronized (arrayList) {
                for (int i2 = 0; i2 < this.i.size(); i2++) {
                    SoftReference<c> softReference = this.i.get(i2);
                    if (softReference != null && (cVar = softReference.get()) != null) {
                        cVar.onLocationGeted(i, str, address);
                    }
                }
                this.i.clear();
            }
        }
    }

    public Address h(boolean z) {
        return j(z, false);
    }

    public Address i(boolean z, c cVar) {
        return k(z, false, cVar);
    }

    public Address j(boolean z, boolean z2) {
        if (System.currentTimeMillis() - this.f41751b > this.f41752c) {
            this.f41757h = null;
        }
        if (this.f41757h != null && !z && ((z2 && this.f41753d) || !z2)) {
            return this.f41757h;
        }
        this.f41757h = null;
        boolean z3 = this.f41755f;
        if (!z3) {
            r(z2);
            return null;
        }
        if (z3 && z2 && !this.f41754e) {
            s();
            r(z2);
        }
        return null;
    }

    public Address k(boolean z, boolean z2, c cVar) {
        boolean z3;
        c cVar2;
        if (System.currentTimeMillis() - this.f41751b > this.f41752c) {
            this.f41757h = null;
        }
        if (this.f41757h != null && !z && ((z2 && this.f41753d) || !z2)) {
            if (cVar != null) {
                cVar.onLocationGeted(0, "", this.f41757h);
            }
            return this.f41757h;
        }
        if (cVar != null) {
            synchronized (this.i) {
                int i = 0;
                while (true) {
                    if (i >= this.i.size()) {
                        z3 = false;
                        break;
                    }
                    SoftReference<c> softReference = this.i.get(i);
                    if (softReference != null && (cVar2 = softReference.get()) != null && cVar2.equals(cVar)) {
                        z3 = true;
                        break;
                    }
                    i++;
                }
                if (!z3) {
                    if (this.i.size() >= 100) {
                        this.i.remove(0);
                    }
                    this.i.add(new SoftReference<>(cVar));
                }
            }
            boolean z4 = this.f41755f;
            if (!z4) {
                r(z2);
                return null;
            } else if (z4 && z2 && !this.f41754e) {
                s();
                r(z2);
                return null;
            }
        }
        return null;
    }

    public long m() {
        return this.f41750a;
    }

    public final void n() {
        this.k = new Handler(Looper.getMainLooper(), new b());
    }

    public void o() {
        this.i = new ArrayList<>();
        n();
    }

    public void p(d.b.b.e.i.b bVar) {
        if (bVar != null) {
            synchronized (this.j) {
                if (!this.j.contains(bVar)) {
                    bVar.a(this.l);
                    this.j.add(bVar);
                }
            }
        }
    }

    public void q(c cVar) {
        c cVar2;
        synchronized (this.i) {
            int i = 0;
            while (true) {
                if (i < this.i.size()) {
                    SoftReference<c> softReference = this.i.get(i);
                    if (softReference != null && (cVar2 = softReference.get()) != null && cVar2.equals(cVar)) {
                        this.i.remove(softReference);
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
        }
    }

    public final void r(boolean z) {
        if (this.k.hasMessages(0)) {
            this.k.removeMessages(0);
        }
        this.f41756g = 4;
        this.f41754e = z;
        this.f41755f = true;
        ArrayList<d.b.b.e.i.b> arrayList = this.j;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<d.b.b.e.i.b> it = this.j.iterator();
            while (it.hasNext()) {
                d.b.b.e.i.b next = it.next();
                if (next != null) {
                    try {
                        next.b(z);
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
            Handler handler = this.k;
            handler.sendMessageDelayed(handler.obtainMessage(0), this.f41750a);
            return;
        }
        this.f41756g = 6;
        Handler handler2 = this.k;
        handler2.sendMessage(handler2.obtainMessage(0));
    }

    public final void s() {
        if (this.k.hasMessages(0)) {
            this.k.removeMessages(0);
        }
        this.f41755f = false;
        Iterator<d.b.b.e.i.b> it = this.j.iterator();
        while (it.hasNext()) {
            d.b.b.e.i.b next = it.next();
            if (next != null) {
                try {
                    next.c();
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    public void t(d.b.b.e.i.b bVar) {
        if (bVar != null) {
            synchronized (this.j) {
                bVar.destroy();
                this.j.remove(bVar);
            }
        }
    }
}
