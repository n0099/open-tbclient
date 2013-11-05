package defpackage;

import android.location.Location;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.cloudsdk.social.share.ShareContent;
/* renamed from: ab  reason: default package */
/* loaded from: classes.dex */
public final class ab implements Parcelable.Creator {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ShareContent createFromParcel(Parcel parcel) {
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        String readString4 = parcel.readString();
        String readString5 = parcel.readString();
        ShareContent shareContent = new ShareContent(readString, readString2, readString3, (Uri) parcel.readParcelable(Uri.class.getClassLoader()));
        shareContent.setEmailBody(readString5, readString4);
        shareContent.setLocation((Location) parcel.readParcelable(Location.class.getClassLoader()));
        return shareContent;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ShareContent[] newArray(int i) {
        return new ShareContent[i];
    }
}
