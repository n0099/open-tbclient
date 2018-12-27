package com.facebook.imagepipeline.b;
/* loaded from: classes2.dex */
public abstract class f {
    private static a iou;

    /* loaded from: classes2.dex */
    public interface a {
    }

    public void a(a aVar) {
        if (iou == null) {
            iou = aVar;
        }
    }
}
