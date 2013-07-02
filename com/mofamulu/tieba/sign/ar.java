package com.mofamulu.tieba.sign;

import com.baidu.browser.core.util.BdUtil;
import com.baidu.cyberplayer.sdk.internal.VersionUtils;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.data.av;
import com.baidu.tieba.util.DatabaseService;
import com.mofamulu.tieba.ch.bf;
import com.mofamulu.tieba.ch.bg;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.cookie.Cookie;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes.dex */
public class ar {
    private final String a;
    private String b;
    private String c;
    private final al f;
    private final bg g;
    private long i;
    private boolean j;
    private int k;
    private List l;
    private List m;
    private Map o;
    private String r;
    private String s;
    private String d = "";
    private boolean e = false;
    private LinkedList n = new LinkedList();
    private boolean p = true;
    private boolean q = true;
    private final com.mofamulu.tieba.ch.af h = com.mofamulu.tieba.ch.af.a();

    protected String a(boolean z) {
        return (z && this.g.n() && this.g.a(this.a, false)) ? "Mozilla/5.0 (Linux; U; Android 4.1.2; zh-cn; MB526 Build/JZO54K) AppleWebKit/530.17 (KHTML, like Gecko) FlyFlow/2.4 Version/4.0 Mobile Safari/530.17 baidubrowser/042_1.8.4.2_diordna_458_084/alorotoM_61_2.1.4_625BM/1200a/39668C8F77034455D4DED02169F3F7C7%7C132773740707453/1" : "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.22 (KHTML, like Gecko) Chrome/25.0.1364.5 Safari/537.22";
    }

    public com.mofamulu.tieba.ch.af a() {
        return this.h;
    }

