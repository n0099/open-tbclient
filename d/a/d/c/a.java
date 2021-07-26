package d.a.d.c;

import android.util.SparseArray;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f41398b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<String> f41399a;

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
        this.f41399a = null;
        this.f41399a = new SparseArray<>();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f41398b == null) {
                synchronized (a.class) {
                    if (f41398b == null) {
                        f41398b = new a();
                    }
                }
            }
            return f41398b;
        }
        return (a) invokeV.objValue;
    }

    public String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            String str = this.f41399a.get(i2);
            if (str != null) {
                return str;
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    public void c(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || !BdBaseApplication.getInst().isDebugMode() || list == null || list.size() == 0) {
            return;
        }
        for (String str : list) {
            d(str);
        }
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            try {
                Class<?> loadClass = a.class.getClassLoader().loadClass(str);
                Object newInstance = loadClass.newInstance();
                Field[] fields = loadClass.getFields();
                if (fields == null || fields.length <= 0) {
                    return;
                }
                for (Field field : fields) {
                    int i2 = field.getInt(newInstance);
                    String name = field.getName();
                    if (this.f41399a.get(i2) == null) {
                        this.f41399a.put(i2, name);
                    } else {
                        throw new Error("cmd " + str + " " + name + " 和 " + this.f41399a.get(i2) + " 重复");
                    }
                }
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (IllegalArgumentException e4) {
                e4.printStackTrace();
            } catch (InstantiationException e5) {
                e5.printStackTrace();
            }
        }
    }
}
