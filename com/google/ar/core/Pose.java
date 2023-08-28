package com.google.ar.core;

import com.baidu.tieba.zrb;
import java.util.Locale;
/* loaded from: classes9.dex */
public class Pose {
    public final zrb a;
    public final float[] b;

    static {
        zrb zrbVar = zrb.e;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "t:[x:%.3f, y:%.3f, z:%.3f], q:[x:%.2f, y:%.2f, z:%.2f, w:%.2f]", Float.valueOf(this.b[0]), Float.valueOf(this.b[1]), Float.valueOf(this.b[2]), Float.valueOf(this.a.a()), Float.valueOf(this.a.c()), Float.valueOf(this.a.d()), Float.valueOf(this.a.e()));
    }
}
