package com.xiaomi.push;

import android.util.Pair;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/* loaded from: classes4.dex */
public class dg implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ df a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f240a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Throwable f241a;

    public dg(df dfVar, String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dfVar, str, th};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = dfVar;
        this.f240a = str;
        this.f241a = th;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        SimpleDateFormat simpleDateFormat;
        String str;
        List list2;
        List list3;
        List list4;
        SimpleDateFormat simpleDateFormat2;
        String str2;
        List list5;
        List list6;
        String unused;
        String unused2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            list = df.f237a;
            simpleDateFormat = df.f236a;
            str = this.a.f63360b;
            list.add(new Pair(String.format("%1$s %2$s %3$s ", simpleDateFormat.format(new Date()), str, this.f240a), this.f241a));
            list2 = df.f237a;
            if (list2.size() > 20000) {
                list3 = df.f237a;
                int size = (list3.size() - 20000) + 50;
                for (int i2 = 0; i2 < size; i2++) {
                    try {
                        list5 = df.f237a;
                        if (list5.size() > 0) {
                            list6 = df.f237a;
                            list6.remove(0);
                        }
                    } catch (IndexOutOfBoundsException unused3) {
                    }
                }
                list4 = df.f237a;
                simpleDateFormat2 = df.f236a;
                str2 = this.a.f63360b;
                list4.add(new Pair(String.format("%1$s %2$s %3$s ", simpleDateFormat2.format(new Date()), str2, "flush " + size + " lines logs."), null));
            }
            try {
                if (aa.d()) {
                    this.a.m296a();
                } else {
                    unused = this.a.f63360b;
                }
            } catch (Exception unused4) {
                unused2 = this.a.f63360b;
            }
        }
    }
}
