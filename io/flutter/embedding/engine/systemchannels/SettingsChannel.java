package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.controller.SensorController;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.JSONMessageCodec;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class SettingsChannel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ALWAYS_USE_24_HOUR_FORMAT = "alwaysUse24HourFormat";
    public static final String CHANNEL_NAME = "flutter/settings";
    public static final String PLATFORM_BRIGHTNESS = "platformBrightness";
    public static final String TAG = "SettingsChannel";
    public static final String TEXT_SCALE_FACTOR = "textScaleFactor";
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final BasicMessageChannel<Object> channel;

    /* loaded from: classes2.dex */
    public static class MessageBuilder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final BasicMessageChannel<Object> channel;
        @NonNull
        public Map<String, Object> message;

        public MessageBuilder(@NonNull BasicMessageChannel<Object> basicMessageChannel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {basicMessageChannel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.message = new HashMap();
            this.channel = basicMessageChannel;
        }

        public void send() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Log.v(SettingsChannel.TAG, "Sending message: \ntextScaleFactor: " + this.message.get(SettingsChannel.TEXT_SCALE_FACTOR) + "\nalwaysUse24HourFormat: " + this.message.get(SettingsChannel.ALWAYS_USE_24_HOUR_FORMAT) + "\nplatformBrightness: " + this.message.get(SettingsChannel.PLATFORM_BRIGHTNESS));
                this.channel.send(this.message);
            }
        }

        @NonNull
        public MessageBuilder setPlatformBrightness(@NonNull PlatformBrightness platformBrightness) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, platformBrightness)) == null) {
                this.message.put(SettingsChannel.PLATFORM_BRIGHTNESS, platformBrightness.name);
                return this;
            }
            return (MessageBuilder) invokeL.objValue;
        }

        @NonNull
        public MessageBuilder setTextScaleFactor(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2)) == null) {
                this.message.put(SettingsChannel.TEXT_SCALE_FACTOR, Float.valueOf(f2));
                return this;
            }
            return (MessageBuilder) invokeF.objValue;
        }

        @NonNull
        public MessageBuilder setUse24HourFormat(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.message.put(SettingsChannel.ALWAYS_USE_24_HOUR_FORMAT, Boolean.valueOf(z));
                return this;
            }
            return (MessageBuilder) invokeZ.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class PlatformBrightness {
        public static final /* synthetic */ PlatformBrightness[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final PlatformBrightness dark;
        public static final PlatformBrightness light;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public String name;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1638605656, "Lio/flutter/embedding/engine/systemchannels/SettingsChannel$PlatformBrightness;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1638605656, "Lio/flutter/embedding/engine/systemchannels/SettingsChannel$PlatformBrightness;");
                    return;
                }
            }
            light = new PlatformBrightness(SensorController.KEY_LIGHT, 0, SensorController.KEY_LIGHT);
            PlatformBrightness platformBrightness = new PlatformBrightness(SkinManager.SKIN_TYPE_STR_DARK, 1, SkinManager.SKIN_TYPE_STR_DARK);
            dark = platformBrightness;
            $VALUES = new PlatformBrightness[]{light, platformBrightness};
        }

        public PlatformBrightness(@NonNull String str, int i2, String str2) {
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
            this.name = str2;
        }

        public static PlatformBrightness valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PlatformBrightness) Enum.valueOf(PlatformBrightness.class, str) : (PlatformBrightness) invokeL.objValue;
        }

        public static PlatformBrightness[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PlatformBrightness[]) $VALUES.clone() : (PlatformBrightness[]) invokeV.objValue;
        }
    }

    public SettingsChannel(@NonNull DartExecutor dartExecutor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dartExecutor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.channel = new BasicMessageChannel<>(dartExecutor, CHANNEL_NAME, JSONMessageCodec.INSTANCE);
    }

    @NonNull
    public MessageBuilder startMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new MessageBuilder(this.channel) : (MessageBuilder) invokeV.objValue;
    }
}
