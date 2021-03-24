package com.ksad.lottie.a.a;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.a;
import com.ksad.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes6.dex */
public class p implements l, a.InterfaceC0351a {

    /* renamed from: a  reason: collision with root package name */
    public final Path f31271a = new Path();

    /* renamed from: b  reason: collision with root package name */
    public final String f31272b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.f f31273c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Path> f31274d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f31275e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public r f31276f;

    public p(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.k kVar) {
        this.f31272b = kVar.a();
        this.f31273c = fVar;
        com.ksad.lottie.a.b.a<com.ksad.lottie.model.content.h, Path> a2 = kVar.b().a();
        this.f31274d = a2;
        aVar.a(a2);
        this.f31274d.a(this);
    }

    private void b() {
        this.f31275e = false;
        this.f31273c.invalidateSelf();
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0351a
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
                    this.f31276f = rVar;
                    rVar.a(this);
                }
            }
        }
    }

    @Override // com.ksad.lottie.a.a.l
    public Path d() {
        if (this.f31275e) {
            return this.f31271a;
        }
        this.f31271a.reset();
        this.f31271a.set(this.f31274d.e());
        this.f31271a.setFillType(Path.FillType.EVEN_ODD);
        com.ksad.lottie.d.f.a(this.f31271a, this.f31276f);
        this.f31275e = true;
        return this.f31271a;
    }
}
