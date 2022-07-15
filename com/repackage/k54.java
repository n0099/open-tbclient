package com.repackage;

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
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.repackage.bn2;
import com.repackage.ed3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class k54 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements ed3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bn2 a;
        public final /* synthetic */ p54 b;
        public final /* synthetic */ List c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ q54 e;
        public final /* synthetic */ List f;
        public final /* synthetic */ List g;
        public final /* synthetic */ AtomicInteger h;
        public final /* synthetic */ int i;

        public a(bn2 bn2Var, p54 p54Var, List list, Context context, q54 q54Var, List list2, List list3, AtomicInteger atomicInteger, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bn2Var, p54Var, list, context, q54Var, list2, list3, atomicInteger, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bn2Var;
            this.b = p54Var;
            this.c = list;
            this.d = context;
            this.e = q54Var;
            this.f = list2;
            this.g = list3;
            this.h = atomicInteger;
            this.i = i;
        }

        @Override // com.repackage.ed3.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (k54.a) {
                    Log.d("MarkerViewCreateHelper", "url=" + str);
                }
                if (bitmap == null) {
                    bitmap = k54.f();
                }
                Bitmap g = k54.g(bitmap, this.a);
                an2 an2Var = this.a.b;
                LatLng latLng = new LatLng(an2Var.a, an2Var.b);
                MarkerOptions zIndex = new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(g)).alpha((float) this.a.f).title(this.a.c).rotate((float) this.a.e).zIndex(88);
                bn2.a aVar = this.a.k;
                MarkerOptions anchor = zIndex.anchor((float) aVar.a, (float) aVar.b);
                this.b.a = this.a;
                this.c.add(anchor);
                LinearLayout linearLayout = new LinearLayout(this.d);
                linearLayout.setOrientation(1);
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                linearLayout.setGravity(17);
                View view2 = new View(this.d);
                view2.setLayoutParams(new ViewGroup.LayoutParams(g.getWidth(), g.getHeight()));
                view2.setVisibility(4);
                linearLayout.addView(view2);
                this.b.e = linearLayout;
                if (p54.h.booleanValue()) {
                    bn2.b bVar = this.a.i;
                    if (bVar != null && bVar.isValid() && TextUtils.equals(this.a.i.g, "ALWAYS")) {
                        View a = e54.a(this.e, this.a);
                        linearLayout.addView(a, 0);
                        this.b.d = a;
                    }
                    bn2.c cVar = this.a.j;
                    if (cVar != null && cVar.isValid()) {
                        this.f.add(g54.a(this.e, this.b));
                    }
                }
                linearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                builder.position(latLng);
                builder.yOffset((int) ((g.getHeight() * (1.0d - this.a.k.b)) + 0.0d));
                this.e.l.addView(linearLayout, builder.build());
                linearLayout.setAlpha(0.0f);
                BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(linearLayout);
                if (fromView == null) {
                    return;
                }
                Bitmap bitmap2 = fromView.getBitmap();
                this.g.add(new MarkerOptions().position(latLng).icon(fromView).anchor(((float) (((bitmap2.getWidth() - g.getWidth()) / 2.0f) + (this.a.k.a * g.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - g.getHeight())) + (this.a.k.b * g.getHeight()))) / bitmap2.getHeight()).zIndex(66));
                synchronized (i54.a) {
                    this.h.getAndIncrement();
                    this.e.n.add(this.b);
                    int size = this.e.n.size();
                    if (this.i == this.h.get()) {
                        List<Overlay> addOverlays = this.e.l.getMap().addOverlays(this.f);
                        int size2 = addOverlays.size();
                        for (int i = 0; i < size2 && i < size; i++) {
                            this.e.n.get(i).c = (Marker) addOverlays.get(i);
                        }
                        List<Overlay> addOverlays2 = this.e.l.getMap().addOverlays(this.c);
                        int size3 = addOverlays2.size();
                        for (int i2 = 0; i2 < size3 && i2 < size; i2++) {
                            this.e.n.get(i2).b = (Marker) addOverlays2.get(i2);
                        }
                        List<Overlay> addOverlays3 = this.e.l.getMap().addOverlays(this.g);
                        int size4 = addOverlays3.size();
                        for (int i3 = 0; i3 < size4 && i3 < size; i3++) {
                            this.e.n.get(i3).f = (Marker) addOverlays3.get(i3);
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755607897, "Lcom/repackage/k54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755607897, "Lcom/repackage/k54;");
                return;
            }
        }
        a = rg1.a;
    }

    public static void d(@NonNull tm2 tm2Var, @NonNull q54 q54Var, m54 m54Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tm2Var, q54Var, m54Var) == null) {
            List<zm2> list = tm2Var.o;
            if (list != null && list.size() > 0) {
                for (zm2 zm2Var : tm2Var.o) {
                    f54.a(q54Var, zm2Var, m54Var);
                    hx1.i("map", "initMapView createControl id " + zm2Var.a);
                }
            }
            ArrayList arrayList = new ArrayList();
            List<dn2> list2 = tm2Var.m;
            if (list2 != null && list2.size() > 0) {
                for (dn2 dn2Var : tm2Var.m) {
                    if (!dn2Var.isValid()) {
                        hx1.c("map", "polyline is invalid");
                    } else {
                        ArrayList arrayList2 = new ArrayList(dn2Var.a.size());
                        Iterator<an2> it = dn2Var.a.iterator();
                        while (it.hasNext()) {
                            an2 next = it.next();
                            arrayList2.add(new LatLng(next.a, next.b));
                        }
                        if (arrayList2.size() >= 2 && !arrayList2.contains(null)) {
                            arrayList.add(new PolylineOptions().points(arrayList2).color(dn2Var.b).width((int) dn2Var.c).dottedLine(dn2Var.d));
                            hx1.i("map", "initMapView createPoly");
                        } else {
                            hx1.c("map", "polyline count can't less than 2 or your polyline points contains null");
                        }
                    }
                }
            }
            List<cn2> list3 = tm2Var.q;
            if (list3 != null && !list3.isEmpty()) {
                for (cn2 cn2Var : tm2Var.q) {
                    if (!cn2Var.isValid()) {
                        hx1.c("map", "polygon is invalid");
                    } else {
                        ArrayList arrayList3 = new ArrayList(cn2Var.a.size());
                        Iterator<an2> it2 = cn2Var.a.iterator();
                        while (it2.hasNext()) {
                            an2 next2 = it2.next();
                            arrayList3.add(new LatLng(next2.a, next2.b));
                        }
                        if (arrayList3.size() >= 3 && !arrayList3.contains(null)) {
                            arrayList.add(new PolygonOptions().points(arrayList3).stroke(new Stroke(cn2Var.b, cn2Var.c)).fillColor(cn2Var.d).zIndex(cn2Var.e));
                            hx1.i("map", "initMapView createPolygons");
                        } else {
                            hx1.c("map", "polygons count can't less than 3 or your polygons points contains null");
                        }
                    }
                }
            }
            List<an2> list4 = tm2Var.p;
            if (list4 != null && list4.size() > 0) {
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                for (an2 an2Var : tm2Var.p) {
                    builder.include(new LatLng(an2Var.a, an2Var.b));
                }
                q54Var.l.getMap().setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
                hx1.i("map", "initMapView includePoints");
            }
            List<ym2> list5 = tm2Var.n;
            if (list5 != null && list5.size() > 0) {
                for (ym2 ym2Var : tm2Var.n) {
                    if (ym2Var.isValid()) {
                        CircleOptions circleOptions = new CircleOptions();
                        an2 an2Var2 = ym2Var.a;
                        arrayList.add(circleOptions.center(new LatLng(an2Var2.a, an2Var2.b)).stroke(new Stroke((int) ym2Var.e, ym2Var.b)).fillColor(ym2Var.c).radius(ym2Var.d));
                        hx1.i("map", "initMapView createCircle");
                    }
                }
            }
            q54Var.l.getMap().addOverlays(arrayList);
        }
    }

    public static void e(Context context, @NonNull tm2 tm2Var, @NonNull q54 q54Var) {
        List<bn2> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65541, null, context, tm2Var, q54Var) == null) || (list = tm2Var.l) == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = list.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Iterator<bn2> it = list.iterator();
        while (it.hasNext()) {
            bn2 next = it.next();
            p54 p54Var = new p54();
            if (next.k == null) {
                next.k = new bn2.a();
            }
            String str = next.d;
            if (TextUtils.isEmpty(str)) {
                str = ImageRequestBuilder.newBuilderWithResourceId(R.drawable.obfuscated_res_0x7f080f1a).build().getSourceUri().toString();
            }
            ed3.e(str, new a(next, p54Var, arrayList, context, q54Var, arrayList2, arrayList3, atomicInteger, size));
            it = it;
            arrayList = arrayList;
        }
    }

    public static Bitmap f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? BitmapFactory.decodeResource(AppRuntime.getAppContext().getResources(), R.drawable.obfuscated_res_0x7f080f1a) : (Bitmap) invokeV.objValue;
    }

    @Nullable
    public static Bitmap g(Bitmap bitmap, bn2 bn2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, bitmap, bn2Var)) == null) {
            int i = bn2Var.g;
            if (i == -1) {
                i = bitmap.getWidth();
            }
            int i2 = bn2Var.h;
            if (i2 == -1) {
                i2 = bitmap.getHeight();
            }
            return f64.a(bitmap, i, i2);
        }
        return (Bitmap) invokeLL.objValue;
    }
}
