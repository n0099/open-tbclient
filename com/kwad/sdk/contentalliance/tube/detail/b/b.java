package com.kwad.sdk.contentalliance.tube.detail.b;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.tube.b;
import com.kwad.sdk.contentalliance.tube.model.TubeInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.utils.ag;
/* loaded from: classes4.dex */
public class b extends com.kwad.sdk.contentalliance.tube.detail.a.a {

    /* renamed from: b  reason: collision with root package name */
    private TextView f8935b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private LinearLayout g;
    private ImageView h;
    private b.a i = new b.a() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.b.1
        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z) {
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, int i, String str) {
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, @NonNull AdResultData adResultData) {
            b.this.a(b.this.f8922a.f8924b.mTubeInfo);
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void b(boolean z) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TubeInfo tubeInfo) {
        if (tubeInfo == null) {
            tubeInfo = new TubeInfo();
        }
        String string = o().getString(R.string.ksad_text_placeholder);
        this.f8935b.setText(ag.a(tubeInfo.name, string));
        this.c.setText(ag.a(tubeInfo.authorName, string));
        this.d.setVisibility(0);
        this.h.setVisibility(0);
        String str = tubeInfo.totalEpisodeCount < 0 ? "" : "" + tubeInfo.totalEpisodeCount;
        if (tubeInfo.isFinished) {
            this.e.setText(String.format(o().getString(R.string.ksad_tube_update_finished_format_text), ag.a(str, string)));
        } else {
            this.e.setText(String.format(o().getString(R.string.ksad_tube_update_unfinished_format_text), ag.a(str, string)));
        }
        this.f.setText(ag.a(tubeInfo.summary, string));
        this.g.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f8922a.d.add(this.i);
        com.kwad.sdk.core.d.a.a("TubeDetailHeaderPresenter", "TubeDetailHeaderPresenter onBind");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f8922a.d.remove(this.i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("TubeDetailHeaderPresenter", "TubeDetailHeaderPresenter onCreate");
        this.g = (LinearLayout) b(R.id.ksad_tube_author_info_area);
        this.d = (TextView) b(R.id.ksad_tube_author_name_label);
        this.f8935b = (TextView) b(R.id.ksad_tube_name);
        this.c = (TextView) b(R.id.ksad_tube_author_name);
        this.e = (TextView) b(R.id.ksad_tube_update_info);
        this.f = (TextView) b(R.id.ksad_tube_description);
        this.h = (ImageView) b(R.id.ksad_tube_divider_line);
    }
}
