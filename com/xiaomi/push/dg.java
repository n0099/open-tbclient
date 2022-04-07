package com.xiaomi.push;

import android.util.Log;
import android.util.Pair;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/* loaded from: classes8.dex */
public class dg implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ df a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f216a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Throwable f217a;

    public dg(df dfVar, String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dfVar, str, th};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = dfVar;
        this.f216a = str;
        this.f217a = th;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        SimpleDateFormat simpleDateFormat;
        String str;
        List list2;
        String str2;
        String str3;
        List list3;
        List list4;
        SimpleDateFormat simpleDateFormat2;
        String str4;
        List list5;
        List list6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            list = df.f213a;
            simpleDateFormat = df.f212a;
            str = this.a.b;
            list.add(new Pair(String.format("%1$s %2$s %3$s ", simpleDateFormat.format(new Date()), str, this.f216a), this.f217a));
            list2 = df.f213a;
            if (list2.size() > 20000) {
                list3 = df.f213a;
                int size = (list3.size() - 20000) + 50;
                for (int i = 0; i < size; i++) {
                    try {
                        list5 = df.f213a;
                        if (list5.size() > 0) {
                            list6 = df.f213a;
                            list6.remove(0);
                        }
                    } catch (IndexOutOfBoundsException unused) {
                    }
                }
                list4 = df.f213a;
                simpleDateFormat2 = df.f212a;
                str4 = this.a.b;
                list4.add(new Pair(String.format("%1$s %2$s %3$s ", simpleDateFormat2.format(new Date()), str4, "flush " + size + " lines logs."), null));
            }
            try {
                if (aa.d()) {
                    this.a.m282a();
                    return;
                }
                str3 = this.a.b;
                Log.w(str3, "SDCard is unavailable.");
            } catch (Exception e) {
                str2 = this.a.b;
                Log.e(str2, "", e);
            }
        }
    }
}
