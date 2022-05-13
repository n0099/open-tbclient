package com.repackage;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public interface h31 {
    public static final h31 a = new a();

    /* loaded from: classes6.dex */
    public static class a implements h31 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.repackage.h31
        public boolean a(Context context, String str, String str2, @Nullable ci0 ci0Var) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, str, str2, ci0Var)) == null) {
                if (str != null) {
                    if (str.startsWith(yh0.f) || str.startsWith("nadcorevendor://")) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(TiebaStatic.Params.REFER, str2);
                        hashMap.put("from_web_view", Boolean.TRUE);
                        th0.e(str, context, hashMap, ci0Var);
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return invokeLLLL.booleanValue;
        }
    }

    @Autowired
    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @NonNull
        @Inject(force = false)
        public static h31 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? h31.a : (h31) invokeV.objValue;
        }
    }

    boolean a(Context context, String str, String str2, @Nullable ci0 ci0Var);
}
