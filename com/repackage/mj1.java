package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class mj1 implements v64 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<String> a;

    public mj1() {
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
        SparseArray<String> sparseArray = new SparseArray<>();
        this.a = sparseArray;
        sparseArray.put(38, DI.BD.FAVOR);
        if (!bk2.c0().a()) {
            this.a.put(35, "add to launch");
        }
        if (bk2.n().a().equals("vivobrowser")) {
            this.a.put(4, "share");
        }
    }

    @Override // com.repackage.v64
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.v64
    public void b(Activity activity, a74 a74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, a74Var) == null) {
        }
    }

    @Override // com.repackage.v64
    public void c(int i, List<a74> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, list) == null) {
        }
    }

    @Override // com.repackage.v64
    public void d(int i, List<a74> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, list) == null) {
        }
    }

    @Override // com.repackage.v64
    public void e(int i, List<a74> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, list) == null) {
            l(i, list);
        }
    }

    @Override // com.repackage.v64
    public void g(Activity activity, a74 a74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, activity, a74Var) == null) {
        }
    }

    @Override // com.repackage.v64
    public void h(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, jSONObject) == null) {
        }
    }

    @Override // com.repackage.v64
    public boolean j(a74 a74Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, a74Var)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void l(int i, List<a74> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, list) == null) || oe3.G() || list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (a74 a74Var : list) {
            if (this.a.get(a74Var.c()) != null) {
                arrayList.add(a74Var);
            }
        }
        if (arrayList.size() > 0) {
            list.removeAll(arrayList);
        }
    }
}
