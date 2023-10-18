package com.kwad.components.core.a;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.retrieve.util.FileMetaUtil;
import com.baidu.mobads.sdk.api.SplashAd;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class g implements h, Comparable<g> {
    public final String DA;
    public final long DB;
    public String DC = null;
    public final String Dr;
    public final String Dy;
    public final String Dz;
    public final long createTime;
    public final int ecpm;

    public g(String str, String str2, String str3, int i, String str4, long j, long j2) {
        this.Dy = str;
        this.Dr = str2;
        this.Dz = str3;
        this.ecpm = i;
        this.DA = str4;
        this.createTime = j;
        this.DB = j2;
    }

    public static List<g> a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                arrayList.add(c(cursor));
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTrace(e);
            }
        }
        return arrayList;
    }

    public static List<g> a(e eVar, AdResultData adResultData) {
        AdResultData adResultData2;
        AdResultData adResultData3 = adResultData;
        List<AdTemplate> proceedTemplateList = adResultData.getProceedTemplateList();
        int size = proceedTemplateList.size();
        long currentTimeMillis = System.currentTimeMillis();
        long lZ = (currentTimeMillis / 1000) + eVar.lZ();
        ArrayList arrayList = new ArrayList();
        SceneImpl defaultAdScene = adResultData.getDefaultAdScene();
        Iterator<AdTemplate> it = proceedTemplateList.iterator();
        while (it.hasNext()) {
            AdTemplate next = it.next();
            Iterator<AdTemplate> it2 = it;
            ArrayList arrayList2 = arrayList;
            g gVar = new g(String.valueOf(com.kwad.sdk.core.response.a.d.ca(next)), String.valueOf(adResultData.getPosId()), new AdResultData(adResultData3, defaultAdScene, Collections.singletonList(next)).getResponseJson(), com.kwad.sdk.core.response.a.d.cf(next), adResultData.getDefaultAdScene().toJson().toString(), size + currentTimeMillis, lZ);
            if (next.hasPlayAgain()) {
                adResultData2 = adResultData;
                gVar.ai(new AdResultData(adResultData2, defaultAdScene, Collections.singletonList(next.mPlayAgain)).getResponseJson());
            } else {
                adResultData2 = adResultData;
            }
            arrayList2.add(gVar);
            size--;
            it = it2;
            arrayList = arrayList2;
            adResultData3 = adResultData2;
        }
        return arrayList;
    }

    private void ai(String str) {
        this.DC = str;
    }

    @SuppressLint({"Range"})
    public static synchronized g c(@NonNull Cursor cursor) {
        g gVar;
        synchronized (g.class) {
            String string = cursor.getString(cursor.getColumnIndex("creativeId"));
            String string2 = cursor.getString(cursor.getColumnIndex("posId"));
            String string3 = cursor.getString(cursor.getColumnIndex("adJson"));
            int i = cursor.getInt(cursor.getColumnIndex(SplashAd.KEY_BIDFAIL_ECPM));
            String string4 = cursor.getString(cursor.getColumnIndex("adSenseJson"));
            long j = cursor.getLong(cursor.getColumnIndex(FileMetaUtil.CREATE_TIME));
            long j2 = cursor.getLong(cursor.getColumnIndex("expireTime"));
            String string5 = cursor.getString(cursor.getColumnIndex("playAgainJson"));
            gVar = new g(string, string2, string3, i, string4, j, j2);
            gVar.ai(string5);
        }
        return gVar;
    }

    @Nullable
    public static AdResultData c(g gVar) {
        if (gVar == null) {
            return null;
        }
        if (gVar.md() == null || gVar.mh() == null) {
            com.kwad.sdk.core.e.b.w("CachedAd", "createAdResultData cachedAd data illegal");
            return null;
        }
        try {
            String mh = gVar.mh();
            SceneImpl sceneImpl = new SceneImpl();
            sceneImpl.parseJson(new JSONObject(mh));
            AdResultData createFromResponseJson = AdResultData.createFromResponseJson(gVar.md(), sceneImpl);
            String mj = gVar.mj();
            if (!TextUtils.isEmpty(mj)) {
                AdTemplate firstAdTemplate = createFromResponseJson.getFirstAdTemplate();
                AdResultData createFromResponseJson2 = AdResultData.createFromResponseJson(mj, sceneImpl);
                for (AdTemplate adTemplate : createFromResponseJson2.getProceedTemplateList()) {
                    adTemplate.fromCache = true;
                }
                firstAdTemplate.setPlayAgain(createFromResponseJson2.getFirstAdTemplate());
            }
            for (AdTemplate adTemplate2 : createFromResponseJson.getProceedTemplateList()) {
                adTemplate2.fromCache = true;
            }
            return createFromResponseJson;
        } catch (JSONException e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: d */
    public int compareTo(g gVar) {
        return gVar.me() == me() ? (int) (gVar.mf() - mf()) : gVar.me() - me();
    }

    public static AdResultData j(List<g> list) {
        ArrayList arrayList = new ArrayList();
        AdResultData adResultData = null;
        if (list == null || list.size() == 0) {
            return null;
        }
        SceneImpl sceneImpl = null;
        for (g gVar : list) {
            adResultData = c(gVar);
            if (adResultData != null) {
                if (sceneImpl == null) {
                    sceneImpl = adResultData.getDefaultAdScene();
                }
                arrayList.addAll(adResultData.getProceedTemplateList());
            }
        }
        return new AdResultData(adResultData, sceneImpl, arrayList);
    }

    private String md() {
        return this.Dz;
    }

    private int me() {
        return this.ecpm;
    }

    private long mf() {
        return this.createTime;
    }

    private String mh() {
        return this.DA;
    }

    private String mj() {
        return this.DC;
    }

    @Override // com.kwad.components.core.a.h
    public final ContentValues ma() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("creativeId", this.Dy);
        contentValues.put("posId", this.Dr);
        contentValues.put("adJson", this.Dz);
        contentValues.put(SplashAd.KEY_BIDFAIL_ECPM, Integer.valueOf(this.ecpm));
        contentValues.put("adSenseJson", this.DA);
        contentValues.put(FileMetaUtil.CREATE_TIME, Long.valueOf(this.createTime));
        contentValues.put("expireTime", Long.valueOf(this.DB));
        contentValues.put("playAgainJson", this.DC);
        return contentValues;
    }

    public final String mc() {
        return this.Dr;
    }

    public final long mg() {
        return this.DB;
    }

    public final String mi() {
        return this.Dy;
    }
}
