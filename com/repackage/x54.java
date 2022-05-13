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
import com.repackage.on2;
import com.repackage.rd3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class x54 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements rd3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ on2 a;
        public final /* synthetic */ c64 b;
        public final /* synthetic */ List c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ d64 e;
        public final /* synthetic */ List f;
        public final /* synthetic */ List g;
        public final /* synthetic */ AtomicInteger h;
        public final /* synthetic */ int i;

        public a(on2 on2Var, c64 c64Var, List list, Context context, d64 d64Var, List list2, List list3, AtomicInteger atomicInteger, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {on2Var, c64Var, list, context, d64Var, list2, list3, atomicInteger, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = on2Var;
            this.b = c64Var;
            this.c = list;
            this.d = context;
            this.e = d64Var;
            this.f = list2;
            this.g = list3;
            this.h = atomicInteger;
            this.i = i;
        }

        @Override // com.repackage.rd3.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (x54.a) {
                    Log.d("MarkerViewCreateHelper", "url=" + str);
                }
                if (bitmap == null) {
                    bitmap = x54.f();
                }
                Bitmap g = x54.g(bitmap, this.a);
                nn2 nn2Var = this.a.b;
                LatLng latLng = new LatLng(nn2Var.a, nn2Var.b);
                MarkerOptions zIndex = new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(g)).alpha((float) this.a.f).title(this.a.c).rotate((float) this.a.e).zIndex(88);
                on2.a aVar = this.a.k;
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
                if (c64.h.booleanValue()) {
                    on2.b bVar = this.a.i;
                    if (bVar != null && bVar.isValid() && TextUtils.equals(this.a.i.g, "ALWAYS")) {
                        View a = r54.a(this.e, this.a);
                        linearLayout.addView(a, 0);
                        this.b.d = a;
                    }
                    on2.c cVar = this.a.j;
                    if (cVar != null && cVar.isValid()) {
                        this.f.add(t54.a(this.e, this.b));
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
                synchronized (v54.a) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755220614, "Lcom/repackage/x54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755220614, "Lcom/repackage/x54;");
                return;
            }
        }
        a = eh1.a;
    }

    public static void d(@NonNull gn2 gn2Var, @NonNull d64 d64Var, z54 z54Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, gn2Var, d64Var, z54Var) == null) {
            List<mn2> list = gn2Var.o;
            if (list != null && list.size() > 0) {
                for (mn2 mn2Var : gn2Var.o) {
                    s54.a(d64Var, mn2Var, z54Var);
                    ux1.i("map", "initMapView createControl id " + mn2Var.a);
                }
            }
            ArrayList arrayList = new ArrayList();
            List<qn2> list2 = gn2Var.m;
            if (list2 != null && list2.size() > 0) {
                for (qn2 qn2Var : gn2Var.m) {
                    if (!qn2Var.isValid()) {
                        ux1.c("map", "polyline is invalid");
                    } else {
                        ArrayList arrayList2 = new ArrayList(qn2Var.a.size());
                        Iterator<nn2> it = qn2Var.a.iterator();
                        while (it.hasNext()) {
                            nn2 next = it.next();
                            arrayList2.add(new LatLng(next.a, next.b));
                        }
                        if (arrayList2.size() >= 2 && !arrayList2.contains(null)) {
                            arrayList.add(new PolylineOptions().points(arrayList2).color(qn2Var.b).width((int) qn2Var.c).dottedLine(qn2Var.d));
                            ux1.i("map", "initMapView createPoly");
                        } else {
                            ux1.c("map", "polyline count can't less than 2 or your polyline points contains null");
                        }
                    }
                }
            }
            List<pn2> list3 = gn2Var.q;
            if (list3 != null && !list3.isEmpty()) {
                for (pn2 pn2Var : gn2Var.q) {
                    if (!pn2Var.isValid()) {
                        ux1.c("map", "polygon is invalid");
                    } else {
                        ArrayList arrayList3 = new ArrayList(pn2Var.a.size());
                        Iterator<nn2> it2 = pn2Var.a.iterator();
                        while (it2.hasNext()) {
                            nn2 next2 = it2.next();
                            arrayList3.add(new LatLng(next2.a, next2.b));
                        }
                        if (arrayList3.size() >= 3 && !arrayList3.contains(null)) {
                            arrayList.add(new PolygonOptions().points(arrayList3).stroke(new Stroke(pn2Var.b, pn2Var.c)).fillColor(pn2Var.d).zIndex(pn2Var.e));
                            ux1.i("map", "initMapView createPolygons");
                        } else {
                            ux1.c("map", "polygons count can't less than 3 or your polygons points contains null");
                        }
                    }
                }
            }
            List<nn2> list4 = gn2Var.p;
            if (list4 != null && list4.size() > 0) {
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                for (nn2 nn2Var : gn2Var.p) {
                    builder.include(new LatLng(nn2Var.a, nn2Var.b));
                }
                d64Var.l.getMap().setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
                ux1.i("map", "initMapView includePoints");
            }
            List<ln2> list5 = gn2Var.n;
            if (list5 != null && list5.size() > 0) {
                for (ln2 ln2Var : gn2Var.n) {
                    if (ln2Var.isValid()) {
                        CircleOptions circleOptions = new CircleOptions();
                        nn2 nn2Var2 = ln2Var.a;
                        arrayList.add(circleOptions.center(new LatLng(nn2Var2.a, nn2Var2.b)).stroke(new Stroke((int) ln2Var.e, ln2Var.b)).fillColor(ln2Var.c).radius(ln2Var.d));
                        ux1.i("map", "initMapView createCircle");
                    }
                }
            }
            d64Var.l.getMap().addOverlays(arrayList);
        }
    }

    public static void e(Context context, @NonNull gn2 gn2Var, @NonNull d64 d64Var) {
        List<on2> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65541, null, context, gn2Var, d64Var) == null) || (list = gn2Var.l) == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = list.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Iterator<on2> it = list.iterator();
        while (it.hasNext()) {
            on2 next = it.next();
            c64 c64Var = new c64();
            if (next.k == null) {
                next.k = new on2.a();
            }
            String str = next.d;
            if (TextUtils.isEmpty(str)) {
                str = ImageRequestBuilder.newBuilderWithResourceId(R.drawable.obfuscated_res_0x7f080f97).build().getSourceUri().toString();
            }
            rd3.e(str, new a(next, c64Var, arrayList, context, d64Var, arrayList2, arrayList3, atomicInteger, size));
            it = it;
            arrayList = arrayList;
        }
    }

    public static Bitmap f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? BitmapFactory.decodeResource(AppRuntime.getAppContext().getResources(), R.drawable.obfuscated_res_0x7f080f97) : (Bitmap) invokeV.objValue;
    }

    @Nullable
    public static Bitmap g(Bitmap bitmap, on2 on2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, bitmap, on2Var)) == null) {
            int i = on2Var.g;
            if (i == -1) {
                i = bitmap.getWidth();
            }
            int i2 = on2Var.h;
            if (i2 == -1) {
                i2 = bitmap.getHeight();
            }
            return s64.a(bitmap, i, i2);
        }
        return (Bitmap) invokeLL.objValue;
    }
}
