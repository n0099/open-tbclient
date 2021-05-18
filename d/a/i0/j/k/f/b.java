package d.a.i0.j.k.f;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.widget.ImageView;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.i0.a.v2.t;
/* loaded from: classes3.dex */
public class b {

    /* loaded from: classes3.dex */
    public static class a implements t.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.h1.c.h.b f47675a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.j.n.c f47676b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.j.l.b f47677c;

        public a(d.a.i0.a.h1.c.h.b bVar, d.a.i0.j.n.c cVar, d.a.i0.j.l.b bVar2) {
            this.f47675a = bVar;
            this.f47676b = cVar;
            this.f47677c = bVar2;
        }

        @Override // d.a.i0.a.v2.t.b
        public void a(String str, Bitmap bitmap) {
            if (bitmap == null) {
                d.a.i0.a.e0.d.l("map", " icon is null ");
            }
            if (bitmap != null) {
                int i2 = this.f47675a.f42498h.f42524g;
                if (i2 == -1) {
                    i2 = bitmap.getWidth();
                }
                int i3 = this.f47675a.f42498h.f42525h;
                if (i3 == -1) {
                    i3 = bitmap.getHeight();
                }
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.absoluteMode);
                builder.width(i2);
                builder.height(i3);
                builder.align(1, 8);
                d.a.i0.a.h1.c.h.g gVar = this.f47675a.f42498h;
                builder.point(new Point(gVar.f42522e, gVar.f42523f));
                ImageView imageView = new ImageView(AppRuntime.getAppContext());
                imageView.setImageBitmap(bitmap);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                this.f47676b.l.addView(imageView, builder.build());
                imageView.setOnClickListener(this.f47677c);
                imageView.setClickable(this.f47675a.f42497g);
                d.a.i0.j.n.a aVar = new d.a.i0.j.n.a();
                aVar.f47702a = this.f47675a;
                aVar.f47703b = imageView;
                this.f47676b.o.add(aVar);
            }
        }
    }

    public static void a(d.a.i0.j.n.c cVar, d.a.i0.a.h1.c.h.b bVar, d.a.i0.j.l.b bVar2) {
        d.a.i0.a.e0.d.g("map", "createControl start");
        if (bVar != null && bVar.isValid()) {
            t.e(bVar.f42496f, new a(bVar, cVar, bVar2));
        }
        d.a.i0.a.e0.d.g("map", "createControl end");
    }
}
