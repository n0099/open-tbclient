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
/* loaded from: classes4.dex */
public class XPlatformPlugin {
    private Activity activity;
    private PlatformChannel.SystemChromeStyle currentTheme;
    private int mEnabledOverlays;
    private PlatformChannel.PlatformMessageHandler mPlatformMessageHandler = new PlatformChannel.PlatformMessageHandler() { // from class: com.idlefish.flutterboost.XPlatformPlugin.1
        @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
        public void playSystemSound(@NonNull PlatformChannel.SoundType soundType) {
            XPlatformPlugin.this.playSystemSound(soundType);
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
        public void vibrateHapticFeedback(@NonNull PlatformChannel.HapticFeedbackType hapticFeedbackType) {
            XPlatformPlugin.this.vibrateHapticFeedback(hapticFeedbackType);
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
        public void setPreferredOrientations(int i) {
            XPlatformPlugin.this.setSystemChromePreferredOrientations(i);
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
        public void setApplicationSwitcherDescription(@NonNull PlatformChannel.AppSwitcherDescription appSwitcherDescription) {
            XPlatformPlugin.this.setSystemChromeApplicationSwitcherDescription(appSwitcherDescription);
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
        public void showSystemOverlays(@NonNull List<PlatformChannel.SystemUiOverlay> list) {
            XPlatformPlugin.this.setSystemChromeEnabledSystemUIOverlays(list);
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
        public void restoreSystemUiOverlays() {
            XPlatformPlugin.this.restoreSystemChromeSystemUIOverlays();
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
        public void setSystemUiOverlayStyle(@NonNull PlatformChannel.SystemChromeStyle systemChromeStyle) {
            XPlatformPlugin.this.setSystemChromeSystemUIOverlayStyle(systemChromeStyle);
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
        public void popSystemNavigator() {
            XPlatformPlugin.this.popSystemNavigator();
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
        public CharSequence getClipboardData(@Nullable PlatformChannel.ClipboardContentFormat clipboardContentFormat) {
            return XPlatformPlugin.this.getClipboardData(clipboardContentFormat);
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
        public void setClipboardData(@NonNull String str) {
            XPlatformPlugin.this.setClipboardData(str);
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
        public List<Rect> getSystemGestureExclusionRects() {
            return XPlatformPlugin.this.getSystemGestureExclusionRects();
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
        public void setSystemGestureExclusionRects(@NonNull ArrayList<Rect> arrayList) {
            XPlatformPlugin.this.setSystemGestureExclusionRects(arrayList);
        }
    };
    private PlatformChannel platformChannel;

    public XPlatformPlugin(PlatformChannel platformChannel) {
        this.platformChannel = platformChannel;
        this.platformChannel.setPlatformMessageHandler(this.mPlatformMessageHandler);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void playSystemSound(PlatformChannel.SoundType soundType) {
        if (soundType == PlatformChannel.SoundType.CLICK) {
            this.activity.getWindow().getDecorView().playSoundEffect(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vibrateHapticFeedback(PlatformChannel.HapticFeedbackType hapticFeedbackType) {
        View decorView = this.activity.getWindow().getDecorView();
        switch (hapticFeedbackType) {
            case STANDARD:
                decorView.performHapticFeedback(0);
                return;
            case LIGHT_IMPACT:
                decorView.performHapticFeedback(1);
                return;
            case MEDIUM_IMPACT:
                decorView.performHapticFeedback(3);
                return;
            case HEAVY_IMPACT:
                decorView.performHapticFeedback(6);
                return;
            case SELECTION_CLICK:
                decorView.performHapticFeedback(4);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSystemChromePreferredOrientations(int i) {
        this.activity.setRequestedOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSystemChromeApplicationSwitcherDescription(PlatformChannel.AppSwitcherDescription appSwitcherDescription) {
        if (Build.VERSION.SDK_INT >= 21 && this.activity != null) {
            if (Build.VERSION.SDK_INT < 28 && Build.VERSION.SDK_INT > 21) {
                this.activity.setTaskDescription(new ActivityManager.TaskDescription(appSwitcherDescription.label, (Bitmap) null, appSwitcherDescription.color));
            }
            if (Build.VERSION.SDK_INT >= 28) {
                this.activity.setTaskDescription(new ActivityManager.TaskDescription(appSwitcherDescription.label, (Bitmap) null, appSwitcherDescription.color));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSystemChromeEnabledSystemUIOverlays(List<PlatformChannel.SystemUiOverlay> list) {
        int i = 1798;
        if (list.size() == 0) {
            i = 5894;
        }
        int i2 = i;
        for (int i3 = 0; i3 < list.size(); i3++) {
            switch (list.get(i3)) {
                case TOP_OVERLAYS:
                    i2 &= -5;
                    break;
                case BOTTOM_OVERLAYS:
                    i2 = i2 & (-513) & (-3);
                    break;
            }
        }
        this.mEnabledOverlays = i2;
        updateSystemUiOverlays();
    }

    public void updateSystemUiOverlays() {
        this.activity.getWindow().getDecorView().setSystemUiVisibility(this.mEnabledOverlays);
        if (this.currentTheme != null) {
            setSystemChromeSystemUIOverlayStyle(this.currentTheme);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restoreSystemChromeSystemUIOverlays() {
        updateSystemUiOverlays();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSystemChromeSystemUIOverlayStyle(PlatformChannel.SystemChromeStyle systemChromeStyle) {
        Window window = this.activity.getWindow();
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        if (Build.VERSION.SDK_INT >= 26) {
            if (systemChromeStyle.systemNavigationBarIconBrightness != null) {
                switch (systemChromeStyle.systemNavigationBarIconBrightness) {
                    case DARK:
                        systemUiVisibility |= 16;
                        break;
                    case LIGHT:
                        systemUiVisibility &= -17;
                        break;
                }
            }
            if (systemChromeStyle.systemNavigationBarColor != null) {
                window.setNavigationBarColor(systemChromeStyle.systemNavigationBarColor.intValue());
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (systemChromeStyle.statusBarIconBrightness != null) {
                switch (systemChromeStyle.statusBarIconBrightness) {
                    case DARK:
                        systemUiVisibility |= 8192;
                        break;
                    case LIGHT:
                        systemUiVisibility &= -8193;
                        break;
                }
            }
            if (systemChromeStyle.statusBarColor != null) {
                window.setStatusBarColor(systemChromeStyle.statusBarColor.intValue());
            }
        }
        if (systemChromeStyle.systemNavigationBarDividerColor != null) {
        }
        decorView.setSystemUiVisibility(systemUiVisibility);
        this.currentTheme = systemChromeStyle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void popSystemNavigator() {
        this.activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CharSequence getClipboardData(PlatformChannel.ClipboardContentFormat clipboardContentFormat) {
        ClipData primaryClip = ((ClipboardManager) this.activity.getSystemService("clipboard")).getPrimaryClip();
        if (primaryClip == null) {
            return null;
        }
        if (clipboardContentFormat == null || clipboardContentFormat == PlatformChannel.ClipboardContentFormat.PLAIN_TEXT) {
            return primaryClip.getItemAt(0).coerceToText(this.activity);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClipboardData(String str) {
        ((ClipboardManager) this.activity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Rect> getSystemGestureExclusionRects() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSystemGestureExclusionRects(ArrayList<Rect> arrayList) {
    }
}
