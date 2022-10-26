package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
/* loaded from: classes7.dex */
public class RangeDateSelector implements DateSelector {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public final String invalidRangeEndError;
    public String invalidRangeStartError;
    public Long proposedTextEnd;
    public Long proposedTextStart;
    public Long selectedEndItem;
    public Long selectedStartItem;

    private boolean isValidRange(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? j <= j2 : invokeCommon.booleanValue;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultTitleResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.string.obfuscated_res_0x7f0f0b3e : invokeV.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-258446408, "Lcom/google/android/material/datepicker/RangeDateSelector;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-258446408, "Lcom/google/android/material/datepicker/RangeDateSelector;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator() { // from class: com.google.android.material.datepicker.RangeDateSelector.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            public RangeDateSelector createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    RangeDateSelector rangeDateSelector = new RangeDateSelector();
                    rangeDateSelector.selectedStartItem = (Long) parcel.readValue(Long.class.getClassLoader());
                    rangeDateSelector.selectedEndItem = (Long) parcel.readValue(Long.class.getClassLoader());
                    return rangeDateSelector;
                }
                return (RangeDateSelector) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            public RangeDateSelector[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new RangeDateSelector[i];
                }
                return (RangeDateSelector[]) invokeI.objValue;
            }
        };
    }

    public RangeDateSelector() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.invalidRangeEndError = " ";
        this.selectedStartItem = null;
        this.selectedEndItem = null;
        this.proposedTextStart = null;
        this.proposedTextEnd = null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection getSelectedDays() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Long l = this.selectedStartItem;
            if (l != null) {
                arrayList.add(l);
            }
            Long l2 = this.selectedEndItem;
            if (l2 != null) {
                arrayList.add(l2);
            }
            return arrayList;
        }
        return (Collection) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.datepicker.DateSelector
    public Pair getSelection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return new Pair(this.selectedStartItem, this.selectedEndItem);
        }
        return (Pair) invokeV.objValue;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean isSelectionComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Long l = this.selectedStartItem;
            if (l != null && this.selectedEndItem != null && isValidRange(l.longValue(), this.selectedEndItem.longValue())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void setInvalidRange(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, textInputLayout, textInputLayout2) == null) {
            textInputLayout.setError(this.invalidRangeStartError);
            textInputLayout2.setError(" ");
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, parcel, i) == null) {
            parcel.writeValue(this.selectedStartItem);
            parcel.writeValue(this.selectedEndItem);
        }
    }

    private void clearInvalidRange(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, textInputLayout, textInputLayout2) == null) {
            if (textInputLayout.getError() != null && this.invalidRangeStartError.contentEquals(textInputLayout.getError())) {
                textInputLayout.setError(null);
            }
            if (textInputLayout2.getError() != null && " ".contentEquals(textInputLayout2.getError())) {
                textInputLayout2.setError(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateIfValidTextProposal(TextInputLayout textInputLayout, TextInputLayout textInputLayout2, OnSelectionChangedListener onSelectionChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, this, textInputLayout, textInputLayout2, onSelectionChangedListener) == null) {
            Long l = this.proposedTextStart;
            if (l != null && this.proposedTextEnd != null) {
                if (isValidRange(l.longValue(), this.proposedTextEnd.longValue())) {
                    this.selectedStartItem = this.proposedTextStart;
                    this.selectedEndItem = this.proposedTextEnd;
                    onSelectionChangedListener.onSelectionChanged(getSelection());
                    return;
                }
                setInvalidRange(textInputLayout, textInputLayout2);
                onSelectionChangedListener.onIncompleteSelectionChanged();
                return;
            }
            clearInvalidRange(textInputLayout, textInputLayout2);
            onSelectionChangedListener.onIncompleteSelectionChanged();
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultThemeResId(Context context) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            Resources resources = context.getResources();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            if (Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07046b)) {
                i = R.attr.obfuscated_res_0x7f0404b6;
            } else {
                i = R.attr.obfuscated_res_0x7f0404ae;
            }
            return MaterialAttributes.resolveOrThrow(context, i, MaterialDatePicker.class.getCanonicalName());
        }
        return invokeL.intValue;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void select(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            Long l = this.selectedStartItem;
            if (l == null) {
                this.selectedStartItem = Long.valueOf(j);
            } else if (this.selectedEndItem == null && isValidRange(l.longValue(), j)) {
                this.selectedEndItem = Long.valueOf(j);
            } else {
                this.selectedEndItem = null;
                this.selectedStartItem = Long.valueOf(j);
            }
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection getSelectedRanges() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.selectedStartItem != null && this.selectedEndItem != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair(this.selectedStartItem, this.selectedEndItem));
                return arrayList;
            }
            return new ArrayList();
        }
        return (Collection) invokeV.objValue;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String getSelectionDisplayString(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            Resources resources = context.getResources();
            if (this.selectedStartItem == null && this.selectedEndItem == null) {
                return resources.getString(R.string.obfuscated_res_0x7f0f0b3f);
            }
            Long l = this.selectedEndItem;
            if (l == null) {
                return resources.getString(R.string.obfuscated_res_0x7f0f0b3c, DateStrings.getDateString(this.selectedStartItem.longValue()));
            }
            Long l2 = this.selectedStartItem;
            if (l2 == null) {
                return resources.getString(R.string.obfuscated_res_0x7f0f0b3b, DateStrings.getDateString(l.longValue()));
            }
            Pair dateRangeString = DateStrings.getDateRangeString(l2, l);
            return resources.getString(R.string.obfuscated_res_0x7f0f0b3d, dateRangeString.first, dateRangeString.second);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View onCreateTextInputView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, OnSelectionChangedListener onSelectionChangedListener) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048585, this, layoutInflater, viewGroup, bundle, calendarConstraints, onSelectionChangedListener)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d05c4, viewGroup, false);
            TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091593);
            TextInputLayout textInputLayout2 = (TextInputLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091592);
            EditText editText = textInputLayout.getEditText();
            EditText editText2 = textInputLayout2.getEditText();
            if (ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters()) {
                editText.setInputType(17);
                editText2.setInputType(17);
            }
            this.invalidRangeStartError = inflate.getResources().getString(R.string.obfuscated_res_0x7f0f0b38);
            SimpleDateFormat textInputFormat = UtcDates.getTextInputFormat();
            Long l = this.selectedStartItem;
            if (l != null) {
                editText.setText(textInputFormat.format(l));
                this.proposedTextStart = this.selectedStartItem;
            }
            Long l2 = this.selectedEndItem;
            if (l2 != null) {
                editText2.setText(textInputFormat.format(l2));
                this.proposedTextEnd = this.selectedEndItem;
            }
            String textInputHint = UtcDates.getTextInputHint(inflate.getResources(), textInputFormat);
            editText.addTextChangedListener(new DateFormatTextWatcher(this, textInputHint, textInputFormat, textInputLayout, calendarConstraints, textInputLayout, textInputLayout2, onSelectionChangedListener) { // from class: com.google.android.material.datepicker.RangeDateSelector.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RangeDateSelector this$0;
                public final /* synthetic */ TextInputLayout val$endTextInput;
                public final /* synthetic */ OnSelectionChangedListener val$listener;
                public final /* synthetic */ TextInputLayout val$startTextInput;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(textInputHint, textInputFormat, textInputLayout, calendarConstraints);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r3;
                        Object[] objArr = {this, textInputHint, textInputFormat, textInputLayout, calendarConstraints, textInputLayout, textInputLayout2, onSelectionChangedListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], (DateFormat) objArr2[1], (TextInputLayout) objArr2[2], (CalendarConstraints) objArr2[3]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$startTextInput = textInputLayout;
                    this.val$endTextInput = textInputLayout2;
                    this.val$listener = onSelectionChangedListener;
                }

                @Override // com.google.android.material.datepicker.DateFormatTextWatcher
                public void onInvalidDate() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.proposedTextStart = null;
                        this.this$0.updateIfValidTextProposal(this.val$startTextInput, this.val$endTextInput, this.val$listener);
                    }
                }

                @Override // com.google.android.material.datepicker.DateFormatTextWatcher
                public void onValidDate(Long l3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l3) == null) {
                        this.this$0.proposedTextStart = l3;
                        this.this$0.updateIfValidTextProposal(this.val$startTextInput, this.val$endTextInput, this.val$listener);
                    }
                }
            });
            editText2.addTextChangedListener(new DateFormatTextWatcher(this, textInputHint, textInputFormat, textInputLayout2, calendarConstraints, textInputLayout, textInputLayout2, onSelectionChangedListener) { // from class: com.google.android.material.datepicker.RangeDateSelector.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RangeDateSelector this$0;
                public final /* synthetic */ TextInputLayout val$endTextInput;
                public final /* synthetic */ OnSelectionChangedListener val$listener;
                public final /* synthetic */ TextInputLayout val$startTextInput;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(textInputHint, textInputFormat, textInputLayout2, calendarConstraints);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r3;
                        Object[] objArr = {this, textInputHint, textInputFormat, textInputLayout2, calendarConstraints, textInputLayout, textInputLayout2, onSelectionChangedListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], (DateFormat) objArr2[1], (TextInputLayout) objArr2[2], (CalendarConstraints) objArr2[3]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$startTextInput = textInputLayout;
                    this.val$endTextInput = textInputLayout2;
                    this.val$listener = onSelectionChangedListener;
                }

                @Override // com.google.android.material.datepicker.DateFormatTextWatcher
                public void onInvalidDate() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.proposedTextEnd = null;
                        this.this$0.updateIfValidTextProposal(this.val$startTextInput, this.val$endTextInput, this.val$listener);
                    }
                }

                @Override // com.google.android.material.datepicker.DateFormatTextWatcher
                public void onValidDate(Long l3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l3) == null) {
                        this.this$0.proposedTextEnd = l3;
                        this.this$0.updateIfValidTextProposal(this.val$startTextInput, this.val$endTextInput, this.val$listener);
                    }
                }
            });
            ViewUtils.requestFocusAndShowKeyboard(editText);
            return inflate;
        }
        return (View) invokeLLLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.datepicker.DateSelector
    public void setSelection(Pair pair) {
        Long valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, pair) == null) {
            F f = pair.first;
            if (f != 0 && pair.second != 0) {
                Preconditions.checkArgument(isValidRange(((Long) f).longValue(), ((Long) pair.second).longValue()));
            }
            F f2 = pair.first;
            Long l = null;
            if (f2 == 0) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(UtcDates.canonicalYearMonthDay(((Long) f2).longValue()));
            }
            this.selectedStartItem = valueOf;
            S s = pair.second;
            if (s != 0) {
                l = Long.valueOf(UtcDates.canonicalYearMonthDay(((Long) s).longValue()));
            }
            this.selectedEndItem = l;
        }
    }
}
