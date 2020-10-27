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
    private final f ptP;
    private final d puN;

    public a(f fVar) {
        q.n(fVar, "videoItem");
        this.ptP = fVar;
        this.puN = new d();
    }

    public final f esN() {
        return this.ptP;
    }

    public final d etj() {
        return this.puN;
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public final class C1012a {
        private final String imageKey;
        private final g puO;
        final /* synthetic */ a puP;

        public C1012a(a aVar, String str, g gVar) {
            q.n(gVar, "frameEntity");
            this.puP = aVar;
            this.imageKey = str;
            this.puO = gVar;
        }

        public final g etk() {
            return this.puO;
        }

        public final String getImageKey() {
            return this.imageKey;
        }
    }

    public final List<C1012a> QC(int i) {
        C1012a c1012a;
        ArrayList arrayList = new ArrayList();
        for (com.opensource.svgaplayer.entities.f fVar : this.ptP.ete()) {
            if (i < 0 || i >= fVar.etH().size()) {
                c1012a = null;
            } else {
                c1012a = fVar.etH().get(i).etI() <= 0.0d ? null : new C1012a(this, fVar.getImageKey(), fVar.etH().get(i));
            }
            if (c1012a != null) {
                arrayList.add(c1012a);
            }
        }
        return arrayList;
    }

    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.n(canvas, "canvas");
        q.n(scaleType, "scaleType");
        this.puN.a(canvas.getWidth(), canvas.getHeight(), (float) this.ptP.etc().getWidth(), (float) this.ptP.etc().getHeight(), scaleType);
    }
}
