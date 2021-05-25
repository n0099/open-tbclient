package d.l.a.f;

import android.graphics.Canvas;
import android.widget.ImageView;
import com.opensource.svgaplayer.SVGAVideoEntity;
import d.l.a.g.f;
import d.l.a.g.g;
import d.l.a.h.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final e f66427a = new e();

    /* renamed from: b  reason: collision with root package name */
    public final SVGAVideoEntity f66428b;

    /* renamed from: d.l.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public final class C1857a {

        /* renamed from: a  reason: collision with root package name */
        public final String f66429a;

        /* renamed from: b  reason: collision with root package name */
        public final g f66430b;

        public C1857a(a aVar, String str, g gVar) {
            this.f66429a = str;
            this.f66430b = gVar;
        }

        public final g a() {
            return this.f66430b;
        }

        public final String b() {
            return this.f66429a;
        }
    }

    public a(SVGAVideoEntity sVGAVideoEntity) {
        this.f66428b = sVGAVideoEntity;
    }

    public void a(Canvas canvas, int i2, ImageView.ScaleType scaleType) {
        this.f66427a.f(canvas.getWidth(), canvas.getHeight(), (float) this.f66428b.h().b(), (float) this.f66428b.h().a(), scaleType);
    }

    public final e b() {
        return this.f66427a;
    }

    public final SVGAVideoEntity c() {
        return this.f66428b;
    }

    public final List<C1857a> d(int i2) {
        List<f> g2 = this.f66428b.g();
        ArrayList arrayList = new ArrayList();
        for (f fVar : g2) {
            C1857a c1857a = null;
            if (i2 >= 0 && i2 < fVar.a().size() && fVar.a().get(i2).a() > 0.0d) {
                c1857a = new C1857a(this, fVar.b(), fVar.a().get(i2));
            }
            if (c1857a != null) {
                arrayList.add(c1857a);
            }
        }
        return arrayList;
    }
}
