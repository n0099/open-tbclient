package d.a.h0.h.a.f.f;

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
import d.a.h0.a.a1.c.h.d;
import d.a.h0.a.i2.s;
import d.a.h0.a.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46958a = k.f43101a;

    /* loaded from: classes3.dex */
    public static class a implements s.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.a1.c.h.d f46959a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.h.a.i.b f46960b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f46961c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f46962d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.h.a.i.c f46963e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f46964f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ List f46965g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f46966h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f46967i;

        public a(d.a.h0.a.a1.c.h.d dVar, d.a.h0.h.a.i.b bVar, List list, Context context, d.a.h0.h.a.i.c cVar, List list2, List list3, AtomicInteger atomicInteger, int i2) {
            this.f46959a = dVar;
            this.f46960b = bVar;
            this.f46961c = list;
            this.f46962d = context;
            this.f46963e = cVar;
            this.f46964f = list2;
            this.f46965g = list3;
            this.f46966h = atomicInteger;
            this.f46967i = i2;
        }

        @Override // d.a.h0.a.i2.s.b
        public void a(String str, Bitmap bitmap) {
            if (f.f46958a) {
                Log.d("MarkerViewCreateHelper", "url=" + str);
            }
            if (bitmap == null) {
                bitmap = f.f();
            }
            Bitmap g2 = f.g(bitmap, this.f46959a);
            d.a.h0.a.a1.c.h.c cVar = this.f46959a.f41181f;
            LatLng latLng = new LatLng(cVar.f41178e, cVar.f41179f);
            MarkerOptions zIndex = new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(g2)).alpha((float) this.f46959a.j).title(this.f46959a.f41182g).rotate((float) this.f46959a.f41184i).zIndex(88);
            d.a aVar = this.f46959a.o;
            MarkerOptions anchor = zIndex.anchor((float) aVar.f41185e, (float) aVar.f41186f);
            this.f46960b.f46980a = this.f46959a;
            this.f46961c.add(anchor);
            LinearLayout linearLayout = new LinearLayout(this.f46962d);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            linearLayout.setGravity(17);
            View view = new View(this.f46962d);
            view.setLayoutParams(new ViewGroup.LayoutParams(g2.getWidth(), g2.getHeight()));
            view.setVisibility(4);
            linearLayout.addView(view);
            this.f46960b.f46984e = linearLayout;
            if (d.a.h0.h.a.i.b.f46979h.booleanValue()) {
                d.b bVar = this.f46959a.m;
                if (bVar != null && bVar.isValid() && TextUtils.equals(this.f46959a.m.k, "ALWAYS")) {
                    View a2 = d.a.h0.h.a.f.f.a.a(this.f46963e, this.f46959a);
                    linearLayout.addView(a2, 0);
                    this.f46960b.f46983d = a2;
                }
                d.c cVar2 = this.f46959a.n;
                if (cVar2 != null && cVar2.isValid()) {
                    this.f46964f.add(c.a(this.f46963e, this.f46960b));
                }
            }
            linearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
            builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
            builder.position(latLng);
            builder.yOffset((int) ((g2.getHeight() * (1.0d - this.f46959a.o.f41186f)) + 0.0d));
            this.f46963e.l.addView(linearLayout, builder.build());
            linearLayout.setAlpha(0.0f);
            BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(linearLayout);
            if (fromView == null) {
                return;
            }
            Bitmap bitmap2 = fromView.getBitmap();
            this.f46965g.add(new MarkerOptions().position(latLng).icon(fromView).anchor(((float) (((bitmap2.getWidth() - g2.getWidth()) / 2.0f) + (this.f46959a.o.f41185e * g2.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - g2.getHeight())) + (this.f46959a.o.f41186f * g2.getHeight()))) / bitmap2.getHeight()).zIndex(66));
            this.f46966h.getAndIncrement();
            this.f46963e.n.add(this.f46960b);
            if (this.f46967i == this.f46966h.get()) {
                List<Overlay> addOverlays = this.f46963e.l.getMap().addOverlays(this.f46964f);
                int size = addOverlays.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f46963e.n.get(i2).f46982c = (Marker) addOverlays.get(i2);
                }
                List<Overlay> addOverlays2 = this.f46963e.l.getMap().addOverlays(this.f46961c);
                int size2 = addOverlays2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    this.f46963e.n.get(i3).f46981b = (Marker) addOverlays2.get(i3);
                }
                List<Overlay> addOverlays3 = this.f46963e.l.getMap().addOverlays(this.f46965g);
                int size3 = addOverlays3.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    this.f46963e.n.get(i4).f46985f = (Marker) addOverlays3.get(i4);
                }
            }
        }
    }

    public static void d(@NonNull d.a.h0.a.a1.c.c cVar, @NonNull d.a.h0.h.a.i.c cVar2, d.a.h0.h.a.g.b bVar) {
        List<d.a.h0.a.a1.c.h.b> list = cVar.s;
        if (list != null && list.size() > 0) {
            for (d.a.h0.a.a1.c.h.b bVar2 : cVar.s) {
                b.a(cVar2, bVar2, bVar);
                d.a.h0.a.c0.c.g("map", "initMapView createControl id " + bVar2.f41174e);
            }
        }
        ArrayList arrayList = new ArrayList();
        List<d.a.h0.a.a1.c.h.f> list2 = cVar.q;
        if (list2 != null && list2.size() > 0) {
            for (d.a.h0.a.a1.c.h.f fVar : cVar.q) {
                if (!fVar.isValid()) {
                    d.a.h0.a.c0.c.b("map", "polyline is invalid");
                } else {
                    ArrayList arrayList2 = new ArrayList(fVar.f41197e.size());
                    Iterator<d.a.h0.a.a1.c.h.c> it = fVar.f41197e.iterator();
                    while (it.hasNext()) {
                        d.a.h0.a.a1.c.h.c next = it.next();
                        arrayList2.add(new LatLng(next.f41178e, next.f41179f));
                    }
                    if (arrayList2.size() >= 2 && !arrayList2.contains(null)) {
                        arrayList.add(new PolylineOptions().points(arrayList2).color(fVar.f41198f).width((int) fVar.f41199g).dottedLine(fVar.f41200h));
                        d.a.h0.a.c0.c.g("map", "initMapView createPoly");
                    } else {
                        d.a.h0.a.c0.c.b("map", "polyline count can't less than 2 or your polyline points contains null");
                    }
                }
            }
        }
        List<d.a.h0.a.a1.c.h.e> list3 = cVar.u;
        if (list3 != null && !list3.isEmpty()) {
            for (d.a.h0.a.a1.c.h.e eVar : cVar.u) {
                if (!eVar.isValid()) {
                    d.a.h0.a.c0.c.b("map", "polygon is invalid");
                } else {
                    ArrayList arrayList3 = new ArrayList(eVar.f41192e.size());
                    Iterator<d.a.h0.a.a1.c.h.c> it2 = eVar.f41192e.iterator();
                    while (it2.hasNext()) {
                        d.a.h0.a.a1.c.h.c next2 = it2.next();
                        arrayList3.add(new LatLng(next2.f41178e, next2.f41179f));
                    }
                    if (arrayList3.size() >= 3 && !arrayList3.contains(null)) {
                        arrayList.add(new PolygonOptions().points(arrayList3).stroke(new Stroke(eVar.f41193f, eVar.f41194g)).fillColor(eVar.f41195h).zIndex(eVar.f41196i));
                        d.a.h0.a.c0.c.g("map", "initMapView createPolygons");
                    } else {
                        d.a.h0.a.c0.c.b("map", "polygons count can't less than 3 or your polygons points contains null");
                    }
                }
            }
        }
        List<d.a.h0.a.a1.c.h.c> list4 = cVar.t;
        if (list4 != null && list4.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (d.a.h0.a.a1.c.h.c cVar3 : cVar.t) {
                builder.include(new LatLng(cVar3.f41178e, cVar3.f41179f));
            }
            cVar2.l.getMap().setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
            d.a.h0.a.c0.c.g("map", "initMapView includePoints");
        }
        List<d.a.h0.a.a1.c.h.a> list5 = cVar.r;
        if (list5 != null && list5.size() > 0) {
            for (d.a.h0.a.a1.c.h.a aVar : cVar.r) {
                if (aVar.isValid()) {
                    CircleOptions circleOptions = new CircleOptions();
                    d.a.h0.a.a1.c.h.c cVar4 = aVar.f41169e;
                    arrayList.add(circleOptions.center(new LatLng(cVar4.f41178e, cVar4.f41179f)).stroke(new Stroke((int) aVar.f41173i, aVar.f41170f)).fillColor(aVar.f41171g).radius(aVar.f41172h));
                    d.a.h0.a.c0.c.g("map", "initMapView createCircle");
                }
            }
        }
        cVar2.l.getMap().addOverlays(arrayList);
    }

    public static void e(Context context, @NonNull d.a.h0.a.a1.c.c cVar, @NonNull d.a.h0.h.a.i.c cVar2) {
        List<d.a.h0.a.a1.c.h.d> list = cVar.p;
        if (list == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = list.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Iterator<d.a.h0.a.a1.c.h.d> it = list.iterator();
        while (it.hasNext()) {
            d.a.h0.a.a1.c.h.d next = it.next();
            d.a.h0.h.a.i.b bVar = new d.a.h0.h.a.i.b();
            if (next.o == null) {
                next.o = new d.a();
            }
            String str = next.f41183h;
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
    public static Bitmap g(Bitmap bitmap, d.a.h0.a.a1.c.h.d dVar) {
        int i2 = dVar.k;
        if (i2 == -1) {
            i2 = bitmap.getWidth();
        }
        int i3 = dVar.l;
        if (i3 == -1) {
            i3 = bitmap.getHeight();
        }
        return d.a.h0.h.a.m.b.a(bitmap, i2, i3);
    }
}
