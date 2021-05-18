package d.a.k0.a3.j;

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
import d.a.j0.r.q.x1;
import d.a.k0.a3.j.f;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class e extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<Object> f52022e;

    /* renamed from: f  reason: collision with root package name */
    public Activity f52023f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.k0.a3.j.f f52024g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<x1> f52025h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<f.b> f52026i;
    public ArrayList<f.a> j;
    public d.a.k0.a3.k.a k;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(e.this.f52022e.getPageActivity(), "square_bottom_find_more", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            e.this.g();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.b f52028e;

        public b(f.b bVar) {
            this.f52028e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(e.this.f52023f, "square_category_more", PrefetchEvent.STATE_CLICK, 1, "loc", Integer.valueOf(this.f52028e.m));
            UrlManager.getInstance().dealOneLink(e.this.f52022e, new String[]{this.f52028e.l});
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.b f52030e;

        public c(f.b bVar) {
            this.f52030e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(e.this.f52023f, "square_module_menu", PrefetchEvent.STATE_CLICK, 1, "loc", Integer.valueOf(this.f52030e.n));
            UrlManager.getInstance().dealOneLink(e.this.f52022e, new String[]{this.f52030e.l});
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.b f52032e;

        public d(f.b bVar) {
            this.f52032e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(e.this.f52023f, "square_module_entry", PrefetchEvent.STATE_CLICK, 1, "moduleloc", Integer.valueOf(this.f52032e.m), "loc", Integer.valueOf(this.f52032e.n));
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.f52022e.getPageActivity()).createNormalCfg(this.f52032e.f52062e, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
        }
    }

    /* renamed from: d.a.k0.a3.j.e$e  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1209e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f52034e;

        public View$OnClickListenerC1209e(e eVar, h hVar) {
            this.f52034e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f52034e.m.performClick();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.b f52035e;

        public f(f.b bVar) {
            this.f52035e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(e.this.f52023f, "square_module_content", PrefetchEvent.STATE_CLICK, 1, "moduleloc", Integer.valueOf(this.f52035e.m), "loc", Integer.valueOf(this.f52035e.n));
            if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class)) {
                MessageManager messageManager = MessageManager.getInstance();
                Activity pageActivity = e.this.f52022e.getPageActivity();
                messageManager.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(pageActivity, this.f52035e.f52061d + "", ForumDetailActivityConfig.FromType.BAR_SQUARE)));
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.f52022e.getPageActivity()).createNormalCfg(this.f52035e.f52062e, FrsActivityConfig.FRS_FROM_SQUARE)));
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.a f52037e;

        public g(f.a aVar) {
            this.f52037e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f52037e.f52057d) {
                e.this.g();
            } else {
                UrlManager.getInstance().dealOneLink(e.this.f52022e, new String[]{this.f52037e.f52055b});
            }
            if (view.getTag() instanceof Integer) {
                int intValue = ((Integer) view.getTag()).intValue();
                Activity activity = e.this.f52023f;
                TiebaStatic.eventStat(activity, "square_entry_content", PrefetchEvent.STATE_CLICK, 1, "loc", "" + intValue);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f52039a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f52040b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f52041c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f52042d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f52043e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f52044f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f52045g;

        /* renamed from: h  reason: collision with root package name */
        public View f52046h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f52047i;
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
        this.f52022e = tbPageContext;
        this.f52023f = tbPageContext.getPageActivity();
        d.a.k0.a3.k.a aVar = new d.a.k0.a3.k.a(tbPageContext);
        this.k = aVar;
        CoverFlowView<d.a.k0.a3.j.g> d2 = aVar.d();
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
            return LayoutInflater.from(this.f52022e.getPageActivity()).inflate(R.layout.square_list_entry_view, (ViewGroup) null);
        }
        if (i3 == 2) {
            inflate = LayoutInflater.from(this.f52022e.getPageActivity()).inflate(R.layout.square_list_title_view, (ViewGroup) null);
            h hVar = new h(null);
            hVar.f52047i = (RelativeLayout) inflate.findViewById(R.id.title_layout);
            hVar.j = (TextView) inflate.findViewById(R.id.title_text);
            hVar.k = (TextView) inflate.findViewById(R.id.more_text);
            inflate.setTag(hVar);
        } else if (i3 != 3) {
            if (i3 == 4) {
                View inflate2 = LayoutInflater.from(this.f52022e.getPageActivity()).inflate(R.layout.square_list_more_view, (ViewGroup) null);
                inflate2.setOnClickListener(new a());
                return inflate2;
            }
            return null;
        } else {
            inflate = LayoutInflater.from(this.f52022e.getPageActivity()).inflate(R.layout.square_forum_item_view, (ViewGroup) null);
            h hVar2 = new h(null);
            hVar2.f52040b = (TextView) inflate.findViewById(R.id.forum_name);
            hVar2.f52039a = (BarImageView) inflate.findViewById(R.id.forum_image);
            hVar2.f52041c = (TextView) inflate.findViewById(R.id.forum_rank);
            hVar2.f52042d = (TextView) inflate.findViewById(R.id.forum_intro);
            hVar2.f52043e = (TextView) inflate.findViewById(R.id.like_num_tv);
            hVar2.f52044f = (TextView) inflate.findViewById(R.id.thread_num_tv);
            hVar2.f52045g = (TextView) inflate.findViewById(R.id.category_name_tv);
            hVar2.f52046h = inflate.findViewById(R.id.vertical_line_view);
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
                                tbImageView.V(aVar.f52056c, 10, false);
                            }
                            View childAt2 = linearLayout.getChildAt(1);
                            if (childAt2 instanceof TextView) {
                                ((TextView) childAt2).setText(UtilHelper.getFixedText(aVar.f52054a, 5, false));
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
                    hVar.f52047i.setPadding(this.f52022e.getResources().getDimensionPixelSize(R.dimen.ds30), this.f52022e.getResources().getDimensionPixelSize(R.dimen.ds26), this.f52022e.getResources().getDimensionPixelSize(R.dimen.ds20), this.f52022e.getResources().getDimensionPixelSize(R.dimen.ds10));
                } else {
                    hVar.f52047i.setPadding(this.f52022e.getResources().getDimensionPixelSize(R.dimen.ds30), this.f52022e.getResources().getDimensionPixelSize(R.dimen.ds6), this.f52022e.getResources().getDimensionPixelSize(R.dimen.ds20), this.f52022e.getResources().getDimensionPixelSize(R.dimen.ds10));
                }
                hVar.j.setText(bVar.f52059b);
                if (bVar.f52060c) {
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
                hVar2.f52039a.V(bVar2.f52063f, 10, false);
                hVar2.f52040b.setText(bVar2.f52062e);
                hVar2.f52041c.setText(bVar2.f52065h);
                hVar2.f52042d.setText(bVar2.f52066i);
                long j = bVar2.j;
                if (j < 0) {
                    j = 0;
                }
                long j2 = bVar2.k;
                long j3 = j2 >= 0 ? j2 : 0L;
                hVar2.f52043e.setText(this.f52022e.getString(R.string.attention) + StringHelper.numFormatOver10000wan(j));
                hVar2.f52044f.setText(this.f52022e.getString(R.string.text_post) + StringHelper.numFormatOver10000wan(j3));
                if (bVar2.f52060c && !StringUtils.isNull(bVar2.f52064g)) {
                    hVar2.f52045g.setText(UtilHelper.getFixedText(bVar2.f52064g, 5));
                    hVar2.f52045g.setVisibility(0);
                    hVar2.f52046h.setVisibility(0);
                } else {
                    hVar2.f52045g.setVisibility(8);
                    hVar2.f52046h.setVisibility(8);
                }
                hVar2.f52045g.setOnClickListener(new c(bVar2));
                hVar2.m.setOnClickListener(new d(bVar2));
                hVar2.l.setOnClickListener(new View$OnClickListenerC1209e(this, hVar2));
                view.setOnClickListener(new f(bVar2));
            }
        }
    }

    public final void g() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2902026, new BarFolderFirstDirActivityConfig(this.f52022e.getPageActivity(), SingleSquareActivityConfig.makeStatisticsParam("forum_browse", "all"))));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<f.b> arrayList = this.f52026i;
        int i2 = 0;
        if (arrayList != null && arrayList.size() != 0) {
            i2 = 0 + this.f52026i.size();
        }
        ArrayList<x1> arrayList2 = this.f52025h;
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
                return this.f52025h;
            }
            int i3 = 1;
            if (itemViewType == 1) {
                return this.j;
            }
            if (itemViewType != 2 && itemViewType != 3) {
                return null;
            }
            ArrayList<x1> arrayList = this.f52025h;
            i3 = (arrayList == null || arrayList.size() == 0) ? 0 : 0;
            ArrayList<f.a> arrayList2 = this.j;
            if (arrayList2 != null && arrayList2.size() != 0) {
                i3++;
            }
            int i4 = i2 - i3;
            if (i4 >= 0 && i4 < this.f52026i.size()) {
                return this.f52026i.get(i4);
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
            ArrayList<x1> arrayList3 = this.f52025h;
            if (arrayList3 != null && arrayList3.size() != 0) {
                return 0;
            }
            ArrayList<f.a> arrayList4 = this.j;
            if (arrayList4 != null && arrayList4.size() != 0) {
                return 1;
            }
        }
        if (i2 != 1 || (arrayList = this.f52025h) == null || arrayList.size() == 0 || (arrayList2 = this.j) == null || arrayList2.size() == 0) {
            if (i2 == getCount() - 1) {
                return 4;
            }
            ArrayList<x1> arrayList5 = this.f52025h;
            if (arrayList5 != null && arrayList5.size() != 0) {
                i3 = 1;
            }
            ArrayList<f.a> arrayList6 = this.j;
            if (arrayList6 != null && arrayList6.size() != 0) {
                i3++;
            }
            int i4 = i2 - i3;
            if (i4 < 0 || i4 >= this.f52026i.size() || (bVar = this.f52026i.get(i4)) == null) {
                return -1;
            }
            return bVar.f52058a ? 2 : 3;
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
        this.f52022e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.f52022e.getLayoutMode().j(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 5;
    }

    public void h(int i2) {
        d.a.k0.a3.k.a aVar = this.k;
        if (aVar != null) {
            aVar.e(i2);
        }
        notifyDataSetChanged();
    }

    public void i(d.a.k0.a3.j.f fVar) {
        if (fVar == null) {
            return;
        }
        this.f52024g = fVar;
        this.f52025h = fVar.e();
        this.f52026i = this.f52024g.b();
        this.j = this.f52024g.a();
        this.k.f(this.f52025h);
    }
}
