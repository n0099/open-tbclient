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
import com.repackage.tn2;
import com.repackage.wd3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class c64 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements wd3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tn2 a;
        public final /* synthetic */ h64 b;
        public final /* synthetic */ List c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ i64 e;
        public final /* synthetic */ List f;
        public final /* synthetic */ List g;
        public final /* synthetic */ AtomicInteger h;
        public final /* synthetic */ int i;

        public a(tn2 tn2Var, h64 h64Var, List list, Context context, i64 i64Var, List list2, List list3, AtomicInteger atomicInteger, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tn2Var, h64Var, list, context, i64Var, list2, list3, atomicInteger, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tn2Var;
            this.b = h64Var;
            this.c = list;
            this.d = context;
            this.e = i64Var;
            this.f = list2;
            this.g = list3;
            this.h = atomicInteger;
            this.i = i;
        }

        @Override // com.repackage.wd3.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (c64.a) {
                    Log.d("MarkerViewCreateHelper", "url=" + str);
                }
                if (bitmap == null) {
                    bitmap = c64.f();
                }
                Bitmap g = c64.g(bitmap, this.a);
                sn2 sn2Var = this.a.b;
                LatLng latLng = new LatLng(sn2Var.a, sn2Var.b);
                MarkerOptions zIndex = new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(g)).alpha((float) this.a.f).title(this.a.c).rotate((float) this.a.e).zIndex(88);
                tn2.a aVar = this.a.k;
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
                if (h64.h.booleanValue()) {
                    tn2.b bVar = this.a.i;
                    if (bVar != null && bVar.isValid() && TextUtils.equals(this.a.i.g, "ALWAYS")) {
                        View a = w54.a(this.e, this.a);
                        linearLayout.addView(a, 0);
                        this.b.d = a;
                    }
                    tn2.c cVar = this.a.j;
                    if (cVar != null && cVar.isValid()) {
                        this.f.add(y54.a(this.e, this.b));
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
                synchronized (a64.a) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755845264, "Lcom/repackage/c64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755845264, "Lcom/repackage/c64;");
                return;
            }
        }
        a = jh1.a;
    }

    public static void d(@NonNull ln2 ln2Var, @NonNull i64 i64Var, e64 e64Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ln2Var, i64Var, e64Var) == null) {
            List<rn2> list = ln2Var.o;
            if (list != null && list.size() > 0) {
                for (rn2 rn2Var : ln2Var.o) {
                    x54.a(i64Var, rn2Var, e64Var);
                    zx1.i("map", "initMapView createControl id " + rn2Var.a);
                }
            }
            ArrayList arrayList = new ArrayList();
            List<vn2> list2 = ln2Var.m;
            if (list2 != null && list2.size() > 0) {
                for (vn2 vn2Var : ln2Var.m) {
                    if (!vn2Var.isValid()) {
                        zx1.c("map", "polyline is invalid");
                    } else {
                        ArrayList arrayList2 = new ArrayList(vn2Var.a.size());
                        Iterator<sn2> it = vn2Var.a.iterator();
                        while (it.hasNext()) {
                            sn2 next = it.next();
                            arrayList2.add(new LatLng(next.a, next.b));
                        }
                        if (arrayList2.size() >= 2 && !arrayList2.contains(null)) {
                            arrayList.add(new PolylineOptions().points(arrayList2).color(vn2Var.b).width((int) vn2Var.c).dottedLine(vn2Var.d));
                            zx1.i("map", "initMapView createPoly");
                        } else {
                            zx1.c("map", "polyline count can't less than 2 or your polyline points contains null");
                        }
                    }
                }
            }
            List<un2> list3 = ln2Var.q;
            if (list3 != null && !list3.isEmpty()) {
                for (un2 un2Var : ln2Var.q) {
                    if (!un2Var.isValid()) {
                        zx1.c("map", "polygon is invalid");
                    } else {
                        ArrayList arrayList3 = new ArrayList(un2Var.a.size());
                        Iterator<sn2> it2 = un2Var.a.iterator();
                        while (it2.hasNext()) {
                            sn2 next2 = it2.next();
                            arrayList3.add(new LatLng(next2.a, next2.b));
                        }
                        if (arrayList3.size() >= 3 && !arrayList3.contains(null)) {
                            arrayList.add(new PolygonOptions().points(arrayList3).stroke(new Stroke(un2Var.b, un2Var.c)).fillColor(un2Var.d).zIndex(un2Var.e));
                            zx1.i("map", "initMapView createPolygons");
                        } else {
                            zx1.c("map", "polygons count can't less than 3 or your polygons points contains null");
                        }
                    }
                }
            }
            List<sn2> list4 = ln2Var.p;
            if (list4 != null && list4.size() > 0) {
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                for (sn2 sn2Var : ln2Var.p) {
                    builder.include(new LatLng(sn2Var.a, sn2Var.b));
                }
                i64Var.l.getMap().setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
                zx1.i("map", "initMapView includePoints");
            }
            List<qn2> list5 = ln2Var.n;
            if (list5 != null && list5.size() > 0) {
                for (qn2 qn2Var : ln2Var.n) {
                    if (qn2Var.isValid()) {
                        CircleOptions circleOptions = new CircleOptions();
                        sn2 sn2Var2 = qn2Var.a;
                        arrayList.add(circleOptions.center(new LatLng(sn2Var2.a, sn2Var2.b)).stroke(new Stroke((int) qn2Var.e, qn2Var.b)).fillColor(qn2Var.c).radius(qn2Var.d));
                        zx1.i("map", "initMapView createCircle");
                    }
                }
            }
            i64Var.l.getMap().addOverlays(arrayList);
        }
    }

    public static void e(Context context, @NonNull ln2 ln2Var, @NonNull i64 i64Var) {
        List<tn2> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65541, null, context, ln2Var, i64Var) == null) || (list = ln2Var.l) == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = list.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Iterator<tn2> it = list.iterator();
        while (it.hasNext()) {
            tn2 next = it.next();
            h64 h64Var = new h64();
            if (next.k == null) {
                next.k = new tn2.a();
            }
            String str = next.d;
            if (TextUtils.isEmpty(str)) {
                str = ImageRequestBuilder.newBuilderWithResourceId(R.drawable.obfuscated_res_0x7f080f85).build().getSourceUri().toString();
            }
            wd3.e(str, new a(next, h64Var, arrayList, context, i64Var, arrayList2, arrayList3, atomicInteger, size));
            it = it;
            arrayList = arrayList;
        }
    }

    public static Bitmap f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? BitmapFactory.decodeResource(AppRuntime.getAppContext().getResources(), R.drawable.obfuscated_res_0x7f080f85) : (Bitmap) invokeV.objValue;
    }

    @Nullable
    public static Bitmap g(Bitmap bitmap, tn2 tn2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, bitmap, tn2Var)) == null) {
            int i = tn2Var.g;
            if (i == -1) {
                i = bitmap.getWidth();
            }
            int i2 = tn2Var.h;
            if (i2 == -1) {
                i2 = bitmap.getHeight();
            }
            return x64.a(bitmap, i, i2);
        }
        return (Bitmap) invokeLL.objValue;
    }
}
