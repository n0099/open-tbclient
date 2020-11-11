package com.kascend.chushou.c;

import android.support.annotation.Nullable;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.coremedia.iso.boxes.MetaBox;
import com.kascend.chushou.constants.AdExtraInfo;
import com.kascend.chushou.constants.AdTrackInfo;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.constants.PannelItem;
import com.kascend.chushou.constants.ParserRet;
import com.kascend.chushou.constants.Replacement;
import com.kascend.chushou.constants.ShareInfo;
import com.kascend.chushou.constants.ShopWindowInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.chushou.zues.utils.h;
/* loaded from: classes6.dex */
public class a {
    public static ParserRet eH(JSONObject jSONObject) {
        int i = -1;
        String str = "";
        if (jSONObject != null) {
            i = jSONObject.optInt("code", -1);
            str = jSONObject.optString("message", "");
        }
        ParserRet parserRet = new ParserRet();
        parserRet.mRc = i;
        parserRet.mMessage = str;
        return parserRet;
    }

    public static ShareInfo eI(JSONObject jSONObject) {
        ShareInfo shareInfo = new ShareInfo();
        shareInfo.mThumbnail = jSONObject.optString("thumbnail", "");
        shareInfo.mTitle = jSONObject.optString("title", "");
        shareInfo.mUrl = jSONObject.optString("url", "");
        shareInfo.mContent = jSONObject.optString("content", "");
        shareInfo.mPic = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN, "");
        shareInfo.mMiniProgramUrl = jSONObject.optString("miniprogramUrl", "");
        shareInfo.mMiniProgramThumbnail = jSONObject.optString("miniprogramThumbnail", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("source");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                shareInfo.mShowPlatform.add(Integer.valueOf(optJSONArray.optInt(i)));
            }
        }
        return shareInfo;
    }

    @Nullable
    public static ListItem eJ(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return eK(jSONObject);
    }

    public static ListItem eK(JSONObject jSONObject) {
        ListItem listItem = new ListItem();
        listItem.mType = jSONObject.optString("type", "");
        listItem.mName = jSONObject.optString("name", "");
        listItem.mDisplayStyle = jSONObject.optString("style", "");
        listItem.mCover = jSONObject.optString("cover", "");
        listItem.mTargetKey = jSONObject.optString("targetKey", "");
        listItem.mCornerIcon = jSONObject.optString("cornerImage", "");
        listItem.mUrl = jSONObject.optString("url");
        listItem.mSummary = jSONObject.optString("summary");
        listItem.mDesc = jSONObject.optString("desc");
        JSONObject optJSONObject = jSONObject.optJSONObject(MetaBox.TYPE);
        if (optJSONObject != null) {
            listItem.mOriginalCover = optJSONObject.optString("originalCover", "");
            listItem.mIcon = optJSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, "");
            listItem.mUid = optJSONObject.optString("uid", "");
            listItem.mVideoDuration = optJSONObject.optString("duration", "");
            listItem.mPlayCount = optJSONObject.optString("playCount", "");
            listItem.mCommentCount = optJSONObject.optString("commentCount", "");
            listItem.mWidth = optJSONObject.optInt("width", 0);
            listItem.mHeight = optJSONObject.optInt("height", 0);
            listItem.mLiveCount = optJSONObject.optString("liveCount", "");
            listItem.mVideoCount = optJSONObject.optString("videoCount", "");
            listItem.mAffixIcon = optJSONObject.optString("affixIcon", "");
            listItem.mIndexName = optJSONObject.optString("indexName", "");
            listItem.mIndexName = listItem.mIndexName.toUpperCase();
            listItem.mAvatar = optJSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR, "");
            listItem.mCreater = optJSONObject.optString("creator", "");
            listItem.mSubscribeCount = optJSONObject.optString("subscriberCount", "");
            listItem.mGender = optJSONObject.optString("gender", "male");
            listItem.mLevel = optJSONObject.optInt("level", 0);
            listItem.mLevelMedal = optJSONObject.optString("levelMedal", "");
            listItem.mGloriouslyUidMedal = optJSONObject.optString("gloriouslyUidMedal");
            listItem.mGloriouslyUidColor = optJSONObject.optString("gloriouslyUidColor");
            listItem.mGloriouslyUid = optJSONObject.optString("gloriouslyUid");
            listItem.mNobleMedal = optJSONObject.optString("nobleMedal", "");
            listItem.mRoomId = optJSONObject.optString("roomId", "");
            listItem.mIsBigFans = optJSONObject.optBoolean("isBigfans", false);
            listItem.mOnlineCount = optJSONObject.optString("onlineCount", "");
            listItem.mLiveType = optJSONObject.optString("liveType", "");
            listItem.mVideoType = optJSONObject.optInt("videoType", 0);
            listItem.mDisplayTag = optJSONObject.optString("displayTag", "");
            listItem.mDisplayTagColor = optJSONObject.optString("displayTagColor", "");
            listItem.mDisplayTagBackground = optJSONObject.optString("displayTagBackground", "");
            listItem.mDisplayTagIcon = optJSONObject.optString("displayTagIcon", "");
            listItem.mDisplayTagBgWidth = h.parseFloat(optJSONObject.optString("displayTagBgWidth", ""));
            listItem.mDisplayTagBgHeight = h.parseInt(optJSONObject.optString("displayTagBgHeight", ""));
            listItem.mCity = optJSONObject.optString("city", "");
            listItem.mNickname = optJSONObject.optString("nickname", "");
            listItem.mImageCount = optJSONObject.optString("imageCount", "");
            listItem.mTotalCount = optJSONObject.optString("totalCount", "");
            listItem.mUrl = optJSONObject.optString("url", "");
            listItem.mCustomIcon = optJSONObject.optString("customIcon", "");
            listItem.mLiveState = (optJSONObject.optBoolean("live", false) || optJSONObject.optBoolean("inLive", false)) ? 1 : 0;
            listItem.mSC = optJSONObject.optString("_sc", "");
            listItem.mNotifyType = optJSONObject.optString("notifyType");
            listItem.mPlantCover = optJSONObject.optString("plantCover");
            listItem.mShowClose = optJSONObject.optBoolean("showClose");
            listItem.mAutoCloseTime = h.parseInt(optJSONObject.optString("autoCloseTime"));
            listItem.mMicGameId = optJSONObject.optInt("micGameId");
            listItem.mPackStyle = optJSONObject.optInt("packStyle", 0);
            listItem.mPackIcon = optJSONObject.optString("packIcon", "");
            listItem.mPackTip = optJSONObject.optString("packTip", "");
            listItem.mAutoDisplay = optJSONObject.optInt("autoDisplay", -1);
            listItem.mTimelineId = optJSONObject.optString("timelineId");
            listItem.mRank = h.parseInt(optJSONObject.optString("rank"));
            listItem.rewardCount = h.parseLong(optJSONObject.optString("rewardCount"));
            listItem.mHasUp = optJSONObject.optBoolean("hasUp");
            listItem.mIsSubscribed = optJSONObject.optBoolean("isSubscriber");
            listItem.mUpCount = optJSONObject.optString("upCount");
            listItem.mShareType = optJSONObject.optString("shareType");
            listItem.mShareTargetKey = optJSONObject.optString("shareTargetKey");
            listItem.hormStyle = optJSONObject.optInt("style", 0);
            listItem.hornAvatar = optJSONObject.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR, "");
            listItem.hornContent = optJSONObject.optString("content", "");
            listItem.hornFrontContent = optJSONObject.optString("frontContent", "");
            listItem.hornTimestamp = optJSONObject.optLong("timestamp", 0L);
            listItem.mBroadcastSuffixIcon = optJSONObject.optString("broadcastSuffixIcon", "");
            listItem.mLowerRightCornerIcon = optJSONObject.optString("lowerRightCornerIcon");
            if ("20".equals(listItem.mType)) {
            }
            if (PayHelper.STATUS_SUCC.equals(listItem.mType)) {
                listItem.mAdExtraInfo = new AdExtraInfo();
                listItem.mAdExtraInfo.mMarketId = optJSONObject.optString("advertSource");
                listItem.mAdExtraInfo.mCode = optJSONObject.optString("advertPositionCode", "");
                listItem.mAdExtraInfo.mClickTimes = h.parseInt(optJSONObject.optString("advertTrackTimes"));
                listItem.mAdExtraInfo.mHtmpSnippet = optJSONObject.optString("htmpSnippet");
                listItem.mAdExtraInfo.mActType = optJSONObject.optString("advertActType");
                listItem.mAdExtraInfo.mNavType = optJSONObject.optString("advertNavType");
                listItem.mAdExtraInfo.mShowType = optJSONObject.optString("advertType");
                listItem.mAdExtraInfo.mAdvertLink = optJSONObject.optString("advertLink", "");
                listItem.mAdExtraInfo.mAdvertDeepLink = optJSONObject.optString("advertDeepLink");
                listItem.mAdExtraInfo.mPgkName = optJSONObject.optString("advertPackageName");
                listItem.mAdExtraInfo.mIntervalTime = h.parseInt(optJSONObject.optString("advertIntervalSecond"));
                listItem.mAdExtraInfo.mDisplayTagLocation = h.parseInt(optJSONObject.optString("displayTagLocation", "1"));
                listItem.mAdExtraInfo.mAdvertWidth = h.parseInt(optJSONObject.optString("advertWidth"));
                listItem.mAdExtraInfo.mAdvertHeight = h.parseInt(optJSONObject.optString("advertHeight"));
                listItem.mAdExtraInfo.mAdvertSelfOpen = optJSONObject.optBoolean("advertSelfOpen");
                listItem.mAdExtraInfo.mAutoPlayAudio = optJSONObject.optBoolean("autoPlay");
                listItem.mAdExtraInfo.mAdvertAutoRefreshTimes = optJSONObject.optLong("advertAutoRefreshTimes");
                listItem.mAdExtraInfo.mAdvertMinFreshIntervalSecond = optJSONObject.optLong("advertMinFreshIntervalSecond");
                listItem.mAdExtraInfo.mAdvertMaxFreshIntervalSecond = optJSONObject.optLong("advertMaxFreshIntervalSecond");
                listItem.mAdExtraInfo.mAdvertRefreshUrl = optJSONObject.optString("advertRefreshUrl");
                listItem.mAdExtraInfo.marketPositionCode = optJSONObject.optString("marketPositionCode");
                listItem.mAdExtraInfo.vTrack = a(optJSONObject.optJSONArray("advertVTrack"));
                listItem.mAdExtraInfo.cTrack = a(optJSONObject.optJSONArray("advertCTrack"));
                listItem.mAdExtraInfo.dTrack = a(optJSONObject.optJSONArray("advertDTrack"));
                listItem.mAdExtraInfo.dlTrack = a(optJSONObject.optJSONArray("advertDFTrack"));
                listItem.mAdExtraInfo.clTrack = a(optJSONObject.optJSONArray("advertCLTrack"));
                listItem.mAdExtraInfo.eTrack = a(optJSONObject.optJSONArray("advertETrack"));
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("rightCornerIcon");
            if (optJSONArray != null) {
                listItem.mRightBottomIcons = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i);
                    if (!h.isEmpty(optString)) {
                        listItem.mRightBottomIcons.add(optString);
                    }
                }
            }
            listItem.mPkLiveIcon = optJSONObject.optString("pkLiveIcon", "");
            listItem.mMicDisplayUid = optJSONObject.optString("displayUid", "");
            listItem.mMicNeedApply = optJSONObject.optBoolean("needApply", false);
            listItem.mMicMc = optJSONObject.optString(Config.DEVICE_MAC_ID);
            if (!h.isEmpty(optJSONObject.optString("adzoneId"))) {
                listItem.mShopWindowInfo = new ShopWindowInfo();
                listItem.mShopWindowInfo.mSubPid = optJSONObject.optString("subPid");
                listItem.mShopWindowInfo.mAdzoneId = optJSONObject.optString("adzoneId");
                listItem.mShopWindowInfo.mUnioneId = optJSONObject.optString("unioneId");
            }
            listItem.mRedirectAppName = optJSONObject.optString("redirectAppName");
            listItem.borderImage = optJSONObject.optString("borderImage", "");
            listItem.remianTime = optJSONObject.optLong("remianTime", 0L);
        }
        return listItem;
    }

    public static List<AdTrackInfo> a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                AdTrackInfo adTrackInfo = new AdTrackInfo();
                adTrackInfo.mUrl = optJSONObject.optString(DownloadDataConstants.Columns.COLUMN_URI);
                adTrackInfo.mSource = h.parseInt(optJSONObject.optString("source"));
                adTrackInfo.mType = h.parseInt(optJSONObject.optString("type"));
                if (optJSONObject.has("replacement")) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("replacement");
                    adTrackInfo.mReplacements = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject2 != null) {
                            Replacement replacement = new Replacement();
                            replacement.mKeyword = optJSONObject2.optString("keyword");
                            replacement.mReplaceType = h.parseInt(optJSONObject2.optString("replaceType"));
                            replacement.mReplaceValueType = h.parseInt(optJSONObject2.optString("replaceValueType"));
                            adTrackInfo.mReplacements.add(replacement);
                        }
                    }
                }
                arrayList.add(adTrackInfo);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ArrayList<PannelItem> ac(JSONArray jSONArray) {
        JSONArray optJSONArray;
        ListItem eJ;
        ArrayList<PannelItem> arrayList = new ArrayList<>();
        if (jSONArray == null || jSONArray.length() == 0) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("navItemList")) != null && optJSONArray.length() != 0) {
                PannelItem pannelItem = new PannelItem();
                pannelItem.mDisplayName = optJSONObject.optString("name", "");
                pannelItem.mIcon = optJSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, "");
                pannelItem.mSupportRefresh = optJSONObject.optBoolean("supportRefresh", false);
                pannelItem.mPannelPos = i + 1;
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                    if (optJSONObject2 != null && (eJ = eJ(optJSONObject2)) != null && (!"12".equals(eJ.mDisplayStyle) || (!h.isEmpty(eJ.hornContent) && !h.isEmpty(eJ.hornFrontContent)))) {
                        eJ.mPannelPos = i + 1;
                        pannelItem.mNavItemList.add(eJ);
                    }
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("moreNav");
                if (optJSONObject3 != null) {
                    pannelItem.mMoreNav = eJ(optJSONObject3);
                }
                arrayList.add(pannelItem);
            }
        }
        return arrayList;
    }
}
