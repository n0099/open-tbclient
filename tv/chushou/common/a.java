package tv.chushou.common;
/* loaded from: classes6.dex */
public final class a {
    private static final a pln;
    private static final a plo;
    private static volatile a plp;
    private String ad;
    private String city;
    private String jbl;
    private String pkX;
    private String pkY;
    private String pkZ;
    private String pla;
    private String plb;
    private String plc;
    private String pld;
    private String ple;
    private String plf;
    private String plg;
    private String plh;
    private String pli;
    private String plj;
    private String plk;
    private int pll;
    private String plm;
    private String sdk;

    static {
        a aVar = new a();
        aVar.pkX = "https://api.chushou.tv/";
        aVar.pkY = "https://bee.kascend.com/";
        aVar.jbl = "https://chushou.tv/";
        aVar.pkZ = "https://chat.chushou.tv/";
        aVar.pla = "https://qos-stat.chushou.tv/";
        aVar.plb = "im.chushou.tv";
        aVar.plc = "https://imapi.chushou.tv/";
        aVar.pld = "https://pay.chushou.tv/kaspay/";
        aVar.ple = "https://gemini.chushou.tv/";
        aVar.plf = "https://mic.chushou.tv/";
        aVar.ad = "https://ja.chushou.tv/";
        aVar.city = "https://geo.chushou.tv/";
        aVar.plg = "https://playground.chushou.tv/";
        aVar.plh = "https://appstat.chushou.tv/";
        aVar.pli = "https://luck.chushou.tv/";
        aVar.plj = "https://gmapi.chushou.tv/";
        aVar.plk = "https://gm.chushou.tv/";
        aVar.sdk = "https://open.chushou.tv/";
        aVar.pll = 8178;
        aVar.plm = "rc";
        pln = aVar;
        a aVar2 = new a();
        aVar2.pkX = "https://api.vchushou.com/";
        aVar2.pkY = "https://bee.vchushou.com/";
        aVar2.jbl = "https://vchushou.com/";
        aVar2.pkZ = "https://chat.vchushou.com/";
        aVar2.pla = "https://qos-stat.vchushou.com/";
        aVar2.plb = "im.vchushou.com";
        aVar2.plc = "https://imapi.vchushou.com/";
        aVar2.pld = "https://pay.vchushou.com/";
        aVar2.ple = "https://gemini.vchushou.com/";
        aVar2.plf = "https://mic.vchushou.com/";
        aVar2.ad = "https://ja.vchushou.com/";
        aVar2.city = "https://geo.vchushou.com/";
        aVar2.plg = "https://open-game.vchushou.com/";
        aVar2.plh = "https://vchushou.com/";
        aVar2.pli = "https://luck.vchushou.com/";
        aVar2.plj = "https://gamemate.vchushou.com/";
        aVar2.plk = "https://gamemate.vchushou.com/";
        aVar2.sdk = "https://open.vchushou.com/";
        aVar2.pll = 8178;
        aVar2.plm = "https";
        plo = aVar2;
        plp = pln;
    }

    private a() {
    }

    public static void Yc(String str) {
        if ("beta".equals(str)) {
            plp = plo;
        } else {
            plp = pln;
        }
    }

    public static String etE() {
        return plp.pkX;
    }

    public static String etF() {
        return plp.pkY;
    }

    public static String cCv() {
        return plp.jbl;
    }

    public static String etG() {
        return plp.pkZ;
    }

    public static String etH() {
        return plp.plf;
    }

    public static String etI() {
        return plp.ad;
    }

    public static String etJ() {
        return plp.pli;
    }

    public static String etK() {
        return plp.sdk;
    }
}
