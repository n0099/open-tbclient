package com.kwad.components.core.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
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
public final class f implements g, Comparable<f> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final String c;
    public final int d;
    public final String e;
    public final long f;
    public final long g;
    public String h;

    public f(String str, String str2, String str3, int i, String str4, long j, long j2) {
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
        this.h = null;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = i;
        this.e = str4;
        this.f = j;
        this.g = j2;
    }

    public static AdResultData a(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fVar)) == null) {
            if (fVar == null) {
                return null;
            }
            if (fVar.c() == null || fVar.g() == null) {
                com.kwad.sdk.core.d.b.d("CachedAd", "createAdResultData cachedAd data illegal");
                return null;
            }
            try {
                String g = fVar.g();
                SceneImpl sceneImpl = new SceneImpl();
                sceneImpl.parseJson(new JSONObject(g));
                AdResultData createFromResponseJson = AdResultData.createFromResponseJson(fVar.c(), sceneImpl);
                String h = fVar.h();
                if (!TextUtils.isEmpty(h)) {
                    AdTemplate firstAdTemplate = createFromResponseJson.getFirstAdTemplate();
                    AdResultData createFromResponseJson2 = AdResultData.createFromResponseJson(h, sceneImpl);
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
                com.kwad.sdk.core.d.b.b(e);
                return null;
            }
        }
        return (AdResultData) invokeL.objValue;
    }

    public static AdResultData a(List<f> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            AdResultData adResultData = null;
            if (list == null || list.size() == 0) {
                return null;
            }
            SceneImpl sceneImpl = null;
            for (f fVar : list) {
                adResultData = a(fVar);
                if (sceneImpl == null) {
                    sceneImpl = adResultData.getDefaultAdScene();
                }
                arrayList.addAll(adResultData.getProceedTemplateList());
            }
            return new AdResultData(adResultData, sceneImpl, arrayList);
        }
        return (AdResultData) invokeL.objValue;
    }

    public static List<f> a(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cursor)) == null) {
            if (cursor == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            while (cursor.moveToNext()) {
                try {
                    arrayList.add(b(cursor));
                } catch (Exception e) {
                    com.kwad.sdk.core.d.b.a(e);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<f> a(e eVar, AdResultData adResultData) {
        InterceptResult invokeLL;
        AdResultData adResultData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, eVar, adResultData)) == null) {
            AdResultData adResultData3 = adResultData;
            List<AdTemplate> proceedTemplateList = adResultData.getProceedTemplateList();
            int size = proceedTemplateList.size();
            long currentTimeMillis = System.currentTimeMillis();
            long c = (currentTimeMillis / 1000) + eVar.c();
            ArrayList arrayList = new ArrayList();
            SceneImpl defaultAdScene = adResultData.getDefaultAdScene();
            Iterator<AdTemplate> it = proceedTemplateList.iterator();
            while (it.hasNext()) {
                AdTemplate next = it.next();
                Iterator<AdTemplate> it2 = it;
                ArrayList arrayList2 = arrayList;
                f fVar = new f(String.valueOf(com.kwad.sdk.core.response.a.d.t(next)), String.valueOf(adResultData.getPosId()), new AdResultData(adResultData3, defaultAdScene, Collections.singletonList(next)).getResponseJson(), com.kwad.sdk.core.response.a.d.y(next), adResultData.getDefaultAdScene().toJson().toString(), size + currentTimeMillis, c);
                if (next.hasPlayAgain()) {
                    adResultData2 = adResultData;
                    fVar.a(new AdResultData(adResultData2, defaultAdScene, Collections.singletonList(next.mPlayAgain)).getResponseJson());
                } else {
                    adResultData2 = adResultData;
                }
                arrayList2.add(fVar);
                size--;
                it = it2;
                arrayList = arrayList2;
                adResultData3 = adResultData2;
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, str) == null) {
            this.h = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, this, fVar)) == null) ? fVar.d() == d() ? (int) (fVar.e() - e()) : fVar.d() - d() : invokeL.intValue;
    }

    public static synchronized f b(@NonNull Cursor cursor) {
        InterceptResult invokeL;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, cursor)) == null) {
            synchronized (f.class) {
                String string = cursor.getString(cursor.getColumnIndex("creativeId"));
                String string2 = cursor.getString(cursor.getColumnIndex("posId"));
                String string3 = cursor.getString(cursor.getColumnIndex("adJson"));
                int i = cursor.getInt(cursor.getColumnIndex("ecpm"));
                String string4 = cursor.getString(cursor.getColumnIndex("adSenseJson"));
                long j = cursor.getLong(cursor.getColumnIndex(FileMetaUtil.CREATE_TIME));
                long j2 = cursor.getLong(cursor.getColumnIndex("expireTime"));
                String string5 = cursor.getString(cursor.getColumnIndex("playAgainJson"));
                fVar = new f(string, string2, string3, i, string4, j, j2);
                fVar.a(string5);
            }
            return fVar;
        }
        return (f) invokeL.objValue;
    }

    private String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    private int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? this.d : invokeV.intValue;
    }

    private long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? this.f : invokeV.longValue;
    }

    private String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    private String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? this.h : (String) invokeV.objValue;
    }

    public final long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.g : invokeV.longValue;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.core.a.g
    public final ContentValues f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("creativeId", this.a);
            contentValues.put("posId", this.b);
            contentValues.put("adJson", this.c);
            contentValues.put("ecpm", Integer.valueOf(this.d));
            contentValues.put("adSenseJson", this.e);
            contentValues.put(FileMetaUtil.CREATE_TIME, Long.valueOf(this.f));
            contentValues.put("expireTime", Long.valueOf(this.g));
            contentValues.put("playAgainJson", this.h);
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }
}
