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
    public final SQLiteDatabase f72174a;

    /* renamed from: b  reason: collision with root package name */
    public final String f72175b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f72176c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f72177d;

    /* renamed from: e  reason: collision with root package name */
    public SQLiteStatement f72178e;

    /* renamed from: f  reason: collision with root package name */
    public SQLiteStatement f72179f;

    /* renamed from: g  reason: collision with root package name */
    public SQLiteStatement f72180g;

    /* renamed from: h  reason: collision with root package name */
    public SQLiteStatement f72181h;

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
        this.f72174a = sQLiteDatabase;
        this.f72175b = str;
        this.f72176c = strArr;
        this.f72177d = strArr2;
    }

    public SQLiteStatement a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f72178e == null) {
                SQLiteStatement compileStatement = this.f72174a.compileStatement(g.a("INSERT INTO ", this.f72175b, this.f72176c));
                synchronized (this) {
                    if (this.f72178e == null) {
                        this.f72178e = compileStatement;
                    }
                }
                if (this.f72178e != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f72178e;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f72180g == null) {
                SQLiteStatement compileStatement = this.f72174a.compileStatement(g.b(this.f72175b, this.f72177d));
                synchronized (this) {
                    if (this.f72180g == null) {
                        this.f72180g = compileStatement;
                    }
                }
                if (this.f72180g != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f72180g;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f72179f == null) {
                SQLiteStatement compileStatement = this.f72174a.compileStatement(g.c(this.f72175b, this.f72176c, this.f72177d));
                synchronized (this) {
                    if (this.f72179f == null) {
                        this.f72179f = compileStatement;
                    }
                }
                if (this.f72179f != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f72179f;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f72181h == null) {
                SQLiteStatement compileStatement = this.f72174a.compileStatement(g.i(this.f72175b, this.f72176c, this.f72177d));
                synchronized (this) {
                    if (this.f72181h == null) {
                        this.f72181h = compileStatement;
                    }
                }
                if (this.f72181h != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f72181h;
        }
        return (SQLiteStatement) invokeV.objValue;
    }
}
