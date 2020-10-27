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
/* loaded from: classes6.dex */
public class a extends RecyclerView.ViewHolder implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private View f4218a;
    private TextView c;
    private TextView d;
    private TextView h;
    private Context i;
    private boolean l;
    private String m;
    private int n;
    private int o;
    private int p;
    private FrescoThumbnailView pgD;
    private FoodView pkb;
    private FrescoThumbnailView pkq;
    private FrescoThumbnailView pkv;
    private ListItem poa;
    private com.kascend.chushou.view.a.a<ListItem> pob;
    private int q;

    public a(View view, com.kascend.chushou.view.a.a<ListItem> aVar, boolean z, String str) {
        super(view);
        this.n = AdCard.INVALID_NUM;
        this.o = AdCard.INVALID_NUM;
        this.p = AdCard.INVALID_NUM;
        this.q = AdCard.INVALID_NUM;
        this.m = str;
        this.i = view.getContext();
        this.f4218a = view;
        this.pob = aVar;
        this.pkb = (FoodView) view.findViewById(a.f.iv_cover);
        this.pkv = (FrescoThumbnailView) view.findViewById(a.f.iv_right_bottom_icon1);
        this.pgD = (FrescoThumbnailView) view.findViewById(a.f.iv_right_bottom_icon2);
        this.pkq = (FrescoThumbnailView) view.findViewById(a.f.iv_pkLiveIcon);
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
        if (this.poa != null && PayHelper.STATUS_SUCC.equals(this.poa.mType)) {
            JSONObject O = com.kascend.chushou.d.e.O("_fromView", this.m);
            try {
                O.put("__DOWN_X__", String.valueOf(this.n));
                O.put("__DOWN_Y__", String.valueOf(this.o));
                O.put("__UP_X__", String.valueOf(this.p));
                O.put("__UP_Y__", String.valueOf(this.q));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            com.kascend.chushou.d.e.a(this.i, this.poa, O);
        } else if (this.pob != null && this.poa != null) {
            this.pob.b(view, this.poa);
        }
    }

    public void a(ListItem listItem) {
        a(listItem, null, false);
    }

    public void a(ListItem listItem, int[] iArr, boolean z) {
        this.poa = listItem;
        this.pkb.a(listItem, (FoodView.a) null, false, (String) null, false);
        int size = listItem.mRightBottomIcons == null ? 0 : listItem.mRightBottomIcons.size();
        if (size == 0) {
            this.pkv.setVisibility(8);
            this.pgD.setVisibility(8);
        } else if (size == 1) {
            this.pkv.setVisibility(8);
            this.pgD.setVisibility(0);
            this.pgD.j(listItem.mRightBottomIcons.get(0), 0, b.C1104b.qfa, b.C1104b.qfa);
        } else {
            listItem.mRightBottomIcons.subList(0, 2);
            this.pkv.setVisibility(0);
            this.pkv.j(listItem.mRightBottomIcons.get(0), 0, b.C1104b.qfa, b.C1104b.qfa);
            this.pgD.setVisibility(0);
            this.pgD.j(listItem.mRightBottomIcons.get(1), 0, b.C1104b.qfa, b.C1104b.qfa);
        }
        tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
        if (PayHelper.STATUS_SUCC.equals(listItem.mType)) {
            cVar.append(listItem.mDesc);
        } else {
            cVar.append(listItem.mCreater).append(" ").a(this.i, tv.chushou.widget.a.c.ZT(listItem.mGender), a.d.double_icon_size, a.d.double_icon_size);
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
        if (iArr != null && z && this.f4218a != null) {
            Context context = this.f4218a.getContext();
            GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) this.f4218a.getLayoutParams();
            layoutParams.bottomMargin = tv.chushou.zues.utils.a.dip2px(context, iArr[1]);
            this.f4218a.setLayoutParams(layoutParams);
        }
    }
}
