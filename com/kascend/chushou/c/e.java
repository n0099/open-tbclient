package com.kascend.chushou.c;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.live.tbadk.img.effect.FilterImageAction;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.http.HttpConfig;
import com.baidu.tbadk.TbConfig;
import com.coremedia.iso.boxes.MetaBox;
import com.kascend.chushou.bean.KaraokeBean;
import com.kascend.chushou.constants.AutoBang;
import com.kascend.chushou.constants.BangInfo;
import com.kascend.chushou.constants.ChatInfo;
import com.kascend.chushou.constants.ConfigDetail;
import com.kascend.chushou.constants.CycleLiveRoomInfo;
import com.kascend.chushou.constants.FanItem;
import com.kascend.chushou.constants.H5Positon;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.constants.MicMemberInfo;
import com.kascend.chushou.constants.MicStatus;
import com.kascend.chushou.constants.MyUserInfo;
import com.kascend.chushou.constants.OnlineVip;
import com.kascend.chushou.constants.OnlineVipItem;
import com.kascend.chushou.constants.ParserRet;
import com.kascend.chushou.constants.PkNotifyInfo;
import com.kascend.chushou.constants.PkUpdateInfo;
import com.kascend.chushou.constants.PlayUrl;
import com.kascend.chushou.constants.PrivilegeInfo;
import com.kascend.chushou.constants.RoomChatBackground;
import com.kascend.chushou.constants.RoomExpandInfo;
import com.kascend.chushou.constants.RoomNewUserInfo;
import com.kascend.chushou.constants.SkinConfig;
import com.kascend.chushou.constants.TrumpetPocket;
import com.kascend.chushou.constants.UrlDetails;
import com.kascend.chushou.player.g;
import com.tencent.open.SocialOperation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.chushou.zues.toolkit.richtext.RichText;
import tv.chushou.zues.toolkit.richtext.RichTextPlus;
import tv.chushou.zues.utils.h;
/* loaded from: classes6.dex */
public class e {
    /* JADX WARN: Removed duplicated region for block: B:101:0x057c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0588  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x05a5  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x05c2  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x05dd  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x05f9  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0615  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x062f  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0649  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0667  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x06a1  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x06bd  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x06d7  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x06f1  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x06fd  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0708  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0718  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0727  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x04f3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0500  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0512  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0524  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0530  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x053b  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x054b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0555  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0561  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x056c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ParserRet F(JSONObject jSONObject, String str) {
        Exception exc;
        ArrayList arrayList;
        String str2;
        ArrayList arrayList2;
        KaraokeBean karaokeBean;
        ArrayList arrayList3;
        com.kascend.chushou.player.ui.h5.c.b bVar;
        BangInfo bangInfo;
        OnlineVip onlineVip;
        RoomChatBackground roomChatBackground;
        int i;
        ArrayList arrayList4;
        MicStatus micStatus;
        String str3;
        ArrayList arrayList5;
        CycleLiveRoomInfo cycleLiveRoomInfo;
        boolean z;
        AutoBang autoBang;
        com.kascend.chushou.player.ui.h5.c.c cVar;
        ArrayList arrayList6;
        ArrayList arrayList7;
        long j;
        Object obj;
        ParserRet parserRet;
        ArrayList arrayList8;
        ArrayList arrayList9;
        ArrayList arrayList10;
        RoomChatBackground roomChatBackground2;
        OnlineVip onlineVip2;
        BangInfo bangInfo2;
        String str4;
        boolean z2;
        CycleLiveRoomInfo cycleLiveRoomInfo2;
        ArrayList arrayList11;
        AutoBang autoBang2;
        KaraokeBean karaokeBean2;
        ArrayList arrayList12;
        com.kascend.chushou.player.ui.h5.c.c cVar2;
        com.kascend.chushou.player.ui.h5.c.b bVar2;
        RoomChatBackground roomChatBackground3;
        Object obj2;
        MicStatus micStatus2;
        ArrayList arrayList13;
        OnlineVip onlineVip3;
        BangInfo bangInfo3;
        OnlineVip onlineVip4;
        boolean z3;
        OnlineVip onlineVip5;
        CycleLiveRoomInfo cycleLiveRoomInfo3;
        KaraokeBean karaokeBean3;
        AutoBang autoBang3;
        com.kascend.chushou.player.ui.h5.c.c cVar3;
        com.kascend.chushou.player.ui.h5.c.b bVar3;
        ArrayList arrayList14;
        ArrayList arrayList15;
        Object obj3;
        ArrayList arrayList16;
        ArrayList arrayList17;
        MicStatus micStatus3;
        RoomChatBackground roomChatBackground4;
        BangInfo bangInfo4;
        com.kascend.chushou.player.ui.h5.c.c cVar4;
        RoomChatBackground roomChatBackground5;
        KaraokeBean karaokeBean4;
        ArrayList arrayList18;
        ArrayList arrayList19;
        ArrayList arrayList20 = null;
        ArrayList arrayList21 = null;
        int i2 = -1;
        String str5 = "";
        ArrayList arrayList22 = new ArrayList();
        ArrayList arrayList23 = new ArrayList();
        ArrayList arrayList24 = new ArrayList();
        try {
            i2 = jSONObject.getInt("code");
            if (jSONObject.has("message")) {
                str5 = jSONObject.getString("message");
            }
            if (i2 != 0 || !jSONObject.has("data")) {
                arrayList8 = null;
                arrayList9 = null;
                arrayList10 = null;
                arrayList7 = arrayList22;
                arrayList6 = null;
                obj = null;
                arrayList5 = null;
                arrayList4 = null;
                micStatus = null;
                roomChatBackground2 = null;
                onlineVip2 = null;
                bangInfo2 = null;
                str4 = "";
                karaokeBean = null;
                bVar = null;
                j = -1;
                z = false;
                cycleLiveRoomInfo = null;
                cVar = null;
                autoBang = null;
            } else {
                ArrayList arrayList25 = new ArrayList();
                try {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    long optLong = jSONObject2.optLong("currentTime");
                    String optString = jSONObject2.optString("breakpoint");
                    try {
                        long optLong2 = jSONObject2.optLong("interval", -1L);
                        try {
                            if (jSONObject2.has("items")) {
                                JSONArray jSONArray = jSONObject2.getJSONArray("items");
                                int length = jSONArray.length();
                                ArrayList arrayList26 = null;
                                ArrayList arrayList27 = null;
                                int i3 = 0;
                                while (i3 < length) {
                                    try {
                                        JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                                        if (optJSONObject.optInt("recOnly", -1) != 0) {
                                            arrayList18 = arrayList26;
                                            arrayList19 = arrayList27;
                                        } else {
                                            JSONObject optJSONObject2 = optJSONObject.optJSONObject("metaInfo");
                                            if (optJSONObject2 == null || a(optJSONObject2.optJSONArray("includexappkey"), optJSONObject2.optJSONArray("excludexappkey"))) {
                                                ChatInfo chatInfo = new ChatInfo();
                                                chatInfo.mID = optJSONObject.optString("id");
                                                chatInfo.mRoomID = optJSONObject.optString("roomId");
                                                chatInfo.mContent = optJSONObject.optString("content");
                                                chatInfo.mType = optJSONObject.optString("type");
                                                if (optJSONObject.has("user")) {
                                                    JSONObject jSONObject3 = optJSONObject.getJSONObject("user");
                                                    chatInfo.mUserID = jSONObject3.optString("uid");
                                                    chatInfo.mUserNickname = jSONObject3.optString("nickname");
                                                    chatInfo.mHeadIcon = jSONObject3.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
                                                    chatInfo.mGender = jSONObject3.optString("gender");
                                                }
                                                chatInfo.mPrivilegeInfo.mRole = optJSONObject.optString("isManager");
                                                if (optJSONObject.has("medalList")) {
                                                    JSONArray jSONArray2 = optJSONObject.getJSONArray("medalList");
                                                    if (chatInfo.mPrivilegeInfo.mMedals == null) {
                                                        chatInfo.mPrivilegeInfo.mMedals = new ArrayList<>();
                                                    }
                                                    for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                                                        chatInfo.mPrivilegeInfo.mMedals.add(jSONArray2.getJSONObject(i4).getString("url"));
                                                    }
                                                }
                                                if (optJSONObject.has("metaInfo")) {
                                                    JSONObject jSONObject4 = optJSONObject.getJSONObject("metaInfo");
                                                    chatInfo.mFilter = jSONObject4.optBoolean(FilterImageAction.ACTION_NAME);
                                                    chatInfo.mAnimationPluginId = jSONObject4.optInt("animationPluginId", 1);
                                                    chatInfo.giftType = jSONObject4.optInt("giftType", 1);
                                                    if (chatInfo.giftType == 2) {
                                                        arrayList18 = arrayList26;
                                                        arrayList19 = arrayList27;
                                                    } else {
                                                        chatInfo.giftDisplayWidth = jSONObject4.optInt("giftDisplayWidth", 0);
                                                        chatInfo.giftDisplayHeight = jSONObject4.optInt("giftDisplayHeight");
                                                        if (jSONObject4.has("displayPosition")) {
                                                            chatInfo.mDisplayPosition = new ArrayList();
                                                            JSONArray optJSONArray = jSONObject4.optJSONArray("displayPosition");
                                                            for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                                                                chatInfo.mDisplayPosition.add(optJSONArray.optString(i5));
                                                            }
                                                        }
                                                        chatInfo.mPrivilegeInfo.mShowAvatar = jSONObject4.optBoolean("showAvatar");
                                                        chatInfo.mPrivilegeInfo.mAvatarFrame = jSONObject4.optString("avatarFrame");
                                                        chatInfo.mGift.mRepeatedBg = jSONObject4.optString("ucombo_bg");
                                                        if (jSONObject4.has("nav")) {
                                                            chatInfo.mItem = a.er(jSONObject4.optJSONObject("nav"));
                                                        }
                                                        if (jSONObject4.has(UbcStatConstant.DebugContentValue.GIFT)) {
                                                            JSONObject jSONObject5 = jSONObject4.getJSONObject(UbcStatConstant.DebugContentValue.GIFT);
                                                            chatInfo.mGift.mDesc = jSONObject5.optString("desc");
                                                            chatInfo.mGift.icon = jSONObject5.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                                                            chatInfo.mGift.point = jSONObject5.optInt(Config.EVENT_HEAT_POINT);
                                                            chatInfo.mGift.name = jSONObject5.optString("name");
                                                            chatInfo.mGift.id = jSONObject5.optInt("id");
                                                        }
                                                        chatInfo.mAnimType = jSONObject4.optInt("animation");
                                                        chatInfo.mAnimSubType = jSONObject4.optInt("animationSubType");
                                                        chatInfo.mAnimationType = jSONObject4.optInt("animationType");
                                                        chatInfo.mRoomComboCount = jSONObject4.optInt("rcombo", -1);
                                                        chatInfo.mUserComboCount = jSONObject4.optInt("ucombo", 1);
                                                        chatInfo.mAnimationPriority = jSONObject4.optInt("animationPriority", 0);
                                                        chatInfo.mAnimationStage = jSONObject4.optInt("animationStage", 1);
                                                        chatInfo.mAnimationDisplayText = jSONObject4.optString("animationDisplayText");
                                                        chatInfo.isBatchGift = jSONObject4.optBoolean("isBatchGift");
                                                        if (jSONObject4.has("coolNickname")) {
                                                            JSONObject jSONObject6 = jSONObject4.getJSONObject("coolNickname");
                                                            chatInfo.mCoolNickname = new RichTextPlus();
                                                            chatInfo.mCoolNickname.mNicknameRichText = tv.chushou.zues.toolkit.richtext.b.Xv(jSONObject6.optString("nickname"));
                                                            chatInfo.mCoolNickname.mFontColors = (ArrayList) a(jSONObject6.optJSONArray("colors"));
                                                            if (!h.isEmpty(chatInfo.mCoolNickname.mNicknameRichText)) {
                                                                chatInfo.mCoolNickname.mNickName = "";
                                                                StringBuilder sb = new StringBuilder();
                                                                sb.append(chatInfo.mCoolNickname.mNickName);
                                                                Iterator<RichText> it = chatInfo.mCoolNickname.mNicknameRichText.iterator();
                                                                while (it.hasNext()) {
                                                                    sb.append(it.next().mContent);
                                                                }
                                                                chatInfo.mCoolNickname.mNickName = sb.toString();
                                                            }
                                                        }
                                                        if (jSONObject4.has("coolContent")) {
                                                            JSONObject jSONObject7 = jSONObject4.getJSONObject("coolContent");
                                                            chatInfo.mCoolContent = new RichTextPlus();
                                                            chatInfo.mCoolContent.mContentRichText = tv.chushou.zues.toolkit.richtext.b.Xv(jSONObject7.optString("content"));
                                                            chatInfo.mCoolContent.mFontColors = (ArrayList) a(jSONObject7.optJSONArray("colors"));
                                                            if (!h.isEmpty(chatInfo.mCoolContent.mContentRichText)) {
                                                                chatInfo.mCoolContent.mContent = "";
                                                                StringBuilder sb2 = new StringBuilder();
                                                                sb2.append(chatInfo.mCoolContent.mContent);
                                                                Iterator<RichText> it2 = chatInfo.mCoolContent.mContentRichText.iterator();
                                                                while (it2.hasNext()) {
                                                                    sb2.append(it2.next().mContent);
                                                                }
                                                                chatInfo.mCoolContent.mContent = sb2.toString();
                                                            }
                                                        }
                                                        if (jSONObject4.has("coolMessage")) {
                                                            JSONObject jSONObject8 = jSONObject4.getJSONObject("coolMessage");
                                                            chatInfo.mCoolMessage = new RichTextPlus();
                                                            chatInfo.mCoolMessage.mContentRichText = tv.chushou.zues.toolkit.richtext.b.Xv(jSONObject8.optString("content"));
                                                            chatInfo.mCoolMessage.mNicknameRichText = tv.chushou.zues.toolkit.richtext.b.Xv(jSONObject8.optString("nickname"));
                                                            chatInfo.mCoolMessage.mBgImage = jSONObject8.optString("bgImage");
                                                            if (!h.isEmpty(chatInfo.mCoolMessage.mNicknameRichText)) {
                                                                chatInfo.mCoolMessage.mNickName = "";
                                                                StringBuilder sb3 = new StringBuilder();
                                                                sb3.append(chatInfo.mCoolMessage.mNickName);
                                                                Iterator<RichText> it3 = chatInfo.mCoolMessage.mNicknameRichText.iterator();
                                                                while (it3.hasNext()) {
                                                                    sb3.append(it3.next().mContent);
                                                                }
                                                                chatInfo.mCoolMessage.mNickName = sb3.toString();
                                                            }
                                                            if (!h.isEmpty(chatInfo.mCoolMessage.mContentRichText)) {
                                                                chatInfo.mCoolMessage.mContent = "";
                                                                StringBuilder sb4 = new StringBuilder();
                                                                sb4.append(chatInfo.mCoolMessage.mContent);
                                                                Iterator<RichText> it4 = chatInfo.mCoolMessage.mContentRichText.iterator();
                                                                while (it4.hasNext()) {
                                                                    sb4.append(it4.next().mContent);
                                                                }
                                                                chatInfo.mCoolMessage.mContent = sb4.toString();
                                                            }
                                                        }
                                                    }
                                                }
                                                chatInfo.mCreatedTime = optJSONObject.optLong("createdTime");
                                                chatInfo.mContentRichText = tv.chushou.zues.toolkit.richtext.b.Xv(chatInfo.mContent);
                                                if (chatInfo.mContentRichText != null && chatInfo.mContentRichText.size() > 0) {
                                                    chatInfo.mContent = "";
                                                    StringBuilder sb5 = new StringBuilder();
                                                    sb5.append(chatInfo.mContent);
                                                    Iterator<RichText> it5 = chatInfo.mContentRichText.iterator();
                                                    while (it5.hasNext()) {
                                                        sb5.append(it5.next().mContent);
                                                    }
                                                    chatInfo.mContent = sb5.toString();
                                                }
                                                chatInfo.mNicknameRichText = tv.chushou.zues.toolkit.richtext.b.Xv(chatInfo.mUserNickname);
                                                if (chatInfo.mNicknameRichText != null && chatInfo.mNicknameRichText.size() > 0) {
                                                    chatInfo.mPrivilegeInfo.mRichNickname = chatInfo.mNicknameRichText;
                                                    chatInfo.mUserNickname = "";
                                                    StringBuilder sb6 = new StringBuilder();
                                                    sb6.append(chatInfo.mUserNickname);
                                                    Iterator<RichText> it6 = chatInfo.mNicknameRichText.iterator();
                                                    while (it6.hasNext()) {
                                                        sb6.append(it6.next().mContent);
                                                    }
                                                    chatInfo.mUserNickname = sb6.toString();
                                                }
                                                if (!"2".equals(chatInfo.mType) || h.isEmpty(chatInfo.mDisplayPosition) || chatInfo.mDisplayPosition.contains("2") || chatInfo.mDisplayPosition.contains("3")) {
                                                    arrayList25.add(chatInfo);
                                                }
                                                if (chatInfo.mAnimType > 0) {
                                                    ArrayList arrayList28 = arrayList27 == null ? new ArrayList() : arrayList27;
                                                    try {
                                                        chatInfo.mJsonData = optJSONObject;
                                                        arrayList28.add(chatInfo);
                                                        arrayList27 = arrayList28;
                                                    } catch (Exception e) {
                                                        karaokeBean = null;
                                                        arrayList2 = arrayList28;
                                                        bVar = null;
                                                        arrayList3 = arrayList25;
                                                        exc = e;
                                                        z = false;
                                                        autoBang = null;
                                                        arrayList7 = arrayList22;
                                                        j = optLong2;
                                                        bangInfo = null;
                                                        str2 = optString;
                                                        onlineVip = null;
                                                        arrayList = arrayList26;
                                                        roomChatBackground = null;
                                                        cycleLiveRoomInfo = null;
                                                        i = i2;
                                                        cVar = null;
                                                        arrayList6 = null;
                                                        obj = null;
                                                        arrayList5 = null;
                                                        arrayList4 = null;
                                                        micStatus = null;
                                                        str3 = str5;
                                                        tv.chushou.zues.utils.e.e("Parser_Player", "error " + exc.toString());
                                                        parserRet = new ParserRet();
                                                        parserRet.mBreakpoint = str2;
                                                        parserRet.mData = arrayList3;
                                                        parserRet.mData1 = Long.valueOf(j);
                                                        if (arrayList2 == null) {
                                                        }
                                                        parserRet.mData2 = new SparseArray();
                                                        if (arrayList2 != null) {
                                                            parserRet.mData2.put(1, arrayList2);
                                                        }
                                                        if (arrayList != null) {
                                                            parserRet.mData2.put(2, arrayList);
                                                        }
                                                        if (bangInfo == null) {
                                                        }
                                                        if (parserRet.mData3 == null) {
                                                        }
                                                        if (bangInfo != null) {
                                                        }
                                                        if (!h.isEmpty(arrayList7)) {
                                                        }
                                                        if (micStatus == null) {
                                                        }
                                                        if (parserRet.mData3 == null) {
                                                        }
                                                        if (micStatus != null) {
                                                        }
                                                        if (!h.isEmpty(arrayList4)) {
                                                        }
                                                        if (obj != null) {
                                                        }
                                                        if (!h.isEmpty(arrayList6)) {
                                                        }
                                                        if (!h.isEmpty(arrayList23)) {
                                                        }
                                                        if (roomChatBackground != null) {
                                                        }
                                                        if (onlineVip != null) {
                                                        }
                                                        if (cVar != null) {
                                                        }
                                                        if (autoBang != null) {
                                                        }
                                                        if (karaokeBean != null) {
                                                        }
                                                        if (!h.isEmpty(arrayList24)) {
                                                        }
                                                        if (0 != 0) {
                                                        }
                                                        if (bVar != null) {
                                                        }
                                                        if (cycleLiveRoomInfo != null) {
                                                        }
                                                        if (micStatus == null) {
                                                        }
                                                        if (parserRet.mData3 == null) {
                                                        }
                                                        if (micStatus != null) {
                                                        }
                                                        if (!h.isEmpty(arrayList4)) {
                                                        }
                                                        if (parserRet.mData3 == null) {
                                                        }
                                                        parserRet.mData3.put(19, Boolean.valueOf(z));
                                                        parserRet.mRc = i;
                                                        parserRet.mMessage = str3;
                                                        return parserRet;
                                                    }
                                                }
                                                if ("2".equals(chatInfo.mType) && (h.isEmpty(chatInfo.mDisplayPosition) || chatInfo.mDisplayPosition.contains("1"))) {
                                                    arrayList18 = arrayList26 == null ? new ArrayList() : arrayList26;
                                                    try {
                                                        arrayList18.add(chatInfo);
                                                        arrayList19 = arrayList27;
                                                    } catch (Exception e2) {
                                                        arrayList2 = arrayList27;
                                                        arrayList3 = arrayList25;
                                                        karaokeBean = null;
                                                        exc = e2;
                                                        bVar = null;
                                                        cycleLiveRoomInfo = null;
                                                        cVar = null;
                                                        arrayList6 = null;
                                                        obj = null;
                                                        arrayList5 = null;
                                                        arrayList4 = null;
                                                        micStatus = null;
                                                        str3 = str5;
                                                        bangInfo = null;
                                                        str2 = optString;
                                                        onlineVip = null;
                                                        arrayList = arrayList18;
                                                        roomChatBackground = null;
                                                        z = false;
                                                        i = i2;
                                                        autoBang = null;
                                                        arrayList7 = arrayList22;
                                                        j = optLong2;
                                                        tv.chushou.zues.utils.e.e("Parser_Player", "error " + exc.toString());
                                                        parserRet = new ParserRet();
                                                        parserRet.mBreakpoint = str2;
                                                        parserRet.mData = arrayList3;
                                                        parserRet.mData1 = Long.valueOf(j);
                                                        if (arrayList2 == null) {
                                                        }
                                                        parserRet.mData2 = new SparseArray();
                                                        if (arrayList2 != null) {
                                                        }
                                                        if (arrayList != null) {
                                                        }
                                                        if (bangInfo == null) {
                                                        }
                                                        if (parserRet.mData3 == null) {
                                                        }
                                                        if (bangInfo != null) {
                                                        }
                                                        if (!h.isEmpty(arrayList7)) {
                                                        }
                                                        if (micStatus == null) {
                                                        }
                                                        if (parserRet.mData3 == null) {
                                                        }
                                                        if (micStatus != null) {
                                                        }
                                                        if (!h.isEmpty(arrayList4)) {
                                                        }
                                                        if (obj != null) {
                                                        }
                                                        if (!h.isEmpty(arrayList6)) {
                                                        }
                                                        if (!h.isEmpty(arrayList23)) {
                                                        }
                                                        if (roomChatBackground != null) {
                                                        }
                                                        if (onlineVip != null) {
                                                        }
                                                        if (cVar != null) {
                                                        }
                                                        if (autoBang != null) {
                                                        }
                                                        if (karaokeBean != null) {
                                                        }
                                                        if (!h.isEmpty(arrayList24)) {
                                                        }
                                                        if (0 != 0) {
                                                        }
                                                        if (bVar != null) {
                                                        }
                                                        if (cycleLiveRoomInfo != null) {
                                                        }
                                                        if (micStatus == null) {
                                                        }
                                                        if (parserRet.mData3 == null) {
                                                        }
                                                        if (micStatus != null) {
                                                        }
                                                        if (!h.isEmpty(arrayList4)) {
                                                        }
                                                        if (parserRet.mData3 == null) {
                                                        }
                                                        parserRet.mData3.put(19, Boolean.valueOf(z));
                                                        parserRet.mRc = i;
                                                        parserRet.mMessage = str3;
                                                        return parserRet;
                                                    }
                                                } else {
                                                    arrayList18 = arrayList26;
                                                    arrayList19 = arrayList27;
                                                }
                                            } else {
                                                arrayList18 = arrayList26;
                                                arrayList19 = arrayList27;
                                            }
                                        }
                                        i3++;
                                        arrayList27 = arrayList19;
                                        arrayList26 = arrayList18;
                                    } catch (Exception e3) {
                                        arrayList2 = arrayList27;
                                        arrayList3 = arrayList25;
                                        karaokeBean = null;
                                        exc = e3;
                                        bVar = null;
                                        z = false;
                                        autoBang = null;
                                        arrayList7 = arrayList22;
                                        j = optLong2;
                                        bangInfo = null;
                                        str2 = optString;
                                        onlineVip = null;
                                        arrayList = arrayList26;
                                        roomChatBackground = null;
                                        cycleLiveRoomInfo = null;
                                        i = i2;
                                        cVar = null;
                                        arrayList6 = null;
                                        obj = null;
                                        arrayList5 = null;
                                        arrayList4 = null;
                                        micStatus = null;
                                        str3 = str5;
                                    }
                                }
                                arrayList21 = arrayList26;
                                arrayList20 = arrayList27;
                            }
                            try {
                                if (!jSONObject2.has("bgItems")) {
                                    z2 = false;
                                    cycleLiveRoomInfo2 = null;
                                    arrayList11 = arrayList22;
                                    autoBang2 = null;
                                    karaokeBean2 = null;
                                    arrayList12 = null;
                                    cVar2 = null;
                                    bVar2 = null;
                                    roomChatBackground3 = null;
                                    arrayList6 = null;
                                    obj2 = null;
                                    micStatus2 = null;
                                    arrayList13 = null;
                                    onlineVip3 = null;
                                    bangInfo3 = null;
                                } else {
                                    JSONArray jSONArray3 = jSONObject2.getJSONArray("bgItems");
                                    int length2 = jSONArray3.length();
                                    z2 = false;
                                    cycleLiveRoomInfo2 = null;
                                    karaokeBean2 = null;
                                    autoBang2 = null;
                                    cVar2 = null;
                                    bVar2 = null;
                                    ArrayList arrayList29 = arrayList22;
                                    ArrayList arrayList30 = null;
                                    Object obj4 = null;
                                    ArrayList arrayList31 = null;
                                    ArrayList arrayList32 = null;
                                    MicStatus micStatus4 = null;
                                    RoomChatBackground roomChatBackground6 = null;
                                    OnlineVip onlineVip6 = null;
                                    BangInfo bangInfo5 = null;
                                    int i6 = 0;
                                    while (i6 < length2) {
                                        try {
                                            JSONObject optJSONObject3 = jSONArray3.optJSONObject(i6);
                                            if (optJSONObject3 == null) {
                                                onlineVip5 = onlineVip6;
                                                z3 = z2;
                                                cycleLiveRoomInfo3 = cycleLiveRoomInfo2;
                                                karaokeBean3 = karaokeBean2;
                                                autoBang3 = autoBang2;
                                                cVar3 = cVar2;
                                                bVar3 = bVar2;
                                                arrayList14 = arrayList29;
                                                arrayList15 = arrayList30;
                                                obj3 = obj4;
                                                arrayList16 = arrayList31;
                                                arrayList17 = arrayList32;
                                                micStatus3 = micStatus4;
                                                roomChatBackground4 = roomChatBackground6;
                                                bangInfo4 = bangInfo5;
                                            } else if (a(optJSONObject3.optJSONArray("includexappkey"), optJSONObject3.optJSONArray("excludexappkey"))) {
                                                if (optJSONObject3.has("onlineVipCount")) {
                                                    onlineVip4 = onlineVip6 == null ? new OnlineVip() : onlineVip6;
                                                    try {
                                                        onlineVip4.mCount = h.parseInt(optJSONObject3.optString("onlineVipCount"));
                                                    } catch (Exception e4) {
                                                        micStatus = micStatus4;
                                                        onlineVip = onlineVip4;
                                                        arrayList4 = arrayList32;
                                                        i = i2;
                                                        arrayList5 = arrayList31;
                                                        obj = obj4;
                                                        com.kascend.chushou.player.ui.h5.c.b bVar4 = bVar2;
                                                        arrayList7 = arrayList29;
                                                        arrayList6 = arrayList30;
                                                        j = optLong2;
                                                        bangInfo = bangInfo5;
                                                        str2 = optString;
                                                        roomChatBackground = roomChatBackground6;
                                                        arrayList = arrayList21;
                                                        str3 = str5;
                                                        arrayList2 = arrayList20;
                                                        arrayList3 = arrayList25;
                                                        exc = e4;
                                                        z = z2;
                                                        cycleLiveRoomInfo = cycleLiveRoomInfo2;
                                                        karaokeBean = karaokeBean2;
                                                        autoBang = autoBang2;
                                                        cVar = cVar2;
                                                        bVar = bVar4;
                                                        tv.chushou.zues.utils.e.e("Parser_Player", "error " + exc.toString());
                                                        parserRet = new ParserRet();
                                                        parserRet.mBreakpoint = str2;
                                                        parserRet.mData = arrayList3;
                                                        parserRet.mData1 = Long.valueOf(j);
                                                        if (arrayList2 == null) {
                                                        }
                                                        parserRet.mData2 = new SparseArray();
                                                        if (arrayList2 != null) {
                                                        }
                                                        if (arrayList != null) {
                                                        }
                                                        if (bangInfo == null) {
                                                        }
                                                        if (parserRet.mData3 == null) {
                                                        }
                                                        if (bangInfo != null) {
                                                        }
                                                        if (!h.isEmpty(arrayList7)) {
                                                        }
                                                        if (micStatus == null) {
                                                        }
                                                        if (parserRet.mData3 == null) {
                                                        }
                                                        if (micStatus != null) {
                                                        }
                                                        if (!h.isEmpty(arrayList4)) {
                                                        }
                                                        if (obj != null) {
                                                        }
                                                        if (!h.isEmpty(arrayList6)) {
                                                        }
                                                        if (!h.isEmpty(arrayList23)) {
                                                        }
                                                        if (roomChatBackground != null) {
                                                        }
                                                        if (onlineVip != null) {
                                                        }
                                                        if (cVar != null) {
                                                        }
                                                        if (autoBang != null) {
                                                        }
                                                        if (karaokeBean != null) {
                                                        }
                                                        if (!h.isEmpty(arrayList24)) {
                                                        }
                                                        if (0 != 0) {
                                                        }
                                                        if (bVar != null) {
                                                        }
                                                        if (cycleLiveRoomInfo != null) {
                                                        }
                                                        if (micStatus == null) {
                                                        }
                                                        if (parserRet.mData3 == null) {
                                                        }
                                                        if (micStatus != null) {
                                                        }
                                                        if (!h.isEmpty(arrayList4)) {
                                                        }
                                                        if (parserRet.mData3 == null) {
                                                        }
                                                        parserRet.mData3.put(19, Boolean.valueOf(z));
                                                        parserRet.mRc = i;
                                                        parserRet.mMessage = str3;
                                                        return parserRet;
                                                    }
                                                } else {
                                                    onlineVip4 = onlineVip6;
                                                }
                                                if (optJSONObject3.has("onlineVipList")) {
                                                    if (onlineVip4 == null) {
                                                        onlineVip4 = new OnlineVip();
                                                    }
                                                    if (onlineVip4.mOnlineVipItems == null) {
                                                        onlineVip4.mOnlineVipItems = new ArrayList();
                                                    }
                                                    JSONArray optJSONArray2 = optJSONObject3.optJSONArray("onlineVipList");
                                                    for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                                                        JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i7);
                                                        OnlineVipItem onlineVipItem = new OnlineVipItem();
                                                        onlineVipItem.mUid = optJSONObject4.optString("uid");
                                                        onlineVipItem.mAvatar = optJSONObject4.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
                                                        onlineVipItem.mScore = optJSONObject4.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
                                                        onlineVip4.mOnlineVipItems.add(onlineVipItem);
                                                    }
                                                }
                                                int optInt = optJSONObject3.optInt("type");
                                                if (optInt == 10001) {
                                                    if (optJSONObject3.has("coverChatBackground")) {
                                                        roomChatBackground5 = new RoomChatBackground();
                                                        try {
                                                            roomChatBackground5.mCoverChatBackground = optJSONObject3.optBoolean("coverChatBackground");
                                                            roomChatBackground5.mChatBackground = optJSONObject3.optString("chatBackground");
                                                        } catch (Exception e5) {
                                                            str3 = str5;
                                                            onlineVip = onlineVip4;
                                                            i = i2;
                                                            KaraokeBean karaokeBean5 = karaokeBean2;
                                                            autoBang = autoBang2;
                                                            cVar = cVar2;
                                                            bVar = bVar2;
                                                            arrayList7 = arrayList29;
                                                            arrayList6 = arrayList30;
                                                            bangInfo = bangInfo5;
                                                            str2 = optString;
                                                            roomChatBackground = roomChatBackground5;
                                                            arrayList = arrayList21;
                                                            micStatus = micStatus4;
                                                            arrayList2 = arrayList20;
                                                            arrayList4 = arrayList32;
                                                            arrayList3 = arrayList25;
                                                            arrayList5 = arrayList31;
                                                            exc = e5;
                                                            obj = obj4;
                                                            z = z2;
                                                            j = optLong2;
                                                            cycleLiveRoomInfo = cycleLiveRoomInfo2;
                                                            karaokeBean = karaokeBean5;
                                                            tv.chushou.zues.utils.e.e("Parser_Player", "error " + exc.toString());
                                                            parserRet = new ParserRet();
                                                            parserRet.mBreakpoint = str2;
                                                            parserRet.mData = arrayList3;
                                                            parserRet.mData1 = Long.valueOf(j);
                                                            if (arrayList2 == null) {
                                                            }
                                                            parserRet.mData2 = new SparseArray();
                                                            if (arrayList2 != null) {
                                                            }
                                                            if (arrayList != null) {
                                                            }
                                                            if (bangInfo == null) {
                                                            }
                                                            if (parserRet.mData3 == null) {
                                                            }
                                                            if (bangInfo != null) {
                                                            }
                                                            if (!h.isEmpty(arrayList7)) {
                                                            }
                                                            if (micStatus == null) {
                                                            }
                                                            if (parserRet.mData3 == null) {
                                                            }
                                                            if (micStatus != null) {
                                                            }
                                                            if (!h.isEmpty(arrayList4)) {
                                                            }
                                                            if (obj != null) {
                                                            }
                                                            if (!h.isEmpty(arrayList6)) {
                                                            }
                                                            if (!h.isEmpty(arrayList23)) {
                                                            }
                                                            if (roomChatBackground != null) {
                                                            }
                                                            if (onlineVip != null) {
                                                            }
                                                            if (cVar != null) {
                                                            }
                                                            if (autoBang != null) {
                                                            }
                                                            if (karaokeBean != null) {
                                                            }
                                                            if (!h.isEmpty(arrayList24)) {
                                                            }
                                                            if (0 != 0) {
                                                            }
                                                            if (bVar != null) {
                                                            }
                                                            if (cycleLiveRoomInfo != null) {
                                                            }
                                                            if (micStatus == null) {
                                                            }
                                                            if (parserRet.mData3 == null) {
                                                            }
                                                            if (micStatus != null) {
                                                            }
                                                            if (!h.isEmpty(arrayList4)) {
                                                            }
                                                            if (parserRet.mData3 == null) {
                                                            }
                                                            parserRet.mData3.put(19, Boolean.valueOf(z));
                                                            parserRet.mRc = i;
                                                            parserRet.mMessage = str3;
                                                            return parserRet;
                                                        }
                                                    } else {
                                                        roomChatBackground5 = roomChatBackground6;
                                                    }
                                                    bangInfo4 = new BangInfo();
                                                    try {
                                                        bangInfo4.mOnlineCount = optJSONObject3.optString("onlineCount");
                                                        bangInfo4.mReceivePoint = optJSONObject3.optString("receivePoint");
                                                        bangInfo4.mSubscriberCount = optJSONObject3.optString("subscriberCount");
                                                        bangInfo4.mCurPoint = optJSONObject3.optLong("currentPoint");
                                                        bangInfo4.mStartPoint = optJSONObject3.optLong("startPoint");
                                                        bangInfo4.mEndPoint = optJSONObject3.optLong("endPoint");
                                                        bangInfo4.mLevel = optJSONObject3.optInt("level");
                                                        bangInfo4.mRoomH5Data = optJSONObject3.optString("h5Data");
                                                        String optString2 = optJSONObject3.optString("karaokeInfoMap");
                                                        if (TextUtils.isEmpty(optString2)) {
                                                            karaokeBean4 = karaokeBean2;
                                                        } else {
                                                            karaokeBean4 = (KaraokeBean) tv.chushou.zues.utils.d.c(optString2, (Class<Object>) KaraokeBean.class);
                                                            if (karaokeBean4 != null) {
                                                                try {
                                                                    if (karaokeBean4.actingInfo != null) {
                                                                        karaokeBean4.actingInfo.currentTime = optLong;
                                                                    }
                                                                } catch (Exception e6) {
                                                                    roomChatBackground = roomChatBackground5;
                                                                    onlineVip = onlineVip4;
                                                                    micStatus = micStatus4;
                                                                    i = i2;
                                                                    arrayList4 = arrayList32;
                                                                    arrayList5 = arrayList31;
                                                                    obj = obj4;
                                                                    ArrayList arrayList33 = arrayList29;
                                                                    arrayList6 = arrayList30;
                                                                    j = optLong2;
                                                                    bangInfo = bangInfo4;
                                                                    str2 = optString;
                                                                    str3 = str5;
                                                                    arrayList = arrayList21;
                                                                    arrayList2 = arrayList20;
                                                                    arrayList3 = arrayList25;
                                                                    exc = e6;
                                                                    autoBang = autoBang2;
                                                                    cVar = cVar2;
                                                                    bVar = bVar2;
                                                                    arrayList7 = arrayList33;
                                                                    z = z2;
                                                                    cycleLiveRoomInfo = cycleLiveRoomInfo2;
                                                                    karaokeBean = karaokeBean4;
                                                                    tv.chushou.zues.utils.e.e("Parser_Player", "error " + exc.toString());
                                                                    parserRet = new ParserRet();
                                                                    parserRet.mBreakpoint = str2;
                                                                    parserRet.mData = arrayList3;
                                                                    parserRet.mData1 = Long.valueOf(j);
                                                                    if (arrayList2 == null) {
                                                                    }
                                                                    parserRet.mData2 = new SparseArray();
                                                                    if (arrayList2 != null) {
                                                                    }
                                                                    if (arrayList != null) {
                                                                    }
                                                                    if (bangInfo == null) {
                                                                    }
                                                                    if (parserRet.mData3 == null) {
                                                                    }
                                                                    if (bangInfo != null) {
                                                                    }
                                                                    if (!h.isEmpty(arrayList7)) {
                                                                    }
                                                                    if (micStatus == null) {
                                                                    }
                                                                    if (parserRet.mData3 == null) {
                                                                    }
                                                                    if (micStatus != null) {
                                                                    }
                                                                    if (!h.isEmpty(arrayList4)) {
                                                                    }
                                                                    if (obj != null) {
                                                                    }
                                                                    if (!h.isEmpty(arrayList6)) {
                                                                    }
                                                                    if (!h.isEmpty(arrayList23)) {
                                                                    }
                                                                    if (roomChatBackground != null) {
                                                                    }
                                                                    if (onlineVip != null) {
                                                                    }
                                                                    if (cVar != null) {
                                                                    }
                                                                    if (autoBang != null) {
                                                                    }
                                                                    if (karaokeBean != null) {
                                                                    }
                                                                    if (!h.isEmpty(arrayList24)) {
                                                                    }
                                                                    if (0 != 0) {
                                                                    }
                                                                    if (bVar != null) {
                                                                    }
                                                                    if (cycleLiveRoomInfo != null) {
                                                                    }
                                                                    if (micStatus == null) {
                                                                    }
                                                                    if (parserRet.mData3 == null) {
                                                                    }
                                                                    if (micStatus != null) {
                                                                    }
                                                                    if (!h.isEmpty(arrayList4)) {
                                                                    }
                                                                    if (parserRet.mData3 == null) {
                                                                    }
                                                                    parserRet.mData3.put(19, Boolean.valueOf(z));
                                                                    parserRet.mRc = i;
                                                                    parserRet.mMessage = str3;
                                                                    return parserRet;
                                                                }
                                                            }
                                                        }
                                                        autoBang3 = autoBang2;
                                                        cVar3 = cVar2;
                                                        bVar3 = bVar2;
                                                        arrayList14 = arrayList29;
                                                        arrayList15 = arrayList30;
                                                        obj3 = obj4;
                                                        arrayList16 = arrayList31;
                                                        arrayList17 = arrayList32;
                                                        micStatus3 = micStatus4;
                                                        roomChatBackground4 = roomChatBackground5;
                                                        onlineVip5 = onlineVip4;
                                                        KaraokeBean karaokeBean6 = karaokeBean4;
                                                        z3 = z2;
                                                        cycleLiveRoomInfo3 = cycleLiveRoomInfo2;
                                                        karaokeBean3 = karaokeBean6;
                                                    } catch (Exception e7) {
                                                        roomChatBackground = roomChatBackground5;
                                                        onlineVip = onlineVip4;
                                                        micStatus = micStatus4;
                                                        i = i2;
                                                        arrayList4 = arrayList32;
                                                        arrayList5 = arrayList31;
                                                        obj = obj4;
                                                        ArrayList arrayList34 = arrayList29;
                                                        arrayList6 = arrayList30;
                                                        j = optLong2;
                                                        bangInfo = bangInfo4;
                                                        str2 = optString;
                                                        str3 = str5;
                                                        arrayList = arrayList21;
                                                        arrayList2 = arrayList20;
                                                        arrayList3 = arrayList25;
                                                        exc = e7;
                                                        z = z2;
                                                        cycleLiveRoomInfo = cycleLiveRoomInfo2;
                                                        karaokeBean = karaokeBean2;
                                                        autoBang = autoBang2;
                                                        cVar = cVar2;
                                                        bVar = bVar2;
                                                        arrayList7 = arrayList34;
                                                    }
                                                } else if (optInt == 10003) {
                                                    arrayList16 = arrayList31;
                                                    onlineVip5 = onlineVip4;
                                                    arrayList17 = arrayList32;
                                                    micStatus3 = micStatus4;
                                                    roomChatBackground4 = roomChatBackground6;
                                                    bangInfo4 = bangInfo5;
                                                    ArrayList arrayList35 = arrayList29;
                                                    arrayList15 = arrayList30;
                                                    obj3 = "10003";
                                                    z3 = z2;
                                                    cycleLiveRoomInfo3 = cycleLiveRoomInfo2;
                                                    karaokeBean3 = karaokeBean2;
                                                    autoBang3 = autoBang2;
                                                    cVar3 = cVar2;
                                                    bVar3 = bVar2;
                                                    arrayList14 = arrayList35;
                                                } else if (optInt == 10004) {
                                                    if (h.isEmpty(str)) {
                                                        z3 = z2;
                                                        onlineVip5 = onlineVip4;
                                                        cycleLiveRoomInfo3 = cycleLiveRoomInfo2;
                                                        karaokeBean3 = karaokeBean2;
                                                        autoBang3 = autoBang2;
                                                        cVar3 = cVar2;
                                                        bVar3 = bVar2;
                                                        arrayList14 = arrayList29;
                                                        arrayList15 = arrayList30;
                                                        obj3 = obj4;
                                                        arrayList16 = arrayList31;
                                                        arrayList17 = arrayList32;
                                                        micStatus3 = micStatus4;
                                                        roomChatBackground4 = roomChatBackground6;
                                                        bangInfo4 = bangInfo5;
                                                    } else {
                                                        arrayList16 = arrayList31;
                                                        onlineVip5 = onlineVip4;
                                                        arrayList17 = arrayList32;
                                                        micStatus3 = micStatus4;
                                                        roomChatBackground4 = roomChatBackground6;
                                                        bangInfo4 = bangInfo5;
                                                        ArrayList arrayList36 = arrayList29;
                                                        arrayList15 = arrayList30;
                                                        obj3 = "10004";
                                                        z3 = z2;
                                                        cycleLiveRoomInfo3 = cycleLiveRoomInfo2;
                                                        karaokeBean3 = karaokeBean2;
                                                        autoBang3 = autoBang2;
                                                        cVar3 = cVar2;
                                                        bVar3 = bVar2;
                                                        arrayList14 = arrayList36;
                                                    }
                                                } else if (optInt == 10005) {
                                                    micStatus = new MicStatus();
                                                    try {
                                                        micStatus.onlineCount = optJSONObject3.optInt("micOnlineCount");
                                                        micStatus.onMic = optJSONObject3.optBoolean("onMic");
                                                        micStatus.name = optJSONObject3.optString("micName");
                                                        micStatus.capacity = optJSONObject3.optInt("micCapacity");
                                                        micStatus.micRoomId = optJSONObject3.optString("micRoomId");
                                                        micStatus.micCanApply = optJSONObject3.optBoolean("micCanApply");
                                                        micStatus.micGameActionType = optJSONObject3.optInt("micGameActionType");
                                                        micStatus.micType = optJSONObject3.optInt("micType");
                                                        micStatus.isOngoing = optJSONObject3.optInt("isOngoing", 0);
                                                        micStatus.displayInteraction = optJSONObject3.optInt("displayInteraction", 0);
                                                        if (optJSONObject3.has("micMembers")) {
                                                            JSONArray jSONArray4 = optJSONObject3.getJSONArray("micMembers");
                                                            int length3 = jSONArray4.length();
                                                            if (length3 > 0) {
                                                                arrayList32 = new ArrayList();
                                                            }
                                                            for (int i8 = 0; i8 < length3; i8++) {
                                                                JSONObject optJSONObject5 = jSONArray4.optJSONObject(i8);
                                                                FanItem fanItem = new FanItem();
                                                                fanItem.mUserId = optJSONObject5.optString("uid", "");
                                                                fanItem.mNickname = optJSONObject5.optString("nickname", "");
                                                                fanItem.mAvatar = optJSONObject5.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR, "");
                                                                fanItem.mGender = optJSONObject5.optString("gender", "");
                                                                fanItem.mSignature = optJSONObject5.optString(SocialOperation.GAME_SIGNATURE, "");
                                                                if (optJSONObject5.has(MetaBox.TYPE)) {
                                                                    fanItem.mFansIcon = optJSONObject5.optJSONObject(MetaBox.TYPE).optString("medalIcon");
                                                                }
                                                                arrayList32.add(fanItem);
                                                            }
                                                        }
                                                        if (optJSONObject3.has("micMembersInfo")) {
                                                            JSONArray jSONArray5 = optJSONObject3.getJSONArray("micMembersInfo");
                                                            int length4 = jSONArray5.length();
                                                            ArrayList arrayList37 = length4 > 0 ? new ArrayList() : arrayList31;
                                                            for (int i9 = 0; i9 < length4; i9++) {
                                                                try {
                                                                    JSONObject optJSONObject6 = jSONArray5.optJSONObject(i9);
                                                                    MicMemberInfo micMemberInfo = new MicMemberInfo();
                                                                    micMemberInfo.uid = optJSONObject6.optString("uid");
                                                                    micMemberInfo.avatar = optJSONObject6.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
                                                                    micMemberInfo.gender = optJSONObject6.optString("gender");
                                                                    micMemberInfo.nickname = optJSONObject6.optString("nickname");
                                                                    micMemberInfo.contributePoint = optJSONObject6.optLong("contributePoint");
                                                                    micMemberInfo.contributeRank = optJSONObject6.optInt("contributeRank");
                                                                    micMemberInfo.order = optJSONObject6.optInt(IMConstants.SERVICE_TYPE_ORDER);
                                                                    micMemberInfo.micStatus = optJSONObject6.optInt("micStatus");
                                                                    arrayList37.add(micMemberInfo);
                                                                } catch (Exception e8) {
                                                                    arrayList4 = arrayList32;
                                                                    onlineVip = onlineVip4;
                                                                    arrayList5 = arrayList37;
                                                                    i = i2;
                                                                    z = z2;
                                                                    cycleLiveRoomInfo = cycleLiveRoomInfo2;
                                                                    karaokeBean = karaokeBean2;
                                                                    autoBang = autoBang2;
                                                                    cVar = cVar2;
                                                                    bVar = bVar2;
                                                                    arrayList7 = arrayList29;
                                                                    arrayList6 = arrayList30;
                                                                    obj = obj4;
                                                                    j = optLong2;
                                                                    bangInfo = bangInfo5;
                                                                    str2 = optString;
                                                                    roomChatBackground = roomChatBackground6;
                                                                    arrayList = arrayList21;
                                                                    str3 = str5;
                                                                    arrayList2 = arrayList20;
                                                                    arrayList3 = arrayList25;
                                                                    exc = e8;
                                                                    tv.chushou.zues.utils.e.e("Parser_Player", "error " + exc.toString());
                                                                    parserRet = new ParserRet();
                                                                    parserRet.mBreakpoint = str2;
                                                                    parserRet.mData = arrayList3;
                                                                    parserRet.mData1 = Long.valueOf(j);
                                                                    if (arrayList2 == null) {
                                                                    }
                                                                    parserRet.mData2 = new SparseArray();
                                                                    if (arrayList2 != null) {
                                                                    }
                                                                    if (arrayList != null) {
                                                                    }
                                                                    if (bangInfo == null) {
                                                                    }
                                                                    if (parserRet.mData3 == null) {
                                                                    }
                                                                    if (bangInfo != null) {
                                                                    }
                                                                    if (!h.isEmpty(arrayList7)) {
                                                                    }
                                                                    if (micStatus == null) {
                                                                    }
                                                                    if (parserRet.mData3 == null) {
                                                                    }
                                                                    if (micStatus != null) {
                                                                    }
                                                                    if (!h.isEmpty(arrayList4)) {
                                                                    }
                                                                    if (obj != null) {
                                                                    }
                                                                    if (!h.isEmpty(arrayList6)) {
                                                                    }
                                                                    if (!h.isEmpty(arrayList23)) {
                                                                    }
                                                                    if (roomChatBackground != null) {
                                                                    }
                                                                    if (onlineVip != null) {
                                                                    }
                                                                    if (cVar != null) {
                                                                    }
                                                                    if (autoBang != null) {
                                                                    }
                                                                    if (karaokeBean != null) {
                                                                    }
                                                                    if (!h.isEmpty(arrayList24)) {
                                                                    }
                                                                    if (0 != 0) {
                                                                    }
                                                                    if (bVar != null) {
                                                                    }
                                                                    if (cycleLiveRoomInfo != null) {
                                                                    }
                                                                    if (micStatus == null) {
                                                                    }
                                                                    if (parserRet.mData3 == null) {
                                                                    }
                                                                    if (micStatus != null) {
                                                                    }
                                                                    if (!h.isEmpty(arrayList4)) {
                                                                    }
                                                                    if (parserRet.mData3 == null) {
                                                                    }
                                                                    parserRet.mData3.put(19, Boolean.valueOf(z));
                                                                    parserRet.mRc = i;
                                                                    parserRet.mMessage = str3;
                                                                    return parserRet;
                                                                }
                                                            }
                                                            arrayList17 = arrayList32;
                                                            roomChatBackground4 = roomChatBackground6;
                                                            micStatus3 = micStatus;
                                                            bangInfo4 = bangInfo5;
                                                            onlineVip5 = onlineVip4;
                                                            com.kascend.chushou.player.ui.h5.c.b bVar5 = bVar2;
                                                            arrayList14 = arrayList29;
                                                            arrayList15 = arrayList30;
                                                            obj3 = obj4;
                                                            arrayList16 = arrayList37;
                                                            z3 = z2;
                                                            cycleLiveRoomInfo3 = cycleLiveRoomInfo2;
                                                            karaokeBean3 = karaokeBean2;
                                                            autoBang3 = autoBang2;
                                                            cVar3 = cVar2;
                                                            bVar3 = bVar5;
                                                        } else {
                                                            z3 = z2;
                                                            roomChatBackground4 = roomChatBackground6;
                                                            cycleLiveRoomInfo3 = cycleLiveRoomInfo2;
                                                            bangInfo4 = bangInfo5;
                                                            karaokeBean3 = karaokeBean2;
                                                            autoBang3 = autoBang2;
                                                            cVar3 = cVar2;
                                                            bVar3 = bVar2;
                                                            arrayList14 = arrayList29;
                                                            arrayList15 = arrayList30;
                                                            obj3 = obj4;
                                                            arrayList16 = arrayList31;
                                                            arrayList17 = arrayList32;
                                                            micStatus3 = micStatus;
                                                            onlineVip5 = onlineVip4;
                                                        }
                                                    } catch (Exception e9) {
                                                        arrayList4 = arrayList32;
                                                        onlineVip = onlineVip4;
                                                        arrayList5 = arrayList31;
                                                        i = i2;
                                                        obj = obj4;
                                                        com.kascend.chushou.player.ui.h5.c.c cVar5 = cVar2;
                                                        bVar = bVar2;
                                                        arrayList7 = arrayList29;
                                                        arrayList6 = arrayList30;
                                                        j = optLong2;
                                                        bangInfo = bangInfo5;
                                                        str2 = optString;
                                                        roomChatBackground = roomChatBackground6;
                                                        arrayList = arrayList21;
                                                        str3 = str5;
                                                        arrayList2 = arrayList20;
                                                        arrayList3 = arrayList25;
                                                        exc = e9;
                                                        z = z2;
                                                        cycleLiveRoomInfo = cycleLiveRoomInfo2;
                                                        karaokeBean = karaokeBean2;
                                                        autoBang = autoBang2;
                                                        cVar = cVar5;
                                                    }
                                                } else if (optInt == 10006) {
                                                    int optInt2 = optJSONObject3.optInt("style", -1);
                                                    if (optInt2 == 1) {
                                                        com.kascend.chushou.player.ui.h5.c.a eD = eD(optJSONObject3);
                                                        if (arrayList29 == null) {
                                                            arrayList29 = new ArrayList();
                                                        }
                                                        arrayList29.add(eD);
                                                        cVar4 = cVar2;
                                                        bVar3 = bVar2;
                                                        arrayList14 = arrayList29;
                                                        arrayList15 = arrayList30;
                                                    } else if (optInt2 == 2) {
                                                        com.kascend.chushou.player.ui.h5.c.e eB = eB(optJSONObject3);
                                                        if (arrayList30 == null) {
                                                            arrayList30 = new ArrayList();
                                                        }
                                                        arrayList30.add(eB);
                                                        cVar4 = cVar2;
                                                        bVar3 = bVar2;
                                                        arrayList14 = arrayList29;
                                                        arrayList15 = arrayList30;
                                                    } else if (optInt2 == 3) {
                                                        arrayList23.add(eC(optJSONObject3));
                                                        cVar4 = cVar2;
                                                        bVar3 = bVar2;
                                                        arrayList14 = arrayList29;
                                                        arrayList15 = arrayList30;
                                                    } else if (optInt2 == 5) {
                                                        cVar4 = eC(optJSONObject3);
                                                        bVar3 = bVar2;
                                                        arrayList14 = arrayList29;
                                                        arrayList15 = arrayList30;
                                                    } else if (optInt2 == 7) {
                                                        cVar4 = cVar2;
                                                        bVar3 = eE(optJSONObject3);
                                                        arrayList14 = arrayList29;
                                                        arrayList15 = arrayList30;
                                                    } else {
                                                        cVar4 = cVar2;
                                                        bVar3 = bVar2;
                                                        arrayList14 = arrayList29;
                                                        arrayList15 = arrayList30;
                                                    }
                                                    obj3 = obj4;
                                                    onlineVip5 = onlineVip4;
                                                    arrayList16 = arrayList31;
                                                    arrayList17 = arrayList32;
                                                    micStatus3 = micStatus4;
                                                    roomChatBackground4 = roomChatBackground6;
                                                    bangInfo4 = bangInfo5;
                                                    AutoBang autoBang4 = autoBang2;
                                                    cVar3 = cVar4;
                                                    z3 = z2;
                                                    cycleLiveRoomInfo3 = cycleLiveRoomInfo2;
                                                    karaokeBean3 = karaokeBean2;
                                                    autoBang3 = autoBang4;
                                                } else if (optInt == 10008) {
                                                    AutoBang autoBang5 = new AutoBang();
                                                    try {
                                                        autoBang5.bangTime = optJSONObject3.optLong("bangTime");
                                                        autoBang5.currentTime = optLong;
                                                        autoBang5.isDone = optJSONObject3.optBoolean("isDone", false);
                                                        cVar3 = cVar2;
                                                        onlineVip5 = onlineVip4;
                                                        bVar3 = bVar2;
                                                        arrayList14 = arrayList29;
                                                        arrayList15 = arrayList30;
                                                        obj3 = obj4;
                                                        arrayList16 = arrayList31;
                                                        arrayList17 = arrayList32;
                                                        micStatus3 = micStatus4;
                                                        roomChatBackground4 = roomChatBackground6;
                                                        bangInfo4 = bangInfo5;
                                                        KaraokeBean karaokeBean7 = karaokeBean2;
                                                        autoBang3 = autoBang5;
                                                        z3 = z2;
                                                        cycleLiveRoomInfo3 = cycleLiveRoomInfo2;
                                                        karaokeBean3 = karaokeBean7;
                                                    } catch (Exception e10) {
                                                        micStatus = micStatus4;
                                                        onlineVip = onlineVip4;
                                                        arrayList4 = arrayList32;
                                                        i = i2;
                                                        arrayList5 = arrayList31;
                                                        obj = obj4;
                                                        com.kascend.chushou.player.ui.h5.c.b bVar6 = bVar2;
                                                        arrayList7 = arrayList29;
                                                        arrayList6 = arrayList30;
                                                        j = optLong2;
                                                        bangInfo = bangInfo5;
                                                        str2 = optString;
                                                        roomChatBackground = roomChatBackground6;
                                                        arrayList = arrayList21;
                                                        str3 = str5;
                                                        arrayList2 = arrayList20;
                                                        arrayList3 = arrayList25;
                                                        exc = e10;
                                                        cVar = cVar2;
                                                        bVar = bVar6;
                                                        boolean z4 = z2;
                                                        cycleLiveRoomInfo = cycleLiveRoomInfo2;
                                                        karaokeBean = karaokeBean2;
                                                        autoBang = autoBang5;
                                                        z = z4;
                                                        tv.chushou.zues.utils.e.e("Parser_Player", "error " + exc.toString());
                                                        parserRet = new ParserRet();
                                                        parserRet.mBreakpoint = str2;
                                                        parserRet.mData = arrayList3;
                                                        parserRet.mData1 = Long.valueOf(j);
                                                        if (arrayList2 == null) {
                                                        }
                                                        parserRet.mData2 = new SparseArray();
                                                        if (arrayList2 != null) {
                                                        }
                                                        if (arrayList != null) {
                                                        }
                                                        if (bangInfo == null) {
                                                        }
                                                        if (parserRet.mData3 == null) {
                                                        }
                                                        if (bangInfo != null) {
                                                        }
                                                        if (!h.isEmpty(arrayList7)) {
                                                        }
                                                        if (micStatus == null) {
                                                        }
                                                        if (parserRet.mData3 == null) {
                                                        }
                                                        if (micStatus != null) {
                                                        }
                                                        if (!h.isEmpty(arrayList4)) {
                                                        }
                                                        if (obj != null) {
                                                        }
                                                        if (!h.isEmpty(arrayList6)) {
                                                        }
                                                        if (!h.isEmpty(arrayList23)) {
                                                        }
                                                        if (roomChatBackground != null) {
                                                        }
                                                        if (onlineVip != null) {
                                                        }
                                                        if (cVar != null) {
                                                        }
                                                        if (autoBang != null) {
                                                        }
                                                        if (karaokeBean != null) {
                                                        }
                                                        if (!h.isEmpty(arrayList24)) {
                                                        }
                                                        if (0 != 0) {
                                                        }
                                                        if (bVar != null) {
                                                        }
                                                        if (cycleLiveRoomInfo != null) {
                                                        }
                                                        if (micStatus == null) {
                                                        }
                                                        if (parserRet.mData3 == null) {
                                                        }
                                                        if (micStatus != null) {
                                                        }
                                                        if (!h.isEmpty(arrayList4)) {
                                                        }
                                                        if (parserRet.mData3 == null) {
                                                        }
                                                        parserRet.mData3.put(19, Boolean.valueOf(z));
                                                        parserRet.mRc = i;
                                                        parserRet.mMessage = str3;
                                                        return parserRet;
                                                    }
                                                } else if (optInt == 10010) {
                                                    z3 = z2;
                                                    onlineVip5 = onlineVip4;
                                                    cycleLiveRoomInfo3 = cycleLiveRoomInfo2;
                                                    karaokeBean3 = karaokeBean2;
                                                    autoBang3 = autoBang2;
                                                    cVar3 = cVar2;
                                                    bVar3 = bVar2;
                                                    arrayList14 = arrayList29;
                                                    arrayList15 = arrayList30;
                                                    obj3 = obj4;
                                                    arrayList16 = arrayList31;
                                                    arrayList17 = arrayList32;
                                                    micStatus3 = micStatus4;
                                                    roomChatBackground4 = roomChatBackground6;
                                                    bangInfo4 = bangInfo5;
                                                } else if (optInt == 10011) {
                                                    if (optJSONObject3.optInt("style", -1) == 3) {
                                                        arrayList23.add(eC(optJSONObject3));
                                                    }
                                                    z3 = z2;
                                                    onlineVip5 = onlineVip4;
                                                    cycleLiveRoomInfo3 = cycleLiveRoomInfo2;
                                                    karaokeBean3 = karaokeBean2;
                                                    autoBang3 = autoBang2;
                                                    cVar3 = cVar2;
                                                    bVar3 = bVar2;
                                                    arrayList14 = arrayList29;
                                                    arrayList15 = arrayList30;
                                                    obj3 = obj4;
                                                    arrayList16 = arrayList31;
                                                    arrayList17 = arrayList32;
                                                    micStatus3 = micStatus4;
                                                    roomChatBackground4 = roomChatBackground6;
                                                    bangInfo4 = bangInfo5;
                                                } else if (optInt == 10012 || optInt == 10013) {
                                                    if (h.isEmpty(str)) {
                                                        z3 = z2;
                                                        onlineVip5 = onlineVip4;
                                                        cycleLiveRoomInfo3 = cycleLiveRoomInfo2;
                                                        karaokeBean3 = karaokeBean2;
                                                        autoBang3 = autoBang2;
                                                        cVar3 = cVar2;
                                                        bVar3 = bVar2;
                                                        arrayList14 = arrayList29;
                                                        arrayList15 = arrayList30;
                                                        obj3 = obj4;
                                                        arrayList16 = arrayList31;
                                                        arrayList17 = arrayList32;
                                                        micStatus3 = micStatus4;
                                                        roomChatBackground4 = roomChatBackground6;
                                                        bangInfo4 = bangInfo5;
                                                    } else {
                                                        int optInt3 = optJSONObject3.optInt("action");
                                                        tv.chushou.zues.utils.e.d("guohe", "Parser_Player.parseGetChat(): type = " + optInt + ", action = " + optInt3);
                                                        PkNotifyInfo pkNotifyInfo = null;
                                                        switch (optInt3) {
                                                            case 2:
                                                                PkNotifyInfo pkNotifyInfo2 = new PkNotifyInfo();
                                                                pkNotifyInfo2.mPkId = optJSONObject3.optString("pkId");
                                                                pkNotifyInfo2.mAction = 2;
                                                                arrayList24.add(pkNotifyInfo2);
                                                                break;
                                                            case 3:
                                                                JSONObject optJSONObject7 = optJSONObject3.optJSONObject("PKInfo");
                                                                if (optJSONObject7 != null) {
                                                                    pkNotifyInfo = ez(optJSONObject7);
                                                                    pkNotifyInfo.mAction = 3;
                                                                }
                                                                arrayList24.add(pkNotifyInfo);
                                                                break;
                                                            case 4:
                                                                PkNotifyInfo pkNotifyInfo3 = new PkNotifyInfo();
                                                                pkNotifyInfo3.mPkId = optJSONObject3.optString("pkId");
                                                                pkNotifyInfo3.mMaxFreeDuration = optJSONObject3.optLong("maxFreeDuration");
                                                                pkNotifyInfo3.mAction = 4;
                                                                arrayList24.add(pkNotifyInfo3);
                                                                break;
                                                            case 5:
                                                                PkNotifyInfo pkNotifyInfo4 = new PkNotifyInfo();
                                                                pkNotifyInfo4.mPkId = optJSONObject3.optString("pkId");
                                                                pkNotifyInfo4.mvpUid = optJSONObject3.optString("mvpUid");
                                                                pkNotifyInfo4.mvpAvatar = optJSONObject3.optString("mvpAvatar");
                                                                pkNotifyInfo4.mvpNickname = optJSONObject3.optString("mvpNickname");
                                                                pkNotifyInfo4.mResult = optJSONObject3.optString("result");
                                                                pkNotifyInfo4.mAction = 5;
                                                                arrayList24.add(pkNotifyInfo4);
                                                                break;
                                                            case 6:
                                                                PkNotifyInfo pkNotifyInfo5 = new PkNotifyInfo();
                                                                pkNotifyInfo5.mPkId = optJSONObject3.optString("pkId");
                                                                pkNotifyInfo5.mPkRoomId = optJSONObject3.optString("pkRoomId");
                                                                pkNotifyInfo5.mPkUid = optJSONObject3.optString("pkUid");
                                                                pkNotifyInfo5.mPkUserNickname = optJSONObject3.optString("pkUserNickname");
                                                                pkNotifyInfo5.mPkUserAvatar = optJSONObject3.optString("pkUserAvatar");
                                                                pkNotifyInfo5.mMaxPKDuration = optJSONObject3.optLong("maxPKDuration");
                                                                pkNotifyInfo5.mMaxFreeDuration = optJSONObject3.optLong("maxFreeDuration");
                                                                pkNotifyInfo5.maxPrepareDuration = optJSONObject3.optLong("maxPrepareDuration");
                                                                pkNotifyInfo5.liveStyle = optJSONObject3.optInt("pkStyle");
                                                                pkNotifyInfo5.mAction = 6;
                                                                if (optInt == 10012) {
                                                                    pkNotifyInfo5.mMode = 1;
                                                                } else {
                                                                    pkNotifyInfo5.mMode = 2;
                                                                }
                                                                arrayList24.add(pkNotifyInfo5);
                                                                break;
                                                            case 7:
                                                                PkNotifyInfo pkNotifyInfo6 = new PkNotifyInfo();
                                                                pkNotifyInfo6.mAction = 7;
                                                                pkNotifyInfo6.mPkId = optJSONObject3.optString("pkId");
                                                                pkNotifyInfo6.mPkRoomId = optJSONObject3.optString("pkRoomId");
                                                                pkNotifyInfo6.mPkUid = optJSONObject3.optString("pkUid");
                                                                pkNotifyInfo6.mPkUserNickname = optJSONObject3.optString("pkUserNickname");
                                                                pkNotifyInfo6.mPkUserAvatar = optJSONObject3.optString("pkUserAvatar");
                                                                pkNotifyInfo6.mMaxPKDuration = optJSONObject3.optLong("maxPKDuration");
                                                                pkNotifyInfo6.destinyInfo = ey(optJSONObject3.optJSONObject("destinyInfo"));
                                                                arrayList24.add(pkNotifyInfo6);
                                                                break;
                                                            case 8:
                                                                PkNotifyInfo pkNotifyInfo7 = new PkNotifyInfo();
                                                                pkNotifyInfo7.mPkId = optJSONObject3.optString("pkId");
                                                                pkNotifyInfo7.mAction = 8;
                                                                pkNotifyInfo7.mPkUpdateInfo = new PkUpdateInfo();
                                                                JSONArray optJSONArray3 = optJSONObject3.optJSONArray("specialMoment");
                                                                if (optJSONArray3 != null) {
                                                                    if (pkNotifyInfo7.mPkUpdateInfo.specialMomentList == null) {
                                                                        pkNotifyInfo7.mPkUpdateInfo.specialMomentList = new ArrayList();
                                                                    }
                                                                    for (int i10 = 0; i10 < optJSONArray3.length(); i10++) {
                                                                        JSONObject optJSONObject8 = optJSONArray3.optJSONObject(i10);
                                                                        if (optJSONObject8 != null) {
                                                                            PkUpdateInfo.SpecialMoment specialMoment = new PkUpdateInfo.SpecialMoment();
                                                                            specialMoment.type = optJSONObject8.optInt("type");
                                                                            if (specialMoment.type == 1) {
                                                                                specialMoment.roomId = optJSONObject8.optString("roomId");
                                                                                specialMoment.addition = optJSONObject8.optString("addition");
                                                                            } else if (specialMoment.type == 2 || specialMoment.type == 3 || specialMoment.type == 4) {
                                                                                specialMoment.endTime = optJSONObject8.optLong("endTime");
                                                                                specialMoment.remainDuration = optJSONObject8.optLong("remainDuration");
                                                                                specialMoment.maxDuration = optJSONObject8.optLong("maxDuration");
                                                                                specialMoment.addition = optJSONObject8.optString("addition");
                                                                            }
                                                                            pkNotifyInfo7.mPkUpdateInfo.specialMomentList.add(specialMoment);
                                                                        }
                                                                    }
                                                                }
                                                                arrayList24.add(pkNotifyInfo7);
                                                                break;
                                                        }
                                                        z3 = z2;
                                                        onlineVip5 = onlineVip4;
                                                        cycleLiveRoomInfo3 = cycleLiveRoomInfo2;
                                                        karaokeBean3 = karaokeBean2;
                                                        autoBang3 = autoBang2;
                                                        cVar3 = cVar2;
                                                        bVar3 = bVar2;
                                                        arrayList14 = arrayList29;
                                                        arrayList15 = arrayList30;
                                                        obj3 = obj4;
                                                        arrayList16 = arrayList31;
                                                        arrayList17 = arrayList32;
                                                        micStatus3 = micStatus4;
                                                        roomChatBackground4 = roomChatBackground6;
                                                        bangInfo4 = bangInfo5;
                                                    }
                                                } else if (optInt == 10014) {
                                                    CycleLiveRoomInfo cycleLiveRoomInfo4 = new CycleLiveRoomInfo();
                                                    try {
                                                        cycleLiveRoomInfo4.uid = optJSONObject3.optString("uid");
                                                        cycleLiveRoomInfo4.nickname = optJSONObject3.optString("nickname");
                                                        cycleLiveRoomInfo4.remainTime = optJSONObject3.optLong("remainTime");
                                                        cycleLiveRoomInfo4.avatar = optJSONObject3.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
                                                        cycleLiveRoomInfo4.roomId = optJSONObject3.optString("roomId");
                                                        karaokeBean3 = karaokeBean2;
                                                        onlineVip5 = onlineVip4;
                                                        autoBang3 = autoBang2;
                                                        cVar3 = cVar2;
                                                        bVar3 = bVar2;
                                                        arrayList14 = arrayList29;
                                                        arrayList15 = arrayList30;
                                                        obj3 = obj4;
                                                        arrayList16 = arrayList31;
                                                        arrayList17 = arrayList32;
                                                        micStatus3 = micStatus4;
                                                        roomChatBackground4 = roomChatBackground6;
                                                        bangInfo4 = bangInfo5;
                                                        z3 = z2;
                                                        cycleLiveRoomInfo3 = cycleLiveRoomInfo4;
                                                    } catch (Exception e11) {
                                                        micStatus = micStatus4;
                                                        onlineVip = onlineVip4;
                                                        arrayList4 = arrayList32;
                                                        i = i2;
                                                        arrayList5 = arrayList31;
                                                        obj = obj4;
                                                        com.kascend.chushou.player.ui.h5.c.b bVar7 = bVar2;
                                                        arrayList7 = arrayList29;
                                                        arrayList6 = arrayList30;
                                                        j = optLong2;
                                                        bangInfo = bangInfo5;
                                                        str2 = optString;
                                                        roomChatBackground = roomChatBackground6;
                                                        arrayList = arrayList21;
                                                        str3 = str5;
                                                        arrayList2 = arrayList20;
                                                        arrayList3 = arrayList25;
                                                        exc = e11;
                                                        karaokeBean = karaokeBean2;
                                                        autoBang = autoBang2;
                                                        cVar = cVar2;
                                                        bVar = bVar7;
                                                        z = z2;
                                                        cycleLiveRoomInfo = cycleLiveRoomInfo4;
                                                        tv.chushou.zues.utils.e.e("Parser_Player", "error " + exc.toString());
                                                        parserRet = new ParserRet();
                                                        parserRet.mBreakpoint = str2;
                                                        parserRet.mData = arrayList3;
                                                        parserRet.mData1 = Long.valueOf(j);
                                                        if (arrayList2 == null) {
                                                        }
                                                        parserRet.mData2 = new SparseArray();
                                                        if (arrayList2 != null) {
                                                        }
                                                        if (arrayList != null) {
                                                        }
                                                        if (bangInfo == null) {
                                                        }
                                                        if (parserRet.mData3 == null) {
                                                        }
                                                        if (bangInfo != null) {
                                                        }
                                                        if (!h.isEmpty(arrayList7)) {
                                                        }
                                                        if (micStatus == null) {
                                                        }
                                                        if (parserRet.mData3 == null) {
                                                        }
                                                        if (micStatus != null) {
                                                        }
                                                        if (!h.isEmpty(arrayList4)) {
                                                        }
                                                        if (obj != null) {
                                                        }
                                                        if (!h.isEmpty(arrayList6)) {
                                                        }
                                                        if (!h.isEmpty(arrayList23)) {
                                                        }
                                                        if (roomChatBackground != null) {
                                                        }
                                                        if (onlineVip != null) {
                                                        }
                                                        if (cVar != null) {
                                                        }
                                                        if (autoBang != null) {
                                                        }
                                                        if (karaokeBean != null) {
                                                        }
                                                        if (!h.isEmpty(arrayList24)) {
                                                        }
                                                        if (0 != 0) {
                                                        }
                                                        if (bVar != null) {
                                                        }
                                                        if (cycleLiveRoomInfo != null) {
                                                        }
                                                        if (micStatus == null) {
                                                        }
                                                        if (parserRet.mData3 == null) {
                                                        }
                                                        if (micStatus != null) {
                                                        }
                                                        if (!h.isEmpty(arrayList4)) {
                                                        }
                                                        if (parserRet.mData3 == null) {
                                                        }
                                                        parserRet.mData3.put(19, Boolean.valueOf(z));
                                                        parserRet.mRc = i;
                                                        parserRet.mMessage = str3;
                                                        return parserRet;
                                                    }
                                                } else if (optInt != 10016) {
                                                    z3 = z2;
                                                    onlineVip5 = onlineVip4;
                                                    cycleLiveRoomInfo3 = cycleLiveRoomInfo2;
                                                    karaokeBean3 = karaokeBean2;
                                                    autoBang3 = autoBang2;
                                                    cVar3 = cVar2;
                                                    bVar3 = bVar2;
                                                    arrayList14 = arrayList29;
                                                    arrayList15 = arrayList30;
                                                    obj3 = obj4;
                                                    arrayList16 = arrayList31;
                                                    arrayList17 = arrayList32;
                                                    micStatus3 = micStatus4;
                                                    roomChatBackground4 = roomChatBackground6;
                                                    bangInfo4 = bangInfo5;
                                                } else if (h.isEmpty(str)) {
                                                    z3 = z2;
                                                    onlineVip5 = onlineVip4;
                                                    cycleLiveRoomInfo3 = cycleLiveRoomInfo2;
                                                    karaokeBean3 = karaokeBean2;
                                                    autoBang3 = autoBang2;
                                                    cVar3 = cVar2;
                                                    bVar3 = bVar2;
                                                    arrayList14 = arrayList29;
                                                    arrayList15 = arrayList30;
                                                    obj3 = obj4;
                                                    arrayList16 = arrayList31;
                                                    arrayList17 = arrayList32;
                                                    micStatus3 = micStatus4;
                                                    roomChatBackground4 = roomChatBackground6;
                                                    bangInfo4 = bangInfo5;
                                                } else {
                                                    z3 = true;
                                                    cycleLiveRoomInfo3 = cycleLiveRoomInfo2;
                                                    onlineVip5 = onlineVip4;
                                                    karaokeBean3 = karaokeBean2;
                                                    autoBang3 = autoBang2;
                                                    cVar3 = cVar2;
                                                    bVar3 = bVar2;
                                                    arrayList14 = arrayList29;
                                                    arrayList15 = arrayList30;
                                                    obj3 = obj4;
                                                    arrayList16 = arrayList31;
                                                    arrayList17 = arrayList32;
                                                    micStatus3 = micStatus4;
                                                    roomChatBackground4 = roomChatBackground6;
                                                    bangInfo4 = bangInfo5;
                                                }
                                            } else {
                                                onlineVip5 = onlineVip6;
                                                z3 = z2;
                                                cycleLiveRoomInfo3 = cycleLiveRoomInfo2;
                                                karaokeBean3 = karaokeBean2;
                                                autoBang3 = autoBang2;
                                                cVar3 = cVar2;
                                                bVar3 = bVar2;
                                                arrayList14 = arrayList29;
                                                arrayList15 = arrayList30;
                                                obj3 = obj4;
                                                arrayList16 = arrayList31;
                                                arrayList17 = arrayList32;
                                                micStatus3 = micStatus4;
                                                roomChatBackground4 = roomChatBackground6;
                                                bangInfo4 = bangInfo5;
                                            }
                                            i6++;
                                            bangInfo5 = bangInfo4;
                                            roomChatBackground6 = roomChatBackground4;
                                            micStatus4 = micStatus3;
                                            arrayList32 = arrayList17;
                                            arrayList31 = arrayList16;
                                            obj4 = obj3;
                                            arrayList30 = arrayList15;
                                            arrayList29 = arrayList14;
                                            bVar2 = bVar3;
                                            cVar2 = cVar3;
                                            autoBang2 = autoBang3;
                                            karaokeBean2 = karaokeBean3;
                                            cycleLiveRoomInfo2 = cycleLiveRoomInfo3;
                                            z2 = z3;
                                            onlineVip6 = onlineVip5;
                                        } catch (Exception e12) {
                                            i = i2;
                                            onlineVip = onlineVip6;
                                            z = z2;
                                            cycleLiveRoomInfo = cycleLiveRoomInfo2;
                                            karaokeBean = karaokeBean2;
                                            autoBang = autoBang2;
                                            cVar = cVar2;
                                            bVar = bVar2;
                                            arrayList7 = arrayList29;
                                            arrayList6 = arrayList30;
                                            j = optLong2;
                                            bangInfo = bangInfo5;
                                            str2 = optString;
                                            roomChatBackground = roomChatBackground6;
                                            arrayList = arrayList21;
                                            str3 = str5;
                                            arrayList2 = arrayList20;
                                            arrayList3 = arrayList25;
                                            exc = e12;
                                            micStatus = micStatus4;
                                            arrayList4 = arrayList32;
                                            arrayList5 = arrayList31;
                                            obj = obj4;
                                        }
                                    }
                                    onlineVip3 = onlineVip6;
                                    arrayList11 = arrayList29;
                                    arrayList6 = arrayList30;
                                    obj2 = obj4;
                                    arrayList12 = arrayList31;
                                    arrayList13 = arrayList32;
                                    micStatus2 = micStatus4;
                                    roomChatBackground3 = roomChatBackground6;
                                    bangInfo3 = bangInfo5;
                                }
                                try {
                                    if (jSONObject2.has("h5Items")) {
                                        JSONArray jSONArray6 = jSONObject2.getJSONArray("h5Items");
                                        tv.chushou.zues.utils.e.d("Parser_Player", "h5items=" + jSONArray6.toString());
                                        int length5 = jSONArray6.length();
                                        int i11 = 0;
                                        while (true) {
                                            int i12 = i11;
                                            if (i12 < length5) {
                                                JSONObject optJSONObject9 = jSONArray6.optJSONObject(i12);
                                                if (optJSONObject9.getInt("type") == 10002) {
                                                    com.kascend.chushou.player.ui.h5.c.a aVar = new com.kascend.chushou.player.ui.h5.c.a();
                                                    aVar.h = 1;
                                                    aVar.i = optJSONObject9.optInt("showClose", 0);
                                                    aVar.j = optJSONObject9.optInt("closeType", 0);
                                                    aVar.b = optJSONObject9.optString("targetKey", "");
                                                    aVar.l = optJSONObject9.optInt("priority", 0);
                                                    aVar.k = optJSONObject9.optString("maskColor", "");
                                                    aVar.a = optJSONObject9.optInt("duration", 0);
                                                    aVar.p = optJSONObject9.optString("id", "");
                                                    JSONObject optJSONObject10 = optJSONObject9.optJSONObject("landscape");
                                                    if (optJSONObject10 != null) {
                                                        aVar.o = optJSONObject10.optString("url", "");
                                                        aVar.oeY = eA(optJSONObject10);
                                                        aVar.a = optJSONObject10.optInt("duration", 0);
                                                    }
                                                    JSONObject optJSONObject11 = optJSONObject9.optJSONObject("portrait");
                                                    if (optJSONObject11 != null) {
                                                        aVar.o = optJSONObject11.optString("url", "");
                                                        aVar.oeZ = eA(optJSONObject11);
                                                        aVar.a = optJSONObject11.optInt("duration", 0);
                                                    }
                                                    if (arrayList11 == null) {
                                                        arrayList11 = new ArrayList();
                                                    }
                                                    arrayList11.add(aVar);
                                                }
                                                i11 = i12 + 1;
                                            }
                                        }
                                    }
                                    onlineVip2 = onlineVip3;
                                    bangInfo2 = bangInfo3;
                                    str4 = optString;
                                    micStatus = micStatus2;
                                    roomChatBackground2 = roomChatBackground3;
                                    arrayList9 = arrayList25;
                                    arrayList5 = arrayList12;
                                    arrayList4 = arrayList13;
                                    obj = obj2;
                                    j = optLong2;
                                    arrayList10 = arrayList21;
                                    arrayList8 = arrayList20;
                                    com.kascend.chushou.player.ui.h5.c.c cVar6 = cVar2;
                                    bVar = bVar2;
                                    arrayList7 = arrayList11;
                                    z = z2;
                                    cycleLiveRoomInfo = cycleLiveRoomInfo2;
                                    karaokeBean = karaokeBean2;
                                    autoBang = autoBang2;
                                    cVar = cVar6;
                                } catch (Exception e13) {
                                    roomChatBackground = roomChatBackground3;
                                    onlineVip = onlineVip3;
                                    arrayList4 = arrayList13;
                                    micStatus = micStatus2;
                                    obj = obj2;
                                    arrayList5 = arrayList12;
                                    j = optLong2;
                                    bangInfo = bangInfo3;
                                    str2 = optString;
                                    str3 = str5;
                                    arrayList = arrayList21;
                                    arrayList2 = arrayList20;
                                    arrayList3 = arrayList25;
                                    exc = e13;
                                    i = i2;
                                    AutoBang autoBang6 = autoBang2;
                                    cVar = cVar2;
                                    bVar = bVar2;
                                    arrayList7 = arrayList11;
                                    z = z2;
                                    cycleLiveRoomInfo = cycleLiveRoomInfo2;
                                    karaokeBean = karaokeBean2;
                                    autoBang = autoBang6;
                                    tv.chushou.zues.utils.e.e("Parser_Player", "error " + exc.toString());
                                    parserRet = new ParserRet();
                                    parserRet.mBreakpoint = str2;
                                    parserRet.mData = arrayList3;
                                    parserRet.mData1 = Long.valueOf(j);
                                    if (arrayList2 == null) {
                                    }
                                    parserRet.mData2 = new SparseArray();
                                    if (arrayList2 != null) {
                                    }
                                    if (arrayList != null) {
                                    }
                                    if (bangInfo == null) {
                                    }
                                    if (parserRet.mData3 == null) {
                                    }
                                    if (bangInfo != null) {
                                    }
                                    if (!h.isEmpty(arrayList7)) {
                                    }
                                    if (micStatus == null) {
                                    }
                                    if (parserRet.mData3 == null) {
                                    }
                                    if (micStatus != null) {
                                    }
                                    if (!h.isEmpty(arrayList4)) {
                                    }
                                    if (obj != null) {
                                    }
                                    if (!h.isEmpty(arrayList6)) {
                                    }
                                    if (!h.isEmpty(arrayList23)) {
                                    }
                                    if (roomChatBackground != null) {
                                    }
                                    if (onlineVip != null) {
                                    }
                                    if (cVar != null) {
                                    }
                                    if (autoBang != null) {
                                    }
                                    if (karaokeBean != null) {
                                    }
                                    if (!h.isEmpty(arrayList24)) {
                                    }
                                    if (0 != 0) {
                                    }
                                    if (bVar != null) {
                                    }
                                    if (cycleLiveRoomInfo != null) {
                                    }
                                    if (micStatus == null) {
                                    }
                                    if (parserRet.mData3 == null) {
                                    }
                                    if (micStatus != null) {
                                    }
                                    if (!h.isEmpty(arrayList4)) {
                                    }
                                    if (parserRet.mData3 == null) {
                                    }
                                    parserRet.mData3.put(19, Boolean.valueOf(z));
                                    parserRet.mRc = i;
                                    parserRet.mMessage = str3;
                                    return parserRet;
                                }
                            } catch (Exception e14) {
                                cycleLiveRoomInfo = null;
                                karaokeBean = null;
                                cVar = null;
                                bVar = null;
                                arrayList6 = null;
                                obj = null;
                                arrayList5 = null;
                                arrayList4 = null;
                                micStatus = null;
                                str3 = str5;
                                z = false;
                                autoBang = null;
                                arrayList7 = arrayList22;
                                j = optLong2;
                                bangInfo = null;
                                str2 = optString;
                                onlineVip = null;
                                arrayList = arrayList21;
                                roomChatBackground = null;
                                arrayList2 = arrayList20;
                                i = i2;
                                arrayList3 = arrayList25;
                                exc = e14;
                            }
                        } catch (Exception e15) {
                            cycleLiveRoomInfo = null;
                            karaokeBean = null;
                            cVar = null;
                            bVar = null;
                            arrayList6 = null;
                            obj = null;
                            arrayList5 = null;
                            arrayList4 = null;
                            micStatus = null;
                            str3 = str5;
                            z = false;
                            autoBang = null;
                            arrayList7 = arrayList22;
                            j = optLong2;
                            bangInfo = null;
                            str2 = optString;
                            onlineVip = null;
                            arrayList = null;
                            roomChatBackground = null;
                            arrayList2 = null;
                            i = i2;
                            arrayList3 = arrayList25;
                            exc = e15;
                        }
                    } catch (Exception e16) {
                        bangInfo = null;
                        str2 = optString;
                        onlineVip = null;
                        arrayList = null;
                        roomChatBackground = null;
                        arrayList2 = null;
                        i = i2;
                        arrayList3 = arrayList25;
                        exc = e16;
                        karaokeBean = null;
                        bVar = null;
                        arrayList4 = null;
                        micStatus = null;
                        str3 = str5;
                        arrayList5 = null;
                        arrayList7 = arrayList22;
                        j = -1;
                        cycleLiveRoomInfo = null;
                        z = false;
                        cVar = null;
                        autoBang = null;
                        arrayList6 = null;
                        obj = null;
                    }
                } catch (Exception e17) {
                    str2 = "";
                    arrayList = null;
                    karaokeBean = null;
                    arrayList2 = null;
                    bVar = null;
                    arrayList3 = arrayList25;
                    exc = e17;
                    bangInfo = null;
                    onlineVip = null;
                    roomChatBackground = null;
                    i = i2;
                    arrayList4 = null;
                    micStatus = null;
                    str3 = str5;
                    arrayList5 = null;
                    z = false;
                    cycleLiveRoomInfo = null;
                    autoBang = null;
                    cVar = null;
                    arrayList6 = null;
                    arrayList7 = arrayList22;
                    obj = null;
                    j = -1;
                }
            }
            arrayList2 = arrayList8;
            arrayList3 = arrayList9;
            str2 = str4;
            arrayList = arrayList10;
            bangInfo = bangInfo2;
            onlineVip = onlineVip2;
            roomChatBackground = roomChatBackground2;
            i = i2;
            str3 = str5;
        } catch (Exception e18) {
            exc = e18;
            arrayList = null;
            str2 = "";
            arrayList2 = null;
            karaokeBean = null;
            arrayList3 = null;
            bVar = null;
            bangInfo = null;
            onlineVip = null;
            roomChatBackground = null;
            i = i2;
            arrayList4 = null;
            micStatus = null;
            str3 = str5;
            arrayList5 = null;
            cycleLiveRoomInfo = null;
            z = false;
            autoBang = null;
            cVar = null;
            arrayList6 = null;
            arrayList7 = arrayList22;
            j = -1;
            obj = null;
        }
        parserRet = new ParserRet();
        parserRet.mBreakpoint = str2;
        parserRet.mData = arrayList3;
        parserRet.mData1 = Long.valueOf(j);
        if (arrayList2 == null || arrayList != null) {
            parserRet.mData2 = new SparseArray();
            if (arrayList2 != null && arrayList2.size() > 0) {
                parserRet.mData2.put(1, arrayList2);
            }
            if (arrayList != null && arrayList.size() > 0) {
                parserRet.mData2.put(2, arrayList);
            }
        }
        if (bangInfo == null || !h.isEmpty(arrayList7)) {
            if (parserRet.mData3 == null) {
                parserRet.mData3 = new SparseArray();
            }
            if (bangInfo != null) {
                parserRet.mData3.put(1, bangInfo);
            }
            if (!h.isEmpty(arrayList7)) {
                parserRet.mData3.put(2, arrayList7);
            }
        }
        if (micStatus == null || !h.isEmpty(arrayList4)) {
            if (parserRet.mData3 == null) {
                parserRet.mData3 = new SparseArray();
            }
            if (micStatus != null) {
                parserRet.mData3.put(3, micStatus);
            }
            if (!h.isEmpty(arrayList4)) {
                parserRet.mData3.put(4, arrayList4);
            }
        }
        if (obj != null) {
            if (parserRet.mData3 == null) {
                parserRet.mData3 = new SparseArray();
            }
            parserRet.mData3.put(5, obj);
        }
        if (!h.isEmpty(arrayList6)) {
            if (parserRet.mData3 == null) {
                parserRet.mData3 = new SparseArray();
            }
            parserRet.mData3.put(6, arrayList6);
        }
        if (!h.isEmpty(arrayList23)) {
            if (parserRet.mData3 == null) {
                parserRet.mData3 = new SparseArray();
            }
            parserRet.mData3.put(7, arrayList23);
        }
        if (roomChatBackground != null) {
            if (parserRet.mData3 == null) {
                parserRet.mData3 = new SparseArray();
            }
            parserRet.mData3.put(9, roomChatBackground);
        }
        if (onlineVip != null) {
            if (parserRet.mData3 == null) {
                parserRet.mData3 = new SparseArray();
            }
            parserRet.mData3.put(10, onlineVip);
        }
        if (cVar != null) {
            if (parserRet.mData3 == null) {
                parserRet.mData3 = new SparseArray();
            }
            parserRet.mData3.put(11, cVar);
        }
        if (autoBang != null) {
            if (parserRet.mData3 == null) {
                parserRet.mData3 = new SparseArray();
            }
            parserRet.mData3.put(12, autoBang);
        }
        if (karaokeBean != null) {
            if (parserRet.mData3 == null) {
                parserRet.mData3 = new SparseArray();
            }
            parserRet.mData3.put(13, karaokeBean);
        }
        if (!h.isEmpty(arrayList24)) {
            if (parserRet.mData3 == null) {
                parserRet.mData3 = new SparseArray();
            }
            tv.chushou.zues.utils.e.d("guohe", "Parser_Player.parseGetChat(): pkNotifyInfoList.size = " + arrayList24.size());
            parserRet.mData3.put(14, arrayList24);
        }
        if (0 != 0) {
            if (parserRet.mData3 == null) {
                parserRet.mData3 = new SparseArray();
            }
            parserRet.mData3.put(15, null);
        }
        if (bVar != null) {
            if (parserRet.mData3 == null) {
                parserRet.mData3 = new SparseArray();
            }
            parserRet.mData3.put(16, bVar);
        }
        if (cycleLiveRoomInfo != null) {
            if (parserRet.mData3 == null) {
                parserRet.mData3 = new SparseArray();
            }
            parserRet.mData3.put(17, cycleLiveRoomInfo);
        }
        if (micStatus == null || !h.isEmpty(arrayList5)) {
            if (parserRet.mData3 == null) {
                parserRet.mData3 = new SparseArray();
            }
            if (micStatus != null) {
                parserRet.mData3.put(3, micStatus);
            }
            if (!h.isEmpty(arrayList4)) {
                parserRet.mData3.put(18, arrayList5);
            }
        }
        if (parserRet.mData3 == null) {
            parserRet.mData3 = new SparseArray();
        }
        parserRet.mData3.put(19, Boolean.valueOf(z));
        parserRet.mRc = i;
        parserRet.mMessage = str3;
        return parserRet;
    }

    public static ParserRet ep(JSONObject jSONObject) {
        int i = -1;
        if (jSONObject != null) {
            tv.chushou.zues.utils.e.d("Parser_Player", "parseSendDanmu :" + jSONObject.toString());
        }
        String str = "";
        String str2 = "";
        PrivilegeInfo privilegeInfo = new PrivilegeInfo();
        if (jSONObject != null) {
            try {
                i = jSONObject.getInt("code");
                str = jSONObject.optString("message");
                if (jSONObject.has("data")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    if (jSONObject2.has("medalList")) {
                        JSONArray jSONArray = jSONObject2.getJSONArray("medalList");
                        if (privilegeInfo.mMedals == null) {
                            privilegeInfo.mMedals = new ArrayList<>();
                        }
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            privilegeInfo.mMedals.add(jSONArray.getJSONObject(i2).getString("url"));
                        }
                    }
                    privilegeInfo.mShowAvatar = jSONObject2.optBoolean("showAvatar");
                    privilegeInfo.mAvatarFrame = jSONObject2.optString("avatarFrame");
                    privilegeInfo.mRole = jSONObject2.optString("isManager");
                    if (jSONObject2.has("privileges")) {
                        JSONArray jSONArray2 = jSONObject2.getJSONArray("privileges");
                        if (privilegeInfo.mPrivileges == null) {
                            privilegeInfo.mPrivileges = new ArrayList<>();
                        }
                        for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                            try {
                                privilegeInfo.mPrivileges.add(Integer.valueOf(jSONArray2.getInt(i3)));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    if (jSONObject2.has("richNickname")) {
                        privilegeInfo.mRichNickname = tv.chushou.zues.toolkit.richtext.b.Xv(jSONObject2.getString("richNickname"));
                    }
                    JSONArray optJSONArray = jSONObject2.optJSONArray("emojiPrivileges");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        HashSet hashSet = new HashSet(optJSONArray.length());
                        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                            hashSet.add(Integer.valueOf(optJSONArray.optInt(i4, -1)));
                        }
                        privilegeInfo.mEmojiPrivileges = hashSet;
                    }
                    b(jSONObject2, privilegeInfo);
                    c(jSONObject2, privilegeInfo);
                    if (21001 == i) {
                        str2 = jSONObject2.optString("url", "");
                    }
                }
                tv.chushou.zues.utils.e.i("Parser_Player", "rc = " + i + " msg=" + str);
            } catch (Exception e2) {
                tv.chushou.zues.utils.e.e("Parser_Player", "error " + e2.toString());
            }
        }
        ParserRet parserRet = new ParserRet();
        parserRet.mRc = i;
        parserRet.mData1 = str2;
        parserRet.mMessage = str;
        parserRet.mData = privilegeInfo;
        return parserRet;
    }

    public static ParserRet et(JSONObject jSONObject) {
        ArrayList arrayList;
        int i;
        ArrayList arrayList2;
        if (jSONObject != null) {
            tv.chushou.zues.utils.e.d("Parser_Player", "parseGetPlayList :" + jSONObject.toString());
        }
        String str = "";
        if (jSONObject == null) {
            arrayList = null;
            i = -1;
        } else {
            try {
                int i2 = jSONObject.getInt("code");
                try {
                    String optString = jSONObject.optString("message");
                    try {
                        tv.chushou.zues.utils.e.i("Parser_Player", "rc = " + i2 + " msg=" + optString);
                        if (i2 != 0 || !jSONObject.has("data")) {
                            arrayList2 = null;
                        } else {
                            arrayList2 = new ArrayList();
                            try {
                                JSONArray jSONArray = jSONObject.getJSONArray("data");
                                int length = jSONArray.length();
                                for (int i3 = 0; i3 < length; i3++) {
                                    PlayUrl playUrl = new PlayUrl();
                                    JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                                    playUrl.mProtocal = optJSONObject.optString("protocol");
                                    playUrl.mName = optJSONObject.optString("name");
                                    playUrl.streamName = optJSONObject.optString("streamName");
                                    playUrl.mEffectiveTime = h.parseLong(optJSONObject.optString("effectiveTime")) * 1000;
                                    if (playUrl.mEffectiveTime == 0) {
                                        playUrl.mEffectiveTime = 86400000L;
                                    }
                                    playUrl.mUseP2p = optJSONObject.optString("isUseP2p");
                                    playUrl.mType = optJSONObject.optString("type");
                                    JSONArray optJSONArray = optJSONObject.optJSONArray("urlDetails");
                                    if (optJSONArray != null) {
                                        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i4);
                                            if (optJSONObject2 != null) {
                                                UrlDetails urlDetails = new UrlDetails();
                                                urlDetails.mDefinitionName = optJSONObject2.optString("name");
                                                urlDetails.mDefinitionType = optJSONObject2.optString("definitionType");
                                                urlDetails.mUrl = optJSONObject2.optString("url");
                                                urlDetails.mBitrate = optJSONObject2.optString("bitrate");
                                                urlDetails.mSourceId = optJSONObject2.optString("liveSourceId");
                                                if (!h.isEmpty(urlDetails.mUrl)) {
                                                    playUrl.mUrlDetails.add(urlDetails);
                                                }
                                            }
                                        }
                                    }
                                    if (!h.isEmpty(playUrl.mUrlDetails)) {
                                        arrayList2.add(playUrl);
                                    }
                                }
                                tv.chushou.zues.utils.e.i("Parser_Player", "parser sucess");
                            } catch (Exception e) {
                                i = i2;
                                e = e;
                                arrayList = arrayList2;
                                str = optString;
                                tv.chushou.zues.utils.e.e("Parser_Player", "error " + e.toString());
                                ParserRet parserRet = new ParserRet();
                                parserRet.mData = arrayList;
                                parserRet.mRc = i;
                                parserRet.mMessage = str;
                                return parserRet;
                            }
                        }
                        i = i2;
                        arrayList = arrayList2;
                        str = optString;
                    } catch (Exception e2) {
                        str = optString;
                        arrayList = null;
                        i = i2;
                        e = e2;
                    }
                } catch (Exception e3) {
                    arrayList = null;
                    i = i2;
                    e = e3;
                }
            } catch (Exception e4) {
                e = e4;
                arrayList = null;
                i = -1;
            }
        }
        ParserRet parserRet2 = new ParserRet();
        parserRet2.mData = arrayList;
        parserRet2.mRc = i;
        parserRet2.mMessage = str;
        return parserRet2;
    }

    public static void a(JSONObject jSONObject, PrivilegeInfo privilegeInfo) {
        if (jSONObject != null) {
            tv.chushou.zues.utils.e.d("Parser_Player", "parsePrivilege :" + jSONObject.toString());
            try {
                if (jSONObject.has("privileges")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("privileges");
                    privilegeInfo.mShowAvatar = jSONObject2.optBoolean("showAvatar");
                    privilegeInfo.mAvatarFrame = jSONObject2.optString("avatarFrame");
                    privilegeInfo.mRole = jSONObject2.optString("isManager");
                    if (jSONObject2.has("privileges")) {
                        JSONArray jSONArray = jSONObject2.getJSONArray("privileges");
                        ArrayList<Integer> arrayList = new ArrayList<>();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            try {
                                arrayList.add(Integer.valueOf(jSONArray.getInt(i)));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        privilegeInfo.mPrivileges = arrayList;
                    }
                    if (jSONObject2.has("medalList")) {
                        JSONArray jSONArray2 = jSONObject2.getJSONArray("medalList");
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            try {
                                arrayList2.add(jSONArray2.getJSONObject(i2).getString("url"));
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                        privilegeInfo.mMedals = arrayList2;
                    }
                    if (jSONObject2.has("richNickname")) {
                        privilegeInfo.mRichNickname = tv.chushou.zues.toolkit.richtext.b.Xv(jSONObject2.getString("richNickname"));
                    }
                    JSONArray optJSONArray = jSONObject2.optJSONArray("emojiPrivileges");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        HashSet hashSet = new HashSet(optJSONArray.length());
                        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                            hashSet.add(Integer.valueOf(optJSONArray.optInt(i3, -1)));
                        }
                        privilegeInfo.mEmojiPrivileges = hashSet;
                    }
                    b(jSONObject2, privilegeInfo);
                    c(jSONObject2, privilegeInfo);
                    tv.chushou.zues.utils.e.i("Parser_Player", "parser sucess");
                }
            } catch (Exception e3) {
                tv.chushou.zues.utils.e.e("Parser_Player", "error " + e3.toString());
            }
        }
    }

    private static void b(JSONObject jSONObject, PrivilegeInfo privilegeInfo) {
        JSONObject optJSONObject;
        if (jSONObject.has("colorPrivileges") && (optJSONObject = jSONObject.optJSONObject("colorPrivileges")) != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            JSONArray optJSONArray = optJSONObject.optJSONArray("colors");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(optJSONArray.optString(i));
                }
                privilegeInfo.mColorPrivileges.mColors = arrayList;
            }
            if (optJSONObject.optInt("style") == 1) {
                privilegeInfo.mColorPrivileges.mWholeColor = true;
            } else {
                privilegeInfo.mColorPrivileges.mWholeColor = false;
            }
        }
    }

    private static void c(JSONObject jSONObject, PrivilegeInfo privilegeInfo) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4;
        if (jSONObject.has("coolPrivileges") && (optJSONObject = jSONObject.optJSONObject("coolPrivileges")) != null) {
            if (optJSONObject.has("coolNickname") && (optJSONObject4 = optJSONObject.optJSONObject("coolNickname")) != null) {
                privilegeInfo.mCoolNickname = new RichTextPlus();
                privilegeInfo.mCoolNickname.mNicknameRichText = tv.chushou.zues.toolkit.richtext.b.Xv(optJSONObject4.optString("nickname"));
                privilegeInfo.mCoolNickname.mFontColors = (ArrayList) a(optJSONObject4.optJSONArray("colors"));
            }
            if (optJSONObject.has("coolContent") && (optJSONObject3 = optJSONObject.optJSONObject("coolContent")) != null) {
                privilegeInfo.mCoolContent = new RichTextPlus();
                privilegeInfo.mCoolContent.mContentRichText = tv.chushou.zues.toolkit.richtext.b.Xv(optJSONObject3.optString("content"));
                privilegeInfo.mCoolContent.mFontColors = (ArrayList) a(optJSONObject3.optJSONArray("colors"));
            }
            if (optJSONObject.has("coolMessage") && (optJSONObject2 = optJSONObject.optJSONObject("coolMessage")) != null) {
                privilegeInfo.mCoolMessage = new RichTextPlus();
                privilegeInfo.mCoolMessage.mNicknameRichText = tv.chushou.zues.toolkit.richtext.b.Xv(optJSONObject2.optString("nickname"));
                privilegeInfo.mCoolMessage.mBgImage = optJSONObject2.optString("bgImage");
                privilegeInfo.mCoolMessage.mContentRichText = tv.chushou.zues.toolkit.richtext.b.Xv(optJSONObject2.optString("content"));
            }
        }
    }

    static List<String> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String optString = jSONArray.optString(i, null);
                if (optString != null) {
                    arrayList.add(optString);
                }
            }
        }
        return arrayList;
    }

    public static ParserRet eu(JSONObject jSONObject) {
        int i = -1;
        CycleLiveRoomInfo cycleLiveRoomInfo = null;
        if (jSONObject != null) {
            i = jSONObject.optInt("code");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                cycleLiveRoomInfo = ex(optJSONObject);
            }
        }
        ParserRet parserRet = new ParserRet();
        parserRet.mData = cycleLiveRoomInfo;
        parserRet.mRc = i;
        return parserRet;
    }

    public static ParserRet ev(JSONObject jSONObject) {
        JSONObject optJSONObject;
        int i = -1;
        PkNotifyInfo pkNotifyInfo = null;
        if (jSONObject != null) {
            i = jSONObject.optInt("code");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("PKInfo")) != null) {
                pkNotifyInfo = ez(optJSONObject);
            }
        }
        ParserRet parserRet = new ParserRet();
        parserRet.mData = pkNotifyInfo;
        parserRet.mRc = i;
        return parserRet;
    }

    public static ParserRet ew(JSONObject jSONObject) {
        String str;
        PrivilegeInfo privilegeInfo;
        ListItem er;
        ListItem er2;
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        JSONObject optJSONObject2;
        JSONArray optJSONArray3;
        ListItem er3;
        ListItem er4;
        RoomExpandInfo roomExpandInfo = null;
        int i = -1;
        if (jSONObject == null) {
            str = "";
            privilegeInfo = null;
        } else {
            int optInt = jSONObject.optInt("code");
            String optString = jSONObject.optString("message");
            JSONObject optJSONObject3 = jSONObject.optJSONObject("data");
            if (optJSONObject3 != null) {
                RoomExpandInfo roomExpandInfo2 = new RoomExpandInfo();
                JSONArray optJSONArray4 = optJSONObject3.optJSONArray("expandNavList");
                if (optJSONArray4 != null) {
                    ArrayList<ListItem> arrayList = new ArrayList<>();
                    roomExpandInfo2.mExpandNavList = arrayList;
                    for (int i2 = 0; i2 < optJSONArray4.length(); i2++) {
                        JSONObject optJSONObject4 = optJSONArray4.optJSONObject(i2);
                        if (optJSONObject4 != null && (er4 = a.er(optJSONObject4)) != null) {
                            arrayList.add(er4);
                        }
                    }
                }
                JSONObject optJSONObject5 = optJSONObject3.optJSONObject("displayH5Nav");
                if (optJSONObject5 != null) {
                    roomExpandInfo2.mTopWebAdItem = a.er(optJSONObject5);
                }
                JSONObject optJSONObject6 = optJSONObject3.optJSONObject("ads");
                if (optJSONObject6 != null && (optJSONArray3 = optJSONObject6.optJSONArray("giftBarAdNavList")) != null) {
                    ArrayList arrayList2 = new ArrayList();
                    if (roomExpandInfo2.mGiftTopRightIcons == null) {
                        roomExpandInfo2.mGiftTopRightIcons = new ArrayList();
                    }
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        JSONObject optJSONObject7 = optJSONArray3.optJSONObject(i3);
                        if (optJSONObject7 != null && (er3 = a.er(optJSONObject7)) != null) {
                            arrayList2.add(er3);
                        }
                    }
                    roomExpandInfo2.mGiftTopRightIcons.clear();
                    roomExpandInfo2.mGiftTopRightIcons.addAll(arrayList2);
                }
                new HashSet();
                if (optJSONObject3.has("privileges")) {
                    privilegeInfo = new PrivilegeInfo();
                    a(optJSONObject3, privilegeInfo);
                    Set<Integer> set = privilegeInfo.mEmojiPrivileges;
                } else {
                    privilegeInfo = null;
                }
                optJSONObject3.optJSONArray("emojiConfig");
                if (optJSONObject3.has("noviceGuide") && (optJSONObject2 = optJSONObject3.optJSONObject("noviceGuide")) != null) {
                    roomExpandInfo2.mRoomNewUserInfo = new RoomNewUserInfo();
                    roomExpandInfo2.mRoomNewUserInfo.mBarrierNoviceGuide = optJSONObject2.optBoolean("barrierNoviceGuide", false);
                    roomExpandInfo2.mRoomNewUserInfo.mRewardNoviceGuide = optJSONObject2.optBoolean("rewardNoviceGuide", false);
                }
                JSONObject optJSONObject8 = optJSONObject3.optJSONObject("redEnvelope");
                if (optJSONObject8 != null && (optJSONArray2 = optJSONObject8.optJSONArray("list")) != null) {
                    ArrayList arrayList3 = new ArrayList();
                    for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                        JSONObject optJSONObject9 = optJSONArray2.optJSONObject(i4);
                        if (optJSONObject9 != null) {
                            arrayList3.add(eB(optJSONObject9));
                        }
                    }
                    roomExpandInfo2.mRedpacketBeanList = arrayList3;
                }
                JSONObject optJSONObject10 = optJSONObject3.optJSONObject("luckyDraw");
                if (optJSONObject10 != null && (optJSONArray = optJSONObject10.optJSONArray("luckDrawList")) != null) {
                    for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                        JSONObject optJSONObject11 = optJSONArray.optJSONObject(i5);
                        if (optJSONObject11 != null) {
                            roomExpandInfo2.mLuckList.add(eC(optJSONObject11));
                        }
                    }
                }
                JSONObject optJSONObject12 = optJSONObject3.optJSONObject("vote");
                if (optJSONObject12 != null && (optJSONObject = optJSONObject12.optJSONObject("currentVote")) != null) {
                    roomExpandInfo2.mVoteItem = eC(optJSONObject);
                }
                JSONArray optJSONArray5 = optJSONObject3.optJSONArray("cornerH5NavList");
                if (optJSONArray5 != null && optJSONArray5.length() > 0) {
                    for (int i6 = 0; i6 < optJSONArray5.length(); i6++) {
                        JSONObject optJSONObject13 = optJSONArray5.optJSONObject(i6);
                        if (optJSONObject13 != null) {
                            roomExpandInfo2.mInteractH5Item.add(eE(optJSONObject13));
                        }
                    }
                }
                JSONArray optJSONArray6 = optJSONObject3.optJSONArray("cornerNavList");
                if (optJSONArray6 != null && optJSONArray6.length() > 0) {
                    for (int i7 = 0; i7 < optJSONArray6.length(); i7++) {
                        JSONObject optJSONObject14 = optJSONArray6.optJSONObject(i7);
                        if (optJSONObject14 != null) {
                            roomExpandInfo2.mInteractNavItem.add(eE(optJSONObject14));
                        }
                    }
                }
                JSONArray optJSONArray7 = optJSONObject3.optJSONArray("barrageColorMapping");
                if (optJSONArray7 != null) {
                    HashMap hashMap = new HashMap();
                    for (int i8 = 0; i8 < optJSONArray7.length(); i8++) {
                        JSONObject optJSONObject15 = optJSONArray7.optJSONObject(i8);
                        if (optJSONObject15 != null) {
                            hashMap.put(optJSONObject15.optString("old").toLowerCase(), optJSONObject15.optString("new").toLowerCase());
                        }
                    }
                    roomExpandInfo2.mColorMap.clear();
                    roomExpandInfo2.mColorMap.putAll(hashMap);
                }
                JSONObject optJSONObject16 = optJSONObject3.optJSONObject("iconConfig");
                if (optJSONObject16 != null) {
                    JSONObject optJSONObject17 = optJSONObject16.optJSONObject("payConfig");
                    if (optJSONObject17 != null) {
                        roomExpandInfo2.mIconConfig.payConfig.display = optJSONObject17.optBoolean("display", true);
                        roomExpandInfo2.mIconConfig.payConfig.icon = optJSONObject17.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                        roomExpandInfo2.mIconConfig.payConfig.notifyIcon = optJSONObject17.optString("notifyIcon");
                    }
                    JSONObject optJSONObject18 = optJSONObject16.optJSONObject("giftConfig");
                    if (optJSONObject18 != null) {
                        roomExpandInfo2.mIconConfig.giftConfig.display = optJSONObject18.optBoolean("display", true);
                        roomExpandInfo2.mIconConfig.giftConfig.icon = optJSONObject18.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                        roomExpandInfo2.mIconConfig.giftConfig.notifyIcon = optJSONObject18.optString("notifyIcon");
                    }
                    JSONObject optJSONObject19 = optJSONObject16.optJSONObject("bangConfig");
                    if (optJSONObject19 != null) {
                        roomExpandInfo2.mIconConfig.bangConfig.display = optJSONObject19.optBoolean("display", true);
                    }
                    JSONArray optJSONArray8 = optJSONObject16.optJSONArray("bottomList");
                    if (!h.ad(optJSONArray8)) {
                        for (int i9 = 0; i9 < optJSONArray8.length(); i9++) {
                            JSONObject optJSONObject20 = optJSONArray8.optJSONObject(i9);
                            if (optJSONObject20 != null) {
                                ConfigDetail configDetail = new ConfigDetail();
                                configDetail.mCover = optJSONObject20.optString("cover");
                                configDetail.mName = optJSONObject20.optString("name");
                                configDetail.mType = optJSONObject20.optString("type");
                                configDetail.mTargetKey = optJSONObject20.optString("targetKey");
                                if (!TbConfig.TMP_SHARE_DIR_NAME.equals(configDetail.mTargetKey)) {
                                    configDetail.position = optJSONObject20.optString("position");
                                    JSONObject optJSONObject21 = optJSONObject20.optJSONObject(MetaBox.TYPE);
                                    if (optJSONObject21 != null) {
                                        configDetail.mUrl = optJSONObject21.optString("url");
                                        configDetail.mNotifyType = optJSONObject21.optString("notifyType");
                                        JSONObject optJSONObject22 = optJSONObject21.optJSONObject("portrait");
                                        if (optJSONObject22 != null) {
                                            configDetail.mPortrait = eA(optJSONObject22);
                                        }
                                        JSONObject optJSONObject23 = optJSONObject21.optJSONObject("landscape");
                                        if (optJSONObject23 != null) {
                                            configDetail.mLandscape = eA(optJSONObject23);
                                        }
                                    }
                                    JSONArray optJSONArray9 = optJSONObject20.optJSONArray("configList");
                                    if (!h.ad(optJSONArray9)) {
                                        for (int i10 = 0; i10 < optJSONArray9.length(); i10++) {
                                            JSONObject optJSONObject24 = optJSONArray9.optJSONObject(i10);
                                            if (optJSONObject24 != null) {
                                                ConfigDetail configDetail2 = new ConfigDetail();
                                                configDetail2.mCover = optJSONObject24.optString("cover");
                                                configDetail2.mName = optJSONObject24.optString("name");
                                                configDetail2.mType = optJSONObject24.optString("type");
                                                configDetail2.mTargetKey = optJSONObject24.optString("targetKey");
                                                JSONObject optJSONObject25 = optJSONObject24.optJSONObject(MetaBox.TYPE);
                                                if (optJSONObject25 != null) {
                                                    configDetail2.mUrl = optJSONObject25.optString("url");
                                                    configDetail2.mNotifyType = optJSONObject25.optString("notifyType");
                                                    JSONObject optJSONObject26 = optJSONObject25.optJSONObject("portrait");
                                                    if (optJSONObject26 != null) {
                                                        configDetail2.mPortrait = eA(optJSONObject26);
                                                    }
                                                    JSONObject optJSONObject27 = optJSONObject25.optJSONObject("landscape");
                                                    if (optJSONObject27 != null) {
                                                        configDetail2.mLandscape = eA(optJSONObject27);
                                                    }
                                                }
                                                configDetail.configDetails.add(configDetail2);
                                            }
                                        }
                                    }
                                    roomExpandInfo2.mIconConfig.configs.add(configDetail);
                                }
                            }
                        }
                    }
                }
                JSONObject optJSONObject28 = optJSONObject3.optJSONObject("h5Tips");
                if (optJSONObject28 != null) {
                    roomExpandInfo2.mH5Tips = eD(optJSONObject28);
                }
                JSONObject optJSONObject29 = optJSONObject3.optJSONObject("autoBang");
                if (optJSONObject29 != null) {
                    roomExpandInfo2.mAutoBang = new AutoBang();
                    roomExpandInfo2.mAutoBang.bangTime = optJSONObject29.optLong("bangTime");
                    roomExpandInfo2.mAutoBang.currentTime = optJSONObject29.optLong("currentTime");
                }
                JSONArray optJSONArray10 = optJSONObject3.optJSONArray("relatedRoomList");
                if (optJSONArray10 != null) {
                    ArrayList arrayList4 = new ArrayList();
                    if (roomExpandInfo2.mRelatedRoomList == null) {
                        roomExpandInfo2.mRelatedRoomList = new ArrayList();
                    }
                    for (int i11 = 0; i11 < optJSONArray10.length(); i11++) {
                        JSONObject optJSONObject30 = optJSONArray10.optJSONObject(i11);
                        if (optJSONObject30 != null && (er2 = a.er(optJSONObject30)) != null) {
                            arrayList4.add(er2);
                        }
                    }
                    roomExpandInfo2.mRelatedRoomList.clear();
                    roomExpandInfo2.mRelatedRoomList.addAll(arrayList4);
                }
                JSONArray optJSONArray11 = optJSONObject3.optJSONArray("taobaokeConfig");
                if (optJSONArray11 != null) {
                    if (roomExpandInfo2.mShopWindowInfos == null) {
                        roomExpandInfo2.mShopWindowInfos = new ArrayList();
                    }
                    for (int i12 = 0; i12 < optJSONArray11.length(); i12++) {
                        JSONObject optJSONObject31 = optJSONArray11.optJSONObject(i12);
                        if (optJSONObject31 != null && (er = a.er(optJSONObject31)) != null) {
                            roomExpandInfo2.mShopWindowInfos.add(er);
                        }
                    }
                }
                JSONObject optJSONObject32 = optJSONObject3.optJSONObject("PKInfo");
                if (optJSONObject32 != null) {
                    roomExpandInfo2.mPkNotifyInfo = ez(optJSONObject32);
                }
                JSONObject optJSONObject33 = optJSONObject3.optJSONObject("trumpetPocket");
                if (optJSONObject33 != null) {
                    TrumpetPocket trumpetPocket = new TrumpetPocket();
                    trumpetPocket.type = optJSONObject33.optInt("type", 0);
                    trumpetPocket.primaryKey = optJSONObject33.optString("primaryKey");
                    trumpetPocket.primaryName = optJSONObject33.optString("primaryName");
                    trumpetPocket.primaryIcon = optJSONObject33.optString("primaryIcon");
                    trumpetPocket.point = optJSONObject33.optString(Config.EVENT_HEAT_POINT);
                    trumpetPocket.desc = optJSONObject33.optString("desc");
                    trumpetPocket.primaryBackground = optJSONObject33.optString("primaryBackground");
                    trumpetPocket.count = optJSONObject33.optInt("count", 0);
                    roomExpandInfo2.mTrumpetPocket = trumpetPocket;
                }
                JSONArray optJSONArray12 = optJSONObject3.optJSONArray("hotWords");
                if (optJSONArray12 != null) {
                    if (roomExpandInfo2.hotwordContentList == null) {
                        roomExpandInfo2.hotwordContentList = new ArrayList();
                    } else {
                        roomExpandInfo2.hotwordContentList.clear();
                    }
                    for (int i13 = 0; i13 < optJSONArray12.length(); i13++) {
                        JSONObject optJSONObject34 = optJSONArray12.optJSONObject(i13);
                        if (optJSONObject34 != null) {
                            g.a aVar = new g.a();
                            aVar.mStrDisplay = optJSONObject34.optString("displayWord");
                            aVar.mStrSend = optJSONObject34.optString("sendWord");
                            roomExpandInfo2.hotwordContentList.add(aVar);
                        }
                    }
                }
                JSONArray optJSONArray13 = optJSONObject3.optJSONArray("skinConfig");
                if (optJSONArray13 != null && optJSONArray13.length() > 0) {
                    if (roomExpandInfo2.skinConfig == null) {
                        roomExpandInfo2.skinConfig = new ArrayList();
                    }
                    for (int i14 = 0; i14 < optJSONArray13.length(); i14++) {
                        JSONObject optJSONObject35 = optJSONArray13.optJSONObject(i14);
                        if (optJSONObject35 != null) {
                            String optString2 = optJSONObject35.optString("position");
                            JSONObject optJSONObject36 = optJSONObject35.optJSONObject("resource");
                            if (optJSONObject36 != null && !h.isEmpty(optString2)) {
                                SkinConfig skinConfig = new SkinConfig();
                                skinConfig.position = optString2;
                                skinConfig.resource.image = optJSONObject36.optString("image");
                                skinConfig.resource.color = optJSONObject36.optString("color");
                                skinConfig.resource.selectedColor = optJSONObject36.optString("selectedColor");
                                skinConfig.resource.text = optJSONObject36.optString("text");
                                roomExpandInfo2.skinConfig.add(skinConfig);
                            }
                        }
                    }
                }
                roomExpandInfo = roomExpandInfo2;
                str = optString;
                i = optInt;
            } else {
                privilegeInfo = null;
                str = optString;
                i = optInt;
            }
        }
        ParserRet parserRet = new ParserRet();
        parserRet.mData = roomExpandInfo;
        if (privilegeInfo != null) {
            parserRet.mData1 = privilegeInfo;
        }
        parserRet.mRc = i;
        parserRet.mMessage = str;
        return parserRet;
    }

    public static CycleLiveRoomInfo ex(JSONObject jSONObject) {
        CycleLiveRoomInfo cycleLiveRoomInfo = new CycleLiveRoomInfo();
        cycleLiveRoomInfo.uid = jSONObject.optString("uid");
        cycleLiveRoomInfo.eventDesc = jSONObject.optString("eventDesc");
        cycleLiveRoomInfo.eventUrl = jSONObject.optString("eventUrl");
        cycleLiveRoomInfo.nickname = jSONObject.optString("nickname");
        cycleLiveRoomInfo.eventIcon = jSONObject.optString("eventIcon");
        cycleLiveRoomInfo.eventName = jSONObject.optString("eventName");
        cycleLiveRoomInfo.remainTime = jSONObject.optLong("remainTime");
        cycleLiveRoomInfo.avatar = jSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
        cycleLiveRoomInfo.roomId = jSONObject.optString("roomId");
        cycleLiveRoomInfo.isSubscribe = jSONObject.optBoolean("isSubscribe");
        return cycleLiveRoomInfo;
    }

    private static PkNotifyInfo.DestinyInfo ey(JSONObject jSONObject) {
        PkNotifyInfo.DestinyInfo destinyInfo = new PkNotifyInfo.DestinyInfo();
        if (jSONObject != null) {
            destinyInfo.destinyId = h.parseInt(jSONObject.optString("destinyId"));
            destinyInfo.pkBarIcon = jSONObject.optString("pkBarIcon");
            destinyInfo.pkBarKey = jSONObject.optString("pkBarKey");
        }
        return destinyInfo;
    }

    private static PkNotifyInfo ez(JSONObject jSONObject) {
        PkNotifyInfo pkNotifyInfo = new PkNotifyInfo();
        if (pkNotifyInfo.mPkUpdateInfo == null) {
            pkNotifyInfo.mPkUpdateInfo = new PkUpdateInfo();
        }
        pkNotifyInfo.mPkId = jSONObject.optString("pkId");
        pkNotifyInfo.mPkUpdateInfo.opponentReceiveCount = jSONObject.optString("opponentReceiveCount");
        pkNotifyInfo.mPkUpdateInfo.receiveCount = jSONObject.optString("receiveCount");
        pkNotifyInfo.mPkUpdateInfo.endTimeStamp = jSONObject.optLong("endTimeStamp");
        pkNotifyInfo.mPkUpdateInfo.remainDuration = jSONObject.optLong("remainDuration");
        int optInt = jSONObject.optInt("mode", 0);
        if (optInt == 1 || optInt == 2) {
            pkNotifyInfo.mMode = optInt;
        }
        int optInt2 = jSONObject.optInt("PKState", -1);
        if (optInt2 == 0) {
            pkNotifyInfo.mAction = 7;
        } else if (optInt2 == 2) {
            pkNotifyInfo.mAction = 5;
        } else if (optInt2 == 3) {
            pkNotifyInfo.mAction = 6;
        } else {
            pkNotifyInfo.mAction = 2;
        }
        pkNotifyInfo.mResult = jSONObject.optString("result");
        JSONObject optJSONObject = jSONObject.optJSONObject("opponentRoom");
        if (optJSONObject != null) {
            pkNotifyInfo.mPkRoomId = optJSONObject.optString("pkRoomId");
            pkNotifyInfo.mPkUid = optJSONObject.optString("pkUid");
            pkNotifyInfo.mPkUserNickname = optJSONObject.optString("pkUserNickname");
            pkNotifyInfo.mPkUserAvatar = optJSONObject.optString("pkUserAvatar");
            pkNotifyInfo.liveStyle = optJSONObject.optInt("pkStyle");
            tv.chushou.zues.utils.e.d("guohe", "Parser_Player.parsePkInfo(): style = " + pkNotifyInfo.liveStyle);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("rewardList");
        if (optJSONArray != null) {
            if (pkNotifyInfo.mPkUpdateInfo.rewardList == null) {
                pkNotifyInfo.mPkUpdateInfo.rewardList = new ArrayList();
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    MyUserInfo myUserInfo = new MyUserInfo();
                    myUserInfo.mHeadiconUrl = optJSONObject2.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
                    myUserInfo.mUserID = optJSONObject2.optString("uid");
                    pkNotifyInfo.mPkUpdateInfo.rewardList.add(myUserInfo);
                }
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("opponentRewardList");
        if (optJSONArray2 != null) {
            if (pkNotifyInfo.mPkUpdateInfo.opponentRewardList == null) {
                pkNotifyInfo.mPkUpdateInfo.opponentRewardList = new ArrayList();
            }
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i2);
                if (optJSONObject3 != null) {
                    MyUserInfo myUserInfo2 = new MyUserInfo();
                    myUserInfo2.mHeadiconUrl = optJSONObject3.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
                    myUserInfo2.mUserID = optJSONObject3.optString("uid");
                    pkNotifyInfo.mPkUpdateInfo.opponentRewardList.add(myUserInfo2);
                }
            }
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray("specialMoment");
        if (optJSONArray3 != null) {
            if (pkNotifyInfo.mPkUpdateInfo.specialMomentList == null) {
                pkNotifyInfo.mPkUpdateInfo.specialMomentList = new ArrayList();
            }
            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                JSONObject optJSONObject4 = optJSONArray3.optJSONObject(i3);
                if (optJSONObject4 != null) {
                    PkUpdateInfo.SpecialMoment specialMoment = new PkUpdateInfo.SpecialMoment();
                    specialMoment.type = optJSONObject4.optInt("type");
                    if (specialMoment.type == 1) {
                        specialMoment.roomId = optJSONObject4.optString("roomId");
                        specialMoment.addition = optJSONObject4.optString("addition");
                    } else if (specialMoment.type == 2 || specialMoment.type == 3 || specialMoment.type == 4) {
                        specialMoment.endTime = optJSONObject4.optLong("endTime");
                        specialMoment.remainDuration = optJSONObject4.optLong("remainDuration");
                        specialMoment.maxDuration = optJSONObject4.optLong("maxDuration");
                        specialMoment.addition = optJSONObject4.optString("addition");
                    }
                    pkNotifyInfo.mPkUpdateInfo.specialMomentList.add(specialMoment);
                }
            }
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("destinyInfo");
        if (optJSONObject5 != null) {
            pkNotifyInfo.destinyInfo = ey(optJSONObject5);
        }
        return pkNotifyInfo;
    }

    private static void a(JSONObject jSONObject, com.kascend.chushou.player.ui.h5.c.d dVar) {
        dVar.h = jSONObject.optInt("style", 1);
        dVar.i = jSONObject.optInt("showClose", 0);
        dVar.j = jSONObject.optInt("closeType", 0);
        dVar.k = jSONObject.optString("maskColor", "");
        dVar.l = jSONObject.optInt("priority", 0);
        dVar.p = jSONObject.optString("key", "");
        dVar.q = jSONObject.optString("displayType", HttpConfig.UBC_HTTP_ID);
        JSONObject optJSONObject = jSONObject.optJSONObject("landscape");
        if (optJSONObject != null) {
            dVar.oeY = eA(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("portrait");
        if (optJSONObject2 != null) {
            dVar.oeZ = eA(optJSONObject2);
        }
        dVar.o = jSONObject.optString("url", "");
    }

    private static H5Positon eA(JSONObject jSONObject) {
        H5Positon h5Positon = new H5Positon();
        h5Positon.mWidth = jSONObject.optInt("width", 0);
        h5Positon.mHeight = jSONObject.optInt("height", 0);
        h5Positon.mAspectRadio = jSONObject.optInt("aspectRatio", 0);
        return h5Positon;
    }

    private static com.kascend.chushou.player.ui.h5.c.e eB(JSONObject jSONObject) {
        com.kascend.chushou.player.ui.h5.c.e eVar = new com.kascend.chushou.player.ui.h5.c.e();
        a(jSONObject, eVar);
        eVar.VE(jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, ""));
        return eVar;
    }

    private static com.kascend.chushou.player.ui.h5.c.c eC(JSONObject jSONObject) {
        com.kascend.chushou.player.ui.h5.c.c cVar = new com.kascend.chushou.player.ui.h5.c.c();
        a(jSONObject, cVar);
        cVar.a = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, "");
        cVar.d = jSONObject.optLong("duration", 0L);
        JSONObject optJSONObject = jSONObject.optJSONObject(MetaBox.TYPE);
        if (optJSONObject != null) {
            cVar.e = optJSONObject.optLong("remainTime", 0L);
            cVar.f = optJSONObject.optString("checkUrl", "");
            cVar.b = optJSONObject.optString("remainTimeIcon", "");
            cVar.c = optJSONObject.optString("remainTimeColor", "");
        }
        cVar.g = jSONObject.optString("targetKey", "");
        return cVar;
    }

    public static com.kascend.chushou.player.ui.h5.c.a eD(JSONObject jSONObject) {
        com.kascend.chushou.player.ui.h5.c.a aVar = new com.kascend.chushou.player.ui.h5.c.a();
        a(jSONObject, aVar);
        aVar.a = jSONObject.optInt("duration", 0);
        aVar.b = jSONObject.optString("targetKey", "");
        aVar.c = jSONObject.optInt("h5Type", 0);
        aVar.d = jSONObject.optInt("delayDuration", 0);
        return aVar;
    }

    public static com.kascend.chushou.player.ui.h5.c.b eE(JSONObject jSONObject) {
        com.kascend.chushou.player.ui.h5.c.b bVar = new com.kascend.chushou.player.ui.h5.c.b();
        a(jSONObject, bVar);
        bVar.c = jSONObject.optInt("duration", 0);
        bVar.d = jSONObject.optString("targetKey", "");
        bVar.e = jSONObject.optInt("h5Type", 0);
        bVar.f = jSONObject.optInt("delayDuration", 0);
        bVar.a = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, "");
        bVar.b = jSONObject.optLong("remainTime", 0L);
        bVar.d = jSONObject.optString("targetKey", "");
        return bVar;
    }

    public static ParserRet eF(JSONObject jSONObject) {
        long j = 0;
        int optInt = jSONObject.optInt("code", -1);
        String optString = jSONObject.optString("message", "");
        com.kascend.chushou.player.ui.h5.c.a aVar = null;
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            j = optJSONObject.optLong("remainTime", 0L);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("resultPage");
            if (optJSONObject2 != null) {
                aVar = new com.kascend.chushou.player.ui.h5.c.a();
                a(optJSONObject2, aVar);
                aVar.a = optJSONObject2.optInt("duration", 0);
                aVar.b = optJSONObject2.optString("targetKey", "");
            }
        }
        ParserRet parserRet = new ParserRet();
        parserRet.mRc = optInt;
        parserRet.mMessage = optString;
        parserRet.mData = aVar;
        parserRet.mData1 = Long.valueOf(j);
        return parserRet;
    }

    private static boolean a(JSONArray jSONArray, JSONArray jSONArray2) {
        String str;
        String str2 = null;
        boolean z = false;
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        tv.chushou.basis.d.a.b.b bVar = (tv.chushou.basis.d.a.b.b) tv.chushou.basis.d.b.epS().S(tv.chushou.basis.d.a.b.b.class);
        if (bVar != null) {
            str = bVar.getAppKey();
            str2 = bVar.eey();
        } else {
            str = null;
        }
        if (jSONArray != null && jSONArray.length() > 0) {
            HashSet hashSet = new HashSet();
            for (int i = 0; i < jSONArray.length(); i++) {
                String optString = jSONArray.optString(i);
                if (!h.isEmpty(optString)) {
                    hashSet.add(optString);
                }
            }
            return (hashSet.contains(str) || hashSet.contains(str2)) ? true : true;
        } else if (jSONArray2 == null || jSONArray2.length() <= 0) {
            return true;
        } else {
            HashSet hashSet2 = new HashSet();
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                String optString2 = jSONArray2.optString(i2);
                if (!h.isEmpty(optString2)) {
                    hashSet2.add(optString2);
                }
            }
            return (hashSet2.contains(str) || hashSet2.contains(str2)) ? false : true;
        }
    }
}
