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
/* loaded from: classes6.dex */
public class dg implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ df f39976a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f235a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Throwable f236a;

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
        this.f39976a = dfVar;
        this.f235a = str;
        this.f236a = th;
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
            list = df.f232a;
            simpleDateFormat = df.f231a;
            str = this.f39976a.f39974b;
            list.add(new Pair(String.format("%1$s %2$s %3$s ", simpleDateFormat.format(new Date()), str, this.f235a), this.f236a));
            list2 = df.f232a;
            if (list2.size() > 20000) {
                list3 = df.f232a;
                int size = (list3.size() - 20000) + 50;
                for (int i2 = 0; i2 < size; i2++) {
                    try {
                        list5 = df.f232a;
                        if (list5.size() > 0) {
                            list6 = df.f232a;
                            list6.remove(0);
                        }
                    } catch (IndexOutOfBoundsException unused) {
                    }
                }
                list4 = df.f232a;
                simpleDateFormat2 = df.f231a;
                str4 = this.f39976a.f39974b;
                list4.add(new Pair(String.format("%1$s %2$s %3$s ", simpleDateFormat2.format(new Date()), str4, "flush " + size + " lines logs."), null));
            }
            try {
                if (aa.d()) {
                    this.f39976a.m244a();
                    return;
                }
                str3 = this.f39976a.f39974b;
                Log.w(str3, "SDCard is unavailable.");
            } catch (Exception e2) {
                str2 = this.f39976a.f39974b;
                Log.e(str2, "", e2);
            }
        }
    }
}
