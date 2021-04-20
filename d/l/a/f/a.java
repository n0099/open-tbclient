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
    public final e f67223a = new e();

    /* renamed from: b  reason: collision with root package name */
    public final SVGAVideoEntity f67224b;

    /* renamed from: d.l.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public final class C1850a {

        /* renamed from: a  reason: collision with root package name */
        public final String f67225a;

        /* renamed from: b  reason: collision with root package name */
        public final g f67226b;

        public C1850a(a aVar, String str, g gVar) {
            this.f67225a = str;
            this.f67226b = gVar;
        }

        public final g a() {
            return this.f67226b;
        }

        public final String b() {
            return this.f67225a;
        }
    }

    public a(SVGAVideoEntity sVGAVideoEntity) {
        this.f67224b = sVGAVideoEntity;
    }

    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        this.f67223a.f(canvas.getWidth(), canvas.getHeight(), (float) this.f67224b.h().b(), (float) this.f67224b.h().a(), scaleType);
    }

    public final e b() {
        return this.f67223a;
    }

    public final SVGAVideoEntity c() {
        return this.f67224b;
    }

    public final List<C1850a> d(int i) {
        List<f> g2 = this.f67224b.g();
        ArrayList arrayList = new ArrayList();
        for (f fVar : g2) {
            C1850a c1850a = null;
            if (i >= 0 && i < fVar.a().size() && fVar.a().get(i).a() > 0.0d) {
                c1850a = new C1850a(this, fVar.b(), fVar.a().get(i));
            }
            if (c1850a != null) {
                arrayList.add(c1850a);
            }
        }
        return arrayList;
    }
}
