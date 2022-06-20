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
import com.repackage.by;
import com.repackage.my;
import com.repackage.tw;
/* loaded from: classes6.dex */
public class ms6 extends an<qx5, ThreadCardViewHolder<qx5>> implements zi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public String k;
    public tn l;
    public boolean m;
    public eg<ImageView> n;
    public eg<GifView> o;
    public mx5<qx5> p;

    /* loaded from: classes6.dex */
    public class a implements fg<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ms6 a;

        public a(ms6 ms6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ms6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ms6Var;
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
                    if (km4.c().g()) {
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
                boolean g = km4.c().g();
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
        public final /* synthetic */ ms6 a;

        public b(ms6 ms6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ms6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ms6Var;
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
                if (km4.c().g()) {
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
                boolean g = km4.c().g();
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
    public class c extends mx5<qx5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ms6 b;

        public c(ms6 ms6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ms6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ms6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.mx5
        /* renamed from: d */
        public void a(View view2, qx5 qx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, qx5Var) == null) {
                this.b.n0(view2, qx5Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements tw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(ms6 ms6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ms6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.tw.b
        public void a(ym4 ym4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, ym4Var, view2) == null) || ym4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f092285) {
                ym4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092266) {
                ym4Var.objType = 4;
            } else {
                ym4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ms6 a;

        public e(ms6 ms6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ms6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ms6Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof gn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                gn gnVar = (gn) nnVar;
                if (gnVar.c() instanceof qx5) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    qx5 qx5Var = (qx5) gnVar.c();
                    qx5Var.f = 1;
                    if (this.a.p != null) {
                        this.a.p.a(threadCardViewHolder.b(), qx5Var);
                    }
                    if (uy6.a(this.a.j, gnVar.c())) {
                        return;
                    }
                    ThreadCardUtils.jumpToPB((ym4) qx5Var, view2.getContext(), 1, false, uw.a((tn) viewGroup, view2, i));
                    threadCardViewHolder.c().o(new my.a(1));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ms6 a;

        public f(ms6 ms6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ms6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ms6Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof gn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                gn gnVar = (gn) nnVar;
                if (gnVar.c() instanceof qx5) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    qx5 qx5Var = (qx5) gnVar.c();
                    qx5Var.f = 1;
                    if (this.a.p != null) {
                        this.a.p.a(threadCardViewHolder.b(), qx5Var);
                    }
                    ThreadCardUtils.jumpToPB((ym4) qx5Var, view2.getContext(), 1, false);
                    threadCardViewHolder.c().o(new my.a(1));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix a;
        public final /* synthetic */ ms6 b;

        public g(ms6 ms6Var, ix ixVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ms6Var, ixVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ms6Var;
            this.a = ixVar;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            qx5 qx5Var;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                boolean z = nnVar instanceof gn;
                if (z) {
                    gn gnVar = (gn) nnVar;
                    if ((gnVar.c() instanceof qx5) && nnVar != null && gnVar.c() != null && (qx5Var = (qx5) gnVar.c()) != null && (threadData = qx5Var.a) != null && qx5Var.u && threadData.getItem() != null) {
                        if (qx5Var.a.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                            BdToast.i(this.b.j.getContext(), this.b.j.getString(R.string.obfuscated_res_0x7f0f1522), R.drawable.obfuscated_res_0x7f0809b5, true).n();
                            return;
                        }
                        int a = hu4.a(qx5Var.a.getItem().button_link_type.intValue(), qx5Var.a.getItem().apk_detail != null ? qx5Var.a.getItem().apk_detail.pkg_source.intValue() : 0);
                        ItemData itemData = new ItemData();
                        itemData.parseProto(qx5Var.a.getItem());
                        ItemCardHelper.q(this.a.u(), qx5Var.a.getItem().item_id.longValue(), this.a.t(itemData), qx5Var.a.getTid(), a, "", 2);
                        ItemClickJumpUtil.itemClickJump(qx5Var.a.getItem().forum_name, String.valueOf(qx5Var.a.getItem().item_id), 2, 2);
                        return;
                    }
                }
                if (z && (view2.getTag() instanceof ThreadCardViewHolder)) {
                    gn gnVar2 = (gn) nnVar;
                    if (gnVar2.c() instanceof qx5) {
                        ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                        qx5 qx5Var2 = (qx5) gnVar2.c();
                        qx5Var2.f = 1;
                        if (this.b.p != null) {
                            this.b.p.a(threadCardViewHolder.b(), qx5Var2);
                        }
                        ThreadCardUtils.jumpToPB((ym4) qx5Var2, view2.getContext(), 1, false, uw.a((tn) viewGroup, view2, i));
                        threadCardViewHolder.c().o(new my.a(1));
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ms6 a;

        public h(ms6 ms6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ms6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ms6Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof gn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                gn gnVar = (gn) nnVar;
                if (gnVar.c() instanceof qx5) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    qx5 qx5Var = (qx5) gnVar.c();
                    qx5Var.f = 1;
                    if (this.a.p != null) {
                        this.a.p.a(threadCardViewHolder.b(), qx5Var);
                    }
                    ThreadCardUtils.jumpToPB((ym4) qx5Var, view2.getContext(), 1, false, uw.a((tn) viewGroup, view2, i));
                    threadCardViewHolder.c().o(new my.a(1));
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

        public i(ms6 ms6Var, ViewGroup viewGroup, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ms6Var, viewGroup, view2, Integer.valueOf(i)};
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
                ((PbActivityConfig) intentConfig).setVideoOriginArea(uw.a((tn) this.a, this.b, this.c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ms6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.n = new eg<>(new a(this), 12, 0);
        this.o = new eg<>(new b(this), 20, 0);
        this.p = new c(this);
        this.j = tbPageContext;
        c0();
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            yx5.R = "c10705";
            yx5.S = "c10730";
            yx5.T = "c10731";
            yx5.U = "c10704";
            yx5.V = "c10755";
            yx5.W = "c10710";
            yx5.X = "c10736";
            yx5.Y = "c10737";
            yx5.Z = "c10711";
            yx5.g0 = "c10758";
            yx5.h0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: d0 */
    public ThreadCardViewHolder<qx5> H(ViewGroup viewGroup, qx5 qx5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, viewGroup, qx5Var)) == null) {
            by.b bVar = new by.b(this.j.getPageActivity(), false);
            dy dyVar = new dy(this.j.getPageActivity());
            en4 en4Var = new en4();
            en4Var.b = 9;
            en4Var.h = 9;
            dyVar.v(en4Var);
            dyVar.x(9);
            dyVar.D("personalize_page");
            dyVar.C(4);
            dyVar.y(1);
            dyVar.b(32);
            dyVar.w(false);
            bVar.m(dyVar);
            by k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.l);
            k.r(1);
            ThreadCardViewHolder<qx5> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.i);
            V(new h(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: e0 */
    public ThreadCardViewHolder<qx5> I(ViewGroup viewGroup, qx5 qx5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, viewGroup, qx5Var)) == null) {
            by.b bVar = new by.b(this.j.getPageActivity(), false);
            if (qx5Var.o) {
                ex exVar = new ex(this.j.getPageActivity());
                exVar.C(this.n, this.o);
                exVar.x(ImageViewerConfig.FROM_CONCERN);
                exVar.z(1);
                exVar.y(this.m);
                exVar.w(1);
                bVar.n(exVar);
            } else if (qx5Var.p) {
                ox oxVar = new ox(this.j.getPageActivity());
                oxVar.q(ImageViewerConfig.FROM_CONCERN);
                oxVar.r(this.m);
                bVar.n(oxVar);
            } else if (qx5Var.q) {
                lx lxVar = new lx(this.j.getPageActivity());
                lxVar.s(ImageViewerConfig.FROM_CONCERN);
                lxVar.t(this.m);
                bVar.n(lxVar);
            } else if (qx5Var.r) {
                px pxVar = new px(this.j.getPageActivity());
                pxVar.r(ImageViewerConfig.FROM_CONCERN);
                pxVar.s(this.m);
                bVar.n(pxVar);
            } else {
                boolean z = qx5Var.s;
            }
            by k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.l);
            k.r(1);
            ThreadCardViewHolder<qx5> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.i);
            V(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: f0 */
    public ThreadCardViewHolder<qx5> J(ViewGroup viewGroup, qx5 qx5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, viewGroup, qx5Var)) == null) {
            by.b bVar = new by.b(this.j.getPageActivity(), false);
            ix ixVar = new ix(this.j.getPageActivity());
            ixVar.z(2);
            ixVar.s();
            ixVar.w(true);
            bVar.h(ixVar);
            bVar.h(new xx(this.j.getPageActivity()));
            bVar.h(new qx(this.j.getPageActivity()));
            ax axVar = new ax(this.j.getPageActivity());
            axVar.t();
            bVar.h(axVar);
            dx dxVar = new dx(this.j.getPageActivity());
            dxVar.x(this.m);
            dxVar.w(ImageViewerConfig.FROM_CONCERN);
            bVar.h(dxVar);
            by k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.l);
            k.r(1);
            ThreadCardViewHolder<qx5> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.i);
            V(new g(this, ixVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    @Override // com.repackage.zi5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.k = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: g0 */
    public ThreadCardViewHolder<qx5> L(ViewGroup viewGroup, qx5 qx5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, viewGroup, qx5Var)) == null) {
            if (qx5Var == null) {
                return null;
            }
            by.b bVar = new by.b(this.j.getPageActivity());
            if (qx5Var.m) {
                tw twVar = new tw(this.j.getPageActivity());
                twVar.t(this.i);
                twVar.b(128);
                twVar.c(1024);
                twVar.s(new d(this));
                bVar.o(twVar);
            } else if (qx5Var.n) {
                bVar.o(new cx(this.j.getPageActivity()));
            }
            by k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.l);
            k.r(1);
            ThreadCardViewHolder<qx5> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.i);
            V(new e(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
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
    @Override // com.repackage.an
    /* renamed from: i0 */
    public View O(int i2, View view2, ViewGroup viewGroup, qx5 qx5Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, qx5Var, threadCardViewHolder})) == null) {
            if (qx5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || qx5Var.a == null) {
                return null;
            }
            qx5Var.I(qx5Var.position + 1);
            threadCardViewHolder.c().q(i2);
            if (threadCardViewHolder.c().f() instanceof dy) {
                ((dy) threadCardViewHolder.c().f()).B(new i(this, viewGroup, view2, i2));
            }
            if (threadCardViewHolder.c() instanceof yi5) {
                threadCardViewHolder.c().b(this.k);
            }
            threadCardViewHolder.u(false, Align.ALIGN_RIGHT_BOTTOM);
            threadCardViewHolder.g(qx5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.p);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: j0 */
    public View P(int i2, View view2, ViewGroup viewGroup, qx5 qx5Var, ThreadCardViewHolder<qx5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, qx5Var, threadCardViewHolder})) == null) {
            if (qx5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || qx5Var.a == null) {
                return null;
            }
            qx5Var.I(qx5Var.position + 1);
            fx5.b().a(qx5Var.f("c12351"));
            threadCardViewHolder.c().q(i2);
            if (threadCardViewHolder.c() instanceof yi5) {
                threadCardViewHolder.c().b(this.k);
            }
            if (qx5Var.p) {
                ox oxVar = (ox) threadCardViewHolder.c().g();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) oxVar.f.d.getLayoutParams();
                layoutParams.width = qx5Var.j;
                layoutParams.height = qx5Var.k;
                if (oxVar.f.d.getVisibility() != 8) {
                    oxVar.f.d.setLayoutParams(layoutParams);
                }
            }
            threadCardViewHolder.g(qx5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.p);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: k0 */
    public View Q(int i2, View view2, ViewGroup viewGroup, qx5 qx5Var, ThreadCardViewHolder<qx5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, qx5Var, threadCardViewHolder})) == null) {
            if (qx5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || qx5Var.a == null) {
                return null;
            }
            qx5Var.I(qx5Var.position + 1);
            threadCardViewHolder.c().q(i2);
            if (threadCardViewHolder.c() instanceof yi5) {
                threadCardViewHolder.c().b(this.k);
            }
            if (qx5Var.y) {
                fx5.b().a(new StatisticItem("c13424"));
            }
            threadCardViewHolder.g(qx5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.p);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: l0 */
    public View R(int i2, View view2, ViewGroup viewGroup, qx5 qx5Var, ThreadCardViewHolder<qx5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, qx5Var, threadCardViewHolder})) == null) {
            if (qx5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || qx5Var.a == null) {
                return null;
            }
            qx5Var.I(qx5Var.position + 1);
            threadCardViewHolder.c().q(i2);
            if (threadCardViewHolder.c() instanceof yi5) {
                threadCardViewHolder.c().b(this.k);
            }
            if (qx5Var.m) {
                threadCardViewHolder.u(true, Align.ALIGN_RIGHT_TOP);
            } else if (qx5Var.n) {
                fx5.b().a(qx5Var.B());
                xi5.c().a(qx5Var.B());
                sy6.h(qx5Var.a, this.i, qx5Var.n());
            }
            threadCardViewHolder.g(qx5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.p);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: m0 */
    public View S(int i2, View view2, ViewGroup viewGroup, qx5 qx5Var, ThreadCardViewHolder<qx5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, qx5Var, threadCardViewHolder})) == null) {
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void n0(View view2, qx5 qx5Var) {
        StatisticItem A;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, view2, qx5Var) == null) || view2 == null || qx5Var == null || qx5Var.getThreadData() == null || StringUtils.isNull(qx5Var.getThreadData().getTid())) {
            return;
        }
        int id = view2.getId();
        int i2 = 1;
        if (qx5Var.m) {
            if (id == R.id.obfuscated_res_0x7f091f85) {
                hs6.b(view2, qx5Var, 2);
            } else if (id != R.id.obfuscated_res_0x7f092266 && id != R.id.obfuscated_res_0x7f092285) {
                if (view2 instanceof TbImageView) {
                    hs6.b(view2, qx5Var, 3);
                }
            } else {
                hs6.b(view2, qx5Var, 1);
            }
        } else if (qx5Var.n) {
            fx5.b().d(true);
            if (id != R.id.obfuscated_res_0x7f090a1b && id != R.id.obfuscated_res_0x7f090a1a && id != R.id.obfuscated_res_0x7f090a1c && id != R.id.obfuscated_res_0x7f090a1d) {
                if (qx5Var.isVideoThreadType()) {
                    A = qx5Var.C();
                } else {
                    A = qx5Var.A();
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(A));
                xi5.c().i("page_concern", "clk_", A);
            } else {
                TiebaStatic.log(qx5Var.j());
                xi5.c().i("page_concern", "clk_", qx5Var.j());
                i2 = 9;
            }
            sy6.d(qx5Var.a, this.i, qx5Var.n(), i2);
        } else if (!qx5Var.o && !qx5Var.p && !qx5Var.q && !qx5Var.r) {
            if (qx5Var.v) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                if (threadCardViewHolder != null) {
                    ThreadCardUtils.jumpToPB((ym4) qx5Var.getThreadData(), view2.getContext(), 1, false);
                    threadCardViewHolder.c().o(new my.a(1));
                }
            } else if (qx5Var.x) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091f85) {
                    hs6.b(view2, qx5Var, 2);
                } else if (id == R.id.obfuscated_res_0x7f090a38) {
                    hs6.b(view2, qx5Var, 7);
                }
            } else if (qx5Var.y) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091f85) {
                    hs6.b(view2, qx5Var, 2);
                } else if (id == R.id.obfuscated_res_0x7f090c7b) {
                    StatisticItem statisticItem = new StatisticItem("c13423");
                    statisticItem.param("obj_locate", 4);
                    statisticItem.param("tid", qx5Var.g);
                    ThreadData threadData = qx5Var.a;
                    if (threadData != null && threadData.getTopAgreePost() != null) {
                        statisticItem.param("pid", qx5Var.a.getTopAgreePost().J());
                    }
                    TiebaStatic.log(statisticItem);
                } else if (id == R.id.obfuscated_res_0x7f090c76) {
                    StatisticItem statisticItem2 = new StatisticItem("c13423");
                    statisticItem2.param("obj_locate", 2);
                    statisticItem2.param("tid", qx5Var.g);
                    ThreadData threadData2 = qx5Var.a;
                    if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                        statisticItem2.param("pid", qx5Var.a.getTopAgreePost().J());
                    }
                    TiebaStatic.log(statisticItem2);
                } else if (id == R.id.obfuscated_res_0x7f090c79 || id == R.id.obfuscated_res_0x7f090c7a) {
                    StatisticItem statisticItem3 = new StatisticItem("c13423");
                    statisticItem3.param("obj_locate", 1);
                    statisticItem3.param("tid", qx5Var.g);
                    ThreadData threadData3 = qx5Var.a;
                    if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                        statisticItem3.param("pid", qx5Var.a.getTopAgreePost().J());
                    }
                    TiebaStatic.log(statisticItem3);
                } else if (id == R.id.obfuscated_res_0x7f090c75) {
                    StatisticItem statisticItem4 = new StatisticItem("c13423");
                    statisticItem4.param("obj_locate", 5);
                    statisticItem4.param("tid", qx5Var.g);
                    ThreadData threadData4 = qx5Var.a;
                    if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                        statisticItem4.param("pid", qx5Var.a.getTopAgreePost().J());
                    }
                    TiebaStatic.log(statisticItem4);
                } else if ((view2 instanceof TbImageView) && (view2.getTag(R.id.obfuscated_res_0x7f090c77) instanceof Integer)) {
                    StatisticItem statisticItem5 = new StatisticItem("c13423");
                    statisticItem5.param("obj_locate", 3);
                    statisticItem5.param("tid", qx5Var.g);
                    ThreadData threadData5 = qx5Var.a;
                    if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                        statisticItem5.param("pid", qx5Var.a.getTopAgreePost().J());
                    }
                    TiebaStatic.log(statisticItem5);
                }
            } else if (qx5Var.A && (view2.getId() == R.id.obfuscated_res_0x7f091f85 || view2.getId() == R.id.obfuscated_res_0x7f091f99)) {
                hs6.b(view2, qx5Var, 2);
            }
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091f85) {
            hs6.b(view2, qx5Var, 2);
        } else if (view2 instanceof TbImageView) {
            hs6.b(view2, qx5Var, 3);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091f86 || view2.getId() == R.id.obfuscated_res_0x7f091f78) {
            hs6.b(view2, qx5Var, 2);
        }
        if (id == R.id.obfuscated_res_0x7f091f99 || id == R.id.obfuscated_res_0x7f091f9b || id == R.id.obfuscated_res_0x7f091f9c) {
            hs6.b(view2, qx5Var, 8);
        }
    }

    public void o0(tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, tnVar) == null) {
            this.l = tnVar;
        }
    }

    @Override // com.repackage.an
    public BdUniqueId u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? qx5.M : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.an
    public BdUniqueId v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? qx5.I : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.an
    public BdUniqueId w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? qx5.L : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.an
    public BdUniqueId x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? qx5.D : (BdUniqueId) invokeV.objValue;
    }
}
