package com.tb.airbnb.lottie.model;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {
    @ColorInt
    public int color;
    int fF;
    public int fG;
    double fH;
    public double fI;
    @ColorInt
    public int fJ;
    public boolean fK;
    public String fontName;
    public int size;
    public int strokeWidth;
    public String text;

    d(String str, String str2, int i, int i2, int i3, double d, double d2, @ColorInt int i4, @ColorInt int i5, int i6, boolean z) {
        this.text = str;
        this.fontName = str2;
        this.size = i;
        this.fF = i2;
        this.fG = i3;
        this.fH = d;
        this.fI = d2;
        this.color = i4;
        this.fJ = i5;
        this.strokeWidth = i6;
        this.fK = z;
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static d cv(JSONObject jSONObject) {
            String optString = jSONObject.optString("t");
            String optString2 = jSONObject.optString(BdStatsConstant.StatsKey.FROM);
            int optInt = jSONObject.optInt("s");
            int optInt2 = jSONObject.optInt("j");
            int optInt3 = jSONObject.optInt("tr");
            double optDouble = jSONObject.optDouble(IXAdRequestInfo.QUERY_HEIGHT);
            double optDouble2 = jSONObject.optDouble("ls");
            JSONArray optJSONArray = jSONObject.optJSONArray("fc");
            int argb = Color.argb(255, (int) (optJSONArray.optDouble(0) * 255.0d), (int) (optJSONArray.optDouble(1) * 255.0d), (int) (optJSONArray.optDouble(2) * 255.0d));
            JSONArray optJSONArray2 = jSONObject.optJSONArray(Config.STAT_SDK_CHANNEL);
            int i = 0;
            if (optJSONArray2 != null) {
                i = Color.argb(255, (int) (optJSONArray2.optDouble(0) * 255.0d), (int) (optJSONArray2.optDouble(1) * 255.0d), (int) (optJSONArray2.optDouble(2) * 255.0d));
            }
            return new d(optString, optString2, optInt, optInt2, optInt3, optDouble, optDouble2, argb, i, jSONObject.optInt("sw"), jSONObject.optBoolean("of"));
        }
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.fH);
        return (((((((((((this.text.hashCode() * 31) + this.fontName.hashCode()) * 31) + this.size) * 31) + this.fF) * 31) + this.fG) * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.color;
    }
}
