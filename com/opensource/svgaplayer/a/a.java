package com.opensource.svgaplayer.a;

import android.graphics.Canvas;
import android.widget.ImageView;
import com.opensource.svgaplayer.b.d;
import com.opensource.svgaplayer.entities.g;
import com.opensource.svgaplayer.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.p;
/* loaded from: classes4.dex */
public class a {
    private final f mKs;
    private final d mLr;

    public a(f fVar) {
        p.j(fVar, "videoItem");
        this.mKs = fVar;
        this.mLr = new d();
    }

    public final f dzC() {
        return this.mKs;
    }

    public final d dzX() {
        return this.mLr;
    }

    /* renamed from: com.opensource.svgaplayer.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public final class C0682a {
        private final String imageKey;
        private final g mLs;
        final /* synthetic */ a mLt;

        public C0682a(a aVar, String str, g gVar) {
            p.j(gVar, "frameEntity");
            this.mLt = aVar;
            this.imageKey = str;
            this.mLs = gVar;
        }

        public final String dzY() {
            return this.imageKey;
        }

        public final g dzZ() {
            return this.mLs;
        }
    }

    public final List<C0682a> Mv(int i) {
        C0682a c0682a;
        ArrayList arrayList = new ArrayList();
        for (com.opensource.svgaplayer.entities.f fVar : this.mKs.dzS()) {
            if (i < 0 || i >= fVar.dAw().size()) {
                c0682a = null;
            } else {
                c0682a = fVar.dAw().get(i).dAx() <= 0.0d ? null : new C0682a(this, fVar.dzY(), fVar.dAw().get(i));
            }
            if (c0682a != null) {
                arrayList.add(c0682a);
            }
        }
        return arrayList;
    }

    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        p.j(canvas, "canvas");
        p.j(scaleType, "scaleType");
        this.mLr.a(canvas.getWidth(), canvas.getHeight(), (float) this.mKs.dzQ().getWidth(), (float) this.mKs.dzQ().getHeight(), scaleType);
    }
}
