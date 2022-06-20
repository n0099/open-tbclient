package com.xiaomi.push;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.cj;
/* loaded from: classes8.dex */
public class cl implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ cj.a f169a;

    public cl(cj.a aVar, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f169a = aVar;
        this.a = context;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, IGET, INVOKE] complete} */
    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    sQLiteDatabase = this.f169a.a();
                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                        sQLiteDatabase.beginTransaction();
                        this.f169a.a(this.a, sQLiteDatabase);
                        sQLiteDatabase.setTransactionSuccessful();
                    }
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Exception e) {
                            e = e;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                            this.f169a.a(this.a);
                        }
                    }
                    if (this.f169a.f160a != null) {
                        this.f169a.f160a.close();
                    }
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Exception e3) {
                            e = e3;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                            this.f169a.a(this.a);
                        }
                    }
                    if (this.f169a.f160a != null) {
                        this.f169a.f160a.close();
                    }
                }
                this.f169a.a(this.a);
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e4) {
                        com.xiaomi.channel.commonutils.logger.b.a(e4);
                        this.f169a.a(this.a);
                        throw th;
                    }
                }
                if (this.f169a.f160a != null) {
                    this.f169a.f160a.close();
                }
                this.f169a.a(this.a);
                throw th;
            }
        }
    }
}
