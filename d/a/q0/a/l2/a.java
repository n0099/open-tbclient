package d.a.q0.a.l2;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f49313a;

    /* renamed from: b  reason: collision with root package name */
    public String f49314b;

    /* renamed from: c  reason: collision with root package name */
    public String f49315c;

    /* renamed from: d  reason: collision with root package name */
    public String f49316d;

    /* renamed from: e  reason: collision with root package name */
    public long f49317e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f49318f;

    /* renamed from: g  reason: collision with root package name */
    public long f49319g;

    /* renamed from: h  reason: collision with root package name */
    public long f49320h;

    /* renamed from: i  reason: collision with root package name */
    public int f49321i;

    /* renamed from: d.a.q0.a.l2.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0852a implements Comparator<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0852a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, aVar2)) == null) {
                int length = aVar2.f49314b.length() - aVar.f49314b.length();
                if (length != 0) {
                    return length;
                }
                int length2 = aVar2.f49313a.length() - aVar.f49313a.length();
                if (length2 != 0) {
                    return length2;
                }
                int hashCode = aVar2.f49315c.hashCode() - aVar.f49315c.hashCode();
                if (hashCode != 0) {
                    return hashCode;
                }
                if (aVar2.f49316d == null) {
                    return -1;
                }
                return aVar.f49316d == null ? 1 : 0;
            }
            return invokeLL.intValue;
        }
    }

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
            }
        }
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f49313a)) {
                if (!this.f49313a.startsWith(".")) {
                    return str.equals(this.f49313a);
                }
                if (str.endsWith(this.f49313a.substring(1))) {
                    int length = this.f49313a.length();
                    int length2 = str.length();
                    return length2 <= length + (-1) || str.charAt(length2 - length) == '.';
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean b(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) ? (aVar == null || TextUtils.isEmpty(this.f49313a) || TextUtils.isEmpty(this.f49314b) || TextUtils.isEmpty(this.f49315c) || !TextUtils.equals(this.f49313a, aVar.f49313a) || !TextUtils.equals(this.f49314b, aVar.f49314b) || !TextUtils.equals(this.f49315c, aVar.f49315c)) ? false : true : invokeL.booleanValue;
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f49314b) || !str.startsWith(this.f49314b)) {
                return false;
            }
            int length = this.f49314b.length();
            return this.f49314b.charAt(length + (-1)) == '/' || str.length() <= length || str.charAt(length) == '/';
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "domain: " + this.f49313a + "; path: " + this.f49314b + "; name: " + this.f49315c + "; value: " + this.f49316d + "; expires: " + this.f49317e + "; secure: " + this.f49318f;
        }
        return (String) invokeV.objValue;
    }

    public a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f49313a = str;
        this.f49314b = str2;
        this.f49317e = -1L;
    }
}
