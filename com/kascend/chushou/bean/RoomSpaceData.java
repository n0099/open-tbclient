package com.kascend.chushou.bean;

import com.google.gson.JsonArray;
import com.kascend.chushou.c.a;
import com.kascend.chushou.constants.ListItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class RoomSpaceData {
    public Achievement achievementMedalInfo;
    public List<AvatarBean> avatarList;
    public long bangCount;
    public long fansCount;
    public long giftPointCount;
    public long idolsCount;
    public List<LikedGameBean> likedGameList;
    public List<MedalBean> medalList;
    public JsonArray recommendList;
    public RoomBean room;
    public List<UserData> roomGiftBillboardList;
    public SkinBean skinInfo;
    public UserBean user;
    public boolean isOnline = false;
    public boolean isSubscribed = false;
    public String liveType = "1";
    public List<String> hiddenList = new ArrayList();

    /* loaded from: classes6.dex */
    public static class AvatarBean {
        public String avatar;
        public String id;
        public String state;
        public String uid;
    }

    /* loaded from: classes6.dex */
    public static class LikedGameBean {
        public String icon;
        public String id;
        public String name;
        public String targetKey;
    }

    /* loaded from: classes6.dex */
    public static class LiveGameBean {
        public boolean gameNameRequired;
        public String id;
        public String name;
        public String poster;
    }

    /* loaded from: classes6.dex */
    public static class LiveStatus {
        public LiveGameBean game;
        public String liveSourceId;
        public LiveTag liveTag;
        public String liveTimeDesc;
        public String modelName;
        public String name;
        public long onlineCount;
        public String roomId;
        public String screenshot;
        public int style;
    }

    /* loaded from: classes6.dex */
    public static class LiveTag {
        public String name;
    }

    /* loaded from: classes6.dex */
    public static class MedalBean {
        public String introductionUrl;
        public String url;
    }

    /* loaded from: classes6.dex */
    public static class RoomBean {
        public String announcement;
        public UserBean creator;
        public String id;
        public long lastLiveTime;
        public String lastLiveTimeDesc;
        public LiveStatus liveStatus;
        public String logo;
        public String name;
        public String shareUrl;
        public long subscriberCount;
    }

    /* loaded from: classes6.dex */
    public static class SkinBean {
        public String background;
        public String homeBackground;
        public String lastLiveTimeBtnBg;
        public String subscribeBtnBg;
        public String subscribedBtnBg;
    }

    /* loaded from: classes6.dex */
    public static class UserData {
        public String point;
        public String uid;
        public UserBean user;
    }

    public List<ListItem> parseRecommendList() {
        ListItem dY;
        ArrayList arrayList = new ArrayList();
        if (this.recommendList != null && this.recommendList.size() > 0) {
            try {
                JSONArray jSONArray = new JSONArray(this.recommendList.toString());
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null && (dY = a.dY(optJSONObject)) != null) {
                        arrayList.add(dY);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }
}
