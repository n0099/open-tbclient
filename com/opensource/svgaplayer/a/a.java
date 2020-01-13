package com.opensource.svgaplayer.a;

import android.graphics.Canvas;
import android.widget.ImageView;
import com.opensource.svgaplayer.b.d;
import com.opensource.svgaplayer.entities.g;
import com.opensource.svgaplayer.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.q;
/* loaded from: classes.dex */
public class a {
    private final f njU;
    private final d nkT;

    public a(f fVar) {
        q.j(fVar, "videoItem");
        this.njU = fVar;
        this.nkT = new d();
    }

    public final f dDv() {
        return this.njU;
    }

    public final d dDQ() {
        return this.nkT;
    }

    /* renamed from: com.opensource.svgaplayer.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0725a {
        private final String imageKey;
        private final g nkU;
        final /* synthetic */ a nkV;

        public C0725a(a aVar, String str, g gVar) {
            q.j(gVar, "frameEntity");
            this.nkV = aVar;
            this.imageKey = str;
            this.nkU = gVar;
        }

        public final String dDR() {
            return this.imageKey;
        }

        public final g dDS() {
            return this.nkU;
        }
    }

    public final List<C0725a> Nf(int i) {
        C0725a c0725a;
        ArrayList arrayList = new ArrayList();
        for (com.opensource.svgaplayer.entities.f fVar : this.njU.dDL()) {
            if (i < 0 || i >= fVar.dEp().size()) {
                c0725a = null;
            } else {
                c0725a = fVar.dEp().get(i).dEq() <= 0.0d ? null : new C0725a(this, fVar.dDR(), fVar.dEp().get(i));
            }
            if (c0725a != null) {
                arrayList.add(c0725a);
            }
        }
        return arrayList;
    }

    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.j(canvas, "canvas");
        q.j(scaleType, "scaleType");
        this.nkT.a(canvas.getWidth(), canvas.getHeight(), (float) this.njU.dDJ().getWidth(), (float) this.njU.dDJ().getHeight(), scaleType);
    }
}
