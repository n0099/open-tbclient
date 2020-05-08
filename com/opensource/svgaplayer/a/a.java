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
    private final f mJn;
    private final d mKm;

    public a(f fVar) {
        q.j(fVar, "videoItem");
        this.mJn = fVar;
        this.mKm = new d();
    }

    public final f dzf() {
        return this.mJn;
    }

    public final d dzB() {
        return this.mKm;
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0779a {
        private final String imageKey;
        private final g mKn;
        final /* synthetic */ a mKo;

        public C0779a(a aVar, String str, g gVar) {
            q.j(gVar, "frameEntity");
            this.mKo = aVar;
            this.imageKey = str;
            this.mKn = gVar;
        }

        public final String dzC() {
            return this.imageKey;
        }

        public final g dzD() {
            return this.mKn;
        }
    }

    public final List<C0779a> II(int i) {
        C0779a c0779a;
        ArrayList arrayList = new ArrayList();
        for (com.opensource.svgaplayer.entities.f fVar : this.mJn.dzw()) {
            if (i < 0 || i >= fVar.dAa().size()) {
                c0779a = null;
            } else {
                c0779a = fVar.dAa().get(i).dAb() <= 0.0d ? null : new C0779a(this, fVar.dzC(), fVar.dAa().get(i));
            }
            if (c0779a != null) {
                arrayList.add(c0779a);
            }
        }
        return arrayList;
    }

    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.j(canvas, "canvas");
        q.j(scaleType, "scaleType");
        this.mKm.a(canvas.getWidth(), canvas.getHeight(), (float) this.mJn.dzu().getWidth(), (float) this.mJn.dzu().getHeight(), scaleType);
    }
}
