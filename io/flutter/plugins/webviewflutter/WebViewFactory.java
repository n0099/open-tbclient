package io.flutter.plugins.webviewflutter;

import android.content.Context;
import android.view.View;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;
import java.util.Map;
/* loaded from: classes7.dex */
public final class WebViewFactory extends PlatformViewFactory {
    public final View containerView;
    public final BinaryMessenger messenger;

    public WebViewFactory(BinaryMessenger binaryMessenger, View view) {
        super(StandardMessageCodec.INSTANCE);
        this.messenger = binaryMessenger;
        this.containerView = view;
    }

    @Override // io.flutter.plugin.platform.PlatformViewFactory
    public PlatformView create(Context context, int i, Object obj) {
        return new FlutterWebView(context, this.messenger, i, (Map) obj, this.containerView);
    }
}
