package tv.chushou.common;
/* loaded from: classes5.dex */
public final class a {
    private static final a nVT;
    private static final a nVU;
    private static volatile a nVV;
    private String ad;
    private String city;
    private String nVC;
    private String nVD;
    private String nVE;
    private String nVF;
    private String nVG;
    private String nVH;
    private String nVI;
    private String nVJ;
    private String nVK;
    private String nVL;
    private String nVM;
    private String nVN;
    private String nVO;
    private String nVP;
    private String nVQ;
    private int nVR;
    private String nVS;
    private String sdk;

    static {
        a aVar = new a();
        aVar.nVC = "https://api.chushou.tv/";
        aVar.nVD = "https://bee.kascend.com/";
        aVar.nVE = "https://chushou.tv/";
        aVar.nVF = "https://chat.chushou.tv/";
        aVar.nVG = "https://qos-stat.chushou.tv/";
        aVar.nVH = "im.chushou.tv";
        aVar.nVI = "https://imapi.chushou.tv/";
        aVar.nVJ = "https://pay.chushou.tv/kaspay/";
        aVar.nVK = "https://gemini.chushou.tv/";
        aVar.nVL = "https://mic.chushou.tv/";
        aVar.ad = "https://ja.chushou.tv/";
        aVar.city = "https://geo.chushou.tv/";
        aVar.nVM = "https://playground.chushou.tv/";
        aVar.nVN = "https://appstat.chushou.tv/";
        aVar.nVO = "https://luck.chushou.tv/";
        aVar.nVP = "https://gmapi.chushou.tv/";
        aVar.nVQ = "https://gm.chushou.tv/";
        aVar.sdk = "https://open.chushou.tv/";
        aVar.nVR = 8178;
        aVar.nVS = "rc";
        nVT = aVar;
        a aVar2 = new a();
        aVar2.nVC = "https://api.vchushou.com/";
        aVar2.nVD = "https://bee.vchushou.com/";
        aVar2.nVE = "https://vchushou.com/";
        aVar2.nVF = "https://chat.vchushou.com/";
        aVar2.nVG = "https://qos-stat.vchushou.com/";
        aVar2.nVH = "im.vchushou.com";
        aVar2.nVI = "https://imapi.vchushou.com/";
        aVar2.nVJ = "https://pay.vchushou.com/";
        aVar2.nVK = "https://gemini.vchushou.com/";
        aVar2.nVL = "https://mic.vchushou.com/";
        aVar2.ad = "https://ja.vchushou.com/";
        aVar2.city = "https://geo.vchushou.com/";
        aVar2.nVM = "https://open-game.vchushou.com/";
        aVar2.nVN = "https://vchushou.com/";
        aVar2.nVO = "https://luck.vchushou.com/";
        aVar2.nVP = "https://gamemate.vchushou.com/";
        aVar2.nVQ = "https://gamemate.vchushou.com/";
        aVar2.sdk = "https://open.vchushou.com/";
        aVar2.nVR = 8178;
        aVar2.nVS = "https";
        nVU = aVar2;
        nVV = nVT;
    }

    private a() {
    }

    public static void SL(String str) {
        if ("beta".equals(str)) {
            nVV = nVU;
        } else {
            nVV = nVT;
        }
    }

    public static String dPX() {
        return nVV.nVC;
    }

    public static String dPY() {
        return nVV.nVD;
    }

    public static String dPZ() {
        return nVV.nVE;
    }

    public static String dQa() {
        return nVV.nVF;
    }

    public static String dQb() {
        return nVV.nVL;
    }

    public static String dQc() {
        return nVV.ad;
    }

    public static String dQd() {
        return nVV.nVO;
    }

    public static String dQe() {
        return nVV.sdk;
    }
}
