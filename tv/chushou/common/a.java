package tv.chushou.common;
/* loaded from: classes5.dex */
public final class a {
    private static final a nrs;
    private static final a nrt;
    private static volatile a nru;
    private String ad;
    private String city;
    private String nrb;
    private String nrc;
    private String nrd;
    private String nre;
    private String nrf;
    private String nrg;
    private String nrh;
    private String nri;
    private String nrj;
    private String nrk;
    private String nrl;
    private String nrm;
    private String nrn;
    private String nro;
    private String nrp;
    private int nrq;
    private String nrr;
    private String sdk;

    static {
        a aVar = new a();
        aVar.nrb = "https://api.chushou.tv/";
        aVar.nrc = "https://bee.kascend.com/";
        aVar.nrd = "https://chushou.tv/";
        aVar.nre = "https://chat.chushou.tv/";
        aVar.nrf = "https://qos-stat.chushou.tv/";
        aVar.nrg = "im.chushou.tv";
        aVar.nrh = "https://imapi.chushou.tv/";
        aVar.nri = "https://pay.chushou.tv/kaspay/";
        aVar.nrj = "https://gemini.chushou.tv/";
        aVar.nrk = "https://mic.chushou.tv/";
        aVar.ad = "https://ja.chushou.tv/";
        aVar.city = "https://geo.chushou.tv/";
        aVar.nrl = "https://playground.chushou.tv/";
        aVar.nrm = "https://appstat.chushou.tv/";
        aVar.nrn = "https://luck.chushou.tv/";
        aVar.nro = "https://gmapi.chushou.tv/";
        aVar.nrp = "https://gm.chushou.tv/";
        aVar.sdk = "https://open.chushou.tv/";
        aVar.nrq = 8178;
        aVar.nrr = "rc";
        nrs = aVar;
        a aVar2 = new a();
        aVar2.nrb = "https://api.vchushou.com/";
        aVar2.nrc = "https://bee.vchushou.com/";
        aVar2.nrd = "https://vchushou.com/";
        aVar2.nre = "https://chat.vchushou.com/";
        aVar2.nrf = "https://qos-stat.vchushou.com/";
        aVar2.nrg = "im.vchushou.com";
        aVar2.nrh = "https://imapi.vchushou.com/";
        aVar2.nri = "https://pay.vchushou.com/";
        aVar2.nrj = "https://gemini.vchushou.com/";
        aVar2.nrk = "https://mic.vchushou.com/";
        aVar2.ad = "https://ja.vchushou.com/";
        aVar2.city = "https://geo.vchushou.com/";
        aVar2.nrl = "https://open-game.vchushou.com/";
        aVar2.nrm = "https://vchushou.com/";
        aVar2.nrn = "https://luck.vchushou.com/";
        aVar2.nro = "https://gamemate.vchushou.com/";
        aVar2.nrp = "https://gamemate.vchushou.com/";
        aVar2.sdk = "https://open.vchushou.com/";
        aVar2.nrq = 8178;
        aVar2.nrr = "https";
        nrt = aVar2;
        nru = nrs;
    }

    private a() {
    }

    public static void Qa(String str) {
        if ("beta".equals(str)) {
            nru = nrt;
        } else {
            nru = nrs;
        }
    }

    public static String dJw() {
        return nru.nrb;
    }

    public static String dJx() {
        return nru.nrc;
    }

    public static String dJy() {
        return nru.nrd;
    }

    public static String dJz() {
        return nru.nre;
    }

    public static String dJA() {
        return nru.nrk;
    }

    public static String dJB() {
        return nru.ad;
    }

    public static String dJC() {
        return nru.nrn;
    }

    public static String dJD() {
        return nru.sdk;
    }
}
