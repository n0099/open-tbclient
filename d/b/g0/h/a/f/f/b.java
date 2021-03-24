package d.b.g0.h.a.f.f;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.widget.ImageView;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.g0.a.a1.c.h.g;
import d.b.g0.a.i2.s;
/* loaded from: classes3.dex */
public class b {

    /* loaded from: classes3.dex */
    public static class a implements s.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.a1.c.h.b f48730a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.h.a.i.c f48731b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.h.a.g.b f48732c;

        public a(d.b.g0.a.a1.c.h.b bVar, d.b.g0.h.a.i.c cVar, d.b.g0.h.a.g.b bVar2) {
            this.f48730a = bVar;
            this.f48731b = cVar;
            this.f48732c = bVar2;
        }

        @Override // d.b.g0.a.i2.s.b
        public void a(String str, Bitmap bitmap) {
            if (bitmap == null) {
                d.b.g0.a.c0.c.l("map", " icon is null ");
            }
            if (bitmap != null) {
                int i = this.f48730a.f43189h.f43212g;
                if (i == -1) {
                    i = bitmap.getWidth();
                }
                int i2 = this.f48730a.f43189h.f43213h;
                if (i2 == -1) {
                    i2 = bitmap.getHeight();
                }
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.absoluteMode);
                builder.width(i);
                builder.height(i2);
                builder.align(1, 8);
                g gVar = this.f48730a.f43189h;
                builder.point(new Point(gVar.f43210e, gVar.f43211f));
                ImageView imageView = new ImageView(AppRuntime.getAppContext());
                imageView.setImageBitmap(bitmap);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setClickable(this.f48730a.f43188g);
                this.f48731b.l.addView(imageView, builder.build());
                imageView.setOnClickListener(this.f48732c);
                d.b.g0.h.a.i.a aVar = new d.b.g0.h.a.i.a();
                aVar.f48754a = this.f48730a;
                aVar.f48755b = imageView;
                this.f48731b.o.add(aVar);
            }
        }
    }

    public static void a(d.b.g0.h.a.i.c cVar, d.b.g0.a.a1.c.h.b bVar, d.b.g0.h.a.g.b bVar2) {
        d.b.g0.a.c0.c.g("map", "createControl start");
        if (bVar != null && bVar.isValid()) {
            s.e(bVar.f43187f, new a(bVar, cVar, bVar2));
        }
        d.b.g0.a.c0.c.g("map", "createControl end");
    }
}
