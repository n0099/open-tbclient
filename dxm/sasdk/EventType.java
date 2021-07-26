package dxm.sasdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class EventType {
    public static final /* synthetic */ EventType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final EventType PROFILE_APPEND;
    public static final EventType PROFILE_DELETE;
    public static final EventType PROFILE_INCREMENT;
    public static final EventType PROFILE_SET;
    public static final EventType PROFILE_SET_ONCE;
    public static final EventType PROFILE_UNSET;
    public static final EventType REGISTER_SUPER_PROPERTIES;
    public static final EventType TRACK;
    public static final EventType TRACK_SIGNUP;
    public transient /* synthetic */ FieldHolder $fh;
    public String eventType;
    public boolean profile;
    public boolean track;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1650972652, "Ldxm/sasdk/EventType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1650972652, "Ldxm/sasdk/EventType;");
                return;
            }
        }
        TRACK = new EventType("TRACK", 0, ARPScriptEnvironment.KEY_DATA_PIP_TRACK, true, false);
        TRACK_SIGNUP = new EventType("TRACK_SIGNUP", 1, "track_signup", true, false);
        PROFILE_SET = new EventType("PROFILE_SET", 2, "profile_set", false, true);
        PROFILE_SET_ONCE = new EventType("PROFILE_SET_ONCE", 3, "profile_set_once", false, true);
        PROFILE_UNSET = new EventType("PROFILE_UNSET", 4, "profile_unset", false, true);
        PROFILE_INCREMENT = new EventType("PROFILE_INCREMENT", 5, "profile_increment", false, true);
        PROFILE_APPEND = new EventType("PROFILE_APPEND", 6, "profile_append", false, true);
        PROFILE_DELETE = new EventType("PROFILE_DELETE", 7, "profile_delete", false, true);
        EventType eventType = new EventType("REGISTER_SUPER_PROPERTIES", 8, "register_super_properties", false, false);
        REGISTER_SUPER_PROPERTIES = eventType;
        $VALUES = new EventType[]{TRACK, TRACK_SIGNUP, PROFILE_SET, PROFILE_SET_ONCE, PROFILE_UNSET, PROFILE_INCREMENT, PROFILE_APPEND, PROFILE_DELETE, eventType};
    }

    public EventType(String str, int i2, String str2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2, Boolean.valueOf(z), Boolean.valueOf(z2)};
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
        this.eventType = str2;
        this.track = z;
        this.profile = z2;
    }

    public static EventType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EventType) Enum.valueOf(EventType.class, str) : (EventType) invokeL.objValue;
    }

    public static EventType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EventType[]) $VALUES.clone() : (EventType[]) invokeV.objValue;
    }

    public String getEventType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.eventType : (String) invokeV.objValue;
    }

    public boolean isProfile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.profile : invokeV.booleanValue;
    }

    public boolean isTrack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.track : invokeV.booleanValue;
    }
}
