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

    /* renamed from: a  reason: collision with root package name */
    public final SQLiteDatabase f69145a;

    /* renamed from: b  reason: collision with root package name */
    public final String f69146b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f69147c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f69148d;

    /* renamed from: e  reason: collision with root package name */
    public SQLiteStatement f69149e;

    /* renamed from: f  reason: collision with root package name */
    public SQLiteStatement f69150f;

    /* renamed from: g  reason: collision with root package name */
    public SQLiteStatement f69151g;

    /* renamed from: h  reason: collision with root package name */
    public SQLiteStatement f69152h;

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
        this.f69145a = sQLiteDatabase;
        this.f69146b = str;
        this.f69147c = strArr;
        this.f69148d = strArr2;
    }

    public SQLiteStatement a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f69149e == null) {
                SQLiteStatement compileStatement = this.f69145a.compileStatement(i.a("INSERT INTO ", this.f69146b, this.f69147c));
                synchronized (this) {
                    if (this.f69149e == null) {
                        this.f69149e = compileStatement;
                    }
                }
                if (this.f69149e != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f69149e;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f69151g == null) {
                SQLiteStatement compileStatement = this.f69145a.compileStatement(i.a(this.f69146b, this.f69148d));
                synchronized (this) {
                    if (this.f69151g == null) {
                        this.f69151g = compileStatement;
                    }
                }
                if (this.f69151g != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f69151g;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f69150f == null) {
                SQLiteStatement compileStatement = this.f69145a.compileStatement(i.a(this.f69146b, this.f69147c, this.f69148d));
                synchronized (this) {
                    if (this.f69150f == null) {
                        this.f69150f = compileStatement;
                    }
                }
                if (this.f69150f != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f69150f;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f69152h == null) {
                SQLiteStatement compileStatement = this.f69145a.compileStatement(i.b(this.f69146b, this.f69147c, this.f69148d));
                synchronized (this) {
                    if (this.f69152h == null) {
                        this.f69152h = compileStatement;
                    }
                }
                if (this.f69152h != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f69152h;
        }
        return (SQLiteStatement) invokeV.objValue;
    }
}
