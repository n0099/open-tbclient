package com.kwai.filedownloader.event;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class DownloadServiceConnectChangedEvent extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final ConnectStatus f39623c;

    /* renamed from: d  reason: collision with root package name */
    public final Class<?> f39624d;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class ConnectStatus {
        public static final /* synthetic */ ConnectStatus[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ConnectStatus connected;
        public static final ConnectStatus disconnected;
        public static final ConnectStatus lost;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1071914770, "Lcom/kwai/filedownloader/event/DownloadServiceConnectChangedEvent$ConnectStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1071914770, "Lcom/kwai/filedownloader/event/DownloadServiceConnectChangedEvent$ConnectStatus;");
                    return;
                }
            }
            connected = new ConnectStatus("connected", 0);
            disconnected = new ConnectStatus("disconnected", 1);
            ConnectStatus connectStatus = new ConnectStatus("lost", 2);
            lost = connectStatus;
            $VALUES = new ConnectStatus[]{connected, disconnected, connectStatus};
        }

        public ConnectStatus(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ConnectStatus valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ConnectStatus) Enum.valueOf(ConnectStatus.class, str) : (ConnectStatus) invokeL.objValue;
        }

        public static ConnectStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ConnectStatus[]) $VALUES.clone() : (ConnectStatus[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadServiceConnectChangedEvent(ConnectStatus connectStatus, Class<?> cls) {
        super("event.service.connect.changed");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {connectStatus, cls};
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
        this.f39623c = connectStatus;
        this.f39624d = cls;
    }

    public ConnectStatus a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f39623c : (ConnectStatus) invokeV.objValue;
    }
}
