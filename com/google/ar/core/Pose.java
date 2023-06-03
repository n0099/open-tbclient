package com.google.ar.core;

import com.baidu.tieba.t6b;
import java.util.Locale;
/* loaded from: classes9.dex */
public class Pose {
    public final t6b a;
    public final float[] b;

    static {
        t6b t6bVar = t6b.e;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "t:[x:%.3f, y:%.3f, z:%.3f], q:[x:%.2f, y:%.2f, z:%.2f, w:%.2f]", Float.valueOf(this.b[0]), Float.valueOf(this.b[1]), Float.valueOf(this.b[2]), Float.valueOf(this.a.a()), Float.valueOf(this.a.c()), Float.valueOf(this.a.d()), Float.valueOf(this.a.e()));
    }
}
