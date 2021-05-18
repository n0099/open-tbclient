package com.yy.mobile.framework.revenuesdk.baseapi.data;

import android.os.Handler;
import android.os.HandlerThread;
import com.xiaomi.mipush.sdk.Constants;
import d.r.b.a.a.f.c.f;
import d.r.b.a.a.f.e.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public enum RevenueDataParser {
    INSTANCE;
    
    public static final String TAG = "RevenueDataParser";
    public Handler parserHandler;
    public List<d.r.b.a.a.f.c.c> revenueDataReceivers = new ArrayList();

    /* loaded from: classes7.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ byte[] f38288e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f38289f;

        public a(byte[] bArr, int i2) {
            this.f38288e = bArr;
            this.f38289f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.r.b.a.a.f.e.d dVar = new d.r.b.a.a.f.e.d(this.f38288e);
            d.r.b.a.a.f.d.d.g(RevenueDataParser.TAG, "parserRevenueResponseData: %s", dVar.toString());
            d.r.b.a.a.f.d.d.c(RevenueDataParser.TAG, "parserRevenueResponseData: jsonMsg = %s", dVar.l());
            for (d.r.b.a.a.f.c.c cVar : RevenueDataParser.this.revenueDataReceivers) {
                cVar.k(this.f38289f, dVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f38291e;

        public b(f fVar) {
            this.f38291e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = new e(this.f38291e.f67662b);
            d.r.b.a.a.f.d.d.g(RevenueDataParser.TAG, "RevenueUnicastData = %s", eVar.toString());
            d.r.b.a.a.f.d.d.c(RevenueDataParser.TAG, "RevenueUnicastData: jsonData = %s", eVar.m());
            eVar.o(this.f38291e.f67661a);
            for (d.r.b.a.a.f.c.c cVar : RevenueDataParser.this.revenueDataReceivers) {
                cVar.j(eVar.l(), eVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.r.b.a.a.f.c.e f38293e;

        public c(d.r.b.a.a.f.c.e eVar) {
            this.f38293e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.r.b.a.a.f.e.b bVar = new d.r.b.a.a.f.e.b(this.f38293e.f67660b);
            d.r.b.a.a.f.d.d.g(RevenueDataParser.TAG, "RevenueBroadcastData = %s", bVar.toString());
            d.r.b.a.a.f.d.d.g(RevenueDataParser.TAG, "RevenueBroadcastData: jsonData = %s", bVar.m());
            bVar.n(this.f38293e.f67659a);
            int optInt = bVar.l().optInt(Constants.APP_ID, 0);
            for (d.r.b.a.a.f.c.c cVar : RevenueDataParser.this.revenueDataReceivers) {
                cVar.h(optInt, bVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f38295e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f38296f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f38297g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f38298h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f38299i;

        public d(int i2, String str, String str2, int i3, int i4) {
            this.f38295e = i2;
            this.f38296f = str;
            this.f38297g = str2;
            this.f38298h = i3;
            this.f38299i = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.r.b.a.a.f.d.d.g(RevenueDataParser.TAG, "onRequestError appId = %d, seq = %s, message = %s", Integer.valueOf(this.f38295e), this.f38296f, this.f38297g);
            for (d.r.b.a.a.f.c.c cVar : RevenueDataParser.this.revenueDataReceivers) {
                cVar.g(this.f38295e, this.f38296f, this.f38298h, this.f38299i, this.f38297g);
            }
        }
    }

    RevenueDataParser() {
        HandlerThread handlerThread = new HandlerThread(TAG);
        handlerThread.start();
        this.parserHandler = new Handler(handlerThread.getLooper());
    }

    public void onRequestError(int i2, String str, int i3, int i4, String str2) {
        this.parserHandler.post(new d(i2, str, str2, i3, i4));
    }

    public void parserRevenueBroadcastData(d.r.b.a.a.f.c.e eVar) {
        this.parserHandler.post(new c(eVar));
    }

    public void parserRevenueResponseData(int i2, byte[] bArr) {
        this.parserHandler.post(new a(bArr, i2));
    }

    public void parserRevenueUnicastData(f fVar) {
        this.parserHandler.post(new b(fVar));
    }

    public void registerDataReceivers(d.r.b.a.a.f.c.c cVar) {
        if (this.revenueDataReceivers.contains(cVar)) {
            return;
        }
        this.revenueDataReceivers.add(cVar);
    }
}
