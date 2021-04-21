package d.b.h0.h.a.f.f;

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
import d.b.h0.a.a1.c.h.d;
import d.b.h0.a.i2.s;
import d.b.h0.a.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49458a = k.f45772a;

    /* loaded from: classes3.dex */
    public static class a implements s.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.a1.c.h.d f49459a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.h.a.i.b f49460b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f49461c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f49462d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.h.a.i.c f49463e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f49464f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ List f49465g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f49466h;
        public final /* synthetic */ int i;

        public a(d.b.h0.a.a1.c.h.d dVar, d.b.h0.h.a.i.b bVar, List list, Context context, d.b.h0.h.a.i.c cVar, List list2, List list3, AtomicInteger atomicInteger, int i) {
            this.f49459a = dVar;
            this.f49460b = bVar;
            this.f49461c = list;
            this.f49462d = context;
            this.f49463e = cVar;
            this.f49464f = list2;
            this.f49465g = list3;
            this.f49466h = atomicInteger;
            this.i = i;
        }

        @Override // d.b.h0.a.i2.s.b
        public void a(String str, Bitmap bitmap) {
            if (f.f49458a) {
                Log.d("MarkerViewCreateHelper", "url=" + str);
            }
            if (bitmap == null) {
                bitmap = f.f();
            }
            Bitmap g2 = f.g(bitmap, this.f49459a);
            d.b.h0.a.a1.c.h.c cVar = this.f49459a.f43915f;
            LatLng latLng = new LatLng(cVar.f43912e, cVar.f43913f);
            MarkerOptions zIndex = new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(g2)).alpha((float) this.f49459a.j).title(this.f49459a.f43916g).rotate((float) this.f49459a.i).zIndex(88);
            d.a aVar = this.f49459a.o;
            MarkerOptions anchor = zIndex.anchor((float) aVar.f43918e, (float) aVar.f43919f);
            this.f49460b.f49479a = this.f49459a;
            this.f49461c.add(anchor);
            LinearLayout linearLayout = new LinearLayout(this.f49462d);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            linearLayout.setGravity(17);
            View view = new View(this.f49462d);
            view.setLayoutParams(new ViewGroup.LayoutParams(g2.getWidth(), g2.getHeight()));
            view.setVisibility(4);
            linearLayout.addView(view);
            this.f49460b.f49483e = linearLayout;
            if (d.b.h0.h.a.i.b.f49478h.booleanValue()) {
                d.b bVar = this.f49459a.m;
                if (bVar != null && bVar.isValid() && TextUtils.equals(this.f49459a.m.k, "ALWAYS")) {
                    View a2 = d.b.h0.h.a.f.f.a.a(this.f49463e, this.f49459a);
                    linearLayout.addView(a2, 0);
                    this.f49460b.f49482d = a2;
                }
                d.c cVar2 = this.f49459a.n;
                if (cVar2 != null && cVar2.isValid()) {
                    this.f49464f.add(c.a(this.f49463e, this.f49460b));
                }
            }
            linearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(latLng);
            builder.yOffset((int) ((g2.getHeight() * (1.0d - this.f49459a.o.f43919f)) + 0.0d));
            this.f49463e.l.addView(linearLayout, builder.build());
            linearLayout.setAlpha(0.0f);
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(linearLayout);
            if (fromView == null) {
                return;
            }
            Bitmap bitmap2 = fromView.getBitmap();
            this.f49465g.add(new MarkerOptions().position(latLng).icon(fromView).anchor(((float) (((bitmap2.getWidth() - g2.getWidth()) / 2.0f) + (this.f49459a.o.f43918e * g2.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - g2.getHeight())) + (this.f49459a.o.f43919f * g2.getHeight()))) / bitmap2.getHeight()).zIndex(66));
            this.f49466h.getAndIncrement();
            this.f49463e.n.add(this.f49460b);
            if (this.i == this.f49466h.get()) {
                List<Overlay> addOverlays = this.f49463e.l.getMap().addOverlays(this.f49464f);
                int size = addOverlays.size();
                for (int i = 0; i < size; i++) {
                    this.f49463e.n.get(i).f49481c = (Marker) addOverlays.get(i);
                }
                List<Overlay> addOverlays2 = this.f49463e.l.getMap().addOverlays(this.f49461c);
                int size2 = addOverlays2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    this.f49463e.n.get(i2).f49480b = (Marker) addOverlays2.get(i2);
                }
                List<Overlay> addOverlays3 = this.f49463e.l.getMap().addOverlays(this.f49465g);
                int size3 = addOverlays3.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.f49463e.n.get(i3).f49484f = (Marker) addOverlays3.get(i3);
                }
            }
        }
    }

    public static void d(@NonNull d.b.h0.a.a1.c.c cVar, @NonNull d.b.h0.h.a.i.c cVar2, d.b.h0.h.a.g.b bVar) {
        List<d.b.h0.a.a1.c.h.b> list = cVar.s;
        if (list != null && list.size() > 0) {
            for (d.b.h0.a.a1.c.h.b bVar2 : cVar.s) {
                b.a(cVar2, bVar2, bVar);
                d.b.h0.a.c0.c.g("map", "initMapView createControl id " + bVar2.f43908e);
            }
        }
        ArrayList arrayList = new ArrayList();
        List<d.b.h0.a.a1.c.h.f> list2 = cVar.q;
        if (list2 != null && list2.size() > 0) {
            for (d.b.h0.a.a1.c.h.f fVar : cVar.q) {
                if (!fVar.isValid()) {
                    d.b.h0.a.c0.c.b("map", "polyline is invalid");
                } else {
                    ArrayList arrayList2 = new ArrayList(fVar.f43928e.size());
                    Iterator<d.b.h0.a.a1.c.h.c> it = fVar.f43928e.iterator();
                    while (it.hasNext()) {
                        d.b.h0.a.a1.c.h.c next = it.next();
                        arrayList2.add(new LatLng(next.f43912e, next.f43913f));
                    }
                    if (arrayList2.size() >= 2 && !arrayList2.contains(null)) {
                        arrayList.add(new PolylineOptions().points(arrayList2).color(fVar.f43929f).width((int) fVar.f43930g).dottedLine(fVar.f43931h));
                        d.b.h0.a.c0.c.g("map", "initMapView createPoly");
                    } else {
                        d.b.h0.a.c0.c.b("map", "polyline count can't less than 2 or your polyline points contains null");
                    }
                }
            }
        }
        List<d.b.h0.a.a1.c.h.e> list3 = cVar.u;
        if (list3 != null && !list3.isEmpty()) {
            for (d.b.h0.a.a1.c.h.e eVar : cVar.u) {
                if (!eVar.isValid()) {
                    d.b.h0.a.c0.c.b("map", "polygon is invalid");
                } else {
                    ArrayList arrayList3 = new ArrayList(eVar.f43924e.size());
                    Iterator<d.b.h0.a.a1.c.h.c> it2 = eVar.f43924e.iterator();
                    while (it2.hasNext()) {
                        d.b.h0.a.a1.c.h.c next2 = it2.next();
                        arrayList3.add(new LatLng(next2.f43912e, next2.f43913f));
                    }
                    if (arrayList3.size() >= 3 && !arrayList3.contains(null)) {
                        arrayList.add(new PolygonOptions().points(arrayList3).stroke(new Stroke(eVar.f43925f, eVar.f43926g)).fillColor(eVar.f43927h).zIndex(eVar.i));
                        d.b.h0.a.c0.c.g("map", "initMapView createPolygons");
                    } else {
                        d.b.h0.a.c0.c.b("map", "polygons count can't less than 3 or your polygons points contains null");
                    }
                }
            }
        }
        List<d.b.h0.a.a1.c.h.c> list4 = cVar.t;
        if (list4 != null && list4.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (d.b.h0.a.a1.c.h.c cVar3 : cVar.t) {
                builder.include(new LatLng(cVar3.f43912e, cVar3.f43913f));
            }
            cVar2.l.getMap().setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
            d.b.h0.a.c0.c.g("map", "initMapView includePoints");
        }
        List<d.b.h0.a.a1.c.h.a> list5 = cVar.r;
        if (list5 != null && list5.size() > 0) {
            for (d.b.h0.a.a1.c.h.a aVar : cVar.r) {
                if (aVar.isValid()) {
                    CircleOptions circleOptions = new CircleOptions();
                    d.b.h0.a.a1.c.h.c cVar4 = aVar.f43904e;
                    arrayList.add(circleOptions.center(new LatLng(cVar4.f43912e, cVar4.f43913f)).stroke(new Stroke((int) aVar.i, aVar.f43905f)).fillColor(aVar.f43906g).radius(aVar.f43907h));
                    d.b.h0.a.c0.c.g("map", "initMapView createCircle");
                }
            }
        }
        cVar2.l.getMap().addOverlays(arrayList);
    }

    public static void e(Context context, @NonNull d.b.h0.a.a1.c.c cVar, @NonNull d.b.h0.h.a.i.c cVar2) {
        List<d.b.h0.a.a1.c.h.d> list = cVar.p;
        if (list == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = list.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Iterator<d.b.h0.a.a1.c.h.d> it = list.iterator();
        while (it.hasNext()) {
            d.b.h0.a.a1.c.h.d next = it.next();
            d.b.h0.h.a.i.b bVar = new d.b.h0.h.a.i.b();
            if (next.o == null) {
                next.o = new d.a();
            }
            String str = next.f43917h;
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
    public static Bitmap g(Bitmap bitmap, d.b.h0.a.a1.c.h.d dVar) {
        int i = dVar.k;
        if (i == -1) {
            i = bitmap.getWidth();
        }
        int i2 = dVar.l;
        if (i2 == -1) {
            i2 = bitmap.getHeight();
        }
        return d.b.h0.h.a.m.b.a(bitmap, i, i2);
    }
}
