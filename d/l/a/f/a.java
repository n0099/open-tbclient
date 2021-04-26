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
    public final e f65698a = new e();

    /* renamed from: b  reason: collision with root package name */
    public final SVGAVideoEntity f65699b;

    /* renamed from: d.l.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public final class C1789a {

        /* renamed from: a  reason: collision with root package name */
        public final String f65700a;

        /* renamed from: b  reason: collision with root package name */
        public final g f65701b;

        public C1789a(a aVar, String str, g gVar) {
            this.f65700a = str;
            this.f65701b = gVar;
        }

        public final g a() {
            return this.f65701b;
        }

        public final String b() {
            return this.f65700a;
        }
    }

    public a(SVGAVideoEntity sVGAVideoEntity) {
        this.f65699b = sVGAVideoEntity;
    }

    public void a(Canvas canvas, int i2, ImageView.ScaleType scaleType) {
        this.f65698a.f(canvas.getWidth(), canvas.getHeight(), (float) this.f65699b.h().b(), (float) this.f65699b.h().a(), scaleType);
    }

    public final e b() {
        return this.f65698a;
    }

    public final SVGAVideoEntity c() {
        return this.f65699b;
    }

    public final List<C1789a> d(int i2) {
        List<f> g2 = this.f65699b.g();
        ArrayList arrayList = new ArrayList();
        for (f fVar : g2) {
            C1789a c1789a = null;
            if (i2 >= 0 && i2 < fVar.a().size() && fVar.a().get(i2).a() > 0.0d) {
                c1789a = new C1789a(this, fVar.b(), fVar.a().get(i2));
            }
            if (c1789a != null) {
                arrayList.add(c1789a);
            }
        }
        return arrayList;
    }
}
