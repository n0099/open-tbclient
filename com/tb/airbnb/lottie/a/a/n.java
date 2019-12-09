package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
/* loaded from: classes6.dex */
public class n implements d, i, k, a.InterfaceC0572a {
    private final com.tb.airbnb.lottie.a.b.p ksA;
    private c ksB;
    private final com.tb.airbnb.lottie.model.layer.a ksx;
    private final com.tb.airbnb.lottie.a.b.a<Float, Float> ksy;
    private final com.tb.airbnb.lottie.a.b.a<Float, Float> ksz;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final String name;
    private final Matrix matrix = new Matrix();
    private final Path path = new Path();

    public n(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.g gVar) {
        this.lottieDrawable = fVar;
        this.ksx = aVar;
        this.name = gVar.getName();
        this.ksy = gVar.cLW().cLl();
        aVar.a(this.ksy);
        this.ksy.b(this);
        this.ksz = gVar.cLX().cLl();
        aVar.a(this.ksz);
        this.ksz.b(this);
        this.ksA = gVar.cLY().cLA();
        this.ksA.a(aVar);
        this.ksA.a(this);
    }

    @Override // com.tb.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.ksB == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.ksB = new c(this.lottieDrawable, this.ksx, "Repeater", arrayList, null);
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.ksB.b(list, list2);
    }

    @Override // com.tb.airbnb.lottie.a.a.k
    public Path bw() {
        Path bw = this.ksB.bw();
        this.path.reset();
        float floatValue = this.ksy.getValue().floatValue();
        float floatValue2 = this.ksz.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.ksA.h(i + floatValue2));
            this.path.addPath(bw, this.matrix);
        }
        return this.path;
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.ksy.getValue().floatValue();
        float floatValue2 = this.ksz.getValue().floatValue();
        float floatValue3 = this.ksA.cLj().getValue().floatValue() / 100.0f;
        float floatValue4 = this.ksA.cLk().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.ksA.h(i2 + floatValue2));
            this.ksB.a(canvas, this.matrix, (int) (i * com.tb.airbnb.lottie.c.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.ksB.a(rectF, matrix);
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.ksB.b(str, str2, colorFilter);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0572a
    public void bt() {
        this.lottieDrawable.invalidateSelf();
    }
}
