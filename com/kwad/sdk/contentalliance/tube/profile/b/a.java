package com.kwad.sdk.contentalliance.tube.profile.b;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.tube.model.TubeProfileResultData;
import com.kwad.sdk.contentalliance.tube.view.WarpLinearLayout;
import com.kwad.sdk.utils.ao;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.contentalliance.tube.profile.a.a {

    /* renamed from: b  reason: collision with root package name */
    public WarpLinearLayout f33529b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.tube.profile.e f33530c = new com.kwad.sdk.contentalliance.tube.profile.e() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.a.1
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
        WarpLinearLayout warpLinearLayout;
        int i;
        List<String> list = tubeProfileResultData.tubeProfile.tubeInfo.tagList;
        if (list == null || list.isEmpty()) {
            warpLinearLayout = this.f33529b;
            i = 8;
        } else {
            for (String str : tubeProfileResultData.tubeProfile.tubeInfo.tagList) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.rightMargin = ao.a(o(), 8.0f);
                this.f33529b.addView(a(str), layoutParams);
            }
            warpLinearLayout = this.f33529b;
            i = 0;
        }
        warpLinearLayout.setVisibility(i);
    }

    @Override // com.kwad.sdk.contentalliance.tube.profile.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33520a.f33525e.add(this.f33530c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33520a.f33525e.remove(this.f33530c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("TubeHeaderTagListPresenter", "TubeHeaderTagListPresenter onCreate");
        this.f33529b = (WarpLinearLayout) b(R.id.ksad_tube_tag_list_container);
    }
}
