package d.a.m0.j.k.f;

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
import d.a.m0.a.h1.c.h.d;
import d.a.m0.a.k;
import d.a.m0.a.v2.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f51640a = k.f46983a;

    /* loaded from: classes3.dex */
    public static class a implements t.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.h1.c.h.d f51641a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.j.n.b f51642b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f51643c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f51644d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.j.n.c f51645e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f51646f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ List f51647g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f51648h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f51649i;

        public a(d.a.m0.a.h1.c.h.d dVar, d.a.m0.j.n.b bVar, List list, Context context, d.a.m0.j.n.c cVar, List list2, List list3, AtomicInteger atomicInteger, int i2) {
            this.f51641a = dVar;
            this.f51642b = bVar;
            this.f51643c = list;
            this.f51644d = context;
            this.f51645e = cVar;
            this.f51646f = list2;
            this.f51647g = list3;
            this.f51648h = atomicInteger;
            this.f51649i = i2;
        }

        @Override // d.a.m0.a.v2.t.b
        public void a(String str, Bitmap bitmap) {
            if (g.f51640a) {
                Log.d("MarkerViewCreateHelper", "url=" + str);
            }
            if (bitmap == null) {
                bitmap = g.f();
            }
            Bitmap g2 = g.g(bitmap, this.f51641a);
            d.a.m0.a.h1.c.h.c cVar = this.f51641a.f46460f;
            LatLng latLng = new LatLng(cVar.f46457e, cVar.f46458f);
            MarkerOptions zIndex = new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(g2)).alpha((float) this.f51641a.j).title(this.f51641a.f46461g).rotate((float) this.f51641a.f46463i).zIndex(88);
            d.a aVar = this.f51641a.o;
            MarkerOptions anchor = zIndex.anchor((float) aVar.f46464e, (float) aVar.f46465f);
            this.f51642b.f51663a = this.f51641a;
            this.f51643c.add(anchor);
            LinearLayout linearLayout = new LinearLayout(this.f51644d);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            linearLayout.setGravity(17);
            View view = new View(this.f51644d);
            view.setLayoutParams(new ViewGroup.LayoutParams(g2.getWidth(), g2.getHeight()));
            view.setVisibility(4);
            linearLayout.addView(view);
            this.f51642b.f51667e = linearLayout;
            if (d.a.m0.j.n.b.f51662h.booleanValue()) {
                d.b bVar = this.f51641a.m;
                if (bVar != null && bVar.isValid() && TextUtils.equals(this.f51641a.m.k, "ALWAYS")) {
                    View a2 = d.a.m0.j.k.f.a.a(this.f51645e, this.f51641a);
                    linearLayout.addView(a2, 0);
                    this.f51642b.f51666d = a2;
                }
                d.c cVar2 = this.f51641a.n;
                if (cVar2 != null && cVar2.isValid()) {
                    this.f51646f.add(c.a(this.f51645e, this.f51642b));
                }
            }
            linearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(latLng);
            builder.yOffset((int) ((g2.getHeight() * (1.0d - this.f51641a.o.f46465f)) + 0.0d));
            this.f51645e.l.addView(linearLayout, builder.build());
            linearLayout.setAlpha(0.0f);
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(linearLayout);
            if (fromView == null) {
                return;
            }
            Bitmap bitmap2 = fromView.getBitmap();
            this.f51647g.add(new MarkerOptions().position(latLng).icon(fromView).anchor(((float) (((bitmap2.getWidth() - g2.getWidth()) / 2.0f) + (this.f51641a.o.f46464e * g2.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - g2.getHeight())) + (this.f51641a.o.f46465f * g2.getHeight()))) / bitmap2.getHeight()).zIndex(66));
            synchronized (e.f51638a) {
                this.f51648h.getAndIncrement();
                this.f51645e.n.add(this.f51642b);
                int size = this.f51645e.n.size();
                if (this.f51649i == this.f51648h.get()) {
                    List<Overlay> addOverlays = this.f51645e.l.getMap().addOverlays(this.f51646f);
                    int size2 = addOverlays.size();
                    for (int i2 = 0; i2 < size2 && i2 < size; i2++) {
                        this.f51645e.n.get(i2).f51665c = (Marker) addOverlays.get(i2);
                    }
                    List<Overlay> addOverlays2 = this.f51645e.l.getMap().addOverlays(this.f51643c);
                    int size3 = addOverlays2.size();
                    for (int i3 = 0; i3 < size3 && i3 < size; i3++) {
                        this.f51645e.n.get(i3).f51664b = (Marker) addOverlays2.get(i3);
                    }
                    List<Overlay> addOverlays3 = this.f51645e.l.getMap().addOverlays(this.f51647g);
                    int size4 = addOverlays3.size();
                    for (int i4 = 0; i4 < size4 && i4 < size; i4++) {
                        this.f51645e.n.get(i4).f51668f = (Marker) addOverlays3.get(i4);
                    }
                }
            }
        }
    }

    public static void d(@NonNull d.a.m0.a.h1.c.c cVar, @NonNull d.a.m0.j.n.c cVar2, d.a.m0.j.l.b bVar) {
        List<d.a.m0.a.h1.c.h.b> list = cVar.s;
        if (list != null && list.size() > 0) {
            for (d.a.m0.a.h1.c.h.b bVar2 : cVar.s) {
                b.a(cVar2, bVar2, bVar);
                d.a.m0.a.e0.d.g("map", "initMapView createControl id " + bVar2.f46453e);
            }
        }
        ArrayList arrayList = new ArrayList();
        List<d.a.m0.a.h1.c.h.f> list2 = cVar.q;
        if (list2 != null && list2.size() > 0) {
            for (d.a.m0.a.h1.c.h.f fVar : cVar.q) {
                if (!fVar.isValid()) {
                    d.a.m0.a.e0.d.b("map", "polyline is invalid");
                } else {
                    ArrayList arrayList2 = new ArrayList(fVar.f46476e.size());
                    Iterator<d.a.m0.a.h1.c.h.c> it = fVar.f46476e.iterator();
                    while (it.hasNext()) {
                        d.a.m0.a.h1.c.h.c next = it.next();
                        arrayList2.add(new LatLng(next.f46457e, next.f46458f));
                    }
                    if (arrayList2.size() >= 2 && !arrayList2.contains(null)) {
                        arrayList.add(new PolylineOptions().points(arrayList2).color(fVar.f46477f).width((int) fVar.f46478g).dottedLine(fVar.f46479h));
                        d.a.m0.a.e0.d.g("map", "initMapView createPoly");
                    } else {
                        d.a.m0.a.e0.d.b("map", "polyline count can't less than 2 or your polyline points contains null");
                    }
                }
            }
        }
        List<d.a.m0.a.h1.c.h.e> list3 = cVar.u;
        if (list3 != null && !list3.isEmpty()) {
            for (d.a.m0.a.h1.c.h.e eVar : cVar.u) {
                if (!eVar.isValid()) {
                    d.a.m0.a.e0.d.b("map", "polygon is invalid");
                } else {
                    ArrayList arrayList3 = new ArrayList(eVar.f46471e.size());
                    Iterator<d.a.m0.a.h1.c.h.c> it2 = eVar.f46471e.iterator();
                    while (it2.hasNext()) {
                        d.a.m0.a.h1.c.h.c next2 = it2.next();
                        arrayList3.add(new LatLng(next2.f46457e, next2.f46458f));
                    }
                    if (arrayList3.size() >= 3 && !arrayList3.contains(null)) {
                        arrayList.add(new PolygonOptions().points(arrayList3).stroke(new Stroke(eVar.f46472f, eVar.f46473g)).fillColor(eVar.f46474h).zIndex(eVar.f46475i));
                        d.a.m0.a.e0.d.g("map", "initMapView createPolygons");
                    } else {
                        d.a.m0.a.e0.d.b("map", "polygons count can't less than 3 or your polygons points contains null");
                    }
                }
            }
        }
        List<d.a.m0.a.h1.c.h.c> list4 = cVar.t;
        if (list4 != null && list4.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (d.a.m0.a.h1.c.h.c cVar3 : cVar.t) {
                builder.include(new LatLng(cVar3.f46457e, cVar3.f46458f));
            }
            cVar2.l.getMap().setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
            d.a.m0.a.e0.d.g("map", "initMapView includePoints");
        }
        List<d.a.m0.a.h1.c.h.a> list5 = cVar.r;
        if (list5 != null && list5.size() > 0) {
            for (d.a.m0.a.h1.c.h.a aVar : cVar.r) {
                if (aVar.isValid()) {
                    CircleOptions circleOptions = new CircleOptions();
                    d.a.m0.a.h1.c.h.c cVar4 = aVar.f46448e;
                    arrayList.add(circleOptions.center(new LatLng(cVar4.f46457e, cVar4.f46458f)).stroke(new Stroke((int) aVar.f46452i, aVar.f46449f)).fillColor(aVar.f46450g).radius(aVar.f46451h));
                    d.a.m0.a.e0.d.g("map", "initMapView createCircle");
                }
            }
        }
        cVar2.l.getMap().addOverlays(arrayList);
    }

    public static void e(Context context, @NonNull d.a.m0.a.h1.c.c cVar, @NonNull d.a.m0.j.n.c cVar2) {
        List<d.a.m0.a.h1.c.h.d> list = cVar.p;
        if (list == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = list.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Iterator<d.a.m0.a.h1.c.h.d> it = list.iterator();
        while (it.hasNext()) {
            d.a.m0.a.h1.c.h.d next = it.next();
            d.a.m0.j.n.b bVar = new d.a.m0.j.n.b();
            if (next.o == null) {
                next.o = new d.a();
            }
            String str = next.f46462h;
            if (TextUtils.isEmpty(str)) {
                str = ImageRequestBuilder.newBuilderWithResourceId(d.a.m0.j.d.pin_red).build().getSourceUri().toString();
            }
            t.e(str, new a(next, bVar, arrayList, context, cVar2, arrayList2, arrayList3, atomicInteger, size));
            it = it;
            arrayList = arrayList;
        }
    }

    public static Bitmap f() {
        return BitmapFactory.decodeResource(AppRuntime.getAppContext().getResources(), d.a.m0.j.d.pin_red);
    }

    @Nullable
    public static Bitmap g(Bitmap bitmap, d.a.m0.a.h1.c.h.d dVar) {
        int i2 = dVar.k;
        if (i2 == -1) {
            i2 = bitmap.getWidth();
        }
        int i3 = dVar.l;
        if (i3 == -1) {
            i3 = bitmap.getHeight();
        }
        return d.a.m0.j.r.b.a(bitmap, i2, i3);
    }
}
