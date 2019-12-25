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
/* loaded from: classes2.dex */
public class n implements d, i, k, a.InterfaceC0687a {
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final com.tb.airbnb.lottie.model.layer.a mNl;
    private final com.tb.airbnb.lottie.a.b.a<Float, Float> mNm;
    private final com.tb.airbnb.lottie.a.b.a<Float, Float> mNn;
    private final com.tb.airbnb.lottie.a.b.p mNo;
    private c mNp;
    private final String name;
    private final Matrix matrix = new Matrix();
    private final Path path = new Path();

    public n(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.g gVar) {
        this.lottieDrawable = fVar;
        this.mNl = aVar;
        this.name = gVar.getName();
        this.mNm = gVar.dCf().dBq();
        aVar.a(this.mNm);
        this.mNm.b(this);
        this.mNn = gVar.dCg().dBq();
        aVar.a(this.mNn);
        this.mNn.b(this);
        this.mNo = gVar.dCh().dBI();
        this.mNo.a(aVar);
        this.mNo.a(this);
    }

    @Override // com.tb.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.mNp == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.mNp = new c(this.lottieDrawable, this.mNl, "Repeater", arrayList, null);
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.mNp.b(list, list2);
    }

    @Override // com.tb.airbnb.lottie.a.a.k
    public Path bF() {
        Path bF = this.mNp.bF();
        this.path.reset();
        float floatValue = this.mNm.getValue().floatValue();
        float floatValue2 = this.mNn.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.mNo.j(i + floatValue2));
            this.path.addPath(bF, this.matrix);
        }
        return this.path;
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.mNm.getValue().floatValue();
        float floatValue2 = this.mNn.getValue().floatValue();
        float floatValue3 = this.mNo.dBo().getValue().floatValue() / 100.0f;
        float floatValue4 = this.mNo.dBp().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.mNo.j(i2 + floatValue2));
            this.mNp.a(canvas, this.matrix, (int) (i * com.tb.airbnb.lottie.c.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.mNp.a(rectF, matrix);
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.mNp.b(str, str2, colorFilter);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0687a
    public void bC() {
        this.lottieDrawable.invalidateSelf();
    }
}