    public String b() {
        Iterator it = this.n.iterator();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (it.hasNext()) {
            as asVar = (as) it.next();
            if (asVar.c() == 10) {
                i4++;
            } else if (asVar.c() == 2) {
                i3++;
            } else if (asVar.c() == 1) {
                i2++;
            } else {
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("成功：").append(i4).append("个，失败：").append(i2).append("个，不支持：").append(i3).append("个；忽略：").append(this.l != null ? this.l.size() : 0).append("个。").append("个；剩余：").append(i).append("个");
        return sb.toString();
    }

    public String c() {
        if (this.o == null) {
            return null;
        }
        String str = (String) this.o.get("login_bdverify");
        if (bf.a(str)) {
            str = (String) this.o.get("vcodestr");
        }
        return "http://wappass.baidu.com/cgi-bin/genimage?" + str.replace("+", "%2B");
    }

    private ar(bg bgVar, al alVar, String str) {
        this.g = bgVar;
        this.f = alVar;
        this.a = str;
    }

    public static ar a(bg bgVar, al alVar, String str, String str2, String str3) {
        ar arVar = new ar(bgVar, alVar, str);
        arVar.b = str2;
        if (bf.b(str3)) {
            arVar.d = str3;
            arVar.e = true;
        }
        return arVar;
    }

    public static ar a(bg bgVar, al alVar, String str) {
        AccountData n = DatabaseService.n(str);
        if (n == null) {
            return null;
        }
        ar arVar = new ar(bgVar, alVar, str);
        arVar.b = null;
        arVar.d = "client";
        arVar.e = false;
        arVar.r = n.getBDUSS();
        arVar.s = n.getTbs();
        arVar.a().a(n);
        return arVar;
    }

    public String d() {
        return this.d;
    }

    public void e() {
        if (this.d.length() == 0) {
            j();
        }
        p();
    }

    public boolean f() {
        return System.currentTimeMillis() >= this.i;
    }

    public boolean g() {
        return this.j;
    }

    public boolean h() {
        boolean z;
        boolean z2;
        Iterator it = this.n.iterator();
        boolean z3 = false;
        int i = 0;
        boolean z4 = true;
        while (true) {
            if (!it.hasNext()) {
                z = z3;
                break;
            }
            as asVar = (as) it.next();
            try {
                if (asVar.c() == 10) {
                    i++;
                } else if (i >= o()) {
                    z = z3;
                    z4 = true;
                    break;
                } else if (com.mofamulu.tieba.ch.as.a(this.a)) {
                    z = z3;
                    z4 = true;
                    break;
                } else if (asVar.e() <= 2) {
                    try {
                        asVar.a(System.currentTimeMillis());
                        asVar.b(asVar.e() + 1);
                        if (this.g.a(this.a, false) && this.g.v()) {
                            z = b(asVar);
                        } else {
                            z = a(asVar);
                        }
                        if (z) {
                            try {
                                this.i = System.currentTimeMillis() + ((this.g.s() + ((int) (this.g.t() * Math.random()))) * LocationClientOption.MIN_SCAN_SPAN);
                                z4 = false;
                                break;
                            } catch (Throwable th) {
                                z2 = false;
                                z4 = z2;
                                z3 = z;
                            }
                        } else {
                            z3 = z;
                            z4 = false;
                        }
                    } catch (Throwable th2) {
                        z = z3;
                        z2 = false;
                    }
                } else {
                    continue;
                }
            } catch (Throwable th3) {
                z = z3;
                z2 = z4;
            }
        }
        if (z4) {
            this.j = true;
            if (this.g.o()) {
                i();
            }
            this.f.a(false);
            return true;
        }
        return z;
    }

    private boolean a(as asVar) {
        at.a(asVar, a("m?kw=" + URLEncoder.encode(asVar.b(), "GBK"), false));
        if (asVar.c() == 11) {
            asVar.a(10);
            asVar.b("已签到");
        } else if (asVar.c() == 2) {
            asVar.b("不支持签到");
        } else {
            String a = a(asVar.d(), true);
            if (a.contains("<title>贴吧客户端下载</title>")) {
                a = a(asVar.d(), false);
            }
            at.b(asVar, a);
            if (asVar.c() == 10) {
                asVar.c(null);
                this.k++;
            }
            return true;
        }
        return false;
    }

    private boolean b(as asVar) {
        av avVar;
        com.baidu.tieba.util.r rVar = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.a) + "c/c/forum/sign");
        try {
            a(rVar);
            rVar.a("kw", asVar.b);
            rVar.a("fid", asVar.a);
            rVar.d(true);
            String j = rVar.j();
            if (!rVar.d() || !rVar.c()) {
                avVar = null;
            } else {
                avVar = new av();
                try {
                    avVar.a(j);
                } catch (Throwable th) {
                }
            }
        } catch (Throwable th2) {
            avVar = null;
        }
        if (avVar != null) {
            if (avVar.b() == 1) {
                StringBuilder sb = new StringBuilder();
                if (avVar.a() > 0) {
                    sb.append("签到成功，你是今天第").append(avVar.c()).append("个签到的。");
                } else {
                    sb.append("签到成功，经验+").append(avVar.f()).append("，你是今天第").append(avVar.c()).append("个签到的，已连续签到").append(avVar.d()).append("天").append("，总共签到").append(avVar.e()).append("天");
                }
                asVar.a(10);
                asVar.b(sb.toString());
            } else {
                asVar.a(2);
                asVar.b("不支持签到");
            }
        } else if (rVar.e() == 160002) {
            asVar.a(10);
            asVar.b("已签到");
        } else {
            String g = rVar.g();
            if (g == null) {
                g = "";
            }
            if (g.contains("服务器开小差了")) {
                asVar.a(2);
                asVar.b("不支持签到");
            } else {
                asVar.a(1);
                asVar.b(g);
            }
        }
        return true;
    }

    public void i() {
        this.c = "http://zhidao.baidu.com/question/149638965.html";
        HashMap hashMap = new HashMap();
        hashMap.put("cm", "100509");
        hashMap.put("t", String.valueOf(System.currentTimeMillis()));
        try {
            b("http://zhidao.baidu.com/submit/user", hashMap, "UTF-8");
        } catch (Exception e) {
        }
    }

    public void j() {
        String a = a("http://wapp.baidu.com/", false);
        String b = at.b(a);
        String h = at.h(a);
        if (bf.b(h)) {
            this.d = h;
        } else if (b == null) {
            if (!this.p) {
                this.p = true;
                try {
                    k();
                    return;
                } catch (Throwable th) {
                }
            }
            throw new Exception("获取登录地址错误！");
        } else {
            Map c = at.c(a(b, false));
            c.put("u", "http://wapp.baidu.com/");
            c.put("login_username", this.a);
            c.put("login_loginpass", URLEncoder.encode(this.b, "UTF-8"));
            a(c);
        }
    }

    public void a(String str) {
        Map map = this.o;
        map.put("login_verifycode", str);
        map.put("verifycode", str);
        a(map);
    }

