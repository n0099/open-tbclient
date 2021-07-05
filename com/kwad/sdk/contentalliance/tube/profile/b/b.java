package com.kwad.sdk.contentalliance.tube.profile.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.tube.detail.TubeDetailParam;
import com.kwad.sdk.contentalliance.tube.episode.TubeEpisodeDetailParam;
import com.kwad.sdk.contentalliance.tube.model.TubeInfo;
import com.kwad.sdk.contentalliance.tube.model.TubeProfile;
import com.kwad.sdk.contentalliance.tube.model.TubeProfileResultData;
import com.kwad.sdk.contentalliance.tube.view.EpisodePhotoView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.contentalliance.tube.profile.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f35717b;

    /* renamed from: c  reason: collision with root package name */
    public TubeInfo f35718c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView.Adapter f35719d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.tube.profile.e f35720e;

    /* loaded from: classes7.dex */
    public class a extends RecyclerView.Adapter<C0420b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f35722a;

        /* renamed from: b  reason: collision with root package name */
        public LayoutInflater f35723b;

        /* renamed from: c  reason: collision with root package name */
        public com.kwad.sdk.lib.widget.b<AdTemplate> f35724c;

        public a(b bVar, Context context, @NonNull TubeProfile tubeProfile) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context, tubeProfile};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35722a = bVar;
            this.f35723b = LayoutInflater.from(context);
            com.kwad.sdk.lib.widget.b<AdTemplate> bVar2 = tubeProfile.adTemplateList;
            this.f35724c = bVar2 == null ? new com.kwad.sdk.lib.widget.b<>(new CopyOnWriteArrayList()) : bVar2.size() > 6 ? new com.kwad.sdk.lib.widget.b<>(new CopyOnWriteArrayList(tubeProfile.adTemplateList.subList(0, 6))) : new com.kwad.sdk.lib.widget.b<>(new CopyOnWriteArrayList(tubeProfile.adTemplateList));
        }

        private AdTemplate a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) ? this.f35724c.get(i2) : (AdTemplate) invokeI.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(TubeInfo tubeInfo, AdTemplate adTemplate) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, this, tubeInfo, adTemplate) == null) {
                TubeDetailParam tubeDetailParam = new TubeDetailParam();
                tubeDetailParam.mTubeInfo = tubeInfo;
                tubeDetailParam.mAdTemplate = adTemplate;
                if (((com.kwad.sdk.contentalliance.tube.profile.a.a) this.f35722a).f35705a.f35711f != null) {
                    tubeDetailParam.mEntryScene = ((com.kwad.sdk.contentalliance.tube.profile.a.a) this.f35722a).f35705a.f35711f.entryScene;
                }
                com.kwad.sdk.contentalliance.tube.detail.b.a(this.f35722a.o(), tubeDetailParam);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(List<AdTemplate> list, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, this, list, i2) == null) {
                com.kwad.sdk.contentalliance.tube.episode.b.a().a(list);
                TubeEpisodeDetailParam tubeEpisodeDetailParam = new TubeEpisodeDetailParam();
                if (((com.kwad.sdk.contentalliance.tube.profile.a.a) this.f35722a).f35705a.f35708c != null) {
                    tubeEpisodeDetailParam.mEntryScene = ((com.kwad.sdk.contentalliance.tube.profile.a.a) this.f35722a).f35705a.f35708c.mEntryScene;
                }
                tubeEpisodeDetailParam.mTubeId = this.f35722a.f35718c.tubeId;
                tubeEpisodeDetailParam.mTotalEpisodeCount = this.f35722a.f35718c.totalEpisodeCount;
                tubeEpisodeDetailParam.mSelectedPosition = i2;
                com.kwad.sdk.contentalliance.tube.episode.a.a(this.f35722a.o(), tubeEpisodeDetailParam);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public C0420b onCreateViewHolder(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i2)) == null) ? new C0420b((EpisodePhotoView) this.f35723b.inflate(R.layout.ksad_tube_trend_scroll_view_episode_photo, viewGroup, false)) : (C0420b) invokeLI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(C0420b c0420b, int i2) {
            EpisodePhotoView episodePhotoView;
            View.OnClickListener onClickListener;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c0420b, i2) == null) {
                com.kwad.sdk.core.d.a.a("TubeProfileEpisodeGridPresenter", "position =" + i2);
                AdTemplate a2 = a(i2);
                c0420b.f35730a.setRatio(1.29f);
                c0420b.f35730a.a(i2, this.f35722a.f35718c.tubeId);
                c0420b.f35730a.setTemplateData(a2);
                if (i2 != 5 || this.f35722a.f35718c.totalEpisodeCount <= 6) {
                    c0420b.f35730a.setLookMoreVisibility(false);
                    episodePhotoView = c0420b.f35730a;
                    onClickListener = new View.OnClickListener(this, a2, i2) { // from class: com.kwad.sdk.contentalliance.tube.profile.b.b.a.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AdTemplate f35727a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ int f35728b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ a f35729c;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, a2, Integer.valueOf(i2)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f35729c = this;
                            this.f35727a = a2;
                            this.f35728b = i2;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                com.kwad.sdk.core.report.e.a(this.f35727a, 1, "current_tube_list", (String) null);
                                a aVar = this.f35729c;
                                aVar.a(aVar.f35724c, this.f35728b);
                            }
                        }
                    };
                } else {
                    c0420b.f35730a.setLookMoreVisibility(true);
                    episodePhotoView = c0420b.f35730a;
                    onClickListener = new View.OnClickListener(this, a2) { // from class: com.kwad.sdk.contentalliance.tube.profile.b.b.a.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AdTemplate f35725a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ a f35726b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, a2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f35726b = this;
                            this.f35725a = a2;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                com.kwad.sdk.core.report.e.a(this.f35725a, "current_tube_list", (String) null);
                                a aVar = this.f35726b;
                                aVar.a(aVar.f35722a.f35718c, this.f35725a);
                            }
                        }
                    };
                }
                episodePhotoView.setOnClickListener(onClickListener);
                c0420b.f35730a.setId(i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f35724c.size() : invokeV.intValue;
        }
    }

    /* renamed from: com.kwad.sdk.contentalliance.tube.profile.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0420b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public EpisodePhotoView f35730a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0420b(View view) {
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
            this.f35730a = (EpisodePhotoView) view;
        }
    }

    public b() {
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
        this.f35720e = new com.kwad.sdk.contentalliance.tube.profile.e(this) { // from class: com.kwad.sdk.contentalliance.tube.profile.b.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f35721a;

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
                this.f35721a = this;
            }

            @Override // com.kwad.sdk.contentalliance.tube.profile.e
            public void a(@NonNull TubeProfileResultData tubeProfileResultData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, tubeProfileResultData) == null) {
                    this.f35721a.f35718c = tubeProfileResultData.tubeProfile.tubeInfo;
                    b bVar = this.f35721a;
                    bVar.f35719d = new a(bVar, bVar.o(), tubeProfileResultData.tubeProfile);
                    b bVar2 = this.f35721a;
                    bVar2.f35717b.setAdapter(bVar2.f35719d);
                    this.f35721a.f35717b.setVisibility(0);
                }
            }
        };
    }

    @Override // com.kwad.sdk.contentalliance.tube.profile.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.core.d.a.a("TubeProfileEpisodeGridPresenter", "TubeProfileEpisodeGridPresenter onBind");
            ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f35705a.f35710e.add(this.f35720e);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f35705a.f35710e.remove(this.f35720e);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            com.kwad.sdk.core.d.a.a("TubeProfileEpisodeGridPresenter", "TubeProfileEpisodeGridPresenter onCreate");
            RecyclerView recyclerView = (RecyclerView) b(R.id.ksad_tube_grid);
            this.f35717b = recyclerView;
            recyclerView.addItemDecoration(new com.kwad.sdk.contentalliance.tube.view.a(ao.a(o(), 2.0f)));
            this.f35717b.setLayoutManager(new GridLayoutManager(o(), 3));
        }
    }
}
