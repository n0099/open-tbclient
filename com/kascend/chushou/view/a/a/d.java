package com.kascend.chushou.view.a.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.constants.PannelItem;
import com.kascend.chushou.player.ui.food.FoodView;
import com.kascend.chushou.widget.convenientbanner.ConvenientBanner;
import java.util.ArrayList;
import java.util.List;
import tv.chushou.zues.utils.h;
/* loaded from: classes6.dex */
public class d extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final List<ListItem> f4222a;
    private Context b;
    private boolean d;
    private String e;
    private ConvenientBanner<ListItem> owP;

    public d(View view, String str) {
        super(view);
        this.f4222a = new ArrayList();
        this.d = false;
        this.e = str;
        this.b = view.getContext();
        this.owP = (ConvenientBanner) view.findViewById(a.f.recycler_view);
        this.owP.a(new com.kascend.chushou.widget.convenientbanner.c.a<ListItem>() { // from class: com.kascend.chushou.view.a.a.d.1
            @Override // com.kascend.chushou.widget.convenientbanner.c.a
            public int getLayoutId() {
                return a.h.recycleitem_sliding_items;
            }

            @Override // com.kascend.chushou.widget.convenientbanner.c.a
            public com.kascend.chushou.widget.convenientbanner.c.b<ListItem> dQ(View view2) {
                return new a(view2, null);
            }
        }, this.f4222a);
        this.owP.r(new int[]{a.e.cs_point_normal, a.e.cs_point_selected});
    }

    public void a(PannelItem pannelItem) {
        this.f4222a.clear();
        this.f4222a.addAll(pannelItem.mNavItemList);
        this.d = false;
        if (!h.isEmpty(this.f4222a)) {
            this.d = !h.isEmpty(this.f4222a.get(0).mName);
        }
        this.owP.notifyDataSetChanged();
        if (this.d) {
            this.owP.h(8388693, 0, 0, tv.chushou.zues.utils.a.dip2px(this.b, 10.0f), tv.chushou.zues.utils.a.dip2px(this.b, 34.0f));
        } else {
            this.owP.h(8388693, 0, 0, tv.chushou.zues.utils.a.dip2px(this.b, 10.0f), tv.chushou.zues.utils.a.dip2px(this.b, 10.0f));
        }
    }

    /* loaded from: classes6.dex */
    private class a extends com.kascend.chushou.widget.convenientbanner.c.b<ListItem> {
        private TextView b;
        private TextView c;
        private TextView d;
        private FoodView osN;

        a(View view, com.kascend.chushou.widget.convenientbanner.d.b<ListItem> bVar) {
            super(view, bVar);
            this.osN = (FoodView) view.findViewById(a.f.iv_ad);
            this.b = (TextView) view.findViewById(a.f.tv_creator);
            this.c = (TextView) view.findViewById(a.f.tv_count);
            this.d = (TextView) view.findViewById(a.f.tv_name);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kascend.chushou.widget.convenientbanner.c.b
        /* renamed from: a */
        public void bD(ListItem listItem) {
            super.bD(listItem);
            this.osN.a(listItem, null, true, d.this.e, 405, 208, 0);
            if (h.isEmpty(listItem.mDesc)) {
                this.b.setVisibility(8);
            } else {
                this.b.setVisibility(0);
                this.b.setText(listItem.mDesc);
            }
            if (d.this.d) {
                this.d.setVisibility(0);
                this.d.setText(listItem.mName);
                return;
            }
            this.d.setVisibility(8);
        }
    }
}
