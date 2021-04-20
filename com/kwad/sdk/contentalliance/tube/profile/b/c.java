package com.kwad.sdk.contentalliance.tube.profile.b;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.tube.model.TubeInfo;
import com.kwad.sdk.contentalliance.tube.model.TubeProfileResultData;
import com.kwad.sdk.contentalliance.tube.profile.TubeProfileParam;
import com.kwad.sdk.utils.ag;
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.contentalliance.tube.profile.a.a {

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f33546b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33547c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33548d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33549e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f33550f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f33551g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f33552h;
    public com.kwad.sdk.contentalliance.tube.profile.e i = new com.kwad.sdk.contentalliance.tube.profile.e() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.c.1
        @Override // com.kwad.sdk.contentalliance.tube.profile.e
        public void a(@NonNull TubeProfileResultData tubeProfileResultData) {
            c.this.a(tubeProfileResultData.tubeProfile.tubeInfo);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull TubeInfo tubeInfo) {
        TextView textView;
        String format;
        String string = o().getString(R.string.ksad_text_placeholder);
        this.f33547c.setText(ag.a(tubeInfo.name, string));
        this.f33548d.setText(ag.a(tubeInfo.authorName, string));
        this.f33549e.setVisibility(0);
        this.f33552h.setVisibility(0);
        int i = tubeInfo.totalEpisodeCount;
        String valueOf = i < 0 ? "" : String.valueOf(i);
        if (tubeInfo.isFinished) {
            String string2 = o().getString(R.string.ksad_tube_update_finished_format_text);
            textView = this.f33550f;
            format = String.format(string2, ag.a(valueOf, string));
        } else {
            String string3 = o().getString(R.string.ksad_tube_update_unfinished_format_text);
            textView = this.f33550f;
            format = String.format(string3, ag.a(valueOf, string));
        }
        textView.setText(format);
        this.f33551g.setText(ag.a(tubeInfo.summary, string));
        this.f33546b.setVisibility(0);
    }

    @Override // com.kwad.sdk.contentalliance.tube.profile.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("TubeProfileHeaderPresenter", "TubeProfileHeaderPresenter onBind");
        ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33520a.f33525e.add(this.i);
        TubeProfileParam tubeProfileParam = ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33520a.f33523c;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33520a.f33525e.remove(this.i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("TubeProfileHeaderPresenter", "TubeProfileHeaderPresenter onCreate");
        this.f33546b = (LinearLayout) b(R.id.ksad_tube_author_info_area);
        this.f33547c = (TextView) b(R.id.ksad_tube_name);
        this.f33548d = (TextView) b(R.id.ksad_tube_author_name);
        this.f33549e = (TextView) b(R.id.ksad_tube_author_name_label);
        this.f33550f = (TextView) b(R.id.ksad_tube_update_info);
        this.f33551g = (TextView) b(R.id.ksad_tube_description);
        this.f33552h = (ImageView) b(R.id.ksad_tube_divider_line);
    }
}
