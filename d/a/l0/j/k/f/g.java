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
    public static final boolean f51532a = k.f46875a;

    /* loaded from: classes3.dex */
    public static class a implements t.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h1.c.h.d f51533a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.j.n.b f51534b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f51535c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f51536d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.j.n.c f51537e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f51538f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ List f51539g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f51540h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f51541i;

        public a(d.a.l0.a.h1.c.h.d dVar, d.a.l0.j.n.b bVar, List list, Context context, d.a.l0.j.n.c cVar, List list2, List list3, AtomicInteger atomicInteger, int i2) {
            this.f51533a = dVar;
            this.f51534b = bVar;
            this.f51535c = list;
            this.f51536d = context;
            this.f51537e = cVar;
            this.f51538f = list2;
            this.f51539g = list3;
            this.f51540h = atomicInteger;
            this.f51541i = i2;
        }

        @Override // d.a.l0.a.v2.t.b
        public void a(String str, Bitmap bitmap) {
            if (g.f51532a) {
                Log.d("MarkerViewCreateHelper", "url=" + str);
            }
            if (bitmap == null) {
                bitmap = g.f();
            }
            Bitmap g2 = g.g(bitmap, this.f51533a);
            d.a.l0.a.h1.c.h.c cVar = this.f51533a.f46352f;
            LatLng latLng = new LatLng(cVar.f46349e, cVar.f46350f);
            MarkerOptions zIndex = new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(g2)).alpha((float) this.f51533a.j).title(this.f51533a.f46353g).rotate((float) this.f51533a.f46355i).zIndex(88);
            d.a aVar = this.f51533a.o;
            MarkerOptions anchor = zIndex.anchor((float) aVar.f46356e, (float) aVar.f46357f);
            this.f51534b.f51555a = this.f51533a;
            this.f51535c.add(anchor);
            LinearLayout linearLayout = new LinearLayout(this.f51536d);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            linearLayout.setGravity(17);
            View view = new View(this.f51536d);
            view.setLayoutParams(new ViewGroup.LayoutParams(g2.getWidth(), g2.getHeight()));
            view.setVisibility(4);
            linearLayout.addView(view);
            this.f51534b.f51559e = linearLayout;
            if (d.a.l0.j.n.b.f51554h.booleanValue()) {
                d.b bVar = this.f51533a.m;
                if (bVar != null && bVar.isValid() && TextUtils.equals(this.f51533a.m.k, "ALWAYS")) {
                    View a2 = d.a.l0.j.k.f.a.a(this.f51537e, this.f51533a);
                    linearLayout.addView(a2, 0);
                    this.f51534b.f51558d = a2;
                }
                d.c cVar2 = this.f51533a.n;
                if (cVar2 != null && cVar2.isValid()) {
                    this.f51538f.add(c.a(this.f51537e, this.f51534b));
                }
            }
            linearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(latLng);
            builder.yOffset((int) ((g2.getHeight() * (1.0d - this.f51533a.o.f46357f)) + 0.0d));
            this.f51537e.l.addView(linearLayout, builder.build());
            linearLayout.setAlpha(0.0f);
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(linearLayout);
            if (fromView == null) {
                return;
            }
            Bitmap bitmap2 = fromView.getBitmap();
            this.f51539g.add(new MarkerOptions().position(latLng).icon(fromView).anchor(((float) (((bitmap2.getWidth() - g2.getWidth()) / 2.0f) + (this.f51533a.o.f46356e * g2.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - g2.getHeight())) + (this.f51533a.o.f46357f * g2.getHeight()))) / bitmap2.getHeight()).zIndex(66));
            synchronized (e.f51530a) {
                this.f51540h.getAndIncrement();
                this.f51537e.n.add(this.f51534b);
                int size = this.f51537e.n.size();
                if (this.f51541i == this.f51540h.get()) {
                    List<Overlay> addOverlays = this.f51537e.l.getMap().addOverlays(this.f51538f);
                    int size2 = addOverlays.size();
                    for (int i2 = 0; i2 < size2 && i2 < size; i2++) {
                        this.f51537e.n.get(i2).f51557c = (Marker) addOverlays.get(i2);
                    }
                    List<Overlay> addOverlays2 = this.f51537e.l.getMap().addOverlays(this.f51535c);
                    int size3 = addOverlays2.size();
                    for (int i3 = 0; i3 < size3 && i3 < size; i3++) {
                        this.f51537e.n.get(i3).f51556b = (Marker) addOverlays2.get(i3);
                    }
                    List<Overlay> addOverlays3 = this.f51537e.l.getMap().addOverlays(this.f51539g);
                    int size4 = addOverlays3.size();
                    for (int i4 = 0; i4 < size4 && i4 < size; i4++) {
                        this.f51537e.n.get(i4).f51560f = (Marker) addOverlays3.get(i4);
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
                d.a.l0.a.e0.d.g("map", "initMapView createControl id " + bVar2.f46345e);
            }
        }
        ArrayList arrayList = new ArrayList();
        List<d.a.l0.a.h1.c.h.f> list2 = cVar.q;
        if (list2 != null && list2.size() > 0) {
            for (d.a.l0.a.h1.c.h.f fVar : cVar.q) {
                if (!fVar.isValid()) {
                    d.a.l0.a.e0.d.b("map", "polyline is invalid");
                } else {
                    ArrayList arrayList2 = new ArrayList(fVar.f46368e.size());
                    Iterator<d.a.l0.a.h1.c.h.c> it = fVar.f46368e.iterator();
                    while (it.hasNext()) {
                        d.a.l0.a.h1.c.h.c next = it.next();
                        arrayList2.add(new LatLng(next.f46349e, next.f46350f));
                    }
                    if (arrayList2.size() >= 2 && !arrayList2.contains(null)) {
                        arrayList.add(new PolylineOptions().points(arrayList2).color(fVar.f46369f).width((int) fVar.f46370g).dottedLine(fVar.f46371h));
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
                    ArrayList arrayList3 = new ArrayList(eVar.f46363e.size());
                    Iterator<d.a.l0.a.h1.c.h.c> it2 = eVar.f46363e.iterator();
                    while (it2.hasNext()) {
                        d.a.l0.a.h1.c.h.c next2 = it2.next();
                        arrayList3.add(new LatLng(next2.f46349e, next2.f46350f));
                    }
                    if (arrayList3.size() >= 3 && !arrayList3.contains(null)) {
                        arrayList.add(new PolygonOptions().points(arrayList3).stroke(new Stroke(eVar.f46364f, eVar.f46365g)).fillColor(eVar.f46366h).zIndex(eVar.f46367i));
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
                builder.include(new LatLng(cVar3.f46349e, cVar3.f46350f));
            }
            cVar2.l.getMap().setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
            d.a.l0.a.e0.d.g("map", "initMapView includePoints");
        }
        List<d.a.l0.a.h1.c.h.a> list5 = cVar.r;
        if (list5 != null && list5.size() > 0) {
            for (d.a.l0.a.h1.c.h.a aVar : cVar.r) {
                if (aVar.isValid()) {
                    CircleOptions circleOptions = new CircleOptions();
                    d.a.l0.a.h1.c.h.c cVar4 = aVar.f46340e;
                    arrayList.add(circleOptions.center(new LatLng(cVar4.f46349e, cVar4.f46350f)).stroke(new Stroke((int) aVar.f46344i, aVar.f46341f)).fillColor(aVar.f46342g).radius(aVar.f46343h));
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
            String str = next.f46354h;
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
