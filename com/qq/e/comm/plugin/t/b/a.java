package com.qq.e.comm.plugin.t.b;

import android.net.Uri;
import com.baidu.webkit.internal.ETAG;
import com.qq.e.comm.plugin.t.b.e;
import com.qq.e.comm.util.StringUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public abstract class a implements e {
    private int c;
    private int d;
    private String e;
    private e.a j;
    private byte[] k;

    /* renamed from: a  reason: collision with root package name */
    private boolean f12825a = true;

    /* renamed from: b  reason: collision with root package name */
    private boolean f12826b = true;
    private Map<String, String> f = new HashMap();
    private Map<String, String> g = new HashMap();
    private Map<String, String> h = Collections.unmodifiableMap(this.f);
    private Map<String, String> i = Collections.unmodifiableMap(this.g);

    public a(String str, e.a aVar, byte[] bArr) {
        this.e = str;
        this.j = aVar;
        if (bArr == null) {
            this.k = null;
        } else {
            this.k = (byte[]) bArr.clone();
        }
    }

    public a(String str, Map<String, String> map, e.a aVar) {
        this.e = str;
        this.j = aVar;
        if (e.a.POST == aVar) {
            StringBuilder sb = new StringBuilder();
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String encode = URLEncoder.encode(entry.getKey(), "utf-8");
                    String encode2 = URLEncoder.encode(entry.getValue(), "utf-8");
                    if (sb.length() > 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(encode);
                    sb.append("=");
                    sb.append(encode2);
                }
                if (sb.length() > 0) {
                    this.k = sb.toString().getBytes("utf-8");
                    a("Content-Type", "application/x-www-form-urlencoded");
                }
            } catch (UnsupportedEncodingException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    @Override // com.qq.e.comm.plugin.t.b.e
    public void a(String str, String str2) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2)) {
            return;
        }
        this.f.put(str, str2);
    }

    @Override // com.qq.e.comm.plugin.t.b.e
    public void a(boolean z) {
        this.f12826b = z;
    }

    @Override // com.qq.e.comm.plugin.t.b.e
    public byte[] a() throws Exception {
        return this.k;
    }

    @Override // com.qq.e.comm.plugin.t.b.e
    public e.a b() {
        return this.j;
    }

    @Override // com.qq.e.comm.plugin.t.b.e
    public void b(String str, String str2) {
        this.g.put(str, str2);
    }

    @Override // com.qq.e.comm.plugin.t.b.e
    public void b(boolean z) {
        this.f12825a = z;
    }

    public String c() {
        return this.e;
    }

    @Override // com.qq.e.comm.plugin.t.b.e
    public Map<String, String> d() {
        return this.h;
    }

    @Override // com.qq.e.comm.plugin.t.b.e
    public Map<String, String> e() {
        return this.i;
    }

    @Override // com.qq.e.comm.plugin.t.b.e
    public String f() {
        if (e().isEmpty()) {
            return c();
        }
        Uri.Builder buildUpon = Uri.parse(c()).buildUpon();
        for (Map.Entry<String, String> entry : e().entrySet()) {
            buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        return buildUpon.build().toString();
    }

    @Override // com.qq.e.comm.plugin.t.b.e
    public int g() {
        return this.c;
    }

    @Override // com.qq.e.comm.plugin.t.b.e
    public int h() {
        return this.d;
    }

    @Override // com.qq.e.comm.plugin.t.b.e
    public boolean i() {
        return this.f12826b;
    }

    @Override // com.qq.e.comm.plugin.t.b.e
    public boolean j() {
        return this.f12825a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((b() == e.a.GET ? "get " : "post ") + "url, ");
        sb.append(f());
        if (b() == e.a.POST) {
            try {
                sb.append(" , " + URLDecoder.decode(new String(this.k, Charset.forName("utf-8"))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
