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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.components.core.l.h;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ae;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes5.dex */
public class ComplianceTextView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public int f;
    public String g;
    public AdTemplate h;
    @ColorInt
    public int i;
    public boolean j;

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
        this.f = Cea708Decoder.COMMAND_DF2;
        a(context, attributeSet);
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040374, R.attr.obfuscated_res_0x7f04037b, R.attr.obfuscated_res_0x7f0403a1});
            this.f = obtainStyledAttributes.getDimensionPixelOffset(2, Cea708Decoder.COMMAND_DF2);
            this.i = obtainStyledAttributes.getColor(0, getResources().getColor(R.color.obfuscated_res_0x7f060753));
            this.j = obtainStyledAttributes.getBoolean(1, true);
            if (getBackground() == null) {
                setBackground(ContextCompat.getDrawable(context, R.drawable.obfuscated_res_0x7f080bbc));
            }
            obtainStyledAttributes.recycle();
        }
    }

    private void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, this, str, str2) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.g);
            if (!TextUtils.isEmpty(this.d)) {
                int length = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) str);
                spannableStringBuilder.setSpan(new ClickableSpan(this, str) { // from class: com.kwad.components.core.widget.ComplianceTextView.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;
                    public final /* synthetic */ ComplianceTextView b;

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
                        this.b = this;
                        this.a = str;
                    }

                    @Override // android.text.style.ClickableSpan
                    public final void onClick(@NonNull View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            AdWebViewActivityProxy.launch(this.b.getContext(), new AdWebViewActivityProxy.a.C0514a().a(this.a).b(this.b.d).a(this.b.h).a());
                        }
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public final void updateDrawState(@NonNull TextPaint textPaint) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                            super.updateDrawState(textPaint);
                            textPaint.setColor(this.b.i);
                            textPaint.setUnderlineText(this.b.j);
                        }
                    }
                }, length, spannableStringBuilder.length(), 33);
            }
            if (!TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(this.e)) {
                spannableStringBuilder.append((CharSequence) " | ");
            }
            if (!TextUtils.isEmpty(this.e)) {
                int length2 = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) str2);
                spannableStringBuilder.setSpan(new ClickableSpan(this, str2) { // from class: com.kwad.components.core.widget.ComplianceTextView.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;
                    public final /* synthetic */ ComplianceTextView b;

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
                        this.b = this;
                        this.a = str2;
                    }

                    @Override // android.text.style.ClickableSpan
                    public final void onClick(@NonNull View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            AdWebViewActivityProxy.launch(this.b.getContext(), new AdWebViewActivityProxy.a.C0514a().a(this.a).b(this.b.e).a(this.b.h).a());
                        }
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public final void updateDrawState(@NonNull TextPaint textPaint) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                            super.updateDrawState(textPaint);
                            textPaint.setColor(this.b.i);
                            textPaint.setUnderlineText(this.b.j);
                        }
                    }
                }, length2, spannableStringBuilder.length(), 33);
            }
            spannableStringBuilder.append((CharSequence) " ");
            setMovementMethod(LinkMovementMethod.getInstance());
            setHighlightColor(ContextCompat.getColor(getContext(), R.color.obfuscated_res_0x7f060765));
            setText(spannableStringBuilder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, this, str, str2, str3) == null) {
            if (TextUtils.isEmpty(str)) {
                setVisibility(8);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            if (!TextUtils.isEmpty(this.d) || !TextUtils.isEmpty(this.e)) {
                sb2.append("   ");
            }
            if (!TextUtils.isEmpty(this.d)) {
                sb2.append(str2);
            }
            if (!TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(this.e)) {
                sb2.append(" | ");
            }
            if (!TextUtils.isEmpty(this.e)) {
                sb2.append(str3);
            }
            int width = ((!ae.e(getContext()) ? this.f : getWidth()) - getPaddingLeft()) - getPaddingRight();
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
            this.g = sb.toString();
            a(str2, str3);
            requestLayout();
        }
    }

    private boolean a(String str, String str2, int i) {
        InterceptResult invokeLLI;
        StaticLayout staticLayout;
        StaticLayout staticLayout2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, this, str, str2, i)) == null) {
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

    public void setAdTemplate(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adTemplate) == null) {
            this.h = adTemplate;
            AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(i.adBaseInfo.appName)) {
                sb.append("应用名：");
                sb.append(i.adBaseInfo.appName);
                sb.append("；");
            }
            if (!TextUtils.isEmpty(i.adBaseInfo.appVersion)) {
                sb.append("版本号：");
                sb.append(i.adBaseInfo.appVersion);
                sb.append("；");
            }
            if (i.adBaseInfo.packageSize > 0) {
                sb.append("应用大小：");
                sb.append(h.a(i.adBaseInfo.packageSize, true));
                sb.append("；");
            }
            if (!TextUtils.isEmpty(i.adBaseInfo.corporationName)) {
                sb.append("开发者：");
                sb.append(i.adBaseInfo.corporationName);
                sb.append("；");
            }
            this.a = sb.toString();
            this.b = "权限信息";
            this.c = "隐私政策";
            AdInfo.DownloadSafeInfo downloadSafeInfo = i.downloadSafeInfo;
            this.d = downloadSafeInfo.appPermissionInfoUrl;
            this.e = downloadSafeInfo.appPrivacyUrl;
            if (this.f > 0) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                layoutParams.width = !ae.e(getContext()) ? com.kwad.sdk.b.kwai.a.a(getContext(), this.f) : -1;
                setLayoutParams(layoutParams);
            }
            post(new Runnable(this) { // from class: com.kwad.components.core.widget.ComplianceTextView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ComplianceTextView a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ComplianceTextView complianceTextView = this.a;
                        complianceTextView.a(complianceTextView.a, this.a.b, this.a.c);
                    }
                }
            });
        }
    }
}
