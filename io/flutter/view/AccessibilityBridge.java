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
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
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
/* loaded from: classes14.dex */
public class AccessibilityBridge extends AccessibilityNodeProvider {
    private static final int ACTION_SHOW_ON_SCREEN = 16908342;
    private static int FIRST_RESOURCE_ID = 267386881;
    private static final int MIN_ENGINE_GENERATED_NODE_ID = 65536;
    private static final int ROOT_NODE_ID = 0;
    private static final float SCROLL_EXTENT_FOR_INFINITY = 100000.0f;
    private static final float SCROLL_POSITION_CAP_FOR_INFINITY = 70000.0f;
    private static final String TAG = "AccessibilityBridge";
    @NonNull
    private final AccessibilityChannel accessibilityChannel;
    @Nullable
    private SemanticsNode accessibilityFocusedSemanticsNode;
    @NonNull
    private final AccessibilityManager accessibilityManager;
    @NonNull
    private final AccessibilityViewEmbedder accessibilityViewEmbedder;
    @NonNull
    private final ContentResolver contentResolver;
    private Integer embeddedAccessibilityFocusedNodeId;
    private Integer embeddedInputFocusedNodeId;
    @Nullable
    private SemanticsNode hoveredObject;
    @Nullable
    private SemanticsNode inputFocusedSemanticsNode;
    @Nullable
    private SemanticsNode lastInputFocusedSemanticsNode;
    @Nullable
    private OnAccessibilityChangeListener onAccessibilityChangeListener;
    @NonNull
    private final PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate;
    @NonNull
    private final View rootAccessibilityView;
    @RequiresApi(19)
    @TargetApi(19)
    private final AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener;
    @NonNull
    private final Map<Integer, SemanticsNode> flutterSemanticsTree = new HashMap();
    @NonNull
    private final Map<Integer, CustomAccessibilityAction> customAccessibilityActions = new HashMap();
    private int accessibilityFeatureFlags = 0;
    @NonNull
    private final List<Integer> flutterNavigationStack = new ArrayList();
    private int previousRouteId = 0;
    @NonNull
    private Integer lastLeftFrameInset = 0;
    private final AccessibilityChannel.AccessibilityMessageHandler accessibilityMessageHandler = new AccessibilityChannel.AccessibilityMessageHandler() { // from class: io.flutter.view.AccessibilityBridge.1
        @Override // io.flutter.embedding.engine.systemchannels.AccessibilityChannel.AccessibilityMessageHandler
        public void announce(@NonNull String str) {
            AccessibilityBridge.this.rootAccessibilityView.announceForAccessibility(str);
        }

        @Override // io.flutter.embedding.engine.systemchannels.AccessibilityChannel.AccessibilityMessageHandler
        public void onTap(int i) {
            AccessibilityBridge.this.sendAccessibilityEvent(i, 1);
        }

        @Override // io.flutter.embedding.engine.systemchannels.AccessibilityChannel.AccessibilityMessageHandler
        public void onLongPress(int i) {
            AccessibilityBridge.this.sendAccessibilityEvent(i, 2);
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
    private final AccessibilityManager.AccessibilityStateChangeListener accessibilityStateChangeListener = new AccessibilityManager.AccessibilityStateChangeListener() { // from class: io.flutter.view.AccessibilityBridge.2
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
    private final ContentObserver animationScaleObserver = new ContentObserver(new Handler()) { // from class: io.flutter.view.AccessibilityBridge.3
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
                AccessibilityBridge.this.accessibilityFeatureFlags &= AccessibilityFeature.DISABLE_ANIMATIONS.value ^ (-1);
            }
            AccessibilityBridge.this.sendLatestAccessibilityFlagsToFlutter();
        }
    };

    /* loaded from: classes14.dex */
    public interface OnAccessibilityChangeListener {
        void onAccessibilityChanged(boolean z, boolean z2);
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
            this.touchExplorationStateChangeListener = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: io.flutter.view.AccessibilityBridge.4
                @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
                public void onTouchExplorationStateChanged(boolean z) {
                    if (!z) {
                        AccessibilityBridge.this.onTouchExplorationExit();
                        AccessibilityBridge.this.accessibilityFeatureFlags &= AccessibilityFeature.ACCESSIBLE_NAVIGATION.value ^ (-1);
                    } else {
                        AccessibilityBridge.this.accessibilityFeatureFlags |= AccessibilityFeature.ACCESSIBLE_NAVIGATION.value;
                    }
                    AccessibilityBridge.this.sendLatestAccessibilityFlagsToFlutter();
                    if (AccessibilityBridge.this.onAccessibilityChangeListener != null) {
                        AccessibilityBridge.this.onAccessibilityChangeListener.onAccessibilityChanged(accessibilityManager.isEnabled(), z);
                    }
                }
            };
            this.touchExplorationStateChangeListener.onTouchExplorationStateChanged(accessibilityManager.isTouchExplorationEnabled());
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

    public void release() {
        if (this.platformViewsAccessibilityDelegate != null) {
            this.platformViewsAccessibilityDelegate.detachAccessibiltyBridge();
        }
        setOnAccessibilityChangeListener(null);
        this.accessibilityManager.removeAccessibilityStateChangeListener(this.accessibilityStateChangeListener);
        if (Build.VERSION.SDK_INT >= 19) {
            this.accessibilityManager.removeTouchExplorationStateChangeListener(this.touchExplorationStateChangeListener);
        }
        this.contentResolver.unregisterContentObserver(this.animationScaleObserver);
    }

    public boolean isAccessibilityEnabled() {
        return this.accessibilityManager.isEnabled();
    }

    public boolean isTouchExplorationEnabled() {
        return this.accessibilityManager.isTouchExplorationEnabled();
    }

    public void setOnAccessibilityChangeListener(@Nullable OnAccessibilityChangeListener onAccessibilityChangeListener) {
        this.onAccessibilityChangeListener = onAccessibilityChangeListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendLatestAccessibilityFlagsToFlutter() {
        this.accessibilityChannel.setAccessibilityFeatures(this.accessibilityFeatureFlags);
    }

    private boolean shouldSetCollectionInfo(final SemanticsNode semanticsNode) {
        return semanticsNode.scrollChildren > 0 && (SemanticsNode.nullableHasAncestor(this.accessibilityFocusedSemanticsNode, new Predicate(semanticsNode) { // from class: io.flutter.view.AccessibilityBridge$$Lambda$0
            private final AccessibilityBridge.SemanticsNode arg$1;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = semanticsNode;
            }

            @Override // io.flutter.util.Predicate
            public boolean test(Object obj) {
                return AccessibilityBridge.lambda$shouldSetCollectionInfo$0$AccessibilityBridge(this.arg$1, (AccessibilityBridge.SemanticsNode) obj);
            }
        }) || !SemanticsNode.nullableHasAncestor(this.accessibilityFocusedSemanticsNode, AccessibilityBridge$$Lambda$1.$instance));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ boolean lambda$shouldSetCollectionInfo$0$AccessibilityBridge(SemanticsNode semanticsNode, SemanticsNode semanticsNode2) {
        return semanticsNode2 == semanticsNode;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    @SuppressLint({"NewApi"})
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        int i2;
        boolean z = false;
        if (i >= 65536) {
            return this.accessibilityViewEmbedder.createAccessibilityNodeInfo(i);
        }
        if (i == -1) {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(this.rootAccessibilityView);
            this.rootAccessibilityView.onInitializeAccessibilityNodeInfo(obtain);
            if (this.flutterSemanticsTree.containsKey(0)) {
                obtain.addChild(this.rootAccessibilityView, 0);
                return obtain;
            }
            return obtain;
        }
        SemanticsNode semanticsNode = this.flutterSemanticsTree.get(Integer.valueOf(i));
        if (semanticsNode == null) {
            return null;
        }
        if (semanticsNode.platformViewId == -1) {
            AccessibilityNodeInfo obtain2 = AccessibilityNodeInfo.obtain(this.rootAccessibilityView, i);
            if (Build.VERSION.SDK_INT >= 18) {
                obtain2.setViewIdResourceName("");
            }
            obtain2.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
            obtain2.setClassName("android.view.View");
            obtain2.setSource(this.rootAccessibilityView, i);
            obtain2.setFocusable(semanticsNode.isFocusable());
            if (this.inputFocusedSemanticsNode != null) {
                obtain2.setFocused(this.inputFocusedSemanticsNode.id == i);
            }
            if (this.accessibilityFocusedSemanticsNode != null) {
                obtain2.setAccessibilityFocused(this.accessibilityFocusedSemanticsNode.id == i);
            }
            if (semanticsNode.hasFlag(Flag.IS_TEXT_FIELD)) {
                obtain2.setPassword(semanticsNode.hasFlag(Flag.IS_OBSCURED));
                if (!semanticsNode.hasFlag(Flag.IS_READ_ONLY)) {
                    obtain2.setClassName("android.widget.EditText");
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    obtain2.setEditable(!semanticsNode.hasFlag(Flag.IS_READ_ONLY));
                    if (semanticsNode.textSelectionBase != -1 && semanticsNode.textSelectionExtent != -1) {
                        obtain2.setTextSelection(semanticsNode.textSelectionBase, semanticsNode.textSelectionExtent);
                    }
                    if (Build.VERSION.SDK_INT > 18 && this.accessibilityFocusedSemanticsNode != null && this.accessibilityFocusedSemanticsNode.id == i) {
                        obtain2.setLiveRegion(1);
                    }
                }
                if (semanticsNode.hasAction(Action.MOVE_CURSOR_FORWARD_BY_CHARACTER)) {
                    obtain2.addAction(256);
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (semanticsNode.hasAction(Action.MOVE_CURSOR_BACKWARD_BY_CHARACTER)) {
                    obtain2.addAction(512);
                    i2 |= 1;
                }
                if (semanticsNode.hasAction(Action.MOVE_CURSOR_FORWARD_BY_WORD)) {
                    obtain2.addAction(256);
                    i2 |= 2;
                }
                if (semanticsNode.hasAction(Action.MOVE_CURSOR_BACKWARD_BY_WORD)) {
                    obtain2.addAction(512);
                    i2 |= 2;
                }
                obtain2.setMovementGranularities(i2);
                if (Build.VERSION.SDK_INT >= 21 && semanticsNode.maxValueLength >= 0) {
                    int length = semanticsNode.value == null ? 0 : semanticsNode.value.length();
                    int i3 = (length - semanticsNode.currentValueLength) + semanticsNode.maxValueLength;
                    obtain2.setMaxTextLength((length - semanticsNode.currentValueLength) + semanticsNode.maxValueLength);
                }
            }
            if (Build.VERSION.SDK_INT > 18) {
                if (semanticsNode.hasAction(Action.SET_SELECTION)) {
                    obtain2.addAction(131072);
                }
                if (semanticsNode.hasAction(Action.COPY)) {
                    obtain2.addAction(16384);
                }
                if (semanticsNode.hasAction(Action.CUT)) {
                    obtain2.addAction(65536);
                }
                if (semanticsNode.hasAction(Action.PASTE)) {
                    obtain2.addAction(32768);
                }
            }
            if (semanticsNode.hasFlag(Flag.IS_BUTTON) || semanticsNode.hasFlag(Flag.IS_LINK)) {
                obtain2.setClassName("android.widget.Button");
            }
            if (semanticsNode.hasFlag(Flag.IS_IMAGE)) {
                obtain2.setClassName("android.widget.ImageView");
            }
            if (Build.VERSION.SDK_INT > 18 && semanticsNode.hasAction(Action.DISMISS)) {
                obtain2.setDismissable(true);
                obtain2.addAction(1048576);
            }
            if (semanticsNode.parent == null) {
                obtain2.setParent(this.rootAccessibilityView);
            } else {
                obtain2.setParent(this.rootAccessibilityView, semanticsNode.parent.id);
            }
            Rect globalRect = semanticsNode.getGlobalRect();
            if (semanticsNode.parent == null) {
                obtain2.setBoundsInParent(globalRect);
            } else {
                Rect globalRect2 = semanticsNode.parent.getGlobalRect();
                Rect rect = new Rect(globalRect);
                rect.offset(-globalRect2.left, -globalRect2.top);
                obtain2.setBoundsInParent(rect);
            }
            obtain2.setBoundsInScreen(globalRect);
            obtain2.setVisibleToUser(true);
            obtain2.setEnabled(!semanticsNode.hasFlag(Flag.HAS_ENABLED_STATE) || semanticsNode.hasFlag(Flag.IS_ENABLED));
            if (semanticsNode.hasAction(Action.TAP)) {
                if (Build.VERSION.SDK_INT >= 21 && semanticsNode.onTapOverride != null) {
                    obtain2.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, semanticsNode.onTapOverride.hint));
                    obtain2.setClickable(true);
                } else {
                    obtain2.addAction(16);
                    obtain2.setClickable(true);
                }
            }
            if (semanticsNode.hasAction(Action.LONG_PRESS)) {
                if (Build.VERSION.SDK_INT >= 21 && semanticsNode.onLongPressOverride != null) {
                    obtain2.addAction(new AccessibilityNodeInfo.AccessibilityAction(32, semanticsNode.onLongPressOverride.hint));
                    obtain2.setLongClickable(true);
                } else {
                    obtain2.addAction(32);
                    obtain2.setLongClickable(true);
                }
            }
            if (semanticsNode.hasAction(Action.SCROLL_LEFT) || semanticsNode.hasAction(Action.SCROLL_UP) || semanticsNode.hasAction(Action.SCROLL_RIGHT) || semanticsNode.hasAction(Action.SCROLL_DOWN)) {
                obtain2.setScrollable(true);
                if (semanticsNode.hasFlag(Flag.HAS_IMPLICIT_SCROLLING)) {
                    if (semanticsNode.hasAction(Action.SCROLL_LEFT) || semanticsNode.hasAction(Action.SCROLL_RIGHT)) {
                        if (Build.VERSION.SDK_INT > 19 && shouldSetCollectionInfo(semanticsNode)) {
                            obtain2.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(0, semanticsNode.scrollChildren, false));
                        } else {
                            obtain2.setClassName("android.widget.HorizontalScrollView");
                        }
                    } else if (Build.VERSION.SDK_INT > 18 && shouldSetCollectionInfo(semanticsNode)) {
                        obtain2.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(semanticsNode.scrollChildren, 0, false));
                    } else {
                        obtain2.setClassName("android.widget.ScrollView");
                    }
                }
                if (semanticsNode.hasAction(Action.SCROLL_LEFT) || semanticsNode.hasAction(Action.SCROLL_UP)) {
                    obtain2.addAction(4096);
                }
                if (semanticsNode.hasAction(Action.SCROLL_RIGHT) || semanticsNode.hasAction(Action.SCROLL_DOWN)) {
                    obtain2.addAction(8192);
                }
            }
            if (semanticsNode.hasAction(Action.INCREASE) || semanticsNode.hasAction(Action.DECREASE)) {
                obtain2.setClassName("android.widget.SeekBar");
                if (semanticsNode.hasAction(Action.INCREASE)) {
                    obtain2.addAction(4096);
                }
                if (semanticsNode.hasAction(Action.DECREASE)) {
                    obtain2.addAction(8192);
                }
            }
            if (semanticsNode.hasFlag(Flag.IS_LIVE_REGION) && Build.VERSION.SDK_INT > 18) {
                obtain2.setLiveRegion(1);
            }
            boolean hasFlag = semanticsNode.hasFlag(Flag.HAS_CHECKED_STATE);
            boolean hasFlag2 = semanticsNode.hasFlag(Flag.HAS_TOGGLED_STATE);
            obtain2.setCheckable((hasFlag || hasFlag2) ? true : true);
            if (!hasFlag) {
                if (hasFlag2) {
                    obtain2.setChecked(semanticsNode.hasFlag(Flag.IS_TOGGLED));
                    obtain2.setClassName("android.widget.Switch");
                    obtain2.setContentDescription(semanticsNode.getValueLabelHint());
                } else if (!semanticsNode.hasFlag(Flag.SCOPES_ROUTE)) {
                    obtain2.setText(semanticsNode.getValueLabelHint());
                }
            } else {
                obtain2.setChecked(semanticsNode.hasFlag(Flag.IS_CHECKED));
                obtain2.setContentDescription(semanticsNode.getValueLabelHint());
                if (semanticsNode.hasFlag(Flag.IS_IN_MUTUALLY_EXCLUSIVE_GROUP)) {
                    obtain2.setClassName("android.widget.RadioButton");
                } else {
                    obtain2.setClassName("android.widget.CheckBox");
                }
            }
            obtain2.setSelected(semanticsNode.hasFlag(Flag.IS_SELECTED));
            if (Build.VERSION.SDK_INT >= 28) {
                obtain2.setHeading(semanticsNode.hasFlag(Flag.IS_HEADER));
            }
            if (this.accessibilityFocusedSemanticsNode != null && this.accessibilityFocusedSemanticsNode.id == i) {
                obtain2.addAction(128);
            } else {
                obtain2.addAction(64);
            }
            if (Build.VERSION.SDK_INT >= 21 && semanticsNode.customAccessibilityActions != null) {
                for (CustomAccessibilityAction customAccessibilityAction : semanticsNode.customAccessibilityActions) {
                    obtain2.addAction(new AccessibilityNodeInfo.AccessibilityAction(customAccessibilityAction.resourceId, customAccessibilityAction.label));
                }
            }
            for (SemanticsNode semanticsNode2 : semanticsNode.childrenInTraversalOrder) {
                if (!semanticsNode2.hasFlag(Flag.IS_HIDDEN)) {
                    obtain2.addChild(this.rootAccessibilityView, semanticsNode2.id);
                }
            }
            return obtain2;
        }
        return this.accessibilityViewEmbedder.getRootNode(this.platformViewsAccessibilityDelegate.getPlatformViewById(Integer.valueOf(semanticsNode.platformViewId)), semanticsNode.id, semanticsNode.getGlobalRect());
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public boolean performAction(int i, int i2, @Nullable Bundle bundle) {
        boolean z = false;
        if (i >= 65536) {
            boolean performAction = this.accessibilityViewEmbedder.performAction(i, i2, bundle);
            if (performAction && i2 == 128) {
                this.embeddedAccessibilityFocusedNodeId = null;
                return performAction;
            }
            return performAction;
        }
        SemanticsNode semanticsNode = this.flutterSemanticsTree.get(Integer.valueOf(i));
        if (semanticsNode == null) {
            return false;
        }
        switch (i2) {
            case 16:
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.TAP);
                return true;
            case 32:
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.LONG_PRESS);
                return true;
            case 64:
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.DID_GAIN_ACCESSIBILITY_FOCUS);
                sendAccessibilityEvent(i, 32768);
                if (this.accessibilityFocusedSemanticsNode == null) {
                    this.rootAccessibilityView.invalidate();
                }
                this.accessibilityFocusedSemanticsNode = semanticsNode;
                if (semanticsNode.hasAction(Action.INCREASE) || semanticsNode.hasAction(Action.DECREASE)) {
                    sendAccessibilityEvent(i, 4);
                }
                return true;
            case 128:
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.DID_LOSE_ACCESSIBILITY_FOCUS);
                sendAccessibilityEvent(i, 65536);
                this.accessibilityFocusedSemanticsNode = null;
                this.embeddedAccessibilityFocusedNodeId = null;
                return true;
            case 256:
                if (Build.VERSION.SDK_INT < 18) {
                    return false;
                }
                return performCursorMoveAction(semanticsNode, i, bundle, true);
            case 512:
                if (Build.VERSION.SDK_INT < 18) {
                    return false;
                }
                return performCursorMoveAction(semanticsNode, i, bundle, false);
            case 4096:
                if (semanticsNode.hasAction(Action.SCROLL_UP)) {
                    this.accessibilityChannel.dispatchSemanticsAction(i, Action.SCROLL_UP);
                } else if (semanticsNode.hasAction(Action.SCROLL_LEFT)) {
                    this.accessibilityChannel.dispatchSemanticsAction(i, Action.SCROLL_LEFT);
                } else if (!semanticsNode.hasAction(Action.INCREASE)) {
                    return false;
                } else {
                    semanticsNode.value = semanticsNode.increasedValue;
                    sendAccessibilityEvent(i, 4);
                    this.accessibilityChannel.dispatchSemanticsAction(i, Action.INCREASE);
                }
                return true;
            case 8192:
                if (semanticsNode.hasAction(Action.SCROLL_DOWN)) {
                    this.accessibilityChannel.dispatchSemanticsAction(i, Action.SCROLL_DOWN);
                } else if (semanticsNode.hasAction(Action.SCROLL_RIGHT)) {
                    this.accessibilityChannel.dispatchSemanticsAction(i, Action.SCROLL_RIGHT);
                } else if (!semanticsNode.hasAction(Action.DECREASE)) {
                    return false;
                } else {
                    semanticsNode.value = semanticsNode.decreasedValue;
                    sendAccessibilityEvent(i, 4);
                    this.accessibilityChannel.dispatchSemanticsAction(i, Action.DECREASE);
                }
                return true;
            case 16384:
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.COPY);
                return true;
            case 32768:
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.PASTE);
                return true;
            case 65536:
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.CUT);
                return true;
            case 131072:
                if (Build.VERSION.SDK_INT < 18) {
                    return false;
                }
                HashMap hashMap = new HashMap();
                if (bundle != null && bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_START_INT) && bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_END_INT)) {
                    z = true;
                }
                if (z) {
                    hashMap.put(SchemeCollecter.CLASSIFY_BASE, Integer.valueOf(bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_START_INT)));
                    hashMap.put("extent", Integer.valueOf(bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_END_INT)));
                } else {
                    hashMap.put(SchemeCollecter.CLASSIFY_BASE, Integer.valueOf(semanticsNode.textSelectionExtent));
                    hashMap.put("extent", Integer.valueOf(semanticsNode.textSelectionExtent));
                }
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.SET_SELECTION, hashMap);
                return true;
            case 1048576:
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.DISMISS);
                return true;
            case ACTION_SHOW_ON_SCREEN /* 16908342 */:
                this.accessibilityChannel.dispatchSemanticsAction(i, Action.SHOW_ON_SCREEN);
                return true;
            default:
                CustomAccessibilityAction customAccessibilityAction = this.customAccessibilityActions.get(Integer.valueOf(i2 - FIRST_RESOURCE_ID));
                if (customAccessibilityAction != null) {
                    this.accessibilityChannel.dispatchSemanticsAction(i, Action.CUSTOM_ACTION, Integer.valueOf(customAccessibilityAction.id));
                    return true;
                }
                return false;
        }
    }

    @RequiresApi(18)
    @TargetApi(18)
    private boolean performCursorMoveAction(@NonNull SemanticsNode semanticsNode, int i, @NonNull Bundle bundle, boolean z) {
        int i2 = bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT);
        boolean z2 = bundle.getBoolean(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN);
        switch (i2) {
            case 1:
                if (z && semanticsNode.hasAction(Action.MOVE_CURSOR_FORWARD_BY_CHARACTER)) {
                    this.accessibilityChannel.dispatchSemanticsAction(i, Action.MOVE_CURSOR_FORWARD_BY_CHARACTER, Boolean.valueOf(z2));
                    return true;
                } else if (!z && semanticsNode.hasAction(Action.MOVE_CURSOR_BACKWARD_BY_CHARACTER)) {
                    this.accessibilityChannel.dispatchSemanticsAction(i, Action.MOVE_CURSOR_BACKWARD_BY_CHARACTER, Boolean.valueOf(z2));
                    return true;
                }
                break;
            case 2:
                if (z && semanticsNode.hasAction(Action.MOVE_CURSOR_FORWARD_BY_WORD)) {
                    this.accessibilityChannel.dispatchSemanticsAction(i, Action.MOVE_CURSOR_FORWARD_BY_WORD, Boolean.valueOf(z2));
                    return true;
                } else if (!z && semanticsNode.hasAction(Action.MOVE_CURSOR_BACKWARD_BY_WORD)) {
                    this.accessibilityChannel.dispatchSemanticsAction(i, Action.MOVE_CURSOR_BACKWARD_BY_WORD, Boolean.valueOf(z2));
                    return true;
                }
                break;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    @Override // android.view.accessibility.AccessibilityNodeProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AccessibilityNodeInfo findFocus(int i) {
        switch (i) {
            case 1:
                if (this.inputFocusedSemanticsNode == null) {
                    if (this.embeddedInputFocusedNodeId != null) {
                        return createAccessibilityNodeInfo(this.embeddedInputFocusedNodeId.intValue());
                    }
                    if (this.accessibilityFocusedSemanticsNode != null) {
                        if (this.embeddedAccessibilityFocusedNodeId != null) {
                            return createAccessibilityNodeInfo(this.embeddedAccessibilityFocusedNodeId.intValue());
                        }
                        return null;
                    }
                    return createAccessibilityNodeInfo(this.accessibilityFocusedSemanticsNode.id);
                }
                return createAccessibilityNodeInfo(this.inputFocusedSemanticsNode.id);
            case 2:
                if (this.accessibilityFocusedSemanticsNode != null) {
                }
                break;
            default:
                return null;
        }
    }

    private SemanticsNode getRootSemanticsNode() {
        return this.flutterSemanticsTree.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SemanticsNode getOrCreateSemanticsNode(int i) {
        SemanticsNode semanticsNode = this.flutterSemanticsTree.get(Integer.valueOf(i));
        if (semanticsNode == null) {
            SemanticsNode semanticsNode2 = new SemanticsNode(this);
            semanticsNode2.id = i;
            this.flutterSemanticsTree.put(Integer.valueOf(i), semanticsNode2);
            return semanticsNode2;
        }
        return semanticsNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CustomAccessibilityAction getOrCreateAccessibilityAction(int i) {
        CustomAccessibilityAction customAccessibilityAction = this.customAccessibilityActions.get(Integer.valueOf(i));
        if (customAccessibilityAction == null) {
            CustomAccessibilityAction customAccessibilityAction2 = new CustomAccessibilityAction();
            customAccessibilityAction2.id = i;
            customAccessibilityAction2.resourceId = FIRST_RESOURCE_ID + i;
            this.customAccessibilityActions.put(Integer.valueOf(i), customAccessibilityAction2);
            return customAccessibilityAction2;
        }
        return customAccessibilityAction;
    }

    public boolean onAccessibilityHoverEvent(MotionEvent motionEvent) {
        if (this.accessibilityManager.isTouchExplorationEnabled() && !this.flutterSemanticsTree.isEmpty()) {
            SemanticsNode hitTest = getRootSemanticsNode().hitTest(new float[]{motionEvent.getX(), motionEvent.getY(), 0.0f, 1.0f});
            if (hitTest.platformViewId != -1) {
                return this.accessibilityViewEmbedder.onAccessibilityHoverEvent(hitTest.id, motionEvent);
            }
            if (motionEvent.getAction() == 9 || motionEvent.getAction() == 7) {
                handleTouchExploration(motionEvent.getX(), motionEvent.getY());
            } else if (motionEvent.getAction() == 10) {
                onTouchExplorationExit();
            } else {
                Log.d("flutter", "unexpected accessibility hover event: " + motionEvent);
                return false;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTouchExplorationExit() {
        if (this.hoveredObject == null) {
            return;
        }
        sendAccessibilityEvent(this.hoveredObject.id, 256);
        this.hoveredObject = null;
    }

    private void handleTouchExploration(float f, float f2) {
        SemanticsNode hitTest;
        if (!this.flutterSemanticsTree.isEmpty() && (hitTest = getRootSemanticsNode().hitTest(new float[]{f, f2, 0.0f, 1.0f})) != this.hoveredObject) {
            if (hitTest != null) {
                sendAccessibilityEvent(hitTest.id, 128);
            }
            if (this.hoveredObject != null) {
                sendAccessibilityEvent(this.hoveredObject.id, 256);
            }
            this.hoveredObject = hitTest;
        }
    }

    void updateCustomAccessibilityActions(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr) {
        while (byteBuffer.hasRemaining()) {
            CustomAccessibilityAction orCreateAccessibilityAction = getOrCreateAccessibilityAction(byteBuffer.getInt());
            orCreateAccessibilityAction.overrideId = byteBuffer.getInt();
            int i = byteBuffer.getInt();
            orCreateAccessibilityAction.label = i == -1 ? null : strArr[i];
            int i2 = byteBuffer.getInt();
            orCreateAccessibilityAction.hint = i2 == -1 ? null : strArr[i2];
        }
    }

    void updateSemantics(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr) {
        String str;
        String str2;
        float f;
        float f2;
        WindowInsets rootWindowInsets;
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
                Matrix.translateM(fArr, 0, this.lastLeftFrameInset.intValue(), 0.0f, 0.0f);
            }
            rootSemanticsNode.updateRecursively(fArr, hashSet, false);
            rootSemanticsNode.collectRoutes(arrayList2);
        }
        SemanticsNode semanticsNode = null;
        for (SemanticsNode semanticsNode2 : arrayList2) {
            if (this.flutterNavigationStack.contains(Integer.valueOf(semanticsNode2.id))) {
                semanticsNode2 = semanticsNode;
            }
            semanticsNode = semanticsNode2;
        }
        if (semanticsNode == null && arrayList2.size() > 0) {
            semanticsNode = (SemanticsNode) arrayList2.get(arrayList2.size() - 1);
        }
        if (semanticsNode != null && semanticsNode.id != this.previousRouteId) {
            this.previousRouteId = semanticsNode.id;
            sendWindowChangeEvent(semanticsNode);
        }
        this.flutterNavigationStack.clear();
        for (SemanticsNode semanticsNode3 : arrayList2) {
            this.flutterNavigationStack.add(Integer.valueOf(semanticsNode3.id));
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
            SemanticsNode semanticsNode4 = (SemanticsNode) it2.next();
            if (semanticsNode4.didScroll()) {
                AccessibilityEvent obtainAccessibilityEvent = obtainAccessibilityEvent(semanticsNode4.id, 4096);
                float f3 = semanticsNode4.scrollPosition;
                float f4 = semanticsNode4.scrollExtentMax;
                if (Float.isInfinite(semanticsNode4.scrollExtentMax)) {
                    if (f3 > SCROLL_POSITION_CAP_FOR_INFINITY) {
                        f4 = 100000.0f;
                        f3 = 70000.0f;
                    } else {
                        f4 = 100000.0f;
                    }
                }
                if (Float.isInfinite(semanticsNode4.scrollExtentMin)) {
                    f = f4 + SCROLL_EXTENT_FOR_INFINITY;
                    if (f3 < -70000.0f) {
                        f3 = -70000.0f;
                    }
                    f2 = f3 + SCROLL_EXTENT_FOR_INFINITY;
                } else {
                    f = f4 - semanticsNode4.scrollExtentMin;
                    f2 = f3 - semanticsNode4.scrollExtentMin;
                }
                if (semanticsNode4.hadAction(Action.SCROLL_UP) || semanticsNode4.hadAction(Action.SCROLL_DOWN)) {
                    obtainAccessibilityEvent.setScrollY((int) f2);
                    obtainAccessibilityEvent.setMaxScrollY((int) f);
                } else if (semanticsNode4.hadAction(Action.SCROLL_LEFT) || semanticsNode4.hadAction(Action.SCROLL_RIGHT)) {
                    obtainAccessibilityEvent.setScrollX((int) f2);
                    obtainAccessibilityEvent.setMaxScrollX((int) f);
                }
                if (semanticsNode4.scrollChildren > 0) {
                    obtainAccessibilityEvent.setItemCount(semanticsNode4.scrollChildren);
                    obtainAccessibilityEvent.setFromIndex(semanticsNode4.scrollIndex);
                    int i = 0;
                    for (SemanticsNode semanticsNode5 : semanticsNode4.childrenInHitTestOrder) {
                        i = !semanticsNode5.hasFlag(Flag.IS_HIDDEN) ? i + 1 : i;
                    }
                    obtainAccessibilityEvent.setToIndex((semanticsNode4.scrollIndex + i) - 1);
                }
                sendAccessibilityEvent(obtainAccessibilityEvent);
            }
            if (semanticsNode4.hasFlag(Flag.IS_LIVE_REGION) && semanticsNode4.didChangeLabel()) {
                sendWindowContentChangeEvent(semanticsNode4.id);
            }
            if (this.accessibilityFocusedSemanticsNode != null && this.accessibilityFocusedSemanticsNode.id == semanticsNode4.id && !semanticsNode4.hadFlag(Flag.IS_SELECTED) && semanticsNode4.hasFlag(Flag.IS_SELECTED)) {
                AccessibilityEvent obtainAccessibilityEvent2 = obtainAccessibilityEvent(semanticsNode4.id, 4);
                obtainAccessibilityEvent2.getText().add(semanticsNode4.label);
                sendAccessibilityEvent(obtainAccessibilityEvent2);
            }
            if (this.inputFocusedSemanticsNode != null && this.inputFocusedSemanticsNode.id == semanticsNode4.id && (this.lastInputFocusedSemanticsNode == null || this.lastInputFocusedSemanticsNode.id != this.inputFocusedSemanticsNode.id)) {
                this.lastInputFocusedSemanticsNode = this.inputFocusedSemanticsNode;
                sendAccessibilityEvent(obtainAccessibilityEvent(semanticsNode4.id, 8));
            } else if (this.inputFocusedSemanticsNode == null) {
                this.lastInputFocusedSemanticsNode = null;
            }
            if (this.inputFocusedSemanticsNode != null && this.inputFocusedSemanticsNode.id == semanticsNode4.id && semanticsNode4.hadFlag(Flag.IS_TEXT_FIELD) && semanticsNode4.hasFlag(Flag.IS_TEXT_FIELD) && (this.accessibilityFocusedSemanticsNode == null || this.accessibilityFocusedSemanticsNode.id == this.inputFocusedSemanticsNode.id)) {
                if (semanticsNode4.previousValue == null) {
                    str = "";
                } else {
                    str = semanticsNode4.previousValue;
                }
                if (semanticsNode4.value == null) {
                    str2 = "";
                } else {
                    str2 = semanticsNode4.value;
                }
                AccessibilityEvent createTextChangedEvent = createTextChangedEvent(semanticsNode4.id, str, str2);
                if (createTextChangedEvent != null) {
                    sendAccessibilityEvent(createTextChangedEvent);
                }
                if (semanticsNode4.previousTextSelectionBase != semanticsNode4.textSelectionBase || semanticsNode4.previousTextSelectionExtent != semanticsNode4.textSelectionExtent) {
                    AccessibilityEvent obtainAccessibilityEvent3 = obtainAccessibilityEvent(semanticsNode4.id, 8192);
                    obtainAccessibilityEvent3.getText().add(str2);
                    obtainAccessibilityEvent3.setFromIndex(semanticsNode4.textSelectionBase);
                    obtainAccessibilityEvent3.setToIndex(semanticsNode4.textSelectionExtent);
                    obtainAccessibilityEvent3.setItemCount(str2.length());
                    sendAccessibilityEvent(obtainAccessibilityEvent3);
                }
            }
        }
    }

    private AccessibilityEvent createTextChangedEvent(int i, String str, String str2) {
        AccessibilityEvent obtainAccessibilityEvent = obtainAccessibilityEvent(i, 16);
        obtainAccessibilityEvent.setBeforeText(str);
        obtainAccessibilityEvent.getText().add(str2);
        int i2 = 0;
        while (i2 < str.length() && i2 < str2.length() && str.charAt(i2) == str2.charAt(i2)) {
            i2++;
        }
        if (i2 >= str.length() && i2 >= str2.length()) {
            return null;
        }
        obtainAccessibilityEvent.setFromIndex(i2);
        int length = str.length() - 1;
        int length2 = str2.length() - 1;
        while (length >= i2 && length2 >= i2 && str.charAt(length) == str2.charAt(length2)) {
            length--;
            length2--;
        }
        obtainAccessibilityEvent.setRemovedCount((length - i2) + 1);
        obtainAccessibilityEvent.setAddedCount((length2 - i2) + 1);
        return obtainAccessibilityEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAccessibilityEvent(int i, int i2) {
        if (this.accessibilityManager.isEnabled()) {
            sendAccessibilityEvent(obtainAccessibilityEvent(i, i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        if (this.accessibilityManager.isEnabled()) {
            this.rootAccessibilityView.getParent().requestSendAccessibilityEvent(this.rootAccessibilityView, accessibilityEvent);
        }
    }

    private void sendWindowChangeEvent(@NonNull SemanticsNode semanticsNode) {
        AccessibilityEvent obtainAccessibilityEvent = obtainAccessibilityEvent(semanticsNode.id, 32);
        obtainAccessibilityEvent.getText().add(semanticsNode.getRouteName());
        sendAccessibilityEvent(obtainAccessibilityEvent);
    }

    private void sendWindowContentChangeEvent(int i) {
        AccessibilityEvent obtainAccessibilityEvent = obtainAccessibilityEvent(i, 2048);
        if (Build.VERSION.SDK_INT >= 19) {
            obtainAccessibilityEvent.setContentChangeTypes(1);
        }
        sendAccessibilityEvent(obtainAccessibilityEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AccessibilityEvent obtainAccessibilityEvent(int i, int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        obtain.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
        obtain.setSource(this.rootAccessibilityView, i);
        return obtain;
    }

    private void willRemoveSemanticsNode(SemanticsNode semanticsNode) {
        semanticsNode.parent = null;
        if (this.accessibilityFocusedSemanticsNode == semanticsNode) {
            sendAccessibilityEvent(this.accessibilityFocusedSemanticsNode.id, 65536);
            this.accessibilityFocusedSemanticsNode = null;
        }
        if (this.inputFocusedSemanticsNode == semanticsNode) {
            this.inputFocusedSemanticsNode = null;
        }
        if (this.hoveredObject == semanticsNode) {
            this.hoveredObject = null;
        }
    }

    public void reset() {
        this.flutterSemanticsTree.clear();
        if (this.accessibilityFocusedSemanticsNode != null) {
            sendAccessibilityEvent(this.accessibilityFocusedSemanticsNode.id, 65536);
        }
        this.accessibilityFocusedSemanticsNode = null;
        this.hoveredObject = null;
        sendWindowContentChangeEvent(0);
    }

    /* loaded from: classes14.dex */
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

        Action(int i) {
            this.value = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
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
        
        final int value;

        Flag(int i) {
            this.value = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public enum AccessibilityFeature {
        ACCESSIBLE_NAVIGATION(1),
        INVERT_COLORS(2),
        DISABLE_ANIMATIONS(4);
        
        final int value;

        AccessibilityFeature(int i) {
            this.value = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public enum TextDirection {
        UNKNOWN,
        LTR,
        RTL;

        public static TextDirection fromInt(int i) {
            switch (i) {
                case 1:
                    return RTL;
                case 2:
                    return LTR;
                default:
                    return UNKNOWN;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public static class CustomAccessibilityAction {
        private String hint;
        private String label;
        private int resourceId = -1;
        private int id = -1;
        private int overrideId = -1;

        CustomAccessibilityAction() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public static class SemanticsNode {
        final AccessibilityBridge accessibilityBridge;
        private int actions;
        private float bottom;
        private int currentValueLength;
        private List<CustomAccessibilityAction> customAccessibilityActions;
        private String decreasedValue;
        private int flags;
        private Rect globalRect;
        private float[] globalTransform;
        private String hint;
        private String increasedValue;
        private float[] inverseTransform;
        private String label;
        private float left;
        private int maxValueLength;
        private CustomAccessibilityAction onLongPressOverride;
        private CustomAccessibilityAction onTapOverride;
        private SemanticsNode parent;
        private int platformViewId;
        private int previousActions;
        private int previousFlags;
        private String previousLabel;
        private float previousScrollExtentMax;
        private float previousScrollExtentMin;
        private float previousScrollPosition;
        private int previousTextSelectionBase;
        private int previousTextSelectionExtent;
        private String previousValue;
        private float right;
        private int scrollChildren;
        private float scrollExtentMax;
        private float scrollExtentMin;
        private int scrollIndex;
        private float scrollPosition;
        private TextDirection textDirection;
        private int textSelectionBase;
        private int textSelectionExtent;
        private float top;
        private float[] transform;
        private String value;
        private int id = -1;
        private boolean hadPreviousConfig = false;
        private List<SemanticsNode> childrenInTraversalOrder = new ArrayList();
        private List<SemanticsNode> childrenInHitTestOrder = new ArrayList();
        private boolean inverseTransformDirty = true;
        private boolean globalGeometryDirty = true;

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean nullableHasAncestor(SemanticsNode semanticsNode, Predicate<SemanticsNode> predicate) {
            return (semanticsNode == null || semanticsNode.getAncestor(predicate) == null) ? false : true;
        }

        SemanticsNode(@NonNull AccessibilityBridge accessibilityBridge) {
            this.accessibilityBridge = accessibilityBridge;
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
        public boolean hasAction(@NonNull Action action) {
            return (this.actions & action.value) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hadAction(@NonNull Action action) {
            return (this.previousActions & action.value) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hasFlag(@NonNull Flag flag) {
            return (this.flags & flag.value) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hadFlag(@NonNull Flag flag) {
            return (this.previousFlags & flag.value) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean didScroll() {
            return (Float.isNaN(this.scrollPosition) || Float.isNaN(this.previousScrollPosition) || this.previousScrollPosition == this.scrollPosition) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean didChangeLabel() {
            if (this.label == null && this.previousLabel == null) {
                return false;
            }
            return this.label == null || this.previousLabel == null || !this.label.equals(this.previousLabel);
        }

        private void log(@NonNull String str, boolean z) {
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
            int i = byteBuffer.getInt();
            this.label = i == -1 ? null : strArr[i];
            int i2 = byteBuffer.getInt();
            this.value = i2 == -1 ? null : strArr[i2];
            int i3 = byteBuffer.getInt();
            this.increasedValue = i3 == -1 ? null : strArr[i3];
            int i4 = byteBuffer.getInt();
            this.decreasedValue = i4 == -1 ? null : strArr[i4];
            int i5 = byteBuffer.getInt();
            this.hint = i5 == -1 ? null : strArr[i5];
            this.textDirection = TextDirection.fromInt(byteBuffer.getInt());
            this.left = byteBuffer.getFloat();
            this.top = byteBuffer.getFloat();
            this.right = byteBuffer.getFloat();
            this.bottom = byteBuffer.getFloat();
            if (this.transform == null) {
                this.transform = new float[16];
            }
            for (int i6 = 0; i6 < 16; i6++) {
                this.transform[i6] = byteBuffer.getFloat();
            }
            this.inverseTransformDirty = true;
            this.globalGeometryDirty = true;
            int i7 = byteBuffer.getInt();
            this.childrenInTraversalOrder.clear();
            this.childrenInHitTestOrder.clear();
            for (int i8 = 0; i8 < i7; i8++) {
                SemanticsNode orCreateSemanticsNode = this.accessibilityBridge.getOrCreateSemanticsNode(byteBuffer.getInt());
                orCreateSemanticsNode.parent = this;
                this.childrenInTraversalOrder.add(orCreateSemanticsNode);
            }
            for (int i9 = 0; i9 < i7; i9++) {
                SemanticsNode orCreateSemanticsNode2 = this.accessibilityBridge.getOrCreateSemanticsNode(byteBuffer.getInt());
                orCreateSemanticsNode2.parent = this;
                this.childrenInHitTestOrder.add(orCreateSemanticsNode2);
            }
            int i10 = byteBuffer.getInt();
            if (i10 == 0) {
                this.customAccessibilityActions = null;
                return;
            }
            if (this.customAccessibilityActions == null) {
                this.customAccessibilityActions = new ArrayList(i10);
            } else {
                this.customAccessibilityActions.clear();
            }
            for (int i11 = 0; i11 < i10; i11++) {
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

        private void ensureInverseTransform() {
            if (this.inverseTransformDirty) {
                this.inverseTransformDirty = false;
                if (this.inverseTransform == null) {
                    this.inverseTransform = new float[16];
                }
                if (!Matrix.invertM(this.inverseTransform, 0, this.transform, 0)) {
                    Arrays.fill(this.inverseTransform, 0.0f);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Rect getGlobalRect() {
            return this.globalRect;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SemanticsNode hitTest(float[] fArr) {
            float f = fArr[3];
            float f2 = fArr[0] / f;
            float f3 = fArr[1] / f;
            if (f2 < this.left || f2 >= this.right || f3 < this.top || f3 >= this.bottom) {
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
            if (hasFlag(Flag.SCOPES_ROUTE)) {
                return false;
            }
            if (hasFlag(Flag.IS_FOCUSABLE)) {
                return true;
            }
            return ((((((Action.SCROLL_RIGHT.value | Action.SCROLL_LEFT.value) | Action.SCROLL_UP.value) | Action.SCROLL_DOWN.value) ^ (-1)) & this.actions) == 0 && this.flags == 0 && (this.label == null || this.label.isEmpty()) && ((this.value == null || this.value.isEmpty()) && (this.hint == null || this.hint.isEmpty()))) ? false : true;
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
        public String getRouteName() {
            if (hasFlag(Flag.NAMES_ROUTE) && this.label != null && !this.label.isEmpty()) {
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

        private void transformPoint(float[] fArr, float[] fArr2, float[] fArr3) {
            Matrix.multiplyMV(fArr, 0, fArr2, 0, fArr3, 0);
            float f = fArr[3];
            fArr[0] = fArr[0] / f;
            fArr[1] = fArr[1] / f;
            fArr[2] = fArr[2] / f;
            fArr[3] = 0.0f;
        }

        private float min(float f, float f2, float f3, float f4) {
            return Math.min(f, Math.min(f2, Math.min(f3, f4)));
        }

        private float max(float f, float f2, float f3, float f4) {
            return Math.max(f, Math.max(f2, Math.max(f3, f4)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getValueLabelHint() {
            String[] strArr;
            StringBuilder sb = new StringBuilder();
            for (String str : new String[]{this.value, this.label, this.hint}) {
                if (str != null && str.length() > 0) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    sb.append(str);
                }
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
            return null;
        }
    }

    public boolean externalViewRequestSendAccessibilityEvent(View view, View view2, AccessibilityEvent accessibilityEvent) {
        Integer recordFlutterId;
        if (this.accessibilityViewEmbedder.requestSendAccessibilityEvent(view, view2, accessibilityEvent) && (recordFlutterId = this.accessibilityViewEmbedder.getRecordFlutterId(view, accessibilityEvent)) != null) {
            switch (accessibilityEvent.getEventType()) {
                case 8:
                    this.embeddedInputFocusedNodeId = recordFlutterId;
                    this.inputFocusedSemanticsNode = null;
                    break;
                case 128:
                    this.hoveredObject = null;
                    break;
                case 32768:
                    this.embeddedAccessibilityFocusedNodeId = recordFlutterId;
                    this.accessibilityFocusedSemanticsNode = null;
                    break;
                case 65536:
                    this.embeddedInputFocusedNodeId = null;
                    this.embeddedAccessibilityFocusedNodeId = null;
                    break;
            }
            return true;
        }
        return false;
    }
}
