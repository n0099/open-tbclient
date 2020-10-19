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
    private final f oCt;
    private final d oDr;

    public a(f fVar) {
        q.n(fVar, "videoItem");
        this.oCt = fVar;
        this.oDr = new d();
    }

    public final f eiN() {
        return this.oCt;
    }

    public final d ejj() {
        return this.oDr;
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public final class C0940a {
        private final String imageKey;
        private final g oDs;
        final /* synthetic */ a oDt;

        public C0940a(a aVar, String str, g gVar) {
            q.n(gVar, "frameEntity");
            this.oDt = aVar;
            this.imageKey = str;
            this.oDs = gVar;
        }

        public final g ejk() {
            return this.oDs;
        }

        public final String getImageKey() {
            return this.imageKey;
        }
    }

    public final List<C0940a> OL(int i) {
        C0940a c0940a;
        ArrayList arrayList = new ArrayList();
        for (com.opensource.svgaplayer.entities.f fVar : this.oCt.eje()) {
            if (i < 0 || i >= fVar.ejH().size()) {
                c0940a = null;
            } else {
                c0940a = fVar.ejH().get(i).ejI() <= 0.0d ? null : new C0940a(this, fVar.getImageKey(), fVar.ejH().get(i));
            }
            if (c0940a != null) {
                arrayList.add(c0940a);
            }
        }
        return arrayList;
    }

    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.n(canvas, "canvas");
        q.n(scaleType, "scaleType");
        this.oDr.a(canvas.getWidth(), canvas.getHeight(), (float) this.oCt.ejc().getWidth(), (float) this.oCt.ejc().getHeight(), scaleType);
    }
}
