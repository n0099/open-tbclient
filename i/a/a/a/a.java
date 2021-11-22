package i.a.a.a;

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
/* loaded from: classes2.dex */
public class a implements IDataSenderAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public IDataSenderAdapter f73086a;

    /* renamed from: b  reason: collision with root package name */
    public IDataSenderAdapter f73087b;

    public a(IDataSenderAdapter iDataSenderAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iDataSenderAdapter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.debug("DataSenderAdapter", "create DataSenderAdapter");
        this.f73086a = iDataSenderAdapter;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataSender
    public void cancelAllRequest(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            RLog.info("DataSenderAdapter", "cancelAllRequest appId:" + i2 + " useChannel:" + i3);
            IDataSenderAdapter iDataSenderAdapter = this.f73086a;
            if (iDataSenderAdapter != null) {
                iDataSenderAdapter.cancelAllRequest(i2, i3);
                return;
            }
            IDataSenderAdapter iDataSenderAdapter2 = this.f73087b;
            if (iDataSenderAdapter2 != null) {
                iDataSenderAdapter2.cancelAllRequest(i2, i3);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IDataSenderAdapter
    public void init(DataSenderConfig dataSenderConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSenderConfig) == null) {
            RLog.debug("DataSenderAdapter", "DataSenderAdapter init");
            IDataSenderAdapter iDataSenderAdapter = this.f73086a;
            if (iDataSenderAdapter == null) {
                HttpDataSenderAdapter httpDataSenderAdapter = new HttpDataSenderAdapter();
                this.f73087b = httpDataSenderAdapter;
                httpDataSenderAdapter.init(dataSenderConfig);
                return;
            }
            iDataSenderAdapter.init(dataSenderConfig);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataSender
    public void sendData(int i2, int i3, String str, ArrayList<Integer> arrayList, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, arrayList, bArr}) == null) {
            IDataSenderAdapter iDataSenderAdapter = this.f73086a;
            if (iDataSenderAdapter != null) {
                iDataSenderAdapter.sendData(i2, i3, str, arrayList, bArr);
                return;
            }
            IDataSenderAdapter iDataSenderAdapter2 = this.f73087b;
            if (iDataSenderAdapter2 != null) {
                iDataSenderAdapter2.sendData(i2, i3, str, arrayList, bArr);
            } else {
                RLog.error("DataSenderAdapter", "sendData senderAdapter is null ", new Object[0]);
            }
        }
    }
}
