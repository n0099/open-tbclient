package d.a.j0.w1;

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
import d.a.i0.r.k;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e extends BaseAdapter {
    public static final float q = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32);
    public static final float r = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds36);
    public static final float s = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds26);
    public static final int t = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds28);
    public static final int u = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds20);

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f62325e;
    public Runnable n;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList<MarkData> f62326f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public boolean f62327g = false;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f62328h = null;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f62329i = null;
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
            d.a.j0.w1.c.b("c14064", item);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.j0.w1.c.b("c14065", e.this.getItem(((Integer) view.getTag()).intValue()));
        }
    }

    /* renamed from: d.a.j0.w1.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1656e {

        /* renamed from: a  reason: collision with root package name */
        public ImageButton f62333a;

        /* renamed from: b  reason: collision with root package name */
        public ClickableHeaderImageView f62334b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f62335c;

        /* renamed from: d  reason: collision with root package name */
        public CommonUserLikeButton f62336d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f62337e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f62338f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f62339g;

        /* renamed from: h  reason: collision with root package name */
        public LinearLayout f62340h;

        /* renamed from: i  reason: collision with root package name */
        public LinearLayout f62341i;
        public LinearLayout j;
        public View k;
        public d.a.i0.r.f0.q.c l;

        public C1656e() {
        }

        public void a(MarkData markData) {
            if (markData == null) {
                return;
            }
            String title = markData.getTitle();
            if (!TextUtils.isEmpty(title)) {
                if (markData.is_deleted()) {
                    this.f62337e.setText(title);
                    this.f62337e.setTextSize(0, e.q);
                    SkinManager.setViewTextColor(this.f62337e, R.color.CAM_X0110);
                } else {
                    this.f62337e.setText(title);
                    this.f62337e.setTextSize(0, e.r);
                    SkinManager.setViewTextColor(this.f62337e, R.color.CAM_X0105);
                }
            } else {
                this.f62337e.setText("");
            }
            c(markData);
            this.f62334b.setData(markData.metaData);
            this.f62334b.setShowV(markData.metaData.isBigV());
            this.l.n(markData.metaData);
            this.f62336d.g(TbadkCoreApplication.getInst().getSkinType());
            this.f62336d.setTextSize(0, e.s);
            if ((markData.metaData.getIsLike() || StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                this.f62336d.setVisibility(8);
            } else {
                this.f62336d.setVisibility(0);
            }
            if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                this.j.setVisibility(0);
                if (markData.isRedTipShow() && !markData.is_deleted()) {
                    this.f62339g.setVisibility(0);
                } else {
                    this.f62339g.setVisibility(8);
                }
                if (markData.is_deleted()) {
                    this.f62338f.setText(e.this.f62325e.getString(R.string.mark_thread_deleted));
                } else {
                    this.f62338f.setText(markData.getmState());
                }
                SkinManager.setViewTextColor(this.f62338f, R.color.CAM_X0109);
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
            this.f62335c.setText(markData.getAuthorName());
            if (markData.metaData.isBigV()) {
                SkinManager.setViewTextColor(this.f62335c, R.color.CAM_X0301);
            } else {
                SkinManager.setViewTextColor(this.f62335c, R.color.CAM_X0106);
            }
        }

        public /* synthetic */ C1656e(e eVar, a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public class f {

        /* renamed from: a  reason: collision with root package name */
        public TextView f62342a;

        /* renamed from: b  reason: collision with root package name */
        public ProgressBar f62343b;

        public f(e eVar) {
        }

        public /* synthetic */ f(e eVar, a aVar) {
            this(eVar);
        }
    }

    /* loaded from: classes3.dex */
    public class g extends C1656e {
        public OriginalThreadCardView n;

        public g(e eVar, View view) {
            super(eVar, null);
            this.f62340h = (LinearLayout) view.findViewById(R.id.share_lv_markitem);
            this.f62333a = (ImageButton) view.findViewById(R.id.share_lv_markitem_delete);
            this.f62334b = (ClickableHeaderImageView) view.findViewById(R.id.share_mark_userinfo_header_view);
            this.f62335c = (TextView) view.findViewById(R.id.share_mark_userinfo_name);
            this.f62336d = (CommonUserLikeButton) view.findViewById(R.id.share_mark_item_userinfo_like_btn);
            this.l = new d.a.i0.r.f0.q.c(eVar.f62325e, this.f62336d);
            this.f62341i = (LinearLayout) view.findViewById(R.id.share_lv_markitem_userinfo);
            this.f62337e = (TextView) view.findViewById(R.id.share_thread_title);
            this.n = (OriginalThreadCardView) view.findViewById(R.id.share_original_thread_view);
            this.f62338f = (TextView) view.findViewById(R.id.share_mark_item_state_text);
            this.f62339g = (ImageView) view.findViewById(R.id.share_new_mark_mention_redtip);
            this.j = (LinearLayout) view.findViewById(R.id.share_mark_item_state);
            this.k = view.findViewById(R.id.share_text_divider);
            b(this.f62334b);
        }

        @Override // d.a.j0.w1.e.C1656e
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
    public class h extends C1656e {
        public TbImageView n;
        public LinearLayout o;

        public h(e eVar, View view) {
            super(eVar, null);
            this.f62340h = (LinearLayout) view.findViewById(R.id.home_lv_markitem);
            this.f62334b = (ClickableHeaderImageView) view.findViewById(R.id.mark_userinfo_header_view);
            this.f62335c = (TextView) view.findViewById(R.id.mark_userinfo_name);
            this.f62341i = (LinearLayout) view.findViewById(R.id.home_lv_markitem_userinfo);
            this.o = (LinearLayout) view.findViewById(R.id.home_lv_markitem_thread);
            this.f62336d = (CommonUserLikeButton) view.findViewById(R.id.markitem_userinfo_like_btn);
            this.l = new d.a.i0.r.f0.q.c(eVar.f62325e, this.f62336d);
            this.n = (TbImageView) view.findViewById(R.id.markitem_thread_image);
            this.f62337e = (TextView) view.findViewById(R.id.markitem_thread_title);
            this.f62338f = (TextView) view.findViewById(R.id.markitem_state_text);
            this.f62333a = (ImageButton) view.findViewById(R.id.home_lv_markitem_delete);
            this.f62339g = (ImageView) view.findViewById(R.id.new_mark_mention_redtip);
            this.j = (LinearLayout) view.findViewById(R.id.markitem_state);
            this.k = view.findViewById(R.id.text_divider);
            b(this.f62334b);
            this.n.setPlaceHolder(1);
        }

        @Override // d.a.j0.w1.e.C1656e
        public void a(MarkData markData) {
            super.a(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f62341i.getLayoutParams();
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
        this.f62325e = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f62326f)) {
            return 0;
        }
        return this.m ? ListUtils.getCount(this.f62326f) + 1 : ListUtils.getCount(this.f62326f);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        if (ListUtils.getCount(this.f62326f) <= i2) {
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
        C1656e hVar;
        f fVar;
        g gVar;
        int itemViewType = getItemViewType(i2);
        if (itemViewType == 0) {
            if (view != null && (view.getTag() instanceof h)) {
                hVar = (h) view.getTag();
            } else {
                view = LayoutInflater.from(this.f62325e.getPageActivity()).inflate(R.layout.home_mark_item, (ViewGroup) null);
                hVar = new h(this, view);
                view.setTag(hVar);
            }
            MarkData item = getItem(i2);
            if (item == null) {
                hVar.f62333a.setVisibility(8);
                return view;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) hVar.f62340h.getLayoutParams();
            if (this.f62327g) {
                hVar.f62333a.setVisibility(0);
                layoutParams.leftMargin = 0;
            } else {
                hVar.f62333a.setVisibility(8);
                layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
            }
            hVar.a(item);
            o(i2, hVar);
        } else if (itemViewType == 1) {
            if (view != null && (view.getTag() instanceof f)) {
                fVar = (f) view.getTag();
            } else {
                view = LayoutInflater.from(this.f62325e.getPageActivity()).inflate(R.layout.page_item, (ViewGroup) null);
                fVar = new f(this, null);
                fVar.f62342a = (TextView) view.findViewById(R.id.page_text);
                fVar.f62343b = (ProgressBar) view.findViewById(R.id.progress);
                view.setTag(fVar);
            }
            fVar.f62342a.setVisibility(0);
            if (this.k) {
                fVar.f62343b.setVisibility(0);
                fVar.f62342a.setText(this.f62325e.getString(R.string.loading));
                SkinManager.setViewTextColor(fVar.f62342a, R.color.common_color_10039, 1);
            } else if (!this.l) {
                fVar.f62343b.setVisibility(8);
                fVar.f62342a.setText(this.f62325e.getString(R.string.no_more_mark));
                SkinManager.setViewTextColor(fVar.f62342a, R.color.common_color_10005, 1);
            } else {
                fVar.f62343b.setVisibility(8);
                fVar.f62342a.setText(this.f62325e.getString(R.string.loading));
                SkinManager.setViewTextColor(fVar.f62342a, R.color.common_color_10039, 1);
            }
        } else if (itemViewType == 2) {
            if (view != null && (view.getTag() instanceof g)) {
                gVar = (g) view.getTag();
            } else {
                view = LayoutInflater.from(this.f62325e.getPageActivity()).inflate(R.layout.cell_collect_share_view, (ViewGroup) null);
                gVar = new g(this, view);
                view.setTag(gVar);
            }
            MarkData item2 = getItem(i2);
            if (item2 == null) {
                gVar.f62333a.setVisibility(8);
                return view;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) gVar.f62340h.getLayoutParams();
            if (this.f62327g) {
                gVar.f62333a.setVisibility(0);
                layoutParams2.leftMargin = 0;
            } else {
                gVar.f62333a.setVisibility(8);
                layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
            }
            gVar.a(item2);
            o(i2, gVar);
            gVar.n.setSubClickListener(new b(this));
        }
        this.f62325e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.f62325e.getLayoutMode().j(view);
        d.a.j0.w1.c.b("c14062", getItem(i2));
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
        return (MarkData) ListUtils.getItem(this.f62326f, i2);
    }

    public void i() {
        if (this.n != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.n);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i2) {
        if (ListUtils.isEmpty(this.f62326f)) {
            return false;
        }
        if (this.l || getItemViewType(i2) != 1) {
            return super.isEnabled(i2);
        }
        return false;
    }

    public void j(ArrayList<MarkData> arrayList) {
        this.f62326f.clear();
        if (arrayList != null) {
            this.f62326f.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    public void k(View.OnClickListener onClickListener) {
        this.f62328h = onClickListener;
    }

    public void l(boolean z) {
        this.f62327g = z;
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

    public final void o(int i2, C1656e c1656e) {
        Integer valueOf = Integer.valueOf(i2);
        c1656e.f62341i.setOnClickListener(this.f62329i);
        c1656e.f62341i.setTag(valueOf);
        c1656e.f62334b.setAfterClickListener(this.o);
        c1656e.f62334b.setTag(valueOf);
        c1656e.f62336d.setAfterOnClickListener(this.o);
        c1656e.f62336d.setAfterOnClickListener(this.p);
        c1656e.f62336d.setTag(valueOf);
        c1656e.j.setOnClickListener(this.j);
        c1656e.j.setTag(valueOf);
        c1656e.f62333a.setOnClickListener(this.f62328h);
        c1656e.f62333a.setFocusable(false);
        c1656e.f62333a.setTag(valueOf);
    }

    public void p(boolean z) {
        this.k = z;
    }

    public void q(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    public void r(View.OnClickListener onClickListener) {
        this.f62329i = onClickListener;
    }
}
