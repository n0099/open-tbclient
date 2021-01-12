package com.ksad.lottie.a.a;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.a;
import com.ksad.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes4.dex */
public class p implements l, a.InterfaceC1061a {

    /* renamed from: a  reason: collision with root package name */
    private final Path f7952a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final String f7953b;
    private final com.ksad.lottie.f c;
    private final com.ksad.lottie.a.b.a<?, Path> d;
    private boolean e;
    @Nullable
    private r f;

    public p(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.k kVar) {
        this.f7953b = kVar.a();
        this.c = fVar;
        this.d = kVar.b().a();
        aVar.a(this.d);
        this.d.a(this);
    }

    private void b() {
        this.e = false;
        this.c.invalidateSelf();
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC1061a
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
                this.f = (r) bVar;
                this.f.a(this);
            }
            i = i2 + 1;
        }
    }

    @Override // com.ksad.lottie.a.a.l
    public Path d() {
        if (this.e) {
            return this.f7952a;
        }
        this.f7952a.reset();
        this.f7952a.set(this.d.e());
        this.f7952a.setFillType(Path.FillType.EVEN_ODD);
        com.ksad.lottie.d.f.a(this.f7952a, this.f);
        this.e = true;
        return this.f7952a;
    }
}
