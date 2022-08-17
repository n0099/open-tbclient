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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.views.logindialog.view.AgreementView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.components.core.m.h;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes5.dex */
public class ComplianceTextView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ComplianceTextView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ComplianceTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComplianceTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.OH = Cea708Decoder.COMMAND_DF2;
        b(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, this, str, str2, str3) == null) {
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
    }

    private boolean a(String str, String str2, int i) {
        InterceptResult invokeLLI;
        StaticLayout staticLayout;
        StaticLayout staticLayout2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65542, this, str, str2, i)) == null) {
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
        return invokeLLI.booleanValue;
    }

    @SuppressLint({"CustomViewStyleable"})
    private void b(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0403b2, R.attr.obfuscated_res_0x7f0403b9, R.attr.obfuscated_res_0x7f0403df});
            this.OH = obtainStyledAttributes.getDimensionPixelOffset(2, Cea708Decoder.COMMAND_DF2);
            this.OJ = obtainStyledAttributes.getColor(0, getResources().getColor(R.color.obfuscated_res_0x7f060762));
            this.OK = obtainStyledAttributes.getBoolean(1, true);
            if (getBackground() == null) {
                setBackground(ContextCompat.getDrawable(context, R.drawable.obfuscated_res_0x7f080be3));
            }
            obtainStyledAttributes.recycle();
        }
    }

    private void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, this, str, str2) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.OI);
            if (!TextUtils.isEmpty(this.OF)) {
                int length = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) str);
                spannableStringBuilder.setSpan(new ClickableSpan(this, str) { // from class: com.kwad.components.core.widget.ComplianceTextView.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ComplianceTextView OL;
                    public final /* synthetic */ String OM;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.OL = this;
                        this.OM = str;
                    }

                    @Override // android.text.style.ClickableSpan
                    public final void onClick(@NonNull View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            AdWebViewActivityProxy.launch(this.OL.getContext(), new AdWebViewActivityProxy.a.C0361a().ao(this.OM).ap(this.OL.OF).N(this.OL.mAdTemplate).nx());
                        }
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public final void updateDrawState(@NonNull TextPaint textPaint) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                            super.updateDrawState(textPaint);
                            textPaint.setColor(this.OL.OJ);
                            textPaint.setUnderlineText(this.OL.OK);
                        }
                    }
                }, length, spannableStringBuilder.length(), 33);
            }
            if (!TextUtils.isEmpty(this.OF) && !TextUtils.isEmpty(this.OG)) {
                spannableStringBuilder.append((CharSequence) " | ");
            }
            if (!TextUtils.isEmpty(this.OG)) {
                int length2 = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) str2);
                spannableStringBuilder.setSpan(new ClickableSpan(this, str2) { // from class: com.kwad.components.core.widget.ComplianceTextView.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ComplianceTextView OL;
                    public final /* synthetic */ String ON;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.OL = this;
                        this.ON = str2;
                    }

                    @Override // android.text.style.ClickableSpan
                    public final void onClick(@NonNull View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            AdWebViewActivityProxy.launch(this.OL.getContext(), new AdWebViewActivityProxy.a.C0361a().ao(this.ON).ap(this.OL.OG).N(this.OL.mAdTemplate).nx());
                        }
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public final void updateDrawState(@NonNull TextPaint textPaint) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                            super.updateDrawState(textPaint);
                            textPaint.setColor(this.OL.OJ);
                            textPaint.setUnderlineText(this.OL.OK);
                        }
                    }
                }, length2, spannableStringBuilder.length(), 33);
            }
            spannableStringBuilder.append((CharSequence) " ");
            setMovementMethod(LinkMovementMethod.getInstance());
            setHighlightColor(ContextCompat.getColor(getContext(), R.color.obfuscated_res_0x7f060774));
            setText(spannableStringBuilder);
        }
    }

    public void setAdTemplate(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adTemplate) == null) {
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
            post(new Runnable(this) { // from class: com.kwad.components.core.widget.ComplianceTextView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ComplianceTextView OL;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.OL = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ComplianceTextView complianceTextView = this.OL;
                        complianceTextView.a(complianceTextView.OC, this.OL.OD, this.OL.OE);
                    }
                }
            });
        }
    }
}
