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
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.core.page.recycle.a {

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f34275a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f34276b;

    /* renamed from: c  reason: collision with root package name */
    public k f34277c;

    /* renamed from: d  reason: collision with root package name */
    public b f34278d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f34279e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f34280f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f34281g;

    /* renamed from: com.kwad.sdk.core.page.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0406a extends d {

        /* renamed from: a  reason: collision with root package name */
        public AdTemplate f34285a;

        /* renamed from: b  reason: collision with root package name */
        public e f34286b;

        /* renamed from: c  reason: collision with root package name */
        public Context f34287c;

        public C0406a(AdTemplate adTemplate, Context context, e eVar) {
            this.f34285a = adTemplate;
            this.f34287c = context;
            this.f34286b = eVar;
        }

        @Override // com.kwad.sdk.core.page.recycle.d
        public c a(ViewGroup viewGroup, int i) {
            if (i == 1) {
                View inflate = LayoutInflater.from(this.f34287c).inflate(R.layout.ksad_datail_webview_container, viewGroup, false);
                Presenter presenter = new Presenter();
                presenter.a((Presenter) new com.kwad.sdk.core.page.a.b());
                return new c(inflate, presenter, this.f34286b);
            } else if (i != 0) {
                View view = new View(viewGroup.getContext());
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, ao.a(viewGroup.getContext(), 64.0f)));
                return new c(view, new Presenter(), this.f34286b);
            } else {
                k kVar = new k(viewGroup.getContext());
                Presenter presenter2 = new Presenter();
                presenter2.a((Presenter) new com.kwad.sdk.core.page.a.a());
                return new c(kVar, presenter2, this.f34286b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.core.page.recycle.d, androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(c cVar, int i) {
            super.onBindViewHolder(cVar, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return com.kwad.sdk.core.response.b.a.y(com.kwad.sdk.core.response.b.c.j(this.f34285a)) ? 3 : 2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return i;
        }
    }

    public static a a(AdTemplate adTemplate) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putString("key_photo", adTemplate.toJson().toString());
        bundle.putBoolean("key_report", adTemplate.mPvReported);
        aVar.setArguments(bundle);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        this.f34279e = (LinearLayout) view.findViewById(R.id.ksad_web_tip_bar);
        this.f34280f = (TextView) view.findViewById(R.id.ksad_web_tip_bar_textview);
        ImageView imageView = (ImageView) view.findViewById(R.id.ksad_web_tip_close_btn);
        this.f34281g = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.f34279e.setVisibility(8);
            }
        });
        AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f34275a);
        boolean aa = com.kwad.sdk.core.response.b.a.aa(j);
        String Y = com.kwad.sdk.core.response.b.a.Y(j);
        if (!aa) {
            this.f34279e.setVisibility(8);
            return;
        }
        this.f34279e.setVisibility(0);
        this.f34280f.setText(Y);
        this.f34280f.setSelected(true);
    }

    @Override // com.kwad.sdk.core.page.recycle.a
    public d a(RecyclerView recyclerView) {
        return new C0406a(this.f34275a, recyclerView.getContext(), new e(this.f34275a, this.f34278d, recyclerView));
    }

    public void a(b bVar) {
        this.f34278d = bVar;
    }

    public boolean a() {
        WebView webView = this.f34276b;
        if (webView != null && webView.canGoBack()) {
            this.f34276b.goBack();
            return true;
        }
        k kVar = this.f34277c;
        if (kVar != null) {
            return kVar.f();
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
        this.f34275a = adTemplate;
        adTemplate.mPvReported = getArguments().getBoolean("key_report", false);
    }

    @Override // com.kwad.sdk.core.page.recycle.a, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        final DetailWebRecycleView detailWebRecycleView = (DetailWebRecycleView) d();
        detailWebRecycleView.setInterceptRequestFocusForWebFiredOnce(true);
        detailWebRecycleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.sdk.core.page.a.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (detailWebRecycleView.getChildCount() > 0) {
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition = detailWebRecycleView.findViewHolderForAdapterPosition(0);
                    int height = findViewHolderForAdapterPosition.itemView.getHeight();
                    com.kwad.sdk.core.d.a.a("AdRecycleWebFragment", "recycleView.setTopViewHeight(" + height + SmallTailInfo.EMOTION_SUFFIX);
                    detailWebRecycleView.setTopViewHeight(findViewHolderForAdapterPosition.itemView.getHeight());
                    View view2 = detailWebRecycleView.findViewHolderForAdapterPosition(0).itemView;
                    if (view2 instanceof k) {
                        a.this.f34277c = (k) view2;
                    }
                }
                if (detailWebRecycleView.getChildCount() > 1) {
                    View view3 = detailWebRecycleView.findViewHolderForAdapterPosition(1).itemView;
                    a.this.f34276b = (WebView) view3.findViewById(R.id.ksad_video_webView);
                    a.this.a(view3);
                }
                com.kwad.sdk.core.d.a.a("AdRecycleWebFragment", "onGlobalLayout");
                detailWebRecycleView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }
}
