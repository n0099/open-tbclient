package d.a.m0.j.k.f;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.widget.ImageView;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.m0.a.v2.t;
/* loaded from: classes3.dex */
public class b {

    /* loaded from: classes3.dex */
    public static class a implements t.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.h1.c.h.b f51633a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.j.n.c f51634b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.j.l.b f51635c;

        public a(d.a.m0.a.h1.c.h.b bVar, d.a.m0.j.n.c cVar, d.a.m0.j.l.b bVar2) {
            this.f51633a = bVar;
            this.f51634b = cVar;
            this.f51635c = bVar2;
        }

        @Override // d.a.m0.a.v2.t.b
        public void a(String str, Bitmap bitmap) {
            if (bitmap == null) {
                d.a.m0.a.e0.d.l("map", " icon is null ");
            }
            if (bitmap != null) {
                int i2 = this.f51633a.f46456h.f46482g;
                if (i2 == -1) {
                    i2 = bitmap.getWidth();
                }
                int i3 = this.f51633a.f46456h.f46483h;
                if (i3 == -1) {
                    i3 = bitmap.getHeight();
                }
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.absoluteMode);
                builder.width(i2);
                builder.height(i3);
                builder.align(1, 8);
                d.a.m0.a.h1.c.h.g gVar = this.f51633a.f46456h;
                builder.point(new Point(gVar.f46480e, gVar.f46481f));
                ImageView imageView = new ImageView(AppRuntime.getAppContext());
                imageView.setImageBitmap(bitmap);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                this.f51634b.l.addView(imageView, builder.build());
                imageView.setOnClickListener(this.f51635c);
                imageView.setClickable(this.f51633a.f46455g);
                d.a.m0.j.n.a aVar = new d.a.m0.j.n.a();
                aVar.f51660a = this.f51633a;
                aVar.f51661b = imageView;
                this.f51634b.o.add(aVar);
            }
        }
    }

    public static void a(d.a.m0.j.n.c cVar, d.a.m0.a.h1.c.h.b bVar, d.a.m0.j.l.b bVar2) {
        d.a.m0.a.e0.d.g("map", "createControl start");
        if (bVar != null && bVar.isValid()) {
            t.e(bVar.f46454f, new a(bVar, cVar, bVar2));
        }
        d.a.m0.a.e0.d.g("map", "createControl end");
    }
}
