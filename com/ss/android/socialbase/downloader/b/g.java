package com.ss.android.socialbase.downloader.b;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.i.i;
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;

    /* renamed from: b  reason: collision with root package name */
    public final String f61643b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f61644c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f61645d;

    /* renamed from: e  reason: collision with root package name */
    public SQLiteStatement f61646e;

    /* renamed from: f  reason: collision with root package name */
    public SQLiteStatement f61647f;

    /* renamed from: g  reason: collision with root package name */
    public SQLiteStatement f61648g;

    /* renamed from: h  reason: collision with root package name */
    public SQLiteStatement f61649h;

    public g(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sQLiteDatabase, str, strArr, strArr2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = sQLiteDatabase;
        this.f61643b = str;
        this.f61644c = strArr;
        this.f61645d = strArr2;
    }

    public SQLiteStatement a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f61646e == null) {
                SQLiteStatement compileStatement = this.a.compileStatement(i.a("INSERT INTO ", this.f61643b, this.f61644c));
                synchronized (this) {
                    if (this.f61646e == null) {
                        this.f61646e = compileStatement;
                    }
                }
                if (this.f61646e != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f61646e;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f61648g == null) {
                SQLiteStatement compileStatement = this.a.compileStatement(i.a(this.f61643b, this.f61645d));
                synchronized (this) {
                    if (this.f61648g == null) {
                        this.f61648g = compileStatement;
                    }
                }
                if (this.f61648g != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f61648g;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f61647f == null) {
                SQLiteStatement compileStatement = this.a.compileStatement(i.a(this.f61643b, this.f61644c, this.f61645d));
                synchronized (this) {
                    if (this.f61647f == null) {
                        this.f61647f = compileStatement;
                    }
                }
                if (this.f61647f != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f61647f;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f61649h == null) {
                SQLiteStatement compileStatement = this.a.compileStatement(i.b(this.f61643b, this.f61644c, this.f61645d));
                synchronized (this) {
                    if (this.f61649h == null) {
                        this.f61649h = compileStatement;
                    }
                }
                if (this.f61649h != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f61649h;
        }
        return (SQLiteStatement) invokeV.objValue;
    }
}
