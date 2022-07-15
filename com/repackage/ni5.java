package com.repackage;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ni5 implements nn, qi5, bp4 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseArray<BdUniqueId> c;
    public transient /* synthetic */ FieldHolder $fh;
    public Object a;
    public int b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755468521, "Lcom/repackage/ni5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755468521, "Lcom/repackage/ni5;");
                return;
            }
        }
        c = new SparseArray<>();
    }

    public ni5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void b(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, list) == null) || c.size() > 0 || list == null) {
            return;
        }
        for (Integer num : list) {
            c.put(num.intValue(), BdUniqueId.gen());
        }
    }

    public static List<BdUniqueId> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < c.size(); i++) {
                arrayList.add(c.valueAt(i));
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public static int g(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        int indexOfValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bdUniqueId)) == null) {
            if (c.size() == 0 || (indexOfValue = c.indexOfValue(bdUniqueId)) == -1 || c.size() <= indexOfValue) {
                return -1;
            }
            return c.keyAt(indexOfValue);
        }
        return invokeL.intValue;
    }

    @Override // com.repackage.qi5
    public Object a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : invokeV.intValue;
    }

    @Override // com.repackage.bp4
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.nn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? c.get(this.b) : (BdUniqueId) invokeV.objValue;
    }

    public void h(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            this.a = obj;
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.b = i;
        }
    }

    @Override // com.repackage.bp4
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (a() instanceof AdvertAppInfo) {
                return ((bp4) a()).j();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.bp4
    public AdvertAppInfo q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (a() instanceof bp4) {
                return (AdvertAppInfo) a();
            }
            return null;
        }
        return (AdvertAppInfo) invokeV.objValue;
    }

    @Override // com.repackage.bp4
    public void setPosition(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && (a() instanceof bp4)) {
            ((bp4) a()).setPosition(i);
        }
    }
}
