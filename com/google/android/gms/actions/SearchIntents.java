package com.google.android.gms.actions;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class SearchIntents {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_SEARCH = "com.google.android.gms.actions.SEARCH_ACTION";
    public static final String EXTRA_QUERY = "query";
    public transient /* synthetic */ FieldHolder $fh;

    public SearchIntents() {
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
}
