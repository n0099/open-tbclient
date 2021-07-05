package d.a.s0.h3.h0;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.bytedance.sdk.component.net.tnc.TNCManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final Pattern f61232f;

    /* renamed from: g  reason: collision with root package name */
    public static final Pattern f61233g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f61234a;

    /* renamed from: b  reason: collision with root package name */
    public String f61235b;

    /* renamed from: c  reason: collision with root package name */
    public String f61236c;

    /* renamed from: d  reason: collision with root package name */
    public String f61237d;

    /* renamed from: e  reason: collision with root package name */
    public SpannableStringBuilder f61238e;

    /* loaded from: classes9.dex */
    public class a extends d.a.r0.z0.r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l f61239f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l lVar, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61239f = lVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c(this.f61239f.f61235b);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends d.a.r0.z0.r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l f61240f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(l lVar, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61240f = lVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Matcher matcher = l.f61232f.matcher(this.f61240f.f61237d);
                if (matcher.find()) {
                    try {
                        String group = matcher.group();
                        b(group.substring(group.lastIndexOf("/") + 1));
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                Matcher matcher2 = l.f61233g.matcher(this.f61240f.f61237d);
                if (matcher2.find()) {
                    try {
                        String group2 = matcher2.group();
                        b(group2.substring(group2.lastIndexOf("=") + 1));
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                c(this.f61240f.f61237d);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends d.a.r0.z0.r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l f61241f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(l lVar, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61241f = lVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f61241f.f61235b != null) {
                    this.f61241f.f61235b.replace(TNCManager.TNC_PROBE_HEADER_SECEPTOR, "").replace(" ", "");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a()).createNormalConfig(d.a.c.e.m.b.f(this.f61241f.f61237d, 0L), false, false)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1315701887, "Ld/a/s0/h3/h0/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1315701887, "Ld/a/s0/h3/h0/l;");
                return;
            }
        }
        f61232f = Pattern.compile("(tieba.baidu.com/p/){1}\\d+");
        f61233g = Pattern.compile("(tieba.baidu.com/f\\?kz=){1}\\d+");
    }

    public l() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f61234a = 0;
        this.f61235b = null;
        this.f61237d = null;
        this.f61238e = null;
    }

    public static boolean l(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(AdIconUtil.BAIDU_LOGO_ID, null, i2, i3)) == null) ? (i2 != 0 || i3 == 3 || i3 == 2) ? false : true : invokeII.booleanValue;
    }

    public SpannableStringBuilder e(SpannableString spannableString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, spannableString)) == null) {
            if (this.f61238e == null) {
                this.f61238e = new SpannableStringBuilder();
            }
            this.f61238e.append((CharSequence) spannableString);
            return this.f61238e;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f61236c : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f61237d : (String) invokeV.objValue;
    }

    public SpannableString h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            int i2 = this.f61234a;
            if (i2 != 0) {
                if (i2 == 1) {
                    if (!this.f61235b.endsWith(" ")) {
                        this.f61235b += " ";
                    }
                    SpannableString spannableString = new SpannableString(this.f61235b);
                    spannableString.setSpan(new b(this, context), 0, this.f61235b.length() - 1, 33);
                    return spannableString;
                } else if (i2 == 2) {
                    SpannableString spannableString2 = new SpannableString(this.f61235b + " ");
                    d.a.c.k.d.a face = TbadkCoreApplication.getInst().getFace(this.f61235b);
                    if (face != null) {
                        BitmapDrawable j = face.j();
                        j.setBounds(0, 0, face.r(), face.m());
                        spannableString2.setSpan(new ImageSpan(j, 1), 0, this.f61235b.length(), 33);
                    }
                    return spannableString2;
                } else if (i2 == 4) {
                    if (!this.f61235b.endsWith(" ")) {
                        this.f61235b += " ";
                    }
                    SpannableString spannableString3 = new SpannableString(this.f61235b);
                    spannableString3.setSpan(new c(this, context), 0, this.f61235b.length() - 1, 33);
                    return spannableString3;
                } else if (i2 != 5) {
                    return null;
                } else {
                    if (!this.f61235b.endsWith(" ")) {
                        this.f61235b += " ";
                    }
                    String string = context.getString(R.string.video);
                    String str = string + this.f61235b;
                    SpannableString spannableString4 = new SpannableString(str);
                    spannableString4.setSpan(new a(this, context), string.length(), str.length() - 1, 33);
                    return spannableString4;
                }
            }
            return new SpannableString(this.f61235b);
        }
        return (SpannableString) invokeL.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f61235b : (String) invokeV.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f61234a : invokeV.intValue;
    }

    public SpannableStringBuilder k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f61238e : (SpannableStringBuilder) invokeV.objValue;
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f61234a = i2;
        }
    }
}
