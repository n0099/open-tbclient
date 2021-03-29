package com.kwad.sdk.contentalliance.tube.detail.b;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.tube.b;
import com.kwad.sdk.contentalliance.tube.view.WarpLinearLayout;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.utils.ao;
import java.util.List;
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.contentalliance.tube.detail.a.a {

    /* renamed from: b  reason: collision with root package name */
    public WarpLinearLayout f33192b;

    /* renamed from: c  reason: collision with root package name */
    public b.a f33193c = new b.a() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.c.1
        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z) {
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, int i, String str) {
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, @NonNull AdResultData adResultData) {
            if (((com.kwad.sdk.contentalliance.tube.detail.a.a) c.this).f33158a.f33160b.mTubeInfo != null) {
                c cVar = c.this;
                cVar.a(((com.kwad.sdk.contentalliance.tube.detail.a.a) cVar).f33158a.f33160b.mTubeInfo.tagList);
            }
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void b(boolean z) {
        }
    };

    private View a(String str) {
        TextView textView = new TextView(o());
        textView.setText(str);
        textView.setPadding(ao.a(o(), 8.0f), ao.a(o(), 2.0f), ao.a(o(), ao.a(o(), 2.0f)), ao.a(o(), 2.0f));
        textView.setTextSize(12.0f);
        textView.setBackground(o().getResources().getDrawable(R.drawable.ksad_tube_detail_tag_bg));
        textView.setTextColor(o().getResources().getColor(R.color.ksad_tube_detail_description_text));
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<String> list) {
        WarpLinearLayout warpLinearLayout;
        int i;
        this.f33192b.removeAllViews();
        if (list == null || list.isEmpty()) {
            warpLinearLayout = this.f33192b;
            i = 8;
        } else {
            for (String str : list) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.rightMargin = ao.a(o(), 8.0f);
                this.f33192b.addView(a(str), layoutParams);
            }
            warpLinearLayout = this.f33192b;
            i = 0;
        }
        warpLinearLayout.setVisibility(i);
    }

    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33158a.f33162d.add(this.f33193c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33158a.f33162d.remove(this.f33193c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("TubeHeaderTagListPresenter", "TubeHeaderTagListPresenter onCreate");
        this.f33192b = (WarpLinearLayout) b(R.id.ksad_tube_tag_list_container);
    }
}
