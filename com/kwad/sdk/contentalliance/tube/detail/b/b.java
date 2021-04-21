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
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.contentalliance.tube.detail.a.a {

    /* renamed from: b  reason: collision with root package name */
    public TextView f33568b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33569c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33570d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33571e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f33572f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f33573g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f33574h;
    public b.a i = new b.a() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.b.1
        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z) {
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, int i, String str) {
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, @NonNull AdResultData adResultData) {
            b bVar = b.this;
            bVar.a(((com.kwad.sdk.contentalliance.tube.detail.a.a) bVar).f33542a.f33544b.mTubeInfo);
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void b(boolean z) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TubeInfo tubeInfo) {
        TextView textView;
        String format;
        if (tubeInfo == null) {
            tubeInfo = new TubeInfo();
        }
        String string = o().getString(R.string.ksad_text_placeholder);
        this.f33568b.setText(ag.a(tubeInfo.name, string));
        this.f33569c.setText(ag.a(tubeInfo.authorName, string));
        this.f33570d.setVisibility(0);
        this.f33574h.setVisibility(0);
        String str = "";
        if (tubeInfo.totalEpisodeCount >= 0) {
            str = "" + tubeInfo.totalEpisodeCount;
        }
        if (tubeInfo.isFinished) {
            String string2 = o().getString(R.string.ksad_tube_update_finished_format_text);
            textView = this.f33571e;
            format = String.format(string2, ag.a(str, string));
        } else {
            String string3 = o().getString(R.string.ksad_tube_update_unfinished_format_text);
            textView = this.f33571e;
            format = String.format(string3, ag.a(str, string));
        }
        textView.setText(format);
        this.f33572f.setText(ag.a(tubeInfo.summary, string));
        this.f33573g.setVisibility(0);
    }

    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33542a.f33546d.add(this.i);
        com.kwad.sdk.core.d.a.a("TubeDetailHeaderPresenter", "TubeDetailHeaderPresenter onBind");
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33542a.f33546d.remove(this.i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("TubeDetailHeaderPresenter", "TubeDetailHeaderPresenter onCreate");
        this.f33573g = (LinearLayout) b(R.id.ksad_tube_author_info_area);
        this.f33570d = (TextView) b(R.id.ksad_tube_author_name_label);
        this.f33568b = (TextView) b(R.id.ksad_tube_name);
        this.f33569c = (TextView) b(R.id.ksad_tube_author_name);
        this.f33571e = (TextView) b(R.id.ksad_tube_update_info);
        this.f33572f = (TextView) b(R.id.ksad_tube_description);
        this.f33574h = (ImageView) b(R.id.ksad_tube_divider_line);
    }
}
