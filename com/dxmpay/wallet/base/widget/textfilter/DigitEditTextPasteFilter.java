package com.dxmpay.wallet.base.widget.textfilter;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class DigitEditTextPasteFilter implements IEditTextPasteFilter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1443961113, "Lcom/dxmpay/wallet/base/widget/textfilter/DigitEditTextPasteFilter;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1443961113, "Lcom/dxmpay/wallet/base/widget/textfilter/DigitEditTextPasteFilter;");
        }
    }

    public DigitEditTextPasteFilter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.dxmpay.wallet.base.widget.textfilter.IEditTextPasteFilter
    public String intercept(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            List<String> regxParse = EditTextPasteFilterUtils.regxParse(str, "[1-9]\\d*[\\.]{0,1}\\d*|0\\.\\d*|\\.\\d*");
            return (regxParse == null || regxParse.size() <= 0) ? "" : regxParse.get(0);
        }
        return (String) invokeL.objValue;
    }
}
