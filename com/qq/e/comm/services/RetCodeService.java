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
/* loaded from: classes7.dex */
public class RetCodeService {

    /* renamed from: a  reason: collision with root package name */
    public final String f35511a;

    /* renamed from: b  reason: collision with root package name */
    public final String f35512b;

    /* renamed from: c  reason: collision with root package name */
    public final Random f35513c;

    /* loaded from: classes7.dex */
    public static class Holder {

        /* renamed from: a  reason: collision with root package name */
        public static final RetCodeService f35514a = new RetCodeService((byte) 0);
    }

    /* loaded from: classes7.dex */
    public static class RetCodeInfo {

        /* renamed from: a  reason: collision with root package name */
        public final String f35515a;

        /* renamed from: b  reason: collision with root package name */
        public final String f35516b;

        /* renamed from: c  reason: collision with root package name */
        public final String f35517c;

        /* renamed from: d  reason: collision with root package name */
        public final int f35518d;

        /* renamed from: e  reason: collision with root package name */
        public final int f35519e;

        /* renamed from: f  reason: collision with root package name */
        public final int f35520f;

        /* renamed from: g  reason: collision with root package name */
        public final int f35521g;

        /* renamed from: h  reason: collision with root package name */
        public final int f35522h;

        public RetCodeInfo(String str, String str2, String str3, int i2, int i3, int i4, int i5, int i6) {
            this.f35515a = str;
            this.f35516b = str2;
            this.f35517c = str3;
            this.f35518d = i2;
            this.f35519e = i3;
            this.f35520f = i4;
            this.f35521g = i5;
            this.f35522h = i6;
        }

        public String toString() {
            return "RetCodeInfo [host=" + this.f35515a + ", commandid=" + this.f35516b + ", releaseversion=" + this.f35517c + ", resultcode=" + this.f35518d + ", tmcost=" + this.f35519e + ", reqsize=" + this.f35520f + ", rspsize=" + this.f35521g + "]";
        }
    }

    /* loaded from: classes7.dex */
    public class SendTask implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public RetCodeInfo f35523a;

        /* renamed from: b  reason: collision with root package name */
        public int f35524b = 100;

        public SendTask(RetCodeInfo retCodeInfo, int i2) {
            this.f35523a = retCodeInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            RetCodeService.a(RetCodeService.this, this.f35523a, this.f35524b);
        }
    }

    public RetCodeService() {
        this.f35511a = "1000162";
        this.f35512b = "http://wspeed.qq.com/w.cgi";
        this.f35513c = new Random(System.currentTimeMillis());
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
            plainRequest.addQuery("resultcode", String.valueOf(retCodeInfo.f35518d));
            plainRequest.addQuery("sdkversion", SDKStatus.getSDKVersion());
            plainRequest.addQuery("touin", "");
            plainRequest.addQuery("tmcost", String.valueOf(retCodeInfo.f35519e));
            plainRequest.addQuery("reqsize", String.valueOf(retCodeInfo.f35520f));
            plainRequest.addQuery("rspsize", String.valueOf(retCodeInfo.f35521g));
            plainRequest.addQuery("frequency", String.valueOf(i2));
            try {
                plainRequest.addQuery("commandid", URLEncoder.encode(retCodeInfo.f35516b, "utf-8"));
                plainRequest.addQuery("releaseversion", URLEncoder.encode(retCodeInfo.f35517c, "utf-8"));
                plainRequest.addQuery("serverip", URLEncoder.encode(a(retCodeInfo.f35515a), "utf-8"));
                NetworkClientImpl.getInstance().submit(plainRequest, NetworkClient.Priority.Low);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        if (retCodeService.a(i2)) {
            PlainRequest plainRequest2 = new PlainRequest("http://c.isdspeed.qq.com/code.cgi", Request.Method.GET, (byte[]) null);
            plainRequest2.addQuery("domain", retCodeInfo.f35515a);
            plainRequest2.addQuery("cgi", retCodeInfo.f35516b);
            plainRequest2.addQuery("type", String.valueOf(retCodeInfo.f35522h));
            plainRequest2.addQuery("code", String.valueOf(retCodeInfo.f35518d));
            plainRequest2.addQuery("time", String.valueOf(retCodeInfo.f35519e));
            plainRequest2.addQuery("rate", String.valueOf(i2));
            NetworkClientImpl.getInstance().submit(plainRequest2, NetworkClient.Priority.Low);
        }
    }

    private boolean a(int i2) {
        return this.f35513c.nextDouble() < 1.0d / ((double) i2);
    }

    public static RetCodeService getInstance() {
        return Holder.f35514a;
    }

    public void send(RetCodeInfo retCodeInfo) {
        new Thread(new SendTask(retCodeInfo, 100)).start();
    }
}
