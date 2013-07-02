package com.google.android.gms.internal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class du {
    Bundle a;

    public du(Bundle bundle) {
        this.a = bundle;
    }

    public boolean a() {
        return this.a.getBoolean("has_plus_one", false);
    }

    public String b() {
        return this.a.getString("bubble_text");
    }

    public String[] c() {
        return this.a.getStringArray("inline_annotations");
    }

    public Uri[] d() {
        Parcelable[] parcelableArray = this.a.getParcelableArray("profile_photo_uris");
        if (parcelableArray == null) {
            return null;
        }
        Uri[] uriArr = new Uri[parcelableArray.length];
        System.arraycopy(parcelableArray, 0, uriArr, 0, parcelableArray.length);
        return uriArr;
    }

    public Intent e() {
        return (Intent) this.a.getParcelable("intent");
    }
}
