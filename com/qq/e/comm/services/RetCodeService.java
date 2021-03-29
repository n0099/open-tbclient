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
    public final String f38372a;

    /* renamed from: b  reason: collision with root package name */
    public final String f38373b;

    /* renamed from: c  reason: collision with root package name */
    public final Random f38374c;

    /* loaded from: classes6.dex */
    public static class Holder {

        /* renamed from: a  reason: collision with root package name */
        public static final RetCodeService f38375a = new RetCodeService((byte) 0);
    }

    /* loaded from: classes6.dex */
    public static class RetCodeInfo {

        /* renamed from: a  reason: collision with root package name */
        public final String f38376a;

        /* renamed from: b  reason: collision with root package name */
        public final String f38377b;

        /* renamed from: c  reason: collision with root package name */
        public final String f38378c;

        /* renamed from: d  reason: collision with root package name */
        public final int f38379d;

        /* renamed from: e  reason: collision with root package name */
        public final int f38380e;

        /* renamed from: f  reason: collision with root package name */
        public final int f38381f;

        /* renamed from: g  reason: collision with root package name */
        public final int f38382g;

        /* renamed from: h  reason: collision with root package name */
        public final int f38383h;

        public RetCodeInfo(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5) {
            this.f38376a = str;
            this.f38377b = str2;
            this.f38378c = str3;
            this.f38379d = i;
            this.f38380e = i2;
            this.f38381f = i3;
            this.f38382g = i4;
            this.f38383h = i5;
        }

        public String toString() {
            return "RetCodeInfo [host=" + this.f38376a + ", commandid=" + this.f38377b + ", releaseversion=" + this.f38378c + ", resultcode=" + this.f38379d + ", tmcost=" + this.f38380e + ", reqsize=" + this.f38381f + ", rspsize=" + this.f38382g + "]";
        }
    }

    /* loaded from: classes6.dex */
    public class SendTask implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public RetCodeInfo f38384a;

        /* renamed from: b  reason: collision with root package name */
        public int f38385b = 100;

        public SendTask(RetCodeInfo retCodeInfo, int i) {
            this.f38384a = retCodeInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            RetCodeService.a(RetCodeService.this, this.f38384a, this.f38385b);
        }
    }

    public RetCodeService() {
        this.f38372a = "1000162";
        this.f38373b = "http://wspeed.qq.com/w.cgi";
        this.f38374c = new Random(System.currentTimeMillis());
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
            plainRequest.addQuery("resultcode", String.valueOf(retCodeInfo.f38379d));
            plainRequest.addQuery("sdkversion", SDKStatus.getSDKVersion());
            plainRequest.addQuery("touin", "");
            plainRequest.addQuery("tmcost", String.valueOf(retCodeInfo.f38380e));
            plainRequest.addQuery("reqsize", String.valueOf(retCodeInfo.f38381f));
            plainRequest.addQuery("rspsize", String.valueOf(retCodeInfo.f38382g));
            plainRequest.addQuery("frequency", String.valueOf(i));
            try {
                plainRequest.addQuery("commandid", URLEncoder.encode(retCodeInfo.f38377b, "utf-8"));
                plainRequest.addQuery("releaseversion", URLEncoder.encode(retCodeInfo.f38378c, "utf-8"));
                plainRequest.addQuery("serverip", URLEncoder.encode(a(retCodeInfo.f38376a), "utf-8"));
                NetworkClientImpl.getInstance().submit(plainRequest, NetworkClient.Priority.Low);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        if (retCodeService.a(i)) {
            PlainRequest plainRequest2 = new PlainRequest("http://c.isdspeed.qq.com/code.cgi", Request.Method.GET, (byte[]) null);
            plainRequest2.addQuery("domain", retCodeInfo.f38376a);
            plainRequest2.addQuery("cgi", retCodeInfo.f38377b);
            plainRequest2.addQuery("type", String.valueOf(retCodeInfo.f38383h));
            plainRequest2.addQuery("code", String.valueOf(retCodeInfo.f38379d));
            plainRequest2.addQuery("time", String.valueOf(retCodeInfo.f38380e));
            plainRequest2.addQuery("rate", String.valueOf(i));
            NetworkClientImpl.getInstance().submit(plainRequest2, NetworkClient.Priority.Low);
        }
    }

    private boolean a(int i) {
        return this.f38374c.nextDouble() < 1.0d / ((double) i);
    }

    public static RetCodeService getInstance() {
        return Holder.f38375a;
    }

    public void send(RetCodeInfo retCodeInfo) {
        new Thread(new SendTask(retCodeInfo, 100)).start();
    }
}
