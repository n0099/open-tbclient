package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class TextInputChannel {
    private static final String TAG = "TextInputChannel";
    @NonNull
    public final MethodChannel channel;
    private final MethodChannel.MethodCallHandler parsingMethodHandler = new MethodChannel.MethodCallHandler() { // from class: io.flutter.embedding.engine.systemchannels.TextInputChannel.1
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0048, code lost:
            if (r4.equals("TextInput.show") != false) goto L8;
         */
        @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            char c = 0;
            if (TextInputChannel.this.textInputMethodHandler != null) {
                String str = methodCall.method;
                Object obj = methodCall.arguments;
                Log.v(TextInputChannel.TAG, "Received '" + str + "' message.");
                switch (str.hashCode()) {
                    case -1779068172:
                        if (str.equals("TextInput.setPlatformViewClient")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1015421462:
                        if (str.equals("TextInput.setEditingState")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case -37561188:
                        if (str.equals("TextInput.setClient")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case 270476819:
                        if (str.equals("TextInput.hide")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 270803918:
                        break;
                    case 1904427655:
                        if (str.equals("TextInput.clearClient")) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                        TextInputChannel.this.textInputMethodHandler.show();
                        result.success(null);
                        return;
                    case 1:
                        TextInputChannel.this.textInputMethodHandler.hide();
                        result.success(null);
                        return;
                    case 2:
                        try {
                            JSONArray jSONArray = (JSONArray) obj;
                            TextInputChannel.this.textInputMethodHandler.setClient(jSONArray.getInt(0), Configuration.fromJson(jSONArray.getJSONObject(1)));
                            result.success(null);
                            return;
                        } catch (NoSuchFieldException | JSONException e) {
                            result.error(BdStatsConstant.StatsType.ERROR, e.getMessage(), null);
                            return;
                        }
                    case 3:
                        TextInputChannel.this.textInputMethodHandler.setPlatformViewClient(((Integer) obj).intValue());
                        return;
                    case 4:
                        try {
                            TextInputChannel.this.textInputMethodHandler.setEditingState(TextEditState.fromJson((JSONObject) obj));
                            result.success(null);
                            return;
                        } catch (JSONException e2) {
                            result.error(BdStatsConstant.StatsType.ERROR, e2.getMessage(), null);
                            return;
                        }
                    case 5:
                        TextInputChannel.this.textInputMethodHandler.clearClient();
                        result.success(null);
                        return;
                    default:
                        result.notImplemented();
                        return;
                }
            }
        }
    };
    @Nullable
    private TextInputMethodHandler textInputMethodHandler;

    /* loaded from: classes19.dex */
    public interface TextInputMethodHandler {
        void clearClient();

        void hide();

        void setClient(int i, @NonNull Configuration configuration);

        void setEditingState(@NonNull TextEditState textEditState);

        void setPlatformViewClient(int i);

        void show();
    }

    public TextInputChannel(@NonNull DartExecutor dartExecutor) {
        this.channel = new MethodChannel(dartExecutor, "flutter/textinput", JSONMethodCodec.INSTANCE);
        this.channel.setMethodCallHandler(this.parsingMethodHandler);
    }

    public void requestExistingInputState() {
        this.channel.invokeMethod("TextInputClient.requestExistingInputState", null);
    }

    public void updateEditingState(int i, String str, int i2, int i3, int i4, int i5) {
        Log.v(TAG, "Sending message to update editing state: \nText: " + str + "\nSelection start: " + i2 + "\nSelection end: " + i3 + "\nComposing start: " + i4 + "\nComposing end: " + i5);
        HashMap hashMap = new HashMap();
        hashMap.put("text", str);
        hashMap.put("selectionBase", Integer.valueOf(i2));
        hashMap.put("selectionExtent", Integer.valueOf(i3));
        hashMap.put("composingBase", Integer.valueOf(i4));
        hashMap.put("composingExtent", Integer.valueOf(i5));
        this.channel.invokeMethod("TextInputClient.updateEditingState", Arrays.asList(Integer.valueOf(i), hashMap));
    }

    public void newline(int i) {
        Log.v(TAG, "Sending 'newline' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.newline"));
    }

    public void go(int i) {
        Log.v(TAG, "Sending 'go' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.go"));
    }

    public void search(int i) {
        Log.v(TAG, "Sending 'search' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.search"));
    }

    public void send(int i) {
        Log.v(TAG, "Sending 'send' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.send"));
    }

    public void done(int i) {
        Log.v(TAG, "Sending 'done' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.done"));
    }

    public void next(int i) {
        Log.v(TAG, "Sending 'next' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.next"));
    }

    public void previous(int i) {
        Log.v(TAG, "Sending 'previous' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.previous"));
    }

    public void unspecifiedAction(int i) {
        Log.v(TAG, "Sending 'unspecified' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.unspecified"));
    }

    public void setTextInputMethodHandler(@Nullable TextInputMethodHandler textInputMethodHandler) {
        this.textInputMethodHandler = textInputMethodHandler;
    }

    /* loaded from: classes19.dex */
    public static class Configuration {
        @Nullable
        public final String actionLabel;
        public final boolean autocorrect;
        public final boolean enableSuggestions;
        @Nullable
        public final Integer inputAction;
        @NonNull
        public final InputType inputType;
        public final boolean obscureText;
        @NonNull
        public final TextCapitalization textCapitalization;

        public static Configuration fromJson(@NonNull JSONObject jSONObject) throws JSONException, NoSuchFieldException {
            String string = jSONObject.getString("inputAction");
            if (string == null) {
                throw new JSONException("Configuration JSON missing 'inputAction' property.");
            }
            return new Configuration(jSONObject.optBoolean("obscureText"), jSONObject.optBoolean("autocorrect", true), jSONObject.optBoolean("enableSuggestions"), TextCapitalization.fromValue(jSONObject.getString("textCapitalization")), InputType.fromJson(jSONObject.getJSONObject("inputType")), inputActionFromTextInputAction(string), jSONObject.isNull("actionLabel") ? null : jSONObject.getString("actionLabel"));
        }

        @NonNull
        private static Integer inputActionFromTextInputAction(@NonNull String str) {
            char c = 65535;
            switch (str.hashCode()) {
                case -810971940:
                    if (str.equals("TextInputAction.unspecified")) {
                        c = 2;
                        break;
                    }
                    break;
                case -737377923:
                    if (str.equals("TextInputAction.done")) {
                        c = 3;
                        break;
                    }
                    break;
                case -737089298:
                    if (str.equals("TextInputAction.next")) {
                        c = 7;
                        break;
                    }
                    break;
                case -737080013:
                    if (str.equals("TextInputAction.none")) {
                        c = 1;
                        break;
                    }
                    break;
                case -736940669:
                    if (str.equals("TextInputAction.send")) {
                        c = 6;
                        break;
                    }
                    break;
                case 469250275:
                    if (str.equals("TextInputAction.search")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1241689507:
                    if (str.equals("TextInputAction.go")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1539450297:
                    if (str.equals("TextInputAction.newline")) {
                        c = 0;
                        break;
                    }
                    break;
                case 2110497650:
                    if (str.equals("TextInputAction.previous")) {
                        c = '\b';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return 1;
                case 1:
                    return 1;
                case 2:
                    return 0;
                case 3:
                    return 6;
                case 4:
                    return 2;
                case 5:
                    return 3;
                case 6:
                    return 4;
                case 7:
                    return 5;
                case '\b':
                    return 7;
                default:
                    return 0;
            }
        }

        public Configuration(boolean z, boolean z2, boolean z3, @NonNull TextCapitalization textCapitalization, @NonNull InputType inputType, @Nullable Integer num, @Nullable String str) {
            this.obscureText = z;
            this.autocorrect = z2;
            this.enableSuggestions = z3;
            this.textCapitalization = textCapitalization;
            this.inputType = inputType;
            this.inputAction = num;
            this.actionLabel = str;
        }
    }

    /* loaded from: classes19.dex */
    public static class InputType {
        public final boolean isDecimal;
        public final boolean isSigned;
        @NonNull
        public final TextInputType type;

        @NonNull
        public static InputType fromJson(@NonNull JSONObject jSONObject) throws JSONException, NoSuchFieldException {
            return new InputType(TextInputType.fromValue(jSONObject.getString("name")), jSONObject.optBoolean("signed", false), jSONObject.optBoolean("decimal", false));
        }

        public InputType(@NonNull TextInputType textInputType, boolean z, boolean z2) {
            this.type = textInputType;
            this.isSigned = z;
            this.isDecimal = z2;
        }
    }

    /* loaded from: classes19.dex */
    public enum TextInputType {
        TEXT("TextInputType.text"),
        DATETIME("TextInputType.datetime"),
        NUMBER("TextInputType.number"),
        PHONE("TextInputType.phone"),
        MULTILINE("TextInputType.multiline"),
        EMAIL_ADDRESS("TextInputType.emailAddress"),
        URL("TextInputType.url"),
        VISIBLE_PASSWORD("TextInputType.visiblePassword");
        
        @NonNull
        private final String encodedName;

        static TextInputType fromValue(@NonNull String str) throws NoSuchFieldException {
            TextInputType[] values;
            for (TextInputType textInputType : values()) {
                if (textInputType.encodedName.equals(str)) {
                    return textInputType;
                }
            }
            throw new NoSuchFieldException("No such TextInputType: " + str);
        }

        TextInputType(@NonNull String str) {
            this.encodedName = str;
        }
    }

    /* loaded from: classes19.dex */
    public enum TextCapitalization {
        CHARACTERS("TextCapitalization.characters"),
        WORDS("TextCapitalization.words"),
        SENTENCES("TextCapitalization.sentences"),
        NONE("TextCapitalization.none");
        
        @NonNull
        private final String encodedName;

        static TextCapitalization fromValue(@NonNull String str) throws NoSuchFieldException {
            TextCapitalization[] values;
            for (TextCapitalization textCapitalization : values()) {
                if (textCapitalization.encodedName.equals(str)) {
                    return textCapitalization;
                }
            }
            throw new NoSuchFieldException("No such TextCapitalization: " + str);
        }

        TextCapitalization(@NonNull String str) {
            this.encodedName = str;
        }
    }

    /* loaded from: classes19.dex */
    public static class TextEditState {
        public final int selectionEnd;
        public final int selectionStart;
        @NonNull
        public final String text;

        public static TextEditState fromJson(@NonNull JSONObject jSONObject) throws JSONException {
            return new TextEditState(jSONObject.getString("text"), jSONObject.getInt("selectionBase"), jSONObject.getInt("selectionExtent"));
        }

        public TextEditState(@NonNull String str, int i, int i2) {
            this.text = str;
            this.selectionStart = i;
            this.selectionEnd = i2;
        }
    }
}
