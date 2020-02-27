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
    private final f nkA;
    private final d nlz;

    public a(f fVar) {
        q.j(fVar, "videoItem");
        this.nkA = fVar;
        this.nlz = new d();
    }

    public final f dEE() {
        return this.nkA;
    }

    public final d dEZ() {
        return this.nlz;
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0733a {
        private final String imageKey;
        private final g nlA;
        final /* synthetic */ a nlB;

        public C0733a(a aVar, String str, g gVar) {
            q.j(gVar, "frameEntity");
            this.nlB = aVar;
            this.imageKey = str;
            this.nlA = gVar;
        }

        public final String dFa() {
            return this.imageKey;
        }

        public final g dFb() {
            return this.nlA;
        }
    }

    public final List<C0733a> Ni(int i) {
        C0733a c0733a;
        ArrayList arrayList = new ArrayList();
        for (com.opensource.svgaplayer.entities.f fVar : this.nkA.dEU()) {
            if (i < 0 || i >= fVar.dFy().size()) {
                c0733a = null;
            } else {
                c0733a = fVar.dFy().get(i).dFz() <= 0.0d ? null : new C0733a(this, fVar.dFa(), fVar.dFy().get(i));
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
        this.nlz.a(canvas.getWidth(), canvas.getHeight(), (float) this.nkA.dES().getWidth(), (float) this.nkA.dES().getHeight(), scaleType);
    }
}
