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
    public TextView f33893b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33894c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33895d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33896e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f33897f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f33898g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f33899h;

    /* renamed from: i  reason: collision with root package name */
    public b.a f33900i = new b.a() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.b.1
        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z) {
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, int i2, String str) {
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, @NonNull AdResultData adResultData) {
            b bVar = b.this;
            bVar.a(((com.kwad.sdk.contentalliance.tube.detail.a.a) bVar).f33866a.f33868b.mTubeInfo);
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
        this.f33893b.setText(ag.a(tubeInfo.name, string));
        this.f33894c.setText(ag.a(tubeInfo.authorName, string));
        this.f33895d.setVisibility(0);
        this.f33899h.setVisibility(0);
        String str = "";
        if (tubeInfo.totalEpisodeCount >= 0) {
            str = "" + tubeInfo.totalEpisodeCount;
        }
        if (tubeInfo.isFinished) {
            String string2 = o().getString(R.string.ksad_tube_update_finished_format_text);
            textView = this.f33896e;
            format = String.format(string2, ag.a(str, string));
        } else {
            String string3 = o().getString(R.string.ksad_tube_update_unfinished_format_text);
            textView = this.f33896e;
            format = String.format(string3, ag.a(str, string));
        }
        textView.setText(format);
        this.f33897f.setText(ag.a(tubeInfo.summary, string));
        this.f33898g.setVisibility(0);
    }

    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33866a.f33870d.add(this.f33900i);
        com.kwad.sdk.core.d.a.a("TubeDetailHeaderPresenter", "TubeDetailHeaderPresenter onBind");
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33866a.f33870d.remove(this.f33900i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("TubeDetailHeaderPresenter", "TubeDetailHeaderPresenter onCreate");
        this.f33898g = (LinearLayout) b(R.id.ksad_tube_author_info_area);
        this.f33895d = (TextView) b(R.id.ksad_tube_author_name_label);
        this.f33893b = (TextView) b(R.id.ksad_tube_name);
        this.f33894c = (TextView) b(R.id.ksad_tube_author_name);
        this.f33896e = (TextView) b(R.id.ksad_tube_update_info);
        this.f33897f = (TextView) b(R.id.ksad_tube_description);
        this.f33899h = (ImageView) b(R.id.ksad_tube_divider_line);
    }
}
