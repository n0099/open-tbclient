package com.facebook.drawee.view;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.generic.c;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class GenericDraweeView extends DraweeView<com.facebook.drawee.generic.a> {
    public GenericDraweeView(Context context) {
        super(context);
        l(context, null);
    }

    public GenericDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        l(context, attributeSet);
    }

    public GenericDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        l(context, attributeSet);
    }

    protected void l(Context context, @Nullable AttributeSet attributeSet) {
        com.facebook.drawee.generic.b k = c.k(context, attributeSet);
        setAspectRatio(k.eiq());
        setHierarchy(k.eiD());
    }
}
