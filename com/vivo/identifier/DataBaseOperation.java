package com.vivo.identifier;

import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes8.dex */
public class DataBaseOperation {
    public static /* synthetic */ Interceptable $ic = null;
    @Keep
    public static final String AAID_FLAG = "AAID";
    @Keep
    public static final String ID_VALUE = "value";
    @Keep
    public static final String OAIDSTATUS_FLAG = "OAIDSTATUS";
    @Keep
    public static final String OAID_FLAG = "OAID";
    @Keep
    public static final String TAG = "VMS_SDK_DB";
    @Keep
    public static final int TYPE_AAID = 2;
    @Keep
    public static final int TYPE_OAID = 0;
    @Keep
    public static final int TYPE_OAIDSTATUS = 4;
    @Keep
    public static final int TYPE_VAID = 1;
    @Keep
    public static final String URI_BASE = "content://com.vivo.vms.IdProvider/IdentifierId";
    @Keep
    public static final String VAID_FLAG = "VAID";
    public transient /* synthetic */ FieldHolder $fh;
    @Keep
    public Context mContext;

    public DataBaseOperation(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
    }

    @Keep
    public native String query(int i, String str);
}
