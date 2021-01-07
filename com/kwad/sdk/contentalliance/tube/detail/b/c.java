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
/* loaded from: classes5.dex */
public class c extends com.kwad.sdk.contentalliance.tube.detail.a.a {

    /* renamed from: b  reason: collision with root package name */
    private WarpLinearLayout f9237b;
    private b.a c = new b.a() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.c.1
        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z) {
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, int i, String str) {
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, @NonNull AdResultData adResultData) {
            if (c.this.f9222a.f9224b.mTubeInfo != null) {
                c.this.a(c.this.f9222a.f9224b.mTubeInfo.tagList);
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
        this.f9237b.removeAllViews();
        if (list == null || list.isEmpty()) {
            this.f9237b.setVisibility(8);
            return;
        }
        for (String str : list) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = ao.a(o(), 8.0f);
            this.f9237b.addView(a(str), layoutParams);
        }
        this.f9237b.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f9222a.d.add(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f9222a.d.remove(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("TubeHeaderTagListPresenter", "TubeHeaderTagListPresenter onCreate");
        this.f9237b = (WarpLinearLayout) b(R.id.ksad_tube_tag_list_container);
    }
}
