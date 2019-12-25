package com.tb.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes2.dex */
public class m implements k, a.InterfaceC0687a {
    private boolean fV;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    @Nullable
    private q mMT;
    private final com.tb.airbnb.lottie.a.b.a<?, PointF> mMV;
    private final com.tb.airbnb.lottie.a.b.a<?, PointF> mMW;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> mNk;
    private final String name;
    private final Path path = new Path();
    private final RectF rect = new RectF();

    public m(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.f fVar2) {
        this.name = fVar2.getName();
        this.lottieDrawable = fVar;
        this.mMW = fVar2.dBC().dBq();
        this.mMV = fVar2.dBM().dBq();
        this.mNk = fVar2.dCe().dBq();
        aVar.a(this.mMW);
        aVar.a(this.mMV);
        aVar.a(this.mNk);
        this.mMW.b(this);
        this.mMV.b(this);
        this.mNk.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0687a
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
                if ((bVar instanceof q) && ((q) bVar).dBh() == ShapeTrimPath.Type.Simultaneously) {
                    this.mMT = (q) bVar;
                    this.mMT.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.k
    public Path bF() {
        if (this.fV) {
            return this.path;
        }
        this.path.reset();
        PointF value = this.mMV.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        float floatValue = this.mNk == null ? 0.0f : this.mNk.getValue().floatValue();
        float min = Math.min(f, f2);
        if (floatValue <= min) {
            min = floatValue;
        }
        PointF value2 = this.mMW.getValue();
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
        com.tb.airbnb.lottie.c.f.a(this.path, this.mMT);
        this.fV = true;
        return this.path;
    }
}
