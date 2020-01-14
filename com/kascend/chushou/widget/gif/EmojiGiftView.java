package com.kascend.chushou.widget.gif;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.drawee.generic.RoundingParams;
import com.kascend.chushou.a;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
/* loaded from: classes4.dex */
public class EmojiGiftView extends FrameLayout {
    private FrescoThumbnailView nay;

    public EmojiGiftView(@NonNull Context context) {
        super(context);
        a(context);
    }

    public EmojiGiftView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public EmojiGiftView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(a.h.widget_emoji_gift, (ViewGroup) this, true);
        this.nay = (FrescoThumbnailView) findViewById(a.f.iv_emoji_gift_icon);
        this.nay.setAnim(true);
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.a(RoundingParams.RoundingMethod.OVERLAY_COLOR);
        roundingParams.HL(tv.chushou.widget.a.c.getColor(a.c.kas_white));
        roundingParams.bq(2.0f);
        this.nay.getHierarchy().a(roundingParams);
    }

    public void g(String str, int i, int i2, int i3) {
        if (this.nay != null) {
            this.nay.h(str, i, i2, i3);
        }
    }
}
