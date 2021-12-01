package com.tachikoma.core.api;

import com.kwad.v8.V8Function;
/* loaded from: classes2.dex */
public interface IWebCardBridgeInner {
    void close();

    void convert();

    String getData();

    void handleAdUrl(String str);

    void hide();

    void log(String str);

    void nonActionbarClick(String str);

    void pageStatus(String str);

    void registerProgressListener(V8Function v8Function);

    void trace(String str);
}
