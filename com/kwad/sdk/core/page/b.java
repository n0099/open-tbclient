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
import com.baidu.tieba.R;
import com.kwad.sdk.core.page.recycle.DetailWebRecycleView;
import com.kwad.sdk.core.page.recycle.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.widget.k;
import com.kwad.sdk.mvp.Presenter;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b extends com.kwad.sdk.core.page.recycle.a {
    public AdTemplate a;
    public WebView b;
    public k c;
    public com.kwad.sdk.core.download.a.b d;
    public LinearLayout e;
    public TextView f;
    public ImageView g;

    /* loaded from: classes5.dex */
    public static class a extends com.kwad.sdk.core.page.recycle.d {
        public AdTemplate a;
        public e b;
        public Context c;

        public a(AdTemplate adTemplate, Context context, e eVar) {
            this.a = adTemplate;
            this.c = context;
            this.b = eVar;
        }

        @Override // com.kwad.sdk.core.page.recycle.d
        public com.kwad.sdk.core.page.recycle.c a(ViewGroup viewGroup, int i) {
            if (i == 1) {
                View inflate = LayoutInflater.from(this.c).inflate(R.layout.obfuscated_res_0x7f0d0424, viewGroup, false);
                Presenter presenter = new Presenter();
                presenter.a((Presenter) new com.kwad.sdk.core.page.kwai.b());
                return new com.kwad.sdk.core.page.recycle.c(inflate, presenter, this.b);
            } else if (i != 0) {
                View view2 = new View(viewGroup.getContext());
                view2.setLayoutParams(new ViewGroup.LayoutParams(-1, com.kwad.sdk.a.kwai.a.a(viewGroup.getContext(), 64.0f)));
                return new com.kwad.sdk.core.page.recycle.c(view2, new Presenter(), this.b);
            } else {
                k kVar = new k(viewGroup.getContext());
                Presenter presenter2 = new Presenter();
                presenter2.a((Presenter) new com.kwad.sdk.core.page.kwai.a());
                return new com.kwad.sdk.core.page.recycle.c(kVar, presenter2, this.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.core.page.recycle.d, androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(com.kwad.sdk.core.page.recycle.c cVar, int i) {
            super.onBindViewHolder(cVar, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return com.kwad.sdk.core.response.a.a.B(com.kwad.sdk.core.response.a.d.j(this.a)) ? 3 : 2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return i;
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
    public void a(View view2) {
        this.e = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09118b);
        this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09118c);
        ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09118d);
        this.g = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                b.this.e.setVisibility(8);
            }
        });
        AdInfo j = com.kwad.sdk.core.response.a.d.j(this.a);
        boolean af = com.kwad.sdk.core.response.a.a.af(j);
        String ab = com.kwad.sdk.core.response.a.a.ab(j);
        if (!af) {
            this.e.setVisibility(8);
            return;
        }
        this.e.setVisibility(0);
        this.f.setText(ab);
        this.f.setSelected(true);
    }

    @Override // com.kwad.sdk.core.page.recycle.a
    public com.kwad.sdk.core.page.recycle.d a(RecyclerView recyclerView) {
        return new a(this.a, recyclerView.getContext(), new e(this.a, this.d, recyclerView));
    }

    public void a(com.kwad.sdk.core.download.a.b bVar) {
        this.d = bVar;
    }

    @Override // com.kwad.sdk.h.d, com.kwad.sdk.h.kwai.b
    public boolean a_() {
        WebView webView = this.b;
        if (webView != null && webView.canGoBack()) {
            this.b.goBack();
            return true;
        }
        k kVar = this.c;
        if (kVar != null) {
            return kVar.d();
        }
        return false;
    }

    @Override // com.kwad.sdk.core.page.recycle.a
    public int b() {
        return R.layout.obfuscated_res_0x7f0d0425;
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
    public void onViewCreated(@NonNull View view2, @Nullable Bundle bundle) {
        super.onViewCreated(view2, bundle);
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
                    View view3 = detailWebRecycleView.findViewHolderForAdapterPosition(0).itemView;
                    if (view3 instanceof k) {
                        b.this.c = (k) view3;
                    }
                }
                if (detailWebRecycleView.getChildCount() > 1) {
                    View view4 = detailWebRecycleView.findViewHolderForAdapterPosition(1).itemView;
                    b.this.b = (WebView) view4.findViewById(R.id.obfuscated_res_0x7f091181);
                    b.this.a(view4);
                }
                com.kwad.sdk.core.d.a.a("AdRecycleWebFragment", "onGlobalLayout");
                detailWebRecycleView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }
}
