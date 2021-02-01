package com.kwad.sdk.contentalliance.tube.profile.b;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.tube.model.TubeProfileResultData;
import com.kwad.sdk.contentalliance.tube.view.WarpLinearLayout;
import com.kwad.sdk.utils.ao;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.contentalliance.tube.profile.a.a {

    /* renamed from: b  reason: collision with root package name */
    private WarpLinearLayout f8960b;
    private com.kwad.sdk.contentalliance.tube.profile.e c = new com.kwad.sdk.contentalliance.tube.profile.e() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.a.1
        @Override // com.kwad.sdk.contentalliance.tube.profile.e
        public void a(@NonNull TubeProfileResultData tubeProfileResultData) {
            a.this.a(tubeProfileResultData);
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
    public void a(@NonNull TubeProfileResultData tubeProfileResultData) {
        if (tubeProfileResultData.tubeProfile.tubeInfo.tagList == null || tubeProfileResultData.tubeProfile.tubeInfo.tagList.isEmpty()) {
            this.f8960b.setVisibility(8);
            return;
        }
        for (String str : tubeProfileResultData.tubeProfile.tubeInfo.tagList) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = ao.a(o(), 8.0f);
            this.f8960b.addView(a(str), layoutParams);
        }
        this.f8960b.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.tube.profile.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f8955a.e.add(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f8955a.e.remove(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("TubeHeaderTagListPresenter", "TubeHeaderTagListPresenter onCreate");
        this.f8960b = (WarpLinearLayout) b(R.id.ksad_tube_tag_list_container);
    }
}
