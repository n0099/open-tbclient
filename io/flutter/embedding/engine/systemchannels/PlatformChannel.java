package io.flutter.embedding.engine.systemchannels;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompatJellybean;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.kwad.sdk.core.config.item.TipsConfigItem;
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
    public static final String TAG = "PlatformChannel";
    @NonNull
    public final MethodChannel channel;
    @NonNull
    @VisibleForTesting
    public final MethodChannel.MethodCallHandler parsingMethodCallHandler = new MethodChannel.MethodCallHandler() { // from class: io.flutter.embedding.engine.systemchannels.PlatformChannel.1
        /* JADX WARN: Removed duplicated region for block: B:57:0x00fa A[Catch: JSONException -> 0x0225, TryCatch #5 {JSONException -> 0x0225, blocks: (B:6:0x002c, B:7:0x0030, B:47:0x00b7, B:48:0x00bc, B:49:0x00d0, B:51:0x00d4, B:55:0x00ee, B:57:0x00fa, B:58:0x0107, B:53:0x00d9, B:59:0x010c, B:61:0x0110, B:62:0x0119, B:63:0x012f, B:65:0x013b, B:66:0x0142, B:67:0x014d, B:75:0x017d, B:96:0x01ed, B:101:0x0209, B:74:0x0174, B:82:0x01a4, B:87:0x01c4, B:94:0x01e5, B:99:0x0201, B:104:0x021d, B:9:0x0035, B:12:0x0040, B:15:0x004b, B:18:0x0056, B:21:0x0060, B:24:0x006a, B:27:0x0075, B:30:0x0080, B:33:0x008a, B:36:0x0094, B:39:0x009e, B:42:0x00a9, B:84:0x01ad), top: B:113:0x002c, inners: #0, #1, #6, #10 }] */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0107 A[Catch: JSONException -> 0x0225, TryCatch #5 {JSONException -> 0x0225, blocks: (B:6:0x002c, B:7:0x0030, B:47:0x00b7, B:48:0x00bc, B:49:0x00d0, B:51:0x00d4, B:55:0x00ee, B:57:0x00fa, B:58:0x0107, B:53:0x00d9, B:59:0x010c, B:61:0x0110, B:62:0x0119, B:63:0x012f, B:65:0x013b, B:66:0x0142, B:67:0x014d, B:75:0x017d, B:96:0x01ed, B:101:0x0209, B:74:0x0174, B:82:0x01a4, B:87:0x01c4, B:94:0x01e5, B:99:0x0201, B:104:0x021d, B:9:0x0035, B:12:0x0040, B:15:0x004b, B:18:0x0056, B:21:0x0060, B:24:0x006a, B:27:0x0075, B:30:0x0080, B:33:0x008a, B:36:0x0094, B:39:0x009e, B:42:0x00a9, B:84:0x01ad), top: B:113:0x002c, inners: #0, #1, #6, #10 }] */
        @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            String str;
            ClipboardContentFormat fromValue;
            CharSequence clipboardData;
            if (PlatformChannel.this.platformMessageHandler == null) {
                return;
            }
            String str2 = methodCall.method;
            Object obj = methodCall.arguments;
            Log.v(PlatformChannel.TAG, "Received '" + str2 + "' message.");
            char c2 = 65535;
            try {
                switch (str2.hashCode()) {
                    case -766342101:
                        if (str2.equals("SystemNavigator.pop")) {
                            c2 = 7;
                            break;
                        }
                        break;
                    case -720677196:
                        if (str2.equals("Clipboard.setData")) {
                            c2 = 11;
                            break;
                        }
                        break;
                    case -548468504:
                        if (str2.equals("SystemChrome.setApplicationSwitcherDescription")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -247230243:
                        if (str2.equals("HapticFeedback.vibrate")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -215273374:
                        if (str2.equals("SystemSound.play")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 96412730:
                        if (str2.equals("SystemGestures.getSystemGestureExclusionRects")) {
                            c2 = '\b';
                            break;
                        }
                        break;
                    case 232206254:
                        if (str2.equals("SystemGestures.setSystemGestureExclusionRects")) {
                            c2 = '\t';
                            break;
                        }
                        break;
                    case 241845679:
                        if (str2.equals("SystemChrome.restoreSystemUIOverlays")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 1390477857:
                        if (str2.equals("SystemChrome.setSystemUIOverlayStyle")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case 1514180520:
                        if (str2.equals("Clipboard.getData")) {
                            c2 = '\n';
                            break;
                        }
                        break;
                    case 1674312266:
                        if (str2.equals("SystemChrome.setEnabledSystemUIOverlays")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 2119655719:
                        if (str2.equals("SystemChrome.setPreferredOrientations")) {
                            c2 = 2;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        try {
                            PlatformChannel.this.platformMessageHandler.playSystemSound(SoundType.fromValue((String) obj));
                            result.success(null);
                            return;
                        } catch (NoSuchFieldException e2) {
                            result.error("error", e2.getMessage(), null);
                            return;
                        }
                    case 1:
                        try {
                            PlatformChannel.this.platformMessageHandler.vibrateHapticFeedback(HapticFeedbackType.fromValue((String) obj));
                            result.success(null);
                            return;
                        } catch (NoSuchFieldException e3) {
                            result.error("error", e3.getMessage(), null);
                            return;
                        }
                    case 2:
                        try {
                            PlatformChannel.this.platformMessageHandler.setPreferredOrientations(PlatformChannel.this.decodeOrientations((JSONArray) obj));
                            result.success(null);
                            return;
                        } catch (NoSuchFieldException | JSONException e4) {
                            result.error("error", e4.getMessage(), null);
                            return;
                        }
                    case 3:
                        try {
                            PlatformChannel.this.platformMessageHandler.setApplicationSwitcherDescription(PlatformChannel.this.decodeAppSwitcherDescription((JSONObject) obj));
                            result.success(null);
                            return;
                        } catch (JSONException e5) {
                            result.error("error", e5.getMessage(), null);
                            return;
                        }
                    case 4:
                        try {
                            PlatformChannel.this.platformMessageHandler.showSystemOverlays(PlatformChannel.this.decodeSystemUiOverlays((JSONArray) obj));
                            result.success(null);
                            return;
                        } catch (NoSuchFieldException | JSONException e6) {
                            result.error("error", e6.getMessage(), null);
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
                        } catch (NoSuchFieldException | JSONException e7) {
                            result.error("error", e7.getMessage(), null);
                            return;
                        }
                    case 7:
                        PlatformChannel.this.platformMessageHandler.popSystemNavigator();
                        result.success(null);
                        return;
                    case '\b':
                        List<Rect> systemGestureExclusionRects = PlatformChannel.this.platformMessageHandler.getSystemGestureExclusionRects();
                        if (systemGestureExclusionRects == null) {
                            result.error("error", "Exclusion rects only exist for Android API 29+.", null);
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
                            } catch (NoSuchFieldException unused) {
                                result.error("error", "No such clipboard content format: " + str, null);
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
                result.error("error", "JSON error: " + e8.getMessage(), null);
            }
            result.error("error", "JSON error: " + e8.getMessage(), null);
        }
    };
    @Nullable
    public PlatformMessageHandler platformMessageHandler;

    /* renamed from: io.flutter.embedding.engine.systemchannels.PlatformChannel$2  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation;
        public static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay;

        static {
            int[] iArr = new int[SystemUiOverlay.values().length];
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay = iArr;
            try {
                iArr[SystemUiOverlay.TOP_OVERLAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay[SystemUiOverlay.BOTTOM_OVERLAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[DeviceOrientation.values().length];
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation = iArr2;
            try {
                iArr2[DeviceOrientation.PORTRAIT_UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[DeviceOrientation.PORTRAIT_DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[DeviceOrientation.LANDSCAPE_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[DeviceOrientation.LANDSCAPE_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
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
    public enum Brightness {
        LIGHT("Brightness.light"),
        DARK("Brightness.dark");
        
        @NonNull
        public String encodedName;

        Brightness(@NonNull String str) {
            this.encodedName = str;
        }

        @NonNull
        public static Brightness fromValue(@NonNull String str) throws NoSuchFieldException {
            Brightness[] values;
            for (Brightness brightness : values()) {
                if (brightness.encodedName.equals(str)) {
                    return brightness;
                }
            }
            throw new NoSuchFieldException("No such Brightness: " + str);
        }
    }

    /* loaded from: classes7.dex */
    public enum ClipboardContentFormat {
        PLAIN_TEXT("text/plain");
        
        @NonNull
        public String encodedName;

        ClipboardContentFormat(@NonNull String str) {
            this.encodedName = str;
        }

        @NonNull
        public static ClipboardContentFormat fromValue(@NonNull String str) throws NoSuchFieldException {
            ClipboardContentFormat[] values;
            for (ClipboardContentFormat clipboardContentFormat : values()) {
                if (clipboardContentFormat.encodedName.equals(str)) {
                    return clipboardContentFormat;
                }
            }
            throw new NoSuchFieldException("No such ClipboardContentFormat: " + str);
        }
    }

    /* loaded from: classes7.dex */
    public enum DeviceOrientation {
        PORTRAIT_UP("DeviceOrientation.portraitUp"),
        PORTRAIT_DOWN("DeviceOrientation.portraitDown"),
        LANDSCAPE_LEFT("DeviceOrientation.landscapeLeft"),
        LANDSCAPE_RIGHT("DeviceOrientation.landscapeRight");
        
        @NonNull
        public String encodedName;

        DeviceOrientation(@NonNull String str) {
            this.encodedName = str;
        }

        @NonNull
        public static DeviceOrientation fromValue(@NonNull String str) throws NoSuchFieldException {
            DeviceOrientation[] values;
            for (DeviceOrientation deviceOrientation : values()) {
                if (deviceOrientation.encodedName.equals(str)) {
                    return deviceOrientation;
                }
            }
            throw new NoSuchFieldException("No such DeviceOrientation: " + str);
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
        public final String encodedName;

        HapticFeedbackType(@Nullable String str) {
            this.encodedName = str;
        }

        @NonNull
        public static HapticFeedbackType fromValue(@Nullable String str) throws NoSuchFieldException {
            HapticFeedbackType[] values;
            String str2;
            for (HapticFeedbackType hapticFeedbackType : values()) {
                if ((hapticFeedbackType.encodedName == null && str == null) || ((str2 = hapticFeedbackType.encodedName) != null && str2.equals(str))) {
                    return hapticFeedbackType;
                }
            }
            throw new NoSuchFieldException("No such HapticFeedbackType: " + str);
        }
    }

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

    /* loaded from: classes7.dex */
    public enum SoundType {
        CLICK("SystemSoundType.click");
        
        @NonNull
        public final String encodedName;

        SoundType(@NonNull String str) {
            this.encodedName = str;
        }

        @NonNull
        public static SoundType fromValue(@NonNull String str) throws NoSuchFieldException {
            SoundType[] values;
            for (SoundType soundType : values()) {
                if (soundType.encodedName.equals(str)) {
                    return soundType;
                }
            }
            throw new NoSuchFieldException("No such SoundType: " + str);
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
    public enum SystemUiOverlay {
        TOP_OVERLAYS("SystemUiOverlay.top"),
        BOTTOM_OVERLAYS("SystemUiOverlay.bottom");
        
        @NonNull
        public String encodedName;

        SystemUiOverlay(@NonNull String str) {
            this.encodedName = str;
        }

        @NonNull
        public static SystemUiOverlay fromValue(@NonNull String str) throws NoSuchFieldException {
            SystemUiOverlay[] values;
            for (SystemUiOverlay systemUiOverlay : values()) {
                if (systemUiOverlay.encodedName.equals(str)) {
                    return systemUiOverlay;
                }
            }
            throw new NoSuchFieldException("No such SystemUiOverlay: " + str);
        }
    }

    public PlatformChannel(@NonNull DartExecutor dartExecutor) {
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/platform", JSONMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this.parsingMethodCallHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public AppSwitcherDescription decodeAppSwitcherDescription(@NonNull JSONObject jSONObject) throws JSONException {
        int i = jSONObject.getInt("primaryColor");
        if (i != 0) {
            i |= -16777216;
        }
        return new AppSwitcherDescription(i, jSONObject.getString(NotificationCompatJellybean.KEY_LABEL));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public ArrayList<Rect> decodeExclusionRects(@NonNull JSONArray jSONArray) throws JSONException {
        ArrayList<Rect> arrayList = new ArrayList<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            try {
                arrayList.add(new Rect(jSONObject.getInt(CustomDialogData.POS_LEFT), jSONObject.getInt("top"), jSONObject.getInt("right"), jSONObject.getInt(TipsConfigItem.TipConfigData.BOTTOM)));
            } catch (JSONException unused) {
                throw new JSONException("Incorrect JSON data shape. To set system gesture exclusion rects, \na JSONObject with top, right, bottom and left values need to be set to int values.");
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0053 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int decodeOrientations(@NonNull JSONArray jSONArray) throws JSONException, NoSuchFieldException {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < jSONArray.length(); i++) {
            int i2 = AnonymousClass2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[DeviceOrientation.fromValue(jSONArray.getString(i)).ordinal()];
            if (i2 == 1) {
                z |= true;
            } else if (i2 == 2) {
                z |= true;
            } else if (i2 == 3) {
                z |= true;
            } else if (i2 == 4) {
                z |= true;
            }
            if (!z2) {
                z2 = z;
            }
        }
        if (z) {
            switch (z) {
                case true:
                    return 0;
                case true:
                case true:
                case true:
                case true:
                case true:
                case true:
                case true:
                    if (!z2) {
                        if (!z2) {
                            return !z2 ? 1 : 8;
                        }
                        return 9;
                    }
                    return 0;
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
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public SystemChromeStyle decodeSystemChromeStyle(@NonNull JSONObject jSONObject) throws JSONException, NoSuchFieldException {
        Brightness fromValue = !jSONObject.isNull("systemNavigationBarIconBrightness") ? Brightness.fromValue(jSONObject.getString("systemNavigationBarIconBrightness")) : null;
        Integer valueOf = !jSONObject.isNull("systemNavigationBarColor") ? Integer.valueOf(jSONObject.getInt("systemNavigationBarColor")) : null;
        return new SystemChromeStyle(!jSONObject.isNull("statusBarColor") ? Integer.valueOf(jSONObject.getInt("statusBarColor")) : null, !jSONObject.isNull("statusBarIconBrightness") ? Brightness.fromValue(jSONObject.getString("statusBarIconBrightness")) : null, valueOf, fromValue, jSONObject.isNull("systemNavigationBarDividerColor") ? null : Integer.valueOf(jSONObject.getInt("systemNavigationBarDividerColor")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public List<SystemUiOverlay> decodeSystemUiOverlays(@NonNull JSONArray jSONArray) throws JSONException, NoSuchFieldException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            int i2 = AnonymousClass2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay[SystemUiOverlay.fromValue(jSONArray.getString(i)).ordinal()];
            if (i2 == 1) {
                arrayList.add(SystemUiOverlay.TOP_OVERLAYS);
            } else if (i2 == 2) {
                arrayList.add(SystemUiOverlay.BOTTOM_OVERLAYS);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<HashMap<String, Integer>> encodeExclusionRects(List<Rect> list) {
        ArrayList<HashMap<String, Integer>> arrayList = new ArrayList<>();
        for (Rect rect : list) {
            HashMap<String, Integer> hashMap = new HashMap<>();
            hashMap.put("top", Integer.valueOf(rect.top));
            hashMap.put("right", Integer.valueOf(rect.right));
            hashMap.put(TipsConfigItem.TipConfigData.BOTTOM, Integer.valueOf(rect.bottom));
            hashMap.put(CustomDialogData.POS_LEFT, Integer.valueOf(rect.left));
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    public void setPlatformMessageHandler(@Nullable PlatformMessageHandler platformMessageHandler) {
        this.platformMessageHandler = platformMessageHandler;
    }
}
