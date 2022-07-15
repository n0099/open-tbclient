package com.repackage;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ec5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;
    public a b;
    public b c;

    /* loaded from: classes6.dex */
    public static class a extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public boolean b;
        public int c;
        public String d;
        public String e;
        public boolean f;
        public int g;
        public View.OnClickListener h;

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
                    return;
                }
            }
            this.b = true;
            this.c = R.drawable.new_pic_emotion_05;
            this.d = ec5.c(R.string.obfuscated_res_0x7f0f0c44, new Object[0]);
            this.e = ec5.c(R.string.obfuscated_res_0x7f0f0f9a, new Object[0]);
            this.f = false;
            this.g = pi.f(ec5.getContext(), R.dimen.obfuscated_res_0x7f0702c1);
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public boolean b;
        public int c;
        public int d;
        public String e;
        public String f;
        public String g;
        public View.OnClickListener h;

        public b() {
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
            this.b = true;
            this.c = R.drawable.new_pic_emotion_08;
            this.d = pi.f(ec5.getContext(), R.dimen.obfuscated_res_0x7f070294);
            this.e = ec5.c(R.string.obfuscated_res_0x7f0f0f9a, new Object[0]);
            this.f = ec5.c(R.string.obfuscated_res_0x7f0f0f9b, new Object[0]);
            this.g = ec5.c(R.string.obfuscated_res_0x7f0f047b, new Object[0]);
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public String c;
        public String d;
        public String e;
        public String f;
        public boolean g;
        public View.OnClickListener h;

        public c() {
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
            this.a = pi.f(ec5.getContext(), R.dimen.tbds182);
            this.b = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            this.c = ec5.c(R.string.obfuscated_res_0x7f0f0a2c, new Object[0]);
            this.d = ec5.c(R.string.obfuscated_res_0x7f0f0dc1, new Object[0]);
            this.e = ec5.c(R.string.obfuscated_res_0x7f0f09e7, new Object[0]);
            this.f = ec5.c(R.string.obfuscated_res_0x7f0f03e3, new Object[0]);
            this.g = false;
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;

        public d() {
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
            this.a = ec5.c(R.string.obfuscated_res_0x7f0f0a32, new Object[0]);
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
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
    }

    public ec5() {
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

    public static String c(int i, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i, objArr)) == null) ? getContext().getString(i, objArr) : (String) invokeIL.objValue;
    }

    public static Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? TbadkCoreApplication.getInst().getApplicationContext() : (Context) invokeV.objValue;
    }
}
