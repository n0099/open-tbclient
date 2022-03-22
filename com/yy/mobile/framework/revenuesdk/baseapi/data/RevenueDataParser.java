package com.yy.mobile.framework.revenuesdk.baseapi.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.PSCIMessageBroadcast;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.PSCIMessageResponse;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.PSCIMessageUnicast;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.ThreadPool;
import java.util.ArrayList;
import java.util.List;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public final class RevenueDataParser implements IRevenueDataParser {
    public static final /* synthetic */ RevenueDataParser[] $VALUES;
    public static /* synthetic */ Interceptable $ic = null;
    public static final RevenueDataParser INSTANCE;
    public static final String TAG = "RevenueDataParser";
    public transient /* synthetic */ FieldHolder $fh;
    public List<IRevenueDataReceiver> revenueDataReceivers;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1469223213, "Lcom/yy/mobile/framework/revenuesdk/baseapi/data/RevenueDataParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1469223213, "Lcom/yy/mobile/framework/revenuesdk/baseapi/data/RevenueDataParser;");
                return;
            }
        }
        RevenueDataParser revenueDataParser = new RevenueDataParser("INSTANCE", 0);
        INSTANCE = revenueDataParser;
        $VALUES = new RevenueDataParser[]{revenueDataParser};
    }

    public RevenueDataParser(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.revenueDataReceivers = new ArrayList();
    }

    public static RevenueDataParser valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (RevenueDataParser) Enum.valueOf(RevenueDataParser.class, str) : (RevenueDataParser) invokeL.objValue;
    }

    public static RevenueDataParser[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (RevenueDataParser[]) $VALUES.clone() : (RevenueDataParser[]) invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataParser
    public void onRequestError(int i, int i2, String str, int i3, int i4, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), str2}) == null) {
            ThreadPool.getDefault().networkIO().execute(new Runnable(this, i, str, str2, i2, i3, i4) { // from class: com.yy.mobile.framework.revenuesdk.baseapi.data.RevenueDataParser.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RevenueDataParser this$0;
                public final /* synthetic */ int val$appId;
                public final /* synthetic */ int val$cmd;
                public final /* synthetic */ String val$message;
                public final /* synthetic */ String val$seq;
                public final /* synthetic */ int val$srvErrorCode;
                public final /* synthetic */ int val$userchannel;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i), str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i5 = newInitContext.flag;
                        if ((i5 & 1) != 0) {
                            int i6 = i5 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$appId = i;
                    this.val$seq = str;
                    this.val$message = str2;
                    this.val$userchannel = i2;
                    this.val$cmd = i3;
                    this.val$srvErrorCode = i4;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        RLog.info(RevenueDataParser.TAG, "onRequestError appId = %d, seq = %s, message = %s", Integer.valueOf(this.val$appId), this.val$seq, this.val$message);
                        for (IRevenueDataReceiver iRevenueDataReceiver : this.this$0.revenueDataReceivers) {
                            iRevenueDataReceiver.onRequestError(this.val$appId, this.val$userchannel, this.val$seq, this.val$cmd, this.val$srvErrorCode, this.val$message);
                        }
                    }
                }
            });
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataParser
    public void parserRevenueBroadcastData(RevenueBroadcastData revenueBroadcastData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, revenueBroadcastData) == null) {
            ThreadPool.getDefault().networkIO().execute(new Runnable(this, revenueBroadcastData) { // from class: com.yy.mobile.framework.revenuesdk.baseapi.data.RevenueDataParser.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RevenueDataParser this$0;
                public final /* synthetic */ RevenueBroadcastData val$broadcastData;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, revenueBroadcastData};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$broadcastData = revenueBroadcastData;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        PSCIMessageBroadcast pSCIMessageBroadcast = new PSCIMessageBroadcast(this.val$broadcastData.jsonData);
                        RLog.info(RevenueDataParser.TAG, "RevenueBroadcastData = %s", pSCIMessageBroadcast.toString());
                        RLog.info(RevenueDataParser.TAG, "RevenueBroadcastData: jsonData = %s", pSCIMessageBroadcast.getJsonData());
                        pSCIMessageBroadcast.setUri(this.val$broadcastData.cmd);
                        int optInt = pSCIMessageBroadcast.getData().optInt("app_id", 0);
                        for (IRevenueDataReceiver iRevenueDataReceiver : this.this$0.revenueDataReceivers) {
                            iRevenueDataReceiver.onBroadcastData(optInt, pSCIMessageBroadcast);
                        }
                    }
                }
            });
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataParser
    public void parserRevenueResponseData(int i, int i2, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, bArr) == null) {
            ThreadPool.getDefault().networkIO().execute(new Runnable(this, bArr, i, i2) { // from class: com.yy.mobile.framework.revenuesdk.baseapi.data.RevenueDataParser.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RevenueDataParser this$0;
                public final /* synthetic */ int val$appId;
                public final /* synthetic */ byte[] val$responseData;
                public final /* synthetic */ int val$userchannel;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bArr, Integer.valueOf(i), Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$responseData = bArr;
                    this.val$appId = i;
                    this.val$userchannel = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        PSCIMessageResponse pSCIMessageResponse = new PSCIMessageResponse(this.val$responseData);
                        RLog.debug(RevenueDataParser.TAG, "parserRevenueResponseData: %s", pSCIMessageResponse.toString());
                        for (IRevenueDataReceiver iRevenueDataReceiver : this.this$0.revenueDataReceivers) {
                            iRevenueDataReceiver.onResponseData(this.val$appId, this.val$userchannel, pSCIMessageResponse);
                        }
                    }
                }
            });
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataParser
    public void parserRevenueUnicastData(RevenueUnicastData revenueUnicastData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, revenueUnicastData) == null) {
            ThreadPool.getDefault().networkIO().execute(new Runnable(this, revenueUnicastData) { // from class: com.yy.mobile.framework.revenuesdk.baseapi.data.RevenueDataParser.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RevenueDataParser this$0;
                public final /* synthetic */ RevenueUnicastData val$unicastData;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, revenueUnicastData};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$unicastData = revenueUnicastData;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        PSCIMessageUnicast pSCIMessageUnicast = new PSCIMessageUnicast(this.val$unicastData.jsonData);
                        RLog.debug(RevenueDataParser.TAG, "RevenueUnicastData = %s", pSCIMessageUnicast.toString());
                        RLog.debug(RevenueDataParser.TAG, "RevenueUnicastData: jsonData = %s", pSCIMessageUnicast.getJsonData());
                        pSCIMessageUnicast.setUri(this.val$unicastData.cmd);
                        for (IRevenueDataReceiver iRevenueDataReceiver : this.this$0.revenueDataReceivers) {
                            iRevenueDataReceiver.onUnicastData(pSCIMessageUnicast.getAppId(), pSCIMessageUnicast);
                        }
                    }
                }
            });
        }
    }

    public void registerDataReceivers(IRevenueDataReceiver iRevenueDataReceiver) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, iRevenueDataReceiver) == null) || this.revenueDataReceivers.contains(iRevenueDataReceiver)) {
            return;
        }
        this.revenueDataReceivers.add(iRevenueDataReceiver);
    }
}
