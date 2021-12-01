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
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.recycle.DetailWebRecycleView;
import com.kwad.sdk.core.page.recycle.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.widget.k;
import com.kwad.sdk.mvp.Presenter;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends com.kwad.sdk.core.page.recycle.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f57535b;

    /* renamed from: c  reason: collision with root package name */
    public k f57536c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f57537d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f57538e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f57539f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f57540g;

    /* loaded from: classes2.dex */
    public static class a extends com.kwad.sdk.core.page.recycle.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AdTemplate a;

        /* renamed from: b  reason: collision with root package name */
        public e f57542b;

        /* renamed from: c  reason: collision with root package name */
        public Context f57543c;

        public a(AdTemplate adTemplate, Context context, e eVar) {
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
            this.a = adTemplate;
            this.f57543c = context;
            this.f57542b = eVar;
        }

        @Override // com.kwad.sdk.core.page.recycle.d
        public com.kwad.sdk.core.page.recycle.c a(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i2)) == null) {
                if (i2 == 1) {
                    View inflate = LayoutInflater.from(this.f57543c).inflate(R.layout.ksad_datail_webview_container, viewGroup, false);
                    Presenter presenter = new Presenter();
                    presenter.a((Presenter) new com.kwad.sdk.core.page.kwai.b());
                    return new com.kwad.sdk.core.page.recycle.c(inflate, presenter, this.f57542b);
                } else if (i2 != 0) {
                    View view = new View(viewGroup.getContext());
                    view.setLayoutParams(new ViewGroup.LayoutParams(-1, com.kwad.sdk.a.kwai.a.a(viewGroup.getContext(), 64.0f)));
                    return new com.kwad.sdk.core.page.recycle.c(view, new Presenter(), this.f57542b);
                } else {
                    k kVar = new k(viewGroup.getContext());
                    Presenter presenter2 = new Presenter();
                    presenter2.a((Presenter) new com.kwad.sdk.core.page.kwai.a());
                    return new com.kwad.sdk.core.page.recycle.c(kVar, presenter2, this.f57542b);
                }
            }
            return (com.kwad.sdk.core.page.recycle.c) invokeLI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.core.page.recycle.d, androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(com.kwad.sdk.core.page.recycle.c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, i2) == null) {
                super.onBindViewHolder(cVar, i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.kwad.sdk.core.response.a.a.B(com.kwad.sdk.core.response.a.d.j(this.a)) ? 3 : 2 : invokeV.intValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? i2 : invokeI.intValue;
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
            }
        }
    }

    public static b a(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, adTemplate)) == null) {
            b bVar = new b();
            Bundle bundle = new Bundle();
            bundle.putString("key_photo", adTemplate.toJson().toString());
            bundle.putBoolean("key_report", adTemplate.mPvReported);
            bVar.setArguments(bundle);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, view) == null) {
            this.f57538e = (LinearLayout) view.findViewById(R.id.ksad_web_tip_bar);
            this.f57539f = (TextView) view.findViewById(R.id.ksad_web_tip_bar_textview);
            ImageView imageView = (ImageView) view.findViewById(R.id.ksad_web_tip_close_btn);
            this.f57540g = imageView;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.core.page.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

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
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.a.f57538e.setVisibility(8);
                    }
                }
            });
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.a);
            boolean af = com.kwad.sdk.core.response.a.a.af(j2);
            String ab = com.kwad.sdk.core.response.a.a.ab(j2);
            if (!af) {
                this.f57538e.setVisibility(8);
                return;
            }
            this.f57538e.setVisibility(0);
            this.f57539f.setText(ab);
            this.f57539f.setSelected(true);
        }
    }

    @Override // com.kwad.sdk.core.page.recycle.a
    public com.kwad.sdk.core.page.recycle.d a(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, recyclerView)) == null) ? new a(this.a, recyclerView.getContext(), new e(this.a, this.f57537d, recyclerView)) : (com.kwad.sdk.core.page.recycle.d) invokeL.objValue;
    }

    public void a(com.kwad.sdk.core.download.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f57537d = bVar;
        }
    }

    @Override // com.kwad.sdk.h.d, com.kwad.sdk.h.kwai.b
    public boolean a_() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            WebView webView = this.f57535b;
            if (webView != null && webView.canGoBack()) {
                this.f57535b.goBack();
                return true;
            }
            k kVar = this.f57536c;
            if (kVar != null) {
                return kVar.d();
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
            this.a = adTemplate;
            adTemplate.mPvReported = getArguments().getBoolean("key_report", false);
            this.a.mAdWebVideoPageShowing = true;
        }
    }

    @Override // com.kwad.sdk.core.page.recycle.a, com.kwad.sdk.h.d, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            AdTemplate adTemplate = this.a;
            if (adTemplate != null) {
                adTemplate.mAdWebVideoPageShowing = false;
            }
        }
    }

    @Override // com.kwad.sdk.core.page.recycle.a, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view, bundle) == null) {
            super.onViewCreated(view, bundle);
            DetailWebRecycleView detailWebRecycleView = (DetailWebRecycleView) d();
            detailWebRecycleView.setInterceptRequestFocusForWeb(true);
            detailWebRecycleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this, detailWebRecycleView) { // from class: com.kwad.sdk.core.page.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DetailWebRecycleView a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f57541b;

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
                    this.f57541b = this;
                    this.a = detailWebRecycleView;
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.a.getChildCount() > 0) {
                            RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.a.findViewHolderForAdapterPosition(0);
                            int height = findViewHolderForAdapterPosition.itemView.getHeight();
                            com.kwad.sdk.core.d.a.a("AdRecycleWebFragment", "recycleView.setTopViewHeight(" + height + SmallTailInfo.EMOTION_SUFFIX);
                            this.a.setTopViewHeight(findViewHolderForAdapterPosition.itemView.getHeight());
                            View view2 = this.a.findViewHolderForAdapterPosition(0).itemView;
                            if (view2 instanceof k) {
                                this.f57541b.f57536c = (k) view2;
                            }
                        }
                        if (this.a.getChildCount() > 1) {
                            View view3 = this.a.findViewHolderForAdapterPosition(1).itemView;
                            this.f57541b.f57535b = (WebView) view3.findViewById(R.id.ksad_video_webView);
                            this.f57541b.a(view3);
                        }
                        com.kwad.sdk.core.d.a.a("AdRecycleWebFragment", "onGlobalLayout");
                        this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                }
            });
        }
    }
}
