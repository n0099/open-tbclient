package com.repackage;

import android.text.TextUtils;
import androidx.collection.ArraySet;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dj2;
/* loaded from: classes6.dex */
public class j92 implements g92 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String[] a;

    public j92() {
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
        this.a = new String[]{p73.w(), p73.y(), m42.c()};
    }

    @Override // com.repackage.g92
    public ArraySet<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArraySet<String> arraySet = new ArraySet<>();
            for (String str : this.a) {
                String K = jg4.K(str);
                if (!TextUtils.isEmpty(K)) {
                    arraySet.add(K);
                }
            }
            if (rg1.a) {
                b(arraySet);
            }
            hx1.k("SwanSdcardFileCollector", "recovery renameAllFiles:" + arraySet.toString());
            return arraySet;
        }
        return (ArraySet) invokeV.objValue;
    }

    public final void b(ArraySet<String> arraySet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arraySet) == null) || arraySet == null) {
            return;
        }
        String[] strArr = {ya2.b().getAbsolutePath(), o93.c().getAbsolutePath(), dj2.b.d(), wc3.b(), gj2.k(), eu2.b()};
        for (int i = 0; i < 6; i++) {
            String K = jg4.K(strArr[i]);
            if (!TextUtils.isEmpty(K)) {
                arraySet.add(K);
            }
        }
    }
}
