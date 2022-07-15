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
import com.repackage.ny;
import com.repackage.tw;
/* loaded from: classes5.dex */
public class at6 extends an<ny5, ThreadCardViewHolder<ny5>> implements ck5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public String k;
    public tn l;
    public boolean m;
    public eg<ImageView> n;
    public eg<GifView> o;
    public jy5<ny5> p;

    /* loaded from: classes5.dex */
    public class a implements fg<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ at6 a;

        public a(at6 at6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = at6Var;
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

    /* loaded from: classes5.dex */
    public class b implements fg<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ at6 a;

        public b(at6 at6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = at6Var;
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

    /* loaded from: classes5.dex */
    public class c extends jy5<ny5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ at6 b;

        public c(at6 at6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = at6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jy5
        /* renamed from: d */
        public void a(View view2, ny5 ny5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ny5Var) == null) {
                this.b.n0(view2, ny5Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements tw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(at6 at6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at6Var};
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
        }
    }

    /* loaded from: classes5.dex */
    public class e implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ at6 a;

        public e(at6 at6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = at6Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof gn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                gn gnVar = (gn) nnVar;
                if (gnVar.c() instanceof ny5) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    ny5 ny5Var = (ny5) gnVar.c();
                    ny5Var.f = 1;
                    if (this.a.p != null) {
                        this.a.p.a(threadCardViewHolder.b(), ny5Var);
                    }
                    if (kz6.a(this.a.j, gnVar.c())) {
                        return;
                    }
                    ThreadCardUtils.jumpToPB((nn4) ny5Var, view2.getContext(), 1, false, uw.a((tn) viewGroup, view2, i));
                    threadCardViewHolder.c().o(new ny.a(1));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ at6 a;

        public f(at6 at6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = at6Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof gn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                gn gnVar = (gn) nnVar;
                if (gnVar.c() instanceof ny5) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    ny5 ny5Var = (ny5) gnVar.c();
                    ny5Var.f = 1;
                    if (this.a.p != null) {
                        this.a.p.a(threadCardViewHolder.b(), ny5Var);
                    }
                    ThreadCardUtils.jumpToPB((nn4) ny5Var, view2.getContext(), 1, false);
                    threadCardViewHolder.c().o(new ny.a(1));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx a;
        public final /* synthetic */ at6 b;

        public g(at6 at6Var, jx jxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at6Var, jxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = at6Var;
            this.a = jxVar;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            ny5 ny5Var;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                boolean z = nnVar instanceof gn;
                if (z) {
                    gn gnVar = (gn) nnVar;
                    if ((gnVar.c() instanceof ny5) && nnVar != null && gnVar.c() != null && (ny5Var = (ny5) gnVar.c()) != null && (threadData = ny5Var.a) != null && ny5Var.u && threadData.getItem() != null) {
                        if (ny5Var.a.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                            BdToast b = BdToast.b(this.b.j.getContext(), this.b.j.getString(R.string.obfuscated_res_0x7f0f151b));
                            b.f(BdToast.ToastIcon.FAILURE);
                            b.h();
                            return;
                        }
                        int a = ev4.a(ny5Var.a.getItem().button_link_type.intValue(), ny5Var.a.getItem().apk_detail != null ? ny5Var.a.getItem().apk_detail.pkg_source.intValue() : 0);
                        ItemData itemData = new ItemData();
                        itemData.parseProto(ny5Var.a.getItem());
                        ItemCardHelper.q(this.a.v(), ny5Var.a.getItem().item_id.longValue(), this.a.u(itemData), ny5Var.a.getTid(), a, "", 2);
                        ItemClickJumpUtil.itemClickJump(ny5Var.a.getItem().forum_name, String.valueOf(ny5Var.a.getItem().item_id), 2, 2);
                        return;
                    }
                }
                if (z && (view2.getTag() instanceof ThreadCardViewHolder)) {
                    gn gnVar2 = (gn) nnVar;
                    if (gnVar2.c() instanceof ny5) {
                        ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                        ny5 ny5Var2 = (ny5) gnVar2.c();
                        ny5Var2.f = 1;
                        if (this.b.p != null) {
                            this.b.p.a(threadCardViewHolder.b(), ny5Var2);
                        }
                        ThreadCardUtils.jumpToPB((nn4) ny5Var2, view2.getContext(), 1, false, uw.a((tn) viewGroup, view2, i));
                        threadCardViewHolder.c().o(new ny.a(1));
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ at6 a;

        public h(at6 at6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = at6Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof gn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                gn gnVar = (gn) nnVar;
                if (gnVar.c() instanceof ny5) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    ny5 ny5Var = (ny5) gnVar.c();
                    ny5Var.f = 1;
                    if (this.a.p != null) {
                        this.a.p.a(threadCardViewHolder.b(), ny5Var);
                    }
                    ThreadCardUtils.jumpToPB((nn4) ny5Var, view2.getContext(), 1, false, uw.a((tn) viewGroup, view2, i));
                    threadCardViewHolder.c().o(new ny.a(1));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements ThreadCommentAndPraiseInfoLayout.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        public i(at6 at6Var, ViewGroup viewGroup, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at6Var, viewGroup, view2, Integer.valueOf(i)};
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
                ((PbActivityConfig) intentConfig).setVideoOriginArea(uw.a((tn) this.a, this.b, this.c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public at6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
            vy5.R = "c10705";
            vy5.S = "c10730";
            vy5.T = "c10731";
            vy5.U = "c10704";
            vy5.V = "c10755";
            vy5.W = "c10710";
            vy5.X = "c10736";
            vy5.Y = "c10737";
            vy5.Z = "c10711";
            vy5.g0 = "c10758";
            vy5.h0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: d0 */
    public ThreadCardViewHolder<ny5> H(ViewGroup viewGroup, ny5 ny5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, viewGroup, ny5Var)) == null) {
            cy.b bVar = new cy.b(this.j.getPageActivity(), false);
            ey eyVar = new ey(this.j.getPageActivity());
            tn4 tn4Var = new tn4();
            tn4Var.b = 9;
            tn4Var.h = 9;
            eyVar.w(tn4Var);
            eyVar.y(9);
            eyVar.E("personalize_page");
            eyVar.D(4);
            eyVar.z(1);
            eyVar.c(32);
            eyVar.x(false);
            bVar.m(eyVar);
            cy k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.l);
            k.r(1);
            ThreadCardViewHolder<ny5> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.i);
            V(new h(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: e0 */
    public ThreadCardViewHolder<ny5> I(ViewGroup viewGroup, ny5 ny5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, viewGroup, ny5Var)) == null) {
            cy.b bVar = new cy.b(this.j.getPageActivity(), false);
            if (ny5Var.o) {
                fx fxVar = new fx(this.j.getPageActivity());
                fxVar.D(this.n, this.o);
                fxVar.y(ImageViewerConfig.FROM_CONCERN);
                fxVar.A(1);
                fxVar.z(this.m);
                fxVar.x(1);
                bVar.n(fxVar);
            } else if (ny5Var.p) {
                px pxVar = new px(this.j.getPageActivity());
                pxVar.r(ImageViewerConfig.FROM_CONCERN);
                pxVar.s(this.m);
                bVar.n(pxVar);
            } else if (ny5Var.q) {
                mx mxVar = new mx(this.j.getPageActivity());
                mxVar.t(ImageViewerConfig.FROM_CONCERN);
                mxVar.u(this.m);
                bVar.n(mxVar);
            } else if (ny5Var.r) {
                qx qxVar = new qx(this.j.getPageActivity());
                qxVar.s(ImageViewerConfig.FROM_CONCERN);
                qxVar.t(this.m);
                bVar.n(qxVar);
            } else {
                boolean z = ny5Var.s;
            }
            cy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.l);
            k.r(1);
            ThreadCardViewHolder<ny5> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.i);
            V(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: f0 */
    public ThreadCardViewHolder<ny5> J(ViewGroup viewGroup, ny5 ny5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, viewGroup, ny5Var)) == null) {
            cy.b bVar = new cy.b(this.j.getPageActivity(), false);
            jx jxVar = new jx(this.j.getPageActivity());
            jxVar.A(2);
            jxVar.t();
            jxVar.x(true);
            bVar.h(jxVar);
            bVar.h(new yx(this.j.getPageActivity()));
            bVar.h(new rx(this.j.getPageActivity()));
            ax axVar = new ax(this.j.getPageActivity());
            axVar.u();
            bVar.h(axVar);
            ex exVar = new ex(this.j.getPageActivity());
            exVar.y(this.m);
            exVar.x(ImageViewerConfig.FROM_CONCERN);
            bVar.h(exVar);
            cy k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.l);
            k.r(1);
            ThreadCardViewHolder<ny5> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.i);
            V(new g(this, jxVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    @Override // com.repackage.ck5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.k = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: g0 */
    public ThreadCardViewHolder<ny5> L(ViewGroup viewGroup, ny5 ny5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, viewGroup, ny5Var)) == null) {
            if (ny5Var == null) {
                return null;
            }
            cy.b bVar = new cy.b(this.j.getPageActivity());
            if (ny5Var.m) {
                tw twVar = new tw(this.j.getPageActivity());
                twVar.u(this.i);
                twVar.c(128);
                twVar.d(1024);
                twVar.t(new d(this));
                bVar.o(twVar);
            } else if (ny5Var.n) {
                bVar.o(new cx(this.j.getPageActivity()));
            }
            cy k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.l);
            k.r(1);
            ThreadCardViewHolder<ny5> threadCardViewHolder = new ThreadCardViewHolder<>(k);
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
    public View O(int i2, View view2, ViewGroup viewGroup, ny5 ny5Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, ny5Var, threadCardViewHolder})) == null) {
            if (ny5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || ny5Var.a == null) {
                return null;
            }
            ny5Var.I(ny5Var.position + 1);
            threadCardViewHolder.c().q(i2);
            if (threadCardViewHolder.c().f() instanceof ey) {
                ((ey) threadCardViewHolder.c().f()).C(new i(this, viewGroup, view2, i2));
            }
            if (threadCardViewHolder.c() instanceof bk5) {
                threadCardViewHolder.c().b(this.k);
            }
            threadCardViewHolder.u(false, Align.ALIGN_RIGHT_BOTTOM);
            threadCardViewHolder.g(ny5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.p);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: j0 */
    public View P(int i2, View view2, ViewGroup viewGroup, ny5 ny5Var, ThreadCardViewHolder<ny5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, ny5Var, threadCardViewHolder})) == null) {
            if (ny5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || ny5Var.a == null) {
                return null;
            }
            ny5Var.I(ny5Var.position + 1);
            cy5.b().a(ny5Var.d("c12351"));
            threadCardViewHolder.c().q(i2);
            if (threadCardViewHolder.c() instanceof bk5) {
                threadCardViewHolder.c().b(this.k);
            }
            if (ny5Var.p) {
                px pxVar = (px) threadCardViewHolder.c().g();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pxVar.f.d.getLayoutParams();
                layoutParams.width = ny5Var.j;
                layoutParams.height = ny5Var.k;
                if (pxVar.f.d.getVisibility() != 8) {
                    pxVar.f.d.setLayoutParams(layoutParams);
                }
            }
            threadCardViewHolder.g(ny5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.p);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: k0 */
    public View Q(int i2, View view2, ViewGroup viewGroup, ny5 ny5Var, ThreadCardViewHolder<ny5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, ny5Var, threadCardViewHolder})) == null) {
            if (ny5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || ny5Var.a == null) {
                return null;
            }
            ny5Var.I(ny5Var.position + 1);
            threadCardViewHolder.c().q(i2);
            if (threadCardViewHolder.c() instanceof bk5) {
                threadCardViewHolder.c().b(this.k);
            }
            if (ny5Var.y) {
                cy5.b().a(new StatisticItem("c13424"));
            }
            threadCardViewHolder.g(ny5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.p);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: l0 */
    public View R(int i2, View view2, ViewGroup viewGroup, ny5 ny5Var, ThreadCardViewHolder<ny5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, ny5Var, threadCardViewHolder})) == null) {
            if (ny5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || ny5Var.a == null) {
                return null;
            }
            ny5Var.I(ny5Var.position + 1);
            threadCardViewHolder.c().q(i2);
            if (threadCardViewHolder.c() instanceof bk5) {
                threadCardViewHolder.c().b(this.k);
            }
            if (ny5Var.m) {
                threadCardViewHolder.u(true, Align.ALIGN_RIGHT_TOP);
            } else if (ny5Var.n) {
                cy5.b().a(ny5Var.B());
                ak5.c().a(ny5Var.B());
                iz6.i(ny5Var.a, this.i, ny5Var.m());
            }
            threadCardViewHolder.g(ny5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.p);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: m0 */
    public View S(int i2, View view2, ViewGroup viewGroup, ny5 ny5Var, ThreadCardViewHolder<ny5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, ny5Var, threadCardViewHolder})) == null) {
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void n0(View view2, ny5 ny5Var) {
        StatisticItem A;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, view2, ny5Var) == null) || view2 == null || ny5Var == null || ny5Var.getThreadData() == null || StringUtils.isNull(ny5Var.getThreadData().getTid())) {
            return;
        }
        int id = view2.getId();
        int i2 = 1;
        if (ny5Var.m) {
            if (id == R.id.obfuscated_res_0x7f09202a) {
                vs6.b(view2, ny5Var, 2);
            } else if (id != R.id.obfuscated_res_0x7f09230c && id != R.id.obfuscated_res_0x7f09232d) {
                if (view2 instanceof TbImageView) {
                    vs6.b(view2, ny5Var, 3);
                }
            } else {
                vs6.b(view2, ny5Var, 1);
            }
        } else if (ny5Var.n) {
            cy5.b().d(true);
            if (id != R.id.obfuscated_res_0x7f090a23 && id != R.id.obfuscated_res_0x7f090a22 && id != R.id.obfuscated_res_0x7f090a24 && id != R.id.obfuscated_res_0x7f090a25) {
                if (ny5Var.isVideoThreadType()) {
                    A = ny5Var.C();
                } else {
                    A = ny5Var.A();
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(A));
                ak5.c().i("page_concern", "clk_", A);
            } else {
                TiebaStatic.log(ny5Var.i());
                ak5.c().i("page_concern", "clk_", ny5Var.i());
                i2 = 9;
            }
            iz6.d(ny5Var.a, this.i, ny5Var.m(), i2);
        } else if (!ny5Var.o && !ny5Var.p && !ny5Var.q && !ny5Var.r) {
            if (ny5Var.v) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                if (threadCardViewHolder != null) {
                    ThreadCardUtils.jumpToPB((nn4) ny5Var.getThreadData(), view2.getContext(), 1, false);
                    threadCardViewHolder.c().o(new ny.a(1));
                }
            } else if (ny5Var.x) {
                if (view2.getId() == R.id.obfuscated_res_0x7f09202a) {
                    vs6.b(view2, ny5Var, 2);
                } else if (id == R.id.obfuscated_res_0x7f090a40) {
                    vs6.b(view2, ny5Var, 7);
                }
            } else if (ny5Var.y) {
                if (view2.getId() == R.id.obfuscated_res_0x7f09202a) {
                    vs6.b(view2, ny5Var, 2);
                } else if (id == R.id.obfuscated_res_0x7f090c84) {
                    StatisticItem statisticItem = new StatisticItem("c13423");
                    statisticItem.param("obj_locate", 4);
                    statisticItem.param("tid", ny5Var.g);
                    ThreadData threadData = ny5Var.a;
                    if (threadData != null && threadData.getTopAgreePost() != null) {
                        statisticItem.param("pid", ny5Var.a.getTopAgreePost().J());
                    }
                    TiebaStatic.log(statisticItem);
                } else if (id == R.id.obfuscated_res_0x7f090c7f) {
                    StatisticItem statisticItem2 = new StatisticItem("c13423");
                    statisticItem2.param("obj_locate", 2);
                    statisticItem2.param("tid", ny5Var.g);
                    ThreadData threadData2 = ny5Var.a;
                    if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                        statisticItem2.param("pid", ny5Var.a.getTopAgreePost().J());
                    }
                    TiebaStatic.log(statisticItem2);
                } else if (id == R.id.obfuscated_res_0x7f090c82 || id == R.id.obfuscated_res_0x7f090c83) {
                    StatisticItem statisticItem3 = new StatisticItem("c13423");
                    statisticItem3.param("obj_locate", 1);
                    statisticItem3.param("tid", ny5Var.g);
                    ThreadData threadData3 = ny5Var.a;
                    if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                        statisticItem3.param("pid", ny5Var.a.getTopAgreePost().J());
                    }
                    TiebaStatic.log(statisticItem3);
                } else if (id == R.id.obfuscated_res_0x7f090c7e) {
                    StatisticItem statisticItem4 = new StatisticItem("c13423");
                    statisticItem4.param("obj_locate", 5);
                    statisticItem4.param("tid", ny5Var.g);
                    ThreadData threadData4 = ny5Var.a;
                    if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                        statisticItem4.param("pid", ny5Var.a.getTopAgreePost().J());
                    }
                    TiebaStatic.log(statisticItem4);
                } else if ((view2 instanceof TbImageView) && (view2.getTag(R.id.obfuscated_res_0x7f090c80) instanceof Integer)) {
                    StatisticItem statisticItem5 = new StatisticItem("c13423");
                    statisticItem5.param("obj_locate", 3);
                    statisticItem5.param("tid", ny5Var.g);
                    ThreadData threadData5 = ny5Var.a;
                    if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                        statisticItem5.param("pid", ny5Var.a.getTopAgreePost().J());
                    }
                    TiebaStatic.log(statisticItem5);
                }
            } else if (ny5Var.A && (view2.getId() == R.id.obfuscated_res_0x7f09202a || view2.getId() == R.id.obfuscated_res_0x7f09203e)) {
                vs6.b(view2, ny5Var, 2);
            }
        } else if (view2.getId() == R.id.obfuscated_res_0x7f09202a) {
            vs6.b(view2, ny5Var, 2);
        } else if (view2 instanceof TbImageView) {
            vs6.b(view2, ny5Var, 3);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f09202b || view2.getId() == R.id.obfuscated_res_0x7f09201d) {
            vs6.b(view2, ny5Var, 2);
        }
        if (id == R.id.obfuscated_res_0x7f09203e || id == R.id.obfuscated_res_0x7f092040 || id == R.id.obfuscated_res_0x7f092041) {
            vs6.b(view2, ny5Var, 8);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? ny5.M : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.an
    public BdUniqueId v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? ny5.I : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.an
    public BdUniqueId w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? ny5.L : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.an
    public BdUniqueId x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? ny5.D : (BdUniqueId) invokeV.objValue;
    }
}
