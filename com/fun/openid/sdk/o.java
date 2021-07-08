package com.fun.openid.sdk;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class o extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(Looper looper) {
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
    /* JADX WARN: Removed duplicated region for block: B:27:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0088  */
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
        if (interceptable != null && interceptable.invokeL(1048576, this, message) != null) {
            return;
        }
        if (message.what != 11) {
            Log.e("VMS_IDLG_SDK_Client", "message type valid");
            return;
        }
        int i2 = message.getData().getInt("type");
        String string = message.getData().getString("appid");
        n nVar = p.j;
        nVar.getClass();
        if (i2 != 0) {
            if (i2 == 1) {
                sb = new StringBuilder();
                str2 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_";
            } else if (i2 == 2) {
                sb = new StringBuilder();
                str2 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_";
            } else if (i2 != 4) {
                parse = null;
                query = nVar.f32783a.getContentResolver().query(parse, null, null, null, null);
                if (query == null) {
                    r2 = query.moveToNext() ? query.getString(query.getColumnIndex("value")) : null;
                    query.close();
                } else {
                    Log.d("VMS_IDLG_SDK_DB", "return cursor is null,return");
                }
                p.f32790g = r2;
                Context context = p.f32784a;
                synchronized (p.f32787d) {
                    p.f32787d.notify();
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
        query = nVar.f32783a.getContentResolver().query(parse, null, null, null, null);
        if (query == null) {
        }
        p.f32790g = r2;
        Context context2 = p.f32784a;
        synchronized (p.f32787d) {
        }
    }
}
