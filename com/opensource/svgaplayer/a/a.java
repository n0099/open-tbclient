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
    private final f pQZ;
    private final d pRX;

    public a(f fVar) {
        p.o(fVar, "videoItem");
        this.pQZ = fVar;
        this.pRX = new d();
    }

    public final f eDt() {
        return this.pQZ;
    }

    public final d eDP() {
        return this.pRX;
    }

    @e
    /* renamed from: com.opensource.svgaplayer.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public final class C1144a {
        private final String imageKey;
        private final g pRY;
        final /* synthetic */ a pRZ;

        public C1144a(a aVar, String str, g gVar) {
            p.o(gVar, "frameEntity");
            this.pRZ = aVar;
            this.imageKey = str;
            this.pRY = gVar;
        }

        public final g eDQ() {
            return this.pRY;
        }

        public final String getImageKey() {
            return this.imageKey;
        }
    }

    public final List<C1144a> Rz(int i) {
        C1144a c1144a;
        ArrayList arrayList = new ArrayList();
        for (com.opensource.svgaplayer.entities.f fVar : this.pQZ.eDK()) {
            if (i < 0 || i >= fVar.eEn().size()) {
                c1144a = null;
            } else {
                c1144a = fVar.eEn().get(i).eEo() <= 0.0d ? null : new C1144a(this, fVar.getImageKey(), fVar.eEn().get(i));
            }
            if (c1144a != null) {
                arrayList.add(c1144a);
            }
        }
        return arrayList;
    }

    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        p.o(canvas, "canvas");
        p.o(scaleType, "scaleType");
        this.pRX.a(canvas.getWidth(), canvas.getHeight(), (float) this.pQZ.eDI().getWidth(), (float) this.pQZ.eDI().getHeight(), scaleType);
    }
}
