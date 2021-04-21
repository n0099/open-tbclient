package d.b.j0.a3.j;

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
import d.b.i0.r.q.x1;
import d.b.j0.a3.j.f;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class e extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<Object> f53587e;

    /* renamed from: f  reason: collision with root package name */
    public Activity f53588f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.j0.a3.j.f f53589g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<x1> f53590h;
    public ArrayList<f.b> i;
    public ArrayList<f.a> j;
    public d.b.j0.a3.k.a k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(e.this.f53587e.getPageActivity(), "square_bottom_find_more", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            e.this.g();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.b f53592e;

        public b(f.b bVar) {
            this.f53592e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(e.this.f53588f, "square_category_more", PrefetchEvent.STATE_CLICK, 1, "loc", Integer.valueOf(this.f53592e.m));
            UrlManager.getInstance().dealOneLink(e.this.f53587e, new String[]{this.f53592e.l});
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.b f53594e;

        public c(f.b bVar) {
            this.f53594e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(e.this.f53588f, "square_module_menu", PrefetchEvent.STATE_CLICK, 1, "loc", Integer.valueOf(this.f53594e.n));
            UrlManager.getInstance().dealOneLink(e.this.f53587e, new String[]{this.f53594e.l});
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.b f53596e;

        public d(f.b bVar) {
            this.f53596e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(e.this.f53588f, "square_module_entry", PrefetchEvent.STATE_CLICK, 1, "moduleloc", Integer.valueOf(this.f53596e.m), "loc", Integer.valueOf(this.f53596e.n));
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.f53587e.getPageActivity()).createNormalCfg(this.f53596e.f53625e, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
        }
    }

    /* renamed from: d.b.j0.a3.j.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1198e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f53598e;

        public View$OnClickListenerC1198e(e eVar, h hVar) {
            this.f53598e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f53598e.m.performClick();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.b f53599e;

        public f(f.b bVar) {
            this.f53599e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(e.this.f53588f, "square_module_content", PrefetchEvent.STATE_CLICK, 1, "moduleloc", Integer.valueOf(this.f53599e.m), "loc", Integer.valueOf(this.f53599e.n));
            if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class)) {
                MessageManager messageManager = MessageManager.getInstance();
                Activity pageActivity = e.this.f53587e.getPageActivity();
                messageManager.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(pageActivity, this.f53599e.f53624d + "", ForumDetailActivityConfig.FromType.BAR_SQUARE)));
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.f53587e.getPageActivity()).createNormalCfg(this.f53599e.f53625e, FrsActivityConfig.FRS_FROM_SQUARE)));
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f.a f53601e;

        public g(f.a aVar) {
            this.f53601e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f53601e.f53620d) {
                e.this.g();
            } else {
                UrlManager.getInstance().dealOneLink(e.this.f53587e, new String[]{this.f53601e.f53618b});
            }
            if (view.getTag() instanceof Integer) {
                int intValue = ((Integer) view.getTag()).intValue();
                Activity activity = e.this.f53588f;
                TiebaStatic.eventStat(activity, "square_entry_content", PrefetchEvent.STATE_CLICK, 1, "loc", "" + intValue);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f53603a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f53604b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f53605c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f53606d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f53607e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f53608f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f53609g;

        /* renamed from: h  reason: collision with root package name */
        public View f53610h;
        public RelativeLayout i;
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
        this.f53587e = tbPageContext;
        this.f53588f = tbPageContext.getPageActivity();
        d.b.j0.a3.k.a aVar = new d.b.j0.a3.k.a(tbPageContext);
        this.k = aVar;
        CoverFlowView<d.b.j0.a3.j.g> d2 = aVar.d();
        if (tbPageContext.getOrignalPage() instanceof SquareActivity) {
            d2.setSwipeControlInterface((SquareActivity) tbPageContext.getOrignalPage());
        }
        d2.setDisableParentEvent(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v13 */
    public final View d(int i, ViewGroup viewGroup, int i2) {
        View inflate;
        if (i2 == 1) {
            return LayoutInflater.from(this.f53587e.getPageActivity()).inflate(R.layout.square_list_entry_view, (ViewGroup) null);
        }
        if (i2 == 2) {
            inflate = LayoutInflater.from(this.f53587e.getPageActivity()).inflate(R.layout.square_list_title_view, (ViewGroup) null);
            h hVar = new h(null);
            hVar.i = (RelativeLayout) inflate.findViewById(R.id.title_layout);
            hVar.j = (TextView) inflate.findViewById(R.id.title_text);
            hVar.k = (TextView) inflate.findViewById(R.id.more_text);
            inflate.setTag(hVar);
        } else if (i2 != 3) {
            if (i2 == 4) {
                View inflate2 = LayoutInflater.from(this.f53587e.getPageActivity()).inflate(R.layout.square_list_more_view, (ViewGroup) null);
                inflate2.setOnClickListener(new a());
                return inflate2;
            }
            return null;
        } else {
            inflate = LayoutInflater.from(this.f53587e.getPageActivity()).inflate(R.layout.square_forum_item_view, (ViewGroup) null);
            h hVar2 = new h(null);
            hVar2.f53604b = (TextView) inflate.findViewById(R.id.forum_name);
            hVar2.f53603a = (BarImageView) inflate.findViewById(R.id.forum_image);
            hVar2.f53605c = (TextView) inflate.findViewById(R.id.forum_rank);
            hVar2.f53606d = (TextView) inflate.findViewById(R.id.forum_intro);
            hVar2.f53607e = (TextView) inflate.findViewById(R.id.like_num_tv);
            hVar2.f53608f = (TextView) inflate.findViewById(R.id.thread_num_tv);
            hVar2.f53609g = (TextView) inflate.findViewById(R.id.category_name_tv);
            hVar2.f53610h = inflate.findViewById(R.id.vertical_line_view);
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
            for (int i = 0; i < 4; i++) {
                if (i < size) {
                    f.a aVar = this.j.get(i);
                    if (aVar == null) {
                        viewArr2[i].setVisibility(8);
                    } else {
                        if (viewArr2[i] instanceof LinearLayout) {
                            LinearLayout linearLayout = (LinearLayout) viewArr2[i];
                            linearLayout.setTag(Integer.valueOf(i));
                            View childAt = linearLayout.getChildAt(0);
                            if (childAt instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt;
                                tbImageView.setTag(Integer.valueOf(i));
                                tbImageView.setDrawerType(1);
                                tbImageView.setIsRound(true);
                                tbImageView.W(aVar.f53619c, 10, false);
                            }
                            View childAt2 = linearLayout.getChildAt(1);
                            if (childAt2 instanceof TextView) {
                                ((TextView) childAt2).setText(UtilHelper.getFixedText(aVar.f53617a, 5, false));
                            }
                            linearLayout.setOnClickListener(new g(aVar));
                        }
                        viewArr2[i].setVisibility(0);
                        viewArr[i].setVisibility(0);
                    }
                } else {
                    viewArr2[i].setVisibility(8);
                    viewArr[i].setVisibility(8);
                }
            }
            return;
        }
        view.setVisibility(8);
    }

    public final void f(View view, int i) {
        if (view == null) {
            return;
        }
        int itemViewType = getItemViewType(i);
        if (itemViewType == 1) {
            e(view);
        } else if (itemViewType == 2) {
            Object item = getItem(i);
            if (item instanceof f.b) {
                f.b bVar = (f.b) item;
                h hVar = (h) view.getTag();
                if (bVar.m == 0) {
                    hVar.i.setPadding(this.f53587e.getResources().getDimensionPixelSize(R.dimen.ds30), this.f53587e.getResources().getDimensionPixelSize(R.dimen.ds26), this.f53587e.getResources().getDimensionPixelSize(R.dimen.ds20), this.f53587e.getResources().getDimensionPixelSize(R.dimen.ds10));
                } else {
                    hVar.i.setPadding(this.f53587e.getResources().getDimensionPixelSize(R.dimen.ds30), this.f53587e.getResources().getDimensionPixelSize(R.dimen.ds6), this.f53587e.getResources().getDimensionPixelSize(R.dimen.ds20), this.f53587e.getResources().getDimensionPixelSize(R.dimen.ds10));
                }
                hVar.j.setText(bVar.f53622b);
                if (bVar.f53623c) {
                    hVar.k.setVisibility(8);
                    return;
                }
                hVar.k.setVisibility(0);
                hVar.k.setOnClickListener(new b(bVar));
            }
        } else if (itemViewType == 3) {
            Object item2 = getItem(i);
            if (item2 instanceof f.b) {
                f.b bVar2 = (f.b) item2;
                h hVar2 = (h) view.getTag();
                if (hVar2 == null) {
                    return;
                }
                hVar2.f53603a.W(bVar2.f53626f, 10, false);
                hVar2.f53604b.setText(bVar2.f53625e);
                hVar2.f53605c.setText(bVar2.f53628h);
                hVar2.f53606d.setText(bVar2.i);
                long j = bVar2.j;
                if (j < 0) {
                    j = 0;
                }
                long j2 = bVar2.k;
                long j3 = j2 >= 0 ? j2 : 0L;
                hVar2.f53607e.setText(this.f53587e.getString(R.string.attention) + StringHelper.numFormatOver10000wan(j));
                hVar2.f53608f.setText(this.f53587e.getString(R.string.text_post) + StringHelper.numFormatOver10000wan(j3));
                if (bVar2.f53623c && !StringUtils.isNull(bVar2.f53627g)) {
                    hVar2.f53609g.setText(UtilHelper.getFixedText(bVar2.f53627g, 5));
                    hVar2.f53609g.setVisibility(0);
                    hVar2.f53610h.setVisibility(0);
                } else {
                    hVar2.f53609g.setVisibility(8);
                    hVar2.f53610h.setVisibility(8);
                }
                hVar2.f53609g.setOnClickListener(new c(bVar2));
                hVar2.m.setOnClickListener(new d(bVar2));
                hVar2.l.setOnClickListener(new View$OnClickListenerC1198e(this, hVar2));
                view.setOnClickListener(new f(bVar2));
            }
        }
    }

    public final void g() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2902026, new BarFolderFirstDirActivityConfig(this.f53587e.getPageActivity(), SingleSquareActivityConfig.makeStatisticsParam("forum_browse", "all"))));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<f.b> arrayList = this.i;
        int i = 0;
        if (arrayList != null && arrayList.size() != 0) {
            i = 0 + this.i.size();
        }
        ArrayList<x1> arrayList2 = this.f53590h;
        if (arrayList2 != null && arrayList2.size() != 0) {
            i++;
        }
        if (i != 0) {
            i++;
        }
        ArrayList<f.a> arrayList3 = this.j;
        return (arrayList3 == null || arrayList3.size() <= 0) ? i : i + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType != -1 && itemViewType != 4) {
            if (itemViewType == 0) {
                return this.f53590h;
            }
            int i2 = 1;
            if (itemViewType == 1) {
                return this.j;
            }
            if (itemViewType != 2 && itemViewType != 3) {
                return null;
            }
            ArrayList<x1> arrayList = this.f53590h;
            i2 = (arrayList == null || arrayList.size() == 0) ? 0 : 0;
            ArrayList<f.a> arrayList2 = this.j;
            if (arrayList2 != null && arrayList2.size() != 0) {
                i2++;
            }
            int i3 = i - i2;
            if (i3 >= 0 && i3 < this.i.size()) {
                return this.i.get(i3);
            }
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        f.b bVar;
        ArrayList<x1> arrayList;
        ArrayList<f.a> arrayList2;
        int i2 = 0;
        if (i == 0) {
            ArrayList<x1> arrayList3 = this.f53590h;
            if (arrayList3 != null && arrayList3.size() != 0) {
                return 0;
            }
            ArrayList<f.a> arrayList4 = this.j;
            if (arrayList4 != null && arrayList4.size() != 0) {
                return 1;
            }
        }
        if (i != 1 || (arrayList = this.f53590h) == null || arrayList.size() == 0 || (arrayList2 = this.j) == null || arrayList2.size() == 0) {
            if (i == getCount() - 1) {
                return 4;
            }
            ArrayList<x1> arrayList5 = this.f53590h;
            if (arrayList5 != null && arrayList5.size() != 0) {
                i2 = 1;
            }
            ArrayList<f.a> arrayList6 = this.j;
            if (arrayList6 != null && arrayList6.size() != 0) {
                i2++;
            }
            int i3 = i - i2;
            if (i3 < 0 || i3 >= this.i.size() || (bVar = this.i.get(i3)) == null) {
                return -1;
            }
            return bVar.f53621a ? 2 : 3;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            return this.k.getView(i, view, viewGroup);
        }
        if (view == null) {
            view = d(i, viewGroup, itemViewType);
        }
        f(view, i);
        this.f53587e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.f53587e.getLayoutMode().j(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 5;
    }

    public void h(int i) {
        d.b.j0.a3.k.a aVar = this.k;
        if (aVar != null) {
            aVar.e(i);
        }
        notifyDataSetChanged();
    }

    public void i(d.b.j0.a3.j.f fVar) {
        if (fVar == null) {
            return;
        }
        this.f53589g = fVar;
        this.f53590h = fVar.e();
        this.i = this.f53589g.b();
        this.j = this.f53589g.a();
        this.k.f(this.f53590h);
    }
}
