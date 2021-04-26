package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
/* loaded from: classes6.dex */
public final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new Parcelable.Creator<Month>() { // from class: com.google.android.material.datepicker.Month.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public Month createFromParcel(@NonNull Parcel parcel) {
            return Month.create(parcel.readInt(), parcel.readInt());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NonNull
        public Month[] newArray(int i2) {
            return new Month[i2];
        }
    };
    public final int daysInMonth;
    public final int daysInWeek;
    @NonNull
    public final Calendar firstOfMonth;
    @NonNull
    public final String longName;
    public final int month;
    public final long timeInMillis;
    public final int year;

    public Month(@NonNull Calendar calendar) {
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
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(j);
        return new Month(utcCalendar);
    }

    @NonNull
    public static Month current() {
        return new Month(UtcDates.getTodayCalendar());
    }

    public int daysFromStartOfWeekToFirstOfMonth() {
        int firstDayOfWeek = this.firstOfMonth.get(7) - this.firstOfMonth.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.daysInWeek : firstDayOfWeek;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Month) {
            Month month = (Month) obj;
            return this.month == month.month && this.year == month.year;
        }
        return false;
    }

    public long getDay(int i2) {
        Calendar dayCopy = UtcDates.getDayCopy(this.firstOfMonth);
        dayCopy.set(5, i2);
        return dayCopy.getTimeInMillis();
    }

    @NonNull
    public String getLongName() {
        return this.longName;
    }

    public long getStableId() {
        return this.firstOfMonth.getTimeInMillis();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.month), Integer.valueOf(this.year)});
    }

    @NonNull
    public Month monthsLater(int i2) {
        Calendar dayCopy = UtcDates.getDayCopy(this.firstOfMonth);
        dayCopy.add(2, i2);
        return new Month(dayCopy);
    }

    public int monthsUntil(@NonNull Month month) {
        if (this.firstOfMonth instanceof GregorianCalendar) {
            return ((month.year - this.year) * 12) + (month.month - this.month);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeInt(this.year);
        parcel.writeInt(this.month);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(@NonNull Month month) {
        return this.firstOfMonth.compareTo(month.firstOfMonth);
    }

    @NonNull
    public static Month create(int i2, int i3) {
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.set(1, i2);
        utcCalendar.set(2, i3);
        return new Month(utcCalendar);
    }
}
