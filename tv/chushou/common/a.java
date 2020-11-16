package tv.chushou.common;
/* loaded from: classes6.dex */
public final class a {
    private static final a qnA;
    private static final a qnB;
    private static volatile a qnC;
    private String ad;
    private String city;
    private String juk;
    private String qnk;
    private String qnl;
    private String qnm;
    private String qnn;
    private String qno;
    private String qnp;
    private String qnq;
    private String qnr;
    private String qns;
    private String qnt;
    private String qnu;
    private String qnv;
    private String qnw;
    private String qnx;
    private int qny;
    private String qnz;
    private String sdk;

    static {
        a aVar = new a();
        aVar.qnk = "https://api.chushou.tv/";
        aVar.qnl = "https://bee.kascend.com/";
        aVar.juk = "https://chushou.tv/";
        aVar.qnm = "https://chat.chushou.tv/";
        aVar.qnn = "https://qos-stat.chushou.tv/";
        aVar.qno = "im.chushou.tv";
        aVar.qnp = "https://imapi.chushou.tv/";
        aVar.qnq = "https://pay.chushou.tv/kaspay/";
        aVar.qnr = "https://gemini.chushou.tv/";
        aVar.qns = "https://mic.chushou.tv/";
        aVar.ad = "https://ja.chushou.tv/";
        aVar.city = "https://geo.chushou.tv/";
        aVar.qnt = "https://playground.chushou.tv/";
        aVar.qnu = "https://appstat.chushou.tv/";
        aVar.qnv = "https://luck.chushou.tv/";
        aVar.qnw = "https://gmapi.chushou.tv/";
        aVar.qnx = "https://gm.chushou.tv/";
        aVar.sdk = "https://open.chushou.tv/";
        aVar.qny = 8178;
        aVar.qnz = "rc";
        qnA = aVar;
        a aVar2 = new a();
        aVar2.qnk = "https://api.vchushou.com/";
        aVar2.qnl = "https://bee.vchushou.com/";
        aVar2.juk = "https://vchushou.com/";
        aVar2.qnm = "https://chat.vchushou.com/";
        aVar2.qnn = "https://qos-stat.vchushou.com/";
        aVar2.qno = "im.vchushou.com";
        aVar2.qnp = "https://imapi.vchushou.com/";
        aVar2.qnq = "https://pay.vchushou.com/";
        aVar2.qnr = "https://gemini.vchushou.com/";
        aVar2.qns = "https://mic.vchushou.com/";
        aVar2.ad = "https://ja.vchushou.com/";
        aVar2.city = "https://geo.vchushou.com/";
        aVar2.qnt = "https://open-game.vchushou.com/";
        aVar2.qnu = "https://vchushou.com/";
        aVar2.qnv = "https://luck.vchushou.com/";
        aVar2.qnw = "https://gamemate.vchushou.com/";
        aVar2.qnx = "https://gamemate.vchushou.com/";
        aVar2.sdk = "https://open.vchushou.com/";
        aVar2.qny = 8178;
        aVar2.qnz = "https";
        qnB = aVar2;
        qnC = qnA;
    }

    private a() {
    }

    public static void aae(String str) {
        if ("beta".equals(str)) {
            qnC = qnB;
        } else {
            qnC = qnA;
        }
    }

    public static String eHs() {
        return qnC.qnk;
    }

    public static String eHt() {
        return qnC.qnl;
    }

    public static String cHI() {
        return qnC.juk;
    }

    public static String eHu() {
        return qnC.qnm;
    }

    public static String eHv() {
        return qnC.qns;
    }

    public static String eHw() {
        return qnC.ad;
    }

    public static String eHx() {
        return qnC.qnv;
    }

    public static String eHy() {
        return qnC.sdk;
    }
}
