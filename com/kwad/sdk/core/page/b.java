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
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.recycle.DetailWebRecycleView;
import com.kwad.sdk.core.page.recycle.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.widget.k;
import com.kwad.sdk.mvp.Presenter;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.core.page.recycle.a {
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f58116b;

    /* renamed from: c  reason: collision with root package name */
    public k f58117c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f58118d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f58119e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f58120f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f58121g;

    /* loaded from: classes3.dex */
    public static class a extends com.kwad.sdk.core.page.recycle.d {
        public AdTemplate a;

        /* renamed from: b  reason: collision with root package name */
        public e f58123b;

        /* renamed from: c  reason: collision with root package name */
        public Context f58124c;

        public a(AdTemplate adTemplate, Context context, e eVar) {
            this.a = adTemplate;
            this.f58124c = context;
            this.f58123b = eVar;
        }

        @Override // com.kwad.sdk.core.page.recycle.d
        public com.kwad.sdk.core.page.recycle.c a(ViewGroup viewGroup, int i2) {
            if (i2 == 1) {
                View inflate = LayoutInflater.from(this.f58124c).inflate(R.layout.ksad_datail_webview_container, viewGroup, false);
                Presenter presenter = new Presenter();
                presenter.a((Presenter) new com.kwad.sdk.core.page.kwai.b());
                return new com.kwad.sdk.core.page.recycle.c(inflate, presenter, this.f58123b);
            } else if (i2 != 0) {
                View view = new View(viewGroup.getContext());
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, com.kwad.sdk.a.kwai.a.a(viewGroup.getContext(), 64.0f)));
                return new com.kwad.sdk.core.page.recycle.c(view, new Presenter(), this.f58123b);
            } else {
                k kVar = new k(viewGroup.getContext());
                Presenter presenter2 = new Presenter();
                presenter2.a((Presenter) new com.kwad.sdk.core.page.kwai.a());
                return new com.kwad.sdk.core.page.recycle.c(kVar, presenter2, this.f58123b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.core.page.recycle.d, androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(com.kwad.sdk.core.page.recycle.c cVar, int i2) {
            super.onBindViewHolder(cVar, i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return com.kwad.sdk.core.response.a.a.B(com.kwad.sdk.core.response.a.d.j(this.a)) ? 3 : 2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i2) {
            return i2;
        }
    }

    public static b a(AdTemplate adTemplate) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putString("key_photo", adTemplate.toJson().toString());
        bundle.putBoolean("key_report", adTemplate.mPvReported);
        bVar.setArguments(bundle);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        this.f58119e = (LinearLayout) view.findViewById(R.id.ksad_web_tip_bar);
        this.f58120f = (TextView) view.findViewById(R.id.ksad_web_tip_bar_textview);
        ImageView imageView = (ImageView) view.findViewById(R.id.ksad_web_tip_close_btn);
        this.f58121g = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.f58119e.setVisibility(8);
            }
        });
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.a);
        boolean af = com.kwad.sdk.core.response.a.a.af(j2);
        String ab = com.kwad.sdk.core.response.a.a.ab(j2);
        if (!af) {
            this.f58119e.setVisibility(8);
            return;
        }
        this.f58119e.setVisibility(0);
        this.f58120f.setText(ab);
        this.f58120f.setSelected(true);
    }

    @Override // com.kwad.sdk.core.page.recycle.a
    public com.kwad.sdk.core.page.recycle.d a(RecyclerView recyclerView) {
        return new a(this.a, recyclerView.getContext(), new e(this.a, this.f58118d, recyclerView));
    }

    public void a(com.kwad.sdk.core.download.a.b bVar) {
        this.f58118d = bVar;
    }

    @Override // com.kwad.sdk.h.d, com.kwad.sdk.h.kwai.b
    public boolean a_() {
        WebView webView = this.f58116b;
        if (webView != null && webView.canGoBack()) {
            this.f58116b.goBack();
            return true;
        }
        k kVar = this.f58117c;
        if (kVar != null) {
            return kVar.d();
        }
        return false;
    }

    @Override // com.kwad.sdk.core.page.recycle.a
    public int b() {
        return R.layout.ksad_detail_webview;
    }

    @Override // com.kwad.sdk.core.page.recycle.a, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreate(@Nullable Bundle bundle) {
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

    @Override // com.kwad.sdk.core.page.recycle.a, com.kwad.sdk.h.d, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
        AdTemplate adTemplate = this.a;
        if (adTemplate != null) {
            adTemplate.mAdWebVideoPageShowing = false;
        }
    }

    @Override // com.kwad.sdk.core.page.recycle.a, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        final DetailWebRecycleView detailWebRecycleView = (DetailWebRecycleView) d();
        detailWebRecycleView.setInterceptRequestFocusForWeb(true);
        detailWebRecycleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.sdk.core.page.b.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (detailWebRecycleView.getChildCount() > 0) {
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition = detailWebRecycleView.findViewHolderForAdapterPosition(0);
                    int height = findViewHolderForAdapterPosition.itemView.getHeight();
                    com.kwad.sdk.core.d.a.a("AdRecycleWebFragment", "recycleView.setTopViewHeight(" + height + SmallTailInfo.EMOTION_SUFFIX);
                    detailWebRecycleView.setTopViewHeight(findViewHolderForAdapterPosition.itemView.getHeight());
                    View view2 = detailWebRecycleView.findViewHolderForAdapterPosition(0).itemView;
                    if (view2 instanceof k) {
                        b.this.f58117c = (k) view2;
                    }
                }
                if (detailWebRecycleView.getChildCount() > 1) {
                    View view3 = detailWebRecycleView.findViewHolderForAdapterPosition(1).itemView;
                    b.this.f58116b = (WebView) view3.findViewById(R.id.ksad_video_webView);
                    b.this.a(view3);
                }
                com.kwad.sdk.core.d.a.a("AdRecycleWebFragment", "onGlobalLayout");
                detailWebRecycleView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }
}
