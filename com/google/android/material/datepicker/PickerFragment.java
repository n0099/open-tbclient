package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashSet;
/* loaded from: classes7.dex */
public abstract class PickerFragment extends Fragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedHashSet onSelectionChangedListeners;

    public abstract DateSelector getDateSelector();

    public PickerFragment() {
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
        this.onSelectionChangedListeners = new LinkedHashSet();
    }

    public void clearOnSelectionChangedListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.onSelectionChangedListeners.clear();
        }
    }

    public boolean addOnSelectionChangedListener(OnSelectionChangedListener onSelectionChangedListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, onSelectionChangedListener)) == null) {
            return this.onSelectionChangedListeners.add(onSelectionChangedListener);
        }
        return invokeL.booleanValue;
    }

    public boolean removeOnSelectionChangedListener(OnSelectionChangedListener onSelectionChangedListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, onSelectionChangedListener)) == null) {
            return this.onSelectionChangedListeners.remove(onSelectionChangedListener);
        }
        return invokeL.booleanValue;
    }
}
