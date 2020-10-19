package io.flutter.embedding.engine.systemchannels;

import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class PlatformChannel {
    private static final String TAG = "PlatformChannel";
    @NonNull
    public final MethodChannel channel;
    @NonNull
    @VisibleForTesting
    protected final MethodChannel.MethodCallHandler parsingMethodCallHandler = new MethodChannel.MethodCallHandler() { // from class: io.flutter.embedding.engine.systemchannels.PlatformChannel.1
        /* JADX WARN: Removed duplicated region for block: B:93:0x0240 A[Catch: JSONException -> 0x003e, TryCatch #10 {JSONException -> 0x003e, blocks: (B:6:0x0030, B:7:0x0034, B:8:0x0037, B:9:0x003a, B:49:0x00ea, B:54:0x010d, B:73:0x019f, B:79:0x01d3, B:80:0x01e2, B:82:0x01ee, B:83:0x01fa, B:84:0x0205, B:86:0x0209, B:87:0x0215, B:88:0x022c, B:90:0x0230, B:91:0x0234, B:93:0x0240, B:97:0x026e, B:95:0x0251, B:98:0x0274, B:52:0x0100, B:57:0x0123, B:62:0x0148, B:67:0x016d, B:72:0x0192, B:78:0x01c6, B:13:0x005e, B:16:0x0069, B:19:0x0074, B:22:0x007f, B:25:0x008a, B:28:0x0095, B:31:0x00a0, B:34:0x00ab, B:37:0x00b6, B:40:0x00c3, B:43:0x00d0, B:46:0x00dd, B:64:0x0155), top: B:114:0x0030, inners: #5, #6, #8, #9 }] */
        /* JADX WARN: Removed duplicated region for block: B:97:0x026e A[Catch: JSONException -> 0x003e, TryCatch #10 {JSONException -> 0x003e, blocks: (B:6:0x0030, B:7:0x0034, B:8:0x0037, B:9:0x003a, B:49:0x00ea, B:54:0x010d, B:73:0x019f, B:79:0x01d3, B:80:0x01e2, B:82:0x01ee, B:83:0x01fa, B:84:0x0205, B:86:0x0209, B:87:0x0215, B:88:0x022c, B:90:0x0230, B:91:0x0234, B:93:0x0240, B:97:0x026e, B:95:0x0251, B:98:0x0274, B:52:0x0100, B:57:0x0123, B:62:0x0148, B:67:0x016d, B:72:0x0192, B:78:0x01c6, B:13:0x005e, B:16:0x0069, B:19:0x0074, B:22:0x007f, B:25:0x008a, B:28:0x0095, B:31:0x00a0, B:34:0x00ab, B:37:0x00b6, B:40:0x00c3, B:43:0x00d0, B:46:0x00dd, B:64:0x0155), top: B:114:0x0030, inners: #5, #6, #8, #9 }] */
        @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            String str;
            ClipboardContentFormat fromValue;
            CharSequence clipboardData;
            if (PlatformChannel.this.platformMessageHandler != null) {
                String str2 = methodCall.method;
                Object obj = methodCall.arguments;
                Log.v(PlatformChannel.TAG, "Received '" + str2 + "' message.");
                char c = 65535;
                try {
                    switch (str2.hashCode()) {
                        case -766342101:
                            if (str2.equals("SystemNavigator.pop")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -720677196:
                            if (str2.equals("Clipboard.setData")) {
                                c = 11;
                                break;
                            }
                            break;
                        case -548468504:
                            if (str2.equals("SystemChrome.setApplicationSwitcherDescription")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -247230243:
                            if (str2.equals("HapticFeedback.vibrate")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -215273374:
                            if (str2.equals("SystemSound.play")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 96412730:
                            if (str2.equals("SystemGestures.getSystemGestureExclusionRects")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case 232206254:
                            if (str2.equals("SystemGestures.setSystemGestureExclusionRects")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case 241845679:
                            if (str2.equals("SystemChrome.restoreSystemUIOverlays")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 1390477857:
                            if (str2.equals("SystemChrome.setSystemUIOverlayStyle")) {
                                c = 6;
                                break;
                            }
                            break;
                        case 1514180520:
                            if (str2.equals("Clipboard.getData")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case 1674312266:
                            if (str2.equals("SystemChrome.setEnabledSystemUIOverlays")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 2119655719:
                            if (str2.equals("SystemChrome.setPreferredOrientations")) {
                                c = 2;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            try {
                                PlatformChannel.this.platformMessageHandler.playSystemSound(SoundType.fromValue((String) obj));
                                result.success(null);
                                return;
                            } catch (NoSuchFieldException e) {
                                result.error(BdStatsConstant.StatsType.ERROR, e.getMessage(), null);
                                return;
                            }
                        case 1:
                            try {
                                PlatformChannel.this.platformMessageHandler.vibrateHapticFeedback(HapticFeedbackType.fromValue((String) obj));
                                result.success(null);
                                return;
                            } catch (NoSuchFieldException e2) {
                                result.error(BdStatsConstant.StatsType.ERROR, e2.getMessage(), null);
                                return;
                            }
                        case 2:
                            try {
                                PlatformChannel.this.platformMessageHandler.setPreferredOrientations(PlatformChannel.this.decodeOrientations((JSONArray) obj));
                                result.success(null);
                                return;
                            } catch (NoSuchFieldException | JSONException e3) {
                                result.error(BdStatsConstant.StatsType.ERROR, e3.getMessage(), null);
                                return;
                            }
                        case 3:
                            try {
                                PlatformChannel.this.platformMessageHandler.setApplicationSwitcherDescription(PlatformChannel.this.decodeAppSwitcherDescription((JSONObject) obj));
                                result.success(null);
                                return;
                            } catch (JSONException e4) {
                                result.error(BdStatsConstant.StatsType.ERROR, e4.getMessage(), null);
                                return;
                            }
                        case 4:
                            try {
                                PlatformChannel.this.platformMessageHandler.showSystemOverlays(PlatformChannel.this.decodeSystemUiOverlays((JSONArray) obj));
                                result.success(null);
                                return;
                            } catch (NoSuchFieldException | JSONException e5) {
                                result.error(BdStatsConstant.StatsType.ERROR, e5.getMessage(), null);
                                return;
                            }
                        case 5:
                            PlatformChannel.this.platformMessageHandler.restoreSystemUiOverlays();
                            result.success(null);
                            return;
                        case 6:
                            try {
                                PlatformChannel.this.platformMessageHandler.setSystemUiOverlayStyle(PlatformChannel.this.decodeSystemChromeStyle((JSONObject) obj));
                                result.success(null);
                                return;
                            } catch (NoSuchFieldException | JSONException e6) {
                                result.error(BdStatsConstant.StatsType.ERROR, e6.getMessage(), null);
                                return;
                            }
                        case 7:
                            PlatformChannel.this.platformMessageHandler.popSystemNavigator();
                            result.success(null);
                            return;
                        case '\b':
                            List<Rect> systemGestureExclusionRects = PlatformChannel.this.platformMessageHandler.getSystemGestureExclusionRects();
                            if (systemGestureExclusionRects == null) {
                                result.error(BdStatsConstant.StatsType.ERROR, "Exclusion rects only exist for Android API 29+.", null);
                                return;
                            } else {
                                result.success(PlatformChannel.this.encodeExclusionRects(systemGestureExclusionRects));
                                return;
                            }
                        case '\t':
                            if (!(obj instanceof JSONArray)) {
                                result.error("inputTypeError", "Input type is incorrect. Ensure that a List<Map<String, int>> is passed as the input for SystemGestureExclusionRects.setSystemGestureExclusionRects.", null);
                                return;
                            }
                            PlatformChannel.this.platformMessageHandler.setSystemGestureExclusionRects(PlatformChannel.this.decodeExclusionRects((JSONArray) obj));
                            result.success(null);
                            return;
                        case '\n':
                            String str3 = (String) obj;
                            if (str3 != null) {
                                try {
                                    fromValue = ClipboardContentFormat.fromValue(str3);
                                } catch (NoSuchFieldException e7) {
                                    result.error(BdStatsConstant.StatsType.ERROR, "No such clipboard content format: " + str, null);
                                }
                                clipboardData = PlatformChannel.this.platformMessageHandler.getClipboardData(fromValue);
                                if (clipboardData == null) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("text", clipboardData);
                                    result.success(jSONObject);
                                    return;
                                }
                                result.success(null);
                                return;
                            }
                            fromValue = null;
                            clipboardData = PlatformChannel.this.platformMessageHandler.getClipboardData(fromValue);
                            if (clipboardData == null) {
                            }
                        case 11:
                            PlatformChannel.this.platformMessageHandler.setClipboardData(((JSONObject) obj).getString("text"));
                            result.success(null);
                            return;
                        default:
                            result.notImplemented();
                            return;
                    }
                } catch (JSONException e8) {
                    result.error(BdStatsConstant.StatsType.ERROR, "JSON error: " + e8.getMessage(), null);
                }
                result.error(BdStatsConstant.StatsType.ERROR, "JSON error: " + e8.getMessage(), null);
            }
        }
    };
    @Nullable
    private PlatformMessageHandler platformMessageHandler;

    /* loaded from: classes7.dex */
    public interface PlatformMessageHandler {
        @Nullable
        CharSequence getClipboardData(@Nullable ClipboardContentFormat clipboardContentFormat);

        List<Rect> getSystemGestureExclusionRects();

        void playSystemSound(@NonNull SoundType soundType);

        void popSystemNavigator();

        void restoreSystemUiOverlays();

        void setApplicationSwitcherDescription(@NonNull AppSwitcherDescription appSwitcherDescription);

        void setClipboardData(@NonNull String str);

        void setPreferredOrientations(int i);

        void setSystemGestureExclusionRects(@NonNull ArrayList<Rect> arrayList);

        void setSystemUiOverlayStyle(@NonNull SystemChromeStyle systemChromeStyle);

        void showSystemOverlays(@NonNull List<SystemUiOverlay> list);

        void vibrateHapticFeedback(@NonNull HapticFeedbackType hapticFeedbackType);
    }

    public PlatformChannel(@NonNull DartExecutor dartExecutor) {
        this.channel = new MethodChannel(dartExecutor, "flutter/platform", JSONMethodCodec.INSTANCE);
        this.channel.setMethodCallHandler(this.parsingMethodCallHandler);
    }

    public void setPlatformMessageHandler(@Nullable PlatformMessageHandler platformMessageHandler) {
        this.platformMessageHandler = platformMessageHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public int decodeOrientations(@NonNull JSONArray jSONArray) throws JSONException, NoSuchFieldException {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < jSONArray.length(); i++) {
            switch (DeviceOrientation.fromValue(jSONArray.getString(i))) {
                case PORTRAIT_UP:
                    z2 |= true;
                    break;
                case PORTRAIT_DOWN:
                    z2 |= true;
                    break;
                case LANDSCAPE_LEFT:
                    z2 |= true;
                    break;
                case LANDSCAPE_RIGHT:
                    z2 |= true;
                    break;
            }
            if (!z) {
                z = z2;
            }
        }
        switch (z2) {
            case false:
                return -1;
            case true:
                return 1;
            case true:
                return 0;
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
                switch (z) {
                    case true:
                        return 1;
                    case true:
                        return 0;
                    case true:
                        return 9;
                    case true:
                        return 8;
                }
            case true:
                return 9;
            case true:
                return 12;
            case true:
                return 8;
            case true:
                return 11;
            case true:
                return 2;
            case true:
                return 13;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public ArrayList<Rect> decodeExclusionRects(@NonNull JSONArray jSONArray) throws JSONException {
        ArrayList<Rect> arrayList = new ArrayList<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            try {
                arrayList.add(new Rect(jSONObject.getInt("left"), jSONObject.getInt(VerticalTranslateLayout.TOP), jSONObject.getInt(HorizontalTranslateLayout.DIRECTION_RIGHT), jSONObject.getInt(VerticalTranslateLayout.BOTTOM)));
            } catch (JSONException e) {
                throw new JSONException("Incorrect JSON data shape. To set system gesture exclusion rects, \na JSONObject with top, right, bottom and left values need to be set to int values.");
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<HashMap<String, Integer>> encodeExclusionRects(List<Rect> list) {
        ArrayList<HashMap<String, Integer>> arrayList = new ArrayList<>();
        for (Rect rect : list) {
            HashMap<String, Integer> hashMap = new HashMap<>();
            hashMap.put(VerticalTranslateLayout.TOP, Integer.valueOf(rect.top));
            hashMap.put(HorizontalTranslateLayout.DIRECTION_RIGHT, Integer.valueOf(rect.right));
            hashMap.put(VerticalTranslateLayout.BOTTOM, Integer.valueOf(rect.bottom));
            hashMap.put("left", Integer.valueOf(rect.left));
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public AppSwitcherDescription decodeAppSwitcherDescription(@NonNull JSONObject jSONObject) throws JSONException {
        int i = jSONObject.getInt("primaryColor");
        if (i != 0) {
            i |= ViewCompat.MEASURED_STATE_MASK;
        }
        return new AppSwitcherDescription(i, jSONObject.getString("label"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public List<SystemUiOverlay> decodeSystemUiOverlays(@NonNull JSONArray jSONArray) throws JSONException, NoSuchFieldException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            switch (SystemUiOverlay.fromValue(jSONArray.getString(i))) {
                case TOP_OVERLAYS:
                    arrayList.add(SystemUiOverlay.TOP_OVERLAYS);
                    break;
                case BOTTOM_OVERLAYS:
                    arrayList.add(SystemUiOverlay.BOTTOM_OVERLAYS);
                    break;
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public SystemChromeStyle decodeSystemChromeStyle(@NonNull JSONObject jSONObject) throws JSONException, NoSuchFieldException {
        Brightness fromValue = !jSONObject.isNull("systemNavigationBarIconBrightness") ? Brightness.fromValue(jSONObject.getString("systemNavigationBarIconBrightness")) : null;
        Integer valueOf = !jSONObject.isNull("systemNavigationBarColor") ? Integer.valueOf(jSONObject.getInt("systemNavigationBarColor")) : null;
        return new SystemChromeStyle(!jSONObject.isNull("statusBarColor") ? Integer.valueOf(jSONObject.getInt("statusBarColor")) : null, !jSONObject.isNull("statusBarIconBrightness") ? Brightness.fromValue(jSONObject.getString("statusBarIconBrightness")) : null, valueOf, fromValue, !jSONObject.isNull("systemNavigationBarDividerColor") ? Integer.valueOf(jSONObject.getInt("systemNavigationBarDividerColor")) : null);
    }

    /* loaded from: classes7.dex */
    public enum SoundType {
        CLICK("SystemSoundType.click");
        
        @NonNull
        private final String encodedName;

        @NonNull
        static SoundType fromValue(@NonNull String str) throws NoSuchFieldException {
            SoundType[] values;
            for (SoundType soundType : values()) {
                if (soundType.encodedName.equals(str)) {
                    return soundType;
                }
            }
            throw new NoSuchFieldException("No such SoundType: " + str);
        }

        SoundType(@NonNull String str) {
            this.encodedName = str;
        }
    }

    /* loaded from: classes7.dex */
    public enum HapticFeedbackType {
        STANDARD(null),
        LIGHT_IMPACT("HapticFeedbackType.lightImpact"),
        MEDIUM_IMPACT("HapticFeedbackType.mediumImpact"),
        HEAVY_IMPACT("HapticFeedbackType.heavyImpact"),
        SELECTION_CLICK("HapticFeedbackType.selectionClick");
        
        @Nullable
        private final String encodedName;

        @NonNull
        static HapticFeedbackType fromValue(@Nullable String str) throws NoSuchFieldException {
            HapticFeedbackType[] values;
            for (HapticFeedbackType hapticFeedbackType : values()) {
                if ((hapticFeedbackType.encodedName == null && str == null) || (hapticFeedbackType.encodedName != null && hapticFeedbackType.encodedName.equals(str))) {
                    return hapticFeedbackType;
                }
            }
            throw new NoSuchFieldException("No such HapticFeedbackType: " + str);
        }

        HapticFeedbackType(@Nullable String str) {
            this.encodedName = str;
        }
    }

    /* loaded from: classes7.dex */
    public enum DeviceOrientation {
        PORTRAIT_UP("DeviceOrientation.portraitUp"),
        PORTRAIT_DOWN("DeviceOrientation.portraitDown"),
        LANDSCAPE_LEFT("DeviceOrientation.landscapeLeft"),
        LANDSCAPE_RIGHT("DeviceOrientation.landscapeRight");
        
        @NonNull
        private String encodedName;

        @NonNull
        static DeviceOrientation fromValue(@NonNull String str) throws NoSuchFieldException {
            DeviceOrientation[] values;
            for (DeviceOrientation deviceOrientation : values()) {
                if (deviceOrientation.encodedName.equals(str)) {
                    return deviceOrientation;
                }
            }
            throw new NoSuchFieldException("No such DeviceOrientation: " + str);
        }

        DeviceOrientation(@NonNull String str) {
            this.encodedName = str;
        }
    }

    /* loaded from: classes7.dex */
    public enum SystemUiOverlay {
        TOP_OVERLAYS("SystemUiOverlay.top"),
        BOTTOM_OVERLAYS("SystemUiOverlay.bottom");
        
        @NonNull
        private String encodedName;

        @NonNull
        static SystemUiOverlay fromValue(@NonNull String str) throws NoSuchFieldException {
            SystemUiOverlay[] values;
            for (SystemUiOverlay systemUiOverlay : values()) {
                if (systemUiOverlay.encodedName.equals(str)) {
                    return systemUiOverlay;
                }
            }
            throw new NoSuchFieldException("No such SystemUiOverlay: " + str);
        }

        SystemUiOverlay(@NonNull String str) {
            this.encodedName = str;
        }
    }

    /* loaded from: classes7.dex */
    public static class AppSwitcherDescription {
        public final int color;
        @NonNull
        public final String label;

        public AppSwitcherDescription(int i, @NonNull String str) {
            this.color = i;
            this.label = str;
        }
    }

    /* loaded from: classes7.dex */
    public static class SystemChromeStyle {
        @Nullable
        public final Integer statusBarColor;
        @Nullable
        public final Brightness statusBarIconBrightness;
        @Nullable
        public final Integer systemNavigationBarColor;
        @Nullable
        public final Integer systemNavigationBarDividerColor;
        @Nullable
        public final Brightness systemNavigationBarIconBrightness;

        public SystemChromeStyle(@Nullable Integer num, @Nullable Brightness brightness, @Nullable Integer num2, @Nullable Brightness brightness2, @Nullable Integer num3) {
            this.statusBarColor = num;
            this.statusBarIconBrightness = brightness;
            this.systemNavigationBarColor = num2;
            this.systemNavigationBarIconBrightness = brightness2;
            this.systemNavigationBarDividerColor = num3;
        }
    }

    /* loaded from: classes7.dex */
    public enum Brightness {
        LIGHT("Brightness.light"),
        DARK("Brightness.dark");
        
        @NonNull
        private String encodedName;

        @NonNull
        static Brightness fromValue(@NonNull String str) throws NoSuchFieldException {
            Brightness[] values;
            for (Brightness brightness : values()) {
                if (brightness.encodedName.equals(str)) {
                    return brightness;
                }
            }
            throw new NoSuchFieldException("No such Brightness: " + str);
        }

        Brightness(@NonNull String str) {
            this.encodedName = str;
        }
    }

    /* loaded from: classes7.dex */
    public enum ClipboardContentFormat {
        PLAIN_TEXT("text/plain");
        
        @NonNull
        private String encodedName;

        @NonNull
        static ClipboardContentFormat fromValue(@NonNull String str) throws NoSuchFieldException {
            ClipboardContentFormat[] values;
            for (ClipboardContentFormat clipboardContentFormat : values()) {
                if (clipboardContentFormat.encodedName.equals(str)) {
                    return clipboardContentFormat;
                }
            }
            throw new NoSuchFieldException("No such ClipboardContentFormat: " + str);
        }

        ClipboardContentFormat(@NonNull String str) {
            this.encodedName = str;
        }
    }
}
