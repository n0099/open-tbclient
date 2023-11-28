package com.kwad.components.core.c;

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
public class e implements i {
    public static volatile e Jl;
    @Nullable
    public String Jm;
    public int Jn = 0;
    public int Jo = 1;
    public long Jp = DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT;
    public boolean Jq = false;

    public e() {
    }

    @NonNull
    public static e mw() {
        if (Jl == null) {
            synchronized (e.class) {
                if (Jl == null) {
                    Jl = new e();
                }
            }
        }
        return Jl;
    }

    public final boolean isDefault() {
        return equals(mw());
    }

    public final boolean isEnable() {
        return this.Jq;
    }

    public final int mx() {
        return this.Jn;
    }

    public final int my() {
        return this.Jo;
    }

    public final long mz() {
        return this.Jp;
    }

    public e(long j) {
        this.Jm = String.valueOf(j);
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
                    com.kwad.sdk.core.e.c.printStackTrace(e);
                }
            }
            return arrayList;
        }
    }

    public static e aj(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return null;
        }
        long j = adTemplate.posId;
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        e eVar = new e(j);
        AdInfo.AdBaseInfo adBaseInfo = dP.adBaseInfo;
        eVar.Jn = adBaseInfo.adCacheStrategy;
        eVar.Jp = adBaseInfo.adCacheSecond;
        eVar.Jo = adBaseInfo.adCacheSize;
        boolean z = true;
        if (adBaseInfo.adCacheSwitch != 1) {
            z = false;
        }
        eVar.Jq = z;
        return eVar;
    }

    @NonNull
    @WorkerThread
    public static e s(long j) {
        e X;
        if (a.mn() != null && (X = a.mn().X(String.valueOf(j))) != null) {
            return X;
        }
        return mw();
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
            eVar.Jm = string;
            eVar.Jn = i;
            eVar.Jo = i2;
            eVar.Jp = j;
            eVar.Jq = z;
        }
        return eVar;
    }

    @Override // com.kwad.components.core.c.i
    public final ContentValues mA() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("posId", this.Jm);
        contentValues.put("strategyCode", Integer.valueOf(this.Jn));
        contentValues.put("cacheSize", Integer.valueOf(this.Jo));
        contentValues.put("cacheSecond", Long.valueOf(this.Jp));
        contentValues.put("enable", Integer.valueOf(this.Jq ? 1 : 0));
        return contentValues;
    }
}
