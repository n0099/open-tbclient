package d.b.i0.m1;

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
import d.b.b.e.i.a;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
/* loaded from: classes3.dex */
public class b implements d.b.b.e.i.b {
    public static b n;

    /* renamed from: b  reason: collision with root package name */
    public Context f56840b;

    /* renamed from: d  reason: collision with root package name */
    public LocationManager f56842d;

    /* renamed from: h  reason: collision with root package name */
    public int f56846h;

    /* renamed from: a  reason: collision with root package name */
    public f f56839a = null;

    /* renamed from: c  reason: collision with root package name */
    public a.d f56841c = null;

    /* renamed from: e  reason: collision with root package name */
    public Address f56843e = null;

    /* renamed from: f  reason: collision with root package name */
    public long f56844f = 0;

    /* renamed from: g  reason: collision with root package name */
    public Handler f56845g = null;
    public boolean i = false;
    public Runnable j = null;
    public Runnable k = null;
    public final LocationListener l = new a();
    public final LocationListener m = new C1342b();

    /* loaded from: classes3.dex */
    public class a implements LocationListener {
        public a() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (b.this.f56845g.hasMessages(0)) {
                b.this.f56845g.removeMessages(0);
            }
            b.this.f56845g.removeCallbacks(b.this.k);
            b.this.f56845g.removeCallbacks(b.this.j);
            if (b.this.f56839a != null) {
                return;
            }
            b.this.f56839a = new f(b.this, null);
            b.this.f56839a.setSelfExecute(true);
            b.this.f56839a.execute(location);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    /* renamed from: d.b.i0.m1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1342b implements LocationListener {
        public C1342b() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (b.this.f56845g.hasMessages(0)) {
                b.this.f56845g.removeMessages(0);
            }
            b.this.f56845g.removeCallbacks(b.this.k);
            b.this.f56845g.removeCallbacks(b.this.j);
            if (b.this.f56839a != null) {
                return;
            }
            b.this.f56839a = new f(b.this, null);
            b.this.f56839a.setSelfExecute(true);
            b.this.f56839a.execute(location);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f56842d == null || !PermissionUtil.checkLocationForGoogle(b.this.f56840b)) {
                return;
            }
            try {
                b.this.f56842d.requestLocationUpdates("network", 10000L, 100.0f, b.this.l);
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
            if (b.this.f56842d == null || !PermissionUtil.checkLocationForGoogle(b.this.f56840b)) {
                return;
            }
            try {
                b.this.f56842d.requestLocationUpdates("gps", 10000L, 100.0f, b.this.m);
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
            b.this.f56841c.a(b.this.f56846h, "", null, b.this.f56844f, b.this.i);
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
            Geocoder geocoder = new Geocoder(b.this.f56840b, Locale.getDefault());
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
            b.this.f56839a = null;
            if (address != null) {
                b.this.c();
                b.this.f56844f = System.currentTimeMillis();
                b.this.f56843e = address;
                b.this.f56841c.a(0, "", b.this.f56843e, b.this.f56844f, b.this.i);
                d.b.i0.r2.a0.a.e().i(String.valueOf(address.getLatitude()));
                d.b.i0.r2.a0.a.e().j(String.valueOf(address.getLongitude()));
                d.b.i0.r2.a0.a.e().k(System.currentTimeMillis());
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            b.this.f56839a = null;
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

    @Override // d.b.b.e.i.b
    public void a(a.d dVar) {
        Context context = TbadkCoreApplication.getInst().getContext();
        this.f56840b = context;
        this.f56841c = dVar;
        try {
            this.f56842d = (LocationManager) context.getSystemService("location");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        this.j = new c();
        this.k = new d();
        u();
    }

    @Override // d.b.b.e.i.b
    public void b(boolean z) {
        LocationManager locationManager;
        if (this.f56841c == null || (locationManager = this.f56842d) == null) {
            return;
        }
        try {
            try {
                locationManager.removeUpdates(this.l);
                this.f56846h = 4;
                this.i = z;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                c();
                this.f56846h = 5;
            }
            if (PermissionUtil.checkLocationForGoogle(this.f56840b) && (this.f56842d.isProviderEnabled("gps") || this.f56842d.isProviderEnabled("network"))) {
                if (PermissionUtil.checkLocationForGoogle(this.f56840b) && this.f56842d.isProviderEnabled("gps")) {
                    this.f56845g.post(this.k);
                } else {
                    this.f56846h = 1;
                }
                if (!z) {
                    if (PermissionUtil.checkLocationForGoogle(this.f56840b) && this.f56842d.isProviderEnabled("network")) {
                        this.f56845g.post(this.j);
                    } else {
                        this.f56846h = 2;
                    }
                }
                return;
            }
            this.f56846h = 3;
            this.f56845g.sendMessageDelayed(this.f56845g.obtainMessage(0), d.b.b.e.i.a.l().m());
        } finally {
            Handler handler = this.f56845g;
            handler.sendMessageDelayed(handler.obtainMessage(0), d.b.b.e.i.a.l().m());
        }
    }

    @Override // d.b.b.e.i.b
    public void c() {
        if (this.f56845g.hasMessages(0)) {
            this.f56845g.removeMessages(0);
        }
        this.f56845g.removeCallbacks(this.k);
        this.f56845g.removeCallbacks(this.j);
        LocationManager locationManager = this.f56842d;
        if (locationManager != null) {
            try {
                locationManager.removeUpdates(this.l);
                this.f56842d.removeUpdates(this.m);
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
        f fVar = this.f56839a;
        if (fVar != null) {
            fVar.cancel();
            this.f56839a = null;
        }
    }

    @Override // d.b.b.e.i.b
    public void destroy() {
        if (this.f56845g.hasMessages(0)) {
            this.f56845g.removeMessages(0);
        }
        this.f56845g.removeCallbacks(this.k);
        this.f56845g.removeCallbacks(this.j);
        LocationManager locationManager = this.f56842d;
        if (locationManager != null) {
            try {
                locationManager.removeUpdates(this.l);
                this.f56842d.removeUpdates(this.m);
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
        f fVar = this.f56839a;
        if (fVar != null) {
            fVar.cancel();
            this.f56839a = null;
        }
    }

    public final void u() {
        this.f56845g = new Handler(Looper.getMainLooper(), new e());
    }
}
