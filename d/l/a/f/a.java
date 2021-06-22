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
    public final e f70317a = new e();

    /* renamed from: b  reason: collision with root package name */
    public final SVGAVideoEntity f70318b;

    /* renamed from: d.l.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public final class C1920a {

        /* renamed from: a  reason: collision with root package name */
        public final String f70319a;

        /* renamed from: b  reason: collision with root package name */
        public final g f70320b;

        public C1920a(a aVar, String str, g gVar) {
            this.f70319a = str;
            this.f70320b = gVar;
        }

        public final g a() {
            return this.f70320b;
        }

        public final String b() {
            return this.f70319a;
        }
    }

    public a(SVGAVideoEntity sVGAVideoEntity) {
        this.f70318b = sVGAVideoEntity;
    }

    public void a(Canvas canvas, int i2, ImageView.ScaleType scaleType) {
        this.f70317a.f(canvas.getWidth(), canvas.getHeight(), (float) this.f70318b.h().b(), (float) this.f70318b.h().a(), scaleType);
    }

    public final e b() {
        return this.f70317a;
    }

    public final SVGAVideoEntity c() {
        return this.f70318b;
    }

    public final List<C1920a> d(int i2) {
        List<f> g2 = this.f70318b.g();
        ArrayList arrayList = new ArrayList();
        for (f fVar : g2) {
            C1920a c1920a = null;
            if (i2 >= 0 && i2 < fVar.a().size() && fVar.a().get(i2).a() > 0.0d) {
                c1920a = new C1920a(this, fVar.b(), fVar.a().get(i2));
            }
            if (c1920a != null) {
                arrayList.add(c1920a);
            }
        }
        return arrayList;
    }
}
