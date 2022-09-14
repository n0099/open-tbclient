package com.kwad.sdk.utils;

import android.text.TextUtils;
import com.kwad.sdk.core.request.model.StatusInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class b {
    public static boolean a(long j, long j2) {
        if (j > 0 && j2 > 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                return simpleDateFormat.format(new Date(j)).equals(simpleDateFormat.format(new Date(j2)));
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            }
        }
        return false;
    }

    public static StatusInfo.SplashStyleControl d(SceneImpl sceneImpl) {
        StatusInfo.SplashStyleControl splashStyleControl = new StatusInfo.SplashStyleControl();
        if (sceneImpl != null && e(sceneImpl)) {
            com.kwad.sdk.internal.api.b bVar = sceneImpl.splashExtraData;
            splashStyleControl.disableShake = bVar.disableShake;
            splashStyleControl.disableRotate = bVar.disableRotate;
            splashStyleControl.disableSlide = bVar.disableSlide;
            return splashStyleControl;
        }
        return null;
    }

    public static boolean e(SceneImpl sceneImpl) {
        return sceneImpl.splashExtraData != null;
    }

    public static int yU() {
        String zB = w.zB();
        if (TextUtils.isEmpty(zB)) {
            return 0;
        }
        try {
            JSONObject jSONObject = new JSONObject(zB);
            int optInt = jSONObject.optInt("currentDailyCount");
            if (a(jSONObject.optLong("lastShowTimestamp"), System.currentTimeMillis())) {
                return optInt;
            }
            return 0;
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            return 0;
        }
    }
}
