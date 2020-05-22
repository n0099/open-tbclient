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
    private final f ndq;
    private final d nep;

    public a(f fVar) {
        q.m(fVar, "videoItem");
        this.ndq = fVar;
        this.nep = new d();
    }

    public final f dGz() {
        return this.ndq;
    }

    public final d dGV() {
        return this.nep;
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0837a {
        private final String imageKey;
        private final g neq;
        final /* synthetic */ a ner;

        public C0837a(a aVar, String str, g gVar) {
            q.m(gVar, "frameEntity");
            this.ner = aVar;
            this.imageKey = str;
            this.neq = gVar;
        }

        public final String dGW() {
            return this.imageKey;
        }

        public final g dGX() {
            return this.neq;
        }
    }

    public final List<C0837a> Jt(int i) {
        C0837a c0837a;
        ArrayList arrayList = new ArrayList();
        for (com.opensource.svgaplayer.entities.f fVar : this.ndq.dGQ()) {
            if (i < 0 || i >= fVar.dHu().size()) {
                c0837a = null;
            } else {
                c0837a = fVar.dHu().get(i).dHv() <= 0.0d ? null : new C0837a(this, fVar.dGW(), fVar.dHu().get(i));
            }
            if (c0837a != null) {
                arrayList.add(c0837a);
            }
        }
        return arrayList;
    }

    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.m(canvas, "canvas");
        q.m(scaleType, "scaleType");
        this.nep.a(canvas.getWidth(), canvas.getHeight(), (float) this.ndq.dGO().getWidth(), (float) this.ndq.dGO().getHeight(), scaleType);
    }
}
