package com.facebook.drawee.d;

import android.graphics.drawable.Drawable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes4.dex */
public interface c extends b {
    void A(Throwable th);

    void B(Throwable th);

    void a(Drawable drawable, float f, boolean z);

    void d(float f, boolean z);

    void reset();

    void u(Drawable drawable);
}
