package com.xiaomi.push;

import android.util.Pair;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/* loaded from: classes10.dex */
public class dg implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ df f77100a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f239a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Throwable f240a;

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
        this.f77100a = dfVar;
        this.f239a = str;
        this.f240a = th;
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
            list = df.f236a;
            simpleDateFormat = df.f235a;
            str = this.f77100a.f77098b;
            list.add(new Pair(String.format("%1$s %2$s %3$s ", simpleDateFormat.format(new Date()), str, this.f239a), this.f240a));
            list2 = df.f236a;
            if (list2.size() > 20000) {
                list3 = df.f236a;
                int size = (list3.size() - 20000) + 50;
                for (int i2 = 0; i2 < size; i2++) {
                    try {
                        list5 = df.f236a;
                        if (list5.size() > 0) {
                            list6 = df.f236a;
                            list6.remove(0);
                        }
                    } catch (IndexOutOfBoundsException unused3) {
                    }
                }
                list4 = df.f236a;
                simpleDateFormat2 = df.f235a;
                str2 = this.f77100a.f77098b;
                list4.add(new Pair(String.format("%1$s %2$s %3$s ", simpleDateFormat2.format(new Date()), str2, "flush " + size + " lines logs."), null));
            }
            try {
                if (aa.d()) {
                    this.f77100a.m247a();
                } else {
                    unused = this.f77100a.f77098b;
                }
            } catch (Exception unused4) {
                unused2 = this.f77100a.f77098b;
            }
        }
    }
}
