package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class TipsConfigItem extends b<TipConfigData> {

    /* loaded from: classes10.dex */
    public static class TipConfigData implements com.kwad.sdk.core.b, Serializable {
        public static final long serialVersionUID = 268961350883157950L;
        public String tipInfo;
        public transient Map<String, String> tipMap = new HashMap();
        public int tipShowSwitch;

        @Nullable
        public String getTipInfoData() {
            return this.tipInfo;
        }

        public int getTipShowSwitch() {
            return this.tipShowSwitch;
        }

        public boolean isShowTips() {
            if (this.tipShowSwitch == 0) {
                return true;
            }
            return false;
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            t.putValue(jSONObject, "tipShowSwitch", this.tipShowSwitch);
            t.putValue(jSONObject, "tipInfo", this.tipInfo);
            return jSONObject;
        }

        private void genTipMap(JSONObject jSONObject) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this.tipMap.put(next, jSONObject.optString(next, ""));
            }
        }

        public String getTips(String str) {
            return this.tipMap.get(str);
        }

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            setTipInfoData(jSONObject.optString("tipInfo"));
            this.tipShowSwitch = jSONObject.optInt("tipShowSwitch", 0);
        }

        public void setTipInfoData(String str) {
            this.tipInfo = str;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str) && !StringUtil.NULL_STRING.equalsIgnoreCase(str)) {
                try {
                    genTipMap(new JSONObject(str));
                } catch (Exception e) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                }
            }
        }

        public void setTipShowSwitch(int i) {
            this.tipShowSwitch = i;
        }
    }

    public TipsConfigItem() {
        super("tipConfig", new TipConfigData());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        TipConfigData value = getValue();
        if (value == null) {
            value = new TipConfigData();
        }
        value.setTipShowSwitch(sharedPreferences.getInt("tipsSwitch", 0));
        value.setTipInfoData(sharedPreferences.getString("tipsInfo", ""));
        setValue(value);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        editor.putInt("tipsSwitch", getValue().getTipShowSwitch());
        if (getValue().getTipInfoData() != null) {
            editor.putString("tipsInfo", getValue().getTipInfoData());
        } else {
            editor.putString("tipsInfo", "");
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void j(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(getKey())) != null) {
            TipConfigData tipConfigData = new TipConfigData();
            tipConfigData.parseJson(optJSONObject);
            setValue(tipConfigData);
            return;
        }
        setValue(Bx());
    }
}
