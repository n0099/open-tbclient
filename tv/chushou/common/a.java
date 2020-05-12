package tv.chushou.common;
/* loaded from: classes5.dex */
public final class a {
    private static final a nrv;
    private static final a nrw;
    private static volatile a nrx;
    private String ad;
    private String city;
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
    private String nrq;
    private String nrr;
    private String nrs;
    private int nrt;
    private String nru;
    private String sdk;

    static {
        a aVar = new a();
        aVar.nre = "https://api.chushou.tv/";
        aVar.nrf = "https://bee.kascend.com/";
        aVar.nrg = "https://chushou.tv/";
        aVar.nrh = "https://chat.chushou.tv/";
        aVar.nri = "https://qos-stat.chushou.tv/";
        aVar.nrj = "im.chushou.tv";
        aVar.nrk = "https://imapi.chushou.tv/";
        aVar.nrl = "https://pay.chushou.tv/kaspay/";
        aVar.nrm = "https://gemini.chushou.tv/";
        aVar.nrn = "https://mic.chushou.tv/";
        aVar.ad = "https://ja.chushou.tv/";
        aVar.city = "https://geo.chushou.tv/";
        aVar.nro = "https://playground.chushou.tv/";
        aVar.nrp = "https://appstat.chushou.tv/";
        aVar.nrq = "https://luck.chushou.tv/";
        aVar.nrr = "https://gmapi.chushou.tv/";
        aVar.nrs = "https://gm.chushou.tv/";
        aVar.sdk = "https://open.chushou.tv/";
        aVar.nrt = 8178;
        aVar.nru = "rc";
        nrv = aVar;
        a aVar2 = new a();
        aVar2.nre = "https://api.vchushou.com/";
        aVar2.nrf = "https://bee.vchushou.com/";
        aVar2.nrg = "https://vchushou.com/";
        aVar2.nrh = "https://chat.vchushou.com/";
        aVar2.nri = "https://qos-stat.vchushou.com/";
        aVar2.nrj = "im.vchushou.com";
        aVar2.nrk = "https://imapi.vchushou.com/";
        aVar2.nrl = "https://pay.vchushou.com/";
        aVar2.nrm = "https://gemini.vchushou.com/";
        aVar2.nrn = "https://mic.vchushou.com/";
        aVar2.ad = "https://ja.vchushou.com/";
        aVar2.city = "https://geo.vchushou.com/";
        aVar2.nro = "https://open-game.vchushou.com/";
        aVar2.nrp = "https://vchushou.com/";
        aVar2.nrq = "https://luck.vchushou.com/";
        aVar2.nrr = "https://gamemate.vchushou.com/";
        aVar2.nrs = "https://gamemate.vchushou.com/";
        aVar2.sdk = "https://open.vchushou.com/";
        aVar2.nrt = 8178;
        aVar2.nru = "https";
        nrw = aVar2;
        nrx = nrv;
    }

    private a() {
    }

    public static void Qd(String str) {
        if ("beta".equals(str)) {
            nrx = nrw;
        } else {
            nrx = nrv;
        }
    }

    public static String dJt() {
        return nrx.nre;
    }

    public static String dJu() {
        return nrx.nrf;
    }

    public static String dJv() {
        return nrx.nrg;
    }

    public static String dJw() {
        return nrx.nrh;
    }

    public static String dJx() {
        return nrx.nrn;
    }

    public static String dJy() {
        return nrx.ad;
    }

    public static String dJz() {
        return nrx.nrq;
    }

    public static String dJA() {
        return nrx.sdk;
    }
}
