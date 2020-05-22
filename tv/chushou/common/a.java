package tv.chushou.common;
/* loaded from: classes5.dex */
public final class a {
    private static final a nMs;
    private static final a nMt;
    private static volatile a nMu;
    private String ad;
    private String city;
    private String nMb;
    private String nMc;
    private String nMd;
    private String nMe;
    private String nMf;
    private String nMg;
    private String nMh;
    private String nMi;
    private String nMj;
    private String nMk;
    private String nMl;
    private String nMm;
    private String nMn;
    private String nMo;
    private String nMp;
    private int nMq;
    private String nMr;
    private String sdk;

    static {
        a aVar = new a();
        aVar.nMb = "https://api.chushou.tv/";
        aVar.nMc = "https://bee.kascend.com/";
        aVar.nMd = "https://chushou.tv/";
        aVar.nMe = "https://chat.chushou.tv/";
        aVar.nMf = "https://qos-stat.chushou.tv/";
        aVar.nMg = "im.chushou.tv";
        aVar.nMh = "https://imapi.chushou.tv/";
        aVar.nMi = "https://pay.chushou.tv/kaspay/";
        aVar.nMj = "https://gemini.chushou.tv/";
        aVar.nMk = "https://mic.chushou.tv/";
        aVar.ad = "https://ja.chushou.tv/";
        aVar.city = "https://geo.chushou.tv/";
        aVar.nMl = "https://playground.chushou.tv/";
        aVar.nMm = "https://appstat.chushou.tv/";
        aVar.nMn = "https://luck.chushou.tv/";
        aVar.nMo = "https://gmapi.chushou.tv/";
        aVar.nMp = "https://gm.chushou.tv/";
        aVar.sdk = "https://open.chushou.tv/";
        aVar.nMq = 8178;
        aVar.nMr = "rc";
        nMs = aVar;
        a aVar2 = new a();
        aVar2.nMb = "https://api.vchushou.com/";
        aVar2.nMc = "https://bee.vchushou.com/";
        aVar2.nMd = "https://vchushou.com/";
        aVar2.nMe = "https://chat.vchushou.com/";
        aVar2.nMf = "https://qos-stat.vchushou.com/";
        aVar2.nMg = "im.vchushou.com";
        aVar2.nMh = "https://imapi.vchushou.com/";
        aVar2.nMi = "https://pay.vchushou.com/";
        aVar2.nMj = "https://gemini.vchushou.com/";
        aVar2.nMk = "https://mic.vchushou.com/";
        aVar2.ad = "https://ja.vchushou.com/";
        aVar2.city = "https://geo.vchushou.com/";
        aVar2.nMl = "https://open-game.vchushou.com/";
        aVar2.nMm = "https://vchushou.com/";
        aVar2.nMn = "https://luck.vchushou.com/";
        aVar2.nMo = "https://gamemate.vchushou.com/";
        aVar2.nMp = "https://gamemate.vchushou.com/";
        aVar2.sdk = "https://open.vchushou.com/";
        aVar2.nMq = 8178;
        aVar2.nMr = "https";
        nMt = aVar2;
        nMu = nMs;
    }

    private a() {
    }

    public static void Sj(String str) {
        if ("beta".equals(str)) {
            nMu = nMt;
        } else {
            nMu = nMs;
        }
    }

    public static String dRn() {
        return nMu.nMb;
    }

    public static String dRo() {
        return nMu.nMc;
    }

    public static String dRp() {
        return nMu.nMd;
    }

    public static String dRq() {
        return nMu.nMe;
    }

    public static String dRr() {
        return nMu.nMk;
    }

    public static String dRs() {
        return nMu.ad;
    }

    public static String dRt() {
        return nMu.nMn;
    }

    public static String dRu() {
        return nMu.sdk;
    }
}
