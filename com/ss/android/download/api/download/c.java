package com.ss.android.download.api.download;

import org.json.JSONObject;
@Deprecated
/* loaded from: classes3.dex */
public class c implements DownloadEventConfig {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f61632b;

    /* renamed from: c  reason: collision with root package name */
    public String f61633c;

    /* renamed from: d  reason: collision with root package name */
    public String f61634d;

    /* renamed from: e  reason: collision with root package name */
    public String f61635e;

    /* renamed from: f  reason: collision with root package name */
    public String f61636f;

    /* renamed from: g  reason: collision with root package name */
    public String f61637g;

    /* renamed from: h  reason: collision with root package name */
    public String f61638h;

    /* renamed from: i  reason: collision with root package name */
    public String f61639i;

    /* renamed from: j  reason: collision with root package name */
    public String f61640j;

    /* renamed from: k  reason: collision with root package name */
    public String f61641k;
    public Object l;
    public boolean m;
    public boolean n;
    public boolean o;
    public String p;
    public String q;

    /* loaded from: classes3.dex */
    public static final class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f61642b;

        /* renamed from: c  reason: collision with root package name */
        public String f61643c;

        /* renamed from: d  reason: collision with root package name */
        public String f61644d;

        /* renamed from: e  reason: collision with root package name */
        public String f61645e;

        /* renamed from: f  reason: collision with root package name */
        public String f61646f;

        /* renamed from: g  reason: collision with root package name */
        public String f61647g;

        /* renamed from: h  reason: collision with root package name */
        public String f61648h;

        /* renamed from: i  reason: collision with root package name */
        public String f61649i;

        /* renamed from: j  reason: collision with root package name */
        public String f61650j;

        /* renamed from: k  reason: collision with root package name */
        public String f61651k;
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
        return this.f61636f;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickInstallLabel() {
        return this.f61637g;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickItemTag() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickLabel() {
        return this.f61633c;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickPauseLabel() {
        return this.f61635e;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickStartLabel() {
        return this.f61634d;
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
        return this.f61640j;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableClickEvent() {
        return this.f61632b;
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
        this.f61632b = aVar.f61642b;
        this.f61633c = aVar.f61643c;
        this.f61634d = aVar.f61644d;
        this.f61635e = aVar.f61645e;
        this.f61636f = aVar.f61646f;
        this.f61637g = aVar.f61647g;
        this.f61638h = aVar.f61648h;
        this.f61639i = aVar.f61649i;
        this.f61640j = aVar.f61650j;
        this.f61641k = aVar.f61651k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.n;
        this.o = aVar.o;
        this.p = aVar.p;
        this.q = aVar.q;
    }
}
