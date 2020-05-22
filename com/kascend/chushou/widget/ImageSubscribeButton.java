package com.kascend.chushou.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.kascend.chushou.a;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
/* loaded from: classes5.dex */
public class ImageSubscribeButton extends LinearLayout {
    private String a;
    private String b;
    private FrescoThumbnailView mTS;

    public ImageSubscribeButton(Context context) {
        this(context, null, 0);
    }

    public ImageSubscribeButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageSubscribeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(a.h.widget_image_subscribe_button, (ViewGroup) this, true);
        this.mTS = (FrescoThumbnailView) findViewById(a.f.iv_image_subscribe_btn);
    }

    public void a(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public void a(int i) {
        if (i == 1) {
            setVisibility(0);
            setEnabled(false);
            this.mTS.bV(this.b, a.e.btn_follow_user_disabled);
        } else if (i == 2) {
            setVisibility(0);
            setEnabled(true);
            this.mTS.bV(this.b, a.e.btn_follow_user_disabled);
        } else if (i == 0) {
            setVisibility(0);
            setEnabled(true);
            this.mTS.bV(this.a, a.e.btn_follow_user_enabled);
        } else if (i == -1) {
            setVisibility(8);
        }
    }

    public void b(int i) {
        a(i);
    }
}
