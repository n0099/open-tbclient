package com.opensource.svgaplayer.a;

import android.graphics.Canvas;
import android.widget.ImageView;
import com.opensource.svgaplayer.b.d;
import com.opensource.svgaplayer.entities.g;
import com.opensource.svgaplayer.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.e;
import kotlin.jvm.internal.p;
@e
/* loaded from: classes6.dex */
public class a {
    private final f pSH;
    private final d pTF;

    public a(f fVar) {
        p.o(fVar, "videoItem");
        this.pSH = fVar;
        this.pTF = new d();
    }

    public final f eDX() {
        return this.pSH;
    }

    public final d eEt() {
        return this.pTF;
    }

    @e
    /* renamed from: com.opensource.svgaplayer.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public final class C1185a {
        private final String imageKey;
        private final g pTG;
        final /* synthetic */ a pTH;

        public C1185a(a aVar, String str, g gVar) {
            p.o(gVar, "frameEntity");
            this.pTH = aVar;
            this.imageKey = str;
            this.pTG = gVar;
        }

        public final g eEu() {
            return this.pTG;
        }

        public final String getImageKey() {
            return this.imageKey;
        }
    }

    public final List<C1185a> RP(int i) {
        C1185a c1185a;
        ArrayList arrayList = new ArrayList();
        for (com.opensource.svgaplayer.entities.f fVar : this.pSH.eEo()) {
            if (i < 0 || i >= fVar.eER().size()) {
                c1185a = null;
            } else {
                c1185a = fVar.eER().get(i).eES() <= 0.0d ? null : new C1185a(this, fVar.getImageKey(), fVar.eER().get(i));
            }
            if (c1185a != null) {
                arrayList.add(c1185a);
            }
        }
        return arrayList;
    }

    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        p.o(canvas, "canvas");
        p.o(scaleType, "scaleType");
        this.pTF.a(canvas.getWidth(), canvas.getHeight(), (float) this.pSH.eEm().getWidth(), (float) this.pSH.eEm().getHeight(), scaleType);
    }
}
