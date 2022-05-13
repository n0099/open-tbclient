package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;
/* loaded from: classes4.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(MaterialAttributes.resolveOrThrow(context, R.attr.obfuscated_res_0x7f040457, MaterialCalendar.class.getCanonicalName()), new int[]{16843277, R.attr.obfuscated_res_0x7f0401e0, R.attr.obfuscated_res_0x7f0401e1, R.attr.obfuscated_res_0x7f0401e2, R.attr.obfuscated_res_0x7f0401e3, R.attr.obfuscated_res_0x7f040526, R.attr.obfuscated_res_0x7f0406e4, R.attr.obfuscated_res_0x7f0406e5, R.attr.obfuscated_res_0x7f0406e6});
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
