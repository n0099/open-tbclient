package com.opensource.svgaplayer.a;

import android.graphics.Canvas;
import android.widget.ImageView;
import com.opensource.svgaplayer.b.d;
import com.opensource.svgaplayer.entities.g;
import com.opensource.svgaplayer.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes.dex */
public class a {
    private final f nmA;
    private final d nnz;

    public a(f fVar) {
        q.j(fVar, "videoItem");
        this.nmA = fVar;
        this.nnz = new d();
    }

    public final f dFh() {
        return this.nmA;
    }

    public final d dFC() {
        return this.nnz;
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0734a {
        private final String imageKey;
        private final g nnA;
        final /* synthetic */ a nnB;

        public C0734a(a aVar, String str, g gVar) {
            q.j(gVar, "frameEntity");
            this.nnB = aVar;
            this.imageKey = str;
            this.nnA = gVar;
        }

        public final String dFD() {
            return this.imageKey;
        }

        public final g dFE() {
            return this.nnA;
        }
    }

    public final List<C0734a> No(int i) {
        C0734a c0734a;
        ArrayList arrayList = new ArrayList();
        for (com.opensource.svgaplayer.entities.f fVar : this.nmA.dFx()) {
            if (i < 0 || i >= fVar.dGb().size()) {
                c0734a = null;
            } else {
                c0734a = fVar.dGb().get(i).dGc() <= 0.0d ? null : new C0734a(this, fVar.dFD(), fVar.dGb().get(i));
            }
            if (c0734a != null) {
                arrayList.add(c0734a);
            }
        }
        return arrayList;
    }

    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.j(canvas, "canvas");
        q.j(scaleType, "scaleType");
        this.nnz.a(canvas.getWidth(), canvas.getHeight(), (float) this.nmA.dFv().getWidth(), (float) this.nmA.dFv().getHeight(), scaleType);
    }
}
