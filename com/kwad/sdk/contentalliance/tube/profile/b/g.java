package com.kwad.sdk.contentalliance.tube.profile.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
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
import com.kwad.sdk.contentalliance.tube.view.TrendTubeScrollView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.q;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public class g extends com.kwad.sdk.contentalliance.tube.profile.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f35762b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35763c;

    /* renamed from: d  reason: collision with root package name */
    public TubeInfo f35764d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.d f35765e;

    /* renamed from: f  reason: collision with root package name */
    public View f35766f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.tube.profile.e f35767g;

    /* loaded from: classes7.dex */
    public class a extends RecyclerView.Adapter<b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f35769a;

        /* renamed from: b  reason: collision with root package name */
        public LayoutInflater f35770b;

        /* renamed from: c  reason: collision with root package name */
        public List<TubeProfile> f35771c;

        public a(g gVar, Context context, @NonNull List<TubeProfile> list) {
            com.kwad.sdk.lib.widget.b<AdTemplate> bVar;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, context, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35769a = gVar;
            this.f35770b = LayoutInflater.from(context);
            this.f35771c = new CopyOnWriteArrayList();
            for (TubeProfile tubeProfile : list) {
                if (tubeProfile != null && (bVar = tubeProfile.adTemplateList) != null && !bVar.isEmpty()) {
                    this.f35771c.add(tubeProfile);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(TubeInfo tubeInfo, AdTemplate adTemplate) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, this, tubeInfo, adTemplate) == null) {
                TubeDetailParam tubeDetailParam = new TubeDetailParam();
                tubeDetailParam.mTubeInfo = tubeInfo;
                tubeDetailParam.mAdTemplate = adTemplate;
                if (((com.kwad.sdk.contentalliance.tube.profile.a.a) this.f35769a).f35705a.f35711f != null) {
                    tubeDetailParam.mEntryScene = ((com.kwad.sdk.contentalliance.tube.profile.a.a) this.f35769a).f35705a.f35711f.entryScene;
                }
                com.kwad.sdk.contentalliance.tube.detail.b.a(this.f35769a.o(), tubeDetailParam);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(List<AdTemplate> list, int i2, int i3, TubeProfile tubeProfile) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65540, this, new Object[]{list, Integer.valueOf(i2), Integer.valueOf(i3), tubeProfile}) == null) {
                com.kwad.sdk.contentalliance.tube.episode.b.a().a(list);
                TubeEpisodeDetailParam tubeEpisodeDetailParam = new TubeEpisodeDetailParam();
                if (((com.kwad.sdk.contentalliance.tube.profile.a.a) this.f35769a).f35705a.f35708c != null) {
                    tubeEpisodeDetailParam.mEntryScene = ((com.kwad.sdk.contentalliance.tube.profile.a.a) this.f35769a).f35705a.f35708c.mEntryScene;
                }
                TubeInfo tubeInfo = tubeProfile.tubeInfo;
                tubeEpisodeDetailParam.mTubeId = tubeInfo.tubeId;
                tubeEpisodeDetailParam.mTotalEpisodeCount = tubeInfo.totalEpisodeCount;
                tubeEpisodeDetailParam.mSelectedPosition = i3;
                com.kwad.sdk.contentalliance.tube.episode.a.a(this.f35769a.o(), tubeEpisodeDetailParam);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public b onCreateViewHolder(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i2)) == null) ? new b(this.f35770b.inflate(R.layout.ksad_tube_trend_item_container, viewGroup, false)) : (b) invokeLI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(b bVar, int i2) {
            TextView textView;
            String format;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, i2) == null) {
                TubeProfile tubeProfile = this.f35771c.get(i2);
                TubeInfo tubeInfo = tubeProfile.tubeInfo;
                com.kwad.sdk.lib.widget.b<AdTemplate> bVar2 = tubeProfile.adTemplateList;
                List<String> list = tubeInfo.tagList;
                if (list == null || list.isEmpty()) {
                    bVar.f35784d.setVisibility(8);
                } else {
                    bVar.f35784d.setText(tubeInfo.tagList.get(0));
                    bVar.f35784d.setVisibility(0);
                }
                String string = this.f35769a.o().getString(R.string.ksad_text_placeholder);
                if (TextUtils.isEmpty(tubeInfo.name)) {
                    bVar.f35783c.setText(string);
                    bVar.f35787g.setVisibility(8);
                } else {
                    bVar.f35783c.setText(tubeInfo.name);
                    bVar.f35787g.setVisibility(0);
                }
                int i3 = tubeInfo.totalEpisodeCount;
                String valueOf = i3 < 0 ? "" : String.valueOf(i3);
                bVar.f35785e.setText(ag.a(tubeInfo.authorName, string));
                if (tubeInfo.isFinished) {
                    String string2 = this.f35769a.o().getString(R.string.ksad_tube_update_finished_format_text);
                    textView = bVar.f35786f;
                    format = String.format(string2, ag.a(valueOf, string));
                } else {
                    String string3 = this.f35769a.o().getString(R.string.ksad_tube_update_unfinished_format_text);
                    textView = bVar.f35786f;
                    format = String.format(string3, ag.a(valueOf, string));
                }
                textView.setText(format);
                bVar.f35782b.setOnClickListener(new View.OnClickListener(this, tubeProfile, i2, tubeInfo) { // from class: com.kwad.sdk.contentalliance.tube.profile.b.g.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TubeProfile f35772a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ int f35773b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ TubeInfo f35774c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ a f35775d;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, tubeProfile, Integer.valueOf(i2), tubeInfo};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f35775d = this;
                        this.f35772a = tubeProfile;
                        this.f35773b = i2;
                        this.f35774c = tubeInfo;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.kwad.sdk.lib.widget.b<AdTemplate> bVar3;
                        AdTemplate adTemplate;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f35775d.f35769a.o() == null || (bVar3 = this.f35772a.adTemplateList) == null || bVar3.isEmpty() || (adTemplate = this.f35772a.adTemplateList.get(0)) == null) {
                            return;
                        }
                        com.kwad.sdk.core.report.e.b(adTemplate, "tube_trends_list", String.valueOf(this.f35773b + 1));
                        this.f35775d.a(this.f35774c, adTemplate);
                    }
                });
                bVar.f35781a.a(tubeProfile);
                bVar.f35781a.setEpisodeItemClickListener(new TrendTubeScrollView.a(this, bVar2, i2, tubeProfile, tubeInfo) { // from class: com.kwad.sdk.contentalliance.tube.profile.b.g.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ List f35776a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ int f35777b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ TubeProfile f35778c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ TubeInfo f35779d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ a f35780e;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, bVar2, Integer.valueOf(i2), tubeProfile, tubeInfo};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f35780e = this;
                        this.f35776a = bVar2;
                        this.f35777b = i2;
                        this.f35778c = tubeProfile;
                        this.f35779d = tubeInfo;
                    }

                    @Override // com.kwad.sdk.contentalliance.tube.view.TrendTubeScrollView.a
                    public void a(AdTemplate adTemplate, int i4, View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, adTemplate, i4, view) == null) {
                            if (i4 != this.f35776a.size() - 1) {
                                com.kwad.sdk.core.report.e.a(adTemplate, 1, "tube_trends_list", String.valueOf(this.f35777b + 1));
                                this.f35780e.a(this.f35776a, this.f35777b, i4, this.f35778c);
                                return;
                            }
                            com.kwad.sdk.core.report.e.a(adTemplate, "tube_trends_list", String.valueOf(this.f35777b + 1));
                            this.f35780e.a(this.f35779d, this.f35778c.adTemplateList.get(0));
                        }
                    }
                });
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f35771c.size() : invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TrendTubeScrollView f35781a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f35782b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f35783c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f35784d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f35785e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f35786f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f35787g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view) {
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
            this.f35783c = (TextView) view.findViewById(R.id.ksad_tube_hot_tube_item_name);
            this.f35787g = (ImageView) view.findViewById(R.id.ksad_tube_hot_tube_item_name_arrow);
            this.f35782b = (LinearLayout) view.findViewById(R.id.ksad_tube_hot_tube_item_title_area);
            this.f35784d = (TextView) view.findViewById(R.id.ksad_tube_hot_tube_item_tag);
            this.f35785e = (TextView) view.findViewById(R.id.ksad_tube_hot_tube_item_author_name);
            this.f35786f = (TextView) view.findViewById(R.id.ksad_tube_hot_tube_item_update_info);
            this.f35781a = (TrendTubeScrollView) view.findViewById(R.id.ksad_tube_hot_tube_item_scroll_view);
        }
    }

    public g() {
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
        this.f35767g = new com.kwad.sdk.contentalliance.tube.profile.e(this) { // from class: com.kwad.sdk.contentalliance.tube.profile.b.g.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f35768a;

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
                this.f35768a = this;
            }

            @Override // com.kwad.sdk.contentalliance.tube.profile.e
            public void a(@NonNull TubeProfileResultData tubeProfileResultData) {
                RecyclerView recyclerView;
                int i4;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, tubeProfileResultData) == null) {
                    this.f35768a.f35764d = tubeProfileResultData.tubeProfile.tubeInfo;
                    List<TubeProfile> list = tubeProfileResultData.trendList;
                    if (list == null || list.isEmpty()) {
                        recyclerView = this.f35768a.f35762b;
                        i4 = 8;
                    } else {
                        g gVar = this.f35768a;
                        a aVar = new a(gVar, gVar.o(), tubeProfileResultData.trendList);
                        this.f35768a.f35765e = new com.kwad.sdk.lib.widget.recycler.d(aVar);
                        this.f35768a.e();
                        this.f35768a.f35762b.setAdapter(this.f35768a.f35765e);
                        this.f35768a.f35765e.a(this.f35768a.f35762b);
                        recyclerView = this.f35768a.f35762b;
                        i4 = 0;
                    }
                    recyclerView.setVisibility(i4);
                    this.f35768a.f35763c.setVisibility(i4);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            if (this.f35766f == null) {
                this.f35766f = ao.a((ViewGroup) this.f35762b, R.layout.ksad_tube_profile_no_more_layout, false);
            }
            TextView textView = (TextView) this.f35766f.findViewById(R.id.ksad_tube_profile_no_more_tip_tv);
            if (!com.kwad.sdk.core.config.c.X()) {
                this.f35766f.setVisibility(8);
                return;
            }
            if (!this.f35765e.d(this.f35766f)) {
                this.f35765e.c(this.f35766f);
            }
            this.f35766f.setVisibility(0);
            textView.setText(q.a(o()));
        }
    }

    @Override // com.kwad.sdk.contentalliance.tube.profile.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.core.d.a.a("TubeTrendListPresenter", "TubeTrendListPresenter onBind");
            ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f35705a.f35710e.add(this.f35767g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f35705a.f35710e.remove(this.f35767g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            com.kwad.sdk.core.d.a.a("TubeTrendListPresenter", "TubeTrendListPresenter onCreate");
            this.f35763c = (TextView) b(R.id.ksad_tube_hot_list_label);
            this.f35762b = (RecyclerView) b(R.id.ksad_tube_recycler_view);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(o());
            linearLayoutManager.setOrientation(1);
            this.f35762b.setLayoutManager(linearLayoutManager);
        }
    }
}
