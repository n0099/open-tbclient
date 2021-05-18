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
    public long f38927a = 10000;

    /* renamed from: b  reason: collision with root package name */
    public long f38928b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f38929c = 300000;

    /* renamed from: d  reason: collision with root package name */
    public boolean f38930d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f38931e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f38932f = false;

    /* renamed from: g  reason: collision with root package name */
    public int f38933g = 4;

    /* renamed from: h  reason: collision with root package name */
    public Address f38934h = null;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<SoftReference<c>> f38935i = null;
    public ArrayList<d.a.c.e.i.b> j = new ArrayList<>();
    public Handler k = null;
    public d l = new C0500a();

    /* renamed from: d.a.c.e.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0500a implements d {
        public C0500a() {
        }

        @Override // d.a.c.e.i.a.d
        public void a(int i2, String str, Address address, long j, boolean z) {
            a aVar = a.this;
            aVar.f38928b = j;
            aVar.f38934h = address;
            a.this.f38930d = z;
            a.this.f38933g = i2;
            a.this.s();
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
            a.this.g(i2, str, address);
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
            int i2 = a.this.f38933g;
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
            aVar.g(aVar.f38933g, string, null);
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

    public final void g(int i2, String str, Address address) {
        c cVar;
        if (this.k.hasMessages(0)) {
            this.k.removeMessages(0);
        }
        ArrayList<SoftReference<c>> arrayList = this.f38935i;
        if (arrayList != null) {
            synchronized (arrayList) {
                for (int i3 = 0; i3 < this.f38935i.size(); i3++) {
                    SoftReference<c> softReference = this.f38935i.get(i3);
                    if (softReference != null && (cVar = softReference.get()) != null) {
                        cVar.onLocationGeted(i2, str, address);
                    }
                }
                this.f38935i.clear();
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
        if (System.currentTimeMillis() - this.f38928b > this.f38929c) {
            this.f38934h = null;
        }
        if (this.f38934h != null && !z && ((z2 && this.f38930d) || !z2)) {
            return this.f38934h;
        }
        this.f38934h = null;
        boolean z3 = this.f38932f;
        if (!z3) {
            r(z2);
            return null;
        }
        if (z3 && z2 && !this.f38931e) {
            s();
            r(z2);
        }
        return null;
    }

    public Address k(boolean z, boolean z2, c cVar) {
        boolean z3;
        c cVar2;
        if (System.currentTimeMillis() - this.f38928b > this.f38929c) {
            this.f38934h = null;
        }
        if (this.f38934h != null && !z && ((z2 && this.f38930d) || !z2)) {
            if (cVar != null) {
                cVar.onLocationGeted(0, "", this.f38934h);
            }
            return this.f38934h;
        }
        if (cVar != null) {
            synchronized (this.f38935i) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.f38935i.size()) {
                        z3 = false;
                        break;
                    }
                    SoftReference<c> softReference = this.f38935i.get(i2);
                    if (softReference != null && (cVar2 = softReference.get()) != null && cVar2.equals(cVar)) {
                        z3 = true;
                        break;
                    }
                    i2++;
                }
                if (!z3) {
                    if (this.f38935i.size() >= 100) {
                        this.f38935i.remove(0);
                    }
                    this.f38935i.add(new SoftReference<>(cVar));
                }
            }
            boolean z4 = this.f38932f;
            if (!z4) {
                r(z2);
                return null;
            } else if (z4 && z2 && !this.f38931e) {
                s();
                r(z2);
                return null;
            }
        }
        return null;
    }

    public long m() {
        return this.f38927a;
    }

    public final void n() {
        this.k = new Handler(Looper.getMainLooper(), new b());
    }

    public void o() {
        this.f38935i = new ArrayList<>();
        n();
    }

    public void p(d.a.c.e.i.b bVar) {
        if (bVar != null) {
            synchronized (this.j) {
                if (!this.j.contains(bVar)) {
                    bVar.b(this.l);
                    this.j.add(bVar);
                }
            }
        }
    }

    public void q(c cVar) {
        c cVar2;
        synchronized (this.f38935i) {
            int i2 = 0;
            while (true) {
                if (i2 < this.f38935i.size()) {
                    SoftReference<c> softReference = this.f38935i.get(i2);
                    if (softReference != null && (cVar2 = softReference.get()) != null && cVar2.equals(cVar)) {
                        this.f38935i.remove(softReference);
                        break;
                    }
                    i2++;
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
        this.f38933g = 4;
        this.f38931e = z;
        this.f38932f = true;
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
            handler.sendMessageDelayed(handler.obtainMessage(0), this.f38927a);
            return;
        }
        this.f38933g = 6;
        Handler handler2 = this.k;
        handler2.sendMessage(handler2.obtainMessage(0));
    }

    public final void s() {
        if (this.k.hasMessages(0)) {
            this.k.removeMessages(0);
        }
        this.f38932f = false;
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

    public void t(d.a.c.e.i.b bVar) {
        if (bVar != null) {
            synchronized (this.j) {
                bVar.destroy();
                this.j.remove(bVar);
            }
        }
    }
}
