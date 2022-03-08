package com.ss.android.download.api.download;

import org.json.JSONObject;
@Deprecated
/* loaded from: classes8.dex */
public class c implements DownloadEventConfig {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f57860b;

    /* renamed from: c  reason: collision with root package name */
    public String f57861c;

    /* renamed from: d  reason: collision with root package name */
    public String f57862d;

    /* renamed from: e  reason: collision with root package name */
    public String f57863e;

    /* renamed from: f  reason: collision with root package name */
    public String f57864f;

    /* renamed from: g  reason: collision with root package name */
    public String f57865g;

    /* renamed from: h  reason: collision with root package name */
    public String f57866h;

    /* renamed from: i  reason: collision with root package name */
    public String f57867i;

    /* renamed from: j  reason: collision with root package name */
    public String f57868j;
    public String k;
    public Object l;
    public boolean m;
    public boolean n;
    public boolean o;
    public String p;
    public String q;

    /* loaded from: classes8.dex */
    public static final class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f57869b;

        /* renamed from: c  reason: collision with root package name */
        public String f57870c;

        /* renamed from: d  reason: collision with root package name */
        public String f57871d;

        /* renamed from: e  reason: collision with root package name */
        public String f57872e;

        /* renamed from: f  reason: collision with root package name */
        public String f57873f;

        /* renamed from: g  reason: collision with root package name */
        public String f57874g;

        /* renamed from: h  reason: collision with root package name */
        public String f57875h;

        /* renamed from: i  reason: collision with root package name */
        public String f57876i;

        /* renamed from: j  reason: collision with root package name */
        public String f57877j;
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
        return this.f57864f;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickInstallLabel() {
        return this.f57865g;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickItemTag() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickLabel() {
        return this.f57861c;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickPauseLabel() {
        return this.f57863e;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickStartLabel() {
        return this.f57862d;
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
        return this.f57868j;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableClickEvent() {
        return this.f57860b;
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
        this.f57860b = aVar.f57869b;
        this.f57861c = aVar.f57870c;
        this.f57862d = aVar.f57871d;
        this.f57863e = aVar.f57872e;
        this.f57864f = aVar.f57873f;
        this.f57865g = aVar.f57874g;
        this.f57866h = aVar.f57875h;
        this.f57867i = aVar.f57876i;
        this.f57868j = aVar.f57877j;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.n;
        this.o = aVar.o;
        this.p = aVar.p;
        this.q = aVar.q;
    }
}
