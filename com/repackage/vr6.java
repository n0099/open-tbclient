package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.iy;
import com.repackage.mw;
import com.repackage.pw;
import com.repackage.xx;
/* loaded from: classes7.dex */
public class vr6 extends wm<zw5, ThreadCardViewHolder<zw5>> implements ci5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public String k;
    public boolean l;
    public pn m;
    public ag<ImageView> n;
    public ag<GifView> o;
    public nw5<zw5> p;

    /* loaded from: classes7.dex */
    public class a implements bg<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vr6 a;

        public a(vr6 vr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vr6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.bg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.bg
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        public ImageView e(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, imageView)) == null) {
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setTag(null);
                    if (am4.c().g()) {
                        tbImageView.setAdjustViewBounds(false);
                        tbImageView.setInterceptOnClick(false);
                    } else {
                        tbImageView.setDefaultResource(R.drawable.icon_click);
                        tbImageView.setAdjustViewBounds(true);
                        tbImageView.setInterceptOnClick(true);
                    }
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bg
        /* renamed from: f */
        public void b(ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, imageView) == null) {
                imageView.setBackgroundDrawable(null);
                imageView.setImageDrawable(null);
                imageView.setTag(null);
                imageView.setOnClickListener(null);
                if (imageView instanceof ForeDrawableImageView) {
                    ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                    foreDrawableImageView.O();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.j.getPageActivity());
                boolean g = am4.c().g();
                foreDrawableImageView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                if (g) {
                    foreDrawableImageView.setAdjustViewBounds(false);
                    foreDrawableImageView.setInterceptOnClick(false);
                } else {
                    foreDrawableImageView.setDefaultResource(R.drawable.icon_click);
                    foreDrawableImageView.setAdjustViewBounds(true);
                    foreDrawableImageView.setInterceptOnClick(true);
                }
                return foreDrawableImageView;
            }
            return (ImageView) invokeV.objValue;
        }

        public ImageView h(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, imageView)) == null) {
                imageView.setBackgroundDrawable(null);
                imageView.setImageDrawable(null);
                imageView.setTag(null);
                imageView.setOnClickListener(null);
                if (imageView instanceof ForeDrawableImageView) {
                    ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                    foreDrawableImageView.O();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    foreDrawableImageView.G();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements bg<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vr6 a;

        public b(vr6 vr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vr6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.bg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.bg
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        public GifView e(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gifView)) == null) {
                gifView.setTag(null);
                if (am4.c().g()) {
                    gifView.setAdjustViewBounds(false);
                    gifView.setInterceptOnClick(false);
                } else {
                    gifView.setDefaultResource(R.drawable.icon_click);
                    gifView.setAdjustViewBounds(true);
                    gifView.setInterceptOnClick(true);
                }
                return gifView;
            }
            return (GifView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bg
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                gifView.b0();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.j.getPageActivity());
                boolean g = am4.c().g();
                gifView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                if (g) {
                    gifView.setAdjustViewBounds(false);
                    gifView.setInterceptOnClick(false);
                } else {
                    gifView.setDefaultResource(R.drawable.icon_click);
                    gifView.setAdjustViewBounds(true);
                    gifView.setInterceptOnClick(true);
                }
                return gifView;
            }
            return (GifView) invokeV.objValue;
        }

        public GifView h(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gifView)) == null) {
                gifView.e0();
                gifView.b0();
                gifView.setImageDrawable(null);
                gifView.f0();
                gifView.setBackgroundDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                return gifView;
            }
            return (GifView) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends nw5<zw5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(vr6 vr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nw5
        /* renamed from: d */
        public void a(View view2, zw5 zw5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, zw5Var) == null) || view2 == null || zw5Var == null || zw5Var.getThreadData() == null || StringUtils.isNull(zw5Var.getThreadData().getTid())) {
                return;
            }
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f091f85 || id == R.id.obfuscated_res_0x7f091f99) {
                er6.b(view2, zw5Var, 2);
            } else if (id == R.id.obfuscated_res_0x7f091f87) {
                er6.b(view2, zw5Var, 6);
            } else if (id == R.id.obfuscated_res_0x7f092278 || id == R.id.obfuscated_res_0x7f092298) {
                er6.b(view2, zw5Var, 1);
            } else if (id == R.id.obfuscated_res_0x7f090c8b) {
                StatisticItem statisticItem = new StatisticItem("c13423");
                statisticItem.param("obj_locate", 4);
                if (zw5Var != null) {
                    statisticItem.param("tid", zw5Var.g);
                    ThreadData threadData = zw5Var.a;
                    if (threadData != null && threadData.getTopAgreePost() != null) {
                        statisticItem.param("pid", zw5Var.a.getTopAgreePost().I());
                    }
                }
                TiebaStatic.log(statisticItem);
            } else if (id == R.id.obfuscated_res_0x7f090c86) {
                StatisticItem statisticItem2 = new StatisticItem("c13423");
                statisticItem2.param("obj_locate", 2);
                if (zw5Var != null) {
                    statisticItem2.param("tid", zw5Var.g);
                    ThreadData threadData2 = zw5Var.a;
                    if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                        statisticItem2.param("pid", zw5Var.a.getTopAgreePost().I());
                    }
                }
                TiebaStatic.log(statisticItem2);
            } else if (id == R.id.obfuscated_res_0x7f090c89 || id == R.id.obfuscated_res_0x7f090c8a) {
                StatisticItem statisticItem3 = new StatisticItem("c13423");
                statisticItem3.param("obj_locate", 1);
                if (zw5Var != null) {
                    statisticItem3.param("tid", zw5Var.g);
                    ThreadData threadData3 = zw5Var.a;
                    if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                        statisticItem3.param("pid", zw5Var.a.getTopAgreePost().I());
                    }
                }
                TiebaStatic.log(statisticItem3);
            } else if (id == R.id.obfuscated_res_0x7f090c85) {
                StatisticItem statisticItem4 = new StatisticItem("c13423");
                statisticItem4.param("obj_locate", 5);
                if (zw5Var != null) {
                    statisticItem4.param("tid", zw5Var.g);
                    ThreadData threadData4 = zw5Var.a;
                    if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                        statisticItem4.param("pid", zw5Var.a.getTopAgreePost().I());
                    }
                }
                TiebaStatic.log(statisticItem4);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090a49) {
                er6.b(view2, zw5Var, 7);
            } else if (view2 instanceof TbImageView) {
                if (view2.getTag(R.id.obfuscated_res_0x7f090c87) instanceof Integer) {
                    StatisticItem statisticItem5 = new StatisticItem("c13423");
                    statisticItem5.param("obj_locate", 3);
                    if (zw5Var != null) {
                        statisticItem5.param("tid", zw5Var.g);
                        ThreadData threadData5 = zw5Var.a;
                        if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                            statisticItem5.param("pid", zw5Var.a.getTopAgreePost().I());
                        }
                    }
                    TiebaStatic.log(statisticItem5);
                    return;
                }
                er6.b(view2, zw5Var, 6);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements pw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vr6 a;

        public d(vr6 vr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vr6Var;
        }

        @Override // com.repackage.pw.b
        public void a(om4 om4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, om4Var, view2) == null) || om4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f092298) {
                om4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092278) {
                om4Var.objType = 4;
            } else {
                om4Var.objType = 1;
            }
            this.a.g0(view2, om4Var);
        }
    }

    /* loaded from: classes7.dex */
    public class e extends nw5<om4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vr6 b;

        public e(vr6 vr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vr6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nw5
        /* renamed from: d */
        public void a(View view2, om4 om4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, om4Var) == null) {
                this.b.g0(view2, om4Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements mw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ax a;
        public final /* synthetic */ vr6 b;

        public f(vr6 vr6Var, ax axVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vr6Var, axVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vr6Var;
            this.a = axVar;
        }

        @Override // com.repackage.mw.a
        public void a(om4 om4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, om4Var) == null) || om4Var == null || om4Var.getThreadData() == null || om4Var.getThreadData().originalThreadData == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(om4Var.getThreadData().originalThreadData, this.b.a, 1);
            er6.b(this.a.g(), om4Var, 6);
        }
    }

    /* loaded from: classes7.dex */
    public class g implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vr6 a;

        public g(vr6 vr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vr6Var;
        }

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (jnVar instanceof zw5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                zw5 zw5Var = (zw5) jnVar;
                zw5Var.f = 1;
                if (this.a.p != null) {
                    this.a.p.a(threadCardViewHolder.b(), zw5Var);
                }
                ThreadCardUtils.jumpToPB((om4) zw5Var, view2.getContext(), 1, false);
                threadCardViewHolder.c().o(new iy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vr6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = true;
        this.n = new ag<>(new a(this), 8, 0);
        this.o = new ag<>(new b(this), 20, 0);
        this.p = new c(this);
        this.j = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: d0 */
    public ThreadCardViewHolder<zw5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            xx.b bVar = new xx.b(this.j.getPageActivity());
            pw pwVar = new pw(this.j.getPageActivity());
            pwVar.t(this.i);
            pwVar.b(128);
            pwVar.c(1024);
            pwVar.s(new d(this));
            bVar.o(pwVar);
            sx sxVar = new sx(this.j);
            sxVar.n(Boolean.FALSE);
            sxVar.v(ImageViewerConfig.FROM_CONCERN);
            bVar.l().h(li.f(this.a, R.dimen.tbds28));
            sxVar.l(new e(this));
            bVar.n(sxVar);
            ax axVar = new ax(this.j.getPageActivity());
            axVar.x(ImageViewerConfig.FROM_CONCERN);
            axVar.z(1);
            axVar.C(this.n, this.o);
            axVar.y(this.l);
            axVar.n(Boolean.TRUE);
            axVar.v(R.color.CAM_X0206);
            axVar.E(HomeGroupUbsUIHelper.getTransmitLRMarginByUbs(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), HomeGroupUbsUIHelper.getTransmitLRMarginByUbs(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
            axVar.A(new f(this, axVar));
            bVar.h(axVar);
            bVar.h(new by(this.j.getPageActivity()));
            bVar.h(new ww(this.j.getPageActivity()));
            zx zxVar = new zx(this.j.getPageActivity());
            um4 um4Var = new um4();
            um4Var.b = 9;
            um4Var.h = 9;
            zxVar.v(um4Var);
            zxVar.x(9);
            zxVar.C(4);
            zxVar.y(1);
            zxVar.b(32);
            zxVar.w(false);
            bVar.m(zxVar);
            xx k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.m);
            k.r(1);
            ThreadCardViewHolder<zw5> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.i);
            V(new g(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: e0 */
    public View S(int i, View view2, ViewGroup viewGroup, zw5 zw5Var, ThreadCardViewHolder<zw5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, zw5Var, threadCardViewHolder})) == null) {
            if (zw5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || zw5Var.a == null) {
                return null;
            }
            zw5Var.I(zw5Var.position + 1);
            threadCardViewHolder.c().q(i);
            gw5.b().a(zw5Var.g("c12351"));
            threadCardViewHolder.c().b(this.k);
            threadCardViewHolder.v(true, Align.ALIGN_RIGHT_TOP);
            threadCardViewHolder.l();
            threadCardViewHolder.g(zw5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.p);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void f0(pn pnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pnVar) == null) {
            this.m = pnVar;
        }
    }

    @Override // com.repackage.ci5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.k = str;
        }
    }

    public final void g0(View view2, om4 om4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, view2, om4Var) == null) || view2 == null || om4Var == null || view2.getId() == -1) {
            return;
        }
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f092298 || id == R.id.obfuscated_res_0x7f092278) {
            er6.b(view2, om4Var, 1);
        } else if (id == R.id.obfuscated_res_0x7f091f86 || id == R.id.obfuscated_res_0x7f091f78 || id == R.id.obfuscated_res_0x7f091f85) {
            er6.b(view2, om4Var, 2);
        }
    }
}
