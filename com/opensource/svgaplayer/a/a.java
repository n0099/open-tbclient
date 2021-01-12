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
    private final f pOh;
    private final d pPf;

    public a(f fVar) {
        p.o(fVar, "videoItem");
        this.pOh = fVar;
        this.pPf = new d();
    }

    public final f eAf() {
        return this.pOh;
    }

    public final d eAB() {
        return this.pPf;
    }

    @e
    /* renamed from: com.opensource.svgaplayer.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public final class C1168a {
        private final String imageKey;
        private final g pPg;
        final /* synthetic */ a pPh;

        public C1168a(a aVar, String str, g gVar) {
            p.o(gVar, "frameEntity");
            this.pPh = aVar;
            this.imageKey = str;
            this.pPg = gVar;
        }

        public final g eAC() {
            return this.pPg;
        }

        public final String getImageKey() {
            return this.imageKey;
        }
    }

    public final List<C1168a> Qi(int i) {
        C1168a c1168a;
        ArrayList arrayList = new ArrayList();
        for (com.opensource.svgaplayer.entities.f fVar : this.pOh.eAw()) {
            if (i < 0 || i >= fVar.eAZ().size()) {
                c1168a = null;
            } else {
                c1168a = fVar.eAZ().get(i).eBa() <= 0.0d ? null : new C1168a(this, fVar.getImageKey(), fVar.eAZ().get(i));
            }
            if (c1168a != null) {
                arrayList.add(c1168a);
            }
        }
        return arrayList;
    }

    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        p.o(canvas, "canvas");
        p.o(scaleType, "scaleType");
        this.pPf.a(canvas.getWidth(), canvas.getHeight(), (float) this.pOh.eAu().getWidth(), (float) this.pOh.eAu().getHeight(), scaleType);
    }
}
