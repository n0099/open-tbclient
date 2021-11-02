package io.flutter.plugin.common;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class FlutterException extends RuntimeException {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FlutterException#";
    public transient /* synthetic */ FieldHolder $fh;
    public final String code;
    public final Object details;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlutterException(String str, String str2, Object obj) {
        super(str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.code = str;
        this.details = obj;
    }
}
