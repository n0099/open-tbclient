package io.flutter.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes6.dex */
final class AccessibilityViewEmbedder {
    private static final String TAG = "AccessibilityBridge";
    private int nextFlutterId;
    private final View rootAccessibilityView;
    private final ReflectionAccessors reflectionAccessors = new ReflectionAccessors();
    private final SparseArray<ViewAndId> flutterIdToOrigin = new SparseArray<>();
    private final Map<ViewAndId, Integer> originToFlutterId = new HashMap();
    private final Map<View, Rect> embeddedViewToDisplayBounds = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public AccessibilityViewEmbedder(@NonNull View view, int i) {
        this.rootAccessibilityView = view;
        this.nextFlutterId = i;
    }

    public AccessibilityNodeInfo getRootNode(@NonNull View view, int i, @NonNull Rect rect) {
        AccessibilityNodeInfo createAccessibilityNodeInfo = view.createAccessibilityNodeInfo();
        Long sourceNodeId = this.reflectionAccessors.getSourceNodeId(createAccessibilityNodeInfo);
        if (sourceNodeId == null) {
            return null;
        }
        this.embeddedViewToDisplayBounds.put(view, rect);
        cacheVirtualIdMappings(view, ReflectionAccessors.getVirtualNodeId(sourceNodeId.longValue()), i);
        return convertToFlutterNode(createAccessibilityNodeInfo, i, view);
    }

