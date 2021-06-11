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
/* loaded from: classes6.dex */
public class KSHalfPageLoadingView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public TextView f33977a;

    /* renamed from: b  reason: collision with root package name */
    public LottieAnimationView f33978b;

    /* renamed from: c  reason: collision with root package name */
    public KSPageLoadingView.a f33979c;

    public KSHalfPageLoadingView(@NonNull Context context) {
        this(context, null);
    }

    public KSHalfPageLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KSHalfPageLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        FrameLayout.inflate(getContext(), R.layout.ksad_content_half_page_loading, this);
        int i2 = R.attr.ksad_light_style;
        int[] iArr = {i2};
        Arrays.sort(iArr);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, iArr);
        boolean z = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i2), false);
        obtainStyledAttributes.recycle();
        TextView textView = (TextView) findViewById(R.id.ksad_error_tip);
        this.f33977a = textView;
        textView.setTextColor(getContext().getResources().getColor(z ? R.color.ksad_hale_page_loading_error_title_light_color : R.color.ksad_hale_page_loading_error_title_dark_color));
        this.f33977a.setOnClickListener(this);
        int i3 = z ? R.raw.ksad_page_loading_light_anim : R.raw.ksad_detail_loading_amin_new;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.ksad_loading_anim);
        this.f33978b = lottieAnimationView;
        lottieAnimationView.setRepeatMode(1);
        this.f33978b.setRepeatCount(-1);
        this.f33978b.setAnimation(i3);
        setOnClickListener(this);
    }

    private void a(String str) {
        g();
        this.f33977a.setText(str);
        this.f33977a.setVisibility(0);
        this.f33977a.setOnClickListener(null);
        setVisibility(0);
    }

    private void g() {
        if (!this.f33978b.c()) {
            this.f33978b.d();
        }
        this.f33978b.setVisibility(8);
    }

    public void a() {
        setVisibility(8);
    }

    public void b() {
        this.f33977a.setVisibility(8);
        this.f33978b.setVisibility(0);
        if (!this.f33978b.c()) {
            this.f33978b.b();
        }
        setVisibility(0);
    }

    public void c() {
        g();
        this.f33977a.setText(q.j(getContext()));
        this.f33977a.setVisibility(0);
        this.f33977a.setOnClickListener(this);
        p.a(getContext());
        setVisibility(0);
    }

    public void d() {
        g();
        this.f33977a.setText(q.j(getContext()));
        this.f33977a.setVisibility(0);
        this.f33977a.setOnClickListener(this);
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
            return;
        }
        KSPageLoadingView.a aVar = this.f33979c;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void setRetryClickListener(KSPageLoadingView.a aVar) {
        this.f33979c = aVar;
    }
}
