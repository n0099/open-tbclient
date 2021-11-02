package org.webrtc;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import org.webrtc.DataChannel;
import org.webrtc.MediaStreamTrack;
import org.webrtc.RtpTransceiver;
/* loaded from: classes3.dex */
public class PeerConnection {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<MediaStream> localStreams;
    public final long nativePeerConnection;
    public List<RtpReceiver> receivers;
    public List<RtpSender> senders;
    public List<RtpTransceiver> transceivers;

    /* renamed from: org.webrtc.PeerConnection$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class AdapterType {
        public static final /* synthetic */ AdapterType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final AdapterType CELLULAR;
        public static final AdapterType ETHERNET;
        public static final AdapterType LOOPBACK;
        public static final AdapterType UNKNOWN;
        public static final AdapterType VPN;
        public static final AdapterType WIFI;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(124161099, "Lorg/webrtc/PeerConnection$AdapterType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(124161099, "Lorg/webrtc/PeerConnection$AdapterType;");
                    return;
                }
            }
            UNKNOWN = new AdapterType(RomUtils.UNKNOWN, 0);
            ETHERNET = new AdapterType("ETHERNET", 1);
            WIFI = new AdapterType(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 2);
            CELLULAR = new AdapterType("CELLULAR", 3);
            VPN = new AdapterType("VPN", 4);
            AdapterType adapterType = new AdapterType("LOOPBACK", 5);
            LOOPBACK = adapterType;
            $VALUES = new AdapterType[]{UNKNOWN, ETHERNET, WIFI, CELLULAR, VPN, adapterType};
        }

        public AdapterType(String str, int i2) {
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

        public static AdapterType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (AdapterType) Enum.valueOf(AdapterType.class, str) : (AdapterType) invokeL.objValue;
        }

        public static AdapterType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (AdapterType[]) $VALUES.clone() : (AdapterType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class BundlePolicy {
        public static final /* synthetic */ BundlePolicy[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BundlePolicy BALANCED;
        public static final BundlePolicy MAXBUNDLE;
        public static final BundlePolicy MAXCOMPAT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-142153874, "Lorg/webrtc/PeerConnection$BundlePolicy;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-142153874, "Lorg/webrtc/PeerConnection$BundlePolicy;");
                    return;
                }
            }
            BALANCED = new BundlePolicy("BALANCED", 0);
            MAXBUNDLE = new BundlePolicy("MAXBUNDLE", 1);
            BundlePolicy bundlePolicy = new BundlePolicy("MAXCOMPAT", 2);
            MAXCOMPAT = bundlePolicy;
            $VALUES = new BundlePolicy[]{BALANCED, MAXBUNDLE, bundlePolicy};
        }

        public BundlePolicy(String str, int i2) {
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

        public static BundlePolicy valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BundlePolicy) Enum.valueOf(BundlePolicy.class, str) : (BundlePolicy) invokeL.objValue;
        }

        public static BundlePolicy[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BundlePolicy[]) $VALUES.clone() : (BundlePolicy[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class CandidateNetworkPolicy {
        public static final /* synthetic */ CandidateNetworkPolicy[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CandidateNetworkPolicy ALL;
        public static final CandidateNetworkPolicy LOW_COST;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2056808421, "Lorg/webrtc/PeerConnection$CandidateNetworkPolicy;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2056808421, "Lorg/webrtc/PeerConnection$CandidateNetworkPolicy;");
                    return;
                }
            }
            ALL = new CandidateNetworkPolicy("ALL", 0);
            CandidateNetworkPolicy candidateNetworkPolicy = new CandidateNetworkPolicy("LOW_COST", 1);
            LOW_COST = candidateNetworkPolicy;
            $VALUES = new CandidateNetworkPolicy[]{ALL, candidateNetworkPolicy};
        }

        public CandidateNetworkPolicy(String str, int i2) {
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

        public static CandidateNetworkPolicy valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CandidateNetworkPolicy) Enum.valueOf(CandidateNetworkPolicy.class, str) : (CandidateNetworkPolicy) invokeL.objValue;
        }

        public static CandidateNetworkPolicy[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CandidateNetworkPolicy[]) $VALUES.clone() : (CandidateNetworkPolicy[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class ContinualGatheringPolicy {
        public static final /* synthetic */ ContinualGatheringPolicy[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ContinualGatheringPolicy GATHER_CONTINUALLY;
        public static final ContinualGatheringPolicy GATHER_ONCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1024869358, "Lorg/webrtc/PeerConnection$ContinualGatheringPolicy;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1024869358, "Lorg/webrtc/PeerConnection$ContinualGatheringPolicy;");
                    return;
                }
            }
            GATHER_ONCE = new ContinualGatheringPolicy("GATHER_ONCE", 0);
            ContinualGatheringPolicy continualGatheringPolicy = new ContinualGatheringPolicy("GATHER_CONTINUALLY", 1);
            GATHER_CONTINUALLY = continualGatheringPolicy;
            $VALUES = new ContinualGatheringPolicy[]{GATHER_ONCE, continualGatheringPolicy};
        }

        public ContinualGatheringPolicy(String str, int i2) {
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

        public static ContinualGatheringPolicy valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ContinualGatheringPolicy) Enum.valueOf(ContinualGatheringPolicy.class, str) : (ContinualGatheringPolicy) invokeL.objValue;
        }

        public static ContinualGatheringPolicy[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ContinualGatheringPolicy[]) $VALUES.clone() : (ContinualGatheringPolicy[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class IceConnectionState {
        public static final /* synthetic */ IceConnectionState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final IceConnectionState CHECKING;
        public static final IceConnectionState CLOSED;
        public static final IceConnectionState COMPLETED;
        public static final IceConnectionState CONNECTED;
        public static final IceConnectionState DISCONNECTED;
        public static final IceConnectionState FAILED;
        public static final IceConnectionState NEW;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1982786886, "Lorg/webrtc/PeerConnection$IceConnectionState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1982786886, "Lorg/webrtc/PeerConnection$IceConnectionState;");
                    return;
                }
            }
            NEW = new IceConnectionState("NEW", 0);
            CHECKING = new IceConnectionState("CHECKING", 1);
            CONNECTED = new IceConnectionState("CONNECTED", 2);
            COMPLETED = new IceConnectionState("COMPLETED", 3);
            FAILED = new IceConnectionState("FAILED", 4);
            DISCONNECTED = new IceConnectionState("DISCONNECTED", 5);
            IceConnectionState iceConnectionState = new IceConnectionState("CLOSED", 6);
            CLOSED = iceConnectionState;
            $VALUES = new IceConnectionState[]{NEW, CHECKING, CONNECTED, COMPLETED, FAILED, DISCONNECTED, iceConnectionState};
        }

        public IceConnectionState(String str, int i2) {
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

        @CalledByNative("IceConnectionState")
        public static IceConnectionState fromNativeIndex(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? values()[i2] : (IceConnectionState) invokeI.objValue;
        }

        public static IceConnectionState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (IceConnectionState) Enum.valueOf(IceConnectionState.class, str) : (IceConnectionState) invokeL.objValue;
        }

        public static IceConnectionState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (IceConnectionState[]) $VALUES.clone() : (IceConnectionState[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class IceGatheringState {
        public static final /* synthetic */ IceGatheringState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final IceGatheringState COMPLETE;
        public static final IceGatheringState GATHERING;
        public static final IceGatheringState NEW;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(604945919, "Lorg/webrtc/PeerConnection$IceGatheringState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(604945919, "Lorg/webrtc/PeerConnection$IceGatheringState;");
                    return;
                }
            }
            NEW = new IceGatheringState("NEW", 0);
            GATHERING = new IceGatheringState("GATHERING", 1);
            IceGatheringState iceGatheringState = new IceGatheringState("COMPLETE", 2);
            COMPLETE = iceGatheringState;
            $VALUES = new IceGatheringState[]{NEW, GATHERING, iceGatheringState};
        }

        public IceGatheringState(String str, int i2) {
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

        @CalledByNative("IceGatheringState")
        public static IceGatheringState fromNativeIndex(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? values()[i2] : (IceGatheringState) invokeI.objValue;
        }

        public static IceGatheringState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (IceGatheringState) Enum.valueOf(IceGatheringState.class, str) : (IceGatheringState) invokeL.objValue;
        }

        public static IceGatheringState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (IceGatheringState[]) $VALUES.clone() : (IceGatheringState[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class IceServer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String hostname;
        public final String password;
        public final List<String> tlsAlpnProtocols;
        public final TlsCertPolicy tlsCertPolicy;
        public final List<String> tlsEllipticCurves;
        @Deprecated
        public final String uri;
        public final List<String> urls;
        public final String username;

        /* loaded from: classes3.dex */
        public static class Builder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String hostname;
            public String password;
            public List<String> tlsAlpnProtocols;
            public TlsCertPolicy tlsCertPolicy;
            public List<String> tlsEllipticCurves;
            @Nullable
            public final List<String> urls;
            public String username;

            public /* synthetic */ Builder(List list, AnonymousClass1 anonymousClass1) {
                this(list);
            }

            public IceServer createIceServer() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new IceServer(this.urls.get(0), this.urls, this.username, this.password, this.tlsCertPolicy, this.hostname, this.tlsAlpnProtocols, this.tlsEllipticCurves, null) : (IceServer) invokeV.objValue;
            }

            public Builder setHostname(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                    this.hostname = str;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setPassword(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                    this.password = str;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setTlsAlpnProtocols(List<String> list) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
                    this.tlsAlpnProtocols = list;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setTlsCertPolicy(TlsCertPolicy tlsCertPolicy) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tlsCertPolicy)) == null) {
                    this.tlsCertPolicy = tlsCertPolicy;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setTlsEllipticCurves(List<String> list) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
                    this.tlsEllipticCurves = list;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder setUsername(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                    this.username = str;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder(List<String> list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.username = "";
                this.password = "";
                this.tlsCertPolicy = TlsCertPolicy.TLS_CERT_POLICY_SECURE;
                this.hostname = "";
                if (list != null && !list.isEmpty()) {
                    this.urls = list;
                    return;
                }
                throw new IllegalArgumentException("urls == null || urls.isEmpty(): " + list);
            }
        }

        public /* synthetic */ IceServer(String str, List list, String str2, String str3, TlsCertPolicy tlsCertPolicy, String str4, List list2, List list3, AnonymousClass1 anonymousClass1) {
            this(str, list, str2, str3, tlsCertPolicy, str4, list2, list3);
        }

        public static Builder builder(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? new Builder(Collections.singletonList(str), null) : (Builder) invokeL.objValue;
        }

        @Nullable
        @CalledByNative("IceServer")
        public String getHostname() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.hostname : (String) invokeV.objValue;
        }

        @Nullable
        @CalledByNative("IceServer")
        public String getPassword() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.password : (String) invokeV.objValue;
        }

        @CalledByNative("IceServer")
        public List<String> getTlsAlpnProtocols() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.tlsAlpnProtocols : (List) invokeV.objValue;
        }

        @CalledByNative("IceServer")
        public TlsCertPolicy getTlsCertPolicy() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.tlsCertPolicy : (TlsCertPolicy) invokeV.objValue;
        }

        @CalledByNative("IceServer")
        public List<String> getTlsEllipticCurves() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.tlsEllipticCurves : (List) invokeV.objValue;
        }

        @Nullable
        @CalledByNative("IceServer")
        public List<String> getUrls() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.urls : (List) invokeV.objValue;
        }

        @Nullable
        @CalledByNative("IceServer")
        public String getUsername() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.username : (String) invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.urls + " [" + this.username + ":" + this.password + "] [" + this.tlsCertPolicy + "] [" + this.hostname + "] [" + this.tlsAlpnProtocols + "] [" + this.tlsEllipticCurves + PreferencesUtil.RIGHT_MOUNT;
            }
            return (String) invokeV.objValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @Deprecated
        public IceServer(String str) {
            this(str, "", "");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((String) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public static Builder builder(List<String> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, list)) == null) ? new Builder(list, null) : (Builder) invokeL.objValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @Deprecated
        public IceServer(String str, String str2, String str3) {
            this(str, str2, str3, TlsCertPolicy.TLS_CERT_POLICY_SECURE);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (TlsCertPolicy) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @Deprecated
        public IceServer(String str, String str2, String str3, TlsCertPolicy tlsCertPolicy) {
            this(str, str2, str3, tlsCertPolicy, "");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, tlsCertPolicy};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (TlsCertPolicy) objArr2[3], (String) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @Deprecated
        public IceServer(String str, String str2, String str3, TlsCertPolicy tlsCertPolicy, String str4) {
            this(str, Collections.singletonList(str), str2, str3, tlsCertPolicy, str4, null, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, tlsCertPolicy, str4};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((String) objArr2[0], (List) objArr2[1], (String) objArr2[2], (String) objArr2[3], (TlsCertPolicy) objArr2[4], (String) objArr2[5], (List) objArr2[6], (List) objArr2[7]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
        }

        public IceServer(String str, List<String> list, String str2, String str3, TlsCertPolicy tlsCertPolicy, String str4, List<String> list2, List<String> list3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, list, str2, str3, tlsCertPolicy, str4, list2, list3};
                interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                    return;
                }
            }
            if (str != null && list != null && !list.isEmpty()) {
                for (String str5 : list) {
                    if (str5 == null) {
                        throw new IllegalArgumentException("urls element is null: " + list);
                    }
                }
                if (str2 == null) {
                    throw new IllegalArgumentException("username == null");
                }
                if (str3 == null) {
                    throw new IllegalArgumentException("password == null");
                }
                if (str4 != null) {
                    this.uri = str;
                    this.urls = list;
                    this.username = str2;
                    this.password = str3;
                    this.tlsCertPolicy = tlsCertPolicy;
                    this.hostname = str4;
                    this.tlsAlpnProtocols = list2;
                    this.tlsEllipticCurves = list3;
                    return;
                }
                throw new IllegalArgumentException("hostname == null");
            }
            throw new IllegalArgumentException("uri == null || urls == null || urls.isEmpty()");
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class IceTransportsType {
        public static final /* synthetic */ IceTransportsType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final IceTransportsType ALL;
        public static final IceTransportsType NOHOST;
        public static final IceTransportsType NONE;
        public static final IceTransportsType RELAY;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1744837957, "Lorg/webrtc/PeerConnection$IceTransportsType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1744837957, "Lorg/webrtc/PeerConnection$IceTransportsType;");
                    return;
                }
            }
            NONE = new IceTransportsType("NONE", 0);
            RELAY = new IceTransportsType("RELAY", 1);
            NOHOST = new IceTransportsType("NOHOST", 2);
            IceTransportsType iceTransportsType = new IceTransportsType("ALL", 3);
            ALL = iceTransportsType;
            $VALUES = new IceTransportsType[]{NONE, RELAY, NOHOST, iceTransportsType};
        }

        public IceTransportsType(String str, int i2) {
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

        public static IceTransportsType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (IceTransportsType) Enum.valueOf(IceTransportsType.class, str) : (IceTransportsType) invokeL.objValue;
        }

        public static IceTransportsType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (IceTransportsType[]) $VALUES.clone() : (IceTransportsType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class IntervalRange {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int max;
        public final int min;

        public IntervalRange(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.min = i2;
            this.max = i3;
        }

        @CalledByNative("IntervalRange")
        public int getMax() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.max : invokeV.intValue;
        }

        @CalledByNative("IntervalRange")
        public int getMin() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.min : invokeV.intValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class KeyType {
        public static final /* synthetic */ KeyType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final KeyType ECDSA;
        public static final KeyType RSA;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-806817861, "Lorg/webrtc/PeerConnection$KeyType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-806817861, "Lorg/webrtc/PeerConnection$KeyType;");
                    return;
                }
            }
            RSA = new KeyType("RSA", 0);
            KeyType keyType = new KeyType("ECDSA", 1);
            ECDSA = keyType;
            $VALUES = new KeyType[]{RSA, keyType};
        }

        public KeyType(String str, int i2) {
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

        public static KeyType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (KeyType) Enum.valueOf(KeyType.class, str) : (KeyType) invokeL.objValue;
        }

        public static KeyType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (KeyType[]) $VALUES.clone() : (KeyType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface Observer {
        @CalledByNative("Observer")
        void onAddStream(MediaStream mediaStream);

        @CalledByNative("Observer")
        void onAddTrack(RtpReceiver rtpReceiver, MediaStream[] mediaStreamArr);

        @CalledByNative("Observer")
        void onConnectionChange(PeerConnectionState peerConnectionState);

        @CalledByNative("Observer")
        void onDataChannel(DataChannel dataChannel);

        @CalledByNative("Observer")
        void onIceCandidate(IceCandidate iceCandidate);

        @CalledByNative("Observer")
        void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr);

        @CalledByNative("Observer")
        void onIceConnectionChange(IceConnectionState iceConnectionState);

        @CalledByNative("Observer")
        void onIceConnectionReceivingChange(boolean z);

        @CalledByNative("Observer")
        void onIceGatheringChange(IceGatheringState iceGatheringState);

        @CalledByNative("Observer")
        void onRemoveStream(MediaStream mediaStream);

        @CalledByNative("Observer")
        void onRenegotiationNeeded();

        @CalledByNative("Observer")
        void onSignalingChange(SignalingState signalingState);

        @CalledByNative("Observer")
        void onTrack(RtpTransceiver rtpTransceiver);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class PeerConnectionState {
        public static final /* synthetic */ PeerConnectionState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final PeerConnectionState CLOSED;
        public static final PeerConnectionState CONNECTED;
        public static final PeerConnectionState CONNECTING;
        public static final PeerConnectionState DISCONNECTED;
        public static final PeerConnectionState FAILED;
        public static final PeerConnectionState NEW;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1581560035, "Lorg/webrtc/PeerConnection$PeerConnectionState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1581560035, "Lorg/webrtc/PeerConnection$PeerConnectionState;");
                    return;
                }
            }
            NEW = new PeerConnectionState("NEW", 0);
            CONNECTING = new PeerConnectionState("CONNECTING", 1);
            CONNECTED = new PeerConnectionState("CONNECTED", 2);
            DISCONNECTED = new PeerConnectionState("DISCONNECTED", 3);
            FAILED = new PeerConnectionState("FAILED", 4);
            PeerConnectionState peerConnectionState = new PeerConnectionState("CLOSED", 5);
            CLOSED = peerConnectionState;
            $VALUES = new PeerConnectionState[]{NEW, CONNECTING, CONNECTED, DISCONNECTED, FAILED, peerConnectionState};
        }

        public PeerConnectionState(String str, int i2) {
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

        @CalledByNative("PeerConnectionState")
        public static PeerConnectionState fromNativeIndex(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? values()[i2] : (PeerConnectionState) invokeI.objValue;
        }

        public static PeerConnectionState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (PeerConnectionState) Enum.valueOf(PeerConnectionState.class, str) : (PeerConnectionState) invokeL.objValue;
        }

        public static PeerConnectionState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (PeerConnectionState[]) $VALUES.clone() : (PeerConnectionState[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class RTCConfiguration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean activeResetSrtpParams;
        public boolean audioJitterBufferFastAccelerate;
        public int audioJitterBufferMaxPackets;
        public BundlePolicy bundlePolicy;
        public CandidateNetworkPolicy candidateNetworkPolicy;
        @Nullable
        public RtcCertificatePem certificate;
        @Nullable
        public Boolean combinedAudioVideoBwe;
        public ContinualGatheringPolicy continualGatheringPolicy;
        @Nullable
        public CryptoOptions cryptoOptions;
        public boolean disableIPv6OnWifi;
        public boolean disableIpv6;
        public boolean enableCpuOveruseDetection;
        public boolean enableDscp;
        @Nullable
        public Boolean enableDtlsSrtp;
        public boolean enableRtpDataChannel;
        public int iceBackupCandidatePairPingInterval;
        public int iceCandidatePoolSize;
        @Nullable
        public Integer iceCheckIntervalStrongConnectivityMs;
        @Nullable
        public Integer iceCheckIntervalWeakConnectivityMs;
        @Nullable
        public Integer iceCheckMinInterval;
        public int iceConnectionReceivingTimeout;
        @Nullable
        public IntervalRange iceRegatherIntervalRange;
        public List<IceServer> iceServers;
        public IceTransportsType iceTransportsType;
        @Nullable
        public Integer iceUnwritableMinChecks;
        @Nullable
        public Integer iceUnwritableTimeMs;
        public KeyType keyType;
        public int maxIPv6Networks;
        public AdapterType networkPreference;
        public boolean presumeWritableWhenFullyRelayed;
        public boolean pruneTurnPorts;
        public RtcpMuxPolicy rtcpMuxPolicy;
        @Nullable
        public Integer screencastMinBitrate;
        public SdpSemantics sdpSemantics;
        @Nullable
        public Integer stunCandidateKeepaliveIntervalMs;
        public boolean suspendBelowMinBitrate;
        public TcpCandidatePolicy tcpCandidatePolicy;
        @Nullable
        public TurnCustomizer turnCustomizer;
        public boolean useMediaTransport;
        public boolean useMediaTransportForDataChannels;

        public RTCConfiguration(List<IceServer> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.iceTransportsType = IceTransportsType.ALL;
            this.bundlePolicy = BundlePolicy.BALANCED;
            this.rtcpMuxPolicy = RtcpMuxPolicy.REQUIRE;
            this.tcpCandidatePolicy = TcpCandidatePolicy.ENABLED;
            this.candidateNetworkPolicy = CandidateNetworkPolicy.ALL;
            this.iceServers = list;
            this.audioJitterBufferMaxPackets = 50;
            this.audioJitterBufferFastAccelerate = false;
            this.iceConnectionReceivingTimeout = -1;
            this.iceBackupCandidatePairPingInterval = -1;
            this.keyType = KeyType.ECDSA;
            this.continualGatheringPolicy = ContinualGatheringPolicy.GATHER_ONCE;
            this.iceCandidatePoolSize = 0;
            this.pruneTurnPorts = false;
            this.presumeWritableWhenFullyRelayed = false;
            this.iceCheckIntervalStrongConnectivityMs = null;
            this.iceCheckIntervalWeakConnectivityMs = null;
            this.iceCheckMinInterval = null;
            this.iceUnwritableTimeMs = null;
            this.iceUnwritableMinChecks = null;
            this.stunCandidateKeepaliveIntervalMs = null;
            this.disableIPv6OnWifi = false;
            this.maxIPv6Networks = 5;
            this.iceRegatherIntervalRange = null;
            this.disableIpv6 = false;
            this.enableDscp = false;
            this.enableCpuOveruseDetection = true;
            this.enableRtpDataChannel = false;
            this.suspendBelowMinBitrate = false;
            this.screencastMinBitrate = null;
            this.combinedAudioVideoBwe = null;
            this.enableDtlsSrtp = null;
            this.networkPreference = AdapterType.UNKNOWN;
            this.sdpSemantics = SdpSemantics.PLAN_B;
            this.activeResetSrtpParams = false;
            this.useMediaTransport = false;
            this.useMediaTransportForDataChannels = false;
            this.cryptoOptions = null;
        }

        @CalledByNative("RTCConfiguration")
        public boolean getActiveResetSrtpParams() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.activeResetSrtpParams : invokeV.booleanValue;
        }

        @CalledByNative("RTCConfiguration")
        public boolean getAudioJitterBufferFastAccelerate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.audioJitterBufferFastAccelerate : invokeV.booleanValue;
        }

        @CalledByNative("RTCConfiguration")
        public int getAudioJitterBufferMaxPackets() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.audioJitterBufferMaxPackets : invokeV.intValue;
        }

        @CalledByNative("RTCConfiguration")
        public BundlePolicy getBundlePolicy() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.bundlePolicy : (BundlePolicy) invokeV.objValue;
        }

        @CalledByNative("RTCConfiguration")
        public CandidateNetworkPolicy getCandidateNetworkPolicy() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.candidateNetworkPolicy : (CandidateNetworkPolicy) invokeV.objValue;
        }

        @Nullable
        @CalledByNative("RTCConfiguration")
        public RtcCertificatePem getCertificate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.certificate : (RtcCertificatePem) invokeV.objValue;
        }

        @Nullable
        @CalledByNative("RTCConfiguration")
        public Boolean getCombinedAudioVideoBwe() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.combinedAudioVideoBwe : (Boolean) invokeV.objValue;
        }

        @CalledByNative("RTCConfiguration")
        public ContinualGatheringPolicy getContinualGatheringPolicy() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.continualGatheringPolicy : (ContinualGatheringPolicy) invokeV.objValue;
        }

        @Nullable
        @CalledByNative("RTCConfiguration")
        public CryptoOptions getCryptoOptions() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.cryptoOptions : (CryptoOptions) invokeV.objValue;
        }

        @CalledByNative("RTCConfiguration")
        public boolean getDisableIPv6OnWifi() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.disableIPv6OnWifi : invokeV.booleanValue;
        }

        @CalledByNative("RTCConfiguration")
        public boolean getDisableIpv6() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.disableIpv6 : invokeV.booleanValue;
        }

        @CalledByNative("RTCConfiguration")
        public boolean getEnableCpuOveruseDetection() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.enableCpuOveruseDetection : invokeV.booleanValue;
        }

        @CalledByNative("RTCConfiguration")
        public boolean getEnableDscp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.enableDscp : invokeV.booleanValue;
        }

        @Nullable
        @CalledByNative("RTCConfiguration")
        public Boolean getEnableDtlsSrtp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.enableDtlsSrtp : (Boolean) invokeV.objValue;
        }

        @CalledByNative("RTCConfiguration")
        public boolean getEnableRtpDataChannel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.enableRtpDataChannel : invokeV.booleanValue;
        }

        @CalledByNative("RTCConfiguration")
        public int getIceBackupCandidatePairPingInterval() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.iceBackupCandidatePairPingInterval : invokeV.intValue;
        }

        @CalledByNative("RTCConfiguration")
        public int getIceCandidatePoolSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.iceCandidatePoolSize : invokeV.intValue;
        }

        @Nullable
        @CalledByNative("RTCConfiguration")
        public Integer getIceCheckIntervalStrongConnectivity() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.iceCheckIntervalStrongConnectivityMs : (Integer) invokeV.objValue;
        }

        @Nullable
        @CalledByNative("RTCConfiguration")
        public Integer getIceCheckIntervalWeakConnectivity() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.iceCheckIntervalWeakConnectivityMs : (Integer) invokeV.objValue;
        }

        @Nullable
        @CalledByNative("RTCConfiguration")
        public Integer getIceCheckMinInterval() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.iceCheckMinInterval : (Integer) invokeV.objValue;
        }

        @CalledByNative("RTCConfiguration")
        public int getIceConnectionReceivingTimeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.iceConnectionReceivingTimeout : invokeV.intValue;
        }

        @Nullable
        @CalledByNative("RTCConfiguration")
        public IntervalRange getIceRegatherIntervalRange() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.iceRegatherIntervalRange : (IntervalRange) invokeV.objValue;
        }

        @CalledByNative("RTCConfiguration")
        public List<IceServer> getIceServers() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.iceServers : (List) invokeV.objValue;
        }

        @CalledByNative("RTCConfiguration")
        public IceTransportsType getIceTransportsType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.iceTransportsType : (IceTransportsType) invokeV.objValue;
        }

        @Nullable
        @CalledByNative("RTCConfiguration")
        public Integer getIceUnwritableMinChecks() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.iceUnwritableMinChecks : (Integer) invokeV.objValue;
        }

        @Nullable
        @CalledByNative("RTCConfiguration")
        public Integer getIceUnwritableTimeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.iceUnwritableTimeMs : (Integer) invokeV.objValue;
        }

        @CalledByNative("RTCConfiguration")
        public KeyType getKeyType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.keyType : (KeyType) invokeV.objValue;
        }

        @CalledByNative("RTCConfiguration")
        public int getMaxIPv6Networks() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.maxIPv6Networks : invokeV.intValue;
        }

        @CalledByNative("RTCConfiguration")
        public AdapterType getNetworkPreference() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.networkPreference : (AdapterType) invokeV.objValue;
        }

        @CalledByNative("RTCConfiguration")
        public boolean getPresumeWritableWhenFullyRelayed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.presumeWritableWhenFullyRelayed : invokeV.booleanValue;
        }

        @CalledByNative("RTCConfiguration")
        public boolean getPruneTurnPorts() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.pruneTurnPorts : invokeV.booleanValue;
        }

        @CalledByNative("RTCConfiguration")
        public RtcpMuxPolicy getRtcpMuxPolicy() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.rtcpMuxPolicy : (RtcpMuxPolicy) invokeV.objValue;
        }

        @Nullable
        @CalledByNative("RTCConfiguration")
        public Integer getScreencastMinBitrate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.screencastMinBitrate : (Integer) invokeV.objValue;
        }

        @CalledByNative("RTCConfiguration")
        public SdpSemantics getSdpSemantics() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.sdpSemantics : (SdpSemantics) invokeV.objValue;
        }

        @Nullable
        @CalledByNative("RTCConfiguration")
        public Integer getStunCandidateKeepaliveInterval() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.stunCandidateKeepaliveIntervalMs : (Integer) invokeV.objValue;
        }

        @CalledByNative("RTCConfiguration")
        public boolean getSuspendBelowMinBitrate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.suspendBelowMinBitrate : invokeV.booleanValue;
        }

        @CalledByNative("RTCConfiguration")
        public TcpCandidatePolicy getTcpCandidatePolicy() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.tcpCandidatePolicy : (TcpCandidatePolicy) invokeV.objValue;
        }

        @Nullable
        @CalledByNative("RTCConfiguration")
        public TurnCustomizer getTurnCustomizer() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.turnCustomizer : (TurnCustomizer) invokeV.objValue;
        }

        @CalledByNative("RTCConfiguration")
        public boolean getUseMediaTransport() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.useMediaTransport : invokeV.booleanValue;
        }

        @CalledByNative("RTCConfiguration")
        public boolean getUseMediaTransportForDataChannels() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.useMediaTransportForDataChannels : invokeV.booleanValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class RtcpMuxPolicy {
        public static final /* synthetic */ RtcpMuxPolicy[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RtcpMuxPolicy NEGOTIATE;
        public static final RtcpMuxPolicy REQUIRE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1455502017, "Lorg/webrtc/PeerConnection$RtcpMuxPolicy;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1455502017, "Lorg/webrtc/PeerConnection$RtcpMuxPolicy;");
                    return;
                }
            }
            NEGOTIATE = new RtcpMuxPolicy("NEGOTIATE", 0);
            RtcpMuxPolicy rtcpMuxPolicy = new RtcpMuxPolicy("REQUIRE", 1);
            REQUIRE = rtcpMuxPolicy;
            $VALUES = new RtcpMuxPolicy[]{NEGOTIATE, rtcpMuxPolicy};
        }

        public RtcpMuxPolicy(String str, int i2) {
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

        public static RtcpMuxPolicy valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RtcpMuxPolicy) Enum.valueOf(RtcpMuxPolicy.class, str) : (RtcpMuxPolicy) invokeL.objValue;
        }

        public static RtcpMuxPolicy[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RtcpMuxPolicy[]) $VALUES.clone() : (RtcpMuxPolicy[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class SdpSemantics {
        public static final /* synthetic */ SdpSemantics[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SdpSemantics PLAN_B;
        public static final SdpSemantics UNIFIED_PLAN;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-276337388, "Lorg/webrtc/PeerConnection$SdpSemantics;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-276337388, "Lorg/webrtc/PeerConnection$SdpSemantics;");
                    return;
                }
            }
            PLAN_B = new SdpSemantics("PLAN_B", 0);
            SdpSemantics sdpSemantics = new SdpSemantics("UNIFIED_PLAN", 1);
            UNIFIED_PLAN = sdpSemantics;
            $VALUES = new SdpSemantics[]{PLAN_B, sdpSemantics};
        }

        public SdpSemantics(String str, int i2) {
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

        public static SdpSemantics valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SdpSemantics) Enum.valueOf(SdpSemantics.class, str) : (SdpSemantics) invokeL.objValue;
        }

        public static SdpSemantics[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SdpSemantics[]) $VALUES.clone() : (SdpSemantics[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class SignalingState {
        public static final /* synthetic */ SignalingState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SignalingState CLOSED;
        public static final SignalingState HAVE_LOCAL_OFFER;
        public static final SignalingState HAVE_LOCAL_PRANSWER;
        public static final SignalingState HAVE_REMOTE_OFFER;
        public static final SignalingState HAVE_REMOTE_PRANSWER;
        public static final SignalingState STABLE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2016772629, "Lorg/webrtc/PeerConnection$SignalingState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2016772629, "Lorg/webrtc/PeerConnection$SignalingState;");
                    return;
                }
            }
            STABLE = new SignalingState("STABLE", 0);
            HAVE_LOCAL_OFFER = new SignalingState("HAVE_LOCAL_OFFER", 1);
            HAVE_LOCAL_PRANSWER = new SignalingState("HAVE_LOCAL_PRANSWER", 2);
            HAVE_REMOTE_OFFER = new SignalingState("HAVE_REMOTE_OFFER", 3);
            HAVE_REMOTE_PRANSWER = new SignalingState("HAVE_REMOTE_PRANSWER", 4);
            SignalingState signalingState = new SignalingState("CLOSED", 5);
            CLOSED = signalingState;
            $VALUES = new SignalingState[]{STABLE, HAVE_LOCAL_OFFER, HAVE_LOCAL_PRANSWER, HAVE_REMOTE_OFFER, HAVE_REMOTE_PRANSWER, signalingState};
        }

        public SignalingState(String str, int i2) {
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

        @CalledByNative("SignalingState")
        public static SignalingState fromNativeIndex(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? values()[i2] : (SignalingState) invokeI.objValue;
        }

        public static SignalingState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (SignalingState) Enum.valueOf(SignalingState.class, str) : (SignalingState) invokeL.objValue;
        }

        public static SignalingState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (SignalingState[]) $VALUES.clone() : (SignalingState[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class TcpCandidatePolicy {
        public static final /* synthetic */ TcpCandidatePolicy[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final TcpCandidatePolicy DISABLED;
        public static final TcpCandidatePolicy ENABLED;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2064519182, "Lorg/webrtc/PeerConnection$TcpCandidatePolicy;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2064519182, "Lorg/webrtc/PeerConnection$TcpCandidatePolicy;");
                    return;
                }
            }
            ENABLED = new TcpCandidatePolicy("ENABLED", 0);
            TcpCandidatePolicy tcpCandidatePolicy = new TcpCandidatePolicy("DISABLED", 1);
            DISABLED = tcpCandidatePolicy;
            $VALUES = new TcpCandidatePolicy[]{ENABLED, tcpCandidatePolicy};
        }

        public TcpCandidatePolicy(String str, int i2) {
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

        public static TcpCandidatePolicy valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TcpCandidatePolicy) Enum.valueOf(TcpCandidatePolicy.class, str) : (TcpCandidatePolicy) invokeL.objValue;
        }

        public static TcpCandidatePolicy[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TcpCandidatePolicy[]) $VALUES.clone() : (TcpCandidatePolicy[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class TlsCertPolicy {
        public static final /* synthetic */ TlsCertPolicy[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final TlsCertPolicy TLS_CERT_POLICY_INSECURE_NO_CHECK;
        public static final TlsCertPolicy TLS_CERT_POLICY_SECURE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2145130083, "Lorg/webrtc/PeerConnection$TlsCertPolicy;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2145130083, "Lorg/webrtc/PeerConnection$TlsCertPolicy;");
                    return;
                }
            }
            TLS_CERT_POLICY_SECURE = new TlsCertPolicy("TLS_CERT_POLICY_SECURE", 0);
            TlsCertPolicy tlsCertPolicy = new TlsCertPolicy("TLS_CERT_POLICY_INSECURE_NO_CHECK", 1);
            TLS_CERT_POLICY_INSECURE_NO_CHECK = tlsCertPolicy;
            $VALUES = new TlsCertPolicy[]{TLS_CERT_POLICY_SECURE, tlsCertPolicy};
        }

        public TlsCertPolicy(String str, int i2) {
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

        public static TlsCertPolicy valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TlsCertPolicy) Enum.valueOf(TlsCertPolicy.class, str) : (TlsCertPolicy) invokeL.objValue;
        }

        public static TlsCertPolicy[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TlsCertPolicy[]) $VALUES.clone() : (TlsCertPolicy[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PeerConnection(NativePeerConnectionFactory nativePeerConnectionFactory) {
        this(nativePeerConnectionFactory.createNativePeerConnection());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nativePeerConnectionFactory};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static long createNativePeerConnectionObserver(Observer observer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, observer)) == null) ? nativeCreatePeerConnectionObserver(observer) : invokeL.longValue;
    }

    private native boolean nativeAddIceCandidate(String str, int i2, String str2);

    private native boolean nativeAddLocalStream(long j);

    private native RtpSender nativeAddTrack(long j, List<String> list);

    private native RtpTransceiver nativeAddTransceiverOfType(MediaStreamTrack.MediaType mediaType, RtpTransceiver.RtpTransceiverInit rtpTransceiverInit);

    private native RtpTransceiver nativeAddTransceiverWithTrack(long j, RtpTransceiver.RtpTransceiverInit rtpTransceiverInit);

    private native void nativeClose();

    private native PeerConnectionState nativeConnectionState();

    private native void nativeCreateAnswer(SdpObserver sdpObserver, MediaConstraints mediaConstraints);

    private native DataChannel nativeCreateDataChannel(String str, DataChannel.Init init);

    private native void nativeCreateOffer(SdpObserver sdpObserver, MediaConstraints mediaConstraints);

    public static native long nativeCreatePeerConnectionObserver(Observer observer);

    private native RtpSender nativeCreateSender(String str, String str2);

    public static native void nativeFreeOwnedPeerConnection(long j);

    private native RtcCertificatePem nativeGetCertificate();

    private native SessionDescription nativeGetLocalDescription();

    private native long nativeGetNativePeerConnection();

    private native List<RtpReceiver> nativeGetReceivers();

    private native SessionDescription nativeGetRemoteDescription();

    private native List<RtpSender> nativeGetSenders();

    private native List<RtpTransceiver> nativeGetTransceivers();

    private native IceConnectionState nativeIceConnectionState();

    private native IceGatheringState nativeIceGatheringState();

    private native void nativeNewGetStats(RTCStatsCollectorCallback rTCStatsCollectorCallback);

    private native boolean nativeOldGetStats(StatsObserver statsObserver, long j);

    private native boolean nativeRemoveIceCandidates(IceCandidate[] iceCandidateArr);

    private native void nativeRemoveLocalStream(long j);

    private native boolean nativeRemoveTrack(long j);

    private native void nativeSetAudioPlayout(boolean z);

    private native void nativeSetAudioRecording(boolean z);

    private native boolean nativeSetBitrate(Integer num, Integer num2, Integer num3);

    private native boolean nativeSetConfiguration(RTCConfiguration rTCConfiguration);

    private native void nativeSetLocalDescription(SdpObserver sdpObserver, SessionDescription sessionDescription);

    private native void nativeSetRemoteDescription(SdpObserver sdpObserver, SessionDescription sessionDescription);

    private native SignalingState nativeSignalingState();

    private native boolean nativeStartRtcEventLog(int i2, int i3);

    private native void nativeStopRtcEventLog();

    public boolean addIceCandidate(IceCandidate iceCandidate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iceCandidate)) == null) ? nativeAddIceCandidate(iceCandidate.sdpMid, iceCandidate.sdpMLineIndex, iceCandidate.sdp) : invokeL.booleanValue;
    }

    public boolean addStream(MediaStream mediaStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaStream)) == null) {
            if (nativeAddLocalStream(mediaStream.getNativeMediaStream())) {
                this.localStreams.add(mediaStream);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public RtpSender addTrack(MediaStreamTrack mediaStreamTrack) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mediaStreamTrack)) == null) ? addTrack(mediaStreamTrack, Collections.emptyList()) : (RtpSender) invokeL.objValue;
    }

    public RtpTransceiver addTransceiver(MediaStreamTrack mediaStreamTrack) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, mediaStreamTrack)) == null) ? addTransceiver(mediaStreamTrack, new RtpTransceiver.RtpTransceiverInit()) : (RtpTransceiver) invokeL.objValue;
    }

    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            nativeClose();
        }
    }

    public PeerConnectionState connectionState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? nativeConnectionState() : (PeerConnectionState) invokeV.objValue;
    }

    public void createAnswer(SdpObserver sdpObserver, MediaConstraints mediaConstraints) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, sdpObserver, mediaConstraints) == null) {
            nativeCreateAnswer(sdpObserver, mediaConstraints);
        }
    }

    public DataChannel createDataChannel(String str, DataChannel.Init init) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, init)) == null) ? nativeCreateDataChannel(str, init) : (DataChannel) invokeLL.objValue;
    }

    public void createOffer(SdpObserver sdpObserver, MediaConstraints mediaConstraints) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, sdpObserver, mediaConstraints) == null) {
            nativeCreateOffer(sdpObserver, mediaConstraints);
        }
    }

    public RtpSender createSender(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, str2)) == null) {
            RtpSender nativeCreateSender = nativeCreateSender(str, str2);
            if (nativeCreateSender != null) {
                this.senders.add(nativeCreateSender);
            }
            return nativeCreateSender;
        }
        return (RtpSender) invokeLL.objValue;
    }

    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            close();
            for (MediaStream mediaStream : this.localStreams) {
                nativeRemoveLocalStream(mediaStream.getNativeMediaStream());
                mediaStream.dispose();
            }
            this.localStreams.clear();
            for (RtpSender rtpSender : this.senders) {
                rtpSender.dispose();
            }
            this.senders.clear();
            for (RtpReceiver rtpReceiver : this.receivers) {
                rtpReceiver.dispose();
            }
            for (RtpTransceiver rtpTransceiver : this.transceivers) {
                rtpTransceiver.dispose();
            }
            this.transceivers.clear();
            this.receivers.clear();
            nativeFreeOwnedPeerConnection(this.nativePeerConnection);
        }
    }

    public RtcCertificatePem getCertificate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? nativeGetCertificate() : (RtcCertificatePem) invokeV.objValue;
    }

    public SessionDescription getLocalDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? nativeGetLocalDescription() : (SessionDescription) invokeV.objValue;
    }

    @CalledByNative
    public long getNativeOwnedPeerConnection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.nativePeerConnection : invokeV.longValue;
    }

    public long getNativePeerConnection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? nativeGetNativePeerConnection() : invokeV.longValue;
    }

    public List<RtpReceiver> getReceivers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            for (RtpReceiver rtpReceiver : this.receivers) {
                rtpReceiver.dispose();
            }
            List<RtpReceiver> nativeGetReceivers = nativeGetReceivers();
            this.receivers = nativeGetReceivers;
            return Collections.unmodifiableList(nativeGetReceivers);
        }
        return (List) invokeV.objValue;
    }

    public SessionDescription getRemoteDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? nativeGetRemoteDescription() : (SessionDescription) invokeV.objValue;
    }

    public List<RtpSender> getSenders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            for (RtpSender rtpSender : this.senders) {
                rtpSender.dispose();
            }
            List<RtpSender> nativeGetSenders = nativeGetSenders();
            this.senders = nativeGetSenders;
            return Collections.unmodifiableList(nativeGetSenders);
        }
        return (List) invokeV.objValue;
    }

    @Deprecated
    public boolean getStats(StatsObserver statsObserver, @Nullable MediaStreamTrack mediaStreamTrack) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, statsObserver, mediaStreamTrack)) == null) {
            return nativeOldGetStats(statsObserver, mediaStreamTrack == null ? 0L : mediaStreamTrack.getNativeMediaStreamTrack());
        }
        return invokeLL.booleanValue;
    }

    public List<RtpTransceiver> getTransceivers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            for (RtpTransceiver rtpTransceiver : this.transceivers) {
                rtpTransceiver.dispose();
            }
            List<RtpTransceiver> nativeGetTransceivers = nativeGetTransceivers();
            this.transceivers = nativeGetTransceivers;
            return Collections.unmodifiableList(nativeGetTransceivers);
        }
        return (List) invokeV.objValue;
    }

    public IceConnectionState iceConnectionState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? nativeIceConnectionState() : (IceConnectionState) invokeV.objValue;
    }

    public IceGatheringState iceGatheringState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? nativeIceGatheringState() : (IceGatheringState) invokeV.objValue;
    }

    public boolean removeIceCandidates(IceCandidate[] iceCandidateArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, iceCandidateArr)) == null) ? nativeRemoveIceCandidates(iceCandidateArr) : invokeL.booleanValue;
    }

    public void removeStream(MediaStream mediaStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, mediaStream) == null) {
            nativeRemoveLocalStream(mediaStream.getNativeMediaStream());
            this.localStreams.remove(mediaStream);
        }
    }

    public boolean removeTrack(RtpSender rtpSender) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, rtpSender)) == null) {
            if (rtpSender != null) {
                return nativeRemoveTrack(rtpSender.getNativeRtpSender());
            }
            throw new NullPointerException("No RtpSender specified for removeTrack.");
        }
        return invokeL.booleanValue;
    }

    public void setAudioPlayout(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            nativeSetAudioPlayout(z);
        }
    }

    public void setAudioRecording(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            nativeSetAudioRecording(z);
        }
    }

    public boolean setBitrate(Integer num, Integer num2, Integer num3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048608, this, num, num2, num3)) == null) ? nativeSetBitrate(num, num2, num3) : invokeLLL.booleanValue;
    }

    public boolean setConfiguration(RTCConfiguration rTCConfiguration) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, rTCConfiguration)) == null) ? nativeSetConfiguration(rTCConfiguration) : invokeL.booleanValue;
    }

    public void setLocalDescription(SdpObserver sdpObserver, SessionDescription sessionDescription) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, sdpObserver, sessionDescription) == null) {
            nativeSetLocalDescription(sdpObserver, sessionDescription);
        }
    }

    public void setRemoteDescription(SdpObserver sdpObserver, SessionDescription sessionDescription) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, sdpObserver, sessionDescription) == null) {
            nativeSetRemoteDescription(sdpObserver, sessionDescription);
        }
    }

    public SignalingState signalingState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? nativeSignalingState() : (SignalingState) invokeV.objValue;
    }

    public boolean startRtcEventLog(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048613, this, i2, i3)) == null) ? nativeStartRtcEventLog(i2, i3) : invokeII.booleanValue;
    }

    public void stopRtcEventLog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            nativeStopRtcEventLog();
        }
    }

    public PeerConnection(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.localStreams = new ArrayList();
        this.senders = new ArrayList();
        this.receivers = new ArrayList();
        this.transceivers = new ArrayList();
        this.nativePeerConnection = j;
    }

    public RtpSender addTrack(MediaStreamTrack mediaStreamTrack, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, mediaStreamTrack, list)) == null) {
            if (mediaStreamTrack != null && list != null) {
                RtpSender nativeAddTrack = nativeAddTrack(mediaStreamTrack.getNativeMediaStreamTrack(), list);
                if (nativeAddTrack != null) {
                    this.senders.add(nativeAddTrack);
                    return nativeAddTrack;
                }
                throw new IllegalStateException("C++ addTrack failed.");
            }
            throw new NullPointerException("No MediaStreamTrack specified in addTrack.");
        }
        return (RtpSender) invokeLL.objValue;
    }

    public RtpTransceiver addTransceiver(MediaStreamTrack mediaStreamTrack, @Nullable RtpTransceiver.RtpTransceiverInit rtpTransceiverInit) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, mediaStreamTrack, rtpTransceiverInit)) == null) {
            if (mediaStreamTrack != null) {
                if (rtpTransceiverInit == null) {
                    rtpTransceiverInit = new RtpTransceiver.RtpTransceiverInit();
                }
                RtpTransceiver nativeAddTransceiverWithTrack = nativeAddTransceiverWithTrack(mediaStreamTrack.getNativeMediaStreamTrack(), rtpTransceiverInit);
                if (nativeAddTransceiverWithTrack != null) {
                    this.transceivers.add(nativeAddTransceiverWithTrack);
                    return nativeAddTransceiverWithTrack;
                }
                throw new IllegalStateException("C++ addTransceiver failed.");
            }
            throw new NullPointerException("No MediaStreamTrack specified for addTransceiver.");
        }
        return (RtpTransceiver) invokeLL.objValue;
    }

    public void getStats(RTCStatsCollectorCallback rTCStatsCollectorCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, rTCStatsCollectorCallback) == null) {
            nativeNewGetStats(rTCStatsCollectorCallback);
        }
    }

    public RtpTransceiver addTransceiver(MediaStreamTrack.MediaType mediaType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, mediaType)) == null) ? addTransceiver(mediaType, new RtpTransceiver.RtpTransceiverInit()) : (RtpTransceiver) invokeL.objValue;
    }

    public RtpTransceiver addTransceiver(MediaStreamTrack.MediaType mediaType, @Nullable RtpTransceiver.RtpTransceiverInit rtpTransceiverInit) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, mediaType, rtpTransceiverInit)) == null) {
            if (mediaType != null) {
                if (rtpTransceiverInit == null) {
                    rtpTransceiverInit = new RtpTransceiver.RtpTransceiverInit();
                }
                RtpTransceiver nativeAddTransceiverOfType = nativeAddTransceiverOfType(mediaType, rtpTransceiverInit);
                if (nativeAddTransceiverOfType != null) {
                    this.transceivers.add(nativeAddTransceiverOfType);
                    return nativeAddTransceiverOfType;
                }
                throw new IllegalStateException("C++ addTransceiver failed.");
            }
            throw new NullPointerException("No MediaType specified for addTransceiver.");
        }
        return (RtpTransceiver) invokeLL.objValue;
    }
}
