package d.a.n0.j.k.f;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.widget.ImageView;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.v2.t;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements t.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.h1.c.h.b f50475a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.j.n.c f50476b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.j.l.b f50477c;

        public a(d.a.n0.a.h1.c.h.b bVar, d.a.n0.j.n.c cVar, d.a.n0.j.l.b bVar2) {
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
            this.f50475a = bVar;
            this.f50476b = cVar;
            this.f50477c = bVar2;
        }

        @Override // d.a.n0.a.v2.t.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (bitmap == null) {
                    d.a.n0.a.e0.d.l("map", " icon is null ");
                }
                if (bitmap != null) {
                    int i2 = this.f50475a.f45304h.f45330g;
                    if (i2 == -1) {
                        i2 = bitmap.getWidth();
                    }
                    int i3 = this.f50475a.f45304h.f45331h;
                    if (i3 == -1) {
                        i3 = bitmap.getHeight();
                    }
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.absoluteMode);
                    builder.width(i2);
                    builder.height(i3);
                    builder.align(1, 8);
                    d.a.n0.a.h1.c.h.g gVar = this.f50475a.f45304h;
                    builder.point(new Point(gVar.f45328e, gVar.f45329f));
                    ImageView imageView = new ImageView(AppRuntime.getAppContext());
                    imageView.setImageBitmap(bitmap);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.f50476b.l.addView(imageView, builder.build());
                    imageView.setOnClickListener(this.f50477c);
                    imageView.setClickable(this.f50475a.f45303g);
                    d.a.n0.j.n.a aVar = new d.a.n0.j.n.a();
                    aVar.f50502a = this.f50475a;
                    aVar.f50503b = imageView;
                    this.f50476b.o.add(aVar);
                }
            }
        }
    }

    public static void a(d.a.n0.j.n.c cVar, d.a.n0.a.h1.c.h.b bVar, d.a.n0.j.l.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, cVar, bVar, bVar2) == null) {
            d.a.n0.a.e0.d.g("map", "createControl start");
            if (bVar != null && bVar.isValid()) {
                t.e(bVar.f45302f, new a(bVar, cVar, bVar2));
            }
            d.a.n0.a.e0.d.g("map", "createControl end");
        }
    }
}
