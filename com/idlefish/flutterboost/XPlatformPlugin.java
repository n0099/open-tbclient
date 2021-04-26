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
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class XPlatformPlugin {
    public Activity activity;
    public PlatformChannel.SystemChromeStyle currentTheme;
    public int mEnabledOverlays;
    public PlatformChannel.PlatformMessageHandler mPlatformMessageHandler;
    public PlatformChannel platformChannel;

    /* renamed from: com.idlefish.flutterboost.XPlatformPlugin$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness;
        public static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType;
        public static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay;

        static {
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
        PlatformChannel.PlatformMessageHandler platformMessageHandler = new PlatformChannel.PlatformMessageHandler() { // from class: com.idlefish.flutterboost.XPlatformPlugin.1
            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public CharSequence getClipboardData(@Nullable PlatformChannel.ClipboardContentFormat clipboardContentFormat) {
                return XPlatformPlugin.this.getClipboardData(clipboardContentFormat);
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public List<Rect> getSystemGestureExclusionRects() {
                return XPlatformPlugin.this.getSystemGestureExclusionRects();
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void playSystemSound(@NonNull PlatformChannel.SoundType soundType) {
                XPlatformPlugin.this.playSystemSound(soundType);
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void popSystemNavigator() {
                XPlatformPlugin.this.popSystemNavigator();
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void restoreSystemUiOverlays() {
                XPlatformPlugin.this.restoreSystemChromeSystemUIOverlays();
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void setApplicationSwitcherDescription(@NonNull PlatformChannel.AppSwitcherDescription appSwitcherDescription) {
                XPlatformPlugin.this.setSystemChromeApplicationSwitcherDescription(appSwitcherDescription);
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void setClipboardData(@NonNull String str) {
                XPlatformPlugin.this.setClipboardData(str);
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void setPreferredOrientations(int i2) {
                XPlatformPlugin.this.setSystemChromePreferredOrientations(i2);
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void setSystemGestureExclusionRects(@NonNull ArrayList<Rect> arrayList) {
                XPlatformPlugin.this.setSystemGestureExclusionRects(arrayList);
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void setSystemUiOverlayStyle(@NonNull PlatformChannel.SystemChromeStyle systemChromeStyle) {
                XPlatformPlugin.this.setSystemChromeSystemUIOverlayStyle(systemChromeStyle);
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void showSystemOverlays(@NonNull List<PlatformChannel.SystemUiOverlay> list) {
                XPlatformPlugin.this.setSystemChromeEnabledSystemUIOverlays(list);
            }

            @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
            public void vibrateHapticFeedback(@NonNull PlatformChannel.HapticFeedbackType hapticFeedbackType) {
                XPlatformPlugin.this.vibrateHapticFeedback(hapticFeedbackType);
            }
        };
        this.mPlatformMessageHandler = platformMessageHandler;
        this.platformChannel = platformChannel;
        platformChannel.setPlatformMessageHandler(platformMessageHandler);
        this.mEnabledOverlays = 1280;
    }

    public void attachToActivity(Activity activity) {
        this.activity = activity;
    }

    public void detachActivity(Activity activity) {
        if (activity == this.activity) {
            this.activity = null;
        }
    }

    public final CharSequence getClipboardData(PlatformChannel.ClipboardContentFormat clipboardContentFormat) {
        ClipData primaryClip = ((ClipboardManager) this.activity.getSystemService("clipboard")).getPrimaryClip();
        if (primaryClip == null) {
            return null;
        }
        if (clipboardContentFormat == null || clipboardContentFormat == PlatformChannel.ClipboardContentFormat.PLAIN_TEXT) {
            return primaryClip.getItemAt(0).coerceToText(this.activity);
        }
        return null;
    }

    public final List<Rect> getSystemGestureExclusionRects() {
        return null;
    }

    public final void playSystemSound(PlatformChannel.SoundType soundType) {
        Activity activity;
        if (soundType != PlatformChannel.SoundType.CLICK || (activity = this.activity) == null) {
            return;
        }
        activity.getWindow().getDecorView().playSoundEffect(0);
    }

    public final void popSystemNavigator() {
        this.activity.finish();
    }

    public final void restoreSystemChromeSystemUIOverlays() {
        updateSystemUiOverlays();
    }

    public final void setClipboardData(String str) {
        ((ClipboardManager) this.activity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", str));
    }

    public final void setSystemChromeApplicationSwitcherDescription(PlatformChannel.AppSwitcherDescription appSwitcherDescription) {
        Activity activity;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 21 || (activity = this.activity) == null) {
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

    public final void setSystemChromePreferredOrientations(int i2) {
        this.activity.setRequestedOrientation(i2);
    }

    public final void setSystemChromeSystemUIOverlayStyle(PlatformChannel.SystemChromeStyle systemChromeStyle) {
        Activity activity = this.activity;
        if (activity == null) {
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
    }

    public void updateSystemUiOverlays() {
        Activity activity = this.activity;
        if (activity == null) {
            return;
        }
        activity.getWindow().getDecorView().setSystemUiVisibility(this.mEnabledOverlays);
        PlatformChannel.SystemChromeStyle systemChromeStyle = this.currentTheme;
        if (systemChromeStyle != null) {
            setSystemChromeSystemUIOverlayStyle(systemChromeStyle);
        }
    }

    public final void vibrateHapticFeedback(PlatformChannel.HapticFeedbackType hapticFeedbackType) {
        Activity activity = this.activity;
        if (activity == null) {
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
