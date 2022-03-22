package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/* loaded from: classes7.dex */
public class fz implements gd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: a  reason: collision with other field name */
    public List<fz> f399a;

    /* renamed from: a  reason: collision with other field name */
    public String[] f400a;

    /* renamed from: b  reason: collision with root package name */
    public String f44265b;

    /* renamed from: b  reason: collision with other field name */
    public String[] f401b;

    /* renamed from: c  reason: collision with root package name */
    public String f44266c;

    public fz(String str, String str2, String[] strArr, String[] strArr2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, strArr, strArr2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f400a = null;
        this.f401b = null;
        this.f399a = null;
        this.a = str;
        this.f44265b = str2;
        this.f400a = strArr;
        this.f401b = strArr2;
    }

    public fz(String str, String str2, String[] strArr, String[] strArr2, String str3, List<fz> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, strArr, strArr2, str3, list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f400a = null;
        this.f401b = null;
        this.f399a = null;
        this.a = str;
        this.f44265b = str2;
        this.f400a = strArr;
        this.f401b = strArr2;
        this.f44266c = str3;
        this.f399a = list;
    }

    public static fz a(Bundle bundle) {
        InterceptResult invokeL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bundle)) == null) {
            String string = bundle.getString("ext_ele_name");
            String string2 = bundle.getString("ext_ns");
            String string3 = bundle.getString("ext_text");
            Bundle bundle2 = bundle.getBundle("attributes");
            Set<String> keySet = bundle2.keySet();
            String[] strArr = new String[keySet.size()];
            String[] strArr2 = new String[keySet.size()];
            int i = 0;
            for (String str : keySet) {
                strArr[i] = str;
                strArr2[i] = bundle2.getString(str);
                i++;
            }
            if (bundle.containsKey("children")) {
                Parcelable[] parcelableArray = bundle.getParcelableArray("children");
                ArrayList arrayList2 = new ArrayList(parcelableArray.length);
                for (Parcelable parcelable : parcelableArray) {
                    arrayList2.add(a((Bundle) parcelable));
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            return new fz(string, string2, strArr, strArr2, string3, arrayList);
        }
        return (fz) invokeL.objValue;
    }

    public static Parcelable[] a(List<fz> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) ? a((fz[]) list.toArray(new fz[list.size()])) : (Parcelable[]) invokeL.objValue;
    }

    public static Parcelable[] a(fz[] fzVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fzVarArr)) == null) {
            if (fzVarArr == null) {
                return null;
            }
            Parcelable[] parcelableArr = new Parcelable[fzVarArr.length];
            for (int i = 0; i < fzVarArr.length; i++) {
                parcelableArr[i] = fzVarArr[i].m375a();
            }
            return parcelableArr;
        }
        return (Parcelable[]) invokeL.objValue;
    }

    public Bundle a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("ext_ele_name", this.a);
            bundle.putString("ext_ns", this.f44265b);
            bundle.putString("ext_text", this.f44266c);
            Bundle bundle2 = new Bundle();
            String[] strArr = this.f400a;
            if (strArr != null && strArr.length > 0) {
                int i = 0;
                while (true) {
                    String[] strArr2 = this.f400a;
                    if (i >= strArr2.length) {
                        break;
                    }
                    bundle2.putString(strArr2[i], this.f401b[i]);
                    i++;
                }
            }
            bundle.putBundle("attributes", bundle2);
            List<fz> list = this.f399a;
            if (list != null && list.size() > 0) {
                bundle.putParcelableArray("children", a(this.f399a));
            }
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Parcelable m375a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? a() : (Parcelable) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m376a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048579, this, str)) != null) {
            return (String) invokeL.objValue;
        }
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if (this.f400a == null) {
            return null;
        }
        int i = 0;
        while (true) {
            String[] strArr = this.f400a;
            if (i >= strArr.length) {
                return null;
            }
            if (str.equals(strArr[i])) {
                return this.f401b[i];
            }
            i++;
        }
    }

    public void a(fz fzVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fzVar) == null) {
            if (this.f399a == null) {
                this.f399a = new ArrayList();
            }
            if (this.f399a.contains(fzVar)) {
                return;
            }
            this.f399a.add(fzVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m377a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                str = gn.a(str);
            }
            this.f44266c = str;
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f44265b : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? !TextUtils.isEmpty(this.f44266c) ? gn.b(this.f44266c) : this.f44266c : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.gd
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("<");
            sb.append(this.a);
            if (!TextUtils.isEmpty(this.f44265b)) {
                sb.append(" ");
                sb.append("xmlns=");
                sb.append("\"");
                sb.append(this.f44265b);
                sb.append("\"");
            }
            String[] strArr = this.f400a;
            if (strArr != null && strArr.length > 0) {
                for (int i = 0; i < this.f400a.length; i++) {
                    if (!TextUtils.isEmpty(this.f401b[i])) {
                        sb.append(" ");
                        sb.append(this.f400a[i]);
                        sb.append("=\"");
                        sb.append(gn.a(this.f401b[i]));
                        sb.append("\"");
                    }
                }
            }
            if (TextUtils.isEmpty(this.f44266c)) {
                List<fz> list = this.f399a;
                if (list == null || list.size() <= 0) {
                    sb.append("/>");
                    return sb.toString();
                }
                sb.append(">");
                for (fz fzVar : this.f399a) {
                    sb.append(fzVar.d());
                }
            } else {
                sb.append(">");
                sb.append(this.f44266c);
            }
            sb.append("</");
            sb.append(this.a);
            sb.append(">");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? d() : (String) invokeV.objValue;
    }
}
