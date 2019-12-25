package com.tb.airbnb.lottie.a.a;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes2.dex */
public class o implements k, a.InterfaceC0687a {
    private boolean fV;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    @Nullable
    private q mMT;
    private final com.tb.airbnb.lottie.a.b.a<?, Path> mNq;
    private final String name;
    private final Path path = new Path();

    public o(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.k kVar) {
        this.name = kVar.getName();
        this.lottieDrawable = fVar;
        this.mNq = kVar.dCj().dBq();
        aVar.a(this.mNq);
        this.mNq.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0687a
    public void bC() {
        invalidate();
    }

    private void invalidate() {
        this.fV = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof q) && ((q) bVar).dBh() == ShapeTrimPath.Type.Simultaneously) {
                    this.mMT = (q) bVar;
                    this.mMT.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.k
    public Path bF() {
        if (this.fV) {
            return this.path;
        }
        this.path.reset();
        this.path.set(this.mNq.getValue());
        this.path.setFillType(Path.FillType.EVEN_ODD);
        com.tb.airbnb.lottie.c.f.a(this.path, this.mMT);
        this.fV = true;
        return this.path;
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }
}
