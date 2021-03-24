package d.b.i0.m1;

import android.content.Context;
import android.location.Address;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.permissionhelper.ApiUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import d.b.b.e.i.a;
import java.util.Locale;
/* loaded from: classes3.dex */
public class a implements d.b.b.e.i.b {
    public static a k;

    /* renamed from: a  reason: collision with root package name */
    public Context f56830a;

    /* renamed from: e  reason: collision with root package name */
    public b f56834e;

    /* renamed from: f  reason: collision with root package name */
    public LocationClient f56835f;

    /* renamed from: g  reason: collision with root package name */
    public LocationClientOption f56836g;

    /* renamed from: h  reason: collision with root package name */
    public Address f56837h;

    /* renamed from: b  reason: collision with root package name */
    public boolean f56831b = true;

    /* renamed from: c  reason: collision with root package name */
    public String f56832c = "";

    /* renamed from: d  reason: collision with root package name */
    public a.d f56833d = null;
    public long i = 0;
    public boolean j = false;

    /* renamed from: d.b.i0.m1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1341a extends CustomMessageListener {
        public C1341a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001330) {
                return;
            }
            if ((!ApiUtil.shouldCheckPermission() || PermissionUtil.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    d.b.b.e.i.a.l().p(a.j());
                } else {
                    d.b.b.e.i.a.l().t(a.j());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BDLocationListener {
        public b() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if ((ApiUtil.shouldCheckPermission() && !PermissionUtil.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) || bDLocation == null || bDLocation.getLocType() == 62 || bDLocation.getLocType() == 63 || bDLocation.getLocType() == 67 || bDLocation.getLocType() == 68 || bDLocation.getLocType() > 161) {
                return;
            }
            a.this.c();
            a.this.f56837h = new Address(Locale.getDefault());
            a.this.f56837h.setLatitude(bDLocation.getLatitude());
            a.this.f56837h.setLongitude(bDLocation.getLongitude());
            d.b.h0.r.d0.b i = d.b.h0.r.d0.b.i();
            i.w("key_last_receive_location_latitude_and_longitude", bDLocation.getLatitude() + "," + bDLocation.getLongitude());
            a.this.f56837h.setLocality(bDLocation.getCity());
            Bundle bundle = new Bundle();
            bundle.putFloat("radius", bDLocation.getRadius());
            bundle.putDouble("altitude", bDLocation.getAltitude());
            bundle.putFloat("speed", bDLocation.getSpeed());
            bundle.putString("cityCode", bDLocation.getCityCode());
            bundle.putString("street", bDLocation.getStreet());
            bundle.putString("streetNumber", bDLocation.getStreetNumber());
            bundle.putString("province", bDLocation.getProvince());
            a.this.f56837h.setExtras(bundle);
            a.this.i = System.currentTimeMillis();
            StringBuffer stringBuffer = new StringBuffer();
            if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                stringBuffer.append(bDLocation.getCity());
            }
            stringBuffer.append(bDLocation.getDistrict());
            stringBuffer.append(bDLocation.getStreet());
            if (bDLocation.getAddrStr() != null) {
                a.this.f56837h.setAddressLine(0, stringBuffer.toString());
            }
            if (a.this.f56833d != null) {
                a.this.f56833d.a(0, "", a.this.f56837h, a.this.i, a.this.j);
                d.b.i0.r2.a0.a.e().i(String.valueOf(a.this.f56837h.getLatitude()));
                d.b.i0.r2.a0.a.e().j(String.valueOf(a.this.f56837h.getLongitude()));
                d.b.i0.r2.a0.a.e().k(System.currentTimeMillis());
            }
        }

        public /* synthetic */ b(a aVar, C1341a c1341a) {
            this();
        }
    }

    static {
        MessageManager.getInstance().registerListener(new C1341a(2001330));
    }

    public static a j() {
        if (k == null) {
            synchronized (a.class) {
                if (k == null) {
                    k = new a();
                }
            }
        }
        return k;
    }

    @Override // d.b.b.e.i.b
    public void a(a.d dVar) {
        Context context = TbadkCoreApplication.getInst().getContext();
        this.f56830a = context;
        this.f56833d = dVar;
        this.f56832c = "baidu";
        if (this.f56831b) {
            try {
                this.f56835f = new LocationClient(context);
                LocationClientOption locationClientOption = new LocationClientOption();
                this.f56836g = locationClientOption;
                locationClientOption.setOpenGps(true);
                this.f56836g.setIgnoreKillProcess(true);
                this.f56836g.setProdName(this.f56832c);
                this.f56836g.setAddrType("all");
                this.f56836g.setCoorType("bd09ll");
                b bVar = new b(this, null);
                this.f56834e = bVar;
                this.f56835f.registerLocationListener(bVar);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    @Override // d.b.b.e.i.b
    public void b(boolean z) {
        if ((!ApiUtil.shouldCheckPermission() || PermissionUtil.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && this.f56831b && this.f56835f != null) {
            try {
                this.j = z;
                if (z) {
                    this.f56836g.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.f56835f.setLocOption(this.f56836g);
                if (!this.f56835f.isStarted()) {
                    this.f56835f.start();
                }
                this.f56835f.requestLocation();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                c();
                a.d dVar = this.f56833d;
                if (dVar != null) {
                    dVar.a(5, "", this.f56837h, this.i, this.j);
                }
            }
        }
    }

    @Override // d.b.b.e.i.b
    public void c() {
        LocationClient locationClient = this.f56835f;
        if (locationClient == null || !locationClient.isStarted()) {
            return;
        }
        try {
            this.f56835f.stop();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    @Override // d.b.b.e.i.b
    public void destroy() {
        c();
    }
}
