package com.kwad.components.core.a;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.util.FileMetaUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class g implements h, Comparable<g> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String DA;
    public final long DB;
    public String DC;
    public final String Dr;
    public final String Dy;
    public final String Dz;
    public final long createTime;
    public final int ecpm;

    public g(String str, String str2, String str3, int i, String str4, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, Integer.valueOf(i), str4, Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.DC = null;
        this.Dy = str;
        this.Dr = str2;
        this.Dz = str3;
        this.ecpm = i;
        this.DA = str4;
        this.createTime = j;
        this.DB = j2;
    }

    public static List<g> a(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cursor)) == null) {
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
        return (List) invokeL.objValue;
    }

    public static List<g> a(e eVar, AdResultData adResultData) {
        InterceptResult invokeLL;
        AdResultData adResultData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, eVar, adResultData)) == null) {
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
        return (List) invokeLL.objValue;
    }

    private void ai(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, str) == null) {
            this.DC = str;
        }
    }

    @SuppressLint({"Range"})
    public static synchronized g c(@NonNull Cursor cursor) {
        InterceptResult invokeL;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cursor)) == null) {
            synchronized (g.class) {
                String string = cursor.getString(cursor.getColumnIndex("creativeId"));
                String string2 = cursor.getString(cursor.getColumnIndex("posId"));
                String string3 = cursor.getString(cursor.getColumnIndex("adJson"));
                int i = cursor.getInt(cursor.getColumnIndex("ecpm"));
                String string4 = cursor.getString(cursor.getColumnIndex("adSenseJson"));
                long j = cursor.getLong(cursor.getColumnIndex(FileMetaUtil.CREATE_TIME));
                long j2 = cursor.getLong(cursor.getColumnIndex("expireTime"));
                String string5 = cursor.getString(cursor.getColumnIndex("playAgainJson"));
                gVar = new g(string, string2, string3, i, string4, j, j2);
                gVar.ai(string5);
            }
            return gVar;
        }
        return (g) invokeL.objValue;
    }

    @Nullable
    public static AdResultData c(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, gVar)) == null) {
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
        return (AdResultData) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: d */
    public int compareTo(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, this, gVar)) == null) ? gVar.me() == me() ? (int) (gVar.mf() - mf()) : gVar.me() - me() : invokeL.intValue;
    }

    public static AdResultData j(List<g> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, list)) == null) {
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
        return (AdResultData) invokeL.objValue;
    }

    private String md() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? this.Dz : (String) invokeV.objValue;
    }

    private int me() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? this.ecpm : invokeV.intValue;
    }

    private long mf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? this.createTime : invokeV.longValue;
    }

    private String mh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? this.DA : (String) invokeV.objValue;
    }

    private String mj() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? this.DC : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.core.a.h
    public final ContentValues ma() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("creativeId", this.Dy);
            contentValues.put("posId", this.Dr);
            contentValues.put("adJson", this.Dz);
            contentValues.put("ecpm", Integer.valueOf(this.ecpm));
            contentValues.put("adSenseJson", this.DA);
            contentValues.put(FileMetaUtil.CREATE_TIME, Long.valueOf(this.createTime));
            contentValues.put("expireTime", Long.valueOf(this.DB));
            contentValues.put("playAgainJson", this.DC);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public final String mc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.Dr : (String) invokeV.objValue;
    }

    public final long mg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.DB : invokeV.longValue;
    }

    public final String mi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.Dy : (String) invokeV.objValue;
    }
}
