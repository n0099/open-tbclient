package d.a.k0.o.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.constants.PlaceId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final Map<PlaceId, List<AdvertAppInfo>> f57763a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<PlaceId, Long> f57764b;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final c f57765a = new c();
    }

    public static c d() {
        return b.f57765a;
    }

    public void a(@NonNull PlaceId placeId, @NonNull List<AdvertAppInfo> list) {
        List<AdvertAppInfo> list2 = this.f57763a.get(placeId);
        if (list2 == null) {
            synchronized (this.f57763a) {
                list2 = Collections.synchronizedList(new ArrayList());
                this.f57763a.put(placeId, list2);
            }
        }
        list2.addAll(list);
        this.f57764b.put(placeId, Long.valueOf(System.currentTimeMillis()));
    }

    @Nullable
    public List<AdvertAppInfo> b(@NonNull PlaceId placeId) {
        List<AdvertAppInfo> list = this.f57763a.get(placeId);
        if (d.a.k0.j1.o.k.a.e(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list);
        d.a.k0.j1.o.k.a.c(list);
        return arrayList;
    }

    @Nullable
    public AdvertAppInfo c(@NonNull PlaceId placeId) {
        List<AdvertAppInfo> list = this.f57763a.get(placeId);
        if (d.a.k0.j1.o.k.a.e(list)) {
            return null;
        }
        return list.remove(0);
    }

    public long e(PlaceId placeId) {
        Long l = this.f57764b.get(placeId);
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public boolean f(@NonNull PlaceId placeId) {
        return !d.a.k0.j1.o.k.a.e(this.f57763a.get(placeId));
    }

    public c() {
        this.f57763a = new ConcurrentHashMap();
        this.f57764b = new ConcurrentHashMap();
    }
}
