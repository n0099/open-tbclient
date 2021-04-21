package com.ksad.lottie.a.a;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.a;
import com.ksad.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes6.dex */
public class p implements l, a.InterfaceC0369a {

    /* renamed from: a  reason: collision with root package name */
    public final Path f31656a = new Path();

    /* renamed from: b  reason: collision with root package name */
    public final String f31657b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.f f31658c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Path> f31659d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f31660e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public r f31661f;

    public p(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.k kVar) {
        this.f31657b = kVar.a();
        this.f31658c = fVar;
        com.ksad.lottie.a.b.a<com.ksad.lottie.model.content.h, Path> a2 = kVar.b().a();
        this.f31659d = a2;
        aVar.a(a2);
        this.f31659d.a(this);
    }

    private void b() {
        this.f31660e = false;
        this.f31658c.invalidateSelf();
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0369a
    public void a() {
        b();
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
        for (int i = 0; i < list.size(); i++) {
            b bVar = list.get(i);
            if (bVar instanceof r) {
                r rVar = (r) bVar;
                if (rVar.b() == ShapeTrimPath.Type.Simultaneously) {
                    this.f31661f = rVar;
                    rVar.a(this);
                }
            }
        }
    }

    @Override // com.ksad.lottie.a.a.l
    public Path d() {
        if (this.f31660e) {
            return this.f31656a;
        }
        this.f31656a.reset();
        this.f31656a.set(this.f31659d.e());
        this.f31656a.setFillType(Path.FillType.EVEN_ODD);
        com.ksad.lottie.d.f.a(this.f31656a, this.f31661f);
        this.f31660e = true;
        return this.f31656a;
    }
}
