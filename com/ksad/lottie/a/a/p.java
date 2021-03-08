package com.ksad.lottie.a.a;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.a;
import com.ksad.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes3.dex */
public class p implements l, a.InterfaceC1084a {

    /* renamed from: a  reason: collision with root package name */
    private final Path f5320a = new Path();
    private final String b;
    private final com.ksad.lottie.f c;
    private final com.ksad.lottie.a.b.a<?, Path> d;
    private boolean e;
    @Nullable
    private r f;

    public p(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.k kVar) {
        this.b = kVar.a();
        this.c = fVar;
        this.d = kVar.b().a();
        aVar.a(this.d);
        this.d.a(this);
    }

    private void b() {
        this.e = false;
        this.c.invalidateSelf();
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC1084a
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
            return this.f5320a;
        }
        this.f5320a.reset();
        this.f5320a.set(this.d.e());
        this.f5320a.setFillType(Path.FillType.EVEN_ODD);
        com.ksad.lottie.d.f.a(this.f5320a, this.f);
        this.e = true;
        return this.f5320a;
    }
}
