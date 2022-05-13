package com.repackage;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class by8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<String> a;
    public String b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public boolean h;
    public boolean i;

    public by8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = -1;
        this.h = false;
        this.i = false;
    }

    public ArrayList<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (ArrayList) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.g : invokeV.intValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.h : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.i : invokeV.booleanValue;
    }

    public SpannableStringBuilder f(Editable editable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, editable)) == null) {
            if (editable == null || StringUtils.isNull(editable.toString()) || ListUtils.isEmpty(this.a)) {
                return null;
            }
            String obj = editable.toString();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
            boolean z = this.g >= 0;
            this.g = -1;
            Iterator<String> it = this.a.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    m(spannableStringBuilder, obj, next);
                }
            }
            if (this.g >= 0 || z) {
                ImageSpan[] imageSpanArr = (ImageSpan[]) editable.getSpans(0, obj.length(), ImageSpan.class);
                if (imageSpanArr != null) {
                    for (ImageSpan imageSpan : imageSpanArr) {
                        if (imageSpan != null) {
                            spannableStringBuilder.setSpan(imageSpan, editable.getSpanStart(imageSpan), editable.getSpanEnd(imageSpan), editable.getSpanFlags(imageSpan));
                        }
                    }
                }
                return spannableStringBuilder;
            }
            return null;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int i = this.c;
            if (i != 0) {
                this.e = SkinManager.getColor(i);
            }
            int i2 = this.d;
            if (i2 != 0) {
                this.f = SkinManager.getColor(i2);
            }
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.d = i;
            this.f = SkinManager.getColor(i);
        }
    }

    public void i(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) {
            this.a = arrayList;
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.c = i;
            this.e = SkinManager.getColor(i);
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.h = z;
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.i = z;
        }
    }

    public final void m(SpannableStringBuilder spannableStringBuilder, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048588, this, spannableStringBuilder, str, str2) == null) || spannableStringBuilder == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.e == 0 && this.f == 0) {
            return;
        }
        int indexOf = str.indexOf(str2);
        int length = str2.length();
        if (indexOf >= 0) {
            int i = this.g;
            if (i == -1) {
                this.g = indexOf + length;
            } else {
                int i2 = indexOf + length;
                if (i2 < i) {
                    this.g = i2;
                }
            }
        }
        while (indexOf >= 0) {
            if (this.e != 0) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.e), indexOf, indexOf + length, 33);
            }
            if (this.f != 0) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f), indexOf, indexOf + length, 33);
            }
            indexOf = str.indexOf(str2, indexOf + 1);
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.b = str;
        }
    }
}
