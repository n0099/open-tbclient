package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.ai;
import com.xiaomi.push.cg;
/* loaded from: classes2.dex */
public class bu {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile bu f70726a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f165a;

    /* renamed from: a  reason: collision with other field name */
    public ai.a f166a;

    /* renamed from: a  reason: collision with other field name */
    public cj f167a;

    /* renamed from: a  reason: collision with other field name */
    public ck f168a;

    /* renamed from: a  reason: collision with other field name */
    public final String f169a;

    /* renamed from: b  reason: collision with root package name */
    public ai.a f70727b;

    /* renamed from: b  reason: collision with other field name */
    public final String f170b;

    /* renamed from: c  reason: collision with root package name */
    public ai.a f70728c;

    /* renamed from: c  reason: collision with other field name */
    public final String f171c;

    /* renamed from: d  reason: collision with root package name */
    public final String f70729d;

    /* renamed from: e  reason: collision with root package name */
    public String f70730e;

    /* renamed from: f  reason: collision with root package name */
    public String f70731f;

    public bu(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f169a = "push_stat_sp";
        this.f170b = "upload_time";
        this.f171c = DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM;
        this.f70729d = "check_time";
        this.f166a = new bv(this);
        this.f70727b = new bw(this);
        this.f70728c = new bx(this);
        this.f165a = context;
    }

    public static bu a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f70726a == null) {
                synchronized (bu.class) {
                    if (f70726a == null) {
                        f70726a = new bu(context);
                    }
                }
            }
            return f70726a;
        }
        return (bu) invokeL.objValue;
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) ? com.xiaomi.push.service.aq.a(this.f165a).a(hk.bi.a(), true) : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, str) == null) {
            SharedPreferences.Editor edit = this.f165a.getSharedPreferences("push_stat_sp", 0).edit();
            edit.putLong(str, System.currentTimeMillis());
            r.a(edit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? this.f165a.getDatabasePath(by.f173a).getAbsolutePath() : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m195a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70730e : (String) invokeV.objValue;
    }

    public void a(cg.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            cg.a(this.f165a).a(aVar);
        }
    }

    public void a(hj hjVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hjVar) == null) && a() && com.xiaomi.push.service.bm.a(hjVar.e())) {
            a(cd.a(this.f165a, c(), hjVar));
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && a() && !TextUtils.isEmpty(str)) {
            a(cl.a(this.f165a, str));
        }
    }

    public void a(String str, String str2, Boolean bool) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, bool) == null) || this.f167a == null) {
            return;
        }
        if (bool.booleanValue()) {
            this.f167a.a(this.f165a, str2, str);
        } else {
            this.f167a.b(this.f165a, str2, str);
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f70731f : (String) invokeV.objValue;
    }
}
