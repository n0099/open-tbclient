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
    private final f pYM;
    private final d pZK;

    public a(f fVar) {
        p.o(fVar, "videoItem");
        this.pYM = fVar;
        this.pZK = new d();
    }

    public final f eCE() {
        return this.pYM;
    }

    public final d eDa() {
        return this.pZK;
    }

    @e
    /* renamed from: com.opensource.svgaplayer.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public final class C1174a {
        private final String imageKey;
        private final g pZL;
        final /* synthetic */ a pZM;

        public C1174a(a aVar, String str, g gVar) {
            p.o(gVar, "frameEntity");
            this.pZM = aVar;
            this.imageKey = str;
            this.pZL = gVar;
        }

        public final g eDb() {
            return this.pZL;
        }

        public final String getImageKey() {
            return this.imageKey;
        }
    }

    public final List<C1174a> QE(int i) {
        C1174a c1174a;
        ArrayList arrayList = new ArrayList();
        for (com.opensource.svgaplayer.entities.f fVar : this.pYM.eCV()) {
            if (i < 0 || i >= fVar.eDy().size()) {
                c1174a = null;
            } else {
                c1174a = fVar.eDy().get(i).eDz() <= 0.0d ? null : new C1174a(this, fVar.getImageKey(), fVar.eDy().get(i));
            }
            if (c1174a != null) {
                arrayList.add(c1174a);
            }
        }
        return arrayList;
    }

    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        p.o(canvas, "canvas");
        p.o(scaleType, "scaleType");
        this.pZK.a(canvas.getWidth(), canvas.getHeight(), (float) this.pYM.eCT().getWidth(), (float) this.pYM.eCT().getHeight(), scaleType);
    }
}
