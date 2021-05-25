package io.flutter.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.net.Uri;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.google.android.material.chip.Chip;
import f.a.d.b;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate;
import io.flutter.util.Predicate;
import io.flutter.view.AccessibilityBridge;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public class AccessibilityBridge extends AccessibilityNodeProvider {
    public static final int ACTION_SHOW_ON_SCREEN = 16908342;
    public static int FIRST_RESOURCE_ID = 267386881;
    public static final int MIN_ENGINE_GENERATED_NODE_ID = 65536;
    public static final int ROOT_NODE_ID = 0;
    public static final float SCROLL_EXTENT_FOR_INFINITY = 100000.0f;
    public static final float SCROLL_POSITION_CAP_FOR_INFINITY = 70000.0f;
    public static final String TAG = "AccessibilityBridge";
    @NonNull
    public final AccessibilityChannel accessibilityChannel;
    @Nullable
    public SemanticsNode accessibilityFocusedSemanticsNode;
    @NonNull
    public final AccessibilityManager accessibilityManager;
    @NonNull
    public final AccessibilityViewEmbedder accessibilityViewEmbedder;
    @NonNull
    public final ContentResolver contentResolver;
    public Integer embeddedAccessibilityFocusedNodeId;
    public Integer embeddedInputFocusedNodeId;
    @Nullable
    public SemanticsNode hoveredObject;
    @Nullable
    public SemanticsNode inputFocusedSemanticsNode;
    @Nullable
    public SemanticsNode lastInputFocusedSemanticsNode;
    @Nullable
    public OnAccessibilityChangeListener onAccessibilityChangeListener;
    @NonNull
    public final PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate;
    @NonNull
    public final View rootAccessibilityView;
    @RequiresApi(19)
    @TargetApi(19)
    public final AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener;
    @NonNull
    public final Map<Integer, SemanticsNode> flutterSemanticsTree = new HashMap();
    @NonNull
    public final Map<Integer, CustomAccessibilityAction> customAccessibilityActions = new HashMap();
    public int accessibilityFeatureFlags = 0;
    @NonNull
    public final List<Integer> flutterNavigationStack = new ArrayList();
    public int previousRouteId = 0;
    @NonNull
    public Integer lastLeftFrameInset = 0;
    public final AccessibilityChannel.AccessibilityMessageHandler accessibilityMessageHandler = new AccessibilityChannel.AccessibilityMessageHandler() { // from class: io.flutter.view.AccessibilityBridge.1
        @Override // io.flutter.embedding.engine.systemchannels.AccessibilityChannel.AccessibilityMessageHandler
        public void announce(@NonNull String str) {
            AccessibilityBridge.this.rootAccessibilityView.announceForAccessibility(str);
        }

        @Override // io.flutter.embedding.engine.systemchannels.AccessibilityChannel.AccessibilityMessageHandler
        public void onLongPress(int i2) {
            AccessibilityBridge.this.sendAccessibilityEvent(i2, 2);
        }

        @Override // io.flutter.embedding.engine.systemchannels.AccessibilityChannel.AccessibilityMessageHandler
        public void onTap(int i2) {
            AccessibilityBridge.this.sendAccessibilityEvent(i2, 1);
        }

        @Override // io.flutter.embedding.engine.systemchannels.AccessibilityChannel.AccessibilityMessageHandler
        public void onTooltip(@NonNull String str) {
            AccessibilityEvent obtainAccessibilityEvent = AccessibilityBridge.this.obtainAccessibilityEvent(0, 32);
            obtainAccessibilityEvent.getText().add(str);
            AccessibilityBridge.this.sendAccessibilityEvent(obtainAccessibilityEvent);
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.AccessibilityDelegate
        public void updateCustomAccessibilityActions(ByteBuffer byteBuffer, String[] strArr) {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            AccessibilityBridge.this.updateCustomAccessibilityActions(byteBuffer, strArr);
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.AccessibilityDelegate
        public void updateSemantics(ByteBuffer byteBuffer, String[] strArr) {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            AccessibilityBridge.this.updateSemantics(byteBuffer, strArr);
        }
    };
    public final AccessibilityManager.AccessibilityStateChangeListener accessibilityStateChangeListener = new AccessibilityManager.AccessibilityStateChangeListener() { // from class: io.flutter.view.AccessibilityBridge.2
        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public void onAccessibilityStateChanged(boolean z) {
            if (z) {
                AccessibilityBridge.this.accessibilityChannel.setAccessibilityMessageHandler(AccessibilityBridge.this.accessibilityMessageHandler);
                AccessibilityBridge.this.accessibilityChannel.onAndroidAccessibilityEnabled();
            } else {
                AccessibilityBridge.this.accessibilityChannel.setAccessibilityMessageHandler(null);
                AccessibilityBridge.this.accessibilityChannel.onAndroidAccessibilityDisabled();
            }
            if (AccessibilityBridge.this.onAccessibilityChangeListener != null) {
                AccessibilityBridge.this.onAccessibilityChangeListener.onAccessibilityChanged(z, AccessibilityBridge.this.accessibilityManager.isTouchExplorationEnabled());
            }
        }
    };
    public final ContentObserver animationScaleObserver = new ContentObserver(new Handler()) { // from class: io.flutter.view.AccessibilityBridge.3
        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            onChange(z, null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            String string = Build.VERSION.SDK_INT < 17 ? null : Settings.Global.getString(AccessibilityBridge.this.contentResolver, "transition_animation_scale");
            if (string != null && string.equals("0")) {
                AccessibilityBridge.this.accessibilityFeatureFlags |= AccessibilityFeature.DISABLE_ANIMATIONS.value;
            } else {
                AccessibilityBridge.this.accessibilityFeatureFlags &= ~AccessibilityFeature.DISABLE_ANIMATIONS.value;
            }
            AccessibilityBridge.this.sendLatestAccessibilityFlagsToFlutter();
        }
    };

    /* loaded from: classes7.dex */
    public enum AccessibilityFeature {
        ACCESSIBLE_NAVIGATION(1),
        INVERT_COLORS(2),
        DISABLE_ANIMATIONS(4);
        
        public final int value;

        AccessibilityFeature(int i2) {
            this.value = i2;
        }
    }

    /* loaded from: classes7.dex */
    public enum Action {
        TAP(1),
        LONG_PRESS(2),
        SCROLL_LEFT(4),
        SCROLL_RIGHT(8),
        SCROLL_UP(16),
        SCROLL_DOWN(32),
        INCREASE(64),
        DECREASE(128),
        SHOW_ON_SCREEN(256),
        MOVE_CURSOR_FORWARD_BY_CHARACTER(512),
        MOVE_CURSOR_BACKWARD_BY_CHARACTER(1024),
        SET_SELECTION(2048),
        COPY(4096),
        CUT(8192),
        PASTE(16384),
        DID_GAIN_ACCESSIBILITY_FOCUS(32768),
        DID_LOSE_ACCESSIBILITY_FOCUS(65536),
        CUSTOM_ACTION(131072),
        DISMISS(262144),
        MOVE_CURSOR_FORWARD_BY_WORD(524288),
        MOVE_CURSOR_BACKWARD_BY_WORD(1048576);
        
        public final int value;

        Action(int i2) {
            this.value = i2;
        }
    }

    /* loaded from: classes7.dex */
    public static class CustomAccessibilityAction {
        public String hint;
        public String label;
        public int resourceId = -1;
        public int id = -1;
        public int overrideId = -1;
    }

    /* loaded from: classes7.dex */
    public enum Flag {
        HAS_CHECKED_STATE(1),
        IS_CHECKED(2),
        IS_SELECTED(4),
        IS_BUTTON(8),
        IS_TEXT_FIELD(16),
        IS_FOCUSED(32),
        HAS_ENABLED_STATE(64),
        IS_ENABLED(128),
        IS_IN_MUTUALLY_EXCLUSIVE_GROUP(256),
        IS_HEADER(512),
        IS_OBSCURED(1024),
        SCOPES_ROUTE(2048),
        NAMES_ROUTE(4096),
        IS_HIDDEN(8192),
        IS_IMAGE(16384),
        IS_LIVE_REGION(32768),
        HAS_TOGGLED_STATE(65536),
        IS_TOGGLED(131072),
        HAS_IMPLICIT_SCROLLING(262144),
        IS_READ_ONLY(1048576),
        IS_FOCUSABLE(2097152),
        IS_LINK(4194304);
        
        public final int value;

        Flag(int i2) {
            this.value = i2;
        }
    }

    /* loaded from: classes7.dex */
    public interface OnAccessibilityChangeListener {
        void onAccessibilityChanged(boolean z, boolean z2);
    }

    /* loaded from: classes7.dex */
    public static class SemanticsNode {
        public final AccessibilityBridge accessibilityBridge;
        public int actions;
        public float bottom;
        public int currentValueLength;
        public List<CustomAccessibilityAction> customAccessibilityActions;
        public String decreasedValue;
        public int flags;
        public Rect globalRect;
        public float[] globalTransform;
        public String hint;
        public String increasedValue;
        public float[] inverseTransform;
        public String label;
        public float left;
        public int maxValueLength;
        public CustomAccessibilityAction onLongPressOverride;
        public CustomAccessibilityAction onTapOverride;
        public SemanticsNode parent;
        public int platformViewId;
        public int previousActions;
        public int previousFlags;
        public String previousLabel;
        public float previousScrollExtentMax;
        public float previousScrollExtentMin;
        public float previousScrollPosition;
        public int previousTextSelectionBase;
        public int previousTextSelectionExtent;
        public String previousValue;
        public float right;
        public int scrollChildren;
        public float scrollExtentMax;
        public float scrollExtentMin;
        public int scrollIndex;
        public float scrollPosition;
        public TextDirection textDirection;
        public int textSelectionBase;
        public int textSelectionExtent;
        public float top;
        public float[] transform;
        public String value;
        public int id = -1;
        public boolean hadPreviousConfig = false;
        public List<SemanticsNode> childrenInTraversalOrder = new ArrayList();
        public List<SemanticsNode> childrenInHitTestOrder = new ArrayList();
        public boolean inverseTransformDirty = true;
        public boolean globalGeometryDirty = true;

        public SemanticsNode(@NonNull AccessibilityBridge accessibilityBridge) {
            this.accessibilityBridge = accessibilityBridge;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void collectRoutes(List<SemanticsNode> list) {
            if (hasFlag(Flag.SCOPES_ROUTE)) {
                list.add(this);
            }
            for (SemanticsNode semanticsNode : this.childrenInTraversalOrder) {
                semanticsNode.collectRoutes(list);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean didChangeLabel() {
            String str;
            if (this.label == null && this.previousLabel == null) {
                return false;
            }
            String str2 = this.label;
            return str2 == null || (str = this.previousLabel) == null || !str2.equals(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean didScroll() {
            return (Float.isNaN(this.scrollPosition) || Float.isNaN(this.previousScrollPosition) || this.previousScrollPosition == this.scrollPosition) ? false : true;
        }

        private void ensureInverseTransform() {
            if (this.inverseTransformDirty) {
                this.inverseTransformDirty = false;
                if (this.inverseTransform == null) {
                    this.inverseTransform = new float[16];
                }
                if (Matrix.invertM(this.inverseTransform, 0, this.transform, 0)) {
                    return;
                }
                Arrays.fill(this.inverseTransform, 0.0f);
            }
        }

        private SemanticsNode getAncestor(Predicate<SemanticsNode> predicate) {
            for (SemanticsNode semanticsNode = this.parent; semanticsNode != null; semanticsNode = semanticsNode.parent) {
                if (predicate.test(semanticsNode)) {
                    return semanticsNode;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Rect getGlobalRect() {
            return this.globalRect;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getRouteName() {
            String str;
            if (hasFlag(Flag.NAMES_ROUTE) && (str = this.label) != null && !str.isEmpty()) {
                return this.label;
            }
            for (SemanticsNode semanticsNode : this.childrenInTraversalOrder) {
                String routeName = semanticsNode.getRouteName();
                if (routeName != null && !routeName.isEmpty()) {
                    return routeName;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getValueLabelHint() {
            StringBuilder sb = new StringBuilder();
            String[] strArr = {this.value, this.label, this.hint};
            for (int i2 = 0; i2 < 3; i2++) {
                String str = strArr[i2];
                if (str != null && str.length() > 0) {
                    if (sb.length() > 0) {
                        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    }
                    sb.append(str);
                }
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hadAction(@NonNull Action action) {
            return (action.value & this.previousActions) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hadFlag(@NonNull Flag flag) {
            return (flag.value & this.previousFlags) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hasAction(@NonNull Action action) {
            return (action.value & this.actions) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hasFlag(@NonNull Flag flag) {
            return (flag.value & this.flags) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SemanticsNode hitTest(float[] fArr) {
            float f2 = fArr[3];
            float f3 = fArr[0] / f2;
            float f4 = fArr[1] / f2;
            if (f3 < this.left || f3 >= this.right || f4 < this.top || f4 >= this.bottom) {
                return null;
            }
            float[] fArr2 = new float[4];
            for (SemanticsNode semanticsNode : this.childrenInHitTestOrder) {
                if (!semanticsNode.hasFlag(Flag.IS_HIDDEN)) {
                    semanticsNode.ensureInverseTransform();
                    Matrix.multiplyMV(fArr2, 0, semanticsNode.inverseTransform, 0, fArr, 0);
                    SemanticsNode hitTest = semanticsNode.hitTest(fArr2);
                    if (hitTest != null) {
                        return hitTest;
                    }
                }
            }
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isFocusable() {
            String str;
            String str2;
            String str3;
            if (hasFlag(Flag.SCOPES_ROUTE)) {
                return false;
            }
            if (hasFlag(Flag.IS_FOCUSABLE)) {
                return true;
            }
            return (((~(((Action.SCROLL_RIGHT.value | Action.SCROLL_LEFT.value) | Action.SCROLL_UP.value) | Action.SCROLL_DOWN.value)) & this.actions) == 0 && this.flags == 0 && ((str = this.label) == null || str.isEmpty()) && (((str2 = this.value) == null || str2.isEmpty()) && ((str3 = this.hint) == null || str3.isEmpty()))) ? false : true;
        }

        private void log(@NonNull String str, boolean z) {
        }

        private float max(float f2, float f3, float f4, float f5) {
            return Math.max(f2, Math.max(f3, Math.max(f4, f5)));
        }

        private float min(float f2, float f3, float f4, float f5) {
            return Math.min(f2, Math.min(f3, Math.min(f4, f5)));
        }

        public static boolean nullableHasAncestor(SemanticsNode semanticsNode, Predicate<SemanticsNode> predicate) {
            return (semanticsNode == null || semanticsNode.getAncestor(predicate) == null) ? false : true;
        }

        private void transformPoint(float[] fArr, float[] fArr2, float[] fArr3) {
            Matrix.multiplyMV(fArr, 0, fArr2, 0, fArr3, 0);
            float f2 = fArr[3];
            fArr[0] = fArr[0] / f2;
            fArr[1] = fArr[1] / f2;
            fArr[2] = fArr[2] / f2;
            fArr[3] = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateRecursively(float[] fArr, Set<SemanticsNode> set, boolean z) {
            set.add(this);
            if (this.globalGeometryDirty) {
                z = true;
            }
            if (z) {
                if (this.globalTransform == null) {
                    this.globalTransform = new float[16];
                }
                Matrix.multiplyMM(this.globalTransform, 0, fArr, 0, this.transform, 0);
                float[] fArr2 = {this.left, this.top, 0.0f, 1.0f};
                float[] fArr3 = new float[4];
                float[] fArr4 = new float[4];
                float[] fArr5 = new float[4];
                float[] fArr6 = new float[4];
                transformPoint(fArr3, this.globalTransform, fArr2);
                fArr2[0] = this.right;
                fArr2[1] = this.top;
                transformPoint(fArr4, this.globalTransform, fArr2);
                fArr2[0] = this.right;
                fArr2[1] = this.bottom;
                transformPoint(fArr5, this.globalTransform, fArr2);
                fArr2[0] = this.left;
                fArr2[1] = this.bottom;
                transformPoint(fArr6, this.globalTransform, fArr2);
                if (this.globalRect == null) {
                    this.globalRect = new Rect();
                }
                this.globalRect.set(Math.round(min(fArr3[0], fArr4[0], fArr5[0], fArr6[0])), Math.round(min(fArr3[1], fArr4[1], fArr5[1], fArr6[1])), Math.round(max(fArr3[0], fArr4[0], fArr5[0], fArr6[0])), Math.round(max(fArr3[1], fArr4[1], fArr5[1], fArr6[1])));
                this.globalGeometryDirty = false;
            }
            for (SemanticsNode semanticsNode : this.childrenInTraversalOrder) {
                semanticsNode.updateRecursively(this.globalTransform, set, z);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateWith(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr) {
            this.hadPreviousConfig = true;
            this.previousValue = this.value;
            this.previousLabel = this.label;
            this.previousFlags = this.flags;
            this.previousActions = this.actions;
            this.previousTextSelectionBase = this.textSelectionBase;
            this.previousTextSelectionExtent = this.textSelectionExtent;
            this.previousScrollPosition = this.scrollPosition;
            this.previousScrollExtentMax = this.scrollExtentMax;
            this.previousScrollExtentMin = this.scrollExtentMin;
            this.flags = byteBuffer.getInt();
            this.actions = byteBuffer.getInt();
            this.maxValueLength = byteBuffer.getInt();
            this.currentValueLength = byteBuffer.getInt();
            this.textSelectionBase = byteBuffer.getInt();
            this.textSelectionExtent = byteBuffer.getInt();
            this.platformViewId = byteBuffer.getInt();
            this.scrollChildren = byteBuffer.getInt();
            this.scrollIndex = byteBuffer.getInt();
            this.scrollPosition = byteBuffer.getFloat();
            this.scrollExtentMax = byteBuffer.getFloat();
            this.scrollExtentMin = byteBuffer.getFloat();
            int i2 = byteBuffer.getInt();
            this.label = i2 == -1 ? null : strArr[i2];
            int i3 = byteBuffer.getInt();
            this.value = i3 == -1 ? null : strArr[i3];
            int i4 = byteBuffer.getInt();
            this.increasedValue = i4 == -1 ? null : strArr[i4];
            int i5 = byteBuffer.getInt();
            this.decreasedValue = i5 == -1 ? null : strArr[i5];
            int i6 = byteBuffer.getInt();
            this.hint = i6 == -1 ? null : strArr[i6];
            this.textDirection = TextDirection.fromInt(byteBuffer.getInt());
            this.left = byteBuffer.getFloat();
            this.top = byteBuffer.getFloat();
            this.right = byteBuffer.getFloat();
            this.bottom = byteBuffer.getFloat();
            if (this.transform == null) {
                this.transform = new float[16];
            }
            for (int i7 = 0; i7 < 16; i7++) {
                this.transform[i7] = byteBuffer.getFloat();
            }
            this.inverseTransformDirty = true;
            this.globalGeometryDirty = true;
            int i8 = byteBuffer.getInt();
            this.childrenInTraversalOrder.clear();
            this.childrenInHitTestOrder.clear();
            for (int i9 = 0; i9 < i8; i9++) {
                SemanticsNode orCreateSemanticsNode = this.accessibilityBridge.getOrCreateSemanticsNode(byteBuffer.getInt());
                orCreateSemanticsNode.parent = this;
                this.childrenInTraversalOrder.add(orCreateSemanticsNode);
            }
            for (int i10 = 0; i10 < i8; i10++) {
                SemanticsNode orCreateSemanticsNode2 = this.accessibilityBridge.getOrCreateSemanticsNode(byteBuffer.getInt());
                orCreateSemanticsNode2.parent = this;
                this.childrenInHitTestOrder.add(orCreateSemanticsNode2);
            }
            int i11 = byteBuffer.getInt();
            if (i11 == 0) {
                this.customAccessibilityActions = null;
                return;
            }
            List<CustomAccessibilityAction> list = this.customAccessibilityActions;
            if (list == null) {
                this.customAccessibilityActions = new ArrayList(i11);
            } else {
                list.clear();
            }
            for (int i12 = 0; i12 < i11; i12++) {
                CustomAccessibilityAction orCreateAccessibilityAction = this.accessibilityBridge.getOrCreateAccessibilityAction(byteBuffer.getInt());
                if (orCreateAccessibilityAction.overrideId != Action.TAP.value) {
                    if (orCreateAccessibilityAction.overrideId == Action.LONG_PRESS.value) {
                        this.onLongPressOverride = orCreateAccessibilityAction;
                    } else {
                        this.customAccessibilityActions.add(orCreateAccessibilityAction);
                    }
                } else {
                    this.onTapOverride = orCreateAccessibilityAction;
                }
                this.customAccessibilityActions.add(orCreateAccessibilityAction);
            }
        }
    }

    /* loaded from: classes7.dex */
    public enum TextDirection {
        UNKNOWN,
        LTR,
        RTL;

        public static TextDirection fromInt(int i2) {
            if (i2 != 1) {
                if (i2 != 2) {
                    return UNKNOWN;
                }
                return LTR;
            }
            return RTL;
        }
    }

    public AccessibilityBridge(@NonNull View view, @NonNull AccessibilityChannel accessibilityChannel, @NonNull final AccessibilityManager accessibilityManager, @NonNull ContentResolver contentResolver, PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate) {
        this.rootAccessibilityView = view;
        this.accessibilityChannel = accessibilityChannel;
        this.accessibilityManager = accessibilityManager;
        this.contentResolver = contentResolver;
        this.platformViewsAccessibilityDelegate = platformViewsAccessibilityDelegate;
        this.accessibilityStateChangeListener.onAccessibilityStateChanged(accessibilityManager.isEnabled());
        this.accessibilityManager.addAccessibilityStateChangeListener(this.accessibilityStateChangeListener);
        if (Build.VERSION.SDK_INT >= 19) {
            AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: io.flutter.view.AccessibilityBridge.4
                @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
                public void onTouchExplorationStateChanged(boolean z) {
                    if (z) {
                        AccessibilityBridge.this.accessibilityFeatureFlags |= AccessibilityFeature.ACCESSIBLE_NAVIGATION.value;
                    } else {
                        AccessibilityBridge.this.onTouchExplorationExit();
                        AccessibilityBridge.this.accessibilityFeatureFlags &= ~AccessibilityFeature.ACCESSIBLE_NAVIGATION.value;
                    }
                    AccessibilityBridge.this.sendLatestAccessibilityFlagsToFlutter();
                    if (AccessibilityBridge.this.onAccessibilityChangeListener != null) {
                        AccessibilityBridge.this.onAccessibilityChangeListener.onAccessibilityChanged(accessibilityManager.isEnabled(), z);
                    }
                }
            };
            this.touchExplorationStateChangeListener = touchExplorationStateChangeListener;
            touchExplorationStateChangeListener.onTouchExplorationStateChanged(accessibilityManager.isTouchExplorationEnabled());
            this.accessibilityManager.addTouchExplorationStateChangeListener(this.touchExplorationStateChangeListener);
        } else {
            this.touchExplorationStateChangeListener = null;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.animationScaleObserver.onChange(false);
            this.contentResolver.registerContentObserver(Settings.Global.getUriFor("transition_animation_scale"), false, this.animationScaleObserver);
        }
        if (platformViewsAccessibilityDelegate != null) {
            platformViewsAccessibilityDelegate.attachAccessibilityBridge(this);
        }
        this.accessibilityViewEmbedder = new AccessibilityViewEmbedder(view, 65536);
    }

    public static /* synthetic */ boolean a(SemanticsNode semanticsNode, SemanticsNode semanticsNode2) {
        return semanticsNode2 == semanticsNode;
    }

    private AccessibilityEvent createTextChangedEvent(int i2, String str, String str2) {
        AccessibilityEvent obtainAccessibilityEvent = obtainAccessibilityEvent(i2, 16);
        obtainAccessibilityEvent.setBeforeText(str);
        obtainAccessibilityEvent.getText().add(str2);
        int i3 = 0;
        while (i3 < str.length() && i3 < str2.length() && str.charAt(i3) == str2.charAt(i3)) {
            i3++;
        }
        if (i3 < str.length() || i3 < str2.length()) {
            obtainAccessibilityEvent.setFromIndex(i3);
            int length = str.length() - 1;
            int length2 = str2.length() - 1;
            while (length >= i3 && length2 >= i3 && str.charAt(length) == str2.charAt(length2)) {
                length--;
                length2--;
            }
            obtainAccessibilityEvent.setRemovedCount((length - i3) + 1);
            obtainAccessibilityEvent.setAddedCount((length2 - i3) + 1);
            return obtainAccessibilityEvent;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CustomAccessibilityAction getOrCreateAccessibilityAction(int i2) {
        CustomAccessibilityAction customAccessibilityAction = this.customAccessibilityActions.get(Integer.valueOf(i2));
        if (customAccessibilityAction == null) {
            CustomAccessibilityAction customAccessibilityAction2 = new CustomAccessibilityAction();
            customAccessibilityAction2.id = i2;
            customAccessibilityAction2.resourceId = FIRST_RESOURCE_ID + i2;
            this.customAccessibilityActions.put(Integer.valueOf(i2), customAccessibilityAction2);
            return customAccessibilityAction2;
        }
        return customAccessibilityAction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SemanticsNode getOrCreateSemanticsNode(int i2) {
        SemanticsNode semanticsNode = this.flutterSemanticsTree.get(Integer.valueOf(i2));
        if (semanticsNode == null) {
            SemanticsNode semanticsNode2 = new SemanticsNode(this);
            semanticsNode2.id = i2;
            this.flutterSemanticsTree.put(Integer.valueOf(i2), semanticsNode2);
            return semanticsNode2;
        }
        return semanticsNode;
    }

    private SemanticsNode getRootSemanticsNode() {
        return this.flutterSemanticsTree.get(0);
    }

    private void handleTouchExploration(float f2, float f3) {
        SemanticsNode hitTest;
        if (this.flutterSemanticsTree.isEmpty() || (hitTest = getRootSemanticsNode().hitTest(new float[]{f2, f3, 0.0f, 1.0f})) == this.hoveredObject) {
            return;
        }
        if (hitTest != null) {
            sendAccessibilityEvent(hitTest.id, 128);
        }
        SemanticsNode semanticsNode = this.hoveredObject;
        if (semanticsNode != null) {
            sendAccessibilityEvent(semanticsNode.id, 256);
        }
        this.hoveredObject = hitTest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AccessibilityEvent obtainAccessibilityEvent(int i2, int i3) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i3);
        obtain.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
        obtain.setSource(this.rootAccessibilityView, i2);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTouchExplorationExit() {
        SemanticsNode semanticsNode = this.hoveredObject;
        if (semanticsNode != null) {
            sendAccessibilityEvent(semanticsNode.id, 256);
            this.hoveredObject = null;
        }
    }

    @RequiresApi(18)
    @TargetApi(18)
    private boolean performCursorMoveAction(@NonNull SemanticsNode semanticsNode, int i2, @NonNull Bundle bundle, boolean z) {
        int i3 = bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT);
        boolean z2 = bundle.getBoolean(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN);
        if (i3 == 1) {
            if (!z || !semanticsNode.hasAction(Action.MOVE_CURSOR_FORWARD_BY_CHARACTER)) {
                if (z || !semanticsNode.hasAction(Action.MOVE_CURSOR_BACKWARD_BY_CHARACTER)) {
                    return false;
                }
                this.accessibilityChannel.dispatchSemanticsAction(i2, Action.MOVE_CURSOR_BACKWARD_BY_CHARACTER, Boolean.valueOf(z2));
                return true;
            }
            this.accessibilityChannel.dispatchSemanticsAction(i2, Action.MOVE_CURSOR_FORWARD_BY_CHARACTER, Boolean.valueOf(z2));
            return true;
        } else if (i3 != 2) {
            return false;
        } else {
            if (!z || !semanticsNode.hasAction(Action.MOVE_CURSOR_FORWARD_BY_WORD)) {
                if (z || !semanticsNode.hasAction(Action.MOVE_CURSOR_BACKWARD_BY_WORD)) {
                    return false;
                }
                this.accessibilityChannel.dispatchSemanticsAction(i2, Action.MOVE_CURSOR_BACKWARD_BY_WORD, Boolean.valueOf(z2));
                return true;
            }
            this.accessibilityChannel.dispatchSemanticsAction(i2, Action.MOVE_CURSOR_FORWARD_BY_WORD, Boolean.valueOf(z2));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAccessibilityEvent(int i2, int i3) {
        if (this.accessibilityManager.isEnabled()) {
            sendAccessibilityEvent(obtainAccessibilityEvent(i2, i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendLatestAccessibilityFlagsToFlutter() {
        this.accessibilityChannel.setAccessibilityFeatures(this.accessibilityFeatureFlags);
    }

    private void sendWindowChangeEvent(@NonNull SemanticsNode semanticsNode) {
        AccessibilityEvent obtainAccessibilityEvent = obtainAccessibilityEvent(semanticsNode.id, 32);
        obtainAccessibilityEvent.getText().add(semanticsNode.getRouteName());
        sendAccessibilityEvent(obtainAccessibilityEvent);
    }

    private void sendWindowContentChangeEvent(int i2) {
        AccessibilityEvent obtainAccessibilityEvent = obtainAccessibilityEvent(i2, 2048);
        if (Build.VERSION.SDK_INT >= 19) {
            obtainAccessibilityEvent.setContentChangeTypes(1);
        }
        sendAccessibilityEvent(obtainAccessibilityEvent);
    }

    private boolean shouldSetCollectionInfo(final SemanticsNode semanticsNode) {
        return semanticsNode.scrollChildren > 0 && (SemanticsNode.nullableHasAncestor(this.accessibilityFocusedSemanticsNode, new Predicate() { // from class: f.a.d.a
            @Override // io.flutter.util.Predicate
            public final boolean test(Object obj) {
                return AccessibilityBridge.a(AccessibilityBridge.SemanticsNode.this, (AccessibilityBridge.SemanticsNode) obj);
            }
        }) || !SemanticsNode.nullableHasAncestor(this.accessibilityFocusedSemanticsNode, b.f68277a));
    }

    private void willRemoveSemanticsNode(SemanticsNode semanticsNode) {
        semanticsNode.parent = null;
        SemanticsNode semanticsNode2 = this.accessibilityFocusedSemanticsNode;
        if (semanticsNode2 == semanticsNode) {
            sendAccessibilityEvent(semanticsNode2.id, 65536);
            this.accessibilityFocusedSemanticsNode = null;
        }
        if (this.inputFocusedSemanticsNode == semanticsNode) {
            this.inputFocusedSemanticsNode = null;
        }
        if (this.hoveredObject == semanticsNode) {
            this.hoveredObject = null;
        }
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    @SuppressLint({"NewApi"})
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i2) {
        int i3;
        SemanticsNode semanticsNode;
        if (i2 >= 65536) {
            return this.accessibilityViewEmbedder.createAccessibilityNodeInfo(i2);
        }
        boolean z = false;
        if (i2 == -1) {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(this.rootAccessibilityView);
            this.rootAccessibilityView.onInitializeAccessibilityNodeInfo(obtain);
            if (this.flutterSemanticsTree.containsKey(0)) {
                obtain.addChild(this.rootAccessibilityView, 0);
            }
            return obtain;
        }
        SemanticsNode semanticsNode2 = this.flutterSemanticsTree.get(Integer.valueOf(i2));
        if (semanticsNode2 == null) {
            return null;
        }
        if (semanticsNode2.platformViewId != -1) {
            return this.accessibilityViewEmbedder.getRootNode(this.platformViewsAccessibilityDelegate.getPlatformViewById(Integer.valueOf(semanticsNode2.platformViewId)), semanticsNode2.id, semanticsNode2.getGlobalRect());
        }
        AccessibilityNodeInfo obtain2 = AccessibilityNodeInfo.obtain(this.rootAccessibilityView, i2);
        if (Build.VERSION.SDK_INT >= 18) {
            obtain2.setViewIdResourceName("");
        }
        obtain2.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
        obtain2.setClassName("android.view.View");
        obtain2.setSource(this.rootAccessibilityView, i2);
        obtain2.setFocusable(semanticsNode2.isFocusable());
        SemanticsNode semanticsNode3 = this.inputFocusedSemanticsNode;
        if (semanticsNode3 != null) {
            obtain2.setFocused(semanticsNode3.id == i2);
        }
        SemanticsNode semanticsNode4 = this.accessibilityFocusedSemanticsNode;
        if (semanticsNode4 != null) {
            obtain2.setAccessibilityFocused(semanticsNode4.id == i2);
        }
        if (semanticsNode2.hasFlag(Flag.IS_TEXT_FIELD)) {
            obtain2.setPassword(semanticsNode2.hasFlag(Flag.IS_OBSCURED));
            if (!semanticsNode2.hasFlag(Flag.IS_READ_ONLY)) {
                obtain2.setClassName("android.widget.EditText");
            }
            if (Build.VERSION.SDK_INT >= 18) {
                obtain2.setEditable(!semanticsNode2.hasFlag(Flag.IS_READ_ONLY));
                if (semanticsNode2.textSelectionBase != -1 && semanticsNode2.textSelectionExtent != -1) {
                    obtain2.setTextSelection(semanticsNode2.textSelectionBase, semanticsNode2.textSelectionExtent);
                }
                if (Build.VERSION.SDK_INT > 18 && (semanticsNode = this.accessibilityFocusedSemanticsNode) != null && semanticsNode.id == i2) {
                    obtain2.setLiveRegion(1);
                }
            }
            if (semanticsNode2.hasAction(Action.MOVE_CURSOR_FORWARD_BY_CHARACTER)) {
                obtain2.addAction(256);
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (semanticsNode2.hasAction(Action.MOVE_CURSOR_BACKWARD_BY_CHARACTER)) {
                obtain2.addAction(512);
                i3 |= 1;
            }
            if (semanticsNode2.hasAction(Action.MOVE_CURSOR_FORWARD_BY_WORD)) {
                obtain2.addAction(256);
                i3 |= 2;
            }
            if (semanticsNode2.hasAction(Action.MOVE_CURSOR_BACKWARD_BY_WORD)) {
                obtain2.addAction(512);
                i3 |= 2;
            }
            obtain2.setMovementGranularities(i3);
            if (Build.VERSION.SDK_INT >= 21 && semanticsNode2.maxValueLength >= 0) {
                int length = semanticsNode2.value == null ? 0 : semanticsNode2.value.length();
                int unused = semanticsNode2.currentValueLength;
                int unused2 = semanticsNode2.maxValueLength;
                obtain2.setMaxTextLength((length - semanticsNode2.currentValueLength) + semanticsNode2.maxValueLength);
            }
        }
        if (Build.VERSION.SDK_INT > 18) {
            if (semanticsNode2.hasAction(Action.SET_SELECTION)) {
                obtain2.addAction(131072);
            }
            if (semanticsNode2.hasAction(Action.COPY)) {
                obtain2.addAction(16384);
            }
            if (semanticsNode2.hasAction(Action.CUT)) {
                obtain2.addAction(65536);
            }
            if (semanticsNode2.hasAction(Action.PASTE)) {
                obtain2.addAction(32768);
            }
        }
        if (semanticsNode2.hasFlag(Flag.IS_BUTTON) || semanticsNode2.hasFlag(Flag.IS_LINK)) {
            obtain2.setClassName(Chip.BUTTON_ACCESSIBILITY_CLASS_NAME);
        }
        if (semanticsNode2.hasFlag(Flag.IS_IMAGE)) {
            obtain2.setClassName("android.widget.ImageView");
        }
        if (Build.VERSION.SDK_INT > 18 && semanticsNode2.hasAction(Action.DISMISS)) {
            obtain2.setDismissable(true);
            obtain2.addAction(1048576);
        }
        if (semanticsNode2.parent != null) {
            obtain2.setParent(this.rootAccessibilityView, semanticsNode2.parent.id);
        } else {
            obtain2.setParent(this.rootAccessibilityView);
        }
        Rect globalRect = semanticsNode2.getGlobalRect();
        if (semanticsNode2.parent != null) {
            Rect globalRect2 = semanticsNode2.parent.getGlobalRect();
            Rect rect = new Rect(globalRect);
            rect.offset(-globalRect2.left, -globalRect2.top);
            obtain2.setBoundsInParent(rect);
        } else {
            obtain2.setBoundsInParent(globalRect);
        }
        obtain2.setBoundsInScreen(globalRect);
        obtain2.setVisibleToUser(true);
        obtain2.setEnabled(!semanticsNode2.hasFlag(Flag.HAS_ENABLED_STATE) || semanticsNode2.hasFlag(Flag.IS_ENABLED));
        if (semanticsNode2.hasAction(Action.TAP)) {
            if (Build.VERSION.SDK_INT >= 21 && semanticsNode2.onTapOverride != null) {
                obtain2.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, semanticsNode2.onTapOverride.hint));
                obtain2.setClickable(true);
            } else {
                obtain2.addAction(16);
                obtain2.setClickable(true);
            }
        }
        if (semanticsNode2.hasAction(Action.LONG_PRESS)) {
            if (Build.VERSION.SDK_INT >= 21 && semanticsNode2.onLongPressOverride != null) {
                obtain2.addAction(new AccessibilityNodeInfo.AccessibilityAction(32, semanticsNode2.onLongPressOverride.hint));
                obtain2.setLongClickable(true);
            } else {
                obtain2.addAction(32);
                obtain2.setLongClickable(true);
            }
        }
        if (semanticsNode2.hasAction(Action.SCROLL_LEFT) || semanticsNode2.hasAction(Action.SCROLL_UP) || semanticsNode2.hasAction(Action.SCROLL_RIGHT) || semanticsNode2.hasAction(Action.SCROLL_DOWN)) {
            obtain2.setScrollable(true);
            if (semanticsNode2.hasFlag(Flag.HAS_IMPLICIT_SCROLLING)) {
                if (!semanticsNode2.hasAction(Action.SCROLL_LEFT) && !semanticsNode2.hasAction(Action.SCROLL_RIGHT)) {
                    if (Build.VERSION.SDK_INT > 18 && shouldSetCollectionInfo(semanticsNode2)) {
                        obtain2.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(semanticsNode2.scrollChildren, 0, false));
                    } else {
                        obtain2.setClassName("android.widget.ScrollView");
                    }
                } else if (Build.VERSION.SDK_INT > 19 && shouldSetCollectionInfo(semanticsNode2)) {
                    obtain2.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(0, semanticsNode2.scrollChildren, false));
                } else {
                    obtain2.setClassName("android.widget.HorizontalScrollView");
                }
            }
            if (semanticsNode2.hasAction(Action.SCROLL_LEFT) || semanticsNode2.hasAction(Action.SCROLL_UP)) {
                obtain2.addAction(4096);
            }
            if (semanticsNode2.hasAction(Action.SCROLL_RIGHT) || semanticsNode2.hasAction(Action.SCROLL_DOWN)) {
                obtain2.addAction(8192);
            }
        }
        if (semanticsNode2.hasAction(Action.INCREASE) || semanticsNode2.hasAction(Action.DECREASE)) {
            obtain2.setClassName("android.widget.SeekBar");
            if (semanticsNode2.hasAction(Action.INCREASE)) {
                obtain2.addAction(4096);
            }
            if (semanticsNode2.hasAction(Action.DECREASE)) {
                obtain2.addAction(8192);
            }
        }
        if (semanticsNode2.hasFlag(Flag.IS_LIVE_REGION) && Build.VERSION.SDK_INT > 18) {
            obtain2.setLiveRegion(1);
        }
        boolean hasFlag = semanticsNode2.hasFlag(Flag.HAS_CHECKED_STATE);
        boolean hasFlag2 = semanticsNode2.hasFlag(Flag.HAS_TOGGLED_STATE);
        obtain2.setCheckable((hasFlag || hasFlag2) ? true : true);
        if (hasFlag) {
            obtain2.setChecked(semanticsNode2.hasFlag(Flag.IS_CHECKED));
            obtain2.setContentDescription(semanticsNode2.getValueLabelHint());
            if (semanticsNode2.hasFlag(Flag.IS_IN_MUTUALLY_EXCLUSIVE_GROUP)) {
                obtain2.setClassName("android.widget.RadioButton");
            } else {
                obtain2.setClassName("android.widget.CheckBox");
            }
        } else if (hasFlag2) {
            obtain2.setChecked(semanticsNode2.hasFlag(Flag.IS_TOGGLED));
            obtain2.setClassName(SwitchCompat.ACCESSIBILITY_EVENT_CLASS_NAME);
            obtain2.setContentDescription(semanticsNode2.getValueLabelHint());
        } else if (!semanticsNode2.hasFlag(Flag.SCOPES_ROUTE)) {
            obtain2.setText(semanticsNode2.getValueLabelHint());
        }
        obtain2.setSelected(semanticsNode2.hasFlag(Flag.IS_SELECTED));
        if (Build.VERSION.SDK_INT >= 28) {
            obtain2.setHeading(semanticsNode2.hasFlag(Flag.IS_HEADER));
        }
        SemanticsNode semanticsNode5 = this.accessibilityFocusedSemanticsNode;
        if (semanticsNode5 != null && semanticsNode5.id == i2) {
            obtain2.addAction(128);
        } else {
            obtain2.addAction(64);
        }
        if (Build.VERSION.SDK_INT >= 21 && semanticsNode2.customAccessibilityActions != null) {
            for (CustomAccessibilityAction customAccessibilityAction : semanticsNode2.customAccessibilityActions) {
                obtain2.addAction(new AccessibilityNodeInfo.AccessibilityAction(customAccessibilityAction.resourceId, customAccessibilityAction.label));
            }
        }
        for (SemanticsNode semanticsNode6 : semanticsNode2.childrenInTraversalOrder) {
            if (!semanticsNode6.hasFlag(Flag.IS_HIDDEN)) {
                obtain2.addChild(this.rootAccessibilityView, semanticsNode6.id);
            }
        }
        return obtain2;
    }

    public boolean externalViewRequestSendAccessibilityEvent(View view, View view2, AccessibilityEvent accessibilityEvent) {
        Integer recordFlutterId;
        if (this.accessibilityViewEmbedder.requestSendAccessibilityEvent(view, view2, accessibilityEvent) && (recordFlutterId = this.accessibilityViewEmbedder.getRecordFlutterId(view, accessibilityEvent)) != null) {
            int eventType = accessibilityEvent.getEventType();
            if (eventType == 8) {
                this.embeddedInputFocusedNodeId = recordFlutterId;
                this.inputFocusedSemanticsNode = null;
                return true;
            } else if (eventType == 128) {
                this.hoveredObject = null;
                return true;
            } else if (eventType == 32768) {
                this.embeddedAccessibilityFocusedNodeId = recordFlutterId;
                this.accessibilityFocusedSemanticsNode = null;
                return true;
            } else if (eventType != 65536) {
                return true;
            } else {
                this.embeddedInputFocusedNodeId = null;
                this.embeddedAccessibilityFocusedNodeId = null;
                return true;
            }
        }
        return false;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public AccessibilityNodeInfo findFocus(int i2) {
        if (i2 == 1) {
            SemanticsNode semanticsNode = this.inputFocusedSemanticsNode;
            if (semanticsNode != null) {
                return createAccessibilityNodeInfo(semanticsNode.id);
            }
            Integer num = this.embeddedInputFocusedNodeId;
            if (num != null) {
                return createAccessibilityNodeInfo(num.intValue());
            }
        } else if (i2 != 2) {
            return null;
        }
        SemanticsNode semanticsNode2 = this.accessibilityFocusedSemanticsNode;
        if (semanticsNode2 != null) {
            return createAccessibilityNodeInfo(semanticsNode2.id);
        }
        Integer num2 = this.embeddedAccessibilityFocusedNodeId;
        if (num2 != null) {
            return createAccessibilityNodeInfo(num2.intValue());
        }
        return null;
    }

    public boolean isAccessibilityEnabled() {
        return this.accessibilityManager.isEnabled();
    }

    public boolean isTouchExplorationEnabled() {
        return this.accessibilityManager.isTouchExplorationEnabled();
    }

    public boolean onAccessibilityHoverEvent(MotionEvent motionEvent) {
        if (this.accessibilityManager.isTouchExplorationEnabled() && !this.flutterSemanticsTree.isEmpty()) {
            SemanticsNode hitTest = getRootSemanticsNode().hitTest(new float[]{motionEvent.getX(), motionEvent.getY(), 0.0f, 1.0f});
            if (hitTest.platformViewId != -1) {
                return this.accessibilityViewEmbedder.onAccessibilityHoverEvent(hitTest.id, motionEvent);
            }
            if (motionEvent.getAction() != 9 && motionEvent.getAction() != 7) {
                if (motionEvent.getAction() == 10) {
                    onTouchExplorationExit();
                } else {
                    Log.d("flutter", "unexpected accessibility hover event: " + motionEvent);
                    return false;
                }
            } else {
                handleTouchExploration(motionEvent.getX(), motionEvent.getY());
            }
            return true;
        }
        return false;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public boolean performAction(int i2, int i3, @Nullable Bundle bundle) {
        if (i2 >= 65536) {
            boolean performAction = this.accessibilityViewEmbedder.performAction(i2, i3, bundle);
            if (performAction && i3 == 128) {
                this.embeddedAccessibilityFocusedNodeId = null;
            }
            return performAction;
        }
        SemanticsNode semanticsNode = this.flutterSemanticsTree.get(Integer.valueOf(i2));
        boolean z = false;
        if (semanticsNode == null) {
            return false;
        }
        switch (i3) {
            case 16:
                this.accessibilityChannel.dispatchSemanticsAction(i2, Action.TAP);
                return true;
            case 32:
                this.accessibilityChannel.dispatchSemanticsAction(i2, Action.LONG_PRESS);
                return true;
            case 64:
                this.accessibilityChannel.dispatchSemanticsAction(i2, Action.DID_GAIN_ACCESSIBILITY_FOCUS);
                sendAccessibilityEvent(i2, 32768);
                if (this.accessibilityFocusedSemanticsNode == null) {
                    this.rootAccessibilityView.invalidate();
                }
                this.accessibilityFocusedSemanticsNode = semanticsNode;
                if (semanticsNode.hasAction(Action.INCREASE) || semanticsNode.hasAction(Action.DECREASE)) {
                    sendAccessibilityEvent(i2, 4);
                }
                return true;
            case 128:
                this.accessibilityChannel.dispatchSemanticsAction(i2, Action.DID_LOSE_ACCESSIBILITY_FOCUS);
                sendAccessibilityEvent(i2, 65536);
                this.accessibilityFocusedSemanticsNode = null;
                this.embeddedAccessibilityFocusedNodeId = null;
                return true;
            case 256:
                if (Build.VERSION.SDK_INT < 18) {
                    return false;
                }
                return performCursorMoveAction(semanticsNode, i2, bundle, true);
            case 512:
                if (Build.VERSION.SDK_INT < 18) {
                    return false;
                }
                return performCursorMoveAction(semanticsNode, i2, bundle, false);
            case 4096:
                if (!semanticsNode.hasAction(Action.SCROLL_UP)) {
                    if (!semanticsNode.hasAction(Action.SCROLL_LEFT)) {
                        if (!semanticsNode.hasAction(Action.INCREASE)) {
                            return false;
                        }
                        semanticsNode.value = semanticsNode.increasedValue;
                        sendAccessibilityEvent(i2, 4);
                        this.accessibilityChannel.dispatchSemanticsAction(i2, Action.INCREASE);
                    } else {
                        this.accessibilityChannel.dispatchSemanticsAction(i2, Action.SCROLL_LEFT);
                    }
                } else {
                    this.accessibilityChannel.dispatchSemanticsAction(i2, Action.SCROLL_UP);
                }
                return true;
            case 8192:
                if (!semanticsNode.hasAction(Action.SCROLL_DOWN)) {
                    if (!semanticsNode.hasAction(Action.SCROLL_RIGHT)) {
                        if (!semanticsNode.hasAction(Action.DECREASE)) {
                            return false;
                        }
                        semanticsNode.value = semanticsNode.decreasedValue;
                        sendAccessibilityEvent(i2, 4);
                        this.accessibilityChannel.dispatchSemanticsAction(i2, Action.DECREASE);
                    } else {
                        this.accessibilityChannel.dispatchSemanticsAction(i2, Action.SCROLL_RIGHT);
                    }
                } else {
                    this.accessibilityChannel.dispatchSemanticsAction(i2, Action.SCROLL_DOWN);
                }
                return true;
            case 16384:
                this.accessibilityChannel.dispatchSemanticsAction(i2, Action.COPY);
                return true;
            case 32768:
                this.accessibilityChannel.dispatchSemanticsAction(i2, Action.PASTE);
                return true;
            case 65536:
                this.accessibilityChannel.dispatchSemanticsAction(i2, Action.CUT);
                return true;
            case 131072:
                if (Build.VERSION.SDK_INT < 18) {
                    return false;
                }
                HashMap hashMap = new HashMap();
                if (bundle != null && bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_START_INT) && bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_END_INT)) {
                    z = true;
                }
                if (!z) {
                    hashMap.put(SchemeCollecter.CLASSIFY_BASE, Integer.valueOf(semanticsNode.textSelectionExtent));
                    hashMap.put("extent", Integer.valueOf(semanticsNode.textSelectionExtent));
                } else {
                    hashMap.put(SchemeCollecter.CLASSIFY_BASE, Integer.valueOf(bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_START_INT)));
                    hashMap.put("extent", Integer.valueOf(bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_END_INT)));
                }
                this.accessibilityChannel.dispatchSemanticsAction(i2, Action.SET_SELECTION, hashMap);
                return true;
            case 1048576:
                this.accessibilityChannel.dispatchSemanticsAction(i2, Action.DISMISS);
                return true;
            case ACTION_SHOW_ON_SCREEN /* 16908342 */:
                this.accessibilityChannel.dispatchSemanticsAction(i2, Action.SHOW_ON_SCREEN);
                return true;
            default:
                CustomAccessibilityAction customAccessibilityAction = this.customAccessibilityActions.get(Integer.valueOf(i3 - FIRST_RESOURCE_ID));
                if (customAccessibilityAction != null) {
                    this.accessibilityChannel.dispatchSemanticsAction(i2, Action.CUSTOM_ACTION, Integer.valueOf(customAccessibilityAction.id));
                    return true;
                }
                return false;
        }
    }

    public void release() {
        PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate = this.platformViewsAccessibilityDelegate;
        if (platformViewsAccessibilityDelegate != null) {
            platformViewsAccessibilityDelegate.detachAccessibiltyBridge();
        }
        setOnAccessibilityChangeListener(null);
        this.accessibilityManager.removeAccessibilityStateChangeListener(this.accessibilityStateChangeListener);
        if (Build.VERSION.SDK_INT >= 19) {
            this.accessibilityManager.removeTouchExplorationStateChangeListener(this.touchExplorationStateChangeListener);
        }
        this.contentResolver.unregisterContentObserver(this.animationScaleObserver);
    }

    public void reset() {
        this.flutterSemanticsTree.clear();
        SemanticsNode semanticsNode = this.accessibilityFocusedSemanticsNode;
        if (semanticsNode != null) {
            sendAccessibilityEvent(semanticsNode.id, 65536);
        }
        this.accessibilityFocusedSemanticsNode = null;
        this.hoveredObject = null;
        sendWindowContentChangeEvent(0);
    }

    public void setOnAccessibilityChangeListener(@Nullable OnAccessibilityChangeListener onAccessibilityChangeListener) {
        this.onAccessibilityChangeListener = onAccessibilityChangeListener;
    }

    public void updateCustomAccessibilityActions(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr) {
        while (byteBuffer.hasRemaining()) {
            CustomAccessibilityAction orCreateAccessibilityAction = getOrCreateAccessibilityAction(byteBuffer.getInt());
            orCreateAccessibilityAction.overrideId = byteBuffer.getInt();
            int i2 = byteBuffer.getInt();
            String str = null;
            orCreateAccessibilityAction.label = i2 == -1 ? null : strArr[i2];
            int i3 = byteBuffer.getInt();
            if (i3 != -1) {
                str = strArr[i3];
            }
            orCreateAccessibilityAction.hint = str;
        }
    }

    public void updateSemantics(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr) {
        SemanticsNode semanticsNode;
        SemanticsNode semanticsNode2;
        float f2;
        float f3;
        WindowInsets rootWindowInsets;
        Integer valueOf;
        ArrayList arrayList = new ArrayList();
        while (byteBuffer.hasRemaining()) {
            SemanticsNode orCreateSemanticsNode = getOrCreateSemanticsNode(byteBuffer.getInt());
            orCreateSemanticsNode.updateWith(byteBuffer, strArr);
            if (!orCreateSemanticsNode.hasFlag(Flag.IS_HIDDEN)) {
                if (orCreateSemanticsNode.hasFlag(Flag.IS_FOCUSED)) {
                    this.inputFocusedSemanticsNode = orCreateSemanticsNode;
                }
                if (orCreateSemanticsNode.hadPreviousConfig) {
                    arrayList.add(orCreateSemanticsNode);
                }
            }
        }
        HashSet hashSet = new HashSet();
        SemanticsNode rootSemanticsNode = getRootSemanticsNode();
        ArrayList<SemanticsNode> arrayList2 = new ArrayList();
        if (rootSemanticsNode != null) {
            float[] fArr = new float[16];
            Matrix.setIdentityM(fArr, 0);
            if (Build.VERSION.SDK_INT >= 23 && (rootWindowInsets = this.rootAccessibilityView.getRootWindowInsets()) != null) {
                if (!this.lastLeftFrameInset.equals(Integer.valueOf(rootWindowInsets.getSystemWindowInsetLeft()))) {
                    rootSemanticsNode.globalGeometryDirty = true;
                    rootSemanticsNode.inverseTransformDirty = true;
                }
                this.lastLeftFrameInset = Integer.valueOf(rootWindowInsets.getSystemWindowInsetLeft());
                Matrix.translateM(fArr, 0, valueOf.intValue(), 0.0f, 0.0f);
            }
            rootSemanticsNode.updateRecursively(fArr, hashSet, false);
            rootSemanticsNode.collectRoutes(arrayList2);
        }
        SemanticsNode semanticsNode3 = null;
        for (SemanticsNode semanticsNode4 : arrayList2) {
            if (!this.flutterNavigationStack.contains(Integer.valueOf(semanticsNode4.id))) {
                semanticsNode3 = semanticsNode4;
            }
        }
        if (semanticsNode3 == null && arrayList2.size() > 0) {
            semanticsNode3 = (SemanticsNode) arrayList2.get(arrayList2.size() - 1);
        }
        if (semanticsNode3 != null && semanticsNode3.id != this.previousRouteId) {
            this.previousRouteId = semanticsNode3.id;
            sendWindowChangeEvent(semanticsNode3);
        }
        this.flutterNavigationStack.clear();
        for (SemanticsNode semanticsNode5 : arrayList2) {
            this.flutterNavigationStack.add(Integer.valueOf(semanticsNode5.id));
        }
        Iterator<Map.Entry<Integer, SemanticsNode>> it = this.flutterSemanticsTree.entrySet().iterator();
        while (it.hasNext()) {
            SemanticsNode value = it.next().getValue();
            if (!hashSet.contains(value)) {
                willRemoveSemanticsNode(value);
                it.remove();
            }
        }
        sendWindowContentChangeEvent(0);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            SemanticsNode semanticsNode6 = (SemanticsNode) it2.next();
            if (semanticsNode6.didScroll()) {
                AccessibilityEvent obtainAccessibilityEvent = obtainAccessibilityEvent(semanticsNode6.id, 4096);
                float f4 = semanticsNode6.scrollPosition;
                float f5 = semanticsNode6.scrollExtentMax;
                if (Float.isInfinite(semanticsNode6.scrollExtentMax)) {
                    if (f4 > 70000.0f) {
                        f4 = 70000.0f;
                    }
                    f5 = 100000.0f;
                }
                if (Float.isInfinite(semanticsNode6.scrollExtentMin)) {
                    f2 = f5 + 100000.0f;
                    if (f4 < -70000.0f) {
                        f4 = -70000.0f;
                    }
                    f3 = f4 + 100000.0f;
                } else {
                    f2 = f5 - semanticsNode6.scrollExtentMin;
                    f3 = f4 - semanticsNode6.scrollExtentMin;
                }
                if (!semanticsNode6.hadAction(Action.SCROLL_UP) && !semanticsNode6.hadAction(Action.SCROLL_DOWN)) {
                    if (semanticsNode6.hadAction(Action.SCROLL_LEFT) || semanticsNode6.hadAction(Action.SCROLL_RIGHT)) {
                        obtainAccessibilityEvent.setScrollX((int) f3);
                        obtainAccessibilityEvent.setMaxScrollX((int) f2);
                    }
                } else {
                    obtainAccessibilityEvent.setScrollY((int) f3);
                    obtainAccessibilityEvent.setMaxScrollY((int) f2);
                }
                if (semanticsNode6.scrollChildren > 0) {
                    obtainAccessibilityEvent.setItemCount(semanticsNode6.scrollChildren);
                    obtainAccessibilityEvent.setFromIndex(semanticsNode6.scrollIndex);
                    int i2 = 0;
                    for (SemanticsNode semanticsNode7 : semanticsNode6.childrenInHitTestOrder) {
                        if (!semanticsNode7.hasFlag(Flag.IS_HIDDEN)) {
                            i2++;
                        }
                    }
                    obtainAccessibilityEvent.setToIndex((semanticsNode6.scrollIndex + i2) - 1);
                }
                sendAccessibilityEvent(obtainAccessibilityEvent);
            }
            if (semanticsNode6.hasFlag(Flag.IS_LIVE_REGION) && semanticsNode6.didChangeLabel()) {
                sendWindowContentChangeEvent(semanticsNode6.id);
            }
            SemanticsNode semanticsNode8 = this.accessibilityFocusedSemanticsNode;
            if (semanticsNode8 != null && semanticsNode8.id == semanticsNode6.id && !semanticsNode6.hadFlag(Flag.IS_SELECTED) && semanticsNode6.hasFlag(Flag.IS_SELECTED)) {
                AccessibilityEvent obtainAccessibilityEvent2 = obtainAccessibilityEvent(semanticsNode6.id, 4);
                obtainAccessibilityEvent2.getText().add(semanticsNode6.label);
                sendAccessibilityEvent(obtainAccessibilityEvent2);
            }
            SemanticsNode semanticsNode9 = this.inputFocusedSemanticsNode;
            if (semanticsNode9 != null && semanticsNode9.id == semanticsNode6.id && ((semanticsNode2 = this.lastInputFocusedSemanticsNode) == null || semanticsNode2.id != this.inputFocusedSemanticsNode.id)) {
                this.lastInputFocusedSemanticsNode = this.inputFocusedSemanticsNode;
                sendAccessibilityEvent(obtainAccessibilityEvent(semanticsNode6.id, 8));
            } else if (this.inputFocusedSemanticsNode == null) {
                this.lastInputFocusedSemanticsNode = null;
            }
            SemanticsNode semanticsNode10 = this.inputFocusedSemanticsNode;
            if (semanticsNode10 != null && semanticsNode10.id == semanticsNode6.id && semanticsNode6.hadFlag(Flag.IS_TEXT_FIELD) && semanticsNode6.hasFlag(Flag.IS_TEXT_FIELD) && ((semanticsNode = this.accessibilityFocusedSemanticsNode) == null || semanticsNode.id == this.inputFocusedSemanticsNode.id)) {
                String str = semanticsNode6.previousValue != null ? semanticsNode6.previousValue : "";
                String str2 = semanticsNode6.value != null ? semanticsNode6.value : "";
                AccessibilityEvent createTextChangedEvent = createTextChangedEvent(semanticsNode6.id, str, str2);
                if (createTextChangedEvent != null) {
                    sendAccessibilityEvent(createTextChangedEvent);
                }
                if (semanticsNode6.previousTextSelectionBase != semanticsNode6.textSelectionBase || semanticsNode6.previousTextSelectionExtent != semanticsNode6.textSelectionExtent) {
                    AccessibilityEvent obtainAccessibilityEvent3 = obtainAccessibilityEvent(semanticsNode6.id, 8192);
                    obtainAccessibilityEvent3.getText().add(str2);
                    obtainAccessibilityEvent3.setFromIndex(semanticsNode6.textSelectionBase);
                    obtainAccessibilityEvent3.setToIndex(semanticsNode6.textSelectionExtent);
                    obtainAccessibilityEvent3.setItemCount(str2.length());
                    sendAccessibilityEvent(obtainAccessibilityEvent3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        if (this.accessibilityManager.isEnabled()) {
            this.rootAccessibilityView.getParent().requestSendAccessibilityEvent(this.rootAccessibilityView, accessibilityEvent);
        }
    }
}
