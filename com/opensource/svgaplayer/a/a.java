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
    private final f nJc;
    private final d nKb;

    public a(f fVar) {
        q.m(fVar, "videoItem");
        this.nJc = fVar;
        this.nKb = new d();
    }

    public final f dOS() {
        return this.nJc;
    }

    public final d dPo() {
        return this.nKb;
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public final class C0867a {
        private final String imageKey;
        private final g nKc;
        final /* synthetic */ a nKd;

        public C0867a(a aVar, String str, g gVar) {
            q.m(gVar, "frameEntity");
            this.nKd = aVar;
            this.imageKey = str;
            this.nKc = gVar;
        }

        public final String dPp() {
            return this.imageKey;
        }

        public final g dPq() {
            return this.nKc;
        }
    }

    public final List<C0867a> KW(int i) {
        C0867a c0867a;
        ArrayList arrayList = new ArrayList();
        for (com.opensource.svgaplayer.entities.f fVar : this.nJc.dPj()) {
            if (i < 0 || i >= fVar.dPN().size()) {
                c0867a = null;
            } else {
                c0867a = fVar.dPN().get(i).dPO() <= 0.0d ? null : new C0867a(this, fVar.dPp(), fVar.dPN().get(i));
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
        this.nKb.a(canvas.getWidth(), canvas.getHeight(), (float) this.nJc.dPh().getWidth(), (float) this.nJc.dPh().getHeight(), scaleType);
    }
}
