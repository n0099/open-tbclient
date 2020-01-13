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
/* loaded from: classes4.dex */
public class d extends RecyclerView.ViewHolder {
    private final List<ListItem> a;
    private Context b;
    private boolean d;
    private String e;
    private ConvenientBanner<ListItem> neo;

    public d(View view, String str) {
        super(view);
        this.a = new ArrayList();
        this.d = false;
        this.e = str;
        this.b = view.getContext();
        this.neo = (ConvenientBanner) view.findViewById(a.f.recycler_view);
        this.neo.a(new com.kascend.chushou.widget.convenientbanner.c.a<ListItem>() { // from class: com.kascend.chushou.view.a.a.d.1
            @Override // com.kascend.chushou.widget.convenientbanner.c.a
            public int getLayoutId() {
                return a.h.recycleitem_sliding_items;
            }

            @Override // com.kascend.chushou.widget.convenientbanner.c.a
            public com.kascend.chushou.widget.convenientbanner.c.b<ListItem> dA(View view2) {
                return new a(view2, null);
            }
        }, this.a);
        this.neo.q(new int[]{a.e.cs_point_normal, a.e.cs_point_selected});
    }

    public void a(PannelItem pannelItem) {
        this.a.clear();
        this.a.addAll(pannelItem.mNavItemList);
        this.d = false;
        if (!h.isEmpty(this.a)) {
            this.d = !h.isEmpty(this.a.get(0).mName);
        }
        this.neo.notifyDataSetChanged();
        if (this.d) {
            this.neo.j(8388693, 0, 0, tv.chushou.zues.utils.a.dip2px(this.b, 10.0f), tv.chushou.zues.utils.a.dip2px(this.b, 34.0f));
        } else {
            this.neo.j(8388693, 0, 0, tv.chushou.zues.utils.a.dip2px(this.b, 10.0f), tv.chushou.zues.utils.a.dip2px(this.b, 10.0f));
        }
    }

    /* loaded from: classes4.dex */
    private class a extends com.kascend.chushou.widget.convenientbanner.c.b<ListItem> {
        private TextView b;
        private TextView c;
        private TextView d;
        private FoodView nao;

        a(View view, com.kascend.chushou.widget.convenientbanner.d.b<ListItem> bVar) {
            super(view, bVar);
            this.nao = (FoodView) view.findViewById(a.f.iv_ad);
            this.b = (TextView) view.findViewById(a.f.tv_creator);
            this.c = (TextView) view.findViewById(a.f.tv_count);
            this.d = (TextView) view.findViewById(a.f.tv_name);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kascend.chushou.widget.convenientbanner.c.b
        /* renamed from: a */
        public void bF(ListItem listItem) {
            super.bF(listItem);
            this.nao.a(listItem, null, true, d.this.e, 405, 208, 0);
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
