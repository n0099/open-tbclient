package com.kwad.sdk.contentalliance.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.widget.KSPageLoadingView;
import com.kwad.sdk.utils.p;
import com.kwad.sdk.utils.q;
import com.kwad.sdk.utils.v;
/* loaded from: classes6.dex */
public class KSProfilePageLoadingView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public TextView f34087a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f34088b;

    /* renamed from: c  reason: collision with root package name */
    public LottieAnimationView f34089c;

    /* renamed from: d  reason: collision with root package name */
    public KSPageLoadingView.a f34090d;

    public KSProfilePageLoadingView(@NonNull Context context) {
        this(context, null);
    }

    public KSProfilePageLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KSProfilePageLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        FrameLayout.inflate(getContext(), R.layout.ksad_profile_page_loading, this);
        TextView textView = (TextView) findViewById(R.id.ksad_error_title);
        this.f34087a = textView;
        textView.setOnClickListener(this);
        this.f34088b = (TextView) findViewById(R.id.ksad_error_sub_title);
        int i2 = R.raw.ksad_detail_loading_amin_new;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.ksad_loading_anim);
        this.f34089c = lottieAnimationView;
        lottieAnimationView.setRepeatMode(1);
        this.f34089c.setRepeatCount(-1);
        this.f34089c.setAnimation(i2);
        setOnClickListener(this);
    }

    private void e() {
        if (!this.f34089c.c()) {
            this.f34089c.d();
        }
        this.f34089c.setVisibility(8);
    }

    private void f() {
        this.f34087a.setVisibility(8);
        this.f34088b.setVisibility(8);
    }

    public void a() {
        setVisibility(8);
    }

    public void b() {
        f();
        this.f34089c.setVisibility(0);
        if (!this.f34089c.c()) {
            this.f34089c.b();
        }
        setVisibility(0);
    }

    public void c() {
        e();
        this.f34087a.setText(q.d(getContext()));
        this.f34087a.setVisibility(0);
        this.f34088b.setText(q.e(getContext()));
        this.f34088b.setVisibility(0);
        p.a(getContext());
        setVisibility(0);
    }

    public void d() {
        e();
        this.f34087a.setText(q.g(getContext()));
        this.f34087a.setVisibility(0);
        this.f34088b.setText(q.h(getContext()));
        this.f34088b.setVisibility(0);
        p.b(getContext());
        setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!v.a(getContext())) {
            c();
            return;
        }
        KSPageLoadingView.a aVar = this.f34090d;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void setRetryClickListener(KSPageLoadingView.a aVar) {
        this.f34090d = aVar;
    }
}
