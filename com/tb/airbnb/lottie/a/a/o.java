package com.tb.airbnb.lottie.a.a;

import android.graphics.Path;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes6.dex */
public class o implements k, a.InterfaceC0577a {
    private boolean eI;
    @Nullable
    private q ksW;
    private final com.tb.airbnb.lottie.a.b.a<?, Path> ktt;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final String name;
    private final Path path = new Path();

    public o(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.k kVar) {
        this.name = kVar.getName();
        this.lottieDrawable = fVar;
        this.ktt = kVar.cMc().cLn();
        aVar.a(this.ktt);
        this.ktt.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0577a
    public void bt() {
        invalidate();
    }

    private void invalidate() {
        this.eI = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b bVar = list.get(i2);
                if ((bVar instanceof q) && ((q) bVar).cLf() == ShapeTrimPath.Type.Simultaneously) {
                    this.ksW = (q) bVar;
                    this.ksW.a(this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.k
    public Path bw() {
        if (this.eI) {
            return this.path;
        }
        this.path.reset();
        this.path.set(this.ktt.getValue());
        this.path.setFillType(Path.FillType.EVEN_ODD);
        com.tb.airbnb.lottie.c.f.a(this.path, this.ksW);
        this.eI = true;
        return this.path;
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }
}
