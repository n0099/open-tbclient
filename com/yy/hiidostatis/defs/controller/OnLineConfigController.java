package com.yy.hiidostatis.defs.controller;

import android.content.Context;
import com.yy.hiidostatis.defs.interf.IConfigAPI;
import com.yy.hiidostatis.defs.interf.IOnLineConfigListener;
import com.yy.hiidostatis.inner.util.Preference;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.log.L;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class OnLineConfigController {
    public static final String PREF_KEY_ONLINE_CONFIG_DATA = "PREF_KEY_ONLINE_CONFIG_DATA";
    public static Preference preference = new Preference("hd_online_config_pref", true);
    public boolean isFinishUpdateConfig = false;
    public IConfigAPI mConfigAPI;
    public IOnLineConfigListener onLineConfigListener;

    public boolean isFinishUpdateConfig() {
        return this.isFinishUpdateConfig;
    }

    public OnLineConfigController(IConfigAPI iConfigAPI) {
        this.mConfigAPI = iConfigAPI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject getOnlineParamsJSON(Context context) throws JSONException {
        String prefString = preference.getPrefString(context, PREF_KEY_ONLINE_CONFIG_DATA, "");
        if (Util.empty(prefString)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(prefString);
        if (!(jSONObject.get("onlineParams") instanceof JSONObject)) {
            return null;
        }
        return jSONObject.getJSONObject("onlineParams");
    }

    public void setOnLineConfigListener(IOnLineConfigListener iOnLineConfigListener) {
        this.onLineConfigListener = iOnLineConfigListener;
    }

    public String getOnlineConfigParams(Context context, String str) {
        try {
            JSONObject onlineParamsJSON = getOnlineParamsJSON(context);
            if (onlineParamsJSON == null || !onlineParamsJSON.has(str)) {
                return "";
            }
            return onlineParamsJSON.getString(str);
        } catch (Throwable th) {
            L.debug("OnLineConfigController", "getOnlineConfigParams error! %s", th);
            return "";
        }
    }

    public void updateOnlineConfigs(final Context context, final String str) {
        this.isFinishUpdateConfig = false;
        ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.defs.controller.OnLineConfigController.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = null;
                try {
                    String onlineConfigs = OnLineConfigController.this.mConfigAPI.getOnlineConfigs(context, str);
                    L.debug("OnLineConfigController", "the online config data is %s", onlineConfigs);
                    if (onlineConfigs != null && onlineConfigs.length() > 0) {
                        OnLineConfigController.preference.setPrefString(context, OnLineConfigController.PREF_KEY_ONLINE_CONFIG_DATA, onlineConfigs);
                    }
                    OnLineConfigController.this.isFinishUpdateConfig = true;
                } catch (Throwable th) {
                    try {
                        L.debug("OnLineConfigController", "updateOnlineConfigs error! %s", th);
                        OnLineConfigController.this.isFinishUpdateConfig = true;
                        if (OnLineConfigController.this.onLineConfigListener == null) {
                            return;
                        }
                        try {
                            jSONObject = OnLineConfigController.this.getOnlineParamsJSON(context);
                        } catch (JSONException e) {
                            L.debug(this, "get getOnlineParamsJSON error! %s", e);
                        }
                        if (jSONObject == null) {
                            jSONObject = new JSONObject();
                        }
                        L.debug("OnLineConfigController", "call onLineConfigListener.onDataReceived(data)", new Object[0]);
                    } catch (Throwable th2) {
                        OnLineConfigController.this.isFinishUpdateConfig = true;
                        if (OnLineConfigController.this.onLineConfigListener != null) {
                            try {
                                jSONObject = OnLineConfigController.this.getOnlineParamsJSON(context);
                            } catch (JSONException e2) {
                                L.debug(this, "get getOnlineParamsJSON error! %s", e2);
                            }
                            if (jSONObject == null) {
                                jSONObject = new JSONObject();
                            }
                            L.debug("OnLineConfigController", "call onLineConfigListener.onDataReceived(data)", new Object[0]);
                            OnLineConfigController.this.onLineConfigListener.onDataReceived(jSONObject);
                        }
                        throw th2;
                    }
                }
                if (OnLineConfigController.this.onLineConfigListener == null) {
                    return;
                }
                try {
                    jSONObject = OnLineConfigController.this.getOnlineParamsJSON(context);
                } catch (JSONException e3) {
                    L.debug(this, "get getOnlineParamsJSON error! %s", e3);
                }
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                L.debug("OnLineConfigController", "call onLineConfigListener.onDataReceived(data)", new Object[0]);
                OnLineConfigController.this.onLineConfigListener.onDataReceived(jSONObject);
            }
        });
    }
}
