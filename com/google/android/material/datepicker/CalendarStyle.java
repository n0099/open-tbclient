package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;
/* loaded from: classes8.dex */
public final class CalendarStyle {
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(MaterialAttributes.resolveOrThrow(context, R.attr.obfuscated_res_0x7f0404b8, MaterialCalendar.class.getCanonicalName()), com.google.android.material.R.styleable.MaterialCalendar);
        this.day = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(3, 0));
        this.invalidDay = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(1, 0));
        this.selectedDay = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(2, 0));
        this.todayDay = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(4, 0));
        ColorStateList colorStateList = MaterialResources.getColorStateList(context, obtainStyledAttributes, 5);
        this.year = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(7, 0));
        this.selectedYear = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(6, 0));
        this.todayYear = CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(8, 0));
        Paint paint = new Paint();
        this.rangeFill = paint;
        paint.setColor(colorStateList.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
