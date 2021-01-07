package com.ksad.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.a;
import com.ksad.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes5.dex */
public class n implements j, l, a.InterfaceC1078a {

    /* renamed from: a  reason: collision with root package name */
    private final Path f8248a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final RectF f8249b = new RectF();
    private final String c;
    private final com.ksad.lottie.f d;
    private final com.ksad.lottie.a.b.a<?, PointF> e;
    private final com.ksad.lottie.a.b.a<?, PointF> f;
    private final com.ksad.lottie.a.b.a<?, Float> g;
    @Nullable
    private r h;
    private boolean i;

    public n(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.f fVar2) {
        this.c = fVar2.a();
        this.d = fVar;
        this.e = fVar2.d().a();
        this.f = fVar2.c().a();
        this.g = fVar2.b().a();
        aVar.a(this.e);
        aVar.a(this.f);
        aVar.a(this.g);
        this.e.a(this);
        this.f.a(this);
        this.g.a(this);
    }

    private void b() {
        this.i = false;
        this.d.invalidateSelf();
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC1078a
    public void a() {
        b();
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            b bVar = list.get(i2);
            if ((bVar instanceof r) && ((r) bVar).b() == ShapeTrimPath.Type.Simultaneously) {
                this.h = (r) bVar;
                this.h.a(this);
            }
            i = i2 + 1;
        }
    }

    @Override // com.ksad.lottie.a.a.l
    public Path d() {
        if (this.i) {
            return this.f8248a;
        }
        this.f8248a.reset();
        PointF e = this.f.e();
        float f = e.x / 2.0f;
        float f2 = e.y / 2.0f;
        float floatValue = this.g == null ? 0.0f : this.g.e().floatValue();
        float min = Math.min(f, f2);
        if (floatValue <= min) {
            min = floatValue;
        }
        PointF e2 = this.e.e();
        this.f8248a.moveTo(e2.x + f, (e2.y - f2) + min);
        this.f8248a.lineTo(e2.x + f, (e2.y + f2) - min);
        if (min > 0.0f) {
            this.f8249b.set((e2.x + f) - (2.0f * min), (e2.y + f2) - (2.0f * min), e2.x + f, e2.y + f2);
            this.f8248a.arcTo(this.f8249b, 0.0f, 90.0f, false);
        }
        this.f8248a.lineTo((e2.x - f) + min, e2.y + f2);
        if (min > 0.0f) {
            this.f8249b.set(e2.x - f, (e2.y + f2) - (2.0f * min), (e2.x - f) + (2.0f * min), e2.y + f2);
            this.f8248a.arcTo(this.f8249b, 90.0f, 90.0f, false);
        }
        this.f8248a.lineTo(e2.x - f, (e2.y - f2) + min);
        if (min > 0.0f) {
            this.f8249b.set(e2.x - f, e2.y - f2, (e2.x - f) + (2.0f * min), (e2.y - f2) + (2.0f * min));
            this.f8248a.arcTo(this.f8249b, 180.0f, 90.0f, false);
        }
        this.f8248a.lineTo((e2.x + f) - min, e2.y - f2);
        if (min > 0.0f) {
            this.f8249b.set((e2.x + f) - (2.0f * min), e2.y - f2, f + e2.x, (e2.y - f2) + (min * 2.0f));
            this.f8248a.arcTo(this.f8249b, 270.0f, 90.0f, false);
        }
        this.f8248a.close();
        com.ksad.lottie.d.f.a(this.f8248a, this.h);
        this.i = true;
        return this.f8248a;
    }
}
