package d.b.i0.t.d.c.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.view.TabLiveStageLiveView;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerRecyclerAdapter;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerRecyclerView;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder;
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public class b extends d.b.i0.x.b<d.b.i0.t.d.c.e.c> {
    public AlaBannerRecyclerView m;
    public AlaBannerRecyclerAdapter n;
    public View o;
    public View p;
    public TextView q;
    public int r;
    public int s;
    public int[] t;
    public boolean u;
    public d.b.i0.t.d.h.a.a v;

    /* loaded from: classes4.dex */
    public class a implements d.b.i0.t.d.h.a.a {

        /* renamed from: d.b.i0.t.d.c.h.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1548a extends AlaBannerViewHolder<SdkLiveInfoData> {

            /* renamed from: a  reason: collision with root package name */
            public View f60447a;

            /* renamed from: b  reason: collision with root package name */
            public View f60448b;

            /* renamed from: c  reason: collision with root package name */
            public TabLiveStageLiveView f60449c;

            /* renamed from: d  reason: collision with root package name */
            public int f60450d;

            /* renamed from: e  reason: collision with root package name */
            public int f60451e;

            public C1548a(View view) {
                super(view);
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void b(View view) {
                this.f60449c = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                this.f60447a = view.findViewById(R.id.recom_live_item_left_space);
                this.f60448b = view.findViewById(R.id.recom_live_item_right_space);
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void c(int i) {
                this.f60449c.c();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            /* renamed from: d */
            public void a(int i, SdkLiveInfoData sdkLiveInfoData) {
                this.f60449c.setData(sdkLiveInfoData, 102);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f60447a.getLayoutParams();
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f60448b.getLayoutParams();
                if (i == 0) {
                    if (b.this.u) {
                        layoutParams.width = b.this.f62181f.getResources().getDimensionPixelSize(R.dimen.tbds44);
                        layoutParams2.width = b.this.f62181f.getResources().getDimensionPixelSize(R.dimen.tbds44);
                        this.f60448b.setVisibility(0);
                    } else {
                        layoutParams.width = b.this.f62181f.getResources().getDimensionPixelSize(R.dimen.tbds44);
                        this.f60448b.setVisibility(8);
                    }
                } else {
                    layoutParams.width = b.this.f62181f.getResources().getDimensionPixelSize(R.dimen.tbds12);
                    if (b.this.n.getItemCount() - 1 == i) {
                        this.f60448b.setVisibility(0);
                    } else {
                        this.f60448b.setVisibility(8);
                    }
                }
                this.f60447a.setLayoutParams(layoutParams);
                this.f60448b.setLayoutParams(layoutParams2);
                e();
                StatisticItem statisticItem = new StatisticItem("c13558");
                statisticItem.param(TiebaStatic.Params.ENTRY_NAME, "推荐");
                TiebaStatic.log(statisticItem);
            }

            public final void e() {
                this.f60450d = b.this.z();
                this.f60451e = b.this.y();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f60449c.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.f60450d, this.f60451e);
                } else {
                    layoutParams.width = this.f60450d;
                    layoutParams.height = this.f60451e;
                }
                layoutParams.gravity = 1;
                this.f60449c.setLayoutParams(layoutParams);
            }
        }

        public a() {
        }

        @Override // d.b.i0.t.d.h.a.a
        public AlaBannerViewHolder a(ViewGroup viewGroup, int i) {
            return new C1548a(LayoutInflater.from(b.this.b()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup, false));
        }
    }

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.u = false;
        this.v = new a();
        this.u = false;
        int k = (int) (l.k(b()) * 0.76d);
        this.r = k;
        this.s = (int) ((k * 9.0d) / 16.0d);
        this.t = d.b.i0.t.d.c.c.a(this.f62182g);
        A();
    }

    public final void A() {
        this.o = m().findViewById(R.id.recom_live_divider);
        this.q = (TextView) m().findViewById(R.id.recom_live_title);
        this.p = m().findViewById(R.id.recom_live_bottom_divider);
        this.m = (AlaBannerRecyclerView) m().findViewById(R.id.recycle_view);
        this.m.setLayoutManager(new LinearLayoutManager(b(), 0, false));
        E();
        AlaBannerRecyclerAdapter alaBannerRecyclerAdapter = new AlaBannerRecyclerAdapter(b(), this.v, false);
        this.n = alaBannerRecyclerAdapter;
        this.m.setAdapter(alaBannerRecyclerAdapter);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: B */
    public void n(d.b.i0.t.d.c.e.c cVar) {
        d.b.i0.t.d.c.e.d dVar;
        if (cVar == null || (dVar = cVar.f60326e) == null) {
            return;
        }
        this.u = ListUtils.getCount(dVar.f60327a) == 1;
        E();
        this.n.setData(cVar.f60326e.f60327a);
        this.n.notifyDataSetChanged();
    }

    public final void E() {
        int y = y();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, y);
        } else {
            layoutParams.width = -1;
            layoutParams.height = y;
        }
        this.m.setLayoutParams(layoutParams);
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.tab_live_official_recom_live_item_view;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext tbPageContext, int i) {
        SkinManager.setBackgroundColor(this.o, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.p, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0105);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public final int y() {
        return this.u ? this.t[1] : this.s;
    }

    public final int z() {
        return this.u ? this.t[0] : this.r;
    }
}
