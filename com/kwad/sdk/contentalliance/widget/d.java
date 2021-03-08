package com.kwad.sdk.contentalliance.widget;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.q;
/* loaded from: classes3.dex */
public class d extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f6001a;
    private LottieAnimationView b;
    private boolean c;

    public d(Context context) {
        super(context);
        b();
    }

    public d(Context context, boolean z) {
        super(context);
        this.c = z;
        b();
    }

    private void b() {
        inflate(getContext(), R.layout.ksad_content_page_load_more, this);
        this.f6001a = (TextView) findViewById(R.id.ksad_loading_tip);
        this.f6001a.setTextColor(getContext().getResources().getColor(this.c ? R.color.ksad_hale_page_loading_error_title_light_color : R.color.ksad_hale_page_loading_error_title_dark_color));
        this.b = (LottieAnimationView) findViewById(R.id.ksad_loading_lottie);
        this.b.setAnimation(this.c ? R.raw.ksad_page_loading_light_anim : R.raw.ksad_detail_loading_amin_new);
        this.b.setRepeatMode(1);
        this.b.setRepeatCount(-1);
    }

    private void c() {
        if (!this.b.c()) {
            this.b.d();
        }
        this.b.setVisibility(8);
    }

    public void a() {
        if (!this.b.c()) {
            this.b.b();
        }
        this.b.setVisibility(0);
        this.f6001a.setVisibility(8);
    }

    public void a(boolean z) {
        c();
        if (!z && !com.kwad.sdk.core.config.c.X()) {
            this.f6001a.setVisibility(8);
            return;
        }
        this.f6001a.setText(z ? getContext().getString(R.string.ksad_page_load_more_tip) : q.a(getContext()));
        this.f6001a.setVisibility(0);
    }
}
