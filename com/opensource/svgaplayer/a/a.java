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
    private final f ocX;
    private final d odW;

    public a(f fVar) {
        q.m(fVar, "videoItem");
        this.ocX = fVar;
        this.odW = new d();
    }

    public final f eaV() {
        return this.ocX;
    }

    public final d ebr() {
        return this.odW;
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public final class C0925a {
        private final String imageKey;
        private final g odX;
        final /* synthetic */ a odY;

        public C0925a(a aVar, String str, g gVar) {
            q.m(gVar, "frameEntity");
            this.odY = aVar;
            this.imageKey = str;
            this.odX = gVar;
        }

        public final String ebs() {
            return this.imageKey;
        }

        public final g ebt() {
            return this.odX;
        }
    }

    public final List<C0925a> NA(int i) {
        C0925a c0925a;
        ArrayList arrayList = new ArrayList();
        for (com.opensource.svgaplayer.entities.f fVar : this.ocX.ebm()) {
            if (i < 0 || i >= fVar.ebQ().size()) {
                c0925a = null;
            } else {
                c0925a = fVar.ebQ().get(i).ebR() <= 0.0d ? null : new C0925a(this, fVar.ebs(), fVar.ebQ().get(i));
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
        this.odW.a(canvas.getWidth(), canvas.getHeight(), (float) this.ocX.ebk().getWidth(), (float) this.ocX.ebk().getHeight(), scaleType);
    }
}
