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
    private final f njZ;
    private final d nkY;

    public a(f fVar) {
        q.j(fVar, "videoItem");
        this.njZ = fVar;
        this.nkY = new d();
    }

    public final f dDx() {
        return this.njZ;
    }

    public final d dDS() {
        return this.nkY;
    }

    /* renamed from: com.opensource.svgaplayer.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0725a {
        private final String imageKey;
        private final g nkZ;
        final /* synthetic */ a nla;

        public C0725a(a aVar, String str, g gVar) {
            q.j(gVar, "frameEntity");
            this.nla = aVar;
            this.imageKey = str;
            this.nkZ = gVar;
        }

        public final String dDT() {
            return this.imageKey;
        }

        public final g dDU() {
            return this.nkZ;
        }
    }

    public final List<C0725a> Nf(int i) {
        C0725a c0725a;
        ArrayList arrayList = new ArrayList();
        for (com.opensource.svgaplayer.entities.f fVar : this.njZ.dDN()) {
            if (i < 0 || i >= fVar.dEr().size()) {
                c0725a = null;
            } else {
                c0725a = fVar.dEr().get(i).dEs() <= 0.0d ? null : new C0725a(this, fVar.dDT(), fVar.dEr().get(i));
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
        this.nkY.a(canvas.getWidth(), canvas.getHeight(), (float) this.njZ.dDL().getWidth(), (float) this.njZ.dDL().getHeight(), scaleType);
    }
}
