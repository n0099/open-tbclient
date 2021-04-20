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
    public TextView f33688a;

    /* renamed from: b  reason: collision with root package name */
    public LottieAnimationView f33689b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f33690c;

    public d(Context context) {
        super(context);
        b();
    }

    public d(Context context, boolean z) {
        super(context);
        this.f33690c = z;
        b();
    }

    private void b() {
        FrameLayout.inflate(getContext(), R.layout.ksad_content_page_load_more, this);
        TextView textView = (TextView) findViewById(R.id.ksad_loading_tip);
        this.f33688a = textView;
        textView.setTextColor(getContext().getResources().getColor(this.f33690c ? R.color.ksad_hale_page_loading_error_title_light_color : R.color.ksad_hale_page_loading_error_title_dark_color));
        this.f33689b = (LottieAnimationView) findViewById(R.id.ksad_loading_lottie);
        this.f33689b.setAnimation(this.f33690c ? R.raw.ksad_page_loading_light_anim : R.raw.ksad_detail_loading_amin_new);
        this.f33689b.setRepeatMode(1);
        this.f33689b.setRepeatCount(-1);
    }

    private void c() {
        if (!this.f33689b.c()) {
            this.f33689b.d();
        }
        this.f33689b.setVisibility(8);
    }

    public void a() {
        if (!this.f33689b.c()) {
            this.f33689b.b();
        }
        this.f33689b.setVisibility(0);
        this.f33688a.setVisibility(8);
    }

    public void a(boolean z) {
        TextView textView;
        int i;
        c();
        if (z || com.kwad.sdk.core.config.c.X()) {
            this.f33688a.setText(z ? getContext().getString(R.string.ksad_page_load_more_tip) : q.a(getContext()));
            textView = this.f33688a;
            i = 0;
        } else {
            textView = this.f33688a;
            i = 8;
        }
        textView.setVisibility(i);
    }
}
