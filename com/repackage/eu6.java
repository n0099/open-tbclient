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
import com.repackage.b00;
import com.repackage.m00;
import com.repackage.ty;
/* loaded from: classes6.dex */
public class eu6 extends ho<xx5, ThreadCardViewHolder<xx5>> implements qi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public String k;
    public zo l;
    public boolean m;
    public dg<ImageView> n;
    public dg<GifView> o;
    public tx5<xx5> p;

    /* loaded from: classes6.dex */
    public class a implements eg<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eu6 a;

        public a(eu6 eu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eu6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.eg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.eg
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
                    if (bn4.c().g()) {
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
        @Override // com.repackage.eg
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
        @Override // com.repackage.eg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.j.getPageActivity());
                boolean g = bn4.c().g();
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
    public class b implements eg<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eu6 a;

        public b(eu6 eu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eu6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.eg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.eg
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
                if (bn4.c().g()) {
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
        @Override // com.repackage.eg
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                gifView.Z();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.eg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.j.getPageActivity());
                boolean g = bn4.c().g();
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
                gifView.c0();
                gifView.Z();
                gifView.setImageDrawable(null);
                gifView.d0();
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
    public class c extends tx5<xx5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eu6 b;

        public c(eu6 eu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = eu6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.tx5
        /* renamed from: d */
        public void a(View view2, xx5 xx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, xx5Var) == null) {
                this.b.n0(view2, xx5Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ty.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(eu6 eu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.ty.b
        public void a(pn4 pn4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, pn4Var, view2) == null) || pn4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09229d) {
                pn4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09227b) {
                pn4Var.objType = 4;
            } else {
                pn4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements dp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eu6 a;

        public e(eu6 eu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eu6Var;
        }

        @Override // com.repackage.dp
        public void b(View view2, uo uoVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, uoVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (uoVar instanceof no) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                no noVar = (no) uoVar;
                if (noVar.e() instanceof xx5) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    xx5 xx5Var = (xx5) noVar.e();
                    xx5Var.f = 1;
                    if (this.a.p != null) {
                        this.a.p.a(threadCardViewHolder.b(), xx5Var);
                    }
                    if (h07.a(this.a.j, noVar.e())) {
                        return;
                    }
                    ThreadCardUtils.jumpToPB((pn4) xx5Var, view2.getContext(), 1, false, uy.a((zo) viewGroup, view2, i));
                    threadCardViewHolder.c().o(new m00.a(1));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements dp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eu6 a;

        public f(eu6 eu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eu6Var;
        }

        @Override // com.repackage.dp
        public void b(View view2, uo uoVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, uoVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (uoVar instanceof no) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                no noVar = (no) uoVar;
                if (noVar.e() instanceof xx5) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    xx5 xx5Var = (xx5) noVar.e();
                    xx5Var.f = 1;
                    if (this.a.p != null) {
                        this.a.p.a(threadCardViewHolder.b(), xx5Var);
                    }
                    ThreadCardUtils.jumpToPB((pn4) xx5Var, view2.getContext(), 1, false);
                    threadCardViewHolder.c().o(new m00.a(1));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements dp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz a;
        public final /* synthetic */ eu6 b;

        public g(eu6 eu6Var, iz izVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eu6Var, izVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = eu6Var;
            this.a = izVar;
        }

        @Override // com.repackage.dp
        public void b(View view2, uo uoVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            xx5 xx5Var;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, uoVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                boolean z = uoVar instanceof no;
                if (z) {
                    no noVar = (no) uoVar;
                    if ((noVar.e() instanceof xx5) && uoVar != null && noVar.e() != null && (xx5Var = (xx5) noVar.e()) != null && (threadData = xx5Var.a) != null && xx5Var.u && threadData.getItem() != null) {
                        if (xx5Var.a.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                            BdToast.i(this.b.j.getContext(), this.b.j.getString(R.string.obfuscated_res_0x7f0f14d7), R.drawable.obfuscated_res_0x7f0809a9, true).q();
                            return;
                        }
                        int a = uu4.a(xx5Var.a.getItem().button_link_type.intValue(), xx5Var.a.getItem().apk_detail != null ? xx5Var.a.getItem().apk_detail.pkg_source.intValue() : 0);
                        ItemData itemData = new ItemData();
                        itemData.parseProto(xx5Var.a.getItem());
                        ItemCardHelper.q(this.a.u(), xx5Var.a.getItem().item_id.longValue(), this.a.t(itemData), xx5Var.a.getTid(), a, "", 2);
                        ItemClickJumpUtil.itemClickJump(xx5Var.a.getItem().forum_name, String.valueOf(xx5Var.a.getItem().item_id), 2, 2);
                        return;
                    }
                }
                if (z && (view2.getTag() instanceof ThreadCardViewHolder)) {
                    no noVar2 = (no) uoVar;
                    if (noVar2.e() instanceof xx5) {
                        ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                        xx5 xx5Var2 = (xx5) noVar2.e();
                        xx5Var2.f = 1;
                        if (this.b.p != null) {
                            this.b.p.a(threadCardViewHolder.b(), xx5Var2);
                        }
                        ThreadCardUtils.jumpToPB((pn4) xx5Var2, view2.getContext(), 1, false, uy.a((zo) viewGroup, view2, i));
                        threadCardViewHolder.c().o(new m00.a(1));
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements dp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eu6 a;

        public h(eu6 eu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eu6Var;
        }

        @Override // com.repackage.dp
        public void b(View view2, uo uoVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, uoVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (uoVar instanceof no) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                no noVar = (no) uoVar;
                if (noVar.e() instanceof xx5) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    xx5 xx5Var = (xx5) noVar.e();
                    xx5Var.f = 1;
                    if (this.a.p != null) {
                        this.a.p.a(threadCardViewHolder.b(), xx5Var);
                    }
                    ThreadCardUtils.jumpToPB((pn4) xx5Var, view2.getContext(), 1, false, uy.a((zo) viewGroup, view2, i));
                    threadCardViewHolder.c().o(new m00.a(1));
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

        public i(eu6 eu6Var, ViewGroup viewGroup, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eu6Var, viewGroup, view2, Integer.valueOf(i)};
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
                ((PbActivityConfig) intentConfig).setVideoOriginArea(uy.a((zo) this.a, this.b, this.c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eu6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.n = new dg<>(new a(this), 12, 0);
        this.o = new dg<>(new b(this), 20, 0);
        this.p = new c(this);
        this.j = tbPageContext;
        c0();
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            fy5.R = "c10705";
            fy5.S = "c10730";
            fy5.T = "c10731";
            fy5.U = "c10704";
            fy5.V = "c10755";
            fy5.W = "c10710";
            fy5.X = "c10736";
            fy5.Y = "c10737";
            fy5.Z = "c10711";
            fy5.g0 = "c10758";
            fy5.h0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: d0 */
    public ThreadCardViewHolder<xx5> I(ViewGroup viewGroup, xx5 xx5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, viewGroup, xx5Var)) == null) {
            b00.b bVar = new b00.b(this.j.getPageActivity(), false);
            d00 d00Var = new d00(this.j.getPageActivity());
            vn4 vn4Var = new vn4();
            vn4Var.b = 9;
            vn4Var.h = 9;
            d00Var.v(vn4Var);
            d00Var.x(9);
            d00Var.D("personalize_page");
            d00Var.C(4);
            d00Var.y(1);
            d00Var.b(32);
            d00Var.w(false);
            bVar.m(d00Var);
            b00 k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.l);
            k.r(1);
            ThreadCardViewHolder<xx5> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.i);
            V(new h(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: e0 */
    public ThreadCardViewHolder<xx5> J(ViewGroup viewGroup, xx5 xx5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, viewGroup, xx5Var)) == null) {
            b00.b bVar = new b00.b(this.j.getPageActivity(), false);
            if (xx5Var.o) {
                ez ezVar = new ez(this.j.getPageActivity());
                ezVar.C(this.n, this.o);
                ezVar.x(ImageViewerConfig.FROM_CONCERN);
                ezVar.z(1);
                ezVar.y(this.m);
                ezVar.w(1);
                bVar.n(ezVar);
            } else if (xx5Var.p) {
                oz ozVar = new oz(this.j.getPageActivity());
                ozVar.q(ImageViewerConfig.FROM_CONCERN);
                ozVar.r(this.m);
                bVar.n(ozVar);
            } else if (xx5Var.q) {
                lz lzVar = new lz(this.j.getPageActivity());
                lzVar.s(ImageViewerConfig.FROM_CONCERN);
                lzVar.t(this.m);
                bVar.n(lzVar);
            } else if (xx5Var.r) {
                pz pzVar = new pz(this.j.getPageActivity());
                pzVar.r(ImageViewerConfig.FROM_CONCERN);
                pzVar.s(this.m);
                bVar.n(pzVar);
            } else {
                boolean z = xx5Var.s;
            }
            b00 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.l);
            k.r(1);
            ThreadCardViewHolder<xx5> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.i);
            V(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: f0 */
    public ThreadCardViewHolder<xx5> K(ViewGroup viewGroup, xx5 xx5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, viewGroup, xx5Var)) == null) {
            b00.b bVar = new b00.b(this.j.getPageActivity(), false);
            iz izVar = new iz(this.j.getPageActivity());
            izVar.z(2);
            izVar.s();
            izVar.w(true);
            bVar.h(izVar);
            bVar.h(new xz(this.j.getPageActivity()));
            bVar.h(new qz(this.j.getPageActivity()));
            az azVar = new az(this.j.getPageActivity());
            azVar.t();
            bVar.h(azVar);
            dz dzVar = new dz(this.j.getPageActivity());
            dzVar.x(this.m);
            dzVar.w(ImageViewerConfig.FROM_CONCERN);
            bVar.h(dzVar);
            b00 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.l);
            k.r(1);
            ThreadCardViewHolder<xx5> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.i);
            V(new g(this, izVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    @Override // com.repackage.qi5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.k = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: g0 */
    public ThreadCardViewHolder<xx5> L(ViewGroup viewGroup, xx5 xx5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, viewGroup, xx5Var)) == null) {
            if (xx5Var == null) {
                return null;
            }
            b00.b bVar = new b00.b(this.j.getPageActivity());
            if (xx5Var.m) {
                ty tyVar = new ty(this.j.getPageActivity());
                tyVar.t(this.i);
                tyVar.b(128);
                tyVar.c(1024);
                tyVar.s(new d(this));
                bVar.o(tyVar);
            } else if (xx5Var.n) {
                bVar.o(new cz(this.j.getPageActivity()));
            }
            b00 k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.l);
            k.r(1);
            ThreadCardViewHolder<xx5> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.i);
            V(new e(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
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
    @Override // com.repackage.ho
    /* renamed from: i0 */
    public View O(int i2, View view2, ViewGroup viewGroup, xx5 xx5Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, xx5Var, threadCardViewHolder})) == null) {
            if (xx5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || xx5Var.a == null) {
                return null;
            }
            xx5Var.I(xx5Var.position + 1);
            threadCardViewHolder.c().q(i2);
            if (threadCardViewHolder.c().f() instanceof d00) {
                ((d00) threadCardViewHolder.c().f()).B(new i(this, viewGroup, view2, i2));
            }
            if (threadCardViewHolder.c() instanceof pi5) {
                threadCardViewHolder.c().b(this.k);
            }
            threadCardViewHolder.v(false, Align.ALIGN_RIGHT_BOTTOM);
            threadCardViewHolder.g(xx5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.p);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: j0 */
    public View P(int i2, View view2, ViewGroup viewGroup, xx5 xx5Var, ThreadCardViewHolder<xx5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, xx5Var, threadCardViewHolder})) == null) {
            if (xx5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || xx5Var.a == null) {
                return null;
            }
            xx5Var.I(xx5Var.position + 1);
            mx5.b().a(xx5Var.g("c12351"));
            threadCardViewHolder.c().q(i2);
            if (threadCardViewHolder.c() instanceof pi5) {
                threadCardViewHolder.c().b(this.k);
            }
            if (xx5Var.p) {
                oz ozVar = (oz) threadCardViewHolder.c().g();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ozVar.f.d.getLayoutParams();
                layoutParams.width = xx5Var.j;
                layoutParams.height = xx5Var.k;
                if (ozVar.f.d.getVisibility() != 8) {
                    ozVar.f.d.setLayoutParams(layoutParams);
                }
            }
            threadCardViewHolder.g(xx5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.p);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: k0 */
    public View Q(int i2, View view2, ViewGroup viewGroup, xx5 xx5Var, ThreadCardViewHolder<xx5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, xx5Var, threadCardViewHolder})) == null) {
            if (xx5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || xx5Var.a == null) {
                return null;
            }
            xx5Var.I(xx5Var.position + 1);
            threadCardViewHolder.c().q(i2);
            if (threadCardViewHolder.c() instanceof pi5) {
                threadCardViewHolder.c().b(this.k);
            }
            if (xx5Var.y) {
                mx5.b().a(new StatisticItem("c13424"));
            }
            threadCardViewHolder.g(xx5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.p);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: l0 */
    public View R(int i2, View view2, ViewGroup viewGroup, xx5 xx5Var, ThreadCardViewHolder<xx5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, xx5Var, threadCardViewHolder})) == null) {
            if (xx5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || xx5Var.a == null) {
                return null;
            }
            xx5Var.I(xx5Var.position + 1);
            threadCardViewHolder.c().q(i2);
            if (threadCardViewHolder.c() instanceof pi5) {
                threadCardViewHolder.c().b(this.k);
            }
            if (xx5Var.m) {
                threadCardViewHolder.v(true, Align.ALIGN_RIGHT_TOP);
            } else if (xx5Var.n) {
                mx5.b().a(xx5Var.B());
                oi5.c().a(xx5Var.B());
                f07.h(xx5Var.a, this.i, xx5Var.q());
            }
            threadCardViewHolder.g(xx5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.p);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: m0 */
    public View S(int i2, View view2, ViewGroup viewGroup, xx5 xx5Var, ThreadCardViewHolder<xx5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, xx5Var, threadCardViewHolder})) == null) {
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void n0(View view2, xx5 xx5Var) {
        StatisticItem A;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, view2, xx5Var) == null) || view2 == null || xx5Var == null || xx5Var.getThreadData() == null || StringUtils.isNull(xx5Var.getThreadData().getTid())) {
            return;
        }
        int id = view2.getId();
        int i2 = 1;
        if (xx5Var.m) {
            if (id == R.id.obfuscated_res_0x7f091f87) {
                au6.b(view2, xx5Var, 2);
            } else if (id == R.id.obfuscated_res_0x7f09227b || id == R.id.obfuscated_res_0x7f09229d) {
                au6.b(view2, xx5Var, 1);
            }
        } else if (xx5Var.n) {
            mx5.b().d(true);
            if (id != R.id.obfuscated_res_0x7f090a4c && id != R.id.obfuscated_res_0x7f090a4b && id != R.id.obfuscated_res_0x7f090a4d && id != R.id.obfuscated_res_0x7f090a4e) {
                if (xx5Var.isVideoThreadType()) {
                    A = xx5Var.C();
                } else {
                    A = xx5Var.A();
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(A));
                oi5.c().i("page_concern", "clk_", A);
            } else {
                TiebaStatic.log(xx5Var.k());
                oi5.c().i("page_concern", "clk_", xx5Var.k());
                i2 = 9;
            }
            f07.d(xx5Var.a, this.i, xx5Var.q(), i2);
        } else if (!xx5Var.o && !xx5Var.p && !xx5Var.q && !xx5Var.r) {
            if (xx5Var.v) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                if (threadCardViewHolder != null) {
                    ThreadCardUtils.jumpToPB((pn4) xx5Var.getThreadData(), view2.getContext(), 1, false);
                    threadCardViewHolder.c().o(new m00.a(1));
                }
            } else if (xx5Var.x) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091f87) {
                    au6.b(view2, xx5Var, 2);
                } else if (id == R.id.obfuscated_res_0x7f090a6b) {
                    au6.b(view2, xx5Var, 7);
                }
            } else if (xx5Var.y) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091f87) {
                    au6.b(view2, xx5Var, 2);
                } else if (id == R.id.obfuscated_res_0x7f090cdb) {
                    StatisticItem statisticItem = new StatisticItem("c13423");
                    statisticItem.param("obj_locate", 4);
                    statisticItem.param("tid", xx5Var.g);
                    ThreadData threadData = xx5Var.a;
                    if (threadData != null && threadData.getTopAgreePost() != null) {
                        statisticItem.param("pid", xx5Var.a.getTopAgreePost().I());
                    }
                    TiebaStatic.log(statisticItem);
                } else if (id == R.id.obfuscated_res_0x7f090cd6) {
                    StatisticItem statisticItem2 = new StatisticItem("c13423");
                    statisticItem2.param("obj_locate", 2);
                    statisticItem2.param("tid", xx5Var.g);
                    ThreadData threadData2 = xx5Var.a;
                    if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                        statisticItem2.param("pid", xx5Var.a.getTopAgreePost().I());
                    }
                    TiebaStatic.log(statisticItem2);
                } else if (id == R.id.obfuscated_res_0x7f090cd9 || id == R.id.obfuscated_res_0x7f090cda) {
                    StatisticItem statisticItem3 = new StatisticItem("c13423");
                    statisticItem3.param("obj_locate", 1);
                    statisticItem3.param("tid", xx5Var.g);
                    ThreadData threadData3 = xx5Var.a;
                    if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                        statisticItem3.param("pid", xx5Var.a.getTopAgreePost().I());
                    }
                    TiebaStatic.log(statisticItem3);
                } else if (id == R.id.obfuscated_res_0x7f090cd5) {
                    StatisticItem statisticItem4 = new StatisticItem("c13423");
                    statisticItem4.param("obj_locate", 5);
                    statisticItem4.param("tid", xx5Var.g);
                    ThreadData threadData4 = xx5Var.a;
                    if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                        statisticItem4.param("pid", xx5Var.a.getTopAgreePost().I());
                    }
                    TiebaStatic.log(statisticItem4);
                } else if ((view2 instanceof TbImageView) && (view2.getTag(R.id.obfuscated_res_0x7f090cd7) instanceof Integer)) {
                    StatisticItem statisticItem5 = new StatisticItem("c13423");
                    statisticItem5.param("obj_locate", 3);
                    statisticItem5.param("tid", xx5Var.g);
                    ThreadData threadData5 = xx5Var.a;
                    if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                        statisticItem5.param("pid", xx5Var.a.getTopAgreePost().I());
                    }
                    TiebaStatic.log(statisticItem5);
                }
            } else if (xx5Var.A && (view2.getId() == R.id.obfuscated_res_0x7f091f87 || view2.getId() == R.id.obfuscated_res_0x7f091f99)) {
                au6.b(view2, xx5Var, 2);
            }
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091f87) {
            au6.b(view2, xx5Var, 2);
        } else if (view2 instanceof TbImageView) {
            au6.b(view2, xx5Var, 3);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091f88 || view2.getId() == R.id.obfuscated_res_0x7f091f7a) {
            au6.b(view2, xx5Var, 2);
        }
        if (id == R.id.obfuscated_res_0x7f091f99 || id == R.id.obfuscated_res_0x7f091f9b || id == R.id.obfuscated_res_0x7f091f9c) {
            au6.b(view2, xx5Var, 8);
        }
    }

    public void o0(zo zoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, zoVar) == null) {
            this.l = zoVar;
        }
    }

    @Override // com.repackage.ho
    public BdUniqueId v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? xx5.M : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.ho
    public BdUniqueId w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? xx5.I : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.ho
    public BdUniqueId x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? xx5.L : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.ho
    public BdUniqueId y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? xx5.D : (BdUniqueId) invokeV.objValue;
    }
}
