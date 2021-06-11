package d.a.n0.v.d.c.h;

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
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.view.TabLiveStageLiveView;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerRecyclerAdapter;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerRecyclerView;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class b extends d.a.n0.z.b<d.a.n0.v.d.c.e.c> {
    public AlaBannerRecyclerView m;
    public AlaBannerRecyclerAdapter n;
    public View o;
    public View p;
    public TextView q;
    public int r;
    public int s;
    public int[] t;
    public boolean u;
    public d.a.n0.v.d.h.a.a v;

    /* loaded from: classes4.dex */
    public class a implements d.a.n0.v.d.h.a.a {

        /* renamed from: d.a.n0.v.d.c.h.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1706a extends AlaBannerViewHolder<SdkLiveInfoData> {

            /* renamed from: a  reason: collision with root package name */
            public View f65343a;

            /* renamed from: b  reason: collision with root package name */
            public View f65344b;

            /* renamed from: c  reason: collision with root package name */
            public TabLiveStageLiveView f65345c;

            /* renamed from: d  reason: collision with root package name */
            public int f65346d;

            /* renamed from: e  reason: collision with root package name */
            public int f65347e;

            public C1706a(View view) {
                super(view);
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void b(View view) {
                this.f65345c = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                this.f65343a = view.findViewById(R.id.recom_live_item_left_space);
                this.f65344b = view.findViewById(R.id.recom_live_item_right_space);
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void c(int i2) {
                this.f65345c.c();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            /* renamed from: d */
            public void a(int i2, SdkLiveInfoData sdkLiveInfoData) {
                SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
                String str;
                this.f65345c.setData(sdkLiveInfoData, 102);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f65343a.getLayoutParams();
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f65344b.getLayoutParams();
                if (i2 == 0) {
                    if (b.this.u) {
                        layoutParams.width = b.this.f67159f.getResources().getDimensionPixelSize(R.dimen.tbds44);
                        layoutParams2.width = b.this.f67159f.getResources().getDimensionPixelSize(R.dimen.tbds44);
                        this.f65344b.setVisibility(0);
                    } else {
                        layoutParams.width = b.this.f67159f.getResources().getDimensionPixelSize(R.dimen.tbds44);
                        this.f65344b.setVisibility(8);
                    }
                } else {
                    layoutParams.width = b.this.f67159f.getResources().getDimensionPixelSize(R.dimen.tbds12);
                    if (b.this.n.getItemCount() - 1 == i2) {
                        this.f65344b.setVisibility(0);
                    } else {
                        this.f65344b.setVisibility(8);
                    }
                }
                this.f65343a.setLayoutParams(layoutParams);
                this.f65344b.setLayoutParams(layoutParams2);
                e();
                StatisticItem statisticItem = new StatisticItem("c13558");
                if (sdkLiveInfoData != null && (alaLiveInfo = sdkLiveInfoData.liveInfo) != null) {
                    int a2 = d.a.n0.v.d.c.c.a(alaLiveInfo);
                    SdkLiveInfoData.YYExt yYExt = sdkLiveInfoData.liveInfo.yyExt;
                    if (yYExt != null) {
                        TiebaStaticHelper.addYYParam(statisticItem, d.a.n0.v.d.c.c.k(yYExt));
                        str = TiebaStatic.YYValues.YY_LIVE;
                    } else {
                        str = "";
                    }
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, a2);
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str);
                }
                statisticItem.param(TiebaStatic.Params.ENTRY_NAME, "推荐");
                TiebaStatic.log(statisticItem);
            }

            public final void e() {
                this.f65346d = b.this.y();
                this.f65347e = b.this.x();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f65345c.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.f65346d, this.f65347e);
                } else {
                    layoutParams.width = this.f65346d;
                    layoutParams.height = this.f65347e;
                }
                layoutParams.gravity = 1;
                this.f65345c.setLayoutParams(layoutParams);
            }
        }

        public a() {
        }

        @Override // d.a.n0.v.d.h.a.a
        public AlaBannerViewHolder a(ViewGroup viewGroup, int i2) {
            return new C1706a(LayoutInflater.from(b.this.b()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup, false));
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
        this.t = d.a.n0.v.d.c.c.b(this.f67160g);
        z();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: A */
    public void n(d.a.n0.v.d.c.e.c cVar) {
        d.a.n0.v.d.c.e.d dVar;
        if (cVar == null || (dVar = cVar.f65213e) == null) {
            return;
        }
        this.u = ListUtils.getCount(dVar.f65214a) == 1;
        B();
        this.n.setData(cVar.f65213e.f65214a);
        this.n.notifyDataSetChanged();
    }

    public final void B() {
        int x = x();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, x);
        } else {
            layoutParams.width = -1;
            layoutParams.height = x;
        }
        this.m.setLayoutParams(layoutParams);
    }

    @Override // d.a.n0.z.b
    public int h() {
        return R.layout.tab_live_official_recom_live_item_view;
    }

    @Override // d.a.n0.z.b
    public void o(TbPageContext tbPageContext, int i2) {
        SkinManager.setBackgroundColor(this.o, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.p, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0105);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public final int x() {
        return this.u ? this.t[1] : this.s;
    }

    public final int y() {
        return this.u ? this.t[0] : this.r;
    }

    public final void z() {
        this.o = m().findViewById(R.id.recom_live_divider);
        this.q = (TextView) m().findViewById(R.id.recom_live_title);
        this.p = m().findViewById(R.id.recom_live_bottom_divider);
        this.m = (AlaBannerRecyclerView) m().findViewById(R.id.recycle_view);
        this.m.setLayoutManager(new LinearLayoutManager(b(), 0, false));
        B();
        AlaBannerRecyclerAdapter alaBannerRecyclerAdapter = new AlaBannerRecyclerAdapter(b(), this.v, false);
        this.n = alaBannerRecyclerAdapter;
        this.m.setAdapter(alaBannerRecyclerAdapter);
    }
}
