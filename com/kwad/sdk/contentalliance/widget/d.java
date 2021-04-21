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
    public TextView f33783a;

    /* renamed from: b  reason: collision with root package name */
    public LottieAnimationView f33784b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f33785c;

    public d(Context context) {
        super(context);
        b();
    }

    public d(Context context, boolean z) {
        super(context);
        this.f33785c = z;
        b();
    }

    private void b() {
        FrameLayout.inflate(getContext(), R.layout.ksad_content_page_load_more, this);
        TextView textView = (TextView) findViewById(R.id.ksad_loading_tip);
        this.f33783a = textView;
        textView.setTextColor(getContext().getResources().getColor(this.f33785c ? R.color.ksad_hale_page_loading_error_title_light_color : R.color.ksad_hale_page_loading_error_title_dark_color));
        this.f33784b = (LottieAnimationView) findViewById(R.id.ksad_loading_lottie);
        this.f33784b.setAnimation(this.f33785c ? R.raw.ksad_page_loading_light_anim : R.raw.ksad_detail_loading_amin_new);
        this.f33784b.setRepeatMode(1);
        this.f33784b.setRepeatCount(-1);
    }

    private void c() {
        if (!this.f33784b.c()) {
            this.f33784b.d();
        }
        this.f33784b.setVisibility(8);
    }

    public void a() {
        if (!this.f33784b.c()) {
            this.f33784b.b();
        }
        this.f33784b.setVisibility(0);
        this.f33783a.setVisibility(8);
    }

    public void a(boolean z) {
        TextView textView;
        int i;
        c();
        if (z || com.kwad.sdk.core.config.c.X()) {
            this.f33783a.setText(z ? getContext().getString(R.string.ksad_page_load_more_tip) : q.a(getContext()));
            textView = this.f33783a;
            i = 0;
        } else {
            textView = this.f33783a;
            i = 8;
        }
        textView.setVisibility(i);
    }
}
