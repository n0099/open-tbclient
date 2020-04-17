package com.kascend.chushou.view.a.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.constants.PannelItem;
import com.kascend.chushou.player.ui.food.FoodView;
import com.kascend.chushou.widget.convenientbanner.ConvenientBanner;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class e extends RecyclerView.ViewHolder {
    private final List<ListItem> a;
    private Context b;
    private View d;
    private String e;
    private String f;
    private ConvenientBanner<ListItem> mDE;

    public e(View view, String str, String str2) {
        super(view);
        this.a = new ArrayList();
        this.b = view.getContext();
        this.d = view;
        this.e = str;
        this.f = str2;
        this.mDE = (ConvenientBanner) view.findViewById(a.f.recycler_view);
        this.mDE.a(new com.kascend.chushou.widget.convenientbanner.c.a<ListItem>() { // from class: com.kascend.chushou.view.a.a.e.1
            @Override // com.kascend.chushou.widget.convenientbanner.c.a
            public int getLayoutId() {
                return a.h.recycleitem_sliding_small_poster;
            }

            @Override // com.kascend.chushou.widget.convenientbanner.c.a
            public com.kascend.chushou.widget.convenientbanner.c.b<ListItem> dt(View view2) {
                return new a(view2, null);
            }
        }, this.a);
        this.mDE.r(new int[]{a.e.cs_point_normal, a.e.cs_point_selected});
        this.mDE.h(8388693, 0, 0, tv.chushou.zues.utils.a.dip2px(this.b, 10.0f), tv.chushou.zues.utils.a.dip2px(this.b, 14.0f));
    }

    public void a(PannelItem pannelItem, int[] iArr) {
        this.a.clear();
        this.a.addAll(pannelItem.mNavItemList);
        this.mDE.notifyDataSetChanged();
        this.d.setPadding(0, tv.chushou.zues.utils.a.dip2px(this.b, iArr[0]), 0, tv.chushou.zues.utils.a.dip2px(this.b, 10.0f));
    }

    /* loaded from: classes5.dex */
    private class a extends com.kascend.chushou.widget.convenientbanner.c.b<ListItem> {
        private FoodView mzs;

        a(View view, com.kascend.chushou.widget.convenientbanner.d.b<ListItem> bVar) {
            super(view, bVar);
            this.mzs = (FoodView) view.findViewById(a.f.iv_ad);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kascend.chushou.widget.convenientbanner.c.b
        /* renamed from: a */
        public void bq(ListItem listItem) {
            super.bq(listItem);
            if ("32".equals(e.this.f)) {
                this.mzs.b(listItem, (FoodView.a) null, true, e.this.e);
            } else {
                this.mzs.a(listItem, (FoodView.a) null, true, e.this.e);
            }
        }
    }
}
