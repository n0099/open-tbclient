package com.tb.airbnb.lottie.a.a;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes20.dex */
public class p implements l, a.InterfaceC1019a {
    private boolean DY;
    private final com.tb.airbnb.lottie.g lottieDrawable;
    private final String name;
    @Nullable
    private r pAT;
    private final com.tb.airbnb.lottie.a.b.a<?, Path> pBp;
    private final Path path = new Path();

    public p(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.k kVar) {
        this.name = kVar.getName();
        this.lottieDrawable = gVar;
        this.pBp = kVar.eBP().eBi();
        aVar.a(this.pBp);
        this.pBp.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC1019a
    public void iT() {
        invalidate();
    }

    private void invalidate() {
        this.DY = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof r) && ((r) bVar).eAY() == ShapeTrimPath.Type.Simultaneously) {
                    this.pAT = (r) bVar;
                    this.pAT.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.l
    public Path iW() {
        if (this.DY) {
            return this.path;
        }
        this.path.reset();
        this.path.set(this.pBp.getValue());
        this.path.setFillType(Path.FillType.EVEN_ODD);
        com.tb.airbnb.lottie.d.f.a(this.path, this.pAT);
        this.DY = true;
        return this.path;
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }
}
