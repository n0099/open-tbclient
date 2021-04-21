package com.qq.e.comm.services;

import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.net.NetworkClient;
import com.qq.e.comm.net.NetworkClientImpl;
import com.qq.e.comm.net.rr.PlainRequest;
import com.qq.e.comm.net.rr.Request;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Random;
/* loaded from: classes6.dex */
public class RetCodeService {

    /* renamed from: a  reason: collision with root package name */
    public final String f38756a;

    /* renamed from: b  reason: collision with root package name */
    public final String f38757b;

    /* renamed from: c  reason: collision with root package name */
    public final Random f38758c;

    /* loaded from: classes6.dex */
    public static class Holder {

        /* renamed from: a  reason: collision with root package name */
        public static final RetCodeService f38759a = new RetCodeService((byte) 0);
    }

    /* loaded from: classes6.dex */
    public static class RetCodeInfo {

        /* renamed from: a  reason: collision with root package name */
        public final String f38760a;

        /* renamed from: b  reason: collision with root package name */
        public final String f38761b;

        /* renamed from: c  reason: collision with root package name */
        public final String f38762c;

        /* renamed from: d  reason: collision with root package name */
        public final int f38763d;

        /* renamed from: e  reason: collision with root package name */
        public final int f38764e;

        /* renamed from: f  reason: collision with root package name */
        public final int f38765f;

        /* renamed from: g  reason: collision with root package name */
        public final int f38766g;

        /* renamed from: h  reason: collision with root package name */
        public final int f38767h;

        public RetCodeInfo(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5) {
            this.f38760a = str;
            this.f38761b = str2;
            this.f38762c = str3;
            this.f38763d = i;
            this.f38764e = i2;
            this.f38765f = i3;
            this.f38766g = i4;
            this.f38767h = i5;
        }

        public String toString() {
            return "RetCodeInfo [host=" + this.f38760a + ", commandid=" + this.f38761b + ", releaseversion=" + this.f38762c + ", resultcode=" + this.f38763d + ", tmcost=" + this.f38764e + ", reqsize=" + this.f38765f + ", rspsize=" + this.f38766g + "]";
        }
    }

    /* loaded from: classes6.dex */
    public class SendTask implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public RetCodeInfo f38768a;

        /* renamed from: b  reason: collision with root package name */
        public int f38769b = 100;

        public SendTask(RetCodeInfo retCodeInfo, int i) {
            this.f38768a = retCodeInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            RetCodeService.a(RetCodeService.this, this.f38768a, this.f38769b);
        }
    }

    public RetCodeService() {
        this.f38756a = "1000162";
        this.f38757b = "http://wspeed.qq.com/w.cgi";
        this.f38758c = new Random(System.currentTimeMillis());
    }

    public /* synthetic */ RetCodeService(byte b2) {
        this();
    }

    public static String a(String str) {
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (UnknownHostException unused) {
            return "0.0.0.0";
        }
    }

    public static /* synthetic */ void a(RetCodeService retCodeService, RetCodeInfo retCodeInfo, int i) {
        if (retCodeService.a(i)) {
            PlainRequest plainRequest = new PlainRequest("http://wspeed.qq.com/w.cgi", Request.Method.GET, (byte[]) null);
            plainRequest.addQuery("appid", "1000162");
            plainRequest.addQuery("resultcode", String.valueOf(retCodeInfo.f38763d));
            plainRequest.addQuery("sdkversion", SDKStatus.getSDKVersion());
            plainRequest.addQuery("touin", "");
            plainRequest.addQuery("tmcost", String.valueOf(retCodeInfo.f38764e));
            plainRequest.addQuery("reqsize", String.valueOf(retCodeInfo.f38765f));
            plainRequest.addQuery("rspsize", String.valueOf(retCodeInfo.f38766g));
            plainRequest.addQuery("frequency", String.valueOf(i));
            try {
                plainRequest.addQuery("commandid", URLEncoder.encode(retCodeInfo.f38761b, "utf-8"));
                plainRequest.addQuery("releaseversion", URLEncoder.encode(retCodeInfo.f38762c, "utf-8"));
                plainRequest.addQuery("serverip", URLEncoder.encode(a(retCodeInfo.f38760a), "utf-8"));
                NetworkClientImpl.getInstance().submit(plainRequest, NetworkClient.Priority.Low);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        if (retCodeService.a(i)) {
            PlainRequest plainRequest2 = new PlainRequest("http://c.isdspeed.qq.com/code.cgi", Request.Method.GET, (byte[]) null);
            plainRequest2.addQuery("domain", retCodeInfo.f38760a);
            plainRequest2.addQuery("cgi", retCodeInfo.f38761b);
            plainRequest2.addQuery("type", String.valueOf(retCodeInfo.f38767h));
            plainRequest2.addQuery("code", String.valueOf(retCodeInfo.f38763d));
            plainRequest2.addQuery("time", String.valueOf(retCodeInfo.f38764e));
            plainRequest2.addQuery("rate", String.valueOf(i));
            NetworkClientImpl.getInstance().submit(plainRequest2, NetworkClient.Priority.Low);
        }
    }

    private boolean a(int i) {
        return this.f38758c.nextDouble() < 1.0d / ((double) i);
    }

    public static RetCodeService getInstance() {
        return Holder.f38759a;
    }

    public void send(RetCodeInfo retCodeInfo) {
        new Thread(new SendTask(retCodeInfo, 100)).start();
    }
}
