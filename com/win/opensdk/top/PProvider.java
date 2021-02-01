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
/* loaded from: classes3.dex */
public class PProvider extends ContentProvider {
    private Context qiN;

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        long currentTimeMillis = System.currentTimeMillis();
        this.qiN = getContext();
        if (this.qiN != null) {
            eIP();
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.win.opensdk.top.PProvider.1
                @Override // java.lang.Runnable
                public final void run() {
                    PProvider.this.qiN = PProvider.this.getContext();
                    if (PProvider.this.qiN != null) {
                        PProvider.this.eIP();
                    }
                }
            });
        }
        try {
            if (az.iV(getContext())) {
                w.iN(this.qiN).jv(System.currentTimeMillis() - currentTimeMillis).eIP();
                return true;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eIP() {
        if (az.d(this.qiN) == 0) {
            v.iL(this.qiN);
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
