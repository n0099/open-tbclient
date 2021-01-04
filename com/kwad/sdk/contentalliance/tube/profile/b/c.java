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
/* loaded from: classes5.dex */
public class c extends com.kwad.sdk.contentalliance.tube.profile.a.a {

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f9268b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private ImageView h;
    private com.kwad.sdk.contentalliance.tube.profile.e i = new com.kwad.sdk.contentalliance.tube.profile.e() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.c.1
        @Override // com.kwad.sdk.contentalliance.tube.profile.e
        public void a(@NonNull TubeProfileResultData tubeProfileResultData) {
            c.this.a(tubeProfileResultData.tubeProfile.tubeInfo);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull TubeInfo tubeInfo) {
        String string = o().getString(R.string.ksad_text_placeholder);
        this.c.setText(ag.a(tubeInfo.name, string));
        this.d.setText(ag.a(tubeInfo.authorName, string));
        this.e.setVisibility(0);
        this.h.setVisibility(0);
        String valueOf = tubeInfo.totalEpisodeCount < 0 ? "" : String.valueOf(tubeInfo.totalEpisodeCount);
        if (tubeInfo.isFinished) {
            this.f.setText(String.format(o().getString(R.string.ksad_tube_update_finished_format_text), ag.a(valueOf, string)));
        } else {
            this.f.setText(String.format(o().getString(R.string.ksad_tube_update_unfinished_format_text), ag.a(valueOf, string)));
        }
        this.g.setText(ag.a(tubeInfo.summary, string));
        this.f9268b.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.tube.profile.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("TubeProfileHeaderPresenter", "TubeProfileHeaderPresenter onBind");
        this.f9252a.e.add(this.i);
        TubeProfileParam tubeProfileParam = this.f9252a.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f9252a.e.remove(this.i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("TubeProfileHeaderPresenter", "TubeProfileHeaderPresenter onCreate");
        this.f9268b = (LinearLayout) b(R.id.ksad_tube_author_info_area);
        this.c = (TextView) b(R.id.ksad_tube_name);
        this.d = (TextView) b(R.id.ksad_tube_author_name);
        this.e = (TextView) b(R.id.ksad_tube_author_name_label);
        this.f = (TextView) b(R.id.ksad_tube_update_info);
        this.g = (TextView) b(R.id.ksad_tube_description);
        this.h = (ImageView) b(R.id.ksad_tube_divider_line);
    }
}
