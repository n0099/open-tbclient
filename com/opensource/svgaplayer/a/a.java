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
    private final f mJk;
    private final d mKj;

    public a(f fVar) {
        q.j(fVar, "videoItem");
        this.mJk = fVar;
        this.mKj = new d();
    }

    public final f dzj() {
        return this.mJk;
    }

    public final d dzF() {
        return this.mKj;
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0758a {
        private final String imageKey;
        private final g mKk;
        final /* synthetic */ a mKl;

        public C0758a(a aVar, String str, g gVar) {
            q.j(gVar, "frameEntity");
            this.mKl = aVar;
            this.imageKey = str;
            this.mKk = gVar;
        }

        public final String dzG() {
            return this.imageKey;
        }

        public final g dzH() {
            return this.mKk;
        }
    }

    public final List<C0758a> II(int i) {
        C0758a c0758a;
        ArrayList arrayList = new ArrayList();
        for (com.opensource.svgaplayer.entities.f fVar : this.mJk.dzA()) {
            if (i < 0 || i >= fVar.dAe().size()) {
                c0758a = null;
            } else {
                c0758a = fVar.dAe().get(i).dAf() <= 0.0d ? null : new C0758a(this, fVar.dzG(), fVar.dAe().get(i));
            }
            if (c0758a != null) {
                arrayList.add(c0758a);
            }
        }
        return arrayList;
    }

    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.j(canvas, "canvas");
        q.j(scaleType, "scaleType");
        this.mKj.a(canvas.getWidth(), canvas.getHeight(), (float) this.mJk.dzy().getWidth(), (float) this.mJk.dzy().getHeight(), scaleType);
    }
}
