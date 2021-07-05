package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;
/* loaded from: classes7.dex */
public final class CalendarStyle {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final CalendarItemStyle day;
    @NonNull
    public final CalendarItemStyle invalidDay;
    @NonNull
    public final Paint rangeFill;
    @NonNull
    public final CalendarItemStyle selectedDay;
    @NonNull
    public final CalendarItemStyle selectedYear;
    @NonNull
    public final CalendarItemStyle todayDay;
    @NonNull
    public final CalendarItemStyle todayYear;
    @NonNull
    public final CalendarItemStyle year;

    public CalendarStyle(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(MaterialAttributes.resolveOrThrow(context, R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), R.styleable.MaterialCalendar);
        this.day = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayStyle, 0));
        this.invalidDay = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayInvalidStyle, 0));
        this.selectedDay = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_daySelectedStyle, 0));
        this.todayDay = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList colorStateList = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.MaterialCalendar_rangeFillColor);
        this.year = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearStyle, 0));
        this.selectedYear = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearSelectedStyle, 0));
        this.todayYear = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.rangeFill = paint;
        paint.setColor(colorStateList.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