    public void a(Map map) {
        map.put("username", this.a);
        map.put("password", URLEncoder.encode(this.b, "UTF-8"));
        String b = b((String) map.get("_PARAM_WAP_LOGIN_URL"), map, "UTF-8");
        if (b.startsWith("http")) {
            this.d = at.h(a(b, false));
            if (bf.a(this.d)) {
                throw new Exception("数据解析错误！");
            }
        } else if (at.e(b)) {
            this.d = at.h(a(at.f(b), false));
            if (bf.a(this.d)) {
                throw new Exception("数据解析错误，请到设置各种杂项设置中检查是否有新版本升级！");
            }
        } else {
            String g = at.g(b);
            if (g == null || g.contains("验证码")) {
                this.o = at.d(b);
                if (!this.p) {
                    this.p = true;
                    try {
                        k();
                        return;
                    } catch (Throwable th) {
                    }
                }
            }
            if (bf.a(g)) {
                this.d = at.h(b);
                if (!bf.b(this.d)) {
                    g = "登录失败，页面无法解析。请到设置->各种杂项设置中检查更新。";
                } else {
                    return;
                }
            }
            throw new Exception(g);
        }
    }

    public void k() {
        a("http://www.baidu.com/", (Map) null, "UTF-8");
        Matcher matcher = Pattern.compile("bdPass\\.api\\.params\\.login_token='(\\w+)'").matcher(a("https://passport.baidu.com/v2/api/?getapi&class=login&tpl=mn&tangram=true", (Map) null, "UTF-8"));
        if (matcher.find()) {
            String group = matcher.group(1);
            HashMap hashMap = new HashMap();
            hashMap.put("username", this.a);
            hashMap.put("password", URLEncoder.encode(this.b, "UTF-8"));
            hashMap.put("mem_pass", "on");
            hashMap.put("charset", BdUtil.UTF8);
            hashMap.put("isPhone", "false");
            hashMap.put("index", "0");
            hashMap.put("staticpage", "http://www.baidu.com/cache/user/html/jump.html");
            hashMap.put("loginType", "1");
            hashMap.put("tpl", "mn");
            hashMap.put("codestring", "");
            hashMap.put("callback", "parent.bdPass.api.login._postCallback");
            hashMap.put("token", group);
            b("https://passport.baidu.com/v2/api/?login", hashMap, "UTF-8");
            a("http://www.baidu.com/", (Map) null, "UTF-8");
            a("http://tieba.baidu.com/", (Map) null, "UTF-8");
            a("http://wapp.baidu.com/m?tn=bdFBW&tab=favorite", false);
            this.d = at.h(a("http://wapp.baidu.com/", false));
            if (bf.a(this.d)) {
                throw new Exception("无法登录2，需要验证码！");
            }
            return;
        }
        throw new Exception("数据格式2错误！");
    }

    protected void a(com.baidu.tieba.util.r rVar) {
        String str;
        String str2;
        String str3 = null;
        if (this.r != null) {
            rVar.a = this.r;
            rVar.b = this.s;
            return;
        }
        List e = this.h.e();
        if (e == null || e.isEmpty()) {
            throw new RuntimeException("未登录！");
        }
        int i = 0;
        String str4 = null;
        while (i < e.size()) {
            Cookie cookie = (Cookie) e.get(i);
            if ("BDUSS".equalsIgnoreCase(cookie.getName())) {
                String str5 = str3;
                str2 = cookie.getValue();
                str = str5;
            } else if ("PTOKEN".equalsIgnoreCase(cookie.getName())) {
                str = cookie.getValue();
                str2 = str4;
            } else {
                if ("TBS".equalsIgnoreCase(cookie.getName())) {
                    rVar.b = cookie.getValue();
                }
                str = str3;
                str2 = str4;
            }
            i++;
            str4 = str2;
            str3 = str;
        }
        if (str4 == null) {
            throw new RuntimeException("未登录！");
        }
        if (str3 != null) {
            str4 = String.valueOf(str4) + "|" + str3;
        }
        rVar.a = str4;
    }

