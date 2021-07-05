package com.kwad.sdk.contentalliance.tube.detail.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.tube.b;
import com.kwad.sdk.contentalliance.tube.episode.TubeEpisodeDetailParam;
import com.kwad.sdk.contentalliance.tube.model.TubeInfo;
import com.kwad.sdk.contentalliance.tube.view.EpisodePhotoView;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.p;
import com.kwad.sdk.utils.q;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.contentalliance.tube.detail.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public TubeInfo f35639b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f35640c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f35641d;

    /* renamed from: e  reason: collision with root package name */
    public b f35642e;

    /* renamed from: f  reason: collision with root package name */
    public View f35643f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f35644g;

    /* renamed from: h  reason: collision with root package name */
    public LottieAnimationView f35645h;

    /* renamed from: i  reason: collision with root package name */
    public StaggeredGridLayoutManager f35646i;
    public C0419a j;
    public b.a k;

    /* renamed from: com.kwad.sdk.contentalliance.tube.detail.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0419a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f35648a;

        public C0419a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35648a = aVar;
        }

        private int a(int[] iArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, iArr)) == null) {
                int length = iArr.length;
                int i2 = Integer.MIN_VALUE;
                for (int i3 = 0; i3 < length; i3++) {
                    if (iArr[i3] > i2) {
                        i2 = iArr[i3];
                    }
                }
                return i2;
            }
            return invokeL.intValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                com.kwad.sdk.core.d.a.a("EpisodeGridPresenter", "onScrolled dx=" + i2 + " dy=" + i3);
                boolean z = i3 > 0;
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
                com.kwad.sdk.core.d.a.a("EpisodeGridPresenter", " manager.getSpanCount()=" + staggeredGridLayoutManager.getSpanCount());
                int a2 = a(staggeredGridLayoutManager.findLastVisibleItemPositions(new int[staggeredGridLayoutManager.getSpanCount()]));
                int itemCount = staggeredGridLayoutManager.getItemCount();
                if (!z || a2 != itemCount - 1 || this.f35648a.f35642e.a() >= this.f35648a.f35639b.totalEpisodeCount || this.f35648a.f35640c.getAndSet(true)) {
                    return;
                }
                recyclerView.stopScroll();
                a aVar = this.f35648a;
                aVar.a(aVar.f35642e.b());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends RecyclerView.Adapter<c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public com.kwad.sdk.lib.widget.b<AdTemplate> f35649a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f35650b;

        /* renamed from: c  reason: collision with root package name */
        public LayoutInflater f35651c;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public b(a aVar, Context context) {
            this(aVar, context, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((a) objArr2[0], (Context) objArr2[1], (List) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public b(a aVar, Context context, List<AdTemplate> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, list};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f35650b = aVar;
            this.f35649a = new com.kwad.sdk.lib.widget.b<>(new CopyOnWriteArrayList());
            this.f35651c = LayoutInflater.from(context);
            a(list);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(65538, this, i2) == null) {
                com.kwad.sdk.contentalliance.tube.episode.b.a().a(this.f35649a);
                TubeEpisodeDetailParam tubeEpisodeDetailParam = new TubeEpisodeDetailParam();
                tubeEpisodeDetailParam.mEntryScene = ((com.kwad.sdk.contentalliance.tube.detail.a.a) this.f35650b).f35629a.f35631b.mEntryScene;
                tubeEpisodeDetailParam.mTubeId = ((com.kwad.sdk.contentalliance.tube.detail.a.a) this.f35650b).f35629a.f35631b.getTubeId();
                if (((com.kwad.sdk.contentalliance.tube.detail.a.a) this.f35650b).f35629a.f35631b.mTubeInfo != null) {
                    tubeEpisodeDetailParam.mTotalEpisodeCount = ((com.kwad.sdk.contentalliance.tube.detail.a.a) this.f35650b).f35629a.f35631b.mTubeInfo.totalEpisodeCount;
                }
                tubeEpisodeDetailParam.mSelectedPosition = i2;
                com.kwad.sdk.contentalliance.tube.episode.a.a(this.f35650b.o(), tubeEpisodeDetailParam);
            }
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                com.kwad.sdk.lib.widget.b<AdTemplate> bVar = this.f35649a;
                if (bVar != null) {
                    return bVar.size();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public c onCreateViewHolder(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) ? new c((EpisodePhotoView) this.f35651c.inflate(R.layout.ksad_tube_trend_scroll_view_episode_photo, viewGroup, false)) : (c) invokeLI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, cVar, i2) == null) {
                com.kwad.sdk.core.d.a.a("EpisodeGridPresenter", "position =" + i2);
                AdTemplate adTemplate = this.f35649a.get(i2);
                cVar.f35655a.setRatio(1.29f);
                cVar.f35655a.a(i2, this.f35650b.f35639b.tubeId);
                cVar.f35655a.setTemplateData(adTemplate);
                cVar.f35655a.setLookMoreVisibility(false);
                cVar.f35655a.setOnClickListener(new View.OnClickListener(this, adTemplate, i2) { // from class: com.kwad.sdk.contentalliance.tube.detail.b.a.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdTemplate f35652a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ int f35653b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ b f35654c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, adTemplate, Integer.valueOf(i2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f35654c = this;
                        this.f35652a = adTemplate;
                        this.f35653b = i2;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            com.kwad.sdk.core.report.e.b(this.f35652a, 1);
                            this.f35654c.a(this.f35653b);
                        }
                    }
                });
                cVar.f35655a.setId(i2);
            }
        }

        public void a(List<AdTemplate> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || list == null || list.isEmpty()) {
                return;
            }
            int size = this.f35649a.size();
            this.f35649a.addAll(list);
            notifyItemRangeChanged(size + 1, list.size());
        }

        public long b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                com.kwad.sdk.lib.widget.b<AdTemplate> bVar = this.f35649a;
                if (bVar == null || bVar.isEmpty()) {
                    return 0L;
                }
                com.kwad.sdk.lib.widget.b<AdTemplate> bVar2 = this.f35649a;
                return com.kwad.sdk.core.response.b.d.k(bVar2.get(bVar2.size() - 1).photoInfo);
            }
            return invokeV.longValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f35649a.size() : invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public EpisodePhotoView f35655a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35655a = (EpisodePhotoView) view;
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35640c = new AtomicBoolean(false);
        this.j = new C0419a(this);
        this.k = new b.a(this) { // from class: com.kwad.sdk.contentalliance.tube.detail.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f35647a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f35647a = this;
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void a(boolean z) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) && z) {
                    this.f35647a.e();
                }
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void a(boolean z, int i4, String str) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i4), str}) == null) && z) {
                    this.f35647a.f35640c.set(false);
                    if (com.kwad.sdk.core.network.f.f36358a.k == i4) {
                        p.a(this.f35647a.o());
                    } else if (com.kwad.sdk.core.network.f.f36364g.k != i4) {
                        p.b(this.f35647a.o());
                    }
                    this.f35647a.f();
                }
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void a(boolean z, @NonNull AdResultData adResultData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, adResultData) == null) {
                    com.kwad.sdk.core.d.a.a("EpisodeGridPresenter", "onSuccess  tubeFeedData item size=" + adResultData.adTemplateList.size());
                    this.f35647a.f35642e.a(adResultData.adTemplateList);
                    if (this.f35647a.f35642e.a() < this.f35647a.f35639b.totalEpisodeCount || !com.kwad.sdk.core.config.c.X()) {
                        this.f35647a.f35644g.setVisibility(4);
                        return;
                    }
                    this.f35647a.f35644g.setVisibility(0);
                    this.f35647a.f35644g.setText(q.a(this.f35647a.o()));
                }
            }

            @Override // com.kwad.sdk.contentalliance.tube.b.a
            public void b(boolean z) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeZ(1048579, this, z) == null) && z) {
                    this.f35647a.f35640c.set(false);
                    this.f35647a.f();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65537, this, j) == null) {
            for (com.kwad.sdk.contentalliance.tube.detail.a aVar : ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f35629a.f35634e) {
                aVar.a(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            if (!this.f35645h.c()) {
                this.f35645h.b();
            }
            this.f35645h.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            if (!this.f35645h.c()) {
                this.f35645h.d();
            }
            this.f35645h.setVisibility(4);
        }
    }

    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f35639b = ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f35629a.f35631b.mTubeInfo;
            this.f35641d.addOnScrollListener(this.j);
            ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f35629a.f35633d.add(this.k);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f35629a.f35633d.remove(this.k);
            this.f35641d.removeOnScrollListener(this.j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            com.kwad.sdk.core.d.a.a("EpisodeGridPresenter", "EpisodeGridPresenter onCreate");
            RecyclerView recyclerView = (RecyclerView) b(R.id.ksad_tube_recycler_view);
            this.f35641d = recyclerView;
            recyclerView.addItemDecoration(new com.kwad.sdk.contentalliance.tube.view.a(ao.a(o(), 2.0f)));
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, 1);
            this.f35646i = staggeredGridLayoutManager;
            this.f35641d.setLayoutManager(staggeredGridLayoutManager);
            b bVar = new b(this, o());
            this.f35642e = bVar;
            com.kwad.sdk.lib.widget.recycler.d dVar = new com.kwad.sdk.lib.widget.recycler.d(bVar);
            if (this.f35643f == null) {
                View a2 = ao.a((ViewGroup) this.f35641d, R.layout.ksad_tube_detail_grid_footer, false);
                this.f35643f = a2;
                TextView textView = (TextView) a2.findViewById(R.id.ksad_tube_detail_grid_no_more_tip);
                this.f35644g = textView;
                textView.setVisibility(4);
                LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f35643f.findViewById(R.id.ksad_tube_detail_grid_loading);
                this.f35645h = lottieAnimationView;
                lottieAnimationView.setVisibility(4);
                int i2 = R.raw.ksad_detail_loading_amin_new;
                this.f35645h.setRepeatMode(1);
                this.f35645h.setRepeatCount(-1);
                this.f35645h.setAnimation(i2);
            }
            if (!dVar.d(this.f35643f)) {
                dVar.c(this.f35643f);
            }
            this.f35643f.setVisibility(0);
            this.f35641d.setAdapter(dVar);
            this.f35641d.setVisibility(0);
            dVar.a(this.f35641d);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.d();
            f();
        }
    }
}
