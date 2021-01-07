package com.kwad.sdk.contentalliance.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.p;
import com.kwad.sdk.utils.q;
import com.kwad.sdk.utils.v;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class KSPageLoadingView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private View f9313a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f9314b;
    private TextView c;
    private TextView d;
    private TextView e;
    private LottieAnimationView f;
    private LottieAnimationView g;
    private a h;
    private boolean i;

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    public KSPageLoadingView(@NonNull Context context) {
        super(context);
        a((AttributeSet) null);
    }

    public KSPageLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public KSPageLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        inflate(getContext(), R.layout.ksad_content_page_loading, this);
        int i = R.attr.ksad_light_style;
        int[] iArr = {i};
        Arrays.sort(iArr);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, iArr);
        this.i = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i), false);
        obtainStyledAttributes.recycle();
        this.f9313a = findViewById(R.id.ksad_error_container);
        this.f9313a.setOnClickListener(this);
        this.f9313a.setBackgroundColor(getContext().getResources().getColor(this.i ? R.color.ksad_page_loading_error_container_light_color : R.color.ksad_page_loading_error_container_dark_color));
        this.f9314b = (ImageView) findViewById(R.id.ksad_error_img);
        this.f9314b.setVisibility(0);
        this.c = (TextView) findViewById(R.id.ksad_error_title);
        this.c.setTextColor(getContext().getResources().getColor(this.i ? R.color.ksad_page_loading_error_title_light_color : R.color.ksad_page_loading_error_title_dark_color));
        this.d = (TextView) findViewById(R.id.ksad_error_sub_title);
        this.d.setTextColor(getContext().getResources().getColor(this.i ? R.color.ksad_page_loading_error_sub_title_light_color : R.color.ksad_page_loading_error_sub_title_dark_color));
        this.e = (TextView) findViewById(R.id.ksad_error_retry_btn);
        this.e.setTextColor(getContext().getResources().getColor(this.i ? R.color.ksad_page_loading_error_retry_light_color : R.color.ksad_page_loading_error_retry_dark_color));
        this.e.setBackgroundResource(this.i ? R.drawable.ksad_page_loading_error_retry_light_bg : R.drawable.ksad_page_loading_error_retry_dark_bg);
        this.e.setOnClickListener(this);
        int i2 = this.i ? R.raw.ksad_page_loading_light_anim : R.raw.ksad_detail_loading_amin_new;
        this.f = (LottieAnimationView) findViewById(R.id.ksad_center_loading_anim);
        this.f.setRepeatMode(1);
        this.f.setRepeatCount(-1);
        this.f.setAnimation(i2);
        this.g = (LottieAnimationView) findViewById(R.id.ksad_other_loading_anim);
        this.g.setRepeatMode(1);
        this.g.setRepeatCount(-1);
        this.g.setAnimation(i2);
    }

    private void f() {
        if (!this.f.c()) {
            this.f.d();
        }
        this.f.setVisibility(8);
    }

    private void g() {
        this.f9313a.setVisibility(8);
    }

    private void h() {
        if (!this.g.c()) {
            this.g.d();
        }
        this.g.setVisibility(8);
    }

    public void a() {
        setVisibility(8);
    }

    public void a(boolean z) {
        f();
        h();
        this.f9314b.setImageDrawable(getContext().getResources().getDrawable(this.i ? R.drawable.ksad_page_loading_network_error : R.drawable.ksad_content_network_error));
        this.c.setText(q.d(getContext()));
        this.c.setVisibility(0);
        this.d.setText(q.e(getContext()));
        this.d.setVisibility(0);
        this.e.setText(q.i(getContext()));
        this.e.setVisibility(0);
        this.f9313a.setVisibility(0);
        if (z) {
            p.a(getContext());
        }
        setVisibility(0);
    }

    public void b() {
        h();
        g();
        this.f.setVisibility(0);
        if (!this.f.c()) {
            this.f.b();
        }
        setVisibility(0);
    }

    public void b(boolean z) {
        f();
        h();
        this.f9314b.setImageDrawable(getContext().getResources().getDrawable(this.i ? R.drawable.ksad_page_loading_data_error : R.drawable.ksad_no_data_img));
        this.c.setText(q.g(getContext()));
        this.c.setVisibility(0);
        this.d.setText(q.h(getContext()));
        this.d.setVisibility(0);
        this.e.setText(q.i(getContext()));
        this.e.setVisibility(0);
        this.f9313a.setVisibility(0);
        if (z) {
            p.b(getContext());
        }
        setVisibility(0);
    }

    public void c() {
        f();
        h();
        this.f9314b.setImageDrawable(getContext().getResources().getDrawable(this.i ? R.drawable.ksad_page_loading_data_limit_error : R.drawable.ksad_no_video_img));
        this.c.setText(getContext().getString(R.string.ksad_page_loading_data_limit_error_title));
        this.c.setVisibility(0);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        this.f9313a.setVisibility(0);
        setVisibility(0);
    }

    public void d() {
        f();
        h();
        this.f9314b.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_no_video_img));
        this.c.setText(getContext().getString(R.string.ksad_video_no_found));
        this.c.setVisibility(0);
        this.d.setText(getContext().getString(R.string.ksad_click_to_next_video));
        this.d.setVisibility(0);
        this.e.setText(getContext().getString(R.string.ksad_watch_next_video));
        this.e.setVisibility(0);
        this.f9313a.setVisibility(0);
        setVisibility(0);
    }

    public void e() {
        g();
        f();
        if (!this.g.c()) {
            this.g.b();
        }
        this.g.setVisibility(0);
        setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.e) {
            return;
        }
        if (!v.a(getContext())) {
            p.a(getContext());
        } else if (this.h != null) {
            this.h.a();
        }
    }

    public void setRetryClickListener(a aVar) {
        this.h = aVar;
    }
}
