package com.kuaishou.tachikoma.api.page;

import com.kwad.v8.V8Function;
@Deprecated
/* loaded from: classes2.dex */
public interface IWebCardBridge {
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
