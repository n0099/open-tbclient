package d.a.q0.v3;

import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.SevenZipUtils;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f66018a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f66019b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f66020c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f66021d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f66022e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f66023f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f66024g;

    /* renamed from: h  reason: collision with root package name */
    public static final String f66025h;

    /* renamed from: i  reason: collision with root package name */
    public static final String f66026i;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(184944543, "Ld/a/q0/v3/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(184944543, "Ld/a/q0/v3/c;");
                return;
            }
        }
        f66018a = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/.music/";
        StringBuilder sb = new StringBuilder();
        sb.append(FileHelper.EXTERNAL_STORAGE_DIRECTORY);
        sb.append("/");
        sb.append("tieba");
        sb.append("/videoCover.jpg");
        f66019b = sb.toString();
        f66020c = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/tbNewVideo/" + SevenZipUtils.FILE_NAME_TEMP;
        f66021d = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/tbVideo/" + SevenZipUtils.FILE_NAME_TEMP;
        f66022e = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/tbNewVideo/temp/";
        f66023f = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/tbVideo/temp/";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(FileHelper.EXTERNAL_STORAGE_DIRECTORY);
        sb2.append("/");
        sb2.append("DCIM/tieba/");
        f66024g = sb2.toString();
        f66025h = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/.pendant/";
        f66026i = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/takepic/";
    }
}
