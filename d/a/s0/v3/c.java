package d.a.s0.v3;

import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.SevenZipUtils;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f68588a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f68589b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f68590c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f68591d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f68592e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f68593f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f68594g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-624402083, "Ld/a/s0/v3/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-624402083, "Ld/a/s0/v3/c;");
                return;
            }
        }
        f68588a = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/.music/";
        StringBuilder sb = new StringBuilder();
        sb.append(FileHelper.EXTERNAL_STORAGE_DIRECTORY);
        sb.append("/");
        sb.append("tieba");
        sb.append("/videoCover.jpg");
        f68589b = sb.toString();
        f68590c = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/tbVideo/" + SevenZipUtils.FILE_NAME_TEMP;
        f68591d = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/tbVideo/temp/";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(FileHelper.EXTERNAL_STORAGE_DIRECTORY);
        sb2.append("/");
        sb2.append("DCIM/tieba/");
        f68592e = sb2.toString();
        f68593f = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/.pendant/";
        f68594g = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/takepic/";
    }
}
