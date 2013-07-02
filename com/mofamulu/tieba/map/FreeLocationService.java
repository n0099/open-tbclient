package com.mofamulu.tieba.map;

import android.content.Context;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.zeus.Headers;
import com.mofamulu.tieba.ch.NickBinder;
import com.mofamulu.tieba.ch.as;
import com.mofamulu.tieba.ch.av;
import com.mofamulu.tieba.ch.bg;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class FreeLocationService {
    private static FreeLocationService h;
    private Context g;
    private LocationManager j;
    private String k;
    private Address l;
    private String m;
    private LocationClient c = null;
    private LocationClient d = null;
    private BDLocationListener e = null;
    private BDLocationListener f = null;
    private ArrayList i = new ArrayList();
    public Handler a = null;
    LocationListener b = null;

    public static FreeLocationService a(Context context) {
        if (h == null && com.mofamulu.tieba.ch.a.b()) {
            h = new FreeLocationService();
            h.g = context;
            h.m();
            h.i();
        }
        return h;
    }

    private void m() {
        Address X = bg.c().X();
        if (X == null) {
            d(35.36273d, 138.731368d);
        } else {
            this.l = X;
        }
    }

    private void d(double d, double d2) {
        this.l = new Address(Locale.getDefault());
        this.l.setAddressLine(0, "白井黑子");
        this.l.setFeatureName("某秘密基地");
        this.l.setLatitude(d);
        this.l.setLongitude(d2);
    }

    public Address a() {
        return this.l;
    }

    private void n() {
        if (this.l != null) {
            bg.c().a(this.l);
        }
    }

    public String b() {
        return this.m;
    }

    public double c() {
        return this.l.getLatitude();
    }

    public double d() {
        return this.l.getLongitude();
    }

    public void a(double d, double d2) {
        this.l.setLatitude(d);
        this.l.setLongitude(d2);
        this.l.setAddressLine(0, null);
    }

    public String b(double d, double d2) {
        av b;
        if (d < -90.0d || d > 90.0d) {
            return "纬度必须在-90~90之间";
        }
        if (d > 80.0d && ((b = as.b(bg.a())) == null || b.c() != -65536)) {
            return "北纬80度以内为保护区，普通人类勿入";
        }
        if (d2 < -180.0d || d2 > 180.0d) {
            return "经度必须在-180~180之间";
        }
        if (d > 18.0d && d < 47.0d && d2 > 100.0d && d2 < 130.0d && !bg.c().e(false)) {
            return "北纬18~47，东经100~130组成的区域为限制区，仅限VIP用户方可跳跃。";
        }
        if (NickBinder.b.b() == 0) {
            return "与助手云端的身份认证失败，请退出应用重试！";
        }
        return null;
    }

    public String c(double d, double d2) {
        String b = b(d, d2);
        if (b == null) {
            a(d, d2);
            return null;
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location) {
        if (location != null) {
            a(location.getLatitude(), location.getLongitude());
            o();
        }
    }

    public void e() {
        com.mofamulu.tieba.ch.a.a(new i(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        List<Address> fromLocation = new Geocoder(this.g, Locale.getDefault()).getFromLocation(this.l.getLatitude(), this.l.getLongitude(), 1);
        if (fromLocation != null && !fromLocation.isEmpty()) {
            this.l = fromLocation.get(0);
        } else {
            d(this.l.getLatitude(), this.l.getLongitude());
        }
        n();
    }

    public String f() {
        StringBuilder sb = new StringBuilder();
        if (c() >= 0.0d) {
            sb.append("北纬:");
        } else {
            sb.append("南纬:");
        }
        sb.append(Math.abs(c())).append("，");
        if (d() >= 0.0d) {
            sb.append("东经:");
        } else {
            sb.append("西经:");
        }
        sb.append(Math.abs(d())).append("；");
        sb.append(h());
        return sb.toString();
    }

    public String g() {
        StringBuilder sb = new StringBuilder();
        if (c() >= 0.0d) {
            sb.append("北纬:");
        } else {
            sb.append("南纬:");
        }
        sb.append(Math.abs(c())).append("，");
        if (d() >= 0.0d) {
            sb.append("东经:");
        } else {
            sb.append("西经:");
        }
        sb.append(Math.abs(d()));
        return sb.toString();
    }

    public String h() {
        if (this.l == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(64);
        String str = null;
        for (int i = 0; i <= this.l.getMaxAddressLineIndex(); i++) {
            str = this.l.getAddressLine(i);
            if (str == null) {
                return sb.toString();
            }
            if (str.contains("邮政编码")) {
                return sb.toString();
            }
            sb.append(str);
        }
        String featureName = this.l.getFeatureName();
        if (featureName != null && !featureName.equals(str)) {
            sb.append(featureName);
        }
        return sb.toString();
    }

    public void a(boolean z) {
        i();
        this.j = (LocationManager) this.g.getSystemService(Headers.LOCATION);
        if (!k()) {
            if (z) {
                a("GPS和网络定位都不可用！");
                return;
            }
            return;
        }
        if (this.k == null) {
            this.k = p();
        }
        Location lastKnownLocation = this.j.getLastKnownLocation(this.k);
        if (lastKnownLocation == null) {
            if (z) {
                this.b = new j(this, z);
                if (this.a.hasMessages(15)) {
                    this.a.removeMessages(15);
                }
                this.j.requestLocationUpdates(this.k, 60000L, 1.0f, this.b);
                this.a.sendMessageDelayed(this.a.obtainMessage(15), 15000L);
                return;
            }
            b(z);
            return;
        }
        com.mofamulu.tieba.ch.a.a(new k(this, lastKnownLocation, z));
    }

    public void i() {
        if (this.c == null) {
            q();
        }
        if (this.a == null) {
            this.a = new Handler(new l(this));
        }
    }

    public void a(m mVar) {
        i();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.i.size()) {
                m mVar2 = (m) this.i.get(i2);
                if (mVar2 == null || !mVar2.equals(mVar)) {
                    i = i2 + 1;
                } else {
                    return;
                }
            } else {
                this.i.add(mVar);
                return;
            }
        }
    }

    public void b(m mVar) {
        if (mVar != null) {
            this.i.remove(mVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.i.size()) {
                m mVar = (m) this.i.get(i2);
                if (mVar != null) {
                    mVar.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public boolean k() {
        return this.j.isProviderEnabled("gps") || this.j.isProviderEnabled("network");
    }

    private String p() {
        Criteria criteria = new Criteria();
        criteria.setAccuracy(1);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(1);
        return this.j.getBestProvider(criteria, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(Location location, Location location2) {
        if (location2 == null) {
            return true;
        }
        long time = location.getTime() - location2.getTime();
        boolean z = time > 120000;
        boolean z2 = time < -120000;
        boolean z3 = time > 0;
        if (z) {
            return true;
        }
        if (z2) {
            return false;
        }
        int accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
        boolean z4 = accuracy > 0;
        boolean z5 = accuracy < 0;
        boolean z6 = accuracy > 200;
        boolean a = a(location.getProvider(), location2.getProvider());
        if (z5) {
            return true;
        }
        if (!z3 || z4) {
            return z3 && !z6 && a;
        }
        return true;
    }

    private boolean a(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        this.m = str;
        this.a.sendMessage(this.a.obtainMessage(1));
    }

    private void q() {
        try {
            this.e = new MyBDLocationListenner(true);
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setProdName("tieba");
            locationClientOption.setAddrType("all");
            locationClientOption.setCoorType("bd09ll");
            locationClientOption.setScanSpan(BdWebErrorView.ERROR_CODE_500);
            locationClientOption.disableCache(true);
            this.c = new LocationClient(this.g);
            this.c.registerLocationListener(this.e);
            this.c.setLocOption(locationClientOption);
            this.f = new MyBDLocationListenner(false);
            this.d = new LocationClient(this.g);
            this.d.registerLocationListener(this.f);
            this.d.setLocOption(locationClientOption);
        } catch (Exception e) {
        }
    }

    public void b(boolean z) {
        try {
            if (this.a.hasMessages(5)) {
                this.a.removeMessages(5);
            }
            if (z) {
                if (!this.c.isStarted()) {
                    this.c.start();
                }
                this.c.requestLocation();
                this.a.sendMessageDelayed(this.a.obtainMessage(5), 15000L);
                return;
            }
            if (!this.d.isStarted()) {
                this.d.start();
            }
            this.d.requestLocation();
            this.a.sendMessageDelayed(this.a.obtainMessage(10), 15000L);
        } catch (Throwable th) {
            if (z) {
                a(th.getMessage());
            }
        }
    }

    /* loaded from: classes.dex */
    public class MyBDLocationListenner implements BDLocationListener {
        private boolean b;

        public MyBDLocationListenner(boolean z) {
            this.b = z;
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null || bDLocation.getLocType() == 62 || bDLocation.getLocType() == 63 || bDLocation.getLocType() == 68 || bDLocation.getLocType() > 161) {
                if (this.b) {
                    FreeLocationService.this.a("baidu定位失败，请稍候重试。");
                    return;
                }
                return;
            }
            FreeLocationService.this.l();
            String addrStr = bDLocation.getAddrStr();
            if (addrStr != null) {
                int indexOf = addrStr.indexOf("邮政编码");
                if (indexOf > 0) {
                    addrStr = addrStr.substring(0, indexOf);
                }
            } else {
                addrStr = "";
            }
            FreeLocationService.this.l = new Address(Locale.getDefault());
            FreeLocationService.this.l.setFeatureName(null);
            FreeLocationService.this.l.setAddressLine(0, addrStr);
            FreeLocationService.this.l.setLatitude(bDLocation.getLatitude());
            FreeLocationService.this.l.setLongitude(bDLocation.getLongitude());
            if (this.b) {
                FreeLocationService.this.a((String) null);
            }
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceivePoi(BDLocation bDLocation) {
        }
    }

    public void l() {
        try {
            if (this.a.hasMessages(5)) {
                this.a.removeMessages(5);
            }
            if (this.c != null && this.c.isStarted()) {
                this.c.stop();
            }
            if (this.d != null && this.d.isStarted()) {
                this.d.stop();
            }
        } catch (Throwable th) {
        }
    }
}
