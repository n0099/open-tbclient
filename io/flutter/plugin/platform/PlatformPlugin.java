package io.flutter.plugin.platform;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.Log;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import java.io.FileNotFoundException;
import java.util.List;
/* loaded from: classes3.dex */
public class PlatformPlugin {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_SYSTEM_UI = 1280;
    public static final String TAG = "PlatformPlugin";
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity activity;
    public PlatformChannel.SystemChromeStyle currentTheme;
    public int mEnabledOverlays;
    @VisibleForTesting
    public final PlatformChannel.PlatformMessageHandler mPlatformMessageHandler;
    public final PlatformChannel platformChannel;
    public final PlatformPluginDelegate platformPluginDelegate;

    /* renamed from: io.flutter.plugin.platform.PlatformPlugin$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness;
        public static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType;
        public static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2044213078, "Lio/flutter/plugin/platform/PlatformPlugin$3;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2044213078, "Lio/flutter/plugin/platform/PlatformPlugin$3;");
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

    /* loaded from: classes3.dex */
    public interface PlatformPluginDelegate {
        boolean popSystemNavigator();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PlatformPlugin(Activity activity, PlatformChannel platformChannel) {
        this(activity, platformChannel, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, platformChannel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Activity) objArr2[0], (PlatformChannel) objArr2[1], (PlatformPluginDelegate) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean clipboardHasStrings() {
        InterceptResult invokeV;
        ClipDescription primaryClipDescription;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            ClipboardManager clipboardManager = (ClipboardManager) this.activity.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
            if (clipboardManager.hasPrimaryClip() && (primaryClipDescription = clipboardManager.getPrimaryClipDescription()) != null) {
                return primaryClipDescription.hasMimeType("text/*");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CharSequence getClipboardData(PlatformChannel.ClipboardContentFormat clipboardContentFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, clipboardContentFormat)) == null) {
            ClipboardManager clipboardManager = (ClipboardManager) this.activity.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
            if (clipboardManager.hasPrimaryClip()) {
                try {
                    ClipData primaryClip = clipboardManager.getPrimaryClip();
                    if (primaryClip == null) {
                        return null;
                    }
                    if (clipboardContentFormat != null && clipboardContentFormat != PlatformChannel.ClipboardContentFormat.PLAIN_TEXT) {
                        return null;
                    }
                    ClipData.Item itemAt = primaryClip.getItemAt(0);
                    if (itemAt.getUri() != null) {
                        this.activity.getContentResolver().openTypedAssetFileDescriptor(itemAt.getUri(), "text/*", null);
                    }
                    return itemAt.coerceToText(this.activity);
                } catch (FileNotFoundException unused) {
                    return null;
                } catch (SecurityException e2) {
                    Log.w(TAG, "Attempted to get clipboard data that requires additional permission(s).\nSee the exception details for which permission(s) are required, and consider adding them to your Android Manifest as described in:\nhttps://developer.android.com/guide/topics/permissions/overview", e2);
                    return null;
                }
            }
            return null;
        }
        return (CharSequence) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playSystemSound(PlatformChannel.SoundType soundType) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65553, this, soundType) == null) && soundType == PlatformChannel.SoundType.CLICK) {
            this.activity.getWindow().getDecorView().playSoundEffect(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void popSystemNavigator() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            PlatformPluginDelegate platformPluginDelegate = this.platformPluginDelegate;
            if (platformPluginDelegate == null || !platformPluginDelegate.popSystemNavigator()) {
                Activity activity = this.activity;
                if (activity instanceof OnBackPressedDispatcherOwner) {
                    ((OnBackPressedDispatcherOwner) activity).getOnBackPressedDispatcher().onBackPressed();
                } else {
                    activity.finish();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restoreSystemChromeSystemUIOverlays() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            updateSystemUiOverlays();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClipboardData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, str) == null) {
            ((ClipboardManager) this.activity.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setPrimaryClip(ClipData.newPlainText("text label?", str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSystemChromeApplicationSwitcherDescription(PlatformChannel.AppSwitcherDescription appSwitcherDescription) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65557, this, appSwitcherDescription) == null) || (i2 = Build.VERSION.SDK_INT) < 21) {
            return;
        }
        if (i2 < 28 && i2 > 21) {
            this.activity.setTaskDescription(new ActivityManager.TaskDescription(appSwitcherDescription.label, (Bitmap) null, appSwitcherDescription.color));
        }
        if (Build.VERSION.SDK_INT >= 28) {
            this.activity.setTaskDescription(new ActivityManager.TaskDescription(appSwitcherDescription.label, 0, appSwitcherDescription.color));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSystemChromeChangeListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            this.activity.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener(this) { // from class: io.flutter.plugin.platform.PlatformPlugin.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PlatformPlugin this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        if ((i2 & 4) == 0) {
                            this.this$0.platformChannel.systemChromeChanged(false);
                        } else {
                            this.this$0.platformChannel.systemChromeChanged(true);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSystemChromeEnabledSystemUIMode(PlatformChannel.SystemUiMode systemUiMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, systemUiMode) == null) {
            int i2 = 1798;
            if (systemUiMode != PlatformChannel.SystemUiMode.LEAN_BACK || Build.VERSION.SDK_INT < 16) {
                if (systemUiMode == PlatformChannel.SystemUiMode.IMMERSIVE && Build.VERSION.SDK_INT >= 19) {
                    i2 = 3846;
                } else if (systemUiMode == PlatformChannel.SystemUiMode.IMMERSIVE_STICKY && Build.VERSION.SDK_INT >= 19) {
                    i2 = 5894;
                } else if (systemUiMode == PlatformChannel.SystemUiMode.EDGE_TO_EDGE && Build.VERSION.SDK_INT >= 16) {
                    i2 = 1792;
                }
            }
            this.mEnabledOverlays = i2;
            updateSystemUiOverlays();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSystemChromeEnabledSystemUIOverlays(List<PlatformChannel.SystemUiOverlay> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, list) == null) {
            int i2 = (list.size() != 0 || Build.VERSION.SDK_INT < 19) ? 1798 : 5894;
            for (int i3 = 0; i3 < list.size(); i3++) {
                int i4 = AnonymousClass3.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay[list.get(i3).ordinal()];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setSystemChromePreferredOrientations(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65561, this, i2) == null) {
            this.activity.setRequestedOrientation(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSystemChromeSystemUIOverlayStyle(PlatformChannel.SystemChromeStyle systemChromeStyle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, this, systemChromeStyle) == null) {
            Window window = this.activity.getWindow();
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (Build.VERSION.SDK_INT >= 23) {
                PlatformChannel.Brightness brightness = systemChromeStyle.statusBarIconBrightness;
                if (brightness != null) {
                    int i2 = AnonymousClass3.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness[brightness.ordinal()];
                    if (i2 == 1) {
                        systemUiVisibility |= 8192;
                    } else if (i2 == 2) {
                        systemUiVisibility &= -8193;
                    }
                }
                Integer num = systemChromeStyle.statusBarColor;
                if (num != null) {
                    window.setStatusBarColor(num.intValue());
                }
            }
            boolean z = systemChromeStyle.systemStatusBarContrastEnforced;
            if (!z && Build.VERSION.SDK_INT >= 29) {
                window.setStatusBarContrastEnforced(z);
            }
            if (Build.VERSION.SDK_INT >= 26) {
                PlatformChannel.Brightness brightness2 = systemChromeStyle.systemNavigationBarIconBrightness;
                if (brightness2 != null) {
                    int i3 = AnonymousClass3.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness[brightness2.ordinal()];
                    if (i3 == 1) {
                        systemUiVisibility |= 16;
                    } else if (i3 == 2) {
                        systemUiVisibility &= -17;
                    }
                }
                Integer num2 = systemChromeStyle.systemNavigationBarColor;
                if (num2 != null) {
                    window.setNavigationBarColor(num2.intValue());
                }
            }
            if (systemChromeStyle.systemNavigationBarDividerColor != null && Build.VERSION.SDK_INT >= 28) {
                window.addFlags(Integer.MIN_VALUE);
                window.clearFlags(134217728);
                window.setNavigationBarDividerColor(systemChromeStyle.systemNavigationBarDividerColor.intValue());
            }
            boolean z2 = systemChromeStyle.systemNavigationBarContrastEnforced;
            if (!z2 && Build.VERSION.SDK_INT >= 29) {
                window.setNavigationBarContrastEnforced(z2);
            }
            decorView.setSystemUiVisibility(systemUiVisibility);
            this.currentTheme = systemChromeStyle;
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.platformChannel.setPlatformMessageHandler(null);
        }
    }

    public void updateSystemUiOverlays() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.activity.getWindow().getDecorView().setSystemUiVisibility(this.mEnabledOverlays);
            PlatformChannel.SystemChromeStyle systemChromeStyle = this.currentTheme;
            if (systemChromeStyle != null) {
                setSystemChromeSystemUIOverlayStyle(systemChromeStyle);
            }
        }
    }

    @VisibleForTesting
    public void vibrateHapticFeedback(PlatformChannel.HapticFeedbackType hapticFeedbackType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hapticFeedbackType) == null) {
            View decorView = this.activity.getWindow().getDecorView();
            int i2 = AnonymousClass3.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType[hapticFeedbackType.ordinal()];
            if (i2 == 1) {
                decorView.performHapticFeedback(0);
            } else if (i2 == 2) {
                decorView.performHapticFeedback(1);
            } else if (i2 == 3) {
                decorView.performHapticFeedback(3);
            } else if (i2 != 4) {
                if (i2 == 5 && Build.VERSION.SDK_INT >= 21) {
                    decorView.performHapticFeedback(4);
                }
            } else if (Build.VERSION.SDK_INT >= 23) {
                decorView.performHapticFeedback(6);
            }
        }
    }

    public PlatformPlugin(Activity activity, PlatformChannel platformChannel, PlatformPluginDelegate platformPluginDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, platformChannel, platformPluginDelegate};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        PlatformChannel.PlatformMessageHandler platformMessageHandler = new PlatformChannel.PlatformMessageHandler(this) { // from class: io.flutter.plugin.platform.PlatformPlugin.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PlatformPlugin this$0;

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
            public boolean clipboardHasStrings() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.this$0.clipboardHasStrings() : invokeV.booleanValue;
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public CharSequence getClipboardData(@Nullable PlatformChannel.ClipboardContentFormat clipboardContentFormat) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, clipboardContentFormat)) == null) ? this.this$0.getClipboardData(clipboardContentFormat) : (CharSequence) invokeL.objValue;
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
            public void setSystemUiChangeListener() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                    this.this$0.setSystemChromeChangeListener();
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
            public void showSystemUiMode(@NonNull PlatformChannel.SystemUiMode systemUiMode) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048587, this, systemUiMode) == null) {
                    this.this$0.setSystemChromeEnabledSystemUIMode(systemUiMode);
                }
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void vibrateHapticFeedback(@NonNull PlatformChannel.HapticFeedbackType hapticFeedbackType) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048588, this, hapticFeedbackType) == null) {
                    this.this$0.vibrateHapticFeedback(hapticFeedbackType);
                }
            }
        };
        this.mPlatformMessageHandler = platformMessageHandler;
        this.activity = activity;
        this.platformChannel = platformChannel;
        platformChannel.setPlatformMessageHandler(platformMessageHandler);
        this.platformPluginDelegate = platformPluginDelegate;
        this.mEnabledOverlays = 1280;
    }
}
