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
/* loaded from: classes3.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;

    /* renamed from: b  reason: collision with root package name */
    public final String f62224b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f62225c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f62226d;

    /* renamed from: e  reason: collision with root package name */
    public SQLiteStatement f62227e;

    /* renamed from: f  reason: collision with root package name */
    public SQLiteStatement f62228f;

    /* renamed from: g  reason: collision with root package name */
    public SQLiteStatement f62229g;

    /* renamed from: h  reason: collision with root package name */
    public SQLiteStatement f62230h;

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
        this.f62224b = str;
        this.f62225c = strArr;
        this.f62226d = strArr2;
    }

    public SQLiteStatement a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f62227e == null) {
                SQLiteStatement compileStatement = this.a.compileStatement(i.a("INSERT INTO ", this.f62224b, this.f62225c));
                synchronized (this) {
                    if (this.f62227e == null) {
                        this.f62227e = compileStatement;
                    }
                }
                if (this.f62227e != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f62227e;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f62229g == null) {
                SQLiteStatement compileStatement = this.a.compileStatement(i.a(this.f62224b, this.f62226d));
                synchronized (this) {
                    if (this.f62229g == null) {
                        this.f62229g = compileStatement;
                    }
                }
                if (this.f62229g != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f62229g;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f62228f == null) {
                SQLiteStatement compileStatement = this.a.compileStatement(i.a(this.f62224b, this.f62225c, this.f62226d));
                synchronized (this) {
                    if (this.f62228f == null) {
                        this.f62228f = compileStatement;
                    }
                }
                if (this.f62228f != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f62228f;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f62230h == null) {
                SQLiteStatement compileStatement = this.a.compileStatement(i.b(this.f62224b, this.f62225c, this.f62226d));
                synchronized (this) {
                    if (this.f62230h == null) {
                        this.f62230h = compileStatement;
                    }
                }
                if (this.f62230h != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f62230h;
        }
        return (SQLiteStatement) invokeV.objValue;
    }
}
