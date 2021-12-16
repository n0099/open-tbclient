package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiOptions;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class RestorationChannel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "RestorationChannel";
    public transient /* synthetic */ FieldHolder $fh;
    public MethodChannel channel;
    public boolean engineHasProvidedData;
    public boolean frameworkHasRequestedData;
    public final MethodChannel.MethodCallHandler handler;
    public MethodChannel.Result pendingFrameworkRestorationChannelRequest;
    public byte[] restorationData;
    public final boolean waitForRestorationData;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RestorationChannel(@NonNull DartExecutor dartExecutor, @NonNull boolean z) {
        this(new MethodChannel(dartExecutor, "flutter/restoration", StandardMethodCodec.INSTANCE), z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dartExecutor, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((MethodChannel) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> packageData(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, bArr)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(SapiOptions.KEY_CACHE_ENABLED, Boolean.TRUE);
            hashMap.put("data", bArr);
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public void clearData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.restorationData = null;
        }
    }

    public byte[] getRestorationData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.restorationData : (byte[]) invokeV.objValue;
    }

    public void setRestorationData(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr) == null) {
            this.engineHasProvidedData = true;
            MethodChannel.Result result = this.pendingFrameworkRestorationChannelRequest;
            if (result != null) {
                result.success(packageData(bArr));
                this.pendingFrameworkRestorationChannelRequest = null;
                this.restorationData = bArr;
            } else if (this.frameworkHasRequestedData) {
                this.channel.invokeMethod("push", packageData(bArr), new MethodChannel.Result(this, bArr) { // from class: io.flutter.embedding.engine.systemchannels.RestorationChannel.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ RestorationChannel this$0;
                    public final /* synthetic */ byte[] val$data;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, bArr};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$data = bArr;
                    }

                    @Override // io.flutter.plugin.common.MethodChannel.Result
                    public void error(String str, String str2, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, str, str2, obj) == null) {
                            Log.e(RestorationChannel.TAG, "Error " + str + " while sending restoration data to framework: " + str2);
                        }
                    }

                    @Override // io.flutter.plugin.common.MethodChannel.Result
                    public void notImplemented() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        }
                    }

                    @Override // io.flutter.plugin.common.MethodChannel.Result
                    public void success(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                            this.this$0.restorationData = this.val$data;
                        }
                    }
                });
            } else {
                this.restorationData = bArr;
            }
        }
    }

    public RestorationChannel(MethodChannel methodChannel, @NonNull boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {methodChannel, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.engineHasProvidedData = false;
        this.frameworkHasRequestedData = false;
        MethodChannel.MethodCallHandler methodCallHandler = new MethodChannel.MethodCallHandler(this) { // from class: io.flutter.embedding.engine.systemchannels.RestorationChannel.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RestorationChannel this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                char c2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, methodCall, result) == null) {
                    String str = methodCall.method;
                    Object obj = methodCall.arguments;
                    int hashCode = str.hashCode();
                    if (hashCode != 102230) {
                        if (hashCode == 111375 && str.equals("put")) {
                            c2 = 0;
                        }
                        c2 = 65535;
                    } else {
                        if (str.equals("get")) {
                            c2 = 1;
                        }
                        c2 = 65535;
                    }
                    if (c2 == 0) {
                        this.this$0.restorationData = (byte[]) obj;
                        result.success(null);
                    } else if (c2 == 1) {
                        this.this$0.frameworkHasRequestedData = true;
                        if (!this.this$0.engineHasProvidedData) {
                            RestorationChannel restorationChannel = this.this$0;
                            if (restorationChannel.waitForRestorationData) {
                                restorationChannel.pendingFrameworkRestorationChannelRequest = result;
                                return;
                            }
                        }
                        RestorationChannel restorationChannel2 = this.this$0;
                        result.success(restorationChannel2.packageData(restorationChannel2.restorationData));
                    } else {
                        result.notImplemented();
                    }
                }
            }
        };
        this.handler = methodCallHandler;
        this.channel = methodChannel;
        this.waitForRestorationData = z;
        methodChannel.setMethodCallHandler(methodCallHandler);
    }
}
