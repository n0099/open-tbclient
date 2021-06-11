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
    public Context f61483b;

    /* renamed from: d  reason: collision with root package name */
    public LocationManager f61485d;

    /* renamed from: h  reason: collision with root package name */
    public int f61489h;

    /* renamed from: a  reason: collision with root package name */
    public f f61482a = null;

    /* renamed from: c  reason: collision with root package name */
    public a.d f61484c = null;

    /* renamed from: e  reason: collision with root package name */
    public Address f61486e = null;

    /* renamed from: f  reason: collision with root package name */
    public long f61487f = 0;

    /* renamed from: g  reason: collision with root package name */
    public Handler f61488g = null;

    /* renamed from: i  reason: collision with root package name */
    public boolean f61490i = false;
    public Runnable j = null;
    public Runnable k = null;
    public final LocationListener l = new a();
    public final LocationListener m = new C1507b();

    /* loaded from: classes3.dex */
    public class a implements LocationListener {
        public a() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (b.this.f61488g.hasMessages(0)) {
                b.this.f61488g.removeMessages(0);
            }
            b.this.f61488g.removeCallbacks(b.this.k);
            b.this.f61488g.removeCallbacks(b.this.j);
            if (b.this.f61482a != null) {
                return;
            }
            b.this.f61482a = new f(b.this, null);
            b.this.f61482a.setSelfExecute(true);
            b.this.f61482a.execute(location);
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
    public class C1507b implements LocationListener {
        public C1507b() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (b.this.f61488g.hasMessages(0)) {
                b.this.f61488g.removeMessages(0);
            }
            b.this.f61488g.removeCallbacks(b.this.k);
            b.this.f61488g.removeCallbacks(b.this.j);
            if (b.this.f61482a != null) {
                return;
            }
            b.this.f61482a = new f(b.this, null);
            b.this.f61482a.setSelfExecute(true);
            b.this.f61482a.execute(location);
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
            if (b.this.f61485d == null || !PermissionUtil.checkLocationForGoogle(b.this.f61483b)) {
                return;
            }
            try {
                b.this.f61485d.requestLocationUpdates("network", 10000L, 100.0f, b.this.l);
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
            if (b.this.f61485d == null || !PermissionUtil.checkLocationForGoogle(b.this.f61483b)) {
                return;
            }
            try {
                b.this.f61485d.requestLocationUpdates("gps", 10000L, 100.0f, b.this.m);
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
            b.this.f61484c.a(b.this.f61489h, "", null, b.this.f61487f, b.this.f61490i);
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
            Geocoder geocoder = new Geocoder(b.this.f61483b, Locale.getDefault());
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
            b.this.f61482a = null;
            if (address != null) {
                b.this.c();
                b.this.f61487f = System.currentTimeMillis();
                b.this.f61486e = address;
                b.this.f61484c.a(0, "", b.this.f61486e, b.this.f61487f, b.this.f61490i);
                d.a.n0.t2.g0.a.e().i(String.valueOf(address.getLatitude()));
                d.a.n0.t2.g0.a.e().j(String.valueOf(address.getLongitude()));
                d.a.n0.t2.g0.a.e().k(System.currentTimeMillis());
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            b.this.f61482a = null;
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
        if (this.f61484c == null || (locationManager = this.f61485d) == null) {
            return;
        }
        try {
            try {
                locationManager.removeUpdates(this.l);
                this.f61489h = 4;
                this.f61490i = z;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                c();
                this.f61489h = 5;
            }
            if (PermissionUtil.checkLocationForGoogle(this.f61483b) && (this.f61485d.isProviderEnabled("gps") || this.f61485d.isProviderEnabled("network"))) {
                if (PermissionUtil.checkLocationForGoogle(this.f61483b) && this.f61485d.isProviderEnabled("gps")) {
                    this.f61488g.post(this.k);
                } else {
                    this.f61489h = 1;
                }
                if (!z) {
                    if (PermissionUtil.checkLocationForGoogle(this.f61483b) && this.f61485d.isProviderEnabled("network")) {
                        this.f61488g.post(this.j);
                    } else {
                        this.f61489h = 2;
                    }
                }
                return;
            }
            this.f61489h = 3;
            this.f61488g.sendMessageDelayed(this.f61488g.obtainMessage(0), d.a.c.e.i.a.l().m());
        } finally {
            Handler handler = this.f61488g;
            handler.sendMessageDelayed(handler.obtainMessage(0), d.a.c.e.i.a.l().m());
        }
    }

    @Override // d.a.c.e.i.b
    public void b(a.d dVar) {
        Context context = TbadkCoreApplication.getInst().getContext();
        this.f61483b = context;
        this.f61484c = dVar;
        try {
            this.f61485d = (LocationManager) context.getSystemService("location");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        this.j = new c();
        this.k = new d();
        u();
    }

    @Override // d.a.c.e.i.b
    public void c() {
        if (this.f61488g.hasMessages(0)) {
            this.f61488g.removeMessages(0);
        }
        this.f61488g.removeCallbacks(this.k);
        this.f61488g.removeCallbacks(this.j);
        LocationManager locationManager = this.f61485d;
        if (locationManager != null) {
            try {
                locationManager.removeUpdates(this.l);
                this.f61485d.removeUpdates(this.m);
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
        f fVar = this.f61482a;
        if (fVar != null) {
            fVar.cancel();
            this.f61482a = null;
        }
    }

    @Override // d.a.c.e.i.b
    public void destroy() {
        if (this.f61488g.hasMessages(0)) {
            this.f61488g.removeMessages(0);
        }
        this.f61488g.removeCallbacks(this.k);
        this.f61488g.removeCallbacks(this.j);
        LocationManager locationManager = this.f61485d;
        if (locationManager != null) {
            try {
                locationManager.removeUpdates(this.l);
                this.f61485d.removeUpdates(this.m);
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
        f fVar = this.f61482a;
        if (fVar != null) {
            fVar.cancel();
            this.f61482a = null;
        }
    }

    public final void u() {
        this.f61488g = new Handler(Looper.getMainLooper(), new e());
    }
}
