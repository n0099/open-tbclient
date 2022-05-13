package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.ai;
import com.xiaomi.push.cg;
/* loaded from: classes8.dex */
public class bu {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bu a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f141a;

    /* renamed from: a  reason: collision with other field name */
    public ai.a f142a;

    /* renamed from: a  reason: collision with other field name */
    public cj f143a;

    /* renamed from: a  reason: collision with other field name */
    public ck f144a;

    /* renamed from: a  reason: collision with other field name */
    public final String f145a;
    public ai.a b;

    /* renamed from: b  reason: collision with other field name */
    public final String f146b;
    public ai.a c;

    /* renamed from: c  reason: collision with other field name */
    public final String f147c;
    public final String d;
    public String e;
    public String f;

    public bu(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f145a = "push_stat_sp";
        this.f146b = "upload_time";
        this.f147c = DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM;
        this.d = "check_time";
        this.f142a = new bv(this);
        this.b = new bw(this);
        this.c = new bx(this);
        this.f141a = context;
    }

    public static bu a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (a == null) {
                synchronized (bu.class) {
                    if (a == null) {
                        a = new bu(context);
                    }
                }
            }
            return a;
        }
        return (bu) invokeL.objValue;
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? com.xiaomi.push.service.aq.a(this.f141a).a(hk.bi.a(), true) : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, str) == null) {
            SharedPreferences.Editor edit = this.f141a.getSharedPreferences("push_stat_sp", 0).edit();
            edit.putLong(str, System.currentTimeMillis());
            r.a(edit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? this.f141a.getDatabasePath(by.f149a).getAbsolutePath() : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m231a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    public void a(cg.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            cg.a(this.f141a).a(aVar);
        }
    }

    public void a(hj hjVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hjVar) == null) && a() && com.xiaomi.push.service.bm.a(hjVar.e())) {
            a(cd.a(this.f141a, c(), hjVar));
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && a() && !TextUtils.isEmpty(str)) {
            a(cl.a(this.f141a, str));
        }
    }

    public void a(String str, String str2, Boolean bool) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, bool) == null) || this.f143a == null) {
            return;
        }
        if (bool.booleanValue()) {
            this.f143a.a(this.f141a, str2, str);
        } else {
            this.f143a.b(this.f141a, str2, str);
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f : (String) invokeV.objValue;
    }
}
