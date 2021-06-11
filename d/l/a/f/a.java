package d.l.a.f;

import android.graphics.Canvas;
import android.widget.ImageView;
import com.opensource.svgaplayer.SVGAVideoEntity;
import d.l.a.g.f;
import d.l.a.g.g;
import d.l.a.h.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final e f70213a = new e();

    /* renamed from: b  reason: collision with root package name */
    public final SVGAVideoEntity f70214b;

    /* renamed from: d.l.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public final class C1917a {

        /* renamed from: a  reason: collision with root package name */
        public final String f70215a;

        /* renamed from: b  reason: collision with root package name */
        public final g f70216b;

        public C1917a(a aVar, String str, g gVar) {
            this.f70215a = str;
            this.f70216b = gVar;
        }

        public final g a() {
            return this.f70216b;
        }

        public final String b() {
            return this.f70215a;
        }
    }

    public a(SVGAVideoEntity sVGAVideoEntity) {
        this.f70214b = sVGAVideoEntity;
    }

    public void a(Canvas canvas, int i2, ImageView.ScaleType scaleType) {
        this.f70213a.f(canvas.getWidth(), canvas.getHeight(), (float) this.f70214b.h().b(), (float) this.f70214b.h().a(), scaleType);
    }

    public final e b() {
        return this.f70213a;
    }

    public final SVGAVideoEntity c() {
        return this.f70214b;
    }

    public final List<C1917a> d(int i2) {
        List<f> g2 = this.f70214b.g();
        ArrayList arrayList = new ArrayList();
        for (f fVar : g2) {
            C1917a c1917a = null;
            if (i2 >= 0 && i2 < fVar.a().size() && fVar.a().get(i2).a() > 0.0d) {
                c1917a = new C1917a(this, fVar.b(), fVar.a().get(i2));
            }
            if (c1917a != null) {
                arrayList.add(c1917a);
            }
        }
        return arrayList;
    }
}
