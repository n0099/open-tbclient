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
/* loaded from: classes18.dex */
public class a {
    private final f pyu;
    private final d pzs;

    public a(f fVar) {
        p.o(fVar, "videoItem");
        this.pyu = fVar;
        this.pzs = new d();
    }

    public final f ezB() {
        return this.pyu;
    }

    public final d ezX() {
        return this.pzs;
    }

    @e
    /* renamed from: com.opensource.svgaplayer.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public final class C1013a {
        private final String imageKey;
        private final g pzt;
        final /* synthetic */ a pzu;

        public C1013a(a aVar, String str, g gVar) {
            p.o(gVar, "frameEntity");
            this.pzu = aVar;
            this.imageKey = str;
            this.pzt = gVar;
        }

        public final g ezY() {
            return this.pzt;
        }

        public final String getImageKey() {
            return this.imageKey;
        }
    }

    public final List<C1013a> RC(int i) {
        C1013a c1013a;
        ArrayList arrayList = new ArrayList();
        for (com.opensource.svgaplayer.entities.f fVar : this.pyu.ezS()) {
            if (i < 0 || i >= fVar.eAv().size()) {
                c1013a = null;
            } else {
                c1013a = fVar.eAv().get(i).eAw() <= 0.0d ? null : new C1013a(this, fVar.getImageKey(), fVar.eAv().get(i));
            }
            if (c1013a != null) {
                arrayList.add(c1013a);
            }
        }
        return arrayList;
    }

    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        p.o(canvas, "canvas");
        p.o(scaleType, "scaleType");
        this.pzs.a(canvas.getWidth(), canvas.getHeight(), (float) this.pyu.ezQ().getWidth(), (float) this.pyu.ezQ().getHeight(), scaleType);
    }
}
