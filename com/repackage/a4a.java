package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.data.DataSenderConfig;
import com.yy.mobile.framework.revenuesdk.baseapi.data.IDataSenderAdapter;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import java.util.ArrayList;
import tv.athena.revenue.http.HttpDataSenderAdapter;
/* loaded from: classes5.dex */
public class a4a implements IDataSenderAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IDataSenderAdapter a;
    public IDataSenderAdapter b;

    public a4a(IDataSenderAdapter iDataSenderAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iDataSenderAdapter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.debug("DataSenderAdapter", "create DataSenderAdapter");
        this.a = iDataSenderAdapter;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataSender
    public void cancelAllRequest(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            RLog.info("DataSenderAdapter", "cancelAllRequest appId:" + i + " useChannel:" + i2);
            IDataSenderAdapter iDataSenderAdapter = this.a;
            if (iDataSenderAdapter != null) {
                iDataSenderAdapter.cancelAllRequest(i, i2);
                return;
            }
            IDataSenderAdapter iDataSenderAdapter2 = this.b;
            if (iDataSenderAdapter2 != null) {
                iDataSenderAdapter2.cancelAllRequest(i, i2);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IDataSenderAdapter
    public void init(DataSenderConfig dataSenderConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSenderConfig) == null) {
            RLog.debug("DataSenderAdapter", "DataSenderAdapter init");
            IDataSenderAdapter iDataSenderAdapter = this.a;
            if (iDataSenderAdapter == null) {
                HttpDataSenderAdapter httpDataSenderAdapter = new HttpDataSenderAdapter();
                this.b = httpDataSenderAdapter;
                httpDataSenderAdapter.init(dataSenderConfig);
                return;
            }
            iDataSenderAdapter.init(dataSenderConfig);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataSender
    public void sendData(int i, int i2, String str, ArrayList<Integer> arrayList, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, arrayList, bArr}) == null) {
            IDataSenderAdapter iDataSenderAdapter = this.a;
            if (iDataSenderAdapter != null) {
                iDataSenderAdapter.sendData(i, i2, str, arrayList, bArr);
                return;
            }
            IDataSenderAdapter iDataSenderAdapter2 = this.b;
            if (iDataSenderAdapter2 != null) {
                iDataSenderAdapter2.sendData(i, i2, str, arrayList, bArr);
            } else {
                RLog.error("DataSenderAdapter", "sendData senderAdapter is null ", new Object[0]);
            }
        }
    }
}
