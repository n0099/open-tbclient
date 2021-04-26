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
        public final /* synthetic */ byte[] f39043e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f39044f;

        public a(byte[] bArr, int i2) {
            this.f39043e = bArr;
            this.f39044f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.r.b.a.a.f.e.d dVar = new d.r.b.a.a.f.e.d(this.f39043e);
            d.r.b.a.a.f.d.d.g(RevenueDataParser.TAG, "parserRevenueResponseData: %s", dVar.toString());
            d.r.b.a.a.f.d.d.c(RevenueDataParser.TAG, "parserRevenueResponseData: jsonMsg = %s", dVar.l());
            for (d.r.b.a.a.f.c.c cVar : RevenueDataParser.this.revenueDataReceivers) {
                cVar.k(this.f39044f, dVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f39046e;

        public b(f fVar) {
            this.f39046e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = new e(this.f39046e.f66976b);
            d.r.b.a.a.f.d.d.g(RevenueDataParser.TAG, "RevenueUnicastData = %s", eVar.toString());
            d.r.b.a.a.f.d.d.c(RevenueDataParser.TAG, "RevenueUnicastData: jsonData = %s", eVar.m());
            eVar.o(this.f39046e.f66975a);
            for (d.r.b.a.a.f.c.c cVar : RevenueDataParser.this.revenueDataReceivers) {
                cVar.j(eVar.l(), eVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.r.b.a.a.f.c.e f39048e;

        public c(d.r.b.a.a.f.c.e eVar) {
            this.f39048e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.r.b.a.a.f.e.b bVar = new d.r.b.a.a.f.e.b(this.f39048e.f66974b);
            d.r.b.a.a.f.d.d.g(RevenueDataParser.TAG, "RevenueBroadcastData = %s", bVar.toString());
            d.r.b.a.a.f.d.d.g(RevenueDataParser.TAG, "RevenueBroadcastData: jsonData = %s", bVar.m());
            bVar.n(this.f39048e.f66973a);
            int optInt = bVar.l().optInt(Constants.APP_ID, 0);
            for (d.r.b.a.a.f.c.c cVar : RevenueDataParser.this.revenueDataReceivers) {
                cVar.h(optInt, bVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f39050e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f39051f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f39052g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f39053h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f39054i;

        public d(int i2, String str, String str2, int i3, int i4) {
            this.f39050e = i2;
            this.f39051f = str;
            this.f39052g = str2;
            this.f39053h = i3;
            this.f39054i = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.r.b.a.a.f.d.d.g(RevenueDataParser.TAG, "onRequestError appId = %d, seq = %s, message = %s", Integer.valueOf(this.f39050e), this.f39051f, this.f39052g);
            for (d.r.b.a.a.f.c.c cVar : RevenueDataParser.this.revenueDataReceivers) {
                cVar.g(this.f39050e, this.f39051f, this.f39053h, this.f39054i, this.f39052g);
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
