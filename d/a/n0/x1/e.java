package d.a.n0.x1;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import d.a.c.e.p.l;
import d.a.m0.r.k;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e extends BaseAdapter {
    public static final float q = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32);
    public static final float r = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds36);
    public static final float s = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds26);
    public static final int t = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds28);
    public static final int u = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds20);

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f63234e;
    public Runnable n;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList<MarkData> f63235f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public boolean f63236g = false;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f63237h = null;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f63238i = null;
    public View.OnClickListener j = null;
    public boolean k = false;
    public boolean l = true;
    public boolean m = true;
    public final View.OnClickListener o = new c();
    public View.OnClickListener p = new d();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.notifyDataSetChanged();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements OriginalThreadCardView.b {
        public b(e eVar) {
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            TiebaStatic.log(new StatisticItem("c12529").param("obj_locate", 5));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarkData item = e.this.getItem(((Integer) view.getTag()).intValue());
            StatisticItem statisticItem = new StatisticItem("c12529");
            if (view instanceof CommonUserLikeButton) {
                statisticItem.param("obj_locate", 4);
            } else if (view instanceof ClickableHeaderImageView) {
                statisticItem.param("obj_locate", 1);
            }
            statisticItem.param("tid", item.getId());
            statisticItem.param("obj_id", item.getUesrId());
            TiebaStatic.log(statisticItem);
            d.a.n0.x1.c.b("c14064", item);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.n0.x1.c.b("c14065", e.this.getItem(((Integer) view.getTag()).intValue()));
        }
    }

    /* renamed from: d.a.n0.x1.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1738e {

        /* renamed from: a  reason: collision with root package name */
        public ImageButton f63242a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f63243b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f63244c;

        /* renamed from: d  reason: collision with root package name */
        public CommonUserLikeButton f63245d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f63246e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f63247f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f63248g;

        /* renamed from: h  reason: collision with root package name */
        public LinearLayout f63249h;

        /* renamed from: i  reason: collision with root package name */
        public LinearLayout f63250i;
        public LinearLayout j;
        public View k;
        public d.a.m0.r.f0.q.c l;

        public C1738e() {
        }

        public void a(MarkData markData) {
            if (markData == null) {
                return;
            }
            String title = markData.getTitle();
            if (!TextUtils.isEmpty(title)) {
                if (markData.is_deleted()) {
                    this.f63246e.setText(title);
                    this.f63246e.setTextSize(0, e.q);
                    SkinManager.setViewTextColor(this.f63246e, R.color.CAM_X0110);
                } else {
                    this.f63246e.setText(title);
                    this.f63246e.setTextSize(0, e.r);
                    SkinManager.setViewTextColor(this.f63246e, R.color.CAM_X0105);
                }
            } else {
                this.f63246e.setText("");
            }
            c(markData);
            this.f63243b.setData(markData.metaData);
            this.f63243b.setShowV(markData.metaData.isBigV());
            this.l.n(markData.metaData);
            this.f63245d.g(TbadkCoreApplication.getInst().getSkinType());
            this.f63245d.setTextSize(0, e.s);
            if ((markData.metaData.getIsLike() || StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                this.f63245d.setVisibility(8);
            } else {
                this.f63245d.setVisibility(0);
            }
            if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                this.j.setVisibility(0);
                if (markData.isRedTipShow() && !markData.is_deleted()) {
                    this.f63248g.setVisibility(0);
                } else {
                    this.f63248g.setVisibility(8);
                }
                if (markData.is_deleted()) {
                    this.f63247f.setText(e.this.f63234e.getString(R.string.mark_thread_deleted));
                } else {
                    this.f63247f.setText(markData.getmState());
                }
                SkinManager.setViewTextColor(this.f63247f, R.color.CAM_X0109);
            } else {
                this.j.setVisibility(8);
            }
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
        }

        public void b(ClickableHeaderImageView clickableHeaderImageView) {
            if (clickableHeaderImageView == null) {
                return;
            }
            clickableHeaderImageView.setDefaultResource(17170445);
            clickableHeaderImageView.setPlaceHolder(1);
            clickableHeaderImageView.setIsRound(true);
            clickableHeaderImageView.setAfterClickListener(e.this.o);
        }

        public final void c(MarkData markData) {
            if (markData == null) {
                return;
            }
            this.f63244c.setText(markData.getAuthorName());
            if (markData.metaData.isBigV()) {
                SkinManager.setViewTextColor(this.f63244c, R.color.CAM_X0301);
            } else {
                SkinManager.setViewTextColor(this.f63244c, R.color.CAM_X0106);
            }
        }

        public /* synthetic */ C1738e(e eVar, a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public class f {

        /* renamed from: a  reason: collision with root package name */
        public TextView f63251a;

        /* renamed from: b  reason: collision with root package name */
        public ProgressBar f63252b;

        public f(e eVar) {
        }

        public /* synthetic */ f(e eVar, a aVar) {
            this(eVar);
        }
    }

    /* loaded from: classes3.dex */
    public class g extends C1738e {
        public OriginalThreadCardView n;

        public g(e eVar, View view) {
            super(eVar, null);
            this.f63249h = (LinearLayout) view.findViewById(R.id.share_lv_markitem);
            this.f63242a = (ImageButton) view.findViewById(R.id.share_lv_markitem_delete);
            this.f63243b = (ClickableHeaderImageView) view.findViewById(R.id.share_mark_userinfo_header_view);
            this.f63244c = (TextView) view.findViewById(R.id.share_mark_userinfo_name);
            this.f63245d = (CommonUserLikeButton) view.findViewById(R.id.share_mark_item_userinfo_like_btn);
            this.l = new d.a.m0.r.f0.q.c(eVar.f63234e, this.f63245d);
            this.f63250i = (LinearLayout) view.findViewById(R.id.share_lv_markitem_userinfo);
            this.f63246e = (TextView) view.findViewById(R.id.share_thread_title);
            this.n = (OriginalThreadCardView) view.findViewById(R.id.share_original_thread_view);
            this.f63247f = (TextView) view.findViewById(R.id.share_mark_item_state_text);
            this.f63248g = (ImageView) view.findViewById(R.id.share_new_mark_mention_redtip);
            this.j = (LinearLayout) view.findViewById(R.id.share_mark_item_state);
            this.k = view.findViewById(R.id.share_text_divider);
            b(this.f63243b);
        }

        @Override // d.a.n0.x1.e.C1738e
        public void a(MarkData markData) {
            super.a(markData);
            this.n.f(markData.getOriginalThreadInfo());
            this.n.n();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) e.q;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends C1738e {
        public TbImageView n;
        public LinearLayout o;

        public h(e eVar, View view) {
            super(eVar, null);
            this.f63249h = (LinearLayout) view.findViewById(R.id.home_lv_markitem);
            this.f63243b = (ClickableHeaderImageView) view.findViewById(R.id.mark_userinfo_header_view);
            this.f63244c = (TextView) view.findViewById(R.id.mark_userinfo_name);
            this.f63250i = (LinearLayout) view.findViewById(R.id.home_lv_markitem_userinfo);
            this.o = (LinearLayout) view.findViewById(R.id.home_lv_markitem_thread);
            this.f63245d = (CommonUserLikeButton) view.findViewById(R.id.markitem_userinfo_like_btn);
            this.l = new d.a.m0.r.f0.q.c(eVar.f63234e, this.f63245d);
            this.n = (TbImageView) view.findViewById(R.id.markitem_thread_image);
            this.f63246e = (TextView) view.findViewById(R.id.markitem_thread_title);
            this.f63247f = (TextView) view.findViewById(R.id.markitem_state_text);
            this.f63242a = (ImageButton) view.findViewById(R.id.home_lv_markitem_delete);
            this.f63248g = (ImageView) view.findViewById(R.id.new_mark_mention_redtip);
            this.j = (LinearLayout) view.findViewById(R.id.markitem_state);
            this.k = view.findViewById(R.id.text_divider);
            b(this.f63243b);
            this.n.setPlaceHolder(1);
        }

        @Override // d.a.n0.x1.e.C1738e
        public void a(MarkData markData) {
            super.a(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f63250i.getLayoutParams();
            if (k.c().g() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.n.setVisibility(0);
                    this.n.V(pic_url, 10, false);
                }
                layoutParams.bottomMargin = e.t;
            } else {
                this.n.setVisibility(8);
                layoutParams.bottomMargin = e.u;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.o.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) e.q;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    public e(TbPageContext<?> tbPageContext) {
        this.f63234e = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f63235f)) {
            return 0;
        }
        return this.m ? ListUtils.getCount(this.f63235f) + 1 : ListUtils.getCount(this.f63235f);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        if (ListUtils.getCount(this.f63235f) <= i2) {
            return -1L;
        }
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        MarkData item = getItem(i2);
        if (item == null) {
            return 1;
        }
        return item.isShareThread() ? 2 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1738e hVar;
        f fVar;
        g gVar;
        int itemViewType = getItemViewType(i2);
        if (itemViewType == 0) {
            if (view != null && (view.getTag() instanceof h)) {
                hVar = (h) view.getTag();
            } else {
                view = LayoutInflater.from(this.f63234e.getPageActivity()).inflate(R.layout.home_mark_item, (ViewGroup) null);
                hVar = new h(this, view);
                view.setTag(hVar);
            }
            MarkData item = getItem(i2);
            if (item == null) {
                hVar.f63242a.setVisibility(8);
                return view;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) hVar.f63249h.getLayoutParams();
            if (this.f63236g) {
                hVar.f63242a.setVisibility(0);
                layoutParams.leftMargin = 0;
            } else {
                hVar.f63242a.setVisibility(8);
                layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
            }
            hVar.a(item);
            o(i2, hVar);
        } else if (itemViewType == 1) {
            if (view != null && (view.getTag() instanceof f)) {
                fVar = (f) view.getTag();
            } else {
                view = LayoutInflater.from(this.f63234e.getPageActivity()).inflate(R.layout.page_item, (ViewGroup) null);
                fVar = new f(this, null);
                fVar.f63251a = (TextView) view.findViewById(R.id.page_text);
                fVar.f63252b = (ProgressBar) view.findViewById(R.id.progress);
                view.setTag(fVar);
            }
            fVar.f63251a.setVisibility(0);
            if (this.k) {
                fVar.f63252b.setVisibility(0);
                fVar.f63251a.setText(this.f63234e.getString(R.string.loading));
                SkinManager.setViewTextColor(fVar.f63251a, R.color.common_color_10039, 1);
            } else if (!this.l) {
                fVar.f63252b.setVisibility(8);
                fVar.f63251a.setText(this.f63234e.getString(R.string.no_more_mark));
                SkinManager.setViewTextColor(fVar.f63251a, R.color.common_color_10005, 1);
            } else {
                fVar.f63252b.setVisibility(8);
                fVar.f63251a.setText(this.f63234e.getString(R.string.loading));
                SkinManager.setViewTextColor(fVar.f63251a, R.color.common_color_10039, 1);
            }
        } else if (itemViewType == 2) {
            if (view != null && (view.getTag() instanceof g)) {
                gVar = (g) view.getTag();
            } else {
                view = LayoutInflater.from(this.f63234e.getPageActivity()).inflate(R.layout.cell_collect_share_view, (ViewGroup) null);
                gVar = new g(this, view);
                view.setTag(gVar);
            }
            MarkData item2 = getItem(i2);
            if (item2 == null) {
                gVar.f63242a.setVisibility(8);
                return view;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) gVar.f63249h.getLayoutParams();
            if (this.f63236g) {
                gVar.f63242a.setVisibility(0);
                layoutParams2.leftMargin = 0;
            } else {
                gVar.f63242a.setVisibility(8);
                layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
            }
            gVar.a(item2);
            o(i2, gVar);
            gVar.n.setSubClickListener(new b(this));
        }
        this.f63234e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.f63234e.getLayoutMode().j(view);
        d.a.n0.x1.c.b("c14062", getItem(i2));
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: h */
    public MarkData getItem(int i2) {
        return (MarkData) ListUtils.getItem(this.f63235f, i2);
    }

    public void i() {
        if (this.n != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.n);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i2) {
        if (ListUtils.isEmpty(this.f63235f)) {
            return false;
        }
        if (this.l || getItemViewType(i2) != 1) {
            return super.isEnabled(i2);
        }
        return false;
    }

    public void j(ArrayList<MarkData> arrayList) {
        this.f63235f.clear();
        if (arrayList != null) {
            this.f63235f.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    public void k(View.OnClickListener onClickListener) {
        this.f63237h = onClickListener;
    }

    public void l(boolean z) {
        this.f63236g = z;
    }

    public void m(boolean z) {
        this.m = z;
    }

    public void n(boolean z) {
        this.l = z;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        if (!l.C()) {
            if (this.n == null) {
                this.n = new a();
            }
            d.a.c.e.m.e.a().post(this.n);
            return;
        }
        super.notifyDataSetChanged();
    }

    public final void o(int i2, C1738e c1738e) {
        Integer valueOf = Integer.valueOf(i2);
        c1738e.f63250i.setOnClickListener(this.f63238i);
        c1738e.f63250i.setTag(valueOf);
        c1738e.f63243b.setAfterClickListener(this.o);
        c1738e.f63243b.setTag(valueOf);
        c1738e.f63245d.setAfterOnClickListener(this.o);
        c1738e.f63245d.setAfterOnClickListener(this.p);
        c1738e.f63245d.setTag(valueOf);
        c1738e.j.setOnClickListener(this.j);
        c1738e.j.setTag(valueOf);
        c1738e.f63242a.setOnClickListener(this.f63237h);
        c1738e.f63242a.setFocusable(false);
        c1738e.f63242a.setTag(valueOf);
    }

    public void p(boolean z) {
        this.k = z;
    }

    public void q(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    public void r(View.OnClickListener onClickListener) {
        this.f63238i = onClickListener;
    }
}
