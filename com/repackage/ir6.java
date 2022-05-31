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
import com.repackage.iy;
import com.repackage.pw;
import com.repackage.xx;
/* loaded from: classes6.dex */
public class ir6 extends wm<rw5, ThreadCardViewHolder<rw5>> implements ci5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public String k;
    public pn l;
    public boolean m;
    public ag<ImageView> n;
    public ag<GifView> o;
    public nw5<rw5> p;

    /* loaded from: classes6.dex */
    public class a implements bg<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ir6 a;

        public a(ir6 ir6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ir6Var;
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

    /* loaded from: classes6.dex */
    public class b implements bg<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ir6 a;

        public b(ir6 ir6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ir6Var;
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

    /* loaded from: classes6.dex */
    public class c extends nw5<rw5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ir6 b;

        public c(ir6 ir6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ir6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nw5
        /* renamed from: d */
        public void a(View view2, rw5 rw5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, rw5Var) == null) {
                this.b.n0(view2, rw5Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements pw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(ir6 ir6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
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
        }
    }

    /* loaded from: classes6.dex */
    public class e implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ir6 a;

        public e(ir6 ir6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ir6Var;
        }

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (jnVar instanceof cn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                cn cnVar = (cn) jnVar;
                if (cnVar.e() instanceof rw5) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    rw5 rw5Var = (rw5) cnVar.e();
                    rw5Var.f = 1;
                    if (this.a.p != null) {
                        this.a.p.a(threadCardViewHolder.b(), rw5Var);
                    }
                    if (lx6.a(this.a.j, cnVar.e())) {
                        return;
                    }
                    ThreadCardUtils.jumpToPB((om4) rw5Var, view2.getContext(), 1, false, qw.a((pn) viewGroup, view2, i));
                    threadCardViewHolder.c().o(new iy.a(1));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ir6 a;

        public f(ir6 ir6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ir6Var;
        }

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (jnVar instanceof cn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                cn cnVar = (cn) jnVar;
                if (cnVar.e() instanceof rw5) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    rw5 rw5Var = (rw5) cnVar.e();
                    rw5Var.f = 1;
                    if (this.a.p != null) {
                        this.a.p.a(threadCardViewHolder.b(), rw5Var);
                    }
                    ThreadCardUtils.jumpToPB((om4) rw5Var, view2.getContext(), 1, false);
                    threadCardViewHolder.c().o(new iy.a(1));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ex a;
        public final /* synthetic */ ir6 b;

        public g(ir6 ir6Var, ex exVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir6Var, exVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ir6Var;
            this.a = exVar;
        }

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            rw5 rw5Var;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                boolean z = jnVar instanceof cn;
                if (z) {
                    cn cnVar = (cn) jnVar;
                    if ((cnVar.e() instanceof rw5) && jnVar != null && cnVar.e() != null && (rw5Var = (rw5) cnVar.e()) != null && (threadData = rw5Var.a) != null && rw5Var.u && threadData.getItem() != null) {
                        if (rw5Var.a.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                            BdToast.i(this.b.j.getContext(), this.b.j.getString(R.string.obfuscated_res_0x7f0f1519), R.drawable.obfuscated_res_0x7f0809ca, true).n();
                            return;
                        }
                        int a = xt4.a(rw5Var.a.getItem().button_link_type.intValue(), rw5Var.a.getItem().apk_detail != null ? rw5Var.a.getItem().apk_detail.pkg_source.intValue() : 0);
                        ItemData itemData = new ItemData();
                        itemData.parseProto(rw5Var.a.getItem());
                        ItemCardHelper.q(this.a.u(), rw5Var.a.getItem().item_id.longValue(), this.a.t(itemData), rw5Var.a.getTid(), a, "", 2);
                        ItemClickJumpUtil.itemClickJump(rw5Var.a.getItem().forum_name, String.valueOf(rw5Var.a.getItem().item_id), 2, 2);
                        return;
                    }
                }
                if (z && (view2.getTag() instanceof ThreadCardViewHolder)) {
                    cn cnVar2 = (cn) jnVar;
                    if (cnVar2.e() instanceof rw5) {
                        ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                        rw5 rw5Var2 = (rw5) cnVar2.e();
                        rw5Var2.f = 1;
                        if (this.b.p != null) {
                            this.b.p.a(threadCardViewHolder.b(), rw5Var2);
                        }
                        ThreadCardUtils.jumpToPB((om4) rw5Var2, view2.getContext(), 1, false, qw.a((pn) viewGroup, view2, i));
                        threadCardViewHolder.c().o(new iy.a(1));
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ir6 a;

        public h(ir6 ir6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ir6Var;
        }

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (jnVar instanceof cn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                cn cnVar = (cn) jnVar;
                if (cnVar.e() instanceof rw5) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    rw5 rw5Var = (rw5) cnVar.e();
                    rw5Var.f = 1;
                    if (this.a.p != null) {
                        this.a.p.a(threadCardViewHolder.b(), rw5Var);
                    }
                    ThreadCardUtils.jumpToPB((om4) rw5Var, view2.getContext(), 1, false, qw.a((pn) viewGroup, view2, i));
                    threadCardViewHolder.c().o(new iy.a(1));
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

        public i(ir6 ir6Var, ViewGroup viewGroup, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir6Var, viewGroup, view2, Integer.valueOf(i)};
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
                ((PbActivityConfig) intentConfig).setVideoOriginArea(qw.a((pn) this.a, this.b, this.c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ir6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.n = new ag<>(new a(this), 12, 0);
        this.o = new ag<>(new b(this), 20, 0);
        this.p = new c(this);
        this.j = tbPageContext;
        c0();
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            zw5.R = "c10705";
            zw5.S = "c10730";
            zw5.T = "c10731";
            zw5.U = "c10704";
            zw5.V = "c10755";
            zw5.W = "c10710";
            zw5.X = "c10736";
            zw5.Y = "c10737";
            zw5.Z = "c10711";
            zw5.g0 = "c10758";
            zw5.h0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: d0 */
    public ThreadCardViewHolder<rw5> I(ViewGroup viewGroup, rw5 rw5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, viewGroup, rw5Var)) == null) {
            xx.b bVar = new xx.b(this.j.getPageActivity(), false);
            zx zxVar = new zx(this.j.getPageActivity());
            um4 um4Var = new um4();
            um4Var.b = 9;
            um4Var.h = 9;
            zxVar.v(um4Var);
            zxVar.x(9);
            zxVar.D("personalize_page");
            zxVar.C(4);
            zxVar.y(1);
            zxVar.b(32);
            zxVar.w(false);
            bVar.m(zxVar);
            xx k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.l);
            k.r(1);
            ThreadCardViewHolder<rw5> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.i);
            V(new h(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: e0 */
    public ThreadCardViewHolder<rw5> J(ViewGroup viewGroup, rw5 rw5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, viewGroup, rw5Var)) == null) {
            xx.b bVar = new xx.b(this.j.getPageActivity(), false);
            if (rw5Var.o) {
                ax axVar = new ax(this.j.getPageActivity());
                axVar.C(this.n, this.o);
                axVar.x(ImageViewerConfig.FROM_CONCERN);
                axVar.z(1);
                axVar.y(this.m);
                axVar.w(1);
                bVar.n(axVar);
            } else if (rw5Var.p) {
                kx kxVar = new kx(this.j.getPageActivity());
                kxVar.q(ImageViewerConfig.FROM_CONCERN);
                kxVar.r(this.m);
                bVar.n(kxVar);
            } else if (rw5Var.q) {
                hx hxVar = new hx(this.j.getPageActivity());
                hxVar.s(ImageViewerConfig.FROM_CONCERN);
                hxVar.t(this.m);
                bVar.n(hxVar);
            } else if (rw5Var.r) {
                lx lxVar = new lx(this.j.getPageActivity());
                lxVar.r(ImageViewerConfig.FROM_CONCERN);
                lxVar.s(this.m);
                bVar.n(lxVar);
            } else {
                boolean z = rw5Var.s;
            }
            xx k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.l);
            k.r(1);
            ThreadCardViewHolder<rw5> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.i);
            V(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: f0 */
    public ThreadCardViewHolder<rw5> K(ViewGroup viewGroup, rw5 rw5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, viewGroup, rw5Var)) == null) {
            xx.b bVar = new xx.b(this.j.getPageActivity(), false);
            ex exVar = new ex(this.j.getPageActivity());
            exVar.z(2);
            exVar.s();
            exVar.w(true);
            bVar.h(exVar);
            bVar.h(new tx(this.j.getPageActivity()));
            bVar.h(new mx(this.j.getPageActivity()));
            ww wwVar = new ww(this.j.getPageActivity());
            wwVar.t();
            bVar.h(wwVar);
            zw zwVar = new zw(this.j.getPageActivity());
            zwVar.x(this.m);
            zwVar.w(ImageViewerConfig.FROM_CONCERN);
            bVar.h(zwVar);
            xx k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.l);
            k.r(1);
            ThreadCardViewHolder<rw5> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.i);
            V(new g(this, exVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    @Override // com.repackage.ci5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.k = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: g0 */
    public ThreadCardViewHolder<rw5> L(ViewGroup viewGroup, rw5 rw5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, viewGroup, rw5Var)) == null) {
            if (rw5Var == null) {
                return null;
            }
            xx.b bVar = new xx.b(this.j.getPageActivity());
            if (rw5Var.m) {
                pw pwVar = new pw(this.j.getPageActivity());
                pwVar.t(this.i);
                pwVar.b(128);
                pwVar.c(1024);
                pwVar.s(new d(this));
                bVar.o(pwVar);
            } else if (rw5Var.n) {
                bVar.o(new yw(this.j.getPageActivity()));
            }
            xx k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.l);
            k.r(1);
            ThreadCardViewHolder<rw5> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.i);
            V(new e(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
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
    @Override // com.repackage.wm
    /* renamed from: i0 */
    public View O(int i2, View view2, ViewGroup viewGroup, rw5 rw5Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, rw5Var, threadCardViewHolder})) == null) {
            if (rw5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || rw5Var.a == null) {
                return null;
            }
            rw5Var.I(rw5Var.position + 1);
            threadCardViewHolder.c().q(i2);
            if (threadCardViewHolder.c().f() instanceof zx) {
                ((zx) threadCardViewHolder.c().f()).B(new i(this, viewGroup, view2, i2));
            }
            if (threadCardViewHolder.c() instanceof bi5) {
                threadCardViewHolder.c().b(this.k);
            }
            threadCardViewHolder.v(false, Align.ALIGN_RIGHT_BOTTOM);
            threadCardViewHolder.g(rw5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.p);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: j0 */
    public View P(int i2, View view2, ViewGroup viewGroup, rw5 rw5Var, ThreadCardViewHolder<rw5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, rw5Var, threadCardViewHolder})) == null) {
            if (rw5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || rw5Var.a == null) {
                return null;
            }
            rw5Var.I(rw5Var.position + 1);
            gw5.b().a(rw5Var.g("c12351"));
            threadCardViewHolder.c().q(i2);
            if (threadCardViewHolder.c() instanceof bi5) {
                threadCardViewHolder.c().b(this.k);
            }
            if (rw5Var.p) {
                kx kxVar = (kx) threadCardViewHolder.c().g();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kxVar.f.d.getLayoutParams();
                layoutParams.width = rw5Var.j;
                layoutParams.height = rw5Var.k;
                if (kxVar.f.d.getVisibility() != 8) {
                    kxVar.f.d.setLayoutParams(layoutParams);
                }
            }
            threadCardViewHolder.g(rw5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.p);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: k0 */
    public View Q(int i2, View view2, ViewGroup viewGroup, rw5 rw5Var, ThreadCardViewHolder<rw5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, rw5Var, threadCardViewHolder})) == null) {
            if (rw5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || rw5Var.a == null) {
                return null;
            }
            rw5Var.I(rw5Var.position + 1);
            threadCardViewHolder.c().q(i2);
            if (threadCardViewHolder.c() instanceof bi5) {
                threadCardViewHolder.c().b(this.k);
            }
            if (rw5Var.y) {
                gw5.b().a(new StatisticItem("c13424"));
            }
            threadCardViewHolder.g(rw5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.p);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: l0 */
    public View R(int i2, View view2, ViewGroup viewGroup, rw5 rw5Var, ThreadCardViewHolder<rw5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, rw5Var, threadCardViewHolder})) == null) {
            if (rw5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || rw5Var.a == null) {
                return null;
            }
            rw5Var.I(rw5Var.position + 1);
            threadCardViewHolder.c().q(i2);
            if (threadCardViewHolder.c() instanceof bi5) {
                threadCardViewHolder.c().b(this.k);
            }
            if (rw5Var.m) {
                threadCardViewHolder.v(true, Align.ALIGN_RIGHT_TOP);
            } else if (rw5Var.n) {
                gw5.b().a(rw5Var.B());
                ai5.c().a(rw5Var.B());
                jx6.h(rw5Var.a, this.i, rw5Var.q());
            }
            threadCardViewHolder.g(rw5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.p);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: m0 */
    public View S(int i2, View view2, ViewGroup viewGroup, rw5 rw5Var, ThreadCardViewHolder<rw5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, rw5Var, threadCardViewHolder})) == null) {
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void n0(View view2, rw5 rw5Var) {
        StatisticItem A;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, view2, rw5Var) == null) || view2 == null || rw5Var == null || rw5Var.getThreadData() == null || StringUtils.isNull(rw5Var.getThreadData().getTid())) {
            return;
        }
        int id = view2.getId();
        int i2 = 1;
        if (rw5Var.m) {
            if (id == R.id.obfuscated_res_0x7f091f85) {
                er6.b(view2, rw5Var, 2);
            } else if (id != R.id.obfuscated_res_0x7f092278 && id != R.id.obfuscated_res_0x7f092298) {
                if (view2 instanceof TbImageView) {
                    er6.b(view2, rw5Var, 3);
                }
            } else {
                er6.b(view2, rw5Var, 1);
            }
        } else if (rw5Var.n) {
            gw5.b().d(true);
            if (id != R.id.obfuscated_res_0x7f090a2c && id != R.id.obfuscated_res_0x7f090a2b && id != R.id.obfuscated_res_0x7f090a2d && id != R.id.obfuscated_res_0x7f090a2e) {
                if (rw5Var.isVideoThreadType()) {
                    A = rw5Var.C();
                } else {
                    A = rw5Var.A();
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(A));
                ai5.c().i("page_concern", "clk_", A);
            } else {
                TiebaStatic.log(rw5Var.k());
                ai5.c().i("page_concern", "clk_", rw5Var.k());
                i2 = 9;
            }
            jx6.d(rw5Var.a, this.i, rw5Var.q(), i2);
        } else if (!rw5Var.o && !rw5Var.p && !rw5Var.q && !rw5Var.r) {
            if (rw5Var.v) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                if (threadCardViewHolder != null) {
                    ThreadCardUtils.jumpToPB((om4) rw5Var.getThreadData(), view2.getContext(), 1, false);
                    threadCardViewHolder.c().o(new iy.a(1));
                }
            } else if (rw5Var.x) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091f85) {
                    er6.b(view2, rw5Var, 2);
                } else if (id == R.id.obfuscated_res_0x7f090a49) {
                    er6.b(view2, rw5Var, 7);
                }
            } else if (rw5Var.y) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091f85) {
                    er6.b(view2, rw5Var, 2);
                } else if (id == R.id.obfuscated_res_0x7f090c8b) {
                    StatisticItem statisticItem = new StatisticItem("c13423");
                    statisticItem.param("obj_locate", 4);
                    statisticItem.param("tid", rw5Var.g);
                    ThreadData threadData = rw5Var.a;
                    if (threadData != null && threadData.getTopAgreePost() != null) {
                        statisticItem.param("pid", rw5Var.a.getTopAgreePost().I());
                    }
                    TiebaStatic.log(statisticItem);
                } else if (id == R.id.obfuscated_res_0x7f090c86) {
                    StatisticItem statisticItem2 = new StatisticItem("c13423");
                    statisticItem2.param("obj_locate", 2);
                    statisticItem2.param("tid", rw5Var.g);
                    ThreadData threadData2 = rw5Var.a;
                    if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                        statisticItem2.param("pid", rw5Var.a.getTopAgreePost().I());
                    }
                    TiebaStatic.log(statisticItem2);
                } else if (id == R.id.obfuscated_res_0x7f090c89 || id == R.id.obfuscated_res_0x7f090c8a) {
                    StatisticItem statisticItem3 = new StatisticItem("c13423");
                    statisticItem3.param("obj_locate", 1);
                    statisticItem3.param("tid", rw5Var.g);
                    ThreadData threadData3 = rw5Var.a;
                    if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                        statisticItem3.param("pid", rw5Var.a.getTopAgreePost().I());
                    }
                    TiebaStatic.log(statisticItem3);
                } else if (id == R.id.obfuscated_res_0x7f090c85) {
                    StatisticItem statisticItem4 = new StatisticItem("c13423");
                    statisticItem4.param("obj_locate", 5);
                    statisticItem4.param("tid", rw5Var.g);
                    ThreadData threadData4 = rw5Var.a;
                    if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                        statisticItem4.param("pid", rw5Var.a.getTopAgreePost().I());
                    }
                    TiebaStatic.log(statisticItem4);
                } else if ((view2 instanceof TbImageView) && (view2.getTag(R.id.obfuscated_res_0x7f090c87) instanceof Integer)) {
                    StatisticItem statisticItem5 = new StatisticItem("c13423");
                    statisticItem5.param("obj_locate", 3);
                    statisticItem5.param("tid", rw5Var.g);
                    ThreadData threadData5 = rw5Var.a;
                    if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                        statisticItem5.param("pid", rw5Var.a.getTopAgreePost().I());
                    }
                    TiebaStatic.log(statisticItem5);
                }
            } else if (rw5Var.A && (view2.getId() == R.id.obfuscated_res_0x7f091f85 || view2.getId() == R.id.obfuscated_res_0x7f091f99)) {
                er6.b(view2, rw5Var, 2);
            }
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091f85) {
            er6.b(view2, rw5Var, 2);
        } else if (view2 instanceof TbImageView) {
            er6.b(view2, rw5Var, 3);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091f86 || view2.getId() == R.id.obfuscated_res_0x7f091f78) {
            er6.b(view2, rw5Var, 2);
        }
        if (id == R.id.obfuscated_res_0x7f091f99 || id == R.id.obfuscated_res_0x7f091f9b || id == R.id.obfuscated_res_0x7f091f9c) {
            er6.b(view2, rw5Var, 8);
        }
    }

    public void o0(pn pnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, pnVar) == null) {
            this.l = pnVar;
        }
    }

    @Override // com.repackage.wm
    public BdUniqueId v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? rw5.M : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.wm
    public BdUniqueId w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? rw5.I : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.wm
    public BdUniqueId x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? rw5.L : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.wm
    public BdUniqueId y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? rw5.D : (BdUniqueId) invokeV.objValue;
    }
}
