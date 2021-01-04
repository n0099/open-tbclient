package com.win.opensdk.top;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.win.opensdk.az;
import com.win.opensdk.v;
import com.win.opensdk.w;
/* loaded from: classes4.dex */
public class PProvider extends ContentProvider {
    private Context qbB;

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        long currentTimeMillis = System.currentTimeMillis();
        this.qbB = getContext();
        if (this.qbB != null) {
            eJL();
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.win.opensdk.top.PProvider.1
                @Override // java.lang.Runnable
                public final void run() {
                    PProvider.this.qbB = PProvider.this.getContext();
                    if (PProvider.this.qbB != null) {
                        PProvider.this.eJL();
                    }
                }
            });
        }
        try {
            if (az.iU(getContext())) {
                w.iM(this.qbB).jp(System.currentTimeMillis() - currentTimeMillis).eJL();
                return true;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eJL() {
        if (az.d(this.qbB) == 0) {
            v.iK(this.qbB);
        }
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }
}
