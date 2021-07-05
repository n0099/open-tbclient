package com.kwad.sdk.lib.widget;

import android.text.Layout;
import android.text.TextPaint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float f38530a;

    /* renamed from: b  reason: collision with root package name */
    public float f38531b;

    /* renamed from: c  reason: collision with root package name */
    public float f38532c;

    /* renamed from: d  reason: collision with root package name */
    public float f38533d;

    /* renamed from: e  reason: collision with root package name */
    public float f38534e;

    /* renamed from: com.kwad.sdk.lib.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0472a {
        CharSequence a();

        TextPaint b();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38530a = -1.0f;
        this.f38531b = 10.0f;
        this.f38532c = 1.0f;
        this.f38533d = 0.0f;
        this.f38534e = 1.0f;
    }

    public float a(CharSequence charSequence, TextPaint textPaint, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{charSequence, textPaint, Float.valueOf(f2)})) == null) {
            textPaint.setTextSize(f2);
            return Layout.getDesiredWidth(charSequence, textPaint);
        }
        return invokeCommon.floatValue;
    }
}
