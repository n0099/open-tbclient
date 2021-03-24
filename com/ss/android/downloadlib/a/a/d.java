package com.ss.android.downloadlib.a.a;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
/* loaded from: classes6.dex */
public class d extends Intent {
    public d(String str, Uri uri) {
        super(str, uri);
    }

    public void a(Parcel parcel) {
    }

    @Override // android.content.Intent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        a(parcel);
        super.writeToParcel(parcel, i);
    }
}
