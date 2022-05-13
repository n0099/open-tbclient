package com.repackage;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.storage.swankv.AshmemFileDescriptor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class j93 extends ProviderDelegation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public j93() {
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

    @Nullable
    public static AshmemFileDescriptor b(@NonNull String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("name", str);
            bundle.putInt("size", i);
            jx2 c = hx2.c(j93.class, bundle);
            if (c.a()) {
                c.a.setClassLoader(AshmemFileDescriptor.class.getClassLoader());
                return (AshmemFileDescriptor) c.a.getParcelable("result");
            }
            return null;
        }
        return (AshmemFileDescriptor) invokeLI.objValue;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            String string = bundle.getString("name", null);
            int i = bundle.getInt("size", 0);
            Bundle bundle2 = new Bundle();
            bundle2.setClassLoader(AshmemFileDescriptor.class.getClassLoader());
            bundle2.putParcelable("result", o93.a(string, i));
            return bundle2;
        }
        return (Bundle) invokeL.objValue;
    }
}
