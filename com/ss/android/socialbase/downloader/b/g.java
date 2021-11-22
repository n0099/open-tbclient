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
    public final SQLiteDatabase f70064a;

    /* renamed from: b  reason: collision with root package name */
    public final String f70065b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f70066c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f70067d;

    /* renamed from: e  reason: collision with root package name */
    public SQLiteStatement f70068e;

    /* renamed from: f  reason: collision with root package name */
    public SQLiteStatement f70069f;

    /* renamed from: g  reason: collision with root package name */
    public SQLiteStatement f70070g;

    /* renamed from: h  reason: collision with root package name */
    public SQLiteStatement f70071h;

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
        this.f70064a = sQLiteDatabase;
        this.f70065b = str;
        this.f70066c = strArr;
        this.f70067d = strArr2;
    }

    public SQLiteStatement a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f70068e == null) {
                SQLiteStatement compileStatement = this.f70064a.compileStatement(i.a("INSERT INTO ", this.f70065b, this.f70066c));
                synchronized (this) {
                    if (this.f70068e == null) {
                        this.f70068e = compileStatement;
                    }
                }
                if (this.f70068e != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f70068e;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f70070g == null) {
                SQLiteStatement compileStatement = this.f70064a.compileStatement(i.a(this.f70065b, this.f70067d));
                synchronized (this) {
                    if (this.f70070g == null) {
                        this.f70070g = compileStatement;
                    }
                }
                if (this.f70070g != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f70070g;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f70069f == null) {
                SQLiteStatement compileStatement = this.f70064a.compileStatement(i.a(this.f70065b, this.f70066c, this.f70067d));
                synchronized (this) {
                    if (this.f70069f == null) {
                        this.f70069f = compileStatement;
                    }
                }
                if (this.f70069f != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f70069f;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f70071h == null) {
                SQLiteStatement compileStatement = this.f70064a.compileStatement(i.b(this.f70065b, this.f70066c, this.f70067d));
                synchronized (this) {
                    if (this.f70071h == null) {
                        this.f70071h = compileStatement;
                    }
                }
                if (this.f70071h != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f70071h;
        }
        return (SQLiteStatement) invokeV.objValue;
    }
}
