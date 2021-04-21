package d.b.j0.n1;

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
import d.b.c.e.i.a;
import java.util.Locale;
/* loaded from: classes3.dex */
public class a implements d.b.c.e.i.b {
    public static a k;

    /* renamed from: a  reason: collision with root package name */
    public Context f58889a;

    /* renamed from: e  reason: collision with root package name */
    public b f58893e;

    /* renamed from: f  reason: collision with root package name */
    public LocationClient f58894f;

    /* renamed from: g  reason: collision with root package name */
    public LocationClientOption f58895g;

    /* renamed from: h  reason: collision with root package name */
    public Address f58896h;

    /* renamed from: b  reason: collision with root package name */
    public boolean f58890b = true;

    /* renamed from: c  reason: collision with root package name */
    public String f58891c = "";

    /* renamed from: d  reason: collision with root package name */
    public a.d f58892d = null;
    public long i = 0;
    public boolean j = false;

    /* renamed from: d.b.j0.n1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1423a extends CustomMessageListener {
        public C1423a(int i) {
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
                    d.b.c.e.i.a.l().p(a.j());
                } else {
                    d.b.c.e.i.a.l().t(a.j());
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
            a.this.f58896h = new Address(Locale.getDefault());
            a.this.f58896h.setLatitude(bDLocation.getLatitude());
            a.this.f58896h.setLongitude(bDLocation.getLongitude());
            d.b.i0.r.d0.b j = d.b.i0.r.d0.b.j();
            j.x("key_last_receive_location_latitude_and_longitude", bDLocation.getLatitude() + "," + bDLocation.getLongitude());
            a.this.f58896h.setLocality(bDLocation.getCity());
            Bundle bundle = new Bundle();
            bundle.putFloat("radius", bDLocation.getRadius());
            bundle.putDouble("altitude", bDLocation.getAltitude());
            bundle.putFloat("speed", bDLocation.getSpeed());
            bundle.putString("cityCode", bDLocation.getCityCode());
            bundle.putString("street", bDLocation.getStreet());
            bundle.putString("streetNumber", bDLocation.getStreetNumber());
            bundle.putString("province", bDLocation.getProvince());
            a.this.f58896h.setExtras(bundle);
            a.this.i = System.currentTimeMillis();
            StringBuffer stringBuffer = new StringBuffer();
            if (bDLocation.getDistrict() == null || bDLocation.getStreet() == null) {
                stringBuffer.append(bDLocation.getCity());
            }
            stringBuffer.append(bDLocation.getDistrict());
            stringBuffer.append(bDLocation.getStreet());
            if (bDLocation.getAddrStr() != null) {
                a.this.f58896h.setAddressLine(0, stringBuffer.toString());
            }
            if (a.this.f58892d != null) {
                a.this.f58892d.a(0, "", a.this.f58896h, a.this.i, a.this.j);
                d.b.j0.s2.d0.a.e().i(String.valueOf(a.this.f58896h.getLatitude()));
                d.b.j0.s2.d0.a.e().j(String.valueOf(a.this.f58896h.getLongitude()));
                d.b.j0.s2.d0.a.e().k(System.currentTimeMillis());
            }
        }

        public /* synthetic */ b(a aVar, C1423a c1423a) {
            this();
        }
    }

    static {
        MessageManager.getInstance().registerListener(new C1423a(2001330));
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

    @Override // d.b.c.e.i.b
    public void a(a.d dVar) {
        Context context = TbadkCoreApplication.getInst().getContext();
        this.f58889a = context;
        this.f58892d = dVar;
        this.f58891c = PathUtils.DIRCTORY_BAIDU;
        if (this.f58890b) {
            try {
                this.f58894f = new LocationClient(context);
                LocationClientOption locationClientOption = new LocationClientOption();
                this.f58895g = locationClientOption;
                locationClientOption.setOpenGps(true);
                this.f58895g.setIgnoreKillProcess(true);
                this.f58895g.setProdName(this.f58891c);
                this.f58895g.setAddrType("all");
                this.f58895g.setCoorType("bd09ll");
                b bVar = new b(this, null);
                this.f58893e = bVar;
                this.f58894f.registerLocationListener(bVar);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    @Override // d.b.c.e.i.b
    public void b(boolean z) {
        if ((!ApiUtil.shouldCheckPermission() || PermissionUtil.checkLocationForBaiduLocation(TbadkCoreApplication.getInst())) && this.f58890b && this.f58894f != null) {
            try {
                this.j = z;
                if (z) {
                    this.f58895g.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
                }
                this.f58894f.setLocOption(this.f58895g);
                if (!this.f58894f.isStarted()) {
                    this.f58894f.start();
                }
                this.f58894f.requestLocation();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                c();
                a.d dVar = this.f58892d;
                if (dVar != null) {
                    dVar.a(5, "", this.f58896h, this.i, this.j);
                }
            }
        }
    }

    @Override // d.b.c.e.i.b
    public void c() {
        LocationClient locationClient = this.f58894f;
        if (locationClient == null || !locationClient.isStarted()) {
            return;
        }
        try {
            this.f58894f.stop();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    @Override // d.b.c.e.i.b
    public void destroy() {
        c();
    }
}
