package com.kwad.components.offline.api.core;

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
/* loaded from: classes7.dex */
public interface IOfflineHostApi {
    IAsync async();

    ICache cache();

    ICrash crash();

    IDownloader downloader();

    IEncrypt encrypt();

    IEnvironment env();

    IImageLoader imageLoader();

    IOfflineCompoLogcat log();

    ILoggerReporter loggerReporter();

    INet net();

    float tkLoggerSamplingRate();

    IVideo video();

    IZipper zipper();
}
