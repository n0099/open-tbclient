package d.l.a.e.b.b;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.l.a.e.b.l.g;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final SQLiteDatabase f71720a;

    /* renamed from: b  reason: collision with root package name */
    public final String f71721b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f71722c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f71723d;

    /* renamed from: e  reason: collision with root package name */
    public SQLiteStatement f71724e;

    /* renamed from: f  reason: collision with root package name */
    public SQLiteStatement f71725f;

    /* renamed from: g  reason: collision with root package name */
    public SQLiteStatement f71726g;

    /* renamed from: h  reason: collision with root package name */
    public SQLiteStatement f71727h;

    public c(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
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
        this.f71720a = sQLiteDatabase;
        this.f71721b = str;
        this.f71722c = strArr;
        this.f71723d = strArr2;
    }

    public SQLiteStatement a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f71724e == null) {
                SQLiteStatement compileStatement = this.f71720a.compileStatement(g.a("INSERT INTO ", this.f71721b, this.f71722c));
                synchronized (this) {
                    if (this.f71724e == null) {
                        this.f71724e = compileStatement;
                    }
                }
                if (this.f71724e != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f71724e;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f71726g == null) {
                SQLiteStatement compileStatement = this.f71720a.compileStatement(g.b(this.f71721b, this.f71723d));
                synchronized (this) {
                    if (this.f71726g == null) {
                        this.f71726g = compileStatement;
                    }
                }
                if (this.f71726g != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f71726g;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f71725f == null) {
                SQLiteStatement compileStatement = this.f71720a.compileStatement(g.c(this.f71721b, this.f71722c, this.f71723d));
                synchronized (this) {
                    if (this.f71725f == null) {
                        this.f71725f = compileStatement;
                    }
                }
                if (this.f71725f != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f71725f;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f71727h == null) {
                SQLiteStatement compileStatement = this.f71720a.compileStatement(g.i(this.f71721b, this.f71722c, this.f71723d));
                synchronized (this) {
                    if (this.f71727h == null) {
                        this.f71727h = compileStatement;
                    }
                }
                if (this.f71727h != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f71727h;
        }
        return (SQLiteStatement) invokeV.objValue;
    }
}
