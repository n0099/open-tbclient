package com.kwad.sdk.utils;

import android.text.TextUtils;
import com.kwad.sdk.core.request.model.StatusInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b {
    public static int a() {
        String c = as.c();
        if (TextUtils.isEmpty(c)) {
            return 0;
        }
        try {
            JSONObject jSONObject = new JSONObject(c);
            int optInt = jSONObject.optInt("currentDailyCount");
            if (a(jSONObject.optLong("lastShowTimestamp"), System.currentTimeMillis())) {
                return optInt;
            }
            return 0;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.b(e);
            return 0;
        }
    }

    public static StatusInfo.SplashStyleControl a(SceneImpl sceneImpl) {
        StatusInfo.SplashStyleControl splashStyleControl = new StatusInfo.SplashStyleControl();
        if (sceneImpl != null && b(sceneImpl)) {
            com.kwad.sdk.internal.api.b bVar = sceneImpl.splashExtraData;
            splashStyleControl.disableShake = bVar.a;
            splashStyleControl.disableRotate = bVar.b;
            splashStyleControl.disableSlide = bVar.c;
            return splashStyleControl;
        }
        return null;
    }

    public static boolean a(long j, long j2) {
        if (j > 0 && j2 > 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                return simpleDateFormat.format(new Date(j)).equals(simpleDateFormat.format(new Date(j2)));
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.b(e);
            }
        }
        return false;
    }

    public static boolean b(SceneImpl sceneImpl) {
        return sceneImpl.splashExtraData != null;
    }
}
