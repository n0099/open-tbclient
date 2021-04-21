package d.m.a.f;

import android.graphics.Canvas;
import android.widget.ImageView;
import com.opensource.svgaplayer.SVGAVideoEntity;
import d.m.a.g.f;
import d.m.a.g.g;
import d.m.a.h.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final e f67370a = new e();

    /* renamed from: b  reason: collision with root package name */
    public final SVGAVideoEntity f67371b;

    /* renamed from: d.m.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public final class C1854a {

        /* renamed from: a  reason: collision with root package name */
        public final String f67372a;

        /* renamed from: b  reason: collision with root package name */
        public final g f67373b;

        public C1854a(a aVar, String str, g gVar) {
            this.f67372a = str;
            this.f67373b = gVar;
        }

        public final g a() {
            return this.f67373b;
        }

        public final String b() {
            return this.f67372a;
        }
    }

    public a(SVGAVideoEntity sVGAVideoEntity) {
        this.f67371b = sVGAVideoEntity;
    }

    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        this.f67370a.f(canvas.getWidth(), canvas.getHeight(), (float) this.f67371b.h().b(), (float) this.f67371b.h().a(), scaleType);
    }

    public final e b() {
        return this.f67370a;
    }

    public final SVGAVideoEntity c() {
        return this.f67371b;
    }

    public final List<C1854a> d(int i) {
        List<f> g2 = this.f67371b.g();
        ArrayList arrayList = new ArrayList();
        for (f fVar : g2) {
            C1854a c1854a = null;
            if (i >= 0 && i < fVar.a().size() && fVar.a().get(i).a() > 0.0d) {
                c1854a = new C1854a(this, fVar.b(), fVar.a().get(i));
            }
            if (c1854a != null) {
                arrayList.add(c1854a);
            }
        }
        return arrayList;
    }
}
