package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/* loaded from: classes8.dex */
public class gk implements go {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: a  reason: collision with other field name */
    public List<gk> f454a;

    /* renamed from: a  reason: collision with other field name */
    public String[] f455a;
    public String b;

    /* renamed from: b  reason: collision with other field name */
    public String[] f456b;
    public String c;

    public gk(String str, String str2, String[] strArr, String[] strArr2) {
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
        this.f455a = null;
        this.f456b = null;
        this.f454a = null;
        this.a = str;
        this.b = str2;
        this.f455a = strArr;
        this.f456b = strArr2;
    }

    public gk(String str, String str2, String[] strArr, String[] strArr2, String str3, List<gk> list) {
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
        this.f455a = null;
        this.f456b = null;
        this.f454a = null;
        this.a = str;
        this.b = str2;
        this.f455a = strArr;
        this.f456b = strArr2;
        this.c = str3;
        this.f454a = list;
    }

    public static gk a(Bundle bundle) {
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
            if (bundle.containsKey(CriusAttrConstants.CHILDREN)) {
                Parcelable[] parcelableArray = bundle.getParcelableArray(CriusAttrConstants.CHILDREN);
                ArrayList arrayList2 = new ArrayList(parcelableArray.length);
                for (Parcelable parcelable : parcelableArray) {
                    arrayList2.add(a((Bundle) parcelable));
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            return new gk(string, string2, strArr, strArr2, string3, arrayList);
        }
        return (gk) invokeL.objValue;
    }

    public static Parcelable[] a(List<gk> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) ? a((gk[]) list.toArray(new gk[list.size()])) : (Parcelable[]) invokeL.objValue;
    }

    public static Parcelable[] a(gk[] gkVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, gkVarArr)) == null) {
            if (gkVarArr == null) {
                return null;
            }
            Parcelable[] parcelableArr = new Parcelable[gkVarArr.length];
            for (int i = 0; i < gkVarArr.length; i++) {
                parcelableArr[i] = gkVarArr[i].m438a();
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
            bundle.putString("ext_ns", this.b);
            bundle.putString("ext_text", this.c);
            Bundle bundle2 = new Bundle();
            String[] strArr = this.f455a;
            if (strArr != null && strArr.length > 0) {
                int i = 0;
                while (true) {
                    String[] strArr2 = this.f455a;
                    if (i >= strArr2.length) {
                        break;
                    }
                    bundle2.putString(strArr2[i], this.f456b[i]);
                    i++;
                }
            }
            bundle.putBundle("attributes", bundle2);
            List<gk> list = this.f454a;
            if (list != null && list.size() > 0) {
                bundle.putParcelableArray(CriusAttrConstants.CHILDREN, a(this.f454a));
            }
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Parcelable m438a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? a() : (Parcelable) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m439a() {
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
        if (this.f455a == null) {
            return null;
        }
        int i = 0;
        while (true) {
            String[] strArr = this.f455a;
            if (i >= strArr.length) {
                return null;
            }
            if (str.equals(strArr[i])) {
                return this.f456b[i];
            }
            i++;
        }
    }

    public void a(gk gkVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gkVar) == null) {
            if (this.f454a == null) {
                this.f454a = new ArrayList();
            }
            if (this.f454a.contains(gkVar)) {
                return;
            }
            this.f454a.add(gkVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m440a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                str = gy.a(str);
            }
            this.c = str;
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? !TextUtils.isEmpty(this.c) ? gy.b(this.c) : this.c : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.go
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("<");
            sb.append(this.a);
            if (!TextUtils.isEmpty(this.b)) {
                sb.append(" ");
                sb.append("xmlns=");
                sb.append("\"");
                sb.append(this.b);
                sb.append("\"");
            }
            String[] strArr = this.f455a;
            if (strArr != null && strArr.length > 0) {
                for (int i = 0; i < this.f455a.length; i++) {
                    if (!TextUtils.isEmpty(this.f456b[i])) {
                        sb.append(" ");
                        sb.append(this.f455a[i]);
                        sb.append("=\"");
                        sb.append(gy.a(this.f456b[i]));
                        sb.append("\"");
                    }
                }
            }
            if (TextUtils.isEmpty(this.c)) {
                List<gk> list = this.f454a;
                if (list == null || list.size() <= 0) {
                    sb.append("/>");
                    return sb.toString();
                }
                sb.append(">");
                for (gk gkVar : this.f454a) {
                    sb.append(gkVar.d());
                }
            } else {
                sb.append(">");
                sb.append(this.c);
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
