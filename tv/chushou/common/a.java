package tv.chushou.common;
/* loaded from: classes6.dex */
public final class a {
    private static final a oLX;
    private static final a oLY;
    private static volatile a oLZ;
    private String ad;
    private String city;
    private String iES;
    private String oLH;
    private String oLI;
    private String oLJ;
    private String oLK;
    private String oLL;
    private String oLM;
    private String oLN;
    private String oLO;
    private String oLP;
    private String oLQ;
    private String oLR;
    private String oLS;
    private String oLT;
    private String oLU;
    private int oLV;
    private String oLW;
    private String sdk;

    static {
        a aVar = new a();
        aVar.oLH = "https://api.chushou.tv/";
        aVar.oLI = "https://bee.kascend.com/";
        aVar.iES = "https://chushou.tv/";
        aVar.oLJ = "https://chat.chushou.tv/";
        aVar.oLK = "https://qos-stat.chushou.tv/";
        aVar.oLL = "im.chushou.tv";
        aVar.oLM = "https://imapi.chushou.tv/";
        aVar.oLN = "https://pay.chushou.tv/kaspay/";
        aVar.oLO = "https://gemini.chushou.tv/";
        aVar.oLP = "https://mic.chushou.tv/";
        aVar.ad = "https://ja.chushou.tv/";
        aVar.city = "https://geo.chushou.tv/";
        aVar.oLQ = "https://playground.chushou.tv/";
        aVar.oLR = "https://appstat.chushou.tv/";
        aVar.oLS = "https://luck.chushou.tv/";
        aVar.oLT = "https://gmapi.chushou.tv/";
        aVar.oLU = "https://gm.chushou.tv/";
        aVar.sdk = "https://open.chushou.tv/";
        aVar.oLV = 8178;
        aVar.oLW = "rc";
        oLX = aVar;
        a aVar2 = new a();
        aVar2.oLH = "https://api.vchushou.com/";
        aVar2.oLI = "https://bee.vchushou.com/";
        aVar2.iES = "https://vchushou.com/";
        aVar2.oLJ = "https://chat.vchushou.com/";
        aVar2.oLK = "https://qos-stat.vchushou.com/";
        aVar2.oLL = "im.vchushou.com";
        aVar2.oLM = "https://imapi.vchushou.com/";
        aVar2.oLN = "https://pay.vchushou.com/";
        aVar2.oLO = "https://gemini.vchushou.com/";
        aVar2.oLP = "https://mic.vchushou.com/";
        aVar2.ad = "https://ja.vchushou.com/";
        aVar2.city = "https://geo.vchushou.com/";
        aVar2.oLQ = "https://open-game.vchushou.com/";
        aVar2.oLR = "https://vchushou.com/";
        aVar2.oLS = "https://luck.vchushou.com/";
        aVar2.oLT = "https://gamemate.vchushou.com/";
        aVar2.oLU = "https://gamemate.vchushou.com/";
        aVar2.sdk = "https://open.vchushou.com/";
        aVar2.oLV = 8178;
        aVar2.oLW = "https";
        oLY = aVar2;
        oLZ = oLX;
    }

    private a() {
    }

    public static void WM(String str) {
        if ("beta".equals(str)) {
            oLZ = oLY;
        } else {
            oLZ = oLX;
        }
    }

    public static String elM() {
        return oLZ.oLH;
    }

    public static String elN() {
        return oLZ.oLI;
    }

    public static String cvD() {
        return oLZ.iES;
    }

    public static String elO() {
        return oLZ.oLJ;
    }

    public static String elP() {
        return oLZ.oLP;
    }

    public static String elQ() {
        return oLZ.ad;
    }

    public static String elR() {
        return oLZ.oLS;
    }

    public static String elS() {
        return oLZ.sdk;
    }
}
