package com.facebook.drawee.view;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.generic.c;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class GenericDraweeView extends DraweeView<com.facebook.drawee.generic.a> {
    public GenericDraweeView(Context context) {
        super(context);
        n(context, null);
    }

    public GenericDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        n(context, attributeSet);
    }

    public GenericDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        n(context, attributeSet);
    }

    protected void n(Context context, @Nullable AttributeSet attributeSet) {
        com.facebook.drawee.generic.b m = c.m(context, attributeSet);
        setAspectRatio(m.evW());
        setHierarchy(m.ewj());
    }
}
