package com.tb.airbnb.lottie.a.a;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes16.dex */
public class p implements l, a.InterfaceC1038a {
    private boolean De;
    private final com.tb.airbnb.lottie.g lottieDrawable;
    private final String name;
    private final com.tb.airbnb.lottie.a.b.a<?, Path> pII;
    @Nullable
    private r pIm;
    private final Path path = new Path();

    public p(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.k kVar) {
        this.name = kVar.getName();
        this.lottieDrawable = gVar;
        this.pII = kVar.ezs().eyL();
        aVar.a(this.pII);
        this.pII.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC1038a
    public void iT() {
        invalidate();
    }

    private void invalidate() {
        this.De = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof r) && ((r) bVar).eyB() == ShapeTrimPath.Type.Simultaneously) {
                    this.pIm = (r) bVar;
                    this.pIm.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.l
    public Path iW() {
        if (this.De) {
            return this.path;
        }
        this.path.reset();
        this.path.set(this.pII.getValue());
        this.path.setFillType(Path.FillType.EVEN_ODD);
        com.tb.airbnb.lottie.d.f.a(this.path, this.pIm);
        this.De = true;
        return this.path;
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }
}
