package com.google.android.material.datepicker;

import android.os.Bundle;
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
/* loaded from: classes3.dex */
public final class CalendarConstraints implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<CalendarConstraints> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final Month end;
    public final int monthSpan;
    @NonNull
    public final Month openAt;
    @NonNull
    public final Month start;
    public final DateValidator validator;
    public final int yearSpan;

    /* loaded from: classes3.dex */
    public interface DateValidator extends Parcelable {
        boolean isValid(long j2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1299285206, "Lcom/google/android/material/datepicker/CalendarConstraints;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1299285206, "Lcom/google/android/material/datepicker/CalendarConstraints;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<CalendarConstraints>() { // from class: com.google.android.material.datepicker.CalendarConstraints.1
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
            public CalendarConstraints createFromParcel(@NonNull Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader())) : (CalendarConstraints) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NonNull
            public CalendarConstraints[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new CalendarConstraints[i2] : (CalendarConstraints[]) invokeI.objValue;
            }
        };
    }

    public Month clamp(Month month) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, month)) == null) {
            if (month.compareTo(this.start) < 0) {
                return this.start;
            }
            return month.compareTo(this.end) > 0 ? this.end : month;
        }
        return (Month) invokeL.objValue;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CalendarConstraints) {
                CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
                return this.start.equals(calendarConstraints.start) && this.end.equals(calendarConstraints.end) && this.openAt.equals(calendarConstraints.openAt) && this.validator.equals(calendarConstraints.validator);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public DateValidator getDateValidator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.validator : (DateValidator) invokeV.objValue;
    }

    @NonNull
    public Month getEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.end : (Month) invokeV.objValue;
    }

    public int getMonthSpan() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.monthSpan : invokeV.intValue;
    }

    @NonNull
    public Month getOpenAt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.openAt : (Month) invokeV.objValue;
    }

    @NonNull
    public Month getStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.start : (Month) invokeV.objValue;
    }

    public int getYearSpan() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.yearSpan : invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? Arrays.hashCode(new Object[]{this.start, this.end, this.openAt, this.validator}) : invokeV.intValue;
    }

    public boolean isWithinBounds(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j2)) == null) {
            if (this.start.getDay(1) <= j2) {
                Month month = this.end;
                if (j2 <= month.getDay(month.daysInMonth)) {
                    return true;
                }
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, parcel, i2) == null) {
            parcel.writeParcelable(this.start, 0);
            parcel.writeParcelable(this.end, 0);
            parcel.writeParcelable(this.openAt, 0);
            parcel.writeParcelable(this.validator, 0);
        }
    }

    public CalendarConstraints(@NonNull Month month, @NonNull Month month2, @NonNull Month month3, DateValidator dateValidator) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {month, month2, month3, dateValidator};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.start = month;
        this.end = month2;
        this.openAt = month3;
        this.validator = dateValidator;
        if (month.compareTo(month3) <= 0) {
            if (month3.compareTo(month2) <= 0) {
                this.monthSpan = month.monthsUntil(month2) + 1;
                this.yearSpan = (month2.year - month.year) + 1;
                return;
            }
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        throw new IllegalArgumentException("start Month cannot be after current Month");
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String DEEP_COPY_VALIDATOR_KEY = "DEEP_COPY_VALIDATOR_KEY";
        public static final long DEFAULT_END;
        public static final long DEFAULT_START;
        public transient /* synthetic */ FieldHolder $fh;
        public long end;
        public Long openAt;
        public long start;
        public DateValidator validator;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-712237005, "Lcom/google/android/material/datepicker/CalendarConstraints$Builder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-712237005, "Lcom/google/android/material/datepicker/CalendarConstraints$Builder;");
                    return;
                }
            }
            DEFAULT_START = UtcDates.canonicalYearMonthDay(Month.create(1900, 0).timeInMillis);
            DEFAULT_END = UtcDates.canonicalYearMonthDay(Month.create(2100, 11).timeInMillis);
        }

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.start = DEFAULT_START;
            this.end = DEFAULT_END;
            this.validator = DateValidatorPointForward.from(Long.MIN_VALUE);
        }

        @NonNull
        public CalendarConstraints build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.openAt == null) {
                    long thisMonthInUtcMilliseconds = MaterialDatePicker.thisMonthInUtcMilliseconds();
                    if (this.start > thisMonthInUtcMilliseconds || thisMonthInUtcMilliseconds > this.end) {
                        thisMonthInUtcMilliseconds = this.start;
                    }
                    this.openAt = Long.valueOf(thisMonthInUtcMilliseconds);
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable(DEEP_COPY_VALIDATOR_KEY, this.validator);
                return new CalendarConstraints(Month.create(this.start), Month.create(this.end), Month.create(this.openAt.longValue()), (DateValidator) bundle.getParcelable(DEEP_COPY_VALIDATOR_KEY));
            }
            return (CalendarConstraints) invokeV.objValue;
        }

        @NonNull
        public Builder setEnd(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                this.end = j2;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        @NonNull
        public Builder setOpenAt(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
                this.openAt = Long.valueOf(j2);
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        @NonNull
        public Builder setStart(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) {
                this.start = j2;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        @NonNull
        public Builder setValidator(DateValidator dateValidator) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, dateValidator)) == null) {
                this.validator = dateValidator;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder(@NonNull CalendarConstraints calendarConstraints) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {calendarConstraints};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.start = DEFAULT_START;
            this.end = DEFAULT_END;
            this.validator = DateValidatorPointForward.from(Long.MIN_VALUE);
            this.start = calendarConstraints.start.timeInMillis;
            this.end = calendarConstraints.end.timeInMillis;
            this.openAt = Long.valueOf(calendarConstraints.openAt.timeInMillis);
            this.validator = calendarConstraints.validator;
        }
    }
}
