package com.kascend.chushou.player.ui.giftpopup;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.utils.BaseUtils;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.d.e;
import com.tencent.connect.common.Constants;
import java.util.List;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
import tv.chushou.zues.widget.fresco.b;
/* loaded from: classes6.dex */
public class b extends LinearLayout implements View.OnClickListener {
    private View b;
    private ImageView c;
    private List<ListItem> e;
    private ListItem nHj;
    private FrescoThumbnailView nTn;

    public b(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(a.h.popup_gift_right, (ViewGroup) this, true);
        this.nTn = (FrescoThumbnailView) findViewById(a.f.gift_popup_gift);
        this.nTn.setAnim(true);
        this.b = findViewById(a.f.gift_popup_close_layout);
        this.c = (ImageView) findViewById(a.f.gift_popup_close_view);
        this.nTn.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
    }

    public void a(int i, @NonNull List<ListItem> list, @NonNull ListItem listItem) {
        if (i == 2 || i == 1) {
            this.c.setImageResource(a.e.ic_room_ad_close_circle);
        } else if (i == 3) {
            this.b.setVisibility(8);
        } else {
            this.c.setImageResource(a.e.ic_room_ad_close_circle);
        }
        this.e = list;
        this.nHj = listItem;
        this.nTn.a(listItem.mCover, a.e.default_color_bg, tv.chushou.zues.widget.fresco.b.oOx, b.C1017b.oOz, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.gift_popup_close_layout || id == a.f.gift_popup_close_view) {
            if (this.e != null) {
                this.e.remove(this.nHj);
            }
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this);
            }
        } else if (id == a.f.gift_popup_gift && this.nHj != null) {
            e.a(getContext(), this.nHj, e.O("_fromView", Constants.VIA_ACT_TYPE_NINETEEN, "_fromPos", BaseUtils.METHOD_SENDMESSAGE));
        }
    }
}