    public List l() {
        com.baidu.tieba.model.b bVar;
        ArrayList b;
        try {
            com.baidu.tieba.util.r rVar = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.a) + "c/f/forum/like");
            a(rVar);
            String j = rVar.j();
            if (!rVar.c()) {
                bVar = null;
            } else {
                bVar = new com.baidu.tieba.model.b();
                try {
                    bVar.a(j);
                } catch (Throwable th) {
                }
            }
        } catch (Throwable th2) {
            bVar = null;
        }
        LinkedList linkedList = new LinkedList();
        if (bVar != null && bVar.a() && (b = bVar.b()) != null) {
            Iterator it = b.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.data.r rVar2 = (com.baidu.tieba.data.r) it.next();
                au auVar = new au();
                auVar.a = rVar2.a();
                auVar.b = rVar2.b();
                auVar.d = rVar2.f();
                auVar.c = rVar2.o();
                linkedList.add(auVar);
            }
        }
        return linkedList;
    }

    public List m() {
        return at.i(a("m?tn=bdFBW&tab=favorite", false));
    }

    public List n() {
        List a;
        LinkedList linkedList = new LinkedList();
        int i = 1;
        int i2 = 0;
        while (i <= o() / 20) {
            try {
                byte[] a2 = a("http://tieba.baidu.com/f/like/mylike?&pn=" + i, null, "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.22 (KHTML, like Gecko) Chrome/25.0.1364.5 Safari/537.22", "UTF-8");
                String str = new String(a2, "GBK");
                if (!str.contains("吧名")) {
                    str = new String(a2, "UTF-8");
                }
                a = at.a(str);
                linkedList.addAll(a);
                try {
                } catch (Throwable th) {
                    i2 = 0;
                    i2++;
                    if (i2 < 5) {
                        i--;
                        i++;
                    } else {
                        return linkedList;
                    }
                }
            } catch (Throwable th2) {
            }
            if (a.size() < 20) {
                break;
            }
            i2 = 0;
            i++;
        }
        return linkedList;
    }

    protected int o() {
        if (this.g.j()) {
            return VersionUtils.CUR_DEVELOPMENT;
        }
        return 200;
    }

    public void p() {
        List<au> n;
        if (this.m == null || this.m.isEmpty()) {
            if (this.g.a(this.a, false) && this.g.v()) {
                n = l();
            } else {
                n = n();
                if (n.isEmpty()) {
                    n = m();
                }
                if ((n == null || n.isEmpty()) && this.e) {
                    this.e = false;
                    j();
                    p();
                    return;
                }
            }
            for (au auVar : n) {
                a(auVar.a, auVar.b);
            }
        } else {
            List l = (this.g.a(this.a, false) && this.g.v()) ? l() : null;
            for (String str : this.m) {
                if (l == null) {
                    a((String) null, str);
                } else {
                    Iterator it = l.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            au auVar2 = (au) it.next();
                            if (str.equalsIgnoreCase(auVar2.b)) {
                                a(auVar2.a, str);
                                break;
                            }
                        }
                    }
                }
            }
        }
        this.f.a(this.n);
    }

    private void a(String str, String str2) {
        boolean z;
        if (!bf.a(str2)) {
            if (this.l != null) {
                Iterator it = this.l.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    } else if (str2.equalsIgnoreCase((String) it.next())) {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    return;
                }
            }
            as asVar = new as();
            asVar.a(str2);
            asVar.d(str);
            this.n.addLast(asVar);
        }
    }

    public String q() {
        List<Cookie> e = this.h.e();
        if (e == null || e.isEmpty()) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        for (Cookie cookie : e) {
            jSONArray.put(new aa(cookie).a());
        }
        return jSONArray.toString();
    }

    public void b(String str) {
        if (!bf.a(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    a((Cookie) new aa(jSONArray.getJSONObject(i)).b());
                }
            } catch (JSONException e) {
            }
        }
    }

    public void a(Cookie cookie) {
        this.h.a(cookie);
    }

    public String a(String str, Map map, String str2) {
        return new String(a(str, map, "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.22 (KHTML, like Gecko) Chrome/25.0.1364.5 Safari/537.22", "UTF-8"), str2);
    }

    public byte[] a(String str, Map map, String str2, String str3) {
        this.c = str;
        return this.h.b(str, map, this.c, str2, str3);
    }

    public String a(String str, boolean z) {
        if (!str.startsWith("http:")) {
            if (str.startsWith("/")) {
                str = "http://wapp.baidu.com" + str;
            } else {
                str = "http://wapp.baidu.com/" + this.d + "/" + str;
            }
        }
        String b = bf.b(str, "&amp;", "&");
        this.c = b;
        return this.h.a(b, (Map) null, this.c, a(z), "UTF-8");
    }

    public String b(String str, Map map, String str2) {
        return this.h.a(str, map, this.c, "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.22 (KHTML, like Gecko) Chrome/25.0.1364.5 Safari/537.22", str2, str2);
    }

    public LinkedList r() {
        return this.n;
    }

    public void a(List list) {
        this.l = list;
    }

    public String s() {
        return this.a;
    }

    public al t() {
        return this.f;
    }

    public List u() {
        return this.m;
    }

    public void b(List list) {
        this.m = list;
    }
}
