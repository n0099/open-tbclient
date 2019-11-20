package com.tb.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes6.dex */
public class e implements k, a.InterfaceC0577a {
    private boolean ei;
    @Nullable
    private q ksf;
    private final com.tb.airbnb.lottie.a.b.a<?, PointF> ksh;
    private final com.tb.airbnb.lottie.a.b.a<?, PointF> ksi;
    private final com.tb.airbnb.lottie.model.content.a ksj;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final String name;
    private final Path path = new Path();

    public e(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.a aVar2) {
        this.name = aVar2.getName();
        this.lottieDrawable = fVar;
        this.ksh = aVar2.cLD().cLl();
        this.ksi = aVar2.cLu().cLl();
        this.ksj = aVar2;
        aVar.a(this.ksh);
        aVar.a(this.ksi);
        this.ksh.b(this);
        this.ksi.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0577a
    public void bt() {
        invalidate();
    }

    private void invalidate() {
        this.ei = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof q) && ((q) bVar).cLd() == ShapeTrimPath.Type.Simultaneously) {
                    this.ksf = (q) bVar;
                    this.ksf.a(this);
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

    @Override // com.tb.airbnb.lottie.a.a.k
    public Path bw() {
        if (this.ei) {
            return this.path;
        }
        this.path.reset();
        PointF value = this.ksh.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = f2 * 0.55228f;
        this.path.reset();
        if (this.ksj.isReversed()) {
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
        PointF value2 = this.ksi.getValue();
        this.path.offset(value2.x, value2.y);
        this.path.close();
        com.tb.airbnb.lottie.c.f.a(this.path, this.ksf);
        this.ei = true;
        return this.path;
    }
}
