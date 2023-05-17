package com.vivo.identifier;

import android.database.ContentObserver;
import android.os.Handler;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes10.dex */
public class IdentifierIdObserver extends ContentObserver {
    public static /* synthetic */ Interceptable $ic = null;
    @Keep
    public static final String TAG = "VMS_SDK_Observer";
    public transient /* synthetic */ FieldHolder $fh;
    @Keep
    public String mAppId;
    @Keep
    public IdentifierIdClient mIdentifierIdClient;
    @Keep
    public int mType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IdentifierIdObserver(IdentifierIdClient identifierIdClient, int i, String str) {
        super(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {identifierIdClient, Integer.valueOf(i), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Handler) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIdentifierIdClient = identifierIdClient;
        this.mType = i;
        this.mAppId = str;
    }

    @Override // android.database.ContentObserver
    @Keep
    public native void onChange(boolean z);
}
