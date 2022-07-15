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
import com.repackage.cy;
import com.repackage.ny;
import com.repackage.qw;
import com.repackage.tw;
/* loaded from: classes6.dex */
public class nt6 extends an<vy5, ThreadCardViewHolder<vy5>> implements ck5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public String k;
    public boolean l;
    public tn m;
    public eg<ImageView> n;
    public eg<GifView> o;
    public jy5<vy5> p;

    /* loaded from: classes6.dex */
    public class a implements fg<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nt6 a;

        public a(nt6 nt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nt6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.fg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.fg
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
                    if (zm4.c().g()) {
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
        @Override // com.repackage.fg
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
        @Override // com.repackage.fg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.j.getPageActivity());
                boolean g = zm4.c().g();
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
                    foreDrawableImageView.F();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements fg<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nt6 a;

        public b(nt6 nt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nt6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.fg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.fg
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
                if (zm4.c().g()) {
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
        @Override // com.repackage.fg
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
        @Override // com.repackage.fg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.j.getPageActivity());
                boolean g = zm4.c().g();
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

    /* loaded from: classes6.dex */
    public class c extends jy5<vy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(nt6 nt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt6Var};
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
        @Override // com.repackage.jy5
        /* renamed from: d */
        public void a(View view2, vy5 vy5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, vy5Var) == null) || view2 == null || vy5Var == null || vy5Var.getThreadData() == null || StringUtils.isNull(vy5Var.getThreadData().getTid())) {
                return;
            }
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f09202a || id == R.id.obfuscated_res_0x7f09203e) {
                vs6.b(view2, vy5Var, 2);
            } else if (id == R.id.obfuscated_res_0x7f09202c) {
                vs6.b(view2, vy5Var, 6);
            } else if (id == R.id.obfuscated_res_0x7f09230c || id == R.id.obfuscated_res_0x7f09232d) {
                vs6.b(view2, vy5Var, 1);
            } else if (id == R.id.obfuscated_res_0x7f090c84) {
                StatisticItem statisticItem = new StatisticItem("c13423");
                statisticItem.param("obj_locate", 4);
                if (vy5Var != null) {
                    statisticItem.param("tid", vy5Var.g);
                    ThreadData threadData = vy5Var.a;
                    if (threadData != null && threadData.getTopAgreePost() != null) {
                        statisticItem.param("pid", vy5Var.a.getTopAgreePost().J());
                    }
                }
                TiebaStatic.log(statisticItem);
            } else if (id == R.id.obfuscated_res_0x7f090c7f) {
                StatisticItem statisticItem2 = new StatisticItem("c13423");
                statisticItem2.param("obj_locate", 2);
                if (vy5Var != null) {
                    statisticItem2.param("tid", vy5Var.g);
                    ThreadData threadData2 = vy5Var.a;
                    if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                        statisticItem2.param("pid", vy5Var.a.getTopAgreePost().J());
                    }
                }
                TiebaStatic.log(statisticItem2);
            } else if (id == R.id.obfuscated_res_0x7f090c82 || id == R.id.obfuscated_res_0x7f090c83) {
                StatisticItem statisticItem3 = new StatisticItem("c13423");
                statisticItem3.param("obj_locate", 1);
                if (vy5Var != null) {
                    statisticItem3.param("tid", vy5Var.g);
                    ThreadData threadData3 = vy5Var.a;
                    if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                        statisticItem3.param("pid", vy5Var.a.getTopAgreePost().J());
                    }
                }
                TiebaStatic.log(statisticItem3);
            } else if (id == R.id.obfuscated_res_0x7f090c7e) {
                StatisticItem statisticItem4 = new StatisticItem("c13423");
                statisticItem4.param("obj_locate", 5);
                if (vy5Var != null) {
                    statisticItem4.param("tid", vy5Var.g);
                    ThreadData threadData4 = vy5Var.a;
                    if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                        statisticItem4.param("pid", vy5Var.a.getTopAgreePost().J());
                    }
                }
                TiebaStatic.log(statisticItem4);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090a40) {
                vs6.b(view2, vy5Var, 7);
            } else if (view2 instanceof TbImageView) {
                if (view2.getTag(R.id.obfuscated_res_0x7f090c80) instanceof Integer) {
                    StatisticItem statisticItem5 = new StatisticItem("c13423");
                    statisticItem5.param("obj_locate", 3);
                    if (vy5Var != null) {
                        statisticItem5.param("tid", vy5Var.g);
                        ThreadData threadData5 = vy5Var.a;
                        if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                            statisticItem5.param("pid", vy5Var.a.getTopAgreePost().J());
                        }
                    }
                    TiebaStatic.log(statisticItem5);
                    return;
                }
                vs6.b(view2, vy5Var, 6);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements tw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nt6 a;

        public d(nt6 nt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nt6Var;
        }

        @Override // com.repackage.tw.b
        public void a(nn4 nn4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, nn4Var, view2) == null) || nn4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09232d) {
                nn4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09230c) {
                nn4Var.objType = 4;
            } else {
                nn4Var.objType = 1;
            }
            this.a.g0(view2, nn4Var);
        }
    }

    /* loaded from: classes6.dex */
    public class e extends jy5<nn4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nt6 b;

        public e(nt6 nt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nt6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jy5
        /* renamed from: d */
        public void a(View view2, nn4 nn4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, nn4Var) == null) {
                this.b.g0(view2, nn4Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements qw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fx a;
        public final /* synthetic */ nt6 b;

        public f(nt6 nt6Var, fx fxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt6Var, fxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nt6Var;
            this.a = fxVar;
        }

        @Override // com.repackage.qw.a
        public void a(nn4 nn4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nn4Var) == null) || nn4Var == null || nn4Var.getThreadData() == null || nn4Var.getThreadData().originalThreadData == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(nn4Var.getThreadData().originalThreadData, this.b.a, 1);
            vs6.b(this.a.h(), nn4Var, 6);
        }
    }

    /* loaded from: classes6.dex */
    public class g implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nt6 a;

        public g(nt6 nt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nt6Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof vy5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                vy5 vy5Var = (vy5) nnVar;
                vy5Var.f = 1;
                if (this.a.p != null) {
                    this.a.p.a(threadCardViewHolder.b(), vy5Var);
                }
                ThreadCardUtils.jumpToPB((nn4) vy5Var, view2.getContext(), 1, false);
                threadCardViewHolder.c().o(new ny.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nt6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.n = new eg<>(new a(this), 8, 0);
        this.o = new eg<>(new b(this), 20, 0);
        this.p = new c(this);
        this.j = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: d0 */
    public ThreadCardViewHolder<vy5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.j.getPageActivity());
            tw twVar = new tw(this.j.getPageActivity());
            twVar.u(this.i);
            twVar.c(128);
            twVar.d(1024);
            twVar.t(new d(this));
            bVar.o(twVar);
            xx xxVar = new xx(this.j);
            xxVar.o(Boolean.FALSE);
            xxVar.w(ImageViewerConfig.FROM_CONCERN);
            bVar.l().h(pi.f(this.a, R.dimen.tbds28));
            xxVar.m(new e(this));
            bVar.n(xxVar);
            fx fxVar = new fx(this.j.getPageActivity());
            fxVar.y(ImageViewerConfig.FROM_CONCERN);
            fxVar.A(1);
            fxVar.D(this.n, this.o);
            fxVar.z(this.l);
            fxVar.o(Boolean.TRUE);
            fxVar.w(R.color.CAM_X0206);
            fxVar.F(HomeGroupUbsUIHelper.getTransmitLRMarginByUbs(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), HomeGroupUbsUIHelper.getTransmitLRMarginByUbs(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
            fxVar.B(new f(this, fxVar));
            bVar.h(fxVar);
            bVar.h(new gy(this.j.getPageActivity()));
            bVar.h(new ax(this.j.getPageActivity()));
            ey eyVar = new ey(this.j.getPageActivity());
            tn4 tn4Var = new tn4();
            tn4Var.b = 9;
            tn4Var.h = 9;
            eyVar.w(tn4Var);
            eyVar.y(9);
            eyVar.D(4);
            eyVar.z(1);
            eyVar.c(32);
            eyVar.x(false);
            bVar.m(eyVar);
            cy k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.m);
            k.r(1);
            ThreadCardViewHolder<vy5> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.i);
            V(new g(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: e0 */
    public View S(int i, View view2, ViewGroup viewGroup, vy5 vy5Var, ThreadCardViewHolder<vy5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, vy5Var, threadCardViewHolder})) == null) {
            if (vy5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || vy5Var.a == null) {
                return null;
            }
            vy5Var.I(vy5Var.position + 1);
            threadCardViewHolder.c().q(i);
            cy5.b().a(vy5Var.d("c12351"));
            threadCardViewHolder.c().b(this.k);
            threadCardViewHolder.u(true, Align.ALIGN_RIGHT_TOP);
            threadCardViewHolder.l();
            threadCardViewHolder.g(vy5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.p);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void f0(tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tnVar) == null) {
            this.m = tnVar;
        }
    }

    @Override // com.repackage.ck5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.k = str;
        }
    }

    public final void g0(View view2, nn4 nn4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, view2, nn4Var) == null) || view2 == null || nn4Var == null || view2.getId() == -1) {
            return;
        }
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f09232d || id == R.id.obfuscated_res_0x7f09230c) {
            vs6.b(view2, nn4Var, 1);
        } else if (id == R.id.obfuscated_res_0x7f09202b || id == R.id.obfuscated_res_0x7f09201d || id == R.id.obfuscated_res_0x7f09202a) {
            vs6.b(view2, nn4Var, 2);
        }
    }
}
