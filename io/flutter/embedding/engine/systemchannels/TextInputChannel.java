package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
/* loaded from: classes7.dex */
public class TextInputChannel {
    public static final String TAG = "TextInputChannel";
    @NonNull
    public final MethodChannel channel;
    public final MethodChannel.MethodCallHandler parsingMethodHandler = new MethodChannel.MethodCallHandler() { // from class: io.flutter.embedding.engine.systemchannels.TextInputChannel.1
        @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
        public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            if (TextInputChannel.this.textInputMethodHandler == null) {
                return;
            }
            String str = methodCall.method;
            Object obj = methodCall.arguments;
            Log.v(TextInputChannel.TAG, "Received '" + str + "' message.");
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1779068172:
                    if (str.equals("TextInput.setPlatformViewClient")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1015421462:
                    if (str.equals("TextInput.setEditingState")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -37561188:
                    if (str.equals("TextInput.setClient")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 270476819:
                    if (str.equals("TextInput.hide")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 270803918:
                    if (str.equals("TextInput.show")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1904427655:
                    if (str.equals("TextInput.clearClient")) {
                        c2 = 5;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                TextInputChannel.this.textInputMethodHandler.show();
                result.success(null);
            } else if (c2 == 1) {
                TextInputChannel.this.textInputMethodHandler.hide();
                result.success(null);
            } else if (c2 == 2) {
                try {
                    JSONArray jSONArray = (JSONArray) obj;
                    TextInputChannel.this.textInputMethodHandler.setClient(jSONArray.getInt(0), Configuration.fromJson(jSONArray.getJSONObject(1)));
                    result.success(null);
                } catch (NoSuchFieldException | JSONException e2) {
                    result.error("error", e2.getMessage(), null);
                }
            } else if (c2 == 3) {
                TextInputChannel.this.textInputMethodHandler.setPlatformViewClient(((Integer) obj).intValue());
            } else if (c2 != 4) {
                if (c2 == 5) {
                    TextInputChannel.this.textInputMethodHandler.clearClient();
                    result.success(null);
                    return;
                }
                result.notImplemented();
            } else {
                try {
                    TextInputChannel.this.textInputMethodHandler.setEditingState(TextEditState.fromJson((JSONObject) obj));
                    result.success(null);
                } catch (JSONException e3) {
                    result.error("error", e3.getMessage(), null);
                }
            }
        }
    };
    @Nullable
    public TextInputMethodHandler textInputMethodHandler;

    /* loaded from: classes7.dex */
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

        public Configuration(boolean z, boolean z2, boolean z3, @NonNull TextCapitalization textCapitalization, @NonNull InputType inputType, @Nullable Integer num, @Nullable String str) {
            this.obscureText = z;
            this.autocorrect = z2;
            this.enableSuggestions = z3;
            this.textCapitalization = textCapitalization;
            this.inputType = inputType;
            this.inputAction = num;
            this.actionLabel = str;
        }

        public static Configuration fromJson(@NonNull JSONObject jSONObject) throws JSONException, NoSuchFieldException {
            String string = jSONObject.getString("inputAction");
            if (string != null) {
                return new Configuration(jSONObject.optBoolean("obscureText"), jSONObject.optBoolean("autocorrect", true), jSONObject.optBoolean("enableSuggestions"), TextCapitalization.fromValue(jSONObject.getString("textCapitalization")), InputType.fromJson(jSONObject.getJSONObject("inputType")), inputActionFromTextInputAction(string), jSONObject.isNull("actionLabel") ? null : jSONObject.getString("actionLabel"));
            }
            throw new JSONException("Configuration JSON missing 'inputAction' property.");
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0029, code lost:
            if (r11.equals("TextInputAction.newline") != false) goto L6;
         */
        @NonNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static Integer inputActionFromTextInputAction(@NonNull String str) {
            char c2 = 0;
            switch (str.hashCode()) {
                case -810971940:
                    if (str.equals("TextInputAction.unspecified")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -737377923:
                    if (str.equals("TextInputAction.done")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -737089298:
                    if (str.equals("TextInputAction.next")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -737080013:
                    if (str.equals("TextInputAction.none")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -736940669:
                    if (str.equals("TextInputAction.send")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 469250275:
                    if (str.equals("TextInputAction.search")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1241689507:
                    if (str.equals("TextInputAction.go")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1539450297:
                    break;
                case 2110497650:
                    if (str.equals("TextInputAction.previous")) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
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
    }

    /* loaded from: classes7.dex */
    public static class InputType {
        public final boolean isDecimal;
        public final boolean isSigned;
        @NonNull
        public final TextInputType type;

        public InputType(@NonNull TextInputType textInputType, boolean z, boolean z2) {
            this.type = textInputType;
            this.isSigned = z;
            this.isDecimal = z2;
        }

        @NonNull
        public static InputType fromJson(@NonNull JSONObject jSONObject) throws JSONException, NoSuchFieldException {
            return new InputType(TextInputType.fromValue(jSONObject.getString("name")), jSONObject.optBoolean("signed", false), jSONObject.optBoolean("decimal", false));
        }
    }

    /* loaded from: classes7.dex */
    public enum TextCapitalization {
        CHARACTERS("TextCapitalization.characters"),
        WORDS("TextCapitalization.words"),
        SENTENCES("TextCapitalization.sentences"),
        NONE("TextCapitalization.none");
        
        @NonNull
        public final String encodedName;

        TextCapitalization(@NonNull String str) {
            this.encodedName = str;
        }

        public static TextCapitalization fromValue(@NonNull String str) throws NoSuchFieldException {
            TextCapitalization[] values;
            for (TextCapitalization textCapitalization : values()) {
                if (textCapitalization.encodedName.equals(str)) {
                    return textCapitalization;
                }
            }
            throw new NoSuchFieldException("No such TextCapitalization: " + str);
        }
    }

    /* loaded from: classes7.dex */
    public static class TextEditState {
        public final int selectionEnd;
        public final int selectionStart;
        @NonNull
        public final String text;

        public TextEditState(@NonNull String str, int i2, int i3) {
            this.text = str;
            this.selectionStart = i2;
            this.selectionEnd = i3;
        }

        public static TextEditState fromJson(@NonNull JSONObject jSONObject) throws JSONException {
            return new TextEditState(jSONObject.getString("text"), jSONObject.getInt("selectionBase"), jSONObject.getInt("selectionExtent"));
        }
    }

    /* loaded from: classes7.dex */
    public interface TextInputMethodHandler {
        void clearClient();

        void hide();

        void setClient(int i2, @NonNull Configuration configuration);

        void setEditingState(@NonNull TextEditState textEditState);

        void setPlatformViewClient(int i2);

        void show();
    }

    /* loaded from: classes7.dex */
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
        public final String encodedName;

        TextInputType(@NonNull String str) {
            this.encodedName = str;
        }

        public static TextInputType fromValue(@NonNull String str) throws NoSuchFieldException {
            TextInputType[] values;
            for (TextInputType textInputType : values()) {
                if (textInputType.encodedName.equals(str)) {
                    return textInputType;
                }
            }
            throw new NoSuchFieldException("No such TextInputType: " + str);
        }
    }

    public TextInputChannel(@NonNull DartExecutor dartExecutor) {
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/textinput", JSONMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this.parsingMethodHandler);
    }

    public void done(int i2) {
        Log.v(TAG, "Sending 'done' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.done"));
    }

    public void go(int i2) {
        Log.v(TAG, "Sending 'go' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.go"));
    }

    public void newline(int i2) {
        Log.v(TAG, "Sending 'newline' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.newline"));
    }

    public void next(int i2) {
        Log.v(TAG, "Sending 'next' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.next"));
    }

    public void previous(int i2) {
        Log.v(TAG, "Sending 'previous' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.previous"));
    }

    public void requestExistingInputState() {
        this.channel.invokeMethod("TextInputClient.requestExistingInputState", null);
    }

    public void search(int i2) {
        Log.v(TAG, "Sending 'search' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.search"));
    }

    public void send(int i2) {
        Log.v(TAG, "Sending 'send' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.send"));
    }

    public void setTextInputMethodHandler(@Nullable TextInputMethodHandler textInputMethodHandler) {
        this.textInputMethodHandler = textInputMethodHandler;
    }

    public void unspecifiedAction(int i2) {
        Log.v(TAG, "Sending 'unspecified' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.unspecified"));
    }

    public void updateEditingState(int i2, String str, int i3, int i4, int i5, int i6) {
        Log.v(TAG, "Sending message to update editing state: \nText: " + str + "\nSelection start: " + i3 + "\nSelection end: " + i4 + "\nComposing start: " + i5 + "\nComposing end: " + i6);
        HashMap hashMap = new HashMap();
        hashMap.put("text", str);
        hashMap.put("selectionBase", Integer.valueOf(i3));
        hashMap.put("selectionExtent", Integer.valueOf(i4));
        hashMap.put("composingBase", Integer.valueOf(i5));
        hashMap.put("composingExtent", Integer.valueOf(i6));
        this.channel.invokeMethod("TextInputClient.updateEditingState", Arrays.asList(Integer.valueOf(i2), hashMap));
    }
}
