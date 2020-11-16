package com.kascend.chushou.player.ui.pk;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes6.dex */
public class CustomCircle implements Parcelable {
    public static final Parcelable.Creator<CustomCircle> CREATOR = new Parcelable.Creator<CustomCircle>() { // from class: com.kascend.chushou.player.ui.pk.CustomCircle.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: ar */
        public CustomCircle createFromParcel(Parcel parcel) {
            return new CustomCircle(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: Rn */
        public CustomCircle[] newArray(int i) {
            return new CustomCircle[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public float f4188a;
    public float b;
    public float c;
    public float d;

    public CustomCircle() {
    }

    public CustomCircle(Parcel parcel) {
        this.f4188a = parcel.readFloat();
        this.b = parcel.readFloat();
        this.c = parcel.readFloat();
        this.d = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f4188a);
        parcel.writeFloat(this.b);
        parcel.writeFloat(this.c);
        parcel.writeFloat(this.d);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        sb.append("\"pointX\":").append(this.f4188a).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("\"pointY\":").append(this.b).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("\"angle\":").append(this.c).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("\"radius\":").append(this.d).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        int lastIndexOf = sb.lastIndexOf(Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (lastIndexOf > 0) {
            sb.deleteCharAt(lastIndexOf);
        }
        sb.append('}');
        return sb.toString().replace("null", "");
    }
}
