package d.b.h0.h.a.f.f;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.widget.ImageView;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.h0.a.a1.c.h.g;
import d.b.h0.a.i2.s;
/* loaded from: classes3.dex */
public class b {

    /* loaded from: classes3.dex */
    public static class a implements s.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.a1.c.h.b f49452a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.h.a.i.c f49453b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.h.a.g.b f49454c;

        public a(d.b.h0.a.a1.c.h.b bVar, d.b.h0.h.a.i.c cVar, d.b.h0.h.a.g.b bVar2) {
            this.f49452a = bVar;
            this.f49453b = cVar;
            this.f49454c = bVar2;
        }

        @Override // d.b.h0.a.i2.s.b
        public void a(String str, Bitmap bitmap) {
            if (bitmap == null) {
                d.b.h0.a.c0.c.l("map", " icon is null ");
            }
            if (bitmap != null) {
                int i = this.f49452a.f43911h.f43934g;
                if (i == -1) {
                    i = bitmap.getWidth();
                }
                int i2 = this.f49452a.f43911h.f43935h;
                if (i2 == -1) {
                    i2 = bitmap.getHeight();
                }
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.absoluteMode);
                builder.width(i);
                builder.height(i2);
                builder.align(1, 8);
                g gVar = this.f49452a.f43911h;
                builder.point(new Point(gVar.f43932e, gVar.f43933f));
                ImageView imageView = new ImageView(AppRuntime.getAppContext());
                imageView.setImageBitmap(bitmap);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setClickable(this.f49452a.f43910g);
                this.f49453b.l.addView(imageView, builder.build());
                imageView.setOnClickListener(this.f49454c);
                d.b.h0.h.a.i.a aVar = new d.b.h0.h.a.i.a();
                aVar.f49476a = this.f49452a;
                aVar.f49477b = imageView;
                this.f49453b.o.add(aVar);
            }
        }
    }

    public static void a(d.b.h0.h.a.i.c cVar, d.b.h0.a.a1.c.h.b bVar, d.b.h0.h.a.g.b bVar2) {
        d.b.h0.a.c0.c.g("map", "createControl start");
        if (bVar != null && bVar.isValid()) {
            s.e(bVar.f43909f, new a(bVar, cVar, bVar2));
        }
        d.b.h0.a.c0.c.g("map", "createControl end");
    }
}
