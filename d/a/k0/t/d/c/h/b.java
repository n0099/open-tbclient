package d.a.k0.t.d.c.h;

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
public class b extends d.a.k0.x.b<d.a.k0.t.d.c.e.c> {
    public AlaBannerRecyclerView m;
    public AlaBannerRecyclerAdapter n;
    public View o;
    public View p;
    public TextView q;
    public int r;
    public int s;
    public int[] t;
    public boolean u;
    public d.a.k0.t.d.h.a.a v;

    /* loaded from: classes4.dex */
    public class a implements d.a.k0.t.d.h.a.a {

        /* renamed from: d.a.k0.t.d.c.h.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1629a extends AlaBannerViewHolder<SdkLiveInfoData> {

            /* renamed from: a  reason: collision with root package name */
            public View f61341a;

            /* renamed from: b  reason: collision with root package name */
            public View f61342b;

            /* renamed from: c  reason: collision with root package name */
            public TabLiveStageLiveView f61343c;

            /* renamed from: d  reason: collision with root package name */
            public int f61344d;

            /* renamed from: e  reason: collision with root package name */
            public int f61345e;

            public C1629a(View view) {
                super(view);
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void b(View view) {
                this.f61343c = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                this.f61341a = view.findViewById(R.id.recom_live_item_left_space);
                this.f61342b = view.findViewById(R.id.recom_live_item_right_space);
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void c(int i2) {
                this.f61343c.c();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            /* renamed from: d */
            public void a(int i2, SdkLiveInfoData sdkLiveInfoData) {
                SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
                String str;
                this.f61343c.setData(sdkLiveInfoData, 102);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f61341a.getLayoutParams();
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f61342b.getLayoutParams();
                if (i2 == 0) {
                    if (b.this.u) {
                        layoutParams.width = b.this.f63161f.getResources().getDimensionPixelSize(R.dimen.tbds44);
                        layoutParams2.width = b.this.f63161f.getResources().getDimensionPixelSize(R.dimen.tbds44);
                        this.f61342b.setVisibility(0);
                    } else {
                        layoutParams.width = b.this.f63161f.getResources().getDimensionPixelSize(R.dimen.tbds44);
                        this.f61342b.setVisibility(8);
                    }
                } else {
                    layoutParams.width = b.this.f63161f.getResources().getDimensionPixelSize(R.dimen.tbds12);
                    if (b.this.n.getItemCount() - 1 == i2) {
                        this.f61342b.setVisibility(0);
                    } else {
                        this.f61342b.setVisibility(8);
                    }
                }
                this.f61341a.setLayoutParams(layoutParams);
                this.f61342b.setLayoutParams(layoutParams2);
                e();
                StatisticItem statisticItem = new StatisticItem("c13558");
                if (sdkLiveInfoData != null && (alaLiveInfo = sdkLiveInfoData.liveInfo) != null) {
                    int a2 = d.a.k0.t.d.c.c.a(alaLiveInfo);
                    SdkLiveInfoData.YYExt yYExt = sdkLiveInfoData.liveInfo.yyExt;
                    if (yYExt != null) {
                        TiebaStaticHelper.addYYParam(statisticItem, d.a.k0.t.d.c.c.k(yYExt));
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
                this.f61344d = b.this.x();
                this.f61345e = b.this.w();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f61343c.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.f61344d, this.f61345e);
                } else {
                    layoutParams.width = this.f61344d;
                    layoutParams.height = this.f61345e;
                }
                layoutParams.gravity = 1;
                this.f61343c.setLayoutParams(layoutParams);
            }
        }

        public a() {
        }

        @Override // d.a.k0.t.d.h.a.a
        public AlaBannerViewHolder a(ViewGroup viewGroup, int i2) {
            return new C1629a(LayoutInflater.from(b.this.b()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup, false));
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
        this.t = d.a.k0.t.d.c.c.b(this.f63162g);
        y();
    }

    public final void A() {
        int w = w();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, w);
        } else {
            layoutParams.width = -1;
            layoutParams.height = w;
        }
        this.m.setLayoutParams(layoutParams);
    }

    @Override // d.a.k0.x.b
    public int g() {
        return R.layout.tab_live_official_recom_live_item_view;
    }

    @Override // d.a.k0.x.b
    public void n(TbPageContext tbPageContext, int i2) {
        SkinManager.setBackgroundColor(this.o, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.p, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0105);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public final int w() {
        return this.u ? this.t[1] : this.s;
    }

    public final int x() {
        return this.u ? this.t[0] : this.r;
    }

    public final void y() {
        this.o = l().findViewById(R.id.recom_live_divider);
        this.q = (TextView) l().findViewById(R.id.recom_live_title);
        this.p = l().findViewById(R.id.recom_live_bottom_divider);
        this.m = (AlaBannerRecyclerView) l().findViewById(R.id.recycle_view);
        this.m.setLayoutManager(new LinearLayoutManager(b(), 0, false));
        A();
        AlaBannerRecyclerAdapter alaBannerRecyclerAdapter = new AlaBannerRecyclerAdapter(b(), this.v, false);
        this.n = alaBannerRecyclerAdapter;
        this.m.setAdapter(alaBannerRecyclerAdapter);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.x.b
    /* renamed from: z */
    public void m(d.a.k0.t.d.c.e.c cVar) {
        d.a.k0.t.d.c.e.d dVar;
        if (cVar == null || (dVar = cVar.f61212e) == null) {
            return;
        }
        this.u = ListUtils.getCount(dVar.f61213a) == 1;
        A();
        this.n.setData(cVar.f61212e.f61213a);
        this.n.notifyDataSetChanged();
    }
}
