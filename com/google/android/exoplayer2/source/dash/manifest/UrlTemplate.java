package com.google.android.exoplayer2.source.dash.manifest;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes4.dex */
public final class UrlTemplate {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BANDWIDTH = "Bandwidth";
    public static final int BANDWIDTH_ID = 3;
    public static final String DEFAULT_FORMAT_TAG = "%01d";
    public static final String ESCAPED_DOLLAR = "$$";
    public static final String NUMBER = "Number";
    public static final int NUMBER_ID = 2;
    public static final String REPRESENTATION = "RepresentationID";
    public static final int REPRESENTATION_ID = 1;
    public static final String TIME = "Time";
    public static final int TIME_ID = 4;
    public transient /* synthetic */ FieldHolder $fh;
    public final int identifierCount;
    public final String[] identifierFormatTags;
    public final int[] identifiers;
    public final String[] urlPieces;

    public UrlTemplate(String[] strArr, int[] iArr, String[] strArr2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {strArr, iArr, strArr2, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.urlPieces = strArr;
        this.identifiers = iArr;
        this.identifierFormatTags = strArr2;
        this.identifierCount = i;
    }

    public static UrlTemplate compile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            String[] strArr = new String[5];
            int[] iArr = new int[4];
            String[] strArr2 = new String[4];
            return new UrlTemplate(strArr, iArr, strArr2, parseTemplate(str, strArr, iArr, strArr2));
        }
        return (UrlTemplate) invokeL.objValue;
    }

    public static int parseTemplate(String str, String[] strArr, int[] iArr, String[] strArr2) {
        InterceptResult invokeLLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, str, strArr, iArr, strArr2)) == null) {
            strArr[0] = "";
            int i = 0;
            int i2 = 0;
            while (i < str.length()) {
                int indexOf = str.indexOf("$", i);
                char c = 65535;
                if (indexOf == -1) {
                    strArr[i2] = strArr[i2] + str.substring(i);
                    i = str.length();
                } else if (indexOf != i) {
                    strArr[i2] = strArr[i2] + str.substring(i, indexOf);
                    i = indexOf;
                } else if (str.startsWith(ESCAPED_DOLLAR, i)) {
                    strArr[i2] = strArr[i2] + "$";
                    i += 2;
                } else {
                    int i3 = i + 1;
                    int indexOf2 = str.indexOf("$", i3);
                    String substring = str.substring(i3, indexOf2);
                    if (substring.equals(REPRESENTATION)) {
                        iArr[i2] = 1;
                    } else {
                        int indexOf3 = substring.indexOf("%0");
                        if (indexOf3 != -1) {
                            str2 = substring.substring(indexOf3);
                            if (!str2.endsWith("d")) {
                                str2 = str2 + "d";
                            }
                            substring = substring.substring(0, indexOf3);
                        } else {
                            str2 = DEFAULT_FORMAT_TAG;
                        }
                        int hashCode = substring.hashCode();
                        if (hashCode != -1950496919) {
                            if (hashCode != 2606829) {
                                if (hashCode == 38199441 && substring.equals(BANDWIDTH)) {
                                    c = 1;
                                }
                            } else if (substring.equals(TIME)) {
                                c = 2;
                            }
                        } else if (substring.equals(NUMBER)) {
                            c = 0;
                        }
                        if (c == 0) {
                            iArr[i2] = 2;
                        } else if (c == 1) {
                            iArr[i2] = 3;
                        } else if (c == 2) {
                            iArr[i2] = 4;
                        } else {
                            throw new IllegalArgumentException("Invalid template: " + str);
                        }
                        strArr2[i2] = str2;
                    }
                    i2++;
                    strArr[i2] = "";
                    i = indexOf2 + 1;
                }
            }
            return i2;
        }
        return invokeLLLL.intValue;
    }

    public String buildUri(String str, int i, int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)})) != null) {
            return (String) invokeCommon.objValue;
        }
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        while (true) {
            int i4 = this.identifierCount;
            if (i3 < i4) {
                sb.append(this.urlPieces[i3]);
                int[] iArr = this.identifiers;
                if (iArr[i3] == 1) {
                    sb.append(str);
                } else if (iArr[i3] == 2) {
                    sb.append(String.format(Locale.US, this.identifierFormatTags[i3], Integer.valueOf(i)));
                } else if (iArr[i3] == 3) {
                    sb.append(String.format(Locale.US, this.identifierFormatTags[i3], Integer.valueOf(i2)));
                } else if (iArr[i3] == 4) {
                    sb.append(String.format(Locale.US, this.identifierFormatTags[i3], Long.valueOf(j)));
                }
                i3++;
            } else {
                sb.append(this.urlPieces[i4]);
                return sb.toString();
            }
        }
    }
}
