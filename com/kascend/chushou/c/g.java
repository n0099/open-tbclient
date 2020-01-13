package com.kascend.chushou.c;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.mobstat.Config;
import com.coremedia.iso.boxes.MetaBox;
import com.kascend.chushou.constants.MyUserInfo;
import com.kascend.chushou.constants.ParserRet;
import com.kascend.chushou.constants.RoomInfo;
import com.kascend.chushou.d.h;
import com.tencent.open.SocialOperation;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {
    public static ParserRet dv(JSONObject jSONObject) {
        String str;
        MyUserInfo myUserInfo;
        int i;
        Exception exc;
        MyUserInfo myUserInfo2;
        JSONArray optJSONArray;
        JSONObject jSONObject2;
        JSONObject optJSONObject;
        tv.chushou.zues.utils.e.d("Parser_User", "parseUserInfo");
        int i2 = -1;
        String str2 = "";
        try {
            tv.chushou.zues.utils.e.i("Parser_User", "login json = " + jSONObject.toString());
            i2 = jSONObject.getInt("code");
            tv.chushou.zues.utils.e.i("Parser_User", "code = " + i2);
            str2 = jSONObject.optString("message", null);
            if (i2 == 0 && jSONObject.has("data")) {
                myUserInfo2 = new MyUserInfo();
                try {
                    JSONObject jSONObject3 = jSONObject.getJSONObject("data");
                    myUserInfo2.mToken = jSONObject3.optString("token");
                    myUserInfo2.isNewUser = jSONObject3.optBoolean("isNewUser");
                    if (jSONObject3.has("user") && (jSONObject2 = jSONObject3.getJSONObject("user")) != null) {
                        myUserInfo2.mUserID = jSONObject2.optString("uid");
                        myUserInfo2.mNickname = jSONObject2.optString("nickname");
                        myUserInfo2.mUsername = jSONObject2.optString("username");
                        myUserInfo2.mHeadiconUrl = jSONObject2.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
                        myUserInfo2.mGender = jSONObject2.optString("gender");
                        myUserInfo2.mSignature = jSONObject2.optString(SocialOperation.GAME_SIGNATURE);
                        myUserInfo2.mAge = jSONObject2.optString("age");
                        myUserInfo2.mGloriouslyUidMedal = jSONObject2.optString("gloriouslyUidMedal");
                        myUserInfo2.mGloriouslyUidColor = jSONObject2.optString("gloriouslyUidColor");
                        myUserInfo2.mGloriouslyUid = jSONObject2.optString("gloriouslyUid");
                        if (jSONObject2.has("rank")) {
                            JSONObject jSONObject4 = jSONObject2.getJSONObject("rank");
                            if (jSONObject4.has(Config.EVENT_HEAT_POINT)) {
                                h.dAK().b(jSONObject4.getString(Config.EVENT_HEAT_POINT), null);
                            }
                            if (jSONObject4.has("noblePoint")) {
                                h.dAK().a(jSONObject4.optString("noblePoint"));
                            }
                            if (jSONObject4.has("nobleState")) {
                                h.dAK().a(jSONObject4.optInt("nobleState"));
                            }
                        }
                        if (jSONObject2.has(MetaBox.TYPE) && (optJSONObject = jSONObject2.optJSONObject(MetaBox.TYPE)) != null) {
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray("avatarFrame");
                            if (!tv.chushou.zues.utils.h.Z(optJSONArray2)) {
                                myUserInfo2.mAvatarFrame = new ArrayList();
                                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                    myUserInfo2.mAvatarFrame.add(optJSONArray2.optString(0));
                                }
                            }
                            myUserInfo2.mNobleMedal = optJSONObject.optString("nobleMedal", "");
                        }
                    }
                    if (jSONObject3.has("verifyInfo")) {
                        JSONObject jSONObject5 = jSONObject3.getJSONObject("verifyInfo");
                        myUserInfo2.mVerifyBankCard = jSONObject5.optString("bankCard");
                        myUserInfo2.mVerifyName = jSONObject5.optString("idCard");
                        myUserInfo2.mVerifyPhone = jSONObject5.optString("phone");
                        myUserInfo2.mVerifyEmail = jSONObject5.optString("emailAddress");
                        myUserInfo2.mHasPassword = jSONObject5.optInt("hasPassword", 0);
                    }
                    if (jSONObject3.has("signTask")) {
                        JSONObject jSONObject6 = jSONObject3.getJSONObject("signTask");
                        myUserInfo2.mSignDesc = jSONObject6.optString("desc");
                        myUserInfo2.misSignIn = jSONObject6.optBoolean("hasSigned") ? "true" : "false";
                        myUserInfo2.mSignInDays = jSONObject6.optInt("continuousDays");
                    }
                    if (jSONObject3.has("roomList") && (optJSONArray = jSONObject3.optJSONArray("roomList")) != null && optJSONArray.length() > 0) {
                        int length = optJSONArray.length();
                        ArrayList arrayList = new ArrayList();
                        for (int i4 = 0; i4 < length; i4++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i4);
                            RoomInfo roomInfo = new RoomInfo();
                            f.a(optJSONObject2, roomInfo);
                            arrayList.add(roomInfo);
                        }
                        myUserInfo2.mRoomInfos = arrayList;
                    }
                } catch (Exception e) {
                    i = i2;
                    exc = e;
                    myUserInfo = myUserInfo2;
                    str = str2;
                    tv.chushou.zues.utils.e.e("Parser_User", "error " + exc.toString());
                    ParserRet parserRet = new ParserRet();
                    parserRet.mData = myUserInfo;
                    parserRet.mRc = i;
                    parserRet.mMessage = str;
                    parserRet.mTips = "";
                    return parserRet;
                }
            } else {
                myUserInfo2 = null;
            }
            i = i2;
            myUserInfo = myUserInfo2;
            str = str2;
        } catch (Exception e2) {
            str = str2;
            myUserInfo = null;
            i = i2;
            exc = e2;
        }
        ParserRet parserRet2 = new ParserRet();
        parserRet2.mData = myUserInfo;
        parserRet2.mRc = i;
        parserRet2.mMessage = str;
        parserRet2.mTips = "";
        return parserRet2;
    }
}
