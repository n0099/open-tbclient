package com.tb.airbnb.lottie.a.a;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes6.dex */
public class p implements l, a.InterfaceC0865a {
    private boolean Cb;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final com.tb.airbnb.lottie.a.b.a<?, Path> nFV;
    @Nullable
    private r nFz;
    private final String name;
    private final Path path = new Path();

    public p(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.k kVar) {
        this.name = kVar.getName();
        this.lottieDrawable = fVar;
        this.nFV = kVar.dOn().dNG();
        aVar.a(this.nFV);
        this.nFV.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0865a
    public void hq() {
        invalidate();
    }

    private void invalidate() {
        this.Cb = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof r) && ((r) bVar).dNw() == ShapeTrimPath.Type.Simultaneously) {
                    this.nFz = (r) bVar;
                    this.nFz.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.l
    public Path ht() {
        if (this.Cb) {
            return this.path;
        }
        this.path.reset();
        this.path.set(this.nFV.getValue());
        this.path.setFillType(Path.FillType.EVEN_ODD);
        com.tb.airbnb.lottie.d.f.a(this.path, this.nFz);
        this.Cb = true;
        return this.path;
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }
}
