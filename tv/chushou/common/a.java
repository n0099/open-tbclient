package tv.chushou.common;
/* loaded from: classes4.dex */
public final class a {
    private static final a nUR;
    private static final a nUS;
    private static volatile a nUT;
    private String ad;
    private String city;
    private String nUA;
    private String nUB;
    private String nUC;
    private String nUD;
    private String nUE;
    private String nUF;
    private String nUG;
    private String nUH;
    private String nUI;
    private String nUJ;
    private String nUK;
    private String nUL;
    private String nUM;
    private String nUN;
    private String nUO;
    private int nUP;
    private String nUQ;
    private String sdk;

    static {
        a aVar = new a();
        aVar.nUA = "https://api.chushou.tv/";
        aVar.nUB = "https://bee.kascend.com/";
        aVar.nUC = "https://chushou.tv/";
        aVar.nUD = "https://chat.chushou.tv/";
        aVar.nUE = "https://qos-stat.chushou.tv/";
        aVar.nUF = "im.chushou.tv";
        aVar.nUG = "https://imapi.chushou.tv/";
        aVar.nUH = "https://pay.chushou.tv/kaspay/";
        aVar.nUI = "https://gemini.chushou.tv/";
        aVar.nUJ = "https://mic.chushou.tv/";
        aVar.ad = "https://ja.chushou.tv/";
        aVar.city = "https://geo.chushou.tv/";
        aVar.nUK = "https://playground.chushou.tv/";
        aVar.nUL = "https://appstat.chushou.tv/";
        aVar.nUM = "https://luck.chushou.tv/";
        aVar.nUN = "https://gmapi.chushou.tv/";
        aVar.nUO = "https://gm.chushou.tv/";
        aVar.sdk = "https://open.chushou.tv/";
        aVar.nUP = 8178;
        aVar.nUQ = "rc";
        nUR = aVar;
        a aVar2 = new a();
        aVar2.nUA = "https://api.vchushou.com/";
        aVar2.nUB = "https://bee.vchushou.com/";
        aVar2.nUC = "https://vchushou.com/";
        aVar2.nUD = "https://chat.vchushou.com/";
        aVar2.nUE = "https://qos-stat.vchushou.com/";
        aVar2.nUF = "im.vchushou.com";
        aVar2.nUG = "https://imapi.vchushou.com/";
        aVar2.nUH = "https://pay.vchushou.com/";
        aVar2.nUI = "https://gemini.vchushou.com/";
        aVar2.nUJ = "https://mic.vchushou.com/";
        aVar2.ad = "https://ja.vchushou.com/";
        aVar2.city = "https://geo.vchushou.com/";
        aVar2.nUK = "https://open-game.vchushou.com/";
        aVar2.nUL = "https://vchushou.com/";
        aVar2.nUM = "https://luck.vchushou.com/";
        aVar2.nUN = "https://gamemate.vchushou.com/";
        aVar2.nUO = "https://gamemate.vchushou.com/";
        aVar2.sdk = "https://open.vchushou.com/";
        aVar2.nUP = 8178;
        aVar2.nUQ = "https";
        nUS = aVar2;
        nUT = nUR;
    }

    private a() {
    }

    public static void Sz(String str) {
        if ("beta".equals(str)) {
            nUT = nUS;
        } else {
            nUT = nUR;
        }
    }

    public static String dOH() {
        return nUT.nUA;
    }

    public static String dOI() {
        return nUT.nUB;
    }

    public static String dOJ() {
        return nUT.nUC;
    }

    public static String dOK() {
        return nUT.nUD;
    }

    public static String dOL() {
        return nUT.nUJ;
    }

    public static String dOM() {
        return nUT.ad;
    }

    public static String dON() {
        return nUT.nUM;
    }

    public static String dOO() {
        return nUT.sdk;
    }
}
