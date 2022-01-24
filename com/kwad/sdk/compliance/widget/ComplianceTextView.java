package com.kwad.sdk.compliance.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.alibaba.fastjson.asm.Opcodes;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.l;
import org.apache.commons.lang3.StringUtils;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class ComplianceTextView extends TextView {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f55584b;

    /* renamed from: c  reason: collision with root package name */
    public String f55585c;

    /* renamed from: d  reason: collision with root package name */
    public String f55586d;

    /* renamed from: e  reason: collision with root package name */
    public String f55587e;

    /* renamed from: f  reason: collision with root package name */
    public int f55588f;

    /* renamed from: g  reason: collision with root package name */
    public String f55589g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f55590h;
    @ColorInt

    /* renamed from: i  reason: collision with root package name */
    public int f55591i;

    /* renamed from: j  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f55592j;

    public ComplianceTextView(Context context) {
        this(context, null);
    }

    public ComplianceTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ComplianceTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f55588f = Opcodes.IFNE;
        this.f55592j = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.sdk.compliance.widget.ComplianceTextView.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (ComplianceTextView.this.getWidth() > 0) {
                    ComplianceTextView complianceTextView = ComplianceTextView.this;
                    complianceTextView.a(complianceTextView.a, ComplianceTextView.this.f55584b, ComplianceTextView.this.f55585c);
                    ComplianceTextView.this.a();
                }
            }
        };
        a(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f55592j != null) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.f55592j);
            this.f55592j = null;
        }
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_ComplianceTextView);
        this.f55588f = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ksad_ComplianceTextView_ksad_width_in_landscape, Opcodes.IFNE);
        this.f55591i = obtainStyledAttributes.getColor(R.styleable.ksad_ComplianceTextView_ksad_privacy_color, getResources().getColor(R.color.ksad_default_privacy_link_color));
        if (getBackground() == null) {
            setBackground(ContextCompat.getDrawable(context, R.drawable.ksad_compliance_view_bg));
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f55592j);
        obtainStyledAttributes.recycle();
    }

    private void a(final String str, final String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.f55589g);
        if (!TextUtils.isEmpty(this.f55586d)) {
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) str);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.kwad.sdk.compliance.widget.ComplianceTextView.1
                @Override // android.text.style.ClickableSpan
                public void onClick(@NonNull View view) {
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C2113a().a(str).b(ComplianceTextView.this.f55586d).a(ComplianceTextView.this.f55590h).a());
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ComplianceTextView.this.f55591i);
                    textPaint.setUnderlineText(true);
                }
            }, length, spannableStringBuilder.length(), 33);
        }
        if (!TextUtils.isEmpty(this.f55586d) && !TextUtils.isEmpty(this.f55587e)) {
            spannableStringBuilder.append((CharSequence) " | ");
        }
        if (!TextUtils.isEmpty(this.f55587e)) {
            int length2 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) str2);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.kwad.sdk.compliance.widget.ComplianceTextView.2
                @Override // android.text.style.ClickableSpan
                public void onClick(@NonNull View view) {
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C2113a().a(str2).b(ComplianceTextView.this.f55587e).a(ComplianceTextView.this.f55590h).a());
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ComplianceTextView.this.f55591i);
                    textPaint.setUnderlineText(true);
                }
            }, length2, spannableStringBuilder.length(), 33);
        }
        setMovementMethod(LinkMovementMethod.getInstance());
        setHighlightColor(ContextCompat.getColor(getContext(), R.color.ksad_translucent));
        setText(spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        StringBuilder sb;
        if (TextUtils.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(this.f55586d) || !TextUtils.isEmpty(this.f55587e)) {
            sb2.append("   ");
        }
        if (!TextUtils.isEmpty(this.f55586d)) {
            sb2.append(str2);
        }
        if (!TextUtils.isEmpty(this.f55586d) && !TextUtils.isEmpty(this.f55587e)) {
            sb2.append(" | ");
        }
        if (!TextUtils.isEmpty(this.f55587e)) {
            sb2.append(str3);
        }
        int width = ((!af.e(getContext()) ? this.f55588f : getWidth()) - getPaddingLeft()) - getPaddingRight();
        if (width < 0) {
            return;
        }
        if (a(str, sb2.toString(), width)) {
            sb = new StringBuilder();
            sb.append(str);
            sb.append(StringUtils.LF);
        } else {
            sb = new StringBuilder();
            sb.append(str);
            sb.append("   ");
        }
        this.f55589g = sb.toString();
        a(str2, str3);
    }

    private boolean a(String str, String str2, int i2) {
        StaticLayout staticLayout;
        StaticLayout staticLayout2;
        String str3 = str + str2;
        if (Build.VERSION.SDK_INT >= 23) {
            staticLayout2 = StaticLayout.Builder.obtain(str, 0, str.length(), getPaint(), i2).build();
            staticLayout = StaticLayout.Builder.obtain(str3, 0, str3.length(), getPaint(), i2).build();
        } else {
            StaticLayout staticLayout3 = new StaticLayout(str, getPaint(), i2, Layout.Alignment.ALIGN_NORMAL, 0.0f, 0.0f, true);
            staticLayout = new StaticLayout(str3, getPaint(), i2, Layout.Alignment.ALIGN_NORMAL, 0.0f, 0.0f, true);
            staticLayout2 = staticLayout3;
        }
        return staticLayout.getLineCount() > staticLayout2.getLineCount();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public void setAdTemplate(AdTemplate adTemplate) {
        this.f55590h = adTemplate;
        AdInfo j2 = d.j(adTemplate);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(j2.adBaseInfo.appName)) {
            sb.append("应用名：");
            sb.append(j2.adBaseInfo.appName);
            sb.append("；");
        }
        if (!TextUtils.isEmpty(j2.adBaseInfo.appVersion)) {
            sb.append("版本号：");
            sb.append(j2.adBaseInfo.appVersion);
            sb.append("；");
        }
        if (j2.adBaseInfo.packageSize > 0) {
            sb.append("应用大小：");
            sb.append(l.a(j2.adBaseInfo.packageSize, true));
            sb.append("；");
        }
        if (!TextUtils.isEmpty(j2.adBaseInfo.corporationName)) {
            sb.append("开发者：");
            sb.append(j2.adBaseInfo.corporationName);
            sb.append("；");
        }
        this.a = sb.toString();
        this.f55584b = "权限信息";
        this.f55585c = "隐私政策";
        AdInfo.DownloadSafeInfo downloadSafeInfo = j2.downloadSafeInfo;
        this.f55586d = downloadSafeInfo.appPermissionInfoUrl;
        this.f55587e = downloadSafeInfo.appPrivacyUrl;
        if (!af.e(getContext())) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.width = bb.a(getContext(), this.f55588f);
            setLayoutParams(layoutParams);
        }
        a(this.a, this.f55584b, this.f55585c);
    }
}
