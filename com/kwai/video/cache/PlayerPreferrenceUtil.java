package com.kwai.video.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.kwai.video.cache.AwesomeCache;
import com.kwai.video.hodor.util.Timber;
/* loaded from: classes3.dex */
public class PlayerPreferrenceUtil {
    private static final String VOD_ADAPTIVE_PREFERENCE_HISTORY_DATA_KEY_NAME = "history_data";
    private static final String VOD_ADAPTIVE_PREFERENCE_NAME = "vod_adaptive_data";
    private static PlayerPreferrenceUtil instance;
    private Context mContext;
    private String vodAdaptiveHisData = "";
    private Boolean mInited = false;

    private PlayerPreferrenceUtil() {
    }

    public static PlayerPreferrenceUtil getInstance() {
        if (instance == null) {
            instance = new PlayerPreferrenceUtil();
        }
        return instance;
    }

    private void init(Context context) {
        if (this.mInited.booleanValue() || context == null) {
            return;
        }
        this.mContext = context.getApplicationContext();
        this.mInited = true;
        Timber.d("PlayerPreferrenceUtil init", new Object[0]);
    }

    public String getVodAdaptiveData(Context context) {
        init(context);
        if (this.mInited.booleanValue()) {
            this.vodAdaptiveHisData = this.mContext.getSharedPreferences(VOD_ADAPTIVE_PREFERENCE_NAME, 0).getString(VOD_ADAPTIVE_PREFERENCE_HISTORY_DATA_KEY_NAME, "");
        }
        Timber.d("PlayerPreferrenceUtil getVodAdaptiveData mInited:" + this.mInited + ", historyData: " + this.vodAdaptiveHisData, new Object[0]);
        return this.vodAdaptiveHisData;
    }

    public void saveVodAdaptiveData() {
        String historyData = AwesomeCache.VodAdaptive.getHistoryData();
        if (!this.mInited.booleanValue() || TextUtils.isEmpty(historyData)) {
            return;
        }
        SharedPreferences.Editor edit = this.mContext.getSharedPreferences(VOD_ADAPTIVE_PREFERENCE_NAME, 0).edit();
        edit.putString(VOD_ADAPTIVE_PREFERENCE_HISTORY_DATA_KEY_NAME, historyData);
        edit.apply();
    }
}
