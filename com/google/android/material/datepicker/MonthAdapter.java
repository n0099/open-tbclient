package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.R;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class MonthAdapter extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public static final int MAXIMUM_WEEKS;
    public transient /* synthetic */ FieldHolder $fh;
    public final CalendarConstraints calendarConstraints;
    public CalendarStyle calendarStyle;
    public final DateSelector<?> dateSelector;
    public final Month month;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1214660795, "Lcom/google/android/material/datepicker/MonthAdapter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1214660795, "Lcom/google/android/material/datepicker/MonthAdapter;");
                return;
            }
        }
        MAXIMUM_WEEKS = UtcDates.getUtcCalendar().getMaximum(4);
    }

    public MonthAdapter(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {month, dateSelector, calendarConstraints};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.month = month;
        this.dateSelector = dateSelector;
        this.calendarConstraints = calendarConstraints;
    }

    private void initializeStyles(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, this, context) == null) && this.calendarStyle == null) {
            this.calendarStyle = new CalendarStyle(context);
        }
    }

    public int dayToPosition(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? firstPositionInMonth() + (i2 - 1) : invokeI.intValue;
    }

    public int firstPositionInMonth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.month.daysFromStartOfWeekToFirstOfMonth() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.month.daysInMonth + firstPositionInMonth() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? i2 / this.month.daysInWeek : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isFirstInRow(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? i2 % this.month.daysInWeek == 0 : invokeI.booleanValue;
    }

    public boolean isLastInRow(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) ? (i2 + 1) % this.month.daysInWeek == 0 : invokeI.booleanValue;
    }

    public int lastPositionInMonth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? (this.month.daysFromStartOfWeekToFirstOfMonth() + this.month.daysInMonth) - 1 : invokeV.intValue;
    }

    public int positionToDay(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) ? (i2 - this.month.daysFromStartOfWeekToFirstOfMonth()) + 1 : invokeI.intValue;
    }

    public boolean withinMonth(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) ? i2 >= firstPositionInMonth() && i2 <= lastPositionInMonth() : invokeI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    @Nullable
    public Long getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (i2 < this.month.daysFromStartOfWeekToFirstOfMonth() || i2 > lastPositionInMonth()) {
                return null;
            }
            return Long.valueOf(this.month.getDay(positionToDay(i2)));
        }
        return (Long) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0073 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0074  */
    @Override // android.widget.Adapter
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TextView getView(int i2, @Nullable View view, @NonNull ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Long item;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) != null) {
            return (TextView) invokeILL.objValue;
        }
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
