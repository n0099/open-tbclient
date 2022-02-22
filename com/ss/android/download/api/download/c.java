package com.ss.android.download.api.download;

import org.json.JSONObject;
@Deprecated
/* loaded from: classes4.dex */
public class c implements DownloadEventConfig {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f59510b;

    /* renamed from: c  reason: collision with root package name */
    public String f59511c;

    /* renamed from: d  reason: collision with root package name */
    public String f59512d;

    /* renamed from: e  reason: collision with root package name */
    public String f59513e;

    /* renamed from: f  reason: collision with root package name */
    public String f59514f;

    /* renamed from: g  reason: collision with root package name */
    public String f59515g;

    /* renamed from: h  reason: collision with root package name */
    public String f59516h;

    /* renamed from: i  reason: collision with root package name */
    public String f59517i;

    /* renamed from: j  reason: collision with root package name */
    public String f59518j;
    public String k;
    public Object l;
    public boolean m;
    public boolean n;
    public boolean o;
    public String p;
    public String q;

    /* loaded from: classes4.dex */
    public static final class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f59519b;

        /* renamed from: c  reason: collision with root package name */
        public String f59520c;

        /* renamed from: d  reason: collision with root package name */
        public String f59521d;

        /* renamed from: e  reason: collision with root package name */
        public String f59522e;

        /* renamed from: f  reason: collision with root package name */
        public String f59523f;

        /* renamed from: g  reason: collision with root package name */
        public String f59524g;

        /* renamed from: h  reason: collision with root package name */
        public String f59525h;

        /* renamed from: i  reason: collision with root package name */
        public String f59526i;

        /* renamed from: j  reason: collision with root package name */
        public String f59527j;
        public String k;
        public Object l;
        public boolean m;
        public boolean n;
        public boolean o;
        public String p;
        public String q;

        public c a() {
            return new c(this);
        }
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickButtonTag() {
        return this.a;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickContinueLabel() {
        return this.f59514f;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickInstallLabel() {
        return this.f59515g;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickItemTag() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickLabel() {
        return this.f59511c;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickPauseLabel() {
        return this.f59513e;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickStartLabel() {
        return this.f59512d;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public int getDownloadScene() {
        return 0;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public Object getExtraEventObject() {
        return this.l;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getExtraJson() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getParamsJson() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getRefer() {
        return this.q;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getStorageDenyLabel() {
        return this.f59518j;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableClickEvent() {
        return this.f59510b;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableV3Event() {
        return this.m;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setDownloadScene(int i2) {
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setRefer(String str) {
    }

    public c() {
    }

    public c(a aVar) {
        this.a = aVar.a;
        this.f59510b = aVar.f59519b;
        this.f59511c = aVar.f59520c;
        this.f59512d = aVar.f59521d;
        this.f59513e = aVar.f59522e;
        this.f59514f = aVar.f59523f;
        this.f59515g = aVar.f59524g;
        this.f59516h = aVar.f59525h;
        this.f59517i = aVar.f59526i;
        this.f59518j = aVar.f59527j;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.n;
        this.o = aVar.o;
        this.p = aVar.p;
        this.q = aVar.q;
    }
}
