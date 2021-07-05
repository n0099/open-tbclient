package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
/* loaded from: classes7.dex */
public final class Month implements Comparable<Month>, Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<Month> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public final int daysInMonth;
    public final int daysInWeek;
    @NonNull
    public final Calendar firstOfMonth;
    @NonNull
    public final String longName;
    public final int month;
    public final long timeInMillis;
    public final int year;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1507480062, "Lcom/google/android/material/datepicker/Month;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1507480062, "Lcom/google/android/material/datepicker/Month;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<Month>() { // from class: com.google.android.material.datepicker.Month.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NonNull
            public Month createFromParcel(@NonNull Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? Month.create(parcel.readInt(), parcel.readInt()) : (Month) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NonNull
            public Month[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new Month[i2] : (Month[]) invokeI.objValue;
            }
        };
    }

    public Month(@NonNull Calendar calendar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {calendar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        calendar.set(5, 1);
        Calendar dayCopy = UtcDates.getDayCopy(calendar);
        this.firstOfMonth = dayCopy;
        this.month = dayCopy.get(2);
        this.year = this.firstOfMonth.get(1);
        this.daysInWeek = this.firstOfMonth.getMaximum(7);
        this.daysInMonth = this.firstOfMonth.getActualMaximum(5);
        this.longName = UtcDates.getYearMonthFormat().format(this.firstOfMonth.getTime());
        this.timeInMillis = this.firstOfMonth.getTimeInMillis();
    }

    @NonNull
    public static Month create(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j)) == null) {
            Calendar utcCalendar = UtcDates.getUtcCalendar();
            utcCalendar.setTimeInMillis(j);
            return new Month(utcCalendar);
        }
        return (Month) invokeJ.objValue;
    }

    @NonNull
    public static Month current() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? new Month(UtcDates.getTodayCalendar()) : (Month) invokeV.objValue;
    }

    public int daysFromStartOfWeekToFirstOfMonth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int firstDayOfWeek = this.firstOfMonth.get(7) - this.firstOfMonth.getFirstDayOfWeek();
            return firstDayOfWeek < 0 ? firstDayOfWeek + this.daysInWeek : firstDayOfWeek;
        }
        return invokeV.intValue;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Month) {
                Month month = (Month) obj;
                return this.month == month.month && this.year == month.year;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public long getDay(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            Calendar dayCopy = UtcDates.getDayCopy(this.firstOfMonth);
            dayCopy.set(5, i2);
            return dayCopy.getTimeInMillis();
        }
        return invokeI.longValue;
    }

    @NonNull
    public String getLongName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.longName : (String) invokeV.objValue;
    }

    public long getStableId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.firstOfMonth.getTimeInMillis() : invokeV.longValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? Arrays.hashCode(new Object[]{Integer.valueOf(this.month), Integer.valueOf(this.year)}) : invokeV.intValue;
    }

    @NonNull
    public Month monthsLater(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            Calendar dayCopy = UtcDates.getDayCopy(this.firstOfMonth);
            dayCopy.add(2, i2);
            return new Month(dayCopy);
        }
        return (Month) invokeI.objValue;
    }

    public int monthsUntil(@NonNull Month month) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, month)) == null) {
            if (this.firstOfMonth instanceof GregorianCalendar) {
                return ((month.year - this.year) * 12) + (month.month - this.month);
            }
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        return invokeL.intValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, parcel, i2) == null) {
            parcel.writeInt(this.year);
            parcel.writeInt(this.month);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(@NonNull Month month) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, month)) == null) ? this.firstOfMonth.compareTo(month.firstOfMonth) : invokeL.intValue;
    }

    @NonNull
    public static Month create(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i2, i3)) == null) {
            Calendar utcCalendar = UtcDates.getUtcCalendar();
            utcCalendar.set(1, i2);
            utcCalendar.set(2, i3);
            return new Month(utcCalendar);
        }
        return (Month) invokeII.objValue;
    }
}
