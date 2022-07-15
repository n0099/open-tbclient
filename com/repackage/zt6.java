package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
import tbclient.Userlike.ConcernData;
/* loaded from: classes7.dex */
public class zt6 extends hq4 {
    public static /* synthetic */ Interceptable $ic;
    public static final Integer h;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean f;
    public List<MetaData> g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755100427, "Lcom/repackage/zt6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755100427, "Lcom/repackage/zt6;");
                return;
            }
        }
        h = 6;
    }

    public zt6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = new ArrayList();
    }

    public static boolean i(ConcernData concernData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, concernData)) == null) {
            if (concernData == null) {
                return false;
            }
            return concernData.recom_type.equals(h);
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.hq4
    public List<MetaData> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.g : (List) invokeV.objValue;
    }

    @Override // com.repackage.hq4
    public void d(List<User> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || list == null) {
            return;
        }
        int min = Math.min(list.size(), 10);
        for (int i = 0; i < min; i++) {
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(list.get(i));
            this.g.add(metaData);
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f : invokeV.booleanValue;
    }

    @Override // com.repackage.hq4, com.repackage.nn4
    public kp4 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new kp4() : (kp4) invokeV.objValue;
    }

    @Override // com.repackage.hq4, com.repackage.nn4
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    @Override // com.repackage.hq4, com.baidu.tieba.card.data.BaseCardInfo, com.repackage.nn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? hq4.e : (BdUniqueId) invokeV.objValue;
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f = z;
        }
    }
}
