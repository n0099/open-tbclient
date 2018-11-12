package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.generic.c;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class GenericDraweeView extends DraweeView<com.facebook.drawee.generic.a> {
    public GenericDraweeView(Context context, com.facebook.drawee.generic.a aVar) {
        super(context);
        setHierarchy(aVar);
    }

    public GenericDraweeView(Context context) {
        super(context);
        inflateHierarchy(context, null);
    }

    public GenericDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflateHierarchy(context, attributeSet);
    }

    public GenericDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        inflateHierarchy(context, attributeSet);
    }

    @TargetApi(21)
    public GenericDraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        inflateHierarchy(context, attributeSet);
    }

    protected void inflateHierarchy(Context context, @Nullable AttributeSet attributeSet) {
        com.facebook.drawee.generic.b g = c.g(context, attributeSet);
        setAspectRatio(g.bSR());
        setHierarchy(g.bTh());
    }
}
