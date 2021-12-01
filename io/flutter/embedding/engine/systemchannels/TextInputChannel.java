package io.flutter.embedding.engine.systemchannels;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.parser.JSONLexer;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.maxicode.decoder.DecodedBitStreamParser;
import com.tachikoma.core.component.anim.AnimationProperty;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.CharUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TextInputChannel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "TextInputChannel";
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final MethodChannel channel;
    public final MethodChannel.MethodCallHandler parsingMethodHandler;
    @Nullable
    public TextInputMethodHandler textInputMethodHandler;

    /* loaded from: classes3.dex */
    public static class Configuration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public final String actionLabel;
        public final boolean autocorrect;
        @Nullable
        public final Autofill autofill;
        public final boolean enableIMEPersonalizedLearning;
        public final boolean enableSuggestions;
        @Nullable
        public final Configuration[] fields;
        @Nullable
        public final Integer inputAction;
        @NonNull
        public final InputType inputType;
        public final boolean obscureText;
        @NonNull
        public final TextCapitalization textCapitalization;

        /* loaded from: classes3.dex */
        public static class Autofill {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final TextEditState editState;
            public final String[] hints;
            public final String uniqueIdentifier;

            public Autofill(@NonNull String str, @NonNull String[] strArr, @NonNull TextEditState textEditState) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, strArr, textEditState};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.uniqueIdentifier = str;
                this.hints = strArr;
                this.editState = textEditState;
            }

            public static Autofill fromJson(@NonNull JSONObject jSONObject) throws JSONException, NoSuchFieldException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                    String string = jSONObject.getString("uniqueIdentifier");
                    JSONArray jSONArray = jSONObject.getJSONArray("hints");
                    JSONObject jSONObject2 = jSONObject.getJSONObject("editingValue");
                    int length = jSONArray.length();
                    String[] strArr = new String[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        strArr[i2] = translateAutofillHint(jSONArray.getString(i2));
                    }
                    return new Autofill(string, strArr, TextEditState.fromJson(jSONObject2));
                }
                return (Autofill) invokeL.objValue;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code restructure failed: missing block: B:26:0x006b, code lost:
                if (r16.equals(com.tachikoma.core.component.input.InputType.PASSWORD) != false) goto L12;
             */
            @NonNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public static String translateAutofillHint(@NonNull String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                    int i2 = Build.VERSION.SDK_INT;
                    char c2 = JSONLexer.EOI;
                    if (i2 < 26) {
                        return str;
                    }
                    switch (str.hashCode()) {
                        case -2058889126:
                            if (str.equals("birthdayYear")) {
                                c2 = 5;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1917283616:
                            if (str.equals("oneTimeCode")) {
                                c2 = 25;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1844815832:
                            if (str.equals("creditCardExpirationMonth")) {
                                c2 = '\t';
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1825589953:
                            if (str.equals("telephoneNumberNational")) {
                                c2 = '\"';
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1821235109:
                            if (str.equals("newPassword")) {
                                c2 = 23;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1757573738:
                            if (str.equals("creditCardSecurityCode")) {
                                c2 = '\f';
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1682373820:
                            if (str.equals("creditCardExpirationDay")) {
                                c2 = '\b';
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1658955742:
                            if (str.equals("fullStreetAddress")) {
                                c2 = 15;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1567118045:
                            if (str.equals("telephoneNumberDevice")) {
                                c2 = '!';
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1476752575:
                            if (str.equals("countryName")) {
                                c2 = 6;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1413737489:
                            if (str.equals("middleInitial")) {
                                c2 = 18;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1377792129:
                            if (str.equals("addressCity")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1249512767:
                            if (str.equals("gender")) {
                                c2 = 16;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1186060294:
                            if (str.equals("postalAddressExtendedPostalCode")) {
                                c2 = DecodedBitStreamParser.GS;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1151034798:
                            if (str.equals("creditCardNumber")) {
                                c2 = 11;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -835992323:
                            if (str.equals("namePrefix")) {
                                c2 = 21;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -818219584:
                            if (str.equals("middleName")) {
                                c2 = 19;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -747304516:
                            if (str.equals("nameSuffix")) {
                                c2 = 22;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -613980922:
                            if (str.equals("creditCardExpirationDate")) {
                                c2 = 7;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -613352043:
                            if (str.equals("creditCardExpirationYear")) {
                                c2 = '\n';
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -549230602:
                            if (str.equals("telephoneNumberCountryCode")) {
                                c2 = ' ';
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -265713450:
                            if (str.equals("username")) {
                                c2 = '#';
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3373707:
                            if (str.equals("name")) {
                                c2 = 20;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 96619420:
                            if (str.equals("email")) {
                                c2 = CharUtils.CR;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 253202685:
                            if (str.equals("addressState")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 588174851:
                            if (str.equals("birthdayMonth")) {
                                c2 = 4;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 798554127:
                            if (str.equals("familyName")) {
                                c2 = 14;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 892233837:
                            if (str.equals("telephoneNumber")) {
                                c2 = 31;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 991032982:
                            if (str.equals("newUsername")) {
                                c2 = 24;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1069376125:
                            if (str.equals("birthday")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1216985755:
                            break;
                        case 1469046696:
                            if (str.equals("givenName")) {
                                c2 = 17;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1662667945:
                            if (str.equals("postalAddress")) {
                                c2 = 27;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1921869058:
                            if (str.equals("postalAddressExtended")) {
                                c2 = DecodedBitStreamParser.FS;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 2011152728:
                            if (str.equals("postalCode")) {
                                c2 = DecodedBitStreamParser.RS;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 2011773919:
                            if (str.equals("birthdayDay")) {
                                c2 = 3;
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
                            return "addressLocality";
                        case 1:
                            return "addressRegion";
                        case 2:
                            return "birthDateFull";
                        case 3:
                            return "birthDateDay";
                        case 4:
                            return "birthDateMonth";
                        case 5:
                            return "birthDateYear";
                        case 6:
                            return "addressCountry";
                        case 7:
                            return "creditCardExpirationDate";
                        case '\b':
                            return "creditCardExpirationDay";
                        case '\t':
                            return "creditCardExpirationMonth";
                        case '\n':
                            return "creditCardExpirationYear";
                        case 11:
                            return "creditCardNumber";
                        case '\f':
                            return "creditCardSecurityCode";
                        case '\r':
                            return "emailAddress";
                        case 14:
                            return "personFamilyName";
                        case 15:
                            return "streetAddress";
                        case 16:
                            return "gender";
                        case 17:
                            return "personGivenName";
                        case 18:
                            return "personMiddleInitial";
                        case 19:
                            return "personMiddleName";
                        case 20:
                            return "personName";
                        case 21:
                            return "personNamePrefix";
                        case 22:
                            return "personNameSuffix";
                        case 23:
                            return "newPassword";
                        case 24:
                            return "newUsername";
                        case 25:
                            return "smsOTPCode";
                        case 26:
                            return com.tachikoma.core.component.input.InputType.PASSWORD;
                        case 27:
                            return "postalAddress";
                        case 28:
                            return "extendedAddress";
                        case 29:
                            return "extendedPostalCode";
                        case 30:
                            return "postalCode";
                        case 31:
                            return "phoneNumber";
                        case ' ':
                            return "phoneCountryCode";
                        case '!':
                            return "phoneNumberDevice";
                        case '\"':
                            return "phoneNational";
                        case '#':
                            return "username";
                        default:
                            return str;
                    }
                }
                return (String) invokeL.objValue;
            }
        }

        public Configuration(boolean z, boolean z2, boolean z3, boolean z4, @NonNull TextCapitalization textCapitalization, @NonNull InputType inputType, @Nullable Integer num, @Nullable String str, @Nullable Autofill autofill, @Nullable Configuration[] configurationArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), textCapitalization, inputType, num, str, autofill, configurationArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.obscureText = z;
            this.autocorrect = z2;
            this.enableSuggestions = z3;
            this.enableIMEPersonalizedLearning = z4;
            this.textCapitalization = textCapitalization;
            this.inputType = inputType;
            this.inputAction = num;
            this.actionLabel = str;
            this.autofill = autofill;
            this.fields = configurationArr;
        }

        public static Configuration fromJson(@NonNull JSONObject jSONObject) throws JSONException, NoSuchFieldException {
            InterceptResult invokeL;
            Configuration[] configurationArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                String string = jSONObject.getString("inputAction");
                if (string != null) {
                    if (jSONObject.isNull("fields")) {
                        configurationArr = null;
                    } else {
                        JSONArray jSONArray = jSONObject.getJSONArray("fields");
                        int length = jSONArray.length();
                        Configuration[] configurationArr2 = new Configuration[length];
                        for (int i2 = 0; i2 < length; i2++) {
                            configurationArr2[i2] = fromJson(jSONArray.getJSONObject(i2));
                        }
                        configurationArr = configurationArr2;
                    }
                    return new Configuration(jSONObject.optBoolean("obscureText"), jSONObject.optBoolean("autocorrect", true), jSONObject.optBoolean("enableSuggestions"), jSONObject.optBoolean("enableIMEPersonalizedLearning"), TextCapitalization.fromValue(jSONObject.getString("textCapitalization")), InputType.fromJson(jSONObject.getJSONObject("inputType")), inputActionFromTextInputAction(string), jSONObject.isNull("actionLabel") ? null : jSONObject.getString("actionLabel"), jSONObject.isNull("autofill") ? null : Autofill.fromJson(jSONObject.getJSONObject("autofill")), configurationArr);
                }
                throw new JSONException("Configuration JSON missing 'inputAction' property.");
            }
            return (Configuration) invokeL.objValue;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
            if (r11.equals("TextInputAction.newline") != false) goto L8;
         */
        @NonNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static Integer inputActionFromTextInputAction(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
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
            return (Integer) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class InputType {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean isDecimal;
        public final boolean isSigned;
        @NonNull
        public final TextInputType type;

        public InputType(@NonNull TextInputType textInputType, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textInputType, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.type = textInputType;
            this.isSigned = z;
            this.isDecimal = z2;
        }

        @NonNull
        public static InputType fromJson(@NonNull JSONObject jSONObject) throws JSONException, NoSuchFieldException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) ? new InputType(TextInputType.fromValue(jSONObject.getString("name")), jSONObject.optBoolean("signed", false), jSONObject.optBoolean("decimal", false)) : (InputType) invokeL.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class TextCapitalization {
        public static final /* synthetic */ TextCapitalization[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final TextCapitalization CHARACTERS;
        public static final TextCapitalization NONE;
        public static final TextCapitalization SENTENCES;
        public static final TextCapitalization WORDS;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final String encodedName;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1667979041, "Lio/flutter/embedding/engine/systemchannels/TextInputChannel$TextCapitalization;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1667979041, "Lio/flutter/embedding/engine/systemchannels/TextInputChannel$TextCapitalization;");
                    return;
                }
            }
            CHARACTERS = new TextCapitalization("CHARACTERS", 0, "TextCapitalization.characters");
            WORDS = new TextCapitalization("WORDS", 1, "TextCapitalization.words");
            SENTENCES = new TextCapitalization("SENTENCES", 2, "TextCapitalization.sentences");
            TextCapitalization textCapitalization = new TextCapitalization(PolyActivity.NONE_PANEL_TYPE, 3, "TextCapitalization.none");
            NONE = textCapitalization;
            $VALUES = new TextCapitalization[]{CHARACTERS, WORDS, SENTENCES, textCapitalization};
        }

        public TextCapitalization(@NonNull String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.encodedName = str2;
        }

        public static TextCapitalization fromValue(@NonNull String str) throws NoSuchFieldException {
            InterceptResult invokeL;
            TextCapitalization[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                for (TextCapitalization textCapitalization : values()) {
                    if (textCapitalization.encodedName.equals(str)) {
                        return textCapitalization;
                    }
                }
                throw new NoSuchFieldException("No such TextCapitalization: " + str);
            }
            return (TextCapitalization) invokeL.objValue;
        }

        public static TextCapitalization valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (TextCapitalization) Enum.valueOf(TextCapitalization.class, str) : (TextCapitalization) invokeL.objValue;
        }

        public static TextCapitalization[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (TextCapitalization[]) $VALUES.clone() : (TextCapitalization[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class TextEditState {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int composingEnd;
        public final int composingStart;
        public final int selectionEnd;
        public final int selectionStart;
        @NonNull
        public final String text;

        public TextEditState(@NonNull String str, int i2, int i3, int i4, int i5) throws IndexOutOfBoundsException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (!(i2 == -1 && i3 == -1) && (i2 < 0 || i3 < 0)) {
                throw new IndexOutOfBoundsException("invalid selection: (" + String.valueOf(i2) + StringUtil.ARRAY_ELEMENT_SEPARATOR + String.valueOf(i3) + SmallTailInfo.EMOTION_SUFFIX);
            } else if ((i4 == -1 && i5 == -1) || (i4 >= 0 && i4 <= i5)) {
                if (i5 <= str.length()) {
                    if (i2 <= str.length()) {
                        if (i3 <= str.length()) {
                            this.text = str;
                            this.selectionStart = i2;
                            this.selectionEnd = i3;
                            this.composingStart = i4;
                            this.composingEnd = i5;
                            return;
                        }
                        throw new IndexOutOfBoundsException("invalid selection end: " + String.valueOf(i3));
                    }
                    throw new IndexOutOfBoundsException("invalid selection start: " + String.valueOf(i2));
                }
                throw new IndexOutOfBoundsException("invalid composing start: " + String.valueOf(i4));
            } else {
                throw new IndexOutOfBoundsException("invalid composing range: (" + String.valueOf(i4) + StringUtil.ARRAY_ELEMENT_SEPARATOR + String.valueOf(i5) + SmallTailInfo.EMOTION_SUFFIX);
            }
        }

        public static TextEditState fromJson(@NonNull JSONObject jSONObject) throws JSONException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) ? new TextEditState(jSONObject.getString("text"), jSONObject.getInt("selectionBase"), jSONObject.getInt("selectionExtent"), jSONObject.getInt("composingBase"), jSONObject.getInt("composingExtent")) : (TextEditState) invokeL.objValue;
        }

        public boolean hasComposing() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.composingStart;
                return i2 >= 0 && this.composingEnd > i2;
            }
            return invokeV.booleanValue;
        }

        public boolean hasSelection() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.selectionStart >= 0 : invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface TextInputMethodHandler {
        void clearClient();

        void finishAutofillContext(boolean z);

        void hide();

        void requestAutofill();

        void sendAppPrivateCommand(String str, Bundle bundle);

        void setClient(int i2, @NonNull Configuration configuration);

        void setEditableSizeAndTransform(double d2, double d3, double[] dArr);

        void setEditingState(@NonNull TextEditState textEditState);

        void setPlatformViewClient(int i2, boolean z);

        void show();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class TextInputType {
        public static final /* synthetic */ TextInputType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final TextInputType DATETIME;
        public static final TextInputType EMAIL_ADDRESS;
        public static final TextInputType MULTILINE;
        public static final TextInputType NAME;
        public static final TextInputType NONE;
        public static final TextInputType NUMBER;
        public static final TextInputType PHONE;
        public static final TextInputType POSTAL_ADDRESS;
        public static final TextInputType TEXT;
        public static final TextInputType URL;
        public static final TextInputType VISIBLE_PASSWORD;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final String encodedName;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1387160439, "Lio/flutter/embedding/engine/systemchannels/TextInputChannel$TextInputType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1387160439, "Lio/flutter/embedding/engine/systemchannels/TextInputChannel$TextInputType;");
                    return;
                }
            }
            TEXT = new TextInputType("TEXT", 0, "TextInputType.text");
            DATETIME = new TextInputType("DATETIME", 1, "TextInputType.datetime");
            NAME = new TextInputType("NAME", 2, "TextInputType.name");
            POSTAL_ADDRESS = new TextInputType("POSTAL_ADDRESS", 3, "TextInputType.address");
            NUMBER = new TextInputType("NUMBER", 4, "TextInputType.number");
            PHONE = new TextInputType("PHONE", 5, "TextInputType.phone");
            MULTILINE = new TextInputType("MULTILINE", 6, "TextInputType.multiline");
            EMAIL_ADDRESS = new TextInputType("EMAIL_ADDRESS", 7, "TextInputType.emailAddress");
            URL = new TextInputType("URL", 8, "TextInputType.url");
            VISIBLE_PASSWORD = new TextInputType("VISIBLE_PASSWORD", 9, "TextInputType.visiblePassword");
            TextInputType textInputType = new TextInputType(PolyActivity.NONE_PANEL_TYPE, 10, "TextInputType.none");
            NONE = textInputType;
            $VALUES = new TextInputType[]{TEXT, DATETIME, NAME, POSTAL_ADDRESS, NUMBER, PHONE, MULTILINE, EMAIL_ADDRESS, URL, VISIBLE_PASSWORD, textInputType};
        }

        public TextInputType(@NonNull String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.encodedName = str2;
        }

        public static TextInputType fromValue(@NonNull String str) throws NoSuchFieldException {
            InterceptResult invokeL;
            TextInputType[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                for (TextInputType textInputType : values()) {
                    if (textInputType.encodedName.equals(str)) {
                        return textInputType;
                    }
                }
                throw new NoSuchFieldException("No such TextInputType: " + str);
            }
            return (TextInputType) invokeL.objValue;
        }

        public static TextInputType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (TextInputType) Enum.valueOf(TextInputType.class, str) : (TextInputType) invokeL.objValue;
        }

        public static TextInputType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (TextInputType[]) $VALUES.clone() : (TextInputType[]) invokeV.objValue;
        }
    }

    public TextInputChannel(@NonNull DartExecutor dartExecutor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dartExecutor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.parsingMethodHandler = new MethodChannel.MethodCallHandler(this) { // from class: io.flutter.embedding.engine.systemchannels.TextInputChannel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TextInputChannel this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                Bundle bundle;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLL(1048576, this, methodCall, result) == null) || this.this$0.textInputMethodHandler == null) {
                    return;
                }
                String str = methodCall.method;
                Object obj = methodCall.arguments;
                Log.v(TextInputChannel.TAG, "Received '" + str + "' message.");
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -1779068172:
                        if (str.equals("TextInput.setPlatformViewClient")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case -1015421462:
                        if (str.equals("TextInput.setEditingState")) {
                            c2 = 5;
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
                    case 649192816:
                        if (str.equals("TextInput.sendAppPrivateCommand")) {
                            c2 = '\b';
                            break;
                        }
                        break;
                    case 1204752139:
                        if (str.equals("TextInput.setEditableSizeAndTransform")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case 1727570905:
                        if (str.equals("TextInput.finishAutofillContext")) {
                            c2 = '\t';
                            break;
                        }
                        break;
                    case 1904427655:
                        if (str.equals("TextInput.clearClient")) {
                            c2 = 7;
                            break;
                        }
                        break;
                    case 2113369584:
                        if (str.equals("TextInput.requestAutofill")) {
                            c2 = 3;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        this.this$0.textInputMethodHandler.show();
                        result.success(null);
                        return;
                    case 1:
                        this.this$0.textInputMethodHandler.hide();
                        result.success(null);
                        return;
                    case 2:
                        try {
                            JSONArray jSONArray = (JSONArray) obj;
                            this.this$0.textInputMethodHandler.setClient(jSONArray.getInt(0), Configuration.fromJson(jSONArray.getJSONObject(1)));
                            result.success(null);
                            return;
                        } catch (NoSuchFieldException | JSONException e2) {
                            result.error("error", e2.getMessage(), null);
                            return;
                        }
                    case 3:
                        this.this$0.textInputMethodHandler.requestAutofill();
                        result.success(null);
                        return;
                    case 4:
                        try {
                            JSONObject jSONObject = (JSONObject) obj;
                            this.this$0.textInputMethodHandler.setPlatformViewClient(jSONObject.getInt("platformViewId"), jSONObject.optBoolean("usesVirtualDisplay", false));
                            result.success(null);
                            return;
                        } catch (JSONException e3) {
                            result.error("error", e3.getMessage(), null);
                            return;
                        }
                    case 5:
                        try {
                            this.this$0.textInputMethodHandler.setEditingState(TextEditState.fromJson((JSONObject) obj));
                            result.success(null);
                            return;
                        } catch (JSONException e4) {
                            result.error("error", e4.getMessage(), null);
                            return;
                        }
                    case 6:
                        try {
                            JSONObject jSONObject2 = (JSONObject) obj;
                            double d2 = jSONObject2.getDouble("width");
                            double d3 = jSONObject2.getDouble("height");
                            JSONArray jSONArray2 = jSONObject2.getJSONArray(AnimationProperty.TRANSFORM);
                            double[] dArr = new double[16];
                            for (int i4 = 0; i4 < 16; i4++) {
                                dArr[i4] = jSONArray2.getDouble(i4);
                            }
                            this.this$0.textInputMethodHandler.setEditableSizeAndTransform(d2, d3, dArr);
                            return;
                        } catch (JSONException e5) {
                            result.error("error", e5.getMessage(), null);
                            return;
                        }
                    case 7:
                        this.this$0.textInputMethodHandler.clearClient();
                        result.success(null);
                        return;
                    case '\b':
                        try {
                            JSONObject jSONObject3 = (JSONObject) obj;
                            String string = jSONObject3.getString("action");
                            String string2 = jSONObject3.getString("data");
                            if (string2 == null || string2.isEmpty()) {
                                bundle = null;
                            } else {
                                bundle = new Bundle();
                                bundle.putString("data", string2);
                            }
                            this.this$0.textInputMethodHandler.sendAppPrivateCommand(string, bundle);
                            result.success(null);
                            return;
                        } catch (JSONException e6) {
                            result.error("error", e6.getMessage(), null);
                            return;
                        }
                    case '\t':
                        this.this$0.textInputMethodHandler.finishAutofillContext(((Boolean) obj).booleanValue());
                        result.success(null);
                        return;
                    default:
                        result.notImplemented();
                        return;
                }
            }
        };
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/textinput", JSONMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this.parsingMethodHandler);
    }

    public static HashMap<Object, Object> createEditingStateJSON(String str, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            HashMap<Object, Object> hashMap = new HashMap<>();
            hashMap.put("text", str);
            hashMap.put("selectionBase", Integer.valueOf(i2));
            hashMap.put("selectionExtent", Integer.valueOf(i3));
            hashMap.put("composingBase", Integer.valueOf(i4));
            hashMap.put("composingExtent", Integer.valueOf(i5));
            return hashMap;
        }
        return (HashMap) invokeCommon.objValue;
    }

    public void done(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            Log.v(TAG, "Sending 'done' message.");
            this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.done"));
        }
    }

    public void go(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            Log.v(TAG, "Sending 'go' message.");
            this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.go"));
        }
    }

    public void newline(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            Log.v(TAG, "Sending 'newline' message.");
            this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.newline"));
        }
    }

    public void next(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            Log.v(TAG, "Sending 'next' message.");
            this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.next"));
        }
    }

    public void performPrivateCommand(int i2, String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i2, str, bundle) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("action", str);
            if (bundle != null) {
                HashMap hashMap2 = new HashMap();
                for (String str2 : bundle.keySet()) {
                    Object obj = bundle.get(str2);
                    if (obj instanceof byte[]) {
                        hashMap2.put(str2, bundle.getByteArray(str2));
                    } else if (obj instanceof Byte) {
                        hashMap2.put(str2, Byte.valueOf(bundle.getByte(str2)));
                    } else if (obj instanceof char[]) {
                        hashMap2.put(str2, bundle.getCharArray(str2));
                    } else if (obj instanceof Character) {
                        hashMap2.put(str2, Character.valueOf(bundle.getChar(str2)));
                    } else if (obj instanceof CharSequence[]) {
                        hashMap2.put(str2, bundle.getCharSequenceArray(str2));
                    } else if (obj instanceof CharSequence) {
                        hashMap2.put(str2, bundle.getCharSequence(str2));
                    } else if (obj instanceof float[]) {
                        hashMap2.put(str2, bundle.getFloatArray(str2));
                    } else if (obj instanceof Float) {
                        hashMap2.put(str2, Float.valueOf(bundle.getFloat(str2)));
                    }
                }
                hashMap.put("data", hashMap2);
            }
            this.channel.invokeMethod("TextInputClient.performPrivateCommand", Arrays.asList(Integer.valueOf(i2), hashMap));
        }
    }

    public void previous(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            Log.v(TAG, "Sending 'previous' message.");
            this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.previous"));
        }
    }

    public void requestExistingInputState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.channel.invokeMethod("TextInputClient.requestExistingInputState", null);
        }
    }

    public void search(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            Log.v(TAG, "Sending 'search' message.");
            this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.search"));
        }
    }

    public void send(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            Log.v(TAG, "Sending 'send' message.");
            this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.send"));
        }
    }

    public void setTextInputMethodHandler(@Nullable TextInputMethodHandler textInputMethodHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, textInputMethodHandler) == null) {
            this.textInputMethodHandler = textInputMethodHandler;
        }
    }

    public void unspecifiedAction(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            Log.v(TAG, "Sending 'unspecified' message.");
            this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.unspecified"));
        }
    }

    public void updateEditingState(int i2, String str, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            Log.v(TAG, "Sending message to update editing state: \nText: " + str + "\nSelection start: " + i3 + "\nSelection end: " + i4 + "\nComposing start: " + i5 + "\nComposing end: " + i6);
            this.channel.invokeMethod("TextInputClient.updateEditingState", Arrays.asList(Integer.valueOf(i2), createEditingStateJSON(str, i3, i4, i5, i6)));
        }
    }

    public void updateEditingStateWithTag(int i2, HashMap<String, TextEditState> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, hashMap) == null) {
            Log.v(TAG, "Sending message to update editing state for " + String.valueOf(hashMap.size()) + " field(s).");
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, TextEditState> entry : hashMap.entrySet()) {
                TextEditState value = entry.getValue();
                hashMap2.put(entry.getKey(), createEditingStateJSON(value.text, value.selectionStart, value.selectionEnd, -1, -1));
            }
            this.channel.invokeMethod("TextInputClient.updateEditingStateWithTag", Arrays.asList(Integer.valueOf(i2), hashMap2));
        }
    }
}
