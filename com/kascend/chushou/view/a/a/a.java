package com.kascend.chushou.view.a.a;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
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
    private FrescoThumbnailView mRe;
    private FoodView mUL;
    private FrescoThumbnailView mUZ;
    private FrescoThumbnailView mVe;
    private ListItem mYO;
    private com.kascend.chushou.view.a.a<ListItem> mYP;
    private int n;
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
        this.mYP = aVar;
        this.mUL = (FoodView) view.findViewById(a.f.iv_cover);
        this.mVe = (FrescoThumbnailView) view.findViewById(a.f.iv_right_bottom_icon1);
        this.mRe = (FrescoThumbnailView) view.findViewById(a.f.iv_right_bottom_icon2);
        this.mUZ = (FrescoThumbnailView) view.findViewById(a.f.iv_pkLiveIcon);
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
        if (this.mYO != null && PayHelper.STATUS_SUCC.equals(this.mYO.mType)) {
            JSONObject P = com.kascend.chushou.d.e.P("_fromView", this.m);
            try {
                P.put("__DOWN_X__", String.valueOf(this.n));
                P.put("__DOWN_Y__", String.valueOf(this.o));
                P.put("__UP_X__", String.valueOf(this.p));
                P.put("__UP_Y__", String.valueOf(this.q));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            com.kascend.chushou.d.e.a(this.i, this.mYO, P);
        } else if (this.mYP != null && this.mYO != null) {
            this.mYP.b(view, this.mYO);
        }
    }

    public void a(ListItem listItem) {
        a(listItem, null, false);
    }

    public void a(ListItem listItem, int[] iArr, boolean z) {
        this.mYO = listItem;
        this.mUL.a(listItem, (FoodView.a) null, false, (String) null, false);
        int size = listItem.mRightBottomIcons == null ? 0 : listItem.mRightBottomIcons.size();
        if (size == 0) {
            this.mVe.setVisibility(8);
            this.mRe.setVisibility(8);
        } else if (size == 1) {
            this.mVe.setVisibility(8);
            this.mRe.setVisibility(0);
            this.mRe.i(listItem.mRightBottomIcons.get(0), 0, b.C0924b.nQi, b.C0924b.nQi);
        } else {
            listItem.mRightBottomIcons.subList(0, 2);
            this.mVe.setVisibility(0);
            this.mVe.i(listItem.mRightBottomIcons.get(0), 0, b.C0924b.nQi, b.C0924b.nQi);
            this.mRe.setVisibility(0);
            this.mRe.i(listItem.mRightBottomIcons.get(1), 0, b.C0924b.nQi, b.C0924b.nQi);
        }
        tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
        if (PayHelper.STATUS_SUCC.equals(listItem.mType)) {
            cVar.append(listItem.mDesc);
        } else {
            cVar.append(listItem.mCreater).append(" ").a(this.i, tv.chushou.widget.a.c.So(listItem.mGender), a.d.double_icon_size, a.d.double_icon_size);
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
