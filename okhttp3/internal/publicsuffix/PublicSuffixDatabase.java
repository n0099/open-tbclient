package okhttp3.internal.publicsuffix;

import androidx.core.view.InputDeviceCompat;
import androidx.webkit.ProxyConfig;
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
/* loaded from: classes3.dex */
public final class PublicSuffixDatabase {
    public static /* synthetic */ Interceptable $ic = null;
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
        WILDCARD_LABEL = new byte[]{42};
        EMPTY_RULE = new String[0];
        PREVAILING_RULE = new String[]{ProxyConfig.MATCH_ALL_SCHEMES};
        instance = new PublicSuffixDatabase();
    }

    public PublicSuffixDatabase() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.listRead = new AtomicBoolean(false);
        this.readCompleteLatch = new CountDownLatch(1);
    }

    public static String binarySearchBytes(byte[] bArr, byte[][] bArr2, int i2) {
        InterceptResult invokeLLI;
        int i3;
        boolean z;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, bArr, bArr2, i2)) == null) {
            int length = bArr.length;
            int i6 = 0;
            while (i6 < length) {
                int i7 = (i6 + length) / 2;
                while (i7 > -1 && bArr[i7] != 10) {
                    i7--;
                }
                int i8 = i7 + 1;
                int i9 = 1;
                while (true) {
                    i3 = i8 + i9;
                    if (bArr[i3] == 10) {
                        break;
                    }
                    i9++;
                }
                int i10 = i3 - i8;
                int i11 = i2;
                boolean z2 = false;
                int i12 = 0;
                int i13 = 0;
                while (true) {
                    if (z2) {
                        i4 = 46;
                        z = false;
                    } else {
                        z = z2;
                        i4 = bArr2[i11][i12] & 255;
                    }
                    i5 = i4 - (bArr[i8 + i13] & 255);
                    if (i5 == 0) {
                        i13++;
                        i12++;
                        if (i13 == i10) {
                            break;
                        } else if (bArr2[i11].length != i12) {
                            z2 = z;
                        } else if (i11 == bArr2.length - 1) {
                            break;
                        } else {
                            i11++;
                            z2 = true;
                            i12 = -1;
                        }
                    } else {
                        break;
                    }
                }
                if (i5 >= 0) {
                    if (i5 <= 0) {
                        int i14 = i10 - i13;
                        int length2 = bArr2[i11].length - i12;
                        while (true) {
                            i11++;
                            if (i11 >= bArr2.length) {
                                break;
                            }
                            length2 += bArr2[i11].length;
                        }
                        if (length2 >= i14) {
                            if (length2 <= i14) {
                                return new String(bArr, i8, i10, Util.UTF_8);
                            }
                        }
                    }
                    i6 = i3 + 1;
                }
                length = i8 - 1;
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
            int i2 = 0;
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
            for (int i3 = 0; i3 < strArr.length; i3++) {
                bArr[i3] = strArr[i3].getBytes(Util.UTF_8);
            }
            int i4 = 0;
            while (true) {
                str = null;
                if (i4 >= length) {
                    str2 = null;
                    break;
                }
                str2 = binarySearchBytes(this.publicSuffixListBytes, bArr, i4);
                if (str2 != null) {
                    break;
                }
                i4++;
            }
            if (length > 1) {
                byte[][] bArr2 = (byte[][]) bArr.clone();
                for (int i5 = 0; i5 < bArr2.length - 1; i5++) {
                    bArr2[i5] = WILDCARD_LABEL;
                    str3 = binarySearchBytes(this.publicSuffixListBytes, bArr2, i5);
                    if (str3 != null) {
                        break;
                    }
                }
            }
            str3 = null;
            if (str3 != null) {
                while (true) {
                    if (i2 >= length - 1) {
                        break;
                    }
                    String binarySearchBytes = binarySearchBytes(this.publicSuffixExceptionListBytes, bArr, i2);
                    if (binarySearchBytes != null) {
                        str = binarySearchBytes;
                        break;
                    }
                    i2++;
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
                return strArr2.length > strArr3.length ? strArr2 : strArr3;
            }
        }
        return (String[]) invokeL.objValue;
    }

    public static PublicSuffixDatabase get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? instance : (PublicSuffixDatabase) invokeV.objValue;
    }

    private void readTheList() throws IOException {
        InputStream resourceAsStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, this) == null) || (resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(PUBLIC_SUFFIX_RESOURCE)) == null) {
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

    private void readTheListUninterruptibly() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            boolean z = false;
            while (true) {
                try {
                    try {
                        readTheList();
                        break;
                    } catch (InterruptedIOException unused) {
                        z = true;
                    } catch (IOException e2) {
                        Platform.get().log(5, "Failed to read public suffix list", e2);
                        if (z) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                        return;
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

    public String getEffectiveTldPlusOne(String str) {
        InterceptResult invokeL;
        int length;
        int length2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str != null) {
                String[] split = IDN.toUnicode(str).split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                String[] findMatchingRule = findMatchingRule(split);
                if (split.length != findMatchingRule.length || findMatchingRule[0].charAt(0) == '!') {
                    if (findMatchingRule[0].charAt(0) == '!') {
                        length = split.length;
                        length2 = findMatchingRule.length;
                    } else {
                        length = split.length;
                        length2 = findMatchingRule.length + 1;
                    }
                    StringBuilder sb = new StringBuilder();
                    String[] split2 = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                    for (int i2 = length - length2; i2 < split2.length; i2++) {
                        sb.append(split2[i2]);
                        sb.append('.');
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    return sb.toString();
                }
                return null;
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
