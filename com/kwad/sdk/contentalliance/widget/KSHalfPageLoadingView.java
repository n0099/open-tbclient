package com.kwad.sdk.contentalliance.widget;

import android.content.Context;
import android.content.res.TypedArray;
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
import java.util.Arrays;
/* loaded from: classes5.dex */
public class KSHalfPageLoadingView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private TextView f9310a;

    /* renamed from: b  reason: collision with root package name */
    private LottieAnimationView f9311b;
    private KSPageLoadingView.a c;

    public KSHalfPageLoadingView(@NonNull Context context) {
        this(context, null);
    }

    public KSHalfPageLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KSHalfPageLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        inflate(getContext(), R.layout.ksad_content_half_page_loading, this);
        int i = R.attr.ksad_light_style;
        int[] iArr = {i};
        Arrays.sort(iArr);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, iArr);
        boolean z = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i), false);
        obtainStyledAttributes.recycle();
        this.f9310a = (TextView) findViewById(R.id.ksad_error_tip);
        this.f9310a.setTextColor(getContext().getResources().getColor(z ? R.color.ksad_hale_page_loading_error_title_light_color : R.color.ksad_hale_page_loading_error_title_dark_color));
        this.f9310a.setOnClickListener(this);
        int i2 = z ? R.raw.ksad_page_loading_light_anim : R.raw.ksad_detail_loading_amin_new;
        this.f9311b = (LottieAnimationView) findViewById(R.id.ksad_loading_anim);
        this.f9311b.setRepeatMode(1);
        this.f9311b.setRepeatCount(-1);
        this.f9311b.setAnimation(i2);
        setOnClickListener(this);
    }

    private void a(String str) {
        g();
        this.f9310a.setText(str);
        this.f9310a.setVisibility(0);
        this.f9310a.setOnClickListener(null);
        setVisibility(0);
    }

    private void g() {
        if (!this.f9311b.c()) {
            this.f9311b.d();
        }
        this.f9311b.setVisibility(8);
    }

    public void a() {
        setVisibility(8);
    }

    public void b() {
        this.f9310a.setVisibility(8);
        this.f9311b.setVisibility(0);
        if (!this.f9311b.c()) {
            this.f9311b.b();
        }
        setVisibility(0);
    }

    public void c() {
        g();
        this.f9310a.setText(q.j(getContext()));
        this.f9310a.setVisibility(0);
        this.f9310a.setOnClickListener(this);
        p.a(getContext());
        setVisibility(0);
    }

    public void d() {
        g();
        this.f9310a.setText(q.j(getContext()));
        this.f9310a.setVisibility(0);
        this.f9310a.setOnClickListener(this);
        p.b(getContext());
        setVisibility(0);
    }

    public void e() {
        a(getContext().getString(R.string.ksad_half_page_loading_no_related_tip));
    }

    public void f() {
        a(getContext().getString(R.string.ksad_half_page_loading_no_comment_tip));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!v.a(getContext())) {
            p.a(getContext());
        } else if (this.c != null) {
            this.c.a();
        }
    }

    public void setRetryClickListener(KSPageLoadingView.a aVar) {
        this.c = aVar;
    }
}
