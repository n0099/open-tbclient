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
/* loaded from: classes3.dex */
public class RetCodeService {

    /* renamed from: a  reason: collision with root package name */
    private final String f13041a;

    /* renamed from: b  reason: collision with root package name */
    private final String f13042b;
    private final Random c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class Holder {

        /* renamed from: a  reason: collision with root package name */
        static final RetCodeService f13043a = new RetCodeService((byte) 0);

        private Holder() {
        }
    }

    /* loaded from: classes3.dex */
    public static class RetCodeInfo {

        /* renamed from: a  reason: collision with root package name */
        final String f13044a;

        /* renamed from: b  reason: collision with root package name */
        final String f13045b;
        final String c;
        final int d;
        final int e;
        final int f;
        final int g;
        final int h;

        public RetCodeInfo(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5) {
            this.f13044a = str;
            this.f13045b = str2;
            this.c = str3;
            this.d = i;
            this.e = i2;
            this.f = i3;
            this.g = i4;
            this.h = i5;
        }

        public String toString() {
            return "RetCodeInfo [host=" + this.f13044a + ", commandid=" + this.f13045b + ", releaseversion=" + this.c + ", resultcode=" + this.d + ", tmcost=" + this.e + ", reqsize=" + this.f + ", rspsize=" + this.g + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class SendTask implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private RetCodeInfo f13046a;

        /* renamed from: b  reason: collision with root package name */
        private int f13047b = 100;

        SendTask(RetCodeInfo retCodeInfo, int i) {
            this.f13046a = retCodeInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            RetCodeService.a(RetCodeService.this, this.f13046a, this.f13047b);
        }
    }

    private RetCodeService() {
        this.f13041a = "1000162";
        this.f13042b = "http://wspeed.qq.com/w.cgi";
        this.c = new Random(System.currentTimeMillis());
    }

    /* synthetic */ RetCodeService(byte b2) {
        this();
    }

    private static String a(String str) {
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (UnknownHostException e) {
            return "0.0.0.0";
        }
    }

    static /* synthetic */ void a(RetCodeService retCodeService, RetCodeInfo retCodeInfo, int i) {
        if (retCodeService.a(i)) {
            PlainRequest plainRequest = new PlainRequest("http://wspeed.qq.com/w.cgi", Request.Method.GET, (byte[]) null);
            plainRequest.addQuery("appid", "1000162");
            plainRequest.addQuery("resultcode", String.valueOf(retCodeInfo.d));
            plainRequest.addQuery("sdkversion", SDKStatus.getSDKVersion());
            plainRequest.addQuery("touin", "");
            plainRequest.addQuery("tmcost", String.valueOf(retCodeInfo.e));
            plainRequest.addQuery("reqsize", String.valueOf(retCodeInfo.f));
            plainRequest.addQuery("rspsize", String.valueOf(retCodeInfo.g));
            plainRequest.addQuery("frequency", String.valueOf(i));
            try {
                plainRequest.addQuery("commandid", URLEncoder.encode(retCodeInfo.f13045b, "utf-8"));
                plainRequest.addQuery("releaseversion", URLEncoder.encode(retCodeInfo.c, "utf-8"));
                plainRequest.addQuery("serverip", URLEncoder.encode(a(retCodeInfo.f13044a), "utf-8"));
                NetworkClientImpl.getInstance().submit(plainRequest, NetworkClient.Priority.Low);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        if (retCodeService.a(i)) {
            PlainRequest plainRequest2 = new PlainRequest("http://c.isdspeed.qq.com/code.cgi", Request.Method.GET, (byte[]) null);
            plainRequest2.addQuery("domain", retCodeInfo.f13044a);
            plainRequest2.addQuery("cgi", retCodeInfo.f13045b);
            plainRequest2.addQuery("type", String.valueOf(retCodeInfo.h));
            plainRequest2.addQuery("code", String.valueOf(retCodeInfo.d));
            plainRequest2.addQuery("time", String.valueOf(retCodeInfo.e));
            plainRequest2.addQuery("rate", String.valueOf(i));
            NetworkClientImpl.getInstance().submit(plainRequest2, NetworkClient.Priority.Low);
        }
    }

    private boolean a(int i) {
        return this.c.nextDouble() < 1.0d / ((double) i);
    }

    public static RetCodeService getInstance() {
        return Holder.f13043a;
    }

    public void send(RetCodeInfo retCodeInfo) {
        new Thread(new SendTask(retCodeInfo, 100)).start();
    }
}
