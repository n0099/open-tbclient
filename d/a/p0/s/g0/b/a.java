package d.a.p0.s.g0.b;

import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.q.h;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f53110a;

    /* renamed from: b  reason: collision with root package name */
    public String f53111b;

    /* renamed from: c  reason: collision with root package name */
    public int f53112c;

    /* renamed from: d  reason: collision with root package name */
    public String f53113d;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53110a = null;
        this.f53111b = null;
        this.f53112c = 0;
        this.f53113d = null;
    }

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            switch (i2) {
                case 1:
                    return h.a(R.string.voice_cache_error_internal);
                case 2:
                    return h.a(R.string.voice_cache_error_no_space);
                case 3:
                    return h.a(R.string.neterror);
                case 4:
                    return h.a(R.string.voice_cache_error_no_file);
                case 5:
                    return h.a(R.string.voice_cache_error_md5);
                case 6:
                    return h.a(R.string.voice_cache_error_no_input);
                case 7:
                    return h.a(R.string.voice_cache_error_no_dir);
                default:
                    return "";
            }
        }
        return (String) invokeI.objValue;
    }
}
