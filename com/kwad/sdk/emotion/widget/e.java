package com.kwad.sdk.emotion.widget;

import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public abstract class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<TextView> f37223a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f37224b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37225c;

    /* renamed from: d  reason: collision with root package name */
    public int f37226d;

    public e(@NonNull TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {textView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37226d = 1;
        this.f37224b = false;
        this.f37225c = true;
        this.f37223a = new WeakReference<>(textView);
    }

    public abstract void a(Editable editable);

    public abstract void a(Editable editable, TextView textView, int i2, int i3);

    public void a(CharSequence charSequence) {
        ImageSpan[] imageSpanArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, charSequence) == null) {
            String charSequence2 = charSequence.toString();
            if (charSequence instanceof Spanned) {
                Spannable spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence);
                for (ImageSpan imageSpan : (ImageSpan[]) spannableString.getSpans(0, spannableString.length(), ImageSpan.class)) {
                    int spanStart = spannableString.getSpanStart(imageSpan);
                    if (spanStart > spannableString.length() - 1 || spannableString.getSpanEnd(imageSpan) > spannableString.length() || (imageSpan.getSource() != null && charSequence2.indexOf(imageSpan.getSource(), spanStart) != spannableString.getSpanStart(imageSpan))) {
                        spannableString.removeSpan(imageSpan);
                    }
                }
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }
}
