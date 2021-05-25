package d.a.l0.j.k.f;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.widget.ImageView;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.l0.a.v2.t;
/* loaded from: classes3.dex */
public class b {

    /* loaded from: classes3.dex */
    public static class a implements t.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h1.c.h.b f47851a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.j.n.c f47852b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.j.l.b f47853c;

        public a(d.a.l0.a.h1.c.h.b bVar, d.a.l0.j.n.c cVar, d.a.l0.j.l.b bVar2) {
            this.f47851a = bVar;
            this.f47852b = cVar;
            this.f47853c = bVar2;
        }

        @Override // d.a.l0.a.v2.t.b
        public void a(String str, Bitmap bitmap) {
            if (bitmap == null) {
                d.a.l0.a.e0.d.l("map", " icon is null ");
            }
            if (bitmap != null) {
                int i2 = this.f47851a.f42672h.f42698g;
                if (i2 == -1) {
                    i2 = bitmap.getWidth();
                }
                int i3 = this.f47851a.f42672h.f42699h;
                if (i3 == -1) {
                    i3 = bitmap.getHeight();
                }
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.absoluteMode);
                builder.width(i2);
                builder.height(i3);
                builder.align(1, 8);
                d.a.l0.a.h1.c.h.g gVar = this.f47851a.f42672h;
                builder.point(new Point(gVar.f42696e, gVar.f42697f));
                ImageView imageView = new ImageView(AppRuntime.getAppContext());
                imageView.setImageBitmap(bitmap);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                this.f47852b.l.addView(imageView, builder.build());
                imageView.setOnClickListener(this.f47853c);
                imageView.setClickable(this.f47851a.f42671g);
                d.a.l0.j.n.a aVar = new d.a.l0.j.n.a();
                aVar.f47878a = this.f47851a;
                aVar.f47879b = imageView;
                this.f47852b.o.add(aVar);
            }
        }
    }

    public static void a(d.a.l0.j.n.c cVar, d.a.l0.a.h1.c.h.b bVar, d.a.l0.j.l.b bVar2) {
        d.a.l0.a.e0.d.g("map", "createControl start");
        if (bVar != null && bVar.isValid()) {
            t.e(bVar.f42670f, new a(bVar, cVar, bVar2));
        }
        d.a.l0.a.e0.d.g("map", "createControl end");
    }
}
