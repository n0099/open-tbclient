package com.google.android.material.badge;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.ParcelableSparseArray;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes7.dex */
public class BadgeUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean USE_COMPAT_PARENT;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1675188459, "Lcom/google/android/material/badge/BadgeUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1675188459, "Lcom/google/android/material/badge/BadgeUtils;");
                return;
            }
        }
        USE_COMPAT_PARENT = Build.VERSION.SDK_INT < 18;
    }

    public BadgeUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void attachBadgeDrawable(@NonNull BadgeDrawable badgeDrawable, @NonNull View view, @NonNull FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, badgeDrawable, view, frameLayout) == null) {
            setBadgeDrawableBounds(badgeDrawable, view, frameLayout);
            if (USE_COMPAT_PARENT) {
                frameLayout.setForeground(badgeDrawable);
            } else {
                view.getOverlay().add(badgeDrawable);
            }
        }
    }

    @NonNull
    public static SparseArray<BadgeDrawable> createBadgeDrawablesFromSavedStates(Context context, @NonNull ParcelableSparseArray parcelableSparseArray) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, parcelableSparseArray)) == null) {
            SparseArray<BadgeDrawable> sparseArray = new SparseArray<>(parcelableSparseArray.size());
            for (int i2 = 0; i2 < parcelableSparseArray.size(); i2++) {
                int keyAt = parcelableSparseArray.keyAt(i2);
                BadgeDrawable.SavedState savedState = (BadgeDrawable.SavedState) parcelableSparseArray.valueAt(i2);
                if (savedState != null) {
                    sparseArray.put(keyAt, BadgeDrawable.createFromSavedState(context, savedState));
                } else {
                    throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeLL.objValue;
    }

    @NonNull
    public static ParcelableSparseArray createParcelableBadgeStates(@NonNull SparseArray<BadgeDrawable> sparseArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, sparseArray)) == null) {
            ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                int keyAt = sparseArray.keyAt(i2);
                BadgeDrawable valueAt = sparseArray.valueAt(i2);
                if (valueAt != null) {
                    parcelableSparseArray.put(keyAt, valueAt.getSavedState());
                } else {
                    throw new IllegalArgumentException("badgeDrawable cannot be null");
                }
            }
            return parcelableSparseArray;
        }
        return (ParcelableSparseArray) invokeL.objValue;
    }

    public static void detachBadgeDrawable(@Nullable BadgeDrawable badgeDrawable, @NonNull View view, @NonNull FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, badgeDrawable, view, frameLayout) == null) || badgeDrawable == null) {
            return;
        }
        if (USE_COMPAT_PARENT) {
            frameLayout.setForeground(null);
        } else {
            view.getOverlay().remove(badgeDrawable);
        }
    }

    public static void setBadgeDrawableBounds(@NonNull BadgeDrawable badgeDrawable, @NonNull View view, @NonNull FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, badgeDrawable, view, frameLayout) == null) {
            Rect rect = new Rect();
            (USE_COMPAT_PARENT ? frameLayout : view).getDrawingRect(rect);
            badgeDrawable.setBounds(rect);
            badgeDrawable.updateBadgeCoordinates(view, frameLayout);
        }
    }

    public static void updateBadgeBounds(@NonNull Rect rect, float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{rect, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            rect.set((int) (f2 - f4), (int) (f3 - f5), (int) (f2 + f4), (int) (f3 + f5));
        }
    }
}
