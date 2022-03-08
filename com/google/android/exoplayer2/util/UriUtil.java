package com.google.android.exoplayer2.util;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
/* loaded from: classes7.dex */
public final class UriUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FRAGMENT = 3;
    public static final int INDEX_COUNT = 4;
    public static final int PATH = 1;
    public static final int QUERY = 2;
    public static final int SCHEME_COLON = 0;
    public transient /* synthetic */ FieldHolder $fh;

    public UriUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int[] getUriIndices(String str) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            int[] iArr = new int[4];
            if (TextUtils.isEmpty(str)) {
                iArr[0] = -1;
                return iArr;
            }
            int length = str.length();
            int indexOf = str.indexOf(35);
            if (indexOf != -1) {
                length = indexOf;
            }
            int indexOf2 = str.indexOf(63);
            if (indexOf2 == -1 || indexOf2 > length) {
                indexOf2 = length;
            }
            int indexOf3 = str.indexOf(47);
            if (indexOf3 == -1 || indexOf3 > indexOf2) {
                indexOf3 = indexOf2;
            }
            int indexOf4 = str.indexOf(58);
            if (indexOf4 > indexOf3) {
                indexOf4 = -1;
            }
            int i3 = indexOf4 + 2;
            if (i3 < indexOf2 && str.charAt(indexOf4 + 1) == '/' && str.charAt(i3) == '/') {
                i2 = str.indexOf(47, indexOf4 + 3);
                if (i2 == -1 || i2 > indexOf2) {
                    i2 = indexOf2;
                }
            } else {
                i2 = indexOf4 + 1;
            }
            iArr[0] = indexOf4;
            iArr[1] = i2;
            iArr[2] = indexOf2;
            iArr[3] = length;
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static String removeDotSegments(StringBuilder sb, int i2, int i3) {
        InterceptResult invokeLII;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, sb, i2, i3)) == null) {
            if (i2 >= i3) {
                return sb.toString();
            }
            if (sb.charAt(i2) == '/') {
                i2++;
            }
            int i6 = i2;
            int i7 = i6;
            while (i6 <= i3) {
                if (i6 == i3) {
                    i4 = i6;
                } else if (sb.charAt(i6) == '/') {
                    i4 = i6 + 1;
                } else {
                    i6++;
                }
                int i8 = i7 + 1;
                if (i6 == i8 && sb.charAt(i7) == '.') {
                    sb.delete(i7, i4);
                    i3 -= i4 - i7;
                } else {
                    if (i6 == i7 + 2 && sb.charAt(i7) == '.' && sb.charAt(i8) == '.') {
                        i5 = sb.lastIndexOf("/", i7 - 2) + 1;
                        int i9 = i5 > i2 ? i5 : i2;
                        sb.delete(i9, i4);
                        i3 -= i4 - i9;
                    } else {
                        i5 = i6 + 1;
                    }
                    i7 = i5;
                }
                i6 = i7;
            }
            return sb.toString();
        }
        return (String) invokeLII.objValue;
    }

    public static String resolve(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            StringBuilder sb = new StringBuilder();
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            int[] uriIndices = getUriIndices(str2);
            if (uriIndices[0] != -1) {
                sb.append(str2);
                removeDotSegments(sb, uriIndices[1], uriIndices[2]);
                return sb.toString();
            }
            int[] uriIndices2 = getUriIndices(str);
            if (uriIndices[3] == 0) {
                sb.append((CharSequence) str, 0, uriIndices2[3]);
                sb.append(str2);
                return sb.toString();
            } else if (uriIndices[2] == 0) {
                sb.append((CharSequence) str, 0, uriIndices2[2]);
                sb.append(str2);
                return sb.toString();
            } else if (uriIndices[1] != 0) {
                int i2 = uriIndices2[0] + 1;
                sb.append((CharSequence) str, 0, i2);
                sb.append(str2);
                return removeDotSegments(sb, uriIndices[1] + i2, i2 + uriIndices[2]);
            } else if (str2.charAt(uriIndices[1]) == '/') {
                sb.append((CharSequence) str, 0, uriIndices2[1]);
                sb.append(str2);
                return removeDotSegments(sb, uriIndices2[1], uriIndices2[1] + uriIndices[2]);
            } else if (uriIndices2[0] + 2 < uriIndices2[1] && uriIndices2[1] == uriIndices2[2]) {
                sb.append((CharSequence) str, 0, uriIndices2[1]);
                sb.append(WebvttCueParser.CHAR_SLASH);
                sb.append(str2);
                return removeDotSegments(sb, uriIndices2[1], uriIndices2[1] + uriIndices[2] + 1);
            } else {
                int lastIndexOf = str.lastIndexOf(47, uriIndices2[2] - 1);
                int i3 = lastIndexOf == -1 ? uriIndices2[1] : lastIndexOf + 1;
                sb.append((CharSequence) str, 0, i3);
                sb.append(str2);
                return removeDotSegments(sb, uriIndices2[1], i3 + uriIndices[2]);
            }
        }
        return (String) invokeLL.objValue;
    }

    public static Uri resolveToUri(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) ? Uri.parse(resolve(str, str2)) : (Uri) invokeLL.objValue;
    }
}
