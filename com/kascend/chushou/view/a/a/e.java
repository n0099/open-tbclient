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
/* loaded from: classes6.dex */
public class e extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final List<ListItem> f4223a;
    private Context b;
    private View d;
    private String e;
    private String f;
    private ConvenientBanner<ListItem> pzi;

    public e(View view, String str, String str2) {
        super(view);
        this.f4223a = new ArrayList();
        this.b = view.getContext();
        this.d = view;
        this.e = str;
        this.f = str2;
        this.pzi = (ConvenientBanner) view.findViewById(a.f.recycler_view);
        this.pzi.a(new com.kascend.chushou.widget.convenientbanner.c.a<ListItem>() { // from class: com.kascend.chushou.view.a.a.e.1
            @Override // com.kascend.chushou.widget.convenientbanner.c.a
            public int getLayoutId() {
                return a.h.recycleitem_sliding_small_poster;
            }

            @Override // com.kascend.chushou.widget.convenientbanner.c.a
            public com.kascend.chushou.widget.convenientbanner.c.b<ListItem> en(View view2) {
                return new a(view2, null);
            }
        }, this.f4223a);
        this.pzi.w(new int[]{a.e.cs_point_normal, a.e.cs_point_selected});
        this.pzi.h(8388693, 0, 0, tv.chushou.zues.utils.a.dip2px(this.b, 10.0f), tv.chushou.zues.utils.a.dip2px(this.b, 14.0f));
    }

    public void a(PannelItem pannelItem, int[] iArr) {
        this.f4223a.clear();
        this.f4223a.addAll(pannelItem.mNavItemList);
        this.pzi.notifyDataSetChanged();
        this.d.setPadding(0, tv.chushou.zues.utils.a.dip2px(this.b, iArr[0]), 0, tv.chushou.zues.utils.a.dip2px(this.b, 10.0f));
    }

    /* loaded from: classes6.dex */
    private class a extends com.kascend.chushou.widget.convenientbanner.c.b<ListItem> {
        private FoodView pvd;

        a(View view, com.kascend.chushou.widget.convenientbanner.d.b<ListItem> bVar) {
            super(view, bVar);
            this.pvd = (FoodView) view.findViewById(a.f.iv_ad);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kascend.chushou.widget.convenientbanner.c.b
        /* renamed from: a */
        public void bI(ListItem listItem) {
            super.bI(listItem);
            if ("32".equals(e.this.f)) {
                this.pvd.b(listItem, (FoodView.a) null, true, e.this.e);
            } else {
                this.pvd.a(listItem, (FoodView.a) null, true, e.this.e);
            }
        }
    }
}
