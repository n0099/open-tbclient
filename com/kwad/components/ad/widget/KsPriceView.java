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
import com.kwad.sdk.core.e.b;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes7.dex */
public class KsPriceView extends TextView implements e {
    public static /* synthetic */ Interceptable $ic = null;
    public static String Cw = "¥%s 到手约 ¥%s";
    public static String Cx = "¥%s  ¥%s";
    public static String Cy = "¥%s";
    public transient /* synthetic */ FieldHolder $fh;
    public String CA;
    public boolean CB;
    public a Cv;
    public String Cz;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int CC;
        public int CD;
        public int CE;
        public int CF;
        public int CG;
        public int CH;

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

        public final a ab(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                this.CD = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a ac(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                this.CG = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final a ad(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.CH = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public final int kX() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.CE : invokeV.intValue;
        }

        public final int kY() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.CG : invokeV.intValue;
        }

        public final int kZ() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.CF : invokeV.intValue;
        }

        public final int la() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.CH : invokeV.intValue;
        }

        public final int lb() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.CC : invokeV.intValue;
        }

        public final int lc() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.CD : invokeV.intValue;
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
        this.Cv = new a();
        L(context);
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
        this.Cv = new a();
        L(context);
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
        this.Cv = new a();
        L(context);
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
        this.Cv = new a();
        L(context);
    }

    private void L(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, context) == null) {
            setMaxLines(1);
            this.Cv.CE = context.getResources().getColor(R.color.obfuscated_res_0x7f060783);
            this.Cv.CF = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703e0);
            this.Cv.CG = context.getResources().getColor(R.color.obfuscated_res_0x7f060784);
            this.Cv.CH = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703df);
            this.Cv.CC = context.getResources().getColor(R.color.obfuscated_res_0x7f060783);
            this.Cv.CD = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703e0);
        }
    }

    @Nullable
    public static SpannableString a(String str, @Nullable String str2, boolean z, a aVar) {
        InterceptResult invokeCommon;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{str, str2, Boolean.valueOf(z), aVar})) == null) {
            if (str2 == null) {
                format = String.format(Cy, str);
            } else {
                format = String.format(z ? Cx : Cw, str, str2);
            }
            SpannableString spannableString = new SpannableString(format);
            if (format.startsWith("¥")) {
                spannableString.setSpan(new ForegroundColorSpan(aVar.lb()), 0, 1, 17);
                spannableString.setSpan(new AbsoluteSizeSpan(aVar.lc()), 0, 1, 17);
            }
            int indexOf = format.indexOf(str);
            if (indexOf < 0) {
                return null;
            }
            int length = str.length() + indexOf;
            spannableString.setSpan(new ForegroundColorSpan(aVar.kX()), indexOf, length, 18);
            spannableString.setSpan(new AbsoluteSizeSpan(aVar.kZ()), indexOf, length, 18);
            if (str2 != null) {
                int lastIndexOf = format.lastIndexOf(str2) - 1;
                int length2 = str2.length() + 1 + lastIndexOf;
                spannableString.setSpan(new ForegroundColorSpan(aVar.kY()), lastIndexOf, length2, 18);
                spannableString.setSpan(new AbsoluteSizeSpan(aVar.la()), lastIndexOf, length2, 18);
                spannableString.setSpan(new StrikethroughSpan(), lastIndexOf, length2, 18);
            }
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    @Override // com.kwad.components.core.widget.e
    public final void a(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            this.Cv.CE = fVar.qh();
            d(this.Cz, this.CA, this.CB);
        }
    }

    public final void d(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, z) == null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return;
            }
            this.Cz = str;
            this.CA = str2;
            this.CB = z;
            SpannableString spannableString = null;
            if (TextUtils.isEmpty(str2)) {
                this.CA = null;
            }
            if (str != null && str.startsWith("¥")) {
                str = str.replaceFirst("¥", "");
            }
            setTextColor(this.Cv.kX());
            try {
                spannableString = a(str, this.CA, z, this.Cv);
            } catch (Exception e) {
                b.printStackTraceOnly(e);
            }
            if (spannableString != null) {
                setText(spannableString);
            }
        }
    }

    public final void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            d(str, str2, false);
        }
    }

    @NonNull
    public a getConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.Cv : (a) invokeV.objValue;
    }
}
