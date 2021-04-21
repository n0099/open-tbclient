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
    public LinearLayout f33641b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33642c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33643d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33644e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f33645f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f33646g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f33647h;
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
        this.f33642c.setText(ag.a(tubeInfo.name, string));
        this.f33643d.setText(ag.a(tubeInfo.authorName, string));
        this.f33644e.setVisibility(0);
        this.f33647h.setVisibility(0);
        int i = tubeInfo.totalEpisodeCount;
        String valueOf = i < 0 ? "" : String.valueOf(i);
        if (tubeInfo.isFinished) {
            String string2 = o().getString(R.string.ksad_tube_update_finished_format_text);
            textView = this.f33645f;
            format = String.format(string2, ag.a(valueOf, string));
        } else {
            String string3 = o().getString(R.string.ksad_tube_update_unfinished_format_text);
            textView = this.f33645f;
            format = String.format(string3, ag.a(valueOf, string));
        }
        textView.setText(format);
        this.f33646g.setText(ag.a(tubeInfo.summary, string));
        this.f33641b.setVisibility(0);
    }

    @Override // com.kwad.sdk.contentalliance.tube.profile.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.core.d.a.a("TubeProfileHeaderPresenter", "TubeProfileHeaderPresenter onBind");
        ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33615a.f33620e.add(this.i);
        TubeProfileParam tubeProfileParam = ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33615a.f33618c;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33615a.f33620e.remove(this.i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("TubeProfileHeaderPresenter", "TubeProfileHeaderPresenter onCreate");
        this.f33641b = (LinearLayout) b(R.id.ksad_tube_author_info_area);
        this.f33642c = (TextView) b(R.id.ksad_tube_name);
        this.f33643d = (TextView) b(R.id.ksad_tube_author_name);
        this.f33644e = (TextView) b(R.id.ksad_tube_author_name_label);
        this.f33645f = (TextView) b(R.id.ksad_tube_update_info);
        this.f33646g = (TextView) b(R.id.ksad_tube_description);
        this.f33647h = (ImageView) b(R.id.ksad_tube_divider_line);
    }
}
