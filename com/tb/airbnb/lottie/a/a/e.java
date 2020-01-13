package com.tb.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes5.dex */
public class e implements j, l, a.InterfaceC0730a {
    private boolean fV;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final String name;
    @Nullable
    private r noZ;
    private final com.tb.airbnb.lottie.a.b.a<?, PointF> npb;
    private final com.tb.airbnb.lottie.a.b.a<?, PointF> npc;
    private final com.tb.airbnb.lottie.model.content.a npd;
    private final Path path = new Path();

    public e(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.a aVar2) {
        this.name = aVar2.getName();
        this.lottieDrawable = fVar;
        this.npb = aVar2.dFO().dFE();
        this.npc = aVar2.dFH().dFE();
        this.npd = aVar2;
        aVar.a(this.npb);
        aVar.a(this.npc);
        this.npb.b(this);
        this.npc.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0730a
    public void bC() {
        invalidate();
    }

    private void invalidate() {
        this.fV = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof r) && ((r) bVar).dFu() == ShapeTrimPath.Type.Simultaneously) {
                    this.noZ = (r) bVar;
                    this.noZ.a(this);
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
    public Path bF() {
        if (this.fV) {
            return this.path;
        }
        this.path.reset();
        PointF value = this.npb.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = f2 * 0.55228f;
        this.path.reset();
        if (this.npd.isReversed()) {
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
        PointF value2 = this.npc.getValue();
        this.path.offset(value2.x, value2.y);
        this.path.close();
        com.tb.airbnb.lottie.d.f.a(this.path, this.noZ);
        this.fV = true;
        return this.path;
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        com.tb.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.eQ) {
            this.npb.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eR) {
            this.npc.a(cVar);
        }
    }
}
