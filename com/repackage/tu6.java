package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
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
import com.repackage.dy;
import com.repackage.oy;
import com.repackage.uw;
/* loaded from: classes7.dex */
public class tu6 extends bn<f06, ThreadCardViewHolder<f06>> implements pl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public un d;
    public boolean e;
    public fg<ImageView> f;
    public fg<GifView> g;
    public b06<f06> h;

    /* loaded from: classes7.dex */
    public class a implements gg<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tu6 a;

        public a(tu6 tu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tu6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.gg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.gg
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
                    if (rn4.c().g()) {
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
        @Override // com.repackage.gg
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
        @Override // com.repackage.gg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.b.getPageActivity());
                boolean g = rn4.c().g();
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

    /* loaded from: classes7.dex */
    public class b implements gg<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tu6 a;

        public b(tu6 tu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tu6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.gg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.gg
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
                if (rn4.c().g()) {
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
        @Override // com.repackage.gg
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
        @Override // com.repackage.gg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.b.getPageActivity());
                boolean g = rn4.c().g();
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
    public class c extends b06<f06> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tu6 b;

        public c(tu6 tu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tu6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.b06
        /* renamed from: d */
        public void a(View view2, f06 f06Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, f06Var) == null) {
                this.b.G(view2, f06Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements uw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(tu6 tu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.uw.b
        public void a(fo4 fo4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, fo4Var, view2) == null) || fo4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09244f) {
                fo4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092421) {
                fo4Var.objType = 4;
            } else {
                fo4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements yn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tu6 a;

        public e(tu6 tu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tu6Var;
        }

        @Override // com.repackage.yn
        public void b(View view2, on onVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, onVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (onVar instanceof hn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                hn hnVar = (hn) onVar;
                if (hnVar.c() instanceof f06) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    f06 f06Var = (f06) hnVar.c();
                    f06Var.f = 1;
                    if (this.a.h != null) {
                        this.a.h.a(threadCardViewHolder.getView(), f06Var);
                    }
                    if (e17.a(this.a.b, hnVar.c())) {
                        return;
                    }
                    ThreadCardUtils.jumpToPB((fo4) f06Var, view2.getContext(), 1, false, vw.a((un) viewGroup, view2, i));
                    threadCardViewHolder.a().o(new oy.a(1));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements yn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tu6 a;

        public f(tu6 tu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tu6Var;
        }

        @Override // com.repackage.yn
        public void b(View view2, on onVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, onVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (onVar instanceof hn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                hn hnVar = (hn) onVar;
                if (hnVar.c() instanceof f06) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    f06 f06Var = (f06) hnVar.c();
                    f06Var.f = 1;
                    if (this.a.h != null) {
                        this.a.h.a(threadCardViewHolder.getView(), f06Var);
                    }
                    ThreadCardUtils.jumpToPB((fo4) f06Var, view2.getContext(), 1, false);
                    threadCardViewHolder.a().o(new oy.a(1));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements yn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kx a;
        public final /* synthetic */ tu6 b;

        public g(tu6 tu6Var, kx kxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tu6Var, kxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tu6Var;
            this.a = kxVar;
        }

        @Override // com.repackage.yn
        public void b(View view2, on onVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            f06 f06Var;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, onVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                boolean z = onVar instanceof hn;
                if (z) {
                    hn hnVar = (hn) onVar;
                    if ((hnVar.c() instanceof f06) && onVar != null && hnVar.c() != null && (f06Var = (f06) hnVar.c()) != null && (threadData = f06Var.a) != null && f06Var.u && threadData.getItem() != null) {
                        if (f06Var.a.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                            BdToast b = BdToast.b(this.b.b.getContext(), this.b.b.getString(R.string.obfuscated_res_0x7f0f1511));
                            b.f(BdToast.ToastIcon.FAILURE);
                            b.h();
                            return;
                        }
                        int a = zv4.a(f06Var.a.getItem().button_link_type.intValue(), f06Var.a.getItem().apk_detail != null ? f06Var.a.getItem().apk_detail.pkg_source.intValue() : 0);
                        ItemData itemData = new ItemData();
                        itemData.parseProto(f06Var.a.getItem());
                        ItemCardHelper.q(this.a.v(), f06Var.a.getItem().item_id.longValue(), this.a.u(itemData), f06Var.a.getTid(), a, "", 2);
                        ItemClickJumpUtil.itemClickJump(f06Var.a.getItem().forum_name, String.valueOf(f06Var.a.getItem().item_id), 2, 2);
                        return;
                    }
                }
                if (z && (view2.getTag() instanceof ThreadCardViewHolder)) {
                    hn hnVar2 = (hn) onVar;
                    if (hnVar2.c() instanceof f06) {
                        ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                        f06 f06Var2 = (f06) hnVar2.c();
                        f06Var2.f = 1;
                        if (this.b.h != null) {
                            this.b.h.a(threadCardViewHolder.getView(), f06Var2);
                        }
                        ThreadCardUtils.jumpToPB((fo4) f06Var2, view2.getContext(), 1, false, vw.a((un) viewGroup, view2, i));
                        threadCardViewHolder.a().o(new oy.a(1));
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements yn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tu6 a;

        public h(tu6 tu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tu6Var;
        }

        @Override // com.repackage.yn
        public void b(View view2, on onVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, onVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (onVar instanceof hn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                hn hnVar = (hn) onVar;
                if (hnVar.c() instanceof f06) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    f06 f06Var = (f06) hnVar.c();
                    f06Var.f = 1;
                    if (this.a.h != null) {
                        this.a.h.a(threadCardViewHolder.getView(), f06Var);
                    }
                    ThreadCardUtils.jumpToPB((fo4) f06Var, view2.getContext(), 1, false, vw.a((un) viewGroup, view2, i));
                    threadCardViewHolder.a().o(new oy.a(1));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements ThreadCommentAndPraiseInfoLayout.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        public i(tu6 tu6Var, ViewGroup viewGroup, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tu6Var, viewGroup, view2, Integer.valueOf(i)};
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

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.k
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(vw.a((un) this.a, this.b, this.c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tu6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.e = true;
        this.f = new fg<>(new a(this), 12, 0);
        this.g = new fg<>(new b(this), 20, 0);
        this.h = new c(this);
        this.b = tbPageContext;
        v();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: A */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            return null;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: B */
    public View onFillBottomViewHolder(int i2, View view2, ViewGroup viewGroup, f06 f06Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, f06Var, threadCardViewHolder})) == null) {
            if (f06Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || f06Var.a == null) {
                return null;
            }
            f06Var.I(f06Var.position + 1);
            threadCardViewHolder.a().q(i2);
            if (threadCardViewHolder.a().f() instanceof fy) {
                ((fy) threadCardViewHolder.a().f()).C(new i(this, viewGroup, view2, i2));
            }
            if (threadCardViewHolder.a() instanceof ol5) {
                threadCardViewHolder.a().b(this.c);
            }
            threadCardViewHolder.s(false, Align.ALIGN_RIGHT_BOTTOM);
            threadCardViewHolder.e(f06Var);
            threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.a().p(this.h);
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: C */
    public View onFillContentViewHolder(int i2, View view2, ViewGroup viewGroup, f06 f06Var, ThreadCardViewHolder<f06> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, f06Var, threadCardViewHolder})) == null) {
            if (f06Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || f06Var.a == null) {
                return null;
            }
            f06Var.I(f06Var.position + 1);
            uz5.b().a(f06Var.f("c12351"));
            threadCardViewHolder.a().q(i2);
            if (threadCardViewHolder.a() instanceof ol5) {
                threadCardViewHolder.a().b(this.c);
            }
            if (f06Var.p) {
                qx qxVar = (qx) threadCardViewHolder.a().g();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) qxVar.f.d.getLayoutParams();
                layoutParams.width = f06Var.j;
                layoutParams.height = f06Var.k;
                if (qxVar.f.d.getVisibility() != 8) {
                    qxVar.f.d.setLayoutParams(layoutParams);
                }
            }
            threadCardViewHolder.e(f06Var);
            threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.a().p(this.h);
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: D */
    public View onFillExtendViewHolder(int i2, View view2, ViewGroup viewGroup, f06 f06Var, ThreadCardViewHolder<f06> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, f06Var, threadCardViewHolder})) == null) {
            if (f06Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || f06Var.a == null) {
                return null;
            }
            f06Var.I(f06Var.position + 1);
            threadCardViewHolder.a().q(i2);
            if (threadCardViewHolder.a() instanceof ol5) {
                threadCardViewHolder.a().b(this.c);
            }
            if (f06Var.y) {
                uz5.b().a(new StatisticItem("c13424"));
            }
            threadCardViewHolder.e(f06Var);
            threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.a().p(this.h);
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: E */
    public View onFillHeaderViewHolder(int i2, View view2, ViewGroup viewGroup, f06 f06Var, ThreadCardViewHolder<f06> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, f06Var, threadCardViewHolder})) == null) {
            if (f06Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || f06Var.a == null) {
                return null;
            }
            f06Var.I(f06Var.position + 1);
            threadCardViewHolder.a().q(i2);
            if (threadCardViewHolder.a() instanceof ol5) {
                threadCardViewHolder.a().b(this.c);
            }
            if (f06Var.m) {
                threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP);
            } else if (f06Var.n) {
                uz5.b().a(f06Var.B());
                nl5.c().a(f06Var.B());
                c17.i(f06Var.a, this.a, f06Var.n());
            }
            threadCardViewHolder.e(f06Var);
            threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.a().p(this.h);
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: F */
    public View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, f06 f06Var, ThreadCardViewHolder<f06> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, f06Var, threadCardViewHolder})) == null) {
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void G(View view2, f06 f06Var) {
        StatisticItem A;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, view2, f06Var) == null) || view2 == null || f06Var == null || f06Var.getThreadData() == null || StringUtils.isNull(f06Var.getThreadData().getTid())) {
            return;
        }
        int id = view2.getId();
        int i2 = 1;
        if (f06Var.m) {
            if (id == R.id.obfuscated_res_0x7f09212a) {
                ou6.b(view2, f06Var, 2);
            } else if (id != R.id.obfuscated_res_0x7f092421 && id != R.id.obfuscated_res_0x7f09244f) {
                if (view2 instanceof TbImageView) {
                    ou6.b(view2, f06Var, 3);
                }
            } else {
                ou6.b(view2, f06Var, 1);
            }
        } else if (f06Var.n) {
            uz5.b().d(true);
            if (id != R.id.obfuscated_res_0x7f090a57 && id != R.id.obfuscated_res_0x7f090a56 && id != R.id.obfuscated_res_0x7f090a58 && id != R.id.obfuscated_res_0x7f090a59) {
                if (f06Var.isVideoThreadType()) {
                    A = f06Var.C();
                } else {
                    A = f06Var.A();
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(A));
                nl5.c().i("page_concern", "clk_", A);
            } else {
                TiebaStatic.log(f06Var.j());
                nl5.c().i("page_concern", "clk_", f06Var.j());
                i2 = 9;
            }
            c17.d(f06Var.a, this.a, f06Var.n(), i2);
        } else if (!f06Var.o && !f06Var.p && !f06Var.q && !f06Var.r) {
            if (f06Var.v) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                if (threadCardViewHolder != null) {
                    ThreadCardUtils.jumpToPB((fo4) f06Var.getThreadData(), view2.getContext(), 1, false);
                    threadCardViewHolder.a().o(new oy.a(1));
                }
            } else if (f06Var.x) {
                if (view2.getId() == R.id.obfuscated_res_0x7f09212a) {
                    ou6.b(view2, f06Var, 2);
                } else if (id == R.id.obfuscated_res_0x7f090a74) {
                    ou6.b(view2, f06Var, 7);
                }
            } else if (f06Var.y) {
                if (view2.getId() == R.id.obfuscated_res_0x7f09212a) {
                    ou6.b(view2, f06Var, 2);
                } else if (id == R.id.obfuscated_res_0x7f090cbe) {
                    StatisticItem statisticItem = new StatisticItem("c13423");
                    statisticItem.param("obj_locate", 4);
                    statisticItem.param("tid", f06Var.g);
                    ThreadData threadData = f06Var.a;
                    if (threadData != null && threadData.getTopAgreePost() != null) {
                        statisticItem.param("pid", f06Var.a.getTopAgreePost().K());
                    }
                    TiebaStatic.log(statisticItem);
                } else if (id == R.id.obfuscated_res_0x7f090cb9) {
                    StatisticItem statisticItem2 = new StatisticItem("c13423");
                    statisticItem2.param("obj_locate", 2);
                    statisticItem2.param("tid", f06Var.g);
                    ThreadData threadData2 = f06Var.a;
                    if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                        statisticItem2.param("pid", f06Var.a.getTopAgreePost().K());
                    }
                    TiebaStatic.log(statisticItem2);
                } else if (id == R.id.obfuscated_res_0x7f090cbc || id == R.id.obfuscated_res_0x7f090cbd) {
                    StatisticItem statisticItem3 = new StatisticItem("c13423");
                    statisticItem3.param("obj_locate", 1);
                    statisticItem3.param("tid", f06Var.g);
                    ThreadData threadData3 = f06Var.a;
                    if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                        statisticItem3.param("pid", f06Var.a.getTopAgreePost().K());
                    }
                    TiebaStatic.log(statisticItem3);
                } else if (id == R.id.obfuscated_res_0x7f090cb8) {
                    StatisticItem statisticItem4 = new StatisticItem("c13423");
                    statisticItem4.param("obj_locate", 5);
                    statisticItem4.param("tid", f06Var.g);
                    ThreadData threadData4 = f06Var.a;
                    if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                        statisticItem4.param("pid", f06Var.a.getTopAgreePost().K());
                    }
                    TiebaStatic.log(statisticItem4);
                } else if ((view2 instanceof TbImageView) && (view2.getTag(R.id.obfuscated_res_0x7f090cba) instanceof Integer)) {
                    StatisticItem statisticItem5 = new StatisticItem("c13423");
                    statisticItem5.param("obj_locate", 3);
                    statisticItem5.param("tid", f06Var.g);
                    ThreadData threadData5 = f06Var.a;
                    if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                        statisticItem5.param("pid", f06Var.a.getTopAgreePost().K());
                    }
                    TiebaStatic.log(statisticItem5);
                }
            } else if (f06Var.A && (view2.getId() == R.id.obfuscated_res_0x7f09212a || view2.getId() == R.id.obfuscated_res_0x7f09213e)) {
                ou6.b(view2, f06Var, 2);
            }
        } else if (view2.getId() == R.id.obfuscated_res_0x7f09212a) {
            ou6.b(view2, f06Var, 2);
        } else if (view2 instanceof TbImageView) {
            ou6.b(view2, f06Var, 3);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f09212b || view2.getId() == R.id.obfuscated_res_0x7f09211d) {
            ou6.b(view2, f06Var, 2);
        }
        if (id == R.id.obfuscated_res_0x7f09213e || id == R.id.obfuscated_res_0x7f092140 || id == R.id.obfuscated_res_0x7f092141) {
            ou6.b(view2, f06Var, 8);
        }
    }

    public void H(un unVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, unVar) == null) {
            this.d = unVar;
        }
    }

    @Override // com.repackage.pl5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.c = str;
        }
    }

    @Override // com.repackage.bn
    public BdUniqueId getBottomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? f06.M : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.bn
    public BdUniqueId getContentId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? f06.I : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.bn
    public BdUniqueId getExtendId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? f06.L : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.bn
    public BdUniqueId getHeaderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? f06.D : (BdUniqueId) invokeV.objValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            n06.R = "c10705";
            n06.S = "c10730";
            n06.T = "c10731";
            n06.U = "c10704";
            n06.V = "c10755";
            n06.W = "c10710";
            n06.X = "c10736";
            n06.Y = "c10737";
            n06.Z = "c10711";
            n06.a0 = "c10758";
            n06.b0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: w */
    public ThreadCardViewHolder<f06> onCreateBottomViewHolder(ViewGroup viewGroup, f06 f06Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, viewGroup, f06Var)) == null) {
            dy.b bVar = new dy.b(this.b.getPageActivity(), false);
            fy fyVar = new fy(this.b.getPageActivity());
            lo4 lo4Var = new lo4();
            lo4Var.b = 9;
            lo4Var.h = 9;
            fyVar.w(lo4Var);
            fyVar.y(9);
            fyVar.E("personalize_page");
            fyVar.D(4);
            fyVar.z(1);
            fyVar.c(32);
            fyVar.x(false);
            bVar.m(fyVar);
            dy k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.d);
            k.r(1);
            ThreadCardViewHolder<f06> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new h(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: x */
    public ThreadCardViewHolder<f06> onCreateContentViewHolder(ViewGroup viewGroup, f06 f06Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, viewGroup, f06Var)) == null) {
            dy.b bVar = new dy.b(this.b.getPageActivity(), false);
            if (f06Var.o) {
                gx gxVar = new gx(this.b.getPageActivity());
                gxVar.D(this.f, this.g);
                gxVar.y(ImageViewerConfig.FROM_CONCERN);
                gxVar.A(1);
                gxVar.z(this.e);
                gxVar.x(1);
                bVar.n(gxVar);
            } else if (f06Var.p) {
                qx qxVar = new qx(this.b.getPageActivity());
                qxVar.r(ImageViewerConfig.FROM_CONCERN);
                qxVar.s(this.e);
                bVar.n(qxVar);
            } else if (f06Var.q) {
                nx nxVar = new nx(this.b.getPageActivity());
                nxVar.t(ImageViewerConfig.FROM_CONCERN);
                nxVar.u(this.e);
                bVar.n(nxVar);
            } else if (f06Var.r) {
                rx rxVar = new rx(this.b.getPageActivity());
                rxVar.s(ImageViewerConfig.FROM_CONCERN);
                rxVar.t(this.e);
                bVar.n(rxVar);
            } else {
                boolean z = f06Var.s;
            }
            dy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.d);
            k.r(1);
            ThreadCardViewHolder<f06> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: y */
    public ThreadCardViewHolder<f06> onCreateExtendViewHolder(ViewGroup viewGroup, f06 f06Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, viewGroup, f06Var)) == null) {
            dy.b bVar = new dy.b(this.b.getPageActivity(), false);
            kx kxVar = new kx(this.b.getPageActivity());
            kxVar.A(2);
            kxVar.t();
            kxVar.x(true);
            bVar.h(kxVar);
            bVar.h(new zx(this.b.getPageActivity()));
            bVar.h(new sx(this.b.getPageActivity()));
            bx bxVar = new bx(this.b.getPageActivity());
            bxVar.u();
            bVar.h(bxVar);
            fx fxVar = new fx(this.b.getPageActivity());
            fxVar.y(this.e);
            fxVar.x(ImageViewerConfig.FROM_CONCERN);
            bVar.h(fxVar);
            dy k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.d);
            k.r(1);
            ThreadCardViewHolder<f06> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new g(this, kxVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: z */
    public ThreadCardViewHolder<f06> onCreateHeaderViewHolder(ViewGroup viewGroup, f06 f06Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, viewGroup, f06Var)) == null) {
            if (f06Var == null) {
                return null;
            }
            dy.b bVar = new dy.b(this.b.getPageActivity());
            if (f06Var.m) {
                uw uwVar = new uw(this.b.getPageActivity());
                uwVar.u(this.a);
                uwVar.c(128);
                uwVar.d(1024);
                uwVar.t(new d(this));
                bVar.o(uwVar);
            } else if (f06Var.n) {
                bVar.o(new dx(this.b.getPageActivity()));
            }
            dy k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.d);
            k.r(1);
            ThreadCardViewHolder<f06> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new e(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }
}
