package d.a.n0.o1;

import android.content.Context;
import android.location.Address;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.util.io.PathUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.permissionhelper.ApiUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import d.a.c.e.i.a;
import java.util.Locale;
/* loaded from: classes3.dex */
public class a implements d.a.c.e.i.b {
    public static a k;

    /* renamed from: a  reason: collision with root package name */
    public Context f61472a;

    /* renamed from: e  reason: collision with root package name */
    public b f61476e;

    /* renamed from: f  reason: collision with root package name */
    public LocationClient f61477f;

    /* renamed from: g  reason: collision with root package name */
    public LocationClientOption f61478g;

    /* renamed from: h  reason: collision with root package name */
    public Address f61479h;

    /* renamed from: b  reason: collision with root package name */
    public boolean f61473b = true;

    /* renamed from: c  reason: collision with root package name */
    public String f61474c = "";

    /* renamed from: d  reason: collision with root package name */
    public a.d f61475d = null;

    /* renamed from: i  reason: collision with root package name */
    public long f61480i = 0;
    public boolean j = false;

    /* renamed from: d.a.n0.o1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1506a extends CustomMessageListener {
        public C1506a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001330) {
                return;
            }
            if ((!ApiUtil.shouldCheckPermission() || PermissionUtil.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    d.a.c.e.i.a.l().p(a.j());
                } else {
                    d.a.c.e.i.a.l().t(a.j());
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
            a.this.f61479h = new Address(Locale.getDefault());
            a.this.f61479h.setLatitude(bDLocation.getLatitude());
            a.this.f61479h.setLongitude(bDLocation.getLongitude());
            d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
            j.x("key_last_receive_location_latitude_and_longitude", bDLocation.getLatitude() + "," + bDLocation.getLongitude());
            a.this.f61479h.setLocality(bDLocation.getCity());
            Bundle bundle = new Bundle();
            bundle.putFloat("radius", bDLocation.getRadius());
            bundle.putDouble("altitude", bDLocation.getAltitude());
            bundle.putFloat("speed", bDLocation.getSpeed());
            bundle.putString("cityCode", bDLocation.getCityCode());
            bundle.putString("street", bDLocation.getStreet());
            bundle.putString("streetNumber", bDLocation.getStreetNumber());
            bundle.putString("province", bDLocation.getProvince());
            a.this.f61479h.setExtras(bundle);
            a.this.f61480i = System.currentTimeMillis();
            StringBuffer stringBuffer = new StringBuffer();
            if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                stringBuffer.append(bDLocation.getCity());
            }
            stringBuffer.append(bDLocation.getDistrict());
            stringBuffer.append(bDLocation.getStreet());
            if (bDLocation.getAddrStr() != null) {
                a.this.f61479h.setAddressLine(0, stringBuffer.toString());
            }
            if (a.this.f61475d != null) {
                a.this.f61475d.a(0, "", a.this.f61479h, a.this.f61480i, a.this.j);
                d.a.n0.t2.g0.a.e().i(String.valueOf(a.this.f61479h.getLatitude()));
                d.a.n0.t2.g0.a.e().j(String.valueOf(a.this.f61479h.getLongitude()));
                d.a.n0.t2.g0.a.e().k(System.currentTimeMillis());
            }
        }

        public /* synthetic */ b(a aVar, C1506a c1506a) {
            this();
        }
    }

    static {
        MessageManager.getInstance().registerListener(new C1506a(2001330));
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

    @Override // d.a.c.e.i.b
    public void a(boolean z) {
        if ((!ApiUtil.shouldCheckPermission() || PermissionUtil.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && this.f61473b && this.f61477f != null) {
            try {
                this.j = z;
                if (z) {
                    this.f61478g.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.f61477f.setLocOption(this.f61478g);
                if (!this.f61477f.isStarted()) {
                    this.f61477f.start();
                }
                this.f61477f.requestLocation();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                c();
                a.d dVar = this.f61475d;
                if (dVar != null) {
                    dVar.a(5, "", this.f61479h, this.f61480i, this.j);
                }
            }
        }
    }

    @Override // d.a.c.e.i.b
    public void b(a.d dVar) {
        Context context = TbadkCoreApplication.getInst().getContext();
        this.f61472a = context;
        this.f61475d = dVar;
        this.f61474c = PathUtils.DIRCTORY_BAIDU;
        if (this.f61473b) {
            try {
                this.f61477f = new LocationClient(context);
                LocationClientOption locationClientOption = new LocationClientOption();
                this.f61478g = locationClientOption;
                locationClientOption.setOpenGps(true);
                this.f61478g.setIgnoreKillProcess(true);
                this.f61478g.setProdName(this.f61474c);
                this.f61478g.setAddrType("all");
                this.f61478g.setCoorType("bd09ll");
                b bVar = new b(this, null);
                this.f61476e = bVar;
                this.f61477f.registerLocationListener(bVar);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    @Override // d.a.c.e.i.b
    public void c() {
        LocationClient locationClient = this.f61477f;
        if (locationClient == null || !locationClient.isStarted()) {
            return;
        }
        try {
            this.f61477f.stop();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    @Override // d.a.c.e.i.b
    public void destroy() {
        c();
    }
}
