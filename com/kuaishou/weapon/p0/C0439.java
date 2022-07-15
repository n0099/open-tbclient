package com.kuaishou.weapon.p0;

import android.os.Process;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
/* renamed from: com.kuaishou.weapon.p0.ᵎ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0439 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public String[] f617;

    public C0439() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f617 = new String[]{"/sbin/.magisk/", "/sbin/.core/mirror", "/sbin/.core/img", "/sbin/.core/db-0/magisk.db"};
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public int m937() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
            return invokeV.intValue;
        }
        File file = new File(String.format("/proc/%d/mounts", Integer.valueOf(Process.myPid())));
        try {
            HashSet hashSet = new HashSet();
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    fileInputStream.close();
                    return hashSet.size();
                }
                String[] strArr = this.f617;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (readLine.contains(strArr[i])) {
                        hashSet.add(readLine);
                        break;
                    } else {
                        i++;
                    }
                }
            }
        } catch (Exception unused) {
            return 0;
        }
    }
}
