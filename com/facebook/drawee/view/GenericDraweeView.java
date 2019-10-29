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

    @TargetApi(21)
    public GenericDraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        l(context, attributeSet);
    }

    protected void l(Context context, @Nullable AttributeSet attributeSet) {
        com.facebook.drawee.generic.b k = c.k(context, attributeSet);
        setAspectRatio(k.cEH());
        setHierarchy(k.cEX());
    }
}
