package tv.chushou.common;
/* loaded from: classes5.dex */
public final class a {
    private static final a nNC;
    private static final a nND;
    private static volatile a nNE;
    private String ad;
    private String city;
    private int nNA;
    private String nNB;
    private String nNl;
    private String nNm;
    private String nNn;
    private String nNo;
    private String nNp;
    private String nNq;
    private String nNr;
    private String nNs;
    private String nNt;
    private String nNu;
    private String nNv;
    private String nNw;
    private String nNx;
    private String nNy;
    private String nNz;
    private String sdk;

    static {
        a aVar = new a();
        aVar.nNl = "https://api.chushou.tv/";
        aVar.nNm = "https://bee.kascend.com/";
        aVar.nNn = "https://chushou.tv/";
        aVar.nNo = "https://chat.chushou.tv/";
        aVar.nNp = "https://qos-stat.chushou.tv/";
        aVar.nNq = "im.chushou.tv";
        aVar.nNr = "https://imapi.chushou.tv/";
        aVar.nNs = "https://pay.chushou.tv/kaspay/";
        aVar.nNt = "https://gemini.chushou.tv/";
        aVar.nNu = "https://mic.chushou.tv/";
        aVar.ad = "https://ja.chushou.tv/";
        aVar.city = "https://geo.chushou.tv/";
        aVar.nNv = "https://playground.chushou.tv/";
        aVar.nNw = "https://appstat.chushou.tv/";
        aVar.nNx = "https://luck.chushou.tv/";
        aVar.nNy = "https://gmapi.chushou.tv/";
        aVar.nNz = "https://gm.chushou.tv/";
        aVar.sdk = "https://open.chushou.tv/";
        aVar.nNA = 8178;
        aVar.nNB = "rc";
        nNC = aVar;
        a aVar2 = new a();
        aVar2.nNl = "https://api.vchushou.com/";
        aVar2.nNm = "https://bee.vchushou.com/";
        aVar2.nNn = "https://vchushou.com/";
        aVar2.nNo = "https://chat.vchushou.com/";
        aVar2.nNp = "https://qos-stat.vchushou.com/";
        aVar2.nNq = "im.vchushou.com";
        aVar2.nNr = "https://imapi.vchushou.com/";
        aVar2.nNs = "https://pay.vchushou.com/";
        aVar2.nNt = "https://gemini.vchushou.com/";
        aVar2.nNu = "https://mic.vchushou.com/";
        aVar2.ad = "https://ja.vchushou.com/";
        aVar2.city = "https://geo.vchushou.com/";
        aVar2.nNv = "https://open-game.vchushou.com/";
        aVar2.nNw = "https://vchushou.com/";
        aVar2.nNx = "https://luck.vchushou.com/";
        aVar2.nNy = "https://gamemate.vchushou.com/";
        aVar2.nNz = "https://gamemate.vchushou.com/";
        aVar2.sdk = "https://open.vchushou.com/";
        aVar2.nNA = 8178;
        aVar2.nNB = "https";
        nND = aVar2;
        nNE = nNC;
    }

    private a() {
    }

    public static void Sk(String str) {
        if ("beta".equals(str)) {
            nNE = nND;
        } else {
            nNE = nNC;
        }
    }

    public static String dRB() {
        return nNE.nNl;
    }

    public static String dRC() {
        return nNE.nNm;
    }

    public static String dRD() {
        return nNE.nNn;
    }

    public static String dRE() {
        return nNE.nNo;
    }

    public static String dRF() {
        return nNE.nNu;
    }

    public static String dRG() {
        return nNE.ad;
    }

    public static String dRH() {
        return nNE.nNx;
    }

    public static String dRI() {
        return nNE.sdk;
    }
}
