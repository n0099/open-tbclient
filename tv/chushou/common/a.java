package tv.chushou.common;
/* loaded from: classes6.dex */
public final class a {
    private static final a osf;
    private static final a osg;
    private static volatile a osh;
    private String ad;
    private String city;
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
    private String osb;
    private String osc;
    private int osd;
    private String ose;
    private String sdk;

    static {
        a aVar = new a();
        aVar.orO = "https://api.chushou.tv/";
        aVar.orP = "https://bee.kascend.com/";
        aVar.orQ = "https://chushou.tv/";
        aVar.orR = "https://chat.chushou.tv/";
        aVar.orS = "https://qos-stat.chushou.tv/";
        aVar.orT = "im.chushou.tv";
        aVar.orU = "https://imapi.chushou.tv/";
        aVar.orV = "https://pay.chushou.tv/kaspay/";
        aVar.orW = "https://gemini.chushou.tv/";
        aVar.orX = "https://mic.chushou.tv/";
        aVar.ad = "https://ja.chushou.tv/";
        aVar.city = "https://geo.chushou.tv/";
        aVar.orY = "https://playground.chushou.tv/";
        aVar.orZ = "https://appstat.chushou.tv/";
        aVar.osa = "https://luck.chushou.tv/";
        aVar.osb = "https://gmapi.chushou.tv/";
        aVar.osc = "https://gm.chushou.tv/";
        aVar.sdk = "https://open.chushou.tv/";
        aVar.osd = 8178;
        aVar.ose = "rc";
        osf = aVar;
        a aVar2 = new a();
        aVar2.orO = "https://api.vchushou.com/";
        aVar2.orP = "https://bee.vchushou.com/";
        aVar2.orQ = "https://vchushou.com/";
        aVar2.orR = "https://chat.vchushou.com/";
        aVar2.orS = "https://qos-stat.vchushou.com/";
        aVar2.orT = "im.vchushou.com";
        aVar2.orU = "https://imapi.vchushou.com/";
        aVar2.orV = "https://pay.vchushou.com/";
        aVar2.orW = "https://gemini.vchushou.com/";
        aVar2.orX = "https://mic.vchushou.com/";
        aVar2.ad = "https://ja.vchushou.com/";
        aVar2.city = "https://geo.vchushou.com/";
        aVar2.orY = "https://open-game.vchushou.com/";
        aVar2.orZ = "https://vchushou.com/";
        aVar2.osa = "https://luck.vchushou.com/";
        aVar2.osb = "https://gamemate.vchushou.com/";
        aVar2.osc = "https://gamemate.vchushou.com/";
        aVar2.sdk = "https://open.vchushou.com/";
        aVar2.osd = 8178;
        aVar2.ose = "https";
        osg = aVar2;
        osh = osf;
    }

    private a() {
    }

    public static void TI(String str) {
        if ("beta".equals(str)) {
            osh = osg;
        } else {
            osh = osf;
        }
    }

    public static String dZI() {
        return osh.orO;
    }

    public static String dZJ() {
        return osh.orP;
    }

    public static String dZK() {
        return osh.orQ;
    }

    public static String dZL() {
        return osh.orR;
    }

    public static String dZM() {
        return osh.orX;
    }

    public static String dZN() {
        return osh.ad;
    }

    public static String dZO() {
        return osh.osa;
    }

    public static String dZP() {
        return osh.sdk;
    }
}
