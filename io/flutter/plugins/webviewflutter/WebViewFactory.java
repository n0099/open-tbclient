package io.flutter.plugins.webviewflutter;

import android.content.Context;
import android.view.View;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;
import java.util.Map;
/* loaded from: classes14.dex */
public final class WebViewFactory extends PlatformViewFactory {
    private final View containerView;
    private final BinaryMessenger messenger;

    /* JADX INFO: Access modifiers changed from: package-private */
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
