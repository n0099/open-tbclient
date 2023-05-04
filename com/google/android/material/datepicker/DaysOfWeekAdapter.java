package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import java.util.Calendar;
import java.util.Locale;
/* loaded from: classes8.dex */
public class DaysOfWeekAdapter extends BaseAdapter {
    public static final int CALENDAR_DAY_STYLE;
    public static final int NARROW_FORMAT = 4;
    @NonNull
    public final Calendar calendar;
    public final int daysInWeek;
    public final int firstDayOfWeek;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    static {
        int i;
        if (Build.VERSION.SDK_INT >= 26) {
            i = 4;
        } else {
            i = 1;
        }
        CALENDAR_DAY_STYLE = i;
    }

    public DaysOfWeekAdapter() {
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        this.calendar = utcCalendar;
        this.daysInWeek = utcCalendar.getMaximum(7);
        this.firstDayOfWeek = this.calendar.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.daysInWeek;
    }

    private int positionToDayOfWeek(int i) {
        int i2 = i + this.firstDayOfWeek;
        int i3 = this.daysInWeek;
        if (i2 > i3) {
            return i2 - i3;
        }
        return i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    @Nullable
    public Integer getItem(int i) {
        if (i >= this.daysInWeek) {
            return null;
        }
        return Integer.valueOf(positionToDayOfWeek(i));
    }

    @Override // android.widget.Adapter
    @Nullable
    @SuppressLint({"WrongConstant"})
    public View getView(int i, @Nullable View view2, @NonNull ViewGroup viewGroup) {
        TextView textView = (TextView) view2;
        if (view2 == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d05fb, viewGroup, false);
        }
        this.calendar.set(7, positionToDayOfWeek(i));
        textView.setText(this.calendar.getDisplayName(7, CALENDAR_DAY_STYLE, Locale.getDefault()));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R.string.obfuscated_res_0x7f0f0be9), this.calendar.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
