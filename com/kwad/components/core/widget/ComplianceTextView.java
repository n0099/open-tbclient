package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.baidu.sapi2.views.logindialog.view.AgreementView;
import com.baidu.tieba.R;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ai;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes10.dex */
public class ComplianceTextView extends TextView {
    public String abc;
    public String abd;
    public String abe;
    public String abf;
    public String abg;
    public String abh;
    public String abi;
    public int abj;
    public AdTemplate mAdTemplate;
    @ColorInt
    public int textColor;

    public ComplianceTextView(Context context) {
        this(context, null);
    }

    public ComplianceTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ComplianceTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.abc = "...";
        this.abj = Cea708Decoder.COMMAND_DF2;
        init(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4, String str5, String str6) {
        int width;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str3)) {
            sb.append(" | 版本 ");
            sb.append(str3);
        }
        if (!TextUtils.isEmpty(this.abh)) {
            sb.append(" | ");
            sb.append(str4);
        }
        if (!TextUtils.isEmpty(this.abg)) {
            sb.append(" | ");
            sb.append(str5);
        }
        if (!TextUtils.isEmpty(this.abi)) {
            sb.append(" | ");
            sb.append(str6);
        }
        getContext();
        if (!ai.Kx()) {
            width = (this.abj - getPaddingLeft()) - getPaddingRight();
            z = true;
        } else {
            width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            z = false;
        }
        if (width < 0) {
            return;
        }
        if (!z && !TextUtils.isEmpty(str2)) {
            Paint paint = new Paint();
            paint.setTextSize(getTextSize());
            float measureText = width - paint.measureText(str + sb.toString());
            if (paint.measureText(" " + str2) > measureText && measureText > 0.0f) {
                while (str2.length() > 1) {
                    str2 = str2.substring(0, str2.length() - 1);
                    if (paint.measureText(" " + str2 + this.abc) <= measureText) {
                        break;
                    }
                }
            } else {
                this.abc = "";
            }
        } else {
            this.abc = "";
        }
        b(str, str2 + this.abc, str3, str4, str5, str6);
        requestLayout();
    }

    private void b(String str, String str2, String str3, String str4, String str5, String str6) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(str)) {
            spannableStringBuilder.append((CharSequence) str);
        }
        if (!TextUtils.isEmpty(str2)) {
            spannableStringBuilder.append((CharSequence) " ").append((CharSequence) str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            spannableStringBuilder.append((CharSequence) " | 版本 ").append((CharSequence) str3);
        }
        if (!TextUtils.isEmpty(this.abh)) {
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) " | ").append((CharSequence) str4);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.kwad.components.core.widget.ComplianceTextView.2
                @Override // android.text.style.ClickableSpan
                public final void onClick(@NonNull View view2) {
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C0655a().al("功能介绍").am(ComplianceTextView.this.abh).aB(true).as(ComplianceTextView.this.mAdTemplate).pa());
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ComplianceTextView.this.textColor);
                    textPaint.setUnderlineText(false);
                }
            }, length, spannableStringBuilder.length(), 33);
        }
        if (!TextUtils.isEmpty(this.abg)) {
            int length2 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) " | ").append((CharSequence) str5);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.kwad.components.core.widget.ComplianceTextView.3
                @Override // android.text.style.ClickableSpan
                public final void onClick(@NonNull View view2) {
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C0655a().al("权限信息").am(ComplianceTextView.this.abg).aB(true).as(ComplianceTextView.this.mAdTemplate).pa());
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ComplianceTextView.this.textColor);
                    textPaint.setUnderlineText(false);
                }
            }, length2, spannableStringBuilder.length(), 33);
        }
        if (!TextUtils.isEmpty(this.abi)) {
            int length3 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) " | ").append((CharSequence) str6);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.kwad.components.core.widget.ComplianceTextView.4
                @Override // android.text.style.ClickableSpan
                public final void onClick(@NonNull View view2) {
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C0655a().al(AgreementView.l).am(ComplianceTextView.this.abi).aB(true).as(ComplianceTextView.this.mAdTemplate).pa());
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ComplianceTextView.this.textColor);
                    textPaint.setUnderlineText(false);
                }
            }, length3, spannableStringBuilder.length(), 33);
        }
        spannableStringBuilder.append((CharSequence) " ");
        setMovementMethod(LinkMovementMethod.getInstance());
        setHighlightColor(ContextCompat.getColor(getContext(), R.color.obfuscated_res_0x7f0607b3));
        setText(spannableStringBuilder);
    }

    @SuppressLint({"CustomViewStyleable"})
    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.kwad.sdk.R.styleable.ksad_ComplianceTextView);
        this.abj = obtainStyledAttributes.getDimensionPixelOffset(2, Cea708Decoder.COMMAND_DF2);
        int color = obtainStyledAttributes.getColor(0, Color.parseColor("#99FFFFFF"));
        this.textColor = color;
        setTextColor(color);
        if (ai.isOrientationPortrait()) {
            setBackgroundColor(0);
        } else {
            setBackground(ContextCompat.getDrawable(context, R.drawable.obfuscated_res_0x7f080e66));
        }
        obtainStyledAttributes.recycle();
    }

    public void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        final AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        this.abd = "功能";
        this.abe = "权限";
        this.abf = "隐私";
        AdInfo.DownloadSafeInfo downloadSafeInfo = dP.downloadSafeInfo;
        this.abg = downloadSafeInfo.appPermissionInfoUrl;
        this.abi = downloadSafeInfo.appPrivacyUrl;
        this.abh = downloadSafeInfo.introductionInfoUrl;
        if (this.abj > 0) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            getContext();
            if (!ai.Kx()) {
                layoutParams.width = com.kwad.sdk.d.a.a.a(getContext(), this.abj);
            } else {
                layoutParams.width = -1;
            }
            setLayoutParams(layoutParams);
        }
        post(new Runnable() { // from class: com.kwad.components.core.widget.ComplianceTextView.1
            @Override // java.lang.Runnable
            public final void run() {
                String str;
                ComplianceTextView complianceTextView = ComplianceTextView.this;
                AdInfo.DownloadSafeInfo downloadSafeInfo2 = dP.downloadSafeInfo;
                String str2 = downloadSafeInfo2.appName;
                if (TextUtils.isEmpty(downloadSafeInfo2.corporationName)) {
                    str = "";
                } else {
                    str = dP.downloadSafeInfo.corporationName;
                }
                complianceTextView.a(str2, str, dP.downloadSafeInfo.appVersion, ComplianceTextView.this.abd, ComplianceTextView.this.abe, ComplianceTextView.this.abf);
            }
        });
    }
}
