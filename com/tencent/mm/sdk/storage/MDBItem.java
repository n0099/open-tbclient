package com.tencent.mm.sdk.storage;

import android.content.ContentValues;
import android.database.Cursor;
/* loaded from: classes.dex */
public interface MDBItem {
    void convertFrom(Cursor cursor);

    ContentValues convertTo();
}
