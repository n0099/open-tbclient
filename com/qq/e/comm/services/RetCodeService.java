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
    public final String f38661a;

    /* renamed from: b  reason: collision with root package name */
    public final String f38662b;

    /* renamed from: c  reason: collision with root package name */
    public final Random f38663c;

    /* loaded from: classes6.dex */
    public static class Holder {

        /* renamed from: a  reason: collision with root package name */
        public static final RetCodeService f38664a = new RetCodeService((byte) 0);
    }

    /* loaded from: classes6.dex */
    public static class RetCodeInfo {

        /* renamed from: a  reason: collision with root package name */
        public final String f38665a;

        /* renamed from: b  reason: collision with root package name */
        public final String f38666b;

        /* renamed from: c  reason: collision with root package name */
        public final String f38667c;

        /* renamed from: d  reason: collision with root package name */
        public final int f38668d;

        /* renamed from: e  reason: collision with root package name */
        public final int f38669e;

        /* renamed from: f  reason: collision with root package name */
        public final int f38670f;

        /* renamed from: g  reason: collision with root package name */
        public final int f38671g;

        /* renamed from: h  reason: collision with root package name */
        public final int f38672h;

        public RetCodeInfo(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5) {
            this.f38665a = str;
            this.f38666b = str2;
            this.f38667c = str3;
            this.f38668d = i;
            this.f38669e = i2;
            this.f38670f = i3;
            this.f38671g = i4;
            this.f38672h = i5;
        }

        public String toString() {
            return "RetCodeInfo [host=" + this.f38665a + ", commandid=" + this.f38666b + ", releaseversion=" + this.f38667c + ", resultcode=" + this.f38668d + ", tmcost=" + this.f38669e + ", reqsize=" + this.f38670f + ", rspsize=" + this.f38671g + "]";
        }
    }

    /* loaded from: classes6.dex */
    public class SendTask implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public RetCodeInfo f38673a;

        /* renamed from: b  reason: collision with root package name */
        public int f38674b = 100;

        public SendTask(RetCodeInfo retCodeInfo, int i) {
            this.f38673a = retCodeInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            RetCodeService.a(RetCodeService.this, this.f38673a, this.f38674b);
        }
    }

    public RetCodeService() {
        this.f38661a = "1000162";
        this.f38662b = "http://wspeed.qq.com/w.cgi";
        this.f38663c = new Random(System.currentTimeMillis());
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
            plainRequest.addQuery("resultcode", String.valueOf(retCodeInfo.f38668d));
            plainRequest.addQuery("sdkversion", SDKStatus.getSDKVersion());
            plainRequest.addQuery("touin", "");
            plainRequest.addQuery("tmcost", String.valueOf(retCodeInfo.f38669e));
            plainRequest.addQuery("reqsize", String.valueOf(retCodeInfo.f38670f));
            plainRequest.addQuery("rspsize", String.valueOf(retCodeInfo.f38671g));
            plainRequest.addQuery("frequency", String.valueOf(i));
            try {
                plainRequest.addQuery("commandid", URLEncoder.encode(retCodeInfo.f38666b, "utf-8"));
                plainRequest.addQuery("releaseversion", URLEncoder.encode(retCodeInfo.f38667c, "utf-8"));
                plainRequest.addQuery("serverip", URLEncoder.encode(a(retCodeInfo.f38665a), "utf-8"));
                NetworkClientImpl.getInstance().submit(plainRequest, NetworkClient.Priority.Low);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        if (retCodeService.a(i)) {
            PlainRequest plainRequest2 = new PlainRequest("http://c.isdspeed.qq.com/code.cgi", Request.Method.GET, (byte[]) null);
            plainRequest2.addQuery("domain", retCodeInfo.f38665a);
            plainRequest2.addQuery("cgi", retCodeInfo.f38666b);
            plainRequest2.addQuery("type", String.valueOf(retCodeInfo.f38672h));
            plainRequest2.addQuery("code", String.valueOf(retCodeInfo.f38668d));
            plainRequest2.addQuery("time", String.valueOf(retCodeInfo.f38669e));
            plainRequest2.addQuery("rate", String.valueOf(i));
            NetworkClientImpl.getInstance().submit(plainRequest2, NetworkClient.Priority.Low);
        }
    }

    private boolean a(int i) {
        return this.f38663c.nextDouble() < 1.0d / ((double) i);
    }

    public static RetCodeService getInstance() {
        return Holder.f38664a;
    }

    public void send(RetCodeInfo retCodeInfo) {
        new Thread(new SendTask(retCodeInfo, 100)).start();
    }
}
