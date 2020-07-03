package tv.chushou.common;
/* loaded from: classes5.dex */
public final class a {
    private static final a ojq;
    private static final a ojr;
    private static volatile a ojs;
    private String ad;
    private String city;
    private String oiZ;
    private String oja;
    private String ojb;
    private String ojc;
    private String ojd;
    private String oje;
    private String ojf;
    private String ojg;
    private String ojh;
    private String oji;
    private String ojj;
    private String ojk;
    private String ojl;
    private String ojm;
    private String ojn;
    private int ojo;
    private String ojp;
    private String sdk;

    static {
        a aVar = new a();
        aVar.oiZ = "https://api.chushou.tv/";
        aVar.oja = "https://bee.kascend.com/";
        aVar.ojb = "https://chushou.tv/";
        aVar.ojc = "https://chat.chushou.tv/";
        aVar.ojd = "https://qos-stat.chushou.tv/";
        aVar.oje = "im.chushou.tv";
        aVar.ojf = "https://imapi.chushou.tv/";
        aVar.ojg = "https://pay.chushou.tv/kaspay/";
        aVar.ojh = "https://gemini.chushou.tv/";
        aVar.oji = "https://mic.chushou.tv/";
        aVar.ad = "https://ja.chushou.tv/";
        aVar.city = "https://geo.chushou.tv/";
        aVar.ojj = "https://playground.chushou.tv/";
        aVar.ojk = "https://appstat.chushou.tv/";
        aVar.ojl = "https://luck.chushou.tv/";
        aVar.ojm = "https://gmapi.chushou.tv/";
        aVar.ojn = "https://gm.chushou.tv/";
        aVar.sdk = "https://open.chushou.tv/";
        aVar.ojo = 8178;
        aVar.ojp = "rc";
        ojq = aVar;
        a aVar2 = new a();
        aVar2.oiZ = "https://api.vchushou.com/";
        aVar2.oja = "https://bee.vchushou.com/";
        aVar2.ojb = "https://vchushou.com/";
        aVar2.ojc = "https://chat.vchushou.com/";
        aVar2.ojd = "https://qos-stat.vchushou.com/";
        aVar2.oje = "im.vchushou.com";
        aVar2.ojf = "https://imapi.vchushou.com/";
        aVar2.ojg = "https://pay.vchushou.com/";
        aVar2.ojh = "https://gemini.vchushou.com/";
        aVar2.oji = "https://mic.vchushou.com/";
        aVar2.ad = "https://ja.vchushou.com/";
        aVar2.city = "https://geo.vchushou.com/";
        aVar2.ojj = "https://open-game.vchushou.com/";
        aVar2.ojk = "https://vchushou.com/";
        aVar2.ojl = "https://luck.vchushou.com/";
        aVar2.ojm = "https://gamemate.vchushou.com/";
        aVar2.ojn = "https://gamemate.vchushou.com/";
        aVar2.sdk = "https://open.vchushou.com/";
        aVar2.ojo = 8178;
        aVar2.ojp = "https";
        ojr = aVar2;
        ojs = ojq;
    }

    private a() {
    }

    public static void SW(String str) {
        if ("beta".equals(str)) {
            ojs = ojr;
        } else {
            ojs = ojq;
        }
    }

    public static String dWh() {
        return ojs.oiZ;
    }

    public static String dWi() {
        return ojs.oja;
    }

    public static String dWj() {
        return ojs.ojb;
    }

    public static String dWk() {
        return ojs.ojc;
    }

    public static String dWl() {
        return ojs.oji;
    }

    public static String dWm() {
        return ojs.ad;
    }

    public static String dWn() {
        return ojs.ojl;
    }

    public static String dWo() {
        return ojs.sdk;
    }
}
