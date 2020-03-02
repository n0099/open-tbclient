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
    private final f nkC;
    private final d nlB;

    public a(f fVar) {
        q.j(fVar, "videoItem");
        this.nkC = fVar;
        this.nlB = new d();
    }

    public final f dEG() {
        return this.nkC;
    }

    public final d dFb() {
        return this.nlB;
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0733a {
        private final String imageKey;
        private final g nlC;
        final /* synthetic */ a nlD;

        public C0733a(a aVar, String str, g gVar) {
            q.j(gVar, "frameEntity");
            this.nlD = aVar;
            this.imageKey = str;
            this.nlC = gVar;
        }

        public final String dFc() {
            return this.imageKey;
        }

        public final g dFd() {
            return this.nlC;
        }
    }

    public final List<C0733a> Ni(int i) {
        C0733a c0733a;
        ArrayList arrayList = new ArrayList();
        for (com.opensource.svgaplayer.entities.f fVar : this.nkC.dEW()) {
            if (i < 0 || i >= fVar.dFA().size()) {
                c0733a = null;
            } else {
                c0733a = fVar.dFA().get(i).dFB() <= 0.0d ? null : new C0733a(this, fVar.dFc(), fVar.dFA().get(i));
            }
            if (c0733a != null) {
                arrayList.add(c0733a);
            }
        }
        return arrayList;
    }

    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.j(canvas, "canvas");
        q.j(scaleType, "scaleType");
        this.nlB.a(canvas.getWidth(), canvas.getHeight(), (float) this.nkC.dEU().getWidth(), (float) this.nkC.dEU().getHeight(), scaleType);
    }
}
