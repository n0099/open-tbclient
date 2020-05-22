package com.kascend.chushou.bean;

import java.util.List;
import kotlin.h;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes5.dex */
public final class UserCard {
    private final Family family;
    private final String managerLevel;
    private final UserCardInfo userCardInfo;

    public static /* synthetic */ UserCard copy$default(UserCard userCard, String str, Family family, UserCardInfo userCardInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userCard.managerLevel;
        }
        if ((i & 2) != 0) {
            family = userCard.family;
        }
        if ((i & 4) != 0) {
            userCardInfo = userCard.userCardInfo;
        }
        return userCard.copy(str, family, userCardInfo);
    }

    public final String component1() {
        return this.managerLevel;
    }

    public final Family component2() {
        return this.family;
    }

    public final UserCardInfo component3() {
        return this.userCardInfo;
    }

    public final UserCard copy(String str, Family family, UserCardInfo userCardInfo) {
        return new UserCard(str, family, userCardInfo);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof UserCard) {
                UserCard userCard = (UserCard) obj;
                if (!q.l((Object) this.managerLevel, (Object) userCard.managerLevel) || !q.l(this.family, userCard.family) || !q.l(this.userCardInfo, userCard.userCardInfo)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.managerLevel;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Family family = this.family;
        int hashCode2 = ((family != null ? family.hashCode() : 0) + hashCode) * 31;
        UserCardInfo userCardInfo = this.userCardInfo;
        return hashCode2 + (userCardInfo != null ? userCardInfo.hashCode() : 0);
    }

    public String toString() {
        return "UserCard(managerLevel=" + this.managerLevel + ", family=" + this.family + ", userCardInfo=" + this.userCardInfo + ")";
    }

    public UserCard(String str, Family family, UserCardInfo userCardInfo) {
        this.managerLevel = str;
        this.family = family;
        this.userCardInfo = userCardInfo;
    }

    public final String getManagerLevel() {
        return this.managerLevel;
    }

    public final Family getFamily() {
        return this.family;
    }

    public final UserCardInfo getUserCardInfo() {
        return this.userCardInfo;
    }

    @h
    /* loaded from: classes5.dex */
    public static final class Family {
        private final String customCard;
        private final String icon;
        private final int id;
        private final String name;

        public static /* synthetic */ Family copy$default(Family family, String str, String str2, int i, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = family.customCard;
            }
            if ((i2 & 2) != 0) {
                str2 = family.icon;
            }
            if ((i2 & 4) != 0) {
                i = family.id;
            }
            if ((i2 & 8) != 0) {
                str3 = family.name;
            }
            return family.copy(str, str2, i, str3);
        }

        public final String component1() {
            return this.customCard;
        }

        public final String component2() {
            return this.icon;
        }

        public final int component3() {
            return this.id;
        }

        public final String component4() {
            return this.name;
        }

        public final Family copy(String str, String str2, int i, String str3) {
            return new Family(str, str2, i, str3);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (!(obj instanceof Family)) {
                    return false;
                }
                Family family = (Family) obj;
                if (!q.l((Object) this.customCard, (Object) family.customCard) || !q.l((Object) this.icon, (Object) family.icon)) {
                    return false;
                }
                if (!(this.id == family.id) || !q.l((Object) this.name, (Object) family.name)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            String str = this.customCard;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.icon;
            int hashCode2 = ((((str2 != null ? str2.hashCode() : 0) + hashCode) * 31) + this.id) * 31;
            String str3 = this.name;
            return hashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "Family(customCard=" + this.customCard + ", icon=" + this.icon + ", id=" + this.id + ", name=" + this.name + ")";
        }

        public Family(String str, String str2, int i, String str3) {
            this.customCard = str;
            this.icon = str2;
            this.id = i;
            this.name = str3;
        }

        public final String getCustomCard() {
            return this.customCard;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final int getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }
    }

    @h
    /* loaded from: classes5.dex */
    public static final class UserCardInfo {
        private final String avatar;
        private final String gender;
        private final String gloriouslyUid;
        private final String gloriouslyUidColor;
        private final String gloriouslyUidMedal;
        private final int level;
        private final String levelMedal;
        private final UserCardMeta meta;
        private final String nickname;
        private final int professional;
        private final String signature;
        private final String uid;

        public final String component1() {
            return this.avatar;
        }

        public final String component10() {
            return this.gloriouslyUid;
        }

        public final String component11() {
            return this.gloriouslyUidColor;
        }

        public final String component12() {
            return this.gloriouslyUidMedal;
        }

        public final String component2() {
            return this.gender;
        }

        public final int component3() {
            return this.level;
        }

        public final String component4() {
            return this.levelMedal;
        }

        public final UserCardMeta component5() {
            return this.meta;
        }

        public final String component6() {
            return this.nickname;
        }

        public final int component7() {
            return this.professional;
        }

        public final String component8() {
            return this.signature;
        }

        public final String component9() {
            return this.uid;
        }

        public final UserCardInfo copy(String str, String str2, int i, String str3, UserCardMeta userCardMeta, String str4, int i2, String str5, String str6, String str7, String str8, String str9) {
            return new UserCardInfo(str, str2, i, str3, userCardMeta, str4, i2, str5, str6, str7, str8, str9);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (!(obj instanceof UserCardInfo)) {
                    return false;
                }
                UserCardInfo userCardInfo = (UserCardInfo) obj;
                if (!q.l((Object) this.avatar, (Object) userCardInfo.avatar) || !q.l((Object) this.gender, (Object) userCardInfo.gender)) {
                    return false;
                }
                if (!(this.level == userCardInfo.level) || !q.l((Object) this.levelMedal, (Object) userCardInfo.levelMedal) || !q.l(this.meta, userCardInfo.meta) || !q.l((Object) this.nickname, (Object) userCardInfo.nickname)) {
                    return false;
                }
                if (!(this.professional == userCardInfo.professional) || !q.l((Object) this.signature, (Object) userCardInfo.signature) || !q.l((Object) this.uid, (Object) userCardInfo.uid) || !q.l((Object) this.gloriouslyUid, (Object) userCardInfo.gloriouslyUid) || !q.l((Object) this.gloriouslyUidColor, (Object) userCardInfo.gloriouslyUidColor) || !q.l((Object) this.gloriouslyUidMedal, (Object) userCardInfo.gloriouslyUidMedal)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            String str = this.avatar;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.gender;
            int hashCode2 = ((((str2 != null ? str2.hashCode() : 0) + hashCode) * 31) + this.level) * 31;
            String str3 = this.levelMedal;
            int hashCode3 = ((str3 != null ? str3.hashCode() : 0) + hashCode2) * 31;
            UserCardMeta userCardMeta = this.meta;
            int hashCode4 = ((userCardMeta != null ? userCardMeta.hashCode() : 0) + hashCode3) * 31;
            String str4 = this.nickname;
            int hashCode5 = ((((str4 != null ? str4.hashCode() : 0) + hashCode4) * 31) + this.professional) * 31;
            String str5 = this.signature;
            int hashCode6 = ((str5 != null ? str5.hashCode() : 0) + hashCode5) * 31;
            String str6 = this.uid;
            int hashCode7 = ((str6 != null ? str6.hashCode() : 0) + hashCode6) * 31;
            String str7 = this.gloriouslyUid;
            int hashCode8 = ((str7 != null ? str7.hashCode() : 0) + hashCode7) * 31;
            String str8 = this.gloriouslyUidColor;
            int hashCode9 = ((str8 != null ? str8.hashCode() : 0) + hashCode8) * 31;
            String str9 = this.gloriouslyUidMedal;
            return hashCode9 + (str9 != null ? str9.hashCode() : 0);
        }

        public String toString() {
            return "UserCardInfo(avatar=" + this.avatar + ", gender=" + this.gender + ", level=" + this.level + ", levelMedal=" + this.levelMedal + ", meta=" + this.meta + ", nickname=" + this.nickname + ", professional=" + this.professional + ", signature=" + this.signature + ", uid=" + this.uid + ", gloriouslyUid=" + this.gloriouslyUid + ", gloriouslyUidColor=" + this.gloriouslyUidColor + ", gloriouslyUidMedal=" + this.gloriouslyUidMedal + ")";
        }

        public UserCardInfo(String str, String str2, int i, String str3, UserCardMeta userCardMeta, String str4, int i2, String str5, String str6, String str7, String str8, String str9) {
            this.avatar = str;
            this.gender = str2;
            this.level = i;
            this.levelMedal = str3;
            this.meta = userCardMeta;
            this.nickname = str4;
            this.professional = i2;
            this.signature = str5;
            this.uid = str6;
            this.gloriouslyUid = str7;
            this.gloriouslyUidColor = str8;
            this.gloriouslyUidMedal = str9;
        }

        public final String getAvatar() {
            return this.avatar;
        }

        public final String getGender() {
            return this.gender;
        }

        public final int getLevel() {
            return this.level;
        }

        public final String getLevelMedal() {
            return this.levelMedal;
        }

        public final UserCardMeta getMeta() {
            return this.meta;
        }

        public final String getNickname() {
            return this.nickname;
        }

        public final int getProfessional() {
            return this.professional;
        }

        public final String getSignature() {
            return this.signature;
        }

        public final String getUid() {
            return this.uid;
        }

        public final String getGloriouslyUid() {
            return this.gloriouslyUid;
        }

        public final String getGloriouslyUidColor() {
            return this.gloriouslyUidColor;
        }

        public final String getGloriouslyUidMedal() {
            return this.gloriouslyUidMedal;
        }
    }

    @h
    /* loaded from: classes5.dex */
    public static final class UserCardMeta {
        private final int bangCount;
        private final List<String> cardFrame;
        private final String cardHeadBackground;
        private final long fansCount;
        private final long giftPointCount;
        private final List<String> hiddenList;
        private final long idolsCount;
        private final boolean isBanned;
        private final boolean isSDKUser;
        private boolean isSubscribed;
        private final String managerLevel;
        private final List<Medal> medalList;
        private final String nobleMedal;
        private final boolean professional;
        private final int roomId;
        private final boolean silent;
        private final int timelineCount;

        public final int component1() {
            return this.bangCount;
        }

        public final String component10() {
            return this.managerLevel;
        }

        public final List<Medal> component11() {
            return this.medalList;
        }

        public final String component12() {
            return this.nobleMedal;
        }

        public final boolean component13() {
            return this.professional;
        }

        public final int component14() {
            return this.roomId;
        }

        public final boolean component15() {
            return this.silent;
        }

        public final int component16() {
            return this.timelineCount;
        }

        public final boolean component17() {
            return this.isSDKUser;
        }

        public final List<String> component2() {
            return this.cardFrame;
        }

        public final String component3() {
            return this.cardHeadBackground;
        }

        public final long component4() {
            return this.fansCount;
        }

        public final long component5() {
            return this.giftPointCount;
        }

        public final List<String> component6() {
            return this.hiddenList;
        }

        public final long component7() {
            return this.idolsCount;
        }

        public final boolean component8() {
            return this.isBanned;
        }

        public final boolean component9() {
            return this.isSubscribed;
        }

        public final UserCardMeta copy(int i, List<String> list, String str, long j, long j2, List<String> list2, long j3, boolean z, boolean z2, String str2, List<Medal> list3, String str3, boolean z3, int i2, boolean z4, int i3, boolean z5) {
            return new UserCardMeta(i, list, str, j, j2, list2, j3, z, z2, str2, list3, str3, z3, i2, z4, i3, z5);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (!(obj instanceof UserCardMeta)) {
                    return false;
                }
                UserCardMeta userCardMeta = (UserCardMeta) obj;
                if (!(this.bangCount == userCardMeta.bangCount) || !q.l(this.cardFrame, userCardMeta.cardFrame) || !q.l((Object) this.cardHeadBackground, (Object) userCardMeta.cardHeadBackground)) {
                    return false;
                }
                if (!(this.fansCount == userCardMeta.fansCount)) {
                    return false;
                }
                if (!(this.giftPointCount == userCardMeta.giftPointCount) || !q.l(this.hiddenList, userCardMeta.hiddenList)) {
                    return false;
                }
                if (!(this.idolsCount == userCardMeta.idolsCount)) {
                    return false;
                }
                if (!(this.isBanned == userCardMeta.isBanned)) {
                    return false;
                }
                if (!(this.isSubscribed == userCardMeta.isSubscribed) || !q.l((Object) this.managerLevel, (Object) userCardMeta.managerLevel) || !q.l(this.medalList, userCardMeta.medalList) || !q.l((Object) this.nobleMedal, (Object) userCardMeta.nobleMedal)) {
                    return false;
                }
                if (!(this.professional == userCardMeta.professional)) {
                    return false;
                }
                if (!(this.roomId == userCardMeta.roomId)) {
                    return false;
                }
                if (!(this.silent == userCardMeta.silent)) {
                    return false;
                }
                if (!(this.timelineCount == userCardMeta.timelineCount)) {
                    return false;
                }
                if (!(this.isSDKUser == userCardMeta.isSDKUser)) {
                    return false;
                }
            }
            return true;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v19, resolved type: boolean */
        /* JADX DEBUG: Multi-variable search result rejected for r0v22, resolved type: boolean */
        /* JADX DEBUG: Multi-variable search result rejected for r0v35, resolved type: boolean */
        /* JADX DEBUG: Multi-variable search result rejected for r0v40, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i = this.bangCount * 31;
            List<String> list = this.cardFrame;
            int hashCode = ((list != null ? list.hashCode() : 0) + i) * 31;
            String str = this.cardHeadBackground;
            int hashCode2 = str != null ? str.hashCode() : 0;
            long j = this.fansCount;
            long j2 = this.giftPointCount;
            int i2 = (((((hashCode2 + hashCode) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            List<String> list2 = this.hiddenList;
            int hashCode3 = list2 != null ? list2.hashCode() : 0;
            long j3 = this.idolsCount;
            int i3 = (((hashCode3 + i2) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            boolean z = this.isBanned;
            int i4 = z;
            if (z != 0) {
                i4 = 1;
            }
            int i5 = (i4 + i3) * 31;
            boolean z2 = this.isSubscribed;
            int i6 = z2;
            if (z2 != 0) {
                i6 = 1;
            }
            int i7 = (i6 + i5) * 31;
            String str2 = this.managerLevel;
            int hashCode4 = ((str2 != null ? str2.hashCode() : 0) + i7) * 31;
            List<Medal> list3 = this.medalList;
            int hashCode5 = ((list3 != null ? list3.hashCode() : 0) + hashCode4) * 31;
            String str3 = this.nobleMedal;
            int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
            boolean z3 = this.professional;
            int i8 = z3;
            if (z3 != 0) {
                i8 = 1;
            }
            int i9 = (((i8 + hashCode6) * 31) + this.roomId) * 31;
            boolean z4 = this.silent;
            int i10 = z4;
            if (z4 != 0) {
                i10 = 1;
            }
            int i11 = (((i10 + i9) * 31) + this.timelineCount) * 31;
            boolean z5 = this.isSDKUser;
            return i11 + (z5 ? 1 : z5 ? 1 : 0);
        }

        public String toString() {
            return "UserCardMeta(bangCount=" + this.bangCount + ", cardFrame=" + this.cardFrame + ", cardHeadBackground=" + this.cardHeadBackground + ", fansCount=" + this.fansCount + ", giftPointCount=" + this.giftPointCount + ", hiddenList=" + this.hiddenList + ", idolsCount=" + this.idolsCount + ", isBanned=" + this.isBanned + ", isSubscribed=" + this.isSubscribed + ", managerLevel=" + this.managerLevel + ", medalList=" + this.medalList + ", nobleMedal=" + this.nobleMedal + ", professional=" + this.professional + ", roomId=" + this.roomId + ", silent=" + this.silent + ", timelineCount=" + this.timelineCount + ", isSDKUser=" + this.isSDKUser + ")";
        }

        public UserCardMeta(int i, List<String> list, String str, long j, long j2, List<String> list2, long j3, boolean z, boolean z2, String str2, List<Medal> list3, String str3, boolean z3, int i2, boolean z4, int i3, boolean z5) {
            this.bangCount = i;
            this.cardFrame = list;
            this.cardHeadBackground = str;
            this.fansCount = j;
            this.giftPointCount = j2;
            this.hiddenList = list2;
            this.idolsCount = j3;
            this.isBanned = z;
            this.isSubscribed = z2;
            this.managerLevel = str2;
            this.medalList = list3;
            this.nobleMedal = str3;
            this.professional = z3;
            this.roomId = i2;
            this.silent = z4;
            this.timelineCount = i3;
            this.isSDKUser = z5;
        }

        public final int getBangCount() {
            return this.bangCount;
        }

        public final List<String> getCardFrame() {
            return this.cardFrame;
        }

        public final String getCardHeadBackground() {
            return this.cardHeadBackground;
        }

        public final long getFansCount() {
            return this.fansCount;
        }

        public final long getGiftPointCount() {
            return this.giftPointCount;
        }

        public final List<String> getHiddenList() {
            return this.hiddenList;
        }

        public final long getIdolsCount() {
            return this.idolsCount;
        }

        public final boolean isBanned() {
            return this.isBanned;
        }

        public final boolean isSubscribed() {
            return this.isSubscribed;
        }

        public final void setSubscribed(boolean z) {
            this.isSubscribed = z;
        }

        public final String getManagerLevel() {
            return this.managerLevel;
        }

        public final List<Medal> getMedalList() {
            return this.medalList;
        }

        public final String getNobleMedal() {
            return this.nobleMedal;
        }

        public final boolean getProfessional() {
            return this.professional;
        }

        public final int getRoomId() {
            return this.roomId;
        }

        public final boolean getSilent() {
            return this.silent;
        }

        public final int getTimelineCount() {
            return this.timelineCount;
        }

        public /* synthetic */ UserCardMeta(int i, List list, String str, long j, long j2, List list2, long j3, boolean z, boolean z2, String str2, List list3, String str3, boolean z3, int i2, boolean z4, int i3, boolean z5, int i4, o oVar) {
            this(i, list, str, j, j2, list2, j3, z, z2, str2, list3, str3, z3, i2, z4, i3, (65536 & i4) != 0 ? true : z5);
        }

        public final boolean isSDKUser() {
            return this.isSDKUser;
        }
    }

    @h
    /* loaded from: classes5.dex */
    public static final class Medal {
        private final String introductionUrl;
        private final String url;

        public static /* synthetic */ Medal copy$default(Medal medal, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = medal.url;
            }
            if ((i & 2) != 0) {
                str2 = medal.introductionUrl;
            }
            return medal.copy(str, str2);
        }

        public final String component1() {
            return this.url;
        }

        public final String component2() {
            return this.introductionUrl;
        }

        public final Medal copy(String str, String str2) {
            return new Medal(str, str2);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof Medal) {
                    Medal medal = (Medal) obj;
                    if (!q.l((Object) this.url, (Object) medal.url) || !q.l((Object) this.introductionUrl, (Object) medal.introductionUrl)) {
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            String str = this.url;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.introductionUrl;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Medal(url=" + this.url + ", introductionUrl=" + this.introductionUrl + ")";
        }

        public Medal(String str, String str2) {
            this.url = str;
            this.introductionUrl = str2;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getIntroductionUrl() {
            return this.introductionUrl;
        }
    }
}
