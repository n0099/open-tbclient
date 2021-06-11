package com.ksad.lottie.a.a;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.a;
import com.ksad.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes6.dex */
public class p implements l, a.InterfaceC0352a {

    /* renamed from: a  reason: collision with root package name */
    public final Path f31800a = new Path();

    /* renamed from: b  reason: collision with root package name */
    public final String f31801b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.f f31802c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Path> f31803d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f31804e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public r f31805f;

    public p(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.k kVar) {
        this.f31801b = kVar.a();
        this.f31802c = fVar;
        com.ksad.lottie.a.b.a<com.ksad.lottie.model.content.h, Path> a2 = kVar.b().a();
        this.f31803d = a2;
        aVar.a(a2);
        this.f31803d.a(this);
    }

    private void b() {
        this.f31804e = false;
        this.f31802c.invalidateSelf();
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0352a
    public void a() {
        b();
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
            if (bVar instanceof r) {
                r rVar = (r) bVar;
                if (rVar.b() == ShapeTrimPath.Type.Simultaneously) {
                    this.f31805f = rVar;
                    rVar.a(this);
                }
            }
        }
    }

    @Override // com.ksad.lottie.a.a.l
    public Path d() {
        if (this.f31804e) {
            return this.f31800a;
        }
        this.f31800a.reset();
        this.f31800a.set(this.f31803d.e());
        this.f31800a.setFillType(Path.FillType.EVEN_ODD);
        com.ksad.lottie.d.f.a(this.f31800a, this.f31805f);
        this.f31804e = true;
        return this.f31800a;
    }
}
