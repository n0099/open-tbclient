package com.google.android.material.badge;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.ParcelableSparseArray;
/* loaded from: classes7.dex */
public class BadgeUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean USE_COMPAT_PARENT;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        boolean z;
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
        if (Build.VERSION.SDK_INT < 18) {
            z = true;
        } else {
            z = false;
        }
        USE_COMPAT_PARENT = z;
    }

    public BadgeUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void attachBadgeDrawable(BadgeDrawable badgeDrawable, View view2, FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, badgeDrawable, view2, frameLayout) == null) {
            setBadgeDrawableBounds(badgeDrawable, view2, frameLayout);
            if (USE_COMPAT_PARENT) {
                frameLayout.setForeground(badgeDrawable);
            } else {
                view2.getOverlay().add(badgeDrawable);
            }
        }
    }

    public static void detachBadgeDrawable(BadgeDrawable badgeDrawable, View view2, FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65541, null, badgeDrawable, view2, frameLayout) != null) || badgeDrawable == null) {
            return;
        }
        if (USE_COMPAT_PARENT) {
            frameLayout.setForeground(null);
        } else {
            view2.getOverlay().remove(badgeDrawable);
        }
    }

    public static void setBadgeDrawableBounds(BadgeDrawable badgeDrawable, View view2, FrameLayout frameLayout) {
        FrameLayout frameLayout2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, badgeDrawable, view2, frameLayout) == null) {
            Rect rect = new Rect();
            if (USE_COMPAT_PARENT) {
                frameLayout2 = frameLayout;
            } else {
                frameLayout2 = view2;
            }
            frameLayout2.getDrawingRect(rect);
            badgeDrawable.setBounds(rect);
            badgeDrawable.updateBadgeCoordinates(view2, frameLayout);
        }
    }

    public static SparseArray createBadgeDrawablesFromSavedStates(Context context, ParcelableSparseArray parcelableSparseArray) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, parcelableSparseArray)) == null) {
            SparseArray sparseArray = new SparseArray(parcelableSparseArray.size());
            for (int i = 0; i < parcelableSparseArray.size(); i++) {
                int keyAt = parcelableSparseArray.keyAt(i);
                BadgeDrawable.SavedState savedState = (BadgeDrawable.SavedState) parcelableSparseArray.valueAt(i);
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

    public static ParcelableSparseArray createParcelableBadgeStates(SparseArray sparseArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, sparseArray)) == null) {
            ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
            for (int i = 0; i < sparseArray.size(); i++) {
                int keyAt = sparseArray.keyAt(i);
                BadgeDrawable badgeDrawable = (BadgeDrawable) sparseArray.valueAt(i);
                if (badgeDrawable != null) {
                    parcelableSparseArray.put(keyAt, badgeDrawable.getSavedState());
                } else {
                    throw new IllegalArgumentException("badgeDrawable cannot be null");
                }
            }
            return parcelableSparseArray;
        }
        return (ParcelableSparseArray) invokeL.objValue;
    }

    public static void updateBadgeBounds(Rect rect, float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{rect, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            rect.set((int) (f - f3), (int) (f2 - f4), (int) (f + f3), (int) (f2 + f4));
        }
    }
}
