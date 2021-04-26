package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class MonthAdapter extends BaseAdapter {
    public static final int MAXIMUM_WEEKS = UtcDates.getUtcCalendar().getMaximum(4);
    public final CalendarConstraints calendarConstraints;
    public CalendarStyle calendarStyle;
    public final DateSelector<?> dateSelector;
    public final Month month;

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

    public int dayToPosition(int i2) {
        return firstPositionInMonth() + (i2 - 1);
    }

    public int firstPositionInMonth() {
        return this.month.daysFromStartOfWeekToFirstOfMonth();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.month.daysInMonth + firstPositionInMonth();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2 / this.month.daysInWeek;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public boolean isFirstInRow(int i2) {
        return i2 % this.month.daysInWeek == 0;
    }

    public boolean isLastInRow(int i2) {
        return (i2 + 1) % this.month.daysInWeek == 0;
    }

    public int lastPositionInMonth() {
        return (this.month.daysFromStartOfWeekToFirstOfMonth() + this.month.daysInMonth) - 1;
    }

    public int positionToDay(int i2) {
        return (i2 - this.month.daysFromStartOfWeekToFirstOfMonth()) + 1;
    }

    public boolean withinMonth(int i2) {
        return i2 >= firstPositionInMonth() && i2 <= lastPositionInMonth();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    @Nullable
    public Long getItem(int i2) {
        if (i2 < this.month.daysFromStartOfWeekToFirstOfMonth() || i2 > lastPositionInMonth()) {
            return null;
        }
        return Long.valueOf(this.month.getDay(positionToDay(i2)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0070  */
    @Override // android.widget.Adapter
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TextView getView(int i2, @Nullable View view, @NonNull ViewGroup viewGroup) {
        Long item;
        initializeStyles(viewGroup.getContext());
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_day, viewGroup, false);
        }
        int firstPositionInMonth = i2 - firstPositionInMonth();
        if (firstPositionInMonth >= 0) {
            Month month = this.month;
            if (firstPositionInMonth < month.daysInMonth) {
                int i3 = firstPositionInMonth + 1;
                textView.setTag(month);
                textView.setText(String.valueOf(i3));
                long day = this.month.getDay(i3);
                if (this.month.year == Month.current().year) {
                    textView.setContentDescription(DateStrings.getMonthDayOfWeekDay(day));
                } else {
                    textView.setContentDescription(DateStrings.getYearMonthDayOfWeekDay(day));
                }
                textView.setVisibility(0);
                textView.setEnabled(true);
                item = getItem(i2);
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
        item = getItem(i2);
        if (item != null) {
        }
    }
}
