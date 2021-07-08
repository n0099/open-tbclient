package d.a.p0.e1.c.e;

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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
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
import d.a.j.a0;
import d.a.j.d;
import d.a.j.h0;
import d.a.j.l0;
import d.a.j.n0;
import d.a.j.v0.a;
import d.a.o0.r.q.b2;
import d.a.p0.a0.b0;
/* loaded from: classes7.dex */
public class c extends d.a.c.k.e.a<d.a.p0.a0.e0.b, ThreadCardViewHolder<d.a.p0.a0.e0.b>> implements d.a.p0.o.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public d.a.c.k.e.s p;
    public boolean q;
    public d.a.c.e.k.b<ImageView> r;
    public d.a.c.e.k.b<GifView> s;
    public b0<d.a.p0.a0.e0.b> t;

    /* loaded from: classes7.dex */
    public class a implements d.a.c.e.k.c<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f55132a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55132a = cVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
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
                    if (d.a.o0.r.k.c().g()) {
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
        @Override // d.a.c.e.k.c
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
                    foreDrawableImageView.Q();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.f55132a.n.getPageActivity());
                boolean g2 = d.a.o0.r.k.c().g();
                foreDrawableImageView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                if (g2) {
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
                    foreDrawableImageView.Q();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    foreDrawableImageView.I();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.a.c.e.k.c<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f55133a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55133a = cVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
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
                if (d.a.o0.r.k.c().g()) {
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
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                gifView.c0();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.f55133a.n.getPageActivity());
                boolean g2 = d.a.o0.r.k.c().g();
                gifView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                if (g2) {
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
                gifView.g0();
                gifView.c0();
                gifView.setImageDrawable(null);
                gifView.h0();
                gifView.setBackgroundDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                return gifView;
            }
            return (GifView) invokeL.objValue;
        }
    }

    /* renamed from: d.a.p0.e1.c.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1327c extends b0<d.a.p0.a0.e0.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f55134b;

        public C1327c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55134b = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.a0.b0
        /* renamed from: d */
        public void a(View view, d.a.p0.a0.e0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, bVar) == null) {
                this.f55134b.x0(view, bVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.j.d.b
        public void a(d.a.o0.r.q.a aVar, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, view) == null) || aVar == null) {
                return;
            }
            if (view.getId() == R.id.user_name) {
                aVar.objType = 3;
            } else if (view.getId() == R.id.user_avatar) {
                aVar.objType = 4;
            } else {
                aVar.objType = 1;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements d.a.c.k.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f55135e;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55135e = cVar;
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof d.a.c.k.e.g) && (view.getTag() instanceof ThreadCardViewHolder)) {
                d.a.c.k.e.g gVar = (d.a.c.k.e.g) nVar;
                if (gVar.c() instanceof d.a.p0.a0.e0.b) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    d.a.p0.a0.e0.b bVar = (d.a.p0.a0.e0.b) gVar.c();
                    bVar.k = 1;
                    if (this.f55135e.t != null) {
                        this.f55135e.t.a(threadCardViewHolder.a(), bVar);
                    }
                    ThreadCardUtils.jumpToPB((d.a.o0.r.q.a) bVar, view.getContext(), 1, false, d.a.j.e.a((d.a.c.k.e.s) viewGroup, view, i2));
                    threadCardViewHolder.b().o(new a.C0611a(1));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements d.a.c.k.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f55136e;

        public f(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55136e = cVar;
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof d.a.c.k.e.g) && (view.getTag() instanceof ThreadCardViewHolder)) {
                d.a.c.k.e.g gVar = (d.a.c.k.e.g) nVar;
                if (gVar.c() instanceof d.a.p0.a0.e0.b) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    d.a.p0.a0.e0.b bVar = (d.a.p0.a0.e0.b) gVar.c();
                    bVar.k = 1;
                    if (this.f55136e.t != null) {
                        this.f55136e.t.a(threadCardViewHolder.a(), bVar);
                    }
                    ThreadCardUtils.jumpToPB((d.a.o0.r.q.a) bVar, view.getContext(), 1, false);
                    threadCardViewHolder.b().o(new a.C0611a(1));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements d.a.c.k.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f55137e;

        public g(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55137e = cVar;
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            d.a.p0.a0.e0.b bVar;
            b2 b2Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                boolean z = nVar instanceof d.a.c.k.e.g;
                if (z) {
                    d.a.c.k.e.g gVar = (d.a.c.k.e.g) nVar;
                    if ((gVar.c() instanceof d.a.p0.a0.e0.b) && nVar != null && gVar.c() != null && (bVar = (d.a.p0.a0.e0.b) gVar.c()) != null && (b2Var = bVar.f53795e) != null && bVar.y && b2Var.n0() != null) {
                        if (bVar.f53795e.getType() == b2.E3) {
                            BdToast.i(this.f55137e.n.getContext(), this.f55137e.n.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).q();
                            return;
                        } else {
                            ItemClickJumpUtil.itemClickJump(bVar.f53795e.n0().forum_name, String.valueOf(bVar.f53795e.n0().item_id), 2, 2);
                            return;
                        }
                    }
                }
                if (z && (view.getTag() instanceof ThreadCardViewHolder)) {
                    d.a.c.k.e.g gVar2 = (d.a.c.k.e.g) nVar;
                    if (gVar2.c() instanceof d.a.p0.a0.e0.b) {
                        ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                        d.a.p0.a0.e0.b bVar2 = (d.a.p0.a0.e0.b) gVar2.c();
                        bVar2.k = 1;
                        if (this.f55137e.t != null) {
                            this.f55137e.t.a(threadCardViewHolder.a(), bVar2);
                        }
                        ThreadCardUtils.jumpToPB((d.a.o0.r.q.a) bVar2, view.getContext(), 1, false, d.a.j.e.a((d.a.c.k.e.s) viewGroup, view, i2));
                        threadCardViewHolder.b().o(new a.C0611a(1));
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements d.a.c.k.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f55138e;

        public h(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55138e = cVar;
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof d.a.c.k.e.g) && (view.getTag() instanceof ThreadCardViewHolder)) {
                d.a.c.k.e.g gVar = (d.a.c.k.e.g) nVar;
                if (gVar.c() instanceof d.a.p0.a0.e0.b) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    d.a.p0.a0.e0.b bVar = (d.a.p0.a0.e0.b) gVar.c();
                    bVar.k = 1;
                    if (this.f55138e.t != null) {
                        this.f55138e.t.a(threadCardViewHolder.a(), bVar);
                    }
                    ThreadCardUtils.jumpToPB((d.a.o0.r.q.a) bVar, view.getContext(), 1, false, d.a.j.e.a((d.a.c.k.e.s) viewGroup, view, i2));
                    threadCardViewHolder.b().o(new a.C0611a(1));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements ThreadCommentAndPraiseInfoLayout.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f55139a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f55140b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f55141c;

        public i(c cVar, ViewGroup viewGroup, View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, viewGroup, view, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55139a = viewGroup;
            this.f55140b = view;
            this.f55141c = i2;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(d.a.j.e.a((d.a.c.k.e.s) this.f55139a, this.f55140b, this.f55141c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.q = true;
        this.r = new d.a.c.e.k.b<>(new a(this), 12, 0);
        this.s = new d.a.c.e.k.b<>(new b(this), 20, 0);
        this.t = new C1327c(this);
        this.n = tbPageContext;
        i0();
    }

    @Override // d.a.p0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.o = str;
        }
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            d.a.p0.a0.e0.k.W = "c10705";
            d.a.p0.a0.e0.k.X = "c10730";
            d.a.p0.a0.e0.k.Y = "c10731";
            d.a.p0.a0.e0.k.Z = "c10704";
            d.a.p0.a0.e0.k.a0 = "c10755";
            d.a.p0.a0.e0.k.b0 = "c10710";
            d.a.p0.a0.e0.k.c0 = "c10736";
            d.a.p0.a0.e0.k.i0 = "c10737";
            d.a.p0.a0.e0.k.j0 = "c10711";
            d.a.p0.a0.e0.k.k0 = "c10758";
            d.a.p0.a0.e0.k.l0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: j0 */
    public ThreadCardViewHolder<d.a.p0.a0.e0.b> M(ViewGroup viewGroup, d.a.p0.a0.e0.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, viewGroup, bVar)) == null) {
            l0.b bVar2 = new l0.b(this.n.getPageActivity(), false);
            n0 n0Var = new n0(this.n.getPageActivity());
            d.a.o0.r.q.f fVar = new d.a.o0.r.q.f();
            fVar.f52647b = 9;
            fVar.f52653h = 9;
            n0Var.v(fVar);
            n0Var.w(4);
            n0Var.B("personalize_page");
            n0Var.A(4);
            n0Var.x(1);
            n0Var.b(32);
            bVar2.m(n0Var);
            l0 k = bVar2.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.p);
            k.r(1);
            ThreadCardViewHolder<d.a.p0.a0.e0.b> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.m);
            a0(new h(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: k0 */
    public ThreadCardViewHolder<d.a.p0.a0.e0.b> N(ViewGroup viewGroup, d.a.p0.a0.e0.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, viewGroup, bVar)) == null) {
            l0.b bVar2 = new l0.b(this.n.getPageActivity(), false);
            if (bVar.t) {
                d.a.j.o oVar = new d.a.j.o(this.n.getPageActivity());
                oVar.D(this.r, this.s);
                oVar.x(ImageViewerConfig.FROM_CONCERN);
                oVar.z(1);
                oVar.y(this.q);
                oVar.w(1);
                bVar2.n(oVar);
            } else if (bVar.u) {
                d.a.j.y yVar = new d.a.j.y(this.n.getPageActivity());
                yVar.q(ImageViewerConfig.FROM_CONCERN);
                yVar.r(this.q);
                bVar2.n(yVar);
            } else if (bVar.v) {
                d.a.j.v vVar = new d.a.j.v(this.n.getPageActivity());
                vVar.v(ImageViewerConfig.FROM_CONCERN);
                vVar.w(this.q);
                bVar2.n(vVar);
            } else if (bVar.w) {
                d.a.j.z zVar = new d.a.j.z(this.n.getPageActivity());
                zVar.r(ImageViewerConfig.FROM_CONCERN);
                zVar.s(this.q);
                bVar2.n(zVar);
            } else {
                boolean z = bVar.x;
            }
            l0 k = bVar2.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.p);
            k.r(1);
            ThreadCardViewHolder<d.a.p0.a0.e0.b> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.m);
            a0(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: l0 */
    public ThreadCardViewHolder<d.a.p0.a0.e0.b> O(ViewGroup viewGroup, d.a.p0.a0.e0.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, viewGroup, bVar)) == null) {
            l0.b bVar2 = new l0.b(this.n.getPageActivity(), false);
            d.a.j.s sVar = new d.a.j.s(this.n.getPageActivity());
            sVar.x(2);
            sVar.s();
            sVar.u(true);
            bVar2.h(sVar);
            bVar2.h(new h0(this.n.getPageActivity()));
            bVar2.h(new a0(this.n.getPageActivity()));
            d.a.j.k kVar = new d.a.j.k(this.n.getPageActivity());
            kVar.t();
            bVar2.h(kVar);
            d.a.j.n nVar = new d.a.j.n(this.n.getPageActivity());
            nVar.x(this.q);
            nVar.w(ImageViewerConfig.FROM_CONCERN);
            bVar2.h(nVar);
            l0 k = bVar2.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.p);
            k.r(1);
            ThreadCardViewHolder<d.a.p0.a0.e0.b> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.m);
            a0(new g(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: m0 */
    public ThreadCardViewHolder<d.a.p0.a0.e0.b> P(ViewGroup viewGroup, d.a.p0.a0.e0.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, viewGroup, bVar)) == null) {
            if (bVar == null) {
                return null;
            }
            l0.b bVar2 = new l0.b(this.n.getPageActivity());
            if (bVar.r) {
                d.a.j.d dVar = new d.a.j.d(this.n.getPageActivity());
                dVar.t(this.m);
                dVar.b(128);
                dVar.c(1024);
                dVar.s(new d(this));
                bVar2.o(dVar);
            } else if (bVar.s) {
                bVar2.o(new d.a.j.m(this.n.getPageActivity()));
            }
            l0 k = bVar2.k(BaseCardInfo.SupportType.TOP, viewGroup, this.p);
            k.r(1);
            ThreadCardViewHolder<d.a.p0.a0.e0.b> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.m);
            a0(new e(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: p0 */
    public ThreadCardViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, viewGroup)) == null) {
            return null;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: q0 */
    public View S(int i2, View view, ViewGroup viewGroup, d.a.p0.a0.e0.b bVar, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, threadCardViewHolder})) == null) {
            if (bVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || bVar.f53795e == null) {
                return null;
            }
            bVar.I(bVar.position + 1);
            threadCardViewHolder.b().q(i2);
            if (threadCardViewHolder.b().e() instanceof n0) {
                ((n0) threadCardViewHolder.b().e()).z(new i(this, viewGroup, view, i2));
            }
            if (threadCardViewHolder.b() instanceof d.a.p0.o.e) {
                threadCardViewHolder.b().setPage(this.o);
            }
            threadCardViewHolder.s(false, Align.ALIGN_RIGHT_BOTTOM);
            threadCardViewHolder.f(bVar);
            threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.b().p(this.t);
            return threadCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: s0 */
    public View T(int i2, View view, ViewGroup viewGroup, d.a.p0.a0.e0.b bVar, ThreadCardViewHolder<d.a.p0.a0.e0.b> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, threadCardViewHolder})) == null) {
            if (bVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || bVar.f53795e == null) {
                return null;
            }
            bVar.I(bVar.position + 1);
            d.a.p0.a0.t.b().a(bVar.d("c12351"));
            threadCardViewHolder.b().q(i2);
            if (threadCardViewHolder.b() instanceof d.a.p0.o.e) {
                threadCardViewHolder.b().setPage(this.o);
            }
            if (bVar.u) {
                d.a.j.y yVar = (d.a.j.y) threadCardViewHolder.b().f();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) yVar.j.f4530h.getLayoutParams();
                layoutParams.width = bVar.o;
                layoutParams.height = bVar.p;
                if (yVar.j.f4530h.getVisibility() != 8) {
                    yVar.j.f4530h.setLayoutParams(layoutParams);
                }
            }
            threadCardViewHolder.f(bVar);
            threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.b().p(this.t);
            return threadCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: t0 */
    public View U(int i2, View view, ViewGroup viewGroup, d.a.p0.a0.e0.b bVar, ThreadCardViewHolder<d.a.p0.a0.e0.b> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, threadCardViewHolder})) == null) {
            if (bVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || bVar.f53795e == null) {
                return null;
            }
            bVar.I(bVar.position + 1);
            threadCardViewHolder.b().q(i2);
            if (threadCardViewHolder.b() instanceof d.a.p0.o.e) {
                threadCardViewHolder.b().setPage(this.o);
            }
            if (bVar.C) {
                d.a.p0.a0.t.b().a(new StatisticItem("c13424"));
            }
            threadCardViewHolder.f(bVar);
            threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.b().p(this.t);
            return threadCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // d.a.c.k.e.a
    public BdUniqueId v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? d.a.p0.a0.e0.b.Q : (BdUniqueId) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: v0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.p0.a0.e0.b bVar, ThreadCardViewHolder<d.a.p0.a0.e0.b> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, threadCardViewHolder})) == null) {
            if (bVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || bVar.f53795e == null) {
                return null;
            }
            bVar.I(bVar.position + 1);
            threadCardViewHolder.b().q(i2);
            if (threadCardViewHolder.b() instanceof d.a.p0.o.e) {
                threadCardViewHolder.b().setPage(this.o);
            }
            if (bVar.r) {
                threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP);
            } else if (bVar.s) {
                d.a.p0.a0.t.b().a(bVar.z());
                d.a.p0.o.d.c().a(bVar.z());
                d.a.p0.e1.h.m.a.c(bVar.f53795e, this.m, bVar.o());
            }
            threadCardViewHolder.f(bVar);
            threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.b().p(this.t);
            return threadCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // d.a.c.k.e.a
    public BdUniqueId w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? d.a.p0.a0.e0.b.M : (BdUniqueId) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: w0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.p0.a0.e0.b bVar, ThreadCardViewHolder<d.a.p0.a0.e0.b> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, threadCardViewHolder})) == null) {
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // d.a.c.k.e.a
    public BdUniqueId x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? d.a.p0.a0.e0.b.P : (BdUniqueId) invokeV.objValue;
    }

    public final void x0(View view, d.a.p0.a0.e0.b bVar) {
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048601, this, view, bVar) == null) || view == null || bVar == null || bVar.getThreadData() == null || StringUtils.isNull(bVar.getThreadData().n1())) {
            return;
        }
        int id = view.getId();
        int i2 = 1;
        if (bVar.r) {
            if (id == R.id.thread_card_root) {
                d.a.p0.e1.c.c.b(view, bVar, 2);
            } else if (id == R.id.user_avatar || id == R.id.user_name) {
                d.a.p0.e1.c.c.b(view, bVar, 1);
            }
        } else if (bVar.s) {
            d.a.p0.a0.t.b().d(true);
            if (id != R.id.forum_head_image && id != R.id.forum_head_barname && id != R.id.forum_head_info_attention && id != R.id.forum_head_info_thread) {
                if (bVar.E()) {
                    y = bVar.B();
                } else {
                    y = bVar.y();
                }
                TiebaStatic.log(y);
                d.a.p0.o.d.c().i("page_concern", "clk_", y);
            } else {
                TiebaStatic.log(bVar.h());
                d.a.p0.o.d.c().i("page_concern", "clk_", bVar.h());
                i2 = 9;
            }
            d.a.p0.e1.h.m.a.a(bVar.f53795e, this.m, bVar.o(), i2);
        } else if (!bVar.t && !bVar.u && !bVar.v && !bVar.w) {
            if (!bVar.y) {
                if (bVar.z) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    if (threadCardViewHolder != null) {
                        ThreadCardUtils.jumpToPB((d.a.o0.r.q.a) bVar.getThreadData(), view.getContext(), 1, false);
                        threadCardViewHolder.b().o(new a.C0611a(1));
                    }
                } else if (!bVar.A) {
                    if (bVar.B) {
                        if (view.getId() == R.id.thread_card_root) {
                            d.a.p0.e1.c.c.b(view, bVar, 2);
                        } else if (id == R.id.forum_name_text) {
                            d.a.p0.e1.c.c.b(view, bVar, 7);
                        }
                    } else if (bVar.C) {
                        if (view.getId() == R.id.thread_card_root) {
                            d.a.p0.e1.c.c.b(view, bVar, 2);
                        } else if (id == R.id.god_reply_voice_btn) {
                            StatisticItem statisticItem = new StatisticItem("c13423");
                            statisticItem.param("obj_locate", 4);
                            statisticItem.param("tid", bVar.l);
                            b2 b2Var = bVar.f53795e;
                            if (b2Var != null && b2Var.p1() != null) {
                                statisticItem.param("pid", bVar.f53795e.p1().E());
                            }
                            TiebaStatic.log(statisticItem);
                        } else if (id == R.id.god_reply_content) {
                            StatisticItem statisticItem2 = new StatisticItem("c13423");
                            statisticItem2.param("obj_locate", 2);
                            statisticItem2.param("tid", bVar.l);
                            b2 b2Var2 = bVar.f53795e;
                            if (b2Var2 != null && b2Var2.p1() != null) {
                                statisticItem2.param("pid", bVar.f53795e.p1().E());
                            }
                            TiebaStatic.log(statisticItem2);
                        } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                            if (id == R.id.god_reply_agree_view) {
                                StatisticItem statisticItem3 = new StatisticItem("c13423");
                                statisticItem3.param("obj_locate", 5);
                                statisticItem3.param("tid", bVar.l);
                                b2 b2Var3 = bVar.f53795e;
                                if (b2Var3 != null && b2Var3.p1() != null) {
                                    statisticItem3.param("pid", bVar.f53795e.p1().E());
                                }
                                TiebaStatic.log(statisticItem3);
                            } else if ((view instanceof TbImageView) && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
                                StatisticItem statisticItem4 = new StatisticItem("c13423");
                                statisticItem4.param("obj_locate", 3);
                                statisticItem4.param("tid", bVar.l);
                                b2 b2Var4 = bVar.f53795e;
                                if (b2Var4 != null && b2Var4.p1() != null) {
                                    statisticItem4.param("pid", bVar.f53795e.p1().E());
                                }
                                TiebaStatic.log(statisticItem4);
                            }
                        } else {
                            StatisticItem statisticItem5 = new StatisticItem("c13423");
                            statisticItem5.param("obj_locate", 1);
                            statisticItem5.param("tid", bVar.l);
                            b2 b2Var5 = bVar.f53795e;
                            if (b2Var5 != null && b2Var5.p1() != null) {
                                statisticItem5.param("pid", bVar.f53795e.p1().E());
                            }
                            TiebaStatic.log(statisticItem5);
                        }
                    } else if (bVar.E && (view.getId() == R.id.thread_card_root || view.getId() == R.id.thread_info_commont_container)) {
                        d.a.p0.e1.c.c.b(view, bVar, 2);
                    }
                }
            }
        } else if (view.getId() == R.id.thread_card_root) {
            d.a.p0.e1.c.c.b(view, bVar, 2);
        } else if (view instanceof TbImageView) {
            d.a.p0.e1.c.c.b(view, bVar, 3);
        } else if (view.getId() == R.id.thread_card_title || view.getId() == R.id.thread_card_abstract) {
            d.a.p0.e1.c.c.b(view, bVar, 2);
        }
        if (id == R.id.thread_info_commont_container || id == R.id.thread_info_commont_img || id == R.id.thread_info_commont_num) {
            d.a.p0.e1.c.c.b(view, bVar, 8);
        }
    }

    @Override // d.a.c.k.e.a
    public BdUniqueId y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? d.a.p0.a0.e0.b.H : (BdUniqueId) invokeV.objValue;
    }

    public void y0(d.a.c.k.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, sVar) == null) {
            this.p = sVar;
        }
    }
}
