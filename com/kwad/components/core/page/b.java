package com.kwad.components.core.page;

import android.content.Context;
import android.os.Bundle;
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
import com.kwad.components.core.widget.FeedVideoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.m.l;
import com.kwad.sdk.mvp.Presenter;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b extends com.kwad.components.core.page.recycle.a {
    public WebView NP;
    public FeedVideoView NQ;
    public LinearLayout NR;
    public TextView NS;
    public ImageView NT;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;

    @Override // com.kwad.components.core.proxy.e
    public final int oR() {
        return R.layout.obfuscated_res_0x7f0d04bc;
    }

    /* loaded from: classes10.dex */
    public static class a extends com.kwad.components.core.page.recycle.d {
        public e NW;
        public AdTemplate mAdTemplate;
        public Context mContext;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int i) {
            return i;
        }

        public a(AdTemplate adTemplate, Context context, e eVar) {
            this.mAdTemplate = adTemplate;
            this.mContext = context;
            this.NW = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.components.core.page.recycle.d, androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public final void onBindViewHolder(com.kwad.components.core.page.recycle.c cVar, int i) {
            super.onBindViewHolder(cVar, i);
        }

        @Override // com.kwad.components.core.page.recycle.d
        public final com.kwad.components.core.page.recycle.c b(ViewGroup viewGroup, int i) {
            if (i == 1) {
                View a = l.a(this.mContext, R.layout.obfuscated_res_0x7f0d04bb, viewGroup, false);
                Presenter presenter = new Presenter();
                presenter.a(new com.kwad.components.core.page.c.b());
                return new com.kwad.components.core.page.recycle.c(a, presenter, this.NW);
            } else if (i == 0) {
                FeedVideoView feedVideoView = new FeedVideoView(viewGroup.getContext());
                Presenter presenter2 = new Presenter();
                presenter2.a(new com.kwad.components.core.page.c.a());
                return new com.kwad.components.core.page.recycle.c(feedVideoView, presenter2, this.NW);
            } else {
                View view2 = new View(viewGroup.getContext());
                view2.setLayoutParams(new ViewGroup.LayoutParams(-1, com.kwad.sdk.d.a.a.a(viewGroup.getContext(), 64.0f)));
                return new com.kwad.components.core.page.recycle.c(view2, new Presenter(), this.NW);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            if (com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate))) {
                return 3;
            }
            return 2;
        }
    }

    @Override // com.kwad.components.core.proxy.e, com.kwad.sdk.l.a.b
    public final boolean onBackPressed() {
        WebView webView = this.NP;
        if (webView != null && webView.canGoBack()) {
            this.NP.goBack();
            return true;
        }
        FeedVideoView feedVideoView = this.NQ;
        if (feedVideoView != null) {
            return feedVideoView.tg();
        }
        return false;
    }

    @Override // com.kwad.components.core.page.recycle.a, com.kwad.components.core.proxy.e, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
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
        final DetailWebRecycleView detailWebRecycleView = (DetailWebRecycleView) pA();
        detailWebRecycleView.setInterceptRequestFocusForWeb(true);
        detailWebRecycleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.components.core.page.b.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                if (detailWebRecycleView.getChildCount() > 0) {
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition = detailWebRecycleView.findViewHolderForAdapterPosition(0);
                    int height = findViewHolderForAdapterPosition.itemView.getHeight();
                    com.kwad.sdk.core.e.c.d("AdRecycleWebFragment", "recycleView.setTopViewHeight(" + height + SmallTailInfo.EMOTION_SUFFIX);
                    detailWebRecycleView.setTopViewHeight(findViewHolderForAdapterPosition.itemView.getHeight());
                    View view3 = detailWebRecycleView.findViewHolderForAdapterPosition(0).itemView;
                    if (view3 instanceof FeedVideoView) {
                        b.this.NQ = (FeedVideoView) view3;
                    }
                }
                if (detailWebRecycleView.getChildCount() > 1) {
                    View view4 = detailWebRecycleView.findViewHolderForAdapterPosition(1).itemView;
                    b.this.NP = (WebView) view4.findViewById(R.id.obfuscated_res_0x7f091512);
                    b.this.w(view4);
                }
                com.kwad.sdk.core.e.c.d("AdRecycleWebFragment", "onGlobalLayout");
                detailWebRecycleView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    public static b ar(AdTemplate adTemplate) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putString("key_photo", adTemplate.toJson().toString());
        bundle.putBoolean("key_report", adTemplate.mPvReported);
        bVar.setArguments(bundle);
        return bVar;
    }

    public final void setApkDownloadHelper(com.kwad.components.core.e.d.c cVar) {
        this.mApkDownloadHelper = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(View view2) {
        this.NR = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09151f);
        this.NS = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091520);
        ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091521);
        this.NT = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.b.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                b.this.NR.setVisibility(8);
            }
        });
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate);
        boolean bw = com.kwad.sdk.core.response.b.a.bw(dP);
        String bs = com.kwad.sdk.core.response.b.a.bs(dP);
        if (bw) {
            this.NR.setVisibility(0);
            this.NS.setText(bs);
            this.NS.setSelected(true);
            return;
        }
        this.NR.setVisibility(8);
    }

    @Override // com.kwad.components.core.page.recycle.a
    public final com.kwad.components.core.page.recycle.d a(RecyclerView recyclerView) {
        return new a(this.mAdTemplate, recyclerView.getContext(), new e(this.mAdTemplate, this.mApkDownloadHelper, recyclerView));
    }

    @Override // com.kwad.components.core.proxy.e, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String string = getArguments().getString("key_photo");
        AdTemplate adTemplate = new AdTemplate();
        if (string != null) {
            try {
                adTemplate.parseJson(new JSONObject(string));
            } catch (JSONException e) {
                com.kwad.sdk.core.e.c.printStackTrace(e);
            }
        }
        this.mAdTemplate = adTemplate;
        adTemplate.mPvReported = getArguments().getBoolean("key_report", false);
        this.mAdTemplate.mAdWebVideoPageShowing = true;
    }
}
