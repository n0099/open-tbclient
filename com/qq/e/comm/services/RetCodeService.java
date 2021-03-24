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
    public final String f38371a;

    /* renamed from: b  reason: collision with root package name */
    public final String f38372b;

    /* renamed from: c  reason: collision with root package name */
    public final Random f38373c;

    /* loaded from: classes6.dex */
    public static class Holder {

        /* renamed from: a  reason: collision with root package name */
        public static final RetCodeService f38374a = new RetCodeService((byte) 0);
    }

    /* loaded from: classes6.dex */
    public static class RetCodeInfo {

        /* renamed from: a  reason: collision with root package name */
        public final String f38375a;

        /* renamed from: b  reason: collision with root package name */
        public final String f38376b;

        /* renamed from: c  reason: collision with root package name */
        public final String f38377c;

        /* renamed from: d  reason: collision with root package name */
        public final int f38378d;

        /* renamed from: e  reason: collision with root package name */
        public final int f38379e;

        /* renamed from: f  reason: collision with root package name */
        public final int f38380f;

        /* renamed from: g  reason: collision with root package name */
        public final int f38381g;

        /* renamed from: h  reason: collision with root package name */
        public final int f38382h;

        public RetCodeInfo(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5) {
            this.f38375a = str;
            this.f38376b = str2;
            this.f38377c = str3;
            this.f38378d = i;
            this.f38379e = i2;
            this.f38380f = i3;
            this.f38381g = i4;
            this.f38382h = i5;
        }

        public String toString() {
            return "RetCodeInfo [host=" + this.f38375a + ", commandid=" + this.f38376b + ", releaseversion=" + this.f38377c + ", resultcode=" + this.f38378d + ", tmcost=" + this.f38379e + ", reqsize=" + this.f38380f + ", rspsize=" + this.f38381g + "]";
        }
    }

    /* loaded from: classes6.dex */
    public class SendTask implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public RetCodeInfo f38383a;

        /* renamed from: b  reason: collision with root package name */
        public int f38384b = 100;

        public SendTask(RetCodeInfo retCodeInfo, int i) {
            this.f38383a = retCodeInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            RetCodeService.a(RetCodeService.this, this.f38383a, this.f38384b);
        }
    }

    public RetCodeService() {
        this.f38371a = "1000162";
        this.f38372b = "http://wspeed.qq.com/w.cgi";
        this.f38373c = new Random(System.currentTimeMillis());
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
            plainRequest.addQuery("resultcode", String.valueOf(retCodeInfo.f38378d));
            plainRequest.addQuery("sdkversion", SDKStatus.getSDKVersion());
            plainRequest.addQuery("touin", "");
            plainRequest.addQuery("tmcost", String.valueOf(retCodeInfo.f38379e));
            plainRequest.addQuery("reqsize", String.valueOf(retCodeInfo.f38380f));
            plainRequest.addQuery("rspsize", String.valueOf(retCodeInfo.f38381g));
            plainRequest.addQuery("frequency", String.valueOf(i));
            try {
                plainRequest.addQuery("commandid", URLEncoder.encode(retCodeInfo.f38376b, "utf-8"));
                plainRequest.addQuery("releaseversion", URLEncoder.encode(retCodeInfo.f38377c, "utf-8"));
                plainRequest.addQuery("serverip", URLEncoder.encode(a(retCodeInfo.f38375a), "utf-8"));
                NetworkClientImpl.getInstance().submit(plainRequest, NetworkClient.Priority.Low);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        if (retCodeService.a(i)) {
            PlainRequest plainRequest2 = new PlainRequest("http://c.isdspeed.qq.com/code.cgi", Request.Method.GET, (byte[]) null);
            plainRequest2.addQuery("domain", retCodeInfo.f38375a);
            plainRequest2.addQuery("cgi", retCodeInfo.f38376b);
            plainRequest2.addQuery("type", String.valueOf(retCodeInfo.f38382h));
            plainRequest2.addQuery("code", String.valueOf(retCodeInfo.f38378d));
            plainRequest2.addQuery("time", String.valueOf(retCodeInfo.f38379e));
            plainRequest2.addQuery("rate", String.valueOf(i));
            NetworkClientImpl.getInstance().submit(plainRequest2, NetworkClient.Priority.Low);
        }
    }

    private boolean a(int i) {
        double nextDouble = this.f38373c.nextDouble();
        double d2 = i;
        Double.isNaN(d2);
        return nextDouble < 1.0d / d2;
    }

    public static RetCodeService getInstance() {
        return Holder.f38374a;
    }

    public void send(RetCodeInfo retCodeInfo) {
        new Thread(new SendTask(retCodeInfo, 100)).start();
    }
}
