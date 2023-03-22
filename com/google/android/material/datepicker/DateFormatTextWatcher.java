package com.google.android.material.datepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
/* loaded from: classes7.dex */
public abstract class DateFormatTextWatcher implements TextWatcher {
    public final CalendarConstraints constraints;
    public final DateFormat dateFormat;
    public final String formatHint;
    public final String outOfRange;
    @NonNull
    public final TextInputLayout textInputLayout;

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onInvalidDate() {
    }

    public abstract void onValidDate(@Nullable Long l);

    public DateFormatTextWatcher(String str, DateFormat dateFormat, @NonNull TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.formatHint = str;
        this.dateFormat = dateFormat;
        this.textInputLayout = textInputLayout;
        this.constraints = calendarConstraints;
        this.outOfRange = textInputLayout.getContext().getString(R.string.obfuscated_res_0x7f0f0bde);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@NonNull CharSequence charSequence, int i, int i2, int i3) {
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
            String string = this.textInputLayout.getContext().getString(R.string.obfuscated_res_0x7f0f0bd9);
            String format = String.format(this.textInputLayout.getContext().getString(R.string.obfuscated_res_0x7f0f0bdb), this.formatHint);
            String format2 = String.format(this.textInputLayout.getContext().getString(R.string.obfuscated_res_0x7f0f0bda), this.dateFormat.format(new Date(UtcDates.getTodayCalendar().getTimeInMillis())));
            TextInputLayout textInputLayout = this.textInputLayout;
            textInputLayout.setError(string + "\n" + format + "\n" + format2);
            onInvalidDate();
        }
    }
}
