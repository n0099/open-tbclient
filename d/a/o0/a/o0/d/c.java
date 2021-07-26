package d.a.o0.a.o0.d;

import android.content.ContentValues;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes7.dex */
public class c extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public ContentValues f47045d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@Nullable Map<String, String> map) {
        super("lifecycle", map);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (Map) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.o0.a.o0.d.b, d.a.o0.a.o0.d.a
    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(d.a.o0.a.o0.a.c(str, "cuid", d.a.o0.a.c1.a.a0().i(d.a.o0.a.c1.a.b())));
            sb.append(d.a.o0.a.o0.a.c(str, "mtjCuid", d.a.o0.a.c1.a.a0().i(d.a.o0.a.c1.a.b())));
            ContentValues contentValues = this.f47045d;
            if (contentValues != null) {
                for (String str2 : contentValues.keySet()) {
                    sb.append(d.a.o0.a.o0.a.b(str, str2, this.f47045d.get(str2)));
                }
            } else {
                for (Map.Entry<String, String> entry : this.f47044c.entrySet()) {
                    sb.append(d.a.o0.a.o0.a.c(str, entry.getKey(), entry.getValue()));
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull ContentValues contentValues) {
        super("lifecycle", null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {contentValues};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (Map) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f47045d = contentValues;
    }
}
