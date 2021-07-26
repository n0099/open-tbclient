package d.a.o0.a.l2;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f46515a;

    /* renamed from: b  reason: collision with root package name */
    public String f46516b;

    /* renamed from: c  reason: collision with root package name */
    public String f46517c;

    /* renamed from: d  reason: collision with root package name */
    public String f46518d;

    /* renamed from: e  reason: collision with root package name */
    public long f46519e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f46520f;

    /* renamed from: g  reason: collision with root package name */
    public long f46521g;

    /* renamed from: h  reason: collision with root package name */
    public long f46522h;

    /* renamed from: i  reason: collision with root package name */
    public int f46523i;

    /* renamed from: d.a.o0.a.l2.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0810a implements Comparator<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0810a() {
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
                int length = aVar2.f46516b.length() - aVar.f46516b.length();
                if (length != 0) {
                    return length;
                }
                int length2 = aVar2.f46515a.length() - aVar.f46515a.length();
                if (length2 != 0) {
                    return length2;
                }
                int hashCode = aVar2.f46517c.hashCode() - aVar.f46517c.hashCode();
                if (hashCode != 0) {
                    return hashCode;
                }
                if (aVar2.f46518d == null) {
                    return -1;
                }
                return aVar.f46518d == null ? 1 : 0;
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
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f46515a)) {
                if (!this.f46515a.startsWith(".")) {
                    return str.equals(this.f46515a);
                }
                if (str.endsWith(this.f46515a.substring(1))) {
                    int length = this.f46515a.length();
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
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) ? (aVar == null || TextUtils.isEmpty(this.f46515a) || TextUtils.isEmpty(this.f46516b) || TextUtils.isEmpty(this.f46517c) || !TextUtils.equals(this.f46515a, aVar.f46515a) || !TextUtils.equals(this.f46516b, aVar.f46516b) || !TextUtils.equals(this.f46517c, aVar.f46517c)) ? false : true : invokeL.booleanValue;
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f46516b) || !str.startsWith(this.f46516b)) {
                return false;
            }
            int length = this.f46516b.length();
            return this.f46516b.charAt(length + (-1)) == '/' || str.length() <= length || str.charAt(length) == '/';
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "domain: " + this.f46515a + "; path: " + this.f46516b + "; name: " + this.f46517c + "; value: " + this.f46518d + "; expires: " + this.f46519e + "; secure: " + this.f46520f;
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
        this.f46515a = str;
        this.f46516b = str2;
        this.f46519e = -1L;
    }
}
