package d.b.g0.h.a.f.f;

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
import com.baidu.tieba.R;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d.b.g0.a.a1.c.h.d;
import d.b.g0.a.i2.s;
import d.b.g0.a.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48736a = k.f45050a;

    /* loaded from: classes3.dex */
    public static class a implements s.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.a1.c.h.d f48737a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.h.a.i.b f48738b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f48739c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f48740d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.h.a.i.c f48741e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f48742f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ List f48743g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f48744h;
        public final /* synthetic */ int i;

        public a(d.b.g0.a.a1.c.h.d dVar, d.b.g0.h.a.i.b bVar, List list, Context context, d.b.g0.h.a.i.c cVar, List list2, List list3, AtomicInteger atomicInteger, int i) {
            this.f48737a = dVar;
            this.f48738b = bVar;
            this.f48739c = list;
            this.f48740d = context;
            this.f48741e = cVar;
            this.f48742f = list2;
            this.f48743g = list3;
            this.f48744h = atomicInteger;
            this.i = i;
        }

        @Override // d.b.g0.a.i2.s.b
        public void a(String str, Bitmap bitmap) {
            if (f.f48736a) {
                Log.d("MarkerViewCreateHelper", "url=" + str);
            }
            if (bitmap == null) {
                bitmap = f.f();
            }
            Bitmap g2 = f.g(bitmap, this.f48737a);
            d.b.g0.a.a1.c.h.c cVar = this.f48737a.f43193f;
            LatLng latLng = new LatLng(cVar.f43190e, cVar.f43191f);
            MarkerOptions zIndex = new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(g2)).alpha((float) this.f48737a.j).title(this.f48737a.f43194g).rotate((float) this.f48737a.i).zIndex(88);
            d.a aVar = this.f48737a.o;
            MarkerOptions anchor = zIndex.anchor((float) aVar.f43196e, (float) aVar.f43197f);
            this.f48738b.f48757a = this.f48737a;
            this.f48739c.add(anchor);
            LinearLayout linearLayout = new LinearLayout(this.f48740d);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            linearLayout.setGravity(17);
            View view = new View(this.f48740d);
            view.setLayoutParams(new ViewGroup.LayoutParams(g2.getWidth(), g2.getHeight()));
            view.setVisibility(4);
            linearLayout.addView(view);
            this.f48738b.f48761e = linearLayout;
            if (d.b.g0.h.a.i.b.f48756h.booleanValue()) {
                d.b bVar = this.f48737a.m;
                if (bVar != null && bVar.isValid() && TextUtils.equals(this.f48737a.m.k, "ALWAYS")) {
                    View a2 = d.b.g0.h.a.f.f.a.a(this.f48741e, this.f48737a);
                    linearLayout.addView(a2, 0);
                    this.f48738b.f48760d = a2;
                }
                d.c cVar2 = this.f48737a.n;
                if (cVar2 != null && cVar2.isValid()) {
                    this.f48742f.add(c.a(this.f48741e, this.f48738b));
                }
            }
            linearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(latLng);
            double height = g2.getHeight();
            Double.isNaN(height);
            builder.yOffset((int) ((height * (1.0d - this.f48737a.o.f43197f)) + 0.0d));
            this.f48741e.l.addView(linearLayout, builder.build());
            linearLayout.setAlpha(0.0f);
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(linearLayout);
            if (fromView == null) {
                return;
            }
            Bitmap bitmap2 = fromView.getBitmap();
            double width = (bitmap2.getWidth() - g2.getWidth()) / 2.0f;
            double d2 = this.f48737a.o.f43196e;
            double width2 = g2.getWidth();
            Double.isNaN(width2);
            Double.isNaN(width);
            double height2 = bitmap2.getHeight();
            Double.isNaN(height2);
            double height3 = g2.getHeight();
            Double.isNaN(height3);
            double d3 = (float) ((height2 - 0.0d) - height3);
            double d4 = this.f48737a.o.f43197f;
            double height4 = g2.getHeight();
            Double.isNaN(height4);
            Double.isNaN(d3);
            this.f48743g.add(new MarkerOptions().position(latLng).icon(fromView).anchor(((float) (width + (d2 * width2))) / bitmap2.getWidth(), ((float) (d3 + (d4 * height4))) / bitmap2.getHeight()).zIndex(66));
            this.f48744h.getAndIncrement();
            this.f48741e.n.add(this.f48738b);
            if (this.i == this.f48744h.get()) {
                List<Overlay> addOverlays = this.f48741e.l.getMap().addOverlays(this.f48742f);
                int size = addOverlays.size();
                for (int i = 0; i < size; i++) {
                    this.f48741e.n.get(i).f48759c = (Marker) addOverlays.get(i);
                }
                List<Overlay> addOverlays2 = this.f48741e.l.getMap().addOverlays(this.f48739c);
                int size2 = addOverlays2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    this.f48741e.n.get(i2).f48758b = (Marker) addOverlays2.get(i2);
                }
                List<Overlay> addOverlays3 = this.f48741e.l.getMap().addOverlays(this.f48743g);
                int size3 = addOverlays3.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.f48741e.n.get(i3).f48762f = (Marker) addOverlays3.get(i3);
                }
            }
        }
    }

    public static void d(@NonNull d.b.g0.a.a1.c.c cVar, @NonNull d.b.g0.h.a.i.c cVar2, d.b.g0.h.a.g.b bVar) {
        List<d.b.g0.a.a1.c.h.b> list = cVar.s;
        if (list != null && list.size() > 0) {
            for (d.b.g0.a.a1.c.h.b bVar2 : cVar.s) {
                b.a(cVar2, bVar2, bVar);
                d.b.g0.a.c0.c.g("map", "initMapView createControl id " + bVar2.f43186e);
            }
        }
        ArrayList arrayList = new ArrayList();
        List<d.b.g0.a.a1.c.h.f> list2 = cVar.q;
        if (list2 != null && list2.size() > 0) {
            for (d.b.g0.a.a1.c.h.f fVar : cVar.q) {
                if (!fVar.isValid()) {
                    d.b.g0.a.c0.c.b("map", "polyline is invalid");
                } else {
                    ArrayList arrayList2 = new ArrayList(fVar.f43206e.size());
                    Iterator<d.b.g0.a.a1.c.h.c> it = fVar.f43206e.iterator();
                    while (it.hasNext()) {
                        d.b.g0.a.a1.c.h.c next = it.next();
                        arrayList2.add(new LatLng(next.f43190e, next.f43191f));
                    }
                    if (arrayList2.size() >= 2 && !arrayList2.contains(null)) {
                        arrayList.add(new PolylineOptions().points(arrayList2).color(fVar.f43207f).width((int) fVar.f43208g).dottedLine(fVar.f43209h));
                        d.b.g0.a.c0.c.g("map", "initMapView createPoly");
                    } else {
                        d.b.g0.a.c0.c.b("map", "polyline count can't less than 2 or your polyline points contains null");
                    }
                }
            }
        }
        List<d.b.g0.a.a1.c.h.e> list3 = cVar.u;
        if (list3 != null && !list3.isEmpty()) {
            for (d.b.g0.a.a1.c.h.e eVar : cVar.u) {
                if (!eVar.isValid()) {
                    d.b.g0.a.c0.c.b("map", "polygon is invalid");
                } else {
                    ArrayList arrayList3 = new ArrayList(eVar.f43202e.size());
                    Iterator<d.b.g0.a.a1.c.h.c> it2 = eVar.f43202e.iterator();
                    while (it2.hasNext()) {
                        d.b.g0.a.a1.c.h.c next2 = it2.next();
                        arrayList3.add(new LatLng(next2.f43190e, next2.f43191f));
                    }
                    if (arrayList3.size() >= 3 && !arrayList3.contains(null)) {
                        arrayList.add(new PolygonOptions().points(arrayList3).stroke(new Stroke(eVar.f43203f, eVar.f43204g)).fillColor(eVar.f43205h).zIndex(eVar.i));
                        d.b.g0.a.c0.c.g("map", "initMapView createPolygons");
                    } else {
                        d.b.g0.a.c0.c.b("map", "polygons count can't less than 3 or your polygons points contains null");
                    }
                }
            }
        }
        List<d.b.g0.a.a1.c.h.c> list4 = cVar.t;
        if (list4 != null && list4.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (d.b.g0.a.a1.c.h.c cVar3 : cVar.t) {
                builder.include(new LatLng(cVar3.f43190e, cVar3.f43191f));
            }
            cVar2.l.getMap().setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
            d.b.g0.a.c0.c.g("map", "initMapView includePoints");
        }
        List<d.b.g0.a.a1.c.h.a> list5 = cVar.r;
        if (list5 != null && list5.size() > 0) {
            for (d.b.g0.a.a1.c.h.a aVar : cVar.r) {
                if (aVar.isValid()) {
                    CircleOptions circleOptions = new CircleOptions();
                    d.b.g0.a.a1.c.h.c cVar4 = aVar.f43182e;
                    arrayList.add(circleOptions.center(new LatLng(cVar4.f43190e, cVar4.f43191f)).stroke(new Stroke((int) aVar.i, aVar.f43183f)).fillColor(aVar.f43184g).radius(aVar.f43185h));
                    d.b.g0.a.c0.c.g("map", "initMapView createCircle");
                }
            }
        }
        cVar2.l.getMap().addOverlays(arrayList);
    }

    public static void e(Context context, @NonNull d.b.g0.a.a1.c.c cVar, @NonNull d.b.g0.h.a.i.c cVar2) {
        List<d.b.g0.a.a1.c.h.d> list = cVar.p;
        if (list == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = list.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Iterator<d.b.g0.a.a1.c.h.d> it = list.iterator();
        while (it.hasNext()) {
            d.b.g0.a.a1.c.h.d next = it.next();
            d.b.g0.h.a.i.b bVar = new d.b.g0.h.a.i.b();
            if (next.o == null) {
                next.o = new d.a();
            }
            String str = next.f43195h;
            if (TextUtils.isEmpty(str)) {
                str = ImageRequestBuilder.newBuilderWithResourceId(R.drawable.pin_red).build().getSourceUri().toString();
            }
            s.e(str, new a(next, bVar, arrayList, context, cVar2, arrayList2, arrayList3, atomicInteger, size));
            it = it;
            arrayList = arrayList;
        }
    }

    public static Bitmap f() {
        return BitmapFactory.decodeResource(AppRuntime.getAppContext().getResources(), R.drawable.pin_red);
    }

    @Nullable
    public static Bitmap g(Bitmap bitmap, d.b.g0.a.a1.c.h.d dVar) {
        int i = dVar.k;
        if (i == -1) {
            i = bitmap.getWidth();
        }
        int i2 = dVar.l;
        if (i2 == -1) {
            i2 = bitmap.getHeight();
        }
        return d.b.g0.h.a.m.b.a(bitmap, i, i2);
    }
}
