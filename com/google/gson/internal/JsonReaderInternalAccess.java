package com.google.gson.internal;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
/* loaded from: classes11.dex */
public abstract class JsonReaderInternalAccess {
    public static /* synthetic */ Interceptable $ic;
    public static JsonReaderInternalAccess INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    public JsonReaderInternalAccess() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public abstract void promoteNameToValue(JsonReader jsonReader) throws IOException;
}
