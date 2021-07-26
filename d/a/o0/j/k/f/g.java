package d.a.o0.j.k.f;

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
import androidx.core.view.InputDeviceCompat;
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
import d.a.o0.a.h1.c.h.d;
import d.a.o0.a.k;
import d.a.o0.a.v2.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f50986a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements t.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.h1.c.h.d f50987a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.j.n.b f50988b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f50989c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f50990d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.j.n.c f50991e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f50992f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ List f50993g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f50994h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f50995i;

        public a(d.a.o0.a.h1.c.h.d dVar, d.a.o0.j.n.b bVar, List list, Context context, d.a.o0.j.n.c cVar, List list2, List list3, AtomicInteger atomicInteger, int i2) {
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
            this.f50987a = dVar;
            this.f50988b = bVar;
            this.f50989c = list;
            this.f50990d = context;
            this.f50991e = cVar;
            this.f50992f = list2;
            this.f50993g = list3;
            this.f50994h = atomicInteger;
            this.f50995i = i2;
        }

        @Override // d.a.o0.a.v2.t.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (g.f50986a) {
                    Log.d("MarkerViewCreateHelper", "url=" + str);
                }
                if (bitmap == null) {
                    bitmap = g.f();
                }
                Bitmap g2 = g.g(bitmap, this.f50987a);
                d.a.o0.a.h1.c.h.c cVar = this.f50987a.f45812f;
                LatLng latLng = new LatLng(cVar.f45809e, cVar.f45810f);
                MarkerOptions zIndex = new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(g2)).alpha((float) this.f50987a.j).title(this.f50987a.f45813g).rotate((float) this.f50987a.f45815i).zIndex(88);
                d.a aVar = this.f50987a.o;
                MarkerOptions anchor = zIndex.anchor((float) aVar.f45816e, (float) aVar.f45817f);
                this.f50988b.f51009a = this.f50987a;
                this.f50989c.add(anchor);
                LinearLayout linearLayout = new LinearLayout(this.f50990d);
                linearLayout.setOrientation(1);
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                linearLayout.setGravity(17);
                View view = new View(this.f50990d);
                view.setLayoutParams(new ViewGroup.LayoutParams(g2.getWidth(), g2.getHeight()));
                view.setVisibility(4);
                linearLayout.addView(view);
                this.f50988b.f51013e = linearLayout;
                if (d.a.o0.j.n.b.f51008h.booleanValue()) {
                    d.b bVar = this.f50987a.m;
                    if (bVar != null && bVar.isValid() && TextUtils.equals(this.f50987a.m.k, "ALWAYS")) {
                        View a2 = d.a.o0.j.k.f.a.a(this.f50991e, this.f50987a);
                        linearLayout.addView(a2, 0);
                        this.f50988b.f51012d = a2;
                    }
                    d.c cVar2 = this.f50987a.n;
                    if (cVar2 != null && cVar2.isValid()) {
                        this.f50992f.add(c.a(this.f50991e, this.f50988b));
                    }
                }
                linearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                builder.position(latLng);
                builder.yOffset((int) ((g2.getHeight() * (1.0d - this.f50987a.o.f45817f)) + 0.0d));
                this.f50991e.l.addView(linearLayout, builder.build());
                linearLayout.setAlpha(0.0f);
                BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(linearLayout);
                if (fromView == null) {
                    return;
                }
                Bitmap bitmap2 = fromView.getBitmap();
                this.f50993g.add(new MarkerOptions().position(latLng).icon(fromView).anchor(((float) (((bitmap2.getWidth() - g2.getWidth()) / 2.0f) + (this.f50987a.o.f45816e * g2.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - g2.getHeight())) + (this.f50987a.o.f45817f * g2.getHeight()))) / bitmap2.getHeight()).zIndex(66));
                synchronized (e.f50984a) {
                    this.f50994h.getAndIncrement();
                    this.f50991e.n.add(this.f50988b);
                    int size = this.f50991e.n.size();
                    if (this.f50995i == this.f50994h.get()) {
                        List<Overlay> addOverlays = this.f50991e.l.getMap().addOverlays(this.f50992f);
                        int size2 = addOverlays.size();
                        for (int i2 = 0; i2 < size2 && i2 < size; i2++) {
                            this.f50991e.n.get(i2).f51011c = (Marker) addOverlays.get(i2);
                        }
                        List<Overlay> addOverlays2 = this.f50991e.l.getMap().addOverlays(this.f50989c);
                        int size3 = addOverlays2.size();
                        for (int i3 = 0; i3 < size3 && i3 < size; i3++) {
                            this.f50991e.n.get(i3).f51010b = (Marker) addOverlays2.get(i3);
                        }
                        List<Overlay> addOverlays3 = this.f50991e.l.getMap().addOverlays(this.f50993g);
                        int size4 = addOverlays3.size();
                        for (int i4 = 0; i4 < size4 && i4 < size; i4++) {
                            this.f50991e.n.get(i4).f51014f = (Marker) addOverlays3.get(i4);
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1515895599, "Ld/a/o0/j/k/f/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1515895599, "Ld/a/o0/j/k/f/g;");
                return;
            }
        }
        f50986a = k.f46335a;
    }

    public static void d(@NonNull d.a.o0.a.h1.c.c cVar, @NonNull d.a.o0.j.n.c cVar2, d.a.o0.j.l.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cVar, cVar2, bVar) == null) {
            List<d.a.o0.a.h1.c.h.b> list = cVar.s;
            if (list != null && list.size() > 0) {
                for (d.a.o0.a.h1.c.h.b bVar2 : cVar.s) {
                    b.a(cVar2, bVar2, bVar);
                    d.a.o0.a.e0.d.g("map", "initMapView createControl id " + bVar2.f45805e);
                }
            }
            ArrayList arrayList = new ArrayList();
            List<d.a.o0.a.h1.c.h.f> list2 = cVar.q;
            if (list2 != null && list2.size() > 0) {
                for (d.a.o0.a.h1.c.h.f fVar : cVar.q) {
                    if (!fVar.isValid()) {
                        d.a.o0.a.e0.d.b("map", "polyline is invalid");
                    } else {
                        ArrayList arrayList2 = new ArrayList(fVar.f45828e.size());
                        Iterator<d.a.o0.a.h1.c.h.c> it = fVar.f45828e.iterator();
                        while (it.hasNext()) {
                            d.a.o0.a.h1.c.h.c next = it.next();
                            arrayList2.add(new LatLng(next.f45809e, next.f45810f));
                        }
                        if (arrayList2.size() >= 2 && !arrayList2.contains(null)) {
                            arrayList.add(new PolylineOptions().points(arrayList2).color(fVar.f45829f).width((int) fVar.f45830g).dottedLine(fVar.f45831h));
                            d.a.o0.a.e0.d.g("map", "initMapView createPoly");
                        } else {
                            d.a.o0.a.e0.d.b("map", "polyline count can't less than 2 or your polyline points contains null");
                        }
                    }
                }
            }
            List<d.a.o0.a.h1.c.h.e> list3 = cVar.u;
            if (list3 != null && !list3.isEmpty()) {
                for (d.a.o0.a.h1.c.h.e eVar : cVar.u) {
                    if (!eVar.isValid()) {
                        d.a.o0.a.e0.d.b("map", "polygon is invalid");
                    } else {
                        ArrayList arrayList3 = new ArrayList(eVar.f45823e.size());
                        Iterator<d.a.o0.a.h1.c.h.c> it2 = eVar.f45823e.iterator();
                        while (it2.hasNext()) {
                            d.a.o0.a.h1.c.h.c next2 = it2.next();
                            arrayList3.add(new LatLng(next2.f45809e, next2.f45810f));
                        }
                        if (arrayList3.size() >= 3 && !arrayList3.contains(null)) {
                            arrayList.add(new PolygonOptions().points(arrayList3).stroke(new Stroke(eVar.f45824f, eVar.f45825g)).fillColor(eVar.f45826h).zIndex(eVar.f45827i));
                            d.a.o0.a.e0.d.g("map", "initMapView createPolygons");
                        } else {
                            d.a.o0.a.e0.d.b("map", "polygons count can't less than 3 or your polygons points contains null");
                        }
                    }
                }
            }
            List<d.a.o0.a.h1.c.h.c> list4 = cVar.t;
            if (list4 != null && list4.size() > 0) {
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                for (d.a.o0.a.h1.c.h.c cVar3 : cVar.t) {
                    builder.include(new LatLng(cVar3.f45809e, cVar3.f45810f));
                }
                cVar2.l.getMap().setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
                d.a.o0.a.e0.d.g("map", "initMapView includePoints");
            }
            List<d.a.o0.a.h1.c.h.a> list5 = cVar.r;
            if (list5 != null && list5.size() > 0) {
                for (d.a.o0.a.h1.c.h.a aVar : cVar.r) {
                    if (aVar.isValid()) {
                        CircleOptions circleOptions = new CircleOptions();
                        d.a.o0.a.h1.c.h.c cVar4 = aVar.f45800e;
                        arrayList.add(circleOptions.center(new LatLng(cVar4.f45809e, cVar4.f45810f)).stroke(new Stroke((int) aVar.f45804i, aVar.f45801f)).fillColor(aVar.f45802g).radius(aVar.f45803h));
                        d.a.o0.a.e0.d.g("map", "initMapView createCircle");
                    }
                }
            }
            cVar2.l.getMap().addOverlays(arrayList);
        }
    }

    public static void e(Context context, @NonNull d.a.o0.a.h1.c.c cVar, @NonNull d.a.o0.j.n.c cVar2) {
        List<d.a.o0.a.h1.c.h.d> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, context, cVar, cVar2) == null) || (list = cVar.p) == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = list.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Iterator<d.a.o0.a.h1.c.h.d> it = list.iterator();
        while (it.hasNext()) {
            d.a.o0.a.h1.c.h.d next = it.next();
            d.a.o0.j.n.b bVar = new d.a.o0.j.n.b();
            if (next.o == null) {
                next.o = new d.a();
            }
            String str = next.f45814h;
            if (TextUtils.isEmpty(str)) {
                str = ImageRequestBuilder.newBuilderWithResourceId(d.a.o0.j.d.pin_red).build().getSourceUri().toString();
            }
            t.e(str, new a(next, bVar, arrayList, context, cVar2, arrayList2, arrayList3, atomicInteger, size));
            it = it;
            arrayList = arrayList;
        }
    }

    public static Bitmap f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? BitmapFactory.decodeResource(AppRuntime.getAppContext().getResources(), d.a.o0.j.d.pin_red) : (Bitmap) invokeV.objValue;
    }

    @Nullable
    public static Bitmap g(Bitmap bitmap, d.a.o0.a.h1.c.h.d dVar) {
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
            return d.a.o0.j.r.b.a(bitmap, i2, i3);
        }
        return (Bitmap) invokeLL.objValue;
    }
}
