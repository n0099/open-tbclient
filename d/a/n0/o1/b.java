package d.a.n0.o1;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import d.a.c.e.i.a;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
/* loaded from: classes3.dex */
public class b implements d.a.c.e.i.b {
    public static b n;

    /* renamed from: b  reason: collision with root package name */
    public Context f57794b;

    /* renamed from: d  reason: collision with root package name */
    public LocationManager f57796d;

    /* renamed from: h  reason: collision with root package name */
    public int f57800h;

    /* renamed from: a  reason: collision with root package name */
    public f f57793a = null;

    /* renamed from: c  reason: collision with root package name */
    public a.d f57795c = null;

    /* renamed from: e  reason: collision with root package name */
    public Address f57797e = null;

    /* renamed from: f  reason: collision with root package name */
    public long f57798f = 0;

    /* renamed from: g  reason: collision with root package name */
    public Handler f57799g = null;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57801i = false;
    public Runnable j = null;
    public Runnable k = null;
    public final LocationListener l = new a();
    public final LocationListener m = new C1451b();

    /* loaded from: classes3.dex */
    public class a implements LocationListener {
        public a() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (b.this.f57799g.hasMessages(0)) {
                b.this.f57799g.removeMessages(0);
            }
            b.this.f57799g.removeCallbacks(b.this.k);
            b.this.f57799g.removeCallbacks(b.this.j);
            if (b.this.f57793a != null) {
                return;
            }
            b.this.f57793a = new f(b.this, null);
            b.this.f57793a.setSelfExecute(true);
            b.this.f57793a.execute(location);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i2, Bundle bundle) {
        }
    }

    /* renamed from: d.a.n0.o1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1451b implements LocationListener {
        public C1451b() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (b.this.f57799g.hasMessages(0)) {
                b.this.f57799g.removeMessages(0);
            }
            b.this.f57799g.removeCallbacks(b.this.k);
            b.this.f57799g.removeCallbacks(b.this.j);
            if (b.this.f57793a != null) {
                return;
            }
            b.this.f57793a = new f(b.this, null);
            b.this.f57793a.setSelfExecute(true);
            b.this.f57793a.execute(location);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i2, Bundle bundle) {
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f57796d == null || !PermissionUtil.checkLocationForGoogle(b.this.f57794b)) {
                return;
            }
            try {
                b.this.f57796d.requestLocationUpdates("network", 10000L, 100.0f, b.this.l);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f57796d == null || !PermissionUtil.checkLocationForGoogle(b.this.f57794b)) {
                return;
            }
            try {
                b.this.f57796d.requestLocationUpdates("gps", 10000L, 100.0f, b.this.m);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Handler.Callback {
        public e() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b.this.c();
            b.this.f57795c.a(b.this.f57800h, "", null, b.this.f57798f, b.this.f57801i);
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class f extends BdAsyncTask<Location, Void, Address> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Address doInBackground(Location... locationArr) {
            List<Address> list;
            Geocoder geocoder = new Geocoder(b.this.f57794b, Locale.getDefault());
            if (locationArr != null && locationArr.length >= 1) {
                Location location = locationArr[0];
                try {
                    list = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                } catch (IOException | IllegalArgumentException unused) {
                    list = null;
                }
                if (list != null && list.size() > 0) {
                    Address address = list.get(0);
                    StringBuffer stringBuffer = new StringBuffer();
                    if (address.getSubLocality() == null || address.getThoroughfare() == null) {
                        stringBuffer.append(address.getLocality());
                    }
                    stringBuffer.append(address.getSubLocality());
                    stringBuffer.append(address.getThoroughfare());
                    address.setAddressLine(0, stringBuffer.toString());
                    return address;
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Address address) {
            super.onPostExecute(address);
            b.this.f57793a = null;
            if (address != null) {
                b.this.c();
                b.this.f57798f = System.currentTimeMillis();
                b.this.f57797e = address;
                b.this.f57795c.a(0, "", b.this.f57797e, b.this.f57798f, b.this.f57801i);
                d.a.n0.t2.g0.a.e().i(String.valueOf(address.getLatitude()));
                d.a.n0.t2.g0.a.e().j(String.valueOf(address.getLongitude()));
                d.a.n0.t2.g0.a.e().k(System.currentTimeMillis());
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            b.this.f57793a = null;
        }

        public /* synthetic */ f(b bVar, a aVar) {
            this();
        }
    }

    public static b t() {
        if (n == null) {
            synchronized (b.class) {
                if (n == null) {
                    n = new b();
                }
            }
        }
        return n;
    }

    @Override // d.a.c.e.i.b
    public void a(boolean z) {
        LocationManager locationManager;
        if (this.f57795c == null || (locationManager = this.f57796d) == null) {
            return;
        }
        try {
            try {
                locationManager.removeUpdates(this.l);
                this.f57800h = 4;
                this.f57801i = z;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                c();
                this.f57800h = 5;
            }
            if (PermissionUtil.checkLocationForGoogle(this.f57794b) && (this.f57796d.isProviderEnabled("gps") || this.f57796d.isProviderEnabled("network"))) {
                if (PermissionUtil.checkLocationForGoogle(this.f57794b) && this.f57796d.isProviderEnabled("gps")) {
                    this.f57799g.post(this.k);
                } else {
                    this.f57800h = 1;
                }
                if (!z) {
                    if (PermissionUtil.checkLocationForGoogle(this.f57794b) && this.f57796d.isProviderEnabled("network")) {
                        this.f57799g.post(this.j);
                    } else {
                        this.f57800h = 2;
                    }
                }
                return;
            }
            this.f57800h = 3;
            this.f57799g.sendMessageDelayed(this.f57799g.obtainMessage(0), d.a.c.e.i.a.l().m());
        } finally {
            Handler handler = this.f57799g;
            handler.sendMessageDelayed(handler.obtainMessage(0), d.a.c.e.i.a.l().m());
        }
    }

    @Override // d.a.c.e.i.b
    public void b(a.d dVar) {
        Context context = TbadkCoreApplication.getInst().getContext();
        this.f57794b = context;
        this.f57795c = dVar;
        try {
            this.f57796d = (LocationManager) context.getSystemService("location");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        this.j = new c();
        this.k = new d();
        u();
    }

    @Override // d.a.c.e.i.b
    public void c() {
        if (this.f57799g.hasMessages(0)) {
            this.f57799g.removeMessages(0);
        }
        this.f57799g.removeCallbacks(this.k);
        this.f57799g.removeCallbacks(this.j);
        LocationManager locationManager = this.f57796d;
        if (locationManager != null) {
            try {
                locationManager.removeUpdates(this.l);
                this.f57796d.removeUpdates(this.m);
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
        f fVar = this.f57793a;
        if (fVar != null) {
            fVar.cancel();
            this.f57793a = null;
        }
    }

    @Override // d.a.c.e.i.b
    public void destroy() {
        if (this.f57799g.hasMessages(0)) {
            this.f57799g.removeMessages(0);
        }
        this.f57799g.removeCallbacks(this.k);
        this.f57799g.removeCallbacks(this.j);
        LocationManager locationManager = this.f57796d;
        if (locationManager != null) {
            try {
                locationManager.removeUpdates(this.l);
                this.f57796d.removeUpdates(this.m);
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
        f fVar = this.f57793a;
        if (fVar != null) {
            fVar.cancel();
            this.f57793a = null;
        }
    }

    public final void u() {
        this.f57799g = new Handler(Looper.getMainLooper(), new e());
    }
}
