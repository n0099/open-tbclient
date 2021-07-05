package d.a.q0.j.k.f;

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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d.a.q0.a.h1.c.h.d;
import d.a.q0.a.k;
import d.a.q0.a.v2.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f53784a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements t.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.h1.c.h.d f53785a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.j.n.b f53786b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f53787c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f53788d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.j.n.c f53789e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f53790f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ List f53791g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f53792h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f53793i;

        public a(d.a.q0.a.h1.c.h.d dVar, d.a.q0.j.n.b bVar, List list, Context context, d.a.q0.j.n.c cVar, List list2, List list3, AtomicInteger atomicInteger, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, bVar, list, context, cVar, list2, list3, atomicInteger, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53785a = dVar;
            this.f53786b = bVar;
            this.f53787c = list;
            this.f53788d = context;
            this.f53789e = cVar;
            this.f53790f = list2;
            this.f53791g = list3;
            this.f53792h = atomicInteger;
            this.f53793i = i2;
        }

        @Override // d.a.q0.a.v2.t.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (g.f53784a) {
                    Log.d("MarkerViewCreateHelper", "url=" + str);
                }
                if (bitmap == null) {
                    bitmap = g.f();
                }
                Bitmap g2 = g.g(bitmap, this.f53785a);
                d.a.q0.a.h1.c.h.c cVar = this.f53785a.f48610f;
                LatLng latLng = new LatLng(cVar.f48607e, cVar.f48608f);
                MarkerOptions zIndex = new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(g2)).alpha((float) this.f53785a.j).title(this.f53785a.f48611g).rotate((float) this.f53785a.f48613i).zIndex(88);
                d.a aVar = this.f53785a.o;
                MarkerOptions anchor = zIndex.anchor((float) aVar.f48614e, (float) aVar.f48615f);
                this.f53786b.f53807a = this.f53785a;
                this.f53787c.add(anchor);
                LinearLayout linearLayout = new LinearLayout(this.f53788d);
                linearLayout.setOrientation(1);
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                linearLayout.setGravity(17);
                View view = new View(this.f53788d);
                view.setLayoutParams(new ViewGroup.LayoutParams(g2.getWidth(), g2.getHeight()));
                view.setVisibility(4);
                linearLayout.addView(view);
                this.f53786b.f53811e = linearLayout;
                if (d.a.q0.j.n.b.f53806h.booleanValue()) {
                    d.b bVar = this.f53785a.m;
                    if (bVar != null && bVar.isValid() && TextUtils.equals(this.f53785a.m.k, "ALWAYS")) {
                        View a2 = d.a.q0.j.k.f.a.a(this.f53789e, this.f53785a);
                        linearLayout.addView(a2, 0);
                        this.f53786b.f53810d = a2;
                    }
                    d.c cVar2 = this.f53785a.n;
                    if (cVar2 != null && cVar2.isValid()) {
                        this.f53790f.add(c.a(this.f53789e, this.f53786b));
                    }
                }
                linearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                builder.position(latLng);
                builder.yOffset((int) ((g2.getHeight() * (1.0d - this.f53785a.o.f48615f)) + 0.0d));
                this.f53789e.l.addView(linearLayout, builder.build());
                linearLayout.setAlpha(0.0f);
                BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(linearLayout);
                if (fromView == null) {
                    return;
                }
                Bitmap bitmap2 = fromView.getBitmap();
                this.f53791g.add(new MarkerOptions().position(latLng).icon(fromView).anchor(((float) (((bitmap2.getWidth() - g2.getWidth()) / 2.0f) + (this.f53785a.o.f48614e * g2.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - g2.getHeight())) + (this.f53785a.o.f48615f * g2.getHeight()))) / bitmap2.getHeight()).zIndex(66));
                synchronized (e.f53782a) {
                    this.f53792h.getAndIncrement();
                    this.f53789e.n.add(this.f53786b);
                    int size = this.f53789e.n.size();
                    if (this.f53793i == this.f53792h.get()) {
                        List<Overlay> addOverlays = this.f53789e.l.getMap().addOverlays(this.f53790f);
                        int size2 = addOverlays.size();
                        for (int i2 = 0; i2 < size2 && i2 < size; i2++) {
                            this.f53789e.n.get(i2).f53809c = (Marker) addOverlays.get(i2);
                        }
                        List<Overlay> addOverlays2 = this.f53789e.l.getMap().addOverlays(this.f53787c);
                        int size3 = addOverlays2.size();
                        for (int i3 = 0; i3 < size3 && i3 < size; i3++) {
                            this.f53789e.n.get(i3).f53808b = (Marker) addOverlays2.get(i3);
                        }
                        List<Overlay> addOverlays3 = this.f53789e.l.getMap().addOverlays(this.f53791g);
                        int size4 = addOverlays3.size();
                        for (int i4 = 0; i4 < size4 && i4 < size; i4++) {
                            this.f53789e.n.get(i4).f53812f = (Marker) addOverlays3.get(i4);
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2078007119, "Ld/a/q0/j/k/f/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2078007119, "Ld/a/q0/j/k/f/g;");
                return;
            }
        }
        f53784a = k.f49133a;
    }

    public static void d(@NonNull d.a.q0.a.h1.c.c cVar, @NonNull d.a.q0.j.n.c cVar2, d.a.q0.j.l.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65540, null, cVar, cVar2, bVar) == null) {
            List<d.a.q0.a.h1.c.h.b> list = cVar.s;
            if (list != null && list.size() > 0) {
                for (d.a.q0.a.h1.c.h.b bVar2 : cVar.s) {
                    b.a(cVar2, bVar2, bVar);
                    d.a.q0.a.e0.d.g("map", "initMapView createControl id " + bVar2.f48603e);
                }
            }
            ArrayList arrayList = new ArrayList();
            List<d.a.q0.a.h1.c.h.f> list2 = cVar.q;
            if (list2 != null && list2.size() > 0) {
                for (d.a.q0.a.h1.c.h.f fVar : cVar.q) {
                    if (!fVar.isValid()) {
                        d.a.q0.a.e0.d.b("map", "polyline is invalid");
                    } else {
                        ArrayList arrayList2 = new ArrayList(fVar.f48626e.size());
                        Iterator<d.a.q0.a.h1.c.h.c> it = fVar.f48626e.iterator();
                        while (it.hasNext()) {
                            d.a.q0.a.h1.c.h.c next = it.next();
                            arrayList2.add(new LatLng(next.f48607e, next.f48608f));
                        }
                        if (arrayList2.size() >= 2 && !arrayList2.contains(null)) {
                            arrayList.add(new PolylineOptions().points(arrayList2).color(fVar.f48627f).width((int) fVar.f48628g).dottedLine(fVar.f48629h));
                            d.a.q0.a.e0.d.g("map", "initMapView createPoly");
                        } else {
                            d.a.q0.a.e0.d.b("map", "polyline count can't less than 2 or your polyline points contains null");
                        }
                    }
                }
            }
            List<d.a.q0.a.h1.c.h.e> list3 = cVar.u;
            if (list3 != null && !list3.isEmpty()) {
                for (d.a.q0.a.h1.c.h.e eVar : cVar.u) {
                    if (!eVar.isValid()) {
                        d.a.q0.a.e0.d.b("map", "polygon is invalid");
                    } else {
                        ArrayList arrayList3 = new ArrayList(eVar.f48621e.size());
                        Iterator<d.a.q0.a.h1.c.h.c> it2 = eVar.f48621e.iterator();
                        while (it2.hasNext()) {
                            d.a.q0.a.h1.c.h.c next2 = it2.next();
                            arrayList3.add(new LatLng(next2.f48607e, next2.f48608f));
                        }
                        if (arrayList3.size() >= 3 && !arrayList3.contains(null)) {
                            arrayList.add(new PolygonOptions().points(arrayList3).stroke(new Stroke(eVar.f48622f, eVar.f48623g)).fillColor(eVar.f48624h).zIndex(eVar.f48625i));
                            d.a.q0.a.e0.d.g("map", "initMapView createPolygons");
                        } else {
                            d.a.q0.a.e0.d.b("map", "polygons count can't less than 3 or your polygons points contains null");
                        }
                    }
                }
            }
            List<d.a.q0.a.h1.c.h.c> list4 = cVar.t;
            if (list4 != null && list4.size() > 0) {
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                for (d.a.q0.a.h1.c.h.c cVar3 : cVar.t) {
                    builder.include(new LatLng(cVar3.f48607e, cVar3.f48608f));
                }
                cVar2.l.getMap().setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
                d.a.q0.a.e0.d.g("map", "initMapView includePoints");
            }
            List<d.a.q0.a.h1.c.h.a> list5 = cVar.r;
            if (list5 != null && list5.size() > 0) {
                for (d.a.q0.a.h1.c.h.a aVar : cVar.r) {
                    if (aVar.isValid()) {
                        CircleOptions circleOptions = new CircleOptions();
                        d.a.q0.a.h1.c.h.c cVar4 = aVar.f48598e;
                        arrayList.add(circleOptions.center(new LatLng(cVar4.f48607e, cVar4.f48608f)).stroke(new Stroke((int) aVar.f48602i, aVar.f48599f)).fillColor(aVar.f48600g).radius(aVar.f48601h));
                        d.a.q0.a.e0.d.g("map", "initMapView createCircle");
                    }
                }
            }
            cVar2.l.getMap().addOverlays(arrayList);
        }
    }

    public static void e(Context context, @NonNull d.a.q0.a.h1.c.c cVar, @NonNull d.a.q0.j.n.c cVar2) {
        List<d.a.q0.a.h1.c.h.d> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, context, cVar, cVar2) == null) || (list = cVar.p) == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = list.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Iterator<d.a.q0.a.h1.c.h.d> it = list.iterator();
        while (it.hasNext()) {
            d.a.q0.a.h1.c.h.d next = it.next();
            d.a.q0.j.n.b bVar = new d.a.q0.j.n.b();
            if (next.o == null) {
                next.o = new d.a();
            }
            String str = next.f48612h;
            if (TextUtils.isEmpty(str)) {
                str = ImageRequestBuilder.newBuilderWithResourceId(d.a.q0.j.d.pin_red).build().getSourceUri().toString();
            }
            t.e(str, new a(next, bVar, arrayList, context, cVar2, arrayList2, arrayList3, atomicInteger, size));
            it = it;
            arrayList = arrayList;
        }
    }

    public static Bitmap f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? BitmapFactory.decodeResource(AppRuntime.getAppContext().getResources(), d.a.q0.j.d.pin_red) : (Bitmap) invokeV.objValue;
    }

    @Nullable
    public static Bitmap g(Bitmap bitmap, d.a.q0.a.h1.c.h.d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, bitmap, dVar)) == null) {
            int i2 = dVar.k;
            if (i2 == -1) {
                i2 = bitmap.getWidth();
            }
            int i3 = dVar.l;
            if (i3 == -1) {
                i3 = bitmap.getHeight();
            }
            return d.a.q0.j.r.b.a(bitmap, i2, i3);
        }
        return (Bitmap) invokeLL.objValue;
    }
}
