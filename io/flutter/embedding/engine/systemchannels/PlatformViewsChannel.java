package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
/* loaded from: classes7.dex */
public class PlatformViewsChannel {
    public static final String TAG = "PlatformViewsChannel";
    public final MethodChannel channel;
    public PlatformViewsHandler handler;
    public final MethodChannel.MethodCallHandler parsingHandler = new MethodChannel.MethodCallHandler() { // from class: io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.1
        private void clearFocus(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            try {
                PlatformViewsChannel.this.handler.clearFocus(((Integer) methodCall.arguments()).intValue());
                result.success(null);
            } catch (IllegalStateException e2) {
                result.error("error", PlatformViewsChannel.detailedExceptionString(e2), null);
            }
        }

        private void create(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            Map map = (Map) methodCall.arguments();
            try {
                result.success(Long.valueOf(PlatformViewsChannel.this.handler.createPlatformView(new PlatformViewCreationRequest(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue(), ((Integer) map.get("direction")).intValue(), map.containsKey("params") ? ByteBuffer.wrap((byte[]) map.get("params")) : null))));
            } catch (IllegalStateException e2) {
                result.error("error", PlatformViewsChannel.detailedExceptionString(e2), null);
            }
        }

        private void dispose(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            try {
                PlatformViewsChannel.this.handler.disposePlatformView(((Integer) methodCall.arguments()).intValue());
                result.success(null);
            } catch (IllegalStateException e2) {
                result.error("error", PlatformViewsChannel.detailedExceptionString(e2), null);
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
            } catch (IllegalStateException e2) {
                result.error("error", PlatformViewsChannel.detailedExceptionString(e2), null);
            }
        }

        private void setDirection(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            Map map = (Map) methodCall.arguments();
            try {
                PlatformViewsChannel.this.handler.setDirection(((Integer) map.get("id")).intValue(), ((Integer) map.get("direction")).intValue());
                result.success(null);
            } catch (IllegalStateException e2) {
                result.error("error", PlatformViewsChannel.detailedExceptionString(e2), null);
            }
        }

        private void touch(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            MethodChannel.Result result2;
            List list = (List) methodCall.arguments();
            try {
                PlatformViewsChannel.this.handler.onTouch(new PlatformViewTouch(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue()));
                result2 = result;
                try {
                    result2.success(null);
                } catch (IllegalStateException e2) {
                    e = e2;
                    result2.error("error", PlatformViewsChannel.detailedExceptionString(e), null);
                }
            } catch (IllegalStateException e3) {
                e = e3;
                result2 = result;
            }
        }

        @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
        public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            if (PlatformViewsChannel.this.handler == null) {
                return;
            }
            Log.v(PlatformViewsChannel.TAG, "Received '" + methodCall.method + "' message.");
            String str = methodCall.method;
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1352294148:
                    if (str.equals("create")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -934437708:
                    if (str.equals("resize")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -756050293:
                    if (str.equals("clearFocus")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 110550847:
                    if (str.equals("touch")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 576796989:
                    if (str.equals("setDirection")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1671767583:
                    if (str.equals("dispose")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                create(methodCall, result);
            } else if (c2 == 1) {
                dispose(methodCall, result);
            } else if (c2 == 2) {
                resize(methodCall, result);
            } else if (c2 == 3) {
                touch(methodCall, result);
            } else if (c2 == 4) {
                setDirection(methodCall, result);
            } else if (c2 != 5) {
                result.notImplemented();
            } else {
                clearFocus(methodCall, result);
            }
        }
    };

    /* loaded from: classes7.dex */
    public static class PlatformViewCreationRequest {
        public final int direction;
        public final double logicalHeight;
        public final double logicalWidth;
        @Nullable
        public final ByteBuffer params;
        public final int viewId;
        @NonNull
        public final String viewType;

        public PlatformViewCreationRequest(int i2, @NonNull String str, double d2, double d3, int i3, @Nullable ByteBuffer byteBuffer) {
            this.viewId = i2;
            this.viewType = str;
            this.logicalWidth = d2;
            this.logicalHeight = d3;
            this.direction = i3;
            this.params = byteBuffer;
        }
    }

    /* loaded from: classes7.dex */
    public static class PlatformViewResizeRequest {
        public final double newLogicalHeight;
        public final double newLogicalWidth;
        public final int viewId;

        public PlatformViewResizeRequest(int i2, double d2, double d3) {
            this.viewId = i2;
            this.newLogicalWidth = d2;
            this.newLogicalHeight = d3;
        }
    }

    /* loaded from: classes7.dex */
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

        public PlatformViewTouch(int i2, @NonNull Number number, @NonNull Number number2, int i3, int i4, @NonNull Object obj, @NonNull Object obj2, int i5, int i6, float f2, float f3, int i7, int i8, int i9, int i10) {
            this.viewId = i2;
            this.downTime = number;
            this.eventTime = number2;
            this.action = i3;
            this.pointerCount = i4;
            this.rawPointerPropertiesList = obj;
            this.rawPointerCoords = obj2;
            this.metaState = i5;
            this.buttonState = i6;
            this.xPrecision = f2;
            this.yPrecision = f3;
            this.deviceId = i7;
            this.edgeFlags = i8;
            this.source = i9;
            this.flags = i10;
        }
    }

    /* loaded from: classes7.dex */
    public interface PlatformViewsHandler {
        void clearFocus(int i2);

        long createPlatformView(@NonNull PlatformViewCreationRequest platformViewCreationRequest);

        void disposePlatformView(int i2);

        void onTouch(@NonNull PlatformViewTouch platformViewTouch);

        void resizePlatformView(@NonNull PlatformViewResizeRequest platformViewResizeRequest, @NonNull Runnable runnable);

        void setDirection(int i2, int i3);
    }

    public PlatformViewsChannel(@NonNull DartExecutor dartExecutor) {
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/platform_views", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this.parsingHandler);
    }

    public static String detailedExceptionString(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public void invokeViewFocused(int i2) {
        MethodChannel methodChannel = this.channel;
        if (methodChannel == null) {
            return;
        }
        methodChannel.invokeMethod("viewFocused", Integer.valueOf(i2));
    }

    public void setPlatformViewsHandler(@Nullable PlatformViewsHandler platformViewsHandler) {
        this.handler = platformViewsHandler;
    }
}
