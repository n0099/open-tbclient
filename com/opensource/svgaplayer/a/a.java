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
    private final f nAr;
    private final d nBq;

    public a(f fVar) {
        q.m(fVar, "videoItem");
        this.nAr = fVar;
        this.nBq = new d();
    }

    public final f dLt() {
        return this.nAr;
    }

    public final d dLP() {
        return this.nBq;
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0857a {
        private final String imageKey;
        private final g nBr;
        final /* synthetic */ a nBs;

        public C0857a(a aVar, String str, g gVar) {
            q.m(gVar, "frameEntity");
            this.nBs = aVar;
            this.imageKey = str;
            this.nBr = gVar;
        }

        public final String dLQ() {
            return this.imageKey;
        }

        public final g dLR() {
            return this.nBr;
        }
    }

    public final List<C0857a> KC(int i) {
        C0857a c0857a;
        ArrayList arrayList = new ArrayList();
        for (com.opensource.svgaplayer.entities.f fVar : this.nAr.dLK()) {
            if (i < 0 || i >= fVar.dMo().size()) {
                c0857a = null;
            } else {
                c0857a = fVar.dMo().get(i).dMp() <= 0.0d ? null : new C0857a(this, fVar.dLQ(), fVar.dMo().get(i));
            }
            if (c0857a != null) {
                arrayList.add(c0857a);
            }
        }
        return arrayList;
    }

    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.m(canvas, "canvas");
        q.m(scaleType, "scaleType");
        this.nBq.a(canvas.getWidth(), canvas.getHeight(), (float) this.nAr.dLI().getWidth(), (float) this.nAr.dLI().getHeight(), scaleType);
    }
}
