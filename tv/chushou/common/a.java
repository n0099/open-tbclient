package tv.chushou.common;
/* loaded from: classes6.dex */
public final class a {
    private static final a oVT;
    private static final a oVU;
    private static volatile a oVV;
    private String ad;
    private String city;
    private String iMt;
    private String oVD;
    private String oVE;
    private String oVF;
    private String oVG;
    private String oVH;
    private String oVI;
    private String oVJ;
    private String oVK;
    private String oVL;
    private String oVM;
    private String oVN;
    private String oVO;
    private String oVP;
    private String oVQ;
    private int oVR;
    private String oVS;
    private String sdk;

    static {
        a aVar = new a();
        aVar.oVD = "https://api.chushou.tv/";
        aVar.oVE = "https://bee.kascend.com/";
        aVar.iMt = "https://chushou.tv/";
        aVar.oVF = "https://chat.chushou.tv/";
        aVar.oVG = "https://qos-stat.chushou.tv/";
        aVar.oVH = "im.chushou.tv";
        aVar.oVI = "https://imapi.chushou.tv/";
        aVar.oVJ = "https://pay.chushou.tv/kaspay/";
        aVar.oVK = "https://gemini.chushou.tv/";
        aVar.oVL = "https://mic.chushou.tv/";
        aVar.ad = "https://ja.chushou.tv/";
        aVar.city = "https://geo.chushou.tv/";
        aVar.oVM = "https://playground.chushou.tv/";
        aVar.oVN = "https://appstat.chushou.tv/";
        aVar.oVO = "https://luck.chushou.tv/";
        aVar.oVP = "https://gmapi.chushou.tv/";
        aVar.oVQ = "https://gm.chushou.tv/";
        aVar.sdk = "https://open.chushou.tv/";
        aVar.oVR = 8178;
        aVar.oVS = "rc";
        oVT = aVar;
        a aVar2 = new a();
        aVar2.oVD = "https://api.vchushou.com/";
        aVar2.oVE = "https://bee.vchushou.com/";
        aVar2.iMt = "https://vchushou.com/";
        aVar2.oVF = "https://chat.vchushou.com/";
        aVar2.oVG = "https://qos-stat.vchushou.com/";
        aVar2.oVH = "im.vchushou.com";
        aVar2.oVI = "https://imapi.vchushou.com/";
        aVar2.oVJ = "https://pay.vchushou.com/";
        aVar2.oVK = "https://gemini.vchushou.com/";
        aVar2.oVL = "https://mic.vchushou.com/";
        aVar2.ad = "https://ja.vchushou.com/";
        aVar2.city = "https://geo.vchushou.com/";
        aVar2.oVM = "https://open-game.vchushou.com/";
        aVar2.oVN = "https://vchushou.com/";
        aVar2.oVO = "https://luck.vchushou.com/";
        aVar2.oVP = "https://gamemate.vchushou.com/";
        aVar2.oVQ = "https://gamemate.vchushou.com/";
        aVar2.sdk = "https://open.vchushou.com/";
        aVar2.oVR = 8178;
        aVar2.oVS = "https";
        oVU = aVar2;
        oVV = oVT;
    }

    private a() {
    }

    public static void Xo(String str) {
        if ("beta".equals(str)) {
            oVV = oVU;
        } else {
            oVV = oVT;
        }
    }

    public static String epT() {
        return oVV.oVD;
    }

    public static String epU() {
        return oVV.oVE;
    }

    public static String cyX() {
        return oVV.iMt;
    }

    public static String epV() {
        return oVV.oVF;
    }

    public static String epW() {
        return oVV.oVL;
    }

    public static String epX() {
        return oVV.ad;
    }

    public static String epY() {
        return oVV.oVO;
    }

    public static String epZ() {
        return oVV.sdk;
    }
}
