package com.repackage;

import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class li8 {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern f;
    public static final Pattern g;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public String c;
    public String d;
    public SpannableStringBuilder e;

    /* loaded from: classes6.dex */
    public class a extends md5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ li8 a;

        public a(li8 li8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = li8Var;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                b(this.a.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends md5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ li8 a;

        public b(li8 li8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = li8Var;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Matcher matcher = li8.f.matcher(this.a.d);
                if (matcher.find()) {
                    try {
                        String group = matcher.group();
                        a(group.substring(group.lastIndexOf("/") + 1));
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                Matcher matcher2 = li8.g.matcher(this.a.d);
                if (matcher2.find()) {
                    try {
                        String group2 = matcher2.group();
                        a(group2.substring(group2.lastIndexOf("=") + 1));
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                b(this.a.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends md5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ li8 a;

        public c(li8 li8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = li8Var;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.b != null) {
                    this.a.b.replace("@", "").replace(" ", "");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(TbadkCoreApplication.getInst()).createNormalConfig(ng.g(this.a.d, 0L), false, false)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755528010, "Lcom/repackage/li8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755528010, "Lcom/repackage/li8;");
                return;
            }
        }
        f = Pattern.compile("(tieba.baidu.com/p/){1}\\d+");
        g = Pattern.compile("(tieba.baidu.com/f\\?kz=){1}\\d+");
    }

    public li8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = null;
        this.d = null;
        this.e = null;
    }

    public static boolean k(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65542, null, i, i2)) == null) ? (i != 0 || i2 == 3 || i2 == 2) ? false : true : invokeII.booleanValue;
    }

    public SpannableStringBuilder e(SpannableString spannableString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, spannableString)) == null) {
            if (this.e == null) {
                this.e = new SpannableStringBuilder();
            }
            this.e.append((CharSequence) spannableString);
            return this.e;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (String) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : invokeV.intValue;
    }

    public SpannableString h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i = this.a;
            if (i != 0) {
                if (i == 1) {
                    if (!this.b.endsWith(" ")) {
                        this.b += " ";
                    }
                    SpannableString spannableString = new SpannableString(this.b);
                    spannableString.setSpan(new b(this), 0, this.b.length() - 1, 33);
                    return spannableString;
                } else if (i == 2) {
                    SpannableString spannableString2 = new SpannableString(this.b + " ");
                    ym face = TbadkCoreApplication.getInst().getFace(this.b);
                    if (face != null) {
                        BitmapDrawable j = face.j();
                        j.setBounds(0, 0, face.r(), face.m());
                        spannableString2.setSpan(new ImageSpan(j, 1), 0, this.b.length(), 33);
                    }
                    return spannableString2;
                } else if (i == 4) {
                    if (!this.b.endsWith(" ")) {
                        this.b += " ";
                    }
                    SpannableString spannableString3 = new SpannableString(this.b);
                    spannableString3.setSpan(new c(this), 0, this.b.length() - 1, 33);
                    return spannableString3;
                } else if (i != 5) {
                    return null;
                } else {
                    if (!this.b.endsWith(" ")) {
                        this.b += " ";
                    }
                    String string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1507);
                    String str = string + this.b;
                    SpannableString spannableString4 = new SpannableString(str);
                    spannableString4.setSpan(new a(this), string.length(), str.length() - 1, 33);
                    return spannableString4;
                }
            }
            return new SpannableString(this.b);
        }
        return (SpannableString) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public SpannableStringBuilder j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : (SpannableStringBuilder) invokeV.objValue;
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.a = i;
        }
    }
}
