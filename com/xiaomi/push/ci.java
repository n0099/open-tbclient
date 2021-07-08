package com.xiaomi.push;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.cg;
/* loaded from: classes6.dex */
public class ci implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f39933a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ cg.a f187a;

    public ci(cg.a aVar, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f187a = aVar;
        this.f39933a = context;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, IGET, INVOKE] complete} */
    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    sQLiteDatabase = this.f187a.a();
                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                        sQLiteDatabase.beginTransaction();
                        this.f187a.a(this.f39933a, sQLiteDatabase);
                        sQLiteDatabase.setTransactionSuccessful();
                    }
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Exception e2) {
                            e = e2;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                            this.f187a.a(this.f39933a);
                        }
                    }
                    if (this.f187a.f178a != null) {
                        this.f187a.f178a.close();
                    }
                } catch (Exception e3) {
                    com.xiaomi.channel.commonutils.logger.b.a(e3);
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Exception e4) {
                            e = e4;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                            this.f187a.a(this.f39933a);
                        }
                    }
                    if (this.f187a.f178a != null) {
                        this.f187a.f178a.close();
                    }
                }
                this.f187a.a(this.f39933a);
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e5) {
                        com.xiaomi.channel.commonutils.logger.b.a(e5);
                        this.f187a.a(this.f39933a);
                        throw th;
                    }
                }
                if (this.f187a.f178a != null) {
                    this.f187a.f178a.close();
                }
                this.f187a.a(this.f39933a);
                throw th;
            }
        }
    }
}
