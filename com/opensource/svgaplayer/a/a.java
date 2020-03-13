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
    private final f nkN;
    private final d nlM;

    public a(f fVar) {
        q.j(fVar, "videoItem");
        this.nkN = fVar;
        this.nlM = new d();
    }

    public final f dEH() {
        return this.nkN;
    }

    public final d dFc() {
        return this.nlM;
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0733a {
        private final String imageKey;
        private final g nlN;
        final /* synthetic */ a nlO;

        public C0733a(a aVar, String str, g gVar) {
            q.j(gVar, "frameEntity");
            this.nlO = aVar;
            this.imageKey = str;
            this.nlN = gVar;
        }

        public final String dFd() {
            return this.imageKey;
        }

        public final g dFe() {
            return this.nlN;
        }
    }

    public final List<C0733a> Ni(int i) {
        C0733a c0733a;
        ArrayList arrayList = new ArrayList();
        for (com.opensource.svgaplayer.entities.f fVar : this.nkN.dEX()) {
            if (i < 0 || i >= fVar.dFB().size()) {
                c0733a = null;
            } else {
                c0733a = fVar.dFB().get(i).dFC() <= 0.0d ? null : new C0733a(this, fVar.dFd(), fVar.dFB().get(i));
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
        this.nlM.a(canvas.getWidth(), canvas.getHeight(), (float) this.nkN.dEV().getWidth(), (float) this.nkN.dEV().getHeight(), scaleType);
    }
}
