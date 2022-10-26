package com.kwad.components.core.page;

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
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.page.recycle.DetailWebRecycleView;
import com.kwad.components.core.page.recycle.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b extends com.kwad.components.core.page.recycle.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WebView Fv;
    public com.kwad.components.core.widget.d Fw;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public ImageView mWebTipBarCloseBtn;
    public LinearLayout mWebTipBarLayout;
    public TextView mWebTipBarTitle;

    /* loaded from: classes7.dex */
    public final class a extends com.kwad.components.core.page.recycle.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public e Fz;
        public AdTemplate mAdTemplate;
        public Context mContext;

        public a(AdTemplate adTemplate, Context context, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adTemplate, context, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mAdTemplate = adTemplate;
            this.mContext = context;
            this.Fz = eVar;
        }

        @Override // com.kwad.components.core.page.recycle.d
        public final com.kwad.components.core.page.recycle.c a(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i)) == null) {
                if (i == 1) {
                    View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0412, viewGroup, false);
                    Presenter presenter = new Presenter();
                    presenter.a(new com.kwad.components.core.page.kwai.b());
                    return new com.kwad.components.core.page.recycle.c(inflate, presenter, this.Fz);
                } else if (i != 0) {
                    View view2 = new View(viewGroup.getContext());
                    view2.setLayoutParams(new ViewGroup.LayoutParams(-1, com.kwad.sdk.b.kwai.a.a(viewGroup.getContext(), 64.0f)));
                    return new com.kwad.components.core.page.recycle.c(view2, new Presenter(), this.Fz);
                } else {
                    com.kwad.components.core.widget.d dVar = new com.kwad.components.core.widget.d(viewGroup.getContext());
                    Presenter presenter2 = new Presenter();
                    presenter2.a(new com.kwad.components.core.page.kwai.a());
                    return new com.kwad.components.core.page.recycle.c(dVar, presenter2, this.Fz);
                }
            }
            return (com.kwad.components.core.page.recycle.c) invokeLI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.components.core.page.recycle.d, androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public final void onBindViewHolder(com.kwad.components.core.page.recycle.c cVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, i) == null) {
                super.onBindViewHolder(cVar, i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.kwad.sdk.core.response.a.a.am(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate)) ? 3 : 2 : invokeV.intValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? i : invokeI.intValue;
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static b M(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adTemplate)) == null) {
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
    public void t(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, view2) == null) {
            this.mWebTipBarLayout = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091238);
            this.mWebTipBarTitle = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091239);
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09123a);
            this.mWebTipBarCloseBtn = imageView;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.core.page.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b Fx;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Fx = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                        this.Fx.mWebTipBarLayout.setVisibility(8);
                    }
                }
            });
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate);
            boolean aQ = com.kwad.sdk.core.response.a.a.aQ(bQ);
            String aM = com.kwad.sdk.core.response.a.a.aM(bQ);
            if (!aQ) {
                this.mWebTipBarLayout.setVisibility(8);
                return;
            }
            this.mWebTipBarLayout.setVisibility(0);
            this.mWebTipBarTitle.setText(aM);
            this.mWebTipBarTitle.setSelected(true);
        }
    }

    @Override // com.kwad.components.core.page.recycle.a
    public final com.kwad.components.core.page.recycle.d a(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, recyclerView)) == null) ? new a(this.mAdTemplate, recyclerView.getContext(), new e(this.mAdTemplate, this.mApkDownloadHelper, recyclerView)) : (com.kwad.components.core.page.recycle.d) invokeL.objValue;
    }

    @Override // com.kwad.components.core.i.c, com.kwad.sdk.g.kwai.b
    public final boolean bG() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            WebView webView = this.Fv;
            if (webView != null && webView.canGoBack()) {
                this.Fv.goBack();
                return true;
            }
            com.kwad.components.core.widget.d dVar = this.Fw;
            if (dVar != null) {
                return dVar.qe();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.components.core.page.recycle.a
    public final int nw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.obfuscated_res_0x7f0d0413 : invokeV.intValue;
    }

    @Override // com.kwad.components.core.page.recycle.a, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            String string = getArguments().getString("key_photo");
            AdTemplate adTemplate = new AdTemplate();
            if (string != null) {
                try {
                    adTemplate.parseJson(new JSONObject(string));
                } catch (JSONException e) {
                    com.kwad.sdk.core.e.b.printStackTrace(e);
                }
            }
            this.mAdTemplate = adTemplate;
            adTemplate.mPvReported = getArguments().getBoolean("key_report", false);
            this.mAdTemplate.mAdWebVideoPageShowing = true;
        }
    }

    @Override // com.kwad.components.core.page.recycle.a, com.kwad.components.core.i.c, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate != null) {
                adTemplate.mAdWebVideoPageShowing = false;
            }
        }
    }

    @Override // com.kwad.components.core.page.recycle.a, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view2, bundle) == null) {
            super.onViewCreated(view2, bundle);
            DetailWebRecycleView detailWebRecycleView = (DetailWebRecycleView) nQ();
            detailWebRecycleView.setInterceptRequestFocusForWeb(true);
            detailWebRecycleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this, detailWebRecycleView) { // from class: com.kwad.components.core.page.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b Fx;
                public final /* synthetic */ DetailWebRecycleView Fy;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, detailWebRecycleView};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Fx = this;
                    this.Fy = detailWebRecycleView;
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.Fy.getChildCount() > 0) {
                            RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.Fy.findViewHolderForAdapterPosition(0);
                            int height = findViewHolderForAdapterPosition.itemView.getHeight();
                            com.kwad.sdk.core.e.b.d("AdRecycleWebFragment", "recycleView.setTopViewHeight(" + height + SmallTailInfo.EMOTION_SUFFIX);
                            this.Fy.setTopViewHeight(findViewHolderForAdapterPosition.itemView.getHeight());
                            View view3 = this.Fy.findViewHolderForAdapterPosition(0).itemView;
                            if (view3 instanceof com.kwad.components.core.widget.d) {
                                this.Fx.Fw = (com.kwad.components.core.widget.d) view3;
                            }
                        }
                        if (this.Fy.getChildCount() > 1) {
                            View view4 = this.Fy.findViewHolderForAdapterPosition(1).itemView;
                            this.Fx.Fv = (WebView) view4.findViewById(R.id.obfuscated_res_0x7f09122e);
                            this.Fx.t(view4);
                        }
                        com.kwad.sdk.core.e.b.d("AdRecycleWebFragment", "onGlobalLayout");
                        this.Fy.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                }
            });
        }
    }

    public final void setApkDownloadHelper(com.kwad.components.core.c.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.mApkDownloadHelper = cVar;
        }
    }
}
