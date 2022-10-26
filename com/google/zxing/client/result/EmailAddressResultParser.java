package com.google.zxing.client.result;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.zxing.Result;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public final class EmailAddressResultParser extends ResultParser {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern COMMA;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1009491218, "Lcom/google/zxing/client/result/EmailAddressResultParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1009491218, "Lcom/google/zxing/client/result/EmailAddressResultParser;");
                return;
            }
        }
        COMMA = Pattern.compile(",");
    }

    public EmailAddressResultParser() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.ResultParser
    public EmailAddressParsedResult parse(Result result) {
        InterceptResult invokeL;
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        String[] strArr4;
        String str;
        String str2;
        String[] strArr5;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, result)) == null) {
            String massagedText = ResultParser.getMassagedText(result);
            String[] strArr6 = null;
            if (!massagedText.startsWith(WebView.SCHEME_MAILTO) && !massagedText.startsWith("MAILTO:")) {
                if (!EmailDoCoMoResultParser.isBasicallyValidEmailAddress(massagedText)) {
                    return null;
                }
                return new EmailAddressParsedResult(massagedText);
            }
            String substring = massagedText.substring(7);
            int indexOf = substring.indexOf(63);
            if (indexOf >= 0) {
                substring = substring.substring(0, indexOf);
            }
            try {
                String urlDecode = ResultParser.urlDecode(substring);
                if (!urlDecode.isEmpty()) {
                    strArr = COMMA.split(urlDecode);
                } else {
                    strArr = null;
                }
                Map parseNameValuePairs = ResultParser.parseNameValuePairs(massagedText);
                if (parseNameValuePairs != null) {
                    if (strArr == null && (str3 = (String) parseNameValuePairs.get("to")) != null) {
                        strArr = COMMA.split(str3);
                    }
                    String str4 = (String) parseNameValuePairs.get("cc");
                    if (str4 != null) {
                        strArr5 = COMMA.split(str4);
                    } else {
                        strArr5 = null;
                    }
                    String str5 = (String) parseNameValuePairs.get("bcc");
                    if (str5 != null) {
                        strArr6 = COMMA.split(str5);
                    }
                    str2 = (String) parseNameValuePairs.get(TtmlNode.TAG_BODY);
                    strArr2 = strArr;
                    strArr4 = strArr6;
                    strArr3 = strArr5;
                    str = (String) parseNameValuePairs.get("subject");
                } else {
                    strArr2 = strArr;
                    strArr3 = null;
                    strArr4 = null;
                    str = null;
                    str2 = null;
                }
                return new EmailAddressParsedResult(strArr2, strArr3, strArr4, str, str2);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        return (EmailAddressParsedResult) invokeL.objValue;
    }
}
