package com.kwad.components.core.a;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.searchbox.download.center.clearcache.DiskManagerSharedPrefsUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class e implements h {
    public static volatile e Dq;
    @Nullable
    public String Dr;
    public int Ds = 0;
    public int Dt = 1;
    public long Du = DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT;
    public boolean Dv = false;

    public e() {
    }

    public e(long j) {
        this.Dr = String.valueOf(j);
    }

    public static e H(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return null;
        }
        long j = adTemplate.posId;
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        e eVar = new e(j);
        AdInfo.AdBaseInfo adBaseInfo = bQ.adBaseInfo;
        eVar.Ds = adBaseInfo.adCacheStrategy;
        eVar.Du = adBaseInfo.adCacheSecond;
        eVar.Dt = adBaseInfo.adCacheSize;
        eVar.Dv = adBaseInfo.adCacheSwitch == 1;
        return eVar;
    }

    public static synchronized List<e> a(Cursor cursor) {
        synchronized (e.class) {
            if (cursor == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            while (cursor.moveToNext()) {
                try {
                    arrayList.add(b(cursor));
                } catch (Exception e) {
                    com.kwad.sdk.core.e.b.printStackTrace(e);
                }
            }
            return arrayList;
        }
    }

    public static synchronized e b(Cursor cursor) {
        e eVar;
        synchronized (e.class) {
            String string = cursor.getString(cursor.getColumnIndex("posId"));
            int i = cursor.getInt(cursor.getColumnIndex("strategyCode"));
            int i2 = cursor.getInt(cursor.getColumnIndex("cacheSize"));
            long j = cursor.getLong(cursor.getColumnIndex("cacheSecond"));
            boolean z = true;
            if (cursor.getInt(cursor.getColumnIndex("enable")) != 1) {
                z = false;
            }
            eVar = new e();
            eVar.Dr = string;
            eVar.Ds = i;
            eVar.Dt = i2;
            eVar.Du = j;
            eVar.Dv = z;
        }
        return eVar;
    }

    @NonNull
    @WorkerThread
    public static e k(long j) {
        e af;
        return (a.lP() == null || (af = a.lP().af(String.valueOf(j))) == null) ? lW() : af;
    }

    @NonNull
    public static e lW() {
        if (Dq == null) {
            synchronized (e.class) {
                if (Dq == null) {
                    Dq = new e();
                }
            }
        }
        return Dq;
    }

    public final boolean isDefault() {
        return equals(lW());
    }

    public final boolean isEnable() {
        return this.Dv;
    }

    public final int lX() {
        return this.Ds;
    }

    public final int lY() {
        return this.Dt;
    }

    public final long lZ() {
        return this.Du;
    }

    @Override // com.kwad.components.core.a.h
    public final ContentValues ma() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("posId", this.Dr);
        contentValues.put("strategyCode", Integer.valueOf(this.Ds));
        contentValues.put("cacheSize", Integer.valueOf(this.Dt));
        contentValues.put("cacheSecond", Long.valueOf(this.Du));
        contentValues.put("enable", Integer.valueOf(this.Dv ? 1 : 0));
        return contentValues;
    }
}
