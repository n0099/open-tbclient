package d.a.j0.n1;

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
    public Context f56904a;

    /* renamed from: e  reason: collision with root package name */
    public b f56908e;

    /* renamed from: f  reason: collision with root package name */
    public LocationClient f56909f;

    /* renamed from: g  reason: collision with root package name */
    public LocationClientOption f56910g;

    /* renamed from: h  reason: collision with root package name */
    public Address f56911h;

    /* renamed from: b  reason: collision with root package name */
    public boolean f56905b = true;

    /* renamed from: c  reason: collision with root package name */
    public String f56906c = "";

    /* renamed from: d  reason: collision with root package name */
    public a.d f56907d = null;

    /* renamed from: i  reason: collision with root package name */
    public long f56912i = 0;
    public boolean j = false;

    /* renamed from: d.a.j0.n1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1362a extends CustomMessageListener {
        public C1362a(int i2) {
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
            a.this.f56911h = new Address(Locale.getDefault());
            a.this.f56911h.setLatitude(bDLocation.getLatitude());
            a.this.f56911h.setLongitude(bDLocation.getLongitude());
            d.a.i0.r.d0.b j = d.a.i0.r.d0.b.j();
            j.x("key_last_receive_location_latitude_and_longitude", bDLocation.getLatitude() + "," + bDLocation.getLongitude());
            a.this.f56911h.setLocality(bDLocation.getCity());
            Bundle bundle = new Bundle();
            bundle.putFloat("radius", bDLocation.getRadius());
            bundle.putDouble("altitude", bDLocation.getAltitude());
            bundle.putFloat("speed", bDLocation.getSpeed());
            bundle.putString("cityCode", bDLocation.getCityCode());
            bundle.putString("street", bDLocation.getStreet());
            bundle.putString("streetNumber", bDLocation.getStreetNumber());
            bundle.putString("province", bDLocation.getProvince());
            a.this.f56911h.setExtras(bundle);
            a.this.f56912i = System.currentTimeMillis();
            StringBuffer stringBuffer = new StringBuffer();
            if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                stringBuffer.append(bDLocation.getCity());
            }
            stringBuffer.append(bDLocation.getDistrict());
            stringBuffer.append(bDLocation.getStreet());
            if (bDLocation.getAddrStr() != null) {
                a.this.f56911h.setAddressLine(0, stringBuffer.toString());
            }
            if (a.this.f56907d != null) {
                a.this.f56907d.a(0, "", a.this.f56911h, a.this.f56912i, a.this.j);
                d.a.j0.s2.f0.a.e().i(String.valueOf(a.this.f56911h.getLatitude()));
                d.a.j0.s2.f0.a.e().j(String.valueOf(a.this.f56911h.getLongitude()));
                d.a.j0.s2.f0.a.e().k(System.currentTimeMillis());
            }
        }

        public /* synthetic */ b(a aVar, C1362a c1362a) {
            this();
        }
    }

    static {
        MessageManager.getInstance().registerListener(new C1362a(2001330));
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
        if ((!ApiUtil.shouldCheckPermission() || PermissionUtil.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && this.f56905b && this.f56909f != null) {
            try {
                this.j = z;
                if (z) {
                    this.f56910g.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.f56909f.setLocOption(this.f56910g);
                if (!this.f56909f.isStarted()) {
                    this.f56909f.start();
                }
                this.f56909f.requestLocation();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                c();
                a.d dVar = this.f56907d;
                if (dVar != null) {
                    dVar.a(5, "", this.f56911h, this.f56912i, this.j);
                }
            }
        }
    }

    @Override // d.a.c.e.i.b
    public void b(a.d dVar) {
        Context context = TbadkCoreApplication.getInst().getContext();
        this.f56904a = context;
        this.f56907d = dVar;
        this.f56906c = PathUtils.DIRCTORY_BAIDU;
        if (this.f56905b) {
            try {
                this.f56909f = new LocationClient(context);
                LocationClientOption locationClientOption = new LocationClientOption();
                this.f56910g = locationClientOption;
                locationClientOption.setOpenGps(true);
                this.f56910g.setIgnoreKillProcess(true);
                this.f56910g.setProdName(this.f56906c);
                this.f56910g.setAddrType("all");
                this.f56910g.setCoorType("bd09ll");
                b bVar = new b(this, null);
                this.f56908e = bVar;
                this.f56909f.registerLocationListener(bVar);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    @Override // d.a.c.e.i.b
    public void c() {
        LocationClient locationClient = this.f56909f;
        if (locationClient == null || !locationClient.isStarted()) {
            return;
        }
        try {
            this.f56909f.stop();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    @Override // d.a.c.e.i.b
    public void destroy() {
        c();
    }
}
