package com.tb.airbnb.lottie.a.a;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes17.dex */
public class p implements l, a.InterfaceC0929a {
    private boolean CI;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final String name;
    private final com.tb.airbnb.lottie.a.b.a<?, Path> osB;
    @Nullable
    private r osf;
    private final Path path = new Path();

    public p(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.k kVar) {
        this.name = kVar.getName();
        this.lottieDrawable = fVar;
        this.osB = kVar.ehS().ehl();
        aVar.a(this.osB);
        this.osB.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0929a
    public void iS() {
        invalidate();
    }

    private void invalidate() {
        this.CI = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof r) && ((r) bVar).ehb() == ShapeTrimPath.Type.Simultaneously) {
                    this.osf = (r) bVar;
                    this.osf.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.l
    public Path iV() {
        if (this.CI) {
            return this.path;
        }
        this.path.reset();
        this.path.set(this.osB.getValue());
        this.path.setFillType(Path.FillType.EVEN_ODD);
        com.tb.airbnb.lottie.d.f.a(this.path, this.osf);
        this.CI = true;
        return this.path;
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }
}
