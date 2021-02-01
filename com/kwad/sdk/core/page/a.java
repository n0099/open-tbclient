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
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.core.page.recycle.a {

    /* renamed from: a  reason: collision with root package name */
    private AdTemplate f9339a;

    /* renamed from: b  reason: collision with root package name */
    private WebView f9340b;
    private k c;
    private b d;
    private LinearLayout e;
    private TextView f;
    private ImageView g;

    /* renamed from: com.kwad.sdk.core.page.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C1102a extends d {

        /* renamed from: a  reason: collision with root package name */
        AdTemplate f9344a;

        /* renamed from: b  reason: collision with root package name */
        e f9345b;
        private Context c;

        C1102a(AdTemplate adTemplate, Context context, e eVar) {
            this.f9344a = adTemplate;
            this.c = context;
            this.f9345b = eVar;
        }

        @Override // com.kwad.sdk.core.page.recycle.d
        protected c a(ViewGroup viewGroup, int i) {
            if (i == 1) {
                View inflate = LayoutInflater.from(this.c).inflate(R.layout.ksad_datail_webview_container, viewGroup, false);
                Presenter presenter = new Presenter();
                presenter.a((Presenter) new com.kwad.sdk.core.page.a.b());
                return new c(inflate, presenter, this.f9345b);
            } else if (i != 0) {
                View view = new View(viewGroup.getContext());
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, ao.a(viewGroup.getContext(), 64.0f)));
                return new c(view, new Presenter(), this.f9345b);
            } else {
                k kVar = new k(viewGroup.getContext());
                Presenter presenter2 = new Presenter();
                presenter2.a((Presenter) new com.kwad.sdk.core.page.a.a());
                return new c(kVar, presenter2, this.f9345b);
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
            return com.kwad.sdk.core.response.b.a.y(com.kwad.sdk.core.response.b.c.j(this.f9344a)) ? 3 : 2;
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
        this.e = (LinearLayout) view.findViewById(R.id.ksad_web_tip_bar);
        this.f = (TextView) view.findViewById(R.id.ksad_web_tip_bar_textview);
        this.g = (ImageView) view.findViewById(R.id.ksad_web_tip_close_btn);
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.e.setVisibility(8);
            }
        });
        AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f9339a);
        boolean aa = com.kwad.sdk.core.response.b.a.aa(j);
        String Y = com.kwad.sdk.core.response.b.a.Y(j);
        if (!aa) {
            this.e.setVisibility(8);
            return;
        }
        this.e.setVisibility(0);
        this.f.setText(Y);
        this.f.setSelected(true);
    }

    @Override // com.kwad.sdk.core.page.recycle.a
    protected d a(RecyclerView recyclerView) {
        return new C1102a(this.f9339a, recyclerView.getContext(), new e(this.f9339a, this.d, recyclerView));
    }

    public void a(b bVar) {
        this.d = bVar;
    }

    public boolean a() {
        if (this.f9340b != null && this.f9340b.canGoBack()) {
            this.f9340b.goBack();
            return true;
        } else if (this.c != null) {
            return this.c.f();
        } else {
            return false;
        }
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
            } catch (JSONException e) {
                com.kwad.sdk.core.d.a.a(e);
            }
        }
        this.f9339a = adTemplate;
        this.f9339a.mPvReported = getArguments().getBoolean("key_report", false);
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
                    com.kwad.sdk.core.d.a.a("AdRecycleWebFragment", "recycleView.setTopViewHeight(" + findViewHolderForAdapterPosition.itemView.getHeight() + ")");
                    detailWebRecycleView.setTopViewHeight(findViewHolderForAdapterPosition.itemView.getHeight());
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition2 = detailWebRecycleView.findViewHolderForAdapterPosition(0);
                    if (findViewHolderForAdapterPosition2.itemView instanceof k) {
                        a.this.c = (k) findViewHolderForAdapterPosition2.itemView;
                    }
                }
                if (detailWebRecycleView.getChildCount() > 1) {
                    View view2 = detailWebRecycleView.findViewHolderForAdapterPosition(1).itemView;
                    a.this.f9340b = (WebView) view2.findViewById(R.id.ksad_video_webView);
                    a.this.a(view2);
                }
                com.kwad.sdk.core.d.a.a("AdRecycleWebFragment", "onGlobalLayout");
                detailWebRecycleView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }
}
