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
/* loaded from: classes5.dex */
public class bj1 implements k64 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<String> a;

    public bj1() {
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
        if (!qj2.c0().a()) {
            this.a.put(35, "add to launch");
        }
        if (qj2.n().a().equals("vivobrowser")) {
            this.a.put(4, "share");
        }
    }

    @Override // com.repackage.k64
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.k64
    public void b(Activity activity, p64 p64Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, p64Var) == null) {
        }
    }

    @Override // com.repackage.k64
    public void c(int i, List<p64> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, list) == null) {
        }
    }

    @Override // com.repackage.k64
    public void d(int i, List<p64> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, list) == null) {
        }
    }

    @Override // com.repackage.k64
    public void e(int i, List<p64> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, list) == null) {
            l(i, list);
        }
    }

    @Override // com.repackage.k64
    public void g(Activity activity, p64 p64Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, activity, p64Var) == null) {
        }
    }

    @Override // com.repackage.k64
    public void h(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, jSONObject) == null) {
        }
    }

    @Override // com.repackage.k64
    public boolean j(p64 p64Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, p64Var)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void l(int i, List<p64> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, list) == null) || de3.G() || list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (p64 p64Var : list) {
            if (this.a.get(p64Var.c()) != null) {
                arrayList.add(p64Var);
            }
        }
        if (arrayList.size() > 0) {
            list.removeAll(arrayList);
        }
    }
}
