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
/* loaded from: classes15.dex */
public class a {
    private final f pDj;
    private final d pEh;

    public a(f fVar) {
        q.n(fVar, "videoItem");
        this.pDj = fVar;
        this.pEh = new d();
    }

    public final f ewC() {
        return this.pDj;
    }

    public final d ewY() {
        return this.pEh;
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public final class C1031a {
        private final String imageKey;
        private final g pEi;
        final /* synthetic */ a pEj;

        public C1031a(a aVar, String str, g gVar) {
            q.n(gVar, "frameEntity");
            this.pEj = aVar;
            this.imageKey = str;
            this.pEi = gVar;
        }

        public final g ewZ() {
            return this.pEi;
        }

        public final String getImageKey() {
            return this.imageKey;
        }
    }

    public final List<C1031a> QX(int i) {
        C1031a c1031a;
        ArrayList arrayList = new ArrayList();
        for (com.opensource.svgaplayer.entities.f fVar : this.pDj.ewT()) {
            if (i < 0 || i >= fVar.exw().size()) {
                c1031a = null;
            } else {
                c1031a = fVar.exw().get(i).exx() <= 0.0d ? null : new C1031a(this, fVar.getImageKey(), fVar.exw().get(i));
            }
            if (c1031a != null) {
                arrayList.add(c1031a);
            }
        }
        return arrayList;
    }

    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.n(canvas, "canvas");
        q.n(scaleType, "scaleType");
        this.pEh.a(canvas.getWidth(), canvas.getHeight(), (float) this.pDj.ewR().getWidth(), (float) this.pDj.ewR().getHeight(), scaleType);
    }
}
