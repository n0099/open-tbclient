package tv.chushou.common;
/* loaded from: classes5.dex */
public final class a {
    private static final a nVG;
    private static final a nVH;
    private static volatile a nVI;
    private String ad;
    private String city;
    private String nVA;
    private String nVB;
    private String nVC;
    private String nVD;
    private int nVE;
    private String nVF;
    private String nVp;
    private String nVq;
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
        aVar.nVp = "https://api.chushou.tv/";
        aVar.nVq = "https://bee.kascend.com/";
        aVar.nVr = "https://chushou.tv/";
        aVar.nVs = "https://chat.chushou.tv/";
        aVar.nVt = "https://qos-stat.chushou.tv/";
        aVar.nVu = "im.chushou.tv";
        aVar.nVv = "https://imapi.chushou.tv/";
        aVar.nVw = "https://pay.chushou.tv/kaspay/";
        aVar.nVx = "https://gemini.chushou.tv/";
        aVar.nVy = "https://mic.chushou.tv/";
        aVar.ad = "https://ja.chushou.tv/";
        aVar.city = "https://geo.chushou.tv/";
        aVar.nVz = "https://playground.chushou.tv/";
        aVar.nVA = "https://appstat.chushou.tv/";
        aVar.nVB = "https://luck.chushou.tv/";
        aVar.nVC = "https://gmapi.chushou.tv/";
        aVar.nVD = "https://gm.chushou.tv/";
        aVar.sdk = "https://open.chushou.tv/";
        aVar.nVE = 8178;
        aVar.nVF = "rc";
        nVG = aVar;
        a aVar2 = new a();
        aVar2.nVp = "https://api.vchushou.com/";
        aVar2.nVq = "https://bee.vchushou.com/";
        aVar2.nVr = "https://vchushou.com/";
        aVar2.nVs = "https://chat.vchushou.com/";
        aVar2.nVt = "https://qos-stat.vchushou.com/";
        aVar2.nVu = "im.vchushou.com";
        aVar2.nVv = "https://imapi.vchushou.com/";
        aVar2.nVw = "https://pay.vchushou.com/";
        aVar2.nVx = "https://gemini.vchushou.com/";
        aVar2.nVy = "https://mic.vchushou.com/";
        aVar2.ad = "https://ja.vchushou.com/";
        aVar2.city = "https://geo.vchushou.com/";
        aVar2.nVz = "https://open-game.vchushou.com/";
        aVar2.nVA = "https://vchushou.com/";
        aVar2.nVB = "https://luck.vchushou.com/";
        aVar2.nVC = "https://gamemate.vchushou.com/";
        aVar2.nVD = "https://gamemate.vchushou.com/";
        aVar2.sdk = "https://open.vchushou.com/";
        aVar2.nVE = 8178;
        aVar2.nVF = "https";
        nVH = aVar2;
        nVI = nVG;
    }

    private a() {
    }

    public static void SK(String str) {
        if ("beta".equals(str)) {
            nVI = nVH;
        } else {
            nVI = nVG;
        }
    }

    public static String dPU() {
        return nVI.nVp;
    }

    public static String dPV() {
        return nVI.nVq;
    }

    public static String dPW() {
        return nVI.nVr;
    }

    public static String dPX() {
        return nVI.nVs;
    }

    public static String dPY() {
        return nVI.nVy;
    }

    public static String dPZ() {
        return nVI.ad;
    }

    public static String dQa() {
        return nVI.nVB;
    }

    public static String dQb() {
        return nVI.sdk;
    }
}
