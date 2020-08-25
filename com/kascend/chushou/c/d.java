package com.kascend.chushou.c;

import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.constants.PannelItem;
import com.kascend.chushou.constants.ParserRet;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {
    public static ParserRet eh(JSONObject jSONObject) {
        String str;
        Exception e;
        int i = -1;
        tv.chushou.zues.utils.e.l("Parser_Home", "%s%s", "parseCommonAd:", jSONObject);
        ArrayList arrayList = new ArrayList();
        try {
            i = jSONObject.optInt("code", -1);
            str = jSONObject.optString("message");
        } catch (Exception e2) {
            str = "";
            e = e2;
        }
        try {
            tv.chushou.zues.utils.e.i("Parser_Home", "rc = " + i + " msg=" + str);
            if (i == 0 && jSONObject.has("data")) {
                JSONArray jSONArray = jSONObject.getJSONObject("data").getJSONArray("advertList");
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        if (optJSONObject != null) {
                            arrayList.add(a.ej(optJSONObject));
                        }
                    }
                }
                tv.chushou.zues.utils.e.i("Parser_Home", "parser sucess");
            }
        } catch (Exception e3) {
            e = e3;
            tv.chushou.zues.utils.e.e("Parser_Home", "error " + e.toString());
            ParserRet parserRet = new ParserRet();
            parserRet.mData = arrayList;
            parserRet.mRc = i;
            parserRet.mMessage = str;
            return parserRet;
        }
        ParserRet parserRet2 = new ParserRet();
        parserRet2.mData = arrayList;
        parserRet2.mRc = i;
        parserRet2.mMessage = str;
        return parserRet2;
    }

    public static ParserRet el(JSONObject jSONObject) {
        String str;
        Exception e;
        JSONObject jSONObject2;
        int i = -1;
        ListItem listItem = null;
        try {
            i = jSONObject.optInt("code", -1);
            str = jSONObject.optString("message");
            if (i == 0) {
                try {
                    if (jSONObject.has("data") && (jSONObject2 = jSONObject.getJSONObject("data").getJSONObject("advert")) != null) {
                        listItem = a.ej(jSONObject2);
                    }
                } catch (Exception e2) {
                    e = e2;
                    tv.chushou.zues.utils.e.e("Parser_Home", "error " + e.toString());
                    ParserRet parserRet = new ParserRet();
                    parserRet.mData = listItem;
                    parserRet.mRc = i;
                    parserRet.mMessage = str;
                    return parserRet;
                }
            }
        } catch (Exception e3) {
            str = "";
            e = e3;
        }
        ParserRet parserRet2 = new ParserRet();
        parserRet2.mData = listItem;
        parserRet2.mRc = i;
        parserRet2.mMessage = str;
        return parserRet2;
    }

    public static ParserRet em(JSONObject jSONObject) {
        ArrayList<PannelItem> ac;
        int optInt = jSONObject.optInt("code", -1);
        String optString = jSONObject.optString("message", "");
        String str = null;
        ArrayList arrayList = new ArrayList();
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            str = optJSONObject.optString("breakpoint");
            JSONArray optJSONArray = optJSONObject.optJSONArray("panels");
            if (optJSONArray != null && (ac = a.ac(optJSONArray)) != null) {
                arrayList.addAll(ac);
            }
        }
        ParserRet parserRet = new ParserRet();
        parserRet.mRc = optInt;
        parserRet.mMessage = optString;
        parserRet.mBreakpoint = str;
        parserRet.mData1 = arrayList;
        return parserRet;
    }
}
