package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.kwad.sdk.utils.r;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class TipsConfigItem extends b<TipConfigData> {

    /* loaded from: classes5.dex */
    public static class TipConfigData implements com.kwad.sdk.core.b, Serializable {
        public static final long serialVersionUID = 268961350883157950L;
        public String tipInfo;
        public transient Map<String, String> tipMap = new HashMap();
        public int tipShowSwitch;

        private void genTipMap(JSONObject jSONObject) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this.tipMap.put(next, jSONObject.optString(next, ""));
            }
        }

        @Nullable
        public String getTipInfoData() {
            return this.tipInfo;
        }

        public int getTipShowSwitch() {
            return this.tipShowSwitch;
        }

        public String getTips(String str) {
            return this.tipMap.get(str);
        }

        public boolean isShowTips() {
            return this.tipShowSwitch == 0;
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
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str) || StringUtil.NULL_STRING.equalsIgnoreCase(str)) {
                return;
            }
            try {
                genTipMap(new JSONObject(str));
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.b(e);
            }
        }

        public void setTipShowSwitch(int i) {
            this.tipShowSwitch = i;
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            r.a(jSONObject, "tipShowSwitch", this.tipShowSwitch);
            r.a(jSONObject, "tipInfo", this.tipInfo);
            return jSONObject;
        }
    }

    public TipsConfigItem() {
        super("tipConfig", new TipConfigData());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences.Editor editor) {
        editor.putInt("tipsSwitch", b().getTipShowSwitch());
        editor.putString("tipsInfo", b().getTipInfoData() != null ? b().getTipInfoData() : "");
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        TipConfigData b = b();
        if (b == null) {
            b = new TipConfigData();
        }
        b.setTipShowSwitch(sharedPreferences.getInt("tipsSwitch", 0));
        b.setTipInfoData(sharedPreferences.getString("tipsInfo", ""));
        a((TipsConfigItem) b);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(a())) == null) {
            a((TipsConfigItem) c());
            return;
        }
        TipConfigData tipConfigData = new TipConfigData();
        tipConfigData.parseJson(optJSONObject);
        a((TipsConfigItem) tipConfigData);
    }
}
