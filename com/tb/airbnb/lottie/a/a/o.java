package com.tb.airbnb.lottie.a.a;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes6.dex */
public class o implements k, a.InterfaceC0572a {
    private boolean ei;
    private final com.tb.airbnb.lottie.a.b.a<?, Path> ksC;
    @Nullable
    private q ksf;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final String name;
    private final Path path = new Path();

    public o(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.k kVar) {
        this.name = kVar.getName();
        this.lottieDrawable = fVar;
        this.ksC = kVar.cMa().cLl();
        aVar.a(this.ksC);
        this.ksC.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0572a
    public void bt() {
        invalidate();
    }

    private void invalidate() {
        this.ei = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof q) && ((q) bVar).cLd() == ShapeTrimPath.Type.Simultaneously) {
                    this.ksf = (q) bVar;
                    this.ksf.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.k
    public Path bw() {
        if (this.ei) {
            return this.path;
        }
        this.path.reset();
        this.path.set(this.ksC.getValue());
        this.path.setFillType(Path.FillType.EVEN_ODD);
        com.tb.airbnb.lottie.c.f.a(this.path, this.ksf);
        this.ei = true;
        return this.path;
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }
}
