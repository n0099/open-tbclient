package com.kascend.chushou.player.ui.pk;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes5.dex */
public class CustomCircle implements Parcelable {
    public static final Parcelable.Creator<CustomCircle> CREATOR = new Parcelable.Creator<CustomCircle>() { // from class: com.kascend.chushou.player.ui.pk.CustomCircle.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: aj */
        public CustomCircle createFromParcel(Parcel parcel) {
            return new CustomCircle(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: Jg */
        public CustomCircle[] newArray(int i) {
            return new CustomCircle[i];
        }
    };
    public float a;
    public float b;
    public float c;
    public float d;

    public CustomCircle() {
    }

    public CustomCircle(Parcel parcel) {
        this.a = parcel.readFloat();
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
        parcel.writeFloat(this.a);
        parcel.writeFloat(this.b);
        parcel.writeFloat(this.c);
        parcel.writeFloat(this.d);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        sb.append("\"pointX\":").append(this.a).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
