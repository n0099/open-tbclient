package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public final class MaterialTextInputPicker<S> extends PickerFragment<S> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    public static final String DATE_SELECTOR_KEY = "DATE_SELECTOR_KEY";
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public CalendarConstraints calendarConstraints;
    @Nullable
    public DateSelector<S> dateSelector;

    public MaterialTextInputPicker() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    @NonNull
    public DateSelector<S> getDateSelector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            DateSelector<S> dateSelector = this.dateSelector;
            if (dateSelector != null) {
                return dateSelector;
            }
            throw new IllegalStateException("dateSelector should not be null. Use MaterialTextInputPicker#newInstance() to create this fragment with a DateSelector, and call this method after the fragment has been created.");
        }
        return (DateSelector) invokeV.objValue;
    }

    @NonNull
    public static <T> MaterialTextInputPicker<T> newInstance(@NonNull DateSelector<T> dateSelector, @NonNull CalendarConstraints calendarConstraints) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, dateSelector, calendarConstraints)) == null) {
            MaterialTextInputPicker<T> materialTextInputPicker = new MaterialTextInputPicker<>();
            Bundle bundle = new Bundle();
            bundle.putParcelable("DATE_SELECTOR_KEY", dateSelector);
            bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
            materialTextInputPicker.setArguments(bundle);
            return materialTextInputPicker;
        }
        return (MaterialTextInputPicker) invokeLL.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle == null) {
                bundle = getArguments();
            }
            this.dateSelector = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
            this.calendarConstraints = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putParcelable("DATE_SELECTOR_KEY", this.dateSelector);
            bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.calendarConstraints);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater, viewGroup, bundle)) == null) {
            return this.dateSelector.onCreateTextInputView(layoutInflater, viewGroup, bundle, this.calendarConstraints, new OnSelectionChangedListener<S>(this) { // from class: com.google.android.material.datepicker.MaterialTextInputPicker.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MaterialTextInputPicker this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.google.android.material.datepicker.OnSelectionChangedListener
                public void onSelectionChanged(S s) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s) == null) {
                        Iterator<OnSelectionChangedListener<S>> it = this.this$0.onSelectionChangedListeners.iterator();
                        while (it.hasNext()) {
                            it.next().onSelectionChanged(s);
                        }
                    }
                }

                @Override // com.google.android.material.datepicker.OnSelectionChangedListener
                public void onIncompleteSelectionChanged() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Iterator<OnSelectionChangedListener<S>> it = this.this$0.onSelectionChangedListeners.iterator();
                        while (it.hasNext()) {
                            it.next().onIncompleteSelectionChanged();
                        }
                    }
                }
            });
        }
        return (View) invokeLLL.objValue;
    }
}
