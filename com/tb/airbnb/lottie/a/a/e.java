package com.tb.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes20.dex */
public class e implements j, l, a.InterfaceC1019a {
    private boolean DY;
    private final com.tb.airbnb.lottie.g lottieDrawable;
    private final String name;
    @Nullable
    private r pAV;
    private final com.tb.airbnb.lottie.a.b.a<?, PointF> pAX;
    private final com.tb.airbnb.lottie.a.b.a<?, PointF> pAY;
    private final com.tb.airbnb.lottie.model.content.a pAZ;
    private final Path path = new Path();

    public e(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.a aVar2) {
        this.name = aVar2.getName();
        this.lottieDrawable = gVar;
        this.pAX = aVar2.eBt().eBj();
        this.pAY = aVar2.eBm().eBj();
        this.pAZ = aVar2;
        aVar.a(this.pAX);
        aVar.a(this.pAY);
        this.pAX.b(this);
        this.pAY.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC1019a
    public void iT() {
        invalidate();
    }

    private void invalidate() {
        this.DY = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof r) && ((r) bVar).eAZ() == ShapeTrimPath.Type.Simultaneously) {
                    this.pAV = (r) bVar;
                    this.pAV.a(this);
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
    public Path iW() {
        if (this.DY) {
            return this.path;
        }
        this.path.reset();
        PointF value = this.pAX.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = f2 * 0.55228f;
        this.path.reset();
        if (this.pAZ.isReversed()) {
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
        PointF value2 = this.pAY.getValue();
        this.path.offset(value2.x, value2.y);
        this.path.close();
        com.tb.airbnb.lottie.d.f.a(this.path, this.pAV);
        this.DY = true;
        return this.path;
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        com.tb.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.k.CX) {
            this.pAX.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.CY) {
            this.pAY.a(cVar);
        }
    }
}
