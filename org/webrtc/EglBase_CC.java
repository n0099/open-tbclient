package org.webrtc;

import android.support.annotation.Nullable;
import javax.microedition.khronos.egl.EGLContext;
import org.webrtc.EglBase;
import org.webrtc.EglBase10;
import org.webrtc.EglBase14;
/* loaded from: classes16.dex */
public final /* synthetic */ class EglBase_CC {
    public static EglBase create() {
        return create(null, EglBase.CONFIG_PLAIN);
    }

    public static EglBase create(EglBase.Context context) {
        return create(context, EglBase.CONFIG_PLAIN);
    }

    public static EglBase create(@Nullable EglBase.Context context, int[] iArr) {
        return (EglBase14.isEGL14Supported() && (context == null || (context instanceof EglBase14.Context))) ? new EglBase14((EglBase14.Context) context, iArr) : new EglBase10((EglBase10.Context) context, iArr);
    }

    public static EglBase createEgl10(EGLContext eGLContext, int[] iArr) {
        return new EglBase10(new EglBase10.Context(eGLContext), iArr);
    }

    public static EglBase createEgl10(int[] iArr) {
        return new EglBase10(null, iArr);
    }

    public static EglBase createEgl14(android.opengl.EGLContext eGLContext, int[] iArr) {
        return new EglBase14(new EglBase14.Context(eGLContext), iArr);
    }

    public static EglBase createEgl14(int[] iArr) {
        return new EglBase14(null, iArr);
    }
}
