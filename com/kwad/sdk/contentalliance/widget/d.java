package com.kwad.sdk.contentalliance.widget;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.q;
/* loaded from: classes6.dex */
public class d extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f34116a;

    /* renamed from: b  reason: collision with root package name */
    public LottieAnimationView f34117b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f34118c;

    public d(Context context) {
        super(context);
        b();
    }

    public d(Context context, boolean z) {
        super(context);
        this.f34118c = z;
        b();
    }

    private void b() {
        FrameLayout.inflate(getContext(), R.layout.ksad_content_page_load_more, this);
        TextView textView = (TextView) findViewById(R.id.ksad_loading_tip);
        this.f34116a = textView;
        textView.setTextColor(getContext().getResources().getColor(this.f34118c ? R.color.ksad_hale_page_loading_error_title_light_color : R.color.ksad_hale_page_loading_error_title_dark_color));
        this.f34117b = (LottieAnimationView) findViewById(R.id.ksad_loading_lottie);
        this.f34117b.setAnimation(this.f34118c ? R.raw.ksad_page_loading_light_anim : R.raw.ksad_detail_loading_amin_new);
        this.f34117b.setRepeatMode(1);
        this.f34117b.setRepeatCount(-1);
    }

    private void c() {
        if (!this.f34117b.c()) {
            this.f34117b.d();
        }
        this.f34117b.setVisibility(8);
    }

    public void a() {
        if (!this.f34117b.c()) {
            this.f34117b.b();
        }
        this.f34117b.setVisibility(0);
        this.f34116a.setVisibility(8);
    }

    public void a(boolean z) {
        TextView textView;
        int i2;
        c();
        if (z || com.kwad.sdk.core.config.c.X()) {
            this.f34116a.setText(z ? getContext().getString(R.string.ksad_page_load_more_tip) : q.a(getContext()));
            textView = this.f34116a;
            i2 = 0;
        } else {
            textView = this.f34116a;
            i2 = 8;
        }
        textView.setVisibility(i2);
    }
}
