package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTails.ColorInfo;
import tbclient.GetTails.ResData;
import tbclient.GetTails.TailInfo;
/* loaded from: classes6.dex */
public class kk7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<TailData> a;
    public List<String> b;

    public kk7() {
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
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    public List<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (List) invokeV.objValue;
    }

    public List<TailData> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public void c(ResData resData) {
        List<TailInfo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, resData) == null) || resData == null || (list = resData.tailList) == null) {
            return;
        }
        for (TailInfo tailInfo : list) {
            if (e(tailInfo)) {
                TailData tailData = new TailData();
                tailData.setContent(tailInfo.tailContent);
                tailData.setFontColor(tailInfo.fontColor);
                tailData.setFontType(tailInfo.fontKeyName);
                tailData.setId(tailInfo.tailId.intValue());
                tailData.setSelected(tailInfo.is_selected.intValue() == 1);
                b().add(tailData);
            }
        }
        d(resData.default_color);
        for (ColorInfo colorInfo : resData.colorList) {
            a().add(colorInfo.fontColor);
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    public final boolean e(TailInfo tailInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tailInfo)) == null) {
            Integer num = tailInfo.tailId;
            return (num == null || num.intValue() == 0 || tailInfo.fontColor == null) ? false : true;
        }
        return invokeL.booleanValue;
    }
}
