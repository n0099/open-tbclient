package com.google.android.material.datepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
/* loaded from: classes7.dex */
public abstract class DateFormatTextWatcher implements TextWatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CalendarConstraints constraints;
    public final DateFormat dateFormat;
    public final String formatHint;
    public final String outOfRange;
    @NonNull
    public final TextInputLayout textInputLayout;

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
        }
    }

    public void onInvalidDate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public abstract void onValidDate(@Nullable Long l);

    public DateFormatTextWatcher(String str, DateFormat dateFormat, @NonNull TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, dateFormat, textInputLayout, calendarConstraints};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.formatHint = str;
        this.dateFormat = dateFormat;
        this.textInputLayout = textInputLayout;
        this.constraints = calendarConstraints;
        this.outOfRange = textInputLayout.getContext().getString(R.string.obfuscated_res_0x7f0f0b7f);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@NonNull CharSequence charSequence, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048579, this, charSequence, i, i2, i3) == null) {
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
                String string = this.textInputLayout.getContext().getString(R.string.obfuscated_res_0x7f0f0b7a);
                String format = String.format(this.textInputLayout.getContext().getString(R.string.obfuscated_res_0x7f0f0b7c), this.formatHint);
                String format2 = String.format(this.textInputLayout.getContext().getString(R.string.obfuscated_res_0x7f0f0b7b), this.dateFormat.format(new Date(UtcDates.getTodayCalendar().getTimeInMillis())));
                TextInputLayout textInputLayout = this.textInputLayout;
                textInputLayout.setError(string + "\n" + format + "\n" + format2);
                onInvalidDate();
            }
        }
    }
}
