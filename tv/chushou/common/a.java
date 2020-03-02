package tv.chushou.common;
/* loaded from: classes5.dex */
public final class a {
    private static final a nVI;
    private static final a nVJ;
    private static volatile a nVK;
    private String ad;
    private String city;
    private String nVA;
    private String nVB;
    private String nVC;
    private String nVD;
    private String nVE;
    private String nVF;
    private int nVG;
    private String nVH;
    private String nVr;
    private String nVs;
    private String nVt;
    private String nVu;
    private String nVv;
    private String nVw;
    private String nVx;
    private String nVy;
    private String nVz;
    private String sdk;

    static {
        a aVar = new a();
        aVar.nVr = "https://api.chushou.tv/";
        aVar.nVs = "https://bee.kascend.com/";
        aVar.nVt = "https://chushou.tv/";
        aVar.nVu = "https://chat.chushou.tv/";
        aVar.nVv = "https://qos-stat.chushou.tv/";
        aVar.nVw = "im.chushou.tv";
        aVar.nVx = "https://imapi.chushou.tv/";
        aVar.nVy = "https://pay.chushou.tv/kaspay/";
        aVar.nVz = "https://gemini.chushou.tv/";
        aVar.nVA = "https://mic.chushou.tv/";
        aVar.ad = "https://ja.chushou.tv/";
        aVar.city = "https://geo.chushou.tv/";
        aVar.nVB = "https://playground.chushou.tv/";
        aVar.nVC = "https://appstat.chushou.tv/";
        aVar.nVD = "https://luck.chushou.tv/";
        aVar.nVE = "https://gmapi.chushou.tv/";
        aVar.nVF = "https://gm.chushou.tv/";
        aVar.sdk = "https://open.chushou.tv/";
        aVar.nVG = 8178;
        aVar.nVH = "rc";
        nVI = aVar;
        a aVar2 = new a();
        aVar2.nVr = "https://api.vchushou.com/";
        aVar2.nVs = "https://bee.vchushou.com/";
        aVar2.nVt = "https://vchushou.com/";
        aVar2.nVu = "https://chat.vchushou.com/";
        aVar2.nVv = "https://qos-stat.vchushou.com/";
        aVar2.nVw = "im.vchushou.com";
        aVar2.nVx = "https://imapi.vchushou.com/";
        aVar2.nVy = "https://pay.vchushou.com/";
        aVar2.nVz = "https://gemini.vchushou.com/";
        aVar2.nVA = "https://mic.vchushou.com/";
        aVar2.ad = "https://ja.vchushou.com/";
        aVar2.city = "https://geo.vchushou.com/";
        aVar2.nVB = "https://open-game.vchushou.com/";
        aVar2.nVC = "https://vchushou.com/";
        aVar2.nVD = "https://luck.vchushou.com/";
        aVar2.nVE = "https://gamemate.vchushou.com/";
        aVar2.nVF = "https://gamemate.vchushou.com/";
        aVar2.sdk = "https://open.vchushou.com/";
        aVar2.nVG = 8178;
        aVar2.nVH = "https";
        nVJ = aVar2;
        nVK = nVI;
    }

    private a() {
    }

    public static void SK(String str) {
        if ("beta".equals(str)) {
            nVK = nVJ;
        } else {
            nVK = nVI;
        }
    }

    public static String dPW() {
        return nVK.nVr;
    }

    public static String dPX() {
        return nVK.nVs;
    }

    public static String dPY() {
        return nVK.nVt;
    }

    public static String dPZ() {
        return nVK.nVu;
    }

    public static String dQa() {
        return nVK.nVA;
    }

    public static String dQb() {
        return nVK.ad;
    }

    public static String dQc() {
        return nVK.nVD;
    }

    public static String dQd() {
        return nVK.sdk;
    }
}
