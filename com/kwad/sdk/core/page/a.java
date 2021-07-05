package com.kwad.sdk.core.page;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.b.b;
import com.kwad.sdk.core.page.recycle.DetailWebRecycleView;
import com.kwad.sdk.core.page.recycle.c;
import com.kwad.sdk.core.page.recycle.d;
import com.kwad.sdk.core.page.recycle.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.widget.k;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ao;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.core.page.recycle.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f36381a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f36382b;

    /* renamed from: c  reason: collision with root package name */
    public k f36383c;

    /* renamed from: d  reason: collision with root package name */
    public b f36384d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f36385e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f36386f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f36387g;

    /* renamed from: com.kwad.sdk.core.page.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0436a extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public AdTemplate f36391a;

        /* renamed from: b  reason: collision with root package name */
        public e f36392b;

        /* renamed from: c  reason: collision with root package name */
        public Context f36393c;

        public C0436a(AdTemplate adTemplate, Context context, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adTemplate, context, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36391a = adTemplate;
            this.f36393c = context;
            this.f36392b = eVar;
        }

        @Override // com.kwad.sdk.core.page.recycle.d
        public c a(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i2)) == null) {
                if (i2 == 1) {
                    View inflate = LayoutInflater.from(this.f36393c).inflate(R.layout.ksad_datail_webview_container, viewGroup, false);
                    Presenter presenter = new Presenter();
                    presenter.a((Presenter) new com.kwad.sdk.core.page.a.b());
                    return new c(inflate, presenter, this.f36392b);
                } else if (i2 != 0) {
                    View view = new View(viewGroup.getContext());
                    view.setLayoutParams(new ViewGroup.LayoutParams(-1, ao.a(viewGroup.getContext(), 64.0f)));
                    return new c(view, new Presenter(), this.f36392b);
                } else {
                    k kVar = new k(viewGroup.getContext());
                    Presenter presenter2 = new Presenter();
                    presenter2.a((Presenter) new com.kwad.sdk.core.page.a.a());
                    return new c(kVar, presenter2, this.f36392b);
                }
            }
            return (c) invokeLI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.core.page.recycle.d, androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, i2) == null) {
                super.onBindViewHolder(cVar, i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.kwad.sdk.core.response.b.a.y(com.kwad.sdk.core.response.b.c.j(this.f36391a)) ? 3 : 2 : invokeV.intValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? i2 : invokeI.intValue;
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
            }
        }
    }

    public static a a(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, adTemplate)) == null) {
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putString("key_photo", adTemplate.toJson().toString());
            bundle.putBoolean("key_report", adTemplate.mPvReported);
            aVar.setArguments(bundle);
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, view) == null) {
            this.f36385e = (LinearLayout) view.findViewById(R.id.ksad_web_tip_bar);
            this.f36386f = (TextView) view.findViewById(R.id.ksad_web_tip_bar_textview);
            ImageView imageView = (ImageView) view.findViewById(R.id.ksad_web_tip_close_btn);
            this.f36387g = imageView;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f36388a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36388a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.f36388a.f36385e.setVisibility(8);
                    }
                }
            });
            AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f36381a);
            boolean aa = com.kwad.sdk.core.response.b.a.aa(j);
            String Y = com.kwad.sdk.core.response.b.a.Y(j);
            if (!aa) {
                this.f36385e.setVisibility(8);
                return;
            }
            this.f36385e.setVisibility(0);
            this.f36386f.setText(Y);
            this.f36386f.setSelected(true);
        }
    }

    @Override // com.kwad.sdk.core.page.recycle.a
    public d a(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, recyclerView)) == null) ? new C0436a(this.f36381a, recyclerView.getContext(), new e(this.f36381a, this.f36384d, recyclerView)) : (d) invokeL.objValue;
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f36384d = bVar;
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            WebView webView = this.f36382b;
            if (webView != null && webView.canGoBack()) {
                this.f36382b.goBack();
                return true;
            }
            k kVar = this.f36383c;
            if (kVar != null) {
                return kVar.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.page.recycle.a
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.ksad_detail_webview : invokeV.intValue;
    }

    @Override // com.kwad.sdk.core.page.recycle.a, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            String string = getArguments().getString("key_photo");
            AdTemplate adTemplate = new AdTemplate();
            if (string != null) {
                try {
                    adTemplate.parseJson(new JSONObject(string));
                } catch (JSONException e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
            }
            this.f36381a = adTemplate;
            adTemplate.mPvReported = getArguments().getBoolean("key_report", false);
        }
    }

    @Override // com.kwad.sdk.core.page.recycle.a, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view, bundle) == null) {
            super.onViewCreated(view, bundle);
            DetailWebRecycleView detailWebRecycleView = (DetailWebRecycleView) d();
            detailWebRecycleView.setInterceptRequestFocusForWebFiredOnce(true);
            detailWebRecycleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this, detailWebRecycleView) { // from class: com.kwad.sdk.core.page.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ DetailWebRecycleView f36389a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f36390b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, detailWebRecycleView};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36390b = this;
                    this.f36389a = detailWebRecycleView;
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f36389a.getChildCount() > 0) {
                            RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.f36389a.findViewHolderForAdapterPosition(0);
                            int height = findViewHolderForAdapterPosition.itemView.getHeight();
                            com.kwad.sdk.core.d.a.a("AdRecycleWebFragment", "recycleView.setTopViewHeight(" + height + SmallTailInfo.EMOTION_SUFFIX);
                            this.f36389a.setTopViewHeight(findViewHolderForAdapterPosition.itemView.getHeight());
                            View view2 = this.f36389a.findViewHolderForAdapterPosition(0).itemView;
                            if (view2 instanceof k) {
                                this.f36390b.f36383c = (k) view2;
                            }
                        }
                        if (this.f36389a.getChildCount() > 1) {
                            View view3 = this.f36389a.findViewHolderForAdapterPosition(1).itemView;
                            this.f36390b.f36382b = (WebView) view3.findViewById(R.id.ksad_video_webView);
                            this.f36390b.a(view3);
                        }
                        com.kwad.sdk.core.d.a.a("AdRecycleWebFragment", "onGlobalLayout");
                        this.f36389a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                }
            });
        }
    }
}
