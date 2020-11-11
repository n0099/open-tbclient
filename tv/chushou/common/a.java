package tv.chushou.common;
/* loaded from: classes6.dex */
public final class a {
    private static final a qlX;
    private static final a qlY;
    private static volatile a qlZ;
    private String ad;
    private String city;
    private String jtD;
    private String qlH;
    private String qlI;
    private String qlJ;
    private String qlK;
    private String qlL;
    private String qlM;
    private String qlN;
    private String qlO;
    private String qlP;
    private String qlQ;
    private String qlR;
    private String qlS;
    private String qlT;
    private String qlU;
    private int qlV;
    private String qlW;
    private String sdk;

    static {
        a aVar = new a();
        aVar.qlH = "https://api.chushou.tv/";
        aVar.qlI = "https://bee.kascend.com/";
        aVar.jtD = "https://chushou.tv/";
        aVar.qlJ = "https://chat.chushou.tv/";
        aVar.qlK = "https://qos-stat.chushou.tv/";
        aVar.qlL = "im.chushou.tv";
        aVar.qlM = "https://imapi.chushou.tv/";
        aVar.qlN = "https://pay.chushou.tv/kaspay/";
        aVar.qlO = "https://gemini.chushou.tv/";
        aVar.qlP = "https://mic.chushou.tv/";
        aVar.ad = "https://ja.chushou.tv/";
        aVar.city = "https://geo.chushou.tv/";
        aVar.qlQ = "https://playground.chushou.tv/";
        aVar.qlR = "https://appstat.chushou.tv/";
        aVar.qlS = "https://luck.chushou.tv/";
        aVar.qlT = "https://gmapi.chushou.tv/";
        aVar.qlU = "https://gm.chushou.tv/";
        aVar.sdk = "https://open.chushou.tv/";
        aVar.qlV = 8178;
        aVar.qlW = "rc";
        qlX = aVar;
        a aVar2 = new a();
        aVar2.qlH = "https://api.vchushou.com/";
        aVar2.qlI = "https://bee.vchushou.com/";
        aVar2.jtD = "https://vchushou.com/";
        aVar2.qlJ = "https://chat.vchushou.com/";
        aVar2.qlK = "https://qos-stat.vchushou.com/";
        aVar2.qlL = "im.vchushou.com";
        aVar2.qlM = "https://imapi.vchushou.com/";
        aVar2.qlN = "https://pay.vchushou.com/";
        aVar2.qlO = "https://gemini.vchushou.com/";
        aVar2.qlP = "https://mic.vchushou.com/";
        aVar2.ad = "https://ja.vchushou.com/";
        aVar2.city = "https://geo.vchushou.com/";
        aVar2.qlQ = "https://open-game.vchushou.com/";
        aVar2.qlR = "https://vchushou.com/";
        aVar2.qlS = "https://luck.vchushou.com/";
        aVar2.qlT = "https://gamemate.vchushou.com/";
        aVar2.qlU = "https://gamemate.vchushou.com/";
        aVar2.sdk = "https://open.vchushou.com/";
        aVar2.qlV = 8178;
        aVar2.qlW = "https";
        qlY = aVar2;
        qlZ = qlX;
    }

    private a() {
    }

    public static void aat(String str) {
        if ("beta".equals(str)) {
            qlZ = qlY;
        } else {
            qlZ = qlX;
        }
    }

    public static String eHr() {
        return qlZ.qlH;
    }

    public static String eHs() {
        return qlZ.qlI;
    }

    public static String cId() {
        return qlZ.jtD;
    }

    public static String eHt() {
        return qlZ.qlJ;
    }

    public static String eHu() {
        return qlZ.qlP;
    }

    public static String eHv() {
        return qlZ.ad;
    }

    public static String eHw() {
        return qlZ.qlS;
    }

    public static String eHx() {
        return qlZ.sdk;
    }
}
