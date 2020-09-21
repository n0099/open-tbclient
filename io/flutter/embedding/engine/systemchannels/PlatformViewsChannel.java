package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.img.effect.ResizeImageAction;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class PlatformViewsChannel {
    private static final String TAG = "PlatformViewsChannel";
    private final MethodChannel channel;
    private PlatformViewsHandler handler;
    private final MethodChannel.MethodCallHandler parsingHandler = new MethodChannel.MethodCallHandler() { // from class: io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.1
        @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
        public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            if (PlatformViewsChannel.this.handler != null) {
                Log.v(PlatformViewsChannel.TAG, "Received '" + methodCall.method + "' message.");
                String str = methodCall.method;
                char c = 65535;
                switch (str.hashCode()) {
                    case -1352294148:
                        if (str.equals("create")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -934437708:
                        if (str.equals(ResizeImageAction.ACTION_NAME)) {
                            c = 2;
                            break;
                        }
                        break;
                    case -756050293:
                        if (str.equals("clearFocus")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 110550847:
                        if (str.equals("touch")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 576796989:
                        if (str.equals("setDirection")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 1671767583:
                        if (str.equals("dispose")) {
                            c = 1;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        create(methodCall, result);
                        return;
                    case 1:
                        dispose(methodCall, result);
                        return;
                    case 2:
                        resize(methodCall, result);
                        return;
                    case 3:
                        touch(methodCall, result);
                        return;
                    case 4:
                        setDirection(methodCall, result);
                        return;
                    case 5:
                        clearFocus(methodCall, result);
                        return;
                    default:
                        result.notImplemented();
                        return;
                }
            }
        }

        private void create(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            Map map = (Map) methodCall.arguments();
            try {
                result.success(Long.valueOf(PlatformViewsChannel.this.handler.createPlatformView(new PlatformViewCreationRequest(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue(), ((Integer) map.get("direction")).intValue(), map.containsKey("params") ? ByteBuffer.wrap((byte[]) map.get("params")) : null))));
            } catch (IllegalStateException e) {
                result.error(BdStatsConstant.StatsType.ERROR, PlatformViewsChannel.detailedExceptionString(e), null);
            }
        }

        private void dispose(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            try {
                PlatformViewsChannel.this.handler.disposePlatformView(((Integer) methodCall.arguments()).intValue());
                result.success(null);
            } catch (IllegalStateException e) {
                result.error(BdStatsConstant.StatsType.ERROR, PlatformViewsChannel.detailedExceptionString(e), null);
            }
        }

        private void resize(@NonNull MethodCall methodCall, @NonNull final MethodChannel.Result result) {
            Map map = (Map) methodCall.arguments();
            try {
                PlatformViewsChannel.this.handler.resizePlatformView(new PlatformViewResizeRequest(((Integer) map.get("id")).intValue(), ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue()), new Runnable() { // from class: io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        result.success(null);
                    }
                });
            } catch (IllegalStateException e) {
                result.error(BdStatsConstant.StatsType.ERROR, PlatformViewsChannel.detailedExceptionString(e), null);
            }
        }

        private void touch(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            List list = (List) methodCall.arguments();
            try {
                PlatformViewsChannel.this.handler.onTouch(new PlatformViewTouch(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue()));
                result.success(null);
            } catch (IllegalStateException e) {
                result.error(BdStatsConstant.StatsType.ERROR, PlatformViewsChannel.detailedExceptionString(e), null);
            }
        }

        private void setDirection(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            Map map = (Map) methodCall.arguments();
            try {
                PlatformViewsChannel.this.handler.setDirection(((Integer) map.get("id")).intValue(), ((Integer) map.get("direction")).intValue());
                result.success(null);
            } catch (IllegalStateException e) {
                result.error(BdStatsConstant.StatsType.ERROR, PlatformViewsChannel.detailedExceptionString(e), null);
            }
        }

        private void clearFocus(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            try {
                PlatformViewsChannel.this.handler.clearFocus(((Integer) methodCall.arguments()).intValue());
                result.success(null);
            } catch (IllegalStateException e) {
                result.error(BdStatsConstant.StatsType.ERROR, PlatformViewsChannel.detailedExceptionString(e), null);
            }
        }
    };

    /* loaded from: classes8.dex */
    public interface PlatformViewsHandler {
        void clearFocus(int i);

        long createPlatformView(@NonNull PlatformViewCreationRequest platformViewCreationRequest);

        void disposePlatformView(int i);

        void onTouch(@NonNull PlatformViewTouch platformViewTouch);

        void resizePlatformView(@NonNull PlatformViewResizeRequest platformViewResizeRequest, @NonNull Runnable runnable);

        void setDirection(int i, int i2);
    }

    public void invokeViewFocused(int i) {
        if (this.channel != null) {
            this.channel.invokeMethod("viewFocused", Integer.valueOf(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String detailedExceptionString(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        ThrowableExtension.printStackTrace(exc, new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public PlatformViewsChannel(@NonNull DartExecutor dartExecutor) {
        this.channel = new MethodChannel(dartExecutor, "flutter/platform_views", StandardMethodCodec.INSTANCE);
        this.channel.setMethodCallHandler(this.parsingHandler);
    }

    public void setPlatformViewsHandler(@Nullable PlatformViewsHandler platformViewsHandler) {
        this.handler = platformViewsHandler;
    }

    /* loaded from: classes8.dex */
    public static class PlatformViewCreationRequest {
        public final int direction;
        public final double logicalHeight;
        public final double logicalWidth;
        @Nullable
        public final ByteBuffer params;
        public final int viewId;
        @NonNull
        public final String viewType;

        public PlatformViewCreationRequest(int i, @NonNull String str, double d, double d2, int i2, @Nullable ByteBuffer byteBuffer) {
            this.viewId = i;
            this.viewType = str;
            this.logicalWidth = d;
            this.logicalHeight = d2;
            this.direction = i2;
            this.params = byteBuffer;
        }
    }

    /* loaded from: classes8.dex */
    public static class PlatformViewResizeRequest {
        public final double newLogicalHeight;
        public final double newLogicalWidth;
        public final int viewId;

        public PlatformViewResizeRequest(int i, double d, double d2) {
            this.viewId = i;
            this.newLogicalWidth = d;
            this.newLogicalHeight = d2;
        }
    }

    /* loaded from: classes8.dex */
    public static class PlatformViewTouch {
        public final int action;
        public final int buttonState;
        public final int deviceId;
        @NonNull
        public final Number downTime;
        public final int edgeFlags;
        @NonNull
        public final Number eventTime;
        public final int flags;
        public final int metaState;
        public final int pointerCount;
        @NonNull
        public final Object rawPointerCoords;
        @NonNull
        public final Object rawPointerPropertiesList;
        public final int source;
        public final int viewId;
        public final float xPrecision;
        public final float yPrecision;

        PlatformViewTouch(int i, @NonNull Number number, @NonNull Number number2, int i2, int i3, @NonNull Object obj, @NonNull Object obj2, int i4, int i5, float f, float f2, int i6, int i7, int i8, int i9) {
            this.viewId = i;
            this.downTime = number;
            this.eventTime = number2;
            this.action = i2;
            this.pointerCount = i3;
            this.rawPointerPropertiesList = obj;
            this.rawPointerCoords = obj2;
            this.metaState = i4;
            this.buttonState = i5;
            this.xPrecision = f;
            this.yPrecision = f2;
            this.deviceId = i6;
            this.edgeFlags = i7;
            this.source = i8;
            this.flags = i9;
        }
    }
}
