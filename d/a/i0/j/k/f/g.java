package d.a.i0.j.k.f;

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
import d.a.i0.a.h1.c.h.d;
import d.a.i0.a.k;
import d.a.i0.a.v2.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47682a = k.f43025a;

    /* loaded from: classes3.dex */
    public static class a implements t.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.h1.c.h.d f47683a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.j.n.b f47684b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f47685c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f47686d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.j.n.c f47687e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f47688f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ List f47689g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f47690h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f47691i;

        public a(d.a.i0.a.h1.c.h.d dVar, d.a.i0.j.n.b bVar, List list, Context context, d.a.i0.j.n.c cVar, List list2, List list3, AtomicInteger atomicInteger, int i2) {
            this.f47683a = dVar;
            this.f47684b = bVar;
            this.f47685c = list;
            this.f47686d = context;
            this.f47687e = cVar;
            this.f47688f = list2;
            this.f47689g = list3;
            this.f47690h = atomicInteger;
            this.f47691i = i2;
        }

        @Override // d.a.i0.a.v2.t.b
        public void a(String str, Bitmap bitmap) {
            if (g.f47682a) {
                Log.d("MarkerViewCreateHelper", "url=" + str);
            }
            if (bitmap == null) {
                bitmap = g.f();
            }
            Bitmap g2 = g.g(bitmap, this.f47683a);
            d.a.i0.a.h1.c.h.c cVar = this.f47683a.f42502f;
            LatLng latLng = new LatLng(cVar.f42499e, cVar.f42500f);
            MarkerOptions zIndex = new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(g2)).alpha((float) this.f47683a.j).title(this.f47683a.f42503g).rotate((float) this.f47683a.f42505i).zIndex(88);
            d.a aVar = this.f47683a.o;
            MarkerOptions anchor = zIndex.anchor((float) aVar.f42506e, (float) aVar.f42507f);
            this.f47684b.f47705a = this.f47683a;
            this.f47685c.add(anchor);
            LinearLayout linearLayout = new LinearLayout(this.f47686d);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            linearLayout.setGravity(17);
            View view = new View(this.f47686d);
            view.setLayoutParams(new ViewGroup.LayoutParams(g2.getWidth(), g2.getHeight()));
            view.setVisibility(4);
            linearLayout.addView(view);
            this.f47684b.f47709e = linearLayout;
            if (d.a.i0.j.n.b.f47704h.booleanValue()) {
                d.b bVar = this.f47683a.m;
                if (bVar != null && bVar.isValid() && TextUtils.equals(this.f47683a.m.k, "ALWAYS")) {
                    View a2 = d.a.i0.j.k.f.a.a(this.f47687e, this.f47683a);
                    linearLayout.addView(a2, 0);
                    this.f47684b.f47708d = a2;
                }
                d.c cVar2 = this.f47683a.n;
                if (cVar2 != null && cVar2.isValid()) {
                    this.f47688f.add(c.a(this.f47687e, this.f47684b));
                }
            }
            linearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(latLng);
            builder.yOffset((int) ((g2.getHeight() * (1.0d - this.f47683a.o.f42507f)) + 0.0d));
            this.f47687e.l.addView(linearLayout, builder.build());
            linearLayout.setAlpha(0.0f);
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(linearLayout);
            if (fromView == null) {
                return;
            }
            Bitmap bitmap2 = fromView.getBitmap();
            this.f47689g.add(new MarkerOptions().position(latLng).icon(fromView).anchor(((float) (((bitmap2.getWidth() - g2.getWidth()) / 2.0f) + (this.f47683a.o.f42506e * g2.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - g2.getHeight())) + (this.f47683a.o.f42507f * g2.getHeight()))) / bitmap2.getHeight()).zIndex(66));
            synchronized (e.f47680a) {
                this.f47690h.getAndIncrement();
                this.f47687e.n.add(this.f47684b);
                int size = this.f47687e.n.size();
                if (this.f47691i == this.f47690h.get()) {
                    List<Overlay> addOverlays = this.f47687e.l.getMap().addOverlays(this.f47688f);
                    int size2 = addOverlays.size();
                    for (int i2 = 0; i2 < size2 && i2 < size; i2++) {
                        this.f47687e.n.get(i2).f47707c = (Marker) addOverlays.get(i2);
                    }
                    List<Overlay> addOverlays2 = this.f47687e.l.getMap().addOverlays(this.f47685c);
                    int size3 = addOverlays2.size();
                    for (int i3 = 0; i3 < size3 && i3 < size; i3++) {
                        this.f47687e.n.get(i3).f47706b = (Marker) addOverlays2.get(i3);
                    }
                    List<Overlay> addOverlays3 = this.f47687e.l.getMap().addOverlays(this.f47689g);
                    int size4 = addOverlays3.size();
                    for (int i4 = 0; i4 < size4 && i4 < size; i4++) {
                        this.f47687e.n.get(i4).f47710f = (Marker) addOverlays3.get(i4);
                    }
                }
            }
        }
    }

    public static void d(@NonNull d.a.i0.a.h1.c.c cVar, @NonNull d.a.i0.j.n.c cVar2, d.a.i0.j.l.b bVar) {
        List<d.a.i0.a.h1.c.h.b> list = cVar.s;
        if (list != null && list.size() > 0) {
            for (d.a.i0.a.h1.c.h.b bVar2 : cVar.s) {
                b.a(cVar2, bVar2, bVar);
                d.a.i0.a.e0.d.g("map", "initMapView createControl id " + bVar2.f42495e);
            }
        }
        ArrayList arrayList = new ArrayList();
        List<d.a.i0.a.h1.c.h.f> list2 = cVar.q;
        if (list2 != null && list2.size() > 0) {
            for (d.a.i0.a.h1.c.h.f fVar : cVar.q) {
                if (!fVar.isValid()) {
                    d.a.i0.a.e0.d.b("map", "polyline is invalid");
                } else {
                    ArrayList arrayList2 = new ArrayList(fVar.f42518e.size());
                    Iterator<d.a.i0.a.h1.c.h.c> it = fVar.f42518e.iterator();
                    while (it.hasNext()) {
                        d.a.i0.a.h1.c.h.c next = it.next();
                        arrayList2.add(new LatLng(next.f42499e, next.f42500f));
                    }
                    if (arrayList2.size() >= 2 && !arrayList2.contains(null)) {
                        arrayList.add(new PolylineOptions().points(arrayList2).color(fVar.f42519f).width((int) fVar.f42520g).dottedLine(fVar.f42521h));
                        d.a.i0.a.e0.d.g("map", "initMapView createPoly");
                    } else {
                        d.a.i0.a.e0.d.b("map", "polyline count can't less than 2 or your polyline points contains null");
                    }
                }
            }
        }
        List<d.a.i0.a.h1.c.h.e> list3 = cVar.u;
        if (list3 != null && !list3.isEmpty()) {
            for (d.a.i0.a.h1.c.h.e eVar : cVar.u) {
                if (!eVar.isValid()) {
                    d.a.i0.a.e0.d.b("map", "polygon is invalid");
                } else {
                    ArrayList arrayList3 = new ArrayList(eVar.f42513e.size());
                    Iterator<d.a.i0.a.h1.c.h.c> it2 = eVar.f42513e.iterator();
                    while (it2.hasNext()) {
                        d.a.i0.a.h1.c.h.c next2 = it2.next();
                        arrayList3.add(new LatLng(next2.f42499e, next2.f42500f));
                    }
                    if (arrayList3.size() >= 3 && !arrayList3.contains(null)) {
                        arrayList.add(new PolygonOptions().points(arrayList3).stroke(new Stroke(eVar.f42514f, eVar.f42515g)).fillColor(eVar.f42516h).zIndex(eVar.f42517i));
                        d.a.i0.a.e0.d.g("map", "initMapView createPolygons");
                    } else {
                        d.a.i0.a.e0.d.b("map", "polygons count can't less than 3 or your polygons points contains null");
                    }
                }
            }
        }
        List<d.a.i0.a.h1.c.h.c> list4 = cVar.t;
        if (list4 != null && list4.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (d.a.i0.a.h1.c.h.c cVar3 : cVar.t) {
                builder.include(new LatLng(cVar3.f42499e, cVar3.f42500f));
            }
            cVar2.l.getMap().setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
            d.a.i0.a.e0.d.g("map", "initMapView includePoints");
        }
        List<d.a.i0.a.h1.c.h.a> list5 = cVar.r;
        if (list5 != null && list5.size() > 0) {
            for (d.a.i0.a.h1.c.h.a aVar : cVar.r) {
                if (aVar.isValid()) {
                    CircleOptions circleOptions = new CircleOptions();
                    d.a.i0.a.h1.c.h.c cVar4 = aVar.f42490e;
                    arrayList.add(circleOptions.center(new LatLng(cVar4.f42499e, cVar4.f42500f)).stroke(new Stroke((int) aVar.f42494i, aVar.f42491f)).fillColor(aVar.f42492g).radius(aVar.f42493h));
                    d.a.i0.a.e0.d.g("map", "initMapView createCircle");
                }
            }
        }
        cVar2.l.getMap().addOverlays(arrayList);
    }

    public static void e(Context context, @NonNull d.a.i0.a.h1.c.c cVar, @NonNull d.a.i0.j.n.c cVar2) {
        List<d.a.i0.a.h1.c.h.d> list = cVar.p;
        if (list == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = list.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Iterator<d.a.i0.a.h1.c.h.d> it = list.iterator();
        while (it.hasNext()) {
            d.a.i0.a.h1.c.h.d next = it.next();
            d.a.i0.j.n.b bVar = new d.a.i0.j.n.b();
            if (next.o == null) {
                next.o = new d.a();
            }
            String str = next.f42504h;
            if (TextUtils.isEmpty(str)) {
                str = ImageRequestBuilder.newBuilderWithResourceId(d.a.i0.j.d.pin_red).build().getSourceUri().toString();
            }
            t.e(str, new a(next, bVar, arrayList, context, cVar2, arrayList2, arrayList3, atomicInteger, size));
            it = it;
            arrayList = arrayList;
        }
    }

    public static Bitmap f() {
        return BitmapFactory.decodeResource(AppRuntime.getAppContext().getResources(), d.a.i0.j.d.pin_red);
    }

    @Nullable
    public static Bitmap g(Bitmap bitmap, d.a.i0.a.h1.c.h.d dVar) {
        int i2 = dVar.k;
        if (i2 == -1) {
            i2 = bitmap.getWidth();
        }
        int i3 = dVar.l;
        if (i3 == -1) {
            i3 = bitmap.getHeight();
        }
        return d.a.i0.j.r.b.a(bitmap, i2, i3);
    }
}
