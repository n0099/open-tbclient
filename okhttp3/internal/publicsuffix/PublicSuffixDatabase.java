package okhttp3.internal.publicsuffix;

import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
/* loaded from: classes9.dex */
public final class PublicSuffixDatabase {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BAIDU_TLD_PLUS_ONE = "baidu.com";
    public static final String[] EMPTY_RULE;
    public static final byte EXCEPTION_MARKER = 33;
    public static final String[] PREVAILING_RULE;
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    public static final byte[] WILDCARD_LABEL;
    public static final PublicSuffixDatabase instance;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicBoolean listRead;
    public byte[] publicSuffixExceptionListBytes;
    public byte[] publicSuffixListBytes;
    public final CountDownLatch readCompleteLatch;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(627355063, "Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(627355063, "Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;");
                return;
            }
        }
        WILDCARD_LABEL = new byte[]{ExifInterface.START_CODE};
        EMPTY_RULE = new String[0];
        PREVAILING_RULE = new String[]{"*"};
        instance = new PublicSuffixDatabase();
    }

    public PublicSuffixDatabase() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.listRead = new AtomicBoolean(false);
        this.readCompleteLatch = new CountDownLatch(1);
    }

    private void readTheListUninterruptibly() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            boolean z = false;
            while (true) {
                try {
                    try {
                        try {
                            readTheList();
                            break;
                        } catch (IOException e) {
                            Platform.get().log(5, "Failed to read public suffix list", e);
                            if (z) {
                                Thread.currentThread().interrupt();
                                return;
                            }
                            return;
                        }
                    } catch (InterruptedIOException unused) {
                        Thread.interrupted();
                        z = true;
                    }
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static String binarySearchBytes(byte[] bArr, byte[][] bArr2, int i) {
        InterceptResult invokeLLI;
        int i2;
        boolean z;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, bArr, bArr2, i)) == null) {
            int length = bArr.length;
            int i5 = 0;
            while (i5 < length) {
                int i6 = (i5 + length) / 2;
                while (i6 > -1 && bArr[i6] != 10) {
                    i6--;
                }
                int i7 = i6 + 1;
                int i8 = 1;
                while (true) {
                    i2 = i7 + i8;
                    if (bArr[i2] == 10) {
                        break;
                    }
                    i8++;
                }
                int i9 = i2 - i7;
                int i10 = i;
                boolean z2 = false;
                int i11 = 0;
                int i12 = 0;
                while (true) {
                    if (z2) {
                        i3 = 46;
                        z = false;
                    } else {
                        z = z2;
                        i3 = bArr2[i10][i11] & 255;
                    }
                    i4 = i3 - (bArr[i7 + i12] & 255);
                    if (i4 == 0) {
                        i12++;
                        i11++;
                        if (i12 == i9) {
                            break;
                        } else if (bArr2[i10].length == i11) {
                            if (i10 == bArr2.length - 1) {
                                break;
                            }
                            i10++;
                            z2 = true;
                            i11 = -1;
                        } else {
                            z2 = z;
                        }
                    } else {
                        break;
                    }
                }
                if (i4 >= 0) {
                    if (i4 <= 0) {
                        int i13 = i9 - i12;
                        int length2 = bArr2[i10].length - i11;
                        while (true) {
                            i10++;
                            if (i10 >= bArr2.length) {
                                break;
                            }
                            length2 += bArr2[i10].length;
                        }
                        if (length2 >= i13) {
                            if (length2 <= i13) {
                                return new String(bArr, i7, i9, Util.UTF_8);
                            }
                        }
                    }
                    i5 = i2 + 1;
                }
                length = i7 - 1;
            }
            return null;
        }
        return (String) invokeLLI.objValue;
    }

    private String[] findMatchingRule(String[] strArr) {
        InterceptResult invokeL;
        String str;
        String str2;
        String str3;
        String[] strArr2;
        String[] strArr3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, strArr)) == null) {
            int i = 0;
            if (!this.listRead.get() && this.listRead.compareAndSet(false, true)) {
                readTheListUninterruptibly();
            } else {
                try {
                    this.readCompleteLatch.await();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
            synchronized (this) {
                if (this.publicSuffixListBytes == null) {
                    throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
                }
            }
            int length = strArr.length;
            byte[][] bArr = new byte[length];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                bArr[i2] = strArr[i2].getBytes(Util.UTF_8);
            }
            int i3 = 0;
            while (true) {
                str = null;
                if (i3 < length) {
                    str2 = binarySearchBytes(this.publicSuffixListBytes, bArr, i3);
                    if (str2 != null) {
                        break;
                    }
                    i3++;
                } else {
                    str2 = null;
                    break;
                }
            }
            if (length > 1) {
                byte[][] bArr2 = (byte[][]) bArr.clone();
                for (int i4 = 0; i4 < bArr2.length - 1; i4++) {
                    bArr2[i4] = WILDCARD_LABEL;
                    str3 = binarySearchBytes(this.publicSuffixListBytes, bArr2, i4);
                    if (str3 != null) {
                        break;
                    }
                }
            }
            str3 = null;
            if (str3 != null) {
                while (true) {
                    if (i >= length - 1) {
                        break;
                    }
                    String binarySearchBytes = binarySearchBytes(this.publicSuffixExceptionListBytes, bArr, i);
                    if (binarySearchBytes != null) {
                        str = binarySearchBytes;
                        break;
                    }
                    i++;
                }
            }
            if (str != null) {
                return ("!" + str).split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            } else if (str2 == null && str3 == null) {
                return PREVAILING_RULE;
            } else {
                if (str2 != null) {
                    strArr2 = str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                } else {
                    strArr2 = EMPTY_RULE;
                }
                if (str3 != null) {
                    strArr3 = str3.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                } else {
                    strArr3 = EMPTY_RULE;
                }
                if (strArr2.length <= strArr3.length) {
                    return strArr3;
                }
                return strArr2;
            }
        }
        return (String[]) invokeL.objValue;
    }

    public static PublicSuffixDatabase get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return instance;
        }
        return (PublicSuffixDatabase) invokeV.objValue;
    }

    private boolean isBaiduDomain(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
            if (!str.equals(BAIDU_TLD_PLUS_ONE) && !str.endsWith(".baidu.com")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private void readTheList() throws IOException {
        InputStream resourceAsStream;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65542, this) != null) || (resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(PUBLIC_SUFFIX_RESOURCE)) == null) {
            return;
        }
        BufferedSource buffer = Okio.buffer(new GzipSource(Okio.source(resourceAsStream)));
        try {
            byte[] bArr = new byte[buffer.readInt()];
            buffer.readFully(bArr);
            byte[] bArr2 = new byte[buffer.readInt()];
            buffer.readFully(bArr2);
            synchronized (this) {
                this.publicSuffixListBytes = bArr;
                this.publicSuffixExceptionListBytes = bArr2;
            }
            this.readCompleteLatch.countDown();
        } finally {
            Util.closeQuietly(buffer);
        }
    }

    public String getEffectiveTldPlusOne(String str) {
        InterceptResult invokeL;
        int length;
        int length2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str != null) {
                if (isBaiduDomain(str)) {
                    return BAIDU_TLD_PLUS_ONE;
                }
                String[] split = IDN.toUnicode(str).split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                String[] findMatchingRule = findMatchingRule(split);
                if (split.length == findMatchingRule.length && findMatchingRule[0].charAt(0) != '!') {
                    return null;
                }
                if (findMatchingRule[0].charAt(0) == '!') {
                    length = split.length;
                    length2 = findMatchingRule.length;
                } else {
                    length = split.length;
                    length2 = findMatchingRule.length + 1;
                }
                StringBuilder sb = new StringBuilder();
                String[] split2 = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                for (int i = length - length2; i < split2.length; i++) {
                    sb.append(split2[i]);
                    sb.append(IStringUtil.EXTENSION_SEPARATOR);
                }
                sb.deleteCharAt(sb.length() - 1);
                return sb.toString();
            }
            throw new NullPointerException("domain == null");
        }
        return (String) invokeL.objValue;
    }

    public void setListBytes(byte[] bArr, byte[] bArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, bArr2) == null) {
            this.publicSuffixListBytes = bArr;
            this.publicSuffixExceptionListBytes = bArr2;
            this.listRead.set(true);
            this.readCompleteLatch.countDown();
        }
    }
}
