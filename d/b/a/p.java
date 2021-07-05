package d.b.a;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class p implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final SimpleDateFormat l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f71720e;

    /* renamed from: f  reason: collision with root package name */
    public long f71721f;

    /* renamed from: g  reason: collision with root package name */
    public String f71722g;

    /* renamed from: h  reason: collision with root package name */
    public String f71723h;

    /* renamed from: i  reason: collision with root package name */
    public String f71724i;
    public String j;
    public String k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-125210595, "Ld/b/a/p;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-125210595, "Ld/b/a/p;");
                return;
            }
        }
        l = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    }

    public p() {
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
        this.f71720e = System.currentTimeMillis();
    }

    public static p b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                return q.f71738e.get(jSONObject.optString("k_cls", "")).clone().h(jSONObject);
            } catch (Throwable th) {
                h0.b(th);
                return null;
            }
        }
        return (p) invokeL.objValue;
    }

    public static String c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j)) == null) ? l.format(new Date(j)) : (String) invokeJ.objValue;
    }

    @NonNull
    public abstract p a(@NonNull Cursor cursor);

    public abstract void d(@NonNull ContentValues contentValues);

    public abstract void e(@NonNull JSONObject jSONObject);

    public abstract String[] f();

    public final ContentValues g(@Nullable ContentValues contentValues) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, contentValues)) == null) {
            if (contentValues == null) {
                contentValues = new ContentValues();
            } else {
                contentValues.clear();
            }
            d(contentValues);
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public abstract p h(@NonNull JSONObject jSONObject);

    public abstract JSONObject i();

    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String[] f2 = f();
            if (f2 != null) {
                StringBuilder sb = new StringBuilder(128);
                sb.append("create table if not exists ");
                sb.append(k());
                sb.append("(");
                for (int i2 = 0; i2 < f2.length; i2 += 2) {
                    sb.append(f2[i2]);
                    sb.append(" ");
                    sb.append(f2[i2 + 1]);
                    sb.append(",");
                }
                sb.delete(sb.length() - 1, sb.length());
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                return sb.toString();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public abstract String k();

    @NonNull
    public final JSONObject l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("k_cls", k());
                e(jSONObject);
            } catch (JSONException e2) {
                h0.b(e2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @NonNull
    public final JSONObject m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            try {
                this.k = c(this.f71720e);
                return i();
            } catch (JSONException e2) {
                h0.b(e2);
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: n */
    public p clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            try {
                return (p) super.clone();
            } catch (CloneNotSupportedException e2) {
                h0.b(e2);
                return null;
            }
        }
        return (p) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return "sid:" + this.f71722g;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (h0.f71677b) {
                String k = k();
                if (!getClass().getSimpleName().equalsIgnoreCase(k)) {
                    k = k + StringUtil.ARRAY_ELEMENT_SEPARATOR + getClass().getSimpleName();
                }
                String str = this.f71722g;
                String str2 = "-";
                if (str != null) {
                    int indexOf = str.indexOf("-");
                    if (indexOf >= 0) {
                        str = str.substring(0, indexOf);
                    }
                    str2 = str;
                }
                return StringUtil.ARRAY_START + k + StringUtil.ARRAY_ELEMENT_SEPARATOR + o() + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f71720e + "}";
            }
            return super.toString();
        }
        return (String) invokeV.objValue;
    }
}
