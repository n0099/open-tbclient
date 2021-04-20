package d.b.g0.h.a.j;

import com.baidu.mapapi.search.core.PoiInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public PoiInfo f49163a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f49164b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f49165c;

    public c(PoiInfo poiInfo, boolean z, boolean z2) {
        if (poiInfo == null) {
            this.f49163a = new PoiInfo();
        }
        this.f49163a = poiInfo;
        this.f49164b = z;
        this.f49165c = z2;
    }

    public static List<c> a(List<PoiInfo> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList(list.size());
            for (PoiInfo poiInfo : list) {
                if (poiInfo.location != null) {
                    arrayList.add(new c(poiInfo));
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public c(PoiInfo poiInfo) {
        this(poiInfo, false, false);
    }
}
