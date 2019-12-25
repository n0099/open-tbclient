package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class f implements d, a.InterfaceC0687a {
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> mMR;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> mMY;
    private final String name;
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final List<k> fO = new ArrayList();

    public f(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.i iVar) {
        this.name = iVar.getName();
        this.lottieDrawable = fVar;
        if (iVar.dCi() == null || iVar.dBF() == null) {
            this.mMY = null;
            this.mMR = null;
            return;
        }
        this.path.setFillType(iVar.cz());
        this.mMY = iVar.dCi().dBq();
        this.mMY.b(this);
        aVar.a(this.mMY);
        this.mMR = iVar.dBF().dBq();
        this.mMR.b(this);
        aVar.a(this.mMR);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0687a
    public void bC() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                b bVar = list2.get(i2);
                if (bVar instanceof k) {
                    this.fO.add((k) bVar);
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

    @Override // com.tb.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.d.beginSection("FillContent#draw");
        this.paint.setColor(this.mMY.getValue().intValue());
        Paint paint = this.paint;
        paint.setAlpha((int) (((this.mMR.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        this.path.reset();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.fO.size()) {
                this.path.addPath(this.fO.get(i3).bF(), matrix);
                i2 = i3 + 1;
            } else {
                canvas.drawPath(this.path, this.paint);
                com.tb.airbnb.lottie.d.F("FillContent#draw");
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.fO.size(); i++) {
            this.path.addPath(this.fO.get(i).bF(), matrix);
        }
        this.path.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }
}
