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
    public final String f36337a;

    /* renamed from: b  reason: collision with root package name */
    public final String f36338b;

    /* renamed from: c  reason: collision with root package name */
    public final Random f36339c;

    /* loaded from: classes6.dex */
    public static class Holder {

        /* renamed from: a  reason: collision with root package name */
        public static final RetCodeService f36340a = new RetCodeService((byte) 0);
    }

    /* loaded from: classes6.dex */
    public static class RetCodeInfo {

        /* renamed from: a  reason: collision with root package name */
        public final String f36341a;

        /* renamed from: b  reason: collision with root package name */
        public final String f36342b;

        /* renamed from: c  reason: collision with root package name */
        public final String f36343c;

        /* renamed from: d  reason: collision with root package name */
        public final int f36344d;

        /* renamed from: e  reason: collision with root package name */
        public final int f36345e;

        /* renamed from: f  reason: collision with root package name */
        public final int f36346f;

        /* renamed from: g  reason: collision with root package name */
        public final int f36347g;

        /* renamed from: h  reason: collision with root package name */
        public final int f36348h;

        public RetCodeInfo(String str, String str2, String str3, int i2, int i3, int i4, int i5, int i6) {
            this.f36341a = str;
            this.f36342b = str2;
            this.f36343c = str3;
            this.f36344d = i2;
            this.f36345e = i3;
            this.f36346f = i4;
            this.f36347g = i5;
            this.f36348h = i6;
        }

        public String toString() {
            return "RetCodeInfo [host=" + this.f36341a + ", commandid=" + this.f36342b + ", releaseversion=" + this.f36343c + ", resultcode=" + this.f36344d + ", tmcost=" + this.f36345e + ", reqsize=" + this.f36346f + ", rspsize=" + this.f36347g + "]";
        }
    }

    /* loaded from: classes6.dex */
    public class SendTask implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public RetCodeInfo f36349a;

        /* renamed from: b  reason: collision with root package name */
        public int f36350b = 100;

        public SendTask(RetCodeInfo retCodeInfo, int i2) {
            this.f36349a = retCodeInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            RetCodeService.a(RetCodeService.this, this.f36349a, this.f36350b);
        }
    }

    public RetCodeService() {
        this.f36337a = "1000162";
        this.f36338b = "http://wspeed.qq.com/w.cgi";
        this.f36339c = new Random(System.currentTimeMillis());
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

    public static /* synthetic */ void a(RetCodeService retCodeService, RetCodeInfo retCodeInfo, int i2) {
        if (retCodeService.a(i2)) {
            PlainRequest plainRequest = new PlainRequest("http://wspeed.qq.com/w.cgi", Request.Method.GET, (byte[]) null);
            plainRequest.addQuery("appid", "1000162");
            plainRequest.addQuery("resultcode", String.valueOf(retCodeInfo.f36344d));
            plainRequest.addQuery("sdkversion", SDKStatus.getSDKVersion());
            plainRequest.addQuery("touin", "");
            plainRequest.addQuery("tmcost", String.valueOf(retCodeInfo.f36345e));
            plainRequest.addQuery("reqsize", String.valueOf(retCodeInfo.f36346f));
            plainRequest.addQuery("rspsize", String.valueOf(retCodeInfo.f36347g));
            plainRequest.addQuery("frequency", String.valueOf(i2));
            try {
                plainRequest.addQuery("commandid", URLEncoder.encode(retCodeInfo.f36342b, "utf-8"));
                plainRequest.addQuery("releaseversion", URLEncoder.encode(retCodeInfo.f36343c, "utf-8"));
                plainRequest.addQuery("serverip", URLEncoder.encode(a(retCodeInfo.f36341a), "utf-8"));
                NetworkClientImpl.getInstance().submit(plainRequest, NetworkClient.Priority.Low);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        if (retCodeService.a(i2)) {
            PlainRequest plainRequest2 = new PlainRequest("http://c.isdspeed.qq.com/code.cgi", Request.Method.GET, (byte[]) null);
            plainRequest2.addQuery("domain", retCodeInfo.f36341a);
            plainRequest2.addQuery("cgi", retCodeInfo.f36342b);
            plainRequest2.addQuery("type", String.valueOf(retCodeInfo.f36348h));
            plainRequest2.addQuery("code", String.valueOf(retCodeInfo.f36344d));
            plainRequest2.addQuery("time", String.valueOf(retCodeInfo.f36345e));
            plainRequest2.addQuery("rate", String.valueOf(i2));
            NetworkClientImpl.getInstance().submit(plainRequest2, NetworkClient.Priority.Low);
        }
    }

    private boolean a(int i2) {
        return this.f36339c.nextDouble() < 1.0d / ((double) i2);
    }

    public static RetCodeService getInstance() {
        return Holder.f36340a;
    }

    public void send(RetCodeInfo retCodeInfo) {
        new Thread(new SendTask(retCodeInfo, 100)).start();
    }
}
