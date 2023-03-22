package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class MonthAdapter extends BaseAdapter {
    public static final int MAXIMUM_WEEKS = UtcDates.getUtcCalendar().getMaximum(4);
    public final CalendarConstraints calendarConstraints;
    public CalendarStyle calendarStyle;
    public final DateSelector<?> dateSelector;
    public final Month month;

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public int firstPositionInMonth() {
        return this.month.daysFromStartOfWeekToFirstOfMonth();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.month.daysInMonth + firstPositionInMonth();
    }

    public int lastPositionInMonth() {
        return (this.month.daysFromStartOfWeekToFirstOfMonth() + this.month.daysInMonth) - 1;
    }

    public MonthAdapter(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints) {
        this.month = month;
        this.dateSelector = dateSelector;
        this.calendarConstraints = calendarConstraints;
    }

    private void initializeStyles(Context context) {
        if (this.calendarStyle == null) {
            this.calendarStyle = new CalendarStyle(context);
        }
    }

    public int dayToPosition(int i) {
        return firstPositionInMonth() + (i - 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    @Nullable
    public Long getItem(int i) {
        if (i >= this.month.daysFromStartOfWeekToFirstOfMonth() && i <= lastPositionInMonth()) {
            return Long.valueOf(this.month.getDay(positionToDay(i)));
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i / this.month.daysInWeek;
    }

    public boolean isFirstInRow(int i) {
        if (i % this.month.daysInWeek == 0) {
            return true;
        }
        return false;
    }

    public boolean isLastInRow(int i) {
        if ((i + 1) % this.month.daysInWeek == 0) {
            return true;
        }
        return false;
    }

    public int positionToDay(int i) {
        return (i - this.month.daysFromStartOfWeekToFirstOfMonth()) + 1;
    }

    public boolean withinMonth(int i) {
        if (i >= firstPositionInMonth() && i <= lastPositionInMonth()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0070 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0071  */
    @Override // android.widget.Adapter
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TextView getView(int i, @Nullable View view2, @NonNull ViewGroup viewGroup) {
        Long item;
        initializeStyles(viewGroup.getContext());
        TextView textView = (TextView) view2;
        if (view2 == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d05f3, viewGroup, false);
        }
        int firstPositionInMonth = i - firstPositionInMonth();
        if (firstPositionInMonth >= 0) {
            Month month = this.month;
            if (firstPositionInMonth < month.daysInMonth) {
                int i2 = firstPositionInMonth + 1;
                textView.setTag(month);
                textView.setText(String.valueOf(i2));
                long day = this.month.getDay(i2);
                if (this.month.year == Month.current().year) {
                    textView.setContentDescription(DateStrings.getMonthDayOfWeekDay(day));
                } else {
                    textView.setContentDescription(DateStrings.getYearMonthDayOfWeekDay(day));
                }
                textView.setVisibility(0);
                textView.setEnabled(true);
                item = getItem(i);
                if (item != null) {
                    return textView;
                }
                if (this.calendarConstraints.getDateValidator().isValid(item.longValue())) {
                    textView.setEnabled(true);
                    Iterator<Long> it = this.dateSelector.getSelectedDays().iterator();
                    while (it.hasNext()) {
                        if (UtcDates.canonicalYearMonthDay(item.longValue()) == UtcDates.canonicalYearMonthDay(it.next().longValue())) {
                            this.calendarStyle.selectedDay.styleItem(textView);
                            return textView;
                        }
                    }
                    if (UtcDates.getTodayCalendar().getTimeInMillis() == item.longValue()) {
                        this.calendarStyle.todayDay.styleItem(textView);
                        return textView;
                    }
                    this.calendarStyle.day.styleItem(textView);
                    return textView;
                }
                textView.setEnabled(false);
                this.calendarStyle.invalidDay.styleItem(textView);
                return textView;
            }
        }
        textView.setVisibility(8);
        textView.setEnabled(false);
        item = getItem(i);
        if (item != null) {
        }
    }
}
