package d.a.m0.a.h0.t.c;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import d.a.m0.a.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46382b = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public final List<d.a.m0.a.o0.d.b> f46383a = new ArrayList();

    /* loaded from: classes3.dex */
    public static class a extends d.a.m0.a.o0.d.b {

        /* renamed from: d  reason: collision with root package name */
        public String f46384d;

        public a(@Nullable Map<String, String> map) {
            super("TopPages", map);
        }

        @Override // d.a.m0.a.o0.d.a
        public String b(d.a.m0.a.h0.f.a aVar) {
            if (this.f46384d == null) {
                this.f46384d = super.b(aVar);
            }
            return this.f46384d;
        }
    }

    public b a(d.a.m0.a.o0.d.b bVar) {
        if (bVar != null) {
            this.f46383a.add(bVar);
        }
        return this;
    }

    public a b() {
        long currentTimeMillis = f46382b ? System.currentTimeMillis() : 0L;
        TreeMap treeMap = new TreeMap();
        treeMap.put(NotificationCompat.WearableExtender.KEY_PAGES, c().toString());
        if (f46382b) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d("TopPageEvent", "build slave preload msg cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }
        return new a(treeMap);
    }

    public final JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        for (d.a.m0.a.o0.d.b bVar : this.f46383a) {
            jSONArray.put(bVar.g());
        }
        return jSONArray;
    }
}
