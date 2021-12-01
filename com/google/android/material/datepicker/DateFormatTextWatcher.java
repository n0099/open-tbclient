package com.google.android.material.datepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes2.dex */
public abstract class DateFormatTextWatcher implements TextWatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CalendarConstraints constraints;
    public final DateFormat dateFormat;
    public final String formatHint;
    public final String outOfRange;
    @NonNull
    public final TextInputLayout textInputLayout;

    public DateFormatTextWatcher(String str, DateFormat dateFormat, @NonNull TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, dateFormat, textInputLayout, calendarConstraints};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.formatHint = str;
        this.dateFormat = dateFormat;
        this.textInputLayout = textInputLayout;
        this.constraints = calendarConstraints;
        this.outOfRange = textInputLayout.getContext().getString(R.string.mtrl_picker_out_of_range);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
        }
    }

    public void onInvalidDate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@NonNull CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048579, this, charSequence, i2, i3, i4) == null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.textInputLayout.setError(null);
                onValidDate(null);
                return;
            }
            try {
                Date parse = this.dateFormat.parse(charSequence.toString());
                this.textInputLayout.setError(null);
                long time = parse.getTime();
                if (this.constraints.getDateValidator().isValid(time) && this.constraints.isWithinBounds(time)) {
                    onValidDate(Long.valueOf(parse.getTime()));
                } else {
                    this.textInputLayout.setError(String.format(this.outOfRange, DateStrings.getDateString(time)));
                    onInvalidDate();
                }
            } catch (ParseException unused) {
                String string = this.textInputLayout.getContext().getString(R.string.mtrl_picker_invalid_format);
                String format = String.format(this.textInputLayout.getContext().getString(R.string.mtrl_picker_invalid_format_use), this.formatHint);
                String format2 = String.format(this.textInputLayout.getContext().getString(R.string.mtrl_picker_invalid_format_example), this.dateFormat.format(new Date(UtcDates.getTodayCalendar().getTimeInMillis())));
                TextInputLayout textInputLayout = this.textInputLayout;
                textInputLayout.setError(string + StringUtils.LF + format + StringUtils.LF + format2);
                onInvalidDate();
            }
        }
    }

    public abstract void onValidDate(@Nullable Long l);
}
