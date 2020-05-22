package com.tb.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes6.dex */
public class n implements j, l, a.InterfaceC0844a {
    private boolean BB;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final String name;
    private final com.tb.airbnb.lottie.a.b.a<?, PointF> niA;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> niO;
    @Nullable
    private r nix;
    private final com.tb.airbnb.lottie.a.b.a<?, PointF> niz;
    private final Path path = new Path();
    private final RectF rect = new RectF();

    public n(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.f fVar2) {
        this.name = fVar2.getName();
        this.lottieDrawable = fVar;
        this.niA = fVar2.dIL().dII();
        this.niz = fVar2.dIS().dII();
        this.niO = fVar2.dJk().dII();
        aVar.a(this.niA);
        aVar.a(this.niz);
        aVar.a(this.niO);
        this.niA.b(this);
        this.niz.b(this);
        this.niO.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0844a
    public void ha() {
        invalidate();
    }

    private void invalidate() {
        this.BB = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof r) && ((r) bVar).dIy() == ShapeTrimPath.Type.Simultaneously) {
                    this.nix = (r) bVar;
                    this.nix.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.l
    public Path hd() {
        if (this.BB) {
            return this.path;
        }
        this.path.reset();
        PointF value = this.niz.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        float floatValue = this.niO == null ? 0.0f : this.niO.getValue().floatValue();
        float min = Math.min(f, f2);
        if (floatValue <= min) {
            min = floatValue;
        }
        PointF value2 = this.niA.getValue();
        this.path.moveTo(value2.x + f, (value2.y - f2) + min);
        this.path.lineTo(value2.x + f, (value2.y + f2) - min);
        if (min > 0.0f) {
            this.rect.set((value2.x + f) - (2.0f * min), (value2.y + f2) - (2.0f * min), value2.x + f, value2.y + f2);
            this.path.arcTo(this.rect, 0.0f, 90.0f, false);
        }
        this.path.lineTo((value2.x - f) + min, value2.y + f2);
        if (min > 0.0f) {
            this.rect.set(value2.x - f, (value2.y + f2) - (2.0f * min), (value2.x - f) + (2.0f * min), value2.y + f2);
            this.path.arcTo(this.rect, 90.0f, 90.0f, false);
        }
        this.path.lineTo(value2.x - f, (value2.y - f2) + min);
        if (min > 0.0f) {
            this.rect.set(value2.x - f, value2.y - f2, (value2.x - f) + (2.0f * min), (value2.y - f2) + (2.0f * min));
            this.path.arcTo(this.rect, 180.0f, 90.0f, false);
        }
        this.path.lineTo((value2.x + f) - min, value2.y - f2);
        if (min > 0.0f) {
            this.rect.set((value2.x + f) - (2.0f * min), value2.y - f2, f + value2.x, (value2.y - f2) + (min * 2.0f));
            this.path.arcTo(this.rect, 270.0f, 90.0f, false);
        }
        this.path.close();
        com.tb.airbnb.lottie.d.f.a(this.path, this.nix);
        this.BB = true;
        return this.path;
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        com.tb.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
    }
}
