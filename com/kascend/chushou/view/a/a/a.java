package com.kascend.chushou.view.a.a;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.player.ui.food.FoodView;
import org.json.JSONException;
import org.json.JSONObject;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
import tv.chushou.zues.widget.fresco.b;
/* loaded from: classes5.dex */
public class a extends RecyclerView.ViewHolder implements View.OnClickListener {
    private View a;
    private TextView c;
    private TextView d;
    private TextView h;
    private Context i;
    private boolean l;
    private String m;
    private FrescoThumbnailView mZw;
    private int n;
    private FoodView ncR;
    private FrescoThumbnailView ndf;
    private FrescoThumbnailView ndk;
    private ListItem ngR;
    private com.kascend.chushou.view.a.a<ListItem> ngS;
    private int o;
    private int p;
    private int q;

    public a(View view, com.kascend.chushou.view.a.a<ListItem> aVar, boolean z, String str) {
        super(view);
        this.n = AdCard.INVALID_NUM;
        this.o = AdCard.INVALID_NUM;
        this.p = AdCard.INVALID_NUM;
        this.q = AdCard.INVALID_NUM;
        this.m = str;
        this.i = view.getContext();
        this.a = view;
        this.ngS = aVar;
        this.ncR = (FoodView) view.findViewById(a.f.iv_cover);
        this.ndk = (FrescoThumbnailView) view.findViewById(a.f.iv_right_bottom_icon1);
        this.mZw = (FrescoThumbnailView) view.findViewById(a.f.iv_right_bottom_icon2);
        this.ndf = (FrescoThumbnailView) view.findViewById(a.f.iv_pkLiveIcon);
        this.c = (TextView) view.findViewById(a.f.tv_creator);
        this.d = (TextView) view.findViewById(a.f.tv_count);
        this.h = (TextView) view.findViewById(a.f.tv_name);
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.kascend.chushou.view.a.a.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() == 0) {
                    a.this.n = (int) motionEvent.getX();
                    a.this.o = (int) motionEvent.getY();
                    a.this.p = AdCard.INVALID_NUM;
                    a.this.q = AdCard.INVALID_NUM;
                    return false;
                } else if (motionEvent.getActionMasked() == 1) {
                    a.this.p = (int) motionEvent.getX();
                    a.this.q = (int) motionEvent.getY();
                    return false;
                } else {
                    return false;
                }
            }
        });
        view.setOnClickListener(this);
        this.l = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ngR != null && PayHelper.STATUS_SUCC.equals(this.ngR.mType)) {
            JSONObject N = com.kascend.chushou.d.e.N("_fromView", this.m);
            try {
                N.put("__DOWN_X__", String.valueOf(this.n));
                N.put("__DOWN_Y__", String.valueOf(this.o));
                N.put("__UP_X__", String.valueOf(this.p));
                N.put("__UP_Y__", String.valueOf(this.q));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            com.kascend.chushou.d.e.a(this.i, this.ngR, N);
        } else if (this.ngS != null && this.ngR != null) {
            this.ngS.b(view, this.ngR);
        }
    }

    public void a(ListItem listItem) {
        a(listItem, null, false);
    }

    public void a(ListItem listItem, int[] iArr, boolean z) {
        this.ngR = listItem;
        this.ncR.a(listItem, (FoodView.a) null, false, (String) null, false);
        int size = listItem.mRightBottomIcons == null ? 0 : listItem.mRightBottomIcons.size();
        if (size == 0) {
            this.ndk.setVisibility(8);
            this.mZw.setVisibility(8);
        } else if (size == 1) {
            this.ndk.setVisibility(8);
            this.mZw.setVisibility(0);
            this.mZw.i(listItem.mRightBottomIcons.get(0), 0, b.C0817b.medium, b.C0817b.medium);
        } else {
            listItem.mRightBottomIcons.subList(0, 2);
            this.ndk.setVisibility(0);
            this.ndk.i(listItem.mRightBottomIcons.get(0), 0, b.C0817b.medium, b.C0817b.medium);
            this.mZw.setVisibility(0);
            this.mZw.i(listItem.mRightBottomIcons.get(1), 0, b.C0817b.medium, b.C0817b.medium);
        }
        tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
        if (PayHelper.STATUS_SUCC.equals(listItem.mType)) {
            cVar.append(listItem.mDesc);
        } else {
            cVar.append(listItem.mCreater).append(HanziToPinyin.Token.SEPARATOR).a(this.i, tv.chushou.widget.a.c.SP(listItem.mGender), a.d.double_icon_size, a.d.double_icon_size);
        }
        this.c.setText(cVar);
        if (this.l) {
            if (h.parseLong(listItem.mOnlineCount) > 0) {
                this.d.setVisibility(0);
                tv.chushou.zues.widget.a.c cVar2 = new tv.chushou.zues.widget.a.c();
                cVar2.a(this.i, a.e.icon_live_count, a.d.double_icon_size, a.d.double_icon_size).append(tv.chushou.zues.utils.b.formatNumber(listItem.mOnlineCount));
                this.d.setText(cVar2);
            } else {
                this.d.setVisibility(8);
            }
        } else {
            this.d.setVisibility(8);
        }
        this.h.setText(listItem.mName);
        if (iArr != null && z && this.a != null) {
            Context context = this.a.getContext();
            GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) this.a.getLayoutParams();
            layoutParams.bottomMargin = tv.chushou.zues.utils.a.dip2px(context, iArr[1]);
            this.a.setLayoutParams(layoutParams);
        }
    }
}
