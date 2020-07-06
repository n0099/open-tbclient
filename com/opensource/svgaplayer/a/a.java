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
    private final f nAu;
    private final d nBt;

    public a(f fVar) {
        q.m(fVar, "videoItem");
        this.nAu = fVar;
        this.nBt = new d();
    }

    public final f dLx() {
        return this.nAu;
    }

    public final d dLT() {
        return this.nBt;
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0858a {
        private final String imageKey;
        private final g nBu;
        final /* synthetic */ a nBv;

        public C0858a(a aVar, String str, g gVar) {
            q.m(gVar, "frameEntity");
            this.nBv = aVar;
            this.imageKey = str;
            this.nBu = gVar;
        }

        public final String dLU() {
            return this.imageKey;
        }

        public final g dLV() {
            return this.nBu;
        }
    }

    public final List<C0858a> KC(int i) {
        C0858a c0858a;
        ArrayList arrayList = new ArrayList();
        for (com.opensource.svgaplayer.entities.f fVar : this.nAu.dLO()) {
            if (i < 0 || i >= fVar.dMs().size()) {
                c0858a = null;
            } else {
                c0858a = fVar.dMs().get(i).dMt() <= 0.0d ? null : new C0858a(this, fVar.dLU(), fVar.dMs().get(i));
            }
            if (c0858a != null) {
                arrayList.add(c0858a);
            }
        }
        return arrayList;
    }

    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.m(canvas, "canvas");
        q.m(scaleType, "scaleType");
        this.nBt.a(canvas.getWidth(), canvas.getHeight(), (float) this.nAu.dLM().getWidth(), (float) this.nAu.dLM().getHeight(), scaleType);
    }
}
