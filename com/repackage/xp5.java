package com.repackage;

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
/* loaded from: classes7.dex */
public class xp5 extends tw5<oo5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaBannerRecyclerView i;
    public AlaBannerRecyclerAdapter j;
    public View k;
    public View l;
    public TextView m;
    public int n;
    public int o;
    public int[] p;
    public boolean q;
    public wr5 r;

    /* loaded from: classes7.dex */
    public class a implements wr5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xp5 a;

        /* renamed from: com.repackage.xp5$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0552a extends AlaBannerViewHolder<SdkLiveInfoData> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public View a;
            public View b;
            public TabLiveStageLiveView c;
            public int d;
            public int e;
            public final /* synthetic */ a f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0552a(a aVar, View view2) {
                super(view2);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, view2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((View) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = aVar;
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void b(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                    this.c = (TabLiveStageLiveView) view2.findViewById(R.id.obfuscated_res_0x7f091d7e);
                    this.a = view2.findViewById(R.id.obfuscated_res_0x7f0919d8);
                    this.b = view2.findViewById(R.id.obfuscated_res_0x7f0919d9);
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void c(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                    this.c.c();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            /* renamed from: d */
            public void a(int i, SdkLiveInfoData sdkLiveInfoData) {
                String str;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048579, this, i, sdkLiveInfoData) == null) {
                    this.c.setData(sdkLiveInfoData, 102);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.getLayoutParams();
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.b.getLayoutParams();
                    if (i == 0) {
                        if (this.f.a.q) {
                            layoutParams.width = this.f.a.b.getResources().getDimensionPixelSize(R.dimen.tbds44);
                            layoutParams2.width = this.f.a.b.getResources().getDimensionPixelSize(R.dimen.tbds44);
                            this.b.setVisibility(0);
                        } else {
                            layoutParams.width = this.f.a.b.getResources().getDimensionPixelSize(R.dimen.tbds44);
                            this.b.setVisibility(8);
                        }
                    } else {
                        layoutParams.width = this.f.a.b.getResources().getDimensionPixelSize(R.dimen.tbds12);
                        if (this.f.a.j.getItemCount() - 1 == i) {
                            this.b.setVisibility(0);
                        } else {
                            this.b.setVisibility(8);
                        }
                    }
                    this.a.setLayoutParams(layoutParams);
                    this.b.setLayoutParams(layoutParams2);
                    e();
                    StatisticItem statisticItem = new StatisticItem("c13558");
                    if (sdkLiveInfoData != null) {
                        SdkLiveInfoData.AlaLiveInfo alaLiveInfo = sdkLiveInfoData.liveInfo;
                        if (alaLiveInfo != null) {
                            int a = ho5.a(alaLiveInfo);
                            SdkLiveInfoData.YYExt yYExt = sdkLiveInfoData.liveInfo.yyExt;
                            if (yYExt != null) {
                                TiebaStaticHelper.addYYParam(statisticItem, ho5.k(yYExt, sdkLiveInfoData.roomId));
                                str = TiebaStatic.YYValues.YY_LIVE;
                            } else {
                                str = "";
                            }
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, a);
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
                    this.d = this.f.a.x();
                    this.e = this.f.a.w();
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.d, this.e);
                    } else {
                        layoutParams.width = this.d;
                        layoutParams.height = this.e;
                    }
                    layoutParams.gravity = 1;
                    this.c.setLayoutParams(layoutParams);
                }
            }
        }

        public a(xp5 xp5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xp5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xp5Var;
        }

        @Override // com.repackage.wr5
        public AlaBannerViewHolder a(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i)) == null) ? new C0552a(this, LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d07ed, viewGroup, false)) : (AlaBannerViewHolder) invokeLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xp5(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = false;
        this.r = new a(this);
        this.q = false;
        int k = (int) (oi.k(getContext()) * 0.76d);
        this.n = k;
        this.o = (int) ((k * 9.0d) / 16.0d);
        this.p = ho5.b(this.c);
        y();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int w = w();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, w);
            } else {
                layoutParams.width = -1;
                layoutParams.height = w;
            }
            this.i.setLayoutParams(layoutParams);
        }
    }

    @Override // com.repackage.tw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.obfuscated_res_0x7f0d07ec : invokeV.intValue;
    }

    @Override // com.repackage.tw5
    public void m(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0105);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
        }
    }

    public final int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.q ? this.p[1] : this.o : invokeV.intValue;
    }

    public final int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.q ? this.p[0] : this.n : invokeV.intValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.k = k().findViewById(R.id.obfuscated_res_0x7f0919d7);
            this.m = (TextView) k().findViewById(R.id.obfuscated_res_0x7f0919da);
            this.l = k().findViewById(R.id.obfuscated_res_0x7f0919d6);
            this.i = (AlaBannerRecyclerView) k().findViewById(R.id.obfuscated_res_0x7f091a15);
            this.i.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            A();
            AlaBannerRecyclerAdapter alaBannerRecyclerAdapter = new AlaBannerRecyclerAdapter(getContext(), this.r, false);
            this.j = alaBannerRecyclerAdapter;
            this.i.setAdapter(alaBannerRecyclerAdapter);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.tw5
    /* renamed from: z */
    public void l(oo5 oo5Var) {
        po5 po5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, oo5Var) == null) || oo5Var == null || (po5Var = oo5Var.a) == null) {
            return;
        }
        this.q = ListUtils.getCount(po5Var.a) == 1;
        A();
        this.j.setData(oo5Var.a.a);
        this.j.notifyDataSetChanged();
    }
}
