package io.flutter.embedding.engine.systemchannels;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompatJellybean;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.HorizontalTranslateLayout;
import com.baidu.adp.widget.VerticalTranslateLayout;
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
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
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
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation;
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
            int[] iArr = new int[SystemUiOverlay.values().length];
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay = iArr;
            try {
                iArr[SystemUiOverlay.TOP_OVERLAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay[SystemUiOverlay.BOTTOM_OVERLAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[DeviceOrientation.values().length];
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation = iArr2;
            try {
                iArr2[DeviceOrientation.PORTRAIT_UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[DeviceOrientation.PORTRAIT_DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[DeviceOrientation.LANDSCAPE_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[DeviceOrientation.LANDSCAPE_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes10.dex */
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
    /* loaded from: classes10.dex */
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
    /* loaded from: classes10.dex */
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
    /* loaded from: classes10.dex */
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
    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
    public interface PlatformMessageHandler {
        @Nullable
        CharSequence getClipboardData(@Nullable ClipboardContentFormat clipboardContentFormat);

        List<Rect> getSystemGestureExclusionRects();

        void playSystemSound(@NonNull SoundType soundType);

        void popSystemNavigator();

        void restoreSystemUiOverlays();

        void setApplicationSwitcherDescription(@NonNull AppSwitcherDescription appSwitcherDescription);

        void setClipboardData(@NonNull String str);

        void setPreferredOrientations(int i2);

        void setSystemGestureExclusionRects(@NonNull ArrayList<Rect> arrayList);

        void setSystemUiOverlayStyle(@NonNull SystemChromeStyle systemChromeStyle);

        void showSystemOverlays(@NonNull List<SystemUiOverlay> list);

        void vibrateHapticFeedback(@NonNull HapticFeedbackType hapticFeedbackType);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class SoundType {
        public static final /* synthetic */ SoundType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
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
            SoundType soundType = new SoundType("CLICK", 0, "SystemSoundType.click");
            CLICK = soundType;
            $VALUES = new SoundType[]{soundType};
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

    /* loaded from: classes10.dex */
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
        public final Integer systemNavigationBarDividerColor;
        @Nullable
        public final Brightness systemNavigationBarIconBrightness;

        public SystemChromeStyle(@Nullable Integer num, @Nullable Brightness brightness, @Nullable Integer num2, @Nullable Brightness brightness2, @Nullable Integer num3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {num, brightness, num2, brightness2, num3};
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
            this.systemNavigationBarColor = num2;
            this.systemNavigationBarIconBrightness = brightness2;
            this.systemNavigationBarDividerColor = num3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
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

            /* JADX WARN: Removed duplicated region for block: B:59:0x00fe A[Catch: JSONException -> 0x0229, TryCatch #5 {JSONException -> 0x0229, blocks: (B:8:0x0030, B:9:0x0034, B:49:0x00bb, B:50:0x00c0, B:51:0x00d4, B:53:0x00d8, B:57:0x00f2, B:59:0x00fe, B:60:0x010b, B:55:0x00dd, B:61:0x0110, B:63:0x0114, B:64:0x011d, B:65:0x0133, B:67:0x013f, B:68:0x0146, B:69:0x0151, B:77:0x0181, B:98:0x01f1, B:103:0x020d, B:76:0x0178, B:84:0x01a8, B:89:0x01c8, B:96:0x01e9, B:101:0x0205, B:106:0x0221, B:11:0x0039, B:14:0x0044, B:17:0x004f, B:20:0x005a, B:23:0x0064, B:26:0x006e, B:29:0x0079, B:32:0x0084, B:35:0x008e, B:38:0x0098, B:41:0x00a2, B:44:0x00ad, B:86:0x01b1), top: B:118:0x0030, inners: #0, #1, #6, #10 }] */
            /* JADX WARN: Removed duplicated region for block: B:60:0x010b A[Catch: JSONException -> 0x0229, TryCatch #5 {JSONException -> 0x0229, blocks: (B:8:0x0030, B:9:0x0034, B:49:0x00bb, B:50:0x00c0, B:51:0x00d4, B:53:0x00d8, B:57:0x00f2, B:59:0x00fe, B:60:0x010b, B:55:0x00dd, B:61:0x0110, B:63:0x0114, B:64:0x011d, B:65:0x0133, B:67:0x013f, B:68:0x0146, B:69:0x0151, B:77:0x0181, B:98:0x01f1, B:103:0x020d, B:76:0x0178, B:84:0x01a8, B:89:0x01c8, B:96:0x01e9, B:101:0x0205, B:106:0x0221, B:11:0x0039, B:14:0x0044, B:17:0x004f, B:20:0x005a, B:23:0x0064, B:26:0x006e, B:29:0x0079, B:32:0x0084, B:35:0x008e, B:38:0x0098, B:41:0x00a2, B:44:0x00ad, B:86:0x01b1), top: B:118:0x0030, inners: #0, #1, #6, #10 }] */
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
                                c2 = 7;
                                break;
                            }
                            break;
                        case -720677196:
                            if (str2.equals("Clipboard.setData")) {
                                c2 = 11;
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
                        case 96412730:
                            if (str2.equals("SystemGestures.getSystemGestureExclusionRects")) {
                                c2 = '\b';
                                break;
                            }
                            break;
                        case 232206254:
                            if (str2.equals("SystemGestures.setSystemGestureExclusionRects")) {
                                c2 = '\t';
                                break;
                            }
                            break;
                        case 241845679:
                            if (str2.equals("SystemChrome.restoreSystemUIOverlays")) {
                                c2 = 5;
                                break;
                            }
                            break;
                        case 1390477857:
                            if (str2.equals("SystemChrome.setSystemUIOverlayStyle")) {
                                c2 = 6;
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
                            this.this$0.platformMessageHandler.restoreSystemUiOverlays();
                            result.success(null);
                            return;
                        case 6:
                            try {
                                this.this$0.platformMessageHandler.setSystemUiOverlayStyle(this.this$0.decodeSystemChromeStyle((JSONObject) obj));
                                result.success(null);
                                return;
                            } catch (NoSuchFieldException | JSONException e7) {
                                result.error("error", e7.getMessage(), null);
                                return;
                            }
                        case 7:
                            this.this$0.platformMessageHandler.popSystemNavigator();
                            result.success(null);
                            return;
                        case '\b':
                            List<Rect> systemGestureExclusionRects = this.this$0.platformMessageHandler.getSystemGestureExclusionRects();
                            if (systemGestureExclusionRects == null) {
                                result.error("error", "Exclusion rects only exist for Android API 29+.", null);
                                return;
                            } else {
                                result.success(this.this$0.encodeExclusionRects(systemGestureExclusionRects));
                                return;
                            }
                        case '\t':
                            if (!(obj instanceof JSONArray)) {
                                result.error("inputTypeError", "Input type is incorrect. Ensure that a List<Map<String, int>> is passed as the input for SystemGestureExclusionRects.setSystemGestureExclusionRects.", null);
                                return;
                            }
                            this.this$0.platformMessageHandler.setSystemGestureExclusionRects(this.this$0.decodeExclusionRects((JSONArray) obj));
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
                        default:
                            result.notImplemented();
                            return;
                    }
                } catch (JSONException e8) {
                    result.error("error", "JSON error: " + e8.getMessage(), null);
                }
                result.error("error", "JSON error: " + e8.getMessage(), null);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, jSONObject)) == null) {
            int i2 = jSONObject.getInt("primaryColor");
            if (i2 != 0) {
                i2 |= -16777216;
            }
            return new AppSwitcherDescription(i2, jSONObject.getString(NotificationCompatJellybean.KEY_LABEL));
        }
        return (AppSwitcherDescription) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public ArrayList<Rect> decodeExclusionRects(@NonNull JSONArray jSONArray) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, jSONArray)) == null) {
            ArrayList<Rect> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                try {
                    arrayList.add(new Rect(jSONObject.getInt("left"), jSONObject.getInt(VerticalTranslateLayout.TOP), jSONObject.getInt(HorizontalTranslateLayout.RIGHT), jSONObject.getInt("bottom")));
                } catch (JSONException unused) {
                    throw new JSONException("Incorrect JSON data shape. To set system gesture exclusion rects, \na JSONObject with top, right, bottom and left values need to be set to int values.");
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0057 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int decodeOrientations(@NonNull JSONArray jSONArray) throws JSONException, NoSuchFieldException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, jSONArray)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, jSONObject)) == null) {
            Brightness fromValue = !jSONObject.isNull("systemNavigationBarIconBrightness") ? Brightness.fromValue(jSONObject.getString("systemNavigationBarIconBrightness")) : null;
            Integer valueOf = !jSONObject.isNull("systemNavigationBarColor") ? Integer.valueOf(jSONObject.getInt("systemNavigationBarColor")) : null;
            return new SystemChromeStyle(!jSONObject.isNull("statusBarColor") ? Integer.valueOf(jSONObject.getInt("statusBarColor")) : null, !jSONObject.isNull("statusBarIconBrightness") ? Brightness.fromValue(jSONObject.getString("statusBarIconBrightness")) : null, valueOf, fromValue, jSONObject.isNull("systemNavigationBarDividerColor") ? null : Integer.valueOf(jSONObject.getInt("systemNavigationBarDividerColor")));
        }
        return (SystemChromeStyle) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public List<SystemUiOverlay> decodeSystemUiOverlays(@NonNull JSONArray jSONArray) throws JSONException, NoSuchFieldException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, jSONArray)) == null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<HashMap<String, Integer>> encodeExclusionRects(List<Rect> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, list)) == null) {
            ArrayList<HashMap<String, Integer>> arrayList = new ArrayList<>();
            for (Rect rect : list) {
                HashMap<String, Integer> hashMap = new HashMap<>();
                hashMap.put(VerticalTranslateLayout.TOP, Integer.valueOf(rect.top));
                hashMap.put(HorizontalTranslateLayout.RIGHT, Integer.valueOf(rect.right));
                hashMap.put("bottom", Integer.valueOf(rect.bottom));
                hashMap.put("left", Integer.valueOf(rect.left));
                arrayList.add(hashMap);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void setPlatformMessageHandler(@Nullable PlatformMessageHandler platformMessageHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, platformMessageHandler) == null) {
            this.platformMessageHandler = platformMessageHandler;
        }
    }
}
