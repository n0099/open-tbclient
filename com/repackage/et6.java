package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
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
import com.repackage.kz;
import com.repackage.vz;
/* loaded from: classes6.dex */
public class et6 extends eo<yx5, ThreadCardViewHolder<yx5>> implements ij5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public String k;
    public xo l;
    public boolean m;
    public bg<ImageView> n;
    public bg<GifView> o;
    public ux5<yx5> p;

    /* loaded from: classes6.dex */
    public class a implements cg<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ et6 a;

        public a(et6 et6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {et6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = et6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.cg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.cg
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
                    if (ln4.c().g()) {
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
        @Override // com.repackage.cg
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
        @Override // com.repackage.cg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.j.getPageActivity());
                boolean g = ln4.c().g();
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

    /* loaded from: classes6.dex */
    public class b implements cg<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ et6 a;

        public b(et6 et6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {et6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = et6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.cg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.cg
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
                if (ln4.c().g()) {
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
        @Override // com.repackage.cg
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
        @Override // com.repackage.cg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.j.getPageActivity());
                boolean g = ln4.c().g();
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
    public class c extends ux5<yx5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ et6 b;

        public c(et6 et6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {et6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = et6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ux5
        /* renamed from: d */
        public void a(View view2, yx5 yx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, yx5Var) == null) {
                this.b.n0(view2, yx5Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements cy.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(et6 et6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {et6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.cy.b
        public void a(zn4 zn4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, zn4Var, view2) == null) || zn4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f0922f3) {
                zn4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0922d3) {
                zn4Var.objType = 4;
            } else {
                zn4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements bp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ et6 a;

        public e(et6 et6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {et6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = et6Var;
        }

        @Override // com.repackage.bp
        public void b(View view2, ro roVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, roVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (roVar instanceof ko) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ko koVar = (ko) roVar;
                if (koVar.e() instanceof yx5) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    yx5 yx5Var = (yx5) koVar.e();
                    yx5Var.f = 1;
                    if (this.a.p != null) {
                        this.a.p.a(threadCardViewHolder.b(), yx5Var);
                    }
                    if (hz6.a(this.a.j, koVar.e())) {
                        return;
                    }
                    ThreadCardUtils.jumpToPB((zn4) yx5Var, view2.getContext(), 1, false, dy.a((xo) viewGroup, view2, i));
                    threadCardViewHolder.c().o(new vz.a(1));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements bp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ et6 a;

        public f(et6 et6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {et6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = et6Var;
        }

        @Override // com.repackage.bp
        public void b(View view2, ro roVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, roVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (roVar instanceof ko) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ko koVar = (ko) roVar;
                if (koVar.e() instanceof yx5) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    yx5 yx5Var = (yx5) koVar.e();
                    yx5Var.f = 1;
                    if (this.a.p != null) {
                        this.a.p.a(threadCardViewHolder.b(), yx5Var);
                    }
                    ThreadCardUtils.jumpToPB((zn4) yx5Var, view2.getContext(), 1, false);
                    threadCardViewHolder.c().o(new vz.a(1));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements bp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ry a;
        public final /* synthetic */ et6 b;

        public g(et6 et6Var, ry ryVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {et6Var, ryVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = et6Var;
            this.a = ryVar;
        }

        @Override // com.repackage.bp
        public void b(View view2, ro roVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            yx5 yx5Var;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, roVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                boolean z = roVar instanceof ko;
                if (z) {
                    ko koVar = (ko) roVar;
                    if ((koVar.e() instanceof yx5) && roVar != null && koVar.e() != null && (yx5Var = (yx5) koVar.e()) != null && (threadData = yx5Var.a) != null && yx5Var.u && threadData.getItem() != null) {
                        if (yx5Var.a.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                            BdToast.i(this.b.j.getContext(), this.b.j.getString(R.string.obfuscated_res_0x7f0f1503), R.drawable.obfuscated_res_0x7f0809be, true).q();
                            return;
                        }
                        int a = hv4.a(yx5Var.a.getItem().button_link_type.intValue(), yx5Var.a.getItem().apk_detail != null ? yx5Var.a.getItem().apk_detail.pkg_source.intValue() : 0);
                        ItemData itemData = new ItemData();
                        itemData.parseProto(yx5Var.a.getItem());
                        ItemCardHelper.q(this.a.u(), yx5Var.a.getItem().item_id.longValue(), this.a.t(itemData), yx5Var.a.getTid(), a, "", 2);
                        ItemClickJumpUtil.itemClickJump(yx5Var.a.getItem().forum_name, String.valueOf(yx5Var.a.getItem().item_id), 2, 2);
                        return;
                    }
                }
                if (z && (view2.getTag() instanceof ThreadCardViewHolder)) {
                    ko koVar2 = (ko) roVar;
                    if (koVar2.e() instanceof yx5) {
                        ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                        yx5 yx5Var2 = (yx5) koVar2.e();
                        yx5Var2.f = 1;
                        if (this.b.p != null) {
                            this.b.p.a(threadCardViewHolder.b(), yx5Var2);
                        }
                        ThreadCardUtils.jumpToPB((zn4) yx5Var2, view2.getContext(), 1, false, dy.a((xo) viewGroup, view2, i));
                        threadCardViewHolder.c().o(new vz.a(1));
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements bp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ et6 a;

        public h(et6 et6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {et6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = et6Var;
        }

        @Override // com.repackage.bp
        public void b(View view2, ro roVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, roVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (roVar instanceof ko) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ko koVar = (ko) roVar;
                if (koVar.e() instanceof yx5) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    yx5 yx5Var = (yx5) koVar.e();
                    yx5Var.f = 1;
                    if (this.a.p != null) {
                        this.a.p.a(threadCardViewHolder.b(), yx5Var);
                    }
                    ThreadCardUtils.jumpToPB((zn4) yx5Var, view2.getContext(), 1, false, dy.a((xo) viewGroup, view2, i));
                    threadCardViewHolder.c().o(new vz.a(1));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements ThreadCommentAndPraiseInfoLayout.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        public i(et6 et6Var, ViewGroup viewGroup, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {et6Var, viewGroup, view2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = viewGroup;
            this.b = view2;
            this.c = i;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(dy.a((xo) this.a, this.b, this.c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public et6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = true;
        this.n = new bg<>(new a(this), 12, 0);
        this.o = new bg<>(new b(this), 20, 0);
        this.p = new c(this);
        this.j = tbPageContext;
        c0();
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            gy5.R = "c10705";
            gy5.S = "c10730";
            gy5.T = "c10731";
            gy5.U = "c10704";
            gy5.V = "c10755";
            gy5.W = "c10710";
            gy5.X = "c10736";
            gy5.Y = "c10737";
            gy5.Z = "c10711";
            gy5.g0 = "c10758";
            gy5.h0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: d0 */
    public ThreadCardViewHolder<yx5> I(ViewGroup viewGroup, yx5 yx5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, viewGroup, yx5Var)) == null) {
            kz.b bVar = new kz.b(this.j.getPageActivity(), false);
            mz mzVar = new mz(this.j.getPageActivity());
            fo4 fo4Var = new fo4();
            fo4Var.b = 9;
            fo4Var.h = 9;
            mzVar.v(fo4Var);
            mzVar.x(9);
            mzVar.D("personalize_page");
            mzVar.C(4);
            mzVar.y(1);
            mzVar.b(32);
            mzVar.w(false);
            bVar.m(mzVar);
            kz k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.l);
            k.r(1);
            ThreadCardViewHolder<yx5> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.i);
            V(new h(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: e0 */
    public ThreadCardViewHolder<yx5> J(ViewGroup viewGroup, yx5 yx5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, viewGroup, yx5Var)) == null) {
            kz.b bVar = new kz.b(this.j.getPageActivity(), false);
            if (yx5Var.o) {
                ny nyVar = new ny(this.j.getPageActivity());
                nyVar.C(this.n, this.o);
                nyVar.x(ImageViewerConfig.FROM_CONCERN);
                nyVar.z(1);
                nyVar.y(this.m);
                nyVar.w(1);
                bVar.n(nyVar);
            } else if (yx5Var.p) {
                xy xyVar = new xy(this.j.getPageActivity());
                xyVar.q(ImageViewerConfig.FROM_CONCERN);
                xyVar.r(this.m);
                bVar.n(xyVar);
            } else if (yx5Var.q) {
                uy uyVar = new uy(this.j.getPageActivity());
                uyVar.s(ImageViewerConfig.FROM_CONCERN);
                uyVar.t(this.m);
                bVar.n(uyVar);
            } else if (yx5Var.r) {
                yy yyVar = new yy(this.j.getPageActivity());
                yyVar.r(ImageViewerConfig.FROM_CONCERN);
                yyVar.s(this.m);
                bVar.n(yyVar);
            } else {
                boolean z = yx5Var.s;
            }
            kz k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.l);
            k.r(1);
            ThreadCardViewHolder<yx5> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.i);
            V(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: f0 */
    public ThreadCardViewHolder<yx5> K(ViewGroup viewGroup, yx5 yx5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, viewGroup, yx5Var)) == null) {
            kz.b bVar = new kz.b(this.j.getPageActivity(), false);
            ry ryVar = new ry(this.j.getPageActivity());
            ryVar.z(2);
            ryVar.s();
            ryVar.w(true);
            bVar.h(ryVar);
            bVar.h(new gz(this.j.getPageActivity()));
            bVar.h(new zy(this.j.getPageActivity()));
            jy jyVar = new jy(this.j.getPageActivity());
            jyVar.t();
            bVar.h(jyVar);
            my myVar = new my(this.j.getPageActivity());
            myVar.x(this.m);
            myVar.w(ImageViewerConfig.FROM_CONCERN);
            bVar.h(myVar);
            kz k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.l);
            k.r(1);
            ThreadCardViewHolder<yx5> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.i);
            V(new g(this, ryVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    @Override // com.repackage.ij5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.k = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: g0 */
    public ThreadCardViewHolder<yx5> L(ViewGroup viewGroup, yx5 yx5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, viewGroup, yx5Var)) == null) {
            if (yx5Var == null) {
                return null;
            }
            kz.b bVar = new kz.b(this.j.getPageActivity());
            if (yx5Var.m) {
                cy cyVar = new cy(this.j.getPageActivity());
                cyVar.t(this.i);
                cyVar.b(128);
                cyVar.c(1024);
                cyVar.s(new d(this));
                bVar.o(cyVar);
            } else if (yx5Var.n) {
                bVar.o(new ly(this.j.getPageActivity()));
            }
            kz k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.l);
            k.r(1);
            ThreadCardViewHolder<yx5> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.i);
            V(new e(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: h0 */
    public ThreadCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, viewGroup)) == null) {
            return null;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: i0 */
    public View O(int i2, View view2, ViewGroup viewGroup, yx5 yx5Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, yx5Var, threadCardViewHolder})) == null) {
            if (yx5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || yx5Var.a == null) {
                return null;
            }
            yx5Var.I(yx5Var.position + 1);
            threadCardViewHolder.c().q(i2);
            if (threadCardViewHolder.c().f() instanceof mz) {
                ((mz) threadCardViewHolder.c().f()).B(new i(this, viewGroup, view2, i2));
            }
            if (threadCardViewHolder.c() instanceof hj5) {
                threadCardViewHolder.c().b(this.k);
            }
            threadCardViewHolder.v(false, Align.ALIGN_RIGHT_BOTTOM);
            threadCardViewHolder.g(yx5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.p);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: j0 */
    public View P(int i2, View view2, ViewGroup viewGroup, yx5 yx5Var, ThreadCardViewHolder<yx5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, yx5Var, threadCardViewHolder})) == null) {
            if (yx5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || yx5Var.a == null) {
                return null;
            }
            yx5Var.I(yx5Var.position + 1);
            nx5.b().a(yx5Var.g("c12351"));
            threadCardViewHolder.c().q(i2);
            if (threadCardViewHolder.c() instanceof hj5) {
                threadCardViewHolder.c().b(this.k);
            }
            if (yx5Var.p) {
                xy xyVar = (xy) threadCardViewHolder.c().g();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) xyVar.f.d.getLayoutParams();
                layoutParams.width = yx5Var.j;
                layoutParams.height = yx5Var.k;
                if (xyVar.f.d.getVisibility() != 8) {
                    xyVar.f.d.setLayoutParams(layoutParams);
                }
            }
            threadCardViewHolder.g(yx5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.p);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: k0 */
    public View Q(int i2, View view2, ViewGroup viewGroup, yx5 yx5Var, ThreadCardViewHolder<yx5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, yx5Var, threadCardViewHolder})) == null) {
            if (yx5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || yx5Var.a == null) {
                return null;
            }
            yx5Var.I(yx5Var.position + 1);
            threadCardViewHolder.c().q(i2);
            if (threadCardViewHolder.c() instanceof hj5) {
                threadCardViewHolder.c().b(this.k);
            }
            if (yx5Var.y) {
                nx5.b().a(new StatisticItem("c13424"));
            }
            threadCardViewHolder.g(yx5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.p);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: l0 */
    public View R(int i2, View view2, ViewGroup viewGroup, yx5 yx5Var, ThreadCardViewHolder<yx5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, yx5Var, threadCardViewHolder})) == null) {
            if (yx5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || yx5Var.a == null) {
                return null;
            }
            yx5Var.I(yx5Var.position + 1);
            threadCardViewHolder.c().q(i2);
            if (threadCardViewHolder.c() instanceof hj5) {
                threadCardViewHolder.c().b(this.k);
            }
            if (yx5Var.m) {
                threadCardViewHolder.v(true, Align.ALIGN_RIGHT_TOP);
            } else if (yx5Var.n) {
                nx5.b().a(yx5Var.B());
                gj5.c().a(yx5Var.B());
                fz6.h(yx5Var.a, this.i, yx5Var.q());
            }
            threadCardViewHolder.g(yx5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.p);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: m0 */
    public View S(int i2, View view2, ViewGroup viewGroup, yx5 yx5Var, ThreadCardViewHolder<yx5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, yx5Var, threadCardViewHolder})) == null) {
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void n0(View view2, yx5 yx5Var) {
        StatisticItem A;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, view2, yx5Var) == null) || view2 == null || yx5Var == null || yx5Var.getThreadData() == null || StringUtils.isNull(yx5Var.getThreadData().getTid())) {
            return;
        }
        int id = view2.getId();
        int i2 = 1;
        if (yx5Var.m) {
            if (id == R.id.obfuscated_res_0x7f091fe0) {
                at6.b(view2, yx5Var, 2);
            } else if (id != R.id.obfuscated_res_0x7f0922d3 && id != R.id.obfuscated_res_0x7f0922f3) {
                if (view2 instanceof TbImageView) {
                    at6.b(view2, yx5Var, 3);
                }
            } else {
                at6.b(view2, yx5Var, 1);
            }
        } else if (yx5Var.n) {
            nx5.b().d(true);
            if (id != R.id.obfuscated_res_0x7f090a42 && id != R.id.obfuscated_res_0x7f090a41 && id != R.id.obfuscated_res_0x7f090a43 && id != R.id.obfuscated_res_0x7f090a44) {
                if (yx5Var.isVideoThreadType()) {
                    A = yx5Var.C();
                } else {
                    A = yx5Var.A();
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(A));
                gj5.c().i("page_concern", "clk_", A);
            } else {
                TiebaStatic.log(yx5Var.k());
                gj5.c().i("page_concern", "clk_", yx5Var.k());
                i2 = 9;
            }
            fz6.d(yx5Var.a, this.i, yx5Var.q(), i2);
        } else if (!yx5Var.o && !yx5Var.p && !yx5Var.q && !yx5Var.r) {
            if (yx5Var.v) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                if (threadCardViewHolder != null) {
                    ThreadCardUtils.jumpToPB((zn4) yx5Var.getThreadData(), view2.getContext(), 1, false);
                    threadCardViewHolder.c().o(new vz.a(1));
                }
            } else if (yx5Var.x) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091fe0) {
                    at6.b(view2, yx5Var, 2);
                } else if (id == R.id.obfuscated_res_0x7f090a5f) {
                    at6.b(view2, yx5Var, 7);
                }
            } else if (yx5Var.y) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091fe0) {
                    at6.b(view2, yx5Var, 2);
                } else if (id == R.id.obfuscated_res_0x7f090cc7) {
                    StatisticItem statisticItem = new StatisticItem("c13423");
                    statisticItem.param("obj_locate", 4);
                    statisticItem.param("tid", yx5Var.g);
                    ThreadData threadData = yx5Var.a;
                    if (threadData != null && threadData.getTopAgreePost() != null) {
                        statisticItem.param("pid", yx5Var.a.getTopAgreePost().I());
                    }
                    TiebaStatic.log(statisticItem);
                } else if (id == R.id.obfuscated_res_0x7f090cc2) {
                    StatisticItem statisticItem2 = new StatisticItem("c13423");
                    statisticItem2.param("obj_locate", 2);
                    statisticItem2.param("tid", yx5Var.g);
                    ThreadData threadData2 = yx5Var.a;
                    if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                        statisticItem2.param("pid", yx5Var.a.getTopAgreePost().I());
                    }
                    TiebaStatic.log(statisticItem2);
                } else if (id == R.id.obfuscated_res_0x7f090cc5 || id == R.id.obfuscated_res_0x7f090cc6) {
                    StatisticItem statisticItem3 = new StatisticItem("c13423");
                    statisticItem3.param("obj_locate", 1);
                    statisticItem3.param("tid", yx5Var.g);
                    ThreadData threadData3 = yx5Var.a;
                    if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                        statisticItem3.param("pid", yx5Var.a.getTopAgreePost().I());
                    }
                    TiebaStatic.log(statisticItem3);
                } else if (id == R.id.obfuscated_res_0x7f090cc1) {
                    StatisticItem statisticItem4 = new StatisticItem("c13423");
                    statisticItem4.param("obj_locate", 5);
                    statisticItem4.param("tid", yx5Var.g);
                    ThreadData threadData4 = yx5Var.a;
                    if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                        statisticItem4.param("pid", yx5Var.a.getTopAgreePost().I());
                    }
                    TiebaStatic.log(statisticItem4);
                } else if ((view2 instanceof TbImageView) && (view2.getTag(R.id.obfuscated_res_0x7f090cc3) instanceof Integer)) {
                    StatisticItem statisticItem5 = new StatisticItem("c13423");
                    statisticItem5.param("obj_locate", 3);
                    statisticItem5.param("tid", yx5Var.g);
                    ThreadData threadData5 = yx5Var.a;
                    if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                        statisticItem5.param("pid", yx5Var.a.getTopAgreePost().I());
                    }
                    TiebaStatic.log(statisticItem5);
                }
            } else if (yx5Var.A && (view2.getId() == R.id.obfuscated_res_0x7f091fe0 || view2.getId() == R.id.obfuscated_res_0x7f091ff4)) {
                at6.b(view2, yx5Var, 2);
            }
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091fe0) {
            at6.b(view2, yx5Var, 2);
        } else if (view2 instanceof TbImageView) {
            at6.b(view2, yx5Var, 3);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091fe1 || view2.getId() == R.id.obfuscated_res_0x7f091fd3) {
            at6.b(view2, yx5Var, 2);
        }
        if (id == R.id.obfuscated_res_0x7f091ff4 || id == R.id.obfuscated_res_0x7f091ff6 || id == R.id.obfuscated_res_0x7f091ff7) {
            at6.b(view2, yx5Var, 8);
        }
    }

    public void o0(xo xoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, xoVar) == null) {
            this.l = xoVar;
        }
    }

    @Override // com.repackage.eo
    public BdUniqueId v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? yx5.M : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.eo
    public BdUniqueId w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? yx5.I : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.eo
    public BdUniqueId x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? yx5.L : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.eo
    public BdUniqueId y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? yx5.D : (BdUniqueId) invokeV.objValue;
    }
}
