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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.kwad.components.core.page.recycle.DetailWebRecycleView;
import com.kwad.components.core.page.recycle.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b extends com.kwad.components.core.page.recycle.a {
    public WebView Fv;
    public com.kwad.components.core.widget.d Fw;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public ImageView mWebTipBarCloseBtn;
    public LinearLayout mWebTipBarLayout;
    public TextView mWebTipBarTitle;

    /* loaded from: classes10.dex */
    public static class a extends com.kwad.components.core.page.recycle.d {
        public e Fz;
        public AdTemplate mAdTemplate;
        public Context mContext;

        public a(AdTemplate adTemplate, Context context, e eVar) {
            this.mAdTemplate = adTemplate;
            this.mContext = context;
            this.Fz = eVar;
        }

        @Override // com.kwad.components.core.page.recycle.d
        public final com.kwad.components.core.page.recycle.c a(ViewGroup viewGroup, int i) {
            if (i == 1) {
                View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d04a9, viewGroup, false);
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.components.core.page.recycle.d, androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public final void onBindViewHolder(com.kwad.components.core.page.recycle.c cVar, int i) {
            super.onBindViewHolder(cVar, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return com.kwad.sdk.core.response.a.a.am(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate)) ? 3 : 2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int i) {
            return i;
        }
    }

    public static b M(AdTemplate adTemplate) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putString("key_photo", adTemplate.toJson().toString());
        bundle.putBoolean("key_report", adTemplate.mPvReported);
        bVar.setArguments(bundle);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(View view2) {
        this.mWebTipBarLayout = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0914af);
        this.mWebTipBarTitle = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0914b0);
        ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0914b1);
        this.mWebTipBarCloseBtn = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.b.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                b.this.mWebTipBarLayout.setVisibility(8);
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

    @Override // com.kwad.components.core.page.recycle.a
    public final com.kwad.components.core.page.recycle.d a(RecyclerView recyclerView) {
        return new a(this.mAdTemplate, recyclerView.getContext(), new e(this.mAdTemplate, this.mApkDownloadHelper, recyclerView));
    }

    @Override // com.kwad.components.core.i.c, com.kwad.sdk.g.kwai.b
    public final boolean bG() {
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

    @Override // com.kwad.components.core.page.recycle.a
    public final int nw() {
        return R.layout.obfuscated_res_0x7f0d04aa;
    }

    @Override // com.kwad.components.core.page.recycle.a, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onCreate(@Nullable Bundle bundle) {
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

    @Override // com.kwad.components.core.page.recycle.a, com.kwad.components.core.i.c, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onDestroy() {
        super.onDestroy();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            adTemplate.mAdWebVideoPageShowing = false;
        }
    }

    @Override // com.kwad.components.core.page.recycle.a, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onViewCreated(@NonNull View view2, @Nullable Bundle bundle) {
        super.onViewCreated(view2, bundle);
        final DetailWebRecycleView detailWebRecycleView = (DetailWebRecycleView) nQ();
        detailWebRecycleView.setInterceptRequestFocusForWeb(true);
        detailWebRecycleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.components.core.page.b.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                if (detailWebRecycleView.getChildCount() > 0) {
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition = detailWebRecycleView.findViewHolderForAdapterPosition(0);
                    int height = findViewHolderForAdapterPosition.itemView.getHeight();
                    com.kwad.sdk.core.e.b.d("AdRecycleWebFragment", "recycleView.setTopViewHeight(" + height + SmallTailInfo.EMOTION_SUFFIX);
                    detailWebRecycleView.setTopViewHeight(findViewHolderForAdapterPosition.itemView.getHeight());
                    View view3 = detailWebRecycleView.findViewHolderForAdapterPosition(0).itemView;
                    if (view3 instanceof com.kwad.components.core.widget.d) {
                        b.this.Fw = (com.kwad.components.core.widget.d) view3;
                    }
                }
                if (detailWebRecycleView.getChildCount() > 1) {
                    View view4 = detailWebRecycleView.findViewHolderForAdapterPosition(1).itemView;
                    b.this.Fv = (WebView) view4.findViewById(R.id.obfuscated_res_0x7f0914a5);
                    b.this.t(view4);
                }
                com.kwad.sdk.core.e.b.d("AdRecycleWebFragment", "onGlobalLayout");
                detailWebRecycleView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    public final void setApkDownloadHelper(com.kwad.components.core.c.a.c cVar) {
        this.mApkDownloadHelper = cVar;
    }
}
