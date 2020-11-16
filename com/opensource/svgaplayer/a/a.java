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
/* loaded from: classes17.dex */
public class a {
    private final f pEM;
    private final d pFK;

    public a(f fVar) {
        q.n(fVar, "videoItem");
        this.pEM = fVar;
        this.pFK = new d();
    }

    public final f ewD() {
        return this.pEM;
    }

    public final d ewZ() {
        return this.pFK;
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public final class C1034a {
        private final String imageKey;
        private final g pFL;
        final /* synthetic */ a pFM;

        public C1034a(a aVar, String str, g gVar) {
            q.n(gVar, "frameEntity");
            this.pFM = aVar;
            this.imageKey = str;
            this.pFL = gVar;
        }

        public final g exa() {
            return this.pFL;
        }

        public final String getImageKey() {
            return this.imageKey;
        }
    }

    public final List<C1034a> RA(int i) {
        C1034a c1034a;
        ArrayList arrayList = new ArrayList();
        for (com.opensource.svgaplayer.entities.f fVar : this.pEM.ewU()) {
            if (i < 0 || i >= fVar.exx().size()) {
                c1034a = null;
            } else {
                c1034a = fVar.exx().get(i).exy() <= 0.0d ? null : new C1034a(this, fVar.getImageKey(), fVar.exx().get(i));
            }
            if (c1034a != null) {
                arrayList.add(c1034a);
            }
        }
        return arrayList;
    }

    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.n(canvas, "canvas");
        q.n(scaleType, "scaleType");
        this.pFK.a(canvas.getWidth(), canvas.getHeight(), (float) this.pEM.ewS().getWidth(), (float) this.pEM.ewS().getHeight(), scaleType);
    }
}
