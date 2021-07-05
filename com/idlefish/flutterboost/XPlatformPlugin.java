package com.idlefish.flutterboost;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class XPlatformPlugin {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity activity;
    public PlatformChannel.SystemChromeStyle currentTheme;
    public int mEnabledOverlays;
    public PlatformChannel.PlatformMessageHandler mPlatformMessageHandler;
    public PlatformChannel platformChannel;

    /* renamed from: com.idlefish.flutterboost.XPlatformPlugin$2  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness;
        public static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType;
        public static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1693040622, "Lcom/idlefish/flutterboost/XPlatformPlugin$2;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1693040622, "Lcom/idlefish/flutterboost/XPlatformPlugin$2;");
                    return;
                }
            }
            int[] iArr = new int[PlatformChannel.Brightness.values().length];
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness = iArr;
            try {
                iArr[PlatformChannel.Brightness.DARK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness[PlatformChannel.Brightness.LIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[PlatformChannel.SystemUiOverlay.values().length];
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay = iArr2;
            try {
                iArr2[PlatformChannel.SystemUiOverlay.TOP_OVERLAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay[PlatformChannel.SystemUiOverlay.BOTTOM_OVERLAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[PlatformChannel.HapticFeedbackType.values().length];
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType = iArr3;
            try {
                iArr3[PlatformChannel.HapticFeedbackType.STANDARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType[PlatformChannel.HapticFeedbackType.LIGHT_IMPACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType[PlatformChannel.HapticFeedbackType.MEDIUM_IMPACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType[PlatformChannel.HapticFeedbackType.HEAVY_IMPACT.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType[PlatformChannel.HapticFeedbackType.SELECTION_CLICK.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public XPlatformPlugin(PlatformChannel platformChannel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {platformChannel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        PlatformChannel.PlatformMessageHandler platformMessageHandler = new PlatformChannel.PlatformMessageHandler(this) { // from class: com.idlefish.flutterboost.XPlatformPlugin.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ XPlatformPlugin this$0;

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

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public CharSequence getClipboardData(@Nullable PlatformChannel.ClipboardContentFormat clipboardContentFormat) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, clipboardContentFormat)) == null) ? this.this$0.getClipboardData(clipboardContentFormat) : (CharSequence) invokeL.objValue;
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public List<Rect> getSystemGestureExclusionRects() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.this$0.getSystemGestureExclusionRects() : (List) invokeV.objValue;
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void playSystemSound(@NonNull PlatformChannel.SoundType soundType) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, soundType) == null) {
                    this.this$0.playSystemSound(soundType);
                }
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void popSystemNavigator() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.this$0.popSystemNavigator();
                }
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void restoreSystemUiOverlays() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    this.this$0.restoreSystemChromeSystemUIOverlays();
                }
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void setApplicationSwitcherDescription(@NonNull PlatformChannel.AppSwitcherDescription appSwitcherDescription) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048581, this, appSwitcherDescription) == null) {
                    this.this$0.setSystemChromeApplicationSwitcherDescription(appSwitcherDescription);
                }
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void setClipboardData(@NonNull String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048582, this, str) == null) {
                    this.this$0.setClipboardData(str);
                }
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void setPreferredOrientations(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048583, this, i4) == null) {
                    this.this$0.setSystemChromePreferredOrientations(i4);
                }
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void setSystemGestureExclusionRects(@NonNull ArrayList<Rect> arrayList) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) {
                    this.this$0.setSystemGestureExclusionRects(arrayList);
                }
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void setSystemUiOverlayStyle(@NonNull PlatformChannel.SystemChromeStyle systemChromeStyle) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048585, this, systemChromeStyle) == null) {
                    this.this$0.setSystemChromeSystemUIOverlayStyle(systemChromeStyle);
                }
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void showSystemOverlays(@NonNull List<PlatformChannel.SystemUiOverlay> list) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048586, this, list) == null) {
                    this.this$0.setSystemChromeEnabledSystemUIOverlays(list);
                }
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void vibrateHapticFeedback(@NonNull PlatformChannel.HapticFeedbackType hapticFeedbackType) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048587, this, hapticFeedbackType) == null) {
                    this.this$0.vibrateHapticFeedback(hapticFeedbackType);
                }
            }
        };
        this.mPlatformMessageHandler = platformMessageHandler;
        this.platformChannel = platformChannel;
        platformChannel.setPlatformMessageHandler(platformMessageHandler);
        this.mEnabledOverlays = 1280;
    }

    public void attachToActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            this.activity = activity;
        }
    }

    public void detachActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) && activity == this.activity) {
            this.activity = null;
        }
    }

    public final CharSequence getClipboardData(PlatformChannel.ClipboardContentFormat clipboardContentFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, clipboardContentFormat)) == null) {
            ClipData primaryClip = ((ClipboardManager) this.activity.getSystemService("clipboard")).getPrimaryClip();
            if (primaryClip == null) {
                return null;
            }
            if (clipboardContentFormat == null || clipboardContentFormat == PlatformChannel.ClipboardContentFormat.PLAIN_TEXT) {
                return primaryClip.getItemAt(0).coerceToText(this.activity);
            }
            return null;
        }
        return (CharSequence) invokeL.objValue;
    }

    public final List<Rect> getSystemGestureExclusionRects() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (List) invokeV.objValue;
    }

    public final void playSystemSound(PlatformChannel.SoundType soundType) {
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, soundType) == null) && soundType == PlatformChannel.SoundType.CLICK && (activity = this.activity) != null) {
            activity.getWindow().getDecorView().playSoundEffect(0);
        }
    }

    public final void popSystemNavigator() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.activity.finish();
        }
    }

    public final void restoreSystemChromeSystemUIOverlays() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            updateSystemUiOverlays();
        }
    }

    public final void setClipboardData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            ((ClipboardManager) this.activity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", str));
        }
    }

    public final void setSystemChromeApplicationSwitcherDescription(PlatformChannel.AppSwitcherDescription appSwitcherDescription) {
        int i2;
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, appSwitcherDescription) == null) || (i2 = Build.VERSION.SDK_INT) < 21 || (activity = this.activity) == null) {
            return;
        }
        if (i2 < 28 && i2 > 21) {
            activity.setTaskDescription(new ActivityManager.TaskDescription(appSwitcherDescription.label, (Bitmap) null, appSwitcherDescription.color));
        }
        if (Build.VERSION.SDK_INT >= 28) {
            this.activity.setTaskDescription(new ActivityManager.TaskDescription(appSwitcherDescription.label, (Bitmap) null, appSwitcherDescription.color));
        }
    }

    public final void setSystemChromeEnabledSystemUIOverlays(List<PlatformChannel.SystemUiOverlay> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            int i2 = list.size() == 0 ? 5894 : 1798;
            for (int i3 = 0; i3 < list.size(); i3++) {
                int i4 = AnonymousClass2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay[list.get(i3).ordinal()];
                if (i4 == 1) {
                    i2 &= -5;
                } else if (i4 == 2) {
                    i2 = i2 & (-513) & (-3);
                }
            }
            this.mEnabledOverlays = i2;
            updateSystemUiOverlays();
        }
    }

    public final void setSystemChromePreferredOrientations(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.activity.setRequestedOrientation(i2);
        }
    }

    public final void setSystemChromeSystemUIOverlayStyle(PlatformChannel.SystemChromeStyle systemChromeStyle) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, systemChromeStyle) == null) || (activity = this.activity) == null) {
            return;
        }
        Window window = activity.getWindow();
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        if (Build.VERSION.SDK_INT >= 26) {
            PlatformChannel.Brightness brightness = systemChromeStyle.systemNavigationBarIconBrightness;
            if (brightness != null) {
                int i2 = AnonymousClass2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness[brightness.ordinal()];
                if (i2 == 1) {
                    systemUiVisibility |= 16;
                } else if (i2 == 2) {
                    systemUiVisibility &= -17;
                }
            }
            Integer num = systemChromeStyle.systemNavigationBarColor;
            if (num != null) {
                window.setNavigationBarColor(num.intValue());
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            PlatformChannel.Brightness brightness2 = systemChromeStyle.statusBarIconBrightness;
            if (brightness2 != null) {
                int i3 = AnonymousClass2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness[brightness2.ordinal()];
                if (i3 == 1) {
                    systemUiVisibility |= 8192;
                } else if (i3 == 2) {
                    systemUiVisibility &= -8193;
                }
            }
            Integer num2 = systemChromeStyle.statusBarColor;
            if (num2 != null) {
                window.setStatusBarColor(num2.intValue());
            }
        }
        Integer num3 = systemChromeStyle.systemNavigationBarDividerColor;
        decorView.setSystemUiVisibility(systemUiVisibility);
        this.currentTheme = systemChromeStyle;
    }

    public final void setSystemGestureExclusionRects(ArrayList<Rect> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, arrayList) == null) {
        }
    }

    public void updateSystemUiOverlays() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (activity = this.activity) == null) {
            return;
        }
        activity.getWindow().getDecorView().setSystemUiVisibility(this.mEnabledOverlays);
        PlatformChannel.SystemChromeStyle systemChromeStyle = this.currentTheme;
        if (systemChromeStyle != null) {
            setSystemChromeSystemUIOverlayStyle(systemChromeStyle);
        }
    }

    public final void vibrateHapticFeedback(PlatformChannel.HapticFeedbackType hapticFeedbackType) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, hapticFeedbackType) == null) || (activity = this.activity) == null) {
            return;
        }
        View decorView = activity.getWindow().getDecorView();
        int i2 = AnonymousClass2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType[hapticFeedbackType.ordinal()];
        if (i2 == 1) {
            decorView.performHapticFeedback(0);
        } else if (i2 == 2) {
            decorView.performHapticFeedback(1);
        } else if (i2 == 3) {
            decorView.performHapticFeedback(3);
        } else if (i2 == 4) {
            decorView.performHapticFeedback(6);
        } else if (i2 != 5) {
        } else {
            decorView.performHapticFeedback(4);
        }
    }
}
