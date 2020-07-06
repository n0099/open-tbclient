package tv.chushou.common;
/* loaded from: classes5.dex */
public final class a {
    private static final a ojt;
    private static final a oju;
    private static volatile a ojv;
    private String ad;
    private String city;
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
    private String ojo;
    private String ojp;
    private String ojq;
    private int ojr;
    private String ojs;
    private String sdk;

    static {
        a aVar = new a();
        aVar.ojc = "https://api.chushou.tv/";
        aVar.ojd = "https://bee.kascend.com/";
        aVar.oje = "https://chushou.tv/";
        aVar.ojf = "https://chat.chushou.tv/";
        aVar.ojg = "https://qos-stat.chushou.tv/";
        aVar.ojh = "im.chushou.tv";
        aVar.oji = "https://imapi.chushou.tv/";
        aVar.ojj = "https://pay.chushou.tv/kaspay/";
        aVar.ojk = "https://gemini.chushou.tv/";
        aVar.ojl = "https://mic.chushou.tv/";
        aVar.ad = "https://ja.chushou.tv/";
        aVar.city = "https://geo.chushou.tv/";
        aVar.ojm = "https://playground.chushou.tv/";
        aVar.ojn = "https://appstat.chushou.tv/";
        aVar.ojo = "https://luck.chushou.tv/";
        aVar.ojp = "https://gmapi.chushou.tv/";
        aVar.ojq = "https://gm.chushou.tv/";
        aVar.sdk = "https://open.chushou.tv/";
        aVar.ojr = 8178;
        aVar.ojs = "rc";
        ojt = aVar;
        a aVar2 = new a();
        aVar2.ojc = "https://api.vchushou.com/";
        aVar2.ojd = "https://bee.vchushou.com/";
        aVar2.oje = "https://vchushou.com/";
        aVar2.ojf = "https://chat.vchushou.com/";
        aVar2.ojg = "https://qos-stat.vchushou.com/";
        aVar2.ojh = "im.vchushou.com";
        aVar2.oji = "https://imapi.vchushou.com/";
        aVar2.ojj = "https://pay.vchushou.com/";
        aVar2.ojk = "https://gemini.vchushou.com/";
        aVar2.ojl = "https://mic.vchushou.com/";
        aVar2.ad = "https://ja.vchushou.com/";
        aVar2.city = "https://geo.vchushou.com/";
        aVar2.ojm = "https://open-game.vchushou.com/";
        aVar2.ojn = "https://vchushou.com/";
        aVar2.ojo = "https://luck.vchushou.com/";
        aVar2.ojp = "https://gamemate.vchushou.com/";
        aVar2.ojq = "https://gamemate.vchushou.com/";
        aVar2.sdk = "https://open.vchushou.com/";
        aVar2.ojr = 8178;
        aVar2.ojs = "https";
        oju = aVar2;
        ojv = ojt;
    }

    private a() {
    }

    public static void SX(String str) {
        if ("beta".equals(str)) {
            ojv = oju;
        } else {
            ojv = ojt;
        }
    }

    public static String dWl() {
        return ojv.ojc;
    }

    public static String dWm() {
        return ojv.ojd;
    }

    public static String dWn() {
        return ojv.oje;
    }

    public static String dWo() {
        return ojv.ojf;
    }

    public static String dWp() {
        return ojv.ojl;
    }

    public static String dWq() {
        return ojv.ad;
    }

    public static String dWr() {
        return ojv.ojo;
    }

    public static String dWs() {
        return ojv.sdk;
    }
}
