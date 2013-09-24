package com.tencent.mm.sdk.contact;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoDBItem;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class RContact extends MAutoDBItem {
    public static final String[] COLUMNS;
    public static final String COL_ALIAS = "alias";
    public static final String COL_CONREMARK = "conRemark";
    public static final String COL_CONREMARK_PYFULL = "conRemarkPYFull";
    public static final String COL_CONREMARK_PYSHORT = "conRemarkPYShort";
    public static final String COL_DOMAINLIST = "domainList";
    public static final int COL_ID_INVALID_VALUE = -1;
    public static final String COL_NICKNAME = "nickname";
    public static final String COL_PYINITIAL = "pyInitial";
    public static final String COL_QUANPIN = "quanPin";
    public static final String COL_SHOWHEAD = "showHead";
    public static final String COL_TYPE = "type";
    public static final String COL_USERNAME = "username";
    public static final String COL_VERIFY_FLAG = "verifyFlag";
    public static final String COL_WEIBOFLAG = "weiboFlag";
    public static final String COL_WEIBONICKNAME = "weiboNickname";
    public static final int DEL_CONTACT_MSG = -1;
    public static final String FAVOUR_CONTACT_SHOW_HEAD_CHAR = "$";
    public static final int FAVOUR_CONTACT_SHOW_HEAD_CODE = 32;
    private static Map<String, String> M = null;
    public static final int MM_CONTACTFLAG_ALL = 127;
    public static final int MM_CONTACTFLAG_BLACKLISTCONTACT = 8;
    public static final int MM_CONTACTFLAG_CHATCONTACT = 2;
    public static final int MM_CONTACTFLAG_CHATROOMCONTACT = 4;
    public static final int MM_CONTACTFLAG_CONTACT = 1;
    public static final int MM_CONTACTFLAG_DOMAINCONTACT = 16;
    public static final int MM_CONTACTFLAG_FAVOURCONTACT = 64;
    public static final int MM_CONTACTFLAG_HIDECONTACT = 32;
    public static final int MM_CONTACTFLAG_NULL = 0;
    public static final int MM_CONTACTIMGFLAG_HAS_HEADIMG = 3;
    public static final int MM_CONTACTIMGFLAG_HAS_NO_HEADIMG = 4;
    public static final int MM_CONTACTIMGFLAG_LOCAL_EXIST = 153;
    public static final int MM_CONTACTIMGFLAG_MODIFY = 2;
    public static final int MM_CONTACTIMGFLAG_NOTMODIFY = 1;
    public static final int MM_CONTACT_BOTTLE = 5;
    public static final int MM_CONTACT_CHATROOM = 2;
    public static final int MM_CONTACT_EMAIL = 3;
    public static final int MM_CONTACT_QQ = 4;
    public static final int MM_CONTACT_QQMICROBLOG = 1;
    public static final int MM_CONTACT_WEIXIN = 0;
    public static final int MM_SEX_FEMALE = 2;
    public static final int MM_SEX_MALE = 1;
    public static final int MM_SEX_UNKNOWN = 0;
    private static Map<String, String> N;
    public static final int NOT_IN_CHAT_LIST = 0;
    protected static Field[] p;
    private String A;
    private int B;
    private int C;
    private String D;
    private String E;
    private String F;
    private String G;
    private int H;
    private int I;
    private String J;
    private String K;
    private String L;
    public long contactId;
    public String field_alias;
    public String field_conRemark;
    public String field_conRemarkPYFull;
    public String field_conRemarkPYShort;
    public String field_domainList;
    public byte[] field_lvbuff;
    public String field_nickname;
    public String field_pyInitial;
    public String field_quanPin;
    public int field_showHead;
    public int field_type;
    public String field_username;
    public int field_verifyFlag;
    public int field_weiboFlag;
    public String field_weiboNickname;
    private int h;
    private int q;
    private int r;
    private String s;
    private long u;
    private String v;
    private String w;
    private int x;
    private int y;
    private String z;

    static {
        Field[] validFields = MAutoDBItem.getValidFields(RContact.class);
        p = validFields;
        COLUMNS = MAutoDBItem.getFullColumns(validFields);
        M = new HashMap();
        N = new HashMap();
    }

    public RContact() {
        reset();
    }

    public RContact(String str) {
        this();
        this.field_username = str == null ? "" : str;
    }

    private byte[] a() {
        try {
            LVBuffer lVBuffer = new LVBuffer();
            lVBuffer.initBuild();
            lVBuffer.putInt(this.q);
            lVBuffer.putInt(this.r);
            lVBuffer.putString(this.s);
            lVBuffer.putLong(this.u);
            lVBuffer.putInt(this.h);
            lVBuffer.putString(this.v);
            lVBuffer.putString(this.w);
            lVBuffer.putInt(this.x);
            lVBuffer.putInt(this.y);
            lVBuffer.putString(this.z);
            lVBuffer.putString(this.A);
            lVBuffer.putInt(this.B);
            lVBuffer.putInt(this.C);
            lVBuffer.putString(this.D);
            lVBuffer.putString(this.E);
            lVBuffer.putString(this.F);
            lVBuffer.putString(this.G);
            lVBuffer.putInt(this.H);
            lVBuffer.putInt(this.I);
            lVBuffer.putString(this.J);
            lVBuffer.putInt(this.field_verifyFlag);
            lVBuffer.putString(this.K);
            lVBuffer.putString(this.L);
            return lVBuffer.buildFinish();
        } catch (Exception e) {
            Log.e("MicroMsg.Contact", "get value failed");
            e.printStackTrace();
            return null;
        }
    }

    public static String formatDisplayNick(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase().endsWith("@t.qq.com") ? "@" + str.replace("@t.qq.com", "") : str.toLowerCase().endsWith("@qqim") ? str.replace("@qqim", "") : str;
    }

    public static int getBlackListContactBit() {
        return 8;
    }

    public static int getContactBit() {
        return 1;
    }

    public static int getDomainContactBit() {
        return 16;
    }

    public static int getHiddenContactBit() {
        return 32;
    }

    public static boolean isContact(int i) {
        return (i & 1) != 0;
    }

    private static boolean isLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    public static void setHardCodeAliasMaps(Map<String, String> map) {
        N = map;
    }

    public static void setHardCodeNickMaps(Map<String, String> map) {
        M = map;
    }

    public int calculateShowHead() {
        char c = ' ';
        if (this.field_conRemarkPYShort != null && !this.field_conRemarkPYShort.equals("")) {
            c = this.field_conRemarkPYShort.charAt(0);
        } else if (this.field_conRemarkPYFull != null && !this.field_conRemarkPYFull.equals("")) {
            c = this.field_conRemarkPYFull.charAt(0);
        } else if (this.field_pyInitial != null && !this.field_pyInitial.equals("")) {
            c = this.field_pyInitial.charAt(0);
        } else if (this.field_quanPin != null && !this.field_quanPin.equals("")) {
            c = this.field_quanPin.charAt(0);
        } else if (this.field_nickname != null && !this.field_nickname.equals("") && isLetter(this.field_nickname.charAt(0))) {
            c = this.field_nickname.charAt(0);
        } else if (this.field_username != null && !this.field_username.equals("") && isLetter(this.field_username.charAt(0))) {
            c = this.field_username.charAt(0);
        }
        if (c < 'a' || c > 'z') {
            if (c < 'A' || c > 'Z') {
                return 123;
            }
            return c;
        }
        return (char) (c - ' ');
    }

    @Override // com.tencent.mm.sdk.storage.MAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        super.convertFrom(cursor);
        this.contactId = (int) cursor.getLong(cursor.getColumnCount() - 1);
        byte[] bArr = this.field_lvbuff;
        try {
            LVBuffer lVBuffer = new LVBuffer();
            int initParse = lVBuffer.initParse(bArr);
            if (initParse != 0) {
                Log.e("MicroMsg.Contact", "parse LVBuffer error:" + initParse);
            } else {
                this.q = lVBuffer.getInt();
                this.r = lVBuffer.getInt();
                this.s = lVBuffer.getString();
                this.u = lVBuffer.getLong();
                this.h = lVBuffer.getInt();
                this.v = lVBuffer.getString();
                this.w = lVBuffer.getString();
                this.x = lVBuffer.getInt();
                this.y = lVBuffer.getInt();
                this.z = lVBuffer.getString();
                this.A = lVBuffer.getString();
                this.B = lVBuffer.getInt();
                this.C = lVBuffer.getInt();
                this.D = lVBuffer.getString();
                this.E = lVBuffer.getString();
                this.F = lVBuffer.getString();
                this.G = lVBuffer.getString();
                this.H = lVBuffer.getInt();
                this.I = lVBuffer.getInt();
                this.J = lVBuffer.getString();
                this.field_verifyFlag = lVBuffer.getInt();
                this.K = lVBuffer.getString();
                if (!lVBuffer.checkGetFinish()) {
                    this.L = lVBuffer.getString();
                }
            }
        } catch (Exception e) {
            Log.e("MicroMsg.Contact", "get value failed");
            e.printStackTrace();
        }
    }

    @Override // com.tencent.mm.sdk.storage.MAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        this.field_lvbuff = a();
        return super.convertTo();
    }

    @Override // com.tencent.mm.sdk.storage.MAutoDBItem
    public Field[] fields() {
        return p;
    }

    public String getAlias() {
        String str = N.get(this.field_username);
        return str == null ? this.field_alias : str;
    }

    public int getChatroomNotify() {
        return this.B;
    }

    public String getCity() {
        return this.F;
    }

    public String getConQQMBlog() {
        return this.A;
    }

    public String getConRemark() {
        return this.field_conRemark;
    }

    public String getConRemarkPYFull() {
        return this.field_conRemarkPYFull;
    }

    public String getConRemarkPYShort() {
        return this.field_conRemarkPYShort;
    }

    public String getConSMBlog() {
        return this.z;
    }

    public int getConType() {
        return this.y;
    }

    public int getContactID() {
        return (int) this.contactId;
    }

    public String getDisplayNick() {
        String str = M.get(this.field_username);
        return str != null ? str : (this.field_nickname == null || this.field_nickname.length() <= 0) ? getDisplayUser() : this.field_nickname;
    }

    public String getDisplayRemark() {
        return (this.field_conRemark == null || this.field_conRemark.trim().equals("")) ? getDisplayNick() : this.field_conRemark;
    }

    public String getDisplayUser() {
        String alias = getAlias();
        if (Util.isNullOrNil(alias)) {
            String formatDisplayNick = formatDisplayNick(this.field_username);
            return (formatDisplayNick == null || formatDisplayNick.length() == 0) ? this.field_username : formatDisplayNick;
        }
        return alias;
    }

    public String getDistance() {
        return this.G;
    }

    public String getDomainList() {
        return this.field_domainList;
    }

    public String getEmail() {
        return this.v;
    }

    public long getFaceBookId() {
        return this.u;
    }

    public String getFaceBookUsername() {
        return this.s;
    }

    public int getFromType() {
        return this.H;
    }

    public int getImgFlag() {
        return this.q;
    }

    public String getMobile() {
        return this.w;
    }

    public String getNickname() {
        return this.field_nickname;
    }

    public int getPersonalCard() {
        return this.C;
    }

    public String getProvince() {
        return this.E;
    }

    public String getPyInitial() {
        return (this.field_pyInitial == null || this.field_pyInitial.length() < 0) ? getQuanPin() : this.field_pyInitial;
    }

    public String getQuanPin() {
        return (this.field_quanPin == null || this.field_quanPin.length() < 0) ? getNickname() : this.field_quanPin;
    }

    public String getRegionCode() {
        return this.L;
    }

    public int getSex() {
        return this.r;
    }

    public int getShowFlag() {
        return this.x;
    }

    public int getShowHead() {
        return this.field_showHead;
    }

    public String getSignature() {
        return this.D;
    }

    public int getSource() {
        return this.I;
    }

    public int getType() {
        return this.field_type;
    }

    public int getUin() {
        return this.h;
    }

    public String getUsername() {
        return this.field_username;
    }

    public int getVerifyFlag() {
        return this.field_verifyFlag;
    }

    public String getVerifyInfo() {
        return this.K;
    }

    public String getWeibo() {
        return this.J;
    }

    public int getWeiboFlag() {
        return this.field_weiboFlag;
    }

    public String getWeiboNickName() {
        return this.field_weiboNickname;
    }

    public boolean isBlackListContact() {
        return (this.field_type & 8) != 0;
    }

    public boolean isChatContact() {
        return (this.field_type & 2) != 0;
    }

    public boolean isChatRoomContact() {
        return (this.field_type & 4) != 0;
    }

    public boolean isContact() {
        return isContact(this.field_type);
    }

    public boolean isDomainContact() {
        return (this.field_type & 16) != 0;
    }

    public boolean isFavourContact() {
        return (this.field_type & 64) != 0;
    }

    public boolean isHidden() {
        return (this.field_type & 32) != 0;
    }

    public boolean isImgLocalExist() {
        return 153 == this.q;
    }

    public void reset() {
        this.field_username = "";
        this.field_nickname = "";
        this.field_pyInitial = "";
        this.field_quanPin = "";
        this.field_alias = "";
        this.field_conRemark = "";
        this.field_conRemarkPYShort = "";
        this.field_conRemarkPYFull = "";
        this.field_domainList = "";
        this.field_weiboFlag = 0;
        this.field_weiboNickname = "";
        this.field_showHead = 0;
        this.field_type = 0;
        this.field_verifyFlag = 0;
        this.r = 0;
        this.G = "";
        this.H = 0;
        this.h = 0;
        this.v = "";
        this.w = "";
        this.x = 0;
        this.y = 0;
        this.z = "";
        this.A = "";
        this.B = 1;
        this.q = 0;
        this.C = 0;
        this.D = "";
        this.E = "";
        this.F = "";
        this.I = 0;
        this.K = "";
        this.J = "";
        this.u = 0L;
        this.s = "";
        this.L = "";
    }

    public void setAlias(String str) {
        this.field_alias = str;
    }

    public void setBlackList() {
        this.field_type |= 8;
    }

    public void setChatContact() {
        this.field_type |= 2;
    }

    public void setChatroomContact() {
        this.field_type |= 4;
    }

    public void setChatroomNotify(int i) {
        this.B = i;
    }

    public void setCity(String str) {
        this.F = str;
    }

    public void setConQQMBlog(String str) {
        this.A = str;
    }

    public void setConRemark(String str) {
        this.field_conRemark = str;
    }

    public void setConRemarkPYFull(String str) {
        this.field_conRemarkPYFull = str;
    }

    public void setConRemarkPYShort(String str) {
        this.field_conRemarkPYShort = str;
    }

    public void setConSMBlog(String str) {
        this.z = str;
    }

    public void setConType(int i) {
        this.y = i;
    }

    public void setContact() {
        this.field_type |= 1;
    }

    public void setDistance(String str) {
        this.G = str;
    }

    public void setDomainList(String str) {
        this.field_domainList = str;
    }

    public void setEmail(String str) {
        this.v = str;
    }

    public void setFaceBookId(long j) {
        this.u = j;
    }

    public void setFaceBookUsername(String str) {
        this.s = str;
    }

    public void setFavour() {
        this.field_type |= 64;
    }

    public void setFromType(int i) {
        this.H = i;
    }

    public void setHidden() {
        this.field_type |= 32;
    }

    public void setImgFlag(int i) {
        this.q = i;
    }

    public void setMobile(String str) {
        this.w = str;
    }

    public void setNickname(String str) {
        this.field_nickname = str;
    }

    public void setNullContact() {
        this.field_type = 0;
    }

    public void setPersonalCard(int i) {
        this.C = i;
    }

    public void setProvince(String str) {
        this.E = str;
    }

    public void setPyInitial(String str) {
        this.field_pyInitial = str;
    }

    public void setQuanPin(String str) {
        this.field_quanPin = str;
    }

    public void setRegionCode(String str) {
        this.L = str;
    }

    public void setSex(int i) {
        this.r = i;
    }

    public void setShowFlag(int i) {
        this.x = i;
    }

    public void setShowHead(int i) {
        this.field_showHead = i;
    }

    public void setSignature(String str) {
        this.D = str;
    }

    public void setSource(int i) {
        this.I = i;
    }

    public void setType(int i) {
        this.field_type = i;
    }

    public void setUin(int i) {
        this.h = i;
    }

    public void setUsername(String str) {
        this.field_username = str;
    }

    public void setVerifyFlag(int i) {
        this.field_verifyFlag = i;
    }

    public void setVerifyInfo(String str) {
        this.K = str;
    }

    public void setWeibo(String str) {
        this.J = str;
    }

    public void setWeiboFlag(int i) {
        this.field_weiboFlag = i;
    }

    public void setWeiboNickName(String str) {
        this.field_weiboNickname = str;
    }

    public void unSetBlackList() {
        this.field_type &= -9;
    }

    public void unSetChatContact() {
        this.field_type &= -3;
    }

    public void unSetContact() {
        this.field_type &= -2;
    }

    public void unSetFavour() {
        this.field_type &= -65;
    }

    public void unSetHidden() {
        this.field_type &= -33;
    }
}
