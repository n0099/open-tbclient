package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetCardByCategory.ThemeCardInMain;
import tbclient.ThemeCardPropMain;
/* loaded from: classes5.dex */
public class dn8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public ArrayList<gm8> b;

    public dn8() {
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

    public ArrayList<gm8> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (ArrayList) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public void c(ThemeCardInMain themeCardInMain) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, themeCardInMain) == null) || themeCardInMain == null) {
            return;
        }
        this.a = themeCardInMain.card_category;
        List<ThemeCardPropMain> list = themeCardInMain.props;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.b = new ArrayList<>();
        for (ThemeCardPropMain themeCardPropMain : list) {
            if (themeCardPropMain != null) {
                gm8 gm8Var = new gm8();
                gm8Var.k(themeCardPropMain);
                this.b.add(gm8Var);
            }
        }
    }
}
