package com.google.android.exoplayer2.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.core.view.DisplayCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.DataSource;
import com.kuaishou.weapon.p0.h;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public final class Util {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] CRC32_BYTES_MSBF;
    public static final String DEVICE;
    public static final String DEVICE_DEBUG_INFO;
    public static final Pattern ESCAPED_CHARACTER_PATTERN;
    public static final String MANUFACTURER;
    public static final String MODEL;
    public static final int SDK_INT;
    public static final String TAG = "Util";
    public static final Pattern XS_DATE_TIME_PATTERN;
    public static final Pattern XS_DURATION_PATTERN;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1682801238, "Lcom/google/android/exoplayer2/util/Util;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1682801238, "Lcom/google/android/exoplayer2/util/Util;");
                return;
            }
        }
        SDK_INT = (Build.VERSION.SDK_INT == 25 && Build.VERSION.CODENAME.charAt(0) == 'O') ? 26 : Build.VERSION.SDK_INT;
        DEVICE = Build.DEVICE;
        MANUFACTURER = Build.MANUFACTURER;
        MODEL = Build.MODEL;
        DEVICE_DEBUG_INFO = DEVICE + StringUtil.ARRAY_ELEMENT_SEPARATOR + MODEL + StringUtil.ARRAY_ELEMENT_SEPARATOR + MANUFACTURER + StringUtil.ARRAY_ELEMENT_SEPARATOR + SDK_INT;
        XS_DATE_TIME_PATTERN = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        XS_DURATION_PATTERN = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        ESCAPED_CHARACTER_PATTERN = Pattern.compile("%([A-Fa-f0-9]{2})");
        CRC32_BYTES_MSBF = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
    }

    public Util() {
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

    public static boolean areEqual(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, obj, obj2)) == null) {
            if (obj == null) {
                return obj2 == null;
            }
            return obj.equals(obj2);
        }
        return invokeLL.booleanValue;
    }

    public static int binarySearchCeil(long[] jArr, long j, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{jArr, Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int binarySearch = Arrays.binarySearch(jArr, j);
            if (binarySearch < 0) {
                i = ~binarySearch;
            } else {
                do {
                    binarySearch++;
                    if (binarySearch >= jArr.length) {
                        break;
                    }
                } while (jArr[binarySearch] == j);
                i = z ? binarySearch - 1 : binarySearch;
            }
            return z2 ? Math.min(jArr.length - 1, i) : i;
        }
        return invokeCommon.intValue;
    }

    public static int binarySearchFloor(int[] iArr, int i, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{iArr, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int binarySearch = Arrays.binarySearch(iArr, i);
            if (binarySearch < 0) {
                i2 = -(binarySearch + 2);
            } else {
                do {
                    binarySearch--;
                    if (binarySearch < 0) {
                        break;
                    }
                } while (iArr[binarySearch] == i);
                i2 = z ? binarySearch + 1 : binarySearch;
            }
            return z2 ? Math.max(0, i2) : i2;
        }
        return invokeCommon.intValue;
    }

    public static int ceilDivide(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65544, null, i, i2)) == null) ? ((i + i2) - 1) / i2 : invokeII.intValue;
    }

    public static void closeQuietly(DataSource dataSource) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, dataSource) == null) || dataSource == null) {
            return;
        }
        try {
            dataSource.close();
        } catch (IOException unused) {
        }
    }

    public static int constrainValue(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65549, null, i, i2, i3)) == null) ? Math.max(i2, Math.min(i, i3)) : invokeIII.intValue;
    }

    public static boolean contains(Object[] objArr, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, objArr, obj)) == null) {
            for (Object obj2 : objArr) {
                if (areEqual(obj2, obj)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static int crc(byte[] bArr, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65552, null, bArr, i, i2, i3)) == null) {
            while (i < i2) {
                i3 = CRC32_BYTES_MSBF[((i3 >>> 24) ^ (bArr[i] & 255)) & 255] ^ (i3 << 8);
                i++;
            }
            return i3;
        }
        return invokeLIII.intValue;
    }

    public static File createTempDirectory(Context context, String str) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, context, str)) == null) {
            File createTempFile = createTempFile(context, str);
            createTempFile.delete();
            createTempFile.mkdir();
            return createTempFile;
        }
        return (File) invokeLL.objValue;
    }

    public static File createTempFile(Context context, String str) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, context, str)) == null) ? File.createTempFile(str, null, context.getCacheDir()) : (File) invokeLL.objValue;
    }

    public static String escapeFileName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) {
            int length = str.length();
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (shouldEscapeCharacter(str.charAt(i3))) {
                    i2++;
                }
            }
            if (i2 == 0) {
                return str;
            }
            StringBuilder sb = new StringBuilder((i2 * 2) + length);
            while (i2 > 0) {
                int i4 = i + 1;
                char charAt = str.charAt(i);
                if (shouldEscapeCharacter(charAt)) {
                    sb.append('%');
                    sb.append(Integer.toHexString(charAt));
                    i2--;
                } else {
                    sb.append(charAt);
                }
                i = i4;
            }
            if (i < length) {
                sb.append((CharSequence) str, i, length);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String fromUtf8Bytes(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, bArr)) == null) ? new String(bArr, Charset.forName("UTF-8")) : (String) invokeL.objValue;
    }

    public static int getAudioContentTypeForStreamType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65557, null, i)) == null) {
            if (i != 0) {
                return (i == 1 || i == 2 || i == 4 || i == 5 || i == 8) ? 4 : 2;
            }
            return 1;
        }
        return invokeI.intValue;
    }

    public static int getAudioUsageForStreamType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65558, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        int i2 = 4;
                        if (i != 4) {
                            i2 = 5;
                            if (i != 5) {
                                return i != 8 ? 1 : 3;
                            }
                        }
                        return i2;
                    }
                    return 6;
                }
                return 13;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    public static byte[] getBytesFromHexString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, str)) == null) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i2 + 1), 16));
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static String getCommaDelimitedSimpleClassNames(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, objArr)) == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < objArr.length; i++) {
                sb.append(objArr[i].getClass().getSimpleName());
                if (i < objArr.length - 1) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static int getDefaultBufferSize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65561, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3 || i == 4) {
                            return 131072;
                        }
                        throw new IllegalStateException();
                    }
                    return C.DEFAULT_VIDEO_BUFFER_SIZE;
                }
                return C.DEFAULT_AUDIO_BUFFER_SIZE;
            }
            return 16777216;
        }
        return invokeI.intValue;
    }

    @TargetApi(16)
    public static void getDisplaySizeV16(Display display, Point point) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65562, null, display, point) == null) {
            display.getSize(point);
        }
    }

    @TargetApi(17)
    public static void getDisplaySizeV17(Display display, Point point) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65563, null, display, point) == null) {
            display.getRealSize(point);
        }
    }

    @TargetApi(23)
    public static void getDisplaySizeV23(Display display, Point point) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65564, null, display, point) == null) {
            Display.Mode mode = display.getMode();
            point.x = mode.getPhysicalWidth();
            point.y = mode.getPhysicalHeight();
        }
    }

    public static void getDisplaySizeV9(Display display, Point point) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65565, null, display, point) == null) {
            point.x = display.getWidth();
            point.y = display.getHeight();
        }
    }

    public static int getIntegerCodeForString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) {
            int length = str.length();
            Assertions.checkArgument(length <= 4);
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                i = (i << 8) | str.charAt(i2);
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static int getPcmEncoding(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65567, null, i)) == null) {
            if (i != 8) {
                if (i != 16) {
                    if (i != 24) {
                        return i != 32 ? 0 : 1073741824;
                    }
                    return Integer.MIN_VALUE;
                }
                return 2;
            }
            return 3;
        }
        return invokeI.intValue;
    }

    public static int getPcmFrameSize(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65568, null, i, i2)) == null) {
            if (i != Integer.MIN_VALUE) {
                if (i != 1073741824) {
                    if (i != 2) {
                        if (i == 3) {
                            return i2;
                        }
                        throw new IllegalArgumentException();
                    }
                    return i2 * 2;
                }
                return i2 * 4;
            }
            return i2 * 3;
        }
        return invokeII.intValue;
    }

    public static Point getPhysicalDisplaySize(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) ? getPhysicalDisplaySize(context, ((WindowManager) context.getSystemService("window")).getDefaultDisplay()) : (Point) invokeL.objValue;
    }

    public static int getStreamTypeForAudioUsage(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65571, null, i)) == null) {
            if (i != 13) {
                switch (i) {
                    case 2:
                        return 0;
                    case 3:
                        return 8;
                    case 4:
                        return 4;
                    case 5:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                        return 5;
                    case 6:
                        return 2;
                    default:
                        return 3;
                }
            }
            return 1;
        }
        return invokeI.intValue;
    }

    public static String getStringForTime(StringBuilder sb, Formatter formatter, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65572, null, new Object[]{sb, formatter, Long.valueOf(j)})) == null) {
            if (j == C.TIME_UNSET) {
                j = 0;
            }
            long j2 = (j + 500) / 1000;
            long j3 = j2 % 60;
            long j4 = (j2 / 60) % 60;
            long j5 = j2 / 3600;
            sb.setLength(0);
            return j5 > 0 ? formatter.format("%d:%02d:%02d", Long.valueOf(j5), Long.valueOf(j4), Long.valueOf(j3)).toString() : formatter.format("%02d:%02d", Long.valueOf(j4), Long.valueOf(j3)).toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static String getUserAgent(Context context, String str) {
        String str2;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65573, null, context, str)) == null) {
            try {
                str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException unused) {
                str2 = "?";
            }
            return str + "/" + str2 + " (Linux;Android " + Build.VERSION.RELEASE + ") " + ExoPlayerLibraryInfo.VERSION_SLASHY;
        }
        return (String) invokeLL.objValue;
    }

    public static byte[] getUtf8Bytes(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65574, null, str)) == null) ? str.getBytes(Charset.forName("UTF-8")) : (byte[]) invokeL.objValue;
    }

    public static int inferContentType(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, uri)) == null) {
            String path = uri.getPath();
            if (path == null) {
                return 3;
            }
            return inferContentType(path);
        }
        return invokeL.intValue;
    }

    public static boolean isLinebreak(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65577, null, i)) == null) ? i == 10 || i == 13 : invokeI.booleanValue;
    }

    public static boolean isLocalFileUri(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, uri)) == null) {
            String scheme = uri.getScheme();
            return TextUtils.isEmpty(scheme) || scheme.equals("file");
        }
        return invokeL.booleanValue;
    }

    @TargetApi(23)
    public static boolean maybeRequestReadExternalStoragePermission(Activity activity, Uri... uriArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65579, null, activity, uriArr)) == null) {
            if (SDK_INT < 23) {
                return false;
            }
            int length = uriArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (!isLocalFileUri(uriArr[i])) {
                    i++;
                } else if (activity.checkSelfPermission(h.i) != 0) {
                    activity.requestPermissions(new String[]{h.i}, 0);
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static ExecutorService newSingleThreadExecutor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65580, null, str)) == null) ? Executors.newSingleThreadExecutor(new ThreadFactory(str) { // from class: com.google.android.exoplayer2.util.Util.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String val$threadName;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$threadName = str;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(@NonNull Runnable runnable) {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, runnable)) == null) ? new Thread(runnable, this.val$threadName) : (Thread) invokeL2.objValue;
            }
        }) : (ExecutorService) invokeL.objValue;
    }

    public static String normalizeLanguageCode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, str)) == null) {
            if (str == null) {
                return null;
            }
            return new Locale(str).getLanguage();
        }
        return (String) invokeL.objValue;
    }

    public static long parseXsDateTime(String str) throws ParserException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, str)) == null) {
            Matcher matcher = XS_DATE_TIME_PATTERN.matcher(str);
            if (matcher.matches()) {
                int i = 0;
                if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
                    i = (Integer.parseInt(matcher.group(12)) * 60) + Integer.parseInt(matcher.group(13));
                    if (matcher.group(11).equals("-")) {
                        i *= -1;
                    }
                }
                GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
                gregorianCalendar.clear();
                gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
                if (!TextUtils.isEmpty(matcher.group(8))) {
                    gregorianCalendar.set(14, new BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
                }
                long timeInMillis = gregorianCalendar.getTimeInMillis();
                return i != 0 ? timeInMillis - (i * 60000) : timeInMillis;
            }
            throw new ParserException("Invalid date/time format: " + str);
        }
        return invokeL.longValue;
    }

    public static long parseXsDuration(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65583, null, str)) == null) {
            Matcher matcher = XS_DURATION_PATTERN.matcher(str);
            if (matcher.matches()) {
                boolean isEmpty = true ^ TextUtils.isEmpty(matcher.group(1));
                String group = matcher.group(3);
                double parseDouble = group != null ? Double.parseDouble(group) * 3.1556908E7d : 0.0d;
                String group2 = matcher.group(5);
                double parseDouble2 = parseDouble + (group2 != null ? Double.parseDouble(group2) * 2629739.0d : 0.0d);
                String group3 = matcher.group(7);
                double parseDouble3 = parseDouble2 + (group3 != null ? Double.parseDouble(group3) * 86400.0d : 0.0d);
                String group4 = matcher.group(10);
                double parseDouble4 = parseDouble3 + (group4 != null ? Double.parseDouble(group4) * 3600.0d : 0.0d);
                String group5 = matcher.group(12);
                double parseDouble5 = parseDouble4 + (group5 != null ? Double.parseDouble(group5) * 60.0d : 0.0d);
                String group6 = matcher.group(14);
                long parseDouble6 = (long) ((parseDouble5 + (group6 != null ? Double.parseDouble(group6) : 0.0d)) * 1000.0d);
                return isEmpty ? -parseDouble6 : parseDouble6;
            }
            return (long) (Double.parseDouble(str) * 3600.0d * 1000.0d);
        }
        return invokeL.longValue;
    }

    public static void recursiveDelete(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65584, null, file) == null) {
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    recursiveDelete(file2);
                }
            }
            file.delete();
        }
    }

    public static long scaleLargeTimestamp(long j, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65585, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            int i = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
            if (i < 0 || j3 % j2 != 0) {
                return (i >= 0 || j2 % j3 != 0) ? (long) (j * (j2 / j3)) : j * (j2 / j3);
            }
            return j / (j3 / j2);
        }
        return invokeCommon.longValue;
    }

    public static long[] scaleLargeTimestamps(List<Long> list, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65586, null, new Object[]{list, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            int size = list.size();
            long[] jArr = new long[size];
            int i = 0;
            int i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
            if (i2 >= 0 && j2 % j == 0) {
                long j3 = j2 / j;
                while (i < size) {
                    jArr[i] = list.get(i).longValue() / j3;
                    i++;
                }
            } else if (i2 >= 0 || j % j2 != 0) {
                double d = j / j2;
                while (i < size) {
                    jArr[i] = (long) (list.get(i).longValue() * d);
                    i++;
                }
            } else {
                long j4 = j / j2;
                while (i < size) {
                    jArr[i] = list.get(i).longValue() * j4;
                    i++;
                }
            }
            return jArr;
        }
        return (long[]) invokeCommon.objValue;
    }

    public static void scaleLargeTimestampsInPlace(long[] jArr, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65587, null, new Object[]{jArr, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            int i = 0;
            int i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
            if (i2 >= 0 && j2 % j == 0) {
                long j3 = j2 / j;
                while (i < jArr.length) {
                    jArr[i] = jArr[i] / j3;
                    i++;
                }
            } else if (i2 < 0 && j % j2 == 0) {
                long j4 = j / j2;
                while (i < jArr.length) {
                    jArr[i] = jArr[i] * j4;
                    i++;
                }
            } else {
                double d = j / j2;
                while (i < jArr.length) {
                    jArr[i] = (long) (jArr[i] * d);
                    i++;
                }
            }
        }
    }

    public static boolean shouldEscapeCharacter(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65588, null, new Object[]{Character.valueOf(c)})) == null) ? c == '\"' || c == '%' || c == '*' || c == '/' || c == ':' || c == '<' || c == '\\' || c == '|' || c == '>' || c == '?' : invokeCommon.booleanValue;
    }

    public static void sneakyThrow(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65589, null, th) == null) {
            sneakyThrowInternal(th);
        }
    }

    public static <T extends Throwable> void sneakyThrowInternal(Throwable th) throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65590, null, th) == null) {
            throw th;
        }
    }

    public static int[] toArray(List<Integer> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65591, null, list)) == null) {
            if (list == null) {
                return null;
            }
            int size = list.size();
            int[] iArr = new int[size];
            for (int i = 0; i < size; i++) {
                iArr[i] = list.get(i).intValue();
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65592, null, inputStream)) != null) {
            return (byte[]) invokeL.objValue;
        }
        byte[] bArr = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static String toLowerInvariant(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65593, null, str)) == null) {
            if (str == null) {
                return null;
            }
            return str.toLowerCase(Locale.US);
        }
        return (String) invokeL.objValue;
    }

    public static String unescapeFileName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65594, null, str)) == null) {
            int length = str.length();
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (str.charAt(i3) == '%') {
                    i2++;
                }
            }
            if (i2 == 0) {
                return str;
            }
            int i4 = length - (i2 * 2);
            StringBuilder sb = new StringBuilder(i4);
            Matcher matcher = ESCAPED_CHARACTER_PATTERN.matcher(str);
            while (i2 > 0 && matcher.find()) {
                sb.append((CharSequence) str, i, matcher.start());
                sb.append((char) Integer.parseInt(matcher.group(1), 16));
                i = matcher.end();
                i2--;
            }
            if (i < length) {
                sb.append((CharSequence) str, i, length);
            }
            if (sb.length() != i4) {
                return null;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static long ceilDivide(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? ((j + j2) - 1) / j2 : invokeCommon.longValue;
    }

    public static void closeQuietly(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static long constrainValue(long j, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) ? Math.max(j2, Math.min(j, j3)) : invokeCommon.longValue;
    }

    public static float constrainValue(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) ? Math.max(f2, Math.min(f, f3)) : invokeCommon.floatValue;
    }

    public static Point getPhysicalDisplaySize(Context context, Display display) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65570, null, context, display)) == null) {
            if (SDK_INT < 25 && display.getDisplayId() == 0) {
                if ("Sony".equals(MANUFACTURER) && MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                    return new Point(3840, DisplayCompat.DISPLAY_SIZE_4K_HEIGHT);
                }
                if ("NVIDIA".equals(MANUFACTURER) && MODEL.contains("SHIELD")) {
                    String str = null;
                    try {
                        Class<?> cls = Class.forName("android.os.SystemProperties");
                        str = (String) cls.getMethod("get", String.class).invoke(cls, "sys.display-size");
                    } catch (Exception e) {
                        Log.e("Util", "Failed to read sys.display-size", e);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            String[] split = str.trim().split("x");
                            if (split.length == 2) {
                                int parseInt = Integer.parseInt(split[0]);
                                int parseInt2 = Integer.parseInt(split[1]);
                                if (parseInt > 0 && parseInt2 > 0) {
                                    return new Point(parseInt, parseInt2);
                                }
                            }
                        } catch (NumberFormatException unused) {
                        }
                        Log.e("Util", "Invalid sys.display-size: " + str);
                    }
                }
            }
            Point point = new Point();
            int i = SDK_INT;
            if (i >= 23) {
                getDisplaySizeV23(display, point);
            } else if (i >= 17) {
                getDisplaySizeV17(display, point);
            } else if (i >= 16) {
                getDisplaySizeV16(display, point);
            } else {
                getDisplaySizeV9(display, point);
            }
            return point;
        }
        return (Point) invokeLL.objValue;
    }

    public static int inferContentType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, str)) == null) {
            String lowerInvariant = toLowerInvariant(str);
            if (lowerInvariant.endsWith(".mpd")) {
                return 0;
            }
            if (lowerInvariant.endsWith(".m3u8")) {
                return 2;
            }
            return lowerInvariant.matches(".*\\.ism(l)?(/manifest(\\(.+\\))?)?") ? 1 : 3;
        }
        return invokeL.intValue;
    }

    public static <T> int binarySearchCeil(List<? extends Comparable<? super T>> list, T t, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{list, t, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int binarySearch = Collections.binarySearch(list, t);
            if (binarySearch < 0) {
                i = ~binarySearch;
            } else {
                int size = list.size();
                do {
                    binarySearch++;
                    if (binarySearch >= size) {
                        break;
                    }
                } while (list.get(binarySearch).compareTo(t) == 0);
                i = z ? binarySearch - 1 : binarySearch;
            }
            return z2 ? Math.min(list.size() - 1, i) : i;
        }
        return invokeCommon.intValue;
    }

    public static int binarySearchFloor(long[] jArr, long j, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{jArr, Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int binarySearch = Arrays.binarySearch(jArr, j);
            if (binarySearch < 0) {
                i = -(binarySearch + 2);
            } else {
                do {
                    binarySearch--;
                    if (binarySearch < 0) {
                        break;
                    }
                } while (jArr[binarySearch] == j);
                i = z ? binarySearch + 1 : binarySearch;
            }
            return z2 ? Math.max(0, i) : i;
        }
        return invokeCommon.intValue;
    }

    public static <T> int binarySearchFloor(List<? extends Comparable<? super T>> list, T t, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{list, t, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int binarySearch = Collections.binarySearch(list, t);
            if (binarySearch < 0) {
                i = -(binarySearch + 2);
            } else {
                do {
                    binarySearch--;
                    if (binarySearch < 0) {
                        break;
                    }
                } while (list.get(binarySearch).compareTo(t) == 0);
                i = z ? binarySearch + 1 : binarySearch;
            }
            return z2 ? Math.max(0, i) : i;
        }
        return invokeCommon.intValue;
    }
}
