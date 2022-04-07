package com.kwad.sdk.core.imageloader.core.listener;

import android.view.View;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import java.io.InputStream;
/* loaded from: classes5.dex */
public interface ImageLoadingListener {
    boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult);

    void onLoadingCancelled(String str, View view2);

    void onLoadingComplete(String str, View view2, DecodedResult decodedResult);

    void onLoadingFailed(String str, View view2, FailReason failReason);

    void onLoadingStarted(String str, View view2);
}
