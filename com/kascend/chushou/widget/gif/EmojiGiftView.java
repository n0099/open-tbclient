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
/* loaded from: classes6.dex */
public class EmojiGiftView extends FrameLayout {
    private FrescoThumbnailView pkk;

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
        this.pkk = (FrescoThumbnailView) findViewById(a.f.iv_emoji_gift_icon);
        this.pkk.setAnim(true);
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.a(RoundingParams.RoundingMethod.OVERLAY_COLOR);
        roundingParams.Ot(tv.chushou.widget.a.c.getColor(a.c.kas_white));
        roundingParams.bm(2.0f);
        this.pkk.getHierarchy().a(roundingParams);
    }

    public void a(String str, int i, int i2, int i3) {
        if (this.pkk != null) {
            this.pkk.i(str, i, i2, i3);
        }
    }
}
