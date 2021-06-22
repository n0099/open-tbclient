package d.a.o0.r1.l;

import android.location.Address;
import com.baidu.searchbox.live.interfaces.location.LocationCallback;
import com.baidu.searchbox.live.interfaces.location.LocationInfo;
import com.baidu.searchbox.live.interfaces.service.LiveLocationService;
import d.a.c.e.i.a;
/* loaded from: classes3.dex */
public class b implements LiveLocationService {

    /* loaded from: classes3.dex */
    public class a implements a.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LocationCallback f63716a;

        public a(LocationCallback locationCallback) {
            this.f63716a = locationCallback;
        }

        @Override // d.a.c.e.i.a.c
        public void onLocationGeted(int i2, String str, Address address) {
            try {
                if (this.f63716a != null) {
                    this.f63716a.onReceiveLocation(b.this.b(address));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final LocationInfo b(Address address) {
        LocationInfo locationInfo = new LocationInfo();
        if (address != null) {
            locationInfo.setCity(address.getLocality());
            locationInfo.setLatitude(address.getLatitude());
            locationInfo.setLongitude(address.getLongitude());
            locationInfo.setProvince(address.getAdminArea());
            locationInfo.setCounty(address.getCountryName());
        }
        return locationInfo;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveLocationService
    public LocationInfo getLocationInfo() {
        return b(d.a.c.e.i.a.k().h(false, null));
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveLocationService
    public void requestLocate(LocationCallback locationCallback) {
        d.a.c.e.i.a.k().h(true, new a(locationCallback));
    }
}
