package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Property;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class MotionSpec {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MotionSpec";
    public transient /* synthetic */ FieldHolder $fh;
    public final SimpleArrayMap<String, PropertyValuesHolder[]> propertyValues;
    public final SimpleArrayMap<String, MotionTiming> timings;

    public MotionSpec() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.timings = new SimpleArrayMap<>();
        this.propertyValues = new SimpleArrayMap<>();
    }

    public static void addInfoFromAnimator(@NonNull MotionSpec motionSpec, Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, motionSpec, animator) == null) {
            if (animator instanceof ObjectAnimator) {
                ObjectAnimator objectAnimator = (ObjectAnimator) animator;
                motionSpec.setPropertyValues(objectAnimator.getPropertyName(), objectAnimator.getValues());
                motionSpec.setTiming(objectAnimator.getPropertyName(), MotionTiming.createFromAnimator(objectAnimator));
                return;
            }
            throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
        }
    }

    @NonNull
    private PropertyValuesHolder[] clonePropertyValuesHolder(@NonNull PropertyValuesHolder[] propertyValuesHolderArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, propertyValuesHolderArr)) == null) {
            PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[propertyValuesHolderArr.length];
            for (int i = 0; i < propertyValuesHolderArr.length; i++) {
                propertyValuesHolderArr2[i] = propertyValuesHolderArr[i].clone();
            }
            return propertyValuesHolderArr2;
        }
        return (PropertyValuesHolder[]) invokeL.objValue;
    }

    @Nullable
    public static MotionSpec createFromAttribute(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i) {
        InterceptResult invokeLLI;
        int resourceId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, context, typedArray, i)) == null) {
            if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
                return null;
            }
            return createFromResource(context, resourceId);
        }
        return (MotionSpec) invokeLLI.objValue;
    }

    @Nullable
    public static MotionSpec createFromResource(@NonNull Context context, @AnimatorRes int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i)) == null) {
            try {
                Animator loadAnimator = AnimatorInflater.loadAnimator(context, i);
                if (loadAnimator instanceof AnimatorSet) {
                    return createSpecFromAnimators(((AnimatorSet) loadAnimator).getChildAnimations());
                }
                if (loadAnimator != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(loadAnimator);
                    return createSpecFromAnimators(arrayList);
                }
                return null;
            } catch (Exception e2) {
                Log.w(TAG, "Can't load animation resource ID #0x" + Integer.toHexString(i), e2);
                return null;
            }
        }
        return (MotionSpec) invokeLI.objValue;
    }

    @NonNull
    public static MotionSpec createSpecFromAnimators(@NonNull List<Animator> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            MotionSpec motionSpec = new MotionSpec();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                addInfoFromAnimator(motionSpec, list.get(i));
            }
            return motionSpec;
        }
        return (MotionSpec) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MotionSpec) {
                return this.timings.equals(((MotionSpec) obj).timings);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public <T> ObjectAnimator getAnimator(@NonNull String str, @NonNull T t, @NonNull Property<T, ?> property) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, t, property)) == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(t, getPropertyValues(str));
            ofPropertyValuesHolder.setProperty(property);
            getTiming(str).apply(ofPropertyValuesHolder);
            return ofPropertyValuesHolder;
        }
        return (ObjectAnimator) invokeLLL.objValue;
    }

    @NonNull
    public PropertyValuesHolder[] getPropertyValues(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (hasPropertyValues(str)) {
                return clonePropertyValuesHolder(this.propertyValues.get(str));
            }
            throw new IllegalArgumentException();
        }
        return (PropertyValuesHolder[]) invokeL.objValue;
    }

    public MotionTiming getTiming(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (hasTiming(str)) {
                return this.timings.get(str);
            }
            throw new IllegalArgumentException();
        }
        return (MotionTiming) invokeL.objValue;
    }

    public long getTotalDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int size = this.timings.size();
            long j = 0;
            for (int i = 0; i < size; i++) {
                MotionTiming valueAt = this.timings.valueAt(i);
                j = Math.max(j, valueAt.getDelay() + valueAt.getDuration());
            }
            return j;
        }
        return invokeV.longValue;
    }

    public boolean hasPropertyValues(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? this.propertyValues.get(str) != null : invokeL.booleanValue;
    }

    public boolean hasTiming(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? this.timings.get(str) != null : invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.timings.hashCode() : invokeV.intValue;
    }

    public void setPropertyValues(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, propertyValuesHolderArr) == null) {
            this.propertyValues.put(str, propertyValuesHolderArr);
        }
    }

    public void setTiming(String str, @Nullable MotionTiming motionTiming) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, motionTiming) == null) {
            this.timings.put(str, motionTiming);
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return '\n' + MotionSpec.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.timings + "}\n";
        }
        return (String) invokeV.objValue;
    }
}
