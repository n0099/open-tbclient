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
/* loaded from: classes10.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final SQLiteDatabase f74668a;

    /* renamed from: b  reason: collision with root package name */
    public final String f74669b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f74670c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f74671d;

    /* renamed from: e  reason: collision with root package name */
    public SQLiteStatement f74672e;

    /* renamed from: f  reason: collision with root package name */
    public SQLiteStatement f74673f;

    /* renamed from: g  reason: collision with root package name */
    public SQLiteStatement f74674g;

    /* renamed from: h  reason: collision with root package name */
    public SQLiteStatement f74675h;

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
        this.f74668a = sQLiteDatabase;
        this.f74669b = str;
        this.f74670c = strArr;
        this.f74671d = strArr2;
    }

    public SQLiteStatement a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f74672e == null) {
                SQLiteStatement compileStatement = this.f74668a.compileStatement(g.a("INSERT INTO ", this.f74669b, this.f74670c));
                synchronized (this) {
                    if (this.f74672e == null) {
                        this.f74672e = compileStatement;
                    }
                }
                if (this.f74672e != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f74672e;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f74674g == null) {
                SQLiteStatement compileStatement = this.f74668a.compileStatement(g.b(this.f74669b, this.f74671d));
                synchronized (this) {
                    if (this.f74674g == null) {
                        this.f74674g = compileStatement;
                    }
                }
                if (this.f74674g != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f74674g;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f74673f == null) {
                SQLiteStatement compileStatement = this.f74668a.compileStatement(g.c(this.f74669b, this.f74670c, this.f74671d));
                synchronized (this) {
                    if (this.f74673f == null) {
                        this.f74673f = compileStatement;
                    }
                }
                if (this.f74673f != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f74673f;
        }
        return (SQLiteStatement) invokeV.objValue;
    }

    public SQLiteStatement d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f74675h == null) {
                SQLiteStatement compileStatement = this.f74668a.compileStatement(g.i(this.f74669b, this.f74670c, this.f74671d));
                synchronized (this) {
                    if (this.f74675h == null) {
                        this.f74675h = compileStatement;
                    }
                }
                if (this.f74675h != compileStatement) {
                    compileStatement.close();
                }
            }
            return this.f74675h;
        }
        return (SQLiteStatement) invokeV.objValue;
    }
}
