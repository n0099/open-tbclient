package com.kwad.components.core.offline.init.kwai;

import androidx.annotation.WorkerThread;
import com.kwad.components.offline.api.core.IOfflineHostApi;
import com.kwad.components.offline.api.core.api.IAsync;
import com.kwad.components.offline.api.core.api.ICache;
import com.kwad.components.offline.api.core.api.ICrash;
import com.kwad.components.offline.api.core.api.IDownloader;
import com.kwad.components.offline.api.core.api.IEncrypt;
import com.kwad.components.offline.api.core.api.IEnvironment;
import com.kwad.components.offline.api.core.api.IImageLoader;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.core.api.INet;
import com.kwad.components.offline.api.core.api.IOfflineCompoLogcat;
import com.kwad.components.offline.api.core.api.IZipper;
import com.kwad.components.offline.api.core.video.IVideo;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.report.k;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class g implements IOfflineHostApi {
    public IAsync EP;
    public IEnvironment EQ;
    public IZipper ER;
    public INet ES;
    public IEncrypt ET;
    public IOfflineCompoLogcat EU;
    public ICrash EV;
    public ILoggerReporter EW;
    public IDownloader EX;
    public IImageLoader EY;
    public IVideo EZ;
    public ICache Fa;

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IAsync async() {
        if (this.EP == null) {
            this.EP = new a();
        }
        return this.EP;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ICache cache() {
        if (this.Fa == null) {
            this.Fa = new b();
        }
        return this.Fa;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ICrash crash() {
        if (this.EV == null) {
            this.EV = new ICrash() { // from class: com.kwad.components.core.offline.init.kwai.g.1
                @Override // com.kwad.components.offline.api.core.api.ICrash
                public final void gatherException(Throwable th) {
                    com.kwad.sdk.service.a.gatherException(th);
                }
            };
        }
        return this.EV;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IDownloader downloader() {
        if (this.EX == null) {
            this.EX = new IDownloader() { // from class: com.kwad.components.core.offline.init.kwai.g.3
                @Override // com.kwad.components.offline.api.core.api.IDownloader
                @WorkerThread
                public final boolean downloadSync(File file, String str) {
                    return com.kwad.sdk.core.download.a.c(str, file);
                }
            };
        }
        return this.EX;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IEncrypt encrypt() {
        if (this.ET == null) {
            this.ET = new c();
        }
        return this.ET;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IEnvironment env() {
        if (this.EQ == null) {
            this.EQ = new d();
        }
        return this.EQ;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IImageLoader imageLoader() {
        if (this.EY == null) {
            this.EY = new e();
        }
        return this.EY;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IOfflineCompoLogcat log() {
        if (this.EU == null) {
            this.EU = new h();
        }
        return this.EU;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ILoggerReporter loggerReporter() {
        if (this.EW == null) {
            this.EW = new ILoggerReporter() { // from class: com.kwad.components.core.offline.init.kwai.g.2
                @Override // com.kwad.components.offline.api.core.api.ILoggerReporter
                public final void reportEvent(double d, String str, BusinessType businessType, String str2, JSONObject jSONObject) {
                    k.a(d, str, businessType, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.d.asl, str2, jSONObject);
                }
            };
        }
        return this.EW;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final INet net() {
        if (this.ES == null) {
            this.ES = new f();
        }
        return this.ES;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final float tkLoggerSamplingRate() {
        return com.kwad.sdk.core.config.d.aX(KsAdSDKImpl.get().getContext());
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IVideo video() {
        if (this.EZ == null) {
            this.EZ = new com.kwad.components.core.offline.init.a.e();
        }
        return this.EZ;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IZipper zipper() {
        if (this.ER == null) {
            this.ER = new j();
        }
        return this.ER;
    }
}
