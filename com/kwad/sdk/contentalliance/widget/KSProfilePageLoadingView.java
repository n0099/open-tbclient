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
/* loaded from: classes4.dex */
public class KSProfilePageLoadingView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private TextView f9015a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f9016b;
    private LottieAnimationView c;
    private KSPageLoadingView.a d;

    public KSProfilePageLoadingView(@NonNull Context context) {
        this(context, null);
    }

    public KSProfilePageLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KSProfilePageLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        inflate(getContext(), R.layout.ksad_profile_page_loading, this);
        this.f9015a = (TextView) findViewById(R.id.ksad_error_title);
        this.f9015a.setOnClickListener(this);
        this.f9016b = (TextView) findViewById(R.id.ksad_error_sub_title);
        int i = R.raw.ksad_detail_loading_amin_new;
        this.c = (LottieAnimationView) findViewById(R.id.ksad_loading_anim);
        this.c.setRepeatMode(1);
        this.c.setRepeatCount(-1);
        this.c.setAnimation(i);
        setOnClickListener(this);
    }

    private void e() {
        if (!this.c.c()) {
            this.c.d();
        }
        this.c.setVisibility(8);
    }

    private void f() {
        this.f9015a.setVisibility(8);
        this.f9016b.setVisibility(8);
    }

    public void a() {
        setVisibility(8);
    }

    public void b() {
        f();
        this.c.setVisibility(0);
        if (!this.c.c()) {
            this.c.b();
        }
        setVisibility(0);
    }

    public void c() {
        e();
        this.f9015a.setText(q.d(getContext()));
        this.f9015a.setVisibility(0);
        this.f9016b.setText(q.e(getContext()));
        this.f9016b.setVisibility(0);
        p.a(getContext());
        setVisibility(0);
    }

    public void d() {
        e();
        this.f9015a.setText(q.g(getContext()));
        this.f9015a.setVisibility(0);
        this.f9016b.setText(q.h(getContext()));
        this.f9016b.setVisibility(0);
        p.b(getContext());
        setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!v.a(getContext())) {
            c();
        } else if (this.d != null) {
            this.d.a();
        }
    }

    public void setRetryClickListener(KSPageLoadingView.a aVar) {
        this.d = aVar;
    }
}
