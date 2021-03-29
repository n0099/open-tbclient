package com.ksad.lottie.a.a;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.a;
import com.ksad.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes6.dex */
public class p implements l, a.InterfaceC0352a {

    /* renamed from: a  reason: collision with root package name */
    public final Path f31272a = new Path();

    /* renamed from: b  reason: collision with root package name */
    public final String f31273b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.f f31274c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Path> f31275d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f31276e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public r f31277f;

    public p(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.k kVar) {
        this.f31273b = kVar.a();
        this.f31274c = fVar;
        com.ksad.lottie.a.b.a<com.ksad.lottie.model.content.h, Path> a2 = kVar.b().a();
        this.f31275d = a2;
        aVar.a(a2);
        this.f31275d.a(this);
    }

    private void b() {
        this.f31276e = false;
        this.f31274c.invalidateSelf();
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0352a
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
                    this.f31277f = rVar;
                    rVar.a(this);
                }
            }
        }
    }

    @Override // com.ksad.lottie.a.a.l
    public Path d() {
        if (this.f31276e) {
            return this.f31272a;
        }
        this.f31272a.reset();
        this.f31272a.set(this.f31275d.e());
        this.f31272a.setFillType(Path.FillType.EVEN_ODD);
        com.ksad.lottie.d.f.a(this.f31272a, this.f31277f);
        this.f31276e = true;
        return this.f31272a;
    }
}
