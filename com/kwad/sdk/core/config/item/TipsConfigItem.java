package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class TipsConfigItem extends a<TipConfigData> {

    /* loaded from: classes5.dex */
    public static class TipConfigData implements com.kwad.sdk.core.b, Serializable {
        public static final String BOTTOM = "bottom";
        public static final String TOAST = "toast";
        private static final long serialVersionUID = 268961350883157950L;
        private String tipInfo;
        private transient Map<String, String> tipMap = new HashMap();
        private int tipShowSwitch;

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

        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            setTipInfoData(jSONObject.optString("tipInfo"));
            this.tipShowSwitch = jSONObject.optInt("tipShowSwitch", 0);
        }

        public void setTipInfoData(String str) {
            this.tipInfo = str;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str) || "null".equalsIgnoreCase(str)) {
                return;
            }
            try {
                genTipMap(new JSONObject(str));
            } catch (Exception e) {
                com.kwad.sdk.core.d.a.b(e);
            }
        }

        public void setTipShowSwitch(int i) {
            this.tipShowSwitch = i;
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "tipShowSwitch", this.tipShowSwitch);
            o.a(jSONObject, "tipInfo", this.tipInfo);
            return jSONObject;
        }
    }

    public TipsConfigItem() {
        super("tipConfig", new TipConfigData());
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences.Editor editor) {
        editor.putInt("tipsSwitch", b().getTipShowSwitch());
        if (b().getTipInfoData() != null) {
            editor.putString("tipsInfo", b().getTipInfoData());
        } else {
            editor.putString("tipsInfo", "");
        }
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(@NonNull SharedPreferences sharedPreferences) {
        TipConfigData b2 = b();
        if (b2 == null) {
            b2 = new TipConfigData();
        }
        b2.setTipShowSwitch(sharedPreferences.getInt("tipsSwitch", 0));
        b2.setTipInfoData(sharedPreferences.getString("tipsInfo", ""));
        a((TipsConfigItem) b2);
    }

    @Override // com.kwad.sdk.core.config.item.a
    public void a(JSONObject jSONObject) {
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
