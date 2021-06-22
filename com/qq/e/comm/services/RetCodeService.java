package com.qq.e.comm.services;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
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
    public final String f39288a;

    /* renamed from: b  reason: collision with root package name */
    public final String f39289b;

    /* renamed from: c  reason: collision with root package name */
    public final Random f39290c;

    /* loaded from: classes7.dex */
    public static class Holder {

        /* renamed from: a  reason: collision with root package name */
        public static final RetCodeService f39291a = new RetCodeService((byte) 0);
    }

    /* loaded from: classes7.dex */
    public static class RetCodeInfo {

        /* renamed from: a  reason: collision with root package name */
        public final String f39292a;

        /* renamed from: b  reason: collision with root package name */
        public final String f39293b;

        /* renamed from: c  reason: collision with root package name */
        public final String f39294c;

        /* renamed from: d  reason: collision with root package name */
        public final int f39295d;

        /* renamed from: e  reason: collision with root package name */
        public final int f39296e;

        /* renamed from: f  reason: collision with root package name */
        public final int f39297f;

        /* renamed from: g  reason: collision with root package name */
        public final int f39298g;

        /* renamed from: h  reason: collision with root package name */
        public final int f39299h;

        public RetCodeInfo(String str, String str2, String str3, int i2, int i3, int i4, int i5, int i6) {
            this.f39292a = str;
            this.f39293b = str2;
            this.f39294c = str3;
            this.f39295d = i2;
            this.f39296e = i3;
            this.f39297f = i4;
            this.f39298g = i5;
            this.f39299h = i6;
        }

        public String toString() {
            return "RetCodeInfo [host=" + this.f39292a + ", commandid=" + this.f39293b + ", releaseversion=" + this.f39294c + ", resultcode=" + this.f39295d + ", tmcost=" + this.f39296e + ", reqsize=" + this.f39297f + ", rspsize=" + this.f39298g + PreferencesUtil.RIGHT_MOUNT;
        }
    }

    /* loaded from: classes7.dex */
    public class SendTask implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public RetCodeInfo f39300a;

        /* renamed from: b  reason: collision with root package name */
        public int f39301b = 100;

        public SendTask(RetCodeInfo retCodeInfo, int i2) {
            this.f39300a = retCodeInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            RetCodeService.a(RetCodeService.this, this.f39300a, this.f39301b);
        }
    }

    public RetCodeService() {
        this.f39288a = "1000162";
        this.f39289b = "http://wspeed.qq.com/w.cgi";
        this.f39290c = new Random(System.currentTimeMillis());
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
            plainRequest.addQuery("resultcode", String.valueOf(retCodeInfo.f39295d));
            plainRequest.addQuery("sdkversion", SDKStatus.getSDKVersion());
            plainRequest.addQuery("touin", "");
            plainRequest.addQuery("tmcost", String.valueOf(retCodeInfo.f39296e));
            plainRequest.addQuery("reqsize", String.valueOf(retCodeInfo.f39297f));
            plainRequest.addQuery("rspsize", String.valueOf(retCodeInfo.f39298g));
            plainRequest.addQuery("frequency", String.valueOf(i2));
            try {
                plainRequest.addQuery("commandid", URLEncoder.encode(retCodeInfo.f39293b, "utf-8"));
                plainRequest.addQuery("releaseversion", URLEncoder.encode(retCodeInfo.f39294c, "utf-8"));
                plainRequest.addQuery("serverip", URLEncoder.encode(a(retCodeInfo.f39292a), "utf-8"));
                NetworkClientImpl.getInstance().submit(plainRequest, NetworkClient.Priority.Low);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        if (retCodeService.a(i2)) {
            PlainRequest plainRequest2 = new PlainRequest("http://c.isdspeed.qq.com/code.cgi", Request.Method.GET, (byte[]) null);
            plainRequest2.addQuery("domain", retCodeInfo.f39292a);
            plainRequest2.addQuery("cgi", retCodeInfo.f39293b);
            plainRequest2.addQuery("type", String.valueOf(retCodeInfo.f39299h));
            plainRequest2.addQuery("code", String.valueOf(retCodeInfo.f39295d));
            plainRequest2.addQuery("time", String.valueOf(retCodeInfo.f39296e));
            plainRequest2.addQuery("rate", String.valueOf(i2));
            NetworkClientImpl.getInstance().submit(plainRequest2, NetworkClient.Priority.Low);
        }
    }

    private boolean a(int i2) {
        return this.f39290c.nextDouble() < 1.0d / ((double) i2);
    }

    public static RetCodeService getInstance() {
        return Holder.f39291a;
    }

    public void send(RetCodeInfo retCodeInfo) {
        new Thread(new SendTask(retCodeInfo, 100)).start();
    }
}
