package com.repackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes5.dex */
public class e46 extends p15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e46() {
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
        t();
    }

    @Override // com.repackage.p15
    public String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            int intValue = (i < 0 || i >= o15.b.size()) ? 0 : o15.b.get(i).intValue();
            for (Map.Entry<String, Integer> entry : o15.c.entrySet()) {
                if (entry.getValue().intValue() == intValue) {
                    return entry.getKey();
                }
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    @Override // com.repackage.p15
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? o15.b.size() : invokeV.intValue;
    }

    @Override // com.repackage.p15
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "_local" : (String) invokeV.objValue;
    }

    @Override // com.repackage.p15
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "_local" : (String) invokeV.objValue;
    }

    @Override // com.repackage.p15
    public EmotionGroupType h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? EmotionGroupType.LOCAL : (EmotionGroupType) invokeV.objValue;
    }

    @Override // com.repackage.p15
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.p15
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.p15
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.p15
    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? o15.c.get(str) != null : invokeL.booleanValue;
    }

    @Override // com.repackage.p15
    public co n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? o(str) : (co) invokeL.objValue;
    }

    @Override // com.repackage.p15
    public co o(String str) {
        InterceptResult invokeL;
        Bitmap e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            Integer num = o15.c.get(str);
            if (num == null || (e = ei.d().e(TbadkCoreApplication.getInst().getApp(), num.intValue())) == null) {
                return null;
            }
            return new co(e, false, str);
        }
        return (co) invokeL.objValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.p(7);
            super.s(3);
            co coVar = new co(BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getApp().getResources(), R.drawable.obfuscated_res_0x7f0806ea), false);
            super.r(coVar);
            super.q(coVar);
        }
    }
}
