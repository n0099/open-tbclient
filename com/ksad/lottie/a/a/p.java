package com.ksad.lottie.a.a;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.a;
import com.ksad.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes6.dex */
public class p implements l, a.InterfaceC0366a {

    /* renamed from: a  reason: collision with root package name */
    public final Path f31561a = new Path();

    /* renamed from: b  reason: collision with root package name */
    public final String f31562b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.f f31563c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Path> f31564d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f31565e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public r f31566f;

    public p(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.k kVar) {
        this.f31562b = kVar.a();
        this.f31563c = fVar;
        com.ksad.lottie.a.b.a<com.ksad.lottie.model.content.h, Path> a2 = kVar.b().a();
        this.f31564d = a2;
        aVar.a(a2);
        this.f31564d.a(this);
    }

    private void b() {
        this.f31565e = false;
        this.f31563c.invalidateSelf();
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0366a
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
                    this.f31566f = rVar;
                    rVar.a(this);
                }
            }
        }
    }

    @Override // com.ksad.lottie.a.a.l
    public Path d() {
        if (this.f31565e) {
            return this.f31561a;
        }
        this.f31561a.reset();
        this.f31561a.set(this.f31564d.e());
        this.f31561a.setFillType(Path.FillType.EVEN_ODD);
        com.ksad.lottie.d.f.a(this.f31561a, this.f31566f);
        this.f31565e = true;
        return this.f31561a;
    }
}
