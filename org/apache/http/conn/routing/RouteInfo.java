package org.apache.http.conn.routing;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.InetAddress;
import org.apache.http.HttpHost;
@Deprecated
/* loaded from: classes10.dex */
public interface RouteInfo {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class LayerType {
        public static final /* synthetic */ LayerType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LayerType LAYERED;
        public static final LayerType PLAIN;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(866769132, "Lorg/apache/http/conn/routing/RouteInfo$LayerType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(866769132, "Lorg/apache/http/conn/routing/RouteInfo$LayerType;");
                    return;
                }
            }
            LAYERED = new LayerType("LAYERED", 0);
            LayerType layerType = new LayerType("PLAIN", 1);
            PLAIN = layerType;
            $VALUES = new LayerType[]{LAYERED, layerType};
        }

        public LayerType(String str, int i2) {
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

        public static LayerType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LayerType) Enum.valueOf(LayerType.class, str) : (LayerType) invokeL.objValue;
        }

        public static LayerType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LayerType[]) $VALUES.clone() : (LayerType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class TunnelType {
        public static final /* synthetic */ TunnelType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final TunnelType PLAIN;
        public static final TunnelType TUNNELLED;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1112822595, "Lorg/apache/http/conn/routing/RouteInfo$TunnelType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1112822595, "Lorg/apache/http/conn/routing/RouteInfo$TunnelType;");
                    return;
                }
            }
            PLAIN = new TunnelType("PLAIN", 0);
            TunnelType tunnelType = new TunnelType("TUNNELLED", 1);
            TUNNELLED = tunnelType;
            $VALUES = new TunnelType[]{PLAIN, tunnelType};
        }

        public TunnelType(String str, int i2) {
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

        public static TunnelType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TunnelType) Enum.valueOf(TunnelType.class, str) : (TunnelType) invokeL.objValue;
        }

        public static TunnelType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TunnelType[]) $VALUES.clone() : (TunnelType[]) invokeV.objValue;
        }
    }

    int getHopCount();

    HttpHost getHopTarget(int i2);

    LayerType getLayerType();

    InetAddress getLocalAddress();

    HttpHost getProxyHost();

    HttpHost getTargetHost();

    TunnelType getTunnelType();

    boolean isLayered();

    boolean isSecure();

    boolean isTunnelled();
}
