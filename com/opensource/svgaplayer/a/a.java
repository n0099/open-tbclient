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
/* loaded from: classes6.dex */
public class a {
    private final f pYm;
    private final d pZk;

    public a(f fVar) {
        p.o(fVar, "videoItem");
        this.pYm = fVar;
        this.pZk = new d();
    }

    public final f eCw() {
        return this.pYm;
    }

    public final d eCS() {
        return this.pZk;
    }

    @e
    /* renamed from: com.opensource.svgaplayer.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public final class C1172a {
        private final String imageKey;
        private final g pZl;
        final /* synthetic */ a pZm;

        public C1172a(a aVar, String str, g gVar) {
            p.o(gVar, "frameEntity");
            this.pZm = aVar;
            this.imageKey = str;
            this.pZl = gVar;
        }

        public final g eCT() {
            return this.pZl;
        }

        public final String getImageKey() {
            return this.imageKey;
        }
    }

    public final List<C1172a> QD(int i) {
        C1172a c1172a;
        ArrayList arrayList = new ArrayList();
        for (com.opensource.svgaplayer.entities.f fVar : this.pYm.eCN()) {
            if (i < 0 || i >= fVar.eDq().size()) {
                c1172a = null;
            } else {
                c1172a = fVar.eDq().get(i).eDr() <= 0.0d ? null : new C1172a(this, fVar.getImageKey(), fVar.eDq().get(i));
            }
            if (c1172a != null) {
                arrayList.add(c1172a);
            }
        }
        return arrayList;
    }

    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        p.o(canvas, "canvas");
        p.o(scaleType, "scaleType");
        this.pZk.a(canvas.getWidth(), canvas.getHeight(), (float) this.pYm.eCL().getWidth(), (float) this.pYm.eCL().getHeight(), scaleType);
    }
}
