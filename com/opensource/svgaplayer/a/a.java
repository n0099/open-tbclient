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
/* loaded from: classes16.dex */
public class a {
    private final d onZ;
    private final f ona;

    public a(f fVar) {
        q.m(fVar, "videoItem");
        this.ona = fVar;
        this.onZ = new d();
    }

    public final f efc() {
        return this.ona;
    }

    public final d efy() {
        return this.onZ;
    }

    @h
    /* renamed from: com.opensource.svgaplayer.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public final class C0922a {
        private final String imageKey;
        private final g ooa;
        final /* synthetic */ a oob;

        public C0922a(a aVar, String str, g gVar) {
            q.m(gVar, "frameEntity");
            this.oob = aVar;
            this.imageKey = str;
            this.ooa = gVar;
        }

        public final g efz() {
            return this.ooa;
        }

        public final String getImageKey() {
            return this.imageKey;
        }
    }

    public final List<C0922a> Of(int i) {
        C0922a c0922a;
        ArrayList arrayList = new ArrayList();
        for (com.opensource.svgaplayer.entities.f fVar : this.ona.eft()) {
            if (i < 0 || i >= fVar.efW().size()) {
                c0922a = null;
            } else {
                c0922a = fVar.efW().get(i).efX() <= 0.0d ? null : new C0922a(this, fVar.getImageKey(), fVar.efW().get(i));
            }
            if (c0922a != null) {
                arrayList.add(c0922a);
            }
        }
        return arrayList;
    }

    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        q.m(canvas, "canvas");
        q.m(scaleType, "scaleType");
        this.onZ.a(canvas.getWidth(), canvas.getHeight(), (float) this.ona.efr().getWidth(), (float) this.ona.efr().getHeight(), scaleType);
    }
}
