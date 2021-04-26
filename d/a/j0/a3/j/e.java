package d.a.j0.a3.j;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarFolderFirstDirActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.SquareActivity;
import d.a.i0.r.q.x1;
import d.a.j0.a3.j.f;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class e extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<Object> f51323e;

    /* renamed from: f  reason: collision with root package name */
    public Activity f51324f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.a3.j.f f51325g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<x1> f51326h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<f.b> f51327i;
    public ArrayList<f.a> j;
    public d.a.j0.a3.k.a k;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(e.this.f51323e.getPageActivity(), "square_bottom_find_more", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            e.this.g();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.b f51329e;

        public b(f.b bVar) {
            this.f51329e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(e.this.f51324f, "square_category_more", PrefetchEvent.STATE_CLICK, 1, "loc", Integer.valueOf(this.f51329e.m));
            UrlManager.getInstance().dealOneLink(e.this.f51323e, new String[]{this.f51329e.l});
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.b f51331e;

        public c(f.b bVar) {
            this.f51331e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(e.this.f51324f, "square_module_menu", PrefetchEvent.STATE_CLICK, 1, "loc", Integer.valueOf(this.f51331e.n));
            UrlManager.getInstance().dealOneLink(e.this.f51323e, new String[]{this.f51331e.l});
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.b f51333e;

        public d(f.b bVar) {
            this.f51333e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(e.this.f51324f, "square_module_entry", PrefetchEvent.STATE_CLICK, 1, "moduleloc", Integer.valueOf(this.f51333e.m), "loc", Integer.valueOf(this.f51333e.n));
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.f51323e.getPageActivity()).createNormalCfg(this.f51333e.f51363e, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
        }
    }

    /* renamed from: d.a.j0.a3.j.e$e  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1137e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f51335e;

        public View$OnClickListenerC1137e(e eVar, h hVar) {
            this.f51335e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f51335e.m.performClick();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.b f51336e;

        public f(f.b bVar) {
            this.f51336e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(e.this.f51324f, "square_module_content", PrefetchEvent.STATE_CLICK, 1, "moduleloc", Integer.valueOf(this.f51336e.m), "loc", Integer.valueOf(this.f51336e.n));
            if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class)) {
                MessageManager messageManager = MessageManager.getInstance();
                Activity pageActivity = e.this.f51323e.getPageActivity();
                messageManager.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(pageActivity, this.f51336e.f51362d + "", ForumDetailActivityConfig.FromType.BAR_SQUARE)));
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.f51323e.getPageActivity()).createNormalCfg(this.f51336e.f51363e, FrsActivityConfig.FRS_FROM_SQUARE)));
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.a f51338e;

        public g(f.a aVar) {
            this.f51338e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f51338e.f51358d) {
                e.this.g();
            } else {
                UrlManager.getInstance().dealOneLink(e.this.f51323e, new String[]{this.f51338e.f51356b});
            }
            if (view.getTag() instanceof Integer) {
                int intValue = ((Integer) view.getTag()).intValue();
                Activity activity = e.this.f51324f;
                TiebaStatic.eventStat(activity, "square_entry_content", PrefetchEvent.STATE_CLICK, 1, "loc", "" + intValue);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f51340a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f51341b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f51342c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f51343d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f51344e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f51345f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f51346g;

        /* renamed from: h  reason: collision with root package name */
        public View f51347h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f51348i;
        public TextView j;
        public TextView k;
        public LinearLayout l;
        public TextView m;

        public h() {
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    public e(TbPageContext<Object> tbPageContext) {
        this.k = null;
        if (tbPageContext == null || tbPageContext.getOrignalPage() == null) {
            return;
        }
        this.f51323e = tbPageContext;
        this.f51324f = tbPageContext.getPageActivity();
        d.a.j0.a3.k.a aVar = new d.a.j0.a3.k.a(tbPageContext);
        this.k = aVar;
        CoverFlowView<d.a.j0.a3.j.g> d2 = aVar.d();
        if (tbPageContext.getOrignalPage() instanceof SquareActivity) {
            d2.setSwipeControlInterface((SquareActivity) tbPageContext.getOrignalPage());
        }
        d2.setDisableParentEvent(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v13 */
    public final View d(int i2, ViewGroup viewGroup, int i3) {
        View inflate;
        if (i3 == 1) {
            return LayoutInflater.from(this.f51323e.getPageActivity()).inflate(R.layout.square_list_entry_view, (ViewGroup) null);
        }
        if (i3 == 2) {
            inflate = LayoutInflater.from(this.f51323e.getPageActivity()).inflate(R.layout.square_list_title_view, (ViewGroup) null);
            h hVar = new h(null);
            hVar.f51348i = (RelativeLayout) inflate.findViewById(R.id.title_layout);
            hVar.j = (TextView) inflate.findViewById(R.id.title_text);
            hVar.k = (TextView) inflate.findViewById(R.id.more_text);
            inflate.setTag(hVar);
        } else if (i3 != 3) {
            if (i3 == 4) {
                View inflate2 = LayoutInflater.from(this.f51323e.getPageActivity()).inflate(R.layout.square_list_more_view, (ViewGroup) null);
                inflate2.setOnClickListener(new a());
                return inflate2;
            }
            return null;
        } else {
            inflate = LayoutInflater.from(this.f51323e.getPageActivity()).inflate(R.layout.square_forum_item_view, (ViewGroup) null);
            h hVar2 = new h(null);
            hVar2.f51341b = (TextView) inflate.findViewById(R.id.forum_name);
            hVar2.f51340a = (BarImageView) inflate.findViewById(R.id.forum_image);
            hVar2.f51342c = (TextView) inflate.findViewById(R.id.forum_rank);
            hVar2.f51343d = (TextView) inflate.findViewById(R.id.forum_intro);
            hVar2.f51344e = (TextView) inflate.findViewById(R.id.like_num_tv);
            hVar2.f51345f = (TextView) inflate.findViewById(R.id.thread_num_tv);
            hVar2.f51346g = (TextView) inflate.findViewById(R.id.category_name_tv);
            hVar2.f51347h = inflate.findViewById(R.id.vertical_line_view);
            hVar2.m = (TextView) inflate.findViewById(R.id.enter_forum);
            hVar2.l = (LinearLayout) inflate.findViewById(R.id.enter_forum_ll);
            inflate.setTag(hVar2);
        }
        return inflate;
    }

    public final void e(View view) {
        if (view == null) {
            return;
        }
        ArrayList<f.a> arrayList = this.j;
        if (arrayList != null && arrayList.size() != 0) {
            view.setVisibility(0);
            int size = this.j.size();
            if (size > 4) {
                size = 4;
            }
            View[] viewArr = {view.findViewById(R.id.empty_view_01), view.findViewById(R.id.empty_view_02), view.findViewById(R.id.empty_view_03), view.findViewById(R.id.empty_view_04), view.findViewById(R.id.empty_view_05)};
            View[] viewArr2 = {view.findViewById(R.id.entry_ll_01), view.findViewById(R.id.entry_ll_02), view.findViewById(R.id.entry_ll_03), view.findViewById(R.id.entry_ll_04)};
            for (int i2 = 0; i2 < 4; i2++) {
                if (i2 < size) {
                    f.a aVar = this.j.get(i2);
                    if (aVar == null) {
                        viewArr2[i2].setVisibility(8);
                    } else {
                        if (viewArr2[i2] instanceof LinearLayout) {
                            LinearLayout linearLayout = (LinearLayout) viewArr2[i2];
                            linearLayout.setTag(Integer.valueOf(i2));
                            View childAt = linearLayout.getChildAt(0);
                            if (childAt instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt;
                                tbImageView.setTag(Integer.valueOf(i2));
                                tbImageView.setDrawerType(1);
                                tbImageView.setIsRound(true);
                                tbImageView.V(aVar.f51357c, 10, false);
                            }
                            View childAt2 = linearLayout.getChildAt(1);
                            if (childAt2 instanceof TextView) {
                                ((TextView) childAt2).setText(UtilHelper.getFixedText(aVar.f51355a, 5, false));
                            }
                            linearLayout.setOnClickListener(new g(aVar));
                        }
                        viewArr2[i2].setVisibility(0);
                        viewArr[i2].setVisibility(0);
                    }
                } else {
                    viewArr2[i2].setVisibility(8);
                    viewArr[i2].setVisibility(8);
                }
            }
            return;
        }
        view.setVisibility(8);
    }

    public final void f(View view, int i2) {
        if (view == null) {
            return;
        }
        int itemViewType = getItemViewType(i2);
        if (itemViewType == 1) {
            e(view);
        } else if (itemViewType == 2) {
            Object item = getItem(i2);
            if (item instanceof f.b) {
                f.b bVar = (f.b) item;
                h hVar = (h) view.getTag();
                if (bVar.m == 0) {
                    hVar.f51348i.setPadding(this.f51323e.getResources().getDimensionPixelSize(R.dimen.ds30), this.f51323e.getResources().getDimensionPixelSize(R.dimen.ds26), this.f51323e.getResources().getDimensionPixelSize(R.dimen.ds20), this.f51323e.getResources().getDimensionPixelSize(R.dimen.ds10));
                } else {
                    hVar.f51348i.setPadding(this.f51323e.getResources().getDimensionPixelSize(R.dimen.ds30), this.f51323e.getResources().getDimensionPixelSize(R.dimen.ds6), this.f51323e.getResources().getDimensionPixelSize(R.dimen.ds20), this.f51323e.getResources().getDimensionPixelSize(R.dimen.ds10));
                }
                hVar.j.setText(bVar.f51360b);
                if (bVar.f51361c) {
                    hVar.k.setVisibility(8);
                    return;
                }
                hVar.k.setVisibility(0);
                hVar.k.setOnClickListener(new b(bVar));
            }
        } else if (itemViewType == 3) {
            Object item2 = getItem(i2);
            if (item2 instanceof f.b) {
                f.b bVar2 = (f.b) item2;
                h hVar2 = (h) view.getTag();
                if (hVar2 == null) {
                    return;
                }
                hVar2.f51340a.V(bVar2.f51364f, 10, false);
                hVar2.f51341b.setText(bVar2.f51363e);
                hVar2.f51342c.setText(bVar2.f51366h);
                hVar2.f51343d.setText(bVar2.f51367i);
                long j = bVar2.j;
                if (j < 0) {
                    j = 0;
                }
                long j2 = bVar2.k;
                long j3 = j2 >= 0 ? j2 : 0L;
                hVar2.f51344e.setText(this.f51323e.getString(R.string.attention) + StringHelper.numFormatOver10000wan(j));
                hVar2.f51345f.setText(this.f51323e.getString(R.string.text_post) + StringHelper.numFormatOver10000wan(j3));
                if (bVar2.f51361c && !StringUtils.isNull(bVar2.f51365g)) {
                    hVar2.f51346g.setText(UtilHelper.getFixedText(bVar2.f51365g, 5));
                    hVar2.f51346g.setVisibility(0);
                    hVar2.f51347h.setVisibility(0);
                } else {
                    hVar2.f51346g.setVisibility(8);
                    hVar2.f51347h.setVisibility(8);
                }
                hVar2.f51346g.setOnClickListener(new c(bVar2));
                hVar2.m.setOnClickListener(new d(bVar2));
                hVar2.l.setOnClickListener(new View$OnClickListenerC1137e(this, hVar2));
                view.setOnClickListener(new f(bVar2));
            }
        }
    }

    public final void g() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2902026, new BarFolderFirstDirActivityConfig(this.f51323e.getPageActivity(), SingleSquareActivityConfig.makeStatisticsParam("forum_browse", "all"))));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<f.b> arrayList = this.f51327i;
        int i2 = 0;
        if (arrayList != null && arrayList.size() != 0) {
            i2 = 0 + this.f51327i.size();
        }
        ArrayList<x1> arrayList2 = this.f51326h;
        if (arrayList2 != null && arrayList2.size() != 0) {
            i2++;
        }
        if (i2 != 0) {
            i2++;
        }
        ArrayList<f.a> arrayList3 = this.j;
        return (arrayList3 == null || arrayList3.size() <= 0) ? i2 : i2 + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        int itemViewType = getItemViewType(i2);
        if (itemViewType != -1 && itemViewType != 4) {
            if (itemViewType == 0) {
                return this.f51326h;
            }
            int i3 = 1;
            if (itemViewType == 1) {
                return this.j;
            }
            if (itemViewType != 2 && itemViewType != 3) {
                return null;
            }
            ArrayList<x1> arrayList = this.f51326h;
            i3 = (arrayList == null || arrayList.size() == 0) ? 0 : 0;
            ArrayList<f.a> arrayList2 = this.j;
            if (arrayList2 != null && arrayList2.size() != 0) {
                i3++;
            }
            int i4 = i2 - i3;
            if (i4 >= 0 && i4 < this.f51327i.size()) {
                return this.f51327i.get(i4);
            }
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        f.b bVar;
        ArrayList<x1> arrayList;
        ArrayList<f.a> arrayList2;
        int i3 = 0;
        if (i2 == 0) {
            ArrayList<x1> arrayList3 = this.f51326h;
            if (arrayList3 != null && arrayList3.size() != 0) {
                return 0;
            }
            ArrayList<f.a> arrayList4 = this.j;
            if (arrayList4 != null && arrayList4.size() != 0) {
                return 1;
            }
        }
        if (i2 != 1 || (arrayList = this.f51326h) == null || arrayList.size() == 0 || (arrayList2 = this.j) == null || arrayList2.size() == 0) {
            if (i2 == getCount() - 1) {
                return 4;
            }
            ArrayList<x1> arrayList5 = this.f51326h;
            if (arrayList5 != null && arrayList5.size() != 0) {
                i3 = 1;
            }
            ArrayList<f.a> arrayList6 = this.j;
            if (arrayList6 != null && arrayList6.size() != 0) {
                i3++;
            }
            int i4 = i2 - i3;
            if (i4 < 0 || i4 >= this.f51327i.size() || (bVar = this.f51327i.get(i4)) == null) {
                return -1;
            }
            return bVar.f51359a ? 2 : 3;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i2);
        if (itemViewType == 0) {
            return this.k.getView(i2, view, viewGroup);
        }
        if (view == null) {
            view = d(i2, viewGroup, itemViewType);
        }
        f(view, i2);
        this.f51323e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.f51323e.getLayoutMode().j(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 5;
    }

    public void h(int i2) {
        d.a.j0.a3.k.a aVar = this.k;
        if (aVar != null) {
            aVar.e(i2);
        }
        notifyDataSetChanged();
    }

    public void i(d.a.j0.a3.j.f fVar) {
        if (fVar == null) {
            return;
        }
        this.f51325g = fVar;
        this.f51326h = fVar.e();
        this.f51327i = this.f51325g.b();
        this.j = this.f51325g.a();
        this.k.f(this.f51326h);
    }
}
