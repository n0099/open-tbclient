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
/* loaded from: classes8.dex */
public class a {
    private final f nJe;
    private final d nKd;

    public a(f fVar) {
        q.m(fVar, "videoItem");
        this.nJe = fVar;
        this.nKd = new d();
    }

    public final f dOT() {
        return this.nJe;
    }

    public final d dPp() {
        return this.nKd;
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public final class C0867a {
        private final String imageKey;
        private final g nKe;
        final /* synthetic */ a nKf;

        public C0867a(a aVar, String str, g gVar) {
            q.m(gVar, "frameEntity");
            this.nKf = aVar;
            this.imageKey = str;
            this.nKe = gVar;
        }

        public final String dPq() {
            return this.imageKey;
        }

        public final g dPr() {
            return this.nKe;
        }
    }

    public final List<C0867a> KW(int i) {
        C0867a c0867a;
        ArrayList arrayList = new ArrayList();
        for (com.opensource.svgaplayer.entities.f fVar : this.nJe.dPk()) {
            if (i < 0 || i >= fVar.dPO().size()) {
                c0867a = null;
            } else {
                c0867a = fVar.dPO().get(i).dPP() <= 0.0d ? null : new C0867a(this, fVar.dPq(), fVar.dPO().get(i));
            }
            if (c0867a != null) {
                arrayList.add(c0867a);
            }
        }
        return arrayList;
    }

    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.m(canvas, "canvas");
        q.m(scaleType, "scaleType");
        this.nKd.a(canvas.getWidth(), canvas.getHeight(), (float) this.nJe.dPi().getWidth(), (float) this.nJe.dPi().getHeight(), scaleType);
    }
}
