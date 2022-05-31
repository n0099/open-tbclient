package com.repackage;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class g14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @V8JavascriptField
    @JvmField
    public final String address;
    @V8JavascriptField
    @JvmField
    public final String family;
    @V8JavascriptField
    @JvmField
    public final int port;
    @V8JavascriptField
    @JvmField
    public final int size;

    public g14(String address, int i, int i2, String family) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {address, Integer.valueOf(i), Integer.valueOf(i2), family};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(family, "family");
        this.address = address;
        this.size = i;
        this.port = i2;
        this.family = family;
    }
}
