package com.repackage;

import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class id0 extends pd0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    a aVar = new a();
                    aVar.a = jSONObject.optString("name");
                    aVar.b = jSONObject.optString("path");
                    aVar.c = jSONObject.optString(PackageTable.MD5);
                    return aVar;
                } catch (Exception unused) {
                    return null;
                }
            }
            return (a) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public id0(jd0 jd0Var) {
        super(jd0Var.b, jd0Var.g);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jd0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (File) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean t(File file) {
        InterceptResult invokeL;
        File file2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            try {
                file2 = new File(file, "files.json");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (file2.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file2);
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String str = new String(bArr);
                fileInputStream.close();
                JSONArray optJSONArray = new JSONObject(str).optJSONArray("files");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        arrayList.add(a.a(optJSONArray.getString(i)));
                    }
                    return u(file, arrayList);
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean u(File file, ArrayList<a> arrayList) {
        InterceptResult invokeLL;
        File file2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, file, arrayList)) == null) {
            if (arrayList == null || arrayList.size() <= 0) {
                return false;
            }
            try {
                Iterator<a> it = arrayList.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    String str = next.b;
                    if (TextUtils.isEmpty(str)) {
                        file2 = new File(file, next.a);
                    } else {
                        file2 = new File(file, str + File.separator + next.a);
                    }
                    if (!file2.exists()) {
                        return false;
                    }
                    String a2 = ld0.a(file2.getAbsolutePath());
                    boolean equals = TextUtils.equals(a2, next.c);
                    if (!equals) {
                        pd0.j(equals + " " + a2 + "!=" + next.c + StringUtil.ARRAY_ELEMENT_SEPARATOR + file2.getAbsolutePath());
                        return false;
                    }
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.pd0
    public boolean i(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) ? t(file) : invokeL.booleanValue;
    }
}
