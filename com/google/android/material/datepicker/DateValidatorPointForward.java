package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.Arrays;
/* loaded from: classes8.dex */
public class DateValidatorPointForward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointForward> CREATOR = new Parcelable.Creator<DateValidatorPointForward>() { // from class: com.google.android.material.datepicker.DateValidatorPointForward.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public DateValidatorPointForward createFromParcel(@NonNull Parcel parcel) {
            return new DateValidatorPointForward(parcel.readLong());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public DateValidatorPointForward[] newArray(int i) {
            return new DateValidatorPointForward[i];
        }
    };
    public final long point;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public static DateValidatorPointForward now() {
        return from(UtcDates.getTodayCalendar().getTimeInMillis());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.point)});
    }

    public DateValidatorPointForward(long j) {
        this.point = j;
    }

    @NonNull
    public static DateValidatorPointForward from(long j) {
        return new DateValidatorPointForward(j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof DateValidatorPointForward) && this.point == ((DateValidatorPointForward) obj).point) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean isValid(long j) {
        if (j >= this.point) {
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeLong(this.point);
    }
}
