package d.a.o0.b3.j;

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
import d.a.n0.r.q.x1;
import d.a.o0.b3.j.f;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class e extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<Object> f56003e;

    /* renamed from: f  reason: collision with root package name */
    public Activity f56004f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.b3.j.f f56005g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<x1> f56006h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<f.b> f56007i;
    public ArrayList<f.a> j;
    public d.a.o0.b3.k.a k;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(e.this.f56003e.getPageActivity(), "square_bottom_find_more", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            e.this.g();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.b f56009e;

        public b(f.b bVar) {
            this.f56009e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(e.this.f56004f, "square_category_more", PrefetchEvent.STATE_CLICK, 1, "loc", Integer.valueOf(this.f56009e.m));
            UrlManager.getInstance().dealOneLink(e.this.f56003e, new String[]{this.f56009e.l});
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.b f56011e;

        public c(f.b bVar) {
            this.f56011e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(e.this.f56004f, "square_module_menu", PrefetchEvent.STATE_CLICK, 1, "loc", Integer.valueOf(this.f56011e.n));
            UrlManager.getInstance().dealOneLink(e.this.f56003e, new String[]{this.f56011e.l});
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.b f56013e;

        public d(f.b bVar) {
            this.f56013e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(e.this.f56004f, "square_module_entry", PrefetchEvent.STATE_CLICK, 1, "moduleloc", Integer.valueOf(this.f56013e.m), "loc", Integer.valueOf(this.f56013e.n));
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.f56003e.getPageActivity()).createNormalCfg(this.f56013e.f56043e, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
        }
    }

    /* renamed from: d.a.o0.b3.j.e$e  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1286e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f56015e;

        public View$OnClickListenerC1286e(e eVar, h hVar) {
            this.f56015e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f56015e.m.performClick();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.b f56016e;

        public f(f.b bVar) {
            this.f56016e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(e.this.f56004f, "square_module_content", PrefetchEvent.STATE_CLICK, 1, "moduleloc", Integer.valueOf(this.f56016e.m), "loc", Integer.valueOf(this.f56016e.n));
            if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class)) {
                MessageManager messageManager = MessageManager.getInstance();
                Activity pageActivity = e.this.f56003e.getPageActivity();
                messageManager.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(pageActivity, this.f56016e.f56042d + "", ForumDetailActivityConfig.FromType.BAR_SQUARE)));
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.f56003e.getPageActivity()).createNormalCfg(this.f56016e.f56043e, FrsActivityConfig.FRS_FROM_SQUARE)));
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.a f56018e;

        public g(f.a aVar) {
            this.f56018e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f56018e.f56038d) {
                e.this.g();
            } else {
                UrlManager.getInstance().dealOneLink(e.this.f56003e, new String[]{this.f56018e.f56036b});
            }
            if (view.getTag() instanceof Integer) {
                int intValue = ((Integer) view.getTag()).intValue();
                Activity activity = e.this.f56004f;
                TiebaStatic.eventStat(activity, "square_entry_content", PrefetchEvent.STATE_CLICK, 1, "loc", "" + intValue);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f56020a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f56021b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f56022c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f56023d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f56024e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f56025f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f56026g;

        /* renamed from: h  reason: collision with root package name */
        public View f56027h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f56028i;
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
        this.f56003e = tbPageContext;
        this.f56004f = tbPageContext.getPageActivity();
        d.a.o0.b3.k.a aVar = new d.a.o0.b3.k.a(tbPageContext);
        this.k = aVar;
        CoverFlowView<d.a.o0.b3.j.g> d2 = aVar.d();
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
            return LayoutInflater.from(this.f56003e.getPageActivity()).inflate(R.layout.square_list_entry_view, (ViewGroup) null);
        }
        if (i3 == 2) {
            inflate = LayoutInflater.from(this.f56003e.getPageActivity()).inflate(R.layout.square_list_title_view, (ViewGroup) null);
            h hVar = new h(null);
            hVar.f56028i = (RelativeLayout) inflate.findViewById(R.id.title_layout);
            hVar.j = (TextView) inflate.findViewById(R.id.title_text);
            hVar.k = (TextView) inflate.findViewById(R.id.more_text);
            inflate.setTag(hVar);
        } else if (i3 != 3) {
            if (i3 == 4) {
                View inflate2 = LayoutInflater.from(this.f56003e.getPageActivity()).inflate(R.layout.square_list_more_view, (ViewGroup) null);
                inflate2.setOnClickListener(new a());
                return inflate2;
            }
            return null;
        } else {
            inflate = LayoutInflater.from(this.f56003e.getPageActivity()).inflate(R.layout.square_forum_item_view, (ViewGroup) null);
            h hVar2 = new h(null);
            hVar2.f56021b = (TextView) inflate.findViewById(R.id.forum_name);
            hVar2.f56020a = (BarImageView) inflate.findViewById(R.id.forum_image);
            hVar2.f56022c = (TextView) inflate.findViewById(R.id.forum_rank);
            hVar2.f56023d = (TextView) inflate.findViewById(R.id.forum_intro);
            hVar2.f56024e = (TextView) inflate.findViewById(R.id.like_num_tv);
            hVar2.f56025f = (TextView) inflate.findViewById(R.id.thread_num_tv);
            hVar2.f56026g = (TextView) inflate.findViewById(R.id.category_name_tv);
            hVar2.f56027h = inflate.findViewById(R.id.vertical_line_view);
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
                                tbImageView.U(aVar.f56037c, 10, false);
                            }
                            View childAt2 = linearLayout.getChildAt(1);
                            if (childAt2 instanceof TextView) {
                                ((TextView) childAt2).setText(UtilHelper.getFixedText(aVar.f56035a, 5, false));
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
                    hVar.f56028i.setPadding(this.f56003e.getResources().getDimensionPixelSize(R.dimen.ds30), this.f56003e.getResources().getDimensionPixelSize(R.dimen.ds26), this.f56003e.getResources().getDimensionPixelSize(R.dimen.ds20), this.f56003e.getResources().getDimensionPixelSize(R.dimen.ds10));
                } else {
                    hVar.f56028i.setPadding(this.f56003e.getResources().getDimensionPixelSize(R.dimen.ds30), this.f56003e.getResources().getDimensionPixelSize(R.dimen.ds6), this.f56003e.getResources().getDimensionPixelSize(R.dimen.ds20), this.f56003e.getResources().getDimensionPixelSize(R.dimen.ds10));
                }
                hVar.j.setText(bVar.f56040b);
                if (bVar.f56041c) {
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
                hVar2.f56020a.U(bVar2.f56044f, 10, false);
                hVar2.f56021b.setText(bVar2.f56043e);
                hVar2.f56022c.setText(bVar2.f56046h);
                hVar2.f56023d.setText(bVar2.f56047i);
                long j = bVar2.j;
                if (j < 0) {
                    j = 0;
                }
                long j2 = bVar2.k;
                long j3 = j2 >= 0 ? j2 : 0L;
                hVar2.f56024e.setText(this.f56003e.getString(R.string.attention) + StringHelper.numFormatOver10000wan(j));
                hVar2.f56025f.setText(this.f56003e.getString(R.string.text_post) + StringHelper.numFormatOver10000wan(j3));
                if (bVar2.f56041c && !StringUtils.isNull(bVar2.f56045g)) {
                    hVar2.f56026g.setText(UtilHelper.getFixedText(bVar2.f56045g, 5));
                    hVar2.f56026g.setVisibility(0);
                    hVar2.f56027h.setVisibility(0);
                } else {
                    hVar2.f56026g.setVisibility(8);
                    hVar2.f56027h.setVisibility(8);
                }
                hVar2.f56026g.setOnClickListener(new c(bVar2));
                hVar2.m.setOnClickListener(new d(bVar2));
                hVar2.l.setOnClickListener(new View$OnClickListenerC1286e(this, hVar2));
                view.setOnClickListener(new f(bVar2));
            }
        }
    }

    public final void g() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2902026, new BarFolderFirstDirActivityConfig(this.f56003e.getPageActivity(), SingleSquareActivityConfig.makeStatisticsParam("forum_browse", "all"))));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<f.b> arrayList = this.f56007i;
        int i2 = 0;
        if (arrayList != null && arrayList.size() != 0) {
            i2 = 0 + this.f56007i.size();
        }
        ArrayList<x1> arrayList2 = this.f56006h;
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
                return this.f56006h;
            }
            int i3 = 1;
            if (itemViewType == 1) {
                return this.j;
            }
            if (itemViewType != 2 && itemViewType != 3) {
                return null;
            }
            ArrayList<x1> arrayList = this.f56006h;
            i3 = (arrayList == null || arrayList.size() == 0) ? 0 : 0;
            ArrayList<f.a> arrayList2 = this.j;
            if (arrayList2 != null && arrayList2.size() != 0) {
                i3++;
            }
            int i4 = i2 - i3;
            if (i4 >= 0 && i4 < this.f56007i.size()) {
                return this.f56007i.get(i4);
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
            ArrayList<x1> arrayList3 = this.f56006h;
            if (arrayList3 != null && arrayList3.size() != 0) {
                return 0;
            }
            ArrayList<f.a> arrayList4 = this.j;
            if (arrayList4 != null && arrayList4.size() != 0) {
                return 1;
            }
        }
        if (i2 != 1 || (arrayList = this.f56006h) == null || arrayList.size() == 0 || (arrayList2 = this.j) == null || arrayList2.size() == 0) {
            if (i2 == getCount() - 1) {
                return 4;
            }
            ArrayList<x1> arrayList5 = this.f56006h;
            if (arrayList5 != null && arrayList5.size() != 0) {
                i3 = 1;
            }
            ArrayList<f.a> arrayList6 = this.j;
            if (arrayList6 != null && arrayList6.size() != 0) {
                i3++;
            }
            int i4 = i2 - i3;
            if (i4 < 0 || i4 >= this.f56007i.size() || (bVar = this.f56007i.get(i4)) == null) {
                return -1;
            }
            return bVar.f56039a ? 2 : 3;
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
        this.f56003e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.f56003e.getLayoutMode().j(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 5;
    }

    public void h(int i2) {
        d.a.o0.b3.k.a aVar = this.k;
        if (aVar != null) {
            aVar.e(i2);
        }
        notifyDataSetChanged();
    }

    public void i(d.a.o0.b3.j.f fVar) {
        if (fVar == null) {
            return;
        }
        this.f56005g = fVar;
        this.f56006h = fVar.e();
        this.f56007i = this.f56005g.b();
        this.j = this.f56005g.a();
        this.k.f(this.f56006h);
    }
}
