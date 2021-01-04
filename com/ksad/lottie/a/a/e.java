package com.ksad.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.a;
import com.ksad.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes5.dex */
public class e implements j, l, a.InterfaceC1037a {

    /* renamed from: a  reason: collision with root package name */
    private final Path f8234a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final String f8235b;
    private final com.ksad.lottie.f c;
    private final com.ksad.lottie.a.b.a<?, PointF> d;
    private final com.ksad.lottie.a.b.a<?, PointF> e;
    private final com.ksad.lottie.model.content.a f;
    @Nullable
    private r g;
    private boolean h;

    public e(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.a aVar2) {
        this.f8235b = aVar2.a();
        this.c = fVar;
        this.d = aVar2.c().a();
        this.e = aVar2.b().a();
        this.f = aVar2;
        aVar.a(this.d);
        aVar.a(this.e);
        this.d.a(this);
        this.e.a(this);
    }

    private void b() {
        this.h = false;
        this.c.invalidateSelf();
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC1037a
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
                this.g = (r) bVar;
                this.g.a(this);
            }
            i = i2 + 1;
        }
    }

    @Override // com.ksad.lottie.a.a.l
    public Path d() {
        if (this.h) {
            return this.f8234a;
        }
        this.f8234a.reset();
        PointF e = this.d.e();
        float f = e.x / 2.0f;
        float f2 = e.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = f2 * 0.55228f;
        this.f8234a.reset();
        if (this.f.d()) {
            this.f8234a.moveTo(0.0f, -f2);
            this.f8234a.cubicTo(0.0f - f3, -f2, -f, 0.0f - f4, -f, 0.0f);
            this.f8234a.cubicTo(-f, 0.0f + f4, 0.0f - f3, f2, 0.0f, f2);
            this.f8234a.cubicTo(0.0f + f3, f2, f, 0.0f + f4, f, 0.0f);
            this.f8234a.cubicTo(f, 0.0f - f4, 0.0f + f3, -f2, 0.0f, -f2);
        } else {
            this.f8234a.moveTo(0.0f, -f2);
            this.f8234a.cubicTo(0.0f + f3, -f2, f, 0.0f - f4, f, 0.0f);
            this.f8234a.cubicTo(f, 0.0f + f4, 0.0f + f3, f2, 0.0f, f2);
            this.f8234a.cubicTo(0.0f - f3, f2, -f, 0.0f + f4, -f, 0.0f);
            this.f8234a.cubicTo(-f, 0.0f - f4, 0.0f - f3, -f2, 0.0f, -f2);
        }
        PointF e2 = this.e.e();
        this.f8234a.offset(e2.x, e2.y);
        this.f8234a.close();
        com.ksad.lottie.d.f.a(this.f8234a, this.g);
        this.h = true;
        return this.f8234a;
    }
}
