package com.kwad.components.ad.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.widget.e;
import com.kwad.components.core.widget.f;
import com.kwad.sdk.core.d.b;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes5.dex */
public class KsPriceView extends TextView implements e {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "¥%s 到手约 ¥%s";
    public static String c = "¥%s  ¥%s";
    public static String d = "¥%s";
    public transient /* synthetic */ FieldHolder $fh;
    public a a;
    public String e;
    public String f;
    public boolean g;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : invokeV.intValue;
        }

        public final a a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                this.b = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : invokeV.intValue;
        }

        public final a b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                this.e = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.d : invokeV.intValue;
        }

        public final a c(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                this.f = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f : invokeV.intValue;
        }

        public final int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : invokeV.intValue;
        }

        public final int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.b : invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1470673223, "Lcom/kwad/components/ad/widget/KsPriceView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1470673223, "Lcom/kwad/components/ad/widget/KsPriceView;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsPriceView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new a();
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsPriceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = new a();
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsPriceView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = new a();
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @RequiresApi(api = 21)
    public KsPriceView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.a = new a();
        a(context);
    }

    @Nullable
    public static SpannableString a(String str, @Nullable String str2, boolean z, a aVar) {
        InterceptResult invokeCommon;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{str, str2, Boolean.valueOf(z), aVar})) == null) {
            if (str2 == null) {
                format = String.format(d, str);
            } else {
                format = String.format(z ? c : b, str, str2);
            }
            SpannableString spannableString = new SpannableString(format);
            if (format.startsWith("¥")) {
                spannableString.setSpan(new ForegroundColorSpan(aVar.e()), 0, 1, 17);
                spannableString.setSpan(new AbsoluteSizeSpan(aVar.f()), 0, 1, 17);
            }
            int indexOf = format.indexOf(str);
            if (indexOf < 0) {
                return null;
            }
            int length = str.length() + indexOf;
            spannableString.setSpan(new ForegroundColorSpan(aVar.a()), indexOf, length, 18);
            spannableString.setSpan(new AbsoluteSizeSpan(aVar.c()), indexOf, length, 18);
            if (str2 != null) {
                int lastIndexOf = format.lastIndexOf(str2) - 1;
                int length2 = str2.length() + 1 + lastIndexOf;
                spannableString.setSpan(new ForegroundColorSpan(aVar.b()), lastIndexOf, length2, 18);
                spannableString.setSpan(new AbsoluteSizeSpan(aVar.d()), lastIndexOf, length2, 18);
                spannableString.setSpan(new StrikethroughSpan(), lastIndexOf, length2, 18);
            }
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, context) == null) {
            setMaxLines(1);
            this.a.c = context.getResources().getColor(R.color.obfuscated_res_0x7f06075f);
            this.a.d = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703e2);
            this.a.e = context.getResources().getColor(R.color.obfuscated_res_0x7f060760);
            this.a.f = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703e1);
            this.a.a = context.getResources().getColor(R.color.obfuscated_res_0x7f06075f);
            this.a.b = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703e2);
        }
    }

    @Override // com.kwad.components.core.widget.e
    public final void a(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            this.a.c = fVar.a();
            a(this.e, this.f, this.g);
        }
    }

    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            a(str, str2, false);
        }
    }

    public final void a(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, str, str2, z) == null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return;
            }
            this.e = str;
            this.f = str2;
            this.g = z;
            SpannableString spannableString = null;
            if (TextUtils.isEmpty(str2)) {
                this.f = null;
            }
            if (str != null && str.startsWith("¥")) {
                str = str.replaceFirst("¥", "");
            }
            setTextColor(this.a.a());
            try {
                spannableString = a(str, this.f, z, this.a);
            } catch (Exception e) {
                b.b(e);
            }
            if (spannableString != null) {
                setText(spannableString);
            }
        }
    }

    @NonNull
    public a getConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (a) invokeV.objValue;
    }
}
