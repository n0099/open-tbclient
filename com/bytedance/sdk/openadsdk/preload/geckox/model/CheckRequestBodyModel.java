package com.bytedance.sdk.openadsdk.preload.geckox.model;

import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.a.a.c;
import io.reactivex.annotations.SchedulerSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Keep
/* loaded from: classes6.dex */
public class CheckRequestBodyModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @c(a = "common")

    /* renamed from: common  reason: collision with root package name */
    public Common f32130common;
    @c(a = SchedulerSupport.CUSTOM)
    public Map<String, Map<String, Object>> custom;
    @c(a = "deployment")
    public Map<String, List<ChannelInfo>> deployment;
    @c(a = "deployments")
    public Map<String, Object> deployments;
    @c(a = "local")
    public Map<String, Map<String, LocalChannel>> local;

    @Keep
    /* loaded from: classes6.dex */
    public static class Channel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @c(a = "c")
        public String channelName;
        @c(a = "l_v")
        public String localVersion;

        public Channel(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.channelName = str;
        }
    }

    @Keep
    /* loaded from: classes6.dex */
    public static class ChannelInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @c(a = "channel")
        public String channel;
        @c(a = "local_version")
        public long localVersion;

        public ChannelInfo(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.channel = str;
            this.localVersion = j;
        }
    }

    @Keep
    /* loaded from: classes6.dex */
    public static class Channels {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @c(a = "channels")
        public List<Channel> channels;

        public Channels() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.channels = new ArrayList();
        }
    }

    @Keep
    /* loaded from: classes6.dex */
    public static class Group {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @c(a = "group_name")
        public String groupName;
        @c(a = "target_channels")
        public List<TargetChannel> targetChannels;

        public Group() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Keep
    /* loaded from: classes6.dex */
    public static final class GroupType {
        public static final /* synthetic */ GroupType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final GroupType HIGHPRIORITY;
        public static final GroupType NORMAL;
        public transient /* synthetic */ FieldHolder $fh;
        public String value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1259902351, "Lcom/bytedance/sdk/openadsdk/preload/geckox/model/CheckRequestBodyModel$GroupType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1259902351, "Lcom/bytedance/sdk/openadsdk/preload/geckox/model/CheckRequestBodyModel$GroupType;");
                    return;
                }
            }
            NORMAL = new GroupType("NORMAL", 0, "normal");
            GroupType groupType = new GroupType("HIGHPRIORITY", 1, "high_priority");
            HIGHPRIORITY = groupType;
            $VALUES = new GroupType[]{NORMAL, groupType};
        }

        public GroupType(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = str2;
        }

        public static GroupType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (GroupType) Enum.valueOf(GroupType.class, str) : (GroupType) invokeL.objValue;
        }

        public static GroupType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (GroupType[]) $VALUES.clone() : (GroupType[]) invokeV.objValue;
        }

        public String getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : (String) invokeV.objValue;
        }
    }

    @Keep
    /* loaded from: classes6.dex */
    public static class LocalChannel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @c(a = "l_v")
        public Long localVersion;

        public LocalChannel() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    @Keep
    /* loaded from: classes6.dex */
    public static class ProcessorParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @c(a = "domain")
        public String domain;

        public ProcessorParams() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    @Keep
    /* loaded from: classes6.dex */
    public static class TargetChannel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @c(a = "c")
        public String channelName;
        @c(a = "t_v")
        public Long targetVersion;

        public TargetChannel() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public TargetChannel(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.channelName = str;
        }

        public TargetChannel(String str, Long l) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, l};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.channelName = str;
            this.targetVersion = l;
        }
    }

    public CheckRequestBodyModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void putChannelInfo(String str, List<ChannelInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
            if (this.deployment == null) {
                this.deployment = new HashMap();
            }
            this.deployment.put(str, list);
        }
    }

    public void setCommon(Common common2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, common2) == null) {
            this.f32130common = common2;
        }
    }

    public void setCustom(Map<String, Map<String, Object>> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
            this.custom = map;
        }
    }

    public void setDeployments(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, map) == null) {
            this.deployments = map;
        }
    }

    public void setLocal(Map<String, Map<String, LocalChannel>> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, map) == null) {
            this.local = map;
        }
    }
}
