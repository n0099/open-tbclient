package d.a.h0.h.a.f.f;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.widget.ImageView;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.h0.a.a1.c.h.g;
import d.a.h0.a.i2.s;
/* loaded from: classes3.dex */
public class b {

    /* loaded from: classes3.dex */
    public static class a implements s.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.a1.c.h.b f46952a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.h.a.i.c f46953b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.h.a.g.b f46954c;

        public a(d.a.h0.a.a1.c.h.b bVar, d.a.h0.h.a.i.c cVar, d.a.h0.h.a.g.b bVar2) {
            this.f46952a = bVar;
            this.f46953b = cVar;
            this.f46954c = bVar2;
        }

        @Override // d.a.h0.a.i2.s.b
        public void a(String str, Bitmap bitmap) {
            if (bitmap == null) {
                d.a.h0.a.c0.c.l("map", " icon is null ");
            }
            if (bitmap != null) {
                int i2 = this.f46952a.f41177h.f41203g;
                if (i2 == -1) {
                    i2 = bitmap.getWidth();
                }
                int i3 = this.f46952a.f41177h.f41204h;
                if (i3 == -1) {
                    i3 = bitmap.getHeight();
                }
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.absoluteMode);
                builder.width(i2);
                builder.height(i3);
                builder.align(1, 8);
                g gVar = this.f46952a.f41177h;
                builder.point(new Point(gVar.f41201e, gVar.f41202f));
                ImageView imageView = new ImageView(AppRuntime.getAppContext());
                imageView.setImageBitmap(bitmap);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setClickable(this.f46952a.f41176g);
                this.f46953b.l.addView(imageView, builder.build());
                imageView.setOnClickListener(this.f46954c);
                d.a.h0.h.a.i.a aVar = new d.a.h0.h.a.i.a();
                aVar.f46977a = this.f46952a;
                aVar.f46978b = imageView;
                this.f46953b.o.add(aVar);
            }
        }
    }

    public static void a(d.a.h0.h.a.i.c cVar, d.a.h0.a.a1.c.h.b bVar, d.a.h0.h.a.g.b bVar2) {
        d.a.h0.a.c0.c.g("map", "createControl start");
        if (bVar != null && bVar.isValid()) {
            s.e(bVar.f41175f, new a(bVar, cVar, bVar2));
        }
        d.a.h0.a.c0.c.g("map", "createControl end");
    }
}
