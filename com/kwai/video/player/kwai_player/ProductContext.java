package com.kwai.video.player.kwai_player;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ProductContext {
    public String productContextJson;

    /* loaded from: classes6.dex */
    public static class Builder {
        public String bizType = "N/A";
        public int playIndex = -1;

        public ProductContext build() {
            return new ProductContext(this);
        }

        public Builder setBizType(String str) {
            this.bizType = str;
            return this;
        }

        public Builder setPlayIndex(int i) {
            this.playIndex = i;
            return this;
        }
    }

    public ProductContext(Builder builder) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("biz_type", builder.bizType);
            jSONObject.put("play_index", builder.playIndex);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.productContextJson = jSONObject.toString();
    }
}
