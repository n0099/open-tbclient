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
import com.xiaomi.push.al;
import com.xiaomi.push.cj;
/* loaded from: classes8.dex */
public class bx {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bx a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f142a;

    /* renamed from: a  reason: collision with other field name */
    public al.a f143a;

    /* renamed from: a  reason: collision with other field name */
    public cm f144a;

    /* renamed from: a  reason: collision with other field name */
    public cn f145a;

    /* renamed from: a  reason: collision with other field name */
    public final String f146a;
    public al.a b;

    /* renamed from: b  reason: collision with other field name */
    public final String f147b;
    public al.a c;

    /* renamed from: c  reason: collision with other field name */
    public final String f148c;
    public final String d;
    public String e;
    public String f;

    public bx(Context context) {
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
        this.f146a = "push_stat_sp";
        this.f147b = "upload_time";
        this.f148c = DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM;
        this.d = "check_time";
        this.f143a = new by(this);
        this.b = new bz(this);
        this.c = new ca(this);
        this.f142a = context;
    }

    public static bx a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (a == null) {
                synchronized (bx.class) {
                    if (a == null) {
                        a = new bx(context);
                    }
                }
            }
            return a;
        }
        return (bx) invokeL.objValue;
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? com.xiaomi.push.service.ba.a(this.f142a).a(ho.bn.a(), true) : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, str) == null) {
            SharedPreferences.Editor edit = this.f142a.getSharedPreferences("push_stat_sp", 0).edit();
            edit.putLong(str, System.currentTimeMillis());
            t.a(edit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? this.f142a.getDatabasePath(cb.f152a).getAbsolutePath() : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m210a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    public void a(cj.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            cj.a(this.f142a).a(aVar);
        }
    }

    public void a(hn hnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hnVar) == null) && a() && com.xiaomi.push.service.bz.a(hnVar.e())) {
            a(cg.a(this.f142a, c(), hnVar));
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && a() && !TextUtils.isEmpty(str)) {
            a(co.a(this.f142a, str));
        }
    }

    public void a(String str, String str2, Boolean bool) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, bool) == null) || this.f144a == null) {
            return;
        }
        if (bool.booleanValue()) {
            this.f144a.a(this.f142a, str2, str);
        } else {
            this.f144a.b(this.f142a, str2, str);
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f : (String) invokeV.objValue;
    }
}
