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
/* loaded from: classes6.dex */
public class KSPageLoadingView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public View f33364a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f33365b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33366c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33367d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33368e;

    /* renamed from: f  reason: collision with root package name */
    public LottieAnimationView f33369f;

    /* renamed from: g  reason: collision with root package name */
    public LottieAnimationView f33370g;

    /* renamed from: h  reason: collision with root package name */
    public a f33371h;
    public boolean i;

    /* loaded from: classes6.dex */
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
        FrameLayout.inflate(getContext(), R.layout.ksad_content_page_loading, this);
        int i = R.attr.ksad_light_style;
        int[] iArr = {i};
        Arrays.sort(iArr);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, iArr);
        this.i = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i), false);
        obtainStyledAttributes.recycle();
        View findViewById = findViewById(R.id.ksad_error_container);
        this.f33364a = findViewById;
        findViewById.setOnClickListener(this);
        this.f33364a.setBackgroundColor(getContext().getResources().getColor(this.i ? R.color.ksad_page_loading_error_container_light_color : R.color.ksad_page_loading_error_container_dark_color));
        ImageView imageView = (ImageView) findViewById(R.id.ksad_error_img);
        this.f33365b = imageView;
        imageView.setVisibility(0);
        TextView textView = (TextView) findViewById(R.id.ksad_error_title);
        this.f33366c = textView;
        textView.setTextColor(getContext().getResources().getColor(this.i ? R.color.ksad_page_loading_error_title_light_color : R.color.ksad_page_loading_error_title_dark_color));
        TextView textView2 = (TextView) findViewById(R.id.ksad_error_sub_title);
        this.f33367d = textView2;
        textView2.setTextColor(getContext().getResources().getColor(this.i ? R.color.ksad_page_loading_error_sub_title_light_color : R.color.ksad_page_loading_error_sub_title_dark_color));
        TextView textView3 = (TextView) findViewById(R.id.ksad_error_retry_btn);
        this.f33368e = textView3;
        textView3.setTextColor(getContext().getResources().getColor(this.i ? R.color.ksad_page_loading_error_retry_light_color : R.color.ksad_page_loading_error_retry_dark_color));
        this.f33368e.setBackgroundResource(this.i ? R.drawable.ksad_page_loading_error_retry_light_bg : R.drawable.ksad_page_loading_error_retry_dark_bg);
        this.f33368e.setOnClickListener(this);
        int i2 = this.i ? R.raw.ksad_page_loading_light_anim : R.raw.ksad_detail_loading_amin_new;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.ksad_center_loading_anim);
        this.f33369f = lottieAnimationView;
        lottieAnimationView.setRepeatMode(1);
        this.f33369f.setRepeatCount(-1);
        this.f33369f.setAnimation(i2);
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) findViewById(R.id.ksad_other_loading_anim);
        this.f33370g = lottieAnimationView2;
        lottieAnimationView2.setRepeatMode(1);
        this.f33370g.setRepeatCount(-1);
        this.f33370g.setAnimation(i2);
    }

    private void f() {
        if (!this.f33369f.c()) {
            this.f33369f.d();
        }
        this.f33369f.setVisibility(8);
    }

    private void g() {
        this.f33364a.setVisibility(8);
    }

    private void h() {
        if (!this.f33370g.c()) {
            this.f33370g.d();
        }
        this.f33370g.setVisibility(8);
    }

    public void a() {
        setVisibility(8);
    }

    public void a(boolean z) {
        f();
        h();
        this.f33365b.setImageDrawable(getContext().getResources().getDrawable(this.i ? R.drawable.ksad_page_loading_network_error : R.drawable.ksad_content_network_error));
        this.f33366c.setText(q.d(getContext()));
        this.f33366c.setVisibility(0);
        this.f33367d.setText(q.e(getContext()));
        this.f33367d.setVisibility(0);
        this.f33368e.setText(q.i(getContext()));
        this.f33368e.setVisibility(0);
        this.f33364a.setVisibility(0);
        if (z) {
            p.a(getContext());
        }
        setVisibility(0);
    }

    public void b() {
        h();
        g();
        this.f33369f.setVisibility(0);
        if (!this.f33369f.c()) {
            this.f33369f.b();
        }
        setVisibility(0);
    }

    public void b(boolean z) {
        f();
        h();
        this.f33365b.setImageDrawable(getContext().getResources().getDrawable(this.i ? R.drawable.ksad_page_loading_data_error : R.drawable.ksad_no_data_img));
        this.f33366c.setText(q.g(getContext()));
        this.f33366c.setVisibility(0);
        this.f33367d.setText(q.h(getContext()));
        this.f33367d.setVisibility(0);
        this.f33368e.setText(q.i(getContext()));
        this.f33368e.setVisibility(0);
        this.f33364a.setVisibility(0);
        if (z) {
            p.b(getContext());
        }
        setVisibility(0);
    }

    public void c() {
        f();
        h();
        this.f33365b.setImageDrawable(getContext().getResources().getDrawable(this.i ? R.drawable.ksad_page_loading_data_limit_error : R.drawable.ksad_no_video_img));
        this.f33366c.setText(getContext().getString(R.string.ksad_page_loading_data_limit_error_title));
        this.f33366c.setVisibility(0);
        this.f33367d.setVisibility(8);
        this.f33368e.setVisibility(8);
        this.f33364a.setVisibility(0);
        setVisibility(0);
    }

    public void d() {
        f();
        h();
        this.f33365b.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_no_video_img));
        this.f33366c.setText(getContext().getString(R.string.ksad_video_no_found));
        this.f33366c.setVisibility(0);
        this.f33367d.setText(getContext().getString(R.string.ksad_click_to_next_video));
        this.f33367d.setVisibility(0);
        this.f33368e.setText(getContext().getString(R.string.ksad_watch_next_video));
        this.f33368e.setVisibility(0);
        this.f33364a.setVisibility(0);
        setVisibility(0);
    }

    public void e() {
        g();
        f();
        if (!this.f33370g.c()) {
            this.f33370g.b();
        }
        this.f33370g.setVisibility(0);
        setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.f33368e) {
            return;
        }
        if (!v.a(getContext())) {
            p.a(getContext());
            return;
        }
        a aVar = this.f33371h;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void setRetryClickListener(a aVar) {
        this.f33371h = aVar;
    }
}
