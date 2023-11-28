package com.kwad.components.core.c;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.retrieve.util.FileMetaUtil;
import com.baidu.mobads.sdk.api.SplashAd;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class h implements i, Comparable<h> {
    public final String Jm;
    public final String Jw;
    public final String Jx;
    public final String Jy;
    public final long Jz;
    public final long createTime;
    public final int ecpm;

    public h(String str, String str2, String str3, int i, String str4, long j, long j2) {
        this.Jw = str;
        this.Jm = str2;
        this.Jx = str3;
        this.ecpm = i;
        this.Jy = str4;
        this.createTime = j;
        this.Jz = j2;
    }

    public static List<h> a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                arrayList.add(c(cursor));
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTrace(e);
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: d */
    public int compareTo(h hVar) {
        if (hVar.mF() == mF()) {
            return (int) (hVar.mG() - mG());
        }
        return hVar.mF() - mF();
    }

    public static List<h> a(e eVar, AdResultData adResultData) {
        List<AdTemplate> proceedTemplateList = adResultData.getProceedTemplateList();
        int size = proceedTemplateList.size();
        long currentTimeMillis = System.currentTimeMillis();
        long mz = (currentTimeMillis / 1000) + eVar.mz();
        ArrayList arrayList = new ArrayList();
        SceneImpl defaultAdScene = adResultData.getDefaultAdScene();
        Iterator<AdTemplate> it = proceedTemplateList.iterator();
        while (it.hasNext()) {
            AdTemplate next = it.next();
            arrayList.add(new h(String.valueOf(com.kwad.sdk.core.response.b.e.dZ(next)), String.valueOf(adResultData.getPosId()), new AdResultData(adResultData, defaultAdScene, Collections.singletonList(next)).getResponseJson(), com.kwad.sdk.core.response.b.e.ed(next), adResultData.getDefaultAdScene().toJson().toString(), currentTimeMillis + size, mz));
            size--;
            it = it;
            defaultAdScene = defaultAdScene;
        }
        return arrayList;
    }

    @SuppressLint({"Range"})
    public static synchronized h c(@NonNull Cursor cursor) {
        h hVar;
        synchronized (h.class) {
            hVar = new h(cursor.getString(cursor.getColumnIndex("creativeId")), cursor.getString(cursor.getColumnIndex("posId")), cursor.getString(cursor.getColumnIndex("adJson")), cursor.getInt(cursor.getColumnIndex(SplashAd.KEY_BIDFAIL_ECPM)), cursor.getString(cursor.getColumnIndex("adSenseJson")), cursor.getLong(cursor.getColumnIndex(FileMetaUtil.CREATE_TIME)), cursor.getLong(cursor.getColumnIndex("expireTime")));
        }
        return hVar;
    }

    @Nullable
    public static AdResultData c(h hVar) {
        if (hVar == null) {
            return null;
        }
        if (hVar.mE() != null && hVar.mI() != null) {
            try {
                String mI = hVar.mI();
                SceneImpl sceneImpl = new SceneImpl();
                sceneImpl.parseJson(new JSONObject(mI));
                AdResultData createFromResponseJson = AdResultData.createFromResponseJson(hVar.mE(), sceneImpl);
                for (AdTemplate adTemplate : createFromResponseJson.getProceedTemplateList()) {
                    adTemplate.fromCache = true;
                }
                return createFromResponseJson;
            } catch (JSONException e) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                return null;
            }
        }
        com.kwad.sdk.core.e.c.w("CachedAd", "createAdResultData cachedAd data illegal");
        return null;
    }

    public static AdResultData k(List<h> list) {
        ArrayList arrayList = new ArrayList();
        AdResultData adResultData = null;
        if (list == null || list.size() == 0) {
            return null;
        }
        SceneImpl sceneImpl = null;
        for (h hVar : list) {
            adResultData = c(hVar);
            if (adResultData != null) {
                if (sceneImpl == null) {
                    sceneImpl = adResultData.getDefaultAdScene();
                }
                arrayList.addAll(adResultData.getProceedTemplateList());
            }
        }
        return new AdResultData(adResultData, sceneImpl, arrayList);
    }

    private String mE() {
        return this.Jx;
    }

    private int mF() {
        return this.ecpm;
    }

    private long mG() {
        return this.createTime;
    }

    private String mI() {
        return this.Jy;
    }

    public final String mD() {
        return this.Jm;
    }

    public final long mH() {
        return this.Jz;
    }

    public final String mJ() {
        return this.Jw;
    }

    @Override // com.kwad.components.core.c.i
    public final ContentValues mA() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("creativeId", this.Jw);
        contentValues.put("posId", this.Jm);
        contentValues.put("adJson", this.Jx);
        contentValues.put(SplashAd.KEY_BIDFAIL_ECPM, Integer.valueOf(this.ecpm));
        contentValues.put("adSenseJson", this.Jy);
        contentValues.put(FileMetaUtil.CREATE_TIME, Long.valueOf(this.createTime));
        contentValues.put("expireTime", Long.valueOf(this.Jz));
        contentValues.put("playAgainJson", (String) null);
        return contentValues;
    }
}
