package tv.chushou.common;
/* loaded from: classes6.dex */
public final class a {
    private static final a qcC;
    private static final a qcD;
    private static volatile a qcE;
    private String ad;
    private String city;
    private String jnG;
    private int qcA;
    private String qcB;
    private String qcm;
    private String qcn;
    private String qco;
    private String qcp;
    private String qcq;
    private String qcr;
    private String qcs;
    private String qct;
    private String qcu;
    private String qcv;
    private String qcw;
    private String qcx;
    private String qcy;
    private String qcz;
    private String sdk;

    static {
        a aVar = new a();
        aVar.qcm = "https://api.chushou.tv/";
        aVar.qcn = "https://bee.kascend.com/";
        aVar.jnG = "https://chushou.tv/";
        aVar.qco = "https://chat.chushou.tv/";
        aVar.qcp = "https://qos-stat.chushou.tv/";
        aVar.qcq = "im.chushou.tv";
        aVar.qcr = "https://imapi.chushou.tv/";
        aVar.qcs = "https://pay.chushou.tv/kaspay/";
        aVar.qct = "https://gemini.chushou.tv/";
        aVar.qcu = "https://mic.chushou.tv/";
        aVar.ad = "https://ja.chushou.tv/";
        aVar.city = "https://geo.chushou.tv/";
        aVar.qcv = "https://playground.chushou.tv/";
        aVar.qcw = "https://appstat.chushou.tv/";
        aVar.qcx = "https://luck.chushou.tv/";
        aVar.qcy = "https://gmapi.chushou.tv/";
        aVar.qcz = "https://gm.chushou.tv/";
        aVar.sdk = "https://open.chushou.tv/";
        aVar.qcA = 8178;
        aVar.qcB = "rc";
        qcC = aVar;
        a aVar2 = new a();
        aVar2.qcm = "https://api.vchushou.com/";
        aVar2.qcn = "https://bee.vchushou.com/";
        aVar2.jnG = "https://vchushou.com/";
        aVar2.qco = "https://chat.vchushou.com/";
        aVar2.qcp = "https://qos-stat.vchushou.com/";
        aVar2.qcq = "im.vchushou.com";
        aVar2.qcr = "https://imapi.vchushou.com/";
        aVar2.qcs = "https://pay.vchushou.com/";
        aVar2.qct = "https://gemini.vchushou.com/";
        aVar2.qcu = "https://mic.vchushou.com/";
        aVar2.ad = "https://ja.vchushou.com/";
        aVar2.city = "https://geo.vchushou.com/";
        aVar2.qcv = "https://open-game.vchushou.com/";
        aVar2.qcw = "https://vchushou.com/";
        aVar2.qcx = "https://luck.vchushou.com/";
        aVar2.qcy = "https://gamemate.vchushou.com/";
        aVar2.qcz = "https://gamemate.vchushou.com/";
        aVar2.sdk = "https://open.vchushou.com/";
        aVar2.qcA = 8178;
        aVar2.qcB = "https";
        qcD = aVar2;
        qcE = qcC;
    }

    private a() {
    }

    public static void ZP(String str) {
        if ("beta".equals(str)) {
            qcE = qcD;
        } else {
            qcE = qcC;
        }
    }

    public static String eDC() {
        return qcE.qcm;
    }

    public static String eDD() {
        return qcE.qcn;
    }

    public static String cFC() {
        return qcE.jnG;
    }

    public static String eDE() {
        return qcE.qco;
    }

    public static String eDF() {
        return qcE.qcu;
    }

    public static String eDG() {
        return qcE.ad;
    }

    public static String eDH() {
        return qcE.qcx;
    }

    public static String eDI() {
        return qcE.sdk;
    }
}
