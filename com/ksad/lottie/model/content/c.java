package com.ksad.lottie.model.content;

import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f31895a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f31896b;

    public c(float[] fArr, int[] iArr) {
        this.f31895a = fArr;
        this.f31896b = iArr;
    }

    public void a(c cVar, c cVar2, float f2) {
        if (cVar.f31896b.length == cVar2.f31896b.length) {
            for (int i = 0; i < cVar.f31896b.length; i++) {
                this.f31895a[i] = com.ksad.lottie.d.e.a(cVar.f31895a[i], cVar2.f31895a[i], f2);
                this.f31896b[i] = com.ksad.lottie.d.b.a(f2, cVar.f31896b[i], cVar2.f31896b[i]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.f31896b.length + " vs " + cVar2.f31896b.length + SmallTailInfo.EMOTION_SUFFIX);
    }

    public float[] a() {
        return this.f31895a;
    }

    public int[] b() {
        return this.f31896b;
    }

    public int c() {
        return this.f31896b.length;
    }
}
