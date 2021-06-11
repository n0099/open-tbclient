package d.a.l0.j.n;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.TextureMapView;
import d.a.l0.a.h1.c.h.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends d.a.l0.a.c0.b.a<TextureMapView, d.a.l0.a.h1.c.c> {

    /* renamed from: i  reason: collision with root package name */
    public String f51566i;
    public String j;
    public boolean k;
    @NonNull
    public TextureMapView l;
    public Context m;
    public List<b> n;
    public List<a> o;

    public c(@NonNull Context context, @NonNull d.a.l0.a.h1.c.c cVar) {
        super(context, cVar);
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.f51566i = cVar.f44522g;
        this.j = cVar.f44521f;
        String str = cVar.f44523h;
        this.m = context;
        this.l = new TextureMapView(context);
        this.k = cVar.v;
    }

    public static c M(Context context, d.a.l0.a.h1.c.c cVar) {
        if (context == null || cVar == null || !cVar.isValid()) {
            return null;
        }
        return new c(context, cVar);
    }

    public void H() {
        for (b bVar : this.n) {
            this.l.removeView(bVar.f51559e);
        }
        this.n.clear();
        for (a aVar : this.o) {
            this.l.removeView(aVar.f51553b);
        }
        this.o.clear();
        this.l.getMap().clear();
    }

    public a I(View view) {
        for (a aVar : this.o) {
            if (aVar.f51553b == view) {
                return aVar;
            }
        }
        return null;
    }

    @Nullable
    public b J(Marker marker) {
        for (b bVar : this.n) {
            if (marker == bVar.f51556b) {
                return bVar;
            }
        }
        return null;
    }

    public List<b> K(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (b bVar : this.n) {
            d dVar = bVar.f51555a;
            if (dVar != null && TextUtils.equals(str, dVar.f46351e)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.c0.b.a
    @NonNull
    /* renamed from: L */
    public TextureMapView v(@NonNull Context context) {
        return this.l;
    }
}
