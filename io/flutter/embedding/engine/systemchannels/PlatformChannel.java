package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.services.bos.BosClient;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class PlatformChannel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PlatformChannel";
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final MethodChannel channel;
    @NonNull
    @VisibleForTesting
    public final MethodChannel.MethodCallHandler parsingMethodCallHandler;
    @Nullable
    public PlatformMessageHandler platformMessageHandler;

    /* renamed from: io.flutter.embedding.engine.systemchannels.PlatformChannel$2  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation;
        public static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiMode;
        public static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-289360568, "Lio/flutter/embedding/engine/systemchannels/PlatformChannel$2;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-289360568, "Lio/flutter/embedding/engine/systemchannels/PlatformChannel$2;");
                    return;
                }
            }
            int[] iArr = new int[SystemUiMode.values().length];
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiMode = iArr;
            try {
                iArr[SystemUiMode.LEAN_BACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiMode[SystemUiMode.IMMERSIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiMode[SystemUiMode.IMMERSIVE_STICKY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiMode[SystemUiMode.EDGE_TO_EDGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[SystemUiOverlay.values().length];
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay = iArr2;
            try {
                iArr2[SystemUiOverlay.TOP_OVERLAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay[SystemUiOverlay.BOTTOM_OVERLAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[DeviceOrientation.values().length];
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation = iArr3;
            try {
                iArr3[DeviceOrientation.PORTRAIT_UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[DeviceOrientation.PORTRAIT_DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[DeviceOrientation.LANDSCAPE_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[DeviceOrientation.LANDSCAPE_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class AppSwitcherDescription {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int color;
        @NonNull
        public final String label;

        public AppSwitcherDescription(int i2, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.color = i2;
            this.label = str;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class Brightness {
        public static final /* synthetic */ Brightness[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Brightness DARK;
        public static final Brightness LIGHT;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public String encodedName;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-94911029, "Lio/flutter/embedding/engine/systemchannels/PlatformChannel$Brightness;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-94911029, "Lio/flutter/embedding/engine/systemchannels/PlatformChannel$Brightness;");
                    return;
                }
            }
            LIGHT = new Brightness("LIGHT", 0, "Brightness.light");
            Brightness brightness = new Brightness("DARK", 1, "Brightness.dark");
            DARK = brightness;
            $VALUES = new Brightness[]{LIGHT, brightness};
        }

        public Brightness(@NonNull String str, int i2, String str2) {
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
            this.encodedName = str2;
        }

        @NonNull
        public static Brightness fromValue(@NonNull String str) throws NoSuchFieldException {
            InterceptResult invokeL;
            Brightness[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                for (Brightness brightness : values()) {
                    if (brightness.encodedName.equals(str)) {
                        return brightness;
                    }
                }
                throw new NoSuchFieldException("No such Brightness: " + str);
            }
            return (Brightness) invokeL.objValue;
        }

        public static Brightness valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (Brightness) Enum.valueOf(Brightness.class, str) : (Brightness) invokeL.objValue;
        }

        public static Brightness[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (Brightness[]) $VALUES.clone() : (Brightness[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class ClipboardContentFormat {
        public static final /* synthetic */ ClipboardContentFormat[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ClipboardContentFormat PLAIN_TEXT;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public String encodedName;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(517085666, "Lio/flutter/embedding/engine/systemchannels/PlatformChannel$ClipboardContentFormat;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(517085666, "Lio/flutter/embedding/engine/systemchannels/PlatformChannel$ClipboardContentFormat;");
                    return;
                }
            }
            ClipboardContentFormat clipboardContentFormat = new ClipboardContentFormat("PLAIN_TEXT", 0, "text/plain");
            PLAIN_TEXT = clipboardContentFormat;
            $VALUES = new ClipboardContentFormat[]{clipboardContentFormat};
        }

        public ClipboardContentFormat(@NonNull String str, int i2, String str2) {
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
            this.encodedName = str2;
        }

        @NonNull
        public static ClipboardContentFormat fromValue(@NonNull String str) throws NoSuchFieldException {
            InterceptResult invokeL;
            ClipboardContentFormat[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                for (ClipboardContentFormat clipboardContentFormat : values()) {
                    if (clipboardContentFormat.encodedName.equals(str)) {
                        return clipboardContentFormat;
                    }
                }
                throw new NoSuchFieldException("No such ClipboardContentFormat: " + str);
            }
            return (ClipboardContentFormat) invokeL.objValue;
        }

        public static ClipboardContentFormat valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (ClipboardContentFormat) Enum.valueOf(ClipboardContentFormat.class, str) : (ClipboardContentFormat) invokeL.objValue;
        }

        public static ClipboardContentFormat[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (ClipboardContentFormat[]) $VALUES.clone() : (ClipboardContentFormat[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class DeviceOrientation {
        public static final /* synthetic */ DeviceOrientation[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DeviceOrientation LANDSCAPE_LEFT;
        public static final DeviceOrientation LANDSCAPE_RIGHT;
        public static final DeviceOrientation PORTRAIT_DOWN;
        public static final DeviceOrientation PORTRAIT_UP;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public String encodedName;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(860222208, "Lio/flutter/embedding/engine/systemchannels/PlatformChannel$DeviceOrientation;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(860222208, "Lio/flutter/embedding/engine/systemchannels/PlatformChannel$DeviceOrientation;");
                    return;
                }
            }
            PORTRAIT_UP = new DeviceOrientation("PORTRAIT_UP", 0, "DeviceOrientation.portraitUp");
            PORTRAIT_DOWN = new DeviceOrientation("PORTRAIT_DOWN", 1, "DeviceOrientation.portraitDown");
            LANDSCAPE_LEFT = new DeviceOrientation("LANDSCAPE_LEFT", 2, "DeviceOrientation.landscapeLeft");
            DeviceOrientation deviceOrientation = new DeviceOrientation("LANDSCAPE_RIGHT", 3, "DeviceOrientation.landscapeRight");
            LANDSCAPE_RIGHT = deviceOrientation;
            $VALUES = new DeviceOrientation[]{PORTRAIT_UP, PORTRAIT_DOWN, LANDSCAPE_LEFT, deviceOrientation};
        }

        public DeviceOrientation(@NonNull String str, int i2, String str2) {
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
            this.encodedName = str2;
        }

        @NonNull
        public static DeviceOrientation fromValue(@NonNull String str) throws NoSuchFieldException {
            InterceptResult invokeL;
            DeviceOrientation[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                for (DeviceOrientation deviceOrientation : values()) {
                    if (deviceOrientation.encodedName.equals(str)) {
                        return deviceOrientation;
                    }
                }
                throw new NoSuchFieldException("No such DeviceOrientation: " + str);
            }
            return (DeviceOrientation) invokeL.objValue;
        }

        public static DeviceOrientation valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (DeviceOrientation) Enum.valueOf(DeviceOrientation.class, str) : (DeviceOrientation) invokeL.objValue;
        }

        public static DeviceOrientation[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (DeviceOrientation[]) $VALUES.clone() : (DeviceOrientation[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class HapticFeedbackType {
        public static final /* synthetic */ HapticFeedbackType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final HapticFeedbackType HEAVY_IMPACT;
        public static final HapticFeedbackType LIGHT_IMPACT;
        public static final HapticFeedbackType MEDIUM_IMPACT;
        public static final HapticFeedbackType SELECTION_CLICK;
        public static final HapticFeedbackType STANDARD;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public final String encodedName;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(544327974, "Lio/flutter/embedding/engine/systemchannels/PlatformChannel$HapticFeedbackType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(544327974, "Lio/flutter/embedding/engine/systemchannels/PlatformChannel$HapticFeedbackType;");
                    return;
                }
            }
            STANDARD = new HapticFeedbackType(BosClient.STORAGE_CLASS_STANDARD, 0, null);
            LIGHT_IMPACT = new HapticFeedbackType("LIGHT_IMPACT", 1, "HapticFeedbackType.lightImpact");
            MEDIUM_IMPACT = new HapticFeedbackType("MEDIUM_IMPACT", 2, "HapticFeedbackType.mediumImpact");
            HEAVY_IMPACT = new HapticFeedbackType("HEAVY_IMPACT", 3, "HapticFeedbackType.heavyImpact");
            HapticFeedbackType hapticFeedbackType = new HapticFeedbackType("SELECTION_CLICK", 4, "HapticFeedbackType.selectionClick");
            SELECTION_CLICK = hapticFeedbackType;
            $VALUES = new HapticFeedbackType[]{STANDARD, LIGHT_IMPACT, MEDIUM_IMPACT, HEAVY_IMPACT, hapticFeedbackType};
        }

        public HapticFeedbackType(@Nullable String str, int i2, String str2) {
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
            this.encodedName = str2;
        }

        @NonNull
        public static HapticFeedbackType fromValue(@Nullable String str) throws NoSuchFieldException {
            InterceptResult invokeL;
            HapticFeedbackType[] values;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                for (HapticFeedbackType hapticFeedbackType : values()) {
                    if ((hapticFeedbackType.encodedName == null && str == null) || ((str2 = hapticFeedbackType.encodedName) != null && str2.equals(str))) {
                        return hapticFeedbackType;
                    }
                }
                throw new NoSuchFieldException("No such HapticFeedbackType: " + str);
            }
            return (HapticFeedbackType) invokeL.objValue;
        }

        public static HapticFeedbackType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (HapticFeedbackType) Enum.valueOf(HapticFeedbackType.class, str) : (HapticFeedbackType) invokeL.objValue;
        }

        public static HapticFeedbackType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (HapticFeedbackType[]) $VALUES.clone() : (HapticFeedbackType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public interface PlatformMessageHandler {
        boolean clipboardHasStrings();

        @Nullable
        CharSequence getClipboardData(@Nullable ClipboardContentFormat clipboardContentFormat);

        void playSystemSound(@NonNull SoundType soundType);

        void popSystemNavigator();

        void restoreSystemUiOverlays();

        void setApplicationSwitcherDescription(@NonNull AppSwitcherDescription appSwitcherDescription);

        void setClipboardData(@NonNull String str);

        void setPreferredOrientations(int i2);

        void setSystemUiChangeListener();

        void setSystemUiOverlayStyle(@NonNull SystemChromeStyle systemChromeStyle);

        void showSystemOverlays(@NonNull List<SystemUiOverlay> list);

        void showSystemUiMode(@NonNull SystemUiMode systemUiMode);

        void vibrateHapticFeedback(@NonNull HapticFeedbackType hapticFeedbackType);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class SoundType {
        public static final /* synthetic */ SoundType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SoundType ALERT;
        public static final SoundType CLICK;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final String encodedName;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1003680623, "Lio/flutter/embedding/engine/systemchannels/PlatformChannel$SoundType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1003680623, "Lio/flutter/embedding/engine/systemchannels/PlatformChannel$SoundType;");
                    return;
                }
            }
            CLICK = new SoundType("CLICK", 0, "SystemSoundType.click");
            SoundType soundType = new SoundType("ALERT", 1, "SystemSoundType.alert");
            ALERT = soundType;
            $VALUES = new SoundType[]{CLICK, soundType};
        }

        public SoundType(@NonNull String str, int i2, String str2) {
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
            this.encodedName = str2;
        }

        @NonNull
        public static SoundType fromValue(@NonNull String str) throws NoSuchFieldException {
            InterceptResult invokeL;
            SoundType[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                for (SoundType soundType : values()) {
                    if (soundType.encodedName.equals(str)) {
                        return soundType;
                    }
                }
                throw new NoSuchFieldException("No such SoundType: " + str);
            }
            return (SoundType) invokeL.objValue;
        }

        public static SoundType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (SoundType) Enum.valueOf(SoundType.class, str) : (SoundType) invokeL.objValue;
        }

        public static SoundType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (SoundType[]) $VALUES.clone() : (SoundType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class SystemChromeStyle {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public final Integer statusBarColor;
        @Nullable
        public final Brightness statusBarIconBrightness;
        @Nullable
        public final Integer systemNavigationBarColor;
        @Nullable
        public final boolean systemNavigationBarContrastEnforced;
        @Nullable
        public final Integer systemNavigationBarDividerColor;
        @Nullable
        public final Brightness systemNavigationBarIconBrightness;
        @Nullable
        public final boolean systemStatusBarContrastEnforced;

        public SystemChromeStyle(@Nullable Integer num, @Nullable Brightness brightness, @Nullable boolean z, @Nullable Integer num2, @Nullable Brightness brightness2, @Nullable Integer num3, @Nullable boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {num, brightness, Boolean.valueOf(z), num2, brightness2, num3, Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.statusBarColor = num;
            this.statusBarIconBrightness = brightness;
            this.systemStatusBarContrastEnforced = z;
            this.systemNavigationBarColor = num2;
            this.systemNavigationBarIconBrightness = brightness2;
            this.systemNavigationBarDividerColor = num3;
            this.systemNavigationBarContrastEnforced = z2;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class SystemUiMode {
        public static final /* synthetic */ SystemUiMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SystemUiMode EDGE_TO_EDGE;
        public static final SystemUiMode IMMERSIVE;
        public static final SystemUiMode IMMERSIVE_STICKY;
        public static final SystemUiMode LEAN_BACK;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public String encodedName;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1325373206, "Lio/flutter/embedding/engine/systemchannels/PlatformChannel$SystemUiMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1325373206, "Lio/flutter/embedding/engine/systemchannels/PlatformChannel$SystemUiMode;");
                    return;
                }
            }
            LEAN_BACK = new SystemUiMode("LEAN_BACK", 0, "SystemUiMode.leanBack");
            IMMERSIVE = new SystemUiMode("IMMERSIVE", 1, "SystemUiMode.immersive");
            IMMERSIVE_STICKY = new SystemUiMode("IMMERSIVE_STICKY", 2, "SystemUiMode.immersiveSticky");
            SystemUiMode systemUiMode = new SystemUiMode("EDGE_TO_EDGE", 3, "SystemUiMode.edgeToEdge");
            EDGE_TO_EDGE = systemUiMode;
            $VALUES = new SystemUiMode[]{LEAN_BACK, IMMERSIVE, IMMERSIVE_STICKY, systemUiMode};
        }

        public SystemUiMode(@NonNull String str, int i2, String str2) {
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
            this.encodedName = str2;
        }

        @NonNull
        public static SystemUiMode fromValue(@NonNull String str) throws NoSuchFieldException {
            InterceptResult invokeL;
            SystemUiMode[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                for (SystemUiMode systemUiMode : values()) {
                    if (systemUiMode.encodedName.equals(str)) {
                        return systemUiMode;
                    }
                }
                throw new NoSuchFieldException("No such SystemUiMode: " + str);
            }
            return (SystemUiMode) invokeL.objValue;
        }

        public static SystemUiMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (SystemUiMode) Enum.valueOf(SystemUiMode.class, str) : (SystemUiMode) invokeL.objValue;
        }

        public static SystemUiMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (SystemUiMode[]) $VALUES.clone() : (SystemUiMode[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class SystemUiOverlay {
        public static final /* synthetic */ SystemUiOverlay[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SystemUiOverlay BOTTOM_OVERLAYS;
        public static final SystemUiOverlay TOP_OVERLAYS;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public String encodedName;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1709231373, "Lio/flutter/embedding/engine/systemchannels/PlatformChannel$SystemUiOverlay;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1709231373, "Lio/flutter/embedding/engine/systemchannels/PlatformChannel$SystemUiOverlay;");
                    return;
                }
            }
            TOP_OVERLAYS = new SystemUiOverlay("TOP_OVERLAYS", 0, "SystemUiOverlay.top");
            SystemUiOverlay systemUiOverlay = new SystemUiOverlay("BOTTOM_OVERLAYS", 1, "SystemUiOverlay.bottom");
            BOTTOM_OVERLAYS = systemUiOverlay;
            $VALUES = new SystemUiOverlay[]{TOP_OVERLAYS, systemUiOverlay};
        }

        public SystemUiOverlay(@NonNull String str, int i2, String str2) {
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
            this.encodedName = str2;
        }

        @NonNull
        public static SystemUiOverlay fromValue(@NonNull String str) throws NoSuchFieldException {
            InterceptResult invokeL;
            SystemUiOverlay[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                for (SystemUiOverlay systemUiOverlay : values()) {
                    if (systemUiOverlay.encodedName.equals(str)) {
                        return systemUiOverlay;
                    }
                }
                throw new NoSuchFieldException("No such SystemUiOverlay: " + str);
            }
            return (SystemUiOverlay) invokeL.objValue;
        }

        public static SystemUiOverlay valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (SystemUiOverlay) Enum.valueOf(SystemUiOverlay.class, str) : (SystemUiOverlay) invokeL.objValue;
        }

        public static SystemUiOverlay[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (SystemUiOverlay[]) $VALUES.clone() : (SystemUiOverlay[]) invokeV.objValue;
        }
    }

    public PlatformChannel(@NonNull DartExecutor dartExecutor) {
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
        this.parsingMethodCallHandler = new MethodChannel.MethodCallHandler(this) { // from class: io.flutter.embedding.engine.systemchannels.PlatformChannel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PlatformChannel this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX WARN: Removed duplicated region for block: B:63:0x0123 A[Catch: JSONException -> 0x023d, TryCatch #6 {JSONException -> 0x023d, blocks: (B:8:0x0030, B:9:0x0034, B:52:0x00c7, B:53:0x00cc, B:54:0x00e5, B:55:0x00f9, B:57:0x00fd, B:61:0x0117, B:63:0x0123, B:64:0x0130, B:59:0x0102, B:65:0x0135, B:73:0x0165, B:74:0x0173, B:102:0x0205, B:107:0x0221, B:72:0x015c, B:81:0x019a, B:88:0x01bc, B:93:0x01dc, B:100:0x01fd, B:105:0x0219, B:110:0x0235, B:11:0x0039, B:14:0x0044, B:17:0x004f, B:20:0x005b, B:23:0x0066, B:26:0x0070, B:29:0x007b, B:32:0x0085, B:35:0x008f, B:38:0x0099, B:41:0x00a3, B:44:0x00ad, B:47:0x00b8, B:90:0x01c5), top: B:122:0x0030, inners: #1, #2, #10, #12 }] */
            /* JADX WARN: Removed duplicated region for block: B:64:0x0130 A[Catch: JSONException -> 0x023d, TryCatch #6 {JSONException -> 0x023d, blocks: (B:8:0x0030, B:9:0x0034, B:52:0x00c7, B:53:0x00cc, B:54:0x00e5, B:55:0x00f9, B:57:0x00fd, B:61:0x0117, B:63:0x0123, B:64:0x0130, B:59:0x0102, B:65:0x0135, B:73:0x0165, B:74:0x0173, B:102:0x0205, B:107:0x0221, B:72:0x015c, B:81:0x019a, B:88:0x01bc, B:93:0x01dc, B:100:0x01fd, B:105:0x0219, B:110:0x0235, B:11:0x0039, B:14:0x0044, B:17:0x004f, B:20:0x005b, B:23:0x0066, B:26:0x0070, B:29:0x007b, B:32:0x0085, B:35:0x008f, B:38:0x0099, B:41:0x00a3, B:44:0x00ad, B:47:0x00b8, B:90:0x01c5), top: B:122:0x0030, inners: #1, #2, #10, #12 }] */
            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                String str;
                ClipboardContentFormat fromValue;
                CharSequence clipboardData;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLL(1048576, this, methodCall, result) == null) || this.this$0.platformMessageHandler == null) {
                    return;
                }
                String str2 = methodCall.method;
                Object obj = methodCall.arguments;
                Log.v(PlatformChannel.TAG, "Received '" + str2 + "' message.");
                char c2 = 65535;
                try {
                    switch (str2.hashCode()) {
                        case -766342101:
                            if (str2.equals("SystemNavigator.pop")) {
                                c2 = '\t';
                                break;
                            }
                            break;
                        case -720677196:
                            if (str2.equals("Clipboard.setData")) {
                                c2 = 11;
                                break;
                            }
                            break;
                        case -577225884:
                            if (str2.equals("SystemChrome.setSystemUIChangeListener")) {
                                c2 = 6;
                                break;
                            }
                            break;
                        case -548468504:
                            if (str2.equals("SystemChrome.setApplicationSwitcherDescription")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case -247230243:
                            if (str2.equals("HapticFeedback.vibrate")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case -215273374:
                            if (str2.equals("SystemSound.play")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 241845679:
                            if (str2.equals("SystemChrome.restoreSystemUIOverlays")) {
                                c2 = 7;
                                break;
                            }
                            break;
                        case 875995648:
                            if (str2.equals("Clipboard.hasStrings")) {
                                c2 = '\f';
                                break;
                            }
                            break;
                        case 1128339786:
                            if (str2.equals("SystemChrome.setEnabledSystemUIMode")) {
                                c2 = 5;
                                break;
                            }
                            break;
                        case 1390477857:
                            if (str2.equals("SystemChrome.setSystemUIOverlayStyle")) {
                                c2 = '\b';
                                break;
                            }
                            break;
                        case 1514180520:
                            if (str2.equals("Clipboard.getData")) {
                                c2 = '\n';
                                break;
                            }
                            break;
                        case 1674312266:
                            if (str2.equals("SystemChrome.setEnabledSystemUIOverlays")) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 2119655719:
                            if (str2.equals("SystemChrome.setPreferredOrientations")) {
                                c2 = 2;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            try {
                                this.this$0.platformMessageHandler.playSystemSound(SoundType.fromValue((String) obj));
                                result.success(null);
                                return;
                            } catch (NoSuchFieldException e2) {
                                result.error("error", e2.getMessage(), null);
                                return;
                            }
                        case 1:
                            try {
                                this.this$0.platformMessageHandler.vibrateHapticFeedback(HapticFeedbackType.fromValue((String) obj));
                                result.success(null);
                                return;
                            } catch (NoSuchFieldException e3) {
                                result.error("error", e3.getMessage(), null);
                                return;
                            }
                        case 2:
                            try {
                                this.this$0.platformMessageHandler.setPreferredOrientations(this.this$0.decodeOrientations((JSONArray) obj));
                                result.success(null);
                                return;
                            } catch (NoSuchFieldException | JSONException e4) {
                                result.error("error", e4.getMessage(), null);
                                return;
                            }
                        case 3:
                            try {
                                this.this$0.platformMessageHandler.setApplicationSwitcherDescription(this.this$0.decodeAppSwitcherDescription((JSONObject) obj));
                                result.success(null);
                                return;
                            } catch (JSONException e5) {
                                result.error("error", e5.getMessage(), null);
                                return;
                            }
                        case 4:
                            try {
                                this.this$0.platformMessageHandler.showSystemOverlays(this.this$0.decodeSystemUiOverlays((JSONArray) obj));
                                result.success(null);
                                return;
                            } catch (NoSuchFieldException | JSONException e6) {
                                result.error("error", e6.getMessage(), null);
                                return;
                            }
                        case 5:
                            try {
                                this.this$0.platformMessageHandler.showSystemUiMode(this.this$0.decodeSystemUiMode((String) obj));
                                result.success(null);
                                return;
                            } catch (NoSuchFieldException | JSONException e7) {
                                result.error("error", e7.getMessage(), null);
                                return;
                            }
                        case 6:
                            this.this$0.platformMessageHandler.setSystemUiChangeListener();
                            result.success(null);
                            return;
                        case 7:
                            this.this$0.platformMessageHandler.restoreSystemUiOverlays();
                            result.success(null);
                            return;
                        case '\b':
                            try {
                                this.this$0.platformMessageHandler.setSystemUiOverlayStyle(this.this$0.decodeSystemChromeStyle((JSONObject) obj));
                                result.success(null);
                                return;
                            } catch (NoSuchFieldException | JSONException e8) {
                                result.error("error", e8.getMessage(), null);
                                return;
                            }
                        case '\t':
                            this.this$0.platformMessageHandler.popSystemNavigator();
                            result.success(null);
                            return;
                        case '\n':
                            String str3 = (String) obj;
                            if (str3 != null) {
                                try {
                                    fromValue = ClipboardContentFormat.fromValue(str3);
                                } catch (NoSuchFieldException unused) {
                                    result.error("error", "No such clipboard content format: " + str, null);
                                }
                                clipboardData = this.this$0.platformMessageHandler.getClipboardData(fromValue);
                                if (clipboardData == null) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("text", clipboardData);
                                    result.success(jSONObject);
                                    return;
                                }
                                result.success(null);
                                return;
                            }
                            fromValue = null;
                            clipboardData = this.this$0.platformMessageHandler.getClipboardData(fromValue);
                            if (clipboardData == null) {
                            }
                        case 11:
                            this.this$0.platformMessageHandler.setClipboardData(((JSONObject) obj).getString("text"));
                            result.success(null);
                            return;
                        case '\f':
                            boolean clipboardHasStrings = this.this$0.platformMessageHandler.clipboardHasStrings();
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("value", clipboardHasStrings);
                            result.success(jSONObject2);
                            return;
                        default:
                            result.notImplemented();
                            return;
                    }
                } catch (JSONException e9) {
                    result.error("error", "JSON error: " + e9.getMessage(), null);
                }
                result.error("error", "JSON error: " + e9.getMessage(), null);
            }
        };
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/platform", JSONMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this.parsingMethodCallHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public AppSwitcherDescription decodeAppSwitcherDescription(@NonNull JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, jSONObject)) == null) {
            int i2 = jSONObject.getInt("primaryColor");
            if (i2 != 0) {
                i2 |= -16777216;
            }
            return new AppSwitcherDescription(i2, jSONObject.getString("label"));
        }
        return (AppSwitcherDescription) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0057 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int decodeOrientations(@NonNull JSONArray jSONArray) throws JSONException, NoSuchFieldException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, jSONArray)) == null) {
            boolean z = false;
            boolean z2 = false;
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                int i3 = AnonymousClass2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[DeviceOrientation.fromValue(jSONArray.getString(i2)).ordinal()];
                if (i3 == 1) {
                    z |= true;
                } else if (i3 == 2) {
                    z |= true;
                } else if (i3 == 3) {
                    z |= true;
                } else if (i3 == 4) {
                    z |= true;
                }
                if (!z2) {
                    z2 = z;
                }
            }
            if (z) {
                switch (z) {
                    case true:
                        return 0;
                    case true:
                    case true:
                    case true:
                    case true:
                    case true:
                    case true:
                    case true:
                        if (!z2) {
                            if (!z2) {
                                return !z2 ? 1 : 8;
                            }
                            return 9;
                        }
                        return 0;
                    case true:
                        return 9;
                    case true:
                        return 12;
                    case true:
                        return 8;
                    case true:
                        return 11;
                    case true:
                        return 2;
                    case true:
                        return 13;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public SystemChromeStyle decodeSystemChromeStyle(@NonNull JSONObject jSONObject) throws JSONException, NoSuchFieldException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, jSONObject)) == null) {
            return new SystemChromeStyle(!jSONObject.isNull("statusBarColor") ? Integer.valueOf(jSONObject.getInt("statusBarColor")) : null, !jSONObject.isNull("statusBarIconBrightness") ? Brightness.fromValue(jSONObject.getString("statusBarIconBrightness")) : null, !jSONObject.isNull("systemStatusBarContrastEnforced") ? jSONObject.getBoolean("systemStatusBarContrastEnforced") : true, !jSONObject.isNull("systemNavigationBarColor") ? Integer.valueOf(jSONObject.getInt("systemNavigationBarColor")) : null, !jSONObject.isNull("systemNavigationBarIconBrightness") ? Brightness.fromValue(jSONObject.getString("systemNavigationBarIconBrightness")) : null, jSONObject.isNull("systemNavigationBarDividerColor") ? null : Integer.valueOf(jSONObject.getInt("systemNavigationBarDividerColor")), !jSONObject.isNull("systemNavigationBarContrastEnforced") ? jSONObject.getBoolean("systemNavigationBarContrastEnforced") : true);
        }
        return (SystemChromeStyle) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public SystemUiMode decodeSystemUiMode(@NonNull String str) throws JSONException, NoSuchFieldException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, str)) == null) {
            int i2 = AnonymousClass2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiMode[SystemUiMode.fromValue(str).ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            return SystemUiMode.EDGE_TO_EDGE;
                        }
                        return SystemUiMode.EDGE_TO_EDGE;
                    }
                    return SystemUiMode.IMMERSIVE_STICKY;
                }
                return SystemUiMode.IMMERSIVE;
            }
            return SystemUiMode.LEAN_BACK;
        }
        return (SystemUiMode) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public List<SystemUiOverlay> decodeSystemUiOverlays(@NonNull JSONArray jSONArray) throws JSONException, NoSuchFieldException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, jSONArray)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                int i3 = AnonymousClass2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay[SystemUiOverlay.fromValue(jSONArray.getString(i2)).ordinal()];
                if (i3 == 1) {
                    arrayList.add(SystemUiOverlay.TOP_OVERLAYS);
                } else if (i3 == 2) {
                    arrayList.add(SystemUiOverlay.BOTTOM_OVERLAYS);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void setPlatformMessageHandler(@Nullable PlatformMessageHandler platformMessageHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, platformMessageHandler) == null) {
            this.platformMessageHandler = platformMessageHandler;
        }
    }

    public void systemChromeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            Log.v(TAG, "Sending 'systemUIChange' message.");
            this.channel.invokeMethod("SystemChrome.systemUIChange", Arrays.asList(Boolean.valueOf(z)));
        }
    }
}
