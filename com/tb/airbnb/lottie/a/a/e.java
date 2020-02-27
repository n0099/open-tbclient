package com.tb.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes6.dex */
public class e implements j, l, a.InterfaceC0738a {
    private boolean fZ;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final String name;
    @Nullable
    private r npG;
    private final com.tb.airbnb.lottie.a.b.a<?, PointF> npI;
    private final com.tb.airbnb.lottie.a.b.a<?, PointF> npJ;
    private final com.tb.airbnb.lottie.model.content.a npK;
    private final Path path = new Path();

    public e(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.a aVar2) {
        this.name = aVar2.getName();
        this.lottieDrawable = fVar;
        this.npI = aVar2.dGX().dGN();
        this.npJ = aVar2.dGQ().dGN();
        this.npK = aVar2;
        aVar.a(this.npI);
        aVar.a(this.npJ);
        this.npI.b(this);
        this.npJ.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0738a
    public void bD() {
        invalidate();
    }

    private void invalidate() {
        this.fZ = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof r) && ((r) bVar).dGD() == ShapeTrimPath.Type.Simultaneously) {
                    this.npG = (r) bVar;
                    this.npG.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.tb.airbnb.lottie.a.a.l
    public Path bG() {
        if (this.fZ) {
            return this.path;
        }
        this.path.reset();
        PointF value = this.npI.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = f2 * 0.55228f;
        this.path.reset();
        if (this.npK.isReversed()) {
            this.path.moveTo(0.0f, -f2);
            this.path.cubicTo(0.0f - f3, -f2, -f, 0.0f - f4, -f, 0.0f);
            this.path.cubicTo(-f, 0.0f + f4, 0.0f - f3, f2, 0.0f, f2);
            this.path.cubicTo(0.0f + f3, f2, f, 0.0f + f4, f, 0.0f);
            this.path.cubicTo(f, 0.0f - f4, 0.0f + f3, -f2, 0.0f, -f2);
        } else {
            this.path.moveTo(0.0f, -f2);
            this.path.cubicTo(0.0f + f3, -f2, f, 0.0f - f4, f, 0.0f);
            this.path.cubicTo(f, 0.0f + f4, 0.0f + f3, f2, 0.0f, f2);
            this.path.cubicTo(0.0f - f3, f2, -f, 0.0f + f4, -f, 0.0f);
            this.path.cubicTo(-f, 0.0f - f4, 0.0f - f3, -f2, 0.0f, -f2);
        }
        PointF value2 = this.npJ.getValue();
        this.path.offset(value2.x, value2.y);
        this.path.close();
        com.tb.airbnb.lottie.d.f.a(this.path, this.npG);
        this.fZ = true;
        return this.path;
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        com.tb.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.eT) {
            this.npI.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eU) {
            this.npJ.a(cVar);
        }
    }
}
