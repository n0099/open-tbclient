package com.kascend.chushou.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.pay.PayHelper;
import com.facebook.drawee.generic.RoundingParams;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.ListItem;
import tv.chushou.zues.utils.e;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
import tv.chushou.zues.widget.fresco.b;
/* loaded from: classes5.dex */
public class ItemTagView extends FrameLayout {
    private TextView c;
    private Context d;
    private FrescoThumbnailView mUT;
    private FrescoThumbnailView mVi;

    public ItemTagView(@NonNull Context context) {
        this(context, null, 0);
    }

    public ItemTagView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemTagView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = context;
        View inflate = LayoutInflater.from(context).inflate(a.h.widget_room_tag, (ViewGroup) this, true);
        this.mUT = (FrescoThumbnailView) inflate.findViewById(a.f.iv_bg);
        this.mVi = (FrescoThumbnailView) inflate.findViewById(a.f.iv_tag_icon);
        this.mVi.setVisibility(8);
        this.c = (TextView) inflate.findViewById(a.f.tv_tag);
    }

    public void a(ListItem listItem) {
        if (listItem != null) {
            if (!TextUtils.isEmpty(listItem.mCornerIcon) && listItem.mDisplayTagBgHeight > 0) {
                setVisibility(0);
                this.mVi.setVisibility(8);
                this.c.setVisibility(8);
                this.mUT.setVisibility(0);
                this.mUT.i(listItem.mCornerIcon, a.c.transparent, b.C0924b.small, b.C0924b.small);
                this.mUT.getHierarchy().Hh(a.e.bg_listitem_room_tag);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mUT.getLayoutParams();
                layoutParams.height = tv.chushou.zues.utils.a.dip2px(this.d, listItem.mDisplayTagBgHeight);
                if (listItem.mDisplayTagBgWidth > 0.01f) {
                    layoutParams.width = (int) (layoutParams.height * listItem.mDisplayTagBgWidth);
                } else {
                    layoutParams.width = -1;
                }
                this.mUT.setLayoutParams(layoutParams);
            } else if (PayHelper.STATUS_SUCC.equals(listItem.mType)) {
                b(listItem);
            } else {
                a(listItem.mDisplayTag, listItem.mDisplayTagBackground, listItem.mDisplayTagColor, listItem.mCornerIcon, listItem.mDisplayTagBgWidth, listItem);
            }
        }
    }

    public void a(String str, String str2, String str3, String str4, float f, ListItem listItem) {
        int color;
        if (h.isEmpty(str) && h.isEmpty(str4)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (!h.isEmpty(str4)) {
            this.c.setVisibility(8);
            this.mUT.setVisibility(0);
            this.mUT.a(str4, a.c.transparent, b.C0924b.small, b.C0924b.small, 1, new FrescoThumbnailView.a() { // from class: com.kascend.chushou.widget.ItemTagView.1
                @Override // tv.chushou.zues.widget.fresco.FrescoThumbnailView.a
                public void dA(int i, int i2) {
                    e.d("ItemTagView", "on image size getwidth: " + i);
                    if (ItemTagView.this.mUT != null && i2 > 0) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ItemTagView.this.mUT.getLayoutParams();
                        layoutParams.height = tv.chushou.zues.utils.a.dip2px(ItemTagView.this.d, 16.0f);
                        layoutParams.width = (int) (((i * 1.0d) / i2) * layoutParams.height);
                        ItemTagView.this.mUT.setLayoutParams(layoutParams);
                    }
                }
            });
            return;
        }
        this.c.setVisibility(0);
        try {
            color = Color.parseColor(str3);
        } catch (Exception e) {
            color = ContextCompat.getColor(getContext(), a.c.white);
        }
        this.c.setTextColor(color);
        this.c.setText(str);
        if (h.isEmpty(listItem.mDisplayTagIcon)) {
            this.mVi.setVisibility(8);
        } else {
            this.c.setPadding(tv.chushou.zues.utils.a.dip2px(this.d, 2.0f), 0, tv.chushou.zues.utils.a.dip2px(this.d, 4.0f), 0);
            this.mVi.setVisibility(0);
            this.mVi.i(listItem.mDisplayTagIcon, a.c.transparent, tv.chushou.zues.utils.a.dip2px(this.d, 9.0f), tv.chushou.zues.utils.a.dip2px(this.d, 9.0f));
        }
        this.mUT.i(str2, a.c.transparent, b.C0924b.small, b.C0924b.small);
        this.mUT.getHierarchy().Hh(a.e.bg_listitem_room_tag);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mUT.getLayoutParams();
        layoutParams.height = tv.chushou.zues.utils.a.dip2px(this.d, 16.0f);
        if (f != 0.0f) {
            layoutParams.width = (int) (layoutParams.height * f);
        } else {
            layoutParams.width = -1;
        }
        this.mUT.setLayoutParams(layoutParams);
    }

    public void b(ListItem listItem) {
        int color;
        if (listItem == null) {
            setVisibility(8);
        } else if (h.isEmpty(listItem.mDisplayTag) && h.isEmpty(listItem.mDisplayTagBackground)) {
            setVisibility(8);
        } else {
            setVisibility(0);
            this.c.setVisibility(0);
            try {
                color = Color.parseColor(listItem.mDisplayTagColor);
            } catch (Exception e) {
                color = ContextCompat.getColor(getContext(), a.c.white);
            }
            this.c.setTextColor(color);
            this.c.setText(listItem.mDisplayTag);
            if (h.isEmpty(listItem.mDisplayTagIcon)) {
                this.mVi.setVisibility(8);
            } else {
                this.c.setPadding(tv.chushou.zues.utils.a.dip2px(this.d, 2.0f), 0, tv.chushou.zues.utils.a.dip2px(this.d, 4.0f), 0);
                this.mVi.setVisibility(0);
                this.mVi.i(listItem.mDisplayTagIcon, a.c.transparent, tv.chushou.zues.utils.a.dip2px(this.d, 9.0f), tv.chushou.zues.utils.a.dip2px(this.d, 9.0f));
            }
            this.mUT.i(listItem.mDisplayTagBackground, a.c.transparent, b.C0924b.small, b.C0924b.small);
            this.mUT.getHierarchy().Hh(a.e.bg_listitem_room_tag);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mUT.getLayoutParams();
            layoutParams.height = tv.chushou.zues.utils.a.dip2px(this.d, 16.0f);
            if (listItem.mDisplayTagBgWidth != 0.0f) {
                layoutParams.width = (int) (layoutParams.height * listItem.mDisplayTagBgWidth);
            } else {
                layoutParams.width = -1;
            }
            this.mUT.setLayoutParams(layoutParams);
        }
    }

    public void a(float f, float f2, float f3, float f4) {
        RoundingParams dwD;
        if (this.mUT != null && (dwD = this.mUT.getHierarchy().dwD()) != null) {
            dwD.h(f, f2, f3, f4);
        }
    }
}
