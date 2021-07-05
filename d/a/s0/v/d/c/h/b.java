package d.a.s0.v.d.c.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes9.dex */
public class b extends d.a.s0.a0.b<d.a.s0.v.d.c.e.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaBannerRecyclerView m;
    public AlaBannerRecyclerAdapter n;
    public View o;
    public View p;
    public TextView q;
    public int r;
    public int s;
    public int[] t;
    public boolean u;
    public d.a.s0.v.d.h.a.a v;

    /* loaded from: classes9.dex */
    public class a implements d.a.s0.v.d.h.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f67648a;

        /* renamed from: d.a.s0.v.d.c.h.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1801a extends AlaBannerViewHolder<SdkLiveInfoData> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public View f67649a;

            /* renamed from: b  reason: collision with root package name */
            public View f67650b;

            /* renamed from: c  reason: collision with root package name */
            public TabLiveStageLiveView f67651c;

            /* renamed from: d  reason: collision with root package name */
            public int f67652d;

            /* renamed from: e  reason: collision with root package name */
            public int f67653e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f67654f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1801a(a aVar, View view) {
                super(view);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, view};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((View) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f67654f = aVar;
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void b(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                    this.f67651c = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                    this.f67649a = view.findViewById(R.id.recom_live_item_left_space);
                    this.f67650b = view.findViewById(R.id.recom_live_item_right_space);
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void c(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                    this.f67651c.c();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            /* renamed from: d */
            public void a(int i2, SdkLiveInfoData sdkLiveInfoData) {
                String str;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048579, this, i2, sdkLiveInfoData) == null) {
                    this.f67651c.setData(sdkLiveInfoData, 102);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f67649a.getLayoutParams();
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f67650b.getLayoutParams();
                    if (i2 == 0) {
                        if (this.f67654f.f67648a.u) {
                            layoutParams.width = this.f67654f.f67648a.f57032f.getResources().getDimensionPixelSize(R.dimen.tbds44);
                            layoutParams2.width = this.f67654f.f67648a.f57032f.getResources().getDimensionPixelSize(R.dimen.tbds44);
                            this.f67650b.setVisibility(0);
                        } else {
                            layoutParams.width = this.f67654f.f67648a.f57032f.getResources().getDimensionPixelSize(R.dimen.tbds44);
                            this.f67650b.setVisibility(8);
                        }
                    } else {
                        layoutParams.width = this.f67654f.f67648a.f57032f.getResources().getDimensionPixelSize(R.dimen.tbds12);
                        if (this.f67654f.f67648a.n.getItemCount() - 1 == i2) {
                            this.f67650b.setVisibility(0);
                        } else {
                            this.f67650b.setVisibility(8);
                        }
                    }
                    this.f67649a.setLayoutParams(layoutParams);
                    this.f67650b.setLayoutParams(layoutParams2);
                    e();
                    StatisticItem statisticItem = new StatisticItem("c13558");
                    if (sdkLiveInfoData != null) {
                        SdkLiveInfoData.AlaLiveInfo alaLiveInfo = sdkLiveInfoData.liveInfo;
                        if (alaLiveInfo != null) {
                            int a2 = d.a.s0.v.d.c.c.a(alaLiveInfo);
                            SdkLiveInfoData.YYExt yYExt = sdkLiveInfoData.liveInfo.yyExt;
                            if (yYExt != null) {
                                TiebaStaticHelper.addYYParam(statisticItem, d.a.s0.v.d.c.c.k(yYExt));
                                str = TiebaStatic.YYValues.YY_LIVE;
                            } else {
                                str = "";
                            }
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, a2);
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str);
                        }
                        statisticItem.param("nid", sdkLiveInfoData.nid);
                        statisticItem.param(TiebaStatic.Params.LOGID, sdkLiveInfoData.logid);
                    }
                    statisticItem.param(TiebaStatic.Params.ENTRY_NAME, "推荐");
                    TiebaStatic.log(statisticItem);
                }
            }

            public final void e() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                    this.f67652d = this.f67654f.f67648a.x();
                    this.f67653e = this.f67654f.f67648a.w();
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f67651c.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.f67652d, this.f67653e);
                    } else {
                        layoutParams.width = this.f67652d;
                        layoutParams.height = this.f67653e;
                    }
                    layoutParams.gravity = 1;
                    this.f67651c.setLayoutParams(layoutParams);
                }
            }
        }

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67648a = bVar;
        }

        @Override // d.a.s0.v.d.h.a.a
        public AlaBannerViewHolder a(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i2)) == null) ? new C1801a(this, LayoutInflater.from(this.f67648a.b()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup, false)) : (AlaBannerViewHolder) invokeLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = false;
        this.v = new a(this);
        this.u = false;
        int k = (int) (l.k(b()) * 0.76d);
        this.r = k;
        this.s = (int) ((k * 9.0d) / 16.0d);
        this.t = d.a.s0.v.d.c.c.b(this.f57033g);
        y();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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
    }

    @Override // d.a.s0.a0.b
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.tab_live_official_recom_live_item_view : invokeV.intValue;
    }

    @Override // d.a.s0.a0.b
    public void n(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) {
            SkinManager.setBackgroundColor(this.o, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.p, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0105);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
        }
    }

    public final int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.u ? this.t[1] : this.s : invokeV.intValue;
    }

    public final int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.u ? this.t[0] : this.r : invokeV.intValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.a0.b
    /* renamed from: z */
    public void m(d.a.s0.v.d.c.e.c cVar) {
        d.a.s0.v.d.c.e.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) || cVar == null || (dVar = cVar.f67519e) == null) {
            return;
        }
        this.u = ListUtils.getCount(dVar.f67520a) == 1;
        A();
        this.n.setData(cVar.f67519e.f67520a);
        this.n.notifyDataSetChanged();
    }
}
