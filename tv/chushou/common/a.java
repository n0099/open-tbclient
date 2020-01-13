package tv.chushou.common;
/* loaded from: classes4.dex */
public final class a {
    private static final a nUM;
    private static final a nUN;
    private static volatile a nUO;
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
    private int nUK;
    private String nUL;
    private String nUv;
    private String nUw;
    private String nUx;
    private String nUy;
    private String nUz;
    private String sdk;

    static {
        a aVar = new a();
        aVar.nUv = "https://api.chushou.tv/";
        aVar.nUw = "https://bee.kascend.com/";
        aVar.nUx = "https://chushou.tv/";
        aVar.nUy = "https://chat.chushou.tv/";
        aVar.nUz = "https://qos-stat.chushou.tv/";
        aVar.nUA = "im.chushou.tv";
        aVar.nUB = "https://imapi.chushou.tv/";
        aVar.nUC = "https://pay.chushou.tv/kaspay/";
        aVar.nUD = "https://gemini.chushou.tv/";
        aVar.nUE = "https://mic.chushou.tv/";
        aVar.ad = "https://ja.chushou.tv/";
        aVar.city = "https://geo.chushou.tv/";
        aVar.nUF = "https://playground.chushou.tv/";
        aVar.nUG = "https://appstat.chushou.tv/";
        aVar.nUH = "https://luck.chushou.tv/";
        aVar.nUI = "https://gmapi.chushou.tv/";
        aVar.nUJ = "https://gm.chushou.tv/";
        aVar.sdk = "https://open.chushou.tv/";
        aVar.nUK = 8178;
        aVar.nUL = "rc";
        nUM = aVar;
        a aVar2 = new a();
        aVar2.nUv = "https://api.vchushou.com/";
        aVar2.nUw = "https://bee.vchushou.com/";
        aVar2.nUx = "https://vchushou.com/";
        aVar2.nUy = "https://chat.vchushou.com/";
        aVar2.nUz = "https://qos-stat.vchushou.com/";
        aVar2.nUA = "im.vchushou.com";
        aVar2.nUB = "https://imapi.vchushou.com/";
        aVar2.nUC = "https://pay.vchushou.com/";
        aVar2.nUD = "https://gemini.vchushou.com/";
        aVar2.nUE = "https://mic.vchushou.com/";
        aVar2.ad = "https://ja.vchushou.com/";
        aVar2.city = "https://geo.vchushou.com/";
        aVar2.nUF = "https://open-game.vchushou.com/";
        aVar2.nUG = "https://vchushou.com/";
        aVar2.nUH = "https://luck.vchushou.com/";
        aVar2.nUI = "https://gamemate.vchushou.com/";
        aVar2.nUJ = "https://gamemate.vchushou.com/";
        aVar2.sdk = "https://open.vchushou.com/";
        aVar2.nUK = 8178;
        aVar2.nUL = "https";
        nUN = aVar2;
        nUO = nUM;
    }

    private a() {
    }

    public static void Sz(String str) {
        if ("beta".equals(str)) {
            nUO = nUN;
        } else {
            nUO = nUM;
        }
    }

    public static String dOF() {
        return nUO.nUv;
    }

    public static String dOG() {
        return nUO.nUw;
    }

    public static String dOH() {
        return nUO.nUx;
    }

    public static String dOI() {
        return nUO.nUy;
    }

    public static String dOJ() {
        return nUO.nUE;
    }

    public static String dOK() {
        return nUO.ad;
    }

    public static String dOL() {
        return nUO.nUH;
    }

    public static String dOM() {
        return nUO.sdk;
    }
}
