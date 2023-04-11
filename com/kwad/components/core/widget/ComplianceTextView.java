package com.kwad.components.core.widget;

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
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.baidu.sapi2.views.logindialog.view.AgreementView;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.components.core.m.h;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes8.dex */
public class ComplianceTextView extends TextView {
    public String OC;
    public String OD;
    public String OE;
    public String OF;
    public String OG;
    public int OH;
    public String OI;
    @ColorInt
    public int OJ;
    public boolean OK;
    public AdTemplate mAdTemplate;

    public ComplianceTextView(Context context) {
        this(context, null);
    }

    public ComplianceTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ComplianceTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.OH = Cea708Decoder.COMMAND_DF2;
        b(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        StringBuilder sb;
        if (TextUtils.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(this.OF) || !TextUtils.isEmpty(this.OG)) {
            sb2.append("   ");
        }
        if (!TextUtils.isEmpty(this.OF)) {
            sb2.append(str2);
        }
        if (!TextUtils.isEmpty(this.OF) && !TextUtils.isEmpty(this.OG)) {
            sb2.append(" | ");
        }
        if (!TextUtils.isEmpty(this.OG)) {
            sb2.append(str3);
        }
        int width = ((!ag.cB(getContext()) ? this.OH : getWidth()) - getPaddingLeft()) - getPaddingRight();
        if (width < 0) {
            return;
        }
        if (a(str, sb2.toString(), width)) {
            sb = new StringBuilder();
            sb.append(str);
            sb.append("\n");
        } else {
            sb = new StringBuilder();
            sb.append(str);
            sb.append("   ");
        }
        this.OI = sb.toString();
        l(str2, str3);
        requestLayout();
    }

    private boolean a(String str, String str2, int i) {
        StaticLayout staticLayout;
        StaticLayout staticLayout2;
        String str3 = str + str2;
        if (Build.VERSION.SDK_INT >= 23) {
            staticLayout2 = StaticLayout.Builder.obtain(str, 0, str.length(), getPaint(), i).build();
            staticLayout = StaticLayout.Builder.obtain(str3, 0, str3.length(), getPaint(), i).build();
        } else {
            StaticLayout staticLayout3 = new StaticLayout(str, getPaint(), i, Layout.Alignment.ALIGN_NORMAL, 0.0f, 0.0f, true);
            staticLayout = new StaticLayout(str3, getPaint(), i, Layout.Alignment.ALIGN_NORMAL, 0.0f, 0.0f, true);
            staticLayout2 = staticLayout3;
        }
        return staticLayout.getLineCount() > staticLayout2.getLineCount();
    }

    @SuppressLint({"CustomViewStyleable"})
    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_ComplianceTextView);
        this.OH = obtainStyledAttributes.getDimensionPixelOffset(2, Cea708Decoder.COMMAND_DF2);
        this.OJ = obtainStyledAttributes.getColor(0, getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f060615));
        this.OK = obtainStyledAttributes.getBoolean(1, true);
        if (getBackground() == null) {
            setBackground(ContextCompat.getDrawable(context, com.baidu.tieba.R.drawable.obfuscated_res_0x7f080c73));
        }
        obtainStyledAttributes.recycle();
    }

    private void l(final String str, final String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.OI);
        if (!TextUtils.isEmpty(this.OF)) {
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) str);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.kwad.components.core.widget.ComplianceTextView.2
                @Override // android.text.style.ClickableSpan
                public final void onClick(@NonNull View view2) {
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C0601a().ao(str).ap(ComplianceTextView.this.OF).N(ComplianceTextView.this.mAdTemplate).nx());
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ComplianceTextView.this.OJ);
                    textPaint.setUnderlineText(ComplianceTextView.this.OK);
                }
            }, length, spannableStringBuilder.length(), 33);
        }
        if (!TextUtils.isEmpty(this.OF) && !TextUtils.isEmpty(this.OG)) {
            spannableStringBuilder.append((CharSequence) " | ");
        }
        if (!TextUtils.isEmpty(this.OG)) {
            int length2 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) str2);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.kwad.components.core.widget.ComplianceTextView.3
                @Override // android.text.style.ClickableSpan
                public final void onClick(@NonNull View view2) {
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C0601a().ao(str2).ap(ComplianceTextView.this.OG).N(ComplianceTextView.this.mAdTemplate).nx());
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ComplianceTextView.this.OJ);
                    textPaint.setUnderlineText(ComplianceTextView.this.OK);
                }
            }, length2, spannableStringBuilder.length(), 33);
        }
        spannableStringBuilder.append((CharSequence) " ");
        setMovementMethod(LinkMovementMethod.getInstance());
        setHighlightColor(ContextCompat.getColor(getContext(), com.baidu.tieba.R.color.obfuscated_res_0x7f060627));
        setText(spannableStringBuilder);
    }

    public void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(bQ.adBaseInfo.appName)) {
            sb.append("应用名：");
            sb.append(bQ.adBaseInfo.appName);
            sb.append("；");
        }
        if (!TextUtils.isEmpty(bQ.adBaseInfo.appVersion)) {
            sb.append("版本号：");
            sb.append(bQ.adBaseInfo.appVersion);
            sb.append("；");
        }
        if (bQ.adBaseInfo.packageSize > 0) {
            sb.append("应用大小：");
            sb.append(h.a(bQ.adBaseInfo.packageSize, true));
            sb.append("；");
        }
        if (!TextUtils.isEmpty(bQ.adBaseInfo.corporationName)) {
            sb.append("开发者：");
            sb.append(bQ.adBaseInfo.corporationName);
            sb.append("；");
        }
        this.OC = sb.toString();
        this.OD = "权限信息";
        this.OE = AgreementView.l;
        AdInfo.DownloadSafeInfo downloadSafeInfo = bQ.downloadSafeInfo;
        this.OF = downloadSafeInfo.appPermissionInfoUrl;
        this.OG = downloadSafeInfo.appPrivacyUrl;
        if (this.OH > 0) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.width = !ag.cB(getContext()) ? com.kwad.sdk.b.kwai.a.a(getContext(), this.OH) : -1;
            setLayoutParams(layoutParams);
        }
        post(new Runnable() { // from class: com.kwad.components.core.widget.ComplianceTextView.1
            @Override // java.lang.Runnable
            public final void run() {
                ComplianceTextView complianceTextView = ComplianceTextView.this;
                complianceTextView.a(complianceTextView.OC, ComplianceTextView.this.OD, ComplianceTextView.this.OE);
            }
        });
    }
}
