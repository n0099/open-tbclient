package com.kascend.chushou.c;

import android.support.v4.util.SparseArrayCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.mobstat.Config;
import com.coremedia.iso.boxes.MetaBox;
import com.heytap.mcssdk.mode.CommandMessage;
import com.kascend.chushou.constants.BangListInfo;
import com.kascend.chushou.constants.EmojiGiftDetail;
import com.kascend.chushou.constants.FullRoomInfo;
import com.kascend.chushou.constants.GeneralGift;
import com.kascend.chushou.constants.GeneralTabGift;
import com.kascend.chushou.constants.GiftComboConfig;
import com.kascend.chushou.constants.H5Positon;
import com.kascend.chushou.constants.ParserRet;
import com.kascend.chushou.constants.RoomInfo;
import com.kascend.chushou.constants.RoomTab;
import com.kascend.chushou.constants.RoomToast;
import com.tencent.open.SocialOperation;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.chushou.zues.utils.h;
/* loaded from: classes6.dex */
public class f {
    public static ParserRet u(String str, JSONObject jSONObject) {
        return b(str, jSONObject, true);
    }

    public static ParserRet b(String str, JSONObject jSONObject, boolean z) {
        FullRoomInfo fullRoomInfo;
        String str2;
        Exception exc;
        int i;
        JSONArray jSONArray;
        boolean z2;
        tv.chushou.zues.utils.e.l("Parser_Room", "%s%sparseRoomInfo:", jSONObject);
        FullRoomInfo fullRoomInfo2 = null;
        int i2 = -1;
        String str3 = "";
        try {
            i2 = jSONObject.optInt("code", -1);
            str3 = jSONObject.optString("message", "");
            tv.chushou.zues.utils.e.i("Parser_Room", "rc = " + i2 + " msg=" + str3);
            if (i2 == 0 && jSONObject.has("data")) {
                fullRoomInfo = new FullRoomInfo();
                try {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    JSONArray optJSONArray = jSONObject2.optJSONArray("roomTabs");
                    if (!h.ad(optJSONArray)) {
                        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                            if (optJSONObject != null) {
                                RoomTab roomTab = new RoomTab();
                                roomTab.name = optJSONObject.optString("name");
                                roomTab.type = optJSONObject.optInt("type");
                                roomTab.url = optJSONObject.optString("url");
                                roomTab.notify = optJSONObject.optInt("notify");
                                roomTab.notifyIcon = optJSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                                roomTab.mTargetKey = optJSONObject.optString("targetKey");
                                fullRoomInfo.mRoomTabs.add(roomTab);
                            }
                        }
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("shareInfo");
                    if (optJSONObject2 != null) {
                        fullRoomInfo.mRoominfo.mShareInfo = a.eC(optJSONObject2);
                    }
                    JSONObject optJSONObject3 = jSONObject2.optJSONObject("user");
                    if (optJSONObject3 != null) {
                        fullRoomInfo.mRoominfo.mCreatorUID = optJSONObject3.optString("uid", "");
                        fullRoomInfo.mRoominfo.mCreatorNickname = optJSONObject3.optString("nickname", "");
                        fullRoomInfo.mRoominfo.mCreatorAvatar = optJSONObject3.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR, "");
                        fullRoomInfo.mRoominfo.mCreatorGender = optJSONObject3.optString("gender", "");
                        fullRoomInfo.mRoominfo.mCreatorSignature = optJSONObject3.optString(SocialOperation.GAME_SIGNATURE);
                        fullRoomInfo.mRoominfo.mCreatorLevel = optJSONObject3.optInt("level", 0);
                        fullRoomInfo.mRoominfo.mCreatorLevelMedal = optJSONObject3.optString("levelMedal");
                    }
                    fullRoomInfo.mRoominfo.mIsLive = jSONObject2.optBoolean("isOnline", false);
                    fullRoomInfo.mRoominfo.mLiveType = jSONObject2.optString("liveType", "1");
                    fullRoomInfo.mRoominfo.mIsSubscribed = jSONObject2.optBoolean("isSubscribed", false);
                    if (jSONObject2.has(UbcStatConstant.KEY_CONTENT_ROOM)) {
                        a(jSONObject2.getJSONObject(UbcStatConstant.KEY_CONTENT_ROOM), fullRoomInfo.mRoominfo);
                    }
                    fullRoomInfo.mRoominfo.mSystemAnnouncement = jSONObject2.optString("systemAnnouncement", "");
                    List<GeneralTabGift> a2 = a(jSONObject2);
                    if (a2 != null) {
                        fullRoomInfo.mGeneralTabGifts.addAll(a2);
                    }
                    JSONArray optJSONArray2 = jSONObject2.optJSONArray("toastList");
                    if (optJSONArray2 != null) {
                        int length = optJSONArray2.length();
                        for (int i4 = 0; i4 < length; i4++) {
                            JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i4);
                            if (optJSONObject4 != null) {
                                RoomToast roomToast = new RoomToast();
                                roomToast.mToastContent = optJSONObject4.optString("toast");
                                roomToast.mType = optJSONObject4.optInt("type");
                                fullRoomInfo.mRoomToastList.add(roomToast);
                            }
                        }
                    }
                    if (jSONObject2.has("giftComboList") && (jSONArray = jSONObject2.getJSONArray("giftComboList")) != null && jSONArray.length() > 0 && fullRoomInfo.mGeneralTabGifts != null) {
                        for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                            JSONObject optJSONObject5 = jSONArray.optJSONObject(i5);
                            if (optJSONObject5 != null && optJSONObject5.has("giftId")) {
                                int optInt = optJSONObject5.optInt("giftId", -1);
                                boolean z3 = false;
                                int i6 = 0;
                                while (i6 < fullRoomInfo.mGeneralTabGifts.size()) {
                                    List<GeneralGift> list = fullRoomInfo.mGeneralTabGifts.get(i6).mGeneralGifts;
                                    if (!h.isEmpty(list)) {
                                        int i7 = 0;
                                        while (true) {
                                            if (i7 >= list.size()) {
                                                z2 = z3;
                                                break;
                                            } else if (optInt != list.get(i7).mId) {
                                                i7++;
                                            } else {
                                                if (optJSONObject5.has("duration")) {
                                                    list.get(i7).mDuration = optJSONObject5.optInt("duration", 3) * 1000;
                                                }
                                                if (optJSONObject5.has("background")) {
                                                    list.get(i7).mRepeatedBg = optJSONObject5.optString("background", "");
                                                }
                                                z2 = true;
                                            }
                                        }
                                        if (z2) {
                                            break;
                                        }
                                    } else {
                                        z2 = z3;
                                    }
                                    i6++;
                                    z3 = z2;
                                }
                            }
                        }
                    }
                    if (jSONObject2.has("giftComboConfig")) {
                        fullRoomInfo.mGiftComboConfig = new GiftComboConfig();
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("giftComboConfig");
                        fullRoomInfo.mGiftComboConfig.displayBaseCombo = jSONObject3.optLong("displayBaseCombo");
                        if (jSONObject3.has("durationList")) {
                            JSONArray jSONArray2 = jSONObject3.getJSONArray("durationList");
                            for (int i8 = 0; i8 < jSONArray2.length(); i8++) {
                                JSONObject jSONObject4 = jSONArray2.getJSONObject(i8);
                                if (jSONObject4 != null) {
                                    GiftComboConfig.Duration duration = new GiftComboConfig.Duration();
                                    duration.duration = jSONObject4.optLong("duration");
                                    duration.startPoint = jSONObject4.optLong("startPoint");
                                    duration.endPoint = jSONObject4.optLong("endPoint");
                                    fullRoomInfo.mGiftComboConfig.durationList.add(duration);
                                }
                            }
                        }
                    }
                    if (jSONObject2.has("bangList")) {
                        JSONArray jSONArray3 = jSONObject2.getJSONArray("bangList");
                        int length2 = jSONArray3.length();
                        if (fullRoomInfo.mBangMap == null) {
                            fullRoomInfo.mBangMap = new SparseArrayCompat<>();
                        }
                        for (int i9 = 0; i9 < length2; i9++) {
                            JSONObject optJSONObject6 = jSONArray3.optJSONObject(i9);
                            BangListInfo bangListInfo = new BangListInfo();
                            bangListInfo.icon = optJSONObject6.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                            bangListInfo.level = optJSONObject6.optInt("level");
                            bangListInfo.name = optJSONObject6.optString("name");
                            fullRoomInfo.mBangMap.put(bangListInfo.level, bangListInfo);
                        }
                    }
                    if (jSONObject2.has("gameInfo")) {
                        jSONObject2.getJSONObject("gameInfo").optString("downloadUrl");
                    }
                    JSONObject optJSONObject7 = jSONObject2.optJSONObject("currentLiveRoom");
                    if (optJSONObject7 != null) {
                        fullRoomInfo.cycleLiveRoomInfo = e.eJ(optJSONObject7);
                    }
                    tv.chushou.zues.utils.e.i("Parser_Room", "parser sucess");
                    fullRoomInfo2 = fullRoomInfo;
                } catch (Exception e) {
                    i = i2;
                    exc = e;
                    str2 = str3;
                    tv.chushou.zues.utils.e.e("Parser_Room", "error " + exc.toString());
                    ParserRet parserRet = new ParserRet();
                    parserRet.mData = fullRoomInfo;
                    parserRet.mRc = i;
                    parserRet.mMessage = str2;
                    return parserRet;
                }
            }
            i = i2;
            fullRoomInfo = fullRoomInfo2;
            str2 = str3;
        } catch (Exception e2) {
            fullRoomInfo = null;
            str2 = str3;
            exc = e2;
            i = i2;
        }
        ParserRet parserRet2 = new ParserRet();
        parserRet2.mData = fullRoomInfo;
        parserRet2.mRc = i;
        parserRet2.mMessage = str2;
        return parserRet2;
    }

    public static List<GeneralTabGift> a(JSONObject jSONObject) {
        ArrayList arrayList = null;
        if (jSONObject.has("generalGiftList")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("generalGiftList");
            int length = optJSONArray.length();
            arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    GeneralTabGift generalTabGift = new GeneralTabGift();
                    generalTabGift.mName = optJSONObject.optString("name");
                    generalTabGift.mFrequentlyUsedTab = optJSONObject.optBoolean("frequentlyUsedTab", false);
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("items");
                    if (optJSONArray2 != null) {
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            GeneralGift eS = eS(optJSONArray2.optJSONObject(i2));
                            if (eS != null) {
                                generalTabGift.mGeneralGifts.add(eS);
                            }
                        }
                    }
                    if (!h.isEmpty(generalTabGift.mName) && !h.isEmpty(generalTabGift.mGeneralGifts)) {
                        arrayList.add(generalTabGift);
                    }
                }
            }
        }
        return arrayList;
    }

    public static List<GeneralGift> a(JSONObject jSONObject, String str) {
        ArrayList arrayList = null;
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        if (optJSONArray != null) {
            arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                GeneralGift eS = eS(optJSONArray.optJSONObject(i));
                if (eS != null) {
                    eS.mGroupName = str;
                    eS.mGroup = 127;
                    arrayList.add(eS);
                }
            }
        }
        return arrayList;
    }

    public static ParserRet eF(JSONObject jSONObject) {
        ArrayList arrayList = null;
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        String str = "";
        if (optJSONObject != null) {
            str = optJSONObject.optString("breakpoint");
            JSONArray optJSONArray = optJSONObject.optJSONArray("items");
            if (optJSONArray != null) {
                arrayList = new ArrayList();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    GeneralGift eS = eS(optJSONArray.optJSONObject(i));
                    if (eS != null) {
                        arrayList.add(eS);
                    }
                }
            }
        }
        ParserRet parserRet = new ParserRet();
        parserRet.mData = arrayList;
        parserRet.mBreakpoint = str;
        return parserRet;
    }

    public static ParserRet eG(JSONObject jSONObject) {
        EmojiGiftDetail emojiGiftDetail = null;
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            emojiGiftDetail = new EmojiGiftDetail();
            emojiGiftDetail.creatorUid = optJSONObject.optString("creatorUid");
            emojiGiftDetail.online = optJSONObject.optBoolean("online", false);
            emojiGiftDetail.roomId = optJSONObject.optString("roomId");
            emojiGiftDetail.subscriber = optJSONObject.optBoolean("subscriber", false);
            emojiGiftDetail.liveType = optJSONObject.optString("liveType");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("generalGift");
            if (optJSONObject2 != null) {
                emojiGiftDetail.generalGift = eS(optJSONObject2);
            }
        }
        ParserRet parserRet = new ParserRet();
        parserRet.mData = emojiGiftDetail;
        return parserRet;
    }

    public static GeneralGift eS(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        GeneralGift generalGift = new GeneralGift();
        generalGift.mId = h.parseInt(jSONObject.optString("id"));
        generalGift.mType = h.parseInt(jSONObject.optString("type"));
        generalGift.mName = jSONObject.optString("name");
        generalGift.mDesc = jSONObject.optString("desc");
        generalGift.mIcon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        generalGift.mCornerImage = jSONObject.optString("cornerIcon");
        generalGift.mPoint = h.cb(jSONObject.optString(Config.EVENT_HEAT_POINT), -1);
        generalGift.mCount = h.cb(jSONObject.optString("count"), -1);
        generalGift.mActionType = h.parseInt(jSONObject.optString("actionType"));
        generalGift.mExpiredTimeDesc = jSONObject.optString("expiredTimeDesc");
        generalGift.mGroup = jSONObject.optInt(TbEnum.ParamKey.GROUP);
        generalGift.mDisplayDesc = jSONObject.optString("displayDesc");
        generalGift.mWorthDesc = jSONObject.optString("worthDesc");
        generalGift.mUrl = jSONObject.optString("url");
        generalGift.mSupportBatch = jSONObject.optBoolean("supportBatch");
        generalGift.mComboExpiryTime = jSONObject.optLong("comboExpiryTime");
        generalGift.mGroupName = jSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_NAME);
        JSONArray optJSONArray = jSONObject.optJSONArray(CommandMessage.TYPE_TAGS);
        if (optJSONArray != null) {
            generalGift.mTagLists = a(optJSONArray);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(MetaBox.TYPE);
        if (optJSONObject != null) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("landscape");
            if (optJSONObject2 != null) {
                generalGift.mLandscape = eT(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("portrait");
            if (optJSONObject3 != null) {
                generalGift.mPortrait = eT(optJSONObject3);
            }
            generalGift.mUrl = optJSONObject.optString("url", "");
            generalGift.mGiftDetailWidth = optJSONObject.optInt("giftDetailWidth", 0);
            generalGift.mGiftDetailHeight = optJSONObject.optInt("giftDetailHeight", 0);
            return generalGift;
        }
        return generalGift;
    }

    private static H5Positon eT(JSONObject jSONObject) {
        H5Positon h5Positon = new H5Positon();
        h5Positon.mWidth = jSONObject.optInt("width", 0);
        h5Positon.mHeight = jSONObject.optInt("height", 0);
        h5Positon.mAspectRadio = jSONObject.optInt("aspectRatio", 0);
        return h5Positon;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(JSONObject jSONObject, RoomInfo roomInfo) {
        roomInfo.mRoomID = jSONObject.optString("id", "");
        roomInfo.mName = jSONObject.optString("name", "");
        roomInfo.mRoomNotice = jSONObject.optString("announcement", "");
        roomInfo.mFansCount = jSONObject.optString("subscriberCount", "");
        roomInfo.mIsPushOn = jSONObject.optBoolean("pushFlag", false);
        roomInfo.mLastLiveTime = jSONObject.optLong("lastLiveTime", 0L);
        roomInfo.mLastLiveDesc = jSONObject.optString("lastLiveTimeDesc", "");
        JSONObject optJSONObject = jSONObject.optJSONObject("creator");
        if (optJSONObject != null) {
            roomInfo.mCreatorUID = optJSONObject.optString("uid", "");
            roomInfo.mCreatorNickname = optJSONObject.optString("nickname", "");
            roomInfo.mCreatorAvatar = optJSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR, "");
            roomInfo.mCreatorGender = optJSONObject.optString("gender", "");
            roomInfo.mCreatorSignature = optJSONObject.optString(SocialOperation.GAME_SIGNATURE);
            roomInfo.mCreatorLevel = optJSONObject.optInt("level", 0);
            roomInfo.mCreatorLevelMedal = optJSONObject.optString("levelMedal");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("liveStatus");
        if (optJSONObject2 != null) {
            roomInfo.mOnlineCount = optJSONObject2.optString("onlineCount", "");
            roomInfo.mCover = optJSONObject2.optString(StatisticConstants.SCREENSHOT, "");
            roomInfo.mModelName = optJSONObject2.optString("modelName", "");
            roomInfo.mLiveTimeDesc = optJSONObject2.optString("liveTimeDesc", "");
            roomInfo.mStyle = optJSONObject2.optInt("style");
            JSONObject optJSONObject3 = optJSONObject2.optJSONObject(ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME);
            if (optJSONObject3 != null) {
                roomInfo.mGameId = optJSONObject3.optString("id", "");
                roomInfo.mGameName = optJSONObject3.optString("name", "");
                roomInfo.mGameIcon = optJSONObject3.optString("poster", "");
            }
            JSONObject optJSONObject4 = optJSONObject2.optJSONObject("liveTag");
            if (optJSONObject4 != null) {
                roomInfo.mLiveTag = optJSONObject4.optString("name", "");
            }
        }
    }
}
