package com;

import android.location.Location;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.cloudsdk.social.share.ShareContent;
/* loaded from: classes.dex */
public final class y implements Parcelable.Creator {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ShareContent createFromParcel(Parcel parcel) {
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        String readString4 = parcel.readString();
        String readString5 = parcel.readString();
        int readInt = parcel.readInt();
        Uri uri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        Location location = (Location) parcel.readParcelable(Location.class.getClassLoader());
        String readString6 = parcel.readString();
        int readInt2 = parcel.readInt();
        byte[] bArr = null;
        if (readInt2 != 0) {
            bArr = new byte[readInt2];
            parcel.readByteArray(bArr);
        }
        ShareContent shareContent = new ShareContent(readString, readString2, readString3, uri);
        shareContent.setEmailBody(readString5, readString4);
        shareContent.setLocation(location);
        shareContent.setWXMediaContentPath(readString6);
        shareContent.setWXMediaObjectType(readInt);
        if (bArr != null) {
            shareContent.setWXMediaContent(bArr);
        }
        return shareContent;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ShareContent[] newArray(int i) {
        return new ShareContent[i];
    }
}
