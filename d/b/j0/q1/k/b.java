package d.b.j0.q1.k;

import android.location.Address;
import com.baidu.searchbox.live.interfaces.location.LocationCallback;
import com.baidu.searchbox.live.interfaces.location.LocationInfo;
import com.baidu.searchbox.live.interfaces.service.LiveLocationService;
import d.b.c.e.i.a;
/* loaded from: classes3.dex */
public class b implements LiveLocationService {

    /* loaded from: classes3.dex */
    public class a implements a.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LocationCallback f60891a;

        public a(LocationCallback locationCallback) {
            this.f60891a = locationCallback;
        }

        @Override // d.b.c.e.i.a.c
        public void onLocationGeted(int i, String str, Address address) {
            try {
                if (this.f60891a != null) {
                    this.f60891a.onReceiveLocation(b.this.b(address));
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
        return b(d.b.c.e.i.a.l().i(false, null));
    }

    @Override // com.baidu.searchbox.live.interfaces.service.LiveLocationService
    public void requestLocate(LocationCallback locationCallback) {
        d.b.c.e.i.a.l().i(true, new a(locationCallback));
    }
}
