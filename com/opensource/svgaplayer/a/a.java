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
/* loaded from: classes18.dex */
public class a {
    private final f pys;
    private final d pzq;

    public a(f fVar) {
        p.o(fVar, "videoItem");
        this.pys = fVar;
        this.pzq = new d();
    }

    public final f ezA() {
        return this.pys;
    }

    public final d ezW() {
        return this.pzq;
    }

    @e
    /* renamed from: com.opensource.svgaplayer.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public final class C1013a {
        private final String imageKey;
        private final g pzr;
        final /* synthetic */ a pzs;

        public C1013a(a aVar, String str, g gVar) {
            p.o(gVar, "frameEntity");
            this.pzs = aVar;
            this.imageKey = str;
            this.pzr = gVar;
        }

        public final g ezX() {
            return this.pzr;
        }

        public final String getImageKey() {
            return this.imageKey;
        }
    }

    public final List<C1013a> RC(int i) {
        C1013a c1013a;
        ArrayList arrayList = new ArrayList();
        for (com.opensource.svgaplayer.entities.f fVar : this.pys.ezR()) {
            if (i < 0 || i >= fVar.eAu().size()) {
                c1013a = null;
            } else {
                c1013a = fVar.eAu().get(i).eAv() <= 0.0d ? null : new C1013a(this, fVar.getImageKey(), fVar.eAu().get(i));
            }
            if (c1013a != null) {
                arrayList.add(c1013a);
            }
        }
        return arrayList;
    }

    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        p.o(canvas, "canvas");
        p.o(scaleType, "scaleType");
        this.pzq.a(canvas.getWidth(), canvas.getHeight(), (float) this.pys.ezP().getWidth(), (float) this.pys.ezP().getHeight(), scaleType);
    }
}
