package io.flutter.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes2.dex */
public final class AccessibilityViewEmbedder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AccessibilityBridge";
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<View, Rect> embeddedViewToDisplayBounds;
    public final SparseArray<ViewAndId> flutterIdToOrigin;
    public int nextFlutterId;
    public final Map<ViewAndId, Integer> originToFlutterId;
    public final ReflectionAccessors reflectionAccessors;
    public final View rootAccessibilityView;

    /* renamed from: io.flutter.view.AccessibilityViewEmbedder$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class ReflectionAccessors {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public final Field childNodeIdsField;
        @Nullable
        public final Method getChildId;
        @Nullable
        public final Method getParentNodeId;
        @Nullable
        public final Method getRecordSourceNodeId;
        @Nullable
        public final Method getSourceNodeId;
        @Nullable
        public final Method longArrayGetIndex;

        public /* synthetic */ ReflectionAccessors(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public Long getChildId(@NonNull AccessibilityNodeInfo accessibilityNodeInfo, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, this, accessibilityNodeInfo, i2)) == null) {
                if (this.getChildId == null && (this.childNodeIdsField == null || this.longArrayGetIndex == null)) {
                    return null;
                }
                Method method = this.getChildId;
                try {
                    return method != null ? (Long) method.invoke(accessibilityNodeInfo, Integer.valueOf(i2)) : Long.valueOf(((Long) this.longArrayGetIndex.invoke(this.childNodeIdsField.get(accessibilityNodeInfo), Integer.valueOf(i2))).longValue());
                } catch (ArrayIndexOutOfBoundsException | IllegalAccessException | InvocationTargetException unused) {
                    return null;
                }
            }
            return (Long) invokeLI.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public Long getParentNodeId(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, accessibilityNodeInfo)) == null) {
                Method method = this.getParentNodeId;
                if (method != null) {
                    try {
                        return Long.valueOf(((Long) method.invoke(accessibilityNodeInfo, new Object[0])).longValue());
                    } catch (IllegalAccessException | InvocationTargetException unused) {
                    }
                }
                return yoinkParentIdFromParcel(accessibilityNodeInfo);
            }
            return (Long) invokeL.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public Long getRecordSourceNodeId(@NonNull AccessibilityRecord accessibilityRecord) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, accessibilityRecord)) == null) {
                Method method = this.getRecordSourceNodeId;
                if (method == null) {
                    return null;
                }
                try {
                    return (Long) method.invoke(accessibilityRecord, new Object[0]);
                } catch (IllegalAccessException | InvocationTargetException unused) {
                    return null;
                }
            }
            return (Long) invokeL.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public Long getSourceNodeId(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, accessibilityNodeInfo)) == null) {
                Method method = this.getSourceNodeId;
                if (method == null) {
                    return null;
                }
                try {
                    return (Long) method.invoke(accessibilityNodeInfo, new Object[0]);
                } catch (IllegalAccessException | InvocationTargetException unused) {
                    return null;
                }
            }
            return (Long) invokeL.objValue;
        }

        public static int getVirtualNodeId(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(65547, null, j)) == null) ? (int) (j >> 32) : invokeJ.intValue;
        }

        public static boolean isBitSet(long j, int i2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Long.valueOf(j), Integer.valueOf(i2)})) == null) ? (j & (1 << i2)) != 0 : invokeCommon.booleanValue;
        }

        @Nullable
        public static Long yoinkParentIdFromParcel(AccessibilityNodeInfo accessibilityNodeInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, accessibilityNodeInfo)) == null) {
                if (Build.VERSION.SDK_INT < 26) {
                    return null;
                }
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
                Long valueOf = isBitSet(readLong, 3) ? Long.valueOf(obtain2.readLong()) : null;
                obtain2.recycle();
                return valueOf;
            }
            return (Long) invokeL.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v13, resolved type: java.lang.reflect.Method */
        /* JADX WARN: Multi-variable type inference failed */
        @SuppressLint({"PrivateApi"})
        public ReflectionAccessors() {
            Method method;
            Method method2;
            Method method3;
            Field field;
            Method method4;
            Method method5;
            Field field2;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Method method6 = null;
            try {
                method = AccessibilityNodeInfo.class.getMethod("getSourceNodeId", new Class[0]);
            } catch (NoSuchMethodException unused) {
                method = null;
            }
            try {
                method2 = AccessibilityRecord.class.getMethod("getSourceNodeId", new Class[0]);
            } catch (NoSuchMethodException unused2) {
                method2 = null;
            }
            if (Build.VERSION.SDK_INT <= 26) {
                try {
                    method5 = AccessibilityNodeInfo.class.getMethod("getParentNodeId", new Class[0]);
                } catch (NoSuchMethodException unused3) {
                    method5 = null;
                }
                try {
                    method3 = AccessibilityNodeInfo.class.getMethod("getChildId", Integer.TYPE);
                    field2 = null;
                } catch (NoSuchMethodException unused4) {
                    method3 = null;
                    field2 = null;
                }
                method6 = method5;
                field = field2;
                method4 = field2;
            } else {
                try {
                    field = AccessibilityNodeInfo.class.getDeclaredField("mChildNodeIds");
                    field.setAccessible(true);
                    method4 = Class.forName("android.util.LongArray").getMethod("get", Integer.TYPE);
                    method3 = null;
                } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException | NullPointerException unused5) {
                    method3 = null;
                    field = null;
                    method4 = null;
                }
            }
            this.getSourceNodeId = method;
            this.getParentNodeId = method6;
            this.getRecordSourceNodeId = method2;
            this.getChildId = method3;
            this.childNodeIdsField = field;
            this.longArrayGetIndex = method4;
        }
    }

    /* loaded from: classes2.dex */
    public static class ViewAndId {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int id;
        public final View view;

        public /* synthetic */ ViewAndId(View view, int i2, AnonymousClass1 anonymousClass1) {
            this(view, i2);
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ViewAndId) {
                    ViewAndId viewAndId = (ViewAndId) obj;
                    return this.id == viewAndId.id && this.view.equals(viewAndId.view);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ((this.view.hashCode() + 31) * 31) + this.id : invokeV.intValue;
        }

        public ViewAndId(View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.view = view;
            this.id = i2;
        }
    }

    public AccessibilityViewEmbedder(@NonNull View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.reflectionAccessors = new ReflectionAccessors(null);
        this.flutterIdToOrigin = new SparseArray<>();
        this.rootAccessibilityView = view;
        this.nextFlutterId = i2;
        this.originToFlutterId = new HashMap();
        this.embeddedViewToDisplayBounds = new HashMap();
    }

    private void addChildrenToFlutterNode(@NonNull AccessibilityNodeInfo accessibilityNodeInfo, @NonNull View view, @NonNull AccessibilityNodeInfo accessibilityNodeInfo2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, this, accessibilityNodeInfo, view, accessibilityNodeInfo2) == null) {
            for (int i3 = 0; i3 < accessibilityNodeInfo.getChildCount(); i3++) {
                Long childId = this.reflectionAccessors.getChildId(accessibilityNodeInfo, i3);
                if (childId != null) {
                    int virtualNodeId = ReflectionAccessors.getVirtualNodeId(childId.longValue());
                    ViewAndId viewAndId = new ViewAndId(view, virtualNodeId, null);
                    if (this.originToFlutterId.containsKey(viewAndId)) {
                        i2 = this.originToFlutterId.get(viewAndId).intValue();
                    } else {
                        int i4 = this.nextFlutterId;
                        this.nextFlutterId = i4 + 1;
                        cacheVirtualIdMappings(view, virtualNodeId, i4);
                        i2 = i4;
                    }
                    accessibilityNodeInfo2.addChild(this.rootAccessibilityView, i2);
                }
            }
        }
    }

    private void cacheVirtualIdMappings(@NonNull View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, this, view, i2, i3) == null) {
            ViewAndId viewAndId = new ViewAndId(view, i2, null);
            this.originToFlutterId.put(viewAndId, Integer.valueOf(i3));
            this.flutterIdToOrigin.put(i3, viewAndId);
        }
    }

    @NonNull
    private AccessibilityNodeInfo convertToFlutterNode(@NonNull AccessibilityNodeInfo accessibilityNodeInfo, int i2, @NonNull View view) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65539, this, accessibilityNodeInfo, i2, view)) == null) {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(this.rootAccessibilityView, i2);
            obtain.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
            obtain.setSource(this.rootAccessibilityView, i2);
            obtain.setClassName(accessibilityNodeInfo.getClassName());
            copyAccessibilityFields(accessibilityNodeInfo, obtain);
            setFlutterNodesTranslateBounds(accessibilityNodeInfo, this.embeddedViewToDisplayBounds.get(view), obtain);
            addChildrenToFlutterNode(accessibilityNodeInfo, view, obtain);
            setFlutterNodeParent(accessibilityNodeInfo, view, obtain);
            return obtain;
        }
        return (AccessibilityNodeInfo) invokeLIL.objValue;
    }

    private void copyAccessibilityFields(@NonNull AccessibilityNodeInfo accessibilityNodeInfo, @NonNull AccessibilityNodeInfo accessibilityNodeInfo2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, accessibilityNodeInfo, accessibilityNodeInfo2) == null) {
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
    }

    private void setFlutterNodeParent(@NonNull AccessibilityNodeInfo accessibilityNodeInfo, @NonNull View view, @NonNull AccessibilityNodeInfo accessibilityNodeInfo2) {
        Long parentNodeId;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, this, accessibilityNodeInfo, view, accessibilityNodeInfo2) == null) || (parentNodeId = this.reflectionAccessors.getParentNodeId(accessibilityNodeInfo)) == null) {
            return;
        }
        Integer num = this.originToFlutterId.get(new ViewAndId(view, ReflectionAccessors.getVirtualNodeId(parentNodeId.longValue()), null));
        if (num != null) {
            accessibilityNodeInfo2.setParent(this.rootAccessibilityView, num.intValue());
        }
    }

    private void setFlutterNodesTranslateBounds(@NonNull AccessibilityNodeInfo accessibilityNodeInfo, @NonNull Rect rect, @NonNull AccessibilityNodeInfo accessibilityNodeInfo2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, this, accessibilityNodeInfo, rect, accessibilityNodeInfo2) == null) {
            Rect rect2 = new Rect();
            accessibilityNodeInfo.getBoundsInParent(rect2);
            accessibilityNodeInfo2.setBoundsInParent(rect2);
            Rect rect3 = new Rect();
            accessibilityNodeInfo.getBoundsInScreen(rect3);
            rect3.offset(rect.left, rect.top);
            accessibilityNodeInfo2.setBoundsInScreen(rect3);
        }
    }

    @Nullable
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i2) {
        InterceptResult invokeI;
        AccessibilityNodeInfo createAccessibilityNodeInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            ViewAndId viewAndId = this.flutterIdToOrigin.get(i2);
            if (viewAndId == null || !this.embeddedViewToDisplayBounds.containsKey(viewAndId.view) || viewAndId.view.getAccessibilityNodeProvider() == null || (createAccessibilityNodeInfo = viewAndId.view.getAccessibilityNodeProvider().createAccessibilityNodeInfo(viewAndId.id)) == null) {
                return null;
            }
            return convertToFlutterNode(createAccessibilityNodeInfo, i2, viewAndId.view);
        }
        return (AccessibilityNodeInfo) invokeI.objValue;
    }

    @Nullable
    public Integer getRecordFlutterId(@NonNull View view, @NonNull AccessibilityRecord accessibilityRecord) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, accessibilityRecord)) == null) {
            Long recordSourceNodeId = this.reflectionAccessors.getRecordSourceNodeId(accessibilityRecord);
            if (recordSourceNodeId == null) {
                return null;
            }
            return this.originToFlutterId.get(new ViewAndId(view, ReflectionAccessors.getVirtualNodeId(recordSourceNodeId.longValue()), null));
        }
        return (Integer) invokeLL.objValue;
    }

    public AccessibilityNodeInfo getRootNode(@NonNull View view, int i2, @NonNull Rect rect) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, view, i2, rect)) == null) {
            AccessibilityNodeInfo createAccessibilityNodeInfo = view.createAccessibilityNodeInfo();
            Long sourceNodeId = this.reflectionAccessors.getSourceNodeId(createAccessibilityNodeInfo);
            if (sourceNodeId == null) {
                return null;
            }
            this.embeddedViewToDisplayBounds.put(view, rect);
            cacheVirtualIdMappings(view, ReflectionAccessors.getVirtualNodeId(sourceNodeId.longValue()), i2);
            return convertToFlutterNode(createAccessibilityNodeInfo, i2, view);
        }
        return (AccessibilityNodeInfo) invokeLIL.objValue;
    }

    public boolean onAccessibilityHoverEvent(int i2, @NonNull MotionEvent motionEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, motionEvent)) == null) {
            ViewAndId viewAndId = this.flutterIdToOrigin.get(i2);
            if (viewAndId == null) {
                return false;
            }
            Rect rect = this.embeddedViewToDisplayBounds.get(viewAndId.view);
            int pointerCount = motionEvent.getPointerCount();
            MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
            MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
            for (int i3 = 0; i3 < motionEvent.getPointerCount(); i3++) {
                pointerPropertiesArr[i3] = new MotionEvent.PointerProperties();
                motionEvent.getPointerProperties(i3, pointerPropertiesArr[i3]);
                MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
                motionEvent.getPointerCoords(i3, pointerCoords);
                pointerCoordsArr[i3] = new MotionEvent.PointerCoords(pointerCoords);
                pointerCoordsArr[i3].x -= rect.left;
                pointerCoordsArr[i3].y -= rect.top;
            }
            return viewAndId.view.dispatchGenericMotionEvent(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getAction(), motionEvent.getPointerCount(), pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags()));
        }
        return invokeIL.booleanValue;
    }

    public boolean performAction(int i2, int i3, @Nullable Bundle bundle) {
        InterceptResult invokeIIL;
        AccessibilityNodeProvider accessibilityNodeProvider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048580, this, i2, i3, bundle)) == null) {
            ViewAndId viewAndId = this.flutterIdToOrigin.get(i2);
            if (viewAndId == null || (accessibilityNodeProvider = viewAndId.view.getAccessibilityNodeProvider()) == null) {
                return false;
            }
            return accessibilityNodeProvider.performAction(viewAndId.id, i3, bundle);
        }
        return invokeIIL.booleanValue;
    }

    public boolean requestSendAccessibilityEvent(@NonNull View view, @NonNull View view2, @NonNull AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, view, view2, accessibilityEvent)) == null) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain(accessibilityEvent);
            Long recordSourceNodeId = this.reflectionAccessors.getRecordSourceNodeId(accessibilityEvent);
            if (recordSourceNodeId == null) {
                return false;
            }
            int virtualNodeId = ReflectionAccessors.getVirtualNodeId(recordSourceNodeId.longValue());
            Integer num = this.originToFlutterId.get(new ViewAndId(view, virtualNodeId, null));
            if (num == null) {
                int i2 = this.nextFlutterId;
                this.nextFlutterId = i2 + 1;
                num = Integer.valueOf(i2);
                cacheVirtualIdMappings(view, virtualNodeId, num.intValue());
            }
            obtain.setSource(this.rootAccessibilityView, num.intValue());
            obtain.setClassName(accessibilityEvent.getClassName());
            obtain.setPackageName(accessibilityEvent.getPackageName());
            for (int i3 = 0; i3 < obtain.getRecordCount(); i3++) {
                AccessibilityRecord record = obtain.getRecord(i3);
                Long recordSourceNodeId2 = this.reflectionAccessors.getRecordSourceNodeId(record);
                if (recordSourceNodeId2 == null) {
                    return false;
                }
                ViewAndId viewAndId = new ViewAndId(view, ReflectionAccessors.getVirtualNodeId(recordSourceNodeId2.longValue()), null);
                if (!this.originToFlutterId.containsKey(viewAndId)) {
                    return false;
                }
                record.setSource(this.rootAccessibilityView, this.originToFlutterId.get(viewAndId).intValue());
            }
            return this.rootAccessibilityView.getParent().requestSendAccessibilityEvent(view2, obtain);
        }
        return invokeLLL.booleanValue;
    }
}
