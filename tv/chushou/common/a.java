package tv.chushou.common;
/* loaded from: classes6.dex */
public final class a {
    private static final a oMp;
    private static final a oMq;
    private static volatile a oMr;
    private String ad;
    private String city;
    private String iEY;
    private String oLZ;
    private String oMa;
    private String oMb;
    private String oMc;
    private String oMd;
    private String oMe;
    private String oMf;
    private String oMg;
    private String oMh;
    private String oMi;
    private String oMj;
    private String oMk;
    private String oMl;
    private String oMm;
    private int oMn;
    private String oMo;
    private String sdk;

    static {
        a aVar = new a();
        aVar.oLZ = "https://api.chushou.tv/";
        aVar.oMa = "https://bee.kascend.com/";
        aVar.iEY = "https://chushou.tv/";
        aVar.oMb = "https://chat.chushou.tv/";
        aVar.oMc = "https://qos-stat.chushou.tv/";
        aVar.oMd = "im.chushou.tv";
        aVar.oMe = "https://imapi.chushou.tv/";
        aVar.oMf = "https://pay.chushou.tv/kaspay/";
        aVar.oMg = "https://gemini.chushou.tv/";
        aVar.oMh = "https://mic.chushou.tv/";
        aVar.ad = "https://ja.chushou.tv/";
        aVar.city = "https://geo.chushou.tv/";
        aVar.oMi = "https://playground.chushou.tv/";
        aVar.oMj = "https://appstat.chushou.tv/";
        aVar.oMk = "https://luck.chushou.tv/";
        aVar.oMl = "https://gmapi.chushou.tv/";
        aVar.oMm = "https://gm.chushou.tv/";
        aVar.sdk = "https://open.chushou.tv/";
        aVar.oMn = 8178;
        aVar.oMo = "rc";
        oMp = aVar;
        a aVar2 = new a();
        aVar2.oLZ = "https://api.vchushou.com/";
        aVar2.oMa = "https://bee.vchushou.com/";
        aVar2.iEY = "https://vchushou.com/";
        aVar2.oMb = "https://chat.vchushou.com/";
        aVar2.oMc = "https://qos-stat.vchushou.com/";
        aVar2.oMd = "im.vchushou.com";
        aVar2.oMe = "https://imapi.vchushou.com/";
        aVar2.oMf = "https://pay.vchushou.com/";
        aVar2.oMg = "https://gemini.vchushou.com/";
        aVar2.oMh = "https://mic.vchushou.com/";
        aVar2.ad = "https://ja.vchushou.com/";
        aVar2.city = "https://geo.vchushou.com/";
        aVar2.oMi = "https://open-game.vchushou.com/";
        aVar2.oMj = "https://vchushou.com/";
        aVar2.oMk = "https://luck.vchushou.com/";
        aVar2.oMl = "https://gamemate.vchushou.com/";
        aVar2.oMm = "https://gamemate.vchushou.com/";
        aVar2.sdk = "https://open.vchushou.com/";
        aVar2.oMn = 8178;
        aVar2.oMo = "https";
        oMq = aVar2;
        oMr = oMp;
    }

    private a() {
    }

    public static void WM(String str) {
        if ("beta".equals(str)) {
            oMr = oMq;
        } else {
            oMr = oMp;
        }
    }

    public static String elV() {
        return oMr.oLZ;
    }

    public static String elW() {
        return oMr.oMa;
    }

    public static String cvE() {
        return oMr.iEY;
    }

    public static String elX() {
        return oMr.oMb;
    }

    public static String elY() {
        return oMr.oMh;
    }

    public static String elZ() {
        return oMr.ad;
    }

    public static String ema() {
        return oMr.oMk;
    }

    public static String emb() {
        return oMr.sdk;
    }
}
