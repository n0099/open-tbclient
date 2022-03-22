package com.yy.gslbsdk.device;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.util.LogTools;
import java.util.Locale;
/* loaded from: classes7.dex */
public class NetStatusReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "NetStatusReceiver";
    public transient /* synthetic */ FieldHolder $fh;
    public ChangeNetworkInter mChangeNetworkInter;
    public BroadcastReceiver mNetReceiver;
    public boolean mRegistered;

    /* loaded from: classes7.dex */
    public interface ChangeNetworkInter {
        void onNetStateChanged();
    }

    public NetStatusReceiver(ChangeNetworkInter changeNetworkInter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {changeNetworkInter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRegistered = false;
        this.mChangeNetworkInter = null;
        this.mNetReceiver = new BroadcastReceiver(this) { // from class: com.yy.gslbsdk.device.NetStatusReceiver.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NetStatusReceiver this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, context, intent) == null) && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") && this.this$0.mRegistered && this.this$0.mChangeNetworkInter != null) {
                    this.this$0.mChangeNetworkInter.onNetStateChanged();
                }
            }
        };
        this.mChangeNetworkInter = changeNetworkInter;
    }

    public void register(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || context == null || this.mRegistered) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            context.registerReceiver(this.mNetReceiver, intentFilter);
            this.mRegistered = true;
        } catch (Exception e2) {
            LogTools.printWarning(TAG, String.format(Locale.US, "register net receiver failed! error: %s", e2.getMessage()));
        }
    }

    public void unregister(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) && context != null && this.mRegistered) {
            context.unregisterReceiver(this.mNetReceiver);
            this.mRegistered = false;
        }
    }
}
