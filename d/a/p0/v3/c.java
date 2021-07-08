package d.a.p0.v3;

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
    public static final String f65370a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f65371b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f65372c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f65373d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f65374e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f65375f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f65376g;

    /* renamed from: h  reason: collision with root package name */
    public static final String f65377h;

    /* renamed from: i  reason: collision with root package name */
    public static final String f65378i;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1557865792, "Ld/a/p0/v3/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1557865792, "Ld/a/p0/v3/c;");
                return;
            }
        }
        f65370a = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/.music/";
        StringBuilder sb = new StringBuilder();
        sb.append(FileHelper.EXTERNAL_STORAGE_DIRECTORY);
        sb.append("/");
        sb.append("tieba");
        sb.append("/videoCover.jpg");
        f65371b = sb.toString();
        f65372c = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/tbNewVideo/" + SevenZipUtils.FILE_NAME_TEMP;
        f65373d = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/tbVideo/" + SevenZipUtils.FILE_NAME_TEMP;
        f65374e = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/tbNewVideo/temp/";
        f65375f = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/tbVideo/temp/";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(FileHelper.EXTERNAL_STORAGE_DIRECTORY);
        sb2.append("/");
        sb2.append("DCIM/tieba/");
        f65376g = sb2.toString();
        f65377h = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/.pendant/";
        f65378i = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/tieba/takepic/";
    }
}
