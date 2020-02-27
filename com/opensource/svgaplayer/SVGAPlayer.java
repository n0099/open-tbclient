package com.opensource.svgaplayer;

import android.content.Context;
import android.util.AttributeSet;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes.dex */
public final class SVGAPlayer extends SVGAImageView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGAPlayer(Context context) {
        super(context);
        q.j(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGAPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        q.j(context, "context");
        q.j(attributeSet, "attrs");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGAPlayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        q.j(context, "context");
        q.j(attributeSet, "attrs");
    }
}
