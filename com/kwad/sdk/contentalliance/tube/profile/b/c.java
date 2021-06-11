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
    public LinearLayout f33870b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33871c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33872d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33873e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f33874f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f33875g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f33876h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.tube.profile.e f33877i = new com.kwad.sdk.contentalliance.tube.profile.e() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.c.1
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
        this.f33871c.setText(ag.a(tubeInfo.name, string));
        this.f33872d.setText(ag.a(tubeInfo.authorName, string));
        this.f33873e.setVisibility(0);
        this.f33876h.setVisibility(0);
        int i2 = tubeInfo.totalEpisodeCount;
        String valueOf = i2 < 0 ? "" : String.valueOf(i2);
        if (tubeInfo.isFinished) {
            String string2 = o().getString(R.string.ksad_tube_update_finished_format_text);
            textView = this.f33874f;
            format = String.format(string2, ag.a(valueOf, string));
        } else {
            String string3 = o().getString(R.string.ksad_tube_update_unfinished_format_text);
            textView = this.f33874f;
            format = String.format(string3, ag.a(valueOf, string));
        }
        textView.setText(format);
        this.f33875g.setText(ag.a(tubeInfo.summary, string));
        this.f33870b.setVisibility(0);
    }

    @Override // com.kwad.sdk.contentalliance.tube.profile.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("TubeProfileHeaderPresenter", "TubeProfileHeaderPresenter onBind");
        ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33844a.f33849e.add(this.f33877i);
        TubeProfileParam tubeProfileParam = ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33844a.f33847c;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33844a.f33849e.remove(this.f33877i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("TubeProfileHeaderPresenter", "TubeProfileHeaderPresenter onCreate");
        this.f33870b = (LinearLayout) b(R.id.ksad_tube_author_info_area);
        this.f33871c = (TextView) b(R.id.ksad_tube_name);
        this.f33872d = (TextView) b(R.id.ksad_tube_author_name);
        this.f33873e = (TextView) b(R.id.ksad_tube_author_name_label);
        this.f33874f = (TextView) b(R.id.ksad_tube_update_info);
        this.f33875g = (TextView) b(R.id.ksad_tube_description);
        this.f33876h = (ImageView) b(R.id.ksad_tube_divider_line);
    }
}
