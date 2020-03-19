package tv.chushou.common;
/* loaded from: classes5.dex */
public final class a {
    private static final a nXG;
    private static final a nXH;
    private static volatile a nXI;
    private String ad;
    private String city;
    private String nXA;
    private String nXB;
    private String nXC;
    private String nXD;
    private int nXE;
    private String nXF;
    private String nXp;
    private String nXq;
    private String nXr;
    private String nXs;
    private String nXt;
    private String nXu;
    private String nXv;
    private String nXw;
    private String nXx;
    private String nXy;
    private String nXz;
    private String sdk;

    static {
        a aVar = new a();
        aVar.nXp = "https://api.chushou.tv/";
        aVar.nXq = "https://bee.kascend.com/";
        aVar.nXr = "https://chushou.tv/";
        aVar.nXs = "https://chat.chushou.tv/";
        aVar.nXt = "https://qos-stat.chushou.tv/";
        aVar.nXu = "im.chushou.tv";
        aVar.nXv = "https://imapi.chushou.tv/";
        aVar.nXw = "https://pay.chushou.tv/kaspay/";
        aVar.nXx = "https://gemini.chushou.tv/";
        aVar.nXy = "https://mic.chushou.tv/";
        aVar.ad = "https://ja.chushou.tv/";
        aVar.city = "https://geo.chushou.tv/";
        aVar.nXz = "https://playground.chushou.tv/";
        aVar.nXA = "https://appstat.chushou.tv/";
        aVar.nXB = "https://luck.chushou.tv/";
        aVar.nXC = "https://gmapi.chushou.tv/";
        aVar.nXD = "https://gm.chushou.tv/";
        aVar.sdk = "https://open.chushou.tv/";
        aVar.nXE = 8178;
        aVar.nXF = "rc";
        nXG = aVar;
        a aVar2 = new a();
        aVar2.nXp = "https://api.vchushou.com/";
        aVar2.nXq = "https://bee.vchushou.com/";
        aVar2.nXr = "https://vchushou.com/";
        aVar2.nXs = "https://chat.vchushou.com/";
        aVar2.nXt = "https://qos-stat.vchushou.com/";
        aVar2.nXu = "im.vchushou.com";
        aVar2.nXv = "https://imapi.vchushou.com/";
        aVar2.nXw = "https://pay.vchushou.com/";
        aVar2.nXx = "https://gemini.vchushou.com/";
        aVar2.nXy = "https://mic.vchushou.com/";
        aVar2.ad = "https://ja.vchushou.com/";
        aVar2.city = "https://geo.vchushou.com/";
        aVar2.nXz = "https://open-game.vchushou.com/";
        aVar2.nXA = "https://vchushou.com/";
        aVar2.nXB = "https://luck.vchushou.com/";
        aVar2.nXC = "https://gamemate.vchushou.com/";
        aVar2.nXD = "https://gamemate.vchushou.com/";
        aVar2.sdk = "https://open.vchushou.com/";
        aVar2.nXE = 8178;
        aVar2.nXF = "https";
        nXH = aVar2;
        nXI = nXG;
    }

    private a() {
    }

    public static void SL(String str) {
        if ("beta".equals(str)) {
            nXI = nXH;
        } else {
            nXI = nXG;
        }
    }

    public static String dQx() {
        return nXI.nXp;
    }

    public static String dQy() {
        return nXI.nXq;
    }

    public static String dQz() {
        return nXI.nXr;
    }

    public static String dQA() {
        return nXI.nXs;
    }

    public static String dQB() {
        return nXI.nXy;
    }

    public static String dQC() {
        return nXI.ad;
    }

    public static String dQD() {
        return nXI.nXB;
    }

    public static String dQE() {
        return nXI.sdk;
    }
}
