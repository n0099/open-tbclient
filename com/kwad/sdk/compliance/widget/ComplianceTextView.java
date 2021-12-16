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
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f57725b;

    /* renamed from: c  reason: collision with root package name */
    public String f57726c;

    /* renamed from: d  reason: collision with root package name */
    public String f57727d;

    /* renamed from: e  reason: collision with root package name */
    public String f57728e;

    /* renamed from: f  reason: collision with root package name */
    public int f57729f;

    /* renamed from: g  reason: collision with root package name */
    public String f57730g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f57731h;
    @ColorInt

    /* renamed from: i  reason: collision with root package name */
    public int f57732i;

    /* renamed from: j  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f57733j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ComplianceTextView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComplianceTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f57729f = Opcodes.IFNE;
        this.f57733j = new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.kwad.sdk.compliance.widget.ComplianceTextView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ComplianceTextView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.getWidth() <= 0) {
                    return;
                }
                ComplianceTextView complianceTextView = this.a;
                complianceTextView.a(complianceTextView.a, this.a.f57725b, this.a.f57726c);
                this.a.a();
            }
        };
        a(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || this.f57733j == null) {
            return;
        }
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f57733j);
        this.f57733j = null;
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_ComplianceTextView);
            this.f57729f = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ksad_ComplianceTextView_ksad_width_in_landscape, Opcodes.IFNE);
            this.f57732i = obtainStyledAttributes.getColor(R.styleable.ksad_ComplianceTextView_ksad_privacy_color, getResources().getColor(R.color.ksad_default_privacy_link_color));
            if (getBackground() == null) {
                setBackground(ContextCompat.getDrawable(context, R.drawable.ksad_compliance_view_bg));
            }
            getViewTreeObserver().addOnGlobalLayoutListener(this.f57733j);
            obtainStyledAttributes.recycle();
        }
    }

    private void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, str, str2) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.f57730g);
            if (!TextUtils.isEmpty(this.f57727d)) {
                int length = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) str);
                spannableStringBuilder.setSpan(new ClickableSpan(this, str) { // from class: com.kwad.sdk.compliance.widget.ComplianceTextView.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ ComplianceTextView f57734b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f57734b = this;
                        this.a = str;
                    }

                    @Override // android.text.style.ClickableSpan
                    public void onClick(@NonNull View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            AdWebViewActivityProxy.launch(this.f57734b.getContext(), new AdWebViewActivityProxy.a.C2083a().a(this.a).b(this.f57734b.f57727d).a(this.f57734b.f57731h).a());
                        }
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(@NonNull TextPaint textPaint) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                            super.updateDrawState(textPaint);
                            textPaint.setColor(this.f57734b.f57732i);
                            textPaint.setUnderlineText(true);
                        }
                    }
                }, length, spannableStringBuilder.length(), 33);
            }
            if (!TextUtils.isEmpty(this.f57727d) && !TextUtils.isEmpty(this.f57728e)) {
                spannableStringBuilder.append((CharSequence) " | ");
            }
            if (!TextUtils.isEmpty(this.f57728e)) {
                int length2 = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) str2);
                spannableStringBuilder.setSpan(new ClickableSpan(this, str2) { // from class: com.kwad.sdk.compliance.widget.ComplianceTextView.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ ComplianceTextView f57735b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f57735b = this;
                        this.a = str2;
                    }

                    @Override // android.text.style.ClickableSpan
                    public void onClick(@NonNull View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            AdWebViewActivityProxy.launch(this.f57735b.getContext(), new AdWebViewActivityProxy.a.C2083a().a(this.a).b(this.f57735b.f57728e).a(this.f57735b.f57731h).a());
                        }
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(@NonNull TextPaint textPaint) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                            super.updateDrawState(textPaint);
                            textPaint.setColor(this.f57735b.f57732i);
                            textPaint.setUnderlineText(true);
                        }
                    }
                }, length2, spannableStringBuilder.length(), 33);
            }
            setMovementMethod(LinkMovementMethod.getInstance());
            setHighlightColor(ContextCompat.getColor(getContext(), R.color.ksad_translucent));
            setText(spannableStringBuilder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, this, str, str2, str3) == null) {
            if (TextUtils.isEmpty(str)) {
                setVisibility(8);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            if (!TextUtils.isEmpty(this.f57727d) || !TextUtils.isEmpty(this.f57728e)) {
                sb2.append("   ");
            }
            if (!TextUtils.isEmpty(this.f57727d)) {
                sb2.append(str2);
            }
            if (!TextUtils.isEmpty(this.f57727d) && !TextUtils.isEmpty(this.f57728e)) {
                sb2.append(" | ");
            }
            if (!TextUtils.isEmpty(this.f57728e)) {
                sb2.append(str3);
            }
            int width = ((!af.e(getContext()) ? this.f57729f : getWidth()) - getPaddingLeft()) - getPaddingRight();
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
            this.f57730g = sb.toString();
            a(str2, str3);
        }
    }

    private boolean a(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        StaticLayout staticLayout;
        StaticLayout staticLayout2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65545, this, str, str2, i2)) == null) {
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
        return invokeLLI.booleanValue;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onDetachedFromWindow();
            a();
        }
    }

    public void setAdTemplate(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            this.f57731h = adTemplate;
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
            this.f57725b = "权限信息";
            this.f57726c = "隐私政策";
            AdInfo.DownloadSafeInfo downloadSafeInfo = j2.downloadSafeInfo;
            this.f57727d = downloadSafeInfo.appPermissionInfoUrl;
            this.f57728e = downloadSafeInfo.appPrivacyUrl;
            if (!af.e(getContext())) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                layoutParams.width = bb.a(getContext(), this.f57729f);
                setLayoutParams(layoutParams);
            }
            a(this.a, this.f57725b, this.f57726c);
        }
    }
}
