package com.kwai.video.player.kwai_player;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ProductContext {
    String productContextJson;

    /* loaded from: classes4.dex */
    public static class Builder {
        private String bizType = "N/A";
        private int playIndex = -1;

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

    private ProductContext(Builder builder) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("biz_type", builder.bizType);
            jSONObject.put("play_index", builder.playIndex);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.productContextJson = jSONObject.toString();
    }
}
