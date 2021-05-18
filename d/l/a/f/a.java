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
    public final e f66384a = new e();

    /* renamed from: b  reason: collision with root package name */
    public final SVGAVideoEntity f66385b;

    /* renamed from: d.l.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public final class C1853a {

        /* renamed from: a  reason: collision with root package name */
        public final String f66386a;

        /* renamed from: b  reason: collision with root package name */
        public final g f66387b;

        public C1853a(a aVar, String str, g gVar) {
            this.f66386a = str;
            this.f66387b = gVar;
        }

        public final g a() {
            return this.f66387b;
        }

        public final String b() {
            return this.f66386a;
        }
    }

    public a(SVGAVideoEntity sVGAVideoEntity) {
        this.f66385b = sVGAVideoEntity;
    }

    public void a(Canvas canvas, int i2, ImageView.ScaleType scaleType) {
        this.f66384a.f(canvas.getWidth(), canvas.getHeight(), (float) this.f66385b.h().b(), (float) this.f66385b.h().a(), scaleType);
    }

    public final e b() {
        return this.f66384a;
    }

    public final SVGAVideoEntity c() {
        return this.f66385b;
    }

    public final List<C1853a> d(int i2) {
        List<f> g2 = this.f66385b.g();
        ArrayList arrayList = new ArrayList();
        for (f fVar : g2) {
            C1853a c1853a = null;
            if (i2 >= 0 && i2 < fVar.a().size() && fVar.a().get(i2).a() > 0.0d) {
                c1853a = new C1853a(this, fVar.b(), fVar.a().get(i2));
            }
            if (c1853a != null) {
                arrayList.add(c1853a);
            }
        }
        return arrayList;
    }
}
