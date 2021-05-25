package d.a.l0.j.k.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.CircleOptions;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.PolygonOptions;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.map.Stroke;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d.a.l0.a.h1.c.h.d;
import d.a.l0.a.k;
import d.a.l0.a.v2.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47858a = k.f43199a;

    /* loaded from: classes3.dex */
    public static class a implements t.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h1.c.h.d f47859a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.j.n.b f47860b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f47861c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f47862d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.j.n.c f47863e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f47864f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ List f47865g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f47866h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f47867i;

        public a(d.a.l0.a.h1.c.h.d dVar, d.a.l0.j.n.b bVar, List list, Context context, d.a.l0.j.n.c cVar, List list2, List list3, AtomicInteger atomicInteger, int i2) {
            this.f47859a = dVar;
            this.f47860b = bVar;
            this.f47861c = list;
            this.f47862d = context;
            this.f47863e = cVar;
            this.f47864f = list2;
            this.f47865g = list3;
            this.f47866h = atomicInteger;
            this.f47867i = i2;
        }

        @Override // d.a.l0.a.v2.t.b
        public void a(String str, Bitmap bitmap) {
            if (g.f47858a) {
                Log.d("MarkerViewCreateHelper", "url=" + str);
            }
            if (bitmap == null) {
                bitmap = g.f();
            }
            Bitmap g2 = g.g(bitmap, this.f47859a);
            d.a.l0.a.h1.c.h.c cVar = this.f47859a.f42676f;
            LatLng latLng = new LatLng(cVar.f42673e, cVar.f42674f);
            MarkerOptions zIndex = new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(g2)).alpha((float) this.f47859a.j).title(this.f47859a.f42677g).rotate((float) this.f47859a.f42679i).zIndex(88);
            d.a aVar = this.f47859a.o;
            MarkerOptions anchor = zIndex.anchor((float) aVar.f42680e, (float) aVar.f42681f);
            this.f47860b.f47881a = this.f47859a;
            this.f47861c.add(anchor);
            LinearLayout linearLayout = new LinearLayout(this.f47862d);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            linearLayout.setGravity(17);
            View view = new View(this.f47862d);
            view.setLayoutParams(new ViewGroup.LayoutParams(g2.getWidth(), g2.getHeight()));
            view.setVisibility(4);
            linearLayout.addView(view);
            this.f47860b.f47885e = linearLayout;
            if (d.a.l0.j.n.b.f47880h.booleanValue()) {
                d.b bVar = this.f47859a.m;
                if (bVar != null && bVar.isValid() && TextUtils.equals(this.f47859a.m.k, "ALWAYS")) {
                    View a2 = d.a.l0.j.k.f.a.a(this.f47863e, this.f47859a);
                    linearLayout.addView(a2, 0);
                    this.f47860b.f47884d = a2;
                }
                d.c cVar2 = this.f47859a.n;
                if (cVar2 != null && cVar2.isValid()) {
                    this.f47864f.add(c.a(this.f47863e, this.f47860b));
                }
            }
            linearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(latLng);
            builder.yOffset((int) ((g2.getHeight() * (1.0d - this.f47859a.o.f42681f)) + 0.0d));
            this.f47863e.l.addView(linearLayout, builder.build());
            linearLayout.setAlpha(0.0f);
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(linearLayout);
            if (fromView == null) {
                return;
            }
            Bitmap bitmap2 = fromView.getBitmap();
            this.f47865g.add(new MarkerOptions().position(latLng).icon(fromView).anchor(((float) (((bitmap2.getWidth() - g2.getWidth()) / 2.0f) + (this.f47859a.o.f42680e * g2.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - g2.getHeight())) + (this.f47859a.o.f42681f * g2.getHeight()))) / bitmap2.getHeight()).zIndex(66));
            synchronized (e.f47856a) {
                this.f47866h.getAndIncrement();
                this.f47863e.n.add(this.f47860b);
                int size = this.f47863e.n.size();
                if (this.f47867i == this.f47866h.get()) {
                    List<Overlay> addOverlays = this.f47863e.l.getMap().addOverlays(this.f47864f);
                    int size2 = addOverlays.size();
                    for (int i2 = 0; i2 < size2 && i2 < size; i2++) {
                        this.f47863e.n.get(i2).f47883c = (Marker) addOverlays.get(i2);
                    }
                    List<Overlay> addOverlays2 = this.f47863e.l.getMap().addOverlays(this.f47861c);
                    int size3 = addOverlays2.size();
                    for (int i3 = 0; i3 < size3 && i3 < size; i3++) {
                        this.f47863e.n.get(i3).f47882b = (Marker) addOverlays2.get(i3);
                    }
                    List<Overlay> addOverlays3 = this.f47863e.l.getMap().addOverlays(this.f47865g);
                    int size4 = addOverlays3.size();
                    for (int i4 = 0; i4 < size4 && i4 < size; i4++) {
                        this.f47863e.n.get(i4).f47886f = (Marker) addOverlays3.get(i4);
                    }
                }
            }
        }
    }

    public static void d(@NonNull d.a.l0.a.h1.c.c cVar, @NonNull d.a.l0.j.n.c cVar2, d.a.l0.j.l.b bVar) {
        List<d.a.l0.a.h1.c.h.b> list = cVar.s;
        if (list != null && list.size() > 0) {
            for (d.a.l0.a.h1.c.h.b bVar2 : cVar.s) {
                b.a(cVar2, bVar2, bVar);
                d.a.l0.a.e0.d.g("map", "initMapView createControl id " + bVar2.f42669e);
            }
        }
        ArrayList arrayList = new ArrayList();
        List<d.a.l0.a.h1.c.h.f> list2 = cVar.q;
        if (list2 != null && list2.size() > 0) {
            for (d.a.l0.a.h1.c.h.f fVar : cVar.q) {
                if (!fVar.isValid()) {
                    d.a.l0.a.e0.d.b("map", "polyline is invalid");
                } else {
                    ArrayList arrayList2 = new ArrayList(fVar.f42692e.size());
                    Iterator<d.a.l0.a.h1.c.h.c> it = fVar.f42692e.iterator();
                    while (it.hasNext()) {
                        d.a.l0.a.h1.c.h.c next = it.next();
                        arrayList2.add(new LatLng(next.f42673e, next.f42674f));
                    }
                    if (arrayList2.size() >= 2 && !arrayList2.contains(null)) {
                        arrayList.add(new PolylineOptions().points(arrayList2).color(fVar.f42693f).width((int) fVar.f42694g).dottedLine(fVar.f42695h));
                        d.a.l0.a.e0.d.g("map", "initMapView createPoly");
                    } else {
                        d.a.l0.a.e0.d.b("map", "polyline count can't less than 2 or your polyline points contains null");
                    }
                }
            }
        }
        List<d.a.l0.a.h1.c.h.e> list3 = cVar.u;
        if (list3 != null && !list3.isEmpty()) {
            for (d.a.l0.a.h1.c.h.e eVar : cVar.u) {
                if (!eVar.isValid()) {
                    d.a.l0.a.e0.d.b("map", "polygon is invalid");
                } else {
                    ArrayList arrayList3 = new ArrayList(eVar.f42687e.size());
                    Iterator<d.a.l0.a.h1.c.h.c> it2 = eVar.f42687e.iterator();
                    while (it2.hasNext()) {
                        d.a.l0.a.h1.c.h.c next2 = it2.next();
                        arrayList3.add(new LatLng(next2.f42673e, next2.f42674f));
                    }
                    if (arrayList3.size() >= 3 && !arrayList3.contains(null)) {
                        arrayList.add(new PolygonOptions().points(arrayList3).stroke(new Stroke(eVar.f42688f, eVar.f42689g)).fillColor(eVar.f42690h).zIndex(eVar.f42691i));
                        d.a.l0.a.e0.d.g("map", "initMapView createPolygons");
                    } else {
                        d.a.l0.a.e0.d.b("map", "polygons count can't less than 3 or your polygons points contains null");
                    }
                }
            }
        }
        List<d.a.l0.a.h1.c.h.c> list4 = cVar.t;
        if (list4 != null && list4.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (d.a.l0.a.h1.c.h.c cVar3 : cVar.t) {
                builder.include(new LatLng(cVar3.f42673e, cVar3.f42674f));
            }
            cVar2.l.getMap().setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
            d.a.l0.a.e0.d.g("map", "initMapView includePoints");
        }
        List<d.a.l0.a.h1.c.h.a> list5 = cVar.r;
        if (list5 != null && list5.size() > 0) {
            for (d.a.l0.a.h1.c.h.a aVar : cVar.r) {
                if (aVar.isValid()) {
                    CircleOptions circleOptions = new CircleOptions();
                    d.a.l0.a.h1.c.h.c cVar4 = aVar.f42664e;
                    arrayList.add(circleOptions.center(new LatLng(cVar4.f42673e, cVar4.f42674f)).stroke(new Stroke((int) aVar.f42668i, aVar.f42665f)).fillColor(aVar.f42666g).radius(aVar.f42667h));
                    d.a.l0.a.e0.d.g("map", "initMapView createCircle");
                }
            }
        }
        cVar2.l.getMap().addOverlays(arrayList);
    }

    public static void e(Context context, @NonNull d.a.l0.a.h1.c.c cVar, @NonNull d.a.l0.j.n.c cVar2) {
        List<d.a.l0.a.h1.c.h.d> list = cVar.p;
        if (list == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = list.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Iterator<d.a.l0.a.h1.c.h.d> it = list.iterator();
        while (it.hasNext()) {
            d.a.l0.a.h1.c.h.d next = it.next();
            d.a.l0.j.n.b bVar = new d.a.l0.j.n.b();
            if (next.o == null) {
                next.o = new d.a();
            }
            String str = next.f42678h;
            if (TextUtils.isEmpty(str)) {
                str = ImageRequestBuilder.newBuilderWithResourceId(d.a.l0.j.d.pin_red).build().getSourceUri().toString();
            }
            t.e(str, new a(next, bVar, arrayList, context, cVar2, arrayList2, arrayList3, atomicInteger, size));
            it = it;
            arrayList = arrayList;
        }
    }

    public static Bitmap f() {
        return BitmapFactory.decodeResource(AppRuntime.getAppContext().getResources(), d.a.l0.j.d.pin_red);
    }

    @Nullable
    public static Bitmap g(Bitmap bitmap, d.a.l0.a.h1.c.h.d dVar) {
        int i2 = dVar.k;
        if (i2 == -1) {
            i2 = bitmap.getWidth();
        }
        int i3 = dVar.l;
        if (i3 == -1) {
            i3 = bitmap.getHeight();
        }
        return d.a.l0.j.r.b.a(bitmap, i2, i3);
    }
}
