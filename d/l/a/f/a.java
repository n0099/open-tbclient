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
    public final e f66230a = new e();

    /* renamed from: b  reason: collision with root package name */
    public final SVGAVideoEntity f66231b;

    /* renamed from: d.l.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public final class C1815a {

        /* renamed from: a  reason: collision with root package name */
        public final String f66232a;

        /* renamed from: b  reason: collision with root package name */
        public final g f66233b;

        public C1815a(a aVar, String str, g gVar) {
            this.f66232a = str;
            this.f66233b = gVar;
        }

        public final g a() {
            return this.f66233b;
        }

        public final String b() {
            return this.f66232a;
        }
    }

    public a(SVGAVideoEntity sVGAVideoEntity) {
        this.f66231b = sVGAVideoEntity;
    }

    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        this.f66230a.f(canvas.getWidth(), canvas.getHeight(), (float) this.f66231b.h().b(), (float) this.f66231b.h().a(), scaleType);
    }

    public final e b() {
        return this.f66230a;
    }

    public final SVGAVideoEntity c() {
        return this.f66231b;
    }

    public final List<C1815a> d(int i) {
        List<f> g2 = this.f66231b.g();
        ArrayList arrayList = new ArrayList();
        for (f fVar : g2) {
            C1815a c1815a = null;
            if (i >= 0 && i < fVar.a().size() && fVar.a().get(i).a() > 0.0d) {
                c1815a = new C1815a(this, fVar.b(), fVar.a().get(i));
            }
            if (c1815a != null) {
                arrayList.add(c1815a);
            }
        }
        return arrayList;
    }
}
