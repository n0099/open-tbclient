package com.qq.e.comm.net.rr;

import android.net.Uri;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.util.StringUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public abstract class AbstractRequest implements Request {

    /* renamed from: b  reason: collision with root package name */
    public int f38741b;

    /* renamed from: c  reason: collision with root package name */
    public int f38742c;

    /* renamed from: d  reason: collision with root package name */
    public int f38743d;

    /* renamed from: e  reason: collision with root package name */
    public String f38744e;
    public Request.Method j;
    public byte[] k;

    /* renamed from: a  reason: collision with root package name */
    public boolean f38740a = true;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f38745f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public Map<String, String> f38746g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f38747h = Collections.unmodifiableMap(this.f38745f);
    public Map<String, String> i = Collections.unmodifiableMap(this.f38746g);

    public AbstractRequest(String str, Request.Method method, byte[] bArr) {
        this.f38744e = str;
        this.j = method;
        this.k = bArr == null ? null : (byte[]) bArr.clone();
    }

    public AbstractRequest(String str, Map<String, String> map, Request.Method method) {
        this.f38744e = str;
        this.j = method;
        if (Request.Method.POST == method) {
            StringBuilder sb = new StringBuilder();
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String encode = URLEncoder.encode(entry.getKey(), "utf-8");
                    String encode2 = URLEncoder.encode(entry.getValue(), "utf-8");
                    if (sb.length() > 0) {
                        sb.append("&");
                    }
                    sb.append(encode);
                    sb.append("=");
                    sb.append(encode2);
                }
                if (sb.length() > 0) {
                    this.k = sb.toString().getBytes("utf-8");
                    addHeader("Content-Type", "application/x-www-form-urlencoded");
                }
            } catch (UnsupportedEncodingException e2) {
                throw new IllegalArgumentException(e2);
            }
        }
    }

    @Override // com.qq.e.comm.net.rr.Request
    public void addHeader(String str, String str2) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2)) {
            return;
        }
        this.f38745f.put(str, str2);
    }

    @Override // com.qq.e.comm.net.rr.Request
    public void addQuery(String str, String str2) {
        this.f38746g.put(str, str2);
    }

    @Override // com.qq.e.comm.net.rr.Request
    public int getConnectionTimeOut() {
        return this.f38742c;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public Map<String, String> getHeaders() {
        return this.f38747h;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public Request.Method getMethod() {
        return this.j;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public byte[] getPostData() throws Exception {
        return this.k;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public int getPriority() {
        return this.f38741b;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public Map<String, String> getQuerys() {
        return this.i;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public int getSocketTimeOut() {
        return this.f38743d;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public String getUrl() {
        return this.f38744e;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public String getUrlWithParas() {
        if (getQuerys().isEmpty()) {
            return getUrl();
        }
        Uri.Builder buildUpon = Uri.parse(getUrl()).buildUpon();
        for (Map.Entry<String, String> entry : getQuerys().entrySet()) {
            buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        return buildUpon.build().toString();
    }

    @Override // com.qq.e.comm.net.rr.Request
    public boolean isAutoClose() {
        return this.f38740a;
    }

    public void setAutoClose(boolean z) {
        this.f38740a = z;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public void setConnectionTimeOut(int i) {
        this.f38742c = i;
    }

    public void setPriority(int i) {
        this.f38741b = i;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public void setSocketTimeOut(int i) {
        this.f38743d = i;
    }
}
