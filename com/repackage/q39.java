package com.repackage;

import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class q39 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends j39 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.j39
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (m39.a(com.baidu.ubs.analytics.d.a.b)) {
                    for (File file : q39.a(com.baidu.ubs.analytics.d.a.b)) {
                        if (t29.c(t29.a(file, "http://absample.baidu.com/appabapp/appapi/sdkerrorlog"), null)) {
                            m39.b(file.getPath());
                        }
                    }
                }
                if (m39.a(com.baidu.ubs.analytics.d.a.c)) {
                    for (File file2 : q39.a(com.baidu.ubs.analytics.d.a.c)) {
                        if (!file2.getName().equals(h39.e()) && t29.c(t29.a(file2, "http://absample.baidu.com/appabapp/appapi/sdklog"), null)) {
                            m39.b(file2.getPath());
                        }
                    }
                }
            }
        }
    }

    public static /* synthetic */ List a(String str) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                String name = listFiles[i].getName();
                if (name.endsWith("txt") || name.endsWith(TbConfig.TMP_LOG_DIR_NAME)) {
                    arrayList.add(listFiles[i]);
                }
            }
        }
        return arrayList;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            i39.a(new a());
        }
    }
}
