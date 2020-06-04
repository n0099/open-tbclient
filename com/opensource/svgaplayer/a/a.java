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
    private final f neB;
    private final d nfA;

    public a(f fVar) {
        q.m(fVar, "videoItem");
        this.neB = fVar;
        this.nfA = new d();
    }

    public final f dGN() {
        return this.neB;
    }

    public final d dHj() {
        return this.nfA;
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0838a {
        private final String imageKey;
        private final g nfB;
        final /* synthetic */ a nfC;

        public C0838a(a aVar, String str, g gVar) {
            q.m(gVar, "frameEntity");
            this.nfC = aVar;
            this.imageKey = str;
            this.nfB = gVar;
        }

        public final String dHk() {
            return this.imageKey;
        }

        public final g dHl() {
            return this.nfB;
        }
    }

    public final List<C0838a> Jv(int i) {
        C0838a c0838a;
        ArrayList arrayList = new ArrayList();
        for (com.opensource.svgaplayer.entities.f fVar : this.neB.dHe()) {
            if (i < 0 || i >= fVar.dHI().size()) {
                c0838a = null;
            } else {
                c0838a = fVar.dHI().get(i).dHJ() <= 0.0d ? null : new C0838a(this, fVar.dHk(), fVar.dHI().get(i));
            }
            if (c0838a != null) {
                arrayList.add(c0838a);
            }
        }
        return arrayList;
    }

    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.m(canvas, "canvas");
        q.m(scaleType, "scaleType");
        this.nfA.a(canvas.getWidth(), canvas.getHeight(), (float) this.neB.dHc().getWidth(), (float) this.neB.dHc().getHeight(), scaleType);
    }
}
