package io.flutter.plugin.platform;

import android.view.View;
import io.flutter.view.AccessibilityBridge;
/* loaded from: classes9.dex */
public interface PlatformViewsAccessibilityDelegate {
    void attachAccessibilityBridge(AccessibilityBridge accessibilityBridge);

    void detachAccessibiltyBridge();

    View getPlatformViewById(Integer num);
}
