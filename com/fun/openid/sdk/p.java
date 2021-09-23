package com.fun.openid.sdk;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class p extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(Looper looper) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {looper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0080  */
    @Override // android.os.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleMessage(Message message) {
        String str;
        Uri parse;
        Cursor query;
        StringBuilder sb;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, message) != null) || message.what != 11) {
            return;
        }
        int i2 = message.getData().getInt("type");
        String string = message.getData().getString("appid");
        o oVar = q.f70370j;
        oVar.getClass();
        if (i2 != 0) {
            if (i2 == 1) {
                sb = new StringBuilder();
                str2 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_";
            } else if (i2 == 2) {
                sb = new StringBuilder();
                str2 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_";
            } else if (i2 != 4) {
                parse = null;
                query = oVar.f70360a.getContentResolver().query(parse, null, null, null, null);
                if (query != null) {
                    r2 = query.moveToNext() ? query.getString(query.getColumnIndex("value")) : null;
                    query.close();
                }
                q.f70367g = r2;
                Context context = q.f70361a;
                synchronized (q.f70364d) {
                    q.f70364d.notify();
                }
                return;
            } else {
                str = "content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS";
            }
            sb.append(str2);
            sb.append(string);
            str = sb.toString();
        } else {
            str = "content://com.vivo.vms.IdProvider/IdentifierId/OAID";
        }
        parse = Uri.parse(str);
        query = oVar.f70360a.getContentResolver().query(parse, null, null, null, null);
        if (query != null) {
        }
        q.f70367g = r2;
        Context context2 = q.f70361a;
        synchronized (q.f70364d) {
        }
    }
}
