package com.opensource.svgaplayer.a;

import android.graphics.Canvas;
import android.widget.ImageView;
import com.opensource.svgaplayer.b.d;
import com.opensource.svgaplayer.entities.g;
import com.opensource.svgaplayer.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.e;
import kotlin.jvm.internal.p;
@e
/* loaded from: classes5.dex */
public class a {
    private final f pZA;
    private final d qay;

    public a(f fVar) {
        p.p(fVar, "videoItem");
        this.pZA = fVar;
        this.qay = new d();
    }

    public final f eCK() {
        return this.pZA;
    }

    public final d eDg() {
        return this.qay;
    }

    @e
    /* renamed from: com.opensource.svgaplayer.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public final class C1191a {
        private final String imageKey;
        final /* synthetic */ a qaA;
        private final g qaz;

        public C1191a(a aVar, String str, g gVar) {
            p.p(gVar, "frameEntity");
            this.qaA = aVar;
            this.imageKey = str;
            this.qaz = gVar;
        }

        public final g eDh() {
            return this.qaz;
        }

        public final String getImageKey() {
            return this.imageKey;
        }
    }

    public final List<C1191a> QI(int i) {
        C1191a c1191a;
        ArrayList arrayList = new ArrayList();
        for (com.opensource.svgaplayer.entities.f fVar : this.pZA.eDb()) {
            if (i < 0 || i >= fVar.eDE().size()) {
                c1191a = null;
            } else {
                c1191a = fVar.eDE().get(i).eDF() <= 0.0d ? null : new C1191a(this, fVar.getImageKey(), fVar.eDE().get(i));
            }
            if (c1191a != null) {
                arrayList.add(c1191a);
            }
        }
        return arrayList;
    }

    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        p.p(canvas, "canvas");
        p.p(scaleType, "scaleType");
        this.qay.a(canvas.getWidth(), canvas.getHeight(), (float) this.pZA.eCZ().getWidth(), (float) this.pZA.eCZ().getHeight(), scaleType);
    }
}
