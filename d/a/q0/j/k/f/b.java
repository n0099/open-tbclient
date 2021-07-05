package d.a.q0.j.k.f;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.widget.ImageView;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.v2.t;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements t.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.h1.c.h.b f53777a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.j.n.c f53778b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.j.l.b f53779c;

        public a(d.a.q0.a.h1.c.h.b bVar, d.a.q0.j.n.c cVar, d.a.q0.j.l.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53777a = bVar;
            this.f53778b = cVar;
            this.f53779c = bVar2;
        }

        @Override // d.a.q0.a.v2.t.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (bitmap == null) {
                    d.a.q0.a.e0.d.l("map", " icon is null ");
                }
                if (bitmap != null) {
                    int i2 = this.f53777a.f48606h.f48632g;
                    if (i2 == -1) {
                        i2 = bitmap.getWidth();
                    }
                    int i3 = this.f53777a.f48606h.f48633h;
                    if (i3 == -1) {
                        i3 = bitmap.getHeight();
                    }
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.absoluteMode);
                    builder.width(i2);
                    builder.height(i3);
                    builder.align(1, 8);
                    d.a.q0.a.h1.c.h.g gVar = this.f53777a.f48606h;
                    builder.point(new Point(gVar.f48630e, gVar.f48631f));
                    ImageView imageView = new ImageView(AppRuntime.getAppContext());
                    imageView.setImageBitmap(bitmap);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.f53778b.l.addView(imageView, builder.build());
                    imageView.setOnClickListener(this.f53779c);
                    imageView.setClickable(this.f53777a.f48605g);
                    d.a.q0.j.n.a aVar = new d.a.q0.j.n.a();
                    aVar.f53804a = this.f53777a;
                    aVar.f53805b = imageView;
                    this.f53778b.o.add(aVar);
                }
            }
        }
    }

    public static void a(d.a.q0.j.n.c cVar, d.a.q0.a.h1.c.h.b bVar, d.a.q0.j.l.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, cVar, bVar, bVar2) == null) {
            d.a.q0.a.e0.d.g("map", "createControl start");
            if (bVar != null && bVar.isValid()) {
                t.e(bVar.f48604f, new a(bVar, cVar, bVar2));
            }
            d.a.q0.a.e0.d.g("map", "createControl end");
        }
    }
}
