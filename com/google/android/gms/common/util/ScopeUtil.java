package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Set;
@KeepForSdk
/* loaded from: classes7.dex */
public final class ScopeUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ScopeUtil() {
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

    @NonNull
    @KeepForSdk
    public static String[] toScopeString(@NonNull Set<Scope> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, set)) == null) {
            Preconditions.checkNotNull(set, "scopes can't be null.");
            Scope[] scopeArr = (Scope[]) set.toArray(new Scope[set.size()]);
            Preconditions.checkNotNull(scopeArr, "scopes can't be null.");
            String[] strArr = new String[scopeArr.length];
            for (int i = 0; i < scopeArr.length; i++) {
                strArr[i] = scopeArr[i].getScopeUri();
            }
            return strArr;
        }
        return (String[]) invokeL.objValue;
    }
}
