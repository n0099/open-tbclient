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
/* loaded from: classes7.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            if (message.what == 11) {
                int i = message.getData().getInt("type");
                String string = message.getData().getString("appid");
                o oVar = q.j;
                oVar.getClass();
                String str3 = null;
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 4) {
                                parse = null;
                                query = oVar.a.getContentResolver().query(parse, null, null, null, null);
                                if (query == null) {
                                    if (query.moveToNext()) {
                                        str3 = query.getString(query.getColumnIndex("value"));
                                    }
                                    query.close();
                                } else {
                                    Log.d("VMS_IDLG_SDK_DB", "return cursor is null,return");
                                }
                                q.g = str3;
                                Context context = q.a;
                                synchronized (q.d) {
                                    q.d.notify();
                                }
                                return;
                            }
                            str = "content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS";
                        } else {
                            sb = new StringBuilder();
                            str2 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_";
                        }
                    } else {
                        sb = new StringBuilder();
                        str2 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_";
                    }
                    sb.append(str2);
                    sb.append(string);
                    str = sb.toString();
                } else {
                    str = "content://com.vivo.vms.IdProvider/IdentifierId/OAID";
                }
                parse = Uri.parse(str);
                query = oVar.a.getContentResolver().query(parse, null, null, null, null);
                if (query == null) {
                }
                q.g = str3;
                Context context2 = q.a;
                synchronized (q.d) {
                }
            } else {
                Log.e("VMS_IDLG_SDK_Client", "message type valid");
            }
        }
    }
}
