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
/* loaded from: classes11.dex */
public class a {
    private final f odp;
    private final d oeo;

    public a(f fVar) {
        q.m(fVar, "videoItem");
        this.odp = fVar;
        this.oeo = new d();
    }

    public final f ebe() {
        return this.odp;
    }

    public final d ebA() {
        return this.oeo;
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public final class C0925a {
        private final String imageKey;
        private final g oep;
        final /* synthetic */ a oeq;

        public C0925a(a aVar, String str, g gVar) {
            q.m(gVar, "frameEntity");
            this.oeq = aVar;
            this.imageKey = str;
            this.oep = gVar;
        }

        public final String ebB() {
            return this.imageKey;
        }

        public final g ebC() {
            return this.oep;
        }
    }

    public final List<C0925a> NA(int i) {
        C0925a c0925a;
        ArrayList arrayList = new ArrayList();
        for (com.opensource.svgaplayer.entities.f fVar : this.odp.ebv()) {
            if (i < 0 || i >= fVar.ebZ().size()) {
                c0925a = null;
            } else {
                c0925a = fVar.ebZ().get(i).eca() <= 0.0d ? null : new C0925a(this, fVar.ebB(), fVar.ebZ().get(i));
            }
            if (c0925a != null) {
                arrayList.add(c0925a);
            }
        }
        return arrayList;
    }

    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.m(canvas, "canvas");
        q.m(scaleType, "scaleType");
        this.oeo.a(canvas.getWidth(), canvas.getHeight(), (float) this.odp.ebt().getWidth(), (float) this.odp.ebt().getHeight(), scaleType);
    }
}
