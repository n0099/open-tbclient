package com.repackage;

import android.content.Context;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.network.outback.IOutbackClientIPProvider;
import com.baidu.searchbox.network.outback.IOutbackContext;
import com.baidu.searchbox.network.outback.core.CallFactory;
import com.baidu.searchbox.network.outback.statistics.IAdditionalRecord;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.BdNetTypeSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.w40;
import com.repackage.x50;
import java.util.HashMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import okhttp3.OkHttpClient;
import okhttp3.internal.tls.OkHostnameVerifier;
@Singleton
@Service
/* loaded from: classes6.dex */
public class h95 implements IOutbackContext {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, CallFactory.CallFactoryProducer> a;
    public CallFactory.CallFactoryProducer b;
    public CallFactory.CallFactoryProducer c;
    public int d;

    /* loaded from: classes6.dex */
    public class a implements HostnameVerifier {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(h95 h95Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h95Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, sSLSession)) == null) ? OkHostnameVerifier.INSTANCE.verify(str, sSLSession) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements IAdditionalRecord {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(h95 h95Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h95Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.network.outback.statistics.IAdditionalRecord
        public long getAppLaunchTimeStamp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0L;
            }
            return invokeV.longValue;
        }

        @Override // com.baidu.searchbox.network.outback.statistics.IAdditionalRecord
        public String getClientIPV6() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.network.outback.statistics.IAdditionalRecord
        public String getHttpDnsAreaInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.network.outback.statistics.IAdditionalRecord
        public long getHttpDnsAreaInfoLastUpdateTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0L;
            }
            return invokeV.longValue;
        }

        @Override // com.baidu.searchbox.network.outback.statistics.IAdditionalRecord
        public int getIpStack() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.searchbox.network.outback.statistics.IAdditionalRecord
        public int getNetworkQuality() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.searchbox.network.outback.statistics.IAdditionalRecord
        public String getProcessName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }
    }

    public h95() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = SwitchManager.getInstance().findType(BdNetTypeSwitch.KEY);
        TbadkCoreApplication.getInst().setBdNetType(this.d);
        OkHttpClient build = new OkHttpClient.Builder().hostnameVerifier(new a(this)).build();
        w40.b bVar = new w40.b();
        bVar.p(build);
        this.b = bVar.n();
        this.c = new x50.a().a();
        HashMap<String, CallFactory.CallFactoryProducer> hashMap = new HashMap<>();
        this.a = hashMap;
        hashMap.put(this.b.getEngineName(), this.b);
        this.a.put(this.c.getEngineName(), this.c);
    }

    @Override // com.baidu.searchbox.network.outback.IOutbackContext
    public CallFactory.CallFactoryProducer getBackupCallFactoryProducer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (CallFactory.CallFactoryProducer) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.network.outback.IOutbackContext
    public IOutbackClientIPProvider getClientIPProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (IOutbackClientIPProvider) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.network.outback.IOutbackContext
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? AppRuntime.getAppContext() : (Context) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.network.outback.IOutbackContext
    public CallFactory.CallFactoryProducer getDefaultCallFactoryProducer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? BdNetTypeSwitch.isOkHttp(this.d) ? this.b : this.c : (CallFactory.CallFactoryProducer) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.network.outback.IOutbackContext
    public IAdditionalRecord getIAdditionalRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new b(this) : (IAdditionalRecord) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.network.outback.IOutbackContext
    public HashMap<String, CallFactory.CallFactoryProducer> getOutbackEngines() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (HashMap) invokeV.objValue;
    }
}
