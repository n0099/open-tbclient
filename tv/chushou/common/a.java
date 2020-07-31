package tv.chushou.common;
/* loaded from: classes6.dex */
public final class a {
    private static final a osd;
    private static final a ose;
    private static volatile a osf;
    private String ad;
    private String city;
    private String orM;
    private String orN;
    private String orO;
    private String orP;
    private String orQ;
    private String orR;
    private String orS;
    private String orT;
    private String orU;
    private String orV;
    private String orW;
    private String orX;
    private String orY;
    private String orZ;
    private String osa;
    private int osb;
    private String osc;
    private String sdk;

    static {
        a aVar = new a();
        aVar.orM = "https://api.chushou.tv/";
        aVar.orN = "https://bee.kascend.com/";
        aVar.orO = "https://chushou.tv/";
        aVar.orP = "https://chat.chushou.tv/";
        aVar.orQ = "https://qos-stat.chushou.tv/";
        aVar.orR = "im.chushou.tv";
        aVar.orS = "https://imapi.chushou.tv/";
        aVar.orT = "https://pay.chushou.tv/kaspay/";
        aVar.orU = "https://gemini.chushou.tv/";
        aVar.orV = "https://mic.chushou.tv/";
        aVar.ad = "https://ja.chushou.tv/";
        aVar.city = "https://geo.chushou.tv/";
        aVar.orW = "https://playground.chushou.tv/";
        aVar.orX = "https://appstat.chushou.tv/";
        aVar.orY = "https://luck.chushou.tv/";
        aVar.orZ = "https://gmapi.chushou.tv/";
        aVar.osa = "https://gm.chushou.tv/";
        aVar.sdk = "https://open.chushou.tv/";
        aVar.osb = 8178;
        aVar.osc = "rc";
        osd = aVar;
        a aVar2 = new a();
        aVar2.orM = "https://api.vchushou.com/";
        aVar2.orN = "https://bee.vchushou.com/";
        aVar2.orO = "https://vchushou.com/";
        aVar2.orP = "https://chat.vchushou.com/";
        aVar2.orQ = "https://qos-stat.vchushou.com/";
        aVar2.orR = "im.vchushou.com";
        aVar2.orS = "https://imapi.vchushou.com/";
        aVar2.orT = "https://pay.vchushou.com/";
        aVar2.orU = "https://gemini.vchushou.com/";
        aVar2.orV = "https://mic.vchushou.com/";
        aVar2.ad = "https://ja.vchushou.com/";
        aVar2.city = "https://geo.vchushou.com/";
        aVar2.orW = "https://open-game.vchushou.com/";
        aVar2.orX = "https://vchushou.com/";
        aVar2.orY = "https://luck.vchushou.com/";
        aVar2.orZ = "https://gamemate.vchushou.com/";
        aVar2.osa = "https://gamemate.vchushou.com/";
        aVar2.sdk = "https://open.vchushou.com/";
        aVar2.osb = 8178;
        aVar2.osc = "https";
        ose = aVar2;
        osf = osd;
    }

    private a() {
    }

    public static void TI(String str) {
        if ("beta".equals(str)) {
            osf = ose;
        } else {
            osf = osd;
        }
    }

    public static String dZH() {
        return osf.orM;
    }

    public static String dZI() {
        return osf.orN;
    }

    public static String dZJ() {
        return osf.orO;
    }

    public static String dZK() {
        return osf.orP;
    }

    public static String dZL() {
        return osf.orV;
    }

    public static String dZM() {
        return osf.ad;
    }

    public static String dZN() {
        return osf.orY;
    }

    public static String dZO() {
        return osf.sdk;
    }
}