    @Nullable
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        AccessibilityNodeInfo createAccessibilityNodeInfo;
        ViewAndId viewAndId = this.flutterIdToOrigin.get(i);
        if (viewAndId != null && this.embeddedViewToDisplayBounds.containsKey(viewAndId.view) && viewAndId.view.getAccessibilityNodeProvider() != null && (createAccessibilityNodeInfo = viewAndId.view.getAccessibilityNodeProvider().createAccessibilityNodeInfo(viewAndId.id)) != null) {
            return convertToFlutterNode(createAccessibilityNodeInfo, i, viewAndId.view);
        }
        return null;
    }

    @NonNull
    private AccessibilityNodeInfo convertToFlutterNode(@NonNull AccessibilityNodeInfo accessibilityNodeInfo, int i, @NonNull View view) {
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(this.rootAccessibilityView, i);
        obtain.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
        obtain.setSource(this.rootAccessibilityView, i);
        obtain.setClassName(accessibilityNodeInfo.getClassName());
        copyAccessibilityFields(accessibilityNodeInfo, obtain);
        setFlutterNodesTranslateBounds(accessibilityNodeInfo, this.embeddedViewToDisplayBounds.get(view), obtain);
        addChildrenToFlutterNode(accessibilityNodeInfo, view, obtain);
        setFlutterNodeParent(accessibilityNodeInfo, view, obtain);
        return obtain;
    }

    private void setFlutterNodeParent(@NonNull AccessibilityNodeInfo accessibilityNodeInfo, @NonNull View view, @NonNull AccessibilityNodeInfo accessibilityNodeInfo2) {
        Long parentNodeId = this.reflectionAccessors.getParentNodeId(accessibilityNodeInfo);
        if (parentNodeId == null) {
            return;
        }
        Integer num = this.originToFlutterId.get(new ViewAndId(view, ReflectionAccessors.getVirtualNodeId(parentNodeId.longValue())));
        if (num != null) {
            accessibilityNodeInfo2.setParent(this.rootAccessibilityView, num.intValue());
        }
    }

    private void addChildrenToFlutterNode(@NonNull AccessibilityNodeInfo accessibilityNodeInfo, @NonNull View view, @NonNull AccessibilityNodeInfo accessibilityNodeInfo2) {
        int i;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= accessibilityNodeInfo.getChildCount()) {
                return;
            }
            Long childId = this.reflectionAccessors.getChildId(accessibilityNodeInfo, i3);
            if (childId != null) {
                int virtualNodeId = ReflectionAccessors.getVirtualNodeId(childId.longValue());
                ViewAndId viewAndId = new ViewAndId(view, virtualNodeId);
                if (this.originToFlutterId.containsKey(viewAndId)) {
                    i = this.originToFlutterId.get(viewAndId).intValue();
                } else {
                    i = this.nextFlutterId;
                    this.nextFlutterId = i + 1;
                    cacheVirtualIdMappings(view, virtualNodeId, i);
                }
                accessibilityNodeInfo2.addChild(this.rootAccessibilityView, i);
            }
            i2 = i3 + 1;
        }
    }

    private void cacheVirtualIdMappings(@NonNull View view, int i, int i2) {
        ViewAndId viewAndId = new ViewAndId(view, i);
        this.originToFlutterId.put(viewAndId, Integer.valueOf(i2));
        this.flutterIdToOrigin.put(i2, viewAndId);
    }

    private void setFlutterNodesTranslateBounds(@NonNull AccessibilityNodeInfo accessibilityNodeInfo, @NonNull Rect rect, @NonNull AccessibilityNodeInfo accessibilityNodeInfo2) {
        Rect rect2 = new Rect();
        accessibilityNodeInfo.getBoundsInParent(rect2);
        accessibilityNodeInfo2.setBoundsInParent(rect2);
        Rect rect3 = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect3);
        rect3.offset(rect.left, rect.top);
        accessibilityNodeInfo2.setBoundsInScreen(rect3);
    }

    private void copyAccessibilityFields(@NonNull AccessibilityNodeInfo accessibilityNodeInfo, @NonNull AccessibilityNodeInfo accessibilityNodeInfo2) {
        accessibilityNodeInfo2.setAccessibilityFocused(accessibilityNodeInfo.isAccessibilityFocused());
        accessibilityNodeInfo2.setCheckable(accessibilityNodeInfo.isCheckable());
        accessibilityNodeInfo2.setChecked(accessibilityNodeInfo.isChecked());
        accessibilityNodeInfo2.setContentDescription(accessibilityNodeInfo.getContentDescription());
        accessibilityNodeInfo2.setEnabled(accessibilityNodeInfo.isEnabled());
        accessibilityNodeInfo2.setClickable(accessibilityNodeInfo.isClickable());
        accessibilityNodeInfo2.setFocusable(accessibilityNodeInfo.isFocusable());
        accessibilityNodeInfo2.setFocused(accessibilityNodeInfo.isFocused());
        accessibilityNodeInfo2.setLongClickable(accessibilityNodeInfo.isLongClickable());
        accessibilityNodeInfo2.setMovementGranularities(accessibilityNodeInfo.getMovementGranularities());
        accessibilityNodeInfo2.setPassword(accessibilityNodeInfo.isPassword());
        accessibilityNodeInfo2.setScrollable(accessibilityNodeInfo.isScrollable());
        accessibilityNodeInfo2.setSelected(accessibilityNodeInfo.isSelected());
        accessibilityNodeInfo2.setText(accessibilityNodeInfo.getText());
        accessibilityNodeInfo2.setVisibleToUser(accessibilityNodeInfo.isVisibleToUser());
        if (Build.VERSION.SDK_INT >= 18) {
            accessibilityNodeInfo2.setEditable(accessibilityNodeInfo.isEditable());
        }
        if (Build.VERSION.SDK_INT >= 19) {
            accessibilityNodeInfo2.setCanOpenPopup(accessibilityNodeInfo.canOpenPopup());
            accessibilityNodeInfo2.setCollectionInfo(accessibilityNodeInfo.getCollectionInfo());
            accessibilityNodeInfo2.setCollectionItemInfo(accessibilityNodeInfo.getCollectionItemInfo());
            accessibilityNodeInfo2.setContentInvalid(accessibilityNodeInfo.isContentInvalid());
            accessibilityNodeInfo2.setDismissable(accessibilityNodeInfo.isDismissable());
            accessibilityNodeInfo2.setInputType(accessibilityNodeInfo.getInputType());
            accessibilityNodeInfo2.setLiveRegion(accessibilityNodeInfo.getLiveRegion());
            accessibilityNodeInfo2.setMultiLine(accessibilityNodeInfo.isMultiLine());
            accessibilityNodeInfo2.setRangeInfo(accessibilityNodeInfo.getRangeInfo());
        }
        if (Build.VERSION.SDK_INT >= 21) {
            accessibilityNodeInfo2.setError(accessibilityNodeInfo.getError());
            accessibilityNodeInfo2.setMaxTextLength(accessibilityNodeInfo.getMaxTextLength());
        }
        if (Build.VERSION.SDK_INT >= 23) {
            accessibilityNodeInfo2.setContextClickable(accessibilityNodeInfo.isContextClickable());
        }
        if (Build.VERSION.SDK_INT >= 24) {
            accessibilityNodeInfo2.setDrawingOrder(accessibilityNodeInfo.getDrawingOrder());
            accessibilityNodeInfo2.setImportantForAccessibility(accessibilityNodeInfo.isImportantForAccessibility());
        }
        if (Build.VERSION.SDK_INT >= 26) {
            accessibilityNodeInfo2.setAvailableExtraData(accessibilityNodeInfo.getAvailableExtraData());
            accessibilityNodeInfo2.setHintText(accessibilityNodeInfo.getHintText());
            accessibilityNodeInfo2.setShowingHintText(accessibilityNodeInfo.isShowingHintText());
        }
    }

    public boolean requestSendAccessibilityEvent(@NonNull View view, @NonNull View view2, @NonNull AccessibilityEvent accessibilityEvent) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(accessibilityEvent);
        Long recordSourceNodeId = this.reflectionAccessors.getRecordSourceNodeId(accessibilityEvent);
        if (recordSourceNodeId == null) {
            return false;
        }
        int virtualNodeId = ReflectionAccessors.getVirtualNodeId(recordSourceNodeId.longValue());
        Integer num = this.originToFlutterId.get(new ViewAndId(view, virtualNodeId));
        if (num == null) {
            int i = this.nextFlutterId;
            this.nextFlutterId = i + 1;
            num = Integer.valueOf(i);
            cacheVirtualIdMappings(view, virtualNodeId, num.intValue());
        }
        obtain.setSource(this.rootAccessibilityView, num.intValue());
        obtain.setClassName(accessibilityEvent.getClassName());
        obtain.setPackageName(accessibilityEvent.getPackageName());
        for (int i2 = 0; i2 < obtain.getRecordCount(); i2++) {
            AccessibilityRecord record = obtain.getRecord(i2);
            Long recordSourceNodeId2 = this.reflectionAccessors.getRecordSourceNodeId(record);
            if (recordSourceNodeId2 == null) {
                return false;
            }
            ViewAndId viewAndId = new ViewAndId(view, ReflectionAccessors.getVirtualNodeId(recordSourceNodeId2.longValue()));
            if (!this.originToFlutterId.containsKey(viewAndId)) {
                return false;
            }
            record.setSource(this.rootAccessibilityView, this.originToFlutterId.get(viewAndId).intValue());
        }
        return this.rootAccessibilityView.getParent().requestSendAccessibilityEvent(view2, obtain);
    }

    public boolean performAction(int i, int i2, @Nullable Bundle bundle) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        ViewAndId viewAndId = this.flutterIdToOrigin.get(i);
        if (viewAndId != null && (accessibilityNodeProvider = viewAndId.view.getAccessibilityNodeProvider()) != null) {
            return accessibilityNodeProvider.performAction(viewAndId.id, i2, bundle);
        }
        return false;
    }

    @Nullable
    public Integer getRecordFlutterId(@NonNull View view, @NonNull AccessibilityRecord accessibilityRecord) {
        Long recordSourceNodeId = this.reflectionAccessors.getRecordSourceNodeId(accessibilityRecord);
        if (recordSourceNodeId == null) {
            return null;
        }
        return this.originToFlutterId.get(new ViewAndId(view, ReflectionAccessors.getVirtualNodeId(recordSourceNodeId.longValue())));
    }

    public boolean onAccessibilityHoverEvent(int i, @NonNull MotionEvent motionEvent) {
        ViewAndId viewAndId = this.flutterIdToOrigin.get(i);
        if (viewAndId == null) {
            return false;
        }
        Rect rect = this.embeddedViewToDisplayBounds.get(viewAndId.view);
        int pointerCount = motionEvent.getPointerCount();
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
        for (int i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
            pointerPropertiesArr[i2] = new MotionEvent.PointerProperties();
            motionEvent.getPointerProperties(i2, pointerPropertiesArr[i2]);
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            motionEvent.getPointerCoords(i2, pointerCoords);
            pointerCoordsArr[i2] = new MotionEvent.PointerCoords(pointerCoords);
            pointerCoordsArr[i2].x -= rect.left;
            pointerCoordsArr[i2].y -= rect.top;
        }
        return viewAndId.view.dispatchGenericMotionEvent(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getAction(), motionEvent.getPointerCount(), pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class ViewAndId {
        final int id;
        final View view;

        private ViewAndId(View view, int i) {
            this.view = view;
            this.id = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ViewAndId) {
                ViewAndId viewAndId = (ViewAndId) obj;
                return this.id == viewAndId.id && this.view.equals(viewAndId.view);
            }
            return false;
        }

        public int hashCode() {
            return ((this.view.hashCode() + 31) * 31) + this.id;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class ReflectionAccessors {
        @Nullable
        private final Field childNodeIdsField;
        @Nullable
        private final Method getChildId;
        @Nullable
        private final Method getParentNodeId;
        @Nullable
        private final Method getRecordSourceNodeId;
        @Nullable
        private final Method getSourceNodeId;
        @Nullable
        private final Method longArrayGetIndex;

        @SuppressLint({"PrivateApi"})
        private ReflectionAccessors() {
            Method method;
            Method method2;
            Field field;
            Method method3;
            Method method4;
            Method method5;
            Method method6 = null;
            try {
                method = AccessibilityNodeInfo.class.getMethod("getSourceNodeId", new Class[0]);
            } catch (NoSuchMethodException e) {
                Log.w(AccessibilityViewEmbedder.TAG, "can't invoke AccessibilityNodeInfo#getSourceNodeId with reflection");
                method = null;
            }
            try {
                method2 = AccessibilityRecord.class.getMethod("getSourceNodeId", new Class[0]);
            } catch (NoSuchMethodException e2) {
                Log.w(AccessibilityViewEmbedder.TAG, "can't invoke AccessibiiltyRecord#getSourceNodeId with reflection");
                method2 = null;
            }
            if (Build.VERSION.SDK_INT <= 26) {
                try {
                    method5 = AccessibilityNodeInfo.class.getMethod("getParentNodeId", new Class[0]);
                } catch (NoSuchMethodException e3) {
                    Log.w(AccessibilityViewEmbedder.TAG, "can't invoke getParentNodeId with reflection");
                    method5 = null;
                }
                try {
                    method4 = method5;
                    method3 = AccessibilityNodeInfo.class.getMethod("getChildId", Integer.TYPE);
                    field = null;
                } catch (NoSuchMethodException e4) {
                    Log.w(AccessibilityViewEmbedder.TAG, "can't invoke getChildId with reflection");
                    field = null;
                    method4 = method5;
                    method3 = null;
                }
            } else {
                try {
                    Field declaredField = AccessibilityNodeInfo.class.getDeclaredField("mChildNodeIds");
                    declaredField.setAccessible(true);
                    method4 = null;
                    method3 = null;
                    method6 = Class.forName("android.util.LongArray").getMethod("get", Integer.TYPE);
                    field = declaredField;
                } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException | NullPointerException e5) {
                    Log.w(AccessibilityViewEmbedder.TAG, "can't access childNodeIdsField with reflection");
                    field = null;
                    method3 = null;
                    method4 = null;
                }
            }
            this.getSourceNodeId = method;
            this.getParentNodeId = method4;
            this.getRecordSourceNodeId = method2;
            this.getChildId = method3;
            this.childNodeIdsField = field;
            this.longArrayGetIndex = method6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int getVirtualNodeId(long j) {
            return (int) (j >> 32);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public Long getSourceNodeId(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
            if (this.getSourceNodeId == null) {
                return null;
            }
            try {
                return (Long) this.getSourceNodeId.invoke(accessibilityNodeInfo, new Object[0]);
            } catch (IllegalAccessException e) {
                Log.w(AccessibilityViewEmbedder.TAG, e);
                return null;
            } catch (InvocationTargetException e2) {
                Log.w(AccessibilityViewEmbedder.TAG, e2);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public Long getChildId(@NonNull AccessibilityNodeInfo accessibilityNodeInfo, int i) {
            if (this.getChildId == null && (this.childNodeIdsField == null || this.longArrayGetIndex == null)) {
                return null;
            }
            if (this.getChildId != null) {
                try {
                    return (Long) this.getChildId.invoke(accessibilityNodeInfo, Integer.valueOf(i));
                } catch (IllegalAccessException e) {
                    Log.w(AccessibilityViewEmbedder.TAG, e);
                } catch (InvocationTargetException e2) {
                    Log.w(AccessibilityViewEmbedder.TAG, e2);
                }
            } else {
                try {
                    return Long.valueOf(((Long) this.longArrayGetIndex.invoke(this.childNodeIdsField.get(accessibilityNodeInfo), Integer.valueOf(i))).longValue());
                } catch (ArrayIndexOutOfBoundsException e3) {
                    e = e3;
                    Log.w(AccessibilityViewEmbedder.TAG, e);
                    return null;
                } catch (IllegalAccessException e4) {
                    Log.w(AccessibilityViewEmbedder.TAG, e4);
                } catch (InvocationTargetException e5) {
                    e = e5;
                    Log.w(AccessibilityViewEmbedder.TAG, e);
                    return null;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public Long getParentNodeId(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
            if (this.getParentNodeId != null) {
                try {
                    return Long.valueOf(((Long) this.getParentNodeId.invoke(accessibilityNodeInfo, new Object[0])).longValue());
                } catch (IllegalAccessException e) {
                    Log.w(AccessibilityViewEmbedder.TAG, e);
                } catch (InvocationTargetException e2) {
                    Log.w(AccessibilityViewEmbedder.TAG, e2);
                }
            }
            return yoinkParentIdFromParcel(accessibilityNodeInfo);
        }

        @Nullable
        private static Long yoinkParentIdFromParcel(AccessibilityNodeInfo accessibilityNodeInfo) {
            if (Build.VERSION.SDK_INT < 26) {
                Log.w(AccessibilityViewEmbedder.TAG, "Unexpected Android version. Unable to find the parent ID.");
            } else {
                AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
                Parcel obtain2 = Parcel.obtain();
                obtain2.setDataPosition(0);
                obtain.writeToParcel(obtain2, 0);
                obtain2.setDataPosition(0);
                long readLong = obtain2.readLong();
                if (isBitSet(readLong, 0)) {
                    obtain2.readInt();
                }
                if (isBitSet(readLong, 1)) {
                    obtain2.readLong();
                }
                if (isBitSet(readLong, 2)) {
                    obtain2.readInt();
                }
                r0 = isBitSet(readLong, 3) ? Long.valueOf(obtain2.readLong()) : null;
                obtain2.recycle();
            }
            return r0;
        }

        private static boolean isBitSet(long j, int i) {
            return ((1 << i) & j) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public Long getRecordSourceNodeId(@NonNull AccessibilityRecord accessibilityRecord) {
            if (this.getRecordSourceNodeId == null) {
                return null;
            }
            try {
                return (Long) this.getRecordSourceNodeId.invoke(accessibilityRecord, new Object[0]);
            } catch (IllegalAccessException e) {
                Log.w(AccessibilityViewEmbedder.TAG, e);
                return null;
            } catch (InvocationTargetException e2) {
                Log.w(AccessibilityViewEmbedder.TAG, e2);
                return null;
            }
        }
    }
}
