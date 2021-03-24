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
    public final e f66229a = new e();

    /* renamed from: b  reason: collision with root package name */
    public final SVGAVideoEntity f66230b;

    /* renamed from: d.l.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public final class C1814a {

        /* renamed from: a  reason: collision with root package name */
        public final String f66231a;

        /* renamed from: b  reason: collision with root package name */
        public final g f66232b;

        public C1814a(a aVar, String str, g gVar) {
            this.f66231a = str;
            this.f66232b = gVar;
        }

        public final g a() {
            return this.f66232b;
        }

        public final String b() {
            return this.f66231a;
        }
    }

    public a(SVGAVideoEntity sVGAVideoEntity) {
        this.f66230b = sVGAVideoEntity;
    }

    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        this.f66229a.f(canvas.getWidth(), canvas.getHeight(), (float) this.f66230b.h().b(), (float) this.f66230b.h().a(), scaleType);
    }

    public final e b() {
        return this.f66229a;
    }

    public final SVGAVideoEntity c() {
        return this.f66230b;
    }

    public final List<C1814a> d(int i) {
        List<f> g2 = this.f66230b.g();
        ArrayList arrayList = new ArrayList();
        for (f fVar : g2) {
            C1814a c1814a = null;
            if (i >= 0 && i < fVar.a().size() && fVar.a().get(i).a() > 0.0d) {
                c1814a = new C1814a(this, fVar.b(), fVar.a().get(i));
            }
            if (c1814a != null) {
                arrayList.add(c1814a);
            }
        }
        return arrayList;
    }
}
